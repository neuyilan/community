package com.community.app.module.controller;

import java.io.IOException;
import java.sql.Timestamp;
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

import com.community.app.module.bean.BusinessDepartment;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.service.BusinessDepartmentService;
import com.community.app.module.service.BusinessPositionService;
import com.community.app.module.service.BusinessUserService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessDepartmentQuery;
import com.community.app.module.vo.BusinessUserQuery;
import com.community.framework.utils.CommonUtils;
import com.community.framework.utils.JsonUtils;

@Controller
@RequestMapping("/business/businessDepartment")
public class BusinessDepartmentController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessDepartmentController.class);
	@Autowired
	private BusinessDepartmentService businessDepartmentService;
	@Autowired
	private BusinessUserService  businessUserService;
	@Autowired
	private BusinessPositionService businessPositionService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(BusinessDepartmentQuery query) {
		BaseBean baseBean = new BaseBean();
		Integer users = 0;
		Integer departments = 0;
		ShiroUser shiroUser = CommonUtils.getUser();
		String orgType = "";
		try{			
			//query.setOrgId(shiroUser.getOrgId());
			/*if(shiroUser.getCurOrgType() != null && !"".equals(shiroUser.getCurOrgType())) {
				orgType = shiroUser.getCurOrgType();
			}else{
				orgType = shiroUser.getOrgType();
			}
			query.setOrgType(orgType);*/
			//query.setUserId(shiroUser.getUserId());
			query.setSort("depId");
			query.setOrder("desc");
			query.setRows(11);
			baseBean = businessDepartmentService.findAllPage(query);
			
			//获取部门数
			departments = businessDepartmentService.selectCount(query);
			
			//获取员工数
			BusinessUserQuery userQuery = new BusinessUserQuery();
			/*if(!"".equals(shiroUser.getCurOrgType())) {//当前选择了部门，运营人员可以看到某部门内所有员工
				userQuery.setOrgType(shiroUser.getCurOrgType());
				if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
					userQuery.setCurEstateId(shiroUser.getCurEstateId());
				}
			}else{//当前没有选择部门 物业、驿站、社区报 只能看到本部门及负责范围内的所有员工 运营能看到所有运营的员工
				if(ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { //运营的员工不按社区查看
					userQuery.setCurComId(0);//过滤掉社区查询条件，否则会出错
				}else{
					userQuery.setCurUserId(shiroUser.getUserId());
					if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
						userQuery.setCurComId(shiroUser.getCurComId());
					}
					if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
						userQuery.setCurEstateId(shiroUser.getCurEstateId());
					}
				}				
				userQuery.setOrgType(shiroUser.getOrgType());
			}*/
			userQuery.setCurUserId(shiroUser.getUserId());
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				userQuery.setCurComId(shiroUser.getCurComId());
			}
			if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
				userQuery.setCurEstateId(shiroUser.getCurEstateId());
			}
			//userQuery.setCurUserId(shiroUser.getUserId());
			BaseBean bb = businessUserService.findAllPage(userQuery);
			users = bb.getCount();

		}catch(Exception e){
			GSLogger.error("进入businessDepartment管理页时发生错误：/business/businessDepartment/list", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/department/list");
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		mav.addObject("users", users);
		mav.addObject("departments", departments);
		mav.addObject("orgId", shiroUser.getUserId());
		mav.addObject("orgType", shiroUser.getUserName());
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessDepartmentQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		String orgType = "";
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			/*if(shiroUser.getCurOrgType() != null && !"".equals(shiroUser.getCurOrgType())) {
				orgType = shiroUser.getCurOrgType();
			}else{
				orgType = shiroUser.getOrgType();
			}*/
			//query.setOrgId(shiroUser.getOrgId());
			//query.setOrgType(orgType);
			//query.setUserId(shiroUser.getUserId());
			query.setSort("depId");
			query.setOrder("desc");
			query.setRows(11);
			BaseBean baseBean = businessDepartmentService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessDepartment businessDepartment = (BusinessDepartment) baseBean.getList().get(i);
				result.append("{")
			    .append("\"depId\":\"").append(businessDepartment.getDepId()).append("\"").append(",")
			    .append("\"depName\":\"").append(businessDepartment.getDepName().replace("\"", "\\\"").replaceAll("(\r?\n()+)", "")).append("\"").append(",")
			    .append("\"depDesc\":\"").append(businessDepartment.getDepDesc().replace("\"", "\\\"").replaceAll("(\r?\n()+)", "")).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessDepartment.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessDepartment.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessDepartment.getEditor()).append("\"").append(",")
			    .append("\"orgType\":\"").append(businessDepartment.getOrgType()).append("\"").append(",")
			    .append("\"orgId\":\"").append(businessDepartment.getOrgId()).append("\"").append(",")
			    .append("\"orgName\":\"").append(businessDepartment.getOrgName()).append("\"")
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
			GSLogger.error("显示businessDepartment列表时发生错误：/business/businessDepartment/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessDepartmentQuery query) {		
		ShiroUser shiroUser = CommonUtils.getUser();
		try{
		}catch(Exception e){
			GSLogger.error("进入businessDepartment新增页时发生错误：/business/businessDepartment/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/department/add");
		mav.addObject("orgId", shiroUser.getUserId());
		mav.addObject("orgType", shiroUser.getUserName());
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessDepartment
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessDepartmentQuery query) {
		BusinessDepartment businessDepartment = new BusinessDepartment();
		String json = "";
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			businessDepartment.setUserId(shiroUser.getUserId());
		    businessDepartment.setDepName(query.getDepName());
		    businessDepartment.setDepDesc(query.getDepDesc());
		    businessDepartment.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessDepartment.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessDepartment.setEditor(shiroUser.getUserName());
		    businessDepartment.setOrgType(shiroUser.getOrgType());
		    businessDepartment.setOrgId(shiroUser.getOrgId());
		    businessDepartment.setOrgName(query.getOrgName());
			businessDepartmentService.save(businessDepartment);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessDepartment信息时发生错误：/business/businessDepartment/save", e);
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
	public ModelAndView modify(BusinessDepartmentQuery query) {	
		BusinessDepartment businessDepartment=new BusinessDepartment();
		
		try{
			businessDepartment = businessDepartmentService.findById(query.getDepId());
		}catch(Exception e){
			GSLogger.error("进入businessDepartment修改页时发生错误：/business/businessDepartment/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/department/modify");
		mav.addObject("businessDepartment", businessDepartment);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessDepartmentQuery query) {
		BusinessDepartment businessDepartment = null;
		String json = "";
		try{
		    businessDepartment = businessDepartmentService.findById(query.getDepId());
		    ShiroUser shiroUser = CommonUtils.getUser();
		    businessDepartment.setDepName(query.getDepName());
		    businessDepartment.setUserId(shiroUser.getUserId());
		    businessDepartment.setDepDesc(query.getDepDesc());
		    //businessDepartment.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessDepartment.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessDepartment.setEditor(shiroUser.getUserName());
		    businessDepartment.setOrgType(shiroUser.getOrgType());
		    businessDepartment.setOrgId(shiroUser.getOrgId());
		    businessDepartment.setOrgName(query.getOrgName());
			businessDepartmentService.update(businessDepartment);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessDepartment信息时发生错误：/business/businessDepartment/update", e);
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
						businessDepartmentService.delete(new Integer(ids[i]));
					}
				}else{
					Map paramMap = new HashMap();
					paramMap.put("depId", new Integer(id));
					List list = businessPositionService.findByMap(paramMap);
					if(list.size() > 0) {
						json = "{\"success\":\"false\",\"message\":\"该部门下拥有职位，请先删除职位\"}";
					}else{
						businessDepartmentService.delete(new Integer(id));
						json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
					}					
				}
			}			
			
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessDepartment时发生错误：/business/businessDepartment/delete", e);
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
