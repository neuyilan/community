package com.community.app.module.controller;

import static com.community.framework.utils.CommonUtils.getCellValue;
import static com.community.framework.utils.CommonUtils.getJSONString;
import static com.community.framework.utils.CommonUtils.getLongTime;
import static com.community.framework.utils.CommonUtils.getMergedRegionValue;
import static com.community.framework.utils.CommonUtils.getUser;
import static com.community.framework.utils.CommonUtils.isMergedRegion;
import static com.community.framework.utils.CommonUtils.isMobileNO;
import static com.community.framework.utils.CommonUtils.print;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.AppFocusScope;
import com.community.app.module.bean.AppHomepage;
import com.community.app.module.bean.AppHomepageScope;
import com.community.app.module.bean.AppPushLog;
import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.BusinessActivity;
import com.community.app.module.bean.BusinessActivityCoupon;
import com.community.app.module.bean.BusinessActivityRegistrationInformation;
import com.community.app.module.bean.BusinessActivityRegistrationTimeslot;
import com.community.app.module.bean.BusinessActivityScope;
import com.community.app.module.bean.BusinessActivityVoteOptions;
import com.community.app.module.bean.BusinessCommunity;
import com.community.app.module.bean.BusinessFocus;
import com.community.app.module.bean.ManageEstate;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.common.ExportUtil;
import com.community.app.module.common.ModuleConst;
import com.community.app.module.push.AppPushNotificationUtil;
import com.community.app.module.service.AppFocusScopeService;
import com.community.app.module.service.AppHomepageScopeService;
import com.community.app.module.service.AppHomepageService;
import com.community.app.module.service.AppPushLogService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessActivityCommentService;
import com.community.app.module.service.BusinessActivityCouponService;
import com.community.app.module.service.BusinessActivityParticipateService;
import com.community.app.module.service.BusinessActivityRegistrationInformationService;
import com.community.app.module.service.BusinessActivityRegistrationTimeslotService;
import com.community.app.module.service.BusinessActivityScopeService;
import com.community.app.module.service.BusinessActivityService;
import com.community.app.module.service.BusinessActivityTypeService;
import com.community.app.module.service.BusinessActivityVoteInformationService;
import com.community.app.module.service.BusinessActivityVoteOptionsService;
import com.community.app.module.service.BusinessCommunityService;
import com.community.app.module.service.BusinessFocusService;
import com.community.app.module.service.ManageEstateService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityCommentQuery;
import com.community.app.module.vo.BusinessActivityParticipateQuery;
import com.community.app.module.vo.BusinessActivityQuery;
import com.community.app.module.vo.BusinessActivityRegistrationInformationQuery;
import com.community.app.module.vo.BusinessActivityRegistrationTimeslotQuery;
import com.community.app.module.vo.BusinessActivityVoteInformationQuery;
import com.community.app.module.vo.BusinessActivityVoteOptionsQuery;
import com.community.framework.utils.CommonUtils;

@Controller
@RequestMapping("/business/businessActivity")
public class BusinessActivityController {
	private static Logger GSLogger = LoggerFactory.getLogger(BusinessActivityController.class);
	@Autowired
	private BusinessActivityService businessActivityService;
    @Autowired
	private BusinessActivityTypeService businessActivityTypeService;
    @Autowired
    private ManageEstateService manageEstateService;
    @Autowired
    private BusinessActivityScopeService businessActivityScopeService;
    @Autowired
    private BusinessFocusService businessFocusService;
    @Autowired
    private AppHomepageService appHomepageService;
    @Autowired
    private BusinessActivityParticipateService businessActivityParticipateService;
    @Autowired
    private BusinessActivityCommentService businessActivityCommentService;
	@Autowired
	private AppHomepageScopeService appHomepageScopeService;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private AppPushLogService appPushLogService;
	@Autowired
	private AppFocusScopeService appFocusScopeService;
	@Autowired
	private BusinessActivityRegistrationTimeslotService businessActivityRegistrationTimeslotService;
	@Autowired
	private BusinessActivityRegistrationInformationService businessActivityRegistrationInformationService;
	@Autowired
	private BusinessActivityVoteOptionsService businessActivityVoteOptionsService;
	@Autowired
	private BusinessCommunityService businessCommunityService;
	@Autowired
	private BusinessActivityVoteInformationService businessActivityVoteInformationService;
	@Autowired
	private BusinessActivityCouponService businessActivityCouponService;
	
