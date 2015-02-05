package com.community.service.shop;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.BusinessShop;
import com.community.app.module.bean.BusinessShopType;
import com.community.app.module.bean.BusinessToken;
import com.community.app.module.service.BusinessShopService;
import com.community.app.module.service.BusinessShopTypeService;
import com.community.app.module.service.BusinessTokenService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessShopQuery;
import com.community.framework.utils.ClientCustomSSL;
import com.community.framework.utils.DefaultConfig;


@Controller
@RequestMapping("/service/shop")
public class ShopController {
	private static Logger GSLogger = LoggerFactory.getLogger(ShopController.class);
	@Autowired
	private BusinessShopService businessShopService;
	@Autowired
	private BusinessShopTypeService businessShopTypeService;
	@Autowired
	private BusinessTokenService businessTokenService;
	
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

			List<BusinessShop> shopList = businessShopService.findAll();
			BusinessShopType shopType = businessShopTypeService.findById(Integer.valueOf(typeId));
			
			if (StringUtils.isNotBlank(shopType.getTypeName()))
				mav.addObject("typeName", shopType.getTypeName());
			if (StringUtils.isNotBlank(estateId))
				mav.addObject("estateId", estateId);
			if (StringUtils.isNotBlank(userId))
				mav.addObject("userId", userId);
			if (StringUtils.isNotBlank(typeId))
				mav.addObject("typeId", typeId);
			
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
	 * 用户查看订单列表 for H5
	 * @param shopType ,estateId,userId 
	 * @return
	 * json
	 */
	@RequestMapping(value="getOrderListPage")
	public ModelAndView getOrderListPage(HttpServletRequest request, HttpServletResponse response,BusinessShopQuery query) {
		ModelAndView mav = new ModelAndView("/service/shop/orderList");
		try{
			
			String estateId = request.getParameter("estateId");
			String userId = request.getParameter("userId");
			
			if (StringUtils.isNotBlank(estateId))
				mav.addObject("estateId", estateId);
			if (StringUtils.isNotBlank(userId))
				mav.addObject("userId", userId);

			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
			mav.addObject("ctx", ctx);

		}catch(Exception e){
			GSLogger.error("进入shop列表页时发生错误：/service/shop/shopList", e);
			e.printStackTrace();
		}
		return mav;
	}
	
	/**
	 * 用户查看商铺列表 for H5
	 * @param shopType ,estateId,userId ,
	 * type=SL/MO  ShopList MyOrder
	 * @return
	 * json
	 */
	@RequestMapping(value="enterShop")
	public ModelAndView enterShop(HttpServletRequest request, HttpServletResponse response,BusinessShopQuery query) {
		ModelAndView mav = new ModelAndView("/service/shop/shopIframe");
		try{
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
			String bu54tk = "" ;
			
			String estateId = request.getParameter("estateId");
			String userId = request.getParameter("userId");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("estateId", estateId);
			map.put("userId", userId);

			BusinessToken loTkn = businessTokenService.findById(Integer.valueOf(userId));
			BusinessShop shop = businessShopService.findById(query.getShopId());
			if (loTkn != null)
			{
				bu54tk = loTkn.getToken();
			}else
			{
				Map<String,Object> userInfo = businessShopService.findUserInfo(map); 
				userInfo.put("authenticationString", DefaultConfig.getProperty("authenticationString"));
				JSONObject json = JSONObject.fromObject(userInfo);
				System.out.println("reqJson ===> "+ json);
				String cerPath=ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath(DefaultConfig.getProperty("cerPath"));
	    		String loginUrl = DefaultConfig.getProperty("loginUrl");  
		    	JSONObject rspJson = ClientCustomSSL.httpPost(cerPath, loginUrl, json);// HttpReq.post(loginUrl, json);
		    	System.out.println("rspJson ===> "+ rspJson);
		    	//登陆 返回的status 1：登陆成功 2 用户不存在 3 密码不正确
		    	if (rspJson != null)
				{
		    		BusinessToken token = new BusinessToken();
		    		if (StringUtils.isNotBlank(String.valueOf(rspJson.get("status"))) &&  "1".equals(String.valueOf(rspJson.get("status"))))
		    		{
		    			System.out.println("登陆返回 状态： "+rspJson);
						bu54tk = String.valueOf(rspJson.get("token"));
						token.setUserId(Integer.valueOf(userId));
						token.setToken(String.valueOf(rspJson.get("token")));
						businessTokenService.save(token);
		    		}else if (StringUtils.isNotBlank(String.valueOf(rspJson.get("status"))) &&  "2".equals(String.valueOf(rspJson.get("status"))))
		    		{
			    		String regUrl = DefaultConfig.getProperty("regUrl");			  
				    	JSONObject rspJsonReg = ClientCustomSSL.httpPost(cerPath, regUrl, json);//HttpReq.post(regUrl, json);
				    	System.out.println("注册返回 状态： "+rspJson);
						bu54tk = String.valueOf(rspJsonReg.get("token"));
						token.setUserId(Integer.valueOf(userId));
						token.setToken(String.valueOf(rspJson.get("token")));
						businessTokenService.save(token);
		    		}else if (StringUtils.isNotBlank(String.valueOf(rspJson.get("status"))) &&  "3".equals(String.valueOf(rspJson.get("status"))))
					{

					}
				}
			}
			
			mav.addObject("ctx", ctx);
			String goUrl = shop.getShopUrl();
			if (shop.getShopUrl().indexOf("token")>0)
				goUrl+=bu54tk;
			mav.addObject("shopURL", goUrl); 
			System.out.println("跳转 URL =====> "+goUrl);
		}catch(Exception e){
			GSLogger.error("进入shop列表页时发生错误：/service/shop/shopList", e);
			e.printStackTrace();
		}
		return mav;
	}
	
	
	
