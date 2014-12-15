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
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessUserQuery;

import com.community.app.module.bean.BusinessDepartment;
import com.community.app.module.bean.BusinessPosition;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.service.BusinessCommunityService;
import com.community.app.module.service.BusinessDepartmentService;
import com.community.app.module.service.BusinessPositionService;
import com.community.app.module.service.BusinessPropertyService;
import com.community.app.module.service.BusinessStationService;
import com.community.app.module.service.BusinessUserService;
import com.community.app.module.service.ManageOrgService;
import com.community.app.module.vo.BusinessPositionQuery;
import com.community.framework.utils.CommonUtils;

@Controller
@RequestMapping("/business/businessPosition")
public class BusinessPositionController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessPositionController.class);
	@Autowired
	private BusinessPositionService businessPositionService;
	
	@Autowired
	private BusinessDepartmentService businessDepartmentService;
	
	@Autowired
	private BusinessCommunityService businessCommunityService;
	
	@Autowired
	private BusinessStationService businessStationService;
	
	@Autowired
	private BusinessPropertyService businessPropertyService;
	
	@Autowired
	private ManageOrgService manageOrgService;
	@Autowired
	private BusinessUserService businessUserService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(BusinessPositionQuery query) {
		BaseBean baseBean = new BaseBean();
		int grandParentId = 0;
		int depId = 0;
		String depName = "";
		try{
			//部门下1级职位时使用
			if(query.getDepId() != null) {
				depId = query.getDepId();
				BusinessDepartment department = businessDepartmentService.findById(depId);
				depName = department.getDepName();
			}
			
			query.setRows(6);
			query.setOrder("desc");
			query.setSort("editTime");
			baseBean = businessPositionService.findAllPage(query);
			
			//获取父亲的父亲ID作为返回上级部门的ID
			BusinessPosition parentPosition = businessPositionService.findById(query.getParentId());
			if(parentPosition != null) {
				grandParentId = parentPosition.getParentId();
				depId = parentPosition.getDepId();
				depName = parentPosition.getDepName();
			}
			
		}catch(Exception e){
			GSLogger.error("进入businessPosition管理页时发生错误", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/position/list");
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		mav.addObject("depId", depId);
		mav.addObject("depName", depName);
		mav.addObject("positionId", query.getParentId());
		mav.addObject("grandParentId", grandParentId);
		mav.addObject("level", query.getLevel());
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessPositionQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			query.setRows(5);
			query.setOrder("desc");
			query.setSort("editTime");
			BaseBean baseBean = businessPositionService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessPosition businessPosition = (BusinessPosition) baseBean.getList().get(i);
				result.append("{")
			    .append("\"positionId\":\"").append(businessPosition.getPositionId()).append("\"").append(",")
			    .append("\"orgId\":\"").append(businessPosition.getOrgId()).append("\"").append(",")
			    .append("\"orgName\":\"").append(businessPosition.getOrgName()).append("\"").append(",")
			    .append("\"parentId\":\"").append(businessPosition.getParentId()).append("\"").append(",")
			    .append("\"parentName\":\"").append(businessPosition.getParentName()).append("\"").append(",")
			    .append("\"positionCode\":\"").append(businessPosition.getPositionCode()).append("\"").append(",")
			    .append("\"positionState\":\"").append(businessPosition.getPositionState()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessPosition.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessPosition.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessPosition.getEditor()).append("\"").append(",")
			    .append("\"ord\":\"").append(businessPosition.getOrd()).append("\"").append(",")
			    .append("\"leaf\":\"").append(businessPosition.getLeaf()).append("\"").append(",")
			    .append("\"level\":\"").append(businessPosition.getLevel()).append("\"").append(",")
			    .append("\"lowerPosition\":\"").append(businessPosition.getLowerPosition()).append("\"").append(",")
			    .append("\"positionName\":\"").append(businessPosition.getPositionName()).append("\"").append(",")
			    .append("\"depId\":\"").append(businessPosition.getDepId()).append("\"").append(",")
			    .append("\"depName\":\"").append(businessPosition.getDepName()).append("\"").append(",")
			    .append("\"orgType\":\"").append(businessPosition.getOrgType()).append("\"")
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
			GSLogger.error("显示businessPosition列表时发生错误：/business/businessPosition/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessPositionQuery query) {
		BusinessPosition businessPosition = new BusinessPosition();
		BusinessDepartment businessDepartment = new BusinessDepartment();
		Integer depId = query.getDepId(); 
		try{
			businessDepartment = businessDepartmentService.findById(query.getDepId());
			if(query.getPositionId() != null && query.getPositionId() != 0) {
				businessPosition = businessPositionService.findById(query.getPositionId());
				businessDepartment = businessDepartmentService.findById(businessPosition.getDepId());
				depId = businessPosition.getDepId();
			}			
		}catch(Exception e){
			GSLogger.error("进入businessPosition新增页时发生错误：/business/businessPosition/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/position/add");
		mav.addObject("businessDepartment", businessDepartment);
		mav.addObject("depId", depId);
		mav.addObject("businessPosition", businessPosition);
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessPosition
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessPositionQuery query) {
		BusinessPosition businessPosition = new BusinessPosition();
		String json = "";
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
		    businessPosition.setOrgId(query.getOrgId());
		    businessPosition.setOrgName(query.getOrgName());
		    Integer parentId = query.getParentId();
		    if(parentId != null) {//有父节点
		    	BusinessPosition parentPosition = businessPositionService.findById(parentId);
		    	businessPosition.setParentId(parentId);
		    	businessPosition.setParentName(query.getParentName());
		    	businessPosition.setLevel(parentPosition.getLevel()+1);
		    	businessPosition.setLeaf(0);
		    	//设置父节点不为叶子节点
		    	parentPosition.setLeaf(1);
		    	businessPositionService.update(parentPosition);
		    }else{//无父节点
		    	businessPosition.setParentId(0);
		    	businessPosition.setParentName("");
		    	businessPosition.setLeaf(0);
		    	businessPosition.setLevel(1);
		    }
		    businessPosition.setPositionCode("");
		    businessPosition.setPositionState(0);
		    businessPosition.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessPosition.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessPosition.setEditor(shiroUser.getUserName());
		    businessPosition.setOrd(0);
		    businessPosition.setPositionName(query.getPositionName());
		    businessPosition.setPositionDesc(query.getPositionDesc());
		    businessPosition.setDepId(query.getDepId());
		    businessPosition.setDepName(query.getDepName());
		    businessPosition.setOrgType(shiroUser.getOrgType());
			businessPositionService.save(businessPosition);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessPosition信息时发生错误：/business/businessPosition/save", e);
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
	public ModelAndView modify(BusinessPositionQuery query) {	
		BusinessPosition businessPosition=new BusinessPosition();
		
		try{
			businessPosition = businessPositionService.findById(query.getPositionId());
		}catch(Exception e){
			GSLogger.error("进入businessPosition修改页时发生错误：/business/businessPosition/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/position/modify");
		mav.addObject("businessPosition", businessPosition);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessPositionQuery query) {
		BusinessPosition businessPosition = null;
		String json = "";
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
		    businessPosition = businessPositionService.findById(query.getPositionId());
		    //businessPosition.setOrgId(query.getOrgId());
		    //businessPosition.setOrgName(query.getOrgName());
		    //Integer parentId = query.getParentId();
		    /*if(parentId != null) {//有父节点
		    	BusinessPosition parentPosition = businessPositionService.findById(parentId);
		    	businessPosition.setParentId(parentId);
		    	businessPosition.setParentName(query.getParentName());
		    	businessPosition.setLevel(parentPosition.getLevel()+1);
		    	businessPosition.setLeaf(0);
		    	//设置父节点不为叶子节点
		    	parentPosition.setLeaf(1);
		    	businessPositionService.update(parentPosition);
		    }else{//无父节点
		    	businessPosition.setParentId(0);
		    	businessPosition.setParentName("");
		    	businessPosition.setLeaf(0);
		    	businessPosition.setLevel(1);
		    }*/
		    //businessPosition.setPositionCode("");
		    //businessPosition.setPositionState(0);
		    //businessPosition.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessPosition.setEditTime(new Timestamp(System.currentTimeMillis()));
		    businessPosition.setEditor(shiroUser.getUserName());
		    //businessPosition.setOrd(0);
		    businessPosition.setPositionName(query.getPositionName());
		    businessPosition.setPositionDesc(query.getPositionDesc());
		    //businessPosition.setDepId(query.getDepId());
		    //businessPosition.setDepName(query.getDepName());
		    //businessPosition.setOrgType(shiroUser.getOrgType());
			businessPositionService.update(businessPosition);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessPosition信息时发生错误：/business/businessPosition/update", e);
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
						Map map  = new HashMap();
						map.put("parentId", new Integer(ids[i]));
						List list = businessPositionService.findByMap(map);
						if(list.size() > 0) {
							json = "{\"success\":\"false\",\"message\":\"该职位有下级职位，必须先删除下级职位\"}";
							break;
						}else{
							businessPositionService.delete(new Integer(ids[i]));
						}
					}
				}else{
					Map map  = new HashMap();
					map.put("parentId", new Integer(id));
					List list = businessPositionService.findByMap(map);
					if(list.size() > 0) {
						json = "{\"success\":\"false\",\"message\":\"该职位有下级职位，必须先删除下级职位\"}";
					}else{
						map  = new HashMap();
						map.put("positionId", new Integer(id));
						List userList = businessUserService.findByMap(map);
						if(userList.size() > 0) {
							json = "{\"success\":\"false\",\"message\":\"该职位下还有员工，暂不能删除\"}";
						}else{
							businessPositionService.delete(new Integer(id));
							json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
						}						
					}					
				}
			}	
			
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessPosition时发生错误：/business/businessPosition/delete", e);
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
