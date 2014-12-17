package com.community.app.module.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.BusinessActivityRegistrationInformation;
import com.community.app.module.bean.BusinessActivityRegistrationTimeslot;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.BusinessActivityRegistrationInformationService;
import com.community.app.module.service.BusinessActivityRegistrationTimeslotService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityRegistrationInformationQuery;

@Controller
@RequestMapping("/business/businessActivityRegistrationInformation")
public class BusinessActivityRegistrationInformationController {
	private static Logger GSLogger = LoggerFactory
			.getLogger(BusinessActivityRegistrationInformationController.class);
	@Autowired
	private BusinessActivityRegistrationInformationService businessActivityRegistrationInformationService;
	@Autowired
	private BusinessActivityRegistrationTimeslotService businessActivityRegistrationTimeslotService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;

	/**
	 * 进入管理页
	 * 
	 * @return
	 */
	@RequestMapping(value = "enter")
	public ModelAndView enter() {
		try {
		} catch (Exception e) {
			GSLogger.error(
					"进入businessActivityRegistrationInformation管理页时发生错误：/business/businessActivityRegistrationInformation/enter",
					e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView(
				"/business/businessActivityRegistrationInformation/enter");
		return mav;
	}

	/**
	 * 列示或者查询所有数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "list")
	public void list(BusinessActivityRegistrationInformationQuery query,
			HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try {
			/*if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
				query.setSort(query.getOrderBy());
			}else{
				query.setSort("editTime");
			}*/
			query.setActId(query.getActId());
			query.setSort("informationId");
			query.setOrder("desc");
			query.setRows(20);
			BaseBean baseBean = businessActivityRegistrationInformationService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageSize\":").append(baseBean.getPager().getPageSize()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for (int i = 0; i < baseBean.getList().size(); i++) {
				BusinessActivityRegistrationInformation businessActivityRegistrationInformation = (BusinessActivityRegistrationInformation) baseBean.getList().get(i);
				result.append("{")
						.append("\"informationId\":\"").append(businessActivityRegistrationInformation.getInformationId()).append("\"").append(",")
						.append("\"userId\":\"").append(businessActivityRegistrationInformation.getUserId()).append("\"").append(",")
						.append("\"actId\":\"").append(businessActivityRegistrationInformation.getActId()).append("\"").append(",")
						.append("\"timeSlotId\":\"").append(businessActivityRegistrationInformation.getTimeSlotId()).append("\"").append(",")
						.append("\"nickname\":\"").append(businessActivityRegistrationInformation.getNickname()).append("\"").append(",")
						.append("\"realname\":\"").append(businessActivityRegistrationInformation.getRealname()).append("\"").append(",")
						.append("\"tel\":\"").append(businessActivityRegistrationInformation.getTel()).append("\"").append(",")
						.append("\"birthday\":\"").append(businessActivityRegistrationInformation.getBirthday()).append("\"").append(",")
						.append("\"age\":\"").append(businessActivityRegistrationInformation.getAge()).append("\"").append(",")
						.append("\"job\":\"").append(businessActivityRegistrationInformation.getJob()).append("\"").append(",")
						.append("\"id\":\"").append(businessActivityRegistrationInformation.getID()).append("\"").append(",")
						.append("\"email\":\"").append(businessActivityRegistrationInformation.getEmail()).append("\"").append(",")
						.append("\"addr\":\"").append(businessActivityRegistrationInformation.getAddr()).append("\"").append(",")
						.append("\"createTime\":\"").append(businessActivityRegistrationInformation.getCreateTime()).append("\"").append("}").append(",");
			}
			json = result.toString();
			if (baseBean.getList().size() > 0) {
				json = json.substring(0, json.length() - 1);
			}
			json += "]}";

			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			GSLogger.error("显示businessActivityRegistrationInformation列表时发生错误：/business/businessActivityRegistrationInformation/list", e);
			e.printStackTrace();
		}
	}

