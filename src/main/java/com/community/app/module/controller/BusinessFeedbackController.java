package com.community.app.module.controller;

import static com.community.framework.utils.CommonUtils.getUser;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.BusinessFeedback;
import com.community.app.module.bean.BusinessFeedbackComment;
import com.community.app.module.bean.MemberVO;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessFeedbackCommentService;
import com.community.app.module.service.BusinessFeedbackReplyService;
import com.community.app.module.service.BusinessFeedbackService;
import com.community.app.module.service.BusinessRepairService;
import com.community.app.module.vo.AppLatestNewsQuery;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFeedbackQuery;
import com.community.framework.utils.CommonUtils;
import com.community.framework.utils.JsonUtils;
import com.community.framework.utils.propertiesUtil;

@Controller
@RequestMapping("/business/businessFeedback")
public class BusinessFeedbackController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessFeedbackController.class);
	@Autowired
	private BusinessFeedbackService businessFeedbackService;
	@Autowired
	private BusinessRepairService businessRepairService;
    @Autowired
    private BusinessFeedbackReplyService businessFeedbackReplyService;
    @Autowired
    private AppUserService appUserService;
    @Autowired
	private BusinessFeedbackCommentService businessFeedbackCommentService;
    @Autowired
	private AppLatestNewsService appLatestNewsService;
	
	/**
	 * 进入物业投诉建议管理页
	 * @return
	 */
	@RequestMapping(value="propList")
	public ModelAndView propList(BusinessFeedbackQuery query) {	
		BaseBean baseBean = null;
		String orgType = "";
		ShiroUser shiroUser = CommonUtils.getUser();
		try{			
			//if(shiroUser.getCurOrgType() != null && !"".equals(shiroUser.getCurOrgType())) {
			//	orgType = shiroUser.getCurOrgType();
			//}else{
			//	orgType = shiroUser.getOrgType();
			//}
			
			//if(ModuleConst.PROPERTY_CODE.equals(orgType)) {//物业人员 
				//if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { 
					query.setCurUserId(shiroUser.getUserId());
				//}	
				if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
					query.setCurEstateId(shiroUser.getCurEstateId());
				}
				if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
					query.setCurComId(shiroUser.getCurComId());
				}
				//query.setOrgType(ModuleConst.PROPERTY_CODE);
				Integer[] types = {0,1};
				query.setFbTypes(types);//0物业投诉,1物业建议
			/*}else if(ModuleConst.STATION_CODE.equals(orgType)) {//驿站人员
				if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { 
					query.setCurUserId(shiroUser.getUserId());
				}	
				if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
					query.setCurEstateId(shiroUser.getCurEstateId());
				}
				query.setOrgType(ModuleConst.STATION_CODE);
				Integer[] types = {3,4};
				query.setFbTypes(types);//3驿站建议,4快递投诉
			}if(ModuleConst.OPERATION_CODE.equals(orgType)) {//运营人员 
				if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
					query.setCurEstateId(shiroUser.getCurEstateId());
				}
				query.setOrgType(ModuleConst.OPERATION_CODE);
				Integer[] types = {2};
				query.setFbTypes(types);//2 运营
			}*/
			query.setSort("editTime");
			query.setOrder("desc");
			query.setRows(12);
			baseBean = businessFeedbackService.findAllPage(query);
		}catch(Exception e){
			GSLogger.error("进入businessFeedback管理页时发生错误：/business/businessFeedback/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/feedback/propList");
		baseBean.setRows(12);
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		mav.addObject("fbState", query.getFbState());
		//mav.addObject("orgType", orgType);
		mav.addObject("originOrgType", shiroUser.getOrgType());
		return mav;
	}

    /**
     * 跳转到物业投诉详情页
     * @param query
     * @return
     */
    @RequestMapping(value="getPropFeedDetails")
    public ModelAndView getPropFeedDetails(HttpServletRequest request, BusinessFeedbackQuery query) {
        BusinessFeedback obj = new BusinessFeedback();
        MemberVO userVO = new MemberVO();
        List list = new ArrayList();
        Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		String isNew = request.getParameter("isNew");
        try{
            //查询详情信息
            obj = businessFeedbackService.findById(query.getFeedbackId());
            //获取app端用户信息
//          userVO = appUserService.getAppUserInfo(query.getFberId());
            Map<String, Object> con = new HashMap<String, Object>();
            con.put("userId", query.getFberId());
            con.put("estateId", query.getEstateId());
            userVO = appUserService.findByCon(con);
            
            Map map = new HashMap();
            map.put("feedbackId", query.getFeedbackId());
            list = businessFeedbackCommentService.findByMap(map); //回复信息
            //如果有新消息则删除消息
            if(isNew != null && new Integer(isNew) == 1) {
            	AppLatestNewsQuery newsQuery = new AppLatestNewsQuery();
            	newsQuery.setTypeId(36);//反馈
            	newsQuery.setSourceId(query.getFeedbackId());
            	newsQuery.setTo(1);//居民向后台发送
            	appLatestNewsService.deleteByCondition(newsQuery);
            }
        }catch(Exception e){
            GSLogger.error("进入businessFeedbackReply详情页页时发生错误：/business/businessFeedback/getFeedDetails", e);
            e.printStackTrace();
        }
        ModelAndView mav = new ModelAndView("/module/feedback/propDetails");
        mav.addObject("ip", ip);
        mav.addObject("obj", obj);
        mav.addObject("list", list);
        mav.addObject("userVO", userVO);
        return mav;
    }

    
    /**
	 * 进入驿站投诉建议管理页
	 * @return
	 */
	@RequestMapping(value="stationList")
	public ModelAndView stationList(BusinessFeedbackQuery query) {	
		BaseBean baseBean = null;
		String orgType = "";
		ShiroUser shiroUser = CommonUtils.getUser();
		try{			
			/*if(shiroUser.getCurOrgType() != null && !"".equals(shiroUser.getCurOrgType())) {
				orgType = shiroUser.getCurOrgType();
			}else{
				orgType = shiroUser.getOrgType();
			}*/
			/*if(ModuleConst.PROPERTY_CODE.equals(orgType)) {//物业人员 
				if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { 
					query.setCurUserId(shiroUser.getUserId());
				}	
				if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
					query.setCurEstateId(shiroUser.getCurEstateId());
				}
				query.setOrgType(ModuleConst.PROPERTY_CODE);
				Integer[] types = {0,1};
				query.setFbTypes(types);//0物业投诉,1物业建议
			}else if(ModuleConst.STATION_CODE.equals(orgType)) {//驿站人员
				if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { */
					query.setCurUserId(shiroUser.getUserId());
				//}	
				if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
					query.setCurEstateId(shiroUser.getCurEstateId());
				}
				if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
					query.setCurComId(shiroUser.getCurComId());
				}
				//query.setOrgType(ModuleConst.STATION_CODE);
				Integer[] types = {3,4};
				query.setFbTypes(types);//3驿站建议,4快递投诉
			/*}if(ModuleConst.OPERATION_CODE.equals(orgType)) {//运营人员 
				if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
					query.setCurEstateId(shiroUser.getCurEstateId());
				}
				query.setOrgType(ModuleConst.OPERATION_CODE);
				Integer[] types = {2};
				query.setFbTypes(types);//2 运营
			}*/
			query.setSort("editTime");
			query.setOrder("desc");
			query.setRows(12);
			baseBean = businessFeedbackService.findAllPage(query);
		}catch(Exception e){
			GSLogger.error("进入businessFeedback管理页时发生错误：/business/businessFeedback/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/feedback/stationList");
		baseBean.setRows(12);
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		mav.addObject("fbState", query.getFbState());
		mav.addObject("orgType", orgType);
		mav.addObject("originOrgType", shiroUser.getOrgType());
		return mav;
	}

    /**
     * 跳转到驿站投诉详情页
     * @param query
     * @return
     */
    @RequestMapping(value="getStationFeedDetails")
    public ModelAndView getStationFeedDetails(HttpServletRequest request, BusinessFeedbackQuery query) {
        BusinessFeedback obj = new BusinessFeedback();
        MemberVO userVO = new MemberVO();
        List list = new ArrayList();
        Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		String isNew = request.getParameter("isNew");
        try{
            //查询详情信息
            obj = businessFeedbackService.findById(query.getFeedbackId());
            //获取app端用户信息
//          userVO = appUserService.getAppUserInfo(query.getFberId());
            Map<String, Object> con = new HashMap<String, Object>();
            con.put("userId", query.getFberId());
            con.put("estateId", query.getEstateId());
            userVO = appUserService.findByCon(con);
            
            Map map = new HashMap();
            map.put("feedbackId", query.getFeedbackId());
            list = businessFeedbackCommentService.findByMap(map); //回复信息
            //如果有新消息则删除消息
            if(isNew != null && new Integer(isNew) == 1) {
            	AppLatestNewsQuery newsQuery = new AppLatestNewsQuery();
            	newsQuery.setTypeId(36);//反馈
            	newsQuery.setSourceId(query.getFeedbackId());
            	newsQuery.setTo(1);//居民向后台发送
            	appLatestNewsService.deleteByCondition(newsQuery);
            }
        }catch(Exception e){
            GSLogger.error("进入businessFeedbackReply详情页页时发生错误：/business/businessFeedback/getFeedDetails", e);
            e.printStackTrace();
        }
        ModelAndView mav = new ModelAndView("/module/feedback/stationDetails");
        mav.addObject("ip", ip);
        mav.addObject("obj", obj);
        mav.addObject("list", list);
        mav.addObject("userVO", userVO);
        return mav;
    }
    
    
    /**
	 * 进入运营投诉建议管理页
	 * @return
	 */
	@RequestMapping(value="operationList")
	public ModelAndView operationList(BusinessFeedbackQuery query) {	
		BaseBean baseBean = null;
		String orgType = "";
		ShiroUser shiroUser = CommonUtils.getUser();
		try{			
			/*if(shiroUser.getCurOrgType() != null && !"".equals(shiroUser.getCurOrgType())) {
				orgType = shiroUser.getCurOrgType();
			}else{
				orgType = shiroUser.getOrgType();
			}*/
			/*if(ModuleConst.PROPERTY_CODE.equals(orgType)) {//物业人员 
				if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { 
					query.setCurUserId(shiroUser.getUserId());
				}	
				if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
					query.setCurEstateId(shiroUser.getCurEstateId());
				}
				query.setOrgType(ModuleConst.PROPERTY_CODE);
				Integer[] types = {0,1};
				query.setFbTypes(types);//0物业投诉,1物业建议
			}else if(ModuleConst.STATION_CODE.equals(orgType)) {//驿站人员
				if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { 
					query.setCurUserId(shiroUser.getUserId());
				}	
				if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
					query.setCurEstateId(shiroUser.getCurEstateId());
				}
				query.setOrgType(ModuleConst.STATION_CODE);
				Integer[] types = {3,4};
				query.setFbTypes(types);//3驿站建议,4快递投诉
			}if(ModuleConst.OPERATION_CODE.equals(orgType)) {//运营人员 
			*/	if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
					query.setCurEstateId(shiroUser.getCurEstateId());
				}
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setCurComId(shiroUser.getCurComId());
			}
				//query.setOrgType(ModuleConst.OPERATION_CODE);
				Integer[] types = {2};
				query.setFbTypes(types);//2 运营
			//}
			query.setSort("editTime");
			query.setOrder("desc");
			query.setRows(12);
			baseBean = businessFeedbackService.findAllPage(query);
		}catch(Exception e){
			GSLogger.error("进入businessFeedback管理页时发生错误：/business/businessFeedback/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/feedback/operationList");
		baseBean.setRows(12);
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		mav.addObject("fbState", query.getFbState());
		mav.addObject("orgType", orgType);
		mav.addObject("originOrgType", shiroUser.getOrgType());
		return mav;
	}

    /**
     * 跳转到详情页
     * @param query
     * @return
     */
    @RequestMapping(value="getOperationFeedDetails")
    public ModelAndView getOperationFeedDetails(HttpServletRequest request, BusinessFeedbackQuery query) {
        BusinessFeedback obj = new BusinessFeedback();
        MemberVO userVO = new MemberVO();
        List list = new ArrayList();
        Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		String isNew = request.getParameter("isNew");
        try{
            //查询详情信息
            obj = businessFeedbackService.findById(query.getFeedbackId());
            //获取app端用户信息
//          userVO = appUserService.getAppUserInfo(query.getFberId());
            Map<String, Object> con = new HashMap<String, Object>();
            con.put("userId", query.getFberId());
            con.put("estateId", query.getEstateId());
            userVO = appUserService.findByCon(con);
            
            Map map = new HashMap();
            map.put("feedbackId", query.getFeedbackId());
            list = businessFeedbackCommentService.findByMap(map); //回复信息
            //如果有新消息则删除消息
            if(isNew != null && new Integer(isNew) == 1) {
            	AppLatestNewsQuery newsQuery = new AppLatestNewsQuery();
            	newsQuery.setTypeId(36);//反馈
            	newsQuery.setSourceId(query.getFeedbackId());
            	newsQuery.setTo(1);//居民向后台发送
            	appLatestNewsService.deleteByCondition(newsQuery);
            }
        }catch(Exception e){
            GSLogger.error("进入businessFeedbackReply详情页页时发生错误：/business/businessFeedback/getFeedDetails", e);
            e.printStackTrace();
        }
        ModelAndView mav = new ModelAndView("/module/feedback/operationDetails");
        mav.addObject("ip", ip);
        mav.addObject("obj", obj);
        mav.addObject("list", list);
        mav.addObject("userVO", userVO);
        return mav;
    }
    
    
    
    /**
     * 用户反馈次数(包括物业投诉和建议)
     * @param query
     */
    @RequestMapping(value="getFeedCount")
    public @ResponseBody String getFeedCount(BusinessFeedbackQuery query) {
        Map map = new HashMap();
        map.put("fberId", query.getFberId()); //反馈人
        List list = new ArrayList();
        list = businessFeedbackService.findByMap(map);
        String count = String.valueOf(list.size());
        return count;
    }

    /**
     * 用户反馈信息
     * @param query
     * @param response
     */
    @RequestMapping(value="getFeedInfoByUser")
    public void getFeedInfoByUser(BusinessFeedbackQuery query, HttpServletResponse response) {
        Map map = new HashMap();
        map.put("fberId", query.getFberId()); //反馈人
        List list = new ArrayList();
        list = businessFeedbackService.findByMap(map);

        String json = "";
        StringBuilder result = new StringBuilder();
        result.append("[");
        for(int i=0;i<list.size();i++) {
            BusinessFeedback businessFeedback = (BusinessFeedback) list.get(i);
            result.append("{")
                    .append("\"feedbackId\":\"").append(businessFeedback.getFeedbackId()).append("\"").append(",")
                    .append("\"fbTitle\":\"").append(businessFeedback.getFbTitle()).append("\"").append(",")
                    .append("\"fberId\":\"").append(businessFeedback.getFberId()).append("\"").append(",")
                    .append("\"fberName\":\"").append(businessFeedback.getFberName()).append("\"").append(",")
                    .append("\"fbTime\":\"").append(businessFeedback.getFbTime()).append("\"").append(",")
                    .append("\"fbContent\":\"").append(JsonUtils.stringToJson(businessFeedback.getFbContent().replace("\"", "\\\"").replaceAll("(\r?\n()+)", ""))).append("\"").append(",")
                    .append("\"fbType\":\"").append(businessFeedback.getFbType()).append("\"").append(",")
                    .append("\"fbState\":\"").append(businessFeedback.getFbState()).append("\"").append(",")
                    .append("\"fbReplies\":\"").append(businessFeedback.getFbReplies()).append("\"").append(",")
                    .append("\"fbScore\":\"").append(businessFeedback.getFbScore()).append("\"").append(",")
                    .append("\"newReplies\":\"").append(businessFeedback.getNewReplies()).append("\"").append(",")
                    .append("\"receiverId\":\"").append(businessFeedback.getReceiverId()).append("\"").append(",")
                    .append("\"receiverName\":\"").append(businessFeedback.getReceiverName()).append("\"").append(",")
                    .append("\"receiveAvatar\":\"").append(businessFeedback.getReceiveAvatar()).append("\"").append(",")
                    .append("\"receiveDate\":\"").append(businessFeedback.getReceiveDate()).append("\"").append(",")
                    .append("\"createTime\":\"").append(businessFeedback.getCreateTime()).append("\"").append(",")
                    .append("\"editTime\":\"").append(businessFeedback.getEditTime()).append("\"").append(",")
                    
                    .append("\"editor\":\"").append(businessFeedback.getEditor()).append("\"")
                    .append("}").append(",");
        }
        json = result.toString();
        if(list.size() > 0) {
            json = json.substring(0, json.length()-1);
        }
        json += "]";

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
	 * 列示或者查询所有物业建议数据
	 * @return
	 */
	@RequestMapping(value="getPropPageList")
	public void getPropPageList(BusinessFeedbackQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			//if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { 
			query.setCurUserId(shiroUser.getUserId());
		//}	
		if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
			query.setCurEstateId(shiroUser.getCurEstateId());
		}
		if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
			query.setCurComId(shiroUser.getCurComId());
		}
		//query.setOrgType(ModuleConst.PROPERTY_CODE);
		Integer[] types = {0,1};
		query.setFbTypes(types);//0物业投诉,1物业建议
			query.setOrder("desc");
			query.setRows(12);
			if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
				query.setSort(query.getOrderBy());
			}else{
				query.setSort("editTime");
			}
			BaseBean baseBean = businessFeedbackService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessFeedback businessFeedback = (BusinessFeedback) baseBean.getList().get(i);
				result.append("{")
			    .append("\"feedbackId\":\"").append(businessFeedback.getFeedbackId()).append("\"").append(",")
			    .append("\"fbTitle\":\"").append(businessFeedback.getFbTitle()).append("\"").append(",")
			    .append("\"fberId\":\"").append(businessFeedback.getFberId()).append("\"").append(",")
			    .append("\"fberName\":\"").append(businessFeedback.getFberName()).append("\"").append(",")
			    .append("\"fbTime\":\"").append(businessFeedback.getFbTime()).append("\"").append(",")
			    .append("\"fbContent\":\"").append(businessFeedback.getFbContent()).append("\"").append(",")
			    .append("\"fbType\":\"").append(businessFeedback.getFbType()).append("\"").append(",")
			    .append("\"fbState\":\"").append(businessFeedback.getFbState()).append("\"").append(",")
			    .append("\"fbReplies\":\"").append(businessFeedback.getFbReplies()).append("\"").append(",")
			    .append("\"fbScore\":\"").append(businessFeedback.getFbScore()).append("\"").append(",")
			    .append("\"newReplies\":\"").append(businessFeedback.getNewReplies()).append("\"").append(",")
			    .append("\"receiverId\":\"").append(businessFeedback.getReceiverId()).append("\"").append(",")
			    .append("\"receiverName\":\"").append(businessFeedback.getReceiverName()).append("\"").append(",")
			    .append("\"receiveAvatar\":\"").append(businessFeedback.getReceiveAvatar()).append("\"").append(",")
			    .append("\"receiveDate\":\"").append(businessFeedback.getReceiveDate()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessFeedback.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessFeedback.getEditTime()).append("\"").append(",")
			    
			    .append("\"expCode\":\"").append(businessFeedback.getExpCode()).append("\"").append(",")
                .append("\"estateId\":\"").append(businessFeedback.getEstateId()).append("\"").append(",")
                .append("\"estateName\":\"").append(businessFeedback.getEstateName()).append("\"").append(",")
                .append("\"portrait\":\"").append(businessFeedback.getPortrait()).append("\"").append(",")
                .append("\"address\":\"").append(businessFeedback.getAddress()).append("\"").append(",")
                .append("\"lastCommentTime\":\"").append(businessFeedback.getLastCommentTime()).append("\"").append(",")
                .append("\"newsCount\":\"").append(businessFeedback.getNewsCount()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessFeedback.getEditor()).append("\"")
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
			GSLogger.error("显示businessFeedback列表时发生错误：/business/businessFeedback/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 列示或者查询所有驿站数据
	 * @return
	 */
	@RequestMapping(value="getStationPageList")
	public void getStationPageList(BusinessFeedbackQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			//if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) { 
			query.setCurUserId(shiroUser.getUserId());
			//}	
			if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
				query.setCurEstateId(shiroUser.getCurEstateId());
			}
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setCurComId(shiroUser.getCurComId());
			}
			//query.setOrgType(ModuleConst.STATION_CODE);
			Integer[] types = {3,4};
			query.setFbTypes(types);//3驿站建议,4快递投诉
			query.setOrder("desc");
			query.setRows(12);
			if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
				query.setSort(query.getOrderBy());
			}else{
				query.setSort("editTime");
			}
			BaseBean baseBean = businessFeedbackService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessFeedback businessFeedback = (BusinessFeedback) baseBean.getList().get(i);
				result.append("{")
			    .append("\"feedbackId\":\"").append(businessFeedback.getFeedbackId()).append("\"").append(",")
			    .append("\"fbTitle\":\"").append(businessFeedback.getFbTitle()).append("\"").append(",")
			    .append("\"fberId\":\"").append(businessFeedback.getFberId()).append("\"").append(",")
			    .append("\"fberName\":\"").append(businessFeedback.getFberName()).append("\"").append(",")
			    .append("\"fbTime\":\"").append(businessFeedback.getFbTime()).append("\"").append(",")
			    .append("\"fbContent\":\"").append(businessFeedback.getFbContent()).append("\"").append(",")
			    .append("\"fbType\":\"").append(businessFeedback.getFbType()).append("\"").append(",")
			    .append("\"fbState\":\"").append(businessFeedback.getFbState()).append("\"").append(",")
			    .append("\"fbReplies\":\"").append(businessFeedback.getFbReplies()).append("\"").append(",")
			    .append("\"fbScore\":\"").append(businessFeedback.getFbScore()).append("\"").append(",")
			    .append("\"newReplies\":\"").append(businessFeedback.getNewReplies()).append("\"").append(",")
			    .append("\"receiverId\":\"").append(businessFeedback.getReceiverId()).append("\"").append(",")
			    .append("\"receiverName\":\"").append(businessFeedback.getReceiverName()).append("\"").append(",")
			    .append("\"receiveAvatar\":\"").append(businessFeedback.getReceiveAvatar()).append("\"").append(",")
			    .append("\"receiveDate\":\"").append(businessFeedback.getReceiveDate()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessFeedback.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessFeedback.getEditTime()).append("\"").append(",")
			    
			    .append("\"expCode\":\"").append(businessFeedback.getExpCode()).append("\"").append(",")
                .append("\"estateId\":\"").append(businessFeedback.getEstateId()).append("\"").append(",")
                .append("\"estateName\":\"").append(businessFeedback.getEstateName()).append("\"").append(",")
                .append("\"portrait\":\"").append(businessFeedback.getPortrait()).append("\"").append(",")
                .append("\"address\":\"").append(businessFeedback.getAddress()).append("\"").append(",")
                .append("\"lastCommentTime\":\"").append(businessFeedback.getLastCommentTime()).append("\"").append(",")
                .append("\"newsCount\":\"").append(businessFeedback.getNewsCount()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessFeedback.getEditor()).append("\"")
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
			GSLogger.error("显示businessFeedback列表时发生错误：/business/businessFeedback/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 列示或者查询所有运营建议数据
	 * @return
	 */
	@RequestMapping(value="getOperationPageList")
	public void getOperationPageList(BusinessFeedbackQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
				query.setCurEstateId(shiroUser.getCurEstateId());
			}
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setCurComId(shiroUser.getCurComId());
			}
			//query.setOrgType(ModuleConst.OPERATION_CODE);
			Integer[] types = {2};
			query.setFbTypes(types);//2 运营
			query.setOrder("desc");
			query.setRows(12);
			if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
				query.setSort(query.getOrderBy());
			}else{
				query.setSort("editTime");
			}
			BaseBean baseBean = businessFeedbackService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessFeedback businessFeedback = (BusinessFeedback) baseBean.getList().get(i);
				result.append("{")
			    .append("\"feedbackId\":\"").append(businessFeedback.getFeedbackId()).append("\"").append(",")
			    .append("\"fbTitle\":\"").append(businessFeedback.getFbTitle()).append("\"").append(",")
			    .append("\"fberId\":\"").append(businessFeedback.getFberId()).append("\"").append(",")
			    .append("\"fberName\":\"").append(businessFeedback.getFberName()).append("\"").append(",")
			    .append("\"fbTime\":\"").append(businessFeedback.getFbTime()).append("\"").append(",")
			    .append("\"fbContent\":\"").append(businessFeedback.getFbContent()).append("\"").append(",")
			    .append("\"fbType\":\"").append(businessFeedback.getFbType()).append("\"").append(",")
			    .append("\"fbState\":\"").append(businessFeedback.getFbState()).append("\"").append(",")
			    .append("\"fbReplies\":\"").append(businessFeedback.getFbReplies()).append("\"").append(",")
			    .append("\"fbScore\":\"").append(businessFeedback.getFbScore()).append("\"").append(",")
			    .append("\"newReplies\":\"").append(businessFeedback.getNewReplies()).append("\"").append(",")
			    .append("\"receiverId\":\"").append(businessFeedback.getReceiverId()).append("\"").append(",")
			    .append("\"receiverName\":\"").append(businessFeedback.getReceiverName()).append("\"").append(",")
			    .append("\"receiveAvatar\":\"").append(businessFeedback.getReceiveAvatar()).append("\"").append(",")
			    .append("\"receiveDate\":\"").append(businessFeedback.getReceiveDate()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessFeedback.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessFeedback.getEditTime()).append("\"").append(",")
			    
			    .append("\"expCode\":\"").append(businessFeedback.getExpCode()).append("\"").append(",")
                .append("\"estateId\":\"").append(businessFeedback.getEstateId()).append("\"").append(",")
                .append("\"estateName\":\"").append(businessFeedback.getEstateName()).append("\"").append(",")
                .append("\"portrait\":\"").append(businessFeedback.getPortrait()).append("\"").append(",")
                .append("\"address\":\"").append(businessFeedback.getAddress()).append("\"").append(",")
                .append("\"lastCommentTime\":\"").append(businessFeedback.getLastCommentTime()).append("\"").append(",")
                .append("\"newsCount\":\"").append(businessFeedback.getNewsCount()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessFeedback.getEditor()).append("\"")
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
			GSLogger.error("显示businessFeedback列表时发生错误：/business/businessFeedback/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessFeedbackQuery query) {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessFeedback新增页时发生错误：/business/businessFeedback/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessFeedback/add");
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessFeedbackQuery query) {
		BusinessFeedback businessFeedback = new BusinessFeedback();
		String json = "";
		try{
		    businessFeedback.setFbTitle(query.getFbTitle());
		    businessFeedback.setFberId(query.getFberId());
		    businessFeedback.setFberName(query.getFberName());
		    //businessFeedback.setFbTime(query.getFbTime());
		    businessFeedback.setFbContent(query.getFbContent());
		    businessFeedback.setFbType(query.getFbType());
		    businessFeedback.setFbState(query.getFbState());
		    businessFeedback.setFbReplies(query.getFbReplies());
		    businessFeedback.setFbScore(query.getFbScore());
		    businessFeedback.setNewReplies(query.getNewReplies());
		    businessFeedback.setReceiverId(query.getReceiverId());
		    businessFeedback.setReceiverName(query.getReceiverName());
		    businessFeedback.setReceiveAvatar(query.getReceiveAvatar());
		    businessFeedback.setReceiveDate(query.getReceiveDate());
		    businessFeedback.setCreateTime(query.getCreateTime());
		    businessFeedback.setEditTime(query.getEditTime());
		    businessFeedback.setEditor(query.getEditor());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessFeedback.setCreateTime(ts);
	        businessFeedback.setEditTime(ts);
			businessFeedbackService.save(businessFeedback);
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessFeedback信息时发生错误：/business/businessFeedback/save", e);
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
	public ModelAndView modify(BusinessFeedbackQuery query) {	
		BusinessFeedback businessFeedback=new BusinessFeedback();
		
		try{
			businessFeedback = businessFeedbackService.findById(query.getFeedbackId());
		}catch(Exception e){
			GSLogger.error("进入businessFeedback修改页时发生错误：/business/businessFeedback/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessFeedback/modify");
		mav.addObject("businessFeedback", businessFeedback);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessFeedbackQuery query) {
		BusinessFeedback businessFeedback = new BusinessFeedback();
		String json = "";
		try{
		    /*businessFeedback = businessFeedbackService.findById(query.getFeedbackId());
		    businessFeedback.setFbTitle(query.getFbTitle());
		    businessFeedback.setFberId(query.getFberId());
		    businessFeedback.setFberName(query.getFberName());
		    //businessFeedback.setFbTime(query.getFbTime());
		    businessFeedback.setFbContent(query.getFbContent());
		    businessFeedback.setFbType(query.getFbType());
		    businessFeedback.setFbState(query.getFbState());
		    businessFeedback.setFbReplies(query.getFbReplies());
		    businessFeedback.setFbScore(query.getFbScore());
		    businessFeedback.setNewReplies(query.getNewReplies());

		    businessFeedback.setReceiveAvatar(query.getReceiveAvatar());
		    businessFeedback.setReceiveDate(query.getReceiveDate());
		    businessFeedback.setCreateTime(query.getCreateTime());
		    businessFeedback.setEditTime(query.getEditTime());
		    businessFeedback.setEditor(query.getEditor());*/
            businessFeedback.setFeedbackId(query.getFeedbackId());
            businessFeedback.setReceiverId(getUser().getUserId());
            businessFeedback.setReceiverName(getUser().getUserName());
            businessFeedback.setFbState(query.getFbState());
	        Timestamp  ts=new Timestamp(new Date().getTime());
	        businessFeedback.setEditTime(ts);
			businessFeedbackService.update(businessFeedback);
			BusinessFeedbackComment businessFeedbackComment = new BusinessFeedbackComment();
			businessFeedbackComment.setFeedbackId(query.getFeedbackId());
			businessFeedbackComment.setContentType(0);
			businessFeedbackComment.setCommentorId(getUser().getUserId());
		    businessFeedbackComment.setCommentorName(getUser().getUserName());
			businessFeedbackComment.setComment("您好，请您对我本次提供的服务整体表现做出评价！");
			businessFeedbackComment.setCommentTime(ts);
			businessFeedbackComment.setVideoSize(0);
		    businessFeedbackComment.setTo(1);
			businessFeedbackCommentService.save_manage(businessFeedbackComment);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getFberId());
			appLatestNews.setSourceId(query.getFeedbackId());
			appLatestNews.setTo(0);
			appLatestNews.setEstateId(0);
			appLatestNews.setTypeId(20);
			appLatestNewsService.save_app(appLatestNews);
			if(query.getFbType()==0){
				appLatestNews.setTypeId(15);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(19);
				appLatestNewsService.save_app(appLatestNews);
			}else {
				appLatestNews.setTypeId(13);
				appLatestNewsService.save_app(appLatestNews);
				appLatestNews.setTypeId(17);
				appLatestNewsService.save_app(appLatestNews);
			}
			
			json = "{\"success\":\"true\",\"message\":\"处理成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"处理失败\"}";
			GSLogger.error("编辑businessFeedback信息时发生错误：/business/businessFeedback/update", e);
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
						businessFeedbackService.delete(new Integer(ids[i]));
					}
				}else{
					businessFeedbackService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessFeedback时发生错误：/business/businessFeedback/delete", e);
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
