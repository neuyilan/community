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

import com.community.app.module.bean.ManageUserFunction;
import com.community.app.module.service.ManageUserFunctionService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.ManageUserFunctionQuery;


@Controller
@RequestMapping("/manage/manageUserFunction")
public class ManageUserFunctionController {
	private static Logger GSLogger = LoggerFactory.getLogger(ManageUserFunctionController.class);
	@Autowired
	private ManageUserFunctionService manageUserFunctionService;
	
	private final String LIST_ACTION = "redirect:/manage/manageUserFunction/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageUserFunction管理页时发生错误：/manage/manageUserFunction/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageUserFunction/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(ManageUserFunctionQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = manageUserFunctionService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				ManageUserFunction manageUserFunction = (ManageUserFunction) baseBean.getList().get(i);
				result.append("{")
			    .append("\"userAuthId\":\"").append(manageUserFunction.getUserAuthId()).append("\"").append(",")
			    .append("\"functionId\":\"").append(manageUserFunction.getFunctionId()).append("\"").append(",")
			    .append("\"userId\":\"").append(manageUserFunction.getUserId()).append("\"").append(",")
			    .append("\"functionName\":\"").append(manageUserFunction.getFunctionName()).append("\"").append(",")
			    .append("\"menuId\":\"").append(manageUserFunction.getMenuId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(manageUserFunction.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(manageUserFunction.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(manageUserFunction.getEditor()).append("\"").append(",")
			    .append("\"moduleId\":\"").append(manageUserFunction.getModuleId()).append("\"")
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
			GSLogger.error("显示manageUserFunction列表时发生错误：/manage/manageUserFunction/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(ManageUserFunctionQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入manageUserFunction新增页时发生错误：/manage/manageUserFunction/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageUserFunction/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param manageUserFunction
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, ManageUserFunctionQuery query) {
		ManageUserFunction manageUserFunction = new ManageUserFunction();
		String json = "";
		try{
		    manageUserFunction.setFunctionId(query.getFunctionId());
		    manageUserFunction.setUserId(query.getUserId());
		    manageUserFunction.setFunctionName(query.getFunctionName());
		    manageUserFunction.setMenuId(query.getMenuId());
		    manageUserFunction.setCreateTime(query.getCreateTime());
		    manageUserFunction.setEditTime(query.getEditTime());
		    manageUserFunction.setEditor(query.getEditor());
		    manageUserFunction.setModuleId(query.getModuleId());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        manageUserFunction.setCreateTime(ts);
	        manageUserFunction.setEditTime(ts);
			manageUserFunctionService.save(manageUserFunction);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存manageUserFunction信息时发生错误：/manage/manageUserFunction/save", e);
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
	public ModelAndView modify(ManageUserFunctionQuery query) {	
		ManageUserFunction manageUserFunction=new ManageUserFunction();
		
		try{
			manageUserFunction = manageUserFunctionService.findById(query.getUserAuthId());
		}catch(Exception e){
			GSLogger.error("进入manageUserFunction修改页时发生错误：/manage/manageUserFunction/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/manage/manageUserFunction/modify");
		mav.addObject("manageUserFunction", manageUserFunction);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, ManageUserFunctionQuery query) {
		ManageUserFunction manageUserFunction = null;
		String json = "";
		try{
		    manageUserFunction = manageUserFunctionService.findById(query.getUserAuthId());
		    manageUserFunction.setFunctionId(query.getFunctionId());
		    manageUserFunction.setUserId(query.getUserId());
		    manageUserFunction.setFunctionName(query.getFunctionName());
		    manageUserFunction.setMenuId(query.getMenuId());
		    manageUserFunction.setCreateTime(query.getCreateTime());
		    manageUserFunction.setEditTime(query.getEditTime());
		    manageUserFunction.setEditor(query.getEditor());
		    manageUserFunction.setModuleId(query.getModuleId());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        manageUserFunction.setEditTime(ts);
			manageUserFunctionService.update(manageUserFunction);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑manageUserFunction信息时发生错误：/manage/manageUserFunction/update", e);
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
						manageUserFunctionService.delete(new Integer(ids[i]));
					}
				}else{
					manageUserFunctionService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除ManageUserFunction时发生错误：/manage/manageUserFunction/delete", e);
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
