package com.community.service.estate;



/**
 * 小区相关处理接口
 * 包括：
 * 
 * @author whh-2_000
 *
 */

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.vo.BaseBean;


import com.community.app.module.vo.AppEstateUserQuery;
import com.community.app.module.vo.ManageBuildingQuery;
import com.community.app.module.vo.ManageEstateQuery;
import com.community.app.module.bean.AppEstateUser;
import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.BusinessAnno;
import com.community.app.module.bean.BusinessCommunity;
import com.community.app.module.bean.ManageBuilding;
import com.community.app.module.bean.ManageEstate;
import com.community.app.module.bean.ManageUnit;
import com.community.app.module.service.AppEstateUserService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessAnnoService;
import com.community.app.module.service.ManageBuildingService;
import com.community.app.module.service.ManageEstateService;
import com.community.app.module.service.ManageUnitService;
import com.community.app.module.vo.BusinessAnnoQuery;


@Controller
@RequestMapping("/service/estate")
public class EstateController {
	private static Logger GSLogger = LoggerFactory.getLogger(EstateController.class);
	@Autowired
	private ManageEstateService manageEstateService;
	
	@Autowired
	private ManageBuildingService manageBuildingService;
	
	@Autowired
	private ManageUnitService manageUnitService;
	@Autowired
	private AppEstateUserService appEstateUserService;
	@Autowired
	private AppUserService appUserService;
	
	
	/**
	 * 用户按小区关键字搜索小区列表
	 * @param keyword
	 * @return
	 * json
	 */
	@RequestMapping(value="search")
	public void search(HttpServletRequest request, HttpServletResponse response,ManageEstateQuery query) {
		List<ManageEstate> list;
		String json = "";
		try{
			list=manageEstateService.search(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"estateList\":[";
			for (ManageEstate manageEstate : list) {
				json += "{\"estateId\":\""+manageEstate.getEstateId()+"\",\"estateName\":\""+manageEstate.getEstateName()+"\",";
				json += "\"comName\":\""+manageEstate.getComName()+"\",\"areaName\":\""+manageEstate.getCountyName()+"\",";
				json += "\"cityName\":\""+manageEstate.getCityName()+"\",\"comId\":\""+manageEstate.getComId()+"\","
						+ "\"stationId\":\""+manageEstate.getStationId()+"\",\"staName\":\""+manageEstate.getStaName()+"\","
						+ "\"comName\":\""+manageEstate.getComName()+"\"},";
			}
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			
			json += "{";
			json += "\"errorCode\":400,";
			json += "\"message\":\"获取失败\"";
			json += "}";
			GSLogger.error("进入businessCommunity管理页时发生错误：/business/businessCommunity/enter", e);
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
	 * 用户按小区关键字搜索小区列表
	 * @param keyword
	 * @return
	 * html
	 */
	@RequestMapping(value="searchIndex")
	public ModelAndView searchIndex(HttpServletRequest request, HttpServletResponse response,ManageEstateQuery query) {
		ModelAndView mav = new ModelAndView("/service/estate");
		List<ManageEstate> list;
		try{
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
			list=manageEstateService.search(query);		
			mav.addObject("ctx", ctx);
			mav.addObject("list", list);
			mav.addObject("ID", request.getParameter("ID"));
			mav.addObject("type", request.getParameter("type"));
		}catch(Exception e){
			GSLogger.error("搜索小区发送错误", e);
			e.printStackTrace();
		}	
		return mav;
	}
	
	/**
	 * 根据APP传回的用户当前坐标搜索附近的小区列表并返回
	 * @param keyword
	 * @return
	 * json
	 */
	@RequestMapping(value="findByPos")
	public void findByPos(HttpServletRequest request, HttpServletResponse response,ManageEstateQuery query) {
		List<ManageEstate> list;
		String json = "";
		try{
			query.setEstateLatitude(query.getLatitude());
			query.setEstateLongitude(query.getLongitude());
			list=manageEstateService.findByExample(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"estateList\":[";
			for (ManageEstate manageEstate : list) {
				json += "{\"estateId\":\""+manageEstate.getEstateId()+"\",\"estateName\":\""+manageEstate.getEstateName()+"\",";
				json += "\"comName\":\""+manageEstate.getComName()+"\",\"areaName\":\""+manageEstate.getCountyName()+"\",";
				json += "\"cityName\":\""+manageEstate.getCityName()+"\",\"comId\":\""+manageEstate.getComId()+"\","
						+ "\"stationId\":\""+manageEstate.getStationId()+"\",\"staName\":\""+manageEstate.getStaName()+"\","
						+ "\"comName\":\""+manageEstate.getComName()+"\"},";
			}
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
			GSLogger.error("进入businessCommunity管理页时发生错误：/business/businessCommunity/enter", e);
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
	 * 用户获取小区楼栋和单元接口
	 * @param keyword
	 * @return
	 * json
	 */
	@RequestMapping(value="getBuildingUnitByEstateId")
	public void getBuildingUnitByEstateId(HttpServletRequest request, HttpServletResponse response,ManageBuildingQuery query) {
		String json = "";
		try{
			List<ManageBuilding> buildingList = manageBuildingService.findByExample(query);
			List<ManageUnit> unitList = manageUnitService.getUnitByEstateId(query.getEstateId());
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"list\":[";
			for (ManageBuilding manageBuilding : buildingList) {
				json += "{\"buildingId\":\""+manageBuilding.getBuildingId()+"\",\"name\":\""+manageBuilding.getBuildingName()+"\",";
				json += "\"units\":[";
				int count = 0;
				for (ManageUnit manageUnit : unitList) {
					if(manageUnit.getBuildingId()==manageBuilding.getBuildingId()){
						json += "{\"unitId\":\""+manageUnit.getUnitId()+"\",\"name\":\""+manageUnit.getUnitName()+"\"},";
						count++;
					}
				}
				if(count > 0) {
					json = json.substring(0, json.length()-1);
				}
				json += "]";
				json += "},";
			}
			if(buildingList.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":400,";
			json += "\"message\":\"获取失败\"";
			json += "}";
			GSLogger.error("进入businessCommunity管理页时发生错误：/business/businessCommunity/enter", e);
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
	 * 用户查看小区列表
	 * @param keyword
	 * @return
	 * json
	 */
	@RequestMapping(value="getUserEstate")
	public void getUserEstate(HttpServletRequest request, HttpServletResponse response,AppEstateUserQuery query) {
		String json = "";
		try{
			List<AppEstateUser> list = appEstateUserService.findByUserId(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"list\":[";
			for (AppEstateUser appEstateUser : list) {
				json +="{\"estateId\":\""+appEstateUser.getEstateId()+"\",\"estateName\":\""+appEstateUser.getEstateName()+"\",\"estateImg\":\""+appEstateUser.getIcon()+"\"";
				if(appEstateUser.getEstateId().equals(appEstateUser.getDefaultEstateId())){
					json +=",\"type\":\"1\"";
				}else {
					json +=",\"type\":\"0\"";
				}
				json +="},";
				
			}
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":400,";
			json += "\"message\":\"获取失败\"";
			json += "}";
			GSLogger.error("用户查看小区列表管理页时发生错误", e);
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
	 * 用户使用切换小区
	 * @param keyword
	 * @return
	 * json
	 */
	@RequestMapping(value="switchEtate")
	public void switchEtate(HttpServletRequest request, HttpServletResponse response,AppEstateUserQuery query) {
		String json = "";
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			List<AppEstateUser> list = appEstateUserService.findByUserId(query);
			if (list!=null && list.size()!=0) {
				
				AppUser appUser = new AppUser();
				appUser.setUserId(query.getUserId());
				appUser.setEstateId(list.get(0).getEstateId());
				appUser.setEstateName(list.get(0).getEstateName());
				appUser.setEditTime(ts);
				appUserService.update(appUser);
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"切换成功\"";
				json += "}";
			}else {
				json += "{";
				json += "\"errorCode\":400,";
				json += "\"message\":\"切换失败\"";
				json += "}";
			}
			
		}catch(Exception e){
			
			json += "{";
			json += "\"errorCode\":400,";
			json += "\"message\":\"切换失败\"";
			json += "}";
			GSLogger.error("进入用户使用小区时发生错误", e);
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
	 * 用户删除小区
	 * @param keyword
	 * @return
	 * json
	 */
	@RequestMapping(value="deleteEtate")
	public void deleteEtate(HttpServletRequest request, HttpServletResponse response,AppEstateUserQuery query) {
		String json = "";
		try{
			List<AppEstateUser> list = appEstateUserService.findByUserId(query);
			if (list!=null && list.size()!=0) {
				if(!list.get(0).getEstateId().equals(list.get(0).getDefaultEstateId())){
					appEstateUserService.delete(list.get(0).getEstMemId());
					json += "{";
					json += "\"errorCode\":\"200\",";
					json += "\"message\":\"删除成功\"";
					json += "}";
				}else {
					json += "{";
					json += "\"errorCode\":400,";
					json += "\"message\":\"不能删除当前小区\"";
					json += "}";
				}
				
			}else {
				json = "";
				json += "{";
				json += "\"errorCode\":400,";
				json += "\"message\":\"删除小区不存在\"";
				json += "}";
			}
			
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":400,";
			json += "\"message\":\"删除失败\"";
			json += "}";
			GSLogger.error("用户删除小区时发生错误", e);
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
	 * 用户使用添加小区
	 * @param keyword
	 * @return
	 * json
	 */
	@RequestMapping(value="addEtate")
	public void addEtate(HttpServletRequest request, HttpServletResponse response,AppEstateUserQuery query) {
		String json = "";
		try{
			List<AppEstateUser> list = appEstateUserService.findByUserId(query);
			if (list==null || list.size()==0) {
				Timestamp  ts=new Timestamp(new Date().getTime());
				AppEstateUser appEstateUser = new AppEstateUser();
				appEstateUser.setEstateId(query.getEstateId());
				appEstateUser.setUserId(query.getUserId());
				appEstateUser.setCreateTime(ts);
				appEstateUser.setEditTime(ts);
				appEstateUserService.save(appEstateUser);
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"添加成功\"";
				json += "}";
			}else {
				json = "";
				json += "{";
				json += "\"errorCode\":400,";
				json += "\"message\":\"重复添加\"";
				json += "}";
			}
			
			
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":400,";
			json += "\"message\":\"添加失败\"";
			json += "}";
			GSLogger.error("用户使用添加小区时发生错误", e);
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
	 * 用户使用变更小区
	 * @param keyword
	 * @return
	 * json
	 */
	@RequestMapping(value="editEtate")
	public void editEtate(HttpServletRequest request, HttpServletResponse response,AppEstateUserQuery query) {
		String json = "";
		try{
			json = appEstateUserService.update_app(query);
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":400,";
			json += "\"message\":\"变更失败\"";
			json += "}";
			GSLogger.error("用户使用变更小区时发生错误", e);
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