	/**
	 * 进入新增页
	 * 
	 * @return
	 */
	@RequestMapping(value = "add")
	public ModelAndView add(BusinessActivityRegistrationInformationQuery query) {
		try {
		} catch (Exception e) {
			GSLogger.error(
					"进入businessActivityRegistrationInformation新增页时发生错误：/business/businessActivityRegistrationInformation/add",
					e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView(
				"/business/businessActivityRegistrationInformation/add");
		return mav;
	}

	/**
	 * 保存对象
	 * 
	 * @param request
	 * @param businessActivityRegistrationInformation
	 * @return
	 */
	@RequestMapping(value = "save")
	public void save(HttpServletRequest request, HttpServletResponse response,
			BusinessActivityRegistrationInformation query) {
		String json = "";
		try {
			BusinessActivityRegistrationInformationQuery businessActivityRegistrationInformationQuery = new BusinessActivityRegistrationInformationQuery();
			businessActivityRegistrationInformationQuery.setActId(query.getActId());
			businessActivityRegistrationInformationQuery.setUserId(query.getUserId());
			int count = businessActivityRegistrationInformationService.selectCount(businessActivityRegistrationInformationQuery);
			if(count==0){
				BusinessActivityRegistrationTimeslot businessActivityRegistrationTimeslot = businessActivityRegistrationTimeslotService.findById(query.getTimeSlotId());
				businessActivityRegistrationInformationQuery.setUserId(null);
				businessActivityRegistrationInformationQuery.setTimeSlotId(query.getTimeSlotId());
				count = businessActivityRegistrationInformationService.selectCount(businessActivityRegistrationInformationQuery);
				if(count>=businessActivityRegistrationTimeslot.getNumber()){
					json = "";
					json += "{";
					json += "\"errorCode\":\"400\",";
					json += "\"message\":\"报名人数已满\"";
					json += "}";
				}else{
					Timestamp  ts=new Timestamp(new Date().getTime());
					query.setCreateTime(ts);
					query.setEditTime(ts);
					businessActivityRegistrationInformationService
							.save(query);
					
					// 保存成功
					json += "{";
					json += "\"errorCode\":\"200\",";
					json += "\"message\":\"参与成功\"";
					json += "}";
					
					AppUserNews appUserNews = new AppUserNews();
					appUserNews.setUserId(query.getUserId());
					appUserNews.setCreateTime(ts);
					appUserNews.setNewTitle("活动通知");
					appUserNews.setType(6);
					appUserNews.setId(query.getActId());
					appUserNews.setContent(query.getTitle());
					appUserNewsService.saveReply(appUserNews);
					AppLatestNews appLatestNews = new AppLatestNews();
					appLatestNews.setUserId(query.getUserId());
					appLatestNews.setTypeId(7);
					appLatestNews.setSourceId(query.getActId());
					appLatestNews.setTo(0);
					appLatestNews.setEstateId(0);
					appLatestNewsService.save_app(appLatestNews);
					appLatestNews.setTypeId(8);
					appLatestNewsService.save_app(appLatestNews);
					appLatestNews.setTypeId(10);
					appLatestNewsService.save_app(appLatestNews);
				}
			}else{
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"您已报名活动不能重复报名\"";
				json += "}";
			}
			
		} catch (Exception e) {
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"参与失败\"";
			json += "}";
			GSLogger.error(
					"保存businessActivityRegistrationInformation信息时发生错误：/business/businessActivityRegistrationInformation/save",
					e);
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
	 * 
	 * @return
	 */
	@RequestMapping(value = "modify")
	public ModelAndView modify(
			BusinessActivityRegistrationInformationQuery query) {
		BusinessActivityRegistrationInformation businessActivityRegistrationInformation = new BusinessActivityRegistrationInformation();

		try {
			businessActivityRegistrationInformation = businessActivityRegistrationInformationService
					.findById(query.getInformationId());
		} catch (Exception e) {
			GSLogger.error(
					"进入businessActivityRegistrationInformation修改页时发生错误：/business/businessActivityRegistrationInformation/modify",
					e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView(
				"/business/businessActivityRegistrationInformation/modify");
		mav.addObject("businessActivityRegistrationInformation",
				businessActivityRegistrationInformation);
		return mav;
	}

	/**
	 * 更新对象
	 * 
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value = "update")
	public void update(HttpServletRequest request,
			HttpServletResponse response,
			BusinessActivityRegistrationInformationQuery query) {
		BusinessActivityRegistrationInformation businessActivityRegistrationInformation = null;
		String json = "";
		try {
			businessActivityRegistrationInformation = businessActivityRegistrationInformationService
					.findById(query.getInformationId());
			businessActivityRegistrationInformation
					.setUserId(query.getUserId());
			businessActivityRegistrationInformation.setActId(query.getActId());
			businessActivityRegistrationInformation.setTimeSlotId(query
					.getTimeSlotId());
			businessActivityRegistrationInformation.setNickname(query
					.getNickname());
			businessActivityRegistrationInformation.setRealname(query
					.getRealname());
			businessActivityRegistrationInformation.setTel(query.getTel());
			businessActivityRegistrationInformation.setBirthday(query
					.getBirthday());
			businessActivityRegistrationInformation.setAge(query.getAge());
			businessActivityRegistrationInformation.setJob(query.getJob());
			businessActivityRegistrationInformation.setID(query.getID());
			businessActivityRegistrationInformation.setEmail(query.getEmail());
			businessActivityRegistrationInformation.setAddr(query.getAddr());
			businessActivityRegistrationInformationService
					.update(businessActivityRegistrationInformation);

			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch (Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error(
					"编辑businessActivityRegistrationInformation信息时发生错误：/business/businessActivityRegistrationInformation/update",
					e);
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
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete")
	public void delete(@RequestParam(value = "id") String id,
			HttpServletResponse response) {
		String json = "";
		try {
			if (id != null) {
				if (id.indexOf(',') > -1) {
					String[] ids = id.split(",");
					for (int i = 0; i < ids.length; i++) {
						businessActivityRegistrationInformationService
								.delete(new Integer(ids[i]));
					}
				} else {
					businessActivityRegistrationInformationService
							.delete(new Integer(id));
				}
			}

			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		} catch (Exception e) {
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error(
					"删除BusinessActivityRegistrationInformation时发生错误：/business/businessActivityRegistrationInformation/delete",
					e);
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
