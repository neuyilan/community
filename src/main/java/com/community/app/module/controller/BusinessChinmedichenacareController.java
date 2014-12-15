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
import com.community.app.module.bean.BusinessChinmedichenacare;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.service.AppHomepageScopeService;
import com.community.app.module.service.AppHomepageService;
import com.community.app.module.service.BusinessChinmedichenacareCommentService;
import com.community.app.module.service.BusinessChinmedichenacareService;
import com.community.app.module.service.BusinessFocusService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessChinmedichenacareCommentQuery;
import com.community.app.module.vo.BusinessChinmedichenacareQuery;
import com.community.framework.utils.CommonUtils;

@Controller
@RequestMapping("/business/businessChinmedichenacare")
public class BusinessChinmedichenacareController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessChinmedichenacareController.class);
	@Autowired
	private BusinessChinmedichenacareService businessChinmedichenacareService;
	@Autowired
	private BusinessFocusService businessFocusService;
	@Autowired
	private AppHomepageService appHomepageService;
	@Autowired
	private AppHomepageScopeService appHomepageScopeService;
	@Autowired
	private BusinessChinmedichenacareCommentService businessChinmedichenacareCommentService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(BusinessChinmedichenacareQuery query) {		
		BaseBean baseBean = new BaseBean();
		try{
			Subject currentUser = SecurityUtils.getSubject();  
			if (currentUser.isPermitted("care_publish")) {  
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
			baseBean = businessChinmedichenacareService.findAllPage(query);
		}catch(Exception e){
			GSLogger.error("进入businessChinmedichenacare管理页时发生错误：/business/businessChinmedichenacare/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/chinmedichenacare/list");
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
	public void getPageList(BusinessChinmedichenacareQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			Subject currentUser = SecurityUtils.getSubject();  
			if (currentUser.isPermitted("care_publish")) {  
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
			BaseBean baseBean = businessChinmedichenacareService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessChinmedichenacare businessChinmedichenacare = (BusinessChinmedichenacare) baseBean.getList().get(i);
				result.append("{")
			    .append("\"cmhcId\":\"").append(businessChinmedichenacare.getCmhcId()).append("\"").append(",")
			    .append("\"cmhcTitle\":\"").append(businessChinmedichenacare.getCmhcTitle()).append("\"").append(",")
			    .append("\"cmhcContent\":\"").append(businessChinmedichenacare.getCmhcContent().replaceAll("(\r?\n()+)", "").replace("\"", "\\\"")).append("\"").append(",")
			    .append("\"cmhcPic\":\"").append(businessChinmedichenacare.getCmhcPic()).append("\"").append(",")
			    .append("\"appPic\":\"").append(businessChinmedichenacare.getAppPic()).append("\"").append(",")
			    .append("\"publisherId\":\"").append(businessChinmedichenacare.getPublisherId()).append("\"").append(",")
			    .append("\"publisherName\":\"").append(businessChinmedichenacare.getPublisherName()).append("\"").append(",")
			    .append("\"publishTime\":\"").append(businessChinmedichenacare.getPublishTime()).append("\"").append(",")
			    .append("\"publishState\":\"").append(businessChinmedichenacare.getPublishState()).append("\"").append(",")
			    .append("\"auditorId\":\"").append(businessChinmedichenacare.getAuditorId()).append("\"").append(",")
			    .append("\"auditorName\":\"").append(businessChinmedichenacare.getAuditorName()).append("\"").append(",")
			    .append("\"auditTime\":\"").append(businessChinmedichenacare.getAuditTime()).append("\"").append(",")
			    .append("\"visits\":\"").append(businessChinmedichenacare.getVisits()).append("\"").append(",")
			    .append("\"supports\":\"").append(businessChinmedichenacare.getSupports()).append("\"").append(",")
			    .append("\"comments\":\"").append(businessChinmedichenacare.getComments()).append("\"").append(",")
			    .append("\"delMemo\":\"").append(businessChinmedichenacare.getDelMemo()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessChinmedichenacare.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessChinmedichenacare.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessChinmedichenacare.getEditor()).append("\"").append(",")
			    .append("\"brief\":\"").append(businessChinmedichenacare.getBrief()).append("\"").append(",")
			    .append("\"isRecommend\":\"").append(businessChinmedichenacare.getIsRecommend()).append("\"").append(",")
			    .append("\"label\":\"").append(businessChinmedichenacare.getLabel()).append("\"")
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
			GSLogger.error("显示businessChinmedichenacare列表时发生错误：/business/businessChinmedichenacare/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessChinmedichenacareQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessChinmedichenacare新增页时发生错误：/business/businessChinmedichenacare/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/chinmedichenacare/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessChinmedichenacare
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessChinmedichenacareQuery query) {
		BusinessChinmedichenacare businessChinmedichenacare = new BusinessChinmedichenacare();
		String json = "";
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
		    businessChinmedichenacare.setCmhcTitle(query.getCmhcTitle());
		    businessChinmedichenacare.setCmhcContent(query.getCmhcContent());
		    businessChinmedichenacare.setCmhcPic(query.getCmhcPic());
		    businessChinmedichenacare.setAppPic(query.getAppPic());
		    businessChinmedichenacare.setPublisherId(shiroUser.getUserId());
		    businessChinmedichenacare.setPublisherName(shiroUser.getUserName());
		    businessChinmedichenacare.setPublishTime(new Timestamp(System.currentTimeMillis()));
		    businessChinmedichenacare.setPublishState(query.getPublishState());
		    businessChinmedichenacare.setVisits(0);
		    businessChinmedichenacare.setSupports(0);
		    businessChinmedichenacare.setComments(0);
		    businessChinmedichenacare.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessChinmedichenacare.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessChinmedichenacare.setEditor(shiroUser.getUserName());
		    businessChinmedichenacare.setBrief(query.getBrief());
		    
	    	businessChinmedichenacare.setIsRecommend(query.getIsRecommend());
		    businessChinmedichenacare.setLabel(query.getLabel());
		    if(query.getAvatar() != null && !"".equals(query.getAvatar())) {
		    	businessChinmedichenacare.setAvatar(query.getAvatar());
		    }
		    businessChinmedichenacare.setDoctorBrief(query.getDoctorBrief());
		    businessChinmedichenacare.setDoctorName(query.getDoctorName());
			businessChinmedichenacareService.save(businessChinmedichenacare);
			
			if(businessChinmedichenacare.getPublishState() == 0 && businessChinmedichenacare.getIsRecommend() == 1) {
				AppHomepage appHomepage = new AppHomepage();
				appHomepage.setId(businessChinmedichenacare.getCmhcId());
				appHomepage.setTitle(businessChinmedichenacare.getCmhcTitle());
				appHomepage.setBrief(businessChinmedichenacare.getBrief());
				appHomepage.setPic(businessChinmedichenacare.getAppPic());
				appHomepage.setType(6);  // 中医养生
				appHomepage.setPublishTime(new Timestamp(System.currentTimeMillis()));
				appHomepage.setTop(0);
				appHomepageService.save(appHomepage);
			}
			
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessChinmedichenacare信息时发生错误：/business/businessChinmedichenacare/save", e);
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
	public ModelAndView modify(BusinessChinmedichenacareQuery query) {	
		BusinessChinmedichenacare businessChinmedichenacare=new BusinessChinmedichenacare();
		
		try{
			businessChinmedichenacare = businessChinmedichenacareService.findById(query.getCmhcId());
		}catch(Exception e){
			GSLogger.error("进入businessChinmedichenacare修改页时发生错误：/business/businessChinmedichenacare/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/chinmedichenacare/modify");
		mav.addObject("businessChinmedichenacare", businessChinmedichenacare);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessChinmedichenacareQuery query) {
		BusinessChinmedichenacare businessChinmedichenacare = null;
		String json = "";
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			String path = request.getContextPath();
		    String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
		    businessChinmedichenacare = businessChinmedichenacareService.findById(query.getCmhcId());
		    businessChinmedichenacare.setCmhcTitle(query.getCmhcTitle());
		    businessChinmedichenacare.setCmhcContent(query.getCmhcContent());
		    if(query.getCmhcPic() != null && !"".equals(query.getCmhcPic())) {
		    	File file = new File(ctx + businessChinmedichenacare.getCmhcPic());
		    	file.delete();
		    	businessChinmedichenacare.setCmhcPic(query.getCmhcPic());
		    }
		    if(query.getAppPic() != null  && !"".equals(query.getAppPic())) {
		    	File file = new File(ctx + businessChinmedichenacare.getAppPic());
		    	file.delete();
		    	businessChinmedichenacare.setAppPic(query.getAppPic());
		    }
		    businessChinmedichenacare.setPublisherId(shiroUser.getUserId());
		    businessChinmedichenacare.setPublisherName(shiroUser.getUserName());
		    businessChinmedichenacare.setPublishTime(new Timestamp(System.currentTimeMillis()));
		    businessChinmedichenacare.setPublishState(query.getPublishState());
		    businessChinmedichenacare.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessChinmedichenacare.setEditor(shiroUser.getUserName());
		    businessChinmedichenacare.setBrief(query.getBrief());
		    businessChinmedichenacare.setIsRecommend(query.getIsRecommend());
		    
		    businessChinmedichenacare.setLabel(query.getLabel());
		    if(query.getAvatar() != null && !"".equals(query.getAvatar())) {
		    	File file = new File(ctx + businessChinmedichenacare.getAvatar());
		    	file.delete();
		    	businessChinmedichenacare.setAvatar(query.getAvatar());
		    }
		    businessChinmedichenacare.setDoctorBrief(query.getDoctorBrief());
		    businessChinmedichenacare.setDoctorName(query.getDoctorName());
		    
			businessChinmedichenacareService.update(businessChinmedichenacare);
			
			if(businessChinmedichenacare.getPublishState() == 0 && businessChinmedichenacare.getIsRecommend() == 1) {
				AppHomepage appHomepage = new AppHomepage();
				appHomepage.setId(businessChinmedichenacare.getCmhcId());
				appHomepage.setTitle(businessChinmedichenacare.getCmhcTitle());
				appHomepage.setBrief(businessChinmedichenacare.getBrief());
				appHomepage.setPic(businessChinmedichenacare.getAppPic());
				appHomepage.setType(6);  // 中医养生
				appHomepage.setPublishTime(new Timestamp(System.currentTimeMillis()));
				appHomepage.setTop(0);
				appHomepageService.save(appHomepage);
			}
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessChinmedichenacare信息时发生错误：/business/businessChinmedichenacare/update", e);
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
						businessChinmedichenacareService.delete(new Integer(ids[i]));
					}
				}else{
					Boolean  result = businessChinmedichenacareService.delete(new Integer(id));
					if(result) {
						Map paramMap = new HashMap();
						paramMap.put("id", Integer.parseInt(id));
						paramMap.put("type", 6);
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
			GSLogger.error("删除BusinessChinmedichenacare时发生错误：/business/businessChinmedichenacare/delete", e);
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
    public void getNewsDetail(BusinessChinmedichenacareQuery query, HttpServletResponse response) {
        try{
        	BusinessChinmedichenacare businessChinmedichenacare = businessChinmedichenacareService.findById(query.getCmhcId());
        	JSONObject jsons= JSONObject.fromObject(businessChinmedichenacare);
        	
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
            try {
                response.getWriter().write(jsons.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            GSLogger.error("显示businessChinmedichenacare列表时发生错误：/business/businessChinmedichenacare/getNewsDetail", e);
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
		BusinessChinmedichenacareQuery query = new BusinessChinmedichenacareQuery();
		query.setCmhcId(Integer.parseInt(id));
		BusinessChinmedichenacare businessChinmedichenacare = businessChinmedichenacareService.findById(query.getCmhcId());
		String json = "";
		try{
			if(!auditInfo.equals("")) {
				businessChinmedichenacare.setPublishState(3);  // 未通过
				businessChinmedichenacare.setAuditInfo(auditInfo);
			} else {
				businessChinmedichenacare.setPublishState(0);  // 已发布
			}

			businessChinmedichenacare.setEditTime(new Timestamp(System.currentTimeMillis()));
			businessChinmedichenacare.setAuditorId(getUser().getUserId());
			businessChinmedichenacare.setAuditorName(getUser().getUserName());
			businessChinmedichenacare.setAuditTime(new Timestamp(System.currentTimeMillis()));
			businessChinmedichenacare.setPublishTime(new Timestamp(System.currentTimeMillis()));
			businessChinmedichenacareService.update(businessChinmedichenacare);
			
			if(businessChinmedichenacare.getPublishState() == 0 && businessChinmedichenacare.getIsRecommend() == 1) {
				AppHomepage appHomepage = new AppHomepage();
				appHomepage.setId(businessChinmedichenacare.getCmhcId());
				appHomepage.setTitle(businessChinmedichenacare.getCmhcTitle());
				appHomepage.setBrief(businessChinmedichenacare.getBrief());
				appHomepage.setPic(businessChinmedichenacare.getAppPic());
				appHomepage.setType(6);  // 中医养生
				appHomepage.setPublishTime(new Timestamp(System.currentTimeMillis()));
				appHomepage.setTop(0);
				appHomepageService.save(appHomepage);
			}
			
			//发布新闻
		/*	if(businessChinmedichenacare.getIsRecommend() != null && businessChinmedichenacare.getPublishState() == 0) {
				if(businessChinmedichenacare.getIsRecommend() == 0) {
					BusinessFocus businessFocus = new BusinessFocus();
					businessFocus.setTitle(businessChinmedichenacare.getCmhcTitle());
				    businessFocus.setState(2);   // 待审核
				    businessFocus.setPicUrl("");
				    businessFocus.setPageUrl("");
				    businessFocus.setSourceId(businessChinmedichenacare.getCmhcId());
				    businessFocus.setSourceType(0);	// 来源类型
				    businessFocus.setIshtml(1);  // 静态
				    businessFocus.setAuditInfo("");*/
				    
				    /*Map paramMap = new HashMap();
				    paramMap.put("comId", businessNews.getPublishScope());
				    List estateList = manageEstateService.findByMap(paramMap);
				    for(int j=0;j<estateList.size();j++) {
						ManageEstate manageEstate = (ManageEstate) estateList.get(j);
						sb.append(manageEstate.getEstateName()).append(",");
					}*/
				    
				    //businessFocus.setFocusScope(sb.toString().substring(0, sb.toString().length()-1));  //展示范围
				   /* businessFocus.setVisits(0);
				    businessFocus.setSupports(0);
				    businessFocus.setSelectorId(getUser().getUserId());
				    businessFocus.setSelectorName(getUser().getUserName());
				    businessFocus.setSelectTime(new Timestamp(System.currentTimeMillis()));
					businessFocusService.save(businessFocus);*/
					
					/*AppFocusScope appFocusScope = new AppFocusScope();
					for(int j=0;j<estateList.size();j++) {
						  ManageEstate manageEstate = (ManageEstate) estateList.get(j);
						  appFocusScope.setFocusId(businessFocus.getFocusId());
						  appFocusScope.setEstateId(manageEstate.getEstateId());
						  appFocusScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
						  appFocusScopeService.save(appFocusScope);
					}*/
				//} 
			//}
			if(!auditInfo.equals("")) { json = "{\"success\":\"true\",\"message\":\"拒绝成功\"}"; } 
			else { json = "{\"success\":\"true\",\"message\":\"发布成功\"}"; }
		} catch(Exception e) {
			if(!auditInfo.equals("")) { json = "{\"success\":\"true\",\"message\":\"拒绝失败\"}"; } 
			else { json = "{\"success\":\"false\",\"message\":\"发布失败\"}"; }
			
			GSLogger.error("显示businessChinmedichenacare列表时发生错误：/business/businessChinmedichenacare/list", e);
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
		BusinessChinmedichenacareQuery query = new BusinessChinmedichenacareQuery();
		query.setCmhcId(Integer.parseInt(id));
		BusinessChinmedichenacare businessChinmedichenacare = businessChinmedichenacareService.findById(query.getCmhcId());
		String json = "";
		try{
			businessChinmedichenacare.setPublishState(4);  // 通过审核
			businessChinmedichenacare.setEditTime(new Timestamp(System.currentTimeMillis()));
			businessChinmedichenacare.setAuditorId(getUser().getUserId());
			businessChinmedichenacare.setAuditorName(getUser().getUserName());
			businessChinmedichenacare.setAuditTime(new Timestamp(System.currentTimeMillis()));
			businessChinmedichenacare.setPublishTime(new Timestamp(System.currentTimeMillis()));
			businessChinmedichenacareService.update(businessChinmedichenacare);
			json = "{\"success\":\"true\",\"message\":\"审核通过成功\"}"; 
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"审核通过失败\"}";
			GSLogger.error("显示businessChinmedichenacare列表时发生错误：/business/businessChinmedichenacare/list", e);
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
		BusinessChinmedichenacareQuery query = new BusinessChinmedichenacareQuery();
		query.setCmhcId(Integer.parseInt(id));
		BusinessChinmedichenacare businessChinmedichenacare = businessChinmedichenacareService.findById(query.getCmhcId());
		String json = "";
		try{
			businessChinmedichenacare.setPublishState(1);  // 未发布
			businessChinmedichenacare.setEditTime(new Timestamp(System.currentTimeMillis()));
			businessChinmedichenacareService.update(businessChinmedichenacare);
			
			if(businessChinmedichenacare.getPublishState() == 1 && businessChinmedichenacare.getIsRecommend() == 1) {
				Map paramMap = new HashMap();
				paramMap.put("id", Integer.parseInt(id));
				paramMap.put("type", 6);
				List<AppHomepage> list = appHomepageService.findByMap(paramMap);
				if(list.size() == 1) {
					AppHomepage AppHomepage = (AppHomepage)list.get(0);
					appHomepageService.delete(AppHomepage);
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"撤回发布成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"true\",\"message\":\"撤回发布失败\"}"; 
			GSLogger.error("显示businessChinmedichenacare列表时发生错误：/business/businessChinmedichenacare/list", e);
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
	public ModelAndView getNewsCommentList(@RequestParam(value="cmhcId") String cmhcId) {
        BaseBean baseBean = new BaseBean();
        BusinessChinmedichenacare businessChinmedichenacare = new BusinessChinmedichenacare();
		BusinessChinmedichenacareCommentQuery query = new BusinessChinmedichenacareCommentQuery();
		try{
            query.setCmhcId(Integer.parseInt(cmhcId));
            query.setRows(12);
            query.setOrder("desc");
            query.setSort("commentId");
			
            baseBean = businessChinmedichenacareCommentService.findAllPage(query);
            businessChinmedichenacare = businessChinmedichenacareService.findById(Integer.parseInt(cmhcId));
                 
		}catch(Exception e){
			GSLogger.error("进入businessChinmedichenacare管理页时发生错误：/business/businessChinmedichenacare/comment", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/chinmedichenacare/comment");
        mav.addObject("baseBean", baseBean);
        mav.addObject("businessChinmedichenacare", businessChinmedichenacare);
        mav.addObject("pager", baseBean.getPager());
        
		return mav;
	}
    
}
