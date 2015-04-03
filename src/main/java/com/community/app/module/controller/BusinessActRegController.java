package com.community.app.module.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.BusinessActReg;
import com.community.app.module.bean.BusinessActivity;
import com.community.app.module.bean.BusinessRegPic;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.BusinessActRegService;
import com.community.app.module.service.BusinessActivityService;
import com.community.app.module.service.BusinessRegPicService;
import com.community.app.module.service.BusinessVoteService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActRegQuery;
import com.community.framework.utils.JsonUtils;

@Controller
@RequestMapping("/business/businessActReg")
public class BusinessActRegController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessActRegController.class);
	@Autowired
	private BusinessActRegService businessActRegService;
	@Autowired
	private BusinessRegPicService businessRegPicService;
	@Autowired
	private BusinessVoteService businessVoteService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	@Autowired
	private BusinessActivityService businessActivityService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActReg管理页时发生错误：/business/businessActReg/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActReg/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessActRegQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			if(query.getFlag() == 2) {
				if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
					query.setSort(query.getOrderBy());
					if(query.getOrderBy().equals("regTime")) {
						query.setOrder("desc");
					} else {
						query.setOrder("asc");
					}
				}else{
					query.setSort("regTime");
					query.setOrder("desc");
				}
			} else if(query.getFlag() == 0) {
				if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
					query.setSort(query.getOrderBy());
					if(query.getOrderBy().equals("votes")) {
						query.setOrder("desc");
					} else {
						query.setOrder("asc");
					}
				}else{
					query.setSort("votes");
					query.setOrder("desc");
				}
			}
			query.setRows(20);
			BaseBean baseBean = businessActRegService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageSize\":").append(baseBean.getPager().getPageSize()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessActReg businessActReg = (BusinessActReg) baseBean.getList().get(i);
				result.append("{")
			    .append("\"regId\":\"").append(businessActReg.getRegId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessActReg.getUserId()).append("\"").append(",")
			    .append("\"nickName\":\"").append(businessActReg.getNickName()).append("\"").append(",")
			    .append("\"estateId\":\"").append(businessActReg.getEstateId()).append("\"").append(",")
			    .append("\"estateName\":\"").append(businessActReg.getEstateName()).append("\"").append(",")
			    .append("\"avatar\":\"").append(businessActReg.getAvatar()).append("\"").append(",")
			    .append("\"code\":\"").append(businessActReg.getCode()).append("\"").append(",")
			    .append("\"content\":\"").append(JsonUtils.stringToJson(businessActReg.getContent().replace("\"", "\\\"").replaceAll("(\r?\n()+)", ""))).append("\"").append(",")
			    .append("\"actId\":\"").append(businessActReg.getActId()).append("\"").append(",")
			    .append("\"votes\":\"").append(businessActReg.getVotes()).append("\"").append(",")
			    .append("\"regTime\":\"").append(businessActReg.getRegTime()).append("\"").append(",")
			    .append("\"count\":\"").append(businessActReg.getCount()).append("\"").append(",")
			    .append("\"picUrl\":\"").append(businessActReg.getPicUrl()==null?"":businessActReg.getPicUrl()).append("\"").append(",")
			    .append("\"flag\":\"").append(businessActReg.getFlag()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(baseBean.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示businessActReg列表时发生错误：/business/businessActReg/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 投票中详情页
	 * @return
	 */
	@RequestMapping(value="getRegById")
    public void getRegById(@RequestParam(value="regId") Integer regId, HttpServletResponse response) {
		BusinessActReg businessActReg = businessActRegService.findById(regId);
		StringBuffer sb = new StringBuffer();
		String picUrlArr = "";
		if(businessActReg != null) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("regId", businessActReg.getRegId());
			List<BusinessRegPic> regPicList = businessRegPicService.findByMap(paramMap);
			
			if(regPicList.size() > 0) {
				for(int i=0; i< regPicList.size(); i++) {
					BusinessRegPic regPicBean = regPicList.get(i);
					sb.append(",").append(regPicBean.getPicUrl());
				}
				picUrlArr = sb.toString().substring(1);
			}
		}
        StringBuilder result = new StringBuilder();
        result.append("{")
		    .append("\"regId\":\"").append(businessActReg.getRegId()).append("\"").append(",")
		    .append("\"userId\":\"").append(businessActReg.getUserId()).append("\"").append(",")
		    .append("\"votes\":\"").append(businessActReg.getVotes()).append("\"").append(",")
		    .append("\"estateName\":\"").append(businessActReg.getEstateName()).append("\"").append(",")
		    .append("\"avatar\":\"").append(businessActReg.getAvatar()).append("\"").append(",")
		    .append("\"nickName\":\"").append(businessActReg.getNickName()).append("\"").append(",")
		    .append("\"code\":\"").append(businessActReg.getCode()).append("\"").append(",")
		    .append("\"content\":\"").append(businessActReg.getContent()).append("\"").append(",")
		    .append("\"picUrlArr\":\"").append(picUrlArr).append("\"").append(",")
		    .append("\"actId\":\"").append(businessActReg.getActId()).append("\"")
            .append("}");
        	
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
            try {
                response.getWriter().write(result.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessActRegQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActReg新增页时发生错误：/business/businessActReg/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActReg/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessActReg
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessActRegQuery query) {
		BusinessActReg businessActReg = new BusinessActReg();
		String json = "";
		try{
		    businessActReg.setUserId(query.getUserId());
		    businessActReg.setNickName(query.getNickName());
		    businessActReg.setAvatar(query.getAvatar());
		    businessActReg.setCode(query.getCode());
		    businessActReg.setContent(query.getContent());
		    businessActReg.setActId(query.getActId());
		    businessActReg.setVotes(query.getVotes());
		    businessActReg.setRegTime(query.getRegTime());
		    businessActReg.setFlag(query.getFlag());
			businessActRegService.save(businessActReg);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessActReg信息时发生错误：/business/businessActReg/save", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入报名人编辑
	 * @return
	 */
	@RequestMapping(value="updateActReg")
	public ModelAndView updateActReg(BusinessActRegQuery query) {
		String imgJoin = "";	
		List<BusinessRegPic> regPicList = null;
		BusinessActReg businessActReg=new BusinessActReg();
		try{
			businessActReg = businessActRegService.findById(query.getRegId());
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("regId", query.getRegId());
			regPicList = businessRegPicService.findByMap(paramMap);
  			for(BusinessRegPic bean : regPicList) {
  				imgJoin += "#" + bean.getPicUrl();
  			}
		}catch(Exception e){
			GSLogger.error("进入businessActReg修改页时发生错误：/module/activity/updateActReg", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/activity/updateActReg");
		mav.addObject("businessActReg", businessActReg);
		mav.addObject("regPicList", regPicList);
		if(imgJoin.length() > 0) {
			mav.addObject("imgJoin", imgJoin);
		} else {
			mav.addObject("imgJoin", "");
		}
		return mav;
	}
	
	/**
	 * 报名人编辑保存
	 * @return
	 */
	@RequestMapping(value="saveActReg")
	public void saveActReg(HttpServletRequest request, HttpServletResponse response, BusinessActRegQuery query) {
		BusinessActReg businessActReg=new BusinessActReg();
		String json = "";
		try{
			businessActReg.setRegId(query.getRegId());
			businessActReg.setContent(query.getContent());
			// businessActReg.setRegTime(new Timestamp(System.currentTimeMillis()));
			businessActRegService.update(businessActReg);
			
			if(query.getPicUrl() != null) {
				businessRegPicService.delete(query.getRegId());
				String[] picUrl = query.getPicUrl().substring(1).split("#");
				for(int i=0; i<picUrl.length; i++) {
					BusinessRegPic businessRegPic = new BusinessRegPic();
					businessRegPic.setRegId(query.getRegId());
					businessRegPic.setPicUrl(picUrl[i]);
					businessRegPicService.save(businessRegPic);
				}
			}
			json = "{\"success\":\"true\",\"message\":\"报名人编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"报名人编辑失败\"}";
			GSLogger.error("报名人编辑businessActReg信息时发生错误：/business/activity/updateActReg", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存开始投票
	 * @return
	 */
	@RequestMapping(value="saveStartVote")
	public void saveStartVote(HttpServletRequest request, HttpServletResponse response, BusinessActRegQuery query) {
		BusinessActReg businessActReg = businessActRegService.findById(query.getRegIdAvatar());
		String json = "";
		try{
			if(query.getAction().equals("savevote")) {
				businessActReg.setRegId(query.getRegIdAvatar());
				businessActReg.setContent(query.getContentAvatar());
				//businessActReg.setRegTime(new Timestamp(System.currentTimeMillis()));
				businessActReg.setAvatar(query.getAvatar());
				businessActReg.setFlag(0);
				
				businessActRegService.update(businessActReg);
				if(query.getPicUrlAvatar() != null) {
					businessRegPicService.delete(businessActReg.getRegId());
					
					String[] picUrl = query.getPicUrlAvatar().substring(1).split("#");
					for(int i=0; i<picUrl.length; i++) {
						BusinessRegPic businessRegPic = new BusinessRegPic();
						businessRegPic.setRegId(query.getRegIdAvatar());
						businessRegPic.setPicUrl(picUrl[i]);
						businessRegPicService.save(businessRegPic);
					}
				}
			} else if(query.getAction().equals("vote")) {
				businessActReg.setRegId(query.getRegIdAvatar());
				businessActReg.setAvatar(query.getAvatar());
				businessActReg.setFlag(0);
				//businessActReg.setRegTime(new Timestamp(System.currentTimeMillis()));
				businessActRegService.update(businessActReg);
			}
			
			/*BusinessVote businessVote = new BusinessVote();
			businessVote.setActId(businessActReg.getActId());
			businessVote.setVateTime(new Timestamp(System.currentTimeMillis()));
			businessVote.setUserId(businessActReg.getUserId());
			businessVote.setRegId(businessActReg.getRegId());
			businessVoteService.save(businessVote);*/
			
			BusinessActivity businessActivity = businessActivityService.findById(businessActReg.getActId());
			if(businessActivity != null) {
				AppUserNews appUserNews = new AppUserNews();
				appUserNews.setUserId(businessActReg.getUserId());
				appUserNews.setCreateTime(new Timestamp(System.currentTimeMillis()));
				appUserNews.setNewTitle("活动通知");
				appUserNews.setType(6);
				appUserNews.setId(businessActReg.getActId());
				appUserNews.setContent("您的报名信息审核通过，您的编号："+businessActReg.getCode()+"，可以进行拉票了！");
				appUserNewsService.saveReply(appUserNews);
				
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(businessActReg.getUserId());
				appLatestNews.setTypeId(7);
				appLatestNews.setSourceId(businessActReg.getActId());
				appLatestNews.setTo(0);
				appLatestNews.setEstateId(0);
				appLatestNewsService.save_app(appLatestNews);
				
				appLatestNews.setTypeId(8);
				appLatestNewsService.save_app(appLatestNews);
				
				appLatestNews.setTypeId(10);
				appLatestNewsService.save_app(appLatestNews);
			}
			json = "{\"success\":\"true\",\"message\":\"开始投票成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"开始投票失败\"}";
			GSLogger.error("报名人编辑businessActReg信息时发生错误：/business/activity/updateActReg", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入修改页
	 * @return
	 */
	@RequestMapping(value="modify")
	public ModelAndView modify(BusinessActRegQuery query) {	
		BusinessActReg businessActReg=new BusinessActReg();
		
		try{
			businessActReg = businessActRegService.findById(query.getRegId());
		}catch(Exception e){
			GSLogger.error("进入businessActReg修改页时发生错误：/business/businessActReg/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActReg/modify");
		mav.addObject("businessActReg", businessActReg);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessActRegQuery query) {
		BusinessActReg businessActReg = null;
		String json = "";
		try{
		    businessActReg = businessActRegService.findById(query.getRegId());
		    businessActReg.setUserId(query.getUserId());
		    businessActReg.setNickName(query.getNickName());
		    businessActReg.setAvatar(query.getAvatar());
		    businessActReg.setCode(query.getCode());
		    businessActReg.setContent(query.getContent());
		    businessActReg.setActId(query.getActId());
		    businessActReg.setVotes(query.getVotes());
		    businessActReg.setRegTime(query.getRegTime());
		    businessActReg.setFlag(query.getFlag());
			businessActRegService.update(businessActReg);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessActReg信息时发生错误：/business/businessActReg/update", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 删除单个或多个对象
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete")
	public void delete(@RequestParam(value="id") String id, HttpServletResponse response) {
		String json = "";
		try{
			if(id != null) {
				if(id.indexOf(',') > -1) {
					String[] ids = id.split(",");
					for(int i=0;i<ids.length;i++) {
						businessActRegService.delete(new Integer(ids[i]));
					}
				}else{
					businessActRegService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessActReg时发生错误：/business/businessActReg/delete", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}