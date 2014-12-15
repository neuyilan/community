package com.community.app.module.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


import com.community.app.module.bean.BusinessExpFav;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.service.BusinessExpFavService;
import com.community.app.module.vo.BusinessExpFavQuery;
import com.community.framework.utils.CommonUtils;

import static com.community.framework.utils.CommonUtils.getUser;


@Controller
@RequestMapping("/business/businessExpFav")
public class BusinessExpFavController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessExpFavController.class);
	@Autowired
	private BusinessExpFavService businessExpFavService;
	
	private final String LIST_ACTION = "redirect:/business/businessExpFav/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessExpFav管理页时发生错误：/business/businessExpFav/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessExpFav/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessExpFavQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessExpFavService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessExpFav businessExpFav = (BusinessExpFav) baseBean.getList().get(i);
				result.append("{")
			    .append("\"favorableId\":\"").append(businessExpFav.getFavorableId()).append("\"").append(",")
			    .append("\"startDate\":\"").append(businessExpFav.getStartDate()).append("\"").append(",")
			    .append("\"endDate\":\"").append(businessExpFav.getEndDate()).append("\"").append(",")
			    .append("\"info\":\"").append(businessExpFav.getInfo()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessExpFav.getCreateTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessExpFav.getEditor()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessExpFav.getEditTime()).append("\"")
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
			GSLogger.error("显示businessExpFav列表时发生错误：/business/businessExpFav/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessExpFavQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessExpFav新增页时发生错误：/business/businessExpFav/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessExpFav/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessExpFavQuery query) {
		BusinessExpFav businessExpFav = new BusinessExpFav();
		String json = "";
		try{
			Map paramMap = new HashMap();
			ShiroUser shiroUser = CommonUtils.getUser();
			if(query.getFavorableId() != null && query.getFavorableId() != 0) {//已存在 修改
				businessExpFav = businessExpFavService.findById(query.getFavorableId());
				//businessExpFav.setStartDate(query.getStartDate());
			    //businessExpFav.setEndDate(query.getEndDate());
			    businessExpFav.setInfo(query.getInfo());
			    //businessExpFav.setCreateTime(query.getCreateTime());
			    businessExpFav.setEditor(getUser().getUserName());
			    businessExpFav.setEditTime(new Timestamp(System.currentTimeMillis()));
		        Timestamp  ts=new Timestamp(new Date().getTime());
		        businessExpFav.setEditTime(ts);
				businessExpFavService.update(businessExpFav);
			}else{//不存在 新增
				//businessExpFav.setStartDate(query.getStartDate());
			    //businessExpFav.setEndDate(query.getEndDate());
			    businessExpFav.setInfo(query.getInfo());
			    businessExpFav.setCreateTime(new Timestamp(System.currentTimeMillis()));
			    businessExpFav.setEditor(getUser().getUserName());
			    businessExpFav.setEditTime(new Timestamp(System.currentTimeMillis()));
			    businessExpFav.setStationId(getUser().getOrgId());
				businessExpFavService.save(businessExpFav);
			}
		    
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessExpFav信息时发生错误：/business/businessExpFav/save", e);
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
	public ModelAndView modify(BusinessExpFavQuery query) {	
		BusinessExpFav businessExpFav=new BusinessExpFav();
		
		try{
			businessExpFav = businessExpFavService.findById(query.getFavorableId());
		}catch(Exception e){
			GSLogger.error("进入businessExpFav修改页时发生错误：/business/businessExpFav/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessExpFav/modify");
		mav.addObject("businessExpFav", businessExpFav);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessExpFavQuery query) {
		BusinessExpFav businessExpFav = null;
		String json = "";
		try{
		    businessExpFav = businessExpFavService.findById(query.getFavorableId());
		    //businessExpFav.setStartDate(query.getStartDate());
		    //businessExpFav.setEndDate(query.getEndDate());
		    businessExpFav.setInfo(query.getInfo());
		    businessExpFav.setCreateTime(query.getCreateTime());
		    businessExpFav.setEditor(query.getEditor());
		    businessExpFav.setEditTime(query.getEditTime());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessExpFav.setEditTime(ts);
			businessExpFavService.update(businessExpFav);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessExpFav信息时发生错误：/business/businessExpFav/update", e);
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
						businessExpFavService.delete(new Integer(ids[i]));
					}
				}else{
					businessExpFavService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessExpFav时发生错误：/business/businessExpFav/delete", e);
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
