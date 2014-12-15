package com.community.app.module.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.community.app.module.bean.*;
import com.community.app.module.service.*;
import net.sf.json.JSONArray;
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
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessDepartmentQuery;

import com.community.app.module.common.EstateBean;
import com.community.app.module.common.ModuleConst;
import com.community.app.module.vo.BusinessUserQuery;
import com.community.framework.utils.CommonUtils;

import static com.community.framework.utils.CommonUtils.getUser;

@Controller
@RequestMapping("/business/businessUser")
public class BusinessUserController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessUserController.class);
	@Autowired
	private BusinessUserService businessUserService;
	@Autowired
	private BusinessPositionService businessPositionService;
	@Autowired
	private BusinessDepartmentService businessDepartmentService;
	@Autowired
	private ManageEstateService manageEstateService;
	@Autowired
	private ManageBuildingService manageBuildingService;
	@Autowired
	private ManageUnitService manageUnitService;
	@Autowired
	private ManageModuleService manageModuleService;
	@Autowired
	private BusinessMenuService businessMenuService;
	@Autowired
	private ManageFunctionService manageFunctionService;
    @Autowired
    private ManageUserFunctionService manageUserFunctionService;
    @Autowired
    private BusinessUserResourceService businessUserResourceService;
    @Autowired
    private BusinessCommunityService businessCommunityService;
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(BusinessUserQuery query) {	
		BaseBean baseBean = new BaseBean();
		Integer users = 0;
		Integer departments = 0;
		try{
			query.setSort("userId");
			query.setOrder("desc");
			Subject currentUser = SecurityUtils.getSubject();  
			if (currentUser.isPermitted("businessuser_add")) {  //新增员工功能展示会影响分页
				query.setRows(11);
			} else {  
				query.setRows(12);
			}
			//按机构类型查看各机构下的员工信息
			ShiroUser shiroUser = CommonUtils.getUser();
			if(!"".equals(shiroUser.getCurOrgType())) {//当前选择了部门，运营人员可以看到某部门内所有员工
				query.setOrgType(shiroUser.getCurOrgType());
				if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
					query.setCurEstateId(shiroUser.getCurEstateId());
				}
			}else{//当前没有选择部门 物业、驿站、社区报 只能看到本部门及负责范围内的所有员工 运营能看到所有运营的员工
				if(ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { //运营的员工不按社区查看
					query.setCurComId(0);//过滤掉社区查询条件，否则会出错
				}else{
					query.setCurUserId(shiroUser.getUserId());
					if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
						query.setCurComId(shiroUser.getCurComId());
					}
					if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
						query.setCurEstateId(shiroUser.getCurEstateId());
					}
				}				
				query.setOrgType(shiroUser.getOrgType());
			}
			
			baseBean = businessUserService.findAllPage(query);
			
			//获取员工数
			users = baseBean.getCount();
					
			//获取部门数
			BusinessDepartmentQuery departmentQuery = new BusinessDepartmentQuery();
			departmentQuery.setOrgType(shiroUser.getOrgType());
			departments = businessDepartmentService.selectCount(departmentQuery);
			
		}catch(Exception e){
			GSLogger.error("进入businessUser管理页时发生错误：/business/businessUser/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/businessUser/list");
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		mav.addObject("users", users);
		mav.addObject("departments", departments);
		return mav;
	}

    /**
     * 查询员工信息
     * @param query
     * @param response
     */
    @RequestMapping(value="getWorkerDetail")
    public void getWorkerDetail(BusinessUserQuery query, HttpServletResponse response) {
        String json = "";
        StringBuilder result = new StringBuilder();
        try{
            MemberVO businessUser = businessUserService.getWorkerInfo(query.getUserId());
            Map map = new HashMap();
            map.put("userId", query.getUserId());
            List<BusinessUserResource> list = businessUserResourceService.findByMap(map);
            StringBuilder sb = new StringBuilder("");
            Map<String, List> resourceMap = new HashMap();
            if(ModuleConst.PROPERTY_CODE.equals(businessUser.getOrgType())) {//物业员工
        		//小区-楼栋列表
            	resourceMap = getResourceByProperty(list);
            	for (Map.Entry<String, List> entry : resourceMap.entrySet()) {
            		sb.append(entry.getKey()).append(" : ");
            		List tempList = entry.getValue();
            		for(int j=0;j<tempList.size();j++) {
            			sb.append(tempList.get(j)).append(" | ");
            		}
            		sb.append("\\n\\r");
            	}
        	}else if(ModuleConst.STATION_CODE.equals(businessUser.getOrgType())) {//驿站员工
        		//小区列表
        		for(int j=0;j<list.size();j++) {
        			BusinessUserResource resource = list.get(j);
        			sb.append(resource.getEstateName()).append(" | ");
        		}
        	}else if(ModuleConst.COMMUNITY_CODE.equals(businessUser.getOrgType())) {//社区员工
        		//社区列表
        		resourceMap = getResourceByCommunity(list);
        		for (Map.Entry<String, List> entry : resourceMap.entrySet()) {
        			sb.append(entry.getValue()).append(" | ");
        		}
        	}else if(ModuleConst.OPERATION_CODE.equals(businessUser.getOrgType())){//运营员工
        		//无服务范围
        	}
/*            for(BusinessUserResource bur : list) {
                //楼 -> 单元
                if(!"".equals(bur.getUnitName())) {
                    sb.append(bur.getBuildingName()).append("：").append(bur.getUnitName()).append(" | ");
                } else {
                    sb.append(bur.getBuildingName()).append(" | ");
                }
            }*/
            Map map1 = new HashMap();
            map1.put("userId", query.getUserId());
            //权限
            List<ManageUserFunction> lists = manageUserFunctionService.findByMap(map1);
            StringBuilder sb1 = new StringBuilder();
            for(ManageUserFunction muf: lists) {
                sb1.append(muf.getFunctionName()).append(" | ");
            }
            //用户数量-通过员工负责楼栋来查询用户数
            int count = businessUserService.getManageUserCount(query.getUserId());

            result.append("{")
            .append("\"userId\":\"").append(businessUser.getUserId()).append("\"").append(",")
            .append("\"userName\":\"").append(businessUser.getUserName()).append("\"").append(",")
            .append("\"userTel\":\"").append(businessUser.getUserTel()).append("\"").append(",")
            .append("\"lastLoginTime\":\"").append(businessUser.getLastLoginTime()).append("\"").append(",")
            .append("\"userEmail\":\"").append(businessUser.getUserEmail()).append("\"").append(",")
            .append("\"userPhoto\":\"").append(businessUser.getUserPhoto()).append("\"").append(",")
            .append("\"userBrief\":\"").append(businessUser.getUserBrief()).append("\"").append(",")
            .append("\"posName\":\"").append(businessUser.getPosName()).append("\"").append(",")
            .append("\"modules\":\"").append(businessUser.getModules()).append("\"").append(",")
            .append("\"isManager\":\"").append(businessUser.getIsManager()).append("\"").append(",")
            .append("\"orgType\":\"").append(businessUser.getOrgType()).append("\"").append(",")
            .append("\"depName\":\"").append(businessUser.getDepName()).append("\"").append(",")
            .append("\"avatar\":\"").append(businessUser.getAvatar()).append("\"").append(",")
            .append("\"serviceScope\":\"").append(sb.toString()).append("\"").append(",")
            .append("\"auths\":\"").append(sb1.toString()).append("\"").append(",")
            .append("\"state\":\"").append(businessUser.getState()).append("\"").append(",")
            .append("\"userCount\":\"").append(count).append("\"")
            .append("}");
            json = result.toString();
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
            try {
                response.getWriter().write(json);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }catch(Exception e){
            GSLogger.error("显示businessUser列表时发生错误：/business/businessUser/list", e);
            e.printStackTrace();
        }
    }
    
    /**
     * 整理并翻译物业员工的服务范围
     * @return
     */
    private Map getResourceByProperty(List list) {
    	Map resourceMap = new HashMap();
    	for(int i=0;i<list.size();i++) {
    		BusinessUserResource resource = (BusinessUserResource) list.get(i);
    		if(resourceMap.containsKey(resource.getEstateName())) {//已包含小区了
    			List buildingList = (List) resourceMap.get(resource.getEstateName());
    			/*if(buildingList.size() == 0) {
    				buildingList = new ArrayList();
    			}*/
    			buildingList.add(resource.getBuildingName());
    		}else{//还没包含小区
    			List resourceList = new ArrayList();
    			resourceList.add(resource.getBuildingName());
    			resourceMap.put(resource.getEstateName(), resourceList);
    		}
    	}
    	return resourceMap;
    }
    
    /**
     * 整理并翻译社区员工的服务范围
     * @return
     */
    private Map getResourceByCommunity(List list) {
    	Map resourceMap = new HashMap();
    	for(int i=0;i<list.size();i++) {
    		BusinessUserResource resource = (BusinessUserResource) list.get(i);
    		if(!resourceMap.containsKey(resource.getComId())) {//未包含社区
    			BusinessCommunity com = businessCommunityService.findById(resource.getComId());
    			resourceMap.put(resource.getComId(), com.getComName());
    		}
    	}
    	return resourceMap;
    }
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessUserQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			query.setSort("userId");
			query.setOrder("desc");
			Subject currentUser = SecurityUtils.getSubject();  
			if (currentUser.isPermitted("businessuser_add")) {  //新增员工功能展示会影响分页
				query.setRows(11);
			} else {  
				query.setRows(12);
			}
			//按机构类型查看各机构下的员工信息
			ShiroUser shiroUser = CommonUtils.getUser();
			if(!"".equals(shiroUser.getCurOrgType())) {//当前选择了部门，运营人员可以看到某部门内所有员工
				query.setOrgType(shiroUser.getCurOrgType());
			}else{//当前没有选择部门 物业、驿站、社区报 只能看到本部门及负责范围内的所有员工 运营能看到所有运营的员工
				if(ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { //运营的员工不按社区查看
					query.setCurComId(0);//过滤掉社区查询条件，否则会出错
				}else{
					query.setCurUserId(shiroUser.getUserId());
					if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
						query.setCurComId(shiroUser.getCurComId());
					}
					if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
						query.setCurEstateId(shiroUser.getCurEstateId());
					}
				}				
				query.setOrgType(shiroUser.getOrgType());
			}
			
            BaseBean baseBean = businessUserService.findAllPage(query);
            result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
                    .append("\"rows\":[");
            for(int i=0;i<baseBean.getList().size();i++) {
                BusinessUser businessUser = (BusinessUser) baseBean.getList().get(i);
                result.append("{")
                        .append("\"userId\":\"").append(businessUser.getUserId()).append("\"").append(",")
                        .append("\"userName\":\"").append(businessUser.getUserName()).append("\"").append(",")
                        .append("\"userTel\":\"").append(businessUser.getUserTel()).append("\"").append(",")
                        .append("\"userPassword\":\"").append(businessUser.getUserPassword()).append("\"").append(",")
                        .append("\"userCode\":\"").append(businessUser.getUserCode()).append("\"").append(",")
                        .append("\"lastLoginTime\":\"").append(businessUser.getLastLoginTime()).append("\"").append(",")
                        .append("\"userEmail\":\"").append(businessUser.getUserEmail()).append("\"").append(",")
                        .append("\"userPhoto\":\"").append(businessUser.getUserPhoto()).append("\"").append(",")
                        .append("\"userBrief\":\"").append(businessUser.getUserBrief()).append("\"").append(",")
                        .append("\"userService\":\"").append(businessUser.getUserService()).append("\"").append(",")
                        .append("\"createTime\":\"").append(businessUser.getCreateTime()).append("\"").append(",")
                        .append("\"editTime\":\"").append(businessUser.getEditTime()).append("\"").append(",")
                        .append("\"editor\":\"").append(businessUser.getEditor()).append("\"").append(",")
                        .append("\"positionId\":\"").append(businessUser.getPositionId()).append("\"").append(",")
                        .append("\"posName\":\"").append(businessUser.getPosName()).append("\"").append(",")
                        .append("\"modules\":\"").append(businessUser.getModules()).append("\"").append(",")
                        .append("\"isCharge\":\"").append(businessUser.getIsCharge()).append("\"").append(",")
                        .append("\"orgType\":\"").append(businessUser.getOrgType()).append("\"").append(",")
                        .append("\"fromAddress\":\"").append(businessUser.getFromAddress()).append("\"").append(",")
                        .append("\"homeAddress\":\"").append(businessUser.getHomeAddress()).append("\"").append(",")
                        .append("\"sex\":\"").append(businessUser.getSex()).append("\"").append(",")
                        .append("\"age\":\"").append(businessUser.getAge()).append("\"").append(",")
                        .append("\"isMarriage\":\"").append(businessUser.getIsMarriage()).append("\"").append(",")
                        .append("\"hometown\":\"").append(businessUser.getHometown()).append("\"").append(",")
                        .append("\"nation\":\"").append(businessUser.getNation()).append("\"").append(",")
                        .append("\"nickname\":\"").append(businessUser.getNickname()).append("\"").append(",")
                        .append("\"avatar\":\"").append(businessUser.getAvatar()).append("\"").append(",")
                        .append("\"isManager\":\"").append(businessUser.getIsManager()).append("\"").append(",")
                        .append("\"isGirl\":\"").append(businessUser.getIsGirl()).append("\"").append(",")
                        .append("\"depName\":\"").append(businessUser.getDepName()).append("\"").append(",")
                        .append("\"state\":\"").append(businessUser.getState()).append("\"")
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
			GSLogger.error("显示businessUser列表时发生错误：/business/businessUser/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessUserQuery query) {	
		ModelAndView mav = null;
		String orgType = "";
		try{
			//当前用户标识
			ShiroUser shiroUser = CommonUtils.getUser();
			orgType = shiroUser.getOrgType();
			if(orgType.equals(ModuleConst.PROPERTY_CODE)) {//物业去物业添加页面 范围需要到楼栋
				mav = new ModelAndView("/module/businessUser/propertyAdd");
			}else if(orgType.equals(ModuleConst.STATION_CODE)){//驿站去驿站的增加页面 范围需要到小区
				mav = new ModelAndView("/module/businessUser/stationAdd");
			}else if(orgType.equals(ModuleConst.COMMUNITY_CODE)){//社区报去社区报的增加页面，社区报用户不用添加小区
				mav = new ModelAndView("/module/businessUser/communityAdd");
			}else{//运营去运营的增加页面，只添加运营下的用户
				mav = new ModelAndView("/module/businessUser/operationAdd");
			}
			mav.addObject("positionId", shiroUser.getPositionId());
		}catch(Exception e){
			GSLogger.error("进入businessUser新增页时发生错误：/business/businessUser/add", e);
			e.printStackTrace();
		}
		mav.addObject("orgType", orgType);
		return mav;
	}
	
	/**
	 * 进入修改页
	 * @return
	 */
	@RequestMapping(value="modify")
	public ModelAndView modify(BusinessUserQuery query) {	
		BusinessUser businessUser=new BusinessUser();
        List list = new ArrayList();
		try{
			businessUser = businessUserService.findById(query.getUserId()); //员工基础信息
            businessUser.setScope("-1"); //初始化范围
            businessUser.setRights("-1"); //初始化权限
            //员工管理范围 business_user_resource
            Map map = new HashMap();
            map.put("userId", query.getUserId());
            list = businessUserResourceService.findByMap(map);

		}catch(Exception e){
			GSLogger.error("进入businessUser修改页时发生错误：/business/businessUser/modify", e);
			e.printStackTrace();
		}
        ModelAndView mav = new ModelAndView();
        ShiroUser shiroUser = CommonUtils.getUser();
		String orgType = shiroUser.getOrgType();
		if(orgType.equals(ModuleConst.PROPERTY_CODE)) {//物业
			mav = new ModelAndView("/module/businessUser/propertyModify");
		}else if(orgType.equals(ModuleConst.STATION_CODE)){//驿站
			mav = new ModelAndView("/module/businessUser/stationModify");
		}else if(orgType.equals(ModuleConst.COMMUNITY_CODE) ){//社区报
			mav = new ModelAndView("/module/businessUser/communityModify");
			List comList = businessCommunityService.findComsByUser(query.getUserId());
			 mav.addObject("comList", comList);
		}else{//运营
			mav = new ModelAndView("/module/businessUser/operationModify");
		}
        mav.addObject("businessUser", businessUser);
        mav.addObject("resourceList", list);
		return mav;
	}
	
	/**
	 * 保存物业，驿站对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="saveProperty")
	public void saveProperty(HttpServletRequest request, HttpServletResponse response, BusinessUserQuery query) {
		BusinessUser businessUser = new BusinessUser();
		String json = "";
		try{
            //查询登录用户信息
            BusinessUser curUser = businessUserService.findById(getUser().getUserId());
            String orgType = curUser.getOrgType();
            String modules = curUser.getModules();

            businessUser.setUserName(query.getUserName());
            businessUser.setUserTel(query.getUserTel());
            businessUser.setUserPassword(query.getUserPassword());
            businessUser.setUserCode(query.getUserCode());
            //businessUser.setLastLoginTime(query.getLastLoginTime());
            businessUser.setUserEmail(query.getUserEmail());
            businessUser.setUserPhoto(query.getAnnoPic()); //照片
            businessUser.setUserBrief(query.getUserBrief());
            businessUser.setUserService(query.getUserService());
            businessUser.setComWord(query.getComWord());
            businessUser.setCreateTime(new Timestamp(System.currentTimeMillis()));
            businessUser.setEditTime(new Timestamp(System.currentTimeMillis()));
            businessUser.setEditor(getUser().getUserName());
            
            //businessUser.setModules(query.getModules());
            businessUser.setIsCharge(query.getIsCharge());
            businessUser.setFromAddress(query.getFromAddress());
            businessUser.setHomeAddress(query.getHomeAddress());
            businessUser.setSex(query.getSex());
            businessUser.setAge(query.getAge());
            businessUser.setIsMarriage(query.getIsMarriage());
            businessUser.setHometown(query.getHometown());
            businessUser.setNation(query.getNation());
            businessUser.setNickname(query.getNickname());
            businessUser.setAvatar((query.getAvatar()==null || query.getAvatar().equals(""))?"/images/icon/pic02.jpg":query.getAvatar());  //头像
            businessUser.setIsManager(query.getIsManager());
            businessUser.setIsGirl(0);
            businessUser.setState(query.getState());
            Timestamp  ts=new Timestamp(new Date().getTime());
            businessUser.setCreateTime(ts);
            businessUser.setEditTime(ts);
            businessUser.setLastLoginTime(ts);
		    businessUser.setModules(modules);
		    businessUser.setIsCharge(query.getIsCharge());
		    businessUser.setOrgId(getUser().getOrgId());
            businessUser.setOrgType(orgType);
            //保存职务 positionId
            BusinessPosition businessPosition = businessPositionService.findById(query.getPositionId());
            businessUser.setPositionId(businessPosition.getPositionId());
            businessUser.setPosName(businessPosition.getPositionName()); //职位名称
            businessUser.setDepId(businessPosition.getDepId()); //部门ID
            businessUser.setRightsInfo(query.getRightsInfo());
             //保存员工基础信息
			businessUserService.save(businessUser);
            //保存所有权限 manage_user_functon
            String right = query.getRights();
            String[] rights = right.split("\\,");
            for(String functionId : rights) {
                ManageUserFunction manageUserFunction = new ManageUserFunction();
                manageUserFunction.setUserId(businessUser.getUserId());
                manageUserFunction.setFunctionId(new Integer(functionId));
                //menuId
                ManageFunction manageFunction = manageFunctionService.findById(new Integer(functionId));
                int menuId = manageFunction.getMenuId();
                manageUserFunction.setMenuId(menuId);
                manageUserFunction.setModuleCode(orgType);
                manageUserFunction.setCreateTime(ts);
                manageUserFunction.setEditTime(ts);
                manageUserFunction.setEditor(getUser().getUserName());
                manageUserFunction.setFunctionName(manageFunction.getFunctionName());
                manageUserFunction.setFunctionCode(manageFunction.getFunctionCode());

                manageUserFunctionService.save(manageUserFunction);
            }
            //保存范围 business_user_resource
            //可取到 小区 楼栋和单元

            String scopeString = query.getScope();
            String[] rows = scopeString.split("\\,");
            for(String row : rows) {
                String estateId = "";
                String estateName = "";
                String buildingId = "";
                String buildingName = "";
                String unitId = "";
                String unitName = "";
                String[] attrs = row.split("\\&");
                for(String attr : attrs) {
                    String[] values = attr.split("\\|");
                    String param_id = ((values[0]).split("\\_"))[1]; //id
                    String param_name = values[1];                    //name
                    //小区
                    if(attr.indexOf("estate") == 0) {
                        estateId = param_id; //小区ID
                        estateName = param_name; //小区名称
                    }
                    //楼栋
                    else if(attr.indexOf("building") == 0) {
                        buildingId = param_id;
                        buildingName = param_name;
                    }
                    //单元
                    else if(attr.indexOf("unit") == 0) {
                        unitId = param_id;
                        unitName = param_name;
                    }
                }
                BusinessUserResource businessUserResource = new BusinessUserResource();
                businessUserResource.setUserId(businessUser.getUserId());
                if(!"".equals(estateId)) {
                    businessUserResource.setEstateId(Integer.parseInt(estateId));
                }
                businessUserResource.setEstateName(estateName);
                if(!"".equals(buildingId)) {
                    businessUserResource.setBuildingId(Integer.parseInt(buildingId));
                }
                businessUserResource.setBuildingName(buildingName);

                if(!"".equals(unitId)) {
                    businessUserResource.setUnitId(Integer.parseInt(unitId));
                }
                businessUserResource.setUnitName(unitName);
                businessUserResource.setCreateTime(ts);
                businessUserResourceService.save(businessUserResource);
            }

			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessUser信息时发生错误：/business/businessUser/save", e);
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
	 * 更新物业，驿站对象
	 * @param request
	 * @param businessUser
	 * @return
	 */
	@RequestMapping(value="updateProperty")
	public void updateProperty(HttpServletRequest request, HttpServletResponse response, BusinessUserQuery query) {
		String json = "";
		try{
            //查询登录用户信息
            BusinessUser businessUser = businessUserService.findById(query.getUserId());
            businessUser.setUserName(query.getUserName());
            businessUser.setUserTel(query.getUserTel());
            businessUser.setUserPassword(query.getUserPassword());
            businessUser.setUserCode(query.getUserCode());
            //businessUser.setLastLoginTime(query.getLastLoginTime());
            businessUser.setUserEmail(query.getUserEmail());
            businessUser.setUserPhoto(query.getAnnoPic()); //照片
            String avatar = query.getAvatar();
            if(avatar != null && !"".equals(avatar)) { //头像
            	if(!avatar.equals(businessUser.getAvatar())) {
            		File file = new File(avatar); 
            		if(file.exists()) {
            			file.delete();
            		}  
            		businessUser.setAvatar(query.getAvatar());
            	}
            }
            businessUser.setUserBrief(query.getUserBrief());
            businessUser.setUserService(query.getUserService());
            businessUser.setEditTime(new Timestamp(System.currentTimeMillis()));
            businessUser.setEditor(getUser().getUserName());
            businessUser.setIsCharge(query.getIsCharge());
            businessUser.setFromAddress(query.getFromAddress());
            businessUser.setHomeAddress(query.getHomeAddress());
            businessUser.setSex(query.getSex());
            businessUser.setComWord(query.getComWord());
            businessUser.setAge(query.getAge());
            businessUser.setIsMarriage(query.getIsMarriage());
            businessUser.setHometown(query.getHometown());
            businessUser.setNation(query.getNation());
            businessUser.setNickname(query.getNickname());
            //businessUser.setAvatar(query.getAvatar()); 
            businessUser.setIsManager(query.getIsManager());
            //businessUser.setIsGirl(query.getIsGirl());
            businessUser.setState(query.getState());
            Timestamp  ts=new Timestamp(new Date().getTime());
            businessUser.setEditTime(ts);
            businessUser.setOrgId(getUser().getOrgId());
            businessUser.setOrgType(getUser().getOrgType());
            BusinessPosition businessPosition = businessPositionService.findById(query.getPositionId());
            businessUser.setPositionId(businessPosition.getPositionId());
            businessUser.setPosName(businessPosition.getPositionName()); //职位名称
            businessUser.setDepId(businessPosition.getDepId()); //部门ID
            businessUser.setRightsInfo(query.getRightsInfo());
            String right = query.getRights();
            if(right != null && !"-1".equals(right)) {
            	businessUser.setRights(query.getRightsInfo());
            	//businessUser.setModules(query.getModules());
            	businessUser.setRightsInfo(query.getRightsInfo());
            }
			businessUserService.update(businessUser);

            //保存所有权限 manage_user_functon
            
            if(right != null && !"-1".equals(right)) {
                //删除旧权限
                manageUserFunctionService.deleteByUserId(businessUser.getUserId());
                //添加新权限
                String[] rights = right.split("\\,");
                for(String functionId : rights) {
                    ManageUserFunction manageUserFunction = new ManageUserFunction();
                    manageUserFunction.setUserId(businessUser.getUserId());
                    manageUserFunction.setFunctionId(new Integer(functionId));
                    //menuId
                    ManageFunction manageFunction = manageFunctionService.findById(new Integer(functionId));
                    int menuId = manageFunction.getMenuId();
                    manageUserFunction.setMenuId(menuId);
                    manageUserFunction.setModuleCode(getUser().getOrgType());
                    manageUserFunction.setCreateTime(ts);
                    manageUserFunction.setFunctionName(manageFunction.getFunctionName());
                    manageUserFunction.setFunctionCode(manageFunction.getFunctionCode());
                    manageUserFunction.setEditTime(ts);
                    manageUserFunction.setEditor(getUser().getUserName());
                    manageUserFunctionService.save(manageUserFunction);
                }
            }

            String scopeString = query.getScope();
            if(scopeString != null && !"-1".equals(scopeString)) {
                //删除旧范围
                businessUserResourceService.deleteByUserId(businessUser.getUserId());
                //保存范围 business_user_resource
                //可取到 小区 楼栋和单元
                String[] rows = scopeString.split("\\,");
                for(String row : rows) {
                    String[] attrs = row.split("\\&");
                    String estateId = "";
                    String estateName = "";
                    String buildingId = "";
                    String buildingName = "";
                    String unitId = "";
                    String unitName = "";
                    for(String attr : attrs) {
                        String[] values = attr.split("\\|");
                        String param_id = ((values[0]).split("\\_"))[1]; //id
                        String param_name = values[1];                    //name
                        //小区
                        if(attr.indexOf("estate") == 0) {
                            estateId = param_id; //小区ID
                            estateName = param_name; //小区名称
                        }
                        //楼栋
                        else if(attr.indexOf("building") == 0) {
                            buildingId = param_id;
                            buildingName = param_name;
                        }
                        //单元
                        else if(attr.indexOf("unit") == 0) {
                            unitId = param_id;
                            unitName = param_name;
                        }
                    }
                    BusinessUserResource businessUserResource = new BusinessUserResource();
                    businessUserResource.setUserId(businessUser.getUserId());
                    if(!"".equals(estateId)) {
                        businessUserResource.setEstateId(Integer.parseInt(estateId));
                    }
                    businessUserResource.setEstateName(estateName);
                    if(!"".equals(buildingId)) {
                        businessUserResource.setBuildingId(Integer.parseInt(buildingId));
                    }
                    businessUserResource.setBuildingName(buildingName);

                    if(!"".equals(unitId)) {
                        businessUserResource.setUnitId(Integer.parseInt(unitId));
                    }
                    businessUserResource.setUnitName(unitName);
                    businessUserResource.setCreateTime(ts);
                    businessUserResourceService.save(businessUserResource);
                }
            }

			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessUser信息时发生错误：/business/businessUser/update", e);
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
	 * 保存驿站对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="saveStation")
	public void saveStation(HttpServletRequest request, HttpServletResponse response, BusinessUserQuery query) {
		BusinessUser businessUser = new BusinessUser();
		String json = "";
		try{
            //查询登录用户信息
            BusinessUser curUser = businessUserService.findById(getUser().getUserId());
            String orgType = curUser.getOrgType();
            String modules = curUser.getModules();

            businessUser.setUserName(query.getUserName());
            businessUser.setUserTel(query.getUserTel());
            businessUser.setUserPassword(query.getUserPassword());
            businessUser.setUserCode(query.getUserCode());
            //businessUser.setLastLoginTime(query.getLastLoginTime());
            businessUser.setUserEmail(query.getUserEmail());
            businessUser.setUserPhoto(query.getAnnoPic()); //照片
            businessUser.setUserBrief(query.getUserBrief());
            businessUser.setUserService(query.getUserService());
            businessUser.setCreateTime(new Timestamp(System.currentTimeMillis()));
            businessUser.setEditTime(new Timestamp(System.currentTimeMillis()));
            businessUser.setEditor(getUser().getUserName());
            
            //businessUser.setModules(query.getModules());
            businessUser.setIsCharge(query.getIsCharge());
            businessUser.setFromAddress(query.getFromAddress());
            businessUser.setComWord(query.getComWord());
            businessUser.setHomeAddress(query.getHomeAddress());
            businessUser.setSex(query.getSex());
            businessUser.setAge(query.getAge());
            businessUser.setIsMarriage(query.getIsMarriage());
            businessUser.setHometown(query.getHometown());
            businessUser.setNation(query.getNation());
            businessUser.setNickname(query.getNickname());
            businessUser.setAvatar((query.getAvatar()==null || query.getAvatar().equals(""))?"/images/icon/pic02.jpg":query.getAvatar());  //头像
            //businessUser.setIsManager(0);
            businessUser.setIsGirl(query.getIsGirl());
            businessUser.setState(query.getState());
            Timestamp  ts=new Timestamp(new Date().getTime());
            businessUser.setCreateTime(ts);
            businessUser.setEditTime(ts);
            businessUser.setLastLoginTime(ts);
		    businessUser.setModules(modules);
		    businessUser.setIsCharge(query.getIsCharge());
		    businessUser.setOrgId(getUser().getOrgId());
            businessUser.setOrgType(orgType);
            //保存职务 positionId
            BusinessPosition businessPosition = businessPositionService.findById(query.getPositionId());
            businessUser.setPositionId(businessPosition.getPositionId());
            businessUser.setPosName(businessPosition.getPositionName()); //职位名称
            businessUser.setDepId(businessPosition.getDepId()); //部门ID
            businessUser.setRightsInfo(query.getRightsInfo());
             //保存员工基础信息
			businessUserService.save(businessUser);
            //保存所有权限 manage_user_functon
            String right = query.getRights();
            String[] rights = right.split("\\,");
            for(String functionId : rights) {
                ManageUserFunction manageUserFunction = new ManageUserFunction();
                manageUserFunction.setUserId(businessUser.getUserId());
                manageUserFunction.setFunctionId(new Integer(functionId));
                //menuId
                ManageFunction manageFunction = manageFunctionService.findById(new Integer(functionId));
                int menuId = manageFunction.getMenuId();
                manageUserFunction.setMenuId(menuId);
                manageUserFunction.setModuleCode(orgType);
                manageUserFunction.setCreateTime(ts);
                manageUserFunction.setEditTime(ts);
                manageUserFunction.setEditor(getUser().getUserName());
                manageUserFunction.setFunctionName(manageFunction.getFunctionName());
                manageUserFunction.setFunctionCode(manageFunction.getFunctionCode());

                manageUserFunctionService.save(manageUserFunction);
            }
            //保存范围 business_user_resource
            String scopeString = query.getScope();
            String[] rows = scopeString.split("\\,");
            for(String row : rows) {
                String estateId = "";
                String estateName = "";
                String buildingId = "";
                String buildingName = "";
                String unitId = "";
                String unitName = "";
                String[] attrs = row.split("\\&");
                for(String attr : attrs) {
                    String[] values = attr.split("\\|");
                    String param_id = ((values[0]).split("\\_"))[1]; //id
                    String param_name = values[1];                    //name
                    //小区
                    if(attr.indexOf("estate") == 0) {
                        estateId = param_id; //小区ID
                        estateName = param_name; //小区名称
                    }
                    //楼栋
                    else if(attr.indexOf("building") == 0) {
                        buildingId = param_id;
                        buildingName = param_name;
                    }
                    //单元
                    else if(attr.indexOf("unit") == 0) {
                        unitId = param_id;
                        unitName = param_name;
                    }
                }
                BusinessUserResource businessUserResource = new BusinessUserResource();
                businessUserResource.setUserId(businessUser.getUserId());
                if(!"".equals(estateId)) {
                    businessUserResource.setEstateId(Integer.parseInt(estateId));
                }
                businessUserResource.setEstateName(estateName);
                if(!"".equals(buildingId)) {
                    businessUserResource.setBuildingId(Integer.parseInt(buildingId));
                }
                businessUserResource.setBuildingName(buildingName);

                if(!"".equals(unitId)) {
                    businessUserResource.setUnitId(Integer.parseInt(unitId));
                }
                businessUserResource.setUnitName(unitName);
                businessUserResource.setCreateTime(ts);
                businessUserResourceService.save(businessUserResource);
            }

			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessUser信息时发生错误：/business/businessUser/save", e);
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
	 * 更新驿站对象
	 * @param request
	 * @param businessUser
	 * @return
	 */
	@RequestMapping(value="updateStation")
	public void updateStation(HttpServletRequest request, HttpServletResponse response, BusinessUserQuery query) {
		String json = "";
		try{
            //查询登录用户信息
            BusinessUser businessUser = businessUserService.findById(query.getUserId());
            businessUser.setUserName(query.getUserName());
            businessUser.setUserTel(query.getUserTel());
            businessUser.setUserPassword(query.getUserPassword());
            businessUser.setUserCode(query.getUserCode());
            //businessUser.setLastLoginTime(query.getLastLoginTime());
            businessUser.setUserEmail(query.getUserEmail());
            businessUser.setUserPhoto(query.getAnnoPic()); //照片
            String avatar = query.getAvatar();
            if(avatar != null && !"".equals(avatar)) { //头像
            	if(!avatar.equals(businessUser.getAvatar())) {
            		File file = new File(avatar); 
            		if(file.exists()) {
            			file.delete();
            		}  
            		businessUser.setAvatar(query.getAvatar());
            	}
            }
            businessUser.setUserBrief(query.getUserBrief());
            businessUser.setUserService(query.getUserService());
            businessUser.setEditTime(new Timestamp(System.currentTimeMillis()));
            businessUser.setEditor(getUser().getUserName());
            businessUser.setIsCharge(query.getIsCharge());
            businessUser.setFromAddress(query.getFromAddress());
            businessUser.setHomeAddress(query.getHomeAddress());
            businessUser.setSex(query.getSex());
            businessUser.setAge(query.getAge());
            businessUser.setIsMarriage(query.getIsMarriage());
            businessUser.setHometown(query.getHometown());
            businessUser.setNation(query.getNation());
            businessUser.setNickname(query.getNickname());
            businessUser.setComWord(query.getComWord());
            //businessUser.setAvatar(query.getAvatar()); 
            //businessUser.setIsManager(query.getIsManager());
            businessUser.setIsGirl(query.getIsGirl());
            businessUser.setState(query.getState());
            Timestamp  ts=new Timestamp(new Date().getTime());
            businessUser.setEditTime(ts);
            businessUser.setOrgId(getUser().getOrgId());
            businessUser.setOrgType(getUser().getOrgType());
            BusinessPosition businessPosition = businessPositionService.findById(query.getPositionId());
            businessUser.setPositionId(businessPosition.getPositionId());
            businessUser.setPosName(businessPosition.getPositionName()); //职位名称
            businessUser.setDepId(businessPosition.getDepId()); //部门ID
            String right = query.getRights();
            if(right != null && !"-1".equals(right)) {
            	businessUser.setRights(query.getRightsInfo());
            	//businessUser.setModules(query.getModules());
            	businessUser.setRightsInfo(query.getRightsInfo());
            }
			businessUserService.update(businessUser);

            //保存所有权限 manage_user_functon
            
            if(right != null && !"-1".equals(right)) {
                //删除旧权限
                manageUserFunctionService.deleteByUserId(businessUser.getUserId());
                //添加新权限
                String[] rights = right.split("\\,");
                for(String functionId : rights) {
                    ManageUserFunction manageUserFunction = new ManageUserFunction();
                    manageUserFunction.setUserId(businessUser.getUserId());
                    manageUserFunction.setFunctionId(new Integer(functionId));
                    //menuId
                    ManageFunction manageFunction = manageFunctionService.findById(new Integer(functionId));
                    int menuId = manageFunction.getMenuId();
                    manageUserFunction.setMenuId(menuId);
                    manageUserFunction.setModuleCode(getUser().getOrgType());
                    manageUserFunction.setCreateTime(ts);
                    manageUserFunction.setFunctionName(manageFunction.getFunctionName());
                    manageUserFunction.setFunctionCode(manageFunction.getFunctionCode());
                    manageUserFunction.setEditTime(ts);
                    manageUserFunction.setEditor(getUser().getUserName());
                    manageUserFunctionService.save(manageUserFunction);
                }
            }

            String scopeString = query.getScope();
            if(scopeString != null && !"-1".equals(scopeString)) {
                //删除旧范围
                businessUserResourceService.deleteByUserId(businessUser.getUserId());
                //保存范围 business_user_resource
                //可取到 小区 楼栋和单元
                String[] rows = scopeString.split("\\,");
                for(String row : rows) {
                    String[] attrs = row.split("\\&");
                    String estateId = "";
                    String estateName = "";
                    String buildingId = "";
                    String buildingName = "";
                    String unitId = "";
                    String unitName = "";
                    for(String attr : attrs) {
                        String[] values = attr.split("\\|");
                        String param_id = ((values[0]).split("\\_"))[1]; //id
                        String param_name = values[1];                    //name
                        //小区
                        if(attr.indexOf("estate") == 0) {
                            estateId = param_id; //小区ID
                            estateName = param_name; //小区名称
                        }
                        //楼栋
                        else if(attr.indexOf("building") == 0) {
                            buildingId = param_id;
                            buildingName = param_name;
                        }
                        //单元
                        else if(attr.indexOf("unit") == 0) {
                            unitId = param_id;
                            unitName = param_name;
                        }
                    }
                    BusinessUserResource businessUserResource = new BusinessUserResource();
                    businessUserResource.setUserId(businessUser.getUserId());
                    if(!"".equals(estateId)) {
                        businessUserResource.setEstateId(Integer.parseInt(estateId));
                    }
                    businessUserResource.setEstateName(estateName);
                    if(!"".equals(buildingId)) {
                        businessUserResource.setBuildingId(Integer.parseInt(buildingId));
                    }
                    businessUserResource.setBuildingName(buildingName);

                    if(!"".equals(unitId)) {
                        businessUserResource.setUnitId(Integer.parseInt(unitId));
                    }
                    businessUserResource.setUnitName(unitName);
                    businessUserResource.setCreateTime(ts);
                    businessUserResourceService.save(businessUserResource);
                }
            }

			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessUser信息时发生错误：/business/businessUser/update", e);
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
	 * 保存社区报对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="saveCommunity")
	public void saveCommunity(HttpServletRequest request, HttpServletResponse response, BusinessUserQuery query) {
		BusinessUser businessUser = new BusinessUser();
		String json = "";
		try{
            //查询登录用户信息
            BusinessUser curUser = businessUserService.findById(getUser().getUserId());
            String orgType = curUser.getOrgType();
            String modules = curUser.getModules();

            businessUser.setUserName(query.getUserName());
            businessUser.setUserTel(query.getUserTel());
            businessUser.setUserPassword(query.getUserPassword());
            businessUser.setUserCode(query.getUserCode());
            //businessUser.setLastLoginTime(query.getLastLoginTime());
            businessUser.setUserEmail(query.getUserEmail());
            businessUser.setUserPhoto(query.getAnnoPic()); //照片
            businessUser.setUserBrief(query.getUserBrief());
            businessUser.setUserService(query.getUserService());
            businessUser.setCreateTime(new Timestamp(System.currentTimeMillis()));
            businessUser.setEditTime(new Timestamp(System.currentTimeMillis()));
            businessUser.setEditor(getUser().getUserName());
            
            //businessUser.setModules(query.getModules());
            businessUser.setIsCharge(query.getIsCharge());
            businessUser.setFromAddress(query.getFromAddress());
            businessUser.setComWord(query.getComWord());
            businessUser.setHomeAddress(query.getHomeAddress());
            businessUser.setSex(query.getSex());
            businessUser.setAge(query.getAge());
            businessUser.setIsMarriage(query.getIsMarriage());
            businessUser.setHometown(query.getHometown());
            businessUser.setNation(query.getNation());
            businessUser.setNickname(query.getNickname());
            businessUser.setAvatar((query.getAvatar()==null || query.getAvatar().equals(""))?"/images/icon/pic02.jpg":query.getAvatar());  //头像
            businessUser.setIsManager(0);
            businessUser.setIsGirl(0);
            businessUser.setState(query.getState());
            Timestamp  ts=new Timestamp(new Date().getTime());
            businessUser.setCreateTime(ts);
            businessUser.setEditTime(ts);
            businessUser.setLastLoginTime(ts);
		    businessUser.setModules(modules);
		    businessUser.setIsCharge(query.getIsCharge());
		    businessUser.setOrgId(getUser().getOrgId());
            businessUser.setOrgType(orgType);
            //保存职务 positionId
            BusinessPosition businessPosition = businessPositionService.findById(query.getPositionId());
            businessUser.setPositionId(businessPosition.getPositionId());
            businessUser.setPosName(businessPosition.getPositionName()); //职位名称
            businessUser.setDepId(businessPosition.getDepId()); //部门ID
            businessUser.setRightsInfo(query.getRightsInfo());
             //保存员工基础信息
			businessUserService.save(businessUser);
            //保存所有权限 manage_user_functon
            String right = query.getRights();
            String[] rights = right.split("\\,");
            for(String functionId : rights) {
                ManageUserFunction manageUserFunction = new ManageUserFunction();
                manageUserFunction.setUserId(businessUser.getUserId());
                manageUserFunction.setFunctionId(new Integer(functionId));
                //menuId
                ManageFunction manageFunction = manageFunctionService.findById(new Integer(functionId));
                int menuId = manageFunction.getMenuId();
                manageUserFunction.setMenuId(menuId);
                manageUserFunction.setModuleCode(orgType);
                manageUserFunction.setCreateTime(ts);
                manageUserFunction.setEditTime(ts);
                manageUserFunction.setEditor(getUser().getUserName());
                manageUserFunction.setFunctionName(manageFunction.getFunctionName());
                manageUserFunction.setFunctionCode(manageFunction.getFunctionCode());

                manageUserFunctionService.save(manageUserFunction);
            }
            //保存范围 business_user_resource
            String scopeString = query.getScope();
            String[] rows = scopeString.split("\\,");
            for(String row : rows) {
                String comId = "";
                String comName = "";
                String[] attrs = row.split("\\&");
                for(String attr : attrs) {
                    String[] values = attr.split("\\|");
                    String param_id = ((values[0]).split("\\_"))[1]; //id
                    String param_name = values[1];                    //name
                    //小区
                    if(attr.indexOf("com") == 0) {
                    	comId = param_id; //社区ID
                    	comName = param_name; //社区名称
                    }
                }
                BusinessUserResource businessUserResource = new BusinessUserResource();
                businessUserResource.setUserId(businessUser.getUserId());
                if(!"".equals(comId)) {
                    businessUserResource.setComId(new Integer(comId));
                }        
                businessUserResource.setCreateTime(ts);
                businessUserResourceService.save(businessUserResource);
            }
            
            //BusinessUserResource businessUserResource = new BusinessUserResource();
            //businessUserResource.setUserId(businessUser.getUserId());
            //businessUserResource.setComId(getUser().getOrgId());//社区ID
            //businessUserResource.setCreateTime(ts);
            //businessUserResourceService.save(businessUserResource);

			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessUser信息时发生错误：/business/businessUser/save", e);
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
	 * 更新社区报对象
	 * @param request
	 * @param businessUser
	 * @return
	 */
	@RequestMapping(value="updateCommunity")
	public void updateCommunity(HttpServletRequest request, HttpServletResponse response, BusinessUserQuery query) {
		String json = "";
		try{
            //查询登录用户信息
            BusinessUser businessUser = businessUserService.findById(query.getUserId());
            businessUser.setUserName(query.getUserName());
            businessUser.setUserTel(query.getUserTel());
            businessUser.setUserPassword(query.getUserPassword());
            businessUser.setUserCode(query.getUserCode());
            //businessUser.setLastLoginTime(query.getLastLoginTime());
            businessUser.setUserEmail(query.getUserEmail());
            businessUser.setUserPhoto(query.getAnnoPic()); //照片
            String avatar = query.getAvatar();
            if(avatar != null && !"".equals(avatar)) { //头像
            	if(!avatar.equals(businessUser.getAvatar())) {
            		File file = new File(avatar); 
            		if(file.exists()) {
            			file.delete();
            		}  
            		businessUser.setAvatar(query.getAvatar());
            	}
            }
            businessUser.setUserBrief(query.getUserBrief());
            businessUser.setUserService(query.getUserService());
            businessUser.setEditTime(new Timestamp(System.currentTimeMillis()));
            businessUser.setEditor(getUser().getUserName());
            businessUser.setIsCharge(query.getIsCharge());
            businessUser.setFromAddress(query.getFromAddress());
            businessUser.setHomeAddress(query.getHomeAddress());
            businessUser.setSex(query.getSex());
            businessUser.setAge(query.getAge());
            businessUser.setIsMarriage(query.getIsMarriage());
            businessUser.setHometown(query.getHometown());
            businessUser.setNation(query.getNation());
            businessUser.setComWord(query.getComWord());
            businessUser.setNickname(query.getNickname());
            //businessUser.setAvatar(query.getAvatar()); 
            businessUser.setIsManager(query.getIsManager());
            businessUser.setIsGirl(query.getIsGirl());
            businessUser.setState(query.getState());
            Timestamp  ts=new Timestamp(new Date().getTime());
            businessUser.setEditTime(ts);
            businessUser.setOrgId(getUser().getOrgId());
            businessUser.setOrgType(getUser().getOrgType());
            BusinessPosition businessPosition = businessPositionService.findById(query.getPositionId());
            businessUser.setPositionId(businessPosition.getPositionId());
            businessUser.setPosName(businessPosition.getPositionName()); //职位名称
            businessUser.setDepId(businessPosition.getDepId()); //部门ID
            businessUser.setRightsInfo(query.getRightsInfo());
            String right = query.getRights();
            if(right != null && !"-1".equals(right)) {
            	businessUser.setRights(query.getRightsInfo());
            	//businessUser.setModules(query.getModules());
            	businessUser.setRightsInfo(query.getRightsInfo());
            }
			businessUserService.update(businessUser);

            //保存所有权限 manage_user_functon
            
            if(right != null && !"-1".equals(right)) {
                //删除旧权限
                manageUserFunctionService.deleteByUserId(businessUser.getUserId());
                //添加新权限
                String[] rights = right.split("\\,");
                for(String functionId : rights) {
                    ManageUserFunction manageUserFunction = new ManageUserFunction();
                    manageUserFunction.setUserId(businessUser.getUserId());
                    manageUserFunction.setFunctionId(new Integer(functionId));
                    //menuId
                    ManageFunction manageFunction = manageFunctionService.findById(new Integer(functionId));
                    int menuId = manageFunction.getMenuId();
                    manageUserFunction.setMenuId(menuId);
                    manageUserFunction.setModuleCode(getUser().getOrgType());
                    manageUserFunction.setCreateTime(ts);
                    manageUserFunction.setFunctionName(manageFunction.getFunctionName());
                    manageUserFunction.setFunctionCode(manageFunction.getFunctionCode());
                    manageUserFunction.setEditTime(ts);
                    manageUserFunction.setEditor(getUser().getUserName());
                    manageUserFunctionService.save(manageUserFunction);
                }
            }

            String scopeString = query.getScope();
            if(scopeString != null && !"-1".equals(scopeString)) {
                //删除旧范围
                businessUserResourceService.deleteByUserId(businessUser.getUserId());
                //保存范围 business_user_resource
                String[] rows = scopeString.split("\\,");
                for(String row : rows) {
                    String comId = "";
                    String comName = "";
                    String[] attrs = row.split("\\&");
                    for(String attr : attrs) {
                        String[] values = attr.split("\\|");
                        String param_id = ((values[0]).split("\\_"))[1]; //id
                        String param_name = values[1];                    //name
                        //小区
                        if(attr.indexOf("com") == 0) {
                        	comId = param_id; //社区ID
                        	comName = param_name; //社区名称
                        }
                    }
                    BusinessUserResource businessUserResource = new BusinessUserResource();
                    businessUserResource.setUserId(businessUser.getUserId());
                    if(!"".equals(comId)) {
                        businessUserResource.setComId(new Integer(comId));
                    }        
                    businessUserResource.setCreateTime(ts);
                    businessUserResourceService.save(businessUserResource);
                }
            }

			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessUser信息时发生错误：/business/businessUser/update", e);
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
	 * 保存运营对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="saveOperation")
	public void saveOperation(HttpServletRequest request, HttpServletResponse response, BusinessUserQuery query) {
		BusinessUser businessUser = new BusinessUser();
		String json = "";
		try{
            //查询登录用户信息
            BusinessUser curUser = businessUserService.findById(getUser().getUserId());
            String orgType = curUser.getOrgType();
            String modules = curUser.getModules();

            businessUser.setUserName(query.getUserName());
            businessUser.setUserTel(query.getUserTel());
            businessUser.setUserPassword(query.getUserPassword());
            businessUser.setUserCode(query.getUserCode());
            //businessUser.setLastLoginTime(query.getLastLoginTime());
            businessUser.setUserEmail(query.getUserEmail());
            businessUser.setUserPhoto(query.getAnnoPic()); //照片
            businessUser.setUserBrief(query.getUserBrief());
            businessUser.setUserService(query.getUserService());
            businessUser.setCreateTime(new Timestamp(System.currentTimeMillis()));
            businessUser.setEditTime(new Timestamp(System.currentTimeMillis()));
            businessUser.setEditor(getUser().getUserName());
            
            //businessUser.setModules(query.getModules());
            businessUser.setIsCharge(query.getIsCharge());
            businessUser.setFromAddress(query.getFromAddress());
            businessUser.setComWord(query.getComWord());
            businessUser.setHomeAddress(query.getHomeAddress());
            businessUser.setSex(query.getSex());
            businessUser.setAge(query.getAge());
            businessUser.setIsMarriage(query.getIsMarriage());
            businessUser.setHometown(query.getHometown());
            businessUser.setNation(query.getNation());
            businessUser.setNickname(query.getNickname());
            businessUser.setAvatar((query.getAvatar()==null || query.getAvatar().equals(""))?"/images/icon/pic02.jpg":query.getAvatar());  //头像
            businessUser.setIsManager(query.getIsManager());
            businessUser.setIsGirl(query.getIsGirl());
            businessUser.setState(query.getState());
            Timestamp  ts=new Timestamp(new Date().getTime());
            businessUser.setCreateTime(ts);
            businessUser.setEditTime(ts);
            businessUser.setLastLoginTime(ts);
		    businessUser.setModules(modules);
		    businessUser.setIsCharge(query.getIsCharge());
		    businessUser.setOrgId(getUser().getOrgId());
            businessUser.setOrgType(orgType);
            //保存职务 positionId
            BusinessPosition businessPosition = businessPositionService.findById(query.getPositionId());
            businessUser.setPositionId(businessPosition.getPositionId());
            businessUser.setPosName(businessPosition.getPositionName()); //职位名称
            businessUser.setDepId(businessPosition.getDepId()); //部门ID
            businessUser.setRightsInfo(query.getRightsInfo());
             //保存员工基础信息
			businessUserService.save(businessUser);
            //保存所有权限 manage_user_functon
            String right = query.getRights();
            String[] rights = right.split("\\,");
            for(String functionRight : rights) {
            	String[] ids = functionRight.split("_");
                ManageUserFunction manageUserFunction = new ManageUserFunction();
                manageUserFunction.setUserId(businessUser.getUserId());
                manageUserFunction.setFunctionId(new Integer(ids[1]));
                //menuId
                ManageFunction manageFunction = manageFunctionService.findById(new Integer(ids[1]));
                int menuId = manageFunction.getMenuId();
                manageUserFunction.setMenuId(menuId);
                manageUserFunction.setModuleCode(ModuleConst.getModuleCode(new Integer(ids[0])));
                manageUserFunction.setCreateTime(ts);
                manageUserFunction.setEditTime(ts);
                manageUserFunction.setEditor(getUser().getUserName());
                manageUserFunction.setFunctionName(manageFunction.getFunctionName());
                manageUserFunction.setFunctionCode(manageFunction.getFunctionCode());

                manageUserFunctionService.save(manageUserFunction);
            }
            //保存范围 business_user_resource
            //可取到 小区 楼栋和单元

            /*String scopeString = query.getScope();
            String[] rows = scopeString.split("\\,");
            for(String row : rows) {
                String estateId = "";
                String estateName = "";
                String buildingId = "";
                String buildingName = "";
                String unitId = "";
                String unitName = "";
                String[] attrs = row.split("\\&");
                for(String attr : attrs) {
                    String[] values = attr.split("\\|");
                    String param_id = ((values[0]).split("\\_"))[1]; //id
                    String param_name = values[1];                    //name
                    //小区
                    if(attr.indexOf("estate") == 0) {
                        estateId = param_id; //小区ID
                        estateName = param_name; //小区名称
                    }
                    //楼栋
                    else if(attr.indexOf("building") == 0) {
                        buildingId = param_id;
                        buildingName = param_name;
                    }
                    //单元
                    else if(attr.indexOf("unit") == 0) {
                        unitId = param_id;
                        unitName = param_name;
                    }
                }
                BusinessUserResource businessUserResource = new BusinessUserResource();
                businessUserResource.setUserId(businessUser.getUserId());
                if(!"".equals(estateId)) {
                    businessUserResource.setEstateId(Integer.parseInt(estateId));
                }
                businessUserResource.setEstateName(estateName);
                if(!"".equals(buildingId)) {
                    businessUserResource.setBuildingId(Integer.parseInt(buildingId));
                }
                businessUserResource.setBuildingName(buildingName);

                if(!"".equals(unitId)) {
                    businessUserResource.setUnitId(Integer.parseInt(unitId));
                }
                businessUserResource.setUnitName(unitName);
                businessUserResource.setCreateTime(ts);
                businessUserResourceService.save(businessUserResource);
            }*/

			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessUser信息时发生错误：/business/businessUser/save", e);
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
	 * 更新运营对象
	 * @param request
	 * @param businessUser
	 * @return
	 */
	@RequestMapping(value="updateOperation")
	public void updateOperation(HttpServletRequest request, HttpServletResponse response, BusinessUserQuery query) {
		String json = "";
		try{
            //查询登录用户信息
            BusinessUser businessUser = businessUserService.findById(query.getUserId());
            businessUser.setUserName(query.getUserName());
            businessUser.setUserTel(query.getUserTel());
            businessUser.setUserPassword(query.getUserPassword());
            businessUser.setUserCode(query.getUserCode());
            //businessUser.setLastLoginTime(query.getLastLoginTime());
            businessUser.setUserEmail(query.getUserEmail());
            businessUser.setUserPhoto(query.getAnnoPic()); //照片
            String avatar = query.getAvatar();
            if(avatar != null && !"".equals(avatar)) { //头像
            	if(!avatar.equals(businessUser.getAvatar())) {
            		File file = new File(avatar); 
            		if(file.exists()) {
            			file.delete();
            		}  
            		businessUser.setAvatar(query.getAvatar());
            	}
            }
            businessUser.setUserBrief(query.getUserBrief());
            businessUser.setUserService(query.getUserService());
            businessUser.setEditTime(new Timestamp(System.currentTimeMillis()));
            businessUser.setEditor(getUser().getUserName());
            businessUser.setIsCharge(query.getIsCharge());
            businessUser.setFromAddress(query.getFromAddress());
            businessUser.setHomeAddress(query.getHomeAddress());
            businessUser.setSex(query.getSex());
            businessUser.setAge(query.getAge());
            businessUser.setIsMarriage(query.getIsMarriage());
            businessUser.setHometown(query.getHometown());
            businessUser.setNation(query.getNation());
            businessUser.setNickname(query.getNickname());
            //businessUser.setAvatar(query.getAvatar()); 
            businessUser.setIsManager(query.getIsManager());
            businessUser.setComWord(query.getComWord());
            businessUser.setIsGirl(query.getIsGirl());
            businessUser.setState(query.getState());
            Timestamp  ts=new Timestamp(new Date().getTime());
            businessUser.setEditTime(ts);
            businessUser.setOrgId(getUser().getOrgId());
            businessUser.setOrgType(getUser().getOrgType());
            BusinessPosition businessPosition = businessPositionService.findById(query.getPositionId());
            businessUser.setPositionId(businessPosition.getPositionId());
            businessUser.setPosName(businessPosition.getPositionName()); //职位名称
            businessUser.setDepId(businessPosition.getDepId()); //部门ID
            businessUser.setRightsInfo(query.getRightsInfo());
            String right = query.getRights();
            if(right != null && !"-1".equals(right)) {
            	businessUser.setRights(query.getRightsInfo());
            	//businessUser.setModules(query.getModules());
            	businessUser.setRightsInfo(query.getRightsInfo());
            }
			businessUserService.update(businessUser);

            //保存所有权限 manage_user_functon
            
            if(right != null && !"-1".equals(right)) {
                //删除旧权限
                manageUserFunctionService.deleteByUserId(businessUser.getUserId());
                //添加新权限
                String[] rights = right.split("\\,");
                for(String functionRight : rights) {
                	String[] ids = functionRight.split("_");
                    ManageUserFunction manageUserFunction = new ManageUserFunction();
                    manageUserFunction.setUserId(businessUser.getUserId());
                    manageUserFunction.setFunctionId(new Integer(ids[1]));
                    //menuId
                    ManageFunction manageFunction = manageFunctionService.findById(new Integer(ids[1]));
                    int menuId = manageFunction.getMenuId();
                    manageUserFunction.setMenuId(menuId);
                    manageUserFunction.setModuleCode(ModuleConst.getModuleCode(new Integer(ids[0])));
                    manageUserFunction.setCreateTime(ts);
                    manageUserFunction.setEditTime(ts);
                    manageUserFunction.setEditor(getUser().getUserName());
                    manageUserFunction.setFunctionName(manageFunction.getFunctionName());
                    manageUserFunction.setFunctionCode(manageFunction.getFunctionCode());

                    manageUserFunctionService.save(manageUserFunction);
                }
            }

            /*String scopeString = businessUser.getScope();
            if(scopeString != null && !"".equals(scopeString)) {
                //删除旧范围
                businessUserResourceService.deleteByUserId(businessUser.getUserId());
                //保存范围 business_user_resource
                //可取到 小区 楼栋和单元
                String[] rows = scopeString.split("\\,");
                for(String row : rows) {
                    String[] attrs = row.split("\\&");
                    String estateId = "";
                    String estateName = "";
                    String buildingId = "";
                    String buildingName = "";
                    String unitId = "";
                    String unitName = "";
                    for(String attr : attrs) {
                        String[] values = attr.split("\\|");
                        String param_id = ((values[0]).split("\\_"))[1]; //id
                        String param_name = values[1];                    //name
                        //小区
                        if(attr.indexOf("estate") == 0) {
                            estateId = param_id; //小区ID
                            estateName = param_name; //小区名称
                        }
                        //楼栋
                        else if(attr.indexOf("building") == 0) {
                            buildingId = param_id;
                            buildingName = param_name;
                        }
                        //单元
                        else if(attr.indexOf("unit") == 0) {
                            unitId = param_id;
                            unitName = param_name;
                        }
                    }
                    BusinessUserResource businessUserResource = new BusinessUserResource();
                    businessUserResource.setUserId(businessUser.getUserId());
                    if(!"".equals(estateId)) {
                        businessUserResource.setEstateId(Integer.parseInt(estateId));
                    }
                    businessUserResource.setEstateName(estateName);
                    if(!"".equals(buildingId)) {
                        businessUserResource.setBuildingId(Integer.parseInt(buildingId));
                    }
                    businessUserResource.setBuildingName(buildingName);

                    if(!"".equals(unitId)) {
                        businessUserResource.setUnitId(Integer.parseInt(unitId));
                    }
                    businessUserResource.setUnitName(unitName);
                    businessUserResource.setCreateTime(ts);
                    businessUserResourceService.save(businessUserResource);
                }
            }*/

			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessUser信息时发生错误：/business/businessUser/update", e);
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
						businessUserService.delete(new Integer(ids[i]));
					}
				}else{
					businessUserService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessUser时发生错误：/business/businessUser/delete", e);
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
	 * 获取某用户所属结构下的部门列表
	 * @param response
	 */
	@RequestMapping(value="getDepartmentsByUser")
	public void getDepartmentsByUser(HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		try{
			ShiroUser shiroUser = getUser();
			BusinessPosition businessPosition = businessPositionService.findById(shiroUser.getPositionId());
			//判断是哪种结构并获取该结构下的部门列表
			Map paramMap = new HashMap();
			paramMap.put("orgType", shiroUser.getOrgType());
			List depList = businessDepartmentService.findByMap(paramMap);
			
			JSONArray arr = new JSONArray();
			JSONObject obj = null;
			for(int i=0;i<depList.size();i++) {
				BusinessDepartment department = (BusinessDepartment) depList.get(i);
				obj = new JSONObject();
				obj.put("id", "department_"+department.getDepId());
				obj.put("text", department.getDepName());
				//obj.put("iconCls", "icon-save");
				obj.put("state", "open");
				arr.add(obj);
			}
			//String[] dateFormats = new String[] {"yyyy-MM-dd HH:mm:ss"};    
			//JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
			
			jsonObj.put("success", true);
			jsonObj.put("result", arr);
		}catch(Exception e){
			jsonObj.put("success", false);
			jsonObj.put("message", "获取失败");
			GSLogger.error("删除BusinessUser时发生错误：/business/businessUser/delete", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(jsonObj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取某用户所属结构下的部门列表
	 * @param response
	 */
	@RequestMapping(value="getDepartmentListByUser")
	public void getDepartmentListByUser(HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		try{
			ShiroUser shiroUser = getUser();
			BusinessPosition businessPosition = businessPositionService.findById(shiroUser.getPositionId());
			//判断是哪种结构并获取该结构下的部门列表
			Map paramMap = new HashMap();
			paramMap.put("orgType", shiroUser.getOrgType());
			List depList = businessDepartmentService.findByMap(paramMap);
			
			JSONArray arr = new JSONArray();
			JSONObject obj = null;
			for(int i=0;i<depList.size();i++) {
				BusinessDepartment department = (BusinessDepartment) depList.get(i);
				obj = new JSONObject();
				obj.put("depId", department.getDepId());
				obj.put("depName", department.getDepName());
				arr.add(obj);
			}
			//String[] dateFormats = new String[] {"yyyy-MM-dd HH:mm:ss"};    
			//JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
			
			jsonObj.put("success", true);
			jsonObj.put("result", arr);
		}catch(Exception e){
			jsonObj.put("success", false);
			jsonObj.put("message", "获取失败");
			GSLogger.error("删除BusinessUser时发生错误：/business/businessUser/getDepartmentListByUser", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(jsonObj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取部门下的职位
	 * @param response
	 */
	@RequestMapping(value="getPositionByDep")
	public void getPositionByDep(@RequestParam(value="depId") String depId, HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		JSONArray arr = new JSONArray();
		try{
			Map paramMap = new HashMap();
			paramMap.put("depId", depId);
			paramMap.put("parentId", 0);
			List posList = businessPositionService.findByMap(paramMap);
			
			JSONObject obj = null;
			for(int i=0;i<posList.size();i++) {
				BusinessPosition position = (BusinessPosition) posList.get(i);
				obj = new JSONObject();
				obj.put("id", "position_"+position.getPositionId());
				obj.put("text", position.getPositionName());
				obj.put("state", "close");
				arr.add(obj);
			}
			jsonObj.put("success", true);
			jsonObj.put("result", arr);
		}catch(Exception e){
			jsonObj.put("success", false);
			jsonObj.put("message", "获取失败");
			GSLogger.error("获取部门下的职位时发生错误：/business/businessUser/getPositionByDep", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(jsonObj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取下级一级职位
	 * @param response
	 */
	@RequestMapping(value="getPositionByParent")
	public void getPositionByParent(@RequestParam(value="positionId") Integer positionId, HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		JSONArray arr = new JSONArray();
		try{
			Map paramMap = new HashMap();
			paramMap.put("parentId", positionId);
			List posList = businessPositionService.findByMap(paramMap);
			
			JSONObject obj = null;
			for(int i=0;i<posList.size();i++) {
				BusinessPosition position = (BusinessPosition) posList.get(i);
				obj = new JSONObject();
				obj.put("id", "position_"+position.getPositionId());
				obj.put("text", position.getPositionName());
				obj.put("state", "open");
				arr.add(obj);
			}
			jsonObj.put("success", true);
			jsonObj.put("result", arr);
		}catch(Exception e){
			jsonObj.put("success", false);
			jsonObj.put("message", "获取失败");
			GSLogger.error("获取下级职位时发生错误：/business/businessUser/getPositionByParent", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(jsonObj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 递归获取下级所有职位
	 * @param response
	 */
	@RequestMapping(value="getRecursionPositionByParent")
	public void getRecursionPositionByParent(HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		JSONArray arr = new JSONArray();
		try{
			Integer positionId = CommonUtils.getUser().getPositionId();
			Map paramMap = new HashMap();
			paramMap.put("parentId", positionId);
			List posList = businessPositionService.findByMap(paramMap);
			for(int i=0;i<posList.size();i++) {
				BusinessPosition pos = (BusinessPosition) posList.get(i);
				arr.add(subPositions(pos.getPositionId()));
			}
			
			jsonObj.put("success", true);
			jsonObj.put("result", arr);
		}catch(Exception e){
			jsonObj.put("success", false);
			jsonObj.put("message", "获取失败");
			GSLogger.error("获取下级职位时发生错误：/business/businessUser/getRecursionPositionByParent", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(jsonObj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private JSONArray subPositions(Integer positionId) {
		JSONArray positionArray = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		BusinessPosition parent = businessPositionService.findById(positionId);
		if(parent != null) {
			jsonObj = new JSONObject();
			jsonObj.put("id", "position_"+parent.getPositionId());
			jsonObj.put("text", parent.getPositionName());
			jsonObj.put("state", "open");
			positionArray.add(jsonObj);
			Map map = new HashMap();
			map.put("parentId", positionId);
			List subList = businessPositionService.findByMap(map); 
			if(subList != null && subList.size() > 0) {
				JSONArray subArray = new JSONArray();
				for(int i=0;i<subList.size();i++) {
					BusinessPosition sub = (BusinessPosition) subList.get(i);
					jsonObj = new JSONObject();
					jsonObj.put("id", "position_"+sub.getPositionId());
					jsonObj.put("text", sub.getPositionName());
					jsonObj.put("state", "close");
					subArray.add(jsonObj);
				}
				jsonObj.put("children", subArray);
				//递归加入职位
				for(int i=0;i<subList.size();i++) {
					BusinessPosition sub = (BusinessPosition) subList.get(i);
					subPositions(sub.getPositionId());
				}
				
			}
		}
		return positionArray;
	}
	
	/**
	 * 获取用户所在机构管理的小区或者樓棟
	 * @param response
	 */
	@RequestMapping(value="getBuildingsByUser")
	public void getBuildingsByUser(HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		JSONArray arr = new JSONArray();
		try{
			ShiroUser shiroUser = getUser();
			List estateList = null;
			JSONObject estateObj = null;
			Map paramMap = new HashMap();
			if(ModuleConst.COMMUNITY_CODE.equals(shiroUser.getOrgType())) {//社区 不选择小区
				//paramMap.put("comId", shiroUser.getOrgId());
				//estateList = manageEstateService.findByMap(paramMap);
				estateList = shiroUser.getEstateBeanList();
				for(int i=0;i<estateList.size();i++) {
					EstateBean estate = (EstateBean) estateList.get(i);
					estateObj = new JSONObject();
					estateObj.put("id", "estate_"+estate.getEstateId());
					estateObj.put("text", estate.getEstateName());
					estateObj.put("checkbox", true);
					//obj.put("state", "close");
					arr.add(estateObj);
				}
			}else if(ModuleConst.PROPERTY_CODE.equals(shiroUser.getOrgType())) {//物业 获取到楼栋
				//paramMap.put("proId", shiroUser.getOrgId());
				//estateList = manageEstateService.findByMap(paramMap);
				
				/*for(int i=0;i<estateList.size();i++) {
					ManageEstate estate = (ManageEstate) estateList.get(i);
					estateObj = new JSONObject();
					estateObj.put("id", "estate_"+estate.getEstateId());
					estateObj.put("text", estate.getEstateName());
					estateObj.put("checkbox", true);
					estateObj.put("state", "open");
					paramMap = new HashMap();
					paramMap.put("estateId", estate.getEstateId());
					List buildingList = manageBuildingService.findByMap(paramMap);
					JSONArray buildingArr = new JSONArray();
					for(int j=0;j<buildingList.size();j++) {
						JSONObject buildingObj = new JSONObject();
						ManageBuilding manageBuilding = (ManageBuilding) buildingList.get(j);
						buildingObj.put("id", "building_"+manageBuilding.getBuildingId());
						buildingObj.put("text", manageBuilding.getBuildingName());

						//装载单元
						paramMap = new HashMap();
						paramMap.put("buildingId", manageBuilding.getBuildingId());
						List unitList = manageUnitService.findByMap(paramMap);
						JSONObject unitObj = null;
						JSONArray unitArr = new JSONArray();
						for(int k=0;k<unitList.size();k++) {
							ManageUnit unit = (ManageUnit) unitList.get(k);
							unitObj = new JSONObject();
							unitObj.put("id", "unit_"+unit.getUnitId());
							unitObj.put("text", unit.getUnitName());
							unitObj.put("state", "closed");
							unitArr.add(unitObj);
						}
						if(unitArr.size() > 0) {
							buildingObj.put("state", "open");
							buildingObj.put("children", unitArr);
						}else{
							buildingObj.put("state", "closed");
						}	
						buildingObj.put("state", "closed");
						buildingArr.add(buildingObj);
					}
					estateObj.put("children", buildingArr);
					arr.add(estateObj);
				}*/
				arr = getBuildingTreeArray(shiroUser.getUserId());
			}else if(ModuleConst.STATION_CODE.equals(shiroUser.getOrgType())) {//驿站 选择小区
				paramMap.put("userId", shiroUser.getUserId());
				//estateList = manageEstateService.findByMap(paramMap);
				List userResourceList = businessUserResourceService.findByMap(paramMap);
				for(int i=0;i<userResourceList.size();i++) {
					BusinessUserResource userResource = (BusinessUserResource) userResourceList.get(i);
					estateObj = new JSONObject();
					estateObj.put("id", "estate_"+userResource.getEstateId());
					estateObj.put("text", userResource.getEstateName());
					/*estateObj.put("state", "open");
					paramMap = new HashMap();
					paramMap.put("estateId", estate.getEstateId());
					List buildingList = manageBuildingService.findByMap(paramMap);
					JSONArray buildingArr = new JSONArray();
					for(int j=0;j<buildingList.size();j++) {
						JSONObject buildingObj = new JSONObject();
						ManageBuilding manageBuilding = (ManageBuilding) buildingList.get(j);
						buildingObj.put("id", "building_"+manageBuilding.getBuildingId());
						buildingObj.put("text", manageBuilding.getBuildingName());
						
						//装载单元
						paramMap = new HashMap();
						paramMap.put("buildingId", manageBuilding.getBuildingId());
						List unitList = manageUnitService.findByMap(paramMap);
						JSONObject unitObj = null;
						JSONArray unitArr = new JSONArray();
						for(int k=0;k<unitList.size();k++) {
							ManageUnit unit = (ManageUnit) unitList.get(k);
							unitObj = new JSONObject();
							unitObj.put("id", "unit_"+unit.getUnitId());
							unitObj.put("text", unit.getUnitName());
							unitObj.put("state", "closed");
							unitArr.add(unitObj);
						}
						if(unitArr.size() > 0) {
							buildingObj.put("state", "open");
							buildingObj.put("children", unitArr);
						}else{
							buildingObj.put("state", "closed");
						}	
						buildingArr.add(buildingObj);
					}
					estateObj.put("children", buildingArr);*/
					arr.add(estateObj);
				}
			}//运营不选择小区
		
			jsonObj.put("success", true);
			jsonObj.put("result", arr);
		}catch(Exception e){
			jsonObj.put("success", false);
			jsonObj.put("message", "获取失败");
			GSLogger.error("获取用户所在机构管理的小区的楼栋：/business/businessUser/getBuildingsByUser", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(jsonObj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 按用户查询并组织某个员工管理的楼栋数组
	 * @param moduleId
	 * @return
	 */
	private JSONArray getBuildingTreeArray(Integer userId) {
		//获取某用户在某模块下的所有功能权限记录
		Map paramMap = new HashMap();
		paramMap.put("userId", userId);
		List userResourceList = businessUserResourceService.findByMap(paramMap);
		JSONArray buildingArr = new JSONArray();
		JSONObject buildingObj = null;
		Map menuMap = new HashMap();
		//拼装 菜单-功能 权限结构
		for(int i=0;i<userResourceList.size();i++) {
			BusinessUserResource resource = (BusinessUserResource) userResourceList.get(i);
			if(buildingArr.size() > 0) {//已有结点
				boolean hasEstate = false;
				for(int j=0;j<buildingArr.size();j++) {//遍历数组
					JSONObject estateObject = buildingArr.getJSONObject(j);
					if(estateObject.get("id").equals("estate_"+resource.getEstateId())) {//如果已存在该小区结点
						hasEstate = true;
						JSONArray estateArray = null;
						//查看该小区下的childrne数组是否存在，如果存在则加入楼栋结点，如果不存在则创建数组再加入结点
						if(estateObject.get("children") != null) {
							estateArray = (JSONArray) estateObject.get("children");
						}else{
							estateArray = new JSONArray();
							estateObject.put("children", estateArray);
						}
						buildingObj = new JSONObject();
						buildingObj.put("id", "building_"+resource.getBuildingId());
						buildingObj.put("text", resource.getBuildingName());
						//obj.put("iconCls", "icon-save");
						buildingObj.put("state", "closed");
						estateArray.add(buildingObj);
					}
				}
				if(!hasEstate) {
					//如果不存在该小区结点，则创建新小区结点
					//并创建功能数组并将功能加入该数组放到小区结点中
					//并加入到最终的小区数组中
					JSONObject estateObj = new JSONObject();
					estateObj.put("id", "estate_"+resource.getEstateId());
					estateObj.put("text", resource.getEstateName());
					//obj.put("iconCls", "icon-save");
					estateObj.put("state", "open");
					//创建功能数组
					JSONArray buildingArray = new JSONArray();
					buildingObj = new JSONObject();
					buildingObj.put("id", "building_"+resource.getBuildingId());
					buildingObj.put("text", resource.getBuildingName());
					//obj.put("iconCls", "icon-save");
					buildingObj.put("state", "closed");
					buildingArray.add(buildingObj);
					//放入小区对象
					estateObj.put("children", buildingArray);
					//把小区放入小区对象
					buildingArr.add(estateObj);
				}
			}else{//没有结点
				JSONObject estateObj = new JSONObject();
				estateObj.put("id", "estate_"+resource.getEstateId());
				estateObj.put("text", resource.getEstateName());
				//obj.put("iconCls", "icon-save");
				estateObj.put("state", "open");
				//创建功能数组
				JSONArray estateArray = new JSONArray();
				buildingObj = new JSONObject();
				buildingObj.put("id", "building_"+resource.getBuildingId());
				buildingObj.put("text", resource.getBuildingName());
				//obj.put("iconCls", "icon-save");
				buildingObj.put("state", "closed");
				estateArray.add(buildingObj);
				//放入菜单对象
				estateObj.put("children", estateArray);
				//把菜单放入菜单对象
				buildingArr.add(estateObj);
			}
		}
		return buildingArr;
	}
	
	/**
	 * 获得楼栋下的单元
	 * @param buildingId
	 * @param response
	 */
	@RequestMapping(value="getUnitsByBuilding")
	public void getUnitsByBuilding(@RequestParam(value="buildingId") String buildingId, HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		JSONArray arr = new JSONArray();
		try{
			Map paramMap = new HashMap();
			paramMap.put("buildingId", buildingId);
			List unitList = manageUnitService.findByMap(paramMap);
			
			JSONObject obj = null;
			for(int i=0;i<unitList.size();i++) {
				ManageUnit unit = (ManageUnit) unitList.get(i);
				obj = new JSONObject();
				obj.put("id", "unit_"+unit.getUnitId());
				obj.put("text", unit.getUnitName());
				obj.put("checkbox", true);
				obj.put("state", "close");
				arr.add(obj);
			}
			jsonObj.put("success", true);
			jsonObj.put("result", arr);
		}catch(Exception e){
			jsonObj.put("success", false);
			jsonObj.put("message", "获取失败");
			GSLogger.error("获得楼栋下的单元时发生错误：/business/businessUser/getUnitsByBuilding", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(jsonObj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取某用户所属结构下的权限列表
	 * @param response
	 */
	@RequestMapping(value="getRightsByUser")
	public void getRightsByUser(HttpServletResponse response) {
		JSONObject moduleObj = new JSONObject();
		JSONArray moduleArr = new JSONArray();
		try{
			ShiroUser shiroUser = getUser();
			Map paramMap = new HashMap();
			List moduleList = null;
			//如果是运营，则需要将4个模块都拼进树结构里
			if(ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) {
				String[] modules = {
						ModuleConst.OPERATION_CODE,
						ModuleConst.PROPERTY_CODE,
						ModuleConst.STATION_CODE,
						ModuleConst.COMMUNITY_CODE
				};
				for(int i=0;i<modules.length;i++) {
					String moduleName = modules[i];
					paramMap.put("moduleCode", moduleName);
					moduleList = manageModuleService.findByMap(paramMap);
					if(moduleList != null && moduleList.size() > 0 ) {
						ManageModule module = (ManageModule) moduleList.get(0);
						moduleObj = new JSONObject();
						moduleObj.put("id", "module_"+module.getModuleId());
						moduleObj.put("text", module.getModuleName());
						//obj.put("iconCls", "icon-save");
						moduleObj.put("state", "open");
						//moduleObj.put("children", getFunctionTreeArray(module.getModuleId()));
						moduleObj.put("children", getOwnFunctionTreeArray(module.getModuleId()));
						moduleArr.add(moduleObj);
					}
				}
				
			}else{
				paramMap.put("moduleCode", shiroUser.getOrgType());
				moduleList = manageModuleService.findByMap(paramMap);
				if(moduleList != null && moduleList.size() > 0 ) {
					ManageModule module = (ManageModule) moduleList.get(0);
					moduleObj = new JSONObject();
					moduleObj.put("id", "module_"+module.getModuleId());
					moduleObj.put("text", module.getModuleName());
					//obj.put("iconCls", "icon-save");
					moduleObj.put("state", "open");
					//moduleObj.put("children", getFunctionTreeArray(module.getModuleId()));
					moduleObj.put("children", getOwnFunctionTreeArray(module.getModuleId()));
					moduleArr.add(moduleObj);
				}
			}
			//jsonObj.put("success", true);
			//jsonObj.put("result", arr);
		}catch(Exception e){
			//jsonObj.put("success", false);
			//jsonObj.put("message", "获取失败");
			GSLogger.error("删除BusinessUser时发生错误：/business/businessUser/delete", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(moduleArr.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * 按模块ID查询并组织某个员工拥有得功能权限数组
	 * @param moduleId
	 * @return
	 */
	private JSONArray getOwnFunctionTreeArray(Integer moduleId) {
		//获取某用户在某模块下的所有功能权限记录
		Map paramMap = new HashMap();
		paramMap.put("moduleCode", ModuleConst.getModuleCode(moduleId));
		paramMap.put("userId", getUser().getUserId());
		List userFunctionList = manageUserFunctionService.findByMap(paramMap);
		JSONArray functionArr = new JSONArray();
		JSONObject functionObj = null;
		Map menuMap = new HashMap();
		//拼装 菜单-功能 权限结构
		for(int i=0;i<userFunctionList.size();i++) {
			ManageUserFunction function = (ManageUserFunction) userFunctionList.get(i);
			if(functionArr.size() > 0) {//已有结点
				boolean hasMenu = false;
				for(int j=0;j<functionArr.size();j++) {//遍历数组
					JSONObject menuObject = functionArr.getJSONObject(j);
					if(menuObject.get("id").equals("menu_"+function.getMenuId())) {//如果已存在该菜单结点
						hasMenu = true;
						JSONArray funArray = null;
						//查看该菜单下的childrne数组是否存在，如果存在则加入功能权限结点，如果不存在则创建数组再加入结点
						boolean hasFunction = false;
						if(menuObject.get("children") != null) {
							funArray = (JSONArray) menuObject.get("children");
							for(int k=0;k<funArray.size();k++) {
								JSONObject funObj = funArray.getJSONObject(k);
								if(funObj.get("id").equals("function_"+function.getFunctionId())) {
									hasFunction = true;
								}
							}
						}else{
							funArray = new JSONArray();
							menuObject.put("children", funArray);
						}
						if(!hasFunction) {
							functionObj = new JSONObject();
							functionObj.put("id", "function_"+function.getFunctionId());
							functionObj.put("text", function.getFunctionName());
							//obj.put("iconCls", "icon-save");
							functionObj.put("state", "closed");
							funArray.add(functionObj);
						}
					}
				}
				if(!hasMenu) {
					//如果不存在该菜单结点，则创建新菜单结点
					//并创建功能数组并将功能加入该数组放到菜单结点中
					//并加入到最终的菜单数组中
					JSONObject menuObj = new JSONObject();
					menuObj.put("id", "menu_"+function.getMenuId());
					BusinessMenu businessMenu = businessMenuService.findById(function.getMenuId());
					menuObj.put("text", businessMenu.getName());
					//obj.put("iconCls", "icon-save");
					menuObj.put("state", "open");
					//创建功能数组
					JSONArray functionArray = new JSONArray();
					functionObj = new JSONObject();
					functionObj.put("id", "function_"+function.getFunctionId());
					functionObj.put("text", function.getFunctionName());
					//obj.put("iconCls", "icon-save");
					functionObj.put("state", "closed");
					functionArray.add(functionObj);
					//放入菜单对象
					menuObj.put("children", functionArray);
					//把菜单放入菜单对象
					functionArr.add(menuObj);
				}
			}else{//没有结点
				JSONObject menuObj = new JSONObject();
				menuObj.put("id", "menu_"+function.getMenuId());
				BusinessMenu businessMenu = businessMenuService.findById(function.getMenuId());
				menuObj.put("text", businessMenu.getName());
				//obj.put("iconCls", "icon-save");
				menuObj.put("state", "open");
				//创建功能数组
				JSONArray menuArray = new JSONArray();
				functionObj = new JSONObject();
				functionObj.put("id", "function_"+function.getFunctionId());
				functionObj.put("text", function.getFunctionName());
				//obj.put("iconCls", "icon-save");
				functionObj.put("state", "closed");
				menuArray.add(functionObj);
				//放入菜单对象
				menuObj.put("children", menuArray);
				//把菜单放入菜单对象
				functionArr.add(menuObj);
			}
		}
		return functionArr;
	}
	
	/**
	 * 按模块ID组织功能权限数组
	 * @param moduleId
	 * @return
	 */
	private JSONArray getFunctionTreeArray(Integer moduleId) {
		List menuList = businessMenuService.findMenuByModuleId(moduleId);
		JSONArray menuArr = new JSONArray();
		JSONObject menuObj = null;
		//装载菜单
		for(int i=0;i<menuList.size();i++) {
			BusinessMenu menu = (BusinessMenu) menuList.get(i);
			menuObj = new JSONObject();
			menuObj.put("id", "menu_"+menu.getMenuId());
			menuObj.put("text", menu.getName());
			//obj.put("iconCls", "icon-save");
			menuObj.put("state", "open");
			
			//装载权限功能
			JSONArray functionArr = new JSONArray();
			JSONObject functionObj = null;
			Map paramMap = new HashMap();
			paramMap.put("menuId", menu.getMenuId());
			List functionList = manageFunctionService.findByMap(paramMap);
			for(int j=0;j<functionList.size();j++) {
				ManageFunction function = (ManageFunction) functionList.get(j);
				functionObj = new JSONObject();
				functionObj.put("id", "function_"+function.getFunctionId());
				functionObj.put("text", function.getFunctionName());
				//obj.put("iconCls", "icon-save");
				functionObj.put("state", "closed");
				functionArr.add(functionObj);
			}
			menuObj.put("children", functionArr);
			
			menuArr.add(menuObj);
		}
		return menuArr;
	}
	
	/**
	 * 更新员工密码对象
	 * @param request
	 * @param businessUser
	 * @return
	 */
	@RequestMapping(value="updateUserPassword")
	public void updateUserPassword(HttpServletRequest request, HttpServletResponse response, BusinessUserQuery query) {
		String json = "";
		try{
            //查询登录用户信息
            BusinessUser businessUser = businessUserService.findById(getUser().getUserId());
            if((query.getNewpassword() != null || !"".equals(query.getNewpassword())) && (query.getValipassword() != null || !"".equals(query.getValipassword()))) {
            	if(query.getNewpassword().equals(query.getValipassword())) {
            		businessUser.setUserPassword(query.getNewpassword());
        			businessUserService.update(businessUser);
        			json = "{\"success\":\"true\",\"message\":\"修改密码成功\"}";
            	}else {
                	json = "{\"success\":\"false\",\"message\":\"修改密码失败\"}";
        			GSLogger.error("编辑businessUser信息时发生错误：/business/businessUser/update", "两次输入密码不一致");
                }
            } else {
            	json = "{\"success\":\"false\",\"message\":\"修改密码失败\"}";
    			GSLogger.error("编辑businessUser信息时发生错误：/business/businessUser/update", "密码不能为空");
            }
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"修改密码失败\"}";
			GSLogger.error("编辑businessUser信息时发生错误：/business/businessUser/update", e);
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
	 * 賬號郵箱查重
	 * @param id
	 * @return
	 */
	/*@RequestMapping(value="checkEmailExist")
	public void checkEmailExist(@RequestParam(value="userEmail") String userEmail, HttpServletResponse response) {
		String json = "";
		try{
			if(userEmail != null && !"".equals(userEmail)) {
				Map paramMap = new HashMap();
				paramMap.put("userEmail", userEmail);
				List list = businessUserService.findByMap(paramMap);
				if(list.size() > 0) {
					json = "{\"success\":\"false\",\"message\":\"该邮箱已存在！\"}";
				}else{
					json = "{\"success\":\"true\",\"message\":\"该邮箱不存在！\"}";
				}
			}
		}catch(Exception e){
			GSLogger.error("賬號郵箱查重时发生错误：/business/businessUser/checkEmailExist", e);
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
	}*/
	
	/**
	 * 检查邮箱是否存在
	 * @param id
	 * @return
	 */
	@RequestMapping(value="checkEmailExist")
	public void checkEmailExist(HttpServletRequest request, HttpServletResponse response, BusinessUserQuery query) {
		String json = "";
		response.setContentType("text/html");
		if(query.getUserId() != 0) {
			BusinessUser businessUser = businessUserService.findById(query.getUserId());
			if(businessUser.getUserEmail().equals(query.getUserEmail())){
				json = "true";
			} else {
				Map paramMap = new HashMap();
				paramMap.put("userEmail", query.getUserEmail());
				List list = businessUserService.findByMap(paramMap);
				json = list.size()>0 ? "false" : "true";
			}
		}else {
			Map paramMap = new HashMap();
			paramMap.put("userEmail", query.getUserEmail());
			List list = businessUserService.findByMap(paramMap);
			json = list.size()>0 ? "false" : "true";
		}        
        try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取用户展示的所有社区列表
	 * @param response
	 */
	@RequestMapping(value="getComsScopeTree")
	public void getComsScopeTree(HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		JSONArray comArr = new JSONArray();
		
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			//获取该用户负责的多社区范围
			List comList = businessCommunityService.findComsByUser(shiroUser.getUserId());
			JSONObject comObj = null;
			Map paramMap = null;
			for(int i=0;i<comList.size();i++) {
				BusinessCommunity community = (BusinessCommunity) comList.get(i);
				comObj = new JSONObject();
				paramMap = new HashMap();
				paramMap.put("comId", community.getComId());
				List estateList = manageEstateService.findByMap(paramMap); 
				if(estateList.size() > 0){
					comObj.put("id", "com_"+community.getComId());
					comObj.put("text", community.getComName());
					comArr.add(comObj);
				}				
			}
			// }
			jsonObj.put("success", true);
			jsonObj.put("result", comArr);
		}catch(Exception e){
			jsonObj.put("success", false);
			jsonObj.put("message", "获取失败");
			GSLogger.error("获取用户的所有社区：/business/businessUser/getComsScopeTree", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(jsonObj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param request
	 * @param businessUser
	 * @return
	 */
	@RequestMapping(value="checkExistNickName")
	public void checkExistNickName(HttpServletRequest request, HttpServletResponse response, BusinessUserQuery query) {
		String json = "";
		int count = 0;
		response.setContentType("text/html");
		if(query.getUserId() != 0) {
			BusinessUser businessUser = businessUserService.findById(query.getUserId());
			if(businessUser.getNickname().equals(query.getNickname())){
				json = "true";
			} else {
				count = businessUserService.checkExistNickName(query.getNickname());
				json = count>0 ? "false" : "true";
			}
		}else {
			count = businessUserService.checkExistNickName(query.getNickname());
			json = count>0 ? "false" : "true";
		}        
        try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}