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
import com.community.app.module.bean.BusinessRepairComment;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.BusinessRepairCommentService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessRepairCommentQuery;

@Controller
@RequestMapping("/business/businessRepairComment")
public class BusinessRepairCommentController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessRepairCommentController.class);
	@Autowired
	private BusinessRepairCommentService businessRepairCommentService;
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
			GSLogger.error("进入businessRepairComment管理页时发生错误：/business/businessRepairComment/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRepairComment/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessRepairCommentQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessRepairCommentService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessRepairComment businessRepairComment = (BusinessRepairComment) baseBean.getList().get(i);
				result.append("{")
			    .append("\"commentId\":\"").append(businessRepairComment.getCommentId()).append("\"").append(",")
			    .append("\"repairId\":\"").append(businessRepairComment.getRepairId()).append("\"").append(",")
			    .append("\"replyId\":\"").append(businessRepairComment.getReplyId()).append("\"").append(",")
			    .append("\"commentorId\":\"").append(businessRepairComment.getCommentorId()).append("\"").append(",")
			    .append("\"commentorName\":\"").append(businessRepairComment.getCommentorName()).append("\"").append(",")
			    .append("\"commentorAvatar\":\"").append(businessRepairComment.getCommentorAvatar()).append("\"").append(",")
			    .append("\"comment\":\"").append(businessRepairComment.getComment().replace("\"", "\\\"").replaceAll("(\r?\n()+)", "")).append("\"").append(",")
			    .append("\"commentTime\":\"").append(businessRepairComment.getCommentTime()).append("\"").append(",")
			    .append("\"contentType\":\"").append(businessRepairComment.getContentType()).append("\"").append(",")
			    .append("\"videoSize\":\"").append(businessRepairComment.getVideoSize()).append("\"").append(",")
			    .append("\"videoTime\":\"").append(businessRepairComment.getVideoTime()).append("\"").append(",")
			    .append("\"videoFormat\":\"").append(businessRepairComment.getVideoFormat()).append("\"")
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
			GSLogger.error("显示businessRepairComment列表时发生错误：/business/businessRepairComment/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessRepairCommentQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRepairComment新增页时发生错误：/business/businessRepairComment/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRepairComment/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessRepairComment
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessRepairCommentQuery query) {
		BusinessRepairComment businessRepairComment = new BusinessRepairComment();
		String json = "";
		try{
	        Timestamp  ts=new Timestamp(new Date().getTime());
		    businessRepairComment.setRepairId(query.getRepairId());
		    businessRepairComment.setCommentorId(getUser().getUserId());
		    businessRepairComment.setCommentorName(getUser().getUserName());
		    businessRepairComment.setComment(query.getComment());
		    businessRepairComment.setCommentTime(ts);
		    businessRepairComment.setContentType(1);
		    businessRepairComment.setVideoTime(0);
		    businessRepairComment.setTo(1);
	        //businessRepairComment.setCreateTime(ts);
	        //businessRepairComment.setEditTime(ts);
			businessRepairCommentService.save_manage(businessRepairComment);
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
			//保存成功
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getReporterId());
			appLatestNews.setTypeId(32);
			appLatestNews.setSourceId(query.getRepairId());
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			appLatestNewsService.save_app(appLatestNews);
			appLatestNews.setTypeId(31);
			appLatestNewsService.save_app(appLatestNews);
			if(query.getRepairState()==0 || query.getRepairState()==1){
				appLatestNews.setTypeId(29);
			}else{
				appLatestNews.setTypeId(30);
			}
			appLatestNewsService.save_app(appLatestNews);
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessRepairComment信息时发生错误：/business/businessRepairComment/save", e);
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
	public ModelAndView modify(BusinessRepairCommentQuery query) {	
		BusinessRepairComment businessRepairComment=new BusinessRepairComment();
		
		try{
			businessRepairComment = businessRepairCommentService.findById(query.getCommentId());
		}catch(Exception e){
			GSLogger.error("进入businessRepairComment修改页时发生错误：/business/businessRepairComment/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRepairComment/modify");
		mav.addObject("businessRepairComment", businessRepairComment);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessRepairCommentQuery query) {
		BusinessRepairComment businessRepairComment = null;
		String json = "";
		try{
		    businessRepairComment = businessRepairCommentService.findById(query.getCommentId());
		    businessRepairComment.setRepairId(query.getRepairId());
		    businessRepairComment.setReplyId(query.getReplyId());
		    businessRepairComment.setCommentorId(query.getCommentorId());
		    businessRepairComment.setCommentorName(query.getCommentorName());
		    businessRepairComment.setCommentorAvatar(query.getCommentorAvatar());
		    businessRepairComment.setComment(query.getComment());
		    businessRepairComment.setCommentTime(query.getCommentTime());
		    businessRepairComment.setContentType(query.getContentType());
		    businessRepairComment.setVideoSize(query.getVideoSize());
		    businessRepairComment.setVideoTime(query.getVideoTime());
		    businessRepairComment.setVideoFormat(query.getVideoFormat());
	        // Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessRepairComment.setEditTime(ts);
			businessRepairCommentService.update(businessRepairComment);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessRepairComment信息时发生错误：/business/businessRepairComment/update", e);
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
						businessRepairCommentService.delete(new Integer(ids[i]));
					}
				}else{
					businessRepairCommentService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessRepairComment时发生错误：/business/businessRepairComment/delete", e);
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