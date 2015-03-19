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

import com.community.app.module.bean.BusinessRepairReply;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.service.BusinessRepairReplyService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessRepairReplyQuery;
import com.community.framework.utils.CommonUtils;
import com.community.framework.utils.JsonUtils;

@Controller
@RequestMapping("/business/businessRepairReply")
public class BusinessRepairReplyController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessRepairReplyController.class);
	@Autowired
	private BusinessRepairReplyService businessRepairReplyService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRepairReply管理页时发生错误：/business/businessRepairReply/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRepairReply/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessRepairReplyQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessRepairReplyService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessRepairReply businessRepairReply = (BusinessRepairReply) baseBean.getList().get(i);
				result.append("{")
			    .append("\"commentId\":\"").append(businessRepairReply.getCommentId()).append("\"").append(",")
			    .append("\"repairId\":\"").append(businessRepairReply.getRepairId()).append("\"").append(",")
			    .append("\"replyId\":\"").append(businessRepairReply.getReplyId()).append("\"").append(",")
			    .append("\"commentorId\":\"").append(businessRepairReply.getCommentorId()).append("\"").append(",")
			    .append("\"commentorName\":\"").append(businessRepairReply.getCommentorName()).append("\"").append(",")
			    .append("\"commentorAvatar\":\"").append(businessRepairReply.getCommentorAvatar()).append("\"").append(",")
			    .append("\"comment\":\"").append(businessRepairReply.getComment().replace("\"", "\\\"").replaceAll("(\r?\n()+)", "")).append("\"").append(",")
			    .append("\"commentTime\":\"").append(businessRepairReply.getCommentTime()).append("\"")
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
			GSLogger.error("显示businessRepairReply列表时发生错误：/business/businessRepairReply/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessRepairReplyQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessRepairReply新增页时发生错误：/business/businessRepairReply/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRepairReply/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessRepairReply
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessRepairReplyQuery query) {
		BusinessRepairReply businessRepairReply = new BusinessRepairReply();
		String json = "";
		try{
            ShiroUser shiroUser = CommonUtils.getUser();
		    businessRepairReply.setRepairId(query.getRepairId());
		    businessRepairReply.setReplyId(query.getReplyId());
		    businessRepairReply.setCommentorId(shiroUser.getUserId());
		    businessRepairReply.setCommentorName(shiroUser.getUserName());
		    businessRepairReply.setCommentorAvatar(query.getCommentorAvatar()); //头像
		    businessRepairReply.setComment(query.getComment());
            Timestamp  ts=new Timestamp(new Date().getTime());
		    businessRepairReply.setCommentTime(ts);

	        //businessRepairReply.setCreateTime(ts);
	        //businessRepairReply.setEditTime(ts);
			businessRepairReplyService.save(businessRepairReply);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessRepairReply信息时发生错误：/business/businessRepairReply/save", e);
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
	public ModelAndView modify(BusinessRepairReplyQuery query) {	
		BusinessRepairReply businessRepairReply=new BusinessRepairReply();
		
		try{
			businessRepairReply = businessRepairReplyService.findById(query.getCommentId());
		}catch(Exception e){
			GSLogger.error("进入businessRepairReply修改页时发生错误：/business/businessRepairReply/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessRepairReply/modify");
		mav.addObject("businessRepairReply", businessRepairReply);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessRepairReplyQuery query) {
		BusinessRepairReply businessRepairReply = null;
		String json = "";
		try{
		    businessRepairReply = businessRepairReplyService.findById(query.getCommentId());
		    businessRepairReply.setRepairId(query.getRepairId());
		    businessRepairReply.setReplyId(query.getReplyId());
		    businessRepairReply.setCommentorId(query.getCommentorId());
		    businessRepairReply.setCommentorName(query.getCommentorName());
		    businessRepairReply.setCommentorAvatar(query.getCommentorAvatar());
		    businessRepairReply.setComment(query.getComment());
		    businessRepairReply.setCommentTime(query.getCommentTime());
			businessRepairReplyService.update(businessRepairReply);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessRepairReply信息时发生错误：/business/businessRepairReply/update", e);
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
						businessRepairReplyService.delete(new Integer(ids[i]));
					}
				}else{
					businessRepairReplyService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessRepairReply时发生错误：/business/businessRepairReply/delete", e);
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
