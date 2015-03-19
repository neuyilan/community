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
import com.community.app.module.bean.BusinessFeedback;
import com.community.app.module.bean.BusinessFeedbackComment;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.BusinessFeedbackCommentService;
import com.community.app.module.service.BusinessFeedbackService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFeedbackCommentQuery;
import com.community.framework.utils.JsonUtils;

@Controller
@RequestMapping("/business/businessFeedbackComment")
public class BusinessFeedbackCommentController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessFeedbackCommentController.class);
	@Autowired
	private BusinessFeedbackCommentService businessFeedbackCommentService;
	@Autowired
	private BusinessFeedbackService businessFeedbackService;
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
			GSLogger.error("进入businessFeedbackComment管理页时发生错误：/business/businessFeedbackComment/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessFeedbackComment/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessFeedbackCommentQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessFeedbackCommentService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessFeedbackComment businessFeedbackComment = (BusinessFeedbackComment) baseBean.getList().get(i);
				result.append("{")
			    .append("\"commentId\":\"").append(businessFeedbackComment.getCommentId()).append("\"").append(",")
			    .append("\"feedbackId\":\"").append(businessFeedbackComment.getFeedbackId()).append("\"").append(",")
			    .append("\"replyId\":\"").append(businessFeedbackComment.getReplyId()).append("\"").append(",")
			    .append("\"commentorId\":\"").append(businessFeedbackComment.getCommentorId()).append("\"").append(",")
			    .append("\"commentorName\":\"").append(businessFeedbackComment.getCommentorName()).append("\"").append(",")
			    .append("\"commentorAvatar\":\"").append(businessFeedbackComment.getCommentorAvatar()).append("\"").append(",")
			    .append("\"comment\":\"").append(JsonUtils.stringToJson(businessFeedbackComment.getComment().replace("\"", "\\\"").replaceAll("(\r?\n()+)", ""))).append("\"").append(",")
			    .append("\"commentTime\":\"").append(businessFeedbackComment.getCommentTime()).append("\"").append(",")
			    .append("\"contentType\":\"").append(businessFeedbackComment.getContentType()).append("\"").append(",")
			    .append("\"videoSize\":\"").append(businessFeedbackComment.getVideoSize()).append("\"").append(",")
			    .append("\"videoTime\":\"").append(businessFeedbackComment.getVideoTime()).append("\"").append(",")
			    .append("\"videoFormat\":\"").append(businessFeedbackComment.getVideoFormat()).append("\"")
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
			GSLogger.error("显示businessFeedbackComment列表时发生错误：/business/businessFeedbackComment/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessFeedbackCommentQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessFeedbackComment新增页时发生错误：/business/businessFeedbackComment/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessFeedbackComment/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessFeedbackComment
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessFeedbackCommentQuery query) {
		BusinessFeedbackComment businessFeedbackComment = new BusinessFeedbackComment();
		String json = "";
		try{
			
			Timestamp  ts=new Timestamp(new Date().getTime());
		    businessFeedbackComment.setFeedbackId(query.getFeedbackId());
		    businessFeedbackComment.setCommentorId(getUser().getUserId());
		    businessFeedbackComment.setCommentorName(getUser().getUserName());
		    businessFeedbackComment.setComment(query.getComment());
		    businessFeedbackComment.setCommentTime(ts);
		    businessFeedbackComment.setContentType(1);
		    businessFeedbackComment.setVideoTime(0);
		    businessFeedbackComment.setTo(1);
	        //businessFeedbackComment.setCreateTime(ts);
	        //businessFeedbackComment.setEditTime(ts);
			businessFeedbackCommentService.save_manage(businessFeedbackComment);
			if(query.getFbState()==0){
				BusinessFeedback businessFeedback = new BusinessFeedback();
				businessFeedback.setFeedbackId(query.getFeedbackId());
				businessFeedback.setFbState(1);
				businessFeedbackService.update(businessFeedback);
			}
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getFberId());
			appLatestNews.setTypeId(20);//我的服务管家列表
			appLatestNews.setSourceId(query.getFeedbackId());
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			appLatestNewsService.save_app(appLatestNews);
			int type = query.getFbType();
			switch (type) {
			case 0:
				appLatestNews.setTypeId(15);
				appLatestNewsService.save_app(appLatestNews);
				if(query.getFbState()==0 || query.getFbState()==1){
					appLatestNews.setTypeId(18);
				}else{
					appLatestNews.setTypeId(19);
				}
				appLatestNewsService.save_app(appLatestNews);
				break;
			case 4:
				appLatestNews.setTypeId(13);
				appLatestNewsService.save_app(appLatestNews);
				if(query.getFbState()==0 || query.getFbState()==1){
					appLatestNews.setTypeId(16);
				}else{
					appLatestNews.setTypeId(17);
				}
				appLatestNewsService.save_app(appLatestNews);
				break;
			case 1:
				appLatestNews.setTypeId(14);
				appLatestNewsService.save_app(appLatestNews);
				break;
			case 2:
				appLatestNews.setTypeId(11);
				appLatestNewsService.save_app(appLatestNews);
				break;
			case 3:
				appLatestNews.setTypeId(12);
				appLatestNewsService.save_app(appLatestNews);
				break;
			default:
				break;
			}
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessFeedbackComment信息时发生错误：/business/businessFeedbackComment/save", e);
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
	public ModelAndView modify(BusinessFeedbackCommentQuery query) {	
		BusinessFeedbackComment businessFeedbackComment=new BusinessFeedbackComment();
		
		try{
			businessFeedbackComment = businessFeedbackCommentService.findById(query.getCommentId());
		}catch(Exception e){
			GSLogger.error("进入businessFeedbackComment修改页时发生错误：/business/businessFeedbackComment/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessFeedbackComment/modify");
		mav.addObject("businessFeedbackComment", businessFeedbackComment);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessFeedbackCommentQuery query) {
		BusinessFeedbackComment businessFeedbackComment = null;
		String json = "";
		try{
		    businessFeedbackComment = businessFeedbackCommentService.findById(query.getCommentId());
		    businessFeedbackComment.setFeedbackId(query.getFeedbackId());
		    businessFeedbackComment.setReplyId(query.getReplyId());
		    businessFeedbackComment.setCommentorId(query.getCommentorId());
		    businessFeedbackComment.setCommentorName(query.getCommentorName());
		    businessFeedbackComment.setCommentorAvatar(query.getCommentorAvatar());
		    businessFeedbackComment.setComment(query.getComment());
		    businessFeedbackComment.setCommentTime(query.getCommentTime());
		    businessFeedbackComment.setContentType(query.getContentType());
		    businessFeedbackComment.setVideoSize(query.getVideoSize());
		    businessFeedbackComment.setVideoTime(query.getVideoTime());
		    businessFeedbackComment.setVideoFormat(query.getVideoFormat());
	        // Timestamp  ts=new Timestamp(new Date().getTime());
	        // businessFeedbackComment.setEditTime(ts);
			businessFeedbackCommentService.update(businessFeedbackComment);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessFeedbackComment信息时发生错误：/business/businessFeedbackComment/update", e);
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
						businessFeedbackCommentService.delete(new Integer(ids[i]));
					}
				}else{
					businessFeedbackCommentService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessFeedbackComment时发生错误：/business/businessFeedbackComment/delete", e);
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