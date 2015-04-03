package com.community.app.module.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.community.app.module.bean.BusinessStationFeedback;
import com.community.app.module.bean.BusinessStationFeedbackInformation;
import com.community.app.module.service.BusinessStationFeedbackInformationService;
import com.community.app.module.service.BusinessStationFeedbackService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessStationFeedbackInformationQuery;

@Controller
@RequestMapping("/business/businessStationFeedbackInformation")
public class BusinessStationFeedbackInformationController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessStationFeedbackInformationController.class);
	@Autowired
	private BusinessStationFeedbackService businessStationFeedbackService;
	@Autowired
	private BusinessStationFeedbackInformationService businessStationFeedbackInformationService;
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public void list(BusinessStationFeedbackInformationQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			BusinessStationFeedback businessStationFeedback = businessStationFeedbackService.findById(query.getFeedId());
			query.setSort("feedTime");
			query.setOrder("desc");
			query.setRows(20);
			BaseBean baseBean = businessStationFeedbackInformationService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageSize\":").append(baseBean.getPager().getPageSize()).append(",");
			result.append("\"state\":").append(businessStationFeedback.getState()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessStationFeedbackInformation businessStationFeedbackInformation = (BusinessStationFeedbackInformation) baseBean.getList().get(i);
				result.append("{")
			    .append("\"inforId\":\"").append(businessStationFeedbackInformation.getInforId()).append("\"").append(",")
			    .append("\"feedId\":\"").append(businessStationFeedbackInformation.getFeedId()).append("\"").append(",")
			    .append("\"userId\":\"").append(businessStationFeedbackInformation.getUserId()).append("\"").append(",")
			    .append("\"realName\":\"").append(businessStationFeedbackInformation.getRealName()).append("\"").append(",")
			    .append("\"nickName\":\"").append(businessStationFeedbackInformation.getNickName()).append("\"").append(",")
			    .append("\"tel\":\"").append(businessStationFeedbackInformation.getTel()).append("\"").append(",")
			    .append("\"feedTime\":\"").append(businessStationFeedbackInformation.getFeedTime()).append("\"").append(",")
			    .append("\"source\":\"").append(businessStationFeedbackInformation.getSource()).append("\"").append(",")
			    .append("\"flag\":\"").append(businessStationFeedbackInformation.getFlag()).append("\"")
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
			GSLogger.error("显示businessStationFeedbackInformation列表时发生错误：/business/businessStationFeedbackInformation/list", e);
			e.printStackTrace();
		}
	}
}