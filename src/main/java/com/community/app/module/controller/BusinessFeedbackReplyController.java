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

import com.community.app.module.bean.BusinessFeedbackReply;
import com.community.app.module.service.BusinessFeedbackReplyService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFeedbackReplyQuery;


@Controller
@RequestMapping("/business/businessFeedbackReply")
public class BusinessFeedbackReplyController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessFeedbackReplyController.class);
	@Autowired
	private BusinessFeedbackReplyService businessFeedbackReplyService;

	private final String LIST_ACTION = "redirect:/business/businessFeedbackReply/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessFeedbackReply管理页时发生错误：/business/businessFeedbackReply/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessFeedbackReply/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessFeedbackReplyQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessFeedbackReplyService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessFeedbackReply businessFeedbackReply = (BusinessFeedbackReply) baseBean.getList().get(i);
				result.append("{")
			    .append("\"commentId\":\"").append(businessFeedbackReply.getCommentId()).append("\"").append(",")
			    .append("\"feedbackId\":\"").append(businessFeedbackReply.getFeedbackId()).append("\"").append(",")
			    .append("\"replyId\":\"").append(businessFeedbackReply.getReplyId()).append("\"").append(",")
			    .append("\"commentorId\":\"").append(businessFeedbackReply.getCommentorId()).append("\"").append(",")
			    .append("\"commentorName\":\"").append(businessFeedbackReply.getCommentorName()).append("\"").append(",")
			    .append("\"commentorAvatar\":\"").append(businessFeedbackReply.getCommentorAvatar()).append("\"").append(",")
			    .append("\"comment\":\"").append(businessFeedbackReply.getComment()).append("\"").append(",")
			    .append("\"commentTime\":\"").append(businessFeedbackReply.getCommentTime()).append("\"")
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
			GSLogger.error("显示businessFeedbackReply列表时发生错误：/business/businessFeedbackReply/list", e);
			e.printStackTrace();
		}
	}

	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessFeedbackReplyQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessFeedbackReply新增页时发生错误：/business/businessFeedbackReply/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessFeedbackReply/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessFeedbackReplyQuery query) {
		BusinessFeedbackReply businessFeedbackReply = new BusinessFeedbackReply();
		String json = "";
		try{
		    businessFeedbackReply.setFeedbackId(query.getFeedbackId());
		    businessFeedbackReply.setReplyId(query.getReplyId());
		    businessFeedbackReply.setCommentorId(query.getCommentorId());
		    businessFeedbackReply.setCommentorName(query.getCommentorName());
		    businessFeedbackReply.setCommentorAvatar(query.getCommentorAvatar());
		    businessFeedbackReply.setComment(query.getComment());

	        Timestamp  ts=new Timestamp(new Date().getTime());
//	        businessFeedbackReply.setCreateTime(ts);
//	        businessFeedbackReply.setEditTime(ts);
            businessFeedbackReply.setCommentTime(ts);
			businessFeedbackReplyService.save(businessFeedbackReply);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessFeedbackReply信息时发生错误：/business/businessFeedbackReply/save", e);
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
	public ModelAndView modify(BusinessFeedbackReplyQuery query) {	
		BusinessFeedbackReply businessFeedbackReply=new BusinessFeedbackReply();
		
		try{
			businessFeedbackReply = businessFeedbackReplyService.findById(query.getCommentId());
		}catch(Exception e){
			GSLogger.error("进入businessFeedbackReply修改页时发生错误：/business/businessFeedbackReply/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessFeedbackReply/modify");
		mav.addObject("businessFeedbackReply", businessFeedbackReply);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessFeedbackReplyQuery query) {
		BusinessFeedbackReply businessFeedbackReply = null;
		String json = "";
		try{
		    businessFeedbackReply = businessFeedbackReplyService.findById(query.getCommentId());
		    businessFeedbackReply.setFeedbackId(query.getFeedbackId());
		    businessFeedbackReply.setReplyId(query.getReplyId());
		    businessFeedbackReply.setCommentorId(query.getCommentorId());
		    businessFeedbackReply.setCommentorName(query.getCommentorName());
		    businessFeedbackReply.setCommentorAvatar(query.getCommentorAvatar());
		    businessFeedbackReply.setComment(query.getComment());

	        Timestamp  ts=new Timestamp(new Date().getTime());
            businessFeedbackReply.setCommentTime(ts);
			businessFeedbackReplyService.update(businessFeedbackReply);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessFeedbackReply信息时发生错误：/business/businessFeedbackReply/update", e);
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
						businessFeedbackReplyService.delete(new Integer(ids[i]));
					}
				}else{
					businessFeedbackReplyService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessFeedbackReply时发生错误：/business/businessFeedbackReply/delete", e);
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
