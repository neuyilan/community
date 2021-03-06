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

import com.community.app.module.bean.BusinessShopGoods;
import com.community.app.module.service.BusinessShopGoodsService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessShopGoodsQuery;


@Controller
@RequestMapping("/business/businessShopGoods")
public class BusinessShopGoodsController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessShopGoodsController.class);
	@Autowired
	private BusinessShopGoodsService businessShopGoodsService;
	
	private final String LIST_ACTION = "redirect:/business/businessShopGoods/list.do";
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessShopGoods管理页时发生错误：/business/businessShopGoods/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessShopGoods/enter");
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessShopGoodsQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessShopGoodsService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessShopGoods businessShopGoods = (BusinessShopGoods) baseBean.getList().get(i);
				result.append("{")
			    .append("\"goodsId\":\"").append(businessShopGoods.getGoodsId()).append("\"").append(",")
			    .append("\"goodsName\":\"").append(businessShopGoods.getGoodsName()).append("\"").append(",")
			    .append("\"goodsNo\":\"").append(businessShopGoods.getGoodsNO()).append("\"").append(",")
			    .append("\"goodsPrice\":\"").append(businessShopGoods.getGoodsPrice()).append("\"").append(",")
			    .append("\"goodsAmount\":\"").append(businessShopGoods.getGoodsAmount()).append("\"").append(",")
			    .append("\"goodsAgio\":\"").append(businessShopGoods.getGoodsAgio()).append("\"").append(",")
			    .append("\"orderId\":\"").append(businessShopGoods.getOrderId()).append("\"")
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
			GSLogger.error("显示businessShopGoods列表时发生错误：/business/businessShopGoods/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessShopGoodsQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessShopGoods新增页时发生错误：/business/businessShopGoods/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessShopGoods/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessShopGoods
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessShopGoodsQuery query) {
		BusinessShopGoods businessShopGoods = new BusinessShopGoods();
		String json = "";
		try{
		    businessShopGoods.setGoodsName(query.getGoodsName());
		    businessShopGoods.setGoodsNO(query.getGoodsNo());
		    businessShopGoods.setGoodsPrice(query.getGoodsPrice());
		    businessShopGoods.setGoodsAmount(query.getGoodsAmount());
		    businessShopGoods.setGoodsAgio(query.getGoodsAgio());
		    businessShopGoods.setOrderId(query.getOrderId());
			businessShopGoodsService.save(businessShopGoods);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessShopGoods信息时发生错误：/business/businessShopGoods/save", e);
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
	public ModelAndView modify(BusinessShopGoodsQuery query) {	
		BusinessShopGoods businessShopGoods=new BusinessShopGoods();
		
		try{
			businessShopGoods = businessShopGoodsService.findById(query.getGoodsId());
		}catch(Exception e){
			GSLogger.error("进入businessShopGoods修改页时发生错误：/business/businessShopGoods/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessShopGoods/modify");
		mav.addObject("businessShopGoods", businessShopGoods);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessShopGoodsQuery query) {
		BusinessShopGoods businessShopGoods = null;
		String json = "";
		try{
		    businessShopGoods = businessShopGoodsService.findById(query.getGoodsId());
		    businessShopGoods.setGoodsName(query.getGoodsName());
		    businessShopGoods.setGoodsNO(query.getGoodsNo());
		    businessShopGoods.setGoodsPrice(query.getGoodsPrice());
		    businessShopGoods.setGoodsAmount(query.getGoodsAmount());
		    businessShopGoods.setGoodsAgio(query.getGoodsAgio());
		    businessShopGoods.setOrderId(query.getOrderId());
			businessShopGoodsService.update(businessShopGoods);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessShopGoods信息时发生错误：/business/businessShopGoods/update", e);
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
						businessShopGoodsService.delete(new Integer(ids[i]));
					}
				}else{
					businessShopGoodsService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessShopGoods时发生错误：/business/businessShopGoods/delete", e);
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
