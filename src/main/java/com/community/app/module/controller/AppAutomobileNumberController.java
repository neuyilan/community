package com.community.app.module.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.AppAutomobileNumber;
import com.community.app.module.service.AppAutomobileNumberService;
import com.community.app.module.vo.AppAutomobileNumberQuery;
import com.community.app.module.vo.BaseBean;


@Controller
@RequestMapping("/app/appAutomobileNumber")
public class AppAutomobileNumberController {
	private static Logger GSLogger = LoggerFactory.getLogger(AppAutomobileNumberController.class);
	@Autowired
	private AppAutomobileNumberService appAutomobileNumberService;
	
	private final String LIST_ACTION = "redirect:/app/appAutomobileNumber/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appAutomobileNumber管理页时发生错误：/app/appAutomobileNumber/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appAutomobileNumber/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(AppAutomobileNumberQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			List<AppAutomobileNumber> list = appAutomobileNumberService.findByExample(query);
			BaseBean baseBean = appAutomobileNumberService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				AppAutomobileNumber appAutomobileNumber = (AppAutomobileNumber) baseBean.getList().get(i);
				result.append("{")
			    .append("\"numberId\":\"").append(appAutomobileNumber.getNumberId()).append("\"").append(",")
			    .append("\"numberName\":\"").append(appAutomobileNumber.getNumberName()).append("\"").append(",")
			    .append("\"userId\":\"").append(appAutomobileNumber.getUserId()).append("\"").append(",")
			    .append("\"createTime\":\"").append(appAutomobileNumber.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(appAutomobileNumber.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(appAutomobileNumber.getEditor()).append("\"")
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
			GSLogger.error("显示appAutomobileNumber列表时发生错误：/app/appAutomobileNumber/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(AppAutomobileNumberQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入appAutomobileNumber新增页时发生错误：/app/appAutomobileNumber/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appAutomobileNumber/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param appAutomobileNumber
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, AppAutomobileNumberQuery query) {
		AppAutomobileNumber appAutomobileNumber = new AppAutomobileNumber();
		String json = "";
		try{
		    appAutomobileNumber.setNumberName(query.getNumberName());
		    appAutomobileNumber.setUserId(query.getUserId());
		    appAutomobileNumber.setCreateTime(query.getCreateTime());
		    appAutomobileNumber.setEditTime(query.getEditTime());
		    appAutomobileNumber.setEditor(query.getEditor());
			appAutomobileNumberService.save(appAutomobileNumber);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存appAutomobileNumber信息时发生错误：/app/appAutomobileNumber/save", e);
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
	public ModelAndView modify(AppAutomobileNumberQuery query) {	
		AppAutomobileNumber appAutomobileNumber=new AppAutomobileNumber();
		
		try{
			appAutomobileNumber = appAutomobileNumberService.findById(query.getNumberId());
		}catch(Exception e){
			GSLogger.error("进入appAutomobileNumber修改页时发生错误：/app/appAutomobileNumber/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/app/appAutomobileNumber/modify");
		mav.addObject("appAutomobileNumber", appAutomobileNumber);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, AppAutomobileNumberQuery query) {
		AppAutomobileNumber appAutomobileNumber = null;
		String json = "";
		try{
		    appAutomobileNumber = appAutomobileNumberService.findById(query.getNumberId());
		    appAutomobileNumber.setNumberName(query.getNumberName());
		    appAutomobileNumber.setUserId(query.getUserId());
		    appAutomobileNumber.setCreateTime(query.getCreateTime());
		    appAutomobileNumber.setEditTime(query.getEditTime());
		    appAutomobileNumber.setEditor(query.getEditor());
			appAutomobileNumberService.update(appAutomobileNumber);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑appAutomobileNumber信息时发生错误：/app/appAutomobileNumber/update", e);
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
						appAutomobileNumberService.delete(new Integer(ids[i]));
					}
				}else{
					appAutomobileNumberService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除AppAutomobileNumber时发生错误：/app/appAutomobileNumber/delete", e);
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
