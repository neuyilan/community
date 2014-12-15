package com.community.service.secondaryMarket;



/**
 * 二手相关处理接口
 * 包括：
 * 用户信息
 * 
 * @author whh-2_000
 *
 */

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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


import com.community.app.module.vo.AppLatestNewsQuery;
import com.community.app.module.vo.BusinessBreakQuery;
import com.community.app.module.vo.BusinessNewsQuery;
import com.community.app.module.vo.BusinessProductCommentQuery;
import com.community.app.module.vo.BusinessProductQuery;
import com.community.app.module.vo.BusinessProductSupportQuery;
import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppStatisticsClick;
import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.BusinessAnno;
import com.community.app.module.bean.BusinessNews;
import com.community.app.module.bean.BusinessProduct;
import com.community.app.module.bean.BusinessProductComment;
import com.community.app.module.bean.BusinessProductKeyword;
import com.community.app.module.bean.BusinessProductSupport;
import com.community.app.module.bean.BusinessProductType;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppStatisticsClickService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.BusinessAnnoService;
import com.community.app.module.service.BusinessProductCommentService;
import com.community.app.module.service.BusinessProductKeywordService;
import com.community.app.module.service.BusinessProductService;
import com.community.app.module.service.BusinessProductSupportService;
import com.community.app.module.service.BusinessProductTypeService;
import com.community.app.module.vo.BusinessAnnoQuery;
import com.community.framework.utils.DateUtil;
import com.community.framework.utils.propertiesUtil;
import com.community.framework.utils.testfilter.src.com.gao.SensitivewordFilter;