	/**
	 * 进入管理页
	 * @return
	 */
	@RequestMapping(value="list")
	public ModelAndView list(HttpServletRequest request, BusinessActivityQuery query) {
		BaseBean baseBean = new BaseBean();
		String stateStr = request.getParameter("stateStr");
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			if(ModuleConst.STATION_CODE.equals(shiroUser.getOrgType())
					|| ModuleConst.COMMUNITY_CODE.equals(shiroUser.getOrgType())) {//社区和驿站根据小区范围数据范围不同
				query.setCurUserId(shiroUser.getUserId());
			}
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setCurComId(shiroUser.getCurComId());
			}
			//运营不跟某个用户复杂范围相关，而是整个范围的活动数据
			Subject currentUser = SecurityUtils.getSubject();  
			if (currentUser.isPermitted("activity_publish")) {  //新增活动功能展示会影响分页
				query.setRows(11);
			} else {  
				query.setRows(12);
			}
			if(stateStr != null && !"".equals(stateStr)) {
				query.setStates(stateStr.split("_"));
			}
			query.setSort("editTime");
			query.setOrder("desc");
			baseBean = businessActivityService.findAllPage(query);
		}catch(Exception e){
			GSLogger.error("进入businessActivity管理页时发生错误：/business/businessActivity/list", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/activity/list");
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		return mav;
	}

	/**
	 * 列示或者查询所有数据
	 * @return
	 */
	@RequestMapping(value="getPageList")
	public void getPageList(BusinessActivityQuery query, HttpServletResponse response) {
		String json = "";
		StringBuilder result = new StringBuilder();
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			if(ModuleConst.STATION_CODE.equals(shiroUser.getOrgType())
					|| ModuleConst.COMMUNITY_CODE.equals(shiroUser.getOrgType())) {//社区和驿站根据小区范围数据范围不同
				query.setCurUserId(shiroUser.getUserId());
			}
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				query.setCurComId(shiroUser.getCurComId());
			}
			if(!("").equals(query.getOrderBy()) && query.getOrderBy() != null) {
				query.setSort(query.getOrderBy());
			}else{
				query.setSort("editTime");
			}
			Subject currentUser = SecurityUtils.getSubject();  
			if (currentUser.isPermitted("activity_publish")) {  //新增活动功能展示会影响分页
				query.setRows(11);
			} else {  
				query.setRows(12);
			}
			query.setOrder("desc");
			BaseBean baseBean = businessActivityService.findAllPage(query);
			result.append("{\"total\":").append(baseBean.getCount()).append(",");
			result.append("\"pageId\":").append(baseBean.getPager().getPageId()).append(",");
			result.append("\"pageCount\":").append(baseBean.getPager().getPageCount()).append(",")
			.append("\"rows\":[");
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessActivity businessActivity = (BusinessActivity) baseBean.getList().get(i);
				result.append("{")
			    .append("\"actId\":\"").append(businessActivity.getActId()).append("\"").append(",")
			    .append("\"typeId\":\"").append(businessActivity.getTypeId()).append("\"").append(",")
			    .append("\"actName\":\"").append(businessActivity.getActName().replaceAll("(\r?\n()+)", "").replace("\"", "\\\"")).append("\"").append(",")
			    .append("\"actContent\":\"").append(businessActivity.getActContent().replaceAll("(\r?\n()+)", "").replace("\"", "\\\"")).append("\"").append(",")
			    .append("\"typeName\":\"").append(businessActivity.getTypeName()).append("\"").append(",")
			    .append("\"actScope\":\"").append(businessActivity.getActScope()).append("\"").append(",")
			    .append("\"brief\":\"").append(businessActivity.getBrief().replaceAll("(\r?\n()+)", "").replace("\"", "\\\"")).append("\"").append(",")
			    .append("\"actPic\":\"").append(businessActivity.getActPic()).append("\"").append(",")
			    .append("\"actLink\":\"").append(businessActivity.getActLink()).append("\"").append(",")
			    .append("\"actManage\":\"").append(businessActivity.getActManage()).append("\"").append(",")
			    .append("\"userType\":\"").append(businessActivity.getUserType()).append("\"").append(",")
			    .append("\"publisherId\":\"").append(businessActivity.getPublisherId()).append("\"").append(",")
			    .append("\"publishDate\":\"").append(businessActivity.getPublishDate()).append("\"").append(",")
			    .append("\"publishTime\":\"").append(businessActivity.getPublishTime()).append("\"").append(",")
			    .append("\"startTime\":\"").append(businessActivity.getStartTime()).append("\"").append(",")
			    .append("\"endTime\":\"").append(businessActivity.getEndTime()).append("\"").append(",")
			    .append("\"rank\":\"").append(businessActivity.getRank()).append("\"").append(",")
			    .append("\"state\":\"").append(businessActivity.getState()).append("\"").append(",")
			    .append("\"auditorId\":\"").append(businessActivity.getAuditorId()).append("\"").append(",")
			    .append("\"auditorName\":\"").append(businessActivity.getAuditorName()).append("\"").append(",")
			    .append("\"auditTime\":\"").append(businessActivity.getAuditTime()).append("\"").append(",")
			    .append("\"visits\":\"").append(businessActivity.getVisits()).append("\"").append(",")
			    .append("\"comments\":\"").append(businessActivity.getComments()).append("\"").append(",")
			    .append("\"supports\":\"").append(businessActivity.getSupports()).append("\"").append(",")
			    .append("\"particpates\":\"").append(businessActivity.getParticpates()).append("\"").append(",")
			    .append("\"isComment\":\"").append(businessActivity.getIsComment()).append("\"").append(",")
			    .append("\"recommend\":\"").append(businessActivity.getRecommend()).append("\"").append(",")
			    .append("\"isPush\":\"").append(businessActivity.getIsPush()).append("\"").append(",")
			    .append("\"createTime\":\"").append(businessActivity.getCreateTime()).append("\"").append(",")
			    .append("\"editTime\":\"").append(businessActivity.getEditTime()).append("\"").append(",")
			    .append("\"isImportant\":\"").append(businessActivity.getIsImportant()).append("\"").append(",")
			    .append("\"editor\":\"").append(businessActivity.getEditor()).append("\"")
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
			GSLogger.error("显示businessActivity列表时发生错误：/business/businessActivity/list", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入新增页
	 * @return
	 */
	@RequestMapping(value="add")
	public ModelAndView add(BusinessActivityQuery query) {
        // List list = new ArrayList();
		try{
            //查询类型
            //list = businessActivityTypeService.findAll();
		}catch(Exception e){
			GSLogger.error("进入businessActivity新增页时发生错误：/business/businessActivity/add", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/activity/add");
        //mav.addObject("type", list);
		return mav;
	}
	
	/**
	 * 保存对象
	 * @param request
	 * @param businessActivity
	 * @return
	 */
	@RequestMapping(value="save")
	public void save(HttpServletRequest request, HttpServletResponse response, BusinessActivityQuery query) {
		BusinessActivity businessActivity = new BusinessActivity();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String json = "";
		try{
		    businessActivity.setTypeId(query.getTypeId());
	    	businessActivity.setTypeName(query.getTypeName());
		    businessActivity.setActName(query.getActName());
		    businessActivity.setActContent(query.getActContent());
		    businessActivity.setBrief(query.getBrief());
		    businessActivity.setActPic(query.getActPic());
		    businessActivity.setAppPic(query.getAppPic());
		    businessActivity.setUserType(query.getUserType());
		    businessActivity.setPublisherId(getUser().getUserId()); //发布人ID
		    businessActivity.setState(query.getState());
		    businessActivity.setVisits(0);
		    businessActivity.setComments(0);
		    businessActivity.setSupports(0);
		    businessActivity.setParticpates(0);
		    businessActivity.setIsComment(query.getIsComment());
		    businessActivity.setRecommend(query.getRecommend());
		    businessActivity.setIsPush(query.getIsPush());
		    businessActivity.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessActivity.setEditTime(new Timestamp(System.currentTimeMillis()));
		    // 活动结束时间
		    if(query.getEndTime() != null && !"".equals(query.getEditTime1()) && (query.getTypeId() == 2 || query.getTypeId() == 3)) {
		    	 businessActivity.setStartTime(sdf.format(new Date()));
				 businessActivity.setEndTime(query.getEndTime());
				 SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
				 SimpleDateFormat sfTime = new SimpleDateFormat("HH:mm");
				 Date date = sdf.parse(query.getEndTime());
				 Date dt = new Date(date.getTime()-1800000);
				 businessActivity.setPublishDate(sfDate.format(sfDate.parse(query.getEndTime())));
				 businessActivity.setPublishTime(sfTime.format(dt));
	        } else {
	        	businessActivity.setStartTime(query.getStartTime());
				 businessActivity.setEndTime(query.getEndTime());
	        }
		    businessActivity.setEditor(getUser().getUserName());
	        businessActivity.setIsImportant(0);
	        businessActivity.setActScope(query.getActScope());
	        businessActivity.setIsTimingPush(query.getIsTimingPush());
	        businessActivity.setTimingPushconTent(query.getTimingPushconTent());
	        if(query.getTimingPushTime1() != null && !"".equals(query.getTimingPushTime1())) {
				Date ts1= (Date) sdf.parse(query.getTimingPushTime1());
		        businessActivity.setTimingPushTime(new Timestamp(ts1.getTime()));
	        }
	        
	        if(query.getTypeId() == 1) {
	        	String planTime = query.getPlanTime();
			    String[] timeArr = planTime.split(" ");
			    businessActivity.setPublishDate(timeArr[0]);
			    businessActivity.setPublishTime(timeArr[1]);
			    businessActivity.setRank(query.getRank());
	        } else if(query.getTypeId() == 2) {
	        	String arr[] = request.getParameterValues("attributeValues");
		        if(arr.length > 0){
		        	String str = "";
		        	for(int i=0; i<arr.length; i++) {
		        		str+=arr[i]+",";
		        	}
		        	str = str.substring(0, str.length()-1);
		        	businessActivity.setAttributeValues(str);
		        }
	        	businessActivity.setTimes(query.getTimes());
	        } else if(query.getTypeId() == 3) {
	        	businessActivity.setVoteType(query.getVoteType());
	        	businessActivity.setVotes(query.getVotes());
	        } else if(query.getTypeId() == 4) {
	        	/*businessActivity.setPublishDate(query.getCouponEndDate());
			    businessActivity.setPublishTime("00:00");*/
	        	String planTime = query.getPlanTime();
			    String[] timeArr = planTime.split(" ");
			    businessActivity.setPublishDate(timeArr[0]);
			    businessActivity.setPublishTime(timeArr[1]);
	        	businessActivity.setCouponName(query.getCouponName());
	        	businessActivity.setCouponDesc(query.getCouponDesc());
	        	businessActivity.setCouponImg(query.getCouponImg());
	        	businessActivity.setCouponNum(query.getCouponNum());
	        	businessActivity.setCouponValid(query.getCouponStartDate()+"~"+query.getCouponEndDate());
	        	businessActivity.setReportExcel(query.getReportExcel());
	        }
	        // 活动状态为定时发布时 设置定时发布时间 
	        if(query.getState() == 6) {
	        	 if(query.getTimingPublicTime1() != null && !"".equals(query.getTimingPublicTime1())) {
	 				Date ts1= (Date) sdf.parse(query.getTimingPublicTime1());
	 		        businessActivity.setTimingPublicTime(new Timestamp(ts1.getTime()));
	 	        }
	        }
	        if(query.getState() == 1 || query.getState() == 0) {
	        	businessActivity.setPublisherId(getUser().getUserId());
	        }
            businessActivityService.save(businessActivity);
            
            if(query.getTypeId() == 2) {
            	if(request.getParameterValues("timeSlotName1") != null && request.getParameterValues("number") != null) {
    	            String timeSlotName[] = request.getParameterValues("timeSlotName1");
    	            String number[] = request.getParameterValues("number");
    	            for(int i=0; i<timeSlotName.length; i++) {
    	            	BusinessActivityRegistrationTimeslot businessActivityRegistrationTimeslot = new BusinessActivityRegistrationTimeslot();
    	            	businessActivityRegistrationTimeslot.setActId(businessActivity.getActId());
    	            	businessActivityRegistrationTimeslot.setTimeSlotName(timeSlotName[i]);
    	            	businessActivityRegistrationTimeslot.setNumber(Integer.parseInt(number[i]));
    	            	businessActivityRegistrationTimeslot.setCreateTime(new Timestamp(System.currentTimeMillis()));
    	            	businessActivityRegistrationTimeslot.setEditTime(new Timestamp(System.currentTimeMillis()));
    	            	businessActivityRegistrationTimeslot.setEditor("");
    	            	businessActivityRegistrationTimeslotService.save(businessActivityRegistrationTimeslot);
    	            }
            	}
            } else if(query.getTypeId() == 3) {
            	if(query.getVoteType() == 1) {
            		if(request.getParameterValues("content") != null) {
	    	            String content[] = request.getParameterValues("content");
	    	            for(int i=0; i<content.length; i++) {
	    	            	BusinessActivityVoteOptions businessActivityVoteOptions = new BusinessActivityVoteOptions();
	    	            	businessActivityVoteOptions.setActId(businessActivity.getActId());
	    	            	businessActivityVoteOptions.setContent(content[i]);
	    	            	businessActivityVoteOptions.setImage("");
	    	            	businessActivityVoteOptions.setCreateTime(new Timestamp(System.currentTimeMillis()));
	    	            	businessActivityVoteOptions.setEditTime(new Timestamp(System.currentTimeMillis()));
	    	            	businessActivityVoteOptions.setEditor("");
	    	            	businessActivityVoteOptionsService.save(businessActivityVoteOptions);
	    	            }
            		}
            	} else if(query.getVoteType() == 2) {
            		if(query.getImage()!= null) {
	    	            String image[] = query.getImage().substring(1).split("#");
	    	            for(int i=0; i<image.length; i++) {
	    	            	BusinessActivityVoteOptions businessActivityVoteOptions = new BusinessActivityVoteOptions();
	    	            	businessActivityVoteOptions.setActId(businessActivity.getActId());
	    	            	businessActivityVoteOptions.setContent("");
	    	            	businessActivityVoteOptions.setImage(image[i]);
	    	            	businessActivityVoteOptions.setCreateTime(new Timestamp(System.currentTimeMillis()));
	    	            	businessActivityVoteOptions.setEditTime(new Timestamp(System.currentTimeMillis()));
	    	            	businessActivityVoteOptions.setEditor("");
	    	            	businessActivityVoteOptionsService.save(businessActivityVoteOptions);
	    	            }
            		}
            	} else if(query.getVoteType() == 3) {
            		if(request.getParameterValues("content") != null && request.getParameterValues("image") != null) {
	    	            String content[] = request.getParameterValues("content");
	    	            String image[] = query.getImage().substring(1).split("#");
	    	            for(int i=0; i<content.length; i++) {
	    	            	BusinessActivityVoteOptions businessActivityVoteOptions = new BusinessActivityVoteOptions();
	    	            	businessActivityVoteOptions.setActId(businessActivity.getActId());
	    	            	businessActivityVoteOptions.setContent(content[i]);
	    	            	businessActivityVoteOptions.setImage(image[i]);
	    	            	businessActivityVoteOptions.setCreateTime(new Timestamp(System.currentTimeMillis()));
	    	            	businessActivityVoteOptions.setEditTime(new Timestamp(System.currentTimeMillis()));
	    	            	businessActivityVoteOptions.setEditor("");
	    	            	businessActivityVoteOptionsService.save(businessActivityVoteOptions);
	    	            }
            		}
            	}
            } else if(query.getTypeId() == 4) {
            	if(!"".equals(businessActivity.getReportExcel()) && businessActivity.getReportExcel() != null) {            
    	            try {
                        File file = new File(CommonUtils.LOCALEXCELPATH, businessActivity.getReportExcel());
                       
                        String path = file.getPath();
                        String[] columns = {"couponCode"};
                        
                        List<BusinessActivityCoupon> list = parse(path, 0, 1, 0, 1, columns);
                        for(int i=0;i<list.size();i++) {
            				BusinessActivityCoupon businessActivityCoupon = (BusinessActivityCoupon) list.get(i);
            				
            				businessActivityCoupon.setActId(businessActivity.getActId());
            				businessActivityCoupon.setCouponCode(businessActivityCoupon.getCouponCode());
            				businessActivityCoupon.setState(0);
            				businessActivityCoupon.setCreateTime(new Timestamp(System.currentTimeMillis()));
            				businessActivityCoupon.setEditTime(new Timestamp(System.currentTimeMillis()));
            				businessActivityCoupon.setEditor("");
            				businessActivityCoupon.setUserId(0);
            				businessActivityCouponService.save(businessActivityCoupon);
            			}
    	            } catch (Exception e) {
    	                e.printStackTrace();
    	            }
    	        }
            }
            //活动范围 ： 针对社区和驿站的小区
            String scopeString = query.getActScope();
            String[] estateArr = scopeString.split(",");
            String str = "";
            for(int i=0;i<estateArr.length;i++) {
            	String[] estate = estateArr[i].split(":");
            	BusinessActivityScope scope = new BusinessActivityScope();
            	scope.setActId(businessActivity.getActId());
            	scope.setCreateTime(new Timestamp(System.currentTimeMillis()));
            	scope.setEstateId(new Integer(estate[0]));
            	scope.setEstateName(estate[1]);
            	str += estate[1]+',';
            	businessActivityScopeService.save(scope);
            }
            str = str.substring(0, str.length()-1);
            businessActivity.setActScope(str);
            businessActivityService.update(businessActivity);
            
            if(query.getRecommend() != null && (query.getState()== 1  || query.getState() == 0)) {//推荐
            	if(query.getRecommend() == 0) {//推荐到首页焦点图
					BusinessFocus businessFocus = new BusinessFocus();
					businessFocus.setTitle(businessActivity.getActName());
					businessFocus.setContent(businessActivity.getActContent());
				    businessFocus.setState(2);   // 待审核
				    businessFocus.setPicUrl(businessActivity.getActPic());
				    businessFocus.setPageUrl("");
				    businessFocus.setSourceId(businessActivity.getActId());
				    businessFocus.setSourceType(1);	// 来源类型
				    businessFocus.setIshtml(0);  // 静态
				    businessFocus.setAuditInfo("");
				    businessFocus.setFocusScope(businessActivity.getActScope());  //展示范围
				    businessFocus.setVisits(0);
				    businessFocus.setSupports(0);
				    businessFocus.setSelectorId(getUser().getUserId());
				    businessFocus.setSelectorName(getUser().getUserName());
				    businessFocus.setSelectTime(new Timestamp(System.currentTimeMillis()));
					businessFocusService.save(businessFocus);
					
					AppFocusScope appFocusScope = new AppFocusScope();
					for(int i=0;i<estateArr.length;i++) {
		            	String[] estate = estateArr[i].split(":");
		            	appFocusScope.setFocusId(businessFocus.getFocusId());
		            	appFocusScope.setEstateId(new Integer(estate[0]));
		            	appFocusScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
		            	appFocusScopeService.save(appFocusScope);
		            }
            	}
            }
            
            if(query.getState()== 1 || query.getState() == 0) {//推荐到首页新闻列表置顶
        		AppHomepage appHomepage = new AppHomepage();
        		appHomepage.setId(businessActivity.getActId());
    		    appHomepage.setTitle(businessActivity.getActName());
    		    appHomepage.setBrief(businessActivity.getBrief());
    		    appHomepage.setPic(businessActivity.getAppPic());
    		    appHomepage.setType(4);//活动
    		    appHomepage.setPublishTime(new Timestamp(System.currentTimeMillis()));
    		    appHomepage.setTop(businessActivity.getRecommend()==null?0:businessActivity.getRecommend());
    		    appHomepageService.save(appHomepage);
				
    		    for(int i=0;i<estateArr.length;i++) {
                	String[] estate = estateArr[i].split(":");
                	AppHomepageScope appHomepageScope = new AppHomepageScope();
    				appHomepageScope.setHomePageId(appHomepage.getHomePageId());
    				appHomepageScope.setId(new Integer(estate[0])); //小区id
    				appHomepageScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
    				appHomepageScopeService.save(appHomepageScope);
                }
        	}
            
            //执行推送接口
			//活动向小区内的所有居民发送通知
			if(businessActivity.getIsPush() != null && businessActivity.getIsPush() == 1 && (businessActivity.getState() == 0 || businessActivity.getState() == 1)) {//可推送
				String ids = "";
				for(int i=0;i<estateArr.length;i++) {
					String[] scope = estateArr[i].split(":");
					Integer estateId = new Integer(scope[0]);
					ids +="'"+estateId+"',"; 
				}
				if(estateArr.length!=0){
					ids = ids.substring(0, ids.length()-1);
				}
				
				//查询该小区下的userId, baiduId, channelId
				List appUserList = appUserService.findUserPushIds(ids);
				AppPushLog appPushLog = new AppPushLog();
				String title = "OK家";
				String description = "【活动】"+businessActivity.getActName();	
				Map paramMap = new HashMap();
				paramMap.put("messageType", 9);
				paramMap.put("ID", businessActivity.getActId());
				
				for(int j=0;j<appUserList.size();j++) {
					AppUser appUser = (AppUser) appUserList.get(j);
					if(appUser.getBaiduId() != null && !"".equals(appUser.getBaiduId()) && appUser.getChannelId() != null && !"".equals(appUser.getChannelId())) {
						Integer success = AppPushNotificationUtil.pushNotification(
								title, 
								description, 
								appUser.getDeviceType(),
								Long.valueOf(appUser.getChannelId()).longValue(), 
								appUser.getBaiduId(),
								paramMap
								);
						//记录推送日志
						appPushLog.setUserId(appUser.getUserId());
					    appPushLog.setUserName(appUser.getRealname());
					    appPushLog.setBaiduId(appUser.getBaiduId());
					    appPushLog.setChannelId(appUser.getChannelId());
					    appPushLog.setTitle(title);
					    appPushLog.setDescription(description);
					    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
					    appPushLog.setSendState(success);
					    appPushLog.setSenderId(getUser().getUserId());
					    appPushLog.setSenderName(getUser().getUserName());
						appPushLogService.save(appPushLog);
					}
				}
			}
            
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"保存成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"保存失败\"}";
			GSLogger.error("保存businessActivity信息时发生错误：/business/businessActivity/save", e);
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
	public ModelAndView modify(BusinessActivityQuery query) {

        ModelAndView mav = new ModelAndView("/module/activity/modify");
        BusinessActivity businessActivity = businessActivityService.findById(query.getActId());
    	//保存公告范围
  		Map paramMap = new HashMap();
  		paramMap.put("actId", businessActivity.getActId());
  		List list = businessActivityScopeService.findByMap(paramMap);
  		StringBuilder sb = new StringBuilder();
  		if(list.size() > 0){
  			for(int i=0;i<list.size();i++) {
  				BusinessActivityScope businessActivityScope = (BusinessActivityScope) list.get(i);
  				sb.append(businessActivityScope.getEstateId()+":"+businessActivityScope.getEstateName()+",");
  			}
  			mav.addObject("scope", sb.toString().subSequence(0, sb.toString().length()-1));
  		}
  		
  		if(businessActivity.getTypeId() == 2) {
  			List<BusinessActivityRegistrationTimeslot> businessActivityRegistrationTimeslot = businessActivityRegistrationTimeslotService.findByMap(paramMap);
  			mav.addObject("businessActivityRegistrationTimeslot", businessActivityRegistrationTimeslot);
  		} else if(businessActivity.getTypeId() == 3) {
  			List<BusinessActivityVoteOptions> businessActivityVoteOptions = businessActivityVoteOptionsService.findByMap(paramMap);
  			mav.addObject("businessActivityVoteOptions", businessActivityVoteOptions);
  			if(businessActivity.getVoteType() == 2 || businessActivity.getVoteType() == 3) {
  				String imgJoin = "";
	  			for(BusinessActivityVoteOptions bean : businessActivityVoteOptions) {
	  				imgJoin += "#" + bean.getImage();
	  			}
	  			if(imgJoin.length() > 0) {
		  			 mav.addObject("imgJoin", imgJoin);
	  			}
  			}
  		} else if(businessActivity.getTypeId() == 4) {
  			String couponValid[] = businessActivity.getCouponValid().split("~");
  			businessActivity.setCouponStartDate(couponValid[0]);
  			businessActivity.setCouponEndDate(couponValid[1]);
  		}
        mav.addObject("businessActivity", businessActivity);
        return mav;
	}
	
	/**
	 * 更新对象
	 * @param request
	 * @param query
	 * @return
	 */
	@RequestMapping(value="update")
	public void update(HttpServletRequest request, HttpServletResponse response, BusinessActivityQuery query) {
		BusinessActivity businessActivity = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String json = "";
		try{
		    businessActivity = businessActivityService.findById(query.getActId());
		    businessActivity.setActName(query.getActName());
		    businessActivity.setTypeId(query.getTypeId());
		    businessActivity.setTypeName(query.getTypeName());
		    businessActivity.setActContent(query.getActContent());
		    businessActivity.setBrief(query.getBrief());
		    businessActivity.setActPic(query.getActPic());
		    if(query.getActPic() != null && !"".equals(query.getActPic())) {
		    	File file = new File(businessActivity.getActPic());
		    	file.delete();
		    	businessActivity.setActPic(query.getActPic());
		    }
		    if(query.getAppPic() != null && !"".equals(query.getAppPic())) {
		    	File file = new File(businessActivity.getAppPic());
		    	file.delete();
		    	businessActivity.setAppPic(query.getAppPic());
		    }
		    businessActivity.setUserType(query.getUserType());
		    businessActivity.setPublisherId(getUser().getUserId()); //发布人ID
		    //String planTime = query.getPlanTime();
		    //String[] timeArr = planTime.split(" ");
		    //businessActivity.setPublishDate(timeArr[0]);
		    //businessActivity.setPublishTime(timeArr[1]);
		    //businessActivity.setRank(query.getRank());
		    businessActivity.setStartTime(query.getStartTime());
		    businessActivity.setEndTime(query.getEndTime());
		    businessActivity.setState(query.getState());
		    businessActivity.setVisits(0);
		    businessActivity.setComments(0);
		    businessActivity.setSupports(0);
		    businessActivity.setParticpates(0);
		    businessActivity.setIsComment(query.getIsComment());
		    businessActivity.setRecommend(query.getRecommend());
		    businessActivity.setIsPush(query.getIsPush());
		    businessActivity.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    businessActivity.setEditTime(new Timestamp(System.currentTimeMillis()));
		    // 活动结束时间

			if(query.getEndTime() != null && !"".equals(query.getEditTime1()) && (query.getTypeId() == 2 || query.getTypeId() == 3)) {
		    	 businessActivity.setStartTime(sdf.format(new Date()));
				 businessActivity.setEndTime(query.getEndTime()); 
				 SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
				 SimpleDateFormat sfTime = new SimpleDateFormat("HH:mm");
				 Date date = sdf.parse(query.getEndTime());
				 Date dt = new Date(date.getTime()-1800000);
				 businessActivity.setPublishDate(sfDate.format(sfDate.parse(query.getEndTime())));
				 businessActivity.setPublishTime(sfTime.format(dt));
	        } else {
	        	businessActivity.setStartTime(query.getStartTime());
				 businessActivity.setEndTime(query.getEndTime());
	        }
		    
		    businessActivity.setEditor(getUser().getUserName());
	        if(query.getActScope() != null && !"".equals(query.getActScope())) {
	        	businessActivity.setActScope(query.getActScope());
	        }
	        if(query.getState() == 0 || query.getState() == 1) {
	        	businessActivity.setPublisherId(getUser().getUserId());
	        }
	        businessActivity.setIsTimingPush(query.getIsTimingPush());
	        businessActivity.setTimingPushconTent(query.getTimingPushconTent());
	        if(query.getTimingPushTime1() != null && !"".equals(query.getTimingPushTime1())) {
				Date ts1= (Date) sdf.parse(query.getTimingPushTime1());
		        businessActivity.setTimingPushTime(new Timestamp(ts1.getTime()));
	        }
	        
	        if(query.getTypeId() == 1) {
	        	String planTime = query.getPlanTime();
			    String[] timeArr = planTime.split(" ");
			    businessActivity.setPublishDate(timeArr[0]);
			    businessActivity.setPublishTime(timeArr[1]);
			    businessActivity.setRank(query.getRank());
	        } else if(query.getTypeId() == 2) {
	        	String arr[] = request.getParameterValues("attributeValues");
		        if(arr.length > 0){
		        	String str = "";
		        	for(int i=0; i<arr.length; i++) {
		        		str+=arr[i]+",";
		        	}
		        	str = str.substring(0, str.length()-1);
		        	businessActivity.setAttributeValues(str);
		        }
	        	businessActivity.setTimes(query.getTimes());
	        } else if(query.getTypeId() == 3) {
	        	businessActivity.setVoteType(query.getVoteType());
	        	businessActivity.setVotes(query.getVotes());
	        } else if(query.getTypeId() == 4) {
	        	/*businessActivity.setPublishDate(query.getCouponEndDate());
			    businessActivity.setPublishTime("00:00");*/
	        	String planTime = query.getPlanTime();
			    String[] timeArr = planTime.split(" ");
			    businessActivity.setPublishDate(timeArr[0]);
			    businessActivity.setPublishTime(timeArr[1]);
			    
	        	businessActivity.setCouponName(query.getCouponName());
	        	businessActivity.setCouponDesc(query.getCouponDesc());
	        	businessActivity.setCouponImg(query.getCouponImg());
	        	businessActivity.setCouponNum(query.getCouponNum());
	        	businessActivity.setCouponValid(query.getCouponStartDate()+"~"+query.getCouponEndDate());
	        	businessActivity.setReportExcel(query.getReportExcel());
	        }
	        
	        // 活动状态为定时发布时 设置定时发布时间 
	        if(query.getState() == 6) {
	        	 if(query.getTimingPublicTime1() != null && !"".equals(query.getTimingPublicTime1())) {
	 				Date ts1= (Date) sdf.parse(query.getTimingPublicTime1());
	 		        businessActivity.setTimingPublicTime(new Timestamp(ts1.getTime()));
	 	        }
	        }
            businessActivityService.update(businessActivity);
            
            if(query.getTypeId() == 2) {
            	boolean flag = businessActivityRegistrationTimeslotService.delete(businessActivity.getActId());
            	if(flag) {
	            	if(request.getParameterValues("timeSlotName1") != null && request.getParameterValues("number") != null) {
	    	            String timeSlotName[] = request.getParameterValues("timeSlotName1");
	    	            String number[] = request.getParameterValues("number");
	    	            for(int i=0; i<timeSlotName.length; i++) {
	    	            	BusinessActivityRegistrationTimeslot businessActivityRegistrationTimeslot = new BusinessActivityRegistrationTimeslot();
	    	            	businessActivityRegistrationTimeslot.setActId(businessActivity.getActId());
	    	            	businessActivityRegistrationTimeslot.setTimeSlotName(timeSlotName[i]);
	    	            	businessActivityRegistrationTimeslot.setNumber(Integer.parseInt(number[i]));
	    	            	businessActivityRegistrationTimeslot.setCreateTime(new Timestamp(System.currentTimeMillis()));
	    	            	businessActivityRegistrationTimeslot.setEditTime(new Timestamp(System.currentTimeMillis()));
	    	            	businessActivityRegistrationTimeslot.setEditor("");
	    	            	businessActivityRegistrationTimeslotService.save(businessActivityRegistrationTimeslot);
	    	            }
	            	}
            	}
            }else if(query.getTypeId() == 3) {
            	boolean flag = businessActivityVoteOptionsService.delete(businessActivity.getActId());
            	if(flag) {
	            	if(query.getVoteType() == 1) {
	            		if(request.getParameterValues("content") != null) {
		    	            String content[] = request.getParameterValues("content");
		    	            for(int i=0; i<content.length; i++) {
		    	            	BusinessActivityVoteOptions businessActivityVoteOptions = new BusinessActivityVoteOptions();
		    	            	businessActivityVoteOptions.setActId(businessActivity.getActId());
		    	            	businessActivityVoteOptions.setContent(content[i]);
		    	            	businessActivityVoteOptions.setImage("");
		    	            	businessActivityVoteOptions.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    	            	businessActivityVoteOptions.setEditTime(new Timestamp(System.currentTimeMillis()));
		    	            	businessActivityVoteOptions.setEditor("");
		    	            	businessActivityVoteOptionsService.save(businessActivityVoteOptions);
		    	            }
	            		}
	            	} else if(query.getVoteType() == 2) {
	            		if(query.getImage()!= null) {
		    	            String image[] = query.getImage().substring(1).split("#");
		    	            for(int i=0; i<image.length; i++) {
		    	            	BusinessActivityVoteOptions businessActivityVoteOptions = new BusinessActivityVoteOptions();
		    	            	businessActivityVoteOptions.setActId(businessActivity.getActId());
		    	            	businessActivityVoteOptions.setContent("");
		    	            	businessActivityVoteOptions.setImage(image[i]);
		    	            	businessActivityVoteOptions.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    	            	businessActivityVoteOptions.setEditTime(new Timestamp(System.currentTimeMillis()));
		    	            	businessActivityVoteOptions.setEditor("");
		    	            	businessActivityVoteOptionsService.save(businessActivityVoteOptions);
		    	            }
	            		}
	            	} else if(query.getVoteType() == 3) {
	            		if(request.getParameterValues("content") != null && request.getParameterValues("image") != null) {
		    	            String content[] = request.getParameterValues("content");
		    	            String image[] = query.getImage().substring(1).split("#");
		    	            for(int i=0; i<content.length; i++) {
		    	            	BusinessActivityVoteOptions businessActivityVoteOptions = new BusinessActivityVoteOptions();
		    	            	businessActivityVoteOptions.setActId(businessActivity.getActId());
		    	            	businessActivityVoteOptions.setContent(content[i]);
		    	            	businessActivityVoteOptions.setImage(image[i]);
		    	            	businessActivityVoteOptions.setCreateTime(new Timestamp(System.currentTimeMillis()));
		    	            	businessActivityVoteOptions.setEditTime(new Timestamp(System.currentTimeMillis()));
		    	            	businessActivityVoteOptions.setEditor("");
		    	            	businessActivityVoteOptionsService.save(businessActivityVoteOptions);
		    	            }
	            		}
	            	}
            	}
            } else if(query.getTypeId() == 4) {
            	if(!"".equals(businessActivity.getReportExcel()) && businessActivity.getReportExcel() != null) {        

                    businessActivityCouponService.delete(businessActivity.getActId());
    	            try {
                        File file = new File(CommonUtils.LOCALEXCELPATH, businessActivity.getReportExcel());
                       
                        String path = file.getPath();
                        String[] columns = {"couponCode"};
                        
                        List<BusinessActivityCoupon> list = parse(path, 0, 1, 0, 1, columns);
                        for(int i=0;i<list.size();i++) {
            				BusinessActivityCoupon businessActivityCoupon = (BusinessActivityCoupon) list.get(i);
            				
            				businessActivityCoupon.setActId(businessActivity.getActId());
            				businessActivityCoupon.setCouponCode(businessActivityCoupon.getCouponCode());
            				businessActivityCoupon.setState(0);
            				businessActivityCoupon.setCreateTime(new Timestamp(System.currentTimeMillis()));
            				businessActivityCoupon.setEditTime(new Timestamp(System.currentTimeMillis()));
            				businessActivityCoupon.setEditor("");
            				businessActivityCoupon.setUserId(0);
            				businessActivityCouponService.save(businessActivityCoupon);
            			}
    	            } catch (Exception e) {
    	                e.printStackTrace();
    	            }
    	        }
            }
            
            //活动范围 ： 针对社区和驿站的小区
            String scopeString = query.getActScope();
        	String[] estateArr = scopeString.split(",");
            if(query.getActScope() != null && !"".equals(query.getActScope())) {
            	//活动范围 ： 针对社区和驿站的小区 先删除之前的小区范围，然后重新插入
    			Map paramMap = new HashMap();
    			paramMap.put("actId", businessActivity.getActId());
    			List scopeList = businessActivityScopeService.findByMap(paramMap);
    			for(int i=0;i<scopeList.size();i++) {
    				BusinessActivityScope scope = (BusinessActivityScope) scopeList.get(i);
    				businessActivityScopeService.delete(scope.getActId());
    			}
                String str = "";
                for(int i=0;i<estateArr.length;i++) {
                	String[] estate = estateArr[i].split(":");
                	BusinessActivityScope scope = new BusinessActivityScope();
                	scope.setActId(businessActivity.getActId());
                	scope.setCreateTime(new Timestamp(System.currentTimeMillis()));
                	scope.setEstateId(new Integer(estate[0]));
                	scope.setEstateName(estate[1]);
                	str += estate[1]+',';
                	businessActivityScopeService.save(scope);
                }
                str = str.substring(0, str.length()-1);
                businessActivity.setActScope(str);
                businessActivityService.update(businessActivity);
            }
            
            if(query.getRecommend() != null && (query.getState()== 1 || query.getState()== 0)) {//推荐
            	if( query.getRecommend() == 0) {//推荐到首页焦点图
            		BusinessFocus businessFocus = new BusinessFocus();
					businessFocus.setTitle(businessActivity.getActName());
					businessFocus.setContent(businessActivity.getActContent());
				    businessFocus.setState(2);   // 待审核
				    businessFocus.setPicUrl(businessActivity.getActPic());
				    businessFocus.setPageUrl("");
				    businessFocus.setSourceId(businessActivity.getActId());
				    businessFocus.setSourceType(1);	// 来源类型
				    businessFocus.setIshtml(0);  // 静态
				    businessFocus.setAuditInfo("");
				    businessFocus.setFocusScope(businessActivity.getActScope());  //展示范围
				    businessFocus.setVisits(0);
				    businessFocus.setSupports(0);
				    businessFocus.setSelectorId(getUser().getUserId());
				    businessFocus.setSelectorName(getUser().getUserName());
				    businessFocus.setSelectTime(new Timestamp(System.currentTimeMillis()));
					businessFocusService.save(businessFocus);
					
					AppFocusScope appFocusScope = new AppFocusScope();
					for(int i=0;i<estateArr.length;i++) {
		            	String[] estate = estateArr[i].split(":");
		            	appFocusScope.setFocusId(businessFocus.getFocusId());
		            	appFocusScope.setEstateId(new Integer(estate[0]));
		            	appFocusScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
		            	appFocusScopeService.save(appFocusScope);
		            }
            	}  
            }
            
            if(query.getState()== 1 || query.getState()== 0) {//推荐到首页新闻列表置顶
        		AppHomepage appHomepage = new AppHomepage();
        		appHomepage.setId(businessActivity.getActId());
    		    appHomepage.setTitle(businessActivity.getActName());
    		    appHomepage.setBrief(businessActivity.getBrief());
    		    appHomepage.setPic(businessActivity.getAppPic());
    		    appHomepage.setType(4);//活动
    		    appHomepage.setPublishTime(new Timestamp(System.currentTimeMillis()));
    		    appHomepage.setTop(businessActivity.getRecommend()==null?0:businessActivity.getRecommend());
    		    appHomepageService.save(appHomepage);
				
    		    for(int i=0;i<estateArr.length;i++) {
                	String[] estate = estateArr[i].split(":");
                	AppHomepageScope appHomepageScope = new AppHomepageScope();
    				appHomepageScope.setHomePageId(appHomepage.getHomePageId());
    				appHomepageScope.setId(new Integer(estate[0])); //小区id
    				appHomepageScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
    				appHomepageScopeService.save(appHomepageScope);
                }
        	}
            
          //执行推送接口
			//活动向小区内的所有居民发送通知
			if(businessActivity.getIsPush() != null && businessActivity.getIsPush() == 1  && (businessActivity.getState() == 0 || businessActivity.getState() == 1)) {//可推送
				String ids = "";
				for(int i=0;i<estateArr.length;i++) {
					String[] scope = estateArr[i].split(":");
					Integer estateId = new Integer(scope[0]);
					ids +="'"+estateId+"',"; 
				}
				if(estateArr.length!=0){
					ids = ids.substring(0, ids.length()-1);
				}
				
				//查询该小区下的userId, baiduId, channelId
				List appUserList = appUserService.findUserPushIds(ids);
					AppPushLog appPushLog = new AppPushLog();
					String title = "OK家";
					String description = "【活动】"+businessActivity.getActName();	
					
					Map paramMap = new HashMap();
					paramMap.put("messageType", 9);
					paramMap.put("ID", businessActivity.getActId());
					
					for(int j=0;j<appUserList.size();j++) {
						AppUser appUser = (AppUser) appUserList.get(j);
						if(appUser.getBaiduId() != null && !"".equals(appUser.getBaiduId()) && appUser.getChannelId() != null && !"".equals(appUser.getChannelId())) {
							Integer success = AppPushNotificationUtil.pushNotification(
									title, 
									description, 
									appUser.getDeviceType(),
									Long.valueOf(appUser.getChannelId()).longValue(), 
									appUser.getBaiduId(),
									paramMap
									);
							//记录推送日志
							appPushLog.setUserId(appUser.getUserId());
						    appPushLog.setUserName(appUser.getRealname());
						    appPushLog.setBaiduId(appUser.getBaiduId());
						    appPushLog.setChannelId(appUser.getChannelId());
						    appPushLog.setTitle(title);
						    appPushLog.setDescription(description);
						    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
						    appPushLog.setSendState(success);
						    appPushLog.setSenderId(getUser().getUserId());
						    appPushLog.setSenderName(getUser().getUserName());
							appPushLogService.save(appPushLog);
						}
					}
			}
			
			json = "{\"success\":\"true\",\"message\":\"编辑成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"编辑失败\"}";
			GSLogger.error("编辑businessActivity信息时发生错误：/business/businessActivity/update", e);
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
						businessActivityService.delete(new Integer(ids[i]));
					}
				}else{
					Boolean  result = businessActivityService.delete(new Integer(id));
					if(result) {
						businessActivityScopeService.delete(new Integer(id));
						Map paramMap = new HashMap();
						paramMap.put("id", Integer.parseInt(id));
						paramMap.put("type", 4);
						List<AppHomepage> list = appHomepageService.findByMap(paramMap);
						if(list.size() == 1) {
							AppHomepage AppHomepage = (AppHomepage)list.get(0);
							appHomepageService.delete(AppHomepage);
							appHomepageScopeService.delete(AppHomepage.getHomePageId());
						}
					}
				}
			}
			json = "{\"success\":\"true\",\"message\":\"删除成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"删除失败\"}";
			GSLogger.error("删除BusinessActivity时发生错误：/business/businessActivity/delete", e);
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
	 * 获取用户所在机构管理的小区
	 * @param response
	 */
	@RequestMapping(value="getEstateTree")
	public void getEstateTree(HttpServletResponse response) {
		JSONObject jsonObj = new JSONObject();
		JSONArray comArr = new JSONArray();
		
		try{
			ShiroUser shiroUser = CommonUtils.getUser();
			// if(ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) {//驿站
			// List comList = businessCommunityService.findAll();
			//获取该用户负责的多社区范围
			Map map = new HashMap();
			map.put("userId", shiroUser.getUserId());
			map.put("orgType", shiroUser.getOrgType());
			map.put("comId", shiroUser.getCurComId());
			
			List comList = businessCommunityService.findComsByUser(map);
			JSONObject comObj = null;
			Map paramMap = null;
			for(int i=0;i<comList.size();i++) {
				BusinessCommunity community = (BusinessCommunity) comList.get(i);
				comObj = new JSONObject();
				paramMap = new HashMap();
				paramMap.put("comId", community.getComId());
				List estateList = manageEstateService.findByMap(paramMap); 
				if(estateList.size() > 0){
					comObj.put("id", "com_"+community.getComId());
					comObj.put("text", community.getComName());
					JSONArray estateArr = new JSONArray();
					for(int j=0;j<estateList.size();j++) {
						ManageEstate estate = (ManageEstate) estateList.get(j);
						JSONObject estateObj = new JSONObject();
						estateObj.put("id", "estate_"+estate.getEstateId());
						estateObj.put("text", estate.getEstateName());
						estateObj.put("checkbox", true);
						estateObj.put("state", "close");
						estateArr.add(estateObj);
					}
					comObj.put("children", estateArr);
					comArr.add(comObj);
				}				
			}
			// }
			jsonObj.put("success", true);
			jsonObj.put("result", comArr);
		}catch(Exception e){
			jsonObj.put("success", false);
			jsonObj.put("message", "获取失败");
			GSLogger.error("获取用户所在机构管理的小区：/business/businessUser/getEstateTree", e);
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(jsonObj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="getActivityByActId")
    public void getActivityByActId(@RequestParam(value="actId") Integer actId, HttpServletResponse response) {
        BusinessActivity businessActivity = new BusinessActivity();
        businessActivity = businessActivityService.findById(actId);
        StringBuilder result = new StringBuilder();
        result.append("{")
            .append("\"actId\":\"").append(businessActivity.getActId()).append("\"").append(",")
		    .append("\"typeId\":\"").append(businessActivity.getTypeId()).append("\"").append(",")
		    .append("\"actName\":\"").append(businessActivity.getActName()).append("\"").append(",")
		    .append("\"actContent\":\"").append(businessActivity.getActContent().replace("\"", "\\\"")).append("\"").append(",")
		    .append("\"typeName\":\"").append(businessActivity.getTypeName()).append("\"").append(",")
		    .append("\"actScope\":\"").append(businessActivity.getActScope()).append("\"").append(",")
		    .append("\"brief\":\"").append(businessActivity.getBrief()).append("\"").append(",")
		    .append("\"actPic\":\"").append(businessActivity.getActPic()).append("\"").append(",")
		    .append("\"actLink\":\"").append(businessActivity.getActLink()).append("\"").append(",")
		    .append("\"actManage\":\"").append(businessActivity.getActManage()).append("\"").append(",")
		    .append("\"userType\":\"").append(businessActivity.getUserType()).append("\"").append(",")
		    .append("\"publisherId\":\"").append(businessActivity.getPublisherId()).append("\"").append(",")
		    .append("\"publishDate\":\"").append(businessActivity.getPublishDate()).append("\"").append(",")
		    .append("\"publishTime\":\"").append(businessActivity.getPublishTime()).append("\"").append(",")
		    .append("\"startTime\":\"").append(businessActivity.getStartTime()).append("\"").append(",")
		    .append("\"endTime\":\"").append(businessActivity.getEndTime()).append("\"").append(",")
		    .append("\"rank\":\"").append(businessActivity.getRank()).append("\"").append(",")
		    .append("\"state\":\"").append(businessActivity.getState()).append("\"").append(",")
		    .append("\"auditorId\":\"").append(businessActivity.getAuditorId()).append("\"").append(",")
		    .append("\"auditorName\":\"").append(businessActivity.getAuditorName()).append("\"").append(",")
		    .append("\"auditTime\":\"").append(businessActivity.getAuditTime()).append("\"").append(",")
		    .append("\"visits\":\"").append(businessActivity.getVisits()).append("\"").append(",")
		    .append("\"comments\":\"").append(businessActivity.getComments()).append("\"").append(",")
		    .append("\"supports\":\"").append(businessActivity.getSupports()).append("\"").append(",")
		    .append("\"particpates\":\"").append(businessActivity.getParticpates()).append("\"").append(",")
		    .append("\"isComment\":\"").append(businessActivity.getIsComment()).append("\"").append(",")
		    .append("\"recommend\":\"").append(businessActivity.getRecommend()).append("\"").append(",")
		    .append("\"isPush\":\"").append(businessActivity.getIsPush()).append("\"").append(",")
		    .append("\"refuseMemo\":\"").append(businessActivity.getRefuseMemo()).append("\"").append(",")
		     .append("\"isImportant\":\"").append(businessActivity.getIsImportant()).append("\"").append(",")
		    .append("\"createTime\":\"").append(businessActivity.getCreateTime()).append("\"").append(",")
		    .append("\"editTime\":\"").append(businessActivity.getEditTime()).append("\"").append(",")
		    .append("\"editor\":\"").append(businessActivity.getEditor()).append("\"")
            .append("}");

            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
            try {
                response.getWriter().write(result.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
	
	 /**
		 * 撤回发布活动对象
		 * @param request
		 * @param businessActivity
		 * @return
		 */
		@RequestMapping(value="cancelActivePublishState")
		public void cancelActivePublishState(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="actId") Integer actId) {
			
			BusinessActivity  businessActivity = businessActivityService.findById(actId);
			String json = "";
			try{
				businessActivity.setState(5);  // 未发布
				businessActivity.setEditTime(new Timestamp(System.currentTimeMillis()));
				businessActivity.setIsImportant(0);
				businessActivityService.update(businessActivity);
				
				if(businessActivity.getState() == 5) {
					Map paramMap = new HashMap();
					paramMap.put("id", actId);
					paramMap.put("type", 4);
					List<AppHomepage> list = appHomepageService.findByMap(paramMap);
					if(list.size() == 1) {
						AppHomepage AppHomepage = (AppHomepage)list.get(0);
						appHomepageService.delete(AppHomepage);
						appHomepageScopeService.delete(AppHomepage.getHomePageId());
					}
				}
				
				json = "{\"success\":\"true\",\"message\":\"撤回发布成功\"}";
			} catch(Exception e) {
				json = "{\"success\":\"true\",\"message\":\"撤回发布失败\"}"; 
				GSLogger.error("显示businessActivity列表时发生错误：/business/businessActivity/list", e);
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
     * 接受
     * @param actId
     * @param response
     */
    @RequestMapping(value="acceptAct")
    public void acceptAct(@RequestParam(value="actId") Integer actId, HttpServletResponse response) {
        String json = "";
        try{
        	BusinessActivity businessActivity = businessActivityService.findById(actId);
        	if(businessActivity.getTypeId() == 2) {
        		businessActivity.setState(0);//审核通过 已开始
        	} else if(businessActivity.getTypeId() == 1) {
        		businessActivity.setState(1);//审核通过 未开始
        	}
        	
        	businessActivity.setAuditorId(CommonUtils.getUser().getUserId());
        	businessActivity.setAuditorName(CommonUtils.getUser().getUserName());
        	businessActivity.setAuditTime(new Timestamp(System.currentTimeMillis()));
        	businessActivity.setEditTime(new Timestamp(System.currentTimeMillis()));
        	businessActivity.setEditor(CommonUtils.getUser().getUserName());
        	businessActivityService.update(businessActivity);
        	
        	if(businessActivity.getRecommend() != null && businessActivity.getState()== 1) {//推荐
            	if(businessActivity.getRecommend() == 0) {//推荐到首页焦点图
            		BusinessFocus businessFocus = new BusinessFocus();
					businessFocus.setTitle(businessActivity.getActName());
					businessFocus.setContent(businessActivity.getActContent());
				    businessFocus.setState(2);   // 待审核
				    businessFocus.setPicUrl(businessActivity.getActPic());
				    businessFocus.setPageUrl("");
				    businessFocus.setSourceId(businessActivity.getActId());
				    businessFocus.setSourceType(1);	// 来源类型
				    businessFocus.setIshtml(0);  // 静态
				    businessFocus.setAuditInfo("");
				    businessFocus.setFocusScope(businessActivity.getActScope());  //展示范围
				    businessFocus.setVisits(0);
				    businessFocus.setSupports(0);
				    businessFocus.setSelectorId(getUser().getUserId());
				    businessFocus.setSelectorName(getUser().getUserName());
				    businessFocus.setSelectTime(new Timestamp(System.currentTimeMillis()));
					businessFocusService.save(businessFocus);
					
					AppFocusScope appFocusScope = new AppFocusScope();
	    			Map paramMap = new HashMap();
	    			paramMap.put("actId", businessActivity.getActId());
	    			List scopeList = businessActivityScopeService.findByMap(paramMap);
	    			for(int i=0;i<scopeList.size();i++) {
	    				BusinessActivityScope scope = (BusinessActivityScope) scopeList.get(i);
	    				appFocusScope.setFocusId(businessFocus.getFocusId());
		            	appFocusScope.setEstateId(scope.getEstateId());
		            	appFocusScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
		            	appFocusScopeService.save(appFocusScope);
	    			}
            	}
            }

        	if(businessActivity.getState()== 1 || businessActivity.getState() == 0) {//推荐到首页新闻列表置顶
        		AppHomepage appHomepage = new AppHomepage();
        		appHomepage.setId(businessActivity.getActId());
    		    appHomepage.setTitle(businessActivity.getActName());
    		    appHomepage.setBrief(businessActivity.getBrief());
    		    appHomepage.setPic(businessActivity.getAppPic());
    		    appHomepage.setType(4);//活动
    		    appHomepage.setPublishTime(new Timestamp(System.currentTimeMillis()));
    		    appHomepage.setTop(businessActivity.getRecommend()==null?0:businessActivity.getRecommend());
    		    appHomepageService.save(appHomepage);
    		    
    		    Map paramMap = new HashMap();
    		    paramMap.put("actId", businessActivity.getActId());
    		    List<BusinessActivityScope> list =businessActivityScopeService.findByMap(paramMap);
    		    for(int i=0; i<list.size(); i++) {
        		    BusinessActivityScope businessActivityScope = (BusinessActivityScope)list.get(i);
                	AppHomepageScope appHomepageScope = new AppHomepageScope();
    				appHomepageScope.setHomePageId(appHomepage.getHomePageId());
    				appHomepageScope.setId(businessActivityScope.getEstateId()); 	// 小区id
    				appHomepageScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
    				
    				appHomepageScopeService.save(appHomepageScope);
                }
        	}
        	
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
			json = "{\"success\":\"true\",\"message\":\"接受成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"接受失败\"}";
			GSLogger.error("删除BusinessActivity时发生错误：/business/businessActivity/acceptAct", e);
			e.printStackTrace();
		}
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 拒绝
     * @param actId
     * @param response
     */
    @RequestMapping(value="refuseAct")
    public void refuseAct(@RequestParam(value="actId") Integer actId, HttpServletRequest request, HttpServletResponse response) {
        String json = "";
        try{
        	String refuseMemo = request.getParameter("refuseMemo");
        	BusinessActivity businessActivity = businessActivityService.findById(actId);
        	businessActivity.setState(4);//未通过
        	businessActivity.setRefuseMemo(refuseMemo);
        	businessActivity.setEditTime(new Timestamp(System.currentTimeMillis()));
        	businessActivity.setEditor(CommonUtils.getUser().getUserName());
        	businessActivityService.update(businessActivity);
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
			
			json = "{\"success\":\"true\",\"message\":\"拒绝成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"拒绝失败\"}";
			GSLogger.error("删除BusinessActivity时发生错误：/business/businessActivity/refuseAct", e);
			e.printStackTrace();
		}
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /*//置顶
    @RequestMapping(value="setTop")
    public void setTop(@RequestParam(value="actId") Integer actId, HttpServletResponse response) {
        String json = "";
        try{
        	BusinessActivity businessActivity = businessActivityService.findById(actId);
        	businessActivity.setIsImportant(1);
        	businessActivity.setEditTime(new Timestamp(System.currentTimeMillis()));
        	businessActivity.setEditor(CommonUtils.getUser().getUserName());
        	businessActivityService.update(businessActivity);
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
			
			json = "{\"success\":\"true\",\"message\":\"置顶成功\"}";
		}catch(Exception e){
			json = "{\"success\":\"false\",\"message\":\"置顶失败\"}";
			GSLogger.error("删除BusinessAnno时发生错误：/business/businessAnno/setTop", e);
			e.printStackTrace();
		}
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    
    /**
     * 根据actId查询当前所有置顶的活动
     * @param query
     * @param response
     */
    @RequestMapping(value="setTop")
    public void setTop(@RequestParam(value="actId") Integer actId, HttpServletResponse response) {
        String json = "";
        try{
        	int size = 2;  //最大置顶数
        	Map paramMap = new HashMap();
        	paramMap.put("isImportant",  1);
        	List<BusinessActivity> list = businessActivityService.findByMap(paramMap);
        	
        	BusinessActivity businessActivity = businessActivityService.findById(actId);
        	
        	//查询出"活动"列表中置顶的条数小于最大置顶数
        	if(list.size() < size) {
    			json = "{\"acttitle\":\""+businessActivity.getActName()+"\",\"oldacttitle\":\"\",\"oldactId\":\"\"}";
        	} else {
    			json = "{\"acttitle\":\""+businessActivity.getActName()+"\",\"oldacttitle\":\""+ list.get(0).getActName()+"\",\"oldactId\":\"" + list.get(0).getActId()+"\"}";
        	}
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("utf-8");
		}catch(Exception e){
			GSLogger.error("删除BusinessActivity时发生错误：/business/businessActivity/setTop", e);
			e.printStackTrace();
		}
        try {
            response.getWriter().write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
	 * 置顶活动，同时更改首页置顶状态
	 * @param request
	 * @param businessActivity
	 * @return
	 */
	@RequestMapping(value="updateActImportantState")
	public void updateActImportantState(HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id") String id, @RequestParam(value="oldactId") String oldactId) {
		BusinessActivity businessActivity0 = new BusinessActivity();
		BusinessActivity businessActivity = new BusinessActivity();
		String json = "";
		try{
			if(!oldactId.trim().equals("")) {
				businessActivity0.setActId(Integer.parseInt(oldactId));
				businessActivity0.setIsImportant(0);
				businessActivity0.setImportantTime(null);
				businessActivity0.setEditTime(new Timestamp(System.currentTimeMillis()));
				businessActivity0.setEditor(CommonUtils.getUser().getUserName());
				businessActivityService.update(businessActivity0);
			} 
			businessActivity.setActId(Integer.parseInt(id));
			businessActivity.setIsImportant(1);
			businessActivity.setImportantTime(new Timestamp(System.currentTimeMillis()));
			businessActivity.setEditTime(new Timestamp(System.currentTimeMillis()));
			businessActivity.setEditor(CommonUtils.getUser().getUserName());
        	businessActivityService.update(businessActivity);
			
			Map paramMap = new HashMap();
			paramMap.put("id", businessActivity.getActId());
			List list = appHomepageService.findByMap(paramMap);
			
			if(list != null) {
				AppHomepage appHomepage = (AppHomepage)list.get(0);
				if((appHomepage.getTop() == null || appHomepage.getTop() == 0) && businessActivity.getIsImportant() == 1) {
					appHomepage.setTop(1);
					appHomepageService.update(appHomepage);
				}
			}
			
			//保存成功
			json = "{\"success\":\"true\",\"message\":\"置顶成功\"}";
		} catch(Exception e) {
			json = "{\"success\":\"false\",\"message\":\"置顶失败\"}";
			GSLogger.error("显示businessActivity列表时发生错误：/business/businessActivity/list", e);
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
	 * 进入参与人员列表页
	 * @return
	 */
	@RequestMapping(value="viewParticipates")
	public ModelAndView viewParticipates(BusinessActivityQuery query) {
		BusinessActivity businessActivity = new BusinessActivity();
		BaseBean baseBean = new BaseBean();
		try{
			businessActivity = businessActivityService.findById(query.getActId());
			//获取参与列表
			BusinessActivityParticipateQuery participateQuery = new BusinessActivityParticipateQuery();
			participateQuery.setActId(query.getActId());
			participateQuery.setSort("rank");
			participateQuery.setOrder("asc");
			participateQuery.setRows(20);
			baseBean = businessActivityParticipateService.findAllPage(participateQuery);
		}catch(Exception e){
			GSLogger.error("进入参与人员列表页时发生错误：/business/businessActivity/viewParticipates", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/activity/viewParticipates");
		mav.addObject("businessActivity", businessActivity);
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		return mav;
	}
	
	/**
	 * 进入报名活动参与人员列表页
	 * @return
	 */
	@RequestMapping(value="viewPublicParticipates")
	public ModelAndView viewPublicParticipates(BusinessActivityQuery query) {
		BusinessActivity businessActivity = new BusinessActivity();
		BaseBean baseBean = new BaseBean();
		BaseBean baseBean1 = new BaseBean();
		try{
			businessActivity = businessActivityService.findById(query.getActId());
			//获取参与列表
			BusinessActivityRegistrationTimeslotQuery participateQuery = new BusinessActivityRegistrationTimeslotQuery();
			participateQuery.setActId(query.getActId());
			participateQuery.setSort("timeSlotId");
			participateQuery.setOrder("asc");
			participateQuery.setRows(20);
			baseBean = businessActivityRegistrationTimeslotService.findAllPage(participateQuery);
			
			BusinessActivityRegistrationInformationQuery inforQuery = new BusinessActivityRegistrationInformationQuery();
			inforQuery.setActId(query.getActId());
			inforQuery.setSort("informationId");
			inforQuery.setOrder("desc");
			inforQuery.setRows(20);
			baseBean1 = businessActivityRegistrationInformationService.findAllPage(inforQuery);
		}catch(Exception e){
			GSLogger.error("进入报名活动参与人员列表页时发生错误：/business/businessActivity/viewParticipates", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/activity/viewPublicParticipates");
		mav.addObject("businessActivity", businessActivity);
		mav.addObject("baseBean", baseBean);
		mav.addObject("baseBean1", baseBean1);
		mav.addObject("pager", baseBean1.getPager());
		return mav;
	}
	
	/**
	 * 导出报名活动参与人员名单
	 * @return
	 */
	@RequestMapping(value="exportPublicParticipates")
	public String exportPublicParticipates(HttpServletRequest reqeust,BusinessActivityQuery query,HttpServletResponse response) {
      try  
      {
    	  response.setContentType("application/binary;charset=UTF-8");  
          ServletOutputStream outputStream = response.getOutputStream();  
  		  BusinessActivity businessActivity = businessActivityService.findById(query.getActId());
  		  
  		  	String fileName; 
  		  	if(businessActivity != null  && StringUtils.isNotBlank(businessActivity.getActName()))
  			  fileName = businessActivity.getActName().replaceAll("[(\\\\):(\\?)*(\\[)(\\])\"\\|]", "") ;//Excel名称根据 活动名称 命名    命名不含 \ / : * ? " < > |
  		  	else
  			  fileName = "活动报名名单";
			fileName = URLEncoder.encode(fileName, "UTF-8"); 
			response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xlsx");// 组装附件名称和格式  
//			businessActivityRegistrationInformationService.exportPublicParticipates(query, outputStream);
  		  	/** 查询活动场次 */
			BusinessActivityRegistrationTimeslotQuery participateQuery = new BusinessActivityRegistrationTimeslotQuery();
			participateQuery.setActId(query.getActId());
			participateQuery.setSort("timeSlotId");
			participateQuery.setOrder("asc");
//			participateQuery.setRows(20);
			BaseBean TimeslotBean = businessActivityRegistrationTimeslotService.findAllPage(participateQuery);
  		  	if (TimeslotBean == null || TimeslotBean.getList().size() <= 0)
  		  		return null;
			/** 查询报名活动参与人列表 */
			BusinessActivityRegistrationInformationQuery inforQuery = new BusinessActivityRegistrationInformationQuery();
			inforQuery.setActId(query.getActId());
			inforQuery.setSort("informationId");
			inforQuery.setOrder("desc");
//			inforQuery.setRows(20);
			BaseBean RegistrationInfoBean = businessActivityRegistrationInformationService.findAllPage(inforQuery);
  		  	if (RegistrationInfoBean == null || RegistrationInfoBean.getList().size() <= 0)
  		  		return null;
			
  		  	String[] title = {"昵称","真实姓名","联系电话","生日","年龄","职业","身份证号","Email","地址"} ;
			// 创建一个workbook 对应一个excel应用文件
			XSSFWorkbook workBook = new XSSFWorkbook();
			// 在workbook中添加一个sheet,对应Excel文件中的sheet
			XSSFCell cell = null;
			XSSFSheet sheet = null;
			XSSFCellStyle headStyle = null;
			XSSFCellStyle bodyStyle = null;
			//不同场次 循环创建sheet页
			Map<Integer,String> timeslotMap = new HashMap<Integer,String>();
			for(int x=0;x<TimeslotBean.getList().size();x++)
			{
				BusinessActivityRegistrationTimeslot timeSlot = (BusinessActivityRegistrationTimeslot) TimeslotBean.getList().get(x);
				sheet = workBook.createSheet(timeSlot.getTimeSlotName().replaceAll("[(\\\\):(\\?)*(\\[)(\\])]", ""));   //sheet name 不能包含 \:/?*[]
				System.out.println("===> " + timeSlot.getTimeSlotName().replaceAll("[(\\\\):(\\?)*(\\[)(\\])]", ""));
				ExportUtil exportUtil = new ExportUtil(workBook, sheet);
			    headStyle = exportUtil.getHeadStyle();
			    bodyStyle = exportUtil.getBodyStyle();
				// 构建表头
				XSSFRow headRow = sheet.createRow(0);
				for (int i = 0; i < title.length; i++) {
					cell = headRow.createCell(i);
					cell.setCellStyle(headStyle);
					cell.setCellValue(title[i]);
				}
				timeslotMap.put(timeSlot.getTimeSlotId(), timeSlot.getTimeSlotName().replaceAll("[(\\\\):(\\?)*(\\[)(\\])]", ""));
			}
			// 构建表体数据
			if (CollectionUtils.isNotEmpty(RegistrationInfoBean.getList())) {
				for(int i=0; i<RegistrationInfoBean.getList().size(); i++)
				{
					BusinessActivityRegistrationInformation actRegInfoBean = (BusinessActivityRegistrationInformation) RegistrationInfoBean.getList().get(i);
					int timeSlotId = actRegInfoBean.getTimeSlotId();

					if (StringUtils.isNotBlank(timeslotMap.get(timeSlotId)))
					{
						sheet = workBook.getSheet(timeslotMap.get(timeSlotId));
						if (sheet == null)
							continue;
					}
					else
						continue;
					XSSFRow bodyRow = sheet.createRow(sheet.getLastRowNum()+1);

					cell = bodyRow.createCell(0);
					cell.setCellStyle(bodyStyle);
					cell.setCellValue(actRegInfoBean.getNickname());

					cell = bodyRow.createCell(1);
					cell.setCellStyle(bodyStyle);
					cell.setCellValue(actRegInfoBean.getRealname());

					cell = bodyRow.createCell(2);
					cell.setCellStyle(bodyStyle);
					cell.setCellValue(actRegInfoBean.getTel());
					
					cell = bodyRow.createCell(3);
					cell.setCellStyle(bodyStyle);
					cell.setCellValue(actRegInfoBean.getBirthday());
					
					cell = bodyRow.createCell(4);
					cell.setCellStyle(bodyStyle);
					cell.setCellValue(actRegInfoBean.getAge());
					
					cell = bodyRow.createCell(5);
					cell.setCellStyle(bodyStyle);
					cell.setCellValue(actRegInfoBean.getJob());
					
					cell = bodyRow.createCell(6);
					cell.setCellStyle(bodyStyle);
					cell.setCellValue(actRegInfoBean.getID());
					
					cell = bodyRow.createCell(7);
					cell.setCellStyle(bodyStyle);
					cell.setCellValue(actRegInfoBean.getEmail());
					
					cell = bodyRow.createCell(8);
					cell.setCellStyle(bodyStyle);
					cell.setCellValue(actRegInfoBean.getAddr());
					
				}
			}
			try {
				workBook.write(outputStream);
				outputStream.flush();
				outputStream.close();
			} catch (IOException e) {
				GSLogger.debug("BusinessActivityController exportPublicParticipates()：导出Excel功能发生错误！",e);
				e.printStackTrace();
			} finally {
				try {
					outputStream.close();
				} catch (IOException e) {
					GSLogger.debug("BusinessActivityController exportPublicParticipates()：关闭输出流发生错误！",e);
					e.printStackTrace();
				}
			}

      }  
      catch (IOException e)  
      {  
          e.printStackTrace();  
      }  
      return null;  
	}
	
	/**
	 * 进入投票活动参与人员列表页
	 * @return
	 */
	@RequestMapping(value="viewVoteTypeParticipates")
	public ModelAndView viewVoteTypeParticipates(BusinessActivityQuery query) {
		BusinessActivity businessActivity = new BusinessActivity();
		BaseBean baseBean = new BaseBean();
		BaseBean baseBean1 = new BaseBean();
		try{
			businessActivity = businessActivityService.findById(query.getActId());
			
			//获取参与列表
			BusinessActivityVoteOptionsQuery voteOptionsQuery = new BusinessActivityVoteOptionsQuery();
			voteOptionsQuery.setActId(query.getActId());
			voteOptionsQuery.setSort("optionsId");
			voteOptionsQuery.setOrder("asc");
			voteOptionsQuery.setRows(20);
			baseBean = businessActivityVoteOptionsService.findAllPage(voteOptionsQuery);

			BusinessActivityVoteInformationQuery voteInformationQuery = new BusinessActivityVoteInformationQuery();
			voteInformationQuery.setActId(query.getActId());
			voteInformationQuery.setSort("informationId");
			voteInformationQuery.setOrder("desc");
			voteInformationQuery.setRows(20);
			baseBean1 = businessActivityVoteInformationService.findAllPage(voteInformationQuery);
		}catch(Exception e){
			GSLogger.error("进入参与人员列表页时发生错误：/business/businessActivity/viewVoteTypeParticipates", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/activity/viewVoteTypeParticipates");
		mav.addObject("businessActivity", businessActivity);
		mav.addObject("baseBean", baseBean);
		mav.addObject("baseBean1", baseBean1);
		mav.addObject("pager", baseBean1.getPager());
		return mav;
	}
	
	/**
	 * 进入评论列表页
	 * @return
	 */
	@RequestMapping(value="viewComments")
	public ModelAndView viewComments(BusinessActivityQuery query) {
		BusinessActivity businessActivity = new BusinessActivity();
		BaseBean baseBean = new BaseBean();
		try{
			businessActivity = businessActivityService.findById(query.getActId());
			//获取参与列表
			BusinessActivityCommentQuery commentQuery = new BusinessActivityCommentQuery();
			commentQuery.setActId(query.getActId());
			commentQuery.setSort("commentTime");
			commentQuery.setOrder("desc");
			commentQuery.setRows(12);
			baseBean = businessActivityCommentService.findAllPage(commentQuery);
		}catch(Exception e){
			GSLogger.error("进入参与人员列表页时发生错误：/business/businessActivity/viewParticipates", e);
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView("/module/activity/viewComments");
		mav.addObject("businessActivity", businessActivity);
		mav.addObject("baseBean", baseBean);
		mav.addObject("pager", baseBean.getPager());
		return mav;
	}
	
	/**
	 * 检查报名活动--报名截止时间必须小于报名活动时间
	 * @param request
	 * @param businessActivityQuery
	 * @return
	 */
	@RequestMapping(value="endTimeXYtimeSlotName")
	public void endTimeXYtimeSlotName(HttpServletRequest request, HttpServletResponse response, BusinessActivityQuery query) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String json = "";
		response.setContentType("text/html");
        try {
        	if(request.getParameter("timeSlotName1") != null && !"undefined".equals(request.getParameter("timeSlotName1"))) {
        		String timeSlotName1 =request.getParameter("timeSlotName1");
	    		json =(sdf.parse(query.getEndTime()).getTime() >= sdf.parse(timeSlotName1).getTime()) ? "false" : "true";
        	} else {
        		json = "true";
        	}
			response.getWriter().write(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 上传EXCEL文件操作
	 * @param exclefile
	 * @param response
	 */
    @RequestMapping(value="uploadExcel")
    public void uploadExcel(@RequestParam MultipartFile[] exclefile, HttpServletResponse response) {
        //上传附件
        try {
            for(MultipartFile file : exclefile){
                if(!file.isEmpty()){
                    String fname = FilenameUtils.getBaseName(file.getOriginalFilename());
                    String extense = FilenameUtils.getExtension(file.getOriginalFilename());
                    DecimalFormat decimalFormat=new DecimalFormat(".0");
                    long ltime = getLongTime();
                    String fname2 =  fname + ltime + "." + extense;
                    File newfile =  new File(CommonUtils.LOCALEXCELPATH, fname2);
                    //拷贝到服务器临时文件进行验证excel格式是否正确
                    FileUtils.copyInputStreamToFile(file.getInputStream(), newfile);
                   
                    String path = newfile.getPath();
                    
                    String msg = parse(path, decimalFormat.format(((float)file.getSize()/1024)), fname2 ,0, 1, 0, 1);
                    print(response, msg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String parse(String path, String filename, String filename2, int sheet0, int rowfrom, int columnfrom, int columnto) throws Exception {
        int i = 0; //行值
        int c = 0; //列值
        try {
            Workbook workbook = CommonUtils.getWorkbook(path);
            Sheet sheet = workbook.getSheetAt(sheet0);

            for(Row row : sheet) {
                //从第几行开始解析
                if(i >= rowfrom) {
                    int lastnum = row.getLastCellNum();
                    if(lastnum != 1) {
                        return getJSONString(false, "请检查Excel模板，正确模板为1列，您上传的模板为" + lastnum + "列。");
                    }
                    for(int m = 0; m < lastnum; m++) {
                        Cell cell = row.getCell(m);
                        if(m != 4) {
                            if(cell == null) {
                                return getJSONString(false, getMessage(i, m, "数据不能为空！"));
                            } else {
                                String value = getCellValue(cell).trim();
                                //判断手机号是否为数据并且是13位,第2列为手机号
                                if(m == 1 && !isMobileNO(value)) {
                                    return getJSONString(false, getMessage(i, m, "手机号格式不正确！"));
                                }
                                if(m == 6 && value.length() > 2000) {
                                    return getJSONString(false, getMessage(i, m, "您填写的通知内容超过了2000个字符！"));
                                }
                            }
                        }
                    }
                    c = 0;  //归零
                }
                i++;
            }
        } catch (Exception e) {
            throw new Exception("Excel导入第"+i+"行第"+c+"列失败，请检查Excel数据格式是否正确！");
        }
        return getJSONString(true, filename.concat("|").concat(filename2));
    }

    private String getMessage(int row, int column, String msg) {
        return "第"+(row+1)+"行,第"+(column+1)+"列，" + msg ;
    }
    
    public List parse(String path, int sheet0, int rowfrom, int columnfrom, int columnto, String[] columns) throws Exception {
        List list = new ArrayList();
        int i = 0;
        int c = 0;
        try {
            Workbook workbook = CommonUtils.getWorkbook(path);
            Sheet sheet = workbook.getSheetAt(sheet0);
            
            for(Row row : sheet) {
            	BusinessActivityCoupon obj = new BusinessActivityCoupon();
                /*List idxList = new ArrayList();
            	for(int idx = 0; idx<=6; idx++) {
            		idxList.add(idx);
            	}*/
                //从第几行开始解析
                if(i >= rowfrom) {
                    for (Cell cell : row) {
                        int columnnum = cell.getColumnIndex();
                        c = columnnum;
                       /* for(int idx=0;idx<idxList.size();idx++) {
                        	int idxValue = (Integer) idxList.get(idx);
                        	if(idxValue == columnnum) {
                        		idxList.remove(idx);
                        	}
                        }*/
                        int rownum = cell.getRowIndex();

                        //到第几列时解析结束
                        if(columnfrom <= columnnum && columnnum <= columnto && columnnum <= columns.length - 1 ) {
                            String cellvalue = "";
                            if(isMergedRegion(sheet, rownum , columnnum)) {
                                cellvalue = getMergedRegionValue(sheet, rownum , columnnum);
                            } else {
                                    cellvalue = getCellValue(cell);
                            }
                            BeanUtils.setProperty(obj, columns[columnnum], cellvalue);
                            //++c;
                        }
                    }
                    /*for(int idx=0;idx<idxList.size();idx++) {
                    	int idxValue = (Integer) idxList.get(idx);
                    	BeanUtils.setProperty(obj, columns[idxValue], "");
                    }*/
                    //c = 0;  //归零
                    list.add(obj);
                }
                i++;
            }
        } catch (Exception e) {
            throw new Exception("Excel导入第"+i+"行第"+c+"列失败，请检查Excel数据格式是否正确！");
        }
        return list;
    }
}