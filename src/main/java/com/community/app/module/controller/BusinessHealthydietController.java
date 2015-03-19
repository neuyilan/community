package com.community.app.module.controller;

import static com.community.framework.utils.CommonUtils.getUser;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.AppHomepage;
import com.community.app.module.bean.BusinessHealthydiet;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.service.AppHomepageScopeService;
import com.community.app.module.service.AppHomepageService;
import com.community.app.module.service.BusinessHealthydietCommentService;
import com.community.app.module.service.BusinessHealthydietService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHealthydietCommentQuery;
import com.community.app.module.vo.BusinessHealthydietQuery;
import com.community.framework.utils.CommonUtils;
import com.community.framework.utils.JsonUtils;

@Controller
@RequestMapping("/business/businessHealthydiet")
public class BusinessHealthydietController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessHealthydietController.class);
	@Autowired
	private BusinessHealthydietService businessHealthydietService;
	@Autowired
	private AppHomepageService appHomepageService;
	@Autowired
	private AppHomepageScopeService appHomepageScopeService;
	@Autowired
	private BusinessHealthydietCommentService businessHealthydietCommentService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(BusinessHealthydietQuery query) {		
		BaseBean baseBean = new BaseBean();
		try{
			Subject currentUser = SecurityUtils.getSubject();  
			if (currentUser.isPermitted("diet_publish")) {  
				query.setRows(11);
			} else {  
				query.setRows(12);
			}
			query.setOrder("desc");
			if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
				query.setSort(query.getOrderBy());
			}else{
				query.setSort("editTime");
			}
			baseBean = businessHealthydietService.findAllPage(query);
		}catch(Exception e){
			GSLogger.error("进入businessHealthydiet管理页时发生错误：/business/businessHealthydiet/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/healthydiet/list");
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		mav.addObject("state", query.getPublishState());
		mav.addObject("sort", query.getSort());
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessHealthydietQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			Subject currentUser = SecurityUtils.getSubject();  
			if (currentUser.isPermitted("diet_publish")) {  
				query.setRows(11);
			} else {  
				query.setRows(12);
			}
			query.setOrder("desc");
			if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
				query.setSort(query.getOrderBy());
			}else{
				query.setSort("editTime");
			}
			BaseBean baseBean = businessHealthydietService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessHealthydiet businessHealthydiet = (BusinessHealthydiet) baseBean.getList().get(i);
				result.append("{")
			    .append("\"healId\":\"").append(businessHealthydiet.getHealId()).append("\"").append(",")
			    .append("\"healTitle\":\"").append(JsonUtils.stringToJson(businessHealthydiet.getHealTitle().replace("\"", "\\\"").replaceAll("(\r?\n()+)", ""))).append("\"").append(",")
			    .append("\"healContent\":\"").append("").append("\"").append(",")
			    .append("\"cmhcPic\":\"").append(businessHealthydiet.getCmhcPic()).append("\"").append(",")
			    .append("\"appPic\":\"").append(businessHealthydiet.getAppPic()).append("\"").append(",")
			    .append("\"publisherId\":\"").append(businessHealthydiet.getPublisherId()).append("\"").append(",")
			    .append("\"publisherName\":\"").append(businessHealthydiet.getPublisherName()).append("\"").append(",")
			    .append("\"publishTime\":\"").append(businessHealthydiet.getPublishTime()).append("\"").append(",")
			    .append("\"publishState\":\"").append(businessHealthydiet.getPublishState()).append("\"").append(",")
			    .append("\"auditorId\":\"").append(businessHealthydiet.getAuditorId()).append("\"").append(",")
			    .append("\"auditorName\":\"").append(businessHealthydiet.getAuditorName()).append("\"").append(",")
			    .append("\"auditTime\":\"").append(businessHealthydiet.getAuditTime()).append("\"").append(",")
			    .append("\"visits\":\"").append(businessHealthydiet.getVisits()).append("\"").append(",")
			    .append("\"supports\":\"").append(businessHealthydiet.getSupports()).append("\"").append(",")
			    .append("\"comments\":\"").append(businessHealthydiet.getComments()).append("\"").append(",")
			    .append("\"delMemo\":\"").append(businessHealthydiet.getDelMemo()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessHealthydiet.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessHealthydiet.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessHealthydiet.getEditor()).append("\"").append(",")
			    .append("\"brief\":\"").append(businessHealthydiet.getBrief()).append("\"").append(",")
			    .append("\"isRecommend\":\"").append(businessHealthydiet.getIsRecommend()).append("\"").append(",")
			    .append("\"auditInfo\":\"").append(businessHealthydiet.getAuditInfo()).append("\"")
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
			GSLogger.error("显示businessHealthydiet列表时发生错误：/business/businessHealthydiet/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessHealthydietQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessHealthydiet新增页时发生错误：/business/businessHealthydiet/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/healthydiet/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessHealthydiet
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessHealthydietQuery query) {
		BusinessHealthydiet businessHealthydiet = new BusinessHealthydiet();
		String json = "";
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
		    businessHealthydiet.setHealTitle(query.getHealTitle());
		    businessHealthydiet.setHealContent(query.getHealContent());
		    businessHealthydiet.setCmhcPic(query.getCmhcPic());
		    businessHealthydiet.setAppPic(query.getAppPic());
		    businessHealthydiet.setPublisherId(shiroUser.getUserId());
		    businessHealthydiet.setPublisherName(shiroUser.getUserName());
		    businessHealthydiet.setPublishTime(new Timestamp(System.currentTimeMillis()));
		    businessHealthydiet.setPublishState(query.getPublishState());
		    businessHealthydiet.setVisits(0);
		    businessHealthydiet.setSupports(0);
		    businessHealthydiet.setComments(0);
		    businessHealthydiet.setDelMemo("");
		    businessHealthydiet.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessHealthydiet.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessHealthydiet.setEditor(shiroUser.getUserName());
		    businessHealthydiet.setBrief(query.getBrief());
		    businessHealthydiet.setIsRecommend(query.getIsRecommend());
		    businessHealthydiet.setLabel(query.getLabel());
		    if(query.getAvatar() != null && !"".equals(query.getAvatar())) {
		    	businessHealthydiet.setAvatar(query.getAvatar());
		    }
		    businessHealthydiet.setDoctorBrief(query.getDoctorBrief());
		    businessHealthydiet.setDoctorName(query.getDoctorName());
			businessHealthydietService.save(businessHealthydiet);
			
			if(businessHealthydiet.getPublishState() == 0 && businessHealthydiet.getIsRecommend() == 1) {
				AppHomepage appHomepage = new AppHomepage();
				appHomepage.setId(businessHealthydiet.getHealId());
				appHomepage.setTitle(businessHealthydiet.getHealTitle());
				appHomepage.setBrief(businessHealthydiet.getBrief());
				appHomepage.setPic(businessHealthydiet.getAppPic());
				appHomepage.setType(7);  // 健康饮食
				appHomepage.setPublishTime(new Timestamp(System.currentTimeMillis()));
				appHomepage.setTop(0);
				appHomepageService.save(appHomepage);
			}
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessHealthydiet信息时发生错误：/business/businessHealthydiet/save", e);
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
	public ModelAndView modify(BusinessHealthydietQuery query) {	
		BusinessHealthydiet businessHealthydiet=new BusinessHealthydiet();
		
		try{
			businessHealthydiet = businessHealthydietService.findById(query.getHealId());
		}catch(Exception e){
			GSLogger.error("进入businessHealthydiet修改页时发生错误：/business/businessHealthydiet/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/healthydiet/modify");
		mav.addObject("businessHealthydiet", businessHealthydiet);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessHealthydietQuery query) {
		BusinessHealthydiet businessHealthydiet = null;
		String json = "";
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			String path = request.getContextPath();
		    String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
		    businessHealthydiet = businessHealthydietService.findById(query.getHealId());
		    businessHealthydiet.setHealTitle(query.getHealTitle());
		    businessHealthydiet.setHealContent(query.getHealContent());
		    if(query.getCmhcPic() != null && !"".equals(query.getCmhcPic())) {
		    	File file = new File(ctx + businessHealthydiet.getCmhcPic());
		    	file.delete();
		    	businessHealthydiet.setCmhcPic(query.getCmhcPic());
		    }
		    if(query.getAppPic() != null  && !"".equals(query.getAppPic())) {
		    	File file = new File(ctx + businessHealthydiet.getAppPic());
		    	file.delete();
		    	businessHealthydiet.setAppPic(query.getAppPic());
		    }
		    businessHealthydiet.setPublisherId(shiroUser.getUserId());
		    businessHealthydiet.setPublisherName(shiroUser.getUserName());
		    businessHealthydiet.setPublishTime(new Timestamp(System.currentTimeMillis()));
		    businessHealthydiet.setPublishState(query.getPublishState());
		    businessHealthydiet.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessHealthydiet.setEditor(shiroUser.getUserName());
		    businessHealthydiet.setBrief(query.getBrief());
		    businessHealthydiet.setIsRecommend(query.getIsRecommend());
		    businessHealthydiet.setLabel(query.getLabel());
		    if(query.getAvatar() != null && !"".equals(query.getAvatar())) {
		    	File file = new File(ctx + businessHealthydiet.getAvatar());
		    	file.delete();
		    	businessHealthydiet.setAvatar(query.getAvatar());
		    }
		    businessHealthydiet.setDoctorBrief(query.getDoctorBrief());
		    businessHealthydiet.setDoctorName(query.getDoctorName());
		    
			businessHealthydietService.update(businessHealthydiet);
			
			if(businessHealthydiet.getPublishState() == 0 && businessHealthydiet.getIsRecommend() == 1) {
				AppHomepage appHomepage = new AppHomepage();
				appHomepage.setId(businessHealthydiet.getHealId());
				appHomepage.setTitle(businessHealthydiet.getHealTitle());
				appHomepage.setBrief(businessHealthydiet.getBrief());
				appHomepage.setPic(businessHealthydiet.getAppPic());
				appHomepage.setType(7);  // 健康饮食
				appHomepage.setPublishTime(new Timestamp(System.currentTimeMillis()));
				appHomepage.setTop(0);
				appHomepageService.save(appHomepage);
			}
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessHealthydiet信息时发生错误：/business/businessHealthydiet/update", e);
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
						businessHealthydietService.delete(new Integer(ids[i]));
					}
				}else{
					Boolean  result = businessHealthydietService.delete(new Integer(id));
					if(result) {
						Map paramMap = new HashMap();
						paramMap.put("id", Integer.parseInt(id));
						paramMap.put("type", 7);
						List<AppHomepage> list = appHomepageService.findByMap(paramMap);
						if(list.size() == 1) {
							AppHomepage AppHomepage = (AppHomepage)list.get(0);
							appHomepageService.delete(AppHomepage);
						}
					}
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessHealthydiet时发生错误：/business/businessHealthydiet/delete", e);
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
     * 查询养生信息
     * @param query
     * @param response
     */
    @RequestMapping(value="getNewsDetail")
    public void getNewsDetail(BusinessHealthydietQuery query, HttpServletResponse response) {
        try{
        	BusinessHealthydiet businessHealthydiet = businessHealthydietService.findById(query.getHealId());
        	JSONObject jsons= JSONObject.fromObject(businessHealthydiet);
        	
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
            try {
                response.getWriter().write(jsons.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            GSLogger.error("显示businessNews列表时发生错误：/business/businessHealthydiet/getNewsDetail", e);
            e.printStackTrace();
        }
    }
	
    /**
	 * 发布/拒绝新闻对象
	 * @param request
	 * @param businessBreak
	 * @return
	 */
	@RequestMapping(value="updateNewsState")
	public void updateNewsState(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id, @RequestParam(value="auditInfo") String auditInfo) {
		BusinessHealthydietQuery query = new BusinessHealthydietQuery();
		query.setHealId(Integer.parseInt(id));
		BusinessHealthydiet businessHealthydiet = businessHealthydietService.findById(query.getHealId());
		String json = "";
		try{
			if(!auditInfo.equals("")) {
				businessHealthydiet.setPublishState(3);  // 未通过
				businessHealthydiet.setAuditInfo(auditInfo);
			} else {
				businessHealthydiet.setPublishState(0);  // 已发布
			}

			businessHealthydiet.setEditTime(new Timestamp(System.currentTimeMillis()));
			businessHealthydiet.setAuditorId(getUser().getUserId());
			businessHealthydiet.setAuditorName(getUser().getUserName());
			businessHealthydiet.setAuditTime(new Timestamp(System.currentTimeMillis()));
			businessHealthydiet.setPublishTime(new Timestamp(System.currentTimeMillis()));
		    
			businessHealthydietService.update(businessHealthydiet);
			
			if(businessHealthydiet.getPublishState() == 0 && businessHealthydiet.getIsRecommend() == 1) {
				AppHomepage appHomepage = new AppHomepage();
				appHomepage.setId(businessHealthydiet.getHealId());
				appHomepage.setTitle(businessHealthydiet.getHealTitle());
				appHomepage.setBrief(businessHealthydiet.getBrief());
				appHomepage.setPic(businessHealthydiet.getAppPic());
				appHomepage.setType(7);  // 健康饮食
				appHomepage.setPublishTime(new Timestamp(System.currentTimeMillis()));
				appHomepage.setTop(0);
				appHomepageService.save(appHomepage);
			}
			
			if(!auditInfo.equals("")) { json = "{\"success\":\"true\",\"message\":\"拒绝成功\"}"; } 
			else { json = "{\"success\":\"true\",\"message\":\"发布成功\"}"; }
		} catch(Exception e) {
			if(!auditInfo.equals("")) { json = "{\"success\":\"true\",\"message\":\"拒绝失败\"}"; } 
			else { json = "{\"success\":\"false\",\"message\":\"发布失败\"}"; }
			
			GSLogger.error("显示businessNews列表时发生错误：/business/businessNews/list", e);
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
	 * 发布/拒绝新闻对象
	 * @param request
	 * @param businessBreak
	 * @return
	 */
	@RequestMapping(value="updateNewsStatePassNews")
	public void updateNewsStatePassNews(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id) {
		BusinessHealthydietQuery query = new BusinessHealthydietQuery();
		query.setHealId(Integer.parseInt(id));
		BusinessHealthydiet businessHealthydiet = businessHealthydietService.findById(query.getHealId());
		String json = "";
		try{
			businessHealthydiet.setPublishState(4);  // 通过审核
			businessHealthydiet.setEditTime(new Timestamp(System.currentTimeMillis()));
			businessHealthydiet.setAuditorId(getUser().getUserId());
			businessHealthydiet.setAuditorName(getUser().getUserName());
			businessHealthydiet.setAuditTime(new Timestamp(System.currentTimeMillis()));
			businessHealthydiet.setPublishTime(new Timestamp(System.currentTimeMillis()));
			businessHealthydietService.update(businessHealthydiet);
			json = "{\"success\":\"true\",\"message\":\"审核通过成功\"}"; 
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"审核通过失败\"}";
			GSLogger.error("显示businessHealthydiet列表时发生错误：/business/businessHealthydiet/list", e);
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
	 * 撤回发布新闻对象
	 * @param request
	 * @param businessBreak
	 * @return
	 */
	@RequestMapping(value="cancelNewsPublishState")
	public void cancelNewsPublishState(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id) {
		BusinessHealthydietQuery query = new BusinessHealthydietQuery();
		query.setHealId(Integer.parseInt(id));
		BusinessHealthydiet businessHealthydiet = businessHealthydietService.findById(query.getHealId());
		String json = "";
		try{
			businessHealthydiet.setPublishState(1);  // 未发布
			businessHealthydiet.setEditTime(new Timestamp(System.currentTimeMillis()));
			businessHealthydietService.update(businessHealthydiet);
			
			if(businessHealthydiet.getPublishState() == 1 && businessHealthydiet.getIsRecommend() == 1) {
				Map paramMap = new HashMap();
				paramMap.put("id", Integer.parseInt(id));
				paramMap.put("type", 7);
				List<AppHomepage> list = appHomepageService.findByMap(paramMap);
				if(list.size() == 1) {
					AppHomepage AppHomepage = (AppHomepage)list.get(0);
					appHomepageService.delete(AppHomepage);
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"撤回发布成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"true\",\"message\":\"撤回发布失败\"}"; 
			GSLogger.error("显示businessNews列表时发生错误：/business/businessHealthydiet/list", e);
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
     * 查询新闻评论信息
     * @param query
     * @param response
     */    
    @RequestMapping(value="getNewsCommentList")
	public ModelAndView getNewsCommentList(@RequestParam(value="healId") String healId) {
        BaseBean baseBean = new BaseBean();
        BusinessHealthydiet businessHealthydiet = new BusinessHealthydiet();
		BusinessHealthydietCommentQuery query = new BusinessHealthydietCommentQuery();
		try{
            query.setHealId(Integer.parseInt(healId));
            query.setRows(12);
            query.setOrder("desc");
            query.setSort("commentId");
			
            baseBean = businessHealthydietCommentService.findAllPage(query);
            businessHealthydiet = businessHealthydietService.findById(Integer.parseInt(healId));
                 
		}catch(Exception e){
			GSLogger.error("进入businessNews管理页时发生错误：/business/businessHealthydiet/comment", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/healthydiet/comment");
        mav.addObject("baseBean", baseBean);
        mav.addObject("businessHealthydiet", businessHealthydiet);
        mav.addObject("pager", baseBean.getPager());
        
		return mav;
	}
}