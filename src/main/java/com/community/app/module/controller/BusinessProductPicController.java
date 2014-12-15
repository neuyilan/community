package com.community.app.module.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.community.app.module.bean.BusinessProduct;
import com.community.app.module.service.BusinessProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.community.app.module.vo.BaseBean;

import com.community.app.module.bean.BusinessProductPic;
import com.community.app.module.service.BusinessProductPicService;
import com.community.app.module.vo.BusinessProductPicQuery;

@Controller
@RequestMapping("/business/businessProductPic")
public class BusinessProductPicController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessProductPicController.class);
	@Autowired
	private BusinessProductPicService businessProductPicService;
	@Autowired
	private BusinessProductService businessProductService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessProductPic管理页时发生错误：/business/businessProductPic/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessProductPic/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessProductPicQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessProductPicService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessProductPic businessProductPic = (BusinessProductPic) baseBean.getList().get(i);
				result.append("{")
			    .append("\"productId\":\"").append(businessProductPic.getProductId()).append("\"").append(",")
			    .append("\"picId\":\"").append(businessProductPic.getPicId()).append("\"").append(",")
			    .append("\"picPath\":\"").append(businessProductPic.getPicPath()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessProductPic.getCreateTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessProductPic.getEditor()).append("\"")
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
			GSLogger.error("显示businessProductPic列表时发生错误：/business/businessProductPic/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessProductPicQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessProductPic新增页时发生错误：/business/businessProductPic/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessProductPic/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessProductPicQuery query) {
		BusinessProductPic businessProductPic = new BusinessProductPic();
		String json = "";
		try{
			BusinessProduct businessProduct = new BusinessProduct();
			businessProduct = businessProductService.findById(query.getProductId());
			businessProductPic.setBusinessProduct(businessProduct);
		    businessProductPic.setProductId(query.getProductId());
		    businessProductPic.setPicId(query.getPicId());
		    businessProductPic.setPicPath(query.getPicPath());
		    businessProductPic.setCreateTime(query.getCreateTime());
		    businessProductPic.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessProductPic.setCreateTime(ts);
	        //businessProductPic.setEditTime(ts);
			businessProductPicService.save(businessProductPic);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessProductPic信息时发生错误：/business/businessProductPic/save", e);
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
	public ModelAndView modify(BusinessProductPicQuery query) {	
		BusinessProductPic businessProductPic=new BusinessProductPic();
		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessProductPic修改页时发生错误：/business/businessProductPic/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessProductPic/modify");
		mav.addObject("businessProductPic", businessProductPic);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessProductPicQuery query) {
		BusinessProductPic businessProductPic = null;
		String json = "";
		try{
			BusinessProduct businessProduct = new BusinessProduct();
			businessProduct = businessProductService.findById(query.getProductId());
			businessProductPic.setBusinessProduct(businessProduct);
		    businessProductPic.setProductId(query.getProductId());
		    businessProductPic.setPicId(query.getPicId());
		    businessProductPic.setPicPath(query.getPicPath());
		    businessProductPic.setCreateTime(query.getCreateTime());
		    businessProductPic.setEditor(query.getEditor());
	        //businessProductPic.setEditTime(ts);
			businessProductPicService.update(businessProductPic);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessProductPic信息时发生错误：/business/businessProductPic/update", e);
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
						businessProductPicService.delete(new Integer(ids[i]));
					}
				}else{
					businessProductPicService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessProductPic时发生错误：/business/businessProductPic/delete", e);
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
