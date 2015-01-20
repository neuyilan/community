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

import com.community.app.module.bean.BusinessActivityCoupon;
import com.community.app.module.service.BusinessActivityCouponService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityCouponQuery;


@Controller
@RequestMapping("/business/businessActivityCoupon")
public class BusinessActivityCouponController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessActivityCouponController.class);
	@Autowired
	private BusinessActivityCouponService businessActivityCouponService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityCoupon管理页时发生错误：/business/businessActivityCoupon/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityCoupon/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessActivityCouponQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessActivityCouponService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessActivityCoupon businessActivityCoupon = (BusinessActivityCoupon) baseBean.getList().get(i);
				result.append("{")
			    .append("\"couponId\":\"").append(businessActivityCoupon.getCouponId()).append("\"").append(",")
			    .append("\"actId\":\"").append(businessActivityCoupon.getActId()).append("\"").append(",")
			    .append("\"couponCode\":\"").append(businessActivityCoupon.getCouponCode()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessActivityCoupon.getUserId()).append("\"").append(",")
			    .append("\"state\":\"").append(businessActivityCoupon.getState()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessActivityCoupon.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessActivityCoupon.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessActivityCoupon.getEditor()).append("\"")
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
			GSLogger.error("显示businessActivityCoupon列表时发生错误：/business/businessActivityCoupon/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessActivityCouponQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessActivityCoupon新增页时发生错误：/business/businessActivityCoupon/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityCoupon/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessActivityCoupon
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessActivityCouponQuery query) {
		BusinessActivityCoupon businessActivityCoupon = new BusinessActivityCoupon();
		String json = "";
		try{
		    businessActivityCoupon.setActId(query.getActId());
		    businessActivityCoupon.setCouponCode(query.getCouponCode());
		    businessActivityCoupon.setUserId(query.getUserId());
		    businessActivityCoupon.setState(query.getState());
		    businessActivityCoupon.setCreateTime(query.getCreateTime());
		    businessActivityCoupon.setEditTime(query.getEditTime());
		    businessActivityCoupon.setEditor(query.getEditor());
			businessActivityCouponService.save(businessActivityCoupon);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessActivityCoupon信息时发生错误：/business/businessActivityCoupon/save", e);
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
	public ModelAndView modify(BusinessActivityCouponQuery query) {	
		BusinessActivityCoupon businessActivityCoupon=new BusinessActivityCoupon();
		
		try{
			businessActivityCoupon = businessActivityCouponService.findById(query.getCouponId());
		}catch(Exception e){
			GSLogger.error("进入businessActivityCoupon修改页时发生错误：/business/businessActivityCoupon/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessActivityCoupon/modify");
		mav.addObject("businessActivityCoupon", businessActivityCoupon);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessActivityCouponQuery query) {
		BusinessActivityCoupon businessActivityCoupon = null;
		String json = "";
		try{
		    businessActivityCoupon = businessActivityCouponService.findById(query.getCouponId());
		    businessActivityCoupon.setActId(query.getActId());
		    businessActivityCoupon.setCouponCode(query.getCouponCode());
		    businessActivityCoupon.setUserId(query.getUserId());
		    businessActivityCoupon.setState(query.getState());
		    businessActivityCoupon.setCreateTime(query.getCreateTime());
		    businessActivityCoupon.setEditTime(query.getEditTime());
		    businessActivityCoupon.setEditor(query.getEditor());
			businessActivityCouponService.update(businessActivityCoupon);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessActivityCoupon信息时发生错误：/business/businessActivityCoupon/update", e);
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
						businessActivityCouponService.delete(new Integer(ids[i]));
					}
				}else{
					businessActivityCouponService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessActivityCoupon时发生错误：/business/businessActivityCoupon/delete", e);
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
