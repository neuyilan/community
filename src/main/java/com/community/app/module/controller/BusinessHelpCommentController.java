package com.community.app.module.controller;

import static com.community.framework.utils.CommonUtils.getUser;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.community.app.module.bean.AppPushLog;
import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.AppUserConfig;
import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.BusinessHelp;
import com.community.app.module.bean.BusinessHelpComment;
import com.community.app.module.push.AppPushNotificationUtil;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppPushLogService;
import com.community.app.module.service.AppUserConfigService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessHelpCommentService;
import com.community.app.module.service.BusinessHelpService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHelpCommentQuery;

@Controller
@RequestMapping("/business/businessHelpComment")
public class BusinessHelpCommentController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessHelpCommentController.class);
	@Autowired
	private BusinessHelpCommentService businessHelpCommentService;
	@Autowired
	private BusinessHelpService businessHelpService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private AppPushLogService appPushLogService;
	@Autowired
	private AppUserConfigService appUserConfigService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessHelpComment管理页时发生错误：/business/businessHelpComment/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelpComment/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessHelpCommentQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessHelpCommentService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessHelpComment businessHelpComment = (BusinessHelpComment) baseBean.getList().get(i);
				result.append("{")
			    .append("\"commentId\":\"").append(businessHelpComment.getCommentId()).append("\"").append(",")
			    .append("\"helpId\":\"").append(businessHelpComment.getHelp()).append("\"").append(",")
			    .append("\"commentorId\":\"").append(businessHelpComment.getCommentorId()).append("\"").append(",")
			    .append("\"commentorName\":\"").append(businessHelpComment.getCommentorName()).append("\"").append(",")
			    .append("\"content\":\"").append(businessHelpComment.getContent().replaceAll("(\r?\n()+)", "").replace("\"", "")).append("\"").append(",")
			    .append("\"commentTime\":\"").append(businessHelpComment.getCommentTime()).append("\"").append(",")
			    .append("\"replyId\":\"").append(businessHelpComment.getReplyId()).append("\"").append(",")
			    .append("\"replyName\":\"").append(businessHelpComment.getReplyName()).append("\"")
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
			GSLogger.error("显示businessHelpComment列表时发生错误：/business/businessHelpComment/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList_manage")
	public void getPageList_manage(BusinessHelpCommentQuery query, HttpServletResponse response) {
		query.setRows(12);
		query.setOrder("desc");
        query.setSort("commentId");
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessHelpCommentService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageSize\":").append(baseBean.getPager().getPageSize()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessHelpComment businessHelpComment = (BusinessHelpComment) baseBean.getList().get(i);
				result.append("{")
			    .append("\"commentId\":\"").append(businessHelpComment.getCommentId()).append("\"").append(",")
			    .append("\"help\":\"").append(businessHelpComment.getHelp()).append("\"").append(",")
			    .append("\"commentorId\":\"").append(businessHelpComment.getCommentorId()).append("\"").append(",")
			    .append("\"commentorName\":\"").append(businessHelpComment.getCommentorName()).append("\"").append(",")
			    .append("\"content\":\"").append(businessHelpComment.getContent().replaceAll("(\r?\n()+)", "").replace("\"", "")).append("\"").append(",")
			    .append("\"commentTime\":\"").append(businessHelpComment.getCommentTime()).append("\"").append(",")
			    .append("\"replyId\":\"").append(businessHelpComment.getReplyId()).append("\"").append(",")
			    .append("\"replyName\":\"").append(businessHelpComment.getReplyName()).append("\"").append(",")
			    .append("\"commentorState\":\"").append(businessHelpComment.getCommentorState()).append("\"").append(",")
			    .append("\"replyState\":\"").append(businessHelpComment.getReplyState()).append("\"")
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
			GSLogger.error("显示businessHelpComment列表时发生错误：/business/businessHelpComment/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessHelpCommentQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessHelpComment新增页时发生错误：/business/businessHelpComment/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelpComment/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessHelpComment
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessHelpCommentQuery query) {
		BusinessHelpComment businessHelpComment = new BusinessHelpComment();
		String json = "";
		try{
		    businessHelpComment.setHelp(query.getHelp());
		    businessHelpComment.setCommentorId(query.getCommentorId());
		    businessHelpComment.setCommentorName(query.getCommentorName());
		    businessHelpComment.setContent(query.getContent());
		    businessHelpComment.setCommentTime(query.getCommentTime());
		    businessHelpComment.setReplyId(query.getReplyId());
		    businessHelpComment.setReplyName(query.getReplyName());
	       // Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessHelpComment.setCreateTime(ts);
	        //businessHelpComment.setEditTime(ts);
			businessHelpCommentService.save(businessHelpComment);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessHelpComment信息时发生错误：/business/businessHelpComment/save", e);
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
	 * @param businessHelpComment
	 * @return
	 */
	@RequestMapping(value="replySave")
	public void replySave(HttpServletRequest request, HttpServletResponse response, BusinessHelpCommentQuery query) {
		BusinessHelpComment businessHelpComment = new BusinessHelpComment();
		String json = "";
		try{
		    businessHelpComment.setHelp(query.getHelp());
		    businessHelpComment.setCommentorId(getUser().getUserId());
		    businessHelpComment.setCommentorName(getUser().getNickName());
		    businessHelpComment.setContent(query.getContent());
		    businessHelpComment.setCommentTime(new Timestamp(new Date().getTime()));
		    businessHelpComment.setReplyId(query.getReplyId());
		    businessHelpComment.setReplyName(query.getReplyName());
		    businessHelpComment.setReplyState(query.getCommentorState());
		    businessHelpComment.setCommentorState(1);
			businessHelpCommentService.replySave(businessHelpComment);
			if (query.getReplyId()!=0 && query.getCommentorId() != query.getReplyId()) {
				BusinessHelp businessHelp = businessHelpService.findById_app(query.getHelp());
				AppUserNews appUserNews = new AppUserNews();
				appUserNews.setUserId(query.getReplyId());
				appUserNews.setCreateTime(new Timestamp(new Date().getTime()));
				appUserNews.setNewTitle(businessHelp.getHelpContent());
				appUserNews.setType(7);
				appUserNews.setId(query.getHelp());
				appUserNews.setContent("");
				appUserNews.setLastMessage(query.getContent());
				appUserNews.setLastMessageName(businessHelpComment.getCommentorName());
				appUserNewsService.saveReply_manage(appUserNews);
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(query.getReplyId());
				appLatestNews.setTypeId(7);
				appLatestNews.setSourceId(query.getHelp());
				appLatestNews.setTo(0);
				appLatestNews.setEstateId(0);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(8);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(9);
				appLatestNewsService.save_app(appLatestNews);
				
				AppUser appUser = appUserService.findById(businessHelp.getHelperId());
				Map paramMapTemp = new HashMap();
				paramMapTemp.put("userId", appUser.getUserId());
				List configList = appUserConfigService.findByMap(paramMapTemp);
				AppUserConfig appUserConfig = null;
				if(configList != null) {
					appUserConfig = (AppUserConfig) configList.get(0);
				}		
				if(appUserConfig != null 
						&& appUserConfig.getHelpSwitch() == 0 
						&& appUser.getBaiduId() != null 
						&& !"".equals(appUser.getBaiduId()) 
						&& appUser.getChannelId() != null 
						&& !"".equals(appUser.getChannelId())) {
	        		String title = "OK家";
					String description = "【我的求助】您的发布的求助信息，得到了("+businessHelpComment.getCommentorName()+")的回复，快来看看吧。";
					
					Map paramMap = new HashMap();
					paramMap.put("messageType", 13);
					paramMap.put("ID", businessHelp.getHelpId());
					
					Integer success = AppPushNotificationUtil.pushNotification(
							title, 
							description, 
							appUser.getDeviceType(),
							Long.valueOf(appUser.getChannelId()).longValue(), 
							appUser.getBaiduId(),
							paramMap
							);
					//记录推送日志
					AppPushLog appPushLog = new AppPushLog();
					appPushLog.setUserId(appUser.getUserId());
				    appPushLog.setUserName(appUser.getRealname());
				    appPushLog.setBaiduId(appUser.getBaiduId());
				    appPushLog.setChannelId(appUser.getChannelId());
				    appPushLog.setTitle(title);
				    appPushLog.setDescription(description);
				    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
				    appPushLog.setSendState(success);
				    appPushLog.setSenderId(getUser().getUserId());
				    appPushLog.setSenderName(getUser().getUserName());
					appPushLogService.save(appPushLog);
				}
			}
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessHelpComment信息时发生错误：/business/businessHelpComment/save", e);
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
	public ModelAndView modify(BusinessHelpCommentQuery query) {	
		BusinessHelpComment businessHelpComment=new BusinessHelpComment();
		
		try{
			businessHelpComment = businessHelpCommentService.findById(query.getCommentId());
		}catch(Exception e){
			GSLogger.error("进入businessHelpComment修改页时发生错误：/business/businessHelpComment/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessHelpComment/modify");
		mav.addObject("businessHelpComment", businessHelpComment);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessHelpCommentQuery query) {
		BusinessHelpComment businessHelpComment = null;
		String json = "";
		try{
		    businessHelpComment = businessHelpCommentService.findById(query.getCommentId());
		    businessHelpComment.setHelp(query.getHelp());
		    businessHelpComment.setCommentorId(query.getCommentorId());
		    businessHelpComment.setCommentorName(query.getCommentorName());
		    businessHelpComment.setContent(query.getContent());
		    businessHelpComment.setCommentTime(query.getCommentTime());
		    businessHelpComment.setReplyId(query.getReplyId());
		    businessHelpComment.setReplyName(query.getReplyName());
	        //Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessHelpComment.setEditTime(ts);
			businessHelpCommentService.update(businessHelpComment);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessHelpComment信息时发生错误：/business/businessHelpComment/update", e);
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
	public void delete(@RequestParam(value="id") String id, @RequestParam(value="help") String help, HttpServletResponse response) {
		String json = "";
		try{
			if(id != null) {
				if(id.indexOf(',') > -1) {
					String[] ids = id.split(",");
					for(int i=0;i<ids.length;i++) {
						businessHelpCommentService.delete(new Integer(ids[i]));
					}
				}else{
					Boolean result = businessHelpCommentService.delete(new Integer(id));
					if(result) {
						BusinessHelp businessHelp = businessHelpService.findById(Integer.parseInt(help));
						businessHelp.setComments(businessHelp.getComments()-1);
						businessHelpService.update(businessHelp);
					}
				}
			}
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除businessHelpComment时发生错误：/business/businessHelpComment/delete", e);
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
