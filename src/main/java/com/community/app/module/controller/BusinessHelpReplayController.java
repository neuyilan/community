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

import com.community.app.module.bean.BusinessHelpReplay;
import com.community.app.module.service.BusinessHelpReplayService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHelpReplayQuery;
import com.community.framework.utils.JsonUtils;


@Controller
@RequestMapping("/business/businessHelpReplay")
public class BusinessHelpReplayController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessHelpReplayController.class);
	@Autowired
	private BusinessHelpReplayService businessHelpReplayService;
	
	private final String LIST_ACTION = "redirect:/business/businessHelpReplay/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessHelpReplay管理页时发生错误：/business/businessHelpReplay/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelpReplay/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessHelpReplayQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessHelpReplayService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessHelpReplay businessHelpReplay = (BusinessHelpReplay) baseBean.getList().get(i);
				result.append("{")
			    .append("\"commentId\":\"").append(businessHelpReplay.getCommentId()).append("\"").append(",")
			    .append("\"helpId\":\"").append(businessHelpReplay.getHelpId()).append("\"").append(",")
			    .append("\"commentorId\":\"").append(businessHelpReplay.getCommentorId()).append("\"").append(",")
			    .append("\"commentorName\":\"").append(businessHelpReplay.getCommentorName()).append("\"").append(",")
			    .append("\"comment\":\"").append(JsonUtils.stringToJson(businessHelpReplay.getComment().replace("\"", "\\\"").replaceAll("(\r?\n()+)", ""))).append("\"").append(",")
			    .append("\"commentTime\":\"").append(businessHelpReplay.getCommentTime()).append("\"").append(",")
			    .append("\"replyId\":\"").append(businessHelpReplay.getReplyId()).append("\"").append(",")
			    .append("\"replyName\":\"").append(businessHelpReplay.getReplyName()).append("\"")
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
			GSLogger.error("显示businessHelpReplay列表时发生错误：/business/businessHelpReplay/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessHelpReplayQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessHelpReplay新增页时发生错误：/business/businessHelpReplay/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelpReplay/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessHelpReplay
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessHelpReplayQuery query) {
		BusinessHelpReplay businessHelpReplay = new BusinessHelpReplay();
		String json = "";
		try{
		    businessHelpReplay.setHelpId(query.getHelpId());
		    businessHelpReplay.setCommentorId(query.getCommentorId());
		    businessHelpReplay.setCommentorName(query.getCommentorName());
		    businessHelpReplay.setComment(query.getComment());
		    businessHelpReplay.setCommentTime(query.getCommentTime());
		    businessHelpReplay.setReplyId(query.getReplyId());
		    businessHelpReplay.setReplyName(query.getReplyName());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessHelpReplay.setCreateTime(ts);
	        //businessHelpReplay.setEditTime(ts);
			businessHelpReplayService.save(businessHelpReplay);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessHelpReplay信息时发生错误：/business/businessHelpReplay/save", e);
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
	public ModelAndView modify(BusinessHelpReplayQuery query) {	
		BusinessHelpReplay businessHelpReplay=new BusinessHelpReplay();
		
		try{
			businessHelpReplay = businessHelpReplayService.findById(query.getCommentId());
		}catch(Exception e){
			GSLogger.error("进入businessHelpReplay修改页时发生错误：/business/businessHelpReplay/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelpReplay/modify");
		mav.addObject("businessHelpReplay", businessHelpReplay);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessHelpReplayQuery query) {
		BusinessHelpReplay businessHelpReplay = null;
		String json = "";
		try{
		    businessHelpReplay = businessHelpReplayService.findById(query.getCommentId());
		    businessHelpReplay.setHelpId(query.getHelpId());
		    businessHelpReplay.setCommentorId(query.getCommentorId());
		    businessHelpReplay.setCommentorName(query.getCommentorName());
		    businessHelpReplay.setComment(query.getComment());
		    businessHelpReplay.setCommentTime(query.getCommentTime());
		    businessHelpReplay.setReplyId(query.getReplyId());
		    businessHelpReplay.setReplyName(query.getReplyName());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessHelpReplay.setEditTime(ts);
			businessHelpReplayService.update(businessHelpReplay);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessHelpReplay信息时发生错误：/business/businessHelpReplay/update", e);
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
						businessHelpReplayService.delete(new Integer(ids[i]));
					}
				}else{
					businessHelpReplayService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessHelpReplay时发生错误：/business/businessHelpReplay/delete", e);
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
