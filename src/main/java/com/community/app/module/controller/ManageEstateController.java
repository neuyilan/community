package com.community.app.module.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.BusinessCommunity;
import com.community.app.module.bean.BusinessProperty;
import com.community.app.module.bean.BusinessStation;
import com.community.app.module.bean.ManageEstate;
import com.community.app.module.service.BusinessCommunityService;
import com.community.app.module.service.BusinessPropertyService;
import com.community.app.module.service.BusinessStationService;
import com.community.app.module.service.ManageEstateService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.ManageEstateQuery;

@Controller
@RequestMapping("/manage/manageEstate")
public class ManageEstateController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageEstateController.class);
	@Autowired
	private ManageEstateService manageEstateService;
	@Autowired
	private BusinessCommunityService businessCommunityService;
	@Autowired
	private BusinessStationService businessStationService;
	@Autowired
	private BusinessPropertyService businessPropertyService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageEstate管理页时发生错误：/manage/manageEstate/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageEstate/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(ManageEstateQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = manageEstateService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				ManageEstate manageEstate = (ManageEstate) baseBean.getList().get(i);
				result.append("{")
			    .append("\"estateId\":\"").append(manageEstate.getEstateId()).append("\"").append(",")
			    .append("\"estateName\":\"").append(manageEstate.getEstateName()).append("\"").append(",")
			    .append("\"estateDesc\":\"").append(manageEstate.getEstateDesc()).append("\"").append(",")
			    .append("\"estateAddress\":\"").append(manageEstate.getEstateAddress()).append("\"").append(",")
			    .append("\"estateMap\":\"").append(manageEstate.getEstateMap()).append("\"").append(",")
			    .append("\"estateLongitude\":\"").append(manageEstate.getEstateLongitude()).append("\"").append(",")
			    .append("\"estateLatitude\":\"").append(manageEstate.getEstateLatitude()).append("\"").append(",")
			    .append("\"estateCarMap\":\"").append(manageEstate.getEstateCarMap()).append("\"").append(",")
			    .append("\"estateType\":\"").append(manageEstate.getEstateType()).append("\"").append(",")
			    .append("\"createTime\":\"").append(manageEstate.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(manageEstate.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(manageEstate.getEditor()).append("\"")
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
			GSLogger.error("显示manageEstate列表时发生错误：/manage/manageEstate/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="findEstateByComId")
	public void findEstateByComId(ManageEstateQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			Map paramMap = new HashMap();
			paramMap.put("comId",  query.getComId());
			List<ManageEstate> baseBean = manageEstateService.findByMap(paramMap);
			result.append("{\"total\":").append(baseBean.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.size();i++) {
				ManageEstate manageEstate = (ManageEstate) baseBean.get(i);
				result.append("{")
			    .append("\"estateId\":\"").append(manageEstate.getEstateId()).append("\"").append(",")
			    .append("\"estateName\":\"").append(manageEstate.getEstateName()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(baseBean.size() > 0) {
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
			GSLogger.error("显示manageEstate列表时发生错误：/manage/manageEstate/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(ManageEstateQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageEstate新增页时发生错误：/manage/manageEstate/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageEstate/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageEstate
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageEstateQuery query) {
		ManageEstate manageEstate = new ManageEstate();
		String json = "";
		try{
		    manageEstate.setEstateName(query.getEstateName());
		    manageEstate.setEstateDesc(query.getEstateDesc());
		    manageEstate.setEstateAddress(query.getEstateAddress());
		    manageEstate.setEstateMap(query.getEstateMap());
		    manageEstate.setEstateLongitude(query.getEstateLongitude());
		    manageEstate.setEstateLatitude(query.getEstateLatitude());
		    manageEstate.setEstateCarMap(query.getEstateCarMap());
		    manageEstate.setEstateType(query.getEstateType());
		    manageEstate.setCreateTime(query.getCreateTime());
		    manageEstate.setEditTime(query.getEditTime());
		    manageEstate.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        manageEstate.setCreateTime(ts);
	        manageEstate.setEditTime(ts);
			manageEstateService.save(manageEstate);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存manageEstate信息时发生错误：/manage/manageEstate/save", e);
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
	public ModelAndView modify(ManageEstateQuery query) {	
		ManageEstate manageEstate=new ManageEstate();
		
		try{
			manageEstate = manageEstateService.findById(query.getEstateId());
		}catch(Exception e){
			GSLogger.error("进入manageEstate修改页时发生错误：/manage/manageEstate/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageEstate/modify");
		mav.addObject("manageEstate", manageEstate);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageEstateQuery query) {
		ManageEstate manageEstate = null;
		String json = "";
		try{
		    manageEstate = manageEstateService.findById(query.getEstateId());
		    manageEstate.setEstateName(query.getEstateName());
		    manageEstate.setEstateDesc(query.getEstateDesc());
		    manageEstate.setEstateAddress(query.getEstateAddress());
		    manageEstate.setEstateMap(query.getEstateMap());
		    manageEstate.setEstateLongitude(query.getEstateLongitude());
		    manageEstate.setEstateLatitude(query.getEstateLatitude());
		    manageEstate.setEstateCarMap(query.getEstateCarMap());
		    manageEstate.setEstateType(query.getEstateType());
		    manageEstate.setCreateTime(query.getCreateTime());
		    manageEstate.setEditTime(query.getEditTime());
		    manageEstate.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        manageEstate.setEditTime(ts);
			manageEstateService.update(manageEstate);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑manageEstate信息时发生错误：/manage/manageEstate/update", e);
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
						manageEstateService.delete(new Integer(ids[i]));
					}
				}else{
					manageEstateService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除ManageEstate时发生错误：/manage/manageEstate/delete", e);
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
	 * 获取社区及社区下的所有小区树结构
	 * @param response
	 */
	@RequestMapping(value="getAllEstateTree")
	public void getAllEstateTree(HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		JSONArray arr = new JSONArray();
		try{
			List comList = businessCommunityService.findAll();
			JSONObject comObj = null;
			JSONArray comArr = new JSONArray();
			Map paramMap = new HashMap();
			for(int i=0;i<comList.size();i++) {
				BusinessCommunity businessCommunity = (BusinessCommunity) comList.get(i);
				comObj = new JSONObject();
				comObj.put("id", "com_"+businessCommunity.getComId());
				comObj.put("text", businessCommunity.getComName());
				//comObj.put("state", "close");
				paramMap = new HashMap();
				paramMap.put("comId", businessCommunity.getComId());
				List estateList = manageEstateService.findByMap(paramMap);
				JSONArray estateArr = new JSONArray();
				JSONObject estateObj = null;
				for(int j=0;j<estateList.size();j++) {
					ManageEstate manageEstate = (ManageEstate) estateList.get(j);
					estateObj = new JSONObject();
					estateObj.put("id", "estate_"+manageEstate.getEstateId());
					estateObj.put("text", manageEstate.getEstateName());
					estateArr.add(estateObj);
				}
				comObj.put("children", estateArr);
				comArr.add(comObj);
			}
			
			jsonObj.put("success", true);
			jsonObj.put("result", comArr);
		}catch(Exception e){
			jsonObj.put("success", false);
			jsonObj.put("message", "获取失败");
			GSLogger.error("获取社区及社区下的所有小区树结构：/business/businessUser/getAllEstateTree", e);
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
	 * 获取所有部门及其下属的所有小区树结构
	 * @param response
	 */
	@RequestMapping(value="getAllDepartmentEstateTree")
	public void getAllDepartmentEstateTree(HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		JSONArray arr = new JSONArray();
		try{
			jsonObj.put("id", "com");
			jsonObj.put("text", "社区");
			jsonObj.put("children", getAllComJSON());
			arr.add(jsonObj);
			jsonObj = new JSONObject();
			jsonObj.put("id", "station");
			jsonObj.put("text", "驿站");
			jsonObj.put("children", getAllStationJSON());
			arr.add(jsonObj);
			jsonObj = new JSONObject();
			jsonObj.put("id", "pro");
			jsonObj.put("text", "物业");
			jsonObj.put("children", getAllProJSON());
			arr.add(jsonObj);
			
			jsonObj = new JSONObject();
			jsonObj.put("id", "root");
			jsonObj.put("text", "部门");
			jsonObj.put("children", arr);			
			
			jsonObj.put("success", true);
			jsonObj.put("result", arr);
		}catch(Exception e){
			jsonObj.put("success", false);
			jsonObj.put("message", "获取失败");
			GSLogger.error("获取社区及社区下的所有小区树结构：/business/businessUser/getAllEstateTree", e);
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
	
	//所有社区下的小区
	private JSONArray getAllComJSON() {
		//社区结构
		List comList = businessCommunityService.findAll();
		JSONObject comObj = null;
		JSONArray comArr = new JSONArray();
		Map paramMap = new HashMap();
		for(int i=0;i<comList.size();i++) {
			BusinessCommunity businessCommunity = (BusinessCommunity) comList.get(i);
			comObj = new JSONObject();
			comObj.put("id", "com_"+businessCommunity.getComId());
			comObj.put("text", businessCommunity.getComName());
			//comObj.put("state", "close");
			paramMap = new HashMap();
			paramMap.put("comId", businessCommunity.getComId());
			List estateList = manageEstateService.findByMap(paramMap);
			JSONArray estateArr = new JSONArray();
			JSONObject estateObj = null;
			for(int j=0;j<estateList.size();j++) {
				ManageEstate manageEstate = (ManageEstate) estateList.get(j);
				estateObj = new JSONObject();
				estateObj.put("id", "estate_"+manageEstate.getEstateId()+"_1");
				estateObj.put("text", manageEstate.getEstateName());
				estateArr.add(estateObj);
			}
			comObj.put("children", estateArr);
			comArr.add(comObj);
		}
		
		return comArr;
	}
	
		//所有驿站下的小区
		private JSONArray getAllStationJSON() {
			//社区结构
			List stationList = businessStationService.findAll();
			JSONObject stationObj = null;
			JSONArray stationArr = new JSONArray();
			Map paramMap = new HashMap();
			for(int i=0;i<stationList.size();i++) {
				BusinessStation businessStation = (BusinessStation) stationList.get(i);
				stationObj = new JSONObject();
				stationObj.put("id", "station_"+businessStation.getStationId());
				stationObj.put("text", businessStation.getStaName());
				paramMap = new HashMap();
				paramMap.put("stationId", businessStation.getStationId());
				List estateList = manageEstateService.findByMap(paramMap);
				JSONArray estateArr = new JSONArray();
				JSONObject estateObj = null;
				for(int j=0;j<estateList.size();j++) {
					ManageEstate manageEstate = (ManageEstate) estateList.get(j);
					estateObj = new JSONObject();
					estateObj.put("id", "estate_"+manageEstate.getEstateId()+"_2");
					estateObj.put("text", manageEstate.getEstateName());
					estateArr.add(estateObj);
				}
				stationObj.put("children", estateArr);
				stationArr.add(stationObj);
			}
			
			return stationArr;
		}
	
		//所有物业下的小区
		private JSONArray getAllProJSON() {
			//社区结构
			List propertyList = businessPropertyService.findAll();
			JSONObject proObj = null;
			JSONArray proArr = new JSONArray();
			Map paramMap = new HashMap();
			for(int i=0;i<propertyList.size();i++) {
				BusinessProperty businessProperty = (BusinessProperty) propertyList.get(i);
				proObj = new JSONObject();
				proObj.put("id", "pro_"+businessProperty.getProId());
				proObj.put("text", businessProperty.getProName());
				paramMap = new HashMap();
				paramMap.put("proId", businessProperty.getProId());
				List estateList = manageEstateService.findByMap(paramMap);
				JSONArray estateArr = new JSONArray();
				JSONObject estateObj = null;
				for(int j=0;j<estateList.size();j++) {
					ManageEstate manageEstate = (ManageEstate) estateList.get(j);
					estateObj = new JSONObject();
					estateObj.put("id", "estate_"+manageEstate.getEstateId()+"_3");
					estateObj.put("text", manageEstate.getEstateName());
					estateArr.add(estateObj);
				}
				proObj.put("children", estateArr);
				proArr.add(proObj);
			}
			
			return proArr;
		}
		
		
}
