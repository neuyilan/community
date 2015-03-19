package com.community.app.module.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.BusinessOpertaion;
import com.community.app.module.service.BusinessOpertaionService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessOpertaionQuery;


@Controller
@RequestMapping("/business/businessOpertaion")
public class BusinessOpertaionController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessOpertaionController.class);
	@Autowired
	private BusinessOpertaionService businessOpertaionService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessOpertaion管理页时发生错误：/business/businessOpertaion/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessOpertaion/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessOpertaionQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessOpertaionService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessOpertaion businessOpertaion = (BusinessOpertaion) baseBean.getList().get(i);
				result.append("{")
			    .append("\"operId\":\"").append(businessOpertaion.getOperId()).append("\"").append(",")
			    .append("\"operUserId\":\"").append(businessOpertaion.getOperUserId()).append("\"").append(",")
			    .append("\"operUserName\":\"").append(businessOpertaion.getOperUserName()).append("\"").append(",")
			    .append("\"operIp\":\"").append(businessOpertaion.getOperIp()).append("\"").append(",")
			    .append("\"typeId\":\"").append(businessOpertaion.getTypeId()).append("\"").append(",")
			    .append("\"attrId\":\"").append(businessOpertaion.getAttrId()).append("\"").append(",")
			    .append("\"funcId\":\"").append(businessOpertaion.getFuncId()).append("\"").append(",")
			    .append("\"funcTitle\":\"").append(businessOpertaion.getFuncTitle()).append("\"").append(",")
			    .append("\"logTime\":\"").append(businessOpertaion.getLogTime()).append("\"")
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
			GSLogger.error("显示businessOpertaion列表时发生错误：/business/businessOpertaion/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessOpertaionQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessOpertaion新增页时发生错误：/business/businessOpertaion/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessOpertaion/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessOpertaion
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessOpertaionQuery query) {
		BusinessOpertaion businessOpertaion = new BusinessOpertaion();
		String json = "";
		try{
		    businessOpertaion.setOperUserId(query.getOperUserId());
		    businessOpertaion.setOperUserName(query.getOperUserName());
		    businessOpertaion.setOperIp(query.getOperIp());
		    businessOpertaion.setTypeId(query.getTypeId());
		    businessOpertaion.setAttrId(query.getAttrId());
		    businessOpertaion.setFuncId(query.getFuncId());
		    businessOpertaion.setFuncTitle(query.getFuncTitle());
		    businessOpertaion.setLogTime(query.getLogTime());
			businessOpertaionService.save(businessOpertaion);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessOpertaion信息时发生错误：/business/businessOpertaion/save", e);
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
	public ModelAndView modify(BusinessOpertaionQuery query) {	
		BusinessOpertaion businessOpertaion=new BusinessOpertaion();
		
		try{
			businessOpertaion = businessOpertaionService.findById(query.getOperId());
		}catch(Exception e){
			GSLogger.error("进入businessOpertaion修改页时发生错误：/business/businessOpertaion/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessOpertaion/modify");
		mav.addObject("businessOpertaion", businessOpertaion);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessOpertaionQuery query) {
		BusinessOpertaion businessOpertaion = null;
		String json = "";
		try{
		    businessOpertaion = businessOpertaionService.findById(query.getOperId());
		    businessOpertaion.setOperUserId(query.getOperUserId());
		    businessOpertaion.setOperUserName(query.getOperUserName());
		    businessOpertaion.setOperIp(query.getOperIp());
		    businessOpertaion.setTypeId(query.getTypeId());
		    businessOpertaion.setAttrId(query.getAttrId());
		    businessOpertaion.setFuncId(query.getFuncId());
		    businessOpertaion.setFuncTitle(query.getFuncTitle());
		    businessOpertaion.setLogTime(query.getLogTime());
			businessOpertaionService.update(businessOpertaion);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessOpertaion信息时发生错误：/business/businessOpertaion/update", e);
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
						businessOpertaionService.delete(new Integer(ids[i]));
					}
				}else{
					businessOpertaionService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessOpertaion时发生错误：/business/businessOpertaion/delete", e);
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