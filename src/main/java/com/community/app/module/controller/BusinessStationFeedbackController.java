package com.community.app.module.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.BusinessStationFeedback;
import com.community.app.module.bean.BusinessStationFeedbackInformation;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.BusinessStationFeedbackInformationService;
import com.community.app.module.service.BusinessStationFeedbackService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessStationFeedbackInformationQuery;
import com.community.app.module.vo.BusinessStationFeedbackQuery;
import com.community.framework.utils.CommonUtils;

@Controller
@RequestMapping("/business/businessStationFeedback")
public class BusinessStationFeedbackController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessStationFeedbackController.class);
	@Autowired
	private BusinessStationFeedbackService businessStationFeedbackService;
	@Autowired
	private BusinessStationFeedbackInformationService businessStationFeedbackInformationService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(BusinessStationFeedbackQuery query) {	
		List<?> comList = null;
		BaseBean baseBean = new BaseBean();	
		try{
			ShiroUser shiroUser = CommonUtils.getUser();

			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setComId(shiroUser.getCurComId());
			}
			if(shiroUser.getCurEstateId() != null) {
				query.setEstateId(shiroUser.getCurEstateId());
			}
			comList = shiroUser.getComList();
			query.setSort("totalPoll");
			query.setOrder("desc");
			query.setRows(20);
			
			baseBean = businessStationFeedbackService.findAllPage(query);
		}catch(Exception e){
			GSLogger.error("进入businessStationFeedback管理页时发生错误：/module/stationFeedback/feedList", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/stationFeedback/feedList");
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		mav.addObject("comList", comList);
		return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessStationFeedbackQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		ShiroUser shiroUser = CommonUtils.getUser();
		try{
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setComId(shiroUser.getCurComId());
			}
			if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
				query.setEstateId(shiroUser.getCurEstateId());
			}
			query.setSort("totalPoll");
			query.setOrder("desc");
			query.setRows(20);
			BaseBean baseBean = businessStationFeedbackService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessStationFeedback businessStationFeedback = (BusinessStationFeedback) baseBean.getList().get(i);
				result.append("{")
			    .append("\"feedId\":\"").append(businessStationFeedback.getFeedId()).append("\"").append(",")
			    .append("\"comId\":\"").append(businessStationFeedback.getComId()).append("\"").append(",")
			    .append("\"comName\":\"").append(businessStationFeedback.getComName()).append("\"").append(",")
			    .append("\"estateId\":\"").append(businessStationFeedback.getEstateId()).append("\"").append(",")
			    .append("\"estateName\":\"").append(businessStationFeedback.getEstateName()).append("\"").append(",")
			    .append("\"state\":\"").append(businessStationFeedback.getState()).append("\"").append(",")
			    .append("\"yznh\":\"").append(businessStationFeedback.getYznh()).append("\"").append(",")
			    .append("\"kdds\":\"").append(businessStationFeedback.getKdds()).append("\"").append(",")
			    .append("\"yzgg\":\"").append(businessStationFeedback.getYzgg()).append("\"").append(",")
			    .append("\"totalPoll\":\"").append(businessStationFeedback.getTotalPoll()).append("\"")
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
			GSLogger.error("显示businessStationFeedback列表时发生错误：/module/stationFeedback/feedList", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入反馈详情列表页
	 * @return
	 */
	@RequestMapping(value="getFeedDetail")
	public ModelAndView getFeedDetail(BusinessStationFeedbackInformationQuery query) {
		BaseBean baseBean = new BaseBean();
		StringBuffer sbFlag = new StringBuffer();
		BusinessStationFeedback businessStationFeedback = businessStationFeedbackService.findById(query.getFeedId());
		try{
			query.setSort("feedTime");
			query.setOrder("desc");
			query.setRows(20);
			baseBean = businessStationFeedbackInformationService.findAllPage(query);
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("feedId", query.getFeedId());
			List<BusinessStationFeedbackInformation> feedInforList= businessStationFeedbackInformationService.findByMap(paramMap);
			for(int i=0;i<feedInforList.size();i++) {
				BusinessStationFeedbackInformation businessStationFeedbackInformation = (BusinessStationFeedbackInformation) feedInforList.get(i);
				sbFlag.append(","+businessStationFeedbackInformation.getFlag());
			}
		}catch(Exception e){
			GSLogger.error("进入反馈详情列表页时发生错误：/module/stationFeedback/feedDetail", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/stationFeedback/feedDetail");
		if(sbFlag.substring(1).contains("0")) {
			mav.addObject("flagNew", "0");
			mav.addObject("sbFlagNew", sbFlag.substring(1));
		} else {
			mav.addObject("flagNew", "1");
			mav.addObject("sbFlagNew", "");
		}
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		mav.addObject("businessStationFeedback", businessStationFeedback);
		
		return mav;
	}
	
	/**
	 * 保存开始投票
	 * @return
	 */
	@RequestMapping(value="sendMessage")
	public void sendMessage(HttpServletRequest request, HttpServletResponse response, BusinessStationFeedbackQuery query) {
		String json = "";
		try{
			BusinessStationFeedback businessStationFeedback = businessStationFeedbackService.findById(query.getFeedId());
			if(businessStationFeedback != null) {
				BusinessStationFeedback bean = new BusinessStationFeedback();
				
				bean.setFeedId(query.getFeedId());
				bean.setState(1);
				businessStationFeedbackService.update(bean);
				
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("feedId", query.getFeedId());
				List<BusinessStationFeedbackInformation> feedInforList= businessStationFeedbackInformationService.findByMap(paramMap);
				
				for(int i=0;i<feedInforList.size();i++) {
					BusinessStationFeedbackInformation inforBean = (BusinessStationFeedbackInformation) feedInforList.get(i);
					inforBean.setFlag(1);
					businessStationFeedbackInformationService.update(inforBean);
					
					AppUserNews appUserNews = new AppUserNews();
					appUserNews.setUserId(inforBean.getUserId());
					appUserNews.setCreateTime(new Timestamp(System.currentTimeMillis()));
					appUserNews.setNewTitle("驿站开通投票通知");
					appUserNews.setType(6);
					appUserNews.setId(inforBean.getFeedId());
					appUserNews.setContent(query.getPushMessage());
					appUserNewsService.saveReply(appUserNews);
					
					AppLatestNews appLatestNews = new AppLatestNews();
					appLatestNews.setUserId(inforBean.getUserId());
					appLatestNews.setTypeId(7);
					appLatestNews.setSourceId(inforBean.getFeedId());
					appLatestNews.setTo(0);
					appLatestNews.setEstateId(0);
					appLatestNewsService.save_app(appLatestNews);
					
					appLatestNews.setTypeId(8);
					appLatestNewsService.save_app(appLatestNews);
					
					appLatestNews.setTypeId(10);
					appLatestNewsService.save_app(appLatestNews);
				}
			}
			json = "{\"success\":\"true\",\"message\":\"系统消息推送成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"系统消息推送失败\"}";
			GSLogger.error("进入反馈详情列表页时发生错误：/module/stationFeedback/feedDetail", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}