package com.community.app.module.controller;

import static com.community.framework.utils.CommonUtils.getUser;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

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
import com.community.app.module.bean.BusinessChinmedichenacare;
import com.community.app.module.bean.BusinessChinmedichenacareComment;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.BusinessChinmedichenacareCommentService;
import com.community.app.module.service.BusinessChinmedichenacareService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessChinmedichenacareCommentQuery;

@Controller
@RequestMapping("/business/businessChinmedichenacareComment")
public class BusinessChinmedichenacareCommentController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessChinmedichenacareCommentController.class);
	@Autowired
	private BusinessChinmedichenacareCommentService businessChinmedichenacareCommentService;
	@Autowired
	private BusinessChinmedichenacareService businessChinmedichenacareService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessChinmedichenacareComment管理页时发生错误：/business/businessChinmedichenacareComment/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessChinmedichenacareComment/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessChinmedichenacareCommentQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessChinmedichenacareCommentService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessChinmedichenacareComment businessChinmedichenacareComment = (BusinessChinmedichenacareComment) baseBean.getList().get(i);
				result.append("{")
			    .append("\"commentId\":\"").append(businessChinmedichenacareComment.getCommentId()).append("\"").append(",")
			    .append("\"cmhcId\":\"").append(businessChinmedichenacareComment.getCmhcId()).append("\"").append(",")
			    .append("\"repliedId\":\"").append(businessChinmedichenacareComment.getRepliedId()).append("\"").append(",")
			    .append("\"repliedName\":\"").append(businessChinmedichenacareComment.getRepliedName()).append("\"").append(",")
			    .append("\"commentorId\":\"").append(businessChinmedichenacareComment.getCommentorId()).append("\"").append(",")
			    .append("\"commentorName\":\"").append(businessChinmedichenacareComment.getCommentorName()).append("\"").append(",")
			    .append("\"commentorAvatar\":\"").append(businessChinmedichenacareComment.getCommentorAvatar()).append("\"").append(",")
			    .append("\"comment\":\"").append(businessChinmedichenacareComment.getComment()).append("\"").append(",")
			    .append("\"commentTime\":\"").append(businessChinmedichenacareComment.getCommentTime()).append("\"").append(",")
			    .append("\"commentorState\":\"").append(businessChinmedichenacareComment.getCommentorState()).append("\"").append(",")
			    .append("\"repliedState\":\"").append(businessChinmedichenacareComment.getRepliedState()).append("\"")
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
			GSLogger.error("显示businessChinmedichenacareComment列表时发生错误：/business/businessChinmedichenacareComment/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessChinmedichenacareCommentQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessChinmedichenacareComment新增页时发生错误：/business/businessChinmedichenacareComment/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessChinmedichenacareComment/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessChinmedichenacareComment
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessChinmedichenacareCommentQuery query) {
		BusinessChinmedichenacareComment businessChinmedichenacareComment = new BusinessChinmedichenacareComment();
		String json = "";
		try{
		    businessChinmedichenacareComment.setCmhcId(query.getCmhcId());
		    businessChinmedichenacareComment.setRepliedId(query.getRepliedId());
		    businessChinmedichenacareComment.setRepliedName(query.getRepliedName());
		    businessChinmedichenacareComment.setCommentorId(query.getCommentorId());
		    businessChinmedichenacareComment.setCommentorName(query.getCommentorName());
		    businessChinmedichenacareComment.setCommentorAvatar(query.getCommentorAvatar());
		    businessChinmedichenacareComment.setComment(query.getComment());
		    businessChinmedichenacareComment.setCommentTime(query.getCommentTime());
		    businessChinmedichenacareComment.setCommentorState(query.getCommentorState());
		    businessChinmedichenacareComment.setRepliedState(query.getRepliedState());
			businessChinmedichenacareCommentService.save(businessChinmedichenacareComment);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessChinmedichenacareComment信息时发生错误：/business/businessChinmedichenacareComment/save", e);
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
	public ModelAndView modify(BusinessChinmedichenacareCommentQuery query) {	
		BusinessChinmedichenacareComment businessChinmedichenacareComment=new BusinessChinmedichenacareComment();
		
		try{
			businessChinmedichenacareComment = businessChinmedichenacareCommentService.findById(query.getCommentId());
		}catch(Exception e){
			GSLogger.error("进入businessChinmedichenacareComment修改页时发生错误：/business/businessChinmedichenacareComment/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessChinmedichenacareComment/modify");
		mav.addObject("businessChinmedichenacareComment", businessChinmedichenacareComment);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessChinmedichenacareCommentQuery query) {
		BusinessChinmedichenacareComment businessChinmedichenacareComment = null;
		String json = "";
		try{
		    businessChinmedichenacareComment = businessChinmedichenacareCommentService.findById(query.getCommentId());
		    businessChinmedichenacareComment.setCmhcId(query.getCmhcId());
		    businessChinmedichenacareComment.setRepliedId(query.getRepliedId());
		    businessChinmedichenacareComment.setRepliedName(query.getRepliedName());
		    businessChinmedichenacareComment.setCommentorId(query.getCommentorId());
		    businessChinmedichenacareComment.setCommentorName(query.getCommentorName());
		    businessChinmedichenacareComment.setCommentorAvatar(query.getCommentorAvatar());
		    businessChinmedichenacareComment.setComment(query.getComment());
		    businessChinmedichenacareComment.setCommentTime(query.getCommentTime());
		    businessChinmedichenacareComment.setCommentorState(query.getCommentorState());
		    businessChinmedichenacareComment.setRepliedState(query.getRepliedState());
			businessChinmedichenacareCommentService.update(businessChinmedichenacareComment);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessChinmedichenacareComment信息时发生错误：/business/businessChinmedichenacareComment/update", e);
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
	public void delete(@RequestParam(value="id") String id, @RequestParam(value="cmhcId") String cmhcId, HttpServletResponse response) {
		String json = "";
		try{
			if(id != null) {
				if(id.indexOf(',') > -1) {
					String[] ids = id.split(",");
					for(int i=0;i<ids.length;i++) {
						Boolean result = businessChinmedichenacareCommentService.delete(new Integer(ids[i]));
						if(result) {
							BusinessChinmedichenacare businessChinmedichenacare = businessChinmedichenacareService.findById(Integer.parseInt(cmhcId));
							if(businessChinmedichenacare.getComments() != null && businessChinmedichenacare.getComments() > 0) {
								businessChinmedichenacare.setComments(businessChinmedichenacare.getComments()-1);
								businessChinmedichenacareService.update(businessChinmedichenacare);
							}							
						}
					}
				}else{
					Boolean result = businessChinmedichenacareCommentService.delete(new Integer(id));
					if(result) {
						BusinessChinmedichenacare businessChinmedichenacare = businessChinmedichenacareService.findById(Integer.parseInt(cmhcId));
						if(businessChinmedichenacare.getComments() != null && businessChinmedichenacare.getComments() > 0) {
							businessChinmedichenacare.setComments(businessChinmedichenacare.getComments()-1);
							businessChinmedichenacareService.update(businessChinmedichenacare);
						}
					}
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessChinmedichenacareComment时发生错误：/business/businessChinmedichenacareComment/delete", e);
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
	 * 保存对象
	 * @param request
	 * @param businessgetChinmedichenacareComment
	 * @return
	 */
	@RequestMapping(value="replySave")
	public void replySave(HttpServletRequest request, HttpServletResponse response, BusinessChinmedichenacareCommentQuery query) {
		BusinessChinmedichenacareComment businessChinmedichenacareComment = new BusinessChinmedichenacareComment();
		String json = "";
		try{
			businessChinmedichenacareComment.setCmhcId(query.getCmhcId());
			businessChinmedichenacareComment.setCommentorId(getUser().getUserId());
			businessChinmedichenacareComment.setCommentorName(getUser().getNickName());
			businessChinmedichenacareComment.setComment(query.getComment());
			businessChinmedichenacareComment.setCommentTime(new Timestamp(System.currentTimeMillis()));
			businessChinmedichenacareComment.setRepliedId(query.getRepliedId());
			businessChinmedichenacareComment.setRepliedName(query.getRepliedName());
			businessChinmedichenacareComment.setRepliedState(query.getCommentorState());
			businessChinmedichenacareComment.setCommentorState(1);
			businessChinmedichenacareCommentService.replySave(businessChinmedichenacareComment);
			if (query.getRepliedId() != 0) {
				BusinessChinmedichenacare businessChinmedichenacare = businessChinmedichenacareService.findById(query.getCmhcId());
				AppUserNews appUserNews = new AppUserNews();
				appUserNews.setUserId(query.getRepliedId());
				appUserNews.setCreateTime(new Timestamp(new Date().getTime()));
				appUserNews.setNewTitle(businessChinmedichenacare.getCmhcTitle());
				appUserNews.setType(9);
				appUserNews.setId(query.getCmhcId());
				appUserNews.setContent("");
				appUserNews.setLastMessage(query.getComment());
				appUserNews.setLastMessageName(businessChinmedichenacareComment.getCommentorName());
				appUserNewsService.saveReply_manage(appUserNews);
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(query.getRepliedId());
				appLatestNews.setTypeId(7);
				appLatestNews.setSourceId(query.getCmhcId());
				appLatestNews.setTo(0);
				appLatestNews.setEstateId(0);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(8);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(9);
				appLatestNewsService.save_app(appLatestNews);
			}	
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessgetChinmedichenacareComment信息时发生错误：/business/businessgetChinmedichenacareComment/save", e);
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
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList_manage")
	public void getPageList_manage(BusinessChinmedichenacareCommentQuery query, HttpServletResponse response) {
		query.setRows(12);
		query.setOrder("desc");
        query.setSort("commentId");
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessChinmedichenacareCommentService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageSize\":").append(baseBean.getPager().getPageSize()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessChinmedichenacareComment businessChinmedichenacareComment = (BusinessChinmedichenacareComment) baseBean.getList().get(i);
				result.append("{")
			    .append("\"commentId\":\"").append(businessChinmedichenacareComment.getCommentId()).append("\"").append(",")
			    .append("\"cmhcId\":\"").append(businessChinmedichenacareComment.getCmhcId()).append("\"").append(",")
			    .append("\"commentorId\":\"").append(businessChinmedichenacareComment.getCommentorId()).append("\"").append(",")
			    .append("\"commentorName\":\"").append(businessChinmedichenacareComment.getCommentorName()).append("\"").append(",")
			    .append("\"comment\":\"").append(businessChinmedichenacareComment.getComment()).append("\"").append(",")
			    .append("\"commentTime\":\"").append(businessChinmedichenacareComment.getCommentTime()).append("\"").append(",")
			    .append("\"repliedId\":\"").append(businessChinmedichenacareComment.getRepliedId()).append("\"").append(",")
			    .append("\"repliedName\":\"").append(businessChinmedichenacareComment.getRepliedName()).append("\"").append(",")
			    .append("\"commentorState\":\"").append(businessChinmedichenacareComment.getCommentorState()).append("\"").append(",")
			    .append("\"repliedState\":\"").append(businessChinmedichenacareComment.getRepliedState()).append("\"")
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
			GSLogger.error("显示businessChinmedichenacareComment列表时发生错误：/business/businessChinmedichenacareComment/getPageList_manage", e);
			e.printStackTrace();
		}
	}
}