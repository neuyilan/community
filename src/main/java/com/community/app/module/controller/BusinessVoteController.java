package com.community.app.module.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.community.app.module.vo.BaseBean;


import com.community.app.module.bean.BusinessVote;
import com.community.app.module.service.BusinessVoteService;
import com.community.app.module.vo.BusinessVoteQuery;


@Controller
@RequestMapping("/business/businessVote")
public class BusinessVoteController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessVoteController.class);
	@Autowired
	private BusinessVoteService businessVoteService;
	
	private final String LIST_ACTION = "redirect:/business/businessVote/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessVote管理页时发生错误：/business/businessVote/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessVote/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessVoteQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessVoteService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessVote businessVote = (BusinessVote) baseBean.getList().get(i);
				result.append("{")
			    .append("\"voteId\":\"").append(businessVote.getVoteId()).append("\"").append(",")
			    .append("\"regId\":\"").append(businessVote.getRegId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessVote.getUserId()).append("\"").append(",")
			    .append("\"vateTime\":\"").append(businessVote.getVateTime()).append("\"").append(",")
			    .append("\"actId\":\"").append(businessVote.getActId()).append("\"")
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
			GSLogger.error("显示businessVote列表时发生错误：/business/businessVote/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessVoteQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessVote新增页时发生错误：/business/businessVote/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessVote/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessVote
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessVoteQuery query) {
		BusinessVote businessVote = new BusinessVote();
		String json = "";
		try{
		    businessVote.setRegId(query.getRegId());
		    businessVote.setUserId(query.getUserId());
		    businessVote.setVateTime(query.getVateTime());
		    businessVote.setActId(query.getActId());
			businessVoteService.save(businessVote);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessVote信息时发生错误：/business/businessVote/save", e);
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
	public ModelAndView modify(BusinessVoteQuery query) {	
		BusinessVote businessVote=new BusinessVote();
		
		try{
			businessVote = businessVoteService.findById(query.getVoteId());
		}catch(Exception e){
			GSLogger.error("进入businessVote修改页时发生错误：/business/businessVote/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessVote/modify");
		mav.addObject("businessVote", businessVote);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessVoteQuery query) {
		BusinessVote businessVote = null;
		String json = "";
		try{
		    businessVote = businessVoteService.findById(query.getVoteId());
		    businessVote.setRegId(query.getRegId());
		    businessVote.setUserId(query.getUserId());
		    businessVote.setVateTime(query.getVateTime());
		    businessVote.setActId(query.getActId());
			businessVoteService.update(businessVote);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessVote信息时发生错误：/business/businessVote/update", e);
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
						businessVoteService.delete(new Integer(ids[i]));
					}
				}else{
					businessVoteService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessVote时发生错误：/business/businessVote/delete", e);
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
