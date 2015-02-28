package com.community.app.module.controller;

import static com.community.framework.utils.CommonUtils.getUser;

import java.io.IOException;
import java.sql.Timestamp;

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
import com.community.app.module.bean.BusinessBreak;
import com.community.app.module.bean.BusinessBreakComment;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.BusinessBreakCommentService;
import com.community.app.module.service.BusinessBreakService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessBreakCommentQuery;

@Controller
@RequestMapping("/business/businessBreakComment")
public class BusinessBreakCommentController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessBreakCommentController.class);
	@Autowired
	private BusinessBreakCommentService businessBreakCommentService;
	@Autowired
	private BusinessBreakService businessBreakService;
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
			GSLogger.error("进入businessBreakComment管理页时发生错误：/business/businessBreakComment/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBreakComment/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessBreakCommentQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessBreakCommentService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessBreakComment businessBreakComment = (BusinessBreakComment) baseBean.getList().get(i);
				result.append("{")
			    .append("\"commentId\":\"").append(businessBreakComment.getCommentId()).append("\"").append(",")
			    .append("\"breakId\":\"").append(businessBreakComment.getBreakId()).append("\"").append(",")
			    .append("\"commentorId\":\"").append(businessBreakComment.getCommentorId()).append("\"").append(",")
			    .append("\"commentorName\":\"").append(businessBreakComment.getCommentorName()).append("\"").append(",")
			    .append("\"content\":\"").append(businessBreakComment.getContent()).append("\"").append(",")
			    .append("\"commentTime\":\"").append(businessBreakComment.getCommentTime()).append("\"").append(",")
			    .append("\"contentType\":\"").append(businessBreakComment.getContentType()).append("\"").append(",")
			    .append("\"videoSize\":\"").append(businessBreakComment.getVideoSize()).append("\"").append(",")
			    .append("\"videoTime\":\"").append(businessBreakComment.getVideoTime()).append("\"").append(",")
			    .append("\"videoFormat\":\"").append(businessBreakComment.getVideoFormat()).append("\"")
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
			GSLogger.error("显示businessBreakComment列表时发生错误：/business/businessBreakComment/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessBreakCommentQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessBreakComment新增页时发生错误：/business/businessBreakComment/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBreakComment/add");
		return mav;
	}
	
	/**
	 * 回复保存对象
	 * @param request
	 * @param businessNewsComment
	 * @return
	 */
	@RequestMapping(value="replySave")
	public void replySave(HttpServletRequest request, HttpServletResponse response, BusinessBreakCommentQuery query) {
		BusinessBreakComment businessBreakComment = new BusinessBreakComment();
		String json = "";
		try{
		    businessBreakComment.setBreakId(query.getBreakId());
		    businessBreakComment.setCommentorId(getUser().getUserId());
		    businessBreakComment.setCommentorName(getUser().getUserName());
		    businessBreakComment.setContent(query.getContent());
		    businessBreakComment.setCommentTime(new Timestamp(System.currentTimeMillis()));
		    businessBreakComment.setContentType(1);
		    businessBreakComment.setVideoFormat("");
		    businessBreakComment.setVideoSize(0);
		    businessBreakComment.setVideoTime(0);
		    businessBreakComment.setTo(1);
			int count = businessBreakCommentService.replySave(businessBreakComment);
			if(count > 0){
				//保存成功
				json = "{\"success\":\"true\",\"message\":\"回复成功\"}";
				BusinessBreak businessBreak =businessBreakService.findById(query.getBreakId());
				businessBreak.setState(1);
				businessBreak.setComments(businessBreak.getComments()+1);
				businessBreak.setLastCommentTime(new Timestamp(System.currentTimeMillis()));
				businessBreakService.updateComments(businessBreak);
				
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(query.getBreakerId());
				appLatestNews.setTypeId(1);
				appLatestNews.setSourceId(query.getBreakId());
				appLatestNews.setTo(0);
				appLatestNews.setEstateId(0);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(0);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(33);
				appLatestNewsService.save_app(appLatestNews);
			}
			
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"回复失败\"}";
			GSLogger.error("保存businessBreakComment信息时发生错误：/business/businessBreakComment/save", e);
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
	 * @param businessBreakComment
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessBreakCommentQuery query) {
		BusinessBreakComment businessBreakComment = new BusinessBreakComment();
		String json = "";
		try{
		    businessBreakComment.setBreakId(query.getBreakId());
		    businessBreakComment.setCommentorId(query.getCommentorId());
		    businessBreakComment.setCommentorName(query.getCommentorName());
		    businessBreakComment.setContent(query.getContent());
		    businessBreakComment.setCommentTime(query.getCommentTime());
		    businessBreakComment.setContentType(query.getContentType());
		    businessBreakComment.setVideoSize(query.getVideoSize());
		    businessBreakComment.setVideoTime(query.getVideoTime());
		    businessBreakComment.setVideoFormat(query.getVideoFormat());
	        //businessBreakComment.setCreateTime(ts);
	        //businessBreakComment.setEditTime(ts);
			businessBreakCommentService.save(businessBreakComment);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessBreakComment信息时发生错误：/business/businessBreakComment/save", e);
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
	public ModelAndView modify(BusinessBreakCommentQuery query) {	
		BusinessBreakComment businessBreakComment=new BusinessBreakComment();
		
		try{
			businessBreakComment = businessBreakCommentService.findById(query.getCommentId());
		}catch(Exception e){
			GSLogger.error("进入businessBreakComment修改页时发生错误：/business/businessBreakComment/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessBreakComment/modify");
		mav.addObject("businessBreakComment", businessBreakComment);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessBreakCommentQuery query) {
		BusinessBreakComment businessBreakComment = null;
		String json = "";
		try{
		    businessBreakComment = businessBreakCommentService.findById(query.getCommentId());
		    businessBreakComment.setBreakId(query.getBreakId());
		    businessBreakComment.setCommentorId(query.getCommentorId());
		    businessBreakComment.setCommentorName(query.getCommentorName());
		    businessBreakComment.setContent(query.getContent());
		    businessBreakComment.setCommentTime(query.getCommentTime());
		    businessBreakComment.setContentType(query.getContentType());
		    businessBreakComment.setVideoSize(query.getVideoSize());
		    businessBreakComment.setVideoTime(query.getVideoTime());
		    businessBreakComment.setVideoFormat(query.getVideoFormat());
	        // Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessBreakComment.setEditTime(ts);
			businessBreakCommentService.update(businessBreakComment);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessBreakComment信息时发生错误：/business/businessBreakComment/update", e);
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
						businessBreakCommentService.delete(new Integer(ids[i]));
					}
				}else{
					businessBreakCommentService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessBreakComment时发生错误：/business/businessBreakComment/delete", e);
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
