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


import com.community.app.module.bean.BusinessShopOrder;
import com.community.app.module.service.BusinessShopOrderService;
import com.community.app.module.vo.BusinessShopOrderQuery;


@Controller
@RequestMapping("/business/businessShopOrder")
public class BusinessShopOrderController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessShopOrderController.class);
	@Autowired
	private BusinessShopOrderService businessShopOrderService;
	
	private final String LIST_ACTION = "redirect:/business/businessShopOrder/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessShopOrder管理页时发生错误：/business/businessShopOrder/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessShopOrder/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessShopOrderQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessShopOrderService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessShopOrder businessShopOrder = (BusinessShopOrder) baseBean.getList().get(i);
				result.append("{")
			    .append("\"orderId\":\"").append(businessShopOrder.getOrderId()).append("\"").append(",")
			    .append("\"orderNo\":\"").append(businessShopOrder.getOrderNo()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessShopOrder.getUserId()).append("\"").append(",")
			    .append("\"nickName\":\"").append(businessShopOrder.getNickName()).append("\"").append(",")
			    .append("\"estateId\":\"").append(businessShopOrder.getEstateId()).append("\"").append(",")
			    .append("\"orderAmount\":\"").append(businessShopOrder.getOrderAmount()).append("\"").append(",")
			    .append("\"shopId\":\"").append(businessShopOrder.getShopId()).append("\"").append(",")
			    .append("\"orderTime\":\"").append(businessShopOrder.getOrderTime()).append("\"")
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
			GSLogger.error("显示businessShopOrder列表时发生错误：/business/businessShopOrder/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessShopOrderQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessShopOrder新增页时发生错误：/business/businessShopOrder/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessShopOrder/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessShopOrder
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessShopOrderQuery query) {
		BusinessShopOrder businessShopOrder = new BusinessShopOrder();
		String json = "";
		try{
		    businessShopOrder.setOrderNo(query.getOrderNo());
		    businessShopOrder.setUserId(query.getUserId());
		    businessShopOrder.setNickName(query.getNickName());
		    businessShopOrder.setEstateId(query.getEstateId());
		    businessShopOrder.setOrderAmount(query.getOrderAmount());
		    businessShopOrder.setShopId(query.getShopId());
		    businessShopOrder.setOrderTime(query.getOrderTime());
			businessShopOrderService.save(businessShopOrder);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessShopOrder信息时发生错误：/business/businessShopOrder/save", e);
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
	public ModelAndView modify(BusinessShopOrderQuery query) {	
		BusinessShopOrder businessShopOrder=new BusinessShopOrder();
		
		try{
			businessShopOrder = businessShopOrderService.findById(query.getOrderId());
		}catch(Exception e){
			GSLogger.error("进入businessShopOrder修改页时发生错误：/business/businessShopOrder/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessShopOrder/modify");
		mav.addObject("businessShopOrder", businessShopOrder);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessShopOrderQuery query) {
		BusinessShopOrder businessShopOrder = null;
		String json = "";
		try{
		    businessShopOrder = businessShopOrderService.findById(query.getOrderId());
		    businessShopOrder.setOrderNo(query.getOrderNo());
		    businessShopOrder.setUserId(query.getUserId());
		    businessShopOrder.setNickName(query.getNickName());
		    businessShopOrder.setEstateId(query.getEstateId());
		    businessShopOrder.setOrderAmount(query.getOrderAmount());
		    businessShopOrder.setShopId(query.getShopId());
		    businessShopOrder.setOrderTime(query.getOrderTime());
			businessShopOrderService.update(businessShopOrder);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessShopOrder信息时发生错误：/business/businessShopOrder/update", e);
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
						businessShopOrderService.delete(new Integer(ids[i]));
					}
				}else{
					businessShopOrderService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessShopOrder时发生错误：/business/businessShopOrder/delete", e);
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
