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
import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.BusinessProduct;
import com.community.app.module.bean.BusinessProductComment;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.BusinessProductCommentService;
import com.community.app.module.service.BusinessProductService;
import com.community.app.module.vo.BusinessProductCommentQuery;

@Controller
@RequestMapping("/business/businessProductComment")
public class BusinessProductCommentController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessProductCommentController.class);
	@Autowired
	private BusinessProductCommentService businessProductCommentService;
	@Autowired
	private BusinessProductService businessProductService;
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
			GSLogger.error("进入businessProductComment管理页时发生错误：/business/businessProductComment/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessProductComment/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessProductCommentQuery query, HttpServletResponse response) {
		String json = "";
		query.setRows(12);
		query.setOrder("desc");
		query.setSort("commentId");
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessProductCommentService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageSize\":").append(baseBean.getPager().getPageSize()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessProductComment businessProductComment = (BusinessProductComment) baseBean.getList().get(i);
				result.append("{")
			    .append("\"commentId\":\"").append(businessProductComment.getCommentId()).append("\"").append(",")
			    .append("\"productId\":\"").append(businessProductComment.getProductId()).append("\"").append(",")
			    .append("\"commentorId\":\"").append(businessProductComment.getCommentorId()).append("\"").append(",")
			    .append("\"commentor\":\"").append(businessProductComment.getCommentor()).append("\"").append(",")
			    .append("\"content\":\"").append(businessProductComment.getContent()).append("\"").append(",")
			    .append("\"commentTime\":\"").append(businessProductComment.getCommentTime()).append("\"").append(",")
			    .append("\"replyId\":\"").append(businessProductComment.getReplyId()).append("\"").append(",")
			    .append("\"replyName\":\"").append(businessProductComment.getReplyName()).append("\"").append(",")
			     .append("\"commentorState\":\"").append(businessProductComment.getCommentorState()).append("\"").append(",")
			    .append("\"replyState\":\"").append(businessProductComment.getReplyState()).append("\"")
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
			GSLogger.error("显示businessProductComment列表时发生错误：/business/businessProductComment/list", e);
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
	public void replySave(HttpServletRequest request, HttpServletResponse response, BusinessProductCommentQuery query) {
		BusinessProductComment businessProductComment = new BusinessProductComment();
		String json = "";
		try{
		    businessProductComment.setProductId(query.getProductId());
		    businessProductComment.setCommentorId(getUser().getUserId());
		    businessProductComment.setCommentor(getUser().getNickName());
		    businessProductComment.setContent(query.getContent());
		    businessProductComment.setCommentTime(query.getCommentTime());
		    businessProductComment.setReplyId(query.getReplyId());
		    businessProductComment.setReplyName(query.getReplyName());
		    businessProductComment.setReplyState(query.getCommentorState());
		    businessProductComment.setCommentorState(1);
		    businessProductCommentService.replySave(businessProductComment);
		    if (query.getReplyId()!=0) {
		    	BusinessProduct businessProduct = businessProductService.findById_app(query.getProductId());
				AppUserNews appUserNews = new AppUserNews();
				appUserNews.setUserId(query.getReplyId());
				appUserNews.setCreateTime(new Timestamp(new Date().getTime()));
				appUserNews.setNewTitle(businessProduct.getTitle());
				appUserNews.setType(8);
				appUserNews.setId(query.getProductId());
				appUserNews.setContent("");
				appUserNews.setLastMessage(query.getContent());
				appUserNews.setLastMessageName(businessProductComment.getCommentor());
				appUserNewsService.saveReply_manage(appUserNews);
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(query.getReplyId());
				appLatestNews.setTypeId(7);
				appLatestNews.setSourceId(query.getProductId());
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
			GSLogger.error("保存businessProductComment信息时发生错误：/business/businessProductComment/replySave", e);
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
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessProductCommentQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessProductComment新增页时发生错误：/business/businessProductComment/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessProductComment/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessProductComment
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessProductCommentQuery query) {
		BusinessProductComment businessProductComment = new BusinessProductComment();
		String json = "";
		try{
		    businessProductComment.setProductId(query.getProductId());
		    businessProductComment.setCommentorId(query.getCommentorId());
		    businessProductComment.setCommentor(query.getCommentor());
		    businessProductComment.setContent(query.getContent());
		    businessProductComment.setCommentTime(query.getCommentTime());
		    businessProductComment.setReplyId(query.getReplyId());
		    businessProductComment.setReplyName(query.getReplyName());
	        //businessProductComment.setCreateTime(ts);
	        //businessProductComment.setEditTime(ts);
			businessProductCommentService.save(businessProductComment);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessProductComment信息时发生错误：/business/businessProductComment/save", e);
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
	public ModelAndView modify(BusinessProductCommentQuery query) {	
		BusinessProductComment businessProductComment=new BusinessProductComment();
		
		try{
			businessProductComment = businessProductCommentService.findById(query.getCommentId());
		}catch(Exception e){
			GSLogger.error("进入businessProductComment修改页时发生错误：/business/businessProductComment/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessProductComment/modify");
		mav.addObject("businessProductComment", businessProductComment);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessProductCommentQuery query) {
		BusinessProductComment businessProductComment = null;
		String json = "";
		try{
		    businessProductComment = businessProductCommentService.findById(query.getCommentId());
		    businessProductComment.setProductId(query.getProductId());
		    businessProductComment.setCommentorId(query.getCommentorId());
		    businessProductComment.setCommentor(query.getCommentor());
		    businessProductComment.setContent(query.getContent());
		    businessProductComment.setCommentTime(query.getCommentTime());
		    businessProductComment.setReplyId(query.getReplyId());
		    businessProductComment.setReplyName(query.getReplyName());
	        //businessProductComment.setEditTime(ts);
			businessProductCommentService.update(businessProductComment);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessProductComment信息时发生错误：/business/businessProductComment/update", e);
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
	public void delete(@RequestParam(value="id") String id, @RequestParam(value="productId") String productId, HttpServletResponse response) {
		String json = "";
		try{
			if(id != null) {
				if(id.indexOf(',') > -1) {
					String[] ids = id.split(",");
					for(int i=0;i<ids.length;i++) {
						businessProductCommentService.delete(new Integer(ids[i]));
					}
				}else{
					Boolean result = businessProductCommentService.delete(new Integer(id));
					if(result) {
						BusinessProduct businessProduct = businessProductService.findById(Integer.parseInt(productId));
						businessProduct.setComments(businessProduct.getComments()-1);
						businessProductService.update(businessProduct);
					}
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessProductComment时发生错误：/business/businessProductComment/delete", e);
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