@Controller
@RequestMapping("/service/secondaryMarket")
public class SecondaryMarketController {
	private static Logger GSLogger = LoggerFactory.getLogger(SecondaryMarketController.class);
	@Autowired
	private BusinessProductService businessProductService;
	@Autowired
	private BusinessProductCommentService businessProductCommentService;
	@Autowired
	private BusinessProductSupportService businessProductSupportService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	@Autowired
	private AppStatisticsClickService appStatisticsClickService;
	@Autowired
	private BusinessProductTypeService businessProductTypeService;
	@Autowired
	private BusinessProductKeywordService businessProductKeywordService;
	
	
	
	
	/**
	 * 用户查看自己发布的二手列表
	 * @param userId,sessionid,type,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="findListByUser")
	public void findListByUser(HttpServletRequest request, HttpServletResponse response,BusinessProductQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setPublisherId(query.getUserId());
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("editTime");
			BaseBean baseBean = businessProductService.findAllPage_app(query);
			AppLatestNewsQuery appLatestNewsQuery = new AppLatestNewsQuery();
			appLatestNewsQuery.setUserId(query.getUserId());
			appLatestNewsQuery.setTo(0);
			appLatestNewsQuery.setTypeId(6);
			List<AppLatestNews> list = appLatestNewsService.findByExample(appLatestNewsQuery);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTypeId(2);
			appLatestNews.setTo(0);
			appLatestNewsService.delete_app(appLatestNews);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"list\":[";
			boolean flag1=false;
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessProduct businessProduct = (BusinessProduct) baseBean.getList().get(i);
				if(businessProduct.getDealState()==5){
					continue;
				}else {
					flag1=true;
				}
				json += "{\"ID\":\""+businessProduct.getProductId()+"\",\"time\":\""
				+DateUtil.getInterval(businessProduct.getEditTime()).substring(0, DateUtil.getInterval(businessProduct.getEditTime()).indexOf(" "))+"\",\"brief\":\""+businessProduct.getContent()+"\",\"type\":\""+businessProduct.getDealType()+"\","+
						"\"price\":\""+businessProduct.getPrice()+"\",\"remarks\":\""+businessProduct.getRemarks()+"\",\"typeId\":\""+businessProduct.getTypeId()+"\",\"typeName\":\""+businessProduct.getTypeName()+"\",\"visits\":\""+businessProduct.getVisits()+"\",\"dealState\":\""+businessProduct.getDealState()+"";
				boolean  flag = false ; //二手列表状态
				for (AppLatestNews appLatestNews2 : list) {
					if(appLatestNews2.getSourceId().equals(businessProduct.getProductId())){
						flag = true;
					}
				}
				if (flag) {
					json += "\",\"status\":true";
				}else {
					json += "\",\"status\":false";
				}
				json +="},";
			}
			if(flag1) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
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
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			if(null==query.getUserId()){
				appStatisticsClick.setUserId(0);
			}else{
				appStatisticsClick.setUserId(query.getUserId());
			}
			appStatisticsClick.setType(61);
			appStatisticsClick.setTypeName("我的跳蚤市场列表");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户发布商品
	 * @param userId,sessionid,productId,name,price,desc,contact,cellphone,qq,weixin,isAgent,pics,submitType
	 * @return
	 * json
	 */
	@RequestMapping(value="addProduct")
	public void addProduct(HttpServletRequest request, HttpServletResponse response,BusinessProductQuery query) {
		String json = "";
		Map map = (Map) request.getAttribute("resultMap");
		Map<String,String> param=(Map) map.get("param");
		Map<String,String> image=(Map) map.get("image");
		try{
			query.setParam(param);
			query.setImage(image);
			businessProductService.addProduct(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"发布成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"发布失败\"";
			json += "}";
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
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			appStatisticsClick.setUserId(new Integer(param.get("userId")));
			appStatisticsClick.setType(7);
			appStatisticsClick.setTypeName("发布跳蚤");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户编辑商品
	 * @param userId,sessionid,productId,name,price,desc,contact,cellphone,qq,weixin,isAgent,pics,submitType
	 * @return
	 * json
	 */
	@RequestMapping(value="editProduct")
	public void editProduct(HttpServletRequest request, HttpServletResponse response,BusinessProductQuery query) {
		String json = "";
		Map map = (Map) request.getAttribute("resultMap");
		Map<String,String> param=(Map) map.get("param");
		Map<String,String> image=(Map) map.get("image");
		try{
			query.setParam(param);
			query.setImage(image);
			businessProductService.editProduct(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"编辑成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"编辑失败\"";
			json += "}";
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
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			appStatisticsClick.setUserId(new Integer(param.get("userId")));
			appStatisticsClick.setType(8);
			appStatisticsClick.setTypeName("编辑跳蚤");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户获取二手类回复我的详情
	 * @param userId,sessionid,productId
	 * @return
	 * json
	 */
	@RequestMapping(value="findInformationProductDetail")
	public void findInformationProductDetail(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("userId:"+request.getParameter("userId"));
		//System.out.println("sessionid:"+request.getParameter("sessionid"));
		//System.out.println("productId:"+request.getParameter("productId"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"获取成功\",";
		json += "\"content\":{";
		json += "\"peopleId\":\"1\",\"title\":\"标题\",\"price\":\"110\",\"sellType\":\"销售类型\",";
		json += "\"state\":\"状态\",\"content\":\"内容\",\"supports\":\"110\",\"comments\":\"111\",";
		json += "\"publisher\":\"张三\",\"publisherId\":\"12\",\"contact\":\"李四\",\"cellphone\":\"11011111\",\"qq\":\"13141314\",";
		json += "\"address\":\"地址\",\"agentStation\":\"代售驿站\",\"avatar\":\"头像\",";
		json += "\"detail\":[";
		json += "{\"userId\":\"1\",\"avatar\":\"头像\",\"name\":\"张三\",\"commentTime\":\"2011-11-11 19:11:11\",\"replyName \":\"招六\",\"replyId \":\"12\",\"content \":\"你好\"},";
		json += "{\"userId\":\"1\",\"avatar\":\"头像\",\"name\":\"张三\",\"commentTime\":\"2011-11-11 19:11:11\",\"replyName \":\"招六\",\"replyId \":\"12\",\"content \":\"你好\"}";
		json += "]";
		json += "}";
		json += "}";
		
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
	 * 用户查看跳蚤市场列表
	 * @param userId,sessionid,page,rows,type,estateId
	 * @return
	 * json
	 */
	@RequestMapping(value="findBySecondaryMarket")
	public void findBySecondaryMarket(HttpServletRequest request, HttpServletResponse response,BusinessProductQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			if(query.getType()==1){
				query.setEstateId(null);
			}else if (query.getType()==0) {
				query.setEstateId(null);
				query.setComId(null);
			}else {
				query.setComId(null);
			}
			if(query.getDealType()==0){
				query.setDealType(null);
			}
			query.setType(null);
			query.setDealState(0);
			query.setOrder("desc");
			query.setSort("editTime");
			BaseBean baseBean = businessProductService.findAllPage_app(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"count\":\""+baseBean.getCount()+"\",";
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"list\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessProduct businessProduct = (BusinessProduct) baseBean.getList().get(i);
				json += "{\"ID\":\""+businessProduct.getProductId()+"\",\"title\":\""+businessProduct.getTitle()+"\",\"time\":\""
				+DateUtil.getInterval(businessProduct.getEditTime()).substring(0, DateUtil.getInterval(businessProduct.getEditTime()).indexOf(" "))+"\",\"brief\":\""+businessProduct.getContent()+"\",\"publisherId\":\""+businessProduct.getPublisherId()+"\","
						+"\"publisherName\":\""+businessProduct.getPublisherName()+"\",\"avatar\":\""+ip+businessProduct.getPortrait()+"\","
						+"\"addr\":\""+businessProduct.getEstateScope()+"\",\"type\":\""+businessProduct.getDealType()+"\",\"OnSale\":\""+businessProduct.getIsEstateAgent()+
						"\",\"price\":\""+businessProduct.getPrice()+"\",\"pic\":\"";
				if(businessProduct.getPicUrl()!=null){
					String[] pic = businessProduct.getPicUrl().split(",");
					json += ip+pic[0];
				}
				json += "\"},";
			}
			if(baseBean.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
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
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			if(null==query.getUserId()){
				appStatisticsClick.setUserId(0);
			}else{
				appStatisticsClick.setUserId(query.getUserId());
			}
			appStatisticsClick.setType(5);
			appStatisticsClick.setTypeName("跳蚤市场列表");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看跳蚤市场详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getsecondaryMarketDetailsById")
	public void getsecondaryMarketDetailsById(HttpServletRequest request, HttpServletResponse response,BusinessProductQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			BusinessProduct businessProduct = businessProductService.findById_app(query.getID());
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTypeId(6);
			appLatestNews.setTo(0);
			appLatestNews.setSourceId(query.getID());
			appLatestNewsService.delete_app_id(appLatestNews);
			appLatestNews.setTypeId(8);
			appLatestNewsService.delete_app_id(appLatestNews);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"ID\":\""+businessProduct.getProductId()+"\",\"title\":\""+businessProduct.getTitle()+"\",\"time\":\""
			+DateUtil.getInterval(businessProduct.getEditTime())+"\",\"content\":\""+businessProduct.getContent()+"\",\"publisherId\":\""+businessProduct.getPublisherId()+"\","
					+"\"publisherName\":\""+businessProduct.getNickname()+"\",\"avatar\":\""+ip+businessProduct.getPortrait()+"\","
					+ "\"addr\":\""+businessProduct.getEstateScope()+"\",\"type\":\""+businessProduct.getDealType()+"\",\"OnSale\":\""+businessProduct.getIsEstateAgent()+
					"\",\"price\":\""+businessProduct.getPrice()+"\",\"supports\":\""+businessProduct.getSupports()+"\",\"comments\":\""+businessProduct.getComments()+"\",";
			json += "\"contact\":\""+businessProduct.getContactName()+"\",";
			json += "\"cellphone\":\""+businessProduct.getContactTel()+"\",";
			json += "\"qq\":\""+businessProduct.getContactQq()+"\",";
			json += "\"address\":\""+businessProduct.getEstateScope()+"\",";
			json += "\"OnSale\":\""+businessProduct.getIsEstateAgent()+"\",";
			json += "\"addrName\":\""+businessProduct.getAddrName()+"\",";
			json += "\"addrUrl\":\""+ip+businessProduct.getAddrUrl()+"\",";
			json += "\"typeId\":\""+businessProduct.getTypeId()+"\",";
			json += "\"typeName\":\""+businessProduct.getTypeName()+"\",";
			if(businessProduct.getDealState()==0){
				json += "\"state\":\"1\",";
			}else {
				json += "\"state\":\"0\",";
			}
			json += "\"pics\":[";
			if(businessProduct.getPicUrl()!=null){
				String[] pic = businessProduct.getPicUrl().split(",");
				for (int i = 0; i < pic.length; i++) {
					json += "{\"pic\":\""+ip+pic[i]+"\"},";
				}
				if(pic.length > 0) {
					json = json.substring(0, json.length()-1);
				}
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
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
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			if(null==query.getUserId()){
				appStatisticsClick.setUserId(0);
			}else{
				appStatisticsClick.setUserId(query.getUserId());
			}
			appStatisticsClick.setType(6);
			appStatisticsClick.setTypeName("跳蚤市场详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看跳蚤市场评论
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getSecondaryMarketReviewById")
	public void getSecondaryMarketReviewById(HttpServletRequest request, HttpServletResponse response,BusinessProductCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("commentTime");
			query.setProductId(query.getID());
			BaseBean baseBean = businessProductCommentService.findAllPage_app(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"reviewList\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessProductComment businessProductComment = (BusinessProductComment) baseBean.getList().get(i);
				json += "{\"userId\":\""+businessProductComment.getCommentorId()+"\",";
				if(businessProductComment.getCommentorState()==1){
					json +="\"avatar\":\""+ip+businessProductComment.getAvatar()+"\",\"name\":\""
							+businessProductComment.getBuNickname()+"\",";
				}else{
					json +="\"avatar\":\""+ip+businessProductComment.getPortrait()+"\",\"name\":\""
							+businessProductComment.getNickname()+"\",";
				}
				json +="\"commentTime\":\""+DateUtil.getInterval(businessProductComment.getCommentTime())+"\",";
					json += "\"replyName\":\""+businessProductComment.getReplyName()+"\",";
					json += "\"replyId\":\""+businessProductComment.getReplyId()+"\",";
					json += "\"content\":\""+businessProductComment.getContent()+"\",";
					if(businessProductComment.getCommentorState()==1){
						json +="\"userType\":\"1\",";
					}else{
						json +="\"userType\":\"0\",";
					}
					if(businessProductComment.getReplyState()==1){
						json +="\"replyType\":\"1\"";
					}else{
						json +="\"replyType\":\"0\"";
					}
					json += "},";
			}
			if(baseBean.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
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
	 * 用户查看跳蚤市场回复我的评论
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getSecondaryMarketReviewByUserId")
	public void getSecondaryMarketReviewByUserId(HttpServletRequest request, HttpServletResponse response,BusinessProductCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("commentTime");
			query.setProductId(query.getID());
			query.setCommentorState(0);
			query.setReplyState(0);
			BaseBean baseBean = businessProductCommentService.findAllPage_app(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"count\":\""+baseBean.getCount()+"\",";
			json += "\"reviewList\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessProductComment businessProductComment = (BusinessProductComment) baseBean.getList().get(i);
				json += "{\"userId\":\""+businessProductComment.getCommentorId()+"\",";
				if(businessProductComment.getCommentorState()==1){
					json +="\"avatar\":\""+ip+businessProductComment.getAvatar()+"\",\"name\":\""
							+businessProductComment.getBuNickname()+"\",";
				}else{
					json +="\"avatar\":\""+ip+businessProductComment.getPortrait()+"\",\"name\":\""
							+businessProductComment.getNickname()+"\",";
				}
				json +="\"commentTime\":\""+DateUtil.getInterval(businessProductComment.getCommentTime())+"\",";
					json += "\"replyName\":\""+businessProductComment.getReplyName()+"\",";
					json += "\"replyId\":\""+businessProductComment.getReplyId()+"\",";
					json += "\"content\":\""+businessProductComment.getContent()+"\",";
					if(businessProductComment.getCommentorState()==1){
						json +="\"userType\":\"1\",";
					}else{
						json +="\"userType\":\"0\",";
					}
					if(businessProductComment.getReplyState()==1){
						json +="\"replyType\":\"1\"";
					}else{
						json +="\"replyType\":\"0\"";
					}
					json += "},";
			}
			if(baseBean.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
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
	 * 用户评论跳蚤市场
	 * @param userId,sessionid,ID,content
	 * @return
	 * json
	 */
	@RequestMapping(value="saveSecondaryMarketReview")
	public void saveSecondaryMarketReview(HttpServletRequest request, HttpServletResponse response,BusinessProductCommentQuery query) {
		String json = "";
		try{
			BusinessProductComment businessProductComment = new BusinessProductComment();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessProductComment.setCommentTime(ts);
			businessProductComment.setProductId(query.getID());
			businessProductComment.setCommentorId(query.getUserId());
			businessProductComment.setContent(SensitivewordFilter.replaceSensitiveWord(query.getContent(),1,"*"));
			businessProductComment.setCommentorState(0);//居民
			businessProductComment.setReplyState(0);
			if(null==query.getReplyId()){
				businessProductComment.setReplyId(0);
			}else{
				businessProductComment.setReplyId(query.getReplyId());
			}
			if(null==query.getReplyName()){
				businessProductComment.setReplyName("");
			}else{
				businessProductComment.setReplyName(query.getReplyName());
			}
			businessProductCommentService.save(businessProductComment);
			BusinessProduct businessProduct = businessProductService.findById(query.getID());
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setSourceId(query.getID());
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			appLatestNews.setUserId(query.getPublisherId());
			appLatestNews.setTypeId(2);//我的二手
			appLatestNewsService.save_app(appLatestNews);
			appLatestNews.setTypeId(6);//我的二手列表
			appLatestNewsService.save_app(appLatestNews);
			appLatestNews.setTypeId(3);//已发布
			appLatestNewsService.save_app(appLatestNews);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"评论成功\",";
			json += "\"content\":{";
			json += "\"comments\":\""+businessProduct.getComments()+"\"";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"评论失败\"";
			json += "}";
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
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			if(null==query.getUserId()){
				appStatisticsClick.setUserId(0);
			}else{
				appStatisticsClick.setUserId(query.getUserId());
			}
			appStatisticsClick.setType(10);
			appStatisticsClick.setTypeName("评论跳蚤");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	
	/**
	 * 用户回复跳蚤市场
	 * @param userId,sessionid,ID,replyId,replyName,content
	 * @return
	 * json
	 */
	@RequestMapping(value="saveSecondaryMarketReply")
	public void saveSecondaryMarketReply(HttpServletRequest request, HttpServletResponse response,BusinessProductCommentQuery query) {
		String json = "";
		try{
			BusinessProductComment businessProductComment = new BusinessProductComment();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessProductComment.setCommentTime(ts);
			businessProductComment.setProductId(query.getID());
			businessProductComment.setCommentorId(query.getUserId());
			businessProductComment.setContent(SensitivewordFilter.replaceSensitiveWord(query.getContent(),1,"*"));
			businessProductComment.setCommentorState(0);//居民
			if(query.getReplyType()==null){
				businessProductComment.setReplyState(0);
			}else{
				businessProductComment.setReplyState(query.getReplyType());
			}
			if(null==query.getReplyId()){
				businessProductComment.setReplyId(0);
			}else{
				businessProductComment.setReplyId(query.getReplyId());
			}
			if(null==query.getReplyName()){
				businessProductComment.setReplyName("");
			}else{
				businessProductComment.setReplyName(query.getReplyName());
			}
			businessProductCommentService.save(businessProductComment);
			BusinessProduct businessProduct = businessProductService.findById(query.getID());
			AppUserNews appUserNews = new AppUserNews();
			appUserNews.setUserId(query.getReplyId());
			appUserNews.setCreateTime(ts);
			appUserNews.setNewTitle(businessProduct.getTitle());
			appUserNews.setType(10);
			appUserNews.setId(query.getID());
			appUserNews.setContent("");
			appUserNews.setLastMessage(SensitivewordFilter.replaceSensitiveWord(query.getContent(),1,"*"));
			appUserNews.setLastMessageName(query.getUserId()+"");
			appUserNewsService.saveReply(appUserNews);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getReplyId());
			appLatestNews.setTypeId(7);
			appLatestNews.setSourceId(query.getID());
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			appLatestNewsService.save_app(appLatestNews);
			appLatestNews.setTypeId(8);
			appLatestNewsService.save_app(appLatestNews);
			appLatestNews.setTypeId(9);
			appLatestNewsService.save_app(appLatestNews);
			appLatestNews.setUserId(query.getPublisherId());
			appLatestNews.setTypeId(2);//我的二手
			appLatestNewsService.save_app(appLatestNews);
			appLatestNews.setTypeId(6);//我的二手列表
			appLatestNewsService.save_app(appLatestNews);
			appLatestNews.setTypeId(3);//已发布
			appLatestNewsService.save_app(appLatestNews);
			
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"回复成功\",";
			json += "\"content\":{";
			json += "\"comments\":\""+businessProduct.getComments()+"\"";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"回复失败\"";
			json += "}";
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
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			if(null==query.getUserId()){
				appStatisticsClick.setUserId(0);
			}else{
				appStatisticsClick.setUserId(query.getUserId());
			}
			appStatisticsClick.setType(11);
			appStatisticsClick.setTypeName("回复跳蚤");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户点赞商品
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="supportSecondaryMarket")
	public void supportSecondaryMarket(HttpServletRequest request, HttpServletResponse response,BusinessProductCommentQuery query) {
		String json = "";
		try{
			BusinessProductSupportQuery businessProductSupportQuery = new BusinessProductSupportQuery();
			businessProductSupportQuery.setUserId(query.getUserId());
			businessProductSupportQuery.setProductId(query.getID());
			int count =businessProductSupportService.selectCount(businessProductSupportQuery);
			if(count==0){
				BusinessProductSupport businessProductSupport = new BusinessProductSupport();
				businessProductSupport.setUserId(query.getUserId());
				businessProductSupport.setProductId(query.getID());
				Timestamp  ts=new Timestamp(new Date().getTime());
				businessProductSupport.setCreateTime(ts);
				businessProductSupportService.save(businessProductSupport);
				BusinessProduct businessProduct = businessProductService.findById(query.getID());
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"点赞成功\",";
				json += "\"content\":{";
				json += "\"supports\":\""+businessProduct.getSupports()+"\"";
				json += "}";
				json += "}";
			}else{
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"已赞过了，再赞他会骄傲的…\"";
				json += "}";
			}
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"已赞过了，再赞他会骄傲的…\"";
			json += "}";
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
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			if(null==query.getUserId()){
				appStatisticsClick.setUserId(0);
			}else{
				appStatisticsClick.setUserId(query.getUserId());
			}
			appStatisticsClick.setType(9);
			appStatisticsClick.setTypeName("点赞跳蚤");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户获取商品类型
	 * @param userId,sessionid,productId
	 * @return
	 * json
	 */
	@RequestMapping(value="getproductTypeList")
	public void getproductTypeList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			List<BusinessProductType> list = businessProductTypeService.findAll();
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"list\":[";
			for (BusinessProductType businessProductType : list) {
				json += "{\"typeId\":\""+businessProductType.getTypeId()+"\",\"typeName\":\""+businessProductType.getTypeName()+"\",\"typeImage\":\""+ip+businessProductType.getTypeImage()+"\"},";
			}
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
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
	 * 用户查看商品热门关键字
	 * @param userId,sessionid,productId
	 * @return
	 * json
	 */
	@RequestMapping(value="productKeywordList")
	public void productKeywordList(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			List<BusinessProductKeyword> list = businessProductKeywordService.findAll();
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"list\":[";
			for (BusinessProductKeyword businessProductKeyword : list) {
				json += "{\"keyword\":\""+businessProductKeyword.getKeyword()+"\"},";
			}
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"获取失败\"";
			json += "}";
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
