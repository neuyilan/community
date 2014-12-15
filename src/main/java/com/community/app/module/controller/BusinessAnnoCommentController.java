package com.community.app.module.controller;

import static com.community.framework.utils.CommonUtils.getUser;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.BusinessAnno;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.BusinessAnnoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.vo.BaseBean;
import com.community.app.module.bean.BusinessAnnoComment;
import com.community.app.module.service.BusinessAnnoCommentService;
import com.community.app.module.vo.BusinessAnnoCommentQuery;
import com.community.framework.utils.CommonUtils;

@Controller
@RequestMapping("/business/businessAnnoComment")
public class BusinessAnnoCommentController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessAnnoCommentController.class);
	@Autowired
	private BusinessAnnoCommentService businessAnnoCommentService;
    @Autowired
	private BusinessAnnoService businessAnnoService;
    @Autowired
	private AppLatestNewsService appLatestNewsService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(@RequestParam(value="annoId") String annoId) {
        BaseBean baseBean = new BaseBean();
        BusinessAnno businessAnno = new BusinessAnno();
		try{
            int id = Integer.parseInt(annoId);
            BusinessAnnoCommentQuery query = new BusinessAnnoCommentQuery();
            query.setAnnoId(id);
            query.setRows(12);
            query.setSort("commentId");
            query.setOrder("desc");
            baseBean = businessAnnoCommentService.findAllPage(query);
            businessAnno = businessAnnoService.findById(id);
		}catch(Exception e){
			GSLogger.error("进入businessAnnoComment管理页时发生错误：/business/businessAnnoComment/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/annocomment/details");
        mav.addObject("baseBean", baseBean);
        mav.addObject("businessAnno", businessAnno);
        mav.addObject("pager", baseBean.getPager());
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessAnnoCommentQuery query, HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
            query.setSort("commentId");
            query.setOrder("desc");
            query.setRows(12);
			BaseBean baseBean = businessAnnoCommentService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageSize\":").append(baseBean.getPager().getPageSize()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessAnnoComment businessAnnoComment = (BusinessAnnoComment) baseBean.getList().get(i);
				result.append("{")
			    .append("\"commentId\":\"").append(businessAnnoComment.getCommentId()).append("\"").append(",")
			    .append("\"annoId\":\"").append(businessAnnoComment.getAnnoId()).append("\"").append(",")
			    .append("\"repliedId\":\"").append(businessAnnoComment.getRepliedId()).append("\"").append(",")
			    .append("\"repliedName\":\"").append(businessAnnoComment.getRepliedName()).append("\"").append(",")
			    .append("\"commentorId\":\"").append(businessAnnoComment.getCommentorId()).append("\"").append(",")
			    .append("\"commentorName\":\"").append(businessAnnoComment.getCommentorName()).append("\"").append(",")
			    .append("\"commentorAvatar\":\"").append(businessAnnoComment.getCommentorAvatar()).append("\"").append(",")
			    .append("\"comment\":\"").append(businessAnnoComment.getComment()).append("\"").append(",")
			    
			    .append("\"commentorState\":\"").append(businessAnnoComment.getCommentorState()).append("\"").append(",")
			    .append("\"repliedState\":\"").append(businessAnnoComment.getRepliedState()).append("\"").append(",")
			    
			    .append("\"commentTime\":\"").append(businessAnnoComment.getCommentTime()).append("\"")
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
			GSLogger.error("显示businessAnnoComment列表时发生错误：/business/businessAnnoComment/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessAnnoCommentQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessAnnoComment新增页时发生错误：/business/businessAnnoComment/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessAnnoComment/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessAnnoCommentQuery query) {
		BusinessAnnoComment businessAnnoComment = new BusinessAnnoComment();
		String json = "";
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			BusinessAnnoComment repliedComment = businessAnnoCommentService.findById(query.getCommentId());
		    businessAnnoComment.setAnnoId(repliedComment.getAnnoId());
		    businessAnnoComment.setRepliedId(repliedComment.getCommentorId());
		    businessAnnoComment.setRepliedName(repliedComment.getCommentorName());
		    businessAnnoComment.setCommentorId(shiroUser.getUserId());
		    businessAnnoComment.setCommentorName(shiroUser.getUserName());
		    businessAnnoComment.setCommentorAvatar(query.getCommentorAvatar());
		    businessAnnoComment.setComment(query.getComment());
		    businessAnnoComment.setCommentorState(query.getCommentorState());
		    businessAnnoComment.setRepliedState(query.getRepliedState());

	        Timestamp  ts=new Timestamp(new Date().getTime());
            businessAnnoComment.setCommentTime(ts);
			businessAnnoCommentService.save(businessAnnoComment);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessAnnoComment信息时发生错误：/business/businessAnnoComment/save", e);
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
	 * 保存回复信息
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(value="replySave")
	public void replySave(HttpServletRequest request, HttpServletResponse response, BusinessAnnoCommentQuery query) {
		BusinessAnnoComment businessAnnoComment = new BusinessAnnoComment();
		String json = "";
		try{
			BusinessAnnoComment repliedComment = businessAnnoCommentService.findById(query.getCommentId());
			
		    businessAnnoComment.setAnnoId(query.getAnnoId());
		    businessAnnoComment.setCommentorId(getUser().getUserId());
		    businessAnnoComment.setCommentorName(getUser().getNickName());
		    businessAnnoComment.setComment(query.getComment());
		    businessAnnoComment.setRepliedId(repliedComment.getCommentorId());
		    businessAnnoComment.setRepliedName(repliedComment.getCommentorName());
		    businessAnnoComment.setRepliedState(query.getCommentorState());
		    businessAnnoComment.setCommentorState(1);
		    
	        Timestamp  ts=new Timestamp(new Date().getTime());
            businessAnnoComment.setCommentTime(ts);
			businessAnnoCommentService.replySave(businessAnnoComment);
			
			if (query.getReplyId()!=0) {
				BusinessAnno businessAnno = businessAnnoService.findById_app(query.getAnnoId());
				AppUserNews appUserNews = new AppUserNews();
				appUserNews.setUserId(query.getReplyId());
				appUserNews.setCreateTime(new Timestamp(new Date().getTime()));
				appUserNews.setNewTitle(businessAnno.getAnnoTitle());
				if(businessAnno.getAnnoType() == 0 || businessAnno.getAnnoType() == 1) {  // 物业公告
					appUserNews.setType(3);
				} else if(businessAnno.getAnnoType() == 4){ // 驿站公告
					appUserNews.setType(4);
				} 
				
				appUserNews.setId(query.getAnnoId());
				appUserNews.setContent("");
				appUserNews.setLastMessage(query.getContent());
				appUserNews.setLastMessageName(businessAnnoComment.getCommentorName());
				appUserNewsService.saveReply_manage(appUserNews);
				AppLatestNews appLatestNews = new AppLatestNews();
				appLatestNews.setUserId(query.getReplyId());
				appLatestNews.setTypeId(7);
				appLatestNews.setSourceId(query.getAnnoId());
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
			GSLogger.error("保存businessAnnoComment信息时发生错误：/business/businessAnnoComment/save", e);
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
	public ModelAndView modify(BusinessAnnoCommentQuery query) {	
		BusinessAnnoComment businessAnnoComment=new BusinessAnnoComment();
		
		try{
			businessAnnoComment = businessAnnoCommentService.findById(query.getCommentId());
		}catch(Exception e){
			GSLogger.error("进入businessAnnoComment修改页时发生错误：/business/businessAnnoComment/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessAnnoComment/modify");
		mav.addObject("businessAnnoComment", businessAnnoComment);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessAnnoCommentQuery query) {
		BusinessAnnoComment businessAnnoComment = null;
		String json = "";
		try{
		    businessAnnoComment = businessAnnoCommentService.findById(query.getCommentId());
		    businessAnnoComment.setAnnoId(query.getAnnoId());
		    businessAnnoComment.setRepliedId(query.getRepliedId());
		    businessAnnoComment.setRepliedName(query.getRepliedName());
		    businessAnnoComment.setCommentorId(query.getCommentorId());
		    businessAnnoComment.setCommentorName(query.getCommentorName());
		    businessAnnoComment.setCommentorAvatar(query.getCommentorAvatar());
		    businessAnnoComment.setComment(query.getComment());
		    businessAnnoComment.setCommentTime(query.getCommentTime());
		    
		    businessAnnoComment.setCommentorState(query.getCommentorState());
		    businessAnnoComment.setRepliedState(query.getRepliedState());
		    
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessAnnoComment.setEditTime(ts);
            businessAnnoComment.setCommentTime(ts);
			businessAnnoCommentService.update(businessAnnoComment);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessAnnoComment信息时发生错误：/business/businessAnnoComment/update", e);
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
	public void delete(@RequestParam(value="id") String id, @RequestParam(value="annoId") String annoId, HttpServletResponse response) {
		String json = "";
		try{
			if(id != null) {
				if(id.indexOf(',') > -1) {
					String[] ids = id.split(",");
					for(int i=0;i<ids.length;i++) {
						businessAnnoCommentService.delete(new Integer(ids[i]));
					}
				}else{
					Boolean result = businessAnnoCommentService.delete(new Integer(id));
					if(result) {
						BusinessAnno businessAnno = businessAnnoService.findById(Integer.parseInt(annoId));
						businessAnno.setComments(businessAnno.getComments()-1);
						businessAnnoService.update(businessAnno);
					}
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessAnnoComment时发生错误：/business/businessAnnoComment/delete", e);
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