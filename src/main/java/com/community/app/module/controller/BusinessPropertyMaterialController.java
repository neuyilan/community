package com.community.app.module.controller;

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


import com.community.app.module.bean.BusinessPropertyMaterial;
import com.community.app.module.service.BusinessPropertyMaterialService;
import com.community.app.module.vo.BusinessPropertyMaterialQuery;


@Controller
@RequestMapping("/business/businessPropertyMaterial")
public class BusinessPropertyMaterialController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessPropertyMaterialController.class);
	@Autowired
	private BusinessPropertyMaterialService businessPropertyMaterialService;
	
	private final String LIST_ACTION = "redirect:/business/businessPropertyMaterial/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessPropertyMaterial管理页时发生错误：/business/businessPropertyMaterial/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessPropertyMaterial/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessPropertyMaterialQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessPropertyMaterialService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessPropertyMaterial businessPropertyMaterial = (BusinessPropertyMaterial) baseBean.getList().get(i);
				result.append("{")
			    .append("\"materialId\":\"").append(businessPropertyMaterial.getMaterialId()).append("\"").append(",")
			    .append("\"proId\":\"").append(businessPropertyMaterial.getProId()).append("\"").append(",")
			    .append("\"materialName\":\"").append(businessPropertyMaterial.getMaterialName()).append("\"").append(",")
			    .append("\"icon\":\"").append(businessPropertyMaterial.getIcon()).append("\"").append(",")
			    .append("\"link\":\"").append(businessPropertyMaterial.getLink()).append("\"")
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
			GSLogger.error("显示businessPropertyMaterial列表时发生错误：/business/businessPropertyMaterial/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessPropertyMaterialQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessPropertyMaterial新增页时发生错误：/business/businessPropertyMaterial/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessPropertyMaterial/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessPropertyMaterial
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessPropertyMaterialQuery query) {
		BusinessPropertyMaterial businessPropertyMaterial = new BusinessPropertyMaterial();
		String json = "";
		try{
		    businessPropertyMaterial.setProId(query.getProId());
		    businessPropertyMaterial.setMaterialName(query.getMaterialName());
		    businessPropertyMaterial.setIcon(query.getIcon());
		    businessPropertyMaterial.setLink(query.getLink());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessPropertyMaterial.setCreateTime(ts);
	        //businessPropertyMaterial.setEditTime(ts);
			businessPropertyMaterialService.save(businessPropertyMaterial);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessPropertyMaterial信息时发生错误：/business/businessPropertyMaterial/save", e);
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
	public ModelAndView modify(BusinessPropertyMaterialQuery query) {	
		BusinessPropertyMaterial businessPropertyMaterial=new BusinessPropertyMaterial();
		
		try{
			businessPropertyMaterial = businessPropertyMaterialService.findById(query.getMaterialId());
		}catch(Exception e){
			GSLogger.error("进入businessPropertyMaterial修改页时发生错误：/business/businessPropertyMaterial/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessPropertyMaterial/modify");
		mav.addObject("businessPropertyMaterial", businessPropertyMaterial);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessPropertyMaterialQuery query) {
		BusinessPropertyMaterial businessPropertyMaterial = null;
		String json = "";
		try{
		    businessPropertyMaterial = businessPropertyMaterialService.findById(query.getMaterialId());
		    businessPropertyMaterial.setProId(query.getProId());
		    businessPropertyMaterial.setMaterialName(query.getMaterialName());
		    businessPropertyMaterial.setIcon(query.getIcon());
		    businessPropertyMaterial.setLink(query.getLink());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        //businessPropertyMaterial.setEditTime(ts);
			businessPropertyMaterialService.update(businessPropertyMaterial);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessPropertyMaterial信息时发生错误：/business/businessPropertyMaterial/update", e);
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
						businessPropertyMaterialService.delete(new Integer(ids[i]));
					}
				}else{
					businessPropertyMaterialService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessPropertyMaterial时发生错误：/business/businessPropertyMaterial/delete", e);
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