	@RequestMapping(value="myOrder")
	public ModelAndView myOrder(HttpServletRequest request, HttpServletResponse response,BusinessShopQuery query) {
		ModelAndView mav = new ModelAndView("/service/shop/shopIframe");
		try{
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;

			String estateId = request.getParameter("estateId");
			String userId = request.getParameter("userId");
			String bu54tk = "";
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("estateId", estateId);
			map.put("userId", userId);
	    	BusinessToken loTkn = businessTokenService.findById(Integer.valueOf(userId));
			if (loTkn != null)
			{
				bu54tk = loTkn.getToken();
			}else
			{
				Map<String,Object> userInfo = businessShopService.findUserInfo(map); 
				userInfo.put("authenticationString", DefaultConfig.getProperty("authenticationString"));
				JSONObject json = JSONObject.fromObject(userInfo);
				System.out.println("reqJson ===> "+ json);
				String cerPath=ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath(DefaultConfig.getProperty("cerPath"));
	    		String loginUrl = DefaultConfig.getProperty("loginUrl");  
		    	JSONObject rspJson = ClientCustomSSL.httpPost(cerPath, loginUrl, json);// HttpReq.post(loginUrl, json);
		    	System.out.println("rspJson ===> "+ rspJson);
		    	//登陆 返回的status 1：登陆成功 2 用户不存在 3 密码不正确
		    	if (rspJson != null)
				{
		    		BusinessToken token = new BusinessToken();
		    		if (StringUtils.isNotBlank(String.valueOf(rspJson.get("status"))) &&  "1".equals(String.valueOf(rspJson.get("status"))))
		    		{
		    			System.out.println("登陆返回 状态： "+rspJson);
						bu54tk = String.valueOf(rspJson.get("token"));
						token.setUserId(Integer.valueOf(userId));
						token.setToken(String.valueOf(rspJson.get("token")));
						businessTokenService.save(token);
		    		}else if (StringUtils.isNotBlank(String.valueOf(rspJson.get("status"))) &&  "2".equals(String.valueOf(rspJson.get("status"))))
		    		{
			    		String regUrl = DefaultConfig.getProperty("regUrl");			  
				    	JSONObject rspJsonReg = ClientCustomSSL.httpPost(cerPath, regUrl, json);//HttpReq.post(regUrl, json);
				    	System.out.println("注册返回 状态： "+rspJsonReg);
						bu54tk = String.valueOf(rspJsonReg.get("token"));
						token.setUserId(Integer.valueOf(userId));
						token.setToken(String.valueOf(rspJsonReg.get("token")));
						businessTokenService.save(token);
		    		}else if (StringUtils.isNotBlank(String.valueOf(rspJson.get("status"))) &&  "3".equals(String.valueOf(rspJson.get("status"))))
					{

					}
				}
			}

			mav.addObject("ctx", ctx);
			String goUrl = "http://wx.5teacher.com/wap/do/weixin/order/list/?openId="+bu54tk;
			mav.addObject("shopURL", goUrl);
			System.out.println("跳转 URL =====> "+goUrl);
		}catch(Exception e){
			GSLogger.error("进入shop列表页时发生错误：/service/shop/shopList", e);
			e.printStackTrace();
		}
		return mav;
	}
	
	
	/**
	 * 将cookie封装到Map里面
	 * @param request
	 * @return
	 */
	private static Map<String,Cookie> ReadCookieMap(HttpServletRequest request){  
	    Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
	    Cookie[] cookies = request.getCookies();
	    if(null!=cookies){
	        for(Cookie cookie : cookies){
	            cookieMap.put(cookie.getName(), cookie);
	        }
	    }
	    return cookieMap;
	}
	public static void addCookie(HttpServletResponse response,String name,String value,int maxAge){
	    Cookie cookie = new Cookie(name,value);
	    cookie.setPath("/");
	    if(maxAge>0)  cookie.setMaxAge(maxAge);
	    response.addCookie(cookie);
	}
	
	public static Cookie getCookieByName(HttpServletRequest request,String name){
	    Map<String,Cookie> cookieMap = ReadCookieMap(request);
	    if(cookieMap.containsKey(name)){
	        Cookie cookie = (Cookie)cookieMap.get(name);
	        return cookie;
	    }else{
	        return null;
	    }   
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
