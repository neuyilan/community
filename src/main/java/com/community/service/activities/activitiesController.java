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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
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
import com.community.app.module.bean.BusinessActReg;
import com.community.app.module.bean.BusinessActivity;
import com.community.app.module.bean.BusinessActivityComment;
import com.community.app.module.bean.BusinessActivityCoupon;
import com.community.app.module.bean.BusinessActivityParticipate;
import com.community.app.module.bean.BusinessActivityQnhInformation;
import com.community.app.module.bean.BusinessActivityRegistrationInformation;
import com.community.app.module.bean.BusinessActivityRegistrationTimeslot;
import com.community.app.module.bean.BusinessActivitySupport;
import com.community.app.module.bean.BusinessActivityVoteOptions;
import com.community.app.module.bean.BusinessPrize;
import com.community.app.module.bean.BusinessRegPic;
import com.community.app.module.bean.BusinessSponsor;
import com.community.app.module.bean.BusinessUser;
import com.community.app.module.bean.BusinessVote;
import com.community.app.module.bean.ManageEstate;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppStatisticsClickService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.BusinessActRegService;
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
import com.community.app.module.service.BusinessPrizeService;
import com.community.app.module.service.BusinessRegPicService;
import com.community.app.module.service.BusinessSponsorService;
import com.community.app.module.service.BusinessUserService;
import com.community.app.module.service.BusinessVoteService;
import com.community.app.module.service.ManageEstateService;
import com.community.app.module.service.ManageSendMsgService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActRegQuery;
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
import com.community.app.module.vo.BusinessSponsorQuery;
import com.community.framework.utils.CommonData;
import com.community.framework.utils.DateUtil;
import com.community.framework.utils.JsonUtils;
import com.community.framework.utils.messagesUtil;
import com.community.framework.utils.propertiesUtil;
import com.community.framework.utils.weather;
import com.community.framework.utils.testfilter.src.com.gao.SensitivewordFilter;
import com.community.ws.QNH.QNHIFClient.InActivitiesOnCli;
import com.community.ws.QNH.QNHIFClient.OnlineCheckInCli;


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
	@Autowired
	private BusinessPrizeService businessPrizeService;
	@Autowired
	private BusinessSponsorService businessSponsorService;
	@Autowired
	private BusinessActRegService businessActRegService;
	@Autowired
	private BusinessRegPicService businessRegPicService;
	@Autowired
	private BusinessVoteService businessVoteService; 
	@Autowired
	private BusinessUserService businessUserService;
	
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
				if("".equals(businessActivity.getActPic()) || businessActivity.getActPic()==null  || businessActivity.getActPic().indexOf("/images/icon/")>=0){
					json +="\"pic\":\"\",";
				}else{
					json +="\"pic\":\""+ip+businessActivity.getActPic()+"\",";
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
				if (businessActivity.getIsQNH()!=null && businessActivity.getIsQNH()==0) {
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
				if("".equals(businessActivity.getActPic()) || businessActivity.getActPic()==null  || businessActivity.getActPic().indexOf("/images/icon/")>=0){
					json +="\"pic\":\"\",";
				}else{
					json +="\"pic\":\""+ip+businessActivity.getActPic()+"\",";
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
				if (businessActivity.getIsQNH()!=null && businessActivity.getIsQNH()==0) {
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
		String activityIp = p.getProperty("activityIp");
		
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
			if (activity.getTypeId()!=6) {
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
				mav.addObject("activityIp", activityIp);
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
						if (BusinessActivityQnhInformationList.get(0).getState()==1) {
							rank=2;
						}
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
				
			}else {
				mav = new ModelAndView("redirect:"+phpIp+"/wxokjia/Activities_vote_info.php");
				mav.addObject("userId", request.getParameter("userId"));
				mav.addObject("sessionid", request.getParameter("sessionid"));
				mav.addObject("ID", request.getParameter("ID"));
				mav.addObject("tel", request.getParameter("tel"));
				mav.addObject("isphp", request.getParameter("isphp"));
			}
			
			
			
			
			
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
			String jsoncallback = request.getParameter("jsoncallback");
			response.getWriter().write(jsoncallback +"("+JsonUtils.stringToJson(json)+")");
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
		String activityIp = p.getProperty("activityIp");
		try{
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
			mav.addObject("ctx", ctx);
			mav.addObject("activityIp", activityIp);
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
						//参与人增加
						businessActivityService.addParticipants(query);
						
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
			String jsoncallback = request.getParameter("jsoncallback");
			response.getWriter().write(jsoncallback +"("+JsonUtils.stringToJson(json)+")");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户签到
	 * @param comId
	 * @return
	 * json
	 */
	@RequestMapping(value="signInQNH")
	public synchronized  void signInQNH(HttpServletRequest request, HttpServletResponse response,BusinessActivityQnhInformationQuery query) {
		BusinessActivityQuery businessActivityQuery = new BusinessActivityQuery();
		List<BusinessActivity> businessActivityList= null;
		String json = "";
		boolean flag = false;
		List<BusinessActivityQnhInformation> BusinessActivityQnhInformationList= null;
		try{
			
			businessActivityQuery.setQNHActId(query.getID());
			businessActivityList= businessActivityService.findByExample(businessActivityQuery);
			
			BusinessActivityQnhInformationQuery businessActivityQnhInformationQuery= new BusinessActivityQnhInformationQuery ();
			businessActivityQnhInformationQuery.setActId(businessActivityList.get(0).getActId());
			businessActivityQnhInformationQuery.setUserId(query.getUserId());
			BusinessActivityQnhInformationList = businessActivityQnhInformationService.findByExample(businessActivityQnhInformationQuery);
			if(BusinessActivityQnhInformationList.size()>0) {//已参与活动
				if (BusinessActivityQnhInformationList.get(0).getState()==1) {
					json = "";
					json += "{";
					json += "\"errorCode\":\"401\",";
					json += "\"message\":\"抱歉！您已经签到该活动！\"";
					json += "}";
				}else {
					BusinessActivityQnhInformation BusinessActivityQnhInformation = new BusinessActivityQnhInformation();
					BusinessActivityQnhInformation.setInformationId(BusinessActivityQnhInformationList.get(0).getInformationId());
					BusinessActivityQnhInformation.setState(1);
					businessActivityQnhInformationService.update(BusinessActivityQnhInformation);
					flag=true;
				}
				
			}else {
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"抱歉！您没有报名活动不能签到！\"";
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
		
		try {
			if(flag) {
				BusinessActivity activity = businessActivityService.findById_app(businessActivityList.get(0).getActId());
				OnlineCheckInCli onlineCheckInCli = new OnlineCheckInCli();
				String string =  onlineCheckInCli.signOnline(activity.getQNHActId(), BusinessActivityQnhInformationList.get(0).getTel());
				if (string!=null && !string.equals("")) {
					JSONObject jsn = JSONObject.fromObject(string);
					if (jsn.get("errorCode").toString().equals("200")) {
						JSONObject content= jsn.getJSONObject("content");
						String times= content.get("times").toString();
						String state= content.get("state").toString();
						json += "{";
						json += "\"errorCode\":\"200\",";
						json += "\"message\":\"签到成功\",";
						json += "\"content\":{\"count\":\""+times+"\"}";
						json += "}";
						if (state.toString().equals("1")) {
							AppUser appUser = appUserService.findById(query.getUserId());
							if (appUser.getIsQNH()==0) {
								AppUser appUser1 = new AppUser();
								appUser1.setUserId(appUser.getUserId());
								appUser1.setIsQNH(1);
								appUserService.update(appUser1);
							}
						}
					}else {
						json += "{";
						json += "\"errorCode\":\"200\",";
						json += "\"message\":\"签到成功\",";
						json += "\"content\":{\"count\":\"1\"}";
						json += "}";
					}
				}else {
					json += "{";
					json += "\"errorCode\":\"200\",";
					json += "\"message\":\"签到成功\",";
					json += "\"content\":{\"count\":\"1\"}";
					json += "}";
				}
				
				
			}
		} catch (Exception e) {
			// 判断青年汇错误
			GSLogger.error("青年汇活动报名错误", e);
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"参与失败\"";
			json += "}";
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
			mav.addObject("time", activity.getTimeslot());
			mav.addObject("userId", appUser.getUserId());
			mav.addObject("nickname", appUser.getNickname());
			mav.addObject("realname", appUser.getRealname());
			mav.addObject("tel", query.getTel());
			mav.addObject("protrait", protrait);
			mav.addObject("ID", query.getID());
			mav.addObject("timeSlotId", activity.getTimeslot());
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
		List<BusinessActivityQnhInformation> BusinessActivityQnhInformationList= null;
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
				BusinessActivityQnhInformationList = businessActivityQnhInformationService.findByExample(businessActivityQnhInformationQuery);
				
				if(BusinessActivityQnhInformationList.size()>0) {//已参与活动
					json = "";
					json += "{";
					json += "\"errorCode\":\"400\",";
					json += "\"message\":\"您已报名活动！不能重复报名！\"";
					json += "}";
				}else {
					businessActivityQnhInformationQuery.setUserId(null);
					businessActivityQnhInformationQuery.setTel(query.getTel());
					BusinessActivityQnhInformationList = businessActivityQnhInformationService.findByExample(businessActivityQnhInformationQuery);
					if(BusinessActivityQnhInformationList.size()>0){
						json = "";
						json += "{";
						json += "\"errorCode\":\"400\",";
						json += "\"message\":\"您输入的手机号已报名活动！不能重复报名！\"";
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
						businessActivityQnhInformation.setTel(query.getTel());
						businessActivityQnhInformationService.save(businessActivityQnhInformation);
						
						//参与人增加
						businessActivityService.addParticipants(query);
						
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
						
						json += "{";
						json += "\"errorCode\":\"200\",";
						json += "\"message\":\"参与成功\"";
						json += "}";
					}
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
		
		try {
			if(BusinessActivityQnhInformationList.size()==0){
				BusinessActivity activity = businessActivityService.findById_app(query.getActId());
				InActivitiesOnCli inActivitiesOnCli = new InActivitiesOnCli();
				inActivitiesOnCli.regOnLine(activity.getQNHActId(), query.getTel());
			}
			
		} catch (Exception e) {
			// 判断青年汇错误
			GSLogger.error("青年汇活动报名错误", e);
		}
	}
	
	/**
	 * 获取活动详情
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getActivitiesDetails")
	public void getActivitiesDetails(HttpServletRequest request, HttpServletResponse response) {

		String json = "";
		String actId = request.getParameter("ID");
		if (StringUtils.isNotBlank(actId))
		{
			BusinessActivity activity = businessActivityService.findById(Integer.valueOf(request.getParameter("ID")));
			if (activity != null)
			{
				try{
			        Properties p = propertiesUtil.getProperties("config.properties");
					String ip = p.getProperty("imageIp");   
					int state = activity.getState();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					Date ts = (Date) sdf.parse(activity.getJptpTimeslotEndTime());
					if (state!=2 && ts.getTime() < new Date().getTime()) {
						state = 7;
					}
					json = new JSONObject().element("errorCode", "200").element("message", "获取成功").element("content", 
							new JSONObject()							
					         .element("actPic", ip + activity.getActPic())
							.element("actName", activity.getActName())
							.element("startTime", activity.getStartTime())
							.element("endTime", activity.getEndTime())
							.element("actContent", activity.getActContent())
							.element("state", state)
							.element("registrationEndTime", activity.getEndTime())
							).toString();
//					json += "{";
//					json += "\"errorCode\":\"200\",";
//					json += "\"message\":\"获取成功\",";
//					json += "\"content\":{";
//					json += "\"actPic\":\"http://b.hiphotos.baidu.com/image/pic/item/d8f9d72a6059252d0d9b5d5b379b033b5ab5b9e5.jpg\",";
//					json += "\"actName\":\"社区美女\",";
//					json += "\"actName\":\"社区美女\",";
//					json += "\"startTime\":\"2014-1-1 00:00:00\",";
//					json += "\"endTime\":\"2014-1-2 12:00:00\",";
//					json += "\"actContent\":\"规则简介规则简介规则简介规则简介规则简介规则简介规则简介规则简介规则简介规则简介规则简介规则简介规则简介规则简介规则简介规则简介规则简介规则简介规则简介\",";
//					json += "\"state\":\"0\",";
//					json += "\"registrationEndTime\":\"2014-1-2 8:00:00\"";
//					json += "}";
//					json += "}";
				}catch(Exception e){
					json=new JSONObject().element("errorCode", "400").element("message", "获取失败").toString();
					e.printStackTrace();
				}
			}else
			{
				json=new JSONObject().element("errorCode", "400").element("message", "获取条数为空").toString();
			}
		}else
		{
			json=new JSONObject().element("errorCode", "400").element("message", "活动ID为空").toString();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取活动奖品接口
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getActivitiesPrizeList")
	public void getActivitiesPrizeList(HttpServletRequest request, HttpServletResponse response) {
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		String json = "";
		String actId = request.getParameter("ID");
		String psize = request.getParameter("psize");//0 全查  n查n条 (0 取活动 奖品规则)
		if(StringUtils.isNotBlank(actId) && StringUtils.isNotBlank(psize))
		{
				Map<String, Object> map = new HashMap<String, Object>();
				
				map.put("actId", Integer.valueOf(actId) );
				if (!"0".equals(psize))
					map.put("psize", Integer.valueOf(psize)); 
				List<BusinessPrize> prizeList = businessPrizeService.findByMap(map);
				if (CollectionUtils.isNotEmpty(prizeList))
				{
					BusinessActivity act = businessActivityService.findById(Integer.valueOf(actId));
					try{
						JSONObject jsn = new JSONObject()
						.element("errorCode", "200")
						.element("message", "获取成功");
						JSONArray jsnary = new JSONArray();
						for(BusinessPrize prize :prizeList)
							jsnary.element(new JSONObject()
							.element("prizeId", prize.getPrizeId())
							.element("awardsName", prize.getAwardName())
							.element("prizeImg", ip+prize.getPrizeImg())
							.element("prizeQuota", prize.getPrizeQuota())
							.element("prizeName", prize.getPrizeName())
							.element("prizeRanking", prize.getRankStart()+"-"+prize.getRankEnd())
							.element("prizeContent", prize.getPrizeContent()));
						jsn.element("content",new JSONObject().element("list", jsnary))
						.element("rule", act.getPrizeRules()).toString();
						json = jsn.toString();
					}catch(Exception e){
						json=new JSONObject().element("errorCode", "400").element("message", "获取失败").toString();
						e.printStackTrace();
					}
				}else
				{
					json=new JSONObject().element("errorCode", "400").element("message", "获取条数为空").toString();
				}
		}else
		{
			json=new JSONObject().element("errorCode", "400").element("message", "ID或psize为空").toString();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 获取活动奖品详情接口
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getActivitiesPrizeByPid")
	public void getActivitiesPrizeByPid(HttpServletRequest request, HttpServletResponse response) {
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		String json = "";
		String prizeId = request.getParameter("ID");
		if(StringUtils.isNotBlank(prizeId))
		{
			    BusinessPrize prize = businessPrizeService.findById(Integer.valueOf(prizeId));
				if (prize != null)
				{
					try{
						json = new JSONObject()
						.element("errorCode", "200")
						.element("message", "获取成功")
						.element("content", new JSONObject()
						.element("prizeId", prize.getPrizeId())
						.element("awardsName", prize.getAwardName())
						.element("prizeImg", ip+prize.getPrizeImg())
						.element("prizeQuota", prize.getPrizeQuota())
						.element("prizeName", prize.getPrizeName())
						.element("prizeRanking", prize.getRankStart()+"-"+prize.getRankEnd())
						.element("prizeContent", prize.getPrizeContent())).toString();
					}catch(Exception e){
						json=new JSONObject().element("errorCode", "400").element("message", "获取失败").toString();
						e.printStackTrace();
					}
				}else
					json=new JSONObject().element("errorCode", "400").element("message", "获取条数为空").toString();
		}else
			json=new JSONObject().element("errorCode", "400").element("message", "ID或psize为空").toString();
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
	 * 获取活动奖品详情接口
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="IWantSponsor")
	public void IWantSponsor(HttpServletRequest request, HttpServletResponse response, BusinessSponsorQuery query) {
		String json = "";
			try{
				BusinessSponsor sponsor = new BusinessSponsor();
				sponsor.setUserId(query.getUserId());
				sponsor.setActId(query.getActId());
				sponsor.setSponsorName(query.getSponsorName());
				sponsor.setSponsorPhone(query.getSponsorPhone());
				sponsor.setSponsorContent(query.getSponsorContent());
				System.out.println("==="+query.getSponsorContent());
				sponsor.setCreatTime(new Timestamp(new Date().getTime()));
				sponsor.setFlag(CommonData.GlobalData.RET_SUCCESS);
				businessSponsorService.save(sponsor);
				json=new JSONObject().element("errorCode", "200").element("message", "保存赞助信息成功").toString();
			}catch(Exception e){
				json=new JSONObject().element("errorCode", "400").element("message", "保存赞助信息失败").toString();
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
	 * 获取活动排名
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getActivitiesRanking")
	public void getActivitiesRanking(HttpServletRequest request, HttpServletResponse response,BusinessActRegQuery query ) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp"); 
			JSONArray jsnary = new JSONArray();
			int state = 1;//1没有报名2审核未通过3报名
			if (query.getRows() == null || query.getRows() == 0) 
				query.setRows(20);
			query.setActId(query.getID());
			
			List<BusinessActReg> userList = businessActRegService.findById_app(query);
			
			if (CollectionUtils.isNotEmpty(userList))
			{
				if (userList.get(0).getFlag() == 2 || userList.get(0).getFlag() == 1)
					state = 2;//2审核未通过
				else if (userList.get(0).getFlag() == 0)
					state = 3;//3通过报名
			}
			BusinessActReg regobj = null;
			if (query.getType()==3 && state == 3  && query.getPage() == 1) {
//				userList = businessActRegService.findById_app(query);
//				if (CollectionUtils.isNotEmpty(userList)){
//					if (userList.get(0).getFlag()==2) {
//						state = 2;
//					}else if (userList.get(0).getFlag()==0) {
						 regobj = userList.get(0);
						state = 3;
						jsnary.element(new JSONObject()
						.element("regId", regobj.getRegId())
						.element("nickname", regobj.getNickName())
						.element("estateName", regobj.getEstateName())
						.element("number", regobj.getVotes())
						.element("portrait", ip+regobj.getAvatar())
						.element("contestantNo", regobj.getCode() > 10 ? regobj.getCode() + "" : "0"+regobj.getCode()) // 编号 <10 补上0
						.element("no", regobj.getRank()));
			}	

			query.setUserId(null);
			query.setFlag(CommonData.GlobalData.RET_SUCCESS);
			BaseBean baseBean = businessActRegService.findRankPage(query);			
			JSONObject jsn = new JSONObject()
			.element("errorCode", "200")
			.element("message", "获取成功");
			List<BusinessActReg> list = (List<BusinessActReg>)baseBean.getList();
			
			for(BusinessActReg actReger :list)
			{
//				if(query.getType()==3 && list.size() == 1)
//					continue; //break; 没有下次
				if(query.getType()==3 && state == 3 && regobj !=null && actReger.getRegId() == regobj.getRegId())
					continue;
				jsnary.element(new JSONObject()
				.element("regId", actReger.getRegId())
				.element("nickname", actReger.getNickName())
				.element("estateName", actReger.getEstateName())
				.element("number", actReger.getVotes())
				.element("portrait", ip+actReger.getAvatar())
				.element("contestantNo", actReger.getCode() > 10 ? actReger.getCode() + "" : "0"+actReger.getCode()) // 编号 <10 补上0
				.element("no", actReger.getRank())); //
		}
			jsn.element("content",new JSONObject().element("state", state).element("PageState", baseBean.getCount()>query.getPage()*query.getRows() ? "true" : "false").element("list", jsnary));
			json = jsn.toString();
		}catch(Exception e){
			json=new JSONObject().element("errorCode", "400").element("message", "获取失败").toString();
			e.printStackTrace();
		}	
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取最新报名
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getLatestRegistration")
	public void getLatestRegistration(HttpServletRequest request, HttpServletResponse response,BusinessActRegQuery query ) {
		String json = "";
		try{
			query.setRows(20);
			BaseBean baseBean = businessActRegService.findLatestRegPage(query);
			
			JSONObject jsn = new JSONObject()
			.element("errorCode", "200")
			.element("message", "获取成功");
			
			JSONArray jsnary = new JSONArray();
			List<BusinessActReg> list = (List<BusinessActReg>)baseBean.getList();
			for(BusinessActReg actReger :list)
				jsnary.element(new JSONObject()
				.element("nickname", actReger.getNickName())
				.element("estateName", actReger.getEstateName())
				.element("number", actReger.getVotes())
				.element("portrait", actReger.getAvatar())
				.element("contestantNo", actReger.getCode() > 10 ? actReger.getCode() + "" : "0"+actReger.getCode()) // 编号 <10 补上0
				.element("no", actReger.getRank())); //
			
			jsn.element("content",new JSONObject().element("PageState", baseBean.getCount()>query.getPage()*query.getRows() ? "true" : "false").element("list", jsnary));
			json = jsn.toString();
			
		}catch(Exception e){
			json=new JSONObject().element("errorCode", "400").element("message", "获取失败").toString();
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
	 * 投票
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="castAVote")
	public void castAVote(HttpServletRequest request, HttpServletResponse response,BusinessActRegQuery query ) {
		String json = "";
		try{
			Map<String, Object> map = new HashMap<String, Object>();
//			map.put("actId", query.getID());
			map.put("userId", query.getUserId());
			map.put("regId", query.getRegId());
			List<BusinessVote> todayVote =  businessVoteService.findTodayVotesByMap(map);
			if(CollectionUtils.isEmpty(todayVote))
			{
				BusinessVote bv = new BusinessVote();
				bv.setRegId(query.getRegId());
				bv.setUserId(query.getUserId());
				bv.setVateTime(new Timestamp(new Date().getTime()));
				bv.setActId(query.getID());
				businessVoteService.save(bv);
				map.put("regId", query.getRegId());
				businessActRegService.updateVotes(map);
				json = new JSONObject().element("errorCode", "200").element("message", "投票成功").toString();
			}else
				json = new JSONObject().element("errorCode", "400").element("message", "今天已经投过票啦").toString();
		}catch(Exception e){
			json = new JSONObject().element("errorCode", "400").element("message", "投票失败").toString();
			e.printStackTrace();
		}	
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * 获取选手信息
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getActivitiesPlayerInfo")
	public void getActivitiesPlayerInfo(HttpServletRequest request, HttpServletResponse response, BusinessActRegQuery query ) {
		String json = "";
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp"); 
		try{
			query.setActId(query.getID());
			query.setUserId(null);
			List<BusinessActReg> actRegs = businessActRegService.findById_app(query);
			BusinessActivity activity = businessActivityService.findById_app(query.getID());
			if (CollectionUtils.isNotEmpty(actRegs))
			{
				BusinessActReg actReg = actRegs.get(0);
				
				JSONArray imgArry = new JSONArray();
				Map<String, Object> paramMap = new HashMap<String, Object>();
				paramMap.put("regId", actReg.getRegId());
				List<BusinessRegPic> picList = businessRegPicService.findByMap(paramMap);
				for(BusinessRegPic pic : picList)
					imgArry.element(new JSONObject().element("pic", ip+pic.getPicUrl()));

				json = new JSONObject().element("errorCode", "200")
						.element("message", "获取成功").element("content", 
					     new JSONObject()
						.element("regId", actReg.getRegId())
						.element("title", activity.getActName())
						.element("nickname", actReg.getNickName())
						.element("estateName", actReg.getEstateName())
						.element("number", actReg.getVotes())
						.element("portrait", ip+actReg.getAvatar())
						.element("contestantNo", actReg.getCode())
						.element("no", actReg.getRank())
						.element("brief", actReg.getContent())
						.element("Images",imgArry
								)).toString();
			}else
				json = new JSONObject().element("errorCode", "400").element("message", "获取失败").toString();
		}catch(Exception e){
			json = new JSONObject().element("errorCode", "400").element("message", "获取失败").toString();
			e.printStackTrace();
		}	
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取选手话术
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="getActivitiesPrompt")
	public void getActivitiesPrompt(HttpServletRequest request, HttpServletResponse response) {
		String json = "";
		String actId = request.getParameter("ID");
		try{
			BusinessActivity act = businessActivityService.findById(Integer.valueOf(actId));
			Map<String, Object> parm = new HashMap<String, Object>();
			parm.put("userId",request.getParameter("userId"));
			parm.put("actId", request.getParameter("ID"));
			int isReg = CommonData.GlobalData.RET_FAILURE; //1 已报名
			if ( CollectionUtils.isEmpty(businessActRegService.findByMap(parm)) )
				isReg = CommonData.GlobalData.RET_SUCCESS; //0 未报名
				
			json = new JSONObject()
			.element("errorCode", "200")
			.element("message", "获取成功")
			.element("content", new JSONObject()
			.element("prompt", CommonData.GlobalData.DEBUG_MODE ? "活动报名话术" : act.getActRegWords())
					.element("isReg", isReg)).toString();  //活动报名话术
		}catch(Exception e){
			json = new JSONObject()
			.element("errorCode", "400")
			.element("message", "获取失败").toString();
			e.printStackTrace();
		}	
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * 选手报名
	 * @param userId,sessionid,ID,page,rows
	 * @return
	 * json
	 */
	@RequestMapping(value="saveActivitiesRegistration")
	public void saveActivitiesRegistration(HttpServletRequest request, HttpServletResponse response, BusinessActRegQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   

			Map<String, Object> parm = new HashMap<String, Object>();
			
			parm.put("userId", query.getUserId());
			parm.put("actId", query.getActId());
			
			if ( CollectionUtils.isEmpty(businessActRegService.findByMap(parm)) )
			{
				AppUser bu =   appUserService.findById(new Integer(query.getUserId()));
				BusinessActReg actReg = new BusinessActReg();
				actReg.setUserId(query.getUserId());
				actReg.setActId(query.getActId());
				actReg.setEstateId(bu.getEstateId());
				actReg.setEstateName(bu.getEstateName());
				actReg.setContent(query.getContent());
				actReg.setNickName(CommonData.GlobalData.DEBUG_MODE ? "昵称" : bu.getNickname());
				actReg.setAvatar("");
				actReg.setRegTime(new Timestamp(new Date().getTime()));
				actReg.setFlag(CommonData.GlobalData.RET_VERIFY);
				actReg.setVotes(0);
				actReg.setCode(0);
				
				int regId =businessActRegService.save(actReg);
				
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("regId", actReg.getRegId());  
				map.put("actId", query.getActId());
				int cnt = businessActRegService.cntFront(map)+1;  // code = cnt+1
				map.put("code", cnt);
				//TODO 事务绑定
				businessActRegService.updateCode(map);
				
				/**图片数组*/
				String images = request.getParameter("Images");
				if (StringUtils.isNotBlank(images))
				{
					String[] imgArry = images.split(",");
					for(String img : imgArry)
					{ 
						BusinessRegPic regPic = new BusinessRegPic();
						regPic.setRegId(actReg.getRegId());
						regPic.setPicUrl(img.replace(ip, ""));
						businessRegPicService.save(regPic);
					}
				}
				json = new JSONObject().element("errorCode", "200").element("message", "报名成功").toString();
				BusinessActivityQuery businessActivityQuery = new BusinessActivityQuery();
				businessActivityQuery.setActId(query.getActId());
				//参与人增加
				businessActivityService.addParticipants(businessActivityQuery);
			}else
			{
				json = new JSONObject().element("errorCode", "400").element("message", "您已经参与活动报名！").toString();
			}
		}catch(Exception e){
			json = new JSONObject().element("errorCode", "400").element("message", "报名失败").toString();
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(JsonUtils.stringToJson(json));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
