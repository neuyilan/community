package com.community.app.module.controller;

import static com.community.framework.utils.CommonUtils.getUser;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.BusinessBreak;
import com.community.app.module.bean.BusinessBreakAudio;
import com.community.app.module.bean.BusinessBreakComment;
import com.community.app.module.bean.BusinessBreakPic;
import com.community.app.module.bean.BusinessBreakSelect;
import com.community.app.module.bean.BusinessCommunity;
import com.community.app.module.bean.BusinessNews;
import com.community.app.module.bean.BusinessNewsScope;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.common.ModuleConst;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.BusinessBreakAudioService;
import com.community.app.module.service.BusinessBreakCommentService;
import com.community.app.module.service.BusinessBreakPicService;
import com.community.app.module.service.BusinessBreakSelectService;
import com.community.app.module.service.BusinessBreakService;
import com.community.app.module.service.BusinessCommunityService;
import com.community.app.module.service.BusinessNewsScopeService;
import com.community.app.module.service.BusinessNewsService;
import com.community.app.module.vo.AppLatestNewsQuery;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessBreakQuery;
import com.community.framework.utils.CommonUtils;
import com.community.framework.utils.propertiesUtil;

@Controller
@RequestMapping("/business/businessBreak")
public class BusinessBreakController {
	
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessBreakController.class);
	@Autowired
	private BusinessBreakSelectService businessBreakSelectService;
	@Autowired
	private BusinessBreakService businessBreakService;
	@Autowired
	private BusinessNewsService businessNewsService;
	@Autowired
	private BusinessCommunityService businessCommunityService;
	@Autowired
	private BusinessBreakPicService businessBreakPicService;
	@Autowired
	private BusinessBreakAudioService businessBreakAudioService;
	@Autowired
	private BusinessBreakCommentService businessBreakCommentService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	@Autowired
	private BusinessNewsScopeService businessNewsScopeService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(BusinessBreakQuery query) {		
		BaseBean baseBean = new BaseBean();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { 
				query.setCurUserId(shiroUser.getUserId());
			}
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setCurComId(shiroUser.getCurComId());
			}
			query.setRows(12);
			query.setOrder("desc");
			query.setSort("editTime");
			baseBean = businessBreakService.findAllPage(query);
		}catch(Exception e){
			GSLogger.error("进入businessBreak管理页时发生错误：/business/businessBreak/list", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/break/list");
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		mav.addObject("state", query.getState());
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessBreakQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { 
				query.setCurUserId(shiroUser.getUserId());
			}
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setCurComId(shiroUser.getCurComId());
			}
			query.setRows(12);
			query.setOrder("desc");
			if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
				query.setSort(query.getOrderBy());
			}else{
				query.setSort("editTime");
			}
			BaseBean baseBean = businessBreakService.findAllPage(query);
			
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessBreak businessBreak = (BusinessBreak) baseBean.getList().get(i);
				result.append("{")
			    .append("\"breakId\":\"").append(businessBreak.getBreakId()).append("\"").append(",")
			    .append("\"breakerId\":\"").append(businessBreak.getBreakerId()).append("\"").append(",")
			    .append("\"breakerName\":\"").append(businessBreak.getBreakerName()).append("\"").append(",")
			    .append("\"breakContent\":\"").append(businessBreak.getBreakContent().replace("\"", "\\\"").replaceAll("(\r?\n()+)", "")).append("\"").append(",")
			    .append("\"breakTime\":\"").append(businessBreak.getBreakTime()).append("\"").append(",")
			    .append("\"breakType\":\"").append(businessBreak.getBreakType()).append("\"").append(",")
			    .append("\"comId\":\"").append(businessBreak.getComId()).append("\"").append(",")
			    .append("\"state\":\"").append(businessBreak.getState()).append("\"").append(",")
			    .append("\"isUsed\":\"").append(businessBreak.getIsUsed()).append("\"").append(",")
			    .append("\"selectedNum\":\"").append(businessBreak.getSelectedNum()).append("\"").append(",")
			    .append("\"comments\":\"").append(businessBreak.getComments()).append("\"").append(",")
			    .append("\"lastCommentTime\":\"").append(businessBreak.getLastCommentTime()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessBreak.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessBreak.getEditTime()).append("\"").append(",")
			    .append("\"address\":\"").append(businessBreak.getAddress()).append("\"").append(",")
			     .append("\"portrait\":\"").append(businessBreak.getPortrait()).append("\"").append(",")
			    .append("\"picCount\":\"").append(businessBreak.getPicCount()).append("\"").append(",")
			    .append("\"newsCount\":\"").append(businessBreak.getNewsCount()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessBreak.getEditor()).append("\"")
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示businessBreak列表时发生错误：/business/businessBreak/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入爆料详细信息页
	 * @return
	 */
	@RequestMapping(value="checkBreakDetail")
	public ModelAndView checkBreakDetail(HttpServletRequest request, BusinessBreakQuery query) {
		String isNew = request.getParameter("isNew");//是否有新消息
		BusinessBreak businessBreak = new BusinessBreak();
		List<BusinessBreakSelect> businessBreakSelectList = new ArrayList<BusinessBreakSelect>() ;
		List<BusinessBreakPic> businessBreakPicList = new ArrayList<BusinessBreakPic>() ;
		List<BusinessBreakAudio> businessBreakAudioList = new ArrayList<BusinessBreakAudio>() ;
		List<BusinessBreakComment> businessBreakCommentList = new ArrayList<BusinessBreakComment>() ;
		
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		try{
			businessBreak = businessBreakService.checkBreakDetail(query.getBreakId());
			businessBreakSelectList = businessBreakSelectService.findListByBreakId(query.getBreakId());
			businessBreakPicList = businessBreakPicService.findPicListByBreakId(query.getBreakId());
			businessBreakAudioList = businessBreakAudioService.findAudioListByBreakId(query.getBreakId());
			businessBreakCommentList = businessBreakCommentService.findCommentListByBreakId(query.getBreakId());
			
			//如果有新消息则删除消息
            if(isNew != null && new Integer(isNew) == 1) {
            	AppLatestNewsQuery newsQuery = new AppLatestNewsQuery();
            	newsQuery.setTypeId(40);//爆料
            	newsQuery.setSourceId(query.getBreakId());
            	newsQuery.setTo(1);//居民向后台发送
            	appLatestNewsService.deleteByCondition(newsQuery);
            }
		}catch(Exception e){
			GSLogger.error("进入businessBreak管理页时发生错误：/business/businessBreak/list", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/break/chekBreakInfo");
		mav.addObject("ip", ip);
		mav.addObject("businessBreak", businessBreak);
		mav.addObject("businessBreakSelectList", businessBreakSelectList);
		mav.addObject("businessBreakPicList", businessBreakPicList);
		mav.addObject("businessBreakAudioList", businessBreakAudioList);
		mav.addObject("businessBreakCommentList", businessBreakCommentList);
		return mav;
	}
	
	/**
	 * 爆料选用至新闻
	 * @param request
	 * @param businessBreak
	 * @return
	 */
	@RequestMapping(value="selectSave")
	public void selectSave(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id) {
		BusinessNews businessNews = new BusinessNews();
		String json = "";
		try{
			BusinessBreak businessBreak = businessBreakService.checkBreakDetail(Integer.parseInt(id));
			List<BusinessBreakPic> businessBreakPicList =  businessBreakPicService.findPicListByBreakId(Integer.parseInt(id));
			BusinessCommunity businessCommunity = businessCommunityService.findById(getUser().getOrgId());
			
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<businessBreakPicList.size(); i++) {
				sb.append("<img src=\""+ ip + (businessBreakPicList.get(i).getPicUrl())+"\" style=\"max-width:500px; height:auto;\"/><br>");
			}
			businessNews.setTitle("");
			businessNews.setBrief(businessBreak.getBreakContent());
			businessNews.setContent(businessBreak.getBreakContent() + "<br>" + sb.toString());
			businessNews.setPublishScope(businessCommunity.getComId());
		    businessNews.setComName(businessCommunity.getComName());  //社区名称
			businessNews.setCreateTime(businessBreak.getCreateTime());
			businessNews.setEditTime(new Timestamp(System.currentTimeMillis()));
			businessNews.setNewsType(1);  //0-官网，1-爆料
			businessNews.setPublisherId(businessBreak.getBreakerId());
			businessNews.setPublisherName(businessBreak.getBreakerName());
			businessNews.setPublishTime(businessBreak.getBreakTime());
			businessNews.setVisits(0);
			businessNews.setAppPic("");
			businessNews.setSubjectPic("");
			businessNews.setComments(0);
			businessNews.setSupports(0);
			businessNews.setIsAd(0);
			businessNews.setIsHot(0);
			businessNews.setIsPush(0);
			businessNews.setIsRecommend(null);
			businessNews.setState(1);  // 未发布
			businessNews.setBreakId(Integer.parseInt(id));
			businessNews.setIsNickname(businessBreak.getIsNickname());
			businessNewsService.save(businessNews);
			
			Timestamp  ts=new Timestamp(new Date().getTime());
			BusinessBreakSelect businessBreakSelect = new BusinessBreakSelect();
			businessBreakSelect.setBreakId(businessBreak.getBreakId());
		    businessBreakSelect.setSelectorId(getUser().getUserId());
		    businessBreakSelect.setSelectorName(getUser().getUserName());
		    businessBreakSelect.setSelectTime(ts);
		    businessBreakSelect.setComId(businessCommunity.getComId());
		    businessBreakSelect.setComName(businessCommunity.getComName());
		    businessBreakSelect.setIsSelected(1);
			businessBreakSelectService.save(businessBreakSelect);
			//保存新闻范围
			if(businessCommunity.getComId() != null && !"".equals(businessCommunity.getComId())) {
				BusinessNewsScope scope = new BusinessNewsScope();
				scope.setNewsId(businessNews.getNewsId());
				scope.setCreateTime(new Timestamp(System.currentTimeMillis()));
				scope.setComId(businessCommunity.getComId());
				scope.setComName(businessCommunity.getComName());
				businessNewsScopeService.save(scope);
			}
			BusinessNews bnBean = new BusinessNews();
			bnBean.setNewsId(businessNews.getNewsId());
			bnBean.setSelectId(businessBreakSelect.getSelectId());
			businessNewsService.update(bnBean);
			
			businessBreak.setSelectedNum(businessBreak.getSelectedNum()+1);
			businessBreakService.update(businessBreak);
			
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"选用成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"选用失败\"}";
			GSLogger.error("进入businessBreak管理页时发生错误：/business/businessBreak/list", e);
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
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessBreakQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessBreak新增页时发生错误：/business/businessBreak/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBreak/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessBreak
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessBreakQuery query) {
		BusinessBreak businessBreak = new BusinessBreak();
		String json = "";
		try{
		    businessBreak.setBreakerId(query.getBreakerId());
		    businessBreak.setBreakerName(query.getBreakerName());
		    businessBreak.setBreakContent(query.getBreakContent());
		    businessBreak.setBreakTime(query.getBreakTime());
		    businessBreak.setBreakType(query.getBreakType());
		    businessBreak.setState(query.getState());
		    businessBreak.setIsUsed(query.getIsUsed());
		    businessBreak.setSelectedNum(query.getSelectedNum());
		    businessBreak.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessBreak.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessBreak.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessBreak.setCreateTime(ts);
	        businessBreak.setEditTime(ts);
			businessBreakService.save(businessBreak);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessBreak信息时发生错误：/business/businessBreak/save", e);
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
	 * 进入修改页
	 * @return
	 */
	@RequestMapping(value="modify")
	public ModelAndView modify(BusinessBreakQuery query) {	
		BusinessBreak businessBreak=new BusinessBreak();
		
		try{
			businessBreak = businessBreakService.findById(query.getBreakId());
		}catch(Exception e){
			GSLogger.error("进入businessBreak修改页时发生错误：/business/businessBreak/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBreak/modify");
		mav.addObject("businessBreak", businessBreak);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessBreakQuery query) {
		BusinessBreak businessBreak = null;
		String json = "";
		try{
		    businessBreak = businessBreakService.findById(query.getBreakId());
		    businessBreak.setBreakerId(query.getBreakerId());
		    businessBreak.setBreakerName(query.getBreakerName());
		    businessBreak.setBreakContent(query.getBreakContent());
		    businessBreak.setBreakTime(query.getBreakTime());
		    businessBreak.setBreakType(query.getBreakType());
		   // businessBreak.setBreakScope(query.getBreakScope());
		    businessBreak.setState(query.getState());
		    businessBreak.setIsUsed(query.getIsUsed());
		    businessBreak.setSelectedNum(query.getSelectedNum());
		    businessBreak.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessBreak.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessBreak.setEditTime(ts);
			businessBreakService.update(businessBreak);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessBreak信息时发生错误：/business/businessBreak/update", e);
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
						businessBreakService.delete(new Integer(ids[i]));
					}
				}else{
					businessBreakService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessBreak时发生错误：/business/businessBreak/delete", e);
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