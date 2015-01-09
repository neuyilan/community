package com.community.app.module.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.BusinessStationMessage;
import com.community.app.module.service.BusinessStationMessageService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessStationMessageQuery;

@Controller
@RequestMapping("/business/businessStationMessage")
public class BusinessStationMessageController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessStationMessageController.class);
	@Autowired
	private BusinessStationMessageService businessStationMessageService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessStationMessage管理页时发生错误：/business/businessStationMessage/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessStationMessage/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessStationMessageQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessStationMessageService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessStationMessage businessStationMessage = (BusinessStationMessage) baseBean.getList().get(i);
				result.append("{")
			    .append("\"commentId\":\"").append(businessStationMessage.getCommentId()).append("\"").append(",")
			    .append("\"stationId\":\"").append(businessStationMessage.getStationId()).append("\"").append(",")
			    .append("\"commentorId\":\"").append(businessStationMessage.getCommentorId()).append("\"").append(",")
			    .append("\"commentorName\":\"").append(businessStationMessage.getCommentorName()).append("\"").append(",")
			    .append("\"content\":\"").append(businessStationMessage.getContent()).append("\"").append(",")
			    .append("\"commentTime\":\"").append(businessStationMessage.getCommentTime()).append("\"").append(",")
			    .append("\"replyId\":\"").append(businessStationMessage.getReplyId()).append("\"").append(",")
			    .append("\"replyName\":\"").append(businessStationMessage.getReplyName()).append("\"").append(",")
			    .append("\"commentorState\":\"").append(businessStationMessage.getCommentorState()).append("\"").append(",")
			    .append("\"replyState\":\"").append(businessStationMessage.getReplyState()).append("\"")
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
			GSLogger.error("显示businessStationMessage列表时发生错误：/business/businessStationMessage/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessStationMessageQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessStationMessage新增页时发生错误：/business/businessStationMessage/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessStationMessage/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessStationMessage
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessStationMessageQuery query) {
		BusinessStationMessage businessStationMessage = new BusinessStationMessage();
		String json = "";
		try{
		    businessStationMessage.setStationId(query.getStationId());
		    businessStationMessage.setCommentorId(query.getCommentorId());
		    businessStationMessage.setCommentorName(query.getCommentorName());
		    businessStationMessage.setContent(query.getContent());
		    businessStationMessage.setCommentTime(query.getCommentTime());
		    businessStationMessage.setReplyId(query.getReplyId());
		    businessStationMessage.setReplyName(query.getReplyName());
		    businessStationMessage.setCommentorState(query.getCommentorState());
		    businessStationMessage.setReplyState(query.getReplyState());
			businessStationMessageService.save(businessStationMessage);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessStationMessage信息时发生错误：/business/businessStationMessage/save", e);
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
	public ModelAndView modify(BusinessStationMessageQuery query) {	
		BusinessStationMessage businessStationMessage=new BusinessStationMessage();
		
		try{
			businessStationMessage = businessStationMessageService.findById(query.getCommentId());
		}catch(Exception e){
			GSLogger.error("进入businessStationMessage修改页时发生错误：/business/businessStationMessage/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessStationMessage/modify");
		mav.addObject("businessStationMessage", businessStationMessage);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessStationMessageQuery query) {
		BusinessStationMessage businessStationMessage = null;
		String json = "";
		try{
		    businessStationMessage = businessStationMessageService.findById(query.getCommentId());
		    businessStationMessage.setStationId(query.getStationId());
		    businessStationMessage.setCommentorId(query.getCommentorId());
		    businessStationMessage.setCommentorName(query.getCommentorName());
		    businessStationMessage.setContent(query.getContent());
		    businessStationMessage.setCommentTime(query.getCommentTime());
		    businessStationMessage.setReplyId(query.getReplyId());
		    businessStationMessage.setReplyName(query.getReplyName());
		    businessStationMessage.setCommentorState(query.getCommentorState());
		    businessStationMessage.setReplyState(query.getReplyState());
			businessStationMessageService.update(businessStationMessage);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessStationMessage信息时发生错误：/business/businessStationMessage/update", e);
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
						businessStationMessageService.delete(new Integer(ids[i]));
					}
				}else{
					businessStationMessageService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessStationMessage时发生错误：/business/businessStationMessage/delete", e);
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