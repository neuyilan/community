package com.community.app.module.controller;

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
import com.community.app.module.bean.BusinessActivity;
import com.community.app.module.bean.BusinessActivityComment;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.BusinessActivityCommentService;
import com.community.app.module.service.BusinessActivityService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityCommentQuery;
import com.community.framework.utils.CommonUtils;

@Controller
@RequestMapping("/business/businessActivityComment")
public class BusinessActivityCommentController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessActivityCommentController.class);
	@Autowired
	private BusinessActivityCommentService businessActivityCommentService;
	@Autowired
	private BusinessActivityService businessActivityService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityComment管理页时发生错误：/business/businessActivityComment/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityComment/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessActivityCommentQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			query.setSort("commentTime");
			query.setOrder("desc");
			query.setRows(12);
			BaseBean baseBean = businessActivityCommentService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageSize\":").append(baseBean.getPager().getPageSize()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessActivityComment businessActivityComment = (BusinessActivityComment) baseBean.getList().get(i);
				result.append("{")
			    .append("\"commentId\":\"").append(businessActivityComment.getCommentId()).append("\"").append(",")
			    .append("\"actId\":\"").append(businessActivityComment.getActId()).append("\"").append(",")
			    .append("\"commentor\":\"").append(businessActivityComment.getCommentor()).append("\"").append(",")
			    .append("\"content\":\"").append(businessActivityComment.getContent().replaceAll("(\r?\n()+)", "").replace("\"", "")).append("\"").append(",")
			    .append("\"commentTime\":\"").append(businessActivityComment.getCommentTime()).append("\"").append(",")
			    .append("\"replyId\":\"").append(businessActivityComment.getReplyId()).append("\"").append(",")
			    .append("\"replyName\":\"").append(businessActivityComment.getReplyName()).append("\"").append(",")
			     .append("\"commentorId\":\"").append(businessActivityComment.getCommentorId()).append("\"").append(",")
			    .append("\"commentorState\":\"").append(businessActivityComment.getCommentorState()).append("\"").append(",")
			    .append("\"replyState\":\"").append(businessActivityComment.getReplyState()).append("\"")
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
			GSLogger.error("显示businessActivityComment列表时发生错误：/business/businessActivityComment/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessActivityCommentQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityComment新增页时发生错误：/business/businessActivityComment/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityComment/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessActivityComment
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessActivityCommentQuery query) {
		BusinessActivityComment businessActivityComment = new BusinessActivityComment();
		String json = "";
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
		    businessActivityComment.setActId(query.getActId());
		    businessActivityComment.setCommentor(shiroUser.getNickName());
		    businessActivityComment.setCommentorId(shiroUser.getUserId());
		    businessActivityComment.setContent(query.getContent());
		    businessActivityComment.setCommentTime(new Timestamp(System.currentTimeMillis()));
		    businessActivityComment.setReplyId(query.getReplyId());
		    businessActivityComment.setReplyName(query.getReplyName());
		    businessActivityComment.setReplyState(query.getCommentorState());
		    businessActivityComment.setCommentorState(1);
			businessActivityCommentService.save(businessActivityComment);
			if (query.getReplyId()!=0) {
				BusinessActivity businessActivity =businessActivityService.findById_app(query.getActId());
				AppUserNews appUserNews = new AppUserNews();
				appUserNews.setUserId(query.getReplyId());
				appUserNews.setCreateTime(new Timestamp(new Date().getTime()));
				appUserNews.setNewTitle(businessActivity.getActName());
				appUserNews.setType(1);
				appUserNews.setId(query.getActId());
				appUserNews.setContent("");
				appUserNews.setLastMessage(query.getContent());
				appUserNews.setLastMessageName(businessActivityComment.getCommentor());
				appUserNewsService.saveReply_manage(appUserNews);
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(query.getReplyId());
				appLatestNews.setTypeId(7);
				appLatestNews.setSourceId(query.getActId());
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
			GSLogger.error("保存businessActivityComment信息时发生错误：/business/businessActivityComment/save", e);
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
	 * @param businessActivityComment
	 * @return
	 */
	@RequestMapping(value="replySave")
	public void replySave(HttpServletRequest request, HttpServletResponse response, BusinessActivityCommentQuery query) {
		BusinessActivityComment businessActivityComment = new BusinessActivityComment();
		String json = "";
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
		    businessActivityComment.setActId(query.getActId());
		    businessActivityComment.setCommentor(shiroUser.getNickName());
		    businessActivityComment.setCommentorId(shiroUser.getUserId());
		    businessActivityComment.setContent(query.getContent());
		    businessActivityComment.setCommentTime(new Timestamp(System.currentTimeMillis()));
		    businessActivityComment.setReplyId(query.getReplyId());
		    businessActivityComment.setReplyName(query.getReplyName());
		    businessActivityComment.setReplyState(query.getCommentorState());
		    businessActivityComment.setCommentorState(1);
			businessActivityCommentService.replySave(businessActivityComment);
			if (query.getReplyId()!=0) {
				BusinessActivity businessActivity =businessActivityService.findById_app(query.getActId());
				AppUserNews appUserNews = new AppUserNews();
				appUserNews.setUserId(query.getReplyId());
				appUserNews.setCreateTime(new Timestamp(new Date().getTime()));
				appUserNews.setNewTitle(businessActivity.getActName());
				appUserNews.setType(1);
				appUserNews.setId(query.getActId());
				appUserNews.setContent("");
				appUserNews.setLastMessage(query.getContent());
				appUserNews.setLastMessageName(businessActivityComment.getCommentor());
				appUserNewsService.saveReply_manage(appUserNews);
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(query.getReplyId());
				appLatestNews.setTypeId(7);
				appLatestNews.setSourceId(query.getActId());
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
			GSLogger.error("保存businessActivityComment信息时发生错误：/business/businessActivityComment/replySave", e);
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
	public ModelAndView modify(BusinessActivityCommentQuery query) {	
		BusinessActivityComment businessActivityComment=new BusinessActivityComment();
		
		try{
			businessActivityComment = businessActivityCommentService.findById(query.getCommentId());
		}catch(Exception e){
			GSLogger.error("进入businessActivityComment修改页时发生错误：/business/businessActivityComment/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityComment/modify");
		mav.addObject("businessActivityComment", businessActivityComment);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessActivityCommentQuery query) {
		BusinessActivityComment businessActivityComment = null;
		String json = "";
		try{
		    businessActivityComment = businessActivityCommentService.findById(query.getCommentId());
		    businessActivityComment.setActId(query.getActId());
		    businessActivityComment.setCommentor(query.getCommentor());
		    businessActivityComment.setContent(query.getContent());
		    businessActivityComment.setCommentTime(query.getCommentTime());
		    businessActivityComment.setReplyId(query.getReplyId());
	        //Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessActivityComment.setEditTime(ts);
			businessActivityCommentService.update(businessActivityComment);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessActivityComment信息时发生错误：/business/businessActivityComment/update", e);
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
	public void delete(@RequestParam(value="id") String id, @RequestParam(value="actId") String actId, HttpServletResponse response) {
		String json = "";
		try{
			if(id != null) {
				if(id.indexOf(',') > -1) {
					String[] ids = id.split(",");
					for(int i=0;i<ids.length;i++) {
						businessActivityCommentService.delete(new Integer(ids[i]));
					}
				}else{
					Boolean result = businessActivityCommentService.delete(new Integer(id));
					if(result) {
						BusinessActivity businessActivity = businessActivityService.findById(Integer.parseInt(actId));
						businessActivity.setComments(businessActivity.getComments()-1);
						businessActivityService.update(businessActivity);
					}
				}
			}
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessActivityComment时发生错误：/business/businessActivityComment/delete", e);
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
}