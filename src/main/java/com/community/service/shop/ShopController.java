package com.community.service.shop;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.BusinessShop;
import com.community.app.module.bean.BusinessShopType;
import com.community.app.module.service.BusinessShopService;
import com.community.app.module.service.BusinessShopTypeService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessShopQuery;


@Controller
@RequestMapping("/service/shop")
public class ShopController {
	private static Logger GSLogger = LoggerFactory.getLogger(ShopController.class);
	@Autowired
	private BusinessShopService businessShopService;
	@Autowired
	private BusinessShopTypeService businessShopTypeService;
	
	private final String LIST_ACTION = "redirect:/business/businessShop/list.do";
	
	/**
	 * 用户查看商铺列表 for H5
	 * @param shopType ,estateId,userId 
	 * @return
	 * json
	 */
	@RequestMapping(value="getShopListPage")
	public ModelAndView getShopListPage(HttpServletRequest request, HttpServletResponse response,BusinessShopQuery query) {
		ModelAndView mav = new ModelAndView("/service/shop/shopList");
		try{
			
			String estateId = request.getParameter("estateId");
			String userId = request.getParameter("userId");
			String typeId = request.getParameter("typeId");
			
//			BaseBean baseBean = businessShopService.findAllPage(query);
			List<BusinessShop> shopList = businessShopService.findAll();
			BusinessShopType shopType = businessShopTypeService.findById(Integer.valueOf(typeId));
			if (StringUtils.isNotBlank(shopType.getTypeName()))
				mav.addObject("typeName", shopType.getTypeName());
			if (StringUtils.isNotBlank(estateId))
				mav.addObject("estateId", estateId);
			if (StringUtils.isNotBlank(userId))
				mav.addObject("userId", userId);
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
			mav.addObject("ctx", ctx);
			mav.addObject("shopList", shopList);
			
		}catch(Exception e){
			GSLogger.error("进入shop列表页时发生错误：/service/shop/shopList", e);
			e.printStackTrace();
		}
		return mav;
	}
	
	
	/**
	 * 用户查看商铺列表 for H5
	 * @param shopType ,estateId,userId 
	 * @return
	 * json
	 */
	@RequestMapping(value="enterShop")
	public ModelAndView enterShop(HttpServletRequest request, HttpServletResponse response,BusinessShopQuery query) {
		ModelAndView mav = new ModelAndView("/service/shop/shopIframe");
		try{
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
			mav.addObject("ctx", ctx);
			mav.addObject("shopURL", "http://www.baidu.com"); 
			
//			String estateId = request.getParameter("estateId");
//			String userId = request.getParameter("userId");
//			String typeId = request.getParameter("typeId");
//			
//			List<BusinessShop> shopList = businessShopService.findAll();
//			BusinessShopType shopType = businessShopTypeService.findById(Integer.valueOf(typeId));
//			if (StringUtils.isNotBlank(shopType.getTypeName()))
//				mav.addObject("typeName", shopType.getTypeName());
//			if (StringUtils.isNotBlank(estateId))
//				mav.addObject("estateId", estateId);
//			if (StringUtils.isNotBlank(userId))
//				mav.addObject("userId", userId);
//			String path = request.getContextPath();
//			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
//			mav.addObject("ctx", ctx);
//			mav.addObject("shopList", shopList);
			
		}catch(Exception e){
			GSLogger.error("进入shop列表页时发生错误：/service/shop/shopList", e);
			e.printStackTrace();
		}
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessShopQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BaseBean baseBean = businessShopService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessShop businessShop = (BusinessShop) baseBean.getList().get(i);
				result.append("{")
			    .append("\"shopId\":\"").append(businessShop.getShopId()).append("\"").append(",")
			    .append("\"shopCode\":\"").append(businessShop.getShopCode()).append("\"").append(",")
			    .append("\"shopKey\":\"").append(businessShop.getShopKey()).append("\"").append(",")
			    .append("\"shopName\":\"").append(businessShop.getShopName()).append("\"").append(",")
			    .append("\"shopImg\":\"").append(businessShop.getShopImg()).append("\"").append(",")
			    .append("\"shopDesc\":\"").append(businessShop.getShopDesc()).append("\"").append(",")
			    .append("\"shopAddr\":\"").append(businessShop.getShopAddr()).append("\"").append(",")
			    .append("\"shopUrl\":\"").append(businessShop.getShopUrl()).append("\"").append(",")
			    .append("\"typeId\":\"").append(businessShop.getTypeId()).append("\"").append(",")
			    .append("\"creatTime\":\"").append(businessShop.getCreatTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessShop.getEditTime()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessShop.getEditor()).append("\"")
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
			GSLogger.error("显示businessShop列表时发生错误：/business/businessShop/list", e);
			e.printStackTrace();
		}
	}
	
}
