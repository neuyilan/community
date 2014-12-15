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

import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHealthydietCommentQuery;


import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.BusinessHealthydiet;
import com.community.app.module.bean.BusinessHealthydietComment;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.BusinessHealthydietCommentService;
import com.community.app.module.service.BusinessHealthydietService;

@Controller
@RequestMapping("/business/businessHealthydietComment")
public class BusinessHealthydietCommentController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessHealthydietCommentController.class);
	@Autowired
	private BusinessHealthydietCommentService businessHealthydietCommentService;
	@Autowired
	private BusinessHealthydietService businessHealthydietService;
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
			GSLogger.error("进入businessHealthydietComment管理页时发生错误：/business/businessHealthydietComment/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHealthydietComment/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessHealthydietCommentQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessHealthydietCommentService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessHealthydietComment businessHealthydietComment = (BusinessHealthydietComment) baseBean.getList().get(i);
				result.append("{")
			    .append("\"commentId\":\"").append(businessHealthydietComment.getCommentId()).append("\"").append(",")
			    .append("\"healId\":\"").append(businessHealthydietComment.getHealId()).append("\"").append(",")
			    .append("\"repliedId\":\"").append(businessHealthydietComment.getRepliedId()).append("\"").append(",")
			    .append("\"repliedName\":\"").append(businessHealthydietComment.getRepliedName()).append("\"").append(",")
			    .append("\"commentorId\":\"").append(businessHealthydietComment.getCommentorId()).append("\"").append(",")
			    .append("\"commentorName\":\"").append(businessHealthydietComment.getCommentorName()).append("\"").append(",")
			    .append("\"commentorAvatar\":\"").append(businessHealthydietComment.getCommentorAvatar()).append("\"").append(",")
			    .append("\"comment\":\"").append(businessHealthydietComment.getComment()).append("\"").append(",")
			    .append("\"commentTime\":\"").append(businessHealthydietComment.getCommentTime()).append("\"").append(",")
			    .append("\"commentorState\":\"").append(businessHealthydietComment.getCommentorState()).append("\"").append(",")
			    .append("\"repliedState\":\"").append(businessHealthydietComment.getRepliedState()).append("\"")
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
			GSLogger.error("显示businessHealthydietComment列表时发生错误：/business/businessHealthydietComment/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessHealthydietCommentQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessHealthydietComment新增页时发生错误：/business/businessHealthydietComment/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHealthydietComment/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessHealthydietComment
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessHealthydietCommentQuery query) {
		BusinessHealthydietComment businessHealthydietComment = new BusinessHealthydietComment();
		String json = "";
		try{
		    businessHealthydietComment.setHealId(query.getHealId());
		    businessHealthydietComment.setRepliedId(query.getRepliedId());
		    businessHealthydietComment.setRepliedName(query.getRepliedName());
		    businessHealthydietComment.setCommentorId(query.getCommentorId());
		    businessHealthydietComment.setCommentorName(query.getCommentorName());
		    businessHealthydietComment.setCommentorAvatar(query.getCommentorAvatar());
		    businessHealthydietComment.setComment(query.getComment());
		    businessHealthydietComment.setCommentTime(query.getCommentTime());
		    businessHealthydietComment.setCommentorState(query.getCommentorState());
		    businessHealthydietComment.setRepliedState(query.getRepliedState());
			businessHealthydietCommentService.save(businessHealthydietComment);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessHealthydietComment信息时发生错误：/business/businessHealthydietComment/save", e);
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
	public ModelAndView modify(BusinessHealthydietCommentQuery query) {	
		BusinessHealthydietComment businessHealthydietComment=new BusinessHealthydietComment();
		
		try{
			businessHealthydietComment = businessHealthydietCommentService.findById(query.getCommentId());
		}catch(Exception e){
			GSLogger.error("进入businessHealthydietComment修改页时发生错误：/business/businessHealthydietComment/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHealthydietComment/modify");
		mav.addObject("businessHealthydietComment", businessHealthydietComment);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessHealthydietCommentQuery query) {
		BusinessHealthydietComment businessHealthydietComment = null;
		String json = "";
		try{
		    businessHealthydietComment = businessHealthydietCommentService.findById(query.getCommentId());
		    businessHealthydietComment.setHealId(query.getHealId());
		    businessHealthydietComment.setRepliedId(query.getRepliedId());
		    businessHealthydietComment.setRepliedName(query.getRepliedName());
		    businessHealthydietComment.setCommentorId(query.getCommentorId());
		    businessHealthydietComment.setCommentorName(query.getCommentorName());
		    businessHealthydietComment.setCommentorAvatar(query.getCommentorAvatar());
		    businessHealthydietComment.setComment(query.getComment());
		    businessHealthydietComment.setCommentTime(query.getCommentTime());
		    businessHealthydietComment.setCommentorState(query.getCommentorState());
		    businessHealthydietComment.setRepliedState(query.getRepliedState());
			businessHealthydietCommentService.update(businessHealthydietComment);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessHealthydietComment信息时发生错误：/business/businessHealthydietComment/update", e);
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
	public void delete(@RequestParam(value="id") String id, @RequestParam(value="healId") String healId, HttpServletResponse response) {
		String json = "";
		try{
			if(id != null) {
				if(id.indexOf(',') > -1) {
					String[] ids = id.split(",");
					for(int i=0;i<ids.length;i++) {
						businessHealthydietCommentService.delete(new Integer(ids[i]));
					}
				}else{
					Boolean result = businessHealthydietCommentService.delete(new Integer(id));
					if(result) {
						BusinessHealthydiet businessHealthydiet = businessHealthydietService.findById(Integer.parseInt(healId));
						if(businessHealthydiet.getComments() != null && businessHealthydiet.getComments() > 0) {
							businessHealthydiet.setComments(businessHealthydiet.getComments()-1);
							businessHealthydietService.update(businessHealthydiet);
						}
					}
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessHealthydietComment时发生错误：/business/businessHealthydietComment/delete", e);
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
	 * @param businessgetHealthydietComment
	 * @return
	 */
	@RequestMapping(value="replySave")
	public void replySave(HttpServletRequest request, HttpServletResponse response, BusinessHealthydietCommentQuery query) {
		BusinessHealthydietComment businessHealthydietComment = new BusinessHealthydietComment();
		String json = "";
		try{
			businessHealthydietComment.setHealId(query.getHealId());
			businessHealthydietComment.setCommentorId(getUser().getUserId());
			businessHealthydietComment.setCommentorName(getUser().getNickName());
			businessHealthydietComment.setComment(query.getComment());
			businessHealthydietComment.setCommentTime(new Timestamp(System.currentTimeMillis()));
			businessHealthydietComment.setRepliedId(query.getRepliedId());
			businessHealthydietComment.setRepliedName(query.getRepliedName());
			businessHealthydietComment.setRepliedState(query.getCommentorState());
			businessHealthydietComment.setCommentorState(1);
			businessHealthydietCommentService.replySave(businessHealthydietComment);
			if (query.getRepliedId() != 0) {
				BusinessHealthydiet businessHealthydiet = businessHealthydietService.findById(query.getHealId());
				AppUserNews appUserNews = new AppUserNews();
				appUserNews.setUserId(query.getRepliedId());
				appUserNews.setCreateTime(new Timestamp(new Date().getTime()));
				appUserNews.setNewTitle(businessHealthydiet.getHealTitle());
				appUserNews.setType(10);
				appUserNews.setId(query.getHealId());
				appUserNews.setContent("");
				appUserNews.setLastMessage(query.getComment());
				appUserNews.setLastMessageName(businessHealthydietComment.getCommentorName());
				appUserNewsService.saveReply_manage(appUserNews);
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(query.getRepliedId());
				appLatestNews.setTypeId(7);
				appLatestNews.setSourceId(query.getHealId());
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
			GSLogger.error("保存businessgetHealthydietComment信息时发生错误：/business/businessgetHealthydietComment/save", e);
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
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList_manage")
	public void getPageList_manage(BusinessHealthydietCommentQuery query, HttpServletResponse response) {
		query.setRows(12);
		query.setOrder("desc");
        query.setSort("commentId");
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessHealthydietCommentService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageSize\":").append(baseBean.getPager().getPageSize()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessHealthydietComment businessHealthydietComment = (BusinessHealthydietComment) baseBean.getList().get(i);
				result.append("{")
			    .append("\"commentId\":\"").append(businessHealthydietComment.getCommentId()).append("\"").append(",")
			    .append("\"healId\":\"").append(businessHealthydietComment.getHealId()).append("\"").append(",")
			    .append("\"commentorId\":\"").append(businessHealthydietComment.getCommentorId()).append("\"").append(",")
			    .append("\"commentorName\":\"").append(businessHealthydietComment.getCommentorName()).append("\"").append(",")
			    .append("\"comment\":\"").append(businessHealthydietComment.getComment()).append("\"").append(",")
			    .append("\"commentTime\":\"").append(businessHealthydietComment.getCommentTime()).append("\"").append(",")
			    .append("\"repliedId\":\"").append(businessHealthydietComment.getRepliedId()).append("\"").append(",")
			    .append("\"repliedName\":\"").append(businessHealthydietComment.getRepliedName()).append("\"").append(",")
			    .append("\"commentorState\":\"").append(businessHealthydietComment.getCommentorState()).append("\"").append(",")
			    .append("\"repliedState\":\"").append(businessHealthydietComment.getRepliedState()).append("\"")
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
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示businessHealthydietComment列表时发生错误：/business/businessHealthydietComment/getPageList_manage", e);
			e.printStackTrace();
		}
	}
}