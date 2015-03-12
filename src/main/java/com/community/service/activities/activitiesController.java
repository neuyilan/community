package com.community.service.activities;





/**
 * 活动相关处理接口
 * 包括：
 * 
 * @author whh-2_000
 *
 */

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppStatisticsClick;
import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.BusinessActivity;
import com.community.app.module.bean.BusinessActivityComment;
import com.community.app.module.bean.BusinessActivityCoupon;
import com.community.app.module.bean.BusinessActivityParticipate;
import com.community.app.module.bean.BusinessActivityQnhInformation;
import com.community.app.module.bean.BusinessActivityRegistrationInformation;
import com.community.app.module.bean.BusinessActivityRegistrationTimeslot;
import com.community.app.module.bean.BusinessActivitySupport;
import com.community.app.module.bean.BusinessActivityVoteOptions;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppStatisticsClickService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessActivityCommentService;
import com.community.app.module.service.BusinessActivityCouponService;
import com.community.app.module.service.BusinessActivityParticipateService;
import com.community.app.module.service.BusinessActivityQnhInformationService;
import com.community.app.module.service.BusinessActivityRegistrationInformationService;
import com.community.app.module.service.BusinessActivityRegistrationTimeslotService;
import com.community.app.module.service.BusinessActivityService;
import com.community.app.module.service.BusinessActivitySupportService;
import com.community.app.module.service.BusinessActivityVoteInformationService;
import com.community.app.module.service.BusinessActivityVoteOptionsService;
import com.community.app.module.service.BusinessCommunityService;
import com.community.app.module.service.ManageEstateService;
import com.community.app.module.service.ManageSendMsgService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityCommentQuery;
import com.community.app.module.vo.BusinessActivityCouponQuery;
import com.community.app.module.vo.BusinessActivityParticipateQuery;
import com.community.app.module.vo.BusinessActivityQnhInformationQuery;
import com.community.app.module.vo.BusinessActivityQuery;
import com.community.app.module.vo.BusinessActivityRegistrationInformationQuery;
import com.community.app.module.vo.BusinessActivityRegistrationTimeslotQuery;
import com.community.app.module.vo.BusinessActivitySupportQuery;
import com.community.app.module.vo.BusinessActivityVoteInformationQuery;
import com.community.app.module.vo.BusinessActivityVoteOptionsQuery;
import com.community.framework.utils.DateUtil;
import com.community.framework.utils.JsonUtils;
import com.community.framework.utils.messagesUtil;
import com.community.framework.utils.propertiesUtil;
import com.community.framework.utils.weather;
import com.community.framework.utils.testfilter.src.com.gao.SensitivewordFilter;


