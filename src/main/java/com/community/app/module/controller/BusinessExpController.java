package com.community.app.module.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.community.app.module.bean.*;
import com.community.app.module.common.ModuleConst;
import com.community.app.module.push.AppPushNotificationUtil;
import com.community.app.module.service.*;
import com.community.app.module.service.BusinessStationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.vo.AppLatestNewsQuery;
import com.community.app.module.vo.BaseBean;


import com.community.app.module.vo.BusinessExpQuery;
import com.community.framework.utils.CommonUtils;
import com.community.framework.utils.MessageChannelClient;
import com.community.framework.utils.StringUtil;
import com.community.framework.utils.propertiesUtil;

import static com.community.framework.utils.CommonUtils.getUser;

@Controller
@RequestMapping("/business/businessExp")
public class BusinessExpController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessExpController.class);
	@Autowired
	private BusinessExpService businessExpService;
	@Autowired
    private ManageExpressService manageExpressService;
	@Autowired
    private BusinessUserService businessUserService;
	@Autowired
    private BusinessStationService businessStationService;
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private BusinessExpResolveService businessExpResolveService;
    @Autowired
    private BusinessExpBackresolveService businessExpBackresolveService;
    @Autowired
    private BusinessExpFavService businessExpFavService;
    @Autowired
    private ManageEstateService manageEstateService;
    @Autowired
    private AppLatestNewsService appLatestNewsService;
    @Autowired
    private AppPushLogService appPushLogService;
    @Autowired
    private AppUserConfigService appUserConfigService;
    @Autowired
	private BusinessAddressService businessAddressService;
	@Autowired
	private ManageExpressAllService manageExpressAllService;
	@Autowired
	private ManageSendMsgService manageSendMsgService;
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="enter")
	public ModelAndView enter() {		
		try{
		}catch(Exception e){
			GSLogger.error("进入businessExp管理页时发生错误：/business/businessExp/enter", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessExp/enter");
		return mav;
	}

    /**
     * 查看快递详情
     * @param query
     * @return
     */
    @RequestMapping(value="getDetails")
    public ModelAndView getDetails(HttpServletRequest request, BusinessExpQuery query) {
        //判断状态进入不同的页面
        //0 上门取件 1 已上门取件 2 已发送 3 已入库 4 自提5 上门送件 6 已签收 7 已退件 8已取消 9问题件
        String view = "";
        int expState = query.getExpState();
        BusinessExp businessExp = businessExpService.findById(query.getExpId());
        /*String newsCount = request.getParameter("newsCount");
        if(newsCount != null && new Integer(newsCount) > 0) {
        	AppLatestNewsQuery newsQuery = new AppLatestNewsQuery();
        	newsQuery.setTypeId(38);
        	newsQuery.setSourceId(query.getExpId());
        	newsQuery.setTo(1);
        	appLatestNewsService.deleteByCondition(newsQuery);
        }*/
        switch (expState)
        {
            case 0 :   //0 上门取件
                view = "/module/express/orderDetail";
                break;
            case 1 :   //1 已上门
	            {
	            	if(businessExp.getExpType() == 0) {//收件
	            		view = "/module/express/delivery";
	            	}else{//发件
	            		view = "/module/express/orderDetail";
	            	}
	            	break;    
	            }
            case 2 :   //2 已发送
                view = "/module/express/sendEnd";
                break;
            case 3 :   //3 已入库 即 驿站发件
                view = "/module/express/storage";
                break;
            case 4 :  //4 自提快件
                view = "/module/express/pickedup";
                break;    
            case 5 :  //5 上门送件
                view = "/module/express/delivery";
                break;
            case 6 : //6 已签收
                view = "/module/express/received";
                break;
            case 7 :  //7 已退件
                view = "/module/express/returned";
                break;    
            case 8 :  //8 已取消
                view = "/module/express/quit";
                break;
            case 9 :  //9 问题件
                view = "/module/express/question";
                break;    

            default:
                break;
        }
        ModelAndView mav = new ModelAndView(view);
        mav.addObject("businessExp", businessExp);
        
        Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
        //处理过程
        Map paramMap = new HashMap();
        paramMap.put("expId", businessExp.getExpId());
        List resolveList = businessExpBackresolveService.findByMap(paramMap);
        mav.addObject("resolveList", resolveList);
        mav.addObject("ip", ip);
        mav.addObject("curEstateId", CommonUtils.getUser().getCurEstateId());
        return mav;
    }

    /**
     * 发件录入
     * @param query
     * @return
     */
    @RequestMapping(value="getSendWrite")
    public ModelAndView getSendWrite(BusinessExpQuery query) {
        BusinessExp businessExp = businessExpService.findById(query.getExpId());
        List expressList = null;
        // expressList = manageExpressService.findExpressByStation(CommonUtils.getUser().getOrgId());
        expressList =manageExpressAllService.findAll();
        
        ModelAndView mav = new ModelAndView("/module/express/updateSend");
        mav.addObject("businessExp", businessExp);
        mav.addObject("expressList", expressList);
        return mav;
    }
    
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(HttpServletRequest reqeust, BusinessExpQuery query, HttpServletResponse response) {
        BaseBean baseBean = new BaseBean();
        List expressList = null;
        String expStateStr = reqeust.getParameter("expStateStr");
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) {
				query.setCurUserId(shiroUser.getUserId());//社区和驿站根据小区范围数据范围不同
			}			
			if(shiroUser.getCurEstateId() != null) {
				query.setCurEstateId(shiroUser.getCurEstateId());
			}
            query.setSort("expId");
            query.setOrder("desc");
            query.setRows(11);
            //if(expStateStr != null && !"".equals(expStateStr)) {
            //	query.setExpStates(expStateStr.split("_"));
            //}
			baseBean = businessExpService.findAllPage(query);
			// expressList = manageExpressService.findExpressByStation(CommonUtils.getUser().getOrgId());
			expressList =manageExpressAllService.findAll();
		}catch(Exception e){
			GSLogger.error("显示businessExp列表时发生错误：/business/businessExp/list", e);
			e.printStackTrace();
		}
        ModelAndView mav = new ModelAndView("/module/express/list");
        mav.addObject("baseBean", baseBean);
        mav.addObject("pager", baseBean.getPager());
        mav.addObject("expState", query.getExpState());
        mav.addObject("expressList", expressList);
        mav.addObject("curEstateId", CommonUtils.getUser().getCurEstateId());
        return mav;
	}
	
	
	
	/**
	 * 导出快递单
	 * @param response
	 * @return
	 */
	@RequestMapping(value="exportExcel")  
    public String exportExcel(HttpServletRequest reqeust, BusinessExpQuery query,HttpServletResponse response)  
    {  
		String[] expArr = null;
        response.setContentType("application/binary;charset=UTF-8");  
        try {  
            ServletOutputStream outputStream = response.getOutputStream();  
            String fileName = "快递导出订单";
            fileName = URLEncoder.encode(fileName, "UTF-8"); 
            response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xlsx");// 组装附件名称和格式  
            
            if(query.getExpIds().contains(",")) {
            	expArr = query.getExpIds().split(",");
            } else {
            	expArr = new String[]{query.getExpIds()};
            }
            query.setExpId(Integer.parseInt(expArr[0]));
            query.setExpIdArray(expArr);
            businessExpService.exportExcel(query, outputStream);
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="findExcelAllExp")
	public ModelAndView findExcelAllExp(HttpServletRequest reqeust, BusinessExpQuery query, HttpServletResponse response) {
        List expressList = null;
        List estateList = null;
        List<BusinessExp> list = new ArrayList<BusinessExp>() ;
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) {
				query.setCurUserId(shiroUser.getUserId());//社区和驿站根据小区范围数据范围不同
			}			
			if(shiroUser.getCurEstateId() != null) {
				query.setCurEstateId(shiroUser.getCurEstateId());
			}
			estateList = CommonUtils.getUser().getEstateBeanList();
			expressList =manageExpressAllService.findAll();
			list = businessExpService.findExcelAllExp(query);
		}catch(Exception e){
			GSLogger.error("显示businessExp导出excel列表时发生错误：/business/businessExp/expExcellist", e);
			e.printStackTrace();
		}
        ModelAndView mav = new ModelAndView("/module/express/expExcellist");
        mav.addObject("list", list);
        mav.addObject("size", list.size());
        mav.addObject("expressList", expressList);
        mav.addObject("estateList", estateList);
        return mav;
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getExcelPageList")
	public void getExcelPageList(BusinessExpQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) {
				query.setCurUserId(shiroUser.getUserId());//社区和驿站根据小区范围数据范围不同
			}				
			List<BusinessExp> expBean = businessExpService.findExcelAllExp(query);
			
			result.append("{\"total\":").append(expBean.size()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<expBean.size();i++) {
				BusinessExp businessExp = (BusinessExp) expBean.get(i);
				result.append("{")
			    .append("\"expId\":\"").append(businessExp.getExpId()).append("\"").append(",")
			    .append("\"senderId\":\"").append(businessExp.getSenderId()).append("\"").append(",")
			    .append("\"senderName\":\"").append(businessExp.getSenderName()).append("\"").append(",")
			    .append("\"expCode\":\"").append(businessExp.getExpCode()).append("\"").append(",")
			    .append("\"senderTel\":\"").append(businessExp.getSenderTel()).append("\"").append(",")
			    .append("\"receiverName\":\"").append(businessExp.getReceiverName()).append("\"").append(",")
			    .append("\"receiverTel\":\"").append(businessExp.getReceiverTel()).append("\"").append(",")
			    .append("\"receiveTime\":\"").append(businessExp.getReceiveTime()).append("\"").append(",")
			    .append("\"receiverAddr\":\"").append(businessExp.getReceiverAddr()).append("\"").append(",")
			    .append("\"sendTime\":\"").append(businessExp.getSendTime()).append("\"").append(",")
			    .append("\"expContent\":\"").append(businessExp.getExpContent()).append("\"").append(",")
			    .append("\"expState\":\"").append(businessExp.getExpState()).append("\"").append(",")
			    .append("\"lastMessage\":\"").append(businessExp.getLastMessage() != null ?businessExp.getLastMessage().replace("\"", "\\\""):"").append("\"").append(",")
			    .append("\"checkInTime\":\"").append(businessExp.getCheckInTime()).append("\"").append(",")
			    .append("\"senderAddr\":\"").append(businessExp.getSenderAddr()).append("\"").append(",")
			    .append("\"expType\":\"").append(businessExp.getExpType()).append("\"").append(",")
			    .append("\"station\":\"").append(businessExp.getStation()).append("\"").append(",")
			    .append("\"expCompanyId\":\"").append(businessExp.getExpCompanyID()).append("\"").append(",")
			    .append("\"expCompany\":\"").append(businessExp.getExpCompany()).append("\"").append(",")
			    .append("\"isPay\":\"").append(businessExp.getIsPay()).append("\"").append(",")
			    .append("\"payMount\":\"").append(businessExp.getPayMount()).append("\"").append(",")
			    .append("\"isAgent\":\"").append(businessExp.getIsAgent()).append("\"").append(",")
			    .append("\"agentMount\":\"").append(businessExp.getAgentMount()).append("\"").append(",")
			    .append("\"memo\":\"").append(businessExp.getMemo()).append("\"").append(",")
			    .append("\"getDate\":\"").append(businessExp.getGetDate()).append("\"").append(",")
			    .append("\"isAnytime\":\"").append(businessExp.getIsAnytime()).append("\"").append(",")
			    .append("\"getTime\":\"").append(businessExp.getGetTime()).append("\"").append(",")
			    .append("\"appointType\":\"").append(businessExp.getAppointType()).append("\"").append(",")
			    .append("\"appointContent\":\"").append(businessExp.getAppointContent()).append("\"").append(",")
			    .append("\"signname\":\"").append(businessExp.getSignname()).append("\"").append(",")
			    .append("\"signTime\":\"").append(businessExp.getSignTime()).append("\"").append(",")
			    .append("\"isSelf\":\"").append(businessExp.getIsSelf()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessExp.getCreateTime()).append("\"").append(",")
			    .append("\"newsCount\":\"").append(businessExp.getNewsCount()).append("\"").append(",")
			    .append("\"modifyTime\":\"").append(businessExp.getModifyTime()).append("\"").append(",")
			    .append("\"lastMessage\":\"").append(businessExp.getLastMessage()).append("\"").append(",")
			    .append("\"briefMessage\":\"").append(businessExp.getBriefMessage()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessExp.getEditor()).append("\"")
				.append("}").append(",");
			}
			json = result.toString();
			if(expBean.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "]}";
			
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("utf-8");
			try {
				response.getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}catch(Exception e){
			GSLogger.error("显示businessExp列表时发生错误：/business/businessExp/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessExpQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) {
				query.setCurUserId(shiroUser.getUserId());//社区和驿站根据小区范围数据范围不同
			}			
			if(shiroUser.getCurEstateId() != null) {
				query.setCurEstateId(shiroUser.getCurEstateId());
			}
			if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
				query.setSort(query.getOrderBy());
			}else{
				query.setSort("expId");
			}
			query.setOrder("desc");
			query.setRows(11);
			BaseBean baseBean = businessExpService.findAllPage(query);
			//result.append("{\"total\":\"").append(baseBean.getCount()+"_"+baseBean.getPager().getPageCount()).append("\",")
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessExp businessExp = (BusinessExp) baseBean.getList().get(i);
				result.append("{")
			    .append("\"expId\":\"").append(businessExp.getExpId()).append("\"").append(",")
			    .append("\"senderId\":\"").append(businessExp.getSenderId()).append("\"").append(",")
			    .append("\"senderName\":\"").append(businessExp.getSenderName()).append("\"").append(",")
			    .append("\"expCode\":\"").append(businessExp.getExpCode()).append("\"").append(",")
			    .append("\"senderTel\":\"").append(businessExp.getSenderTel()).append("\"").append(",")
			    .append("\"receiverName\":\"").append(businessExp.getReceiverName()).append("\"").append(",")
			    .append("\"receiverTel\":\"").append(businessExp.getReceiverTel()).append("\"").append(",")
			    .append("\"receiveTime\":\"").append(businessExp.getReceiveTime()).append("\"").append(",")
			    .append("\"receiverAddr\":\"").append(businessExp.getReceiverAddr()).append("\"").append(",")
			    .append("\"sendTime\":\"").append(businessExp.getSendTime()).append("\"").append(",")
			    .append("\"expContent\":\"").append(businessExp.getExpContent()).append("\"").append(",")
			    .append("\"expState\":\"").append(businessExp.getExpState()).append("\"").append(",")
			    .append("\"lastMessage\":\"").append(businessExp.getLastMessage() != null ?businessExp.getLastMessage().replace("\"", "\\\""):"").append("\"").append(",")
			    .append("\"checkInTime\":\"").append(businessExp.getCheckInTime()).append("\"").append(",")
			    .append("\"senderAddr\":\"").append(businessExp.getSenderAddr()).append("\"").append(",")
			    .append("\"expType\":\"").append(businessExp.getExpType()).append("\"").append(",")
			    .append("\"station\":\"").append(businessExp.getStation()).append("\"").append(",")
			    .append("\"expCompanyId\":\"").append(businessExp.getExpCompanyID()).append("\"").append(",")
			    .append("\"expCompany\":\"").append(businessExp.getExpCompany()).append("\"").append(",")
			    .append("\"isPay\":\"").append(businessExp.getIsPay()).append("\"").append(",")
			    .append("\"payMount\":\"").append(businessExp.getPayMount()).append("\"").append(",")
			    .append("\"isAgent\":\"").append(businessExp.getIsAgent()).append("\"").append(",")
			    .append("\"agentMount\":\"").append(businessExp.getAgentMount()).append("\"").append(",")
			    .append("\"memo\":\"").append(businessExp.getMemo()).append("\"").append(",")
			    .append("\"getDate\":\"").append(businessExp.getGetDate()).append("\"").append(",")
			    .append("\"isAnytime\":\"").append(businessExp.getIsAnytime()).append("\"").append(",")
			    .append("\"getTime\":\"").append(businessExp.getGetTime()).append("\"").append(",")
			    .append("\"appointType\":\"").append(businessExp.getAppointType()).append("\"").append(",")
			    .append("\"appointContent\":\"").append(businessExp.getAppointContent()).append("\"").append(",")
			    .append("\"signname\":\"").append(businessExp.getSignname()).append("\"").append(",")
			    .append("\"signTime\":\"").append(businessExp.getSignTime()).append("\"").append(",")
			    .append("\"isSelf\":\"").append(businessExp.getIsSelf()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessExp.getCreateTime()).append("\"").append(",")
			    .append("\"newsCount\":\"").append(businessExp.getNewsCount()).append("\"").append(",")
			    .append("\"modifyTime\":\"").append(businessExp.getModifyTime()).append("\"").append(",")
			    .append("\"lastMessage\":\"").append(businessExp.getLastMessage()).append("\"").append(",")
			    .append("\"briefMessage\":\"").append(businessExp.getBriefMessage()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessExp.getEditor()).append("\"")
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
			GSLogger.error("显示businessExp列表时发生错误：/business/businessExp/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入发布收件页
	 * @return
	 */
	@RequestMapping(value="addReceive")
	public ModelAndView addReceive(BusinessExpQuery query) {
		List expressList = null;
        try{
        	// expressList = manageExpressService.findExpressByStation(CommonUtils.getUser().getOrgId());
        	expressList =manageExpressAllService.findAll();
        }catch(Exception e){
			GSLogger.error("进入businessExp新增页时发生错误：/business/businessExp/addReceive", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/express/addReceive");
		mav.addObject("expressList", expressList);
		return mav;
	}

	/**
	 * 进入快件发件页
	 * @return
	 */
	@RequestMapping(value="addSend")
	public ModelAndView send(BusinessExpQuery query) {
		List expressList = null;
        try{
        	// expressList = manageExpressService.findExpressByStation(CommonUtils.getUser().getOrgId());
        	expressList =manageExpressAllService.findAll();
		}catch(Exception e){
			GSLogger.error("进入businessExp新增页时发生错误：/business/businessExp/addSend", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/express/addSend");
		mav.addObject("expressList", expressList);
        return mav;
	}

	/**
	 * 进入预约取件页
	 * @return
	 */
	@RequestMapping(value="addAppointment")
	public ModelAndView addAppointment(BusinessExpQuery query) {
		List expressList = null;
        try{
        	// expressList = manageExpressService.findExpressByStation(CommonUtils.getUser().getOrgId());
        	expressList =manageExpressAllService.findAll();
        }catch(Exception e){
			GSLogger.error("进入businessExp新增页时发生错误：/business/businessExp/addAppointment", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/express/addAppointment");
		mav.addObject("expressList", expressList);
        return mav;
	}

	/**
	 * 进入优惠页
	 * @return
	 */
	@RequestMapping(value="addDiscount")
	public ModelAndView addDiscount(BusinessExpQuery query) {
		BusinessExpFav businessExpFav = new BusinessExpFav();
		try{
			Map paramMap = new HashMap();
			ShiroUser shiroUser = CommonUtils.getUser();
			paramMap.put("stationId", shiroUser.getOrgId());
			List list = businessExpFavService.findByMap(paramMap);
			if(list != null && list.size() > 0) {
				businessExpFav = (BusinessExpFav) list.get(0);
			}
		}catch(Exception e){
			GSLogger.error("进入businessExp新增页时发生错误：/business/businessExp/addDiscount", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/express/discount");
		mav.addObject("businessExpFav", businessExpFav);
		return mav;
	}
	
	/**
	 * 保存收件对象
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(value="saveReceive")
	public void saveReceive(HttpServletRequest request, HttpServletResponse response, BusinessExpQuery query) {
		BusinessExp businessExp = new BusinessExp();
		String json = "";
		try{
			boolean isUser = false;
			String cellphone = query.getReceiverTel();
			AppUser appUser = appUserService.getAppUserByTel(cellphone);
			if(appUser != null) {
				isUser = true;
				businessExp.setReceiverId(appUser.getUserId());
			}
			
			ShiroUser shiroUser = CommonUtils.getUser();
		    //businessExp.setSenderId(query.getSenderId());
		    //businessExp.setSenderName(query.getSenderName());
		    businessExp.setExpCode(query.getExpCode());
		    //businessExp.setSenderTel(query.getSenderTel());
		    businessExp.setReceiverName(query.getReceiverName());
		    businessExp.setReceiverTel(query.getReceiverTel());
		    businessExp.setPhoneType(query.getPhoneType());
		    //businessExp.setReceiveTime(new Timestamp(System.currentTimeMillis()));
		    businessExp.setReceiverAddr(query.getReceiverAddr());
		    //businessExp.setSendTime(new Timestamp(System.currentTimeMillis()));
		    //businessExp.setExpContent(query.getExpContent());
		    businessExp.setExpState(3);//已入库
		    businessExp.setCheckInTime(new Timestamp(System.currentTimeMillis()));//入库时间
		    //businessExp.setSenderAddr(query.getSenderAddr());
		    businessExp.setExpType(0);//收件
		    //生成6位验证码
		    String str=StringUtil.createRandom(true, 6);
		    businessExp.setCode(str);
            //查询当前所属驿站信息            
            BusinessStation businessStation = new BusinessStation();
            ManageEstate manageEstate = manageEstateService.findById(shiroUser.getCurEstateId());
            businessStation = businessStationService.findById(manageEstate.getStationId());
            businessExp.setStationId(businessStation.getStationId());
            businessExp.setStation(businessStation.getStaName());
            businessExp.setEstateId(shiroUser.getCurEstateId());
           /* ManageExpress manageExpress = manageExpressService.findById(query.getExpCompanyID());
		    businessExp.setExpCompanyID(manageExpress.getExpressId());
		    businessExp.setExpCompany(manageExpress.getExpressComppay());
		    businessExp.setLogo(manageExpress.getExpressIcon());*/
            ManageExpressAll manageExpressAll = manageExpressAllService.findById(query.getExpCompanyID());
		    businessExp.setExpCompanyID(manageExpressAll.getExpressId());
		    businessExp.setExpCompany(manageExpressAll.getExpressComppay());
		    businessExp.setLogo(manageExpressAll.getExpressIcon());
		    businessExp.setIsPay(query.getIsPay());
		    businessExp.setPayMount(query.getPayMount()==null?0:query.getPayMount());
		    businessExp.setIsAgent(query.getIsAgent());
		    businessExp.setAgentMount(query.getAgentMount()==null?0:query.getAgentMount());
		    businessExp.setMemo(query.getMemo()==null?"":query.getMemo());
		    //businessExp.setGetDate(query.getGetDate());
		    //businessExp.setIsAnytime(query.getIsAnytime());
		    //businessExp.setGetTime(query.getGetTime());
		    //businessExp.setAppointType(query.getAppointType());
		    //businessExp.setAppointContent(query.getAppointContent());
		    //businessExp.setSignname(query.getSignname());
		    //businessExp.setSignTime(query.getSignTime());
		    //businessExp.setIsSelf(query.getIsSelf());
		    businessExp.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessExp.setModifyTime(new Timestamp(System.currentTimeMillis()));
		    businessExp.setEditor(shiroUser.getUserName());
		    businessExp.setIsDistributed(0);
		    businessExp.setIsProblem(0);
			businessExpService.save(businessExp);
			
			if(businessExp.getExpId() > 0 && businessExp.getReceiverTel().length() == 11) {
				if(query.getFlag() == 1) {
					BusinessAddress businessAddress = new BusinessAddress();
					businessAddress.setMobile(businessExp.getReceiverTel());
					businessAddress.setContacts(businessExp.getReceiverName());
					businessAddress.setAddress(businessExp.getReceiverAddr());
					businessAddressService.save(businessAddress);
				} else {
            		Map paramMap = new HashMap();
            		paramMap.put("mobile", businessExp.getReceiverTel());
            		paramMap.put("contacts", businessExp.getReceiverName());
            		paramMap.put("address", businessExp.getReceiverAddr());
            		
            		List<BusinessAddress> addrList = businessAddressService.findByMap(paramMap);
            		if(addrList.size() == 0 ) {
            			BusinessAddress businessAddress = new BusinessAddress();
    					businessAddress.setMobile(businessExp.getReceiverTel());
    					businessAddress.setContacts(businessExp.getReceiverName());
    					businessAddress.setAddress(businessExp.getReceiverAddr());
    					businessAddressService.save(businessAddress);
            		}
            	}
			}
						
			//服务器保存发送的处理
	        BusinessExpBackresolve businessExpBackresolve = new BusinessExpBackresolve();
	        businessExpBackresolve.setExpId(businessExp.getExpId());
		    businessExpBackresolve.setResolverId(shiroUser.getUserId());
		    businessExpBackresolve.setResolverName(shiroUser.getUserName());
		    businessExpBackresolve.setState(String.valueOf(businessExp.getExpState()));
		    businessExpBackresolve.setType(0);
		    businessExpBackresolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
		    BusinessUser businessUser = businessUserService.findById(shiroUser.getUserId());
		    businessExpBackresolve.setResolveMemo("快件,已经到达服务驿站\\r\\n办理人： "+shiroUser.getUserName()+"\\r\\n联系方式： "+businessUser.getUserTel());
		    //businessExpBackresolve.setResolveMemo("快件，已经到达 "+businessExp.getStation()+"\\r\\n办理人 ："+shiroUser.getUserName()+"\\r\\n联系方式："+businessUser.getUserTel());
		    businessExpBackresolveService.save(businessExpBackresolve);
		    
		    //手机保存处理信息
		    BusinessExpResolve businessExpResolve = new BusinessExpResolve();
		    businessExpResolve.setExpId(businessExp.getExpId());
		    businessExpResolve.setResolverId(shiroUser.getUserId());
		    businessExpResolve.setResolverName(shiroUser.getUserName());
		    businessExpResolve.setState(String.valueOf(businessExp.getExpState()));
		    businessExpResolve.setType(0);
		    businessExpResolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
		    businessExpResolve.setResolveMemo("快件,已经到达服务驿站\\r\\n办理人： "+businessUser.getUserName()+"\\r\\n联系方式： "+businessUser.getUserTel());
		    //businessExpBackresolve.setResolveMemo("快件，已经到达 "+businessExp.getStation()+"\\r\\n办理人 ："+shiroUser.getUserName()+"\\r\\n联系方式："+businessUser.getUserTel());
		    businessExpResolveService.save(businessExpResolve);
		    
		    String currTime = String.valueOf(businessExp.getModifyTime()).substring(0, 16);
		    businessExp.setBriefMessage(currTime+"\\r\\n运单号:"+businessExp.getExpCode()+"\\r\\n快件，已经到达"+businessExp.getStation());
		    businessExp.setLastMessage("快件，已经到达"+businessExp.getStation());
		    businessExpService.update(businessExp);
		    
		    //能够使用电话绑定的用户就能够收到消息
		    if(isUser) {
		    	AppLatestNews appLatestNews = new AppLatestNews();
			    appLatestNews.setUserId(businessExp.getReceiverId());
			    appLatestNews.setTypeId(21);//我的快件
			    appLatestNews.setSourceId(businessExp.getExpId());
			    appLatestNews.setTo(0);
			    appLatestNews.setEstateId(0);
			    appLatestNewsService.save_app(appLatestNews);

			    appLatestNews = new AppLatestNews();
			    appLatestNews.setUserId(businessExp.getReceiverId());
			    appLatestNews.setTypeId(24);//未收快件
			    appLatestNews.setSourceId(businessExp.getExpId());
			    appLatestNews.setTo(0);
			    appLatestNews.setEstateId(0);
			    appLatestNewsService.save_app(appLatestNews);

			    appLatestNews = new AppLatestNews();
			    appLatestNews.setUserId(businessExp.getReceiverId());
			    appLatestNews.setTypeId(26);//快件列表
			    appLatestNews.setSourceId(businessExp.getExpId());
			    appLatestNews.setTo(0);
			    appLatestNews.setEstateId(0);
			    appLatestNewsService.save_app(appLatestNews);
		    }
		    
		    
		    //发送验证码处理
		  //todo:判断收件人手机号，如果非APP用户则给收件人发送短信，如果是APP用户则给收件人推送通知
           /* Map map = new HashMap();
            map.put("tel", query.getReceiverTel());
            List list = appUserService.findByMap(map);*/
            if(isUser) {
                //APP用户
                //System.out.println("向APP用户推送通知！");
            	Map paramMapTemp = new HashMap();
            	paramMapTemp.put("userId", appUser.getUserId());
				List configList = appUserConfigService.findByMap(paramMapTemp);
				AppUserConfig appUserConfig = null;
				if(configList != null) {
					appUserConfig = (AppUserConfig) configList.get(0);
				}	
            	if(appUserConfig != null 
						&& appUserConfig.getExpressSwitch() == 0 
						&& appUser.getBaiduId() != null 
						&& !"".equals(appUser.getBaiduId()) 
						&& appUser.getChannelId() != null 
						&& !"".equals(appUser.getChannelId())) {
            		String title = "OK家";
					String description = "【"+businessExp.getStation()+"】尊贵的主人，我是您的快件。现已到达社区服务驿站，请您快来社区服务驿站接我吧！取件签收码："+ businessExp.getCode();
					
					Map paramMap = new HashMap();
					paramMap.put("messageType", 3);
					paramMap.put("ID", businessExp.getExpId());
					paramMap.put("expState", businessExp.getExpState());
					
					Integer success = AppPushNotificationUtil.pushNotification(
							title, 
							description, 
							appUser.getDeviceType(),
							Long.valueOf(appUser.getChannelId()).longValue(), 
							appUser.getBaiduId(),
							paramMap
							);
					//记录推送日志
					AppPushLog appPushLog = new AppPushLog();
					appPushLog.setUserId(appUser.getUserId());
				    appPushLog.setUserName(appUser.getRealname());
				    appPushLog.setBaiduId(appUser.getBaiduId());
				    appPushLog.setChannelId(appUser.getChannelId());
				    appPushLog.setTitle(title);
				    appPushLog.setDescription(description);
				    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
				    appPushLog.setSendState(success);
				    appPushLog.setSenderId(shiroUser.getUserId());
				    appPushLog.setSenderName(shiroUser.getUserName());
					appPushLogService.save(appPushLog);
				}
            } else {
                //非APP用户
                //System.out.println("向非APP用户发送短信通知！");
        		MessageChannelClient client=new MessageChannelClient();
        		//短信发送		
        		StringBuilder sb = new StringBuilder();
        		String messageContent = "【"+businessExp.getStation()+"】尊贵的主人，我是您的快件。现已到达社区服务驿站，请您快来社区服务驿站接我吧！驿站电话:"+businessStation.getStaTel()+"取件签收码："+ businessExp.getCode() +"请妥善保管；为了让尊贵的主人享受更便捷的服务，驿站专属手机社区服务平台“OK家”已经发布了，猛戳后边链接，也把他接回家吧：http://www.bqsqcm.com/community/download/index.html?id=11【OK家】";
        		sb.append(messageContent);
        		//sb.append("您正在申请注册OK家注册用户,验证码").append(messageContent).append(",2分钟内有效。【OK家】");
        		String content=URLEncoder.encode(sb.toString(), "utf8");
        		String result_mt = client.mdsmssend(cellphone, content, "", "", "", "");
        		manageSendMsgService.save(cellphone,result_mt,messageContent,0);
            }
                
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessExp信息时发生错误：/business/businessExp/save", e);
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
	 * 保存发件对象
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(value="saveSend")
	public void saveSend(HttpServletRequest request, HttpServletResponse response, BusinessExpQuery query) {
		BusinessExp businessExp = new BusinessExp();
		String json = "";
		try{
			boolean isUser = false;
			String cellphone = query.getSenderTel();
			AppUser appUser = appUserService.getAppUserByTel(cellphone);
			if(appUser != null) {
				isUser = true;
				businessExp.setSenderId(appUser.getUserId());
			}
			ShiroUser shiroUser = CommonUtils.getUser();
		    //businessExp.setSenderId(query.getSenderId());
		    businessExp.setSenderName(query.getSenderName());
		    businessExp.setExpCode(query.getExpCode());
		    businessExp.setSenderTel(query.getSenderTel());
		    businessExp.setPhoneType(query.getPhoneType());
		    businessExp.setReceiverName(query.getReceiverName());
		    businessExp.setReceiverTel(query.getReceiverTel());
		    businessExp.setReceiveTime(new Timestamp(System.currentTimeMillis()));
		    businessExp.setReceiverAddr(query.getReceiverAddr());
		    businessExp.setSendTime(new Timestamp(System.currentTimeMillis()));
		    //businessExp.setExpContent(query.getExpContent());
		    businessExp.setExpState(2);//直接发件
		    //businessExp.setCheckInTime(new Timestamp(System.currentTimeMillis()));
		    businessExp.setSenderAddr(query.getSenderAddr());
		    businessExp.setExpType(1);//发件
            //查询当前所属驿站信息            
            BusinessStation businessStation = new BusinessStation();
            ManageEstate manageEstate = manageEstateService.findById(shiroUser.getCurEstateId());
            businessStation = businessStationService.findById(manageEstate.getStationId());
            businessExp.setStationId(businessStation.getStationId());
            businessExp.setStation(businessStation.getStaName());
            businessExp.setEstateId(shiroUser.getCurEstateId());
            ManageExpressAll manageExpressAll = manageExpressAllService.findById(query.getExpCompanyID());
		    businessExp.setExpCompanyID(manageExpressAll.getExpressId());
		    businessExp.setExpCompany(manageExpressAll.getExpressComppay());
		    businessExp.setLogo(manageExpressAll.getExpressIcon());
		    businessExp.setIsPay(query.getIsPay());
		    businessExp.setPayMount(query.getPayMount()==null?0:query.getPayMount());
		    businessExp.setIsAgent(query.getIsAgent()==null?0:query.getIsAgent());
		    businessExp.setAgentMount(query.getAgentMount()==null?0:query.getAgentMount());
		    businessExp.setMemo(query.getMemo()==null?"":query.getMemo());
		    businessExp.setIsProblem(0);
		    businessExp.setIsDistributed(0);
		    //businessExp.setGetDate(query.getGetDate());
		    //businessExp.setIsAnytime(query.getIsAnytime());
		    //businessExp.setGetTime(query.getGetTime());
		    //businessExp.setAppointType(query.getAppointType());
		    //businessExp.setAppointContent(query.getAppointContent());
		    //businessExp.setSignname(query.getSignname());
		    //businessExp.setSignTime(query.getSignTime());
		    //businessExp.setIsSelf(query.getIsSelf());
		    businessExp.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessExp.setModifyTime(new Timestamp(System.currentTimeMillis()));
		    businessExp.setEditor(shiroUser.getUserName());
	        Timestamp  ts=new Timestamp(new Date().getTime());
            
			businessExpService.save(businessExp);
			
			if(businessExp.getExpId() > 0 && businessExp.getSenderTel().length() == 11) {
            	if(query.getFlag() == 1) {
					BusinessAddress businessAddress = new BusinessAddress();
					businessAddress.setMobile(businessExp.getSenderTel());
					businessAddress.setContacts(businessExp.getSenderName());
					businessAddress.setAddress(businessExp.getSenderAddr());
					businessAddressService.save(businessAddress);
            	} else {
            		Map paramMap = new HashMap();
            		paramMap.put("mobile", businessExp.getSenderTel());
            		paramMap.put("contacts", businessExp.getSenderName());
            		paramMap.put("address", businessExp.getSenderAddr());
            		
            		List<BusinessAddress> addrList = businessAddressService.findByMap(paramMap);
            		if(addrList.size() == 0 ) {
            			BusinessAddress businessAddress = new BusinessAddress();
    					businessAddress.setMobile(businessExp.getSenderTel());
    					businessAddress.setContacts(businessExp.getSenderName());
    					businessAddress.setAddress(businessExp.getSenderAddr());
    					businessAddressService.save(businessAddress);
            		}
            	}
			}
			 
			//todo:判断发件人手机号，如果非APP用户则给收件人发送短信，如果是APP用户则给收件人推送通知
            /* Map map = new HashMap();
            map.put("tel", query.getReceiverTel());
            List list = appUserService.findByMap(map);*/
	        if(isUser) {
                //APP用户
                //System.out.println("向APP用户推送通知！");
	        	Map paramMapTemp = new HashMap();
	        	paramMapTemp.put("userId", appUser.getUserId());
				List configList = appUserConfigService.findByMap(paramMapTemp);
				AppUserConfig appUserConfig = null;
				if(configList != null) {
					appUserConfig = (AppUserConfig) configList.get(0);
				}	
            	if(appUserConfig != null 
						&& appUserConfig.getExpressSwitch() == 0 
						&& appUser.getBaiduId() != null 
						&& !"".equals(appUser.getBaiduId()) 
						&& appUser.getChannelId() != null 
						&& !"".equals(appUser.getChannelId())) {
            		String title = "OK家";
					String description = "【"+businessExp.getStation()+"】尊贵的主人，我是您要发出的快件，现在我已经奔向目的地了，我的编码是：" + businessExp.getExpCompany() + " " + businessExp.getExpCode();
					Map paramMap = new HashMap();
					paramMap.put("messageType", 6);
					paramMap.put("ID", businessExp.getExpId());
					paramMap.put("expState", businessExp.getExpState());
					
					Integer success = AppPushNotificationUtil.pushNotification(
							title, 
							description, 
							appUser.getDeviceType(),
							Long.valueOf(appUser.getChannelId()).longValue(), 
							appUser.getBaiduId(),
							paramMap
							);
					//记录推送日志
					AppPushLog appPushLog = new AppPushLog();
					appPushLog.setUserId(appUser.getUserId());
				    appPushLog.setUserName(appUser.getRealname());
				    appPushLog.setBaiduId(appUser.getBaiduId());
				    appPushLog.setChannelId(appUser.getChannelId());
				    appPushLog.setTitle(title);
				    appPushLog.setDescription(description);
				    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
				    appPushLog.setSendState(success);
				    appPushLog.setSenderId(shiroUser.getUserId());
				    appPushLog.setSenderName(shiroUser.getUserName());
					appPushLogService.save(appPushLog);
				}
            } else {
                //非APP用户
                //System.out.println("向非APP用户发送短信通知！");
        		MessageChannelClient client=new MessageChannelClient();
        		//短信发送		
        		StringBuilder sb = new StringBuilder();
        		String messageContent = "【"+businessExp.getStation()+"】尊贵的主人，我是您要发出的快件，现在我已经奔向目的地了，我的编码是：" + businessExp.getExpCompany() + " " + businessExp.getExpCode()+"，驿站电话:"+businessStation.getStaTel()+"【OK家】";
        		sb.append(messageContent);
        		//sb.append("您正在申请注册OK家注册用户,验证码").append(messageContent).append(",2分钟内有效。【OK家】");
        		String content=URLEncoder.encode(sb.toString(), "utf8");
        		String result_mt = client.mdsmssend(cellphone, content, "", "", "", "");
        		manageSendMsgService.save(cellphone,result_mt,messageContent,0);
            }
			
			//保存发送的处理
			BusinessUser businessUser = businessUserService.findById(shiroUser.getUserId());
			BusinessExpBackresolve businessExpBackresolve = new BusinessExpBackresolve();
	        businessExpBackresolve.setExpId(businessExp.getExpId());
		    businessExpBackresolve.setResolverId(shiroUser.getUserId());
		    businessExpBackresolve.setResolverName(shiroUser.getUserName());
		    businessExpBackresolve.setState(String.valueOf(businessExp.getExpState()));
		    businessExpBackresolve.setType(0);
		    businessExpBackresolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
		    businessExpBackresolve.setResolveMemo("快件已从服务驿站发出\\r\\n办理人："+businessUser.getUserName()+"\\r\\n联系方式："+businessUser.getUserTel()+"\\r\\n运费金额:￥"+businessExp.getPayMount());
		    //businessExpBackresolve.setResolveMemo("快件已从"+businessExp.getStation()+"服务驿站发出");
		    businessExpBackresolveService.save(businessExpBackresolve);
			
		  //保存发送的处理
			BusinessExpResolve businessExpResolve = new BusinessExpResolve();
			businessExpResolve.setExpId(businessExp.getExpId());
			businessExpResolve.setResolverId(shiroUser.getUserId());
			businessExpResolve.setResolverName(shiroUser.getUserName());
			businessExpResolve.setState(String.valueOf(businessExp.getExpState()));
			businessExpResolve.setType(0);
			businessExpResolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
			businessExpResolve.setResolveMemo("快件已从服务驿站发出\\r\\n办理人："+businessUser.getUserName()+"\\r\\n联系方式："+businessUser.getUserTel()+"\\r\\n运费金额:￥"+businessExp.getPayMount());
		    //businessExpBackresolve.setResolveMemo("快件已从"+businessExp.getStation()+"服务驿站发出");
		    businessExpResolveService.save(businessExpResolve);
		    
		    String currTime = String.valueOf(businessExp.getModifyTime()).substring(0, 16);
		    businessExp.setBriefMessage(currTime+"\\r\\n运单号:"+businessExp.getExpCode()+"\\r\\n已从服务驿站发出");
		    businessExp.setLastMessage("快件 已从服务驿站发出");
		    businessExpService.update(businessExp);
		    
		    //能够使用电话绑定的用户就能够收到消息
		    if(isUser) {
		    	AppLatestNews appLatestNews = new AppLatestNews();
			    appLatestNews.setUserId(businessExp.getSenderId());
			    appLatestNews.setTypeId(21);//我的快件
			    appLatestNews.setSourceId(businessExp.getExpId());
			    appLatestNews.setTo(0);
			    appLatestNews.setEstateId(0);
			    appLatestNewsService.save_app(appLatestNews);

			    appLatestNews = new AppLatestNews();
			    appLatestNews.setUserId(businessExp.getSenderId());
			    appLatestNews.setTypeId(23);//已发快件
			    appLatestNews.setSourceId(businessExp.getExpId());
			    appLatestNews.setTo(0);
			    appLatestNews.setEstateId(0);
			    appLatestNewsService.save_app(appLatestNews);

			    appLatestNews = new AppLatestNews();
			    appLatestNews.setUserId(businessExp.getSenderId());
			    appLatestNews.setTypeId(26);//快件列表
			    appLatestNews.setSourceId(businessExp.getExpId());
			    appLatestNews.setTo(0);
			    appLatestNews.setEstateId(0);
			    appLatestNewsService.save_app(appLatestNews);
		    }
		    
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessExp信息时发生错误：/business/businessExp/save", e);
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
	 * 编辑发件对象
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(value="updateSend")
	public void updateSend(HttpServletRequest request, HttpServletResponse response, BusinessExpQuery query) {
		BusinessExp businessExp = new BusinessExp();
		String json = "";
		try{
			AppLatestNewsQuery newsQuery = new AppLatestNewsQuery();
        	newsQuery.setTypeId(38);//快递
        	newsQuery.setSourceId(query.getExpId());
        	newsQuery.setTo(1);//居民向后台发送
        	appLatestNewsService.deleteByCondition(newsQuery);
			ShiroUser shiroUser = CommonUtils.getUser();
			businessExp = businessExpService.findById(query.getExpId());
				boolean isUser = false;
				
				if(businessExp.getIsVideo() == 0) {
					String cellphone = query.getSenderTel();
					AppUser appUser = appUserService.getAppUserByTel(cellphone);
					if(appUser != null) {
						isUser = true;
						businessExp.setSenderId(appUser.getUserId());
					}					
				}
			    //businessExp.setSenderId(query.getSenderId());
			    businessExp.setSenderName(query.getSenderName());
			    businessExp.setExpCode(query.getExpCode());
			    businessExp.setSenderTel(query.getSenderTel());
			    businessExp.setPhoneType(query.getPhoneType());
			    businessExp.setReceiverName(query.getReceiverName());
			    businessExp.setReceiverTel(query.getReceiverTel());
			    businessExp.setReceiveTime(new Timestamp(System.currentTimeMillis()));
			    businessExp.setReceiverAddr(query.getReceiverAddr());
			    businessExp.setSendTime(new Timestamp(System.currentTimeMillis()));
			    //businessExp.setExpContent(query.getExpContent());
			    businessExp.setExpState(2);//直接发件
			    //businessExp.setCheckInTime(new Timestamp(System.currentTimeMillis()));
			    businessExp.setSenderAddr(query.getSenderAddr());
			    businessExp.setExpType(1);//发件
	            //查询当前所属驿站信息            
	            BusinessStation businessStation = new BusinessStation();
	            //ManageEstate manageEstate = manageEstateService.findById(shiroUser.getCurEstateId());
	            //businessStation = businessStationService.findById(manageEstate.getStationId());
	            //businessStation = businessStationService.findById(businessExp.getStationId());
	            //businessExp.setStation(businessStation.getStaName());
	            //businessExp.setStationId(businessStation.getStationId());
	           /* ManageExpress manageExpress = manageExpressService.findById(query.getExpCompanyID());
			    businessExp.setExpCompanyID(manageExpress.getExpressId());
			    businessExp.setExpCompany(manageExpress.getExpressComppay());
			    businessExp.setLogo(manageExpress.getExpressIcon());*/
	            ManageExpressAll manageExpressAll = manageExpressAllService.findById(query.getExpCompanyID());
			    businessExp.setExpCompanyID(manageExpressAll.getExpressId());
			    businessExp.setExpCompany(manageExpressAll.getExpressComppay());
			    businessExp.setLogo(manageExpressAll.getExpressIcon());
			    
			    businessExp.setIsPay(query.getIsPay());
			    businessExp.setPayMount(query.getPayMount()==null?0:query.getPayMount());
			    businessExp.setIsAgent(query.getIsAgent());
			    businessExp.setAgentMount(query.getAgentMount());
			    businessExp.setMemo(query.getMemo());
			    //businessExp.setGetDate(query.getGetDate());
			    //businessExp.setIsAnytime(query.getIsAnytime());
			    //businessExp.setGetTime(query.getGetTime());
			    //businessExp.setAppointType(query.getAppointType());
			    //businessExp.setAppointContent(query.getAppointContent());
			    //businessExp.setSignname(query.getSignname());
			    //businessExp.setSignTime(query.getSignTime());
			    //businessExp.setIsSelf(query.getIsSelf());
			    businessExp.setCreateTime(new Timestamp(System.currentTimeMillis()));
			    businessExp.setModifyTime(new Timestamp(System.currentTimeMillis()));
			    businessExp.setEditor(shiroUser.getUserName());
		        Timestamp  ts=new Timestamp(new Date().getTime());

				businessExpService.update(businessExp);
				
				//todo:判断发件人手机号，如果非APP用户则给收件人发送短信，如果是APP用户则给收件人推送通知
	            /* Map map = new HashMap();
	            map.put("tel", query.getReceiverTel());
	            List list = appUserService.findByMap(map);*/
				boolean isSendUser = false;
				AppUser sendUser = appUserService.findById(businessExp.getSenderId());
				if(sendUser != null) {
					isSendUser = true;
				}
		        if(isSendUser) {
	                //APP用户
	                //System.out.println("向APP用户推送通知！");
		        	Map paramMapTemp = new HashMap();
		        	paramMapTemp.put("userId", sendUser.getUserId());
					List configList = appUserConfigService.findByMap(paramMapTemp);
					AppUserConfig appUserConfig = null;
					if(configList != null) {
						appUserConfig = (AppUserConfig) configList.get(0);
					}	
	            	if(appUserConfig != null 
							&& appUserConfig.getExpressSwitch() == 0 
							&& sendUser.getBaiduId() != null 
							&& !"".equals(sendUser.getBaiduId()) 
							&& sendUser.getChannelId() != null 
							&& !"".equals(sendUser.getChannelId())) {
	            		String title = "OK家";
						String description = "【"+businessExp.getStation()+"】尊贵的主人，我是您要发出的快件，现在我已经奔向目的地了，我的编码是：" + businessExp.getExpCompany() + " " + businessExp.getExpCode();
						Map paramMap = new HashMap();
						paramMap.put("messageType", 6);
						paramMap.put("ID", businessExp.getExpId());
						paramMap.put("expState", businessExp.getExpState());
						
						Integer success = AppPushNotificationUtil.pushNotification(
								title, 
								description, 
								sendUser.getDeviceType(),
								Long.valueOf(sendUser.getChannelId()).longValue(), 
								sendUser.getBaiduId(),
								paramMap
								);
						//记录推送日志
						AppPushLog appPushLog = new AppPushLog();
						appPushLog.setUserId(sendUser.getUserId());
					    appPushLog.setUserName(sendUser.getRealname());
					    appPushLog.setBaiduId(sendUser.getBaiduId());
					    appPushLog.setChannelId(sendUser.getChannelId());
					    appPushLog.setTitle(title);
					    appPushLog.setDescription(description);
					    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
					    appPushLog.setSendState(success);
					    appPushLog.setSenderId(shiroUser.getUserId());
					    appPushLog.setSenderName(shiroUser.getUserName());
						appPushLogService.save(appPushLog);
					}
	            } else {
	            	//非APP用户
	                //System.out.println("向非APP用户发送短信通知！");
	        		MessageChannelClient client=new MessageChannelClient();
	        		//短信发送		
	        		StringBuilder sb = new StringBuilder();
	        		String messageContent = "【"+businessExp.getStation()+"】尊贵的主人，我是您要发出的快件，现在我已经奔向目的地了，我的编码是：" + businessExp.getExpCompany() + " " + businessExp.getExpCode()+"。【OK家】";
	        		sb.append(messageContent);
	        		//sb.append("您正在申请注册OK家注册用户,验证码").append(messageContent).append(",2分钟内有效。【OK家】");
	        		String content=URLEncoder.encode(sb.toString(), "utf8");
	        		String result_mt = client.mdsmssend(businessExp.getSenderTel(), content, "", "", "", "");
	        		manageSendMsgService.save(businessExp.getSenderTel(),result_mt,messageContent,0);
	            }
		        
		        //使用过发送快件服务的居民改变居民的状态为验证类型居民
		        if(isSendUser) {
		        	AppUser appUser = new AppUser();
		            appUser.setUserId(sendUser.getUserId());
		            appUser.setType(1);//验证居民
		            appUser.setVerifyTime(ts);
		            appUser.setVerifier(getUser().getUserName());
		            appUserService.update(appUser);
		        }	            
				
				//保存处理
		        /*BusinessExpResolve businessExpResolve = new BusinessExpResolve();
		        businessExpResolve.setExpId(query.getExpId());
		        businessExpResolve.setResolverId(shiroUser.getUserId());
		        businessExpResolve.setResolverName(shiroUser.getUserName());
		        businessExpResolve.setState(String.valueOf(businessExp.getExpState()));
		        businessExpResolve.setType(0);
		        businessExpResolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
			    BusinessUser businessUser = businessUserService.findById(shiroUser.getUserId());
			    businessExpResolve.setResolveMemo("快件已从服务驿站发出\\r\\n办理人："+shiroUser.getUserName()+"\\r\\n联系方式："+businessUser.getUserTel()+"\\r\\n运费金额:￥"+businessExp.getPayMount());
			    businessExpResolveService.save(businessExpResolve);
			    
			    BusinessExpBackresolve businessExpBackresolve = new BusinessExpBackresolve();
		        businessExpBackresolve.setExpId(query.getExpId());
			    businessExpBackresolve.setResolverId(shiroUser.getUserId());
			    businessExpBackresolve.setResolverName(shiroUser.getUserName());
			    businessExpBackresolve.setState(String.valueOf(businessExp.getExpState()));
			    businessExpBackresolve.setType(0);
			    businessExpBackresolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
			    businessExpBackresolve.setResolveMemo("快件已从服务驿站发出\\r\\n办理人："+shiroUser.getUserName()+"\\r\\n联系方式："+businessUser.getUserTel()+"\\r\\n运费金额:￥"+businessExp.getPayMount());
			    businessExpBackresolveService.save(businessExpBackresolve);*/
				
			    String currTime = String.valueOf(businessExp.getModifyTime()).substring(0, 16);
			    businessExp.setBriefMessage(currTime+"\\r\\n运单号:"+businessExp.getExpCode()+"\\r\\n快件 已从服务驿站发出");
			    //businessExp.setBriefMessage(businessExpBackresolve.getResolveMemo());
			    businessExp.setLastMessage("快件 已从服务驿站发出");
			    businessExpService.update(businessExp);
			    
			    //能够使用电话绑定的用户就能够收到消息
			    if(isSendUser) {
			    	AppLatestNews appLatestNews = new AppLatestNews();
				    appLatestNews.setUserId(businessExp.getSenderId());
				    appLatestNews.setTypeId(21);//我的快件
				    appLatestNews.setSourceId(businessExp.getExpId());
				    appLatestNews.setTo(0);
				    appLatestNews.setEstateId(0);
				    appLatestNewsService.save_app(appLatestNews);

				    appLatestNews = new AppLatestNews();
				    appLatestNews.setUserId(businessExp.getSenderId());
				    appLatestNews.setTypeId(23);//已发快件
				    appLatestNews.setSourceId(businessExp.getExpId());
				    appLatestNews.setTo(0);
				    appLatestNews.setEstateId(0);
				    appLatestNewsService.save_app(appLatestNews);

				    appLatestNews = new AppLatestNews();
				    appLatestNews.setUserId(businessExp.getSenderId());
				    appLatestNews.setTypeId(26);//快件列表
				    appLatestNews.setSourceId(businessExp.getExpId());
				    appLatestNews.setTo(0);
				    appLatestNews.setEstateId(0);
				    appLatestNewsService.save_app(appLatestNews);
			    }
			    
			    //保存成功
				json = "{\"success\":\"true\",\"message\":\"保存成功\"}";			
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessExp信息时发生错误：/business/businessExp/save", e);
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
	 * 保存预约发件对象
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(value="saveAppointment")
	public void saveAppointment(HttpServletRequest request, HttpServletResponse response, BusinessExpQuery query) {
		BusinessExp businessExp = new BusinessExp();
		String json = "";
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			boolean isUser = false;
			String cellphone = query.getSenderTel();
			AppUser appUser = appUserService.getAppUserByTel(cellphone);
			if(appUser != null) {
				isUser = true;
				businessExp.setSenderId(appUser.getUserId());
			}
		    businessExp.setSenderName(query.getSenderName());
		    //businessExp.setExpCode(query.getExpCode());
		    businessExp.setSenderTel(query.getSenderTel());
		    businessExp.setPhoneType(query.getPhoneType());
		    //businessExp.setReceiverName(query.getReceiverName());
		    //businessExp.setReceiverTel(query.getReceiverTel());
		    //businessExp.setReceiveTime(new Timestamp(System.currentTimeMillis()));
		    //businessExp.setReceiverAddr(query.getReceiverAddr());
		    businessExp.setSendTime(new Timestamp(System.currentTimeMillis()));
		    //businessExp.setExpContent(query.getExpContent());
		    businessExp.setExpState(0);//预约上门
		    //businessExp.setCheckInTime(new Timestamp(System.currentTimeMillis()));//入库时间
		    businessExp.setSenderAddr(query.getSenderAddr());
		    businessExp.setExpType(1);//发件
            //查询当前所属驿站信息            
            BusinessStation businessStation = new BusinessStation();
            ManageEstate manageEstate = manageEstateService.findById(shiroUser.getCurEstateId());
            businessStation = businessStationService.findById(manageEstate.getStationId());
            businessExp.setStationId(businessStation.getStationId());
            businessExp.setStation(businessStation.getStaName());
            businessExp.setEstateId(shiroUser.getCurEstateId());
            /*ManageExpress manageExpress = manageExpressService.findById(query.getExpCompanyID());
		    businessExp.setExpCompanyID(manageExpress.getExpressId());
		    businessExp.setExpCompany(manageExpress.getExpressComppay());
		    businessExp.setLogo(manageExpress.getExpressIcon());*/
            ManageExpressAll manageExpressAll = manageExpressAllService.findById(query.getExpCompanyID());
		    businessExp.setExpCompanyID(manageExpressAll.getExpressId());
		    businessExp.setExpCompany(manageExpressAll.getExpressComppay());
		    businessExp.setLogo(manageExpressAll.getExpressIcon());
		    businessExp.setIsPay(0);
		    businessExp.setPayMount(Float.parseFloat("0"));
		    businessExp.setIsAgent(0);
		    businessExp.setAgentMount(Float.parseFloat("0"));
		    businessExp.setIsDistributed(0);
		    businessExp.setIsProblem(0);
		    //businessExp.setMemo(query.getMemo());
		    businessExp.setGetDate(query.getGetDate());
		    if(query.getAnyTime() != null) {
		    	if(query.getAnyTime().equals("0")) {
		    		businessExp.setIsAnytime(0);//默认任何时间
		    	}else{
		    		businessExp.setIsAnytime(1);
		    		businessExp.setGetTime(query.getAnyTime());
		    	}
		    }
		    //businessExp.setAppointType(query.getAppointType());
		    //businessExp.setAppointContent(query.getAppointContent());
		    //businessExp.setSignname(query.getSignname());
		    //businessExp.setSignTime(query.getSignTime());
		    //businessExp.setIsSelf(query.getIsSelf());
		    businessExp.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessExp.setModifyTime(new Timestamp(System.currentTimeMillis()));
		    businessExp.setEditor(shiroUser.getUserName());
            //todo:判断收件人手机号，如果非APP用户则给收件人发送短信，如果是APP用户则给收件人推送通知
            Map map = new HashMap();
            map.put("tel", query.getReceiverTel());
            List list = appUserService.findByMap(map);
            //if(list != null && list.size() > 0) {
                //APP用户
               // System.out.println("向APP用户推送通知！");
                //向用户快件表中插入数据
            //} else {
                //非APP用户
                //System.out.println("向非APP用户发送短信通知！");
            //}
            businessExpService.save(businessExp);
            
            if(businessExp.getExpId() > 0 && businessExp.getSenderTel().length() == 11) {
            	if(query.getFlag() == 1) {
					BusinessAddress businessAddress = new BusinessAddress();
					businessAddress.setMobile(businessExp.getSenderTel());
					businessAddress.setContacts(businessExp.getSenderName());
					businessAddress.setAddress(businessExp.getSenderAddr());
					businessAddressService.save(businessAddress);
            	} else {
            		Map paramMap = new HashMap();
            		paramMap.put("mobile", businessExp.getSenderTel());
            		paramMap.put("contacts", businessExp.getSenderName());
            		paramMap.put("address", businessExp.getSenderAddr());
            		
            		List<BusinessAddress> addrList = businessAddressService.findByMap(paramMap);
            		if(addrList.size() == 0 ) {
            			BusinessAddress businessAddress = new BusinessAddress();
    					businessAddress.setMobile(businessExp.getSenderTel());
    					businessAddress.setContacts(businessExp.getSenderName());
    					businessAddress.setAddress(businessExp.getSenderAddr());
    					businessAddressService.save(businessAddress);
            		}
            	}
			}
            
            //手机保存处理信息
            BusinessExpResolve businessExpResolve = new BusinessExpResolve();
            businessExpResolve.setExpId(businessExp.getExpId());
            businessExpResolve.setResolverId(shiroUser.getUserId());
            businessExpResolve.setResolverName(shiroUser.getUserName());
            businessExpResolve.setState(String.valueOf(businessExp.getExpState()));
            businessExpResolve.setType(0);
            businessExpResolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
            businessExpResolve.setResolveMemo("预约 "+businessExp.getGetDate()+" "+(businessExp.getIsAnytime() == 0? " 任何时间 ":businessExp.getGetTime())+" 服务驿站上门取件");
		    //businessExpBackresolve.setResolveMemo("预约 "+businessExp.getGetDate()+" "+(businessExp.getIsAnytime() == 0? "任何时间":businessExp.getGetTime())+" 服务驿站上门取件");
		    businessExpResolveService.save(businessExpResolve);
		    
		    //保存预约上门取件的处理
            BusinessExpBackresolve businessExpBackresolve = new BusinessExpBackresolve();
	        businessExpBackresolve.setExpId(businessExp.getExpId());
		    businessExpBackresolve.setResolverId(shiroUser.getUserId());
		    businessExpBackresolve.setResolverName(shiroUser.getUserName());
		    businessExpBackresolve.setState(String.valueOf(businessExp.getExpState()));
		    businessExpBackresolve.setType(0);
		    businessExpBackresolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
		    businessExpBackresolve.setResolveMemo("预约 "+businessExp.getGetDate()+" "+(businessExp.getIsAnytime() == 0? " 任何时间 ":businessExp.getGetTime())+" 服务驿站上门取件");
		    //businessExpBackresolve.setResolveMemo("预约 "+businessExp.getGetDate()+" "+(businessExp.getIsAnytime() == 0? "任何时间":businessExp.getGetTime())+" 服务驿站上门取件");
		    businessExpBackresolveService.save(businessExpBackresolve);
		    
		    String currTime = String.valueOf(businessExp.getModifyTime()).substring(0, 16);		    
		    businessExp.setBriefMessage(currTime+"\\r\\n预约 "+businessExp.getGetDate()+" "+(businessExp.getIsAnytime() == 0? " 任何时间 ":businessExp.getGetTime())+" 服务驿站上门取件");
		    businessExp.setLastMessage("服务驿站开始上门取件");
		    businessExpService.update(businessExp);
		    
		  //能够使用电话绑定的用户就能够收到消息
		    if(isUser) {
		      AppLatestNews appLatestNews = new AppLatestNews();
		      appLatestNews.setUserId(businessExp.getSenderId());
		      appLatestNews.setTypeId(21);//我的快件
		      appLatestNews.setSourceId(businessExp.getExpId());
		      appLatestNews.setTo(0);
		      appLatestNews.setEstateId(0);
		      appLatestNewsService.save_app(appLatestNews);

		      appLatestNews = new AppLatestNews();
		      appLatestNews.setUserId(businessExp.getSenderId());
		      appLatestNews.setTypeId(22);//代发快件
		      appLatestNews.setSourceId(businessExp.getExpId());
		      appLatestNews.setTo(0);
		      appLatestNews.setEstateId(0);
		      appLatestNewsService.save_app(appLatestNews);

		      appLatestNews = new AppLatestNews();
		      appLatestNews.setUserId(businessExp.getSenderId());
		      appLatestNews.setTypeId(26);//快件列表
		      appLatestNews.setSourceId(businessExp.getExpId());
		      appLatestNews.setTo(0);
		      appLatestNews.setEstateId(0);
		      appLatestNewsService.save_app(appLatestNews);
		    }
		    
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessExp信息时发生错误：/business/businessExp/save", e);
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
	public ModelAndView modify(BusinessExpQuery query) {	
		BusinessExp businessExp=new BusinessExp();
		
		try{
			businessExp = businessExpService.findById(query.getExpId());
		}catch(Exception e){
			GSLogger.error("进入businessExp修改页时发生错误：/business/businessExp/modify", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/business/businessExp/modify");
		mav.addObject("businessExp", businessExp);
		return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessExp businessExp) {
		String json = "";
		try{
	        Timestamp  ts=new Timestamp(new Date().getTime());
            businessExp.setModifyTime(ts);
            businessExp.setEditor(getUser().getUserName());
			businessExpService.update(businessExp);
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessExp信息时发生错误：/business/businessExp/update", e);
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
						businessExpService.delete(new Integer(ids[i]));
					}
				}else{
					businessExpService.delete(new Integer(id));
				}
			}
			
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessExp时发生错误：/business/businessExp/delete", e);
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
	 * 通过验证码获取快递信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findExpByCode")
	public void findExpByCode(BusinessExpQuery query, HttpServletResponse response) {
		String json = "";
		try {
			query.setIsSigned(0);
			query.setCode(query.getCode());
			query.setExpType(0);
			List expList = businessExpService.findByExample(query);
			if(expList != null && expList.size() > 0) {
				BusinessExp businessExp = (BusinessExp) expList.get(0);
				json = "{\"success\":\"true\",\"message\":\"查询成功\",\"expId\":\""+businessExp.getExpId()+"\",\"expCompany\":\""+businessExp.getExpCompany()+"\",\"receiverName\":\""+businessExp.getReceiverName()+"\",\"receiverTel\":\""+businessExp.getReceiverTel()+"\"}";
			}else{
				json = "{\"success\":\"false\",\"message\":\"无此快件\"}";
			}
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"查询失败\"}";
			GSLogger.error("删除BusinessExp时发生错误：/business/businessExp/findExpByCode", e);
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
	
	/**
	 * 快递签收处理 修改签收状态并向app端发布消息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="signExp")
	public void signExp(BusinessExpQuery query, HttpServletResponse response) {
		String json = "";
		try {
			BusinessExp businessExp = businessExpService.findById(query.getExpId());
			if(businessExp.getIsProblem() == 1) {//如果是问题件
				businessExp.setIsProblem(0);//不是问题件
			}
			businessExp.setExpState(6);//已签收
			businessExp.setIsSigned(1);
			businessExp.setSignTime(new Timestamp(System.currentTimeMillis()));
			businessExp.setSignname(businessExp.getReceiverName());
			businessExp.setIsSelf(0);
			businessExp.setEditor(getUser().getUserName());
	        businessExp.setModifyTime(new Timestamp(System.currentTimeMillis()));
			businessExpService.update(businessExp);
			
			//保存处理
	        BusinessExpResolve businessExpResolve = new BusinessExpResolve();
	        businessExpResolve.setExpId(query.getExpId());
	        ShiroUser shiroUser = CommonUtils.getUser();
	        businessExpResolve.setResolverId(shiroUser.getUserId());
	        businessExpResolve.setResolverName(shiroUser.getUserName());
	        businessExpResolve.setState(String.valueOf(businessExp.getExpState()));
	        businessExpResolve.setType(0);
	        businessExpResolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
		    BusinessUser businessUser = businessUserService.findById(shiroUser.getUserId());
		    String picker = "";
		    	if(businessExp.getIsSelf() == null || businessExp.getIsSelf() == 0) {//代收
		    		picker = "代收";
		    	}else{//本人
		    		picker = "本人";
		    	}
		    	businessExpResolve.setResolveMemo("快件已签收\\r\\n签收人("+picker+")："+query.getSignname()+"\\r\\n办理人："+shiroUser.getUserName()+"\\r\\n联系方式："+businessUser.getUserTel());
		    businessExpResolveService.save(businessExpResolve);
		    
		    BusinessExpBackresolve businessExpBackresolve = new BusinessExpBackresolve();
	        businessExpBackresolve.setExpId(query.getExpId());
		    businessExpBackresolve.setResolverId(shiroUser.getUserId());
		    businessExpBackresolve.setResolverName(shiroUser.getUserName());
		    businessExpBackresolve.setState(String.valueOf(businessExp.getExpState()));
		    businessExpBackresolve.setType(0);
		    businessExpBackresolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
		    picker = "";
		    	if(businessExp.getIsSelf() == null || businessExp.getIsSelf() == 0) {//代收
		    		picker = "代收";
		    	}else{//本人
		    		picker = "本人";
		    	}
		    businessExpBackresolve.setResolveMemo("快件已签收\\r\\n签收人("+picker+")："+query.getSignname()+"\\r\\n办理人："+shiroUser.getUserName()+"\\r\\n联系方式："+businessUser.getUserTel());
		    businessExpBackresolveService.save(businessExpBackresolve);
		    
		    String currTime = String.valueOf(businessExp.getModifyTime()).substring(0, 16);
		    businessExp.setBriefMessage(currTime+"\\r\\n运单号:"+businessExp.getExpCode()+"\\r\\n快件已签收");
		    businessExp.setLastMessage("快件已签收");
		    businessExpService.update(businessExp);
			
		    //能够使用电话绑定的用户就能够收到消息
		    if(businessExp.getReceiverId() != null && businessExp.getReceiverId() != 0) {
		    	AppLatestNews appLatestNews = new AppLatestNews();
		        appLatestNews.setUserId(businessExp.getReceiverId());
		        appLatestNews.setTypeId(21);//我的快件
		        appLatestNews.setSourceId(businessExp.getExpId());
		        appLatestNews.setTo(0);
		        appLatestNews.setEstateId(0);
		        appLatestNewsService.save_app(appLatestNews);

		        appLatestNews = new AppLatestNews();
		        appLatestNews.setUserId(businessExp.getReceiverId());
		        appLatestNews.setTypeId(25);//已收快件
		        appLatestNews.setSourceId(businessExp.getExpId());
		        appLatestNews.setTo(0);
		        appLatestNews.setEstateId(0);
		        appLatestNewsService.save_app(appLatestNews);

		        appLatestNews = new AppLatestNews();
		        appLatestNews.setUserId(businessExp.getReceiverId());
		        appLatestNews.setTypeId(26);//快件列表
		        appLatestNews.setSourceId(businessExp.getExpId());
		        appLatestNews.setTo(0);
		        appLatestNews.setEstateId(0);
		        appLatestNewsService.save_app(appLatestNews);
		    }
		    
			json = "{\"success\":\"true\",\"message\":\"签收成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"签收失败\"}";
			GSLogger.error("删除BusinessExp时发生错误：/business/businessExp/signExp", e);
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
	
	 /**
     * 保存发件录入状态 0 上门取件 -> 2 已发送
     * @param query
     * @return
     */
    @RequestMapping(value="saveSendResolve")
    public ModelAndView saveSendResolve(BusinessExpQuery query) {
        BusinessExp businessExp = businessExpService.findById(query.getExpId());
        businessExp.setExpState(2);//已发送状态
        businessExp.setEditor(getUser().getUserName());
        businessExp.setModifyTime(new Timestamp(System.currentTimeMillis()));
        businessExpService.update(businessExp);
        //保存处理
        BusinessExpResolve businessExpResolve = new BusinessExpResolve();
        businessExpResolve.setExpId(query.getExpId());
        ShiroUser shiroUser = CommonUtils.getUser();
        businessExpResolve.setResolverId(shiroUser.getUserId());
        businessExpResolve.setResolverName(shiroUser.getUserName());
        businessExpResolve.setState(String.valueOf(businessExp.getExpState()));
        businessExpResolve.setType(0);
        businessExpResolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
	    BusinessUser businessUser = businessUserService.findById(shiroUser.getUserId());
	    businessExpResolve.setResolveMemo("快件已从服务驿站发出\\r\\n办理人："+shiroUser.getUserName()+"\\r\\n联系方式："+businessUser.getUserTel()+"\\r\\n运费金额:￥"+businessExp.getPayMount());
	    businessExpResolveService.save(businessExpResolve);
	    
	    BusinessExpBackresolve businessExpBackresolve = new BusinessExpBackresolve();
        businessExpBackresolve.setExpId(query.getExpId());
	    businessExpBackresolve.setResolverId(shiroUser.getUserId());
	    businessExpBackresolve.setResolverName(shiroUser.getUserName());
	    businessExpBackresolve.setState(String.valueOf(businessExp.getExpState()));
	    businessExpBackresolve.setType(0);
	    businessExpBackresolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
	    businessExpBackresolve.setResolveMemo("快件已从服务驿站发出\\r\\n办理人："+shiroUser.getUserName()+"\\r\\n联系方式："+businessUser.getUserTel()+"\\r\\n运费金额:￥"+businessExp.getPayMount());
	    businessExpBackresolveService.save(businessExpBackresolve);
	    
	    String currTime =  String.valueOf(businessExp.getModifyTime()).substring(0, 16);		    
	    businessExp.setBriefMessage(currTime+"\\r\\n运单号:"+businessExp.getExpCode()+"\\r\\n快件已从服务驿站发出");
	    businessExp.setLastMessage("快件已从服务驿站发出");
	    businessExpService.update(businessExp);
	    
	    //能够使用电话绑定的用户就能够收到消息
	    if(businessExp.getSenderId() != null && businessExp.getSenderId() != 0) {
	    	AppLatestNews appLatestNews = new AppLatestNews();
	        appLatestNews.setUserId(businessExp.getSenderId());
	        appLatestNews.setTypeId(21);//我的快件
	        appLatestNews.setSourceId(businessExp.getExpId());
	        appLatestNews.setTo(0);
	        appLatestNews.setEstateId(0);
	        appLatestNewsService.save_app(appLatestNews);

	        appLatestNews = new AppLatestNews();
	        appLatestNews.setUserId(businessExp.getSenderId());
	        appLatestNews.setTypeId(23);//已发快件
	        appLatestNews.setSourceId(businessExp.getExpId());
	        appLatestNews.setTo(0);
	        appLatestNews.setEstateId(0);
	        appLatestNewsService.save_app(appLatestNews);

	        appLatestNews = new AppLatestNews();
	        appLatestNews.setUserId(businessExp.getSenderId());
	        appLatestNews.setTypeId(26);//快件列表
	        appLatestNews.setSourceId(businessExp.getExpId());
	        appLatestNews.setTo(0);
	        appLatestNews.setEstateId(0);
	        appLatestNewsService.save_app(appLatestNews);
	    }
	    
	    ModelAndView mav = new ModelAndView("redirect:/business/businessExp/getDetails.do?expId="+businessExp.getExpId()+"&expState="+businessExp.getExpState());
        return mav;
    }
    
    /**
     * 保存开始取件状态 0 上门取件 ->  1 已上门取件
     * @param query
     * @return
     */
    @RequestMapping(value="saveGetResolve")
	public void saveGetResolve(BusinessExpQuery query, HttpServletResponse response) {
		String json = "";
		try {
			AppLatestNewsQuery newsQuery = new AppLatestNewsQuery();
        	newsQuery.setTypeId(38);//快递
        	newsQuery.setSourceId(query.getExpId());
        	newsQuery.setTo(1);//居民向后台发送
        	appLatestNewsService.deleteByCondition(newsQuery);
			BusinessExp businessExp = businessExpService.findById(query.getExpId());
	        businessExp.setExpState(1);//已上门取件
	        businessExp.setEditor(getUser().getUserName());
	        businessExp.setModifyTime(new Timestamp(System.currentTimeMillis()));
	        businessExpService.update(businessExp);
	        //保存处理
	        BusinessExpResolve businessExpResolve = new BusinessExpResolve();
	        businessExpResolve.setExpId(query.getExpId());
	        ShiroUser shiroUser = CommonUtils.getUser();
	        businessExpResolve.setResolverId(shiroUser.getUserId());
	        businessExpResolve.setResolverName(shiroUser.getUserName());
	        businessExpResolve.setState(String.valueOf(businessExp.getExpState()));
	        businessExpResolve.setType(0);
	        businessExpResolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
		    BusinessUser businessUser = businessUserService.findById(shiroUser.getUserId());
		    businessExpResolve.setResolveMemo(businessExp.getStation()+" 开始取件\\r\\n办理人："+shiroUser.getUserName()+"\\r\\n联系方式："+businessUser.getUserTel());
		    businessExpResolveService.save(businessExpResolve);
		    
		    BusinessExpBackresolve businessExpBackresolve = new BusinessExpBackresolve();
	        businessExpBackresolve.setExpId(query.getExpId());
		    businessExpBackresolve.setResolverId(shiroUser.getUserId());
		    businessExpBackresolve.setResolverName(shiroUser.getUserName());
		    businessExpBackresolve.setState(String.valueOf(businessExp.getExpState()));
		    businessExpBackresolve.setType(0);
		    businessExpBackresolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
		    businessExpBackresolve.setResolveMemo(businessExp.getStation()+" 开始取件\\r\\n办理人："+shiroUser.getUserName()+"\\r\\n联系方式："+businessUser.getUserTel());
		    businessExpBackresolveService.save(businessExpBackresolve);
		    
		    String currTime = String.valueOf(businessExp.getModifyTime()).substring(0, 16);		    
		    businessExp.setBriefMessage(currTime+"\\r\\n运单号:"+businessExp.getExpCode()+"\\r\\n服务驿站 开始上门取件");
		    businessExp.setLastMessage("服务驿站 开始上门取件");
		    businessExpService.update(businessExp);
		    
		    //能够使用电话绑定的用户就能够收到消息
		    if(businessExp.getSenderId() != null && businessExp.getSenderId() != 0) {
		    	AppLatestNews appLatestNews = new AppLatestNews();
		        appLatestNews.setUserId(businessExp.getSenderId());
		        appLatestNews.setTypeId(21);//我的快件
		        appLatestNews.setSourceId(businessExp.getExpId());
		        appLatestNews.setTo(0);
		        appLatestNews.setEstateId(0);
		        appLatestNewsService.save_app(appLatestNews);

		        appLatestNews = new AppLatestNews();
		        appLatestNews.setUserId(businessExp.getSenderId());
		        appLatestNews.setTypeId(22);//代发快件
		        appLatestNews.setSourceId(businessExp.getExpId());
		        appLatestNews.setTo(0);
		        appLatestNews.setEstateId(0);
		        appLatestNewsService.save_app(appLatestNews);

		        appLatestNews = new AppLatestNews();
		        appLatestNews.setUserId(businessExp.getSenderId());
		        appLatestNews.setTypeId(26);//快件列表
		        appLatestNews.setSourceId(businessExp.getExpId());
		        appLatestNews.setTo(0);
		        appLatestNews.setEstateId(0);
		        appLatestNewsService.save_app(appLatestNews);
		    }
		    
            //向APP用户推送通知
		    if(businessExp.getSenderId() != null && businessExp.getSenderId() != 0) {
		    	AppUser appUser = appUserService.findById(businessExp.getSenderId());
		    	Map paramMapTemp = new HashMap();
		    	paramMapTemp.put("userId", appUser.getUserId());
				List configList = appUserConfigService.findByMap(paramMapTemp);
				AppUserConfig appUserConfig = null;
				if(configList != null) {
					appUserConfig = (AppUserConfig) configList.get(0);
				}	
            	if(appUserConfig != null 
						&& appUserConfig.getExpressSwitch() == 0 
						&& appUser.getBaiduId() != null 
						&& !"".equals(appUser.getBaiduId()) 
						&& appUser.getChannelId() != null 
						&& !"".equals(appUser.getChannelId())) {
            		String title = "OK家";
					String description = "【"+businessExp.getStation()+"】尊贵的主人，我是您要发出的快件，现在驿站服务人员“"+shiroUser.getUserName()+"”已经出发来家里接我了！";
					Map paramMap = new HashMap();
					paramMap.put("messageType", 5);
					paramMap.put("ID", businessExp.getExpId());
					paramMap.put("expState", businessExp.getExpState());
					paramMap.put("isVideo", businessExp.getIsVideo());
					
					Integer success = AppPushNotificationUtil.pushNotification(
							title, 
							description, 
							appUser.getDeviceType(),
							Long.valueOf(appUser.getChannelId()).longValue(), 
							appUser.getBaiduId(),
							paramMap
							);
					//记录推送日志
					AppPushLog appPushLog = new AppPushLog();
					appPushLog.setUserId(appUser.getUserId());
				    appPushLog.setUserName(appUser.getRealname());
				    appPushLog.setBaiduId(appUser.getBaiduId());
				    appPushLog.setChannelId(appUser.getChannelId());
				    appPushLog.setTitle(title);
				    appPushLog.setDescription(description);
				    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
				    appPushLog.setSendState(success);
				    appPushLog.setSenderId(shiroUser.getUserId());
				    appPushLog.setSenderName(shiroUser.getUserName());
					appPushLogService.save(appPushLog);
				}
            } else {
                //非APP用户
                //System.out.println("向非APP用户发送短信通知！");
            }
		    
			json = "{\"success\":\"true\",\"message\":\"处理成功\",\"resolveTime\":\""+businessExpBackresolve.getResolveTime()+"\",\"resolveMemo\":\""+businessExpBackresolve.getResolveMemo()+"\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"处理失败\"}";
			GSLogger.error("删除BusinessExp时发生错误：/business/businessExp/saveGetResolve", e);
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
    
    /**
     * 保存自提状态 3 已入库 ->  4 自提
     * @param query
     * @return
     */
    @RequestMapping(value="savePickResolve")
	public void savePickResolve(BusinessExpQuery query, HttpServletResponse response) {
		String json = "";
		try {
			BusinessExp businessExp = businessExpService.findById(query.getExpId());
	        businessExp.setExpState(4);//自提
	        businessExp.setIsSigned(0);//未自提
	        businessExp.setEditor(getUser().getUserName());
	        businessExp.setModifyTime(new Timestamp(System.currentTimeMillis()));
	        businessExpService.update(businessExp);
	        //保存处理
	        BusinessExpResolve businessExpResolve = new BusinessExpResolve();
	        businessExpResolve.setExpId(query.getExpId());
	        ShiroUser shiroUser = CommonUtils.getUser();
	        businessExpResolve.setResolverId(shiroUser.getUserId());
	        businessExpResolve.setResolverName(shiroUser.getUserName());
	        businessExpResolve.setState(String.valueOf(businessExp.getExpState()));
	        businessExpResolve.setType(0);
	        businessExpResolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
		    BusinessUser businessUser = businessUserService.findById(shiroUser.getUserId());
		    businessExpResolve.setResolveMemo(businessExp.getReceiverName()+"\\r\\n"+businessExp.getReceiverTel()+"\\r\\n去服务驿站上门自提");
		    businessExpResolveService.save(businessExpResolve);
		    
		    BusinessExpBackresolve businessExpBackresolve = new BusinessExpBackresolve();
	        businessExpBackresolve.setExpId(query.getExpId());
		    businessExpBackresolve.setResolverId(shiroUser.getUserId());
		    businessExpBackresolve.setResolverName(shiroUser.getUserName());
		    businessExpBackresolve.setState(String.valueOf(businessExp.getExpState()));
		    businessExpBackresolve.setType(0);
		    businessExpBackresolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
		    businessExpBackresolve.setResolveMemo(businessExp.getReceiverName()+"\\r\\n"+businessExp.getReceiverTel()+"\\r\\n去服务驿站上门自提");
		    businessExpBackresolveService.save(businessExpBackresolve);
		    
		    String currTime = String.valueOf(businessExp.getModifyTime()).substring(0, 16);
		    businessExp.setBriefMessage(currTime+"\\r\\n运单号:"+businessExp.getExpCode()+"\\r\\n去服务驿站上门自提");
		    businessExp.setLastMessage("预约 去服务驿站上门自提");
		    businessExpService.update(businessExp);
		    
		    //能够使用电话绑定的用户就能够收到消息
		    if(businessExp.getReceiverId() != null && businessExp.getReceiverId() != 0) {
		    	AppLatestNews appLatestNews = new AppLatestNews();
		        appLatestNews.setUserId(businessExp.getReceiverId());
		        appLatestNews.setTypeId(21);//我的快件
		        appLatestNews.setSourceId(businessExp.getExpId());
		        appLatestNews.setTo(0);
		        appLatestNews.setEstateId(0);
		        appLatestNewsService.save_app(appLatestNews);

		        appLatestNews = new AppLatestNews();
		        appLatestNews.setUserId(businessExp.getReceiverId());
		        appLatestNews.setTypeId(24);//未收快件
		        appLatestNews.setSourceId(businessExp.getExpId());
		        appLatestNews.setTo(0);
		        appLatestNews.setEstateId(0);
		        appLatestNewsService.save_app(appLatestNews);

		        appLatestNews = new AppLatestNews();
		        appLatestNews.setUserId(businessExp.getReceiverId());
		        appLatestNews.setTypeId(26);//快件列表
		        appLatestNews.setSourceId(businessExp.getExpId());
		        appLatestNews.setTo(0);
		        appLatestNews.setEstateId(0);
		        appLatestNewsService.save_app(appLatestNews);
		    }
		    
			json = "{\"success\":\"true\",\"message\":\"处理成功\",\"resolveTime\":\""+businessExpBackresolve.getResolveTime()+"\",\"resolveMemo\":\""+businessExpBackresolve.getResolveMemo()+"\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"处理失败\"}";
			GSLogger.error("删除BusinessExp时发生错误：/business/businessExp/savePickResolve", e);
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
    
    /**
     * 保存送货上门状态 3 已入库 ->  5 送货上门
     * @param query
     * @return
     */
    @RequestMapping(value="saveSendHomeResolve")
	public void saveSendHomeResolve(BusinessExpQuery query, HttpServletResponse response) {
		String json = "";
		try {
			BusinessExp businessExp = businessExpService.findById(query.getExpId());
	        businessExp.setExpState(5);//送货上门
			//businessExp.setExpState(1);//送货上门
	        businessExp.setEditor(getUser().getUserName());
	        businessExp.setModifyTime(new Timestamp(System.currentTimeMillis()));
	        businessExpService.update(businessExp);
	        //保存处理
	        BusinessExpResolve businessExpResolve = new BusinessExpResolve();
	        businessExpResolve.setExpId(query.getExpId());
	        ShiroUser shiroUser = CommonUtils.getUser();
	        businessExpResolve.setResolverId(shiroUser.getUserId());
	        businessExpResolve.setResolverName(shiroUser.getUserName());
	        businessExpResolve.setState(String.valueOf(businessExp.getExpState()));
	        businessExpResolve.setType(0);
	        businessExpResolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
		    BusinessUser businessUser = businessUserService.findById(shiroUser.getUserId());
		    businessExpResolve.setResolveMemo(businessExp.getReceiverName()+" "+businessExp.getReceiverTel()+"\\r\\n"+businessExp.getReceiverAddr()+"\\r\\n预约 服务驿站送货上门");
		    businessExpResolveService.save(businessExpResolve);
		    
		    BusinessExpBackresolve businessExpBackresolve = new BusinessExpBackresolve();
	        businessExpBackresolve.setExpId(query.getExpId());
		    businessExpBackresolve.setResolverId(shiroUser.getUserId());
		    businessExpBackresolve.setResolverName(shiroUser.getUserName());
		    businessExpBackresolve.setState(String.valueOf(businessExp.getExpState()));
		    businessExpBackresolve.setType(0);
		    businessExpBackresolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
		    businessExpBackresolve.setResolveMemo(businessExp.getReceiverName()+" "+businessExp.getReceiverTel()+"\\r\\n"+businessExp.getReceiverAddr()+"\\r\\n预约 服务驿站送货上门");
		    businessExpBackresolveService.save(businessExpBackresolve);
		    
		    String currTime = String.valueOf(businessExp.getModifyTime()).substring(0, 16);
		    String message = "";
		    if(businessExp.getIsVideo() == 1) {
		    	message = "语音预约";
		    }else{
		    	message = "预约 服务驿站送货上门";
		    }
		    businessExp.setBriefMessage(currTime+"\\r\\n运单号:"+businessExp.getExpCode()+"\\r\\n"+message);
		    businessExp.setLastMessage("预约 服务驿站送货上门");
		    businessExpService.update(businessExp);
		    
		    //能够使用电话绑定的用户就能够收到消息
		    if(businessExp.getReceiverId() != null && businessExp.getReceiverId() != 0) {
		    	AppLatestNews appLatestNews = new AppLatestNews();
		        appLatestNews.setUserId(businessExp.getReceiverId());
		        appLatestNews.setTypeId(21);//我的快件
		        appLatestNews.setSourceId(businessExp.getExpId());
		        appLatestNews.setTo(0);
		        appLatestNews.setEstateId(0);
		        appLatestNewsService.save_app(appLatestNews);

		        appLatestNews = new AppLatestNews();
		        appLatestNews.setUserId(businessExp.getReceiverId());
		        appLatestNews.setTypeId(24);//未收快件
		        appLatestNews.setSourceId(businessExp.getExpId());
		        appLatestNews.setTo(0);
		        appLatestNews.setEstateId(0);
		        appLatestNewsService.save_app(appLatestNews);

		        appLatestNews = new AppLatestNews();
		        appLatestNews.setUserId(businessExp.getReceiverId());
		        appLatestNews.setTypeId(26);//快件列表
		        appLatestNews.setSourceId(businessExp.getExpId());
		        appLatestNews.setTo(0);
		        appLatestNews.setEstateId(0);
		        appLatestNewsService.save_app(appLatestNews);
		    }
		    
			json = "{\"success\":\"true\",\"message\":\"处理成功\",\"resolveTime\":\""+businessExpBackresolve.getResolveTime()+"\",\"resolveMemo\":\""+businessExpBackresolve.getResolveMemo()+"\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"处理失败\"}";
			GSLogger.error("删除BusinessExp时发生错误：/business/businessExp/savePickResolve", e);
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
    
    /**
     * 保存已签收状态 3 签收 /5 送货上门 ->  6 已签收
     * @param query
     * @return
     */
    @RequestMapping(value="saveSignedResolve")
	public void saveSignedResolve(BusinessExpQuery query, HttpServletResponse response) {
		String json = "";
		try {
			AppLatestNewsQuery newsQuery = new AppLatestNewsQuery();
        	newsQuery.setTypeId(38);//快递
        	newsQuery.setSourceId(query.getExpId());
        	newsQuery.setTo(1);//居民向后台发送
        	appLatestNewsService.deleteByCondition(newsQuery);
			BusinessExp businessExp = businessExpService.findById(query.getExpId());
	        businessExp.setExpState(6);//已签收
	        businessExp.setIsSigned(1);//已签收
	        businessExp.setSignname(query.getSignname());
	        businessExp.setSignTime(new Timestamp(System.currentTimeMillis()));
	        businessExp.setReceiveTime(new Timestamp(System.currentTimeMillis()));
	        businessExp.setIsSelf(query.getIsSelf());
	        businessExp.setEditor(getUser().getUserName());
	        businessExp.setModifyTime(new Timestamp(System.currentTimeMillis()));
	        businessExpService.update(businessExp);
	        //保存处理
	        BusinessExpResolve businessExpResolve = new BusinessExpResolve();
	        businessExpResolve.setExpId(query.getExpId());
	        ShiroUser shiroUser = CommonUtils.getUser();
	        businessExpResolve.setResolverId(shiroUser.getUserId());
	        businessExpResolve.setResolverName(shiroUser.getUserName());
	        businessExpResolve.setState(String.valueOf(businessExp.getExpState()));
	        businessExpResolve.setType(0);
	        businessExpResolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
		    BusinessUser businessUser = businessUserService.findById(shiroUser.getUserId());
		    String picker = "";
		    	if(businessExp.getIsSelf() == 0) {//代收
		    		picker = "代收";
		    	}else{//本人
		    		picker = "本人";
		    	}
		    	businessExpResolve.setResolveMemo("快件已签收\\r\\n签收人("+picker+")："+query.getSignname()+"\\r\\n办理人："+shiroUser.getUserName()+"\\r\\n联系方式："+businessUser.getUserTel());
		    businessExpResolveService.save(businessExpResolve);
		    
		    BusinessExpBackresolve businessExpBackresolve = new BusinessExpBackresolve();
	        businessExpBackresolve.setExpId(query.getExpId());
		    businessExpBackresolve.setResolverId(shiroUser.getUserId());
		    businessExpBackresolve.setResolverName(shiroUser.getUserName());
		    businessExpBackresolve.setState(String.valueOf(businessExp.getExpState()));
		    businessExpBackresolve.setType(0);
		    businessExpBackresolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
		    picker = "";
		    	if(businessExp.getIsSelf() == null || businessExp.getIsSelf() == 0) {//代收
		    		picker = "代收";
		    	}else{//本人
		    		picker = "本人";
		    	}
		    businessExpBackresolve.setResolveMemo("快件已签收\\r\\n签收人("+picker+")："+query.getSignname()+"\\r\\n办理人："+shiroUser.getUserName()+"\\r\\n联系方式："+businessUser.getUserTel());
		    businessExpBackresolveService.save(businessExpBackresolve);
		    
		    String currTime = String.valueOf(businessExp.getModifyTime()).substring(0, 16);
		    businessExp.setBriefMessage(currTime+"\\r\\n运单号:"+businessExp.getExpCode()+"\\r\\n快件已签收");
		    businessExp.setLastMessage("快件已签收");
		    businessExpService.update(businessExp);
		    
		    //能够使用电话绑定的用户就能够收到消息
		    if(businessExp.getReceiverId() != null && businessExp.getReceiverId() != 0) {
		    	AppLatestNews appLatestNews = new AppLatestNews();
		        appLatestNews.setUserId(businessExp.getReceiverId());
		        appLatestNews.setTypeId(21);//我的快件
		        appLatestNews.setSourceId(businessExp.getExpId());
		        appLatestNews.setTo(0);
		        appLatestNews.setEstateId(0);
		        appLatestNewsService.save_app(appLatestNews);

		        appLatestNews = new AppLatestNews();
		        appLatestNews.setUserId(businessExp.getReceiverId());
		        appLatestNews.setTypeId(25);//已收快件
		        appLatestNews.setSourceId(businessExp.getExpId());
		        appLatestNews.setTo(0);
		        appLatestNews.setEstateId(0);
		        appLatestNewsService.save_app(appLatestNews);

		        appLatestNews = new AppLatestNews();
		        appLatestNews.setUserId(businessExp.getReceiverId());
		        appLatestNews.setTypeId(26);//快件列表
		        appLatestNews.setSourceId(businessExp.getExpId());
		        appLatestNews.setTo(0);
		        appLatestNews.setEstateId(0);
		        appLatestNewsService.save_app(appLatestNews);
		    }
		    
			json = "{\"success\":\"true\",\"message\":\"处理成功\",\"resolveTime\":\""+businessExpBackresolve.getResolveTime()+"\",\"resolveMemo\":\""+businessExpBackresolve.getResolveMemo()+"\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"处理失败\"}";
			GSLogger.error("删除BusinessExp时发生错误：/business/businessExp/savePickResolve", e);
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
    
    /**
	 * 开始配送先向APP端推送信息 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="startDistribution")
	public void startDistribution(BusinessExpQuery query, HttpServletResponse response) {
		String json = "";
		try {
			AppLatestNewsQuery newsQuery = new AppLatestNewsQuery();
        	newsQuery.setTypeId(38);//快递
        	newsQuery.setSourceId(query.getExpId());
        	newsQuery.setTo(1);//居民向后台发送
        	appLatestNewsService.deleteByCondition(newsQuery);
			BusinessExp businessExp = businessExpService.findById(query.getExpId());
	        businessExp.setExpState(1);//上门送件
	        businessExp.setEditor(getUser().getUserName());
	        businessExp.setModifyTime(new Timestamp(System.currentTimeMillis()));
	        businessExpService.update(businessExp);
	        //保存处理
			BusinessExpResolve businessExpResolve = new BusinessExpResolve();
			businessExpResolve.setExpId(query.getExpId());
	        ShiroUser shiroUser = CommonUtils.getUser();
	        businessExpResolve.setResolverId(shiroUser.getUserId());
	        businessExpResolve.setResolverName(shiroUser.getUserName());
	        businessExpResolve.setState(String.valueOf(businessExp.getExpState()));
	        businessExpResolve.setType(0);
	        businessExpResolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
		    BusinessUser businessUser = businessUserService.findById(shiroUser.getUserId());
		    businessExpResolve.setResolveMemo("服务驿站 开始上门送件\\r\\n配送人："+shiroUser.getUserName()+"\\r\\n联系方式："+businessUser.getUserTel());
		    businessExpResolveService.save(businessExpResolve);
		    
		    BusinessExpBackresolve businessExpBackresolve = new BusinessExpBackresolve();
	        businessExpBackresolve.setExpId(query.getExpId());
		    businessExpBackresolve.setResolverId(shiroUser.getUserId());
		    businessExpBackresolve.setResolverName(shiroUser.getUserName());
		    businessExpBackresolve.setState(String.valueOf(businessExp.getExpState()));
		    businessExpBackresolve.setType(0);
		    businessExpBackresolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
		    businessExpBackresolve.setResolveMemo("服务驿站 开始上门送件\\r\\n配送人："+shiroUser.getUserName()+"\\r\\n联系方式："+businessUser.getUserTel());
		    businessExpBackresolveService.save(businessExpBackresolve);
		    
	        businessExp.setIsDistributed(1);//已配送
	        //businessExp.setReturnMemo(query.getReturnMemo());
	        businessExp.setEditor(getUser().getUserName());
	        businessExp.setModifyTime(new Timestamp(System.currentTimeMillis()));
	        String currTime = String.valueOf(businessExp.getModifyTime()).substring(0, 16);
	        businessExp.setBriefMessage(currTime+"\\r\\n运单号："+businessExp.getExpCode()+"\\r\\n服务驿站 开始上门送件");
	        businessExp.setLastMessage("服务驿站 开始上门送件");
	        businessExpService.update(businessExp);
            //todo:调用APP消息推送接口
	        //向APP用户推送通知
		    if(businessExp.getReceiverId() != null && businessExp.getReceiverId() != 0) {
		    	AppUser appUser = appUserService.findById(businessExp.getReceiverId());
		    	Map paramMapTemp = new HashMap();
		    	paramMapTemp.put("userId", appUser.getUserId());
				List configList = appUserConfigService.findByMap(paramMapTemp);
				AppUserConfig appUserConfig = null;
				if(configList != null) {
					appUserConfig = (AppUserConfig) configList.get(0);
				}	
            	if(appUserConfig != null 
						&& appUserConfig.getExpressSwitch() == 0 
						&& appUser.getBaiduId() != null 
						&& !"".equals(appUser.getBaiduId()) 
						&& appUser.getChannelId() != null 
						&& !"".equals(appUser.getChannelId())) {
            		String title = "OK家";
					String description = "【"+businessExp.getStation()+"】尊贵的主人，我是您的快件。现在驿站服务人员“"+shiroUser.getUserName()+"”正背着我往您家狂奔，记得给我留门哦！";
					Map paramMap = new HashMap();
					paramMap.put("messageType", 4);
					paramMap.put("ID", businessExp.getExpId());
					paramMap.put("expState", businessExp.getExpState());
					
					Integer success = AppPushNotificationUtil.pushNotification(
							title, 
							description, 
							appUser.getDeviceType(),
							Long.valueOf(appUser.getChannelId()).longValue(), 
							appUser.getBaiduId(),
							paramMap
							);
					//记录推送日志
					AppPushLog appPushLog = new AppPushLog();
					appPushLog.setUserId(appUser.getUserId());
				    appPushLog.setUserName(appUser.getRealname());
				    appPushLog.setBaiduId(appUser.getBaiduId());
				    appPushLog.setChannelId(appUser.getChannelId());
				    appPushLog.setTitle(title);
				    appPushLog.setDescription(description);
				    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
				    appPushLog.setSendState(success);
				    appPushLog.setSenderId(shiroUser.getUserId());
				    appPushLog.setSenderName(shiroUser.getUserName());
					appPushLogService.save(appPushLog);
				}
            } else {
                //非APP用户
                //System.out.println("向非APP用户发送短信通知！");
            }
	        
	        //能够使用电话绑定的用户就能够收到消息
		    if(businessExp.getReceiverId() != null && businessExp.getReceiverId() != 0) {
		    	AppLatestNews appLatestNews = new AppLatestNews();
		        appLatestNews.setUserId(businessExp.getReceiverId());
		        appLatestNews.setTypeId(21);//我的快件
		        appLatestNews.setSourceId(businessExp.getExpId());
		        appLatestNews.setTo(0);
		        appLatestNews.setEstateId(0);
		        appLatestNewsService.save_app(appLatestNews);

		        appLatestNews = new AppLatestNews();
		        appLatestNews.setUserId(businessExp.getReceiverId());
		        appLatestNews.setTypeId(24);//未收快件
		        appLatestNews.setSourceId(businessExp.getExpId());
		        appLatestNews.setTo(0);
		        appLatestNews.setEstateId(0);
		        appLatestNewsService.save_app(appLatestNews);

		        appLatestNews = new AppLatestNews();
		        appLatestNews.setUserId(businessExp.getReceiverId());
		        appLatestNews.setTypeId(26);//快件列表
		        appLatestNews.setSourceId(businessExp.getExpId());
		        appLatestNews.setTo(0);
		        appLatestNews.setEstateId(0);
		        appLatestNewsService.save_app(appLatestNews);
		    }
		    
			json = "{\"success\":\"true\",\"message\":\"配送成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"配送失败\"}";
			GSLogger.error("删除BusinessExp时发生错误：/business/businessExp/startDistribution", e);
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
	
	/**
     * 保存退件状态 9 问题件 ->  7 已退件
     * @param query
     * @return
     */
    @RequestMapping(value="saveReturnResolve")
	public void saveReturnResolve(BusinessExpQuery query, HttpServletResponse response) {
		String json = "";
		try {
			BusinessExp businessExp = businessExpService.findById(query.getExpId());
			if(businessExp.getIsProblem() == 1) {//问题件
				businessExp.setIsProblem(0);//不是问题件了
			}
	        businessExp.setExpState(7);//已退件
	        businessExp.setReturnMemo(query.getReturnMemo());
	        businessExp.setEditor(getUser().getUserName());
	        businessExp.setModifyTime(new Timestamp(System.currentTimeMillis()));
	        businessExpService.update(businessExp);
	        //保存处理
	        BusinessExpResolve businessExpResolve = new BusinessExpResolve();
	        businessExpResolve.setExpId(query.getExpId());
	        ShiroUser shiroUser = CommonUtils.getUser();
	        businessExpResolve.setResolverId(shiroUser.getUserId());
	        businessExpResolve.setResolverName(shiroUser.getUserName());
	        businessExpResolve.setState(String.valueOf(businessExp.getExpState()));
	        businessExpResolve.setType(0);
	        businessExpResolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
		    BusinessUser businessUser = businessUserService.findById(shiroUser.getUserId());
		    businessExpResolve.setResolveMemo("快件已退还至快件公司\\r\\n办理人："+shiroUser.getUserName()+" "+businessUser.getUserTel()+"\\r\\n退件理由："+query.getReturnMemo());
		    businessExpResolveService.save(businessExpResolve);
		    
		    BusinessExpBackresolve businessExpBackresolve = new BusinessExpBackresolve();
	        businessExpBackresolve.setExpId(query.getExpId());
		    businessExpBackresolve.setResolverId(shiroUser.getUserId());
		    businessExpBackresolve.setResolverName(shiroUser.getUserName());
		    businessExpBackresolve.setState(String.valueOf(businessExp.getExpState()));
		    businessExpBackresolve.setType(0);
		    businessExpBackresolve.setResolveTime(new Timestamp(System.currentTimeMillis()));
		    businessExpBackresolve.setResolveMemo("快件已退还至快件公司\\r\\n办理人："+shiroUser.getUserName()+" "+businessUser.getUserTel()+"\\r\\n退件理由："+query.getReturnMemo());
		    businessExpBackresolveService.save(businessExpBackresolve);
		    
		    String currTime = String.valueOf(businessExp.getModifyTime()).substring(0, 16);
		    businessExp.setBriefMessage(currTime+"\\r\\n运单号:"+businessExp.getExpCode()+"\\r\\n快件已退还至快件公司");
		    businessExp.setLastMessage("快件已退还至快件公司");
		    businessExpService.update(businessExp);
		    		    
			json = "{\"success\":\"true\",\"message\":\"处理成功\",\"resolveTime\":\""+businessExpBackresolve.getResolveTime()+"\",\"resolveMemo\":\""+businessExpBackresolve.getResolveMemo()+"\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"处理失败\"}";
			GSLogger.error("保存退件状态时发生错误：/business/businessExp/saveReturnResolve", e);
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