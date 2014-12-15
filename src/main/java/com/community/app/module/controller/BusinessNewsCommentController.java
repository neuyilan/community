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
import com.community.app.module.bean.BusinessNews;
import com.community.app.module.bean.BusinessNewsComment;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.BusinessNewsCommentService;
import com.community.app.module.service.BusinessNewsService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessNewsCommentQuery;

@Controller
@RequestMapping("/business/businessNewsComment")
public class BusinessNewsCommentController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessNewsCommentController.class);
	@Autowired
	private BusinessNewsCommentService businessNewsCommentService;
	@Autowired
	private BusinessNewsService businessNewsService;
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
			GSLogger.error("进入businessNewsComment管理页时发生错误：/business/businessNewsComment/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessNewsComment/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessNewsCommentQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessNewsCommentService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessNewsComment businessNewsComment = (BusinessNewsComment) baseBean.getList().get(i);
				result.append("{")
			    .append("\"commentId\":\"").append(businessNewsComment.getCommentId()).append("\"").append(",")
			    .append("\"newsId\":\"").append(businessNewsComment.getNewsId()).append("\"").append(",")
			    .append("\"commentorId\":\"").append(businessNewsComment.getCommentorId()).append("\"").append(",")
			    .append("\"commentorName\":\"").append(businessNewsComment.getCommentorName()).append("\"").append(",")
			    .append("\"content\":\"").append(businessNewsComment.getContent()).append("\"").append(",")
			    .append("\"commentTime\":\"").append(businessNewsComment.getCommentTime()).append("\"").append(",")
			    .append("\"replyId\":\"").append(businessNewsComment.getReplyId()).append("\"").append(",")
			    .append("\"replyName\":\"").append(businessNewsComment.getReplyName()).append("\"")
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
			GSLogger.error("显示businessNewsComment列表时发生错误：/business/businessNewsComment/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList_manage")
	public void getPageList_manage(BusinessNewsCommentQuery query, HttpServletResponse response) {
		query.setRows(12);
		query.setOrder("desc");
        query.setSort("commentId");
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessNewsCommentService.findAllPage_manage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageSize\":").append(baseBean.getPager().getPageSize()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessNewsComment businessNewsComment = (BusinessNewsComment) baseBean.getList().get(i);
				result.append("{")
			    .append("\"commentId\":\"").append(businessNewsComment.getCommentId()).append("\"").append(",")
			    .append("\"newsId\":\"").append(businessNewsComment.getNewsId()).append("\"").append(",")
			    .append("\"commentorId\":\"").append(businessNewsComment.getCommentorId()).append("\"").append(",")
			    .append("\"commentorName\":\"").append(businessNewsComment.getCommentorName()).append("\"").append(",")
			    .append("\"content\":\"").append(businessNewsComment.getContent()).append("\"").append(",")
			    .append("\"commentTime\":\"").append(businessNewsComment.getCommentTime()).append("\"").append(",")
			    .append("\"replyId\":\"").append(businessNewsComment.getReplyId()).append("\"").append(",")
			    .append("\"replyName\":\"").append(businessNewsComment.getReplyName()).append("\"").append(",")
			    .append("\"commentorState\":\"").append(businessNewsComment.getCommentorState()).append("\"").append(",")
			    .append("\"replyState\":\"").append(businessNewsComment.getReplyState()).append("\"")
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
			GSLogger.error("显示businessNewsComment列表时发生错误：/business/businessNewsComment/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessNewsCommentQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessNewsComment新增页时发生错误：/business/businessNewsComment/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessNewsComment/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessNewsComment
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessNewsCommentQuery query) {
		BusinessNewsComment businessNewsComment = new BusinessNewsComment();
		String json = "";
		try{
		    businessNewsComment.setNewsId(query.getNewsId());
		    businessNewsComment.setCommentorId(query.getCommentorId());
		    businessNewsComment.setCommentorName(query.getCommentorName());
		    businessNewsComment.setContent(query.getContent());
		    businessNewsComment.setCommentTime(query.getCommentTime());
		    businessNewsComment.setReplyId(query.getReplyId());
		    businessNewsComment.setReplyName(query.getReplyName());
	       // Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessNewsComment.setCreateTime(ts);
	        //businessNewsComment.setEditTime(ts);
			businessNewsCommentService.save(businessNewsComment);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessNewsComment信息时发生错误：/business/businessNewsComment/save", e);
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
	 * @param businessNewsComment
	 * @return
	 */
	@RequestMapping(value="replySave")
	public void replySave(HttpServletRequest request, HttpServletResponse response, BusinessNewsCommentQuery query) {
		BusinessNewsComment businessNewsComment = new BusinessNewsComment();
		String json = "";
		try{
		    businessNewsComment.setNewsId(query.getNewsId());
		    businessNewsComment.setCommentorId(getUser().getUserId());
		    businessNewsComment.setCommentorName(getUser().getNickName());
		    businessNewsComment.setContent(query.getContent());
		    businessNewsComment.setCommentTime(query.getCommentTime());
		    businessNewsComment.setReplyId(query.getReplyId());
		    businessNewsComment.setReplyName(query.getReplyName());
		    businessNewsComment.setReplyState(query.getCommentorState());
		    businessNewsComment.setCommentorState(1);
			businessNewsCommentService.replySave(businessNewsComment);
			if (query.getReplyId()!=0) {
				BusinessNews businessNews = businessNewsService.findById_app(query.getNewsId());
				AppUserNews appUserNews = new AppUserNews();
				appUserNews.setUserId(query.getReplyId());
				appUserNews.setCreateTime(new Timestamp(new Date().getTime()));
				appUserNews.setNewTitle(businessNews.getTitle());
				appUserNews.setType(0);
				appUserNews.setId(query.getNewsId());
				appUserNews.setContent("");
				appUserNews.setLastMessage(query.getContent());
				appUserNews.setLastMessageName(businessNewsComment.getCommentorName());
				appUserNewsService.saveReply_manage(appUserNews);
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(query.getReplyId());
				appLatestNews.setTypeId(7);
				appLatestNews.setSourceId(query.getNewsId());
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
			GSLogger.error("保存businessNewsComment信息时发生错误：/business/businessNewsComment/save", e);
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
	public ModelAndView modify(BusinessNewsCommentQuery query) {	
		BusinessNewsComment businessNewsComment=new BusinessNewsComment();
		
		try{
			businessNewsComment = businessNewsCommentService.findById(query.getCommentId());
		}catch(Exception e){
			GSLogger.error("进入businessNewsComment修改页时发生错误：/business/businessNewsComment/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessNewsComment/modify");
		mav.addObject("businessNewsComment", businessNewsComment);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessNewsCommentQuery query) {
		BusinessNewsComment businessNewsComment = null;
		String json = "";
		try{
		    businessNewsComment = businessNewsCommentService.findById(query.getCommentId());
		    businessNewsComment.setNewsId(query.getNewsId());
		    businessNewsComment.setCommentorId(query.getCommentorId());
		    businessNewsComment.setCommentorName(query.getCommentorName());
		    businessNewsComment.setContent(query.getContent());
		    businessNewsComment.setCommentTime(query.getCommentTime());
		    businessNewsComment.setReplyId(query.getReplyId());
		    businessNewsComment.setReplyName(query.getReplyName());
	        //Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessNewsComment.setEditTime(ts);
			businessNewsCommentService.update(businessNewsComment);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessNewsComment信息时发生错误：/business/businessNewsComment/update", e);
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
	public void delete(@RequestParam(value="id") String id, @RequestParam(value="newsId") String newsId, HttpServletResponse response) {
		String json = "";
		try{
			if(id != null) {
				if(id.indexOf(',') > -1) {
					String[] ids = id.split(",");
					for(int i=0;i<ids.length;i++) {
						businessNewsCommentService.delete(new Integer(ids[i]));
					}
				}else{
					Boolean result = businessNewsCommentService.delete(new Integer(id));
					if(result) {
						BusinessNews businessNews = businessNewsService.findById(Integer.parseInt(newsId));
						businessNews.setComments(businessNews.getComments()-1);
						businessNewsService.update(businessNews);
					}
				}
			}
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessNewsComment时发生错误：/business/businessNewsComment/delete", e);
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