@Controller
@RequestMapping("/service/activities")
public class activitiesController {
	private static Logger GSLogger = LoggerFactory.getLogger(activitiesController.class);
	@Autowired
	private BusinessCommunityService businessCommunityService;
	@Autowired
	private ManageEstateService manageEstateService;
	@Autowired
	private BusinessActivityService businessActivityService;
	@Autowired
	private BusinessActivityCommentService businessActivityCommentService;
	@Autowired
	private BusinessActivitySupportService businessActivitySupportService;
	@Autowired
	private BusinessActivityParticipateService businessActivityParticipateService;
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private AppUserNewsService appUserNewsService;
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	@Autowired
	private AppStatisticsClickService appStatisticsClickService;
	@Autowired
	private BusinessActivityRegistrationInformationService businessActivityRegistrationInformationService;
	@Autowired
	private BusinessActivityRegistrationTimeslotService businessActivityRegistrationTimeslotService;
	@Autowired
	private BusinessActivityVoteOptionsService businessActivityVoteOptionsService;
	@Autowired
	private BusinessActivityVoteInformationService businessActivityVoteInformationService;
	@Autowired
	private BusinessActivityCouponService businessActivityCouponService;
	@Autowired
	private ManageSendMsgService manageSendMsgService;
	@Autowired
	private BusinessActivityQnhInformationService businessActivityQnhInformationService;
	
	
	
	
	/**
	 * 用户查看活动列表
	 * @param userId,sessionid,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="findByActivities")
	public void findByActivities  (HttpServletRequest request, HttpServletResponse response,BusinessActivityQuery query) {
		String json = "";
		try{
			if (query.getType()!=null && query.getType()==2) {
				query.setStatetype(2);
				query.setIsQNH(1);
			}else {
				query.setStatetype(1);
			}
			query.setType(null);
			
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");  
			query.setSort("editTime");
			query.setOrder("desc");
			query.setRows(15);
			query.setActScope(query.getEstateId()+"");
			query.setIsImportant(1);
			BaseBean topBaseBean = businessActivityService.findAllPage_app(query);
			query.setIsImportant(0);
			BaseBean baseBean = businessActivityService.findAllPage_app(query);
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
			for(int i=0;i<topBaseBean.getList().size();i++) {
				BusinessActivity businessActivity = (BusinessActivity) topBaseBean.getList().get(i);
				json += "{\"ID\":\""+businessActivity.getActId()+"\",\"title\":\""+businessActivity.getActName().replace("\\", "\\\\")+"\",\"time\":\""
						+businessActivity.getPublishTime()+"\",\"brief\":\""+businessActivity.getBrief().replace("\\", "\\\\")+"\",";
				if(businessActivity.getState()==2){
					if("".equals(businessActivity.getActPicNo()) || businessActivity.getActPicNo()==null  || businessActivity.getActPicNo().indexOf("/images/icon/")>=0){
						json +="\"pic\":\"\",";
					}else{
						json +="\"pic\":\""+ip+businessActivity.getActPicNo()+"\",";
					}
				}else {
					if("".equals(businessActivity.getActPic()) || businessActivity.getActPic()==null  || businessActivity.getActPic().indexOf("/images/icon/")>=0){
						json +="\"pic\":\"\",";
					}else{
						json +="\"pic\":\""+ip+businessActivity.getActPic()+"\",";
					}
				}
				if (businessActivity.getTypeId()==1 || businessActivity.getTypeId()==4) {
					String startTime = businessActivity.getPublishDate() + " " + businessActivity.getPublishTime() + ":00";
					//开始结束时间计算
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date ts = (Date) sdf.parse(startTime);
					long time = ts.getTime() + 30*60*1000;
					//long time = ts.getTime() + 1*60*1000;
					String endTime = sdf.format(new Date(time));
					json +="\"startTime\":\""+startTime.replace("-", "/")+"\",";
					json +="\"endTime\":\""+endTime.replace("-", "/")+"\",";
				}else {
					json +="\"startTime\":\""+businessActivity.getStartTime()+"\",";
					json +="\"endTime\":\""+businessActivity.getEndTime()+"\",";
				}
				json +="\"publisherId\":\""+businessActivity.getPublisherId()+"\",\"publisherName\":\""+businessActivity.getNickname()+"\",\"avatar\":\""+ip+businessActivity.getPortrait()+"\",\"state\":\""+businessActivity.getState()+"\",";
				if (businessActivity.getIsQNH()==0) {
					json +="\"qnh\":\"\",";
				}else {
					json +="\"qnh\":\""+businessActivity.getQNHName()+"\",";
				}
				
				if (businessActivity.getTypeId()==1 || businessActivity.getTypeId()==4) {
					json +="\"typeName\":\"限时抢\"";
				}else if (businessActivity.getTypeId()==2) {
					json +="\"typeName\":\"报名\"";
				}else if (businessActivity.getTypeId()==3) {
					json +="\"typeName\":\"投票\"";
				}else {
					json +="\"typeName\":\"\"";
				}
				json +="},";
			}
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessActivity businessActivity = (BusinessActivity) baseBean.getList().get(i);
				json += "{\"ID\":\""+businessActivity.getActId()+"\",\"title\":\""+businessActivity.getActName().replace("\\", "\\\\")+"\",\"time\":\""
						+businessActivity.getPublishTime()+"\",\"brief\":\""+businessActivity.getBrief().replace("\\", "\\\\")+"\",";
				if(businessActivity.getState()==2){
					if("".equals(businessActivity.getActPicNo()) || businessActivity.getActPicNo()==null  || businessActivity.getActPicNo().indexOf("/images/icon/")>=0){
						json +="\"pic\":\"\",";
					}else{
						json +="\"pic\":\""+ip+businessActivity.getActPicNo()+"\",";
					}
				}else {
					if("".equals(businessActivity.getActPic()) || businessActivity.getActPic()==null  || businessActivity.getActPic().indexOf("/images/icon/")>=0){
						json +="\"pic\":\"\",";
					}else{
						json +="\"pic\":\""+ip+businessActivity.getActPic()+"\",";
					}
				}
				
				if (businessActivity.getTypeId()==1 || businessActivity.getTypeId()==4) {
					String startTime = businessActivity.getPublishDate() + " " + businessActivity.getPublishTime() + ":00";
					//开始结束时间计算
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date ts = (Date) sdf.parse(startTime);
					long time = ts.getTime() + 30*60*1000;
					//long time = ts.getTime() + 1*60*1000;
					String endTime = sdf.format(new Date(time));
					json +="\"startTime\":\""+startTime.replace("-", "/")+"\",";
					json +="\"endTime\":\""+endTime.replace("-", "/")+"\",";
				}else {
					json +="\"startTime\":\""+businessActivity.getStartTime()+"\",";
					json +="\"endTime\":\""+businessActivity.getEndTime()+"\",";
				}
				json +="\"publisherId\":\""+businessActivity.getPublisherId()+"\",\"publisherName\":\""+businessActivity.getNickname()+"\",\"avatar\":\""+ip+businessActivity.getPortrait()+"\",\"state\":\""+businessActivity.getState()+"\",";
				if (businessActivity.getIsQNH()==0) {
					json +="\"qnh\":\"\",";
				}else {
					json +="\"qnh\":\""+businessActivity.getQNHName()+"\",";
				}
				
				if (businessActivity.getTypeId()==1 || businessActivity.getTypeId()==4) {
					json +="\"typeName\":\"限时抢\"";
				}else if (businessActivity.getTypeId()==2) {
					json +="\"typeName\":\"报名\"";
				}else if (businessActivity.getTypeId()==3) {
					json +="\"typeName\":\"投票\"";
				}else {
					json +="\"typeName\":\"\"";
				}
				
				json +="},";
			}
			if(baseBean.getList().size() > 0 || topBaseBean.getList().size() > 0) {
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
			response.getWriter().write(JsonUtils.stringToJson(json));
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
			appStatisticsClick.setType(23);
			appStatisticsClick.setTypeName("社区活动列表");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看社区活动详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getActivitiesDetailsById")
	public ModelAndView getActivitiesDetailsById (HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/service/activity");
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		String phpIp = p.getProperty("phpIp");   
		Integer ID = new Integer(request.getParameter("ID"));
		//Integer ID = 11;
		String sessionid = request.getParameter("sessionid");
		//String sessionid = "sessionid";
		String userId = request.getParameter("userId");
		try{
			
			//获取活动信息
			BusinessActivity activity = businessActivityService.findById_app(ID);
			//判断活动类型跳转相应页面
			if(activity.getTypeId()==2){
				mav = new ModelAndView("/service/activityRegistration");
			}else if (activity.getTypeId()==3) {
				mav = new ModelAndView("/service/activityVote");
			}else if (activity.getTypeId()==4) {
				mav = new ModelAndView("/service/activityCoupon");
			}else if (activity.getTypeId()==5) {
				mav = new ModelAndView("/service/activityQnhRegistration");
			}
			
			//Integer userId = 1;
			if(userId!=null && !userId.equals("0") && !userId.equals("")){
				AppUser appUser = appUserService.findById(new Integer(userId));
				mav.addObject("protrait", ip+appUser.getPortrait());
				mav.addObject("nickname", appUser.getNickname());
			}else {
				userId = "0";
			}
			
			
			
			
			
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
			mav.addObject("ctx", ctx);
			mav.addObject("actId", activity.getActId());
			mav.addObject("title", activity.getActName());
			mav.addObject("appPic", activity.getAppPic());
			mav.addObject("particpates", activity.getParticpates());
			mav.addObject("actContent", activity.getActContent());
			mav.addObject("isComment", activity.getIsComment());
			mav.addObject("comments", activity.getComments());
			mav.addObject("supports", activity.getSupports());
			mav.addObject("state", activity.getState());//活动状态
			mav.addObject("protrait", activity.getState());//活动状态
			mav.addObject("state", activity.getState());//活动状态
			mav.addObject("ranks", activity.getRank());//活动排位
			mav.addObject("phpIp", phpIp);
			String startTime = activity.getPublishDate() + " " + activity.getPublishTime() + ":00";
			//开始结束时间计算
			if(activity.getTypeId()==1 || activity.getTypeId()==3 || activity.getTypeId()==4){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date ts = (Date) sdf.parse(startTime);
				long time = ts.getTime() + 30*60*1000;
				//long time = ts.getTime() + 1*60*1000;
				String endTime = sdf.format(new Date(time));
				String dateTime = sdf.format(new Date());
				mav.addObject("startTime", startTime.replace("-", "/"));
				mav.addObject("endTime", endTime.replace("-", "/"));
				mav.addObject("dateTime", dateTime.replace("-", "/"));
			}
			
			
			mav.addObject("ID", ID);
			mav.addObject("sessionid", sessionid);
			mav.addObject("userId", userId);
			
			//获取用户活动排名
			Map paramMap = new HashMap();
			paramMap.put("actId", ID);
			paramMap.put("userId", userId);
			int rank = 0;
			boolean flag=false;
			
			//判断活动类型提取参数
			if(activity.getTypeId()==2){
				BusinessActivityRegistrationTimeslotQuery BusinessActivityRegistrationTimeslotQuery = new BusinessActivityRegistrationTimeslotQuery();
				BusinessActivityRegistrationTimeslotQuery.setActId(ID);
				List<BusinessActivityRegistrationTimeslot> list = businessActivityRegistrationTimeslotService.findByExample(BusinessActivityRegistrationTimeslotQuery);
				int i =0;
				for (BusinessActivityRegistrationTimeslot businessActivityRegistrationTimeslot : list) {
					BusinessActivityRegistrationInformationQuery businessActivityRegistrationInformationQuery = new BusinessActivityRegistrationInformationQuery();
					businessActivityRegistrationInformationQuery.setActId(ID);
					businessActivityRegistrationInformationQuery.setTimeSlotId(businessActivityRegistrationTimeslot.getTimeSlotId());
					int count = businessActivityRegistrationInformationService.selectCount(businessActivityRegistrationInformationQuery);
					businessActivityRegistrationTimeslot.setCount(count);
					if(count>=businessActivityRegistrationTimeslot.getNumber()){
						i++;
					}
				}
				if(list.size()==i){
					flag=true;
				}
				
				mav.addObject("tel", request.getParameter("tel"));
				mav.addObject("list", list);
				mav.addObject("timeSlotId", list.get(0).getTimeSlotId());
				BusinessActivityRegistrationInformationQuery businessActivityRegistrationInformationQuery = new BusinessActivityRegistrationInformationQuery();
				businessActivityRegistrationInformationQuery.setActId(ID);
				businessActivityRegistrationInformationQuery.setUserId(new Integer(userId));
				List<BusinessActivityRegistrationInformation> BusinessActivityRegistrationInformationList = businessActivityRegistrationInformationService.findByExample(businessActivityRegistrationInformationQuery);
				
				if(BusinessActivityRegistrationInformationList.size()>0) {//已参与活动
					rank = 1;
					mav.addObject("partakeTimeSlotId", BusinessActivityRegistrationInformationList.get(0).getTimeSlotId());
				}
				
			}else if (activity.getTypeId()==3) {
				BusinessActivityVoteOptionsQuery businessActivityVoteOptionsQuery = new BusinessActivityVoteOptionsQuery();
				businessActivityVoteOptionsQuery.setActId(ID);
				//获取活动投票项
				List<BusinessActivityVoteOptions> list = businessActivityVoteOptionsService.findByExample(businessActivityVoteOptionsQuery);
				BusinessActivityVoteInformationQuery businessActivityVoteInformationQuery = new BusinessActivityVoteInformationQuery();
				businessActivityVoteInformationQuery.setActId(ID);
				businessActivityVoteInformationQuery.setUserId(new Integer(userId));
				//获取用户投票记录
				int count = businessActivityVoteInformationService.selectCount(businessActivityVoteInformationQuery);
				//判断是否参与活动
				if(count>0){
					rank = 1;
				}
				businessActivityVoteInformationQuery.setUserId(null);
				//获取总票数
				int numberVotes = businessActivityVoteInformationService.selectCount(businessActivityVoteInformationQuery);
				//获取活动参与总人数
				count = businessActivityVoteInformationService.selectCount_userId(businessActivityVoteInformationQuery);
				//分别统计活动投票项数量
				for (BusinessActivityVoteOptions businessActivityVoteOptions : list) {
					businessActivityVoteInformationQuery.setOptionsId(businessActivityVoteOptions.getOptionsId());
					int optCount = businessActivityVoteInformationService.selectCount(businessActivityVoteInformationQuery);
					businessActivityVoteOptions.setCount(optCount);
					businessActivityVoteOptions.setPercentage(weather.percentage(optCount,numberVotes));
				}
				mav.addObject("votes", activity.getVotes());
				mav.addObject("voteType", activity.getVoteType());
				mav.addObject("list", list);
				mav.addObject("count", count);
			}else if (activity.getTypeId()==4) {
				BusinessActivityCouponQuery businessActivityCouponQuery = new BusinessActivityCouponQuery();
				businessActivityCouponQuery.setActId(ID);
				businessActivityCouponQuery.setState(0);
				//统计剩余数量
				int  count = businessActivityCouponService.selectCount(businessActivityCouponQuery);
				mav.addObject("count", count);
				businessActivityCouponQuery.setUserId(new Integer(userId));
				businessActivityCouponQuery.setState(null);
				//是否参与活动
				count = businessActivityCouponService.selectCount(businessActivityCouponQuery);
				if(count>0){
					rank = 1;
				}
				
				mav.addObject("couponDesc", activity.getCouponDesc());
				mav.addObject("couponValid", activity.getCouponValid());
			}else if(activity.getTypeId()==5){
				
				mav.addObject("tel", request.getParameter("tel"));
				BusinessActivityQnhInformationQuery businessActivityQnhInformationQuery = new BusinessActivityQnhInformationQuery();
				businessActivityQnhInformationQuery.setActId(ID);
				businessActivityQnhInformationQuery.setUserId(new Integer(userId));
				List<BusinessActivityQnhInformation> BusinessActivityQnhInformationList = businessActivityQnhInformationService.findByExample(businessActivityQnhInformationQuery);
				
				if(BusinessActivityQnhInformationList.size()>0) {//已参与活动
					rank = 1;
				}
				
			}else {
				List<BusinessActivityParticipate> participateList = businessActivityParticipateService.findByMap(paramMap);
				if(participateList.size() > 0) {//已参与活动
					BusinessActivityParticipate businessActivityParticipate = participateList.get(0);
					rank = businessActivityParticipate.getRank();
				}
			}
			if (userId.equals("0")) {
				rank = 0;
			}
			mav.addObject("flag", flag);
			mav.addObject("rank", rank);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			appStatisticsClick.setUserId(new Integer(userId));
			appStatisticsClick.setType(24);
			appStatisticsClick.setTypeName("社区活动详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	/**
	 * 用户查看北京社区报中新闻的评论
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getActivitiesDetailsById_title")
	public void getActivitiesDetailsById_title(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		try{
			Integer newsId = new Integer(request.getParameter("ID"));
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");  
			BusinessActivity activity = businessActivityService.findById_app(newsId);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"title\":\""+activity.getActName()+"\",";
			json += "\"pic\":\""+ip+activity.getAppPic()+"\"";
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
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看回复我的社区活动详情
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="getInformationById")
	public ModelAndView getInformationById (HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("/service/userActivity");
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		Integer ID = new Integer(request.getParameter("ID"));
		//Integer ID = 11;
		String sessionid = request.getParameter("sessionid");
		//String sessionid = "sessionid";
		String userId = request.getParameter("userId");
		//Integer userId = 1;
		
		try{
			//Integer userId = 1;
			if(userId!=null && !userId.equals("0") && !userId.equals("")){
				AppUser appUser = appUserService.findById(new Integer(userId));
				mav.addObject("protrait", ip+appUser.getPortrait());
				mav.addObject("nickname", appUser.getNickname());
			}else {
				userId = "0";
			}
			
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(new Integer(userId));
			appLatestNews.setTypeId(8);
			appLatestNews.setTo(0);
			appLatestNews.setSourceId(ID);
			appLatestNewsService.delete_app_id(appLatestNews);
			
			//获取活动信息
			BusinessActivity activity = businessActivityService.findById_app(ID);
			//判断活动类型跳转相应页面
			if(activity.getTypeId()==2){
				mav = new ModelAndView("/service/userActivityRegistration");
			}else if (activity.getTypeId()==3) {
				mav = new ModelAndView("/service/userActivityVote");
			}
			
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
			mav.addObject("ctx", ctx);
			mav.addObject("actId", activity.getActId());
			mav.addObject("title", activity.getActName());
			mav.addObject("appPic", activity.getAppPic());
			mav.addObject("particpates", activity.getParticpates());
			mav.addObject("actContent", activity.getActContent());
			mav.addObject("isComment", activity.getIsComment());
			mav.addObject("comments", activity.getComments());
			mav.addObject("supports", activity.getSupports());
			mav.addObject("state", activity.getState());//活动状态
			mav.addObject("protrait", activity.getState());//活动状态
			mav.addObject("state", activity.getState());//活动状态
			mav.addObject("ranks", activity.getRank());//活动排位
			String startTime = activity.getPublishDate() + " " + activity.getPublishTime() + ":00";
			//开始结束时间计算
			if(activity.getTypeId()==1 || activity.getTypeId()==3){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date ts = (Date) sdf.parse(startTime);
				long time = ts.getTime() + 30*60*1000;
				//long time = ts.getTime() + 1*60*1000;
				String endTime = sdf.format(new Date(time));
				String dateTime = sdf.format(new Date());
				mav.addObject("startTime", startTime.replace("-", "/"));
				mav.addObject("endTime", endTime.replace("-", "/"));
				mav.addObject("dateTime", dateTime.replace("-", "/"));
			}
			
			
			mav.addObject("ID", ID);
			mav.addObject("sessionid", sessionid);
			mav.addObject("userId", userId);
			
			//获取用户活动排名
			Map paramMap = new HashMap();
			paramMap.put("actId", ID);
			paramMap.put("userId", userId);
			int rank = 0;
			boolean flag=false;
			
			//判断活动类型提取参数
			if(activity.getTypeId()==2){
				BusinessActivityRegistrationTimeslotQuery BusinessActivityRegistrationTimeslotQuery = new BusinessActivityRegistrationTimeslotQuery();
				BusinessActivityRegistrationTimeslotQuery.setActId(ID);
				List<BusinessActivityRegistrationTimeslot> list = businessActivityRegistrationTimeslotService.findByExample(BusinessActivityRegistrationTimeslotQuery);
				int i =0;
				for (BusinessActivityRegistrationTimeslot businessActivityRegistrationTimeslot : list) {
					BusinessActivityRegistrationInformationQuery businessActivityRegistrationInformationQuery = new BusinessActivityRegistrationInformationQuery();
					businessActivityRegistrationInformationQuery.setActId(ID);
					businessActivityRegistrationInformationQuery.setTimeSlotId(businessActivityRegistrationTimeslot.getTimeSlotId());
					int count = businessActivityRegistrationInformationService.selectCount(businessActivityRegistrationInformationQuery);
					businessActivityRegistrationTimeslot.setCount(count);
					if(count>=businessActivityRegistrationTimeslot.getNumber()){
						i++;
					}
				}
				if(list.size()==i){
					flag=true;
				}
				
				mav.addObject("tel", request.getParameter("tel"));
				mav.addObject("list", list);
				mav.addObject("timeSlotId", list.get(0).getTimeSlotId());
				BusinessActivityRegistrationInformationQuery businessActivityRegistrationInformationQuery = new BusinessActivityRegistrationInformationQuery();
				businessActivityRegistrationInformationQuery.setActId(ID);
				businessActivityRegistrationInformationQuery.setUserId(new Integer(userId));
				List<BusinessActivityRegistrationInformation> BusinessActivityRegistrationInformationList = businessActivityRegistrationInformationService.findByExample(businessActivityRegistrationInformationQuery);
				
				if(BusinessActivityRegistrationInformationList.size()>0) {//已参与活动
					rank = 1;
					mav.addObject("partakeTimeSlotId", BusinessActivityRegistrationInformationList.get(0).getTimeSlotId());
				}
				
			}else if (activity.getTypeId()==3) {
				BusinessActivityVoteOptionsQuery businessActivityVoteOptionsQuery = new BusinessActivityVoteOptionsQuery();
				businessActivityVoteOptionsQuery.setActId(ID);
				//获取活动投票项
				List<BusinessActivityVoteOptions> list = businessActivityVoteOptionsService.findByExample(businessActivityVoteOptionsQuery);
				BusinessActivityVoteInformationQuery businessActivityVoteInformationQuery = new BusinessActivityVoteInformationQuery();
				businessActivityVoteInformationQuery.setActId(ID);
				businessActivityVoteInformationQuery.setUserId(new Integer(userId));
				//获取用户投票记录
				int count = businessActivityVoteInformationService.selectCount(businessActivityVoteInformationQuery);
				//判断是否参与活动
				if(count>0){
					rank = 1;
				}
				businessActivityVoteInformationQuery.setUserId(null);
				//获取总票数
				int numberVotes = businessActivityVoteInformationService.selectCount(businessActivityVoteInformationQuery);
				//获取活动参与总人数
				count = businessActivityVoteInformationService.selectCount_userId(businessActivityVoteInformationQuery);
				//分别统计活动投票项数量
				for (BusinessActivityVoteOptions businessActivityVoteOptions : list) {
					businessActivityVoteInformationQuery.setOptionsId(businessActivityVoteOptions.getOptionsId());
					int optCount = businessActivityVoteInformationService.selectCount(businessActivityVoteInformationQuery);
					businessActivityVoteOptions.setCount(optCount);
					businessActivityVoteOptions.setPercentage(weather.percentage(optCount,numberVotes));
				}
				mav.addObject("votes", activity.getVotes());
				mav.addObject("voteType", activity.getVoteType());
				mav.addObject("list", list);
				mav.addObject("count", count);
			}else {
				List<BusinessActivityParticipate> participateList = businessActivityParticipateService.findByMap(paramMap);
				if(participateList.size() > 0) {//已参与活动
					BusinessActivityParticipate businessActivityParticipate = participateList.get(0);
					rank = businessActivityParticipate.getRank();
				}
			}
			if (userId.equals("0")) {
				rank = 0;
			}
			mav.addObject("flag", flag);
			mav.addObject("rank", rank);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			Timestamp  ts=new Timestamp(new Date().getTime());
			AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			appStatisticsClick.setUserId(new Integer(userId));
			appStatisticsClick.setType(24);
			appStatisticsClick.setTypeName("社区活动详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	/**
	 * 用户查看社区活动的评论
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getActivitiesReviewById")
	public void getActivitiesReviewById(HttpServletRequest request, HttpServletResponse response, BusinessActivityCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp"); 
			String phpIp = p.getProperty("phpIp");  
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("commentTime");
			query.setActId(query.getID());
			BaseBean baseBean = businessActivityCommentService.findAllPage_app(query);
			BusinessActivity BusinessActivity = businessActivityService.findById(query.getID());
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"appPic\":\""+ip+BusinessActivity.getAppPic()+"\",";
			json += "\"title\":\""+BusinessActivity.getActName()+"\",";
			json += "\"url\":\""+phpIp+"/wxokjia/activity-info.php?ID="+query.getID()+"\",";
	
			json += "\"supports\":\""+BusinessActivity.getSupports()+"\",";
			json += "\"comments\":\""+BusinessActivity.getComments()+"\",";
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"reviewList\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessActivityComment  businessActivityComment= (BusinessActivityComment) baseBean.getList().get(i);
				json += "{\"userId\":\""+businessActivityComment.getCommentorId()+"\",";
				if(businessActivityComment.getCommentorState()==1){
					json +="\"avatar\":\""+ip+businessActivityComment.getAvatar()+"\",\"name\":\""
							+businessActivityComment.getBuNickname()+"\",";
				}else{
					json +="\"avatar\":\""+ip+businessActivityComment.getPortrait()+"\",\"name\":\""
							+businessActivityComment.getNickname()+"\",";
				}
				json +="\"commentTime\":\""+DateUtil.getInterval(businessActivityComment.getCommentTime())+"\",";
					json += "\"replyName\":\""+businessActivityComment.getReplyName()+"\",";
					json += "\"replyId\":\""+businessActivityComment.getReplyId()+"\",";
					json += "\"content\":\""+businessActivityComment.getContent()+"\",";
					if(businessActivityComment.getCommentorState()==1){
						json +="\"userType\":\"1\",";
					}else{
						json +="\"userType\":\"0\",";
					}
					if(businessActivityComment.getReplyState()==1){
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
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户查看社区活动回复我的评论
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getActivitiesReviewByUserId")
	public void getActivitiesReviewByUserId(HttpServletRequest request, HttpServletResponse response, BusinessActivityCommentQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			String phpIp = p.getProperty("phpIp");  
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("commentTime");
			query.setActId(query.getID());
			query.setCommentorState(0);
			query.setReplyState(0);
			BaseBean baseBean = businessActivityCommentService.findAllPage_app(query);
			BusinessActivity BusinessActivity = businessActivityService.findById(query.getID());
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTypeId(8);
			appLatestNews.setTo(0);
			appLatestNews.setSourceId(query.getID());
			appLatestNewsService.delete_app_id(appLatestNews);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"appPic\":\""+ip+BusinessActivity.getAppPic()+"\",";
			json += "\"title\":\""+BusinessActivity.getActName()+"\",";
			json += "\"url\":\""+phpIp+"/wxokjia/activity-info.php?ID="+query.getID()+"\",";
			
			json += "\"supports\":\""+BusinessActivity.getSupports()+"\",";
			json += "\"comments\":\""+BusinessActivity.getComments()+"\",";
			json += "\"PageState\":";
			if(baseBean.getCount()>query.getPage()*query.getRows()){
				json += "true,";
			}else{
				json += "false,";
			}
			json += "\"count\":\""+baseBean.getCount()+"\",";
			json += "\"reviewList\":[";
			for(int i=0;i<baseBean.getList().size();i++) {
				BusinessActivityComment  businessActivityComment= (BusinessActivityComment) baseBean.getList().get(i);
				json += "{\"userId\":\""+businessActivityComment.getCommentorId()+"\",";
				if(businessActivityComment.getCommentorState()==1){
					json +="\"avatar\":\""+ip+businessActivityComment.getAvatar()+"\",\"name\":\""
							+businessActivityComment.getBuNickname()+"\",";
				}else{
					json +="\"avatar\":\""+ip+businessActivityComment.getPortrait()+"\",\"name\":\""
							+businessActivityComment.getNickname()+"\",";
				}
				json +="\"commentTime\":\""+DateUtil.getInterval(businessActivityComment.getCommentTime())+"\",";
					json += "\"replyName\":\""+businessActivityComment.getReplyName()+"\",";
					json += "\"replyId\":\""+businessActivityComment.getReplyId()+"\",";
					json += "\"content\":\""+businessActivityComment.getContent()+"\",";
					if(businessActivityComment.getCommentorState()==1){
						json +="\"userType\":\"1\",";
					}else{
						json +="\"userType\":\"0\",";
					}
					if(businessActivityComment.getReplyState()==1){
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
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户评论社区活动
	 * @param userId,sessionid,ID,content
	 * @return
	 * json
	 */
	@RequestMapping(value="saveActivitiesReview")
	public void saveActivitiesReview(HttpServletRequest request, HttpServletResponse response,BusinessActivityCommentQuery query) {
		String json = "";
		try{
			AppUser appuser =  appUserService.findById(query.getUserId());
			Timestamp  ts=new Timestamp(new Date().getTime());
			BusinessActivityComment businessActivityComment = new BusinessActivityComment();
			businessActivityComment.setCommentTime(ts);
			businessActivityComment.setActId(query.getID());
			businessActivityComment.setCommentorId(query.getUserId());
			businessActivityComment.setContent(SensitivewordFilter.replaceSensitiveWord(query.getContent(),1,"*"));
			businessActivityComment.setReplyId(query.getReplyId());
			businessActivityComment.setReplyName(query.getReplyName());
			businessActivityComment.setCommentorState(0);//居民
			businessActivityComment.setReplyState(0);
			if(null==query.getReplyId()){
				businessActivityComment.setReplyId(0);
			}
			if(null==query.getReplyName()){
				businessActivityComment.setReplyName("");
			}
			businessActivityCommentService.save(businessActivityComment);
			BusinessActivity BusinessActivity = businessActivityService.findById(query.getID());
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"评论成功\",";
			json += "\"content\":{";
			//json += "\"comments\":\""+businessNews.getComments()+"\"";
			json += "\"commentId\":\""+businessActivityComment.getCommentId()+"\",";
			json += "\"content\":\""+businessActivityComment.getContent()+"\",";
			json += "\"commentTime\":\""+businessActivityComment.getCommentTime()+"\",";
			json += "\"replyId\":\""+businessActivityComment.getReplyId()+"\",";
			json += "\"replyName\":\""+businessActivityComment.getReplyName()+"\",";
			json += "\"comments\":\""+BusinessActivity.getComments()+"\",";
			json += "\"commentorId\":\""+businessActivityComment.getCommentorState()+"\"";
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
			response.getWriter().write(JsonUtils.stringToJson(json));
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
			appStatisticsClick.setType(26);
			appStatisticsClick.setTypeName("评论活动");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户回复社区活动
	 * @param userId,sessionid,ID,replyId,replyName,content
	 * @return
	 * json
	 */
	@RequestMapping(value="saveActivitiesReply")
	public void saveActivitiesReply(HttpServletRequest request, HttpServletResponse response,BusinessActivityCommentQuery query) {
		String json = "";
		try{
			AppUser appuser =  appUserService.findById(query.getUserId());
			Timestamp  ts = new Timestamp(new Date().getTime());
			BusinessActivityComment businessActivityComment = new BusinessActivityComment();
			businessActivityComment.setCommentTime(ts);
			businessActivityComment.setActId(query.getID());
			businessActivityComment.setCommentorId(query.getUserId());
			businessActivityComment.setContent(SensitivewordFilter.replaceSensitiveWord(query.getContent(),1,"*"));
			businessActivityComment.setReplyId(query.getReplyId());
			businessActivityComment.setReplyName(query.getReplyName());
			businessActivityComment.setCommentorState(0);//居民
			businessActivityComment.setReplyState(query.getReplyType());
			if(null==query.getReplyId()){
				businessActivityComment.setReplyId(0);
			}
			if(null==query.getReplyName()){
				businessActivityComment.setReplyName("");
			}
			businessActivityCommentService.save(businessActivityComment);
			BusinessActivity BusinessActivity = businessActivityService.findById(query.getID());
			if(!(businessActivityComment.getReplyState()==1)){
				AppUserNews appUserNews = new AppUserNews();
				appUserNews.setUserId(query.getReplyId());
				appUserNews.setCreateTime(ts);
				appUserNews.setNewTitle(BusinessActivity.getActName());
				appUserNews.setType(1);
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
			}
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"评论成功\",";
			json += "\"content\":{";
			//json += "\"comments\":\""+businessNews.getComments()+"\"";
			json += "\"commentId\":\""+businessActivityComment.getCommentId()+"\",";
			json += "\"content\":\""+businessActivityComment.getContent()+"\",";
			json += "\"commentTime\":\""+businessActivityComment.getCommentTime()+"\",";
			json += "\"replyId\":\""+businessActivityComment.getReplyId()+"\",";
			json += "\"replyName\":\""+businessActivityComment.getReplyName()+"\",";
			json += "\"comments\":\""+BusinessActivity.getComments()+"\",";
			json += "\"commentorId\":\""+businessActivityComment.getCommentorState()+"\"";
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
			response.getWriter().write(JsonUtils.stringToJson(json));
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
			appStatisticsClick.setType(27);
			appStatisticsClick.setTypeName("回复活动");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户点赞社区活动
	 * @param userId,sessionid,ID
	 * @return
	 * json
	 */
	@RequestMapping(value="supportActivities")
	public void supportActivities(HttpServletRequest request, HttpServletResponse response,BusinessActivitySupportQuery query) {
		String json = "";
		try{
			query.setActId(query.getID());
			int count =businessActivitySupportService.selectCount(query);
			if(count==0 || query.getUserId()==0){
				BusinessActivitySupport businessActivitySupport = new BusinessActivitySupport();
				businessActivitySupport.setUserId(query.getUserId());
				businessActivitySupport.setActId(query.getID());
				Timestamp  ts=new Timestamp(new Date().getTime());
				businessActivitySupport.setCreateTime(ts);
				businessActivitySupportService.save(businessActivitySupport);
				//活动点赞数量增1
				BusinessActivity businessActivity = businessActivityService.findById_app(query.getID());
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"点赞成功\",";
				json += "\"content\":{";
				json += "\"supports\":\""+businessActivity.getSupports()+"\"";
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
			json ="";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"已赞过了，再赞他会骄傲的…\"";
			json += "}";
			e.printStackTrace();
		}	
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
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
			appStatisticsClick.setType(25);
			appStatisticsClick.setTypeName("点赞活动详情");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户获取活动排名
	 * @param comId
	 * @return
	 * json
	 */
	@RequestMapping(value="ranking")
	public ModelAndView ranking(HttpServletRequest request, HttpServletResponse response,BusinessActivityParticipateQuery query) {
		Map<String,Object> map = new HashMap<String,Object>();
		ModelAndView mav = new ModelAndView("/service/activityRanking");
		query.setActId(query.getID());
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		try{
			map=businessActivityParticipateService.ranking(query);
			AppUser appUser = appUserService.findById(query.getUserId());
			String protrait = ip+appUser.getPortrait();
//			for (BusinessActivityParticipateQuery businessActivityParticipateQuery : list) {
//				json += "{\"ID\":\""+businessActivityParticipateQuery.getUserId()+"\",\"name\":\""+businessActivityParticipateQuery.getUserName()+"\",";
//				json += "\"ranking\":\""+businessActivityParticipateQuery.getRank()+"\",";
//				if(businessActivityParticipateQuery.getUserId().equals(query.getUserId())){
//					json += "\"type\":\"0\",\"portrait\":\""+appUser.getPortrait()+"\"},";
//				}else{
//					json += "\"type\":\"1\"},";
//				}
//			
//			}
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
			mav.addObject("ctx", ctx);
			mav.addObject("userId", appUser.getUserId());
			mav.addObject("nickname", appUser.getNickname());
			mav.addObject("protrait", protrait);
			mav.addObject("list", map.get("list"));
			mav.addObject("ranks", query.getRanks());
			mav.addObject("businessActivityParticipate", map.get("businessActivityParticipate"));
		}catch(Exception e){
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
			appStatisticsClick.setType(28);
			appStatisticsClick.setTypeName("获取活动排名");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;	
	}
	
	/**
	 * 用户参与活动
	 * @param comId
	 * @return
	 * json
	 */
	@RequestMapping(value="participateActivites")
	public synchronized  void participateActivites(HttpServletRequest request, HttpServletResponse response,BusinessActivityParticipateQuery query) {
		List<BusinessActivityParticipateQuery> list;
		String json = "";
		if(query.getUserId()==null){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"用户错误\"";
			json += "}";
		}else{
			//query.setActId(query.getID());
			try{
				query.setActId(query.getID());
				int count = businessActivityParticipateService.selectCount(query);
				if(count==0){
					//保存参与信息
					BusinessActivityParticipate businessActivityParticipate = new BusinessActivityParticipate();
					businessActivityParticipate.setActId(query.getID());
					businessActivityParticipate.setUserId(query.getUserId());
					businessActivityParticipate.setJoinTime(new Timestamp(System.currentTimeMillis()));
					businessActivityParticipate.setIsAward(0);
					businessActivityParticipate.setRank(0);
					businessActivityParticipate.setCreateTime(new Timestamp(System.currentTimeMillis()));
					businessActivityParticipate.setEditTime(new Timestamp(System.currentTimeMillis()));
					businessActivityParticipateService.save(businessActivityParticipate);

					//计算排名
					Map paramMap = new HashMap();
					paramMap.put("actId", query.getID());
					List<BusinessActivityParticipate> participateList = businessActivityParticipateService.findByMap(paramMap);
					int rank = 0;
					for(int i=0;i<participateList.size();i++) {
						businessActivityParticipate =  (BusinessActivityParticipate) participateList.get(i);
						if(query.getUserId().equals(businessActivityParticipate.getUserId())) {
							businessActivityParticipate.setRank(i+1);
							businessActivityParticipateService.update(businessActivityParticipate);
							rank = i + 1;
							break;
						}
					}
					json += "{";
					json += "\"errorCode\":\"200\",";
					json += "\"message\":\"参与成功\",";
					json += "\"content\":{";
					json += "\"rank\":"+rank;
					json += "}";
					json += "}";
				}else {
					json = "";
					json += "{";
					json += "\"errorCode\":\"400\",";
					json += "\"message\":\"您已经参与活动！不能重复参与！\"";
					json += "}";
				}
				
			}catch(Exception e){
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"参与失败\"";
				json += "}";
				e.printStackTrace();
			}
		}
		
		
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转至报名表单页
	 * @param tel,userId,actId,timeSlotId
	 * @return
	 * json
	 */
	@RequestMapping(value="registrationIndex")
	public ModelAndView registrationIndex(HttpServletRequest request, HttpServletResponse response,BusinessActivityQuery query) {
		Map<String,Object> map = new HashMap<String,Object>();
		ModelAndView mav = new ModelAndView("/service/registrationIndex");
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		try{
			//获取活动信息
			BusinessActivity activity = businessActivityService.findById_app(query.getID());
			BusinessActivityRegistrationTimeslot businessActivityRegistrationTimeslot = businessActivityRegistrationTimeslotService.findById(query.getTimeSlotId());
			String[] AttributeValues = activity.getAttributeValues().split(",");
			AppUser appUser = appUserService.findById(query.getUserId());
			String protrait = ip+appUser.getPortrait();
//			for (BusinessActivityParticipateQuery businessActivityParticipateQuery : list) {
//				json += "{\"ID\":\""+businessActivityParticipateQuery.getUserId()+"\",\"name\":\""+businessActivityParticipateQuery.getUserName()+"\",";
//				json += "\"ranking\":\""+businessActivityParticipateQuery.getRank()+"\",";
//				if(businessActivityParticipateQuery.getUserId().equals(query.getUserId())){
//					json += "\"type\":\"0\",\"portrait\":\""+appUser.getPortrait()+"\"},";
//				}else{
//					json += "\"type\":\"1\"},";
//				}
//			
//			}
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
			mav.addObject("ctx", ctx);
			mav.addObject("title", activity.getActName());
			mav.addObject("time", businessActivityRegistrationTimeslot.getTimeSlotName());
			mav.addObject("userId", appUser.getUserId());
			mav.addObject("nickname", appUser.getNickname());
			mav.addObject("realname", appUser.getRealname());
			mav.addObject("tel", query.getTel());
			mav.addObject("protrait", protrait);
			mav.addObject("ID", query.getID());
			mav.addObject("timeSlotId", query.getTimeSlotId());
			mav.addObject("AttributeValues", AttributeValues);
		}catch(Exception e){
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
			appStatisticsClick.setType(28);
			appStatisticsClick.setTypeName("获取活动排名");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;	
	}
	
	/**
	 * 跳转至查看我的报名信息页
	 * @param tel,userId,actId,timeSlotId
	 * @return
	 * json
	 */
	@RequestMapping(value="registrationInformation")
	public ModelAndView registrationInformation(HttpServletRequest request, HttpServletResponse response,BusinessActivityRegistrationInformationQuery query) {
		Map<String,Object> map = new HashMap<String,Object>();
		ModelAndView mav = new ModelAndView("/service/registrationInformation");
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		try{
			//获取活动信息
			BusinessActivityRegistrationTimeslot businessActivityRegistrationTimeslot = businessActivityRegistrationTimeslotService.findById(query.getTimeSlotId());
			BusinessActivityRegistrationInformationQuery businessActivityRegistrationInformationQuery = new BusinessActivityRegistrationInformationQuery();
			businessActivityRegistrationInformationQuery.setActId(new Integer(query.getID()));
			businessActivityRegistrationInformationQuery.setUserId(query.getUserId());
			List<BusinessActivityRegistrationInformation> list = businessActivityRegistrationInformationService.findByExample(businessActivityRegistrationInformationQuery);
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
			mav.addObject("ctx", ctx);
			mav.addObject("time", businessActivityRegistrationTimeslot.getTimeSlotName());
			mav.addObject("list", list);
		}catch(Exception e){
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
			appStatisticsClick.setType(28);
			appStatisticsClick.setTypeName("获取活动排名");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;	
	}
	
	/**
	 * 跳转至领取优惠信息页
	 * @param tel,userId,actId,timeSlotId
	 * @return
	 * json
	 */
	@RequestMapping(value="receiveCouponPage")
	public ModelAndView receiveCouponPage(HttpServletRequest request, HttpServletResponse response,BusinessActivityQuery query) {
		Map<String,Object> map = new HashMap<String,Object>();
		ModelAndView mav = new ModelAndView("/service/receiveCoupon");
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		try{
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
			mav.addObject("ctx", ctx);
			mav.addObject("userId", query.getUserId());
			mav.addObject("actId", query.getID());
		}catch(Exception e){
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
			appStatisticsClick.setType(28);
			appStatisticsClick.setTypeName("领取优惠券");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;	
	}
	
	/**
	 * 用户参与活动
	 * @param comId
	 * @return
	 * json
	 */
	@RequestMapping(value="receiveCoupon")
	public synchronized  void receiveCoupon(HttpServletRequest request, HttpServletResponse response,BusinessActivityQuery query) {
		List<BusinessActivityCoupon> list;
		String json = "";
		if(query.getUserId()==null){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"用户错误\"";
			json += "}";
		}else{
			//query.setActId(query.getID());
			try{
				BusinessActivityCouponQuery businessActivityCouponQuery = new BusinessActivityCouponQuery();
				businessActivityCouponQuery.setActId(query.getActId());
				businessActivityCouponQuery.setState(0);
				//查看未领取优惠券数量
				int count = businessActivityCouponService.selectCount(businessActivityCouponQuery);
				//如果为空则提示抢完
				if(count!=0){
					businessActivityCouponQuery.setUserId(query.getUserId());
					businessActivityCouponQuery.setState(null);
					//查看用户是否领取过优惠券
					count = businessActivityCouponService.selectCount(businessActivityCouponQuery);
					//如果领取则提示不能重复参与
					if(count==0){
						businessActivityCouponQuery.setUserId(null);
						businessActivityCouponQuery.setState(0);
						//查找未领取优惠券
						list = businessActivityCouponService.findByExample(businessActivityCouponQuery);
						BusinessActivity activity = businessActivityService.findById_app(query.getActId());
						Timestamp  ts=new Timestamp(new Date().getTime());
						BusinessActivityCoupon businessActivityCoupon = new BusinessActivityCoupon();
						businessActivityCoupon.setCouponId(list.get(0).getCouponId());
						businessActivityCoupon.setState(1);
						businessActivityCoupon.setUserId(query.getUserId());
						businessActivityCoupon.setCellphone(query.getCellphone());
						businessActivityCoupon.setEditTime(ts);
						//修改优惠券状态
						businessActivityCouponService.update(businessActivityCoupon);
						
						//发送短信
						String str="恭喜！您成功领取了（"+activity.getCouponName()+"），使用验证码为："+list.get(0).getCouponCode()+"，请妥善保存，并于"+activity.getCouponValid()+"期间内使用。【OK家】";
						String returnMessage = messagesUtil.returnMessageRrid(query.getCellphone(), str);
						manageSendMsgService.save(query.getCellphone(),returnMessage,str,1);
						
						json += "{";
						json += "\"errorCode\":\"200\",";
						json += "\"message\":\"参与成功\"";
						json += "}";
					}else {
						json = "";
						json += "{";
						json += "\"errorCode\":\"400\",";
						json += "\"message\":\"您已经参与活动！不能重复参与！\"";
						json += "}";
					}
					
				}else {
					json = "";
					json += "{";
					json += "\"errorCode\":\"400\",";
					json += "\"message\":\"抱歉！您下手慢了，优惠券已经被别人抢光了。\"";
					json += "}";
				}
				
				
			}catch(Exception e){
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"参与失败\"";
				json += "}";
				e.printStackTrace();
			}
		}
		
		
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户参与活动
	 * @param comId
	 * @return
	 * json
	 */
	@RequestMapping(value="signInQNH")
	public synchronized  void signInQNH(HttpServletRequest request, HttpServletResponse response,BusinessActivityQuery query) {
		String json = "";
		try{
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"签到成功\",";
			json += "\"content\":{\"count\":\"1\"}";
			json += "}";
			
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"参与失败\"";
			json += "}";
			e.printStackTrace();
		}
		
		
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 跳转至报名表单页
	 * @param tel,userId,actId,timeSlotId
	 * @return
	 * json
	 */
	@RequestMapping(value="qnhRegistrationIndex")
	public ModelAndView qnhRegistrationIndex(HttpServletRequest request, HttpServletResponse response,BusinessActivityQuery query) {
		Map<String,Object> map = new HashMap<String,Object>();
		ModelAndView mav = new ModelAndView("/service/qnhRegistrationIndex");
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		try{
			//获取活动信息
			BusinessActivity activity = businessActivityService.findById_app(query.getID());
			AppUser appUser = appUserService.findById(query.getUserId());
			String protrait = ip+appUser.getPortrait();
//			for (BusinessActivityParticipateQuery businessActivityParticipateQuery : list) {
//				json += "{\"ID\":\""+businessActivityParticipateQuery.getUserId()+"\",\"name\":\""+businessActivityParticipateQuery.getUserName()+"\",";
//				json += "\"ranking\":\""+businessActivityParticipateQuery.getRank()+"\",";
//				if(businessActivityParticipateQuery.getUserId().equals(query.getUserId())){
//					json += "\"type\":\"0\",\"portrait\":\""+appUser.getPortrait()+"\"},";
//				}else{
//					json += "\"type\":\"1\"},";
//				}
//			
//			}
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
			mav.addObject("ctx", ctx);
			mav.addObject("title", activity.getActName());
			mav.addObject("time", activity.getPublishTime());
			mav.addObject("userId", appUser.getUserId());
			mav.addObject("nickname", appUser.getNickname());
			mav.addObject("realname", appUser.getRealname());
			mav.addObject("tel", query.getTel());
			mav.addObject("protrait", protrait);
			mav.addObject("ID", query.getID());
			mav.addObject("timeSlotId", query.getTimeSlotId());
		}catch(Exception e){
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
			appStatisticsClick.setType(28);
			appStatisticsClick.setTypeName("获取活动排名");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;	
	}
	
	/**
	 * 用户参与活动
	 * @param comId
	 * @return
	 * json
	 */
	@RequestMapping(value="savebusinessActivityQnhInformation")
	public synchronized  void savebusinessActivityQnhInformation(HttpServletRequest request, HttpServletResponse response,BusinessActivityQuery query) {
		String json = "";
		if(query.getUserId()==null){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"用户错误\"";
			json += "}";
		}else{
			//query.setActId(query.getID());
			try{
				BusinessActivityQnhInformationQuery businessActivityQnhInformationQuery = new BusinessActivityQnhInformationQuery();
				businessActivityQnhInformationQuery.setActId(query.getActId());
				businessActivityQnhInformationQuery.setUserId(query.getUserId());
				List<BusinessActivityQnhInformation> BusinessActivityQnhInformationList = businessActivityQnhInformationService.findByExample(businessActivityQnhInformationQuery);
				
				if(BusinessActivityQnhInformationList.size()>0) {//已参与活动
					json = "";
					json += "{";
					json += "\"errorCode\":\"400\",";
					json += "\"message\":\"您已经参与活动！不能重复参与！\"";
					json += "}";
				}else {
					Timestamp  ts=new Timestamp(new Date().getTime());
					BusinessActivityQnhInformation businessActivityQnhInformation = new BusinessActivityQnhInformation();
					businessActivityQnhInformation.setActId(query.getActId());
					businessActivityQnhInformation.setUserId(query.getUserId());
					businessActivityQnhInformation.setState(0);
					businessActivityQnhInformation.setRealname(query.getRealname());
					businessActivityQnhInformation.setCreateTime(ts);
					businessActivityQnhInformation.setEditTime(ts);
					businessActivityQnhInformation.setEditor("");
					businessActivityQnhInformationService.save(businessActivityQnhInformation);
					json += "{";
					json += "\"errorCode\":\"200\",";
					json += "\"message\":\"参与成功\"";
					json += "}";
				}
			}catch(Exception e){
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"参与失败\"";
				json += "}";
				e.printStackTrace();
			}
		}
		
		
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
