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

import com.community.app.module.bean.ManageBuilding;
import com.community.app.module.service.ManageBuildingService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.ManageBuildingQuery;

@Controller
@RequestMapping("/manage/manageBuilding")
public class ManageBuildingController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageBuildingController.class);
	@Autowired
	private ManageBuildingService manageBuildingService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageBuilding管理页时发生错误：/manage/manageBuilding/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageBuilding/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(ManageBuildingQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = manageBuildingService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				ManageBuilding manageBuilding = (ManageBuilding) baseBean.getList().get(i);
				result.append("{")
			    .append("\"buildingId\":\"").append(manageBuilding.getBuildingId()).append("\"").append(",")
			    .append("\"estateId\":\"").append(manageBuilding.getEstateId()).append("\"").append(",")
			    .append("\"buildingName\":\"").append(manageBuilding.getBuildingName()).append("\"").append(",")
			    .append("\"buildingDesc\":\"").append(manageBuilding.getBuildingDesc()).append("\"").append(",")
			    .append("\"buildingFloor\":\"").append(manageBuilding.getBuildingFloor()).append("\"").append(",")
			    .append("\"estateLongitude\":\"").append(manageBuilding.getEstateLongitude()).append("\"").append(",")
			    .append("\"estateLatitude\":\"").append(manageBuilding.getEstateLatitude()).append("\"").append(",")
			    .append("\"createTime\":\"").append(manageBuilding.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(manageBuilding.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(manageBuilding.getEditor()).append("\"").append(",")
			    .append("\"buildingMap\":\"").append(manageBuilding.getBuildingMap()).append("\"")
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
			GSLogger.error("显示manageBuilding列表时发生错误：/manage/manageBuilding/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(ManageBuildingQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageBuilding新增页时发生错误：/manage/manageBuilding/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageBuilding/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageBuilding
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageBuildingQuery query) {
		ManageBuilding manageBuilding = new ManageBuilding();
		String json = "";
		try{
		    manageBuilding.setEstateId(query.getEstateId());
		    manageBuilding.setBuildingName(query.getBuildingName());
		    manageBuilding.setBuildingDesc(query.getBuildingDesc());
		    manageBuilding.setBuildingFloor(query.getBuildingFloor());
		    manageBuilding.setEstateLongitude(query.getEstateLongitude());
		    manageBuilding.setEstateLatitude(query.getEstateLatitude());
		    manageBuilding.setCreateTime(query.getCreateTime());
		    manageBuilding.setEditTime(query.getEditTime());
		    manageBuilding.setEditor(query.getEditor());
		    manageBuilding.setBuildingMap(query.getBuildingMap());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        manageBuilding.setCreateTime(ts);
	        manageBuilding.setEditTime(ts);
			manageBuildingService.save(manageBuilding);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存manageBuilding信息时发生错误：/manage/manageBuilding/save", e);
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
	public ModelAndView modify(ManageBuildingQuery query) {	
		ManageBuilding manageBuilding=new ManageBuilding();
		
		try{
			manageBuilding = manageBuildingService.findById(query.getBuildingId());
		}catch(Exception e){
			GSLogger.error("进入manageBuilding修改页时发生错误：/manage/manageBuilding/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageBuilding/modify");
		mav.addObject("manageBuilding", manageBuilding);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageBuildingQuery query) {
		ManageBuilding manageBuilding = null;
		String json = "";
		try{
		    manageBuilding = manageBuildingService.findById(query.getBuildingId());
		    manageBuilding.setEstateId(query.getEstateId());
		    manageBuilding.setBuildingName(query.getBuildingName());
		    manageBuilding.setBuildingDesc(query.getBuildingDesc());
		    manageBuilding.setBuildingFloor(query.getBuildingFloor());
		    manageBuilding.setEstateLongitude(query.getEstateLongitude());
		    manageBuilding.setEstateLatitude(query.getEstateLatitude());
		    manageBuilding.setCreateTime(query.getCreateTime());
		    manageBuilding.setEditTime(query.getEditTime());
		    manageBuilding.setEditor(query.getEditor());
		    manageBuilding.setBuildingMap(query.getBuildingMap());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        manageBuilding.setEditTime(ts);
			manageBuildingService.update(manageBuilding);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑manageBuilding信息时发生错误：/manage/manageBuilding/update", e);
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
						manageBuildingService.delete(new Integer(ids[i]));
					}
				}else{
					manageBuildingService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除ManageBuilding时发生错误：/manage/manageBuilding/delete", e);
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
