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

import com.community.app.module.bean.ManageModulemenu;
import com.community.app.module.service.ManageModulemenuService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.ManageModulemenuQuery;


@Controller
@RequestMapping("/manage/manageModulemenu")
public class ManageModulemenuController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageModulemenuController.class);
	@Autowired
	private ManageModulemenuService manageModulemenuService;
	
	private final String LIST_ACTION = "redirect:/manage/manageModulemenu/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageModulemenu管理页时发生错误：/manage/manageModulemenu/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageModulemenu/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(ManageModulemenuQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = manageModulemenuService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				ManageModulemenu manageModulemenu = (ManageModulemenu) baseBean.getList().get(i);
				result.append("{")
			    .append("\"moduleMenuId\":\"").append(manageModulemenu.getModuleMenuId()).append("\"").append(",")
			    .append("\"moduleId\":\"").append(manageModulemenu.getModuleId()).append("\"").append(",")
			    .append("\"menuId\":\"").append(manageModulemenu.getMenuId()).append("\"")
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
			GSLogger.error("显示manageModulemenu列表时发生错误：/manage/manageModulemenu/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(ManageModulemenuQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageModulemenu新增页时发生错误：/manage/manageModulemenu/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageModulemenu/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageModulemenu
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageModulemenuQuery query) {
		ManageModulemenu manageModulemenu = new ManageModulemenu();
		String json = "";
		try{
		    manageModulemenu.setModuleId(query.getModuleId());
		    manageModulemenu.setMenuId(query.getMenuId());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //manageModulemenu.setCreateTime(ts);
	        //manageModulemenu.setEditTime(ts);
			manageModulemenuService.save(manageModulemenu);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存manageModulemenu信息时发生错误：/manage/manageModulemenu/save", e);
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
	public ModelAndView modify(ManageModulemenuQuery query) {	
		ManageModulemenu manageModulemenu=new ManageModulemenu();
		
		try{
			manageModulemenu = manageModulemenuService.findById(query.getModuleMenuId());
		}catch(Exception e){
			GSLogger.error("进入manageModulemenu修改页时发生错误：/manage/manageModulemenu/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageModulemenu/modify");
		mav.addObject("manageModulemenu", manageModulemenu);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageModulemenuQuery query) {
		ManageModulemenu manageModulemenu = null;
		String json = "";
		try{
		    manageModulemenu = manageModulemenuService.findById(query.getModuleMenuId());
		    manageModulemenu.setModuleId(query.getModuleId());
		    manageModulemenu.setMenuId(query.getMenuId());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	       //manageModulemenu.setEditTime(ts);
			manageModulemenuService.update(manageModulemenu);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑manageModulemenu信息时发生错误：/manage/manageModulemenu/update", e);
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
						manageModulemenuService.delete(new Integer(ids[i]));
					}
				}else{
					manageModulemenuService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除ManageModulemenu时发生错误：/manage/manageModulemenu/delete", e);
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
