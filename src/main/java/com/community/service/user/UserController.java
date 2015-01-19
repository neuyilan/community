package com.community.service.user;

/**
 * 用户相关处理接口
 * 包括：
 * 用户信息
 * 
 * @author zyp-2_000
 *
 */

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.community.app.module.bean.AppEstateUser;
import com.community.app.module.bean.AppHomepage;
import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.bean.AppPartyAddress;
import com.community.app.module.bean.AppStatisticsClick;
import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.AppUserCellphone;
import com.community.app.module.bean.AppUserConfig;
import com.community.app.module.bean.AppUserNews;
import com.community.app.module.bean.AppVerify;
import com.community.app.module.bean.BusinessActivity;
import com.community.app.module.bean.BusinessAnno;
import com.community.app.module.bean.BusinessChinmedichenacare;
import com.community.app.module.bean.BusinessExp;
import com.community.app.module.bean.BusinessFocus;
import com.community.app.module.bean.BusinessHealthydiet;
import com.community.app.module.bean.BusinessHelp;
import com.community.app.module.bean.BusinessNews;
import com.community.app.module.bean.BusinessProduct;
import com.community.app.module.bean.BusinessTel;
import com.community.app.module.bean.BusinessTelGroup;
import com.community.app.module.bean.MemberVO;
import com.community.app.module.service.AppEstateUserService;
import com.community.app.module.service.AppHomepageService;
import com.community.app.module.service.AppLatestNewsService;
import com.community.app.module.service.AppPartyAddressService;
import com.community.app.module.service.AppStatisticsClickService;
import com.community.app.module.service.AppUserCellphoneService;
import com.community.app.module.service.AppUserConfigService;
import com.community.app.module.service.AppUserNewsService;
import com.community.app.module.service.AppUserService;
import com.community.app.module.service.AppVerifyService;
import com.community.app.module.service.BusinessActivityService;
import com.community.app.module.service.BusinessAnnoService;
import com.community.app.module.service.BusinessChinmedichenacareService;
import com.community.app.module.service.BusinessExpService;
import com.community.app.module.service.BusinessFocusService;
import com.community.app.module.service.BusinessHealthydietService;
import com.community.app.module.service.BusinessHelpService;
import com.community.app.module.service.BusinessNewsService;
import com.community.app.module.service.BusinessProductService;
import com.community.app.module.service.BusinessTelGroupService;
import com.community.app.module.service.BusinessTelService;
import com.community.app.module.service.ManageSendMsgService;
import com.community.app.module.vo.AppEstateUserQuery;
import com.community.app.module.vo.AppHomepageQuery;
import com.community.app.module.vo.AppLatestNewsQuery;
import com.community.app.module.vo.AppPartyAddressQuery;
import com.community.app.module.vo.AppStatisticsClickQuery;
import com.community.app.module.vo.AppUserCellphoneQuery;
import com.community.app.module.vo.AppUserConfigQuery;
import com.community.app.module.vo.AppUserNewsQuery;
import com.community.app.module.vo.AppUserQuery;
import com.community.app.module.vo.AppVerifyQuery;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFocusQuery;
import com.community.app.module.vo.BusinessHelpQuery;
import com.community.app.module.vo.BusinessNewsQuery;
import com.community.app.module.vo.BusinessProductQuery;
import com.community.app.module.vo.BusinessTelGroupQuery;
import com.community.app.module.vo.BusinessTelQuery;
import com.community.framework.utils.DateUtil;
import com.community.framework.utils.StringUtil;
import com.community.framework.utils.messagesUtil;
import com.community.framework.utils.propertiesUtil;
import com.qq.connect.api.OpenID;
import com.qq.connect.api.qzone.UserInfo;
import com.qq.connect.javabeans.AccessToken;
import com.qq.connect.javabeans.qzone.UserInfoBean;
import com.qq.connect.oauth.Oauth;

@Controller
@RequestMapping("/service/user")
public class UserController {
	private static Logger GSLogger = LoggerFactory
			.getLogger(UserController.class);
	@Autowired
	private AppUserService appUserService;
	@Autowired
	private AppUserCellphoneService appUserCellphoneService;
	
	@Autowired
	private AppEstateUserService appEstateUserService;
	
	@Autowired
	private AppPartyAddressService appPartyAddressService;
	
	@Autowired
	private AppUserConfigService appUserConfigService;
	
	@Autowired
	private BusinessTelService businessTelService;
	
	@Autowired
	private BusinessTelGroupService businessTelGroupService;
	
	@Autowired
	private AppHomepageService appHomepageService;
	
	@Autowired
	private BusinessFocusService businessFocusService;
	
	@Autowired
	private AppUserNewsService appUserNewsService;
	
	@Autowired
	private AppLatestNewsService appLatestNewsService;
	
	@Autowired
	private AppStatisticsClickService appStatisticsClickService;
	
	@Autowired
	private BusinessNewsService businessNewsService;
	
	@Autowired
	private BusinessActivityService businessActivityService;
	
	@Autowired
	private BusinessAnnoService businessAnnoService;
	
	@Autowired
	private BusinessChinmedichenacareService businessChinmedichenacareService;
	
	@Autowired
	private BusinessHealthydietService businessHealthydietService;
	@Autowired
	private BusinessProductService businessProductService;
	
	@Autowired
	private BusinessHelpService businessHelpService;
	
	@Autowired
	private BusinessExpService businessExpService;
	
	@Autowired
	private AppVerifyService appVerifyService;
	
	@Autowired
	private ManageSendMsgService manageSendMsgService;
	
	
	
	
	
	
	/**
	 * 用户使用电话和密码快速注册
	 * 
	 * @param cellphone
	 *            ,password
	 * @return json
	 */
	@RequestMapping(value = "regist")
	public void regist(HttpServletRequest request,
			HttpServletResponse response, AppUserQuery query) {
		String openid = (String) request.getSession().getAttribute("openid");
		String QQopenid = (String) request.getSession().getAttribute("QQopenid");
		String nickname = (String) request.getSession().getAttribute("nickname");
		AppUser appUser = new AppUser();
		String json = "";
		boolean whetherRepeat = false;
		try {
			whetherRepeat = appUserService.whetherRepeat(query.getCellphone());
		} catch (Exception e) {
			GSLogger.error("验证tel是否重复", e);
			e.printStackTrace();
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"注册失败\"";
			json += "}";
		}
		if (whetherRepeat) {
			try {
				String uuid= UUID.randomUUID().toString();
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				String dateString = sf.format(new Date());
				String filedir = "app/image/" +dateString+"/"+uuid+".png";
				appUser.setPath(request.getSession().getServletContext().getRealPath("/").replace("\\", "/"));
				appUser.setFiledir(filedir);
				appUser.setPassword(query.getPassword());
				appUser.setTel(query.getCellphone());
				appUser.setEstateId(query.getEstateId());
				appUser.setType(0);
				appUser.setState(1);
				Timestamp ts = new Timestamp(new Date().getTime());
				appUser.setPortrait("/images/morentouxiang.png");
				appUser.setCreateTime(ts);
				appUser.setEditTime(ts);
				appUser.setLastLoginTime(ts);
				if (openid!=null) {
					appUser.setWenxinId(openid);
				} else {
					appUser.setWenxinId("");
				}
				if (QQopenid!=null) {
					appUser.setQqId(QQopenid);
				} else {
					appUser.setQqId("");
				}
				if (nickname!=null) {
					appUser.setNickname(nickname);
				} else {
					appUser.setNickname("");
				}
				appUserService.saveRegist(appUser);
				// 保存成功
				Properties p = propertiesUtil.getProperties("config.properties");
				String ip = p.getProperty("imageIp");   
				MemberVO MemberVO = appUserService.getAppUserLoginInfo(appUser);
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"登录成功\",";
				json += "\"content\":{";
				json += "\"sessionid\":\"42823AFB33\",";
				json += "\"userType\":\""+MemberVO.getType()+"\",";
				json += "\"isWorker\":\""+MemberVO.getIsWorker()+"\",";
				json += "\"userId\":\""+MemberVO.getUserId()+"\",";
				json += "\"portrait\":\""+ip+MemberVO.getPortrait()+"\",";
				json += "\"realname\":{\"realname\":\""+MemberVO.getRealname()+"\",\"state\":\"1\"},";
				json += "\"nickname\":\""+MemberVO.getNickname()+"\",";
				json += "\"signatrue\":\""+MemberVO.getSignature()+"\",";
				json += "\"tel\":\""+query.getCellphone()+"\",";
				json += "\"sex\":\""+MemberVO.getSex()+"\",";
				json += "\"birthday\":\"";
				if(MemberVO.getBirthday()!=null){
					json += new SimpleDateFormat("yyyy-MM-dd").format(MemberVO.getBirthday().getTime());
				}
				json += "\",";
				json += "\"twoCode\":\""+ip+MemberVO.getDimensionCode()+"\",";
				json += "\"informationState\":true,";
				json += "\"estateId\":\""+MemberVO.getEstateId()+"\",";
				json += "\"estateName\":\""+MemberVO.getEstateName()+"\",";
				json += "\"estateAttr\":\""+ip+MemberVO.getEstateMap()+"\",";
				if(MemberVO.getStaId()==null || MemberVO.getStaId().equals("")){
					json += "\"stationId\":\"0\",";
				}else {
					json += "\"stationId\":\""+MemberVO.getStaId()+"\",";
				}
				if(MemberVO.getStaName()==null){
					json += "\"staName\":\"\",";
				}else {
					json += "\"staName\":\""+MemberVO.getStaName()+"\",";
				}
				json += "\"comId\":\""+MemberVO.getComId()+"\",";
				json += "\"comName\":\""+MemberVO.getComName()+"\",";
				if(MemberVO.getProId()==null){
					json += "\"proId\":\"0\",";
				}else {
					json += "\"proId\":\""+MemberVO.getProId()+"\",";
				}
				if(MemberVO.getProName()==null){
					json += "\"proName\":\"\",";
				}else {
					json += "\"proName\":\""+MemberVO.getProName()+"\",";
				}
				if(MemberVO.getUnitId()!=null && !MemberVO.getUnitId().equals("0")){
					if (MemberVO.getUnitHomeAttr()!=null) {
						json += "\"homeAttr\":\""+ip+MemberVO.getUnitHomeAttr()+"\",";
					}else {
						json += "\"homeAttr\":\"\",";
					}
				}else {
					if (MemberVO.getHomeAttr()!=null) {
						json += "\"homeAttr\":\""+ip+MemberVO.getHomeAttr()+"\",";
					}else {
						json += "\"homeAttr\":\"\",";
					}
				}
				
				json += "\"familyId\":\""+MemberVO.getFamilyId()+"\",";
				json += "\"familyNumber\":\""+MemberVO.getMount()+"\",";
				json += "\"buildingId\":\""+MemberVO.getBuildingId()+"\",";
				json += "\"buildingName\":\""+MemberVO.getBuildingName()+"\",";
				json += "\"unitId\":\""+MemberVO.getUnitId()+"\",";
				json += "\"unitName\":\""+MemberVO.getUnitName()+"\",";
				json += "\"houseNo\":\""+MemberVO.getHouseNo()+"\",";
				if(MemberVO.getHelpSwitch()==0){
					json += "\"SeekHelpMessageReply\":true,";
				}else{
					json += "\"SeekHelpMessageReply\":false,";
				}
				if(MemberVO.getMarketSwitch()==0){
					json += "\"SecondaryMarketMessageReply\":true,";
				}else{
					json += "\"SecondaryMarketMessageReply\":false,";
				}
				if(MemberVO.getServiceSwitch()==0){
					json += "\"serviceSwitch\":true,";
				}else{
					json += "\"serviceSwitch\":false,";
				}
				if(MemberVO.getExpressSwitch()==0){
					json += "\"expressSwitch\":true,";
				}else{
					json += "\"expressSwitch\":false,";
				}
				if(MemberVO.getWeatherSwitch()==0){
					json += "\"weatherSwitch\":true,";
				}else{
					json += "\"weatherSwitch\":false,";
				}
				if(MemberVO.getLimitSwitch()==0){
					json += "\"limitSwitch\":true,";
				}else{
					json += "\"limitSwitch\":false,";
				}
				if(MemberVO.getBrokeSwitch()==0){
					json += "\"brokeSwitch\":true,";
				}else{
					json += "\"brokeSwitch\":false,";
				}
				json +="\"isDoor\":\""+MemberVO.getIsDoor()+"\",";
				json +="\"estateLongitude\":\""+MemberVO.getEstateLongitude()+"\",";
				json +="\"estateLatitude\":\""+MemberVO.getEstateLatitude()+"\"";
				json += "}";
				json += "}";
			} catch (Exception e) {
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"注册失败\"";
				json += "}";
				GSLogger.error("保存appUser信息时发生错误：/app/appUser/save", e);
				e.printStackTrace();
			}
		} else {
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"注册手机号重复\"";
			json += "}";
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
	 * 用户使用电话和密码快速注册
	 * 
	 * @param cellphone
	 *            ,password
	 * @return json
	 */
	@RequestMapping(value = "fastRegist")
	public void fastRegist(HttpServletRequest request,
			HttpServletResponse response, AppUserQuery query) {
		String openid = (String) request.getSession().getAttribute("openid");
		String QQopenid = (String) request.getSession().getAttribute("QQopenid");
		String nickname = (String) request.getSession().getAttribute("nickname");
		nickname = request.getParameter("nickname");
		AppUser appUser = new AppUser();
		String json = "";
		boolean whetherRepeat = false;
		try {
			whetherRepeat = appUserService.whetherRepeat(query.getCellphone());
		} catch (Exception e) {
			GSLogger.error("验证tel是否重复", e);
			e.printStackTrace();
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"注册失败\"";
			json += "}";
		}
		if (whetherRepeat) {
			try {
				String str=StringUtil.createRandom(true, 6);
				String uuid= UUID.randomUUID().toString();
				SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
				String dateString = sf.format(new Date());
				String filedir = "app/image/" +dateString+"/"+uuid+".png";
				appUser.setPath(request.getSession().getServletContext().getRealPath("/").replace("\\", "/"));
				appUser.setFiledir(filedir);
				appUser.setPassword(str);
				appUser.setTel(query.getCellphone());
				appUser.setEstateId(query.getEstateId());
				appUser.setType(0);
				appUser.setState(1);
				Timestamp ts = new Timestamp(new Date().getTime());
				appUser.setPortrait("/images/morentouxiang.png");
				appUser.setCreateTime(ts);
				appUser.setEditTime(ts);
				appUser.setLastLoginTime(ts);
				if (openid!=null) {
					appUser.setWenxinId(openid);
				} else {
					appUser.setWenxinId("");
				}
				if (QQopenid!=null) {
					appUser.setQqId(QQopenid);
				} else {
					appUser.setQqId("");
				}
				if (nickname!=null) {
					appUser.setNickname(nickname);
				} else {
					appUser.setNickname("");
				}
				appUserService.saveRegist(appUser);
				// 保存成功
				Properties p = propertiesUtil.getProperties("config.properties");
				String ip = p.getProperty("imageIp");   
				MemberVO MemberVO = appUserService.getAppUserLoginInfo(appUser);
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"登录成功\",";
				json += "\"content\":{";
				json += "\"sessionid\":\"42823AFB33\",";
				json += "\"userType\":\""+MemberVO.getType()+"\",";
				json += "\"isWorker\":\""+MemberVO.getIsWorker()+"\",";
				json += "\"userId\":\""+MemberVO.getUserId()+"\",";
				json += "\"portrait\":\""+ip+MemberVO.getPortrait()+"\",";
				json += "\"realname\":{\"realname\":\""+MemberVO.getRealname()+"\",\"state\":\"1\"},";
				json += "\"nickname\":\""+MemberVO.getNickname()+"\",";
				json += "\"signatrue\":\""+MemberVO.getSignature()+"\",";
				json += "\"tel\":\""+query.getCellphone()+"\",";
				json += "\"sex\":\""+MemberVO.getSex()+"\",";
				json += "\"birthday\":\"";
				if(MemberVO.getBirthday()!=null){
					json += new SimpleDateFormat("yyyy-MM-dd").format(MemberVO.getBirthday().getTime());
				}
				json += "\",";
				json += "\"twoCode\":\""+ip+MemberVO.getDimensionCode()+"\",";
				json += "\"informationState\":true,";
				json += "\"estateId\":\""+MemberVO.getEstateId()+"\",";
				json += "\"estateName\":\""+MemberVO.getEstateName()+"\",";
				json += "\"estateAttr\":\""+ip+MemberVO.getEstateMap()+"\",";
				if(MemberVO.getStaId()==null || MemberVO.getStaId().equals("")){
					json += "\"stationId\":\"0\",";
				}else {
					json += "\"stationId\":\""+MemberVO.getStaId()+"\",";
				}
				if(MemberVO.getStaName()==null){
					json += "\"staName\":\"\",";
				}else {
					json += "\"staName\":\""+MemberVO.getStaName()+"\",";
				}
				json += "\"comId\":\""+MemberVO.getComId()+"\",";
				json += "\"comName\":\""+MemberVO.getComName()+"\",";
				if(MemberVO.getProId()==null){
					json += "\"proId\":\"0\",";
				}else {
					json += "\"proId\":\""+MemberVO.getProId()+"\",";
				}
				if(MemberVO.getProName()==null){
					json += "\"proName\":\"\",";
				}else {
					json += "\"proName\":\""+MemberVO.getProName()+"\",";
				}
				if(MemberVO.getUnitId()!=null && !MemberVO.getUnitId().equals("0")){
					if (MemberVO.getUnitHomeAttr()!=null) {
						json += "\"homeAttr\":\""+ip+MemberVO.getUnitHomeAttr()+"\",";
					}else {
						json += "\"homeAttr\":\"\",";
					}
				}else {
					if (MemberVO.getHomeAttr()!=null) {
						json += "\"homeAttr\":\""+ip+MemberVO.getHomeAttr()+"\",";
					}else {
						json += "\"homeAttr\":\"\",";
					}
				}
				
				json += "\"familyId\":\""+MemberVO.getFamilyId()+"\",";
				json += "\"familyNumber\":\""+MemberVO.getMount()+"\",";
				json += "\"buildingId\":\""+MemberVO.getBuildingId()+"\",";
				json += "\"buildingName\":\""+MemberVO.getBuildingName()+"\",";
				json += "\"unitId\":\""+MemberVO.getUnitId()+"\",";
				json += "\"unitName\":\""+MemberVO.getUnitName()+"\",";
				json += "\"houseNo\":\""+MemberVO.getHouseNo()+"\",";
				if(MemberVO.getHelpSwitch()==0){
					json += "\"SeekHelpMessageReply\":true,";
				}else{
					json += "\"SeekHelpMessageReply\":false,";
				}
				if(MemberVO.getMarketSwitch()==0){
					json += "\"SecondaryMarketMessageReply\":true,";
				}else{
					json += "\"SecondaryMarketMessageReply\":false,";
				}
				if(MemberVO.getServiceSwitch()==0){
					json += "\"serviceSwitch\":true,";
				}else{
					json += "\"serviceSwitch\":false,";
				}
				if(MemberVO.getExpressSwitch()==0){
					json += "\"expressSwitch\":true,";
				}else{
					json += "\"expressSwitch\":false,";
				}
				if(MemberVO.getWeatherSwitch()==0){
					json += "\"weatherSwitch\":true,";
				}else{
					json += "\"weatherSwitch\":false,";
				}
				if(MemberVO.getLimitSwitch()==0){
					json += "\"limitSwitch\":true,";
				}else{
					json += "\"limitSwitch\":false,";
				}
				if(MemberVO.getBrokeSwitch()==0){
					json += "\"brokeSwitch\":true,";
				}else{
					json += "\"brokeSwitch\":false,";
				}
				json +="\"isDoor\":\""+MemberVO.getIsDoor()+"\",";
				json +="\"estateLongitude\":\""+MemberVO.getEstateLongitude()+"\",";
				json +="\"estateLatitude\":\""+MemberVO.getEstateLatitude()+"\"";
				json += "}";
				json += "}";
				
				//短信发送随机密码
				AppVerify appVerify = new AppVerify();
				appVerify.setCellphone(query.getCellphone());
			    appVerify.setVerificationCode(str);
			    appVerify.setCreateTime(query.getCreateTime());
		        appVerify.setCreateTime(ts);
		        AppVerifyQuery appVerifyQuery = new AppVerifyQuery();
		        appVerifyQuery.setCellphone(query.getCellphone());
		        appVerifyService.delete(appVerifyQuery);
				appVerifyService.save(appVerify);
				// 发送短信
				str="您已通过手机号"+query.getCellphone()+"快速注册成为“OK家”居民，初始密码为："+str+"立即下载OK家APP，享受小区生活服务：http://www.bqsqcm.com/community/download/index.html?id=18【OK家】";
				String returnMessage = messagesUtil.returnMessageRrid(query.getCellphone(), str);
				manageSendMsgService.save(query.getCellphone(),returnMessage,str,1);
			} catch (Exception e) {
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"注册失败\"";
				json += "}";
				GSLogger.error("保存appUser信息时发生错误：/app/appUser/save", e);
				e.printStackTrace();
			}
		} else {
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"注册手机号重复\"";
			json += "}";
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
	 * 用户使用电话和密码登录APP
	 * 
	 * @param cellphone
	 *            ,password
	 * @return json
	 */
	@RequestMapping(value = "login")
	public void login(HttpServletRequest request, HttpServletResponse response,
			AppUserQuery query) {
		AppUser appUser = new AppUser();
		String json = "";
		boolean whetherCorrect = false;
		try {
			appUser.setPassword(query.getPassword());
			appUser.setTel(query.getCellphone());
			whetherCorrect = appUserService.whetherCorrect(appUser);
		} catch (Exception e) {
			GSLogger.error("验证tel、password是否正确", e);
			e.printStackTrace();
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"帐号密码错误\"";
			json += "}";
		}
		if (whetherCorrect) {
			try {
				appUser.setPassword(query.getPassword());
				appUser.setTel(query.getCellphone());
				MemberVO MemberVO = appUserService.getAppUserLoginInfo(appUser);
				Properties p = propertiesUtil.getProperties("config.properties");
				String ip = p.getProperty("imageIp");   
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"登录成功\",";
				json += "\"content\":{";
				json += "\"sessionid\":\"42823AFB33\",";
				json += "\"userType\":\""+MemberVO.getType()+"\",";
				json += "\"isWorker\":\""+MemberVO.getIsWorker()+"\",";
				json += "\"userId\":\""+MemberVO.getUserId()+"\",";
				json += "\"portrait\":\""+ip+MemberVO.getPortrait()+"\",";
				json += "\"realname\":{\"realname\":\""+MemberVO.getRealname()+"\",\"state\":\"1\"},";
				json += "\"nickname\":\""+MemberVO.getNickname()+"\",";
				json += "\"signatrue\":\""+MemberVO.getSignature()+"\",";
				json += "\"tel\":\""+query.getCellphone()+"\",";
				json += "\"sex\":\""+MemberVO.getSex()+"\",";
				json += "\"birthday\":\"";
				if(MemberVO.getBirthday()!=null){
					json += new SimpleDateFormat("yyyy-MM-dd").format(MemberVO.getBirthday().getTime());
				}
				json += "\",";
				json += "\"twoCode\":\""+ip+MemberVO.getDimensionCode()+"\",";
				json += "\"informationState\":true,";
				json += "\"estateId\":\""+MemberVO.getEstateId()+"\",";
				json += "\"estateName\":\""+MemberVO.getEstateName()+"\",";
				json += "\"estateAttr\":\""+ip+MemberVO.getEstateMap()+"\",";
				if(MemberVO.getStaId()==null || MemberVO.getStaId().equals("")){
					json += "\"stationId\":\"0\",";
				}else {
					json += "\"stationId\":\""+MemberVO.getStaId()+"\",";
				}
				if(MemberVO.getStaName()==null){
					json += "\"staName\":\"\",";
				}else {
					json += "\"staName\":\""+MemberVO.getStaName()+"\",";
				}
				json += "\"comId\":\""+MemberVO.getComId()+"\",";
				json += "\"comName\":\""+MemberVO.getComName()+"\",";
				if(MemberVO.getProId()==null){
					json += "\"proId\":\"0\",";
				}else {
					json += "\"proId\":\""+MemberVO.getProId()+"\",";
				}
				if(MemberVO.getProName()==null){
					json += "\"proName\":\"\",";
				}else {
					json += "\"proName\":\""+MemberVO.getProName()+"\",";
				}
				if(MemberVO.getUnitId()!=null && !MemberVO.getUnitId().equals("0")){
					if (MemberVO.getUnitHomeAttr()!=null) {
						json += "\"homeAttr\":\""+ip+MemberVO.getUnitHomeAttr()+"\",";
					}else {
						json += "\"homeAttr\":\"\",";
					}
				}else {
					if (MemberVO.getHomeAttr()!=null) {
						json += "\"homeAttr\":\""+ip+MemberVO.getHomeAttr()+"\",";
					}else {
						json += "\"homeAttr\":\"\",";
					}
				}
				
				json += "\"familyId\":\""+MemberVO.getFamilyId()+"\",";
				json += "\"familyNumber\":\""+MemberVO.getMount()+"\",";
				json += "\"buildingId\":\""+MemberVO.getBuildingId()+"\",";
				json += "\"buildingName\":\""+MemberVO.getBuildingName()+"\",";
				json += "\"unitId\":\""+MemberVO.getUnitId()+"\",";
				json += "\"unitName\":\""+MemberVO.getUnitName()+"\",";
				json += "\"houseNo\":\""+MemberVO.getHouseNo()+"\",";
				if(MemberVO.getHelpSwitch()==0){
					json += "\"SeekHelpMessageReply\":true,";
				}else{
					json += "\"SeekHelpMessageReply\":false,";
				}
				if(MemberVO.getMarketSwitch()==0){
					json += "\"SecondaryMarketMessageReply\":true,";
				}else{
					json += "\"SecondaryMarketMessageReply\":false,";
				}
				if(MemberVO.getServiceSwitch()==0){
					json += "\"serviceSwitch\":true,";
				}else{
					json += "\"serviceSwitch\":false,";
				}
				if(MemberVO.getExpressSwitch()==0){
					json += "\"expressSwitch\":true,";
				}else{
					json += "\"expressSwitch\":false,";
				}
				if(MemberVO.getWeatherSwitch()==0){
					json += "\"weatherSwitch\":true,";
				}else{
					json += "\"weatherSwitch\":false,";
				}
				if(MemberVO.getLimitSwitch()==0){
					json += "\"limitSwitch\":true,";
				}else{
					json += "\"limitSwitch\":false,";
				}
				if(MemberVO.getBrokeSwitch()==0){
					json += "\"brokeSwitch\":true,";
				}else{
					json += "\"brokeSwitch\":false,";
				}
				json +="\"isDoor\":\""+MemberVO.getIsDoor()+"\",";
				json +="\"estateLongitude\":\""+MemberVO.getEstateLongitude()+"\",";
				json +="\"estateLatitude\":\""+MemberVO.getEstateLatitude()+"\"";
				json += "}";
				json += "}";
				AppUser appUser1 = new AppUser();
				Timestamp  ts=new Timestamp(new Date().getTime());
		        appUser1.setUserId(MemberVO.getUserId());
		        appUser1.setLastLoginTime(ts);
				appUserService.update(appUser1);
			} catch (Exception e) {
				GSLogger.error("验证tel、password是否正确", e);
				e.printStackTrace();
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"获取用户信息失败\"";
				json += "}";
			}
			
		} else {
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"帐号密码错误\"";
			json += "}";
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
	 * 用户编辑保存个人头像
	 * 
	 * @param userId
	 *            ,sessionid,avatar
	 * @return json
	 */
	@RequestMapping(value = "updateUserAvatar")
	public void updateUserAvatar(HttpServletRequest request,
			HttpServletResponse response,AppUserQuery query) {
		String json = "";
		Map map = (Map) request.getAttribute("resultMap");
		Map<String,String> paramMap=(Map) map.get("param");
		Map<String,String> imageMap=(Map) map.get("image");
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			AppUser appUser = new AppUser();
			Timestamp  ts=new Timestamp(new Date().getTime());
	        appUser.setEditTime(ts);
	        Collection<String> c = imageMap.keySet();
			Iterator it = c.iterator();
	        for (; it.hasNext();) {
	        	appUser.setPortrait((String)imageMap.get((String)it.next()));
	        }
	        appUser.setUserId(new Integer(paramMap.get("userId")));
			appUserService.update(appUser);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"保存成功\",";
			json += "\"content\":{";
			json += "\"avatar\":\""+ip+appUser.getPortrait()+"\"";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
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
			appStatisticsClick.setUserId(new Integer(paramMap.get("userId")));
			appStatisticsClick.setType(45);
			appStatisticsClick.setTypeName("修改头像");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 用户编辑保存真实姓名
	 * 
	 * @param userId
	 *            ,sessionid,realname,type
	 * @return json
	 */
	@RequestMapping(value = "updateUserRealname")
	public void updateUserRealname(HttpServletRequest request,
			HttpServletResponse response,AppUserQuery query) {
		String json = "";
		try{
			AppUser appUser = new AppUser();
			Timestamp  ts=new Timestamp(new Date().getTime());
	        appUser.setEditTime(ts);
	        appUser.setRealname(query.getRealname());
	        appUser.setUserId(query.getUserId());
	        appUser.setIsNameSecret(query.getType());
			appUserService.update(appUser);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"保存成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
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
			appStatisticsClick.setType(46);
			appStatisticsClick.setTypeName("修改姓名");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 用户编辑保存个人个性签名
	 * 
	 * @param userId
	 *            ,sessionid,singature
	 * @return json
	 */
	@RequestMapping(value = "updateUserSingature")
	public void updateUserSingature(HttpServletRequest request,
			HttpServletResponse response,AppUserQuery query) {
		String json = "";
		try{
			AppUser appUser = new AppUser();
			Timestamp  ts=new Timestamp(new Date().getTime());
	        appUser.setEditTime(ts);
	        appUser.setSignature(query.getSignature());
	        appUser.setUserId(query.getUserId());
			appUserService.update(appUser);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"保存成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
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
			appStatisticsClick.setType(48);
			appStatisticsClick.setTypeName("修改个性签名");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 用户编辑保存个人昵称
	 * 
	 * @param userId
	 *            ,sessionid,nickname
	 * @return json
	 */
	@RequestMapping(value = "updateUserNickname")
	public void updateUserNickname(HttpServletRequest request,
			HttpServletResponse response,AppUserQuery query) {
		String json = "";
		try{
			AppUserQuery AppUserQuery = new AppUserQuery();
			AppUserQuery.setNickname(query.getNickname());
			int count = appUserService.selectCount(AppUserQuery);
			if(count>0 && !"".equals(query.getNickname())){
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"昵称已被人使用\"";
				json += "}";
			}else {
				AppUser appUser = new AppUser();
				Timestamp  ts=new Timestamp(new Date().getTime());
		        appUser.setEditTime(ts);
		        appUser.setNickname(query.getNickname());
		        appUser.setUserId(query.getUserId());
				appUserService.update(appUser);
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"保存成功\"";
				json += "}";
			}
			
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
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
			appStatisticsClick.setType(47);
			appStatisticsClick.setTypeName("修改昵称");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 用户编辑保存个人性别
	 * 
	 * @param userId
	 *            ,sessionid,sex
	 * @return json
	 */
	@RequestMapping(value = "updateUserSex")
	public void updateUserSex(HttpServletRequest request,
			HttpServletResponse response,AppUserQuery query) {
		String json = "";
		try{
			AppUser appUser = new AppUser();
			Timestamp  ts=new Timestamp(new Date().getTime());
	        appUser.setEditTime(ts);
	        appUser.setSex(query.getSex());
	        appUser.setUserId(query.getUserId());
			appUserService.update(appUser);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"保存成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
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
			appStatisticsClick.setType(50);
			appStatisticsClick.setTypeName("修改性别");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 用户编辑保存个人生日
	 * 
	 * @param userId
	 *            ,sessionid,birthday
	 * @return json
	 */
	@RequestMapping(value = "updateUserBirthday")
	public void updateUserBirthday(HttpServletRequest request,
			HttpServletResponse response,AppUserQuery query) {
		String json = "";
		try{
			AppUser appUser = new AppUser();
			Timestamp  ts=new Timestamp(new Date().getTime());
	        appUser.setEditTime(ts);
	        appUser.setStrBirthday(query.getBirthday());
	        appUser.setUserId(query.getUserId());
			appUserService.update(appUser);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"保存成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
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
			appStatisticsClick.setType(51);
			appStatisticsClick.setTypeName("修改生日");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 用户添加手机号码
	 * 
	 * @param userId
	 *            ,sessionid,tel
	 * @return json
	 */
	@RequestMapping(value = "addTel")
	public void addTel(HttpServletRequest request, HttpServletResponse response,AppUserCellphoneQuery query) {
		String json = "";
		try{
			AppUserCellphone AppUserCellphone = new AppUserCellphone();
			AppUserCellphone.setUserId(query.getUserId());
			AppUserCellphone.setCellphone(query.getTel());
			Timestamp ts = new Timestamp(new Date().getTime());
			AppUserCellphone.setCreateTime(ts);
			AppUserCellphone.setEditTime(ts);
			appUserCellphoneService.save(AppUserCellphone);
			
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"保存成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
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
			appStatisticsClick.setType(49);
			appStatisticsClick.setTypeName("添加手机号");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 替换手机号码
	 * 
	 * @param userId
	 *            ,sessionid,telId,value
	 * @return json
	 */
	@RequestMapping(value = "replaceTel")
	public void replaceTel(HttpServletRequest request,
			HttpServletResponse response,AppUserCellphoneQuery query) {
		String json = "";
		try{
			AppUserCellphone AppUserCellphone = new AppUserCellphone();
			AppUserCellphone.setCellphoneId(query.getTelId());
			AppUserCellphone.setCellphone(query.getValue());
			Timestamp ts = new Timestamp(new Date().getTime());
			AppUserCellphone.setEditTime(ts);
			appUserCellphoneService.update(AppUserCellphone);
			
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"修改成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"修改失败\"";
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
	 * 获取手机号码列表
	 * 
	 * @param userId
	 *            ,sessionid
	 * @return json
	 */
	@RequestMapping(value = "getTelList")
	public void getTelList(HttpServletRequest request,
			HttpServletResponse response,AppUserCellphoneQuery query) {
		String json = "";
		try{
			List<AppUserCellphone> list = appUserCellphoneService.findByExample(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			
			json += "\"tel\":[";
			for (AppUserCellphone appUserCellphone : list) {
				json += "{\"telId\":\""+appUserCellphone.getCellphoneId()+"\",\"tel\":\""+appUserCellphone.getCellphone()+"\"},";
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
	 * 删除手机号码
	 * 
	 * @param userId
	 *            ,sessionid,telId,value
	 * @return json
	 */
	@RequestMapping(value = "deleteTel")
	public void deleteTel(HttpServletRequest request,
			HttpServletResponse response) {
		String json = "";
		try{
			appUserCellphoneService.delete(new Integer(request.getParameter("telId")));
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"删除成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"删除失败\"";
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
	 * 手机号码保密
	 * 
	 * @param userId
	 *            ,sessionid,telId,value
	 * @return json
	 */
	@RequestMapping(value = "telConfidential")
	public void telConfidential(HttpServletRequest request,
			HttpServletResponse response,AppUserQuery query) {
		String json = "";
		try{
			AppUser appUser = new AppUser();
			Timestamp  ts=new Timestamp(new Date().getTime());
	        appUser.setEditTime(ts);
	        appUser.setUserId(query.getUserId());
	        appUser.setIsTelSecret(query.getType());
			appUserService.update(appUser);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"保存成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
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
	 * 用户获取地址列表
	 * 
	 * @param userId
	 *            ,sessionid
	 * @return json
	 */
	@RequestMapping(value = "getExpAddrList")
	public void getExpAddrList(HttpServletRequest request,
			HttpServletResponse response,AppPartyAddressQuery query) {
		String json = "";
		try{
			List<AppPartyAddress> list = appPartyAddressService.findByExample(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"addrList\":[";
			for (AppPartyAddress appPartyAddress : list) {
				json += "{\"addrId\":\""+appPartyAddress.getPartyAddressId()+"\",\"name\":\""+appPartyAddress.getName()+"\",\"cellphone\":\""+appPartyAddress.getTel()+"\",\"address\":\""+appPartyAddress.getAddress()+"\",\"type\":\""+appPartyAddress.getType()+"\"},";
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
			appStatisticsClick.setType(52);
			appStatisticsClick.setTypeName("我的快递地址");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 用户添加收件地址
	 * 
	 * @param addrId
	 *            ,userId,sessionid,estateId,buildtingId,unitId,realname,tel,
	 *            houseCode
	 * @return json
	 */
	@RequestMapping(value = "addExpAddr")
	public void addExpAddr(HttpServletRequest request,
			HttpServletResponse response,AppPartyAddressQuery query) {
		String json = "";
		try{
			appPartyAddressService.save(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"添加成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"添加失败\"";
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
			appStatisticsClick.setType(53);
			appStatisticsClick.setTypeName("添加快递地址");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 用户编辑收件地址
	 * 
	 * @param addrId
	 *            ,userId,sessionid,estateId,buildtingId,unitId,realname,tel,
	 *            houseCode
	 * @return json
	 */
	@RequestMapping(value = "updateExpAddr")
	public void updateExpAddr(HttpServletRequest request,
			HttpServletResponse response,AppPartyAddressQuery query) {
		String json = "";
		try{
			appPartyAddressService.update(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"添加成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"添加失败\"";
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
			appStatisticsClick.setType(54);
			appStatisticsClick.setTypeName("修改快递地址");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户删除收件地址
	 * 
	 * @param userId
	 *            ,sessionid,addrId
	 * @return json
	 */
	@RequestMapping(value = "delExpAddr")
	public void delExpAddr(HttpServletRequest request,
			HttpServletResponse response,AppPartyAddressQuery query) {
		String json = "";
		try{
			appPartyAddressService.delete(query.getAddrId());
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"删除成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"删除失败\"";
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
			appStatisticsClick.setType(56);
			appStatisticsClick.setTypeName("删除快递地址");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 用户设置默认收件地址
	 * 
	 * @param 	
	 * @return json
	 */
	@RequestMapping(value = "setDefault")
	public void setDefault(HttpServletRequest request,
			HttpServletResponse response,AppPartyAddressQuery query) {
		String json = "";
		try{
			appPartyAddressService.setDefault(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"设置成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"设置失败\"";
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
			appStatisticsClick.setType(55);
			appStatisticsClick.setTypeName("设置默认快递地址");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户设置家庭地址
	 * 
	 * @param userId
	 *            ,sessionid,estateId,buildtingId,unitId,houseCode
	 * @return json
	 */
	@RequestMapping(value = "saveFamilyAddr")
	public void saveFamilyAddr(HttpServletRequest request,
			HttpServletResponse response,AppEstateUserQuery query) {
		String json = "";
		try{
			Properties p = propertiesUtil.getProperties("config.properties");
			String ip = p.getProperty("imageIp");   
			AppEstateUser appEstateUser = new AppEstateUser();
			appEstateUser.setUserId(query.getUserId());
			appEstateUser.setEstateId(query.getEstateId());
			appEstateUser.setBuildingId(query.getBuildtingId());
			appEstateUser.setUnitId(query.getUnitId());
			appEstateUser.setHouseNo(query.getHouseCode());
			Timestamp ts = new Timestamp(new Date().getTime());
			appEstateUser.setEditTime(ts);
			AppEstateUser attr = appEstateUserService.update(appEstateUser);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"设置成功\",";
			json += "\"content\":{";
			json += "\"attr\":\""+ip+attr.getBuildingMap()+"\",";
			json += "\"buildingId\":\""+attr.getBuildingId()+"\",";
			json += "\"buildingName\":\""+attr.getBuildingName()+"\",";
			json += "\"unitId\":\""+attr.getUnitId()+"\",";
			json += "\"unitName\":\""+attr.getUnitName()+"\",";
			json += "\"houseNo\":\""+query.getHouseCode()+"\"";
			json += "}";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"设置失败\"";
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
			appStatisticsClick.setType(97);
			appStatisticsClick.setTypeName("添加我家位置");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 用户信息提示接口
	 * 
	 * @param userId
	 *            ,sessionid
	 * @return json
	 */
	@RequestMapping(value = "infoPrompt")
	public void infoPrompt(HttpServletRequest request,
			HttpServletResponse response,AppUserQuery query) {
		String json = "";
		try{
			MemberVO MemberVO = appUserService.getAppUserInfoById(query.getUserId());
			AppLatestNewsQuery appLatestNewsQuery = new AppLatestNewsQuery();
			appLatestNewsQuery.setUserId(query.getUserId());
			appLatestNewsQuery.setTo(0);
			List<AppLatestNews> list = appLatestNewsService.findByExample(appLatestNewsQuery);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			if(null==MemberVO){
				json += "\"familyId\":\"\",";
				json += "\"familyNumber\":\"\",";
				json += "\"familyState\":\"0\",";
			}else{
				
				if(MemberVO.getState()==0){
					json += "\"familyId\":\""+MemberVO.getFamilyId()+"\",";
					json += "\"familyNumber\":\""+MemberVO.getMount()+"\",";
					json += "\"familyState\":\"1\",";
				}else if(MemberVO.getState()==2){
					json += "\"familyId\":\"\",";
					json += "\"familyNumber\":\"\",";
					json += "\"familyState\":\"2\",";
				}else{
					json += "\"familyId\":\"\",";
					json += "\"familyNumber\":\"\",";
					json += "\"familyState\":\"0\",";
				}
			}
			boolean  brokeState = false ; //我的爆料状态
			int brokeNumber = 0 ; //我的爆料数量
			
			boolean  broke1State = false ; //我的爆料未选用状态
			int broke1Number = 0 ; //我的爆料未选用数量
			
			boolean  broke2State = false ; //我的爆料已选用状态
			int broke2Number = 0 ; //我的爆料已选用数量
			
			boolean  secondryMarketState = false ; //我的二手状态
			int secondryMarketNumber = 0 ; //我的二手数量
			
			boolean  secondryMarket1State = false ; //我的二手已发布状态
			int secondryMarket1Number = 0 ; //我的二手已发布数量
			
			boolean  secondryMarket2State = false ; //我的二手审核中状态
			int secondryMarket2Number = 0 ; //我的二手审核中数量
			
			boolean  secondryMarket3State = false ; //我的二手已结束状态
			int secondryMarket3Number = 0 ; //我的二手已结束数量
			
			boolean  helpState = false ; //我的求助状态
			int helpNumber = 0 ; //我的求助数量
			
			boolean  infoState = false ; //我的消息状态
			int infoNumber = 0 ; //我的消息数量
			
			boolean  info1State = false ; //我的信息回复我的状态
			int info1Number = 0 ; //我的信息回复我的数量
			boolean  info2State = false ; //我的信息系统消息状态
			int info2Number = 0 ; //我的信息系统消息数量
			
			boolean  useFeedbackState = false ; //使用反馈状态
			int useFeedbackNumber = 0 ; //使用反馈数量
			
			boolean  estateProposeState = false ; //驿站建议状态
			int estateProposeNumber = 0 ; //驿站建议数量
			
			boolean  propertyProposeState = false ; //物业建议状态
			int propertyProposeNumber = 0 ; //物业建议数量
			
			boolean  expressComplaintState = false ; //快递投诉状态
			int expressComplaintNumber = 0 ; //快递投诉数量
			
			boolean  expressComplaint1State = false ; //快递投诉处理中状态
			int expressComplaint1Number = 0 ; //快递投诉处理中数量
			
			boolean  expressComplaint2State = false ; //快递投诉已完结状态
			int expressComplaint2Number = 0 ; //快递投诉已完结数量
			
			boolean  propertyComplaintState = false ; //物业投诉状态
			int propertyComplaintNumber = 0 ; //物业投诉数量
			
			boolean  propertyComplaint1State = false ; //物业投诉处理中状态
			int propertyComplaint1Number = 0 ; //物业投诉处理中数量
			
			boolean  propertyComplaint2State = false ; //物业投诉已完结状态
			int propertyComplaint2Number = 0 ; //物业投诉已完结数量
			
			boolean  propertyRepairState = false ; //物业报修状态
			int propertyRepairNumber = 0 ; //物业报修数量
			
			boolean  propertyRepair1State = false ; //物业报修处理中状态
			int propertyRepair1Number = 0 ; //物业报修处理中数量
			
			boolean  propertyRepair2State = false ; //物业报修已完结状态
			int propertyRepair2Number = 0 ; //物业报修已完结数量
			
			boolean  IExpressState = false ; //我的快件状态
			int IExpressNumber = 0 ; //我的快件数量
			
			boolean  IExpress1State = false ; //我的快件状态
			int IExpress1Number = 0 ; //我的快件数量

			boolean  IExpress2State = false ; //我的快件状态
			int IExpress2Number = 0 ; //我的快件数量
			
			boolean  IExpress3State = false ; //我的快件状态
			int IExpress3Number = 0 ; //我的快件数量
			
			boolean  IExpress4State = false ; //我的快件状态
			int IExpress4Number = 0 ; //我的快件数量
			
			for (AppLatestNews appLatestNews : list) {
				//System.out.println(appLatestNews.getTypeId());
				switch (appLatestNews.getTypeId()) {
				case 0:
					brokeState = true;
					brokeNumber++;
					break;
				case 33:
					broke1State = true;
					broke1Number++;
					break;
				case 34:
					broke2State = true;
					broke2Number++;
					break;
				case 2:
					secondryMarketState = true;
					secondryMarketNumber++;
					break;
				case 3:
					secondryMarket1State = true;
					secondryMarket1Number++;
					break;
				case 4:
					secondryMarket2State = true;
					secondryMarket2Number++;
					break;
				case 5:
					secondryMarket3State = true;
					secondryMarket3Number++;
					break;
				case 27:
					helpState = true;
					helpNumber++;
					break;
				case 7:
					infoState = true;
					infoNumber++;
					break;
				case 9:
					info1State = true;
					info1Number++;
					break;
				case 10:
					info2State = true;
					info2Number++;
					break;
				case 11:
					useFeedbackState = true;
					useFeedbackNumber++;
					break;
				case 12:
					estateProposeState = true;
					estateProposeNumber++;
					break;
				case 14:
					propertyProposeState = true;
					propertyProposeNumber++;
					break;
				case 13:
					expressComplaintState = true;
					expressComplaintNumber++;
					break;
				case 15:
					propertyComplaintState = true;
					propertyComplaintNumber++;
					break;
				case 16:
					expressComplaint1State = true;
					expressComplaint1Number++;
					break;
				case 17:
					expressComplaint2State = true;
					expressComplaint2Number++;
					break;
				case 18:
					propertyComplaint1State = true;
					propertyComplaint1Number++;
					break;
				case 19:
					propertyComplaint2State = true;
					propertyComplaint2Number++;
					break;
				case 29:
					propertyRepair1State = true;
					propertyRepair1Number++;
					break;
				case 30:
					propertyRepair2State = true;
					propertyRepair2Number++;
					break;
				case 32:
					propertyRepairState = true;
					propertyRepairNumber++;
					break;
				case 21:
					IExpressState = true;
					IExpressNumber++;
					break;
				case 22:
					IExpress1State = true;
					IExpress1Number++;
					break;
				case 23:
					IExpress2State = true;
					IExpress2Number++;
					break;
				case 24:
					IExpress3State = true;
					IExpress3Number++;
					break;
				case 25:
					IExpress4State = true;
					IExpress4Number++;
					break;
				default:
					break;
				}
			}
			json += "\"broke\":{";
			json += "\"state\":"+brokeState+",";
			json += "\"number\":\""+brokeNumber+"\"";
			json += "},";
			json += "\"broke1\":{";
			json += "\"state\":"+broke1State+",";
			json += "\"number\":\""+broke1Number+"\"";
			json += "},";
			json += "\"broke2\":{";
			json += "\"state\":"+broke2State+",";
			json += "\"number\":\""+broke2Number+"\"";
			json += "},";
			json += "\"secondryMarket\":{";
			json += "\"state\":"+secondryMarketState+",";
			json += "\"number\":\""+secondryMarketNumber+"\"";
			json += "},";
			json += "\"secondryMarket1\":{";
			json += "\"state\":"+secondryMarket1State+",";
			json += "\"number\":\""+secondryMarket1Number+"\"";
			json += "},";
			json += "\"secondryMarket2\":{";
			json += "\"state\":"+secondryMarket2State+",";
			json += "\"number\":\""+secondryMarket2Number+"\"";
			json += "},";
			json += "\"secondryMarket3\":{";
			json += "\"state\":"+secondryMarket3State+",";
			json += "\"number\":\""+secondryMarket3Number+"\"";
			json += "},";
			json += "\"help\":{";
			json += "\"state\":"+helpState+",";
			json += "\"number\":\""+helpNumber+"\"";
			json += "},";
			json += "\"info\":{";
			json += "\"state\":"+infoState+",";
			json += "\"number\":\""+infoNumber+"\"";
			json += "},";
			json += "\"info1\":{";
			json += "\"state\":"+info1State+",";
			json += "\"number\":\""+info1Number+"\"";
			json += "},";
			json += "\"info2\":{";
			json += "\"state\":"+info2State+",";
			json += "\"number\":\""+info2Number+"\"";
			json += "},";
			json += "\"useFeedback\":{";
			json += "\"state\":"+useFeedbackState+",";
			json += "\"number\":\""+useFeedbackNumber+"\"";
			json += "},";
			json += "\"estatePropose\":{";
			json += "\"state\":"+estateProposeState+",";
			json += "\"number\":\""+estateProposeNumber+"\"";
			json += "},";
			json += "\"propertyPropose\":{";
			json += "\"state\":"+propertyProposeState+",";
			json += "\"number\":\""+propertyProposeNumber+"\"";
			json += "},";
			json += "\"expressComplaint\":{";
			json += "\"state\":"+expressComplaintState+",";
			json += "\"number\":\""+expressComplaintNumber+"\"";
			json += "},";
			json += "\"expressComplaint1\":{";
			json += "\"state\":"+expressComplaint1State+",";
			json += "\"number\":\""+expressComplaint1Number+"\"";
			json += "},";
			json += "\"expressComplaint2\":{";
			json += "\"state\":"+expressComplaint2State+",";
			json += "\"number\":\""+expressComplaint2Number+"\"";
			json += "},";
			json += "\"propertyComplaint\":{";
			json += "\"state\":"+propertyComplaintState+",";
			json += "\"number\":\""+propertyComplaintNumber+"\"";
			json += "},";
			json += "\"propertyComplaint1\":{";
			json += "\"state\":"+propertyComplaint1State+",";
			json += "\"number\":\""+propertyComplaint1Number+"\"";
			json += "},";
			json += "\"propertyComplaint2\":{";
			json += "\"state\":"+propertyComplaint2State+",";
			json += "\"number\":\""+propertyComplaint2Number+"\"";
			json += "},";
			json += "\"propertyRepair\":{";
			json += "\"state\":"+propertyRepairState+",";
			json += "\"number\":\""+propertyRepairNumber+"\"";
			json += "},";
			json += "\"propertyRepair1\":{";
			json += "\"state\":"+propertyRepair1State+",";
			json += "\"number\":\""+propertyRepair1Number+"\"";
			json += "},";
			json += "\"propertyRepair2\":{";
			json += "\"state\":"+propertyRepair2State+",";
			json += "\"number\":\""+propertyRepair2Number+"\"";
			json += "},";
			json += "\"IExpress\":{";
			json += "\"state\":"+IExpressState+",";
			json += "\"number\":\""+IExpressNumber+"\"";
			json += "},";
			json += "\"IExpress1\":{";
			json += "\"state\":"+IExpress1State+",";
			json += "\"number\":\""+IExpress1Number+"\"";
			json += "},";
			json += "\"IExpress2\":{";
			json += "\"state\":"+IExpress2State+",";
			json += "\"number\":\""+IExpress2Number+"\"";
			json += "},";
			json += "\"IExpress3\":{";
			json += "\"state\":"+IExpress3State+",";
			json += "\"number\":\""+IExpress3Number+"\"";
			json += "},";
			json += "\"IExpress4\":{";
			json += "\"state\":"+IExpress4State+",";
			json += "\"number\":\""+IExpress4Number+"\"";
			json += "}";
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
	 * 用户查看求助详情
	 * 
	 * @param userId
	 *            ,seekHelpId,sessionid
	 * @return json
	 */
	@RequestMapping(value = "getSeekHelpById")
	public void getSeekHelpById(HttpServletRequest request,
			HttpServletResponse response) {
		//System.out.println("userId:" + request.getParameter("userId"));
		//System.out.println("seekHelpId:" + request.getParameter("seekHelpId"));
		//System.out.println("sessionid:" + request.getParameter("sessionid"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"获取成功\",";
		json += "\"content\":{";
		json += "\"seekHelpId\":\"1\",";
		json += "\"title\":\"标题啊\",";
		json += "\"time\":\"2001-1-1 11:11:11\",";
		json += "\"content\":\"详细内容\",";
		json += "\"comments\":\"12\",";
		json += "\"publisher\":\"张三\",";
		json += "\"supports\":\"12\",";
		json += "\"pics\":[";
		json += "{\"pic\":\"图片1\"},";
		json += "{\"pic\":\"图片2\"}";
		json += "],";
		json += "\"speechSounds\":[";
		json += "{\"speechSound\":\"语音1\"},";
		json += "{\"speechSound\":\"语音2\"}";
		json += "],";
		json += "\"detail\":[";
		json += "{\"type\":\"1\",\"userId\":\"1\",\"avatar\":\"头像\",\"name\":\"张三\",\"commentTime\":\"2011-11-11 19:11:11\",\"content \":\"你好\"},";
		json += "{\"type\":\"2\",\"userId\":\"2\",\"avatar\":\"头像\",\"name\":\"张三\",\"commentTime\":\"2011-11-11 19:11:11\",\"speechSound \":\"语音\"}";
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
	 * 用户查看我的信息列表
	 * 
	 * @param userId
	 *            ,sessionid,type,page,rows
	 * @return json
	 */
	@RequestMapping(value = "findInformationByUser")
	public void findInformationByUser(HttpServletRequest request,
			HttpServletResponse response,AppUserNewsQuery query) {
		String json = "";
		AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
		try{
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("createTime");
			BaseBean baseBean = appUserNewsService.findAllPage(query);
			AppLatestNewsQuery appLatestNewsQuery = new AppLatestNewsQuery();
			appLatestNewsQuery.setUserId(query.getUserId());
			appLatestNewsQuery.setTo(0);
			appLatestNewsQuery.setTypeId(8);
			List<AppLatestNews> list = appLatestNewsService.findByExample(appLatestNewsQuery);
			AppLatestNews appLatestNews = new AppLatestNews();
			appLatestNews.setUserId(query.getUserId());
			appLatestNews.setTypeId(7);
			appLatestNews.setTo(0);
			appLatestNewsService.delete_app(appLatestNews);
			if(query.getType()==2){
				appLatestNews.setTypeId(10);
			}else {
				appLatestNews.setTypeId(9);
			}
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
			if("1".equals(request.getParameter("type"))){
				json += "\"list\":[";
				for(int i=0;i<baseBean.getList().size();i++) {
					AppUserNews appUserNews = (AppUserNews) baseBean.getList().get(i);
					String pic = "";
					try {
						if(appUserNews.getType()==0){
							BusinessNews businessNews = businessNewsService.findById_app(appUserNews.getId());
							pic = businessNews.getAppPic();
						}else if (appUserNews.getType()==1) {
							BusinessActivity activity = businessActivityService.findById_app(appUserNews.getId());
							pic = activity.getAppPic();
						} else if (appUserNews.getType()==3 || appUserNews.getType()==4) {
							BusinessAnno businessAnno = businessAnnoService.findById_app(appUserNews.getId());
							pic = businessAnno.getAppPic();	
						}else if (appUserNews.getType()==9) {
							BusinessChinmedichenacare businessChinmedichenacare = businessChinmedichenacareService.findById_app(appUserNews.getId());
							pic = businessChinmedichenacare.getAppPic();	
						}else if (appUserNews.getType()==10) {
							BusinessHealthydiet businessHealthydiet = businessHealthydietService.findById_app(appUserNews.getId());
							pic = businessHealthydiet.getAppPic();	

						}
					} catch (Exception e) {
						// TODO: handle exception
						continue;
					}
					
					Properties p = propertiesUtil.getProperties("config.properties");
					String ip = p.getProperty("imageIp");   

					
					
					json += "{";
					json += "\"type\":\""+appUserNews.getType()+"\",";
					json += "\"title\":\""+appUserNews.getNewTitle()+"\",";
					json += "\"time\":\""+DateUtil.getInterval(appUserNews.getCreateTime())+"\",";
					json += "\"ID\":\""+appUserNews.getId()+"\",";
					json += "\"replieName\":\""+appUserNews.getLastMessageName()+"\",";
					json += "\"content\":\""+appUserNews.getLastMessage()+"\",";
					json += "\"pic\":\""+ip+pic+"\",";
					json += "\"url\":\"\"";
					boolean  flag = false ; //我的消息列表状态
					for (AppLatestNews appLatestNews2 : list) {
						if(appLatestNews2.getSourceId().equals(appUserNews.getId())){
							flag = true;
						}
					}
					if (flag) {
						json += ",\"status\":true";
					}else {
						json += ",\"status\":false";
					}
					json +="},";
					appStatisticsClick.setType(63);
					appStatisticsClick.setTypeName("我的评论回复列表");
				}
			}else{
				json += "\"list\":[";
				for(int i=0;i<baseBean.getList().size();i++) {
					AppUserNews appUserNews = (AppUserNews) baseBean.getList().get(i);
					json += "{";
					json += "\"title\":\""+appUserNews.getNewTitle()+"\",";
					json += "\"time\":\""+DateUtil.getInterval(appUserNews.getCreateTime())+"\",";
					json += "\"ID\":\""+appUserNews.getId()+"\",";
					json += "\"replieName\":\""+appUserNews.getLastMessageName()+"\",";
					json += "\"content\":\""+appUserNews.getContent()+"\",";
					if(appUserNews.getType()!=5){
						json += "\"type\":\"1\"";
					}else{
						json += "\"type\":\"2\"";
					}
					boolean  flag = false ; //我的消息列表状态
					for (AppLatestNews appLatestNews2 : list) {
						if(appLatestNews2.getSourceId().equals(appUserNews.getId())){
							flag = true;
						}
					}
					if (flag) {
						json += ",\"status\":true";
						appLatestNews.setTypeId(8);
						appLatestNews.setTo(0);
						appLatestNews.setSourceId(appUserNews.getId());
						appLatestNewsService.delete_app_id(appLatestNews);
					}else {
						json += ",\"status\":false";
					}
					json +="},";
				}
				appStatisticsClick.setType(64);
				appStatisticsClick.setTypeName("系统消息");
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
			appStatisticsClick.setCreateTime(ts);
			appStatisticsClick.setEditTime(ts);
			if(null==query.getUserId()){
				appStatisticsClick.setUserId(0);
			}else{
				appStatisticsClick.setUserId(query.getUserId());
			}
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 用户获取使用反馈列表
	 * 
	 * @param userId
	 *            ,sessionid,type,page,rows
	 * @return json
	 */
	@RequestMapping(value = "findFeedbackListByUser")
	public void findFeedbackListByUser(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("userId:" + request.getParameter("userId"));
		System.out.println("sessionid:" + request.getParameter("sessionid"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"执行成功\",";
		json += "\"content\":\"{";
		json += "\"PageState\":true,";
		json += "\"feedbackList\":[";
		json += "{\"userId\":\"1\",\"userName\":\"张三\",\"content\":\"反馈内容\",\"time\":\"2014-03-23 12:32\",\"replierName\":\"名称\",\"lastReply\":\"最新回复\"},";
		json += "{\"userId\":\"2\",\"userName\":\"张三\",\"content\":\"反馈内容\",\"time\":\"2014-03-23 12:32\",\"replierName\":\"名称\",\"lastReply\":\"最新回复\"}";
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
	 * 用户查看使用反馈详情
	 * 
	 * @param userId
	 *            ,sessionid,ID
	 * @return json
	 */
	@RequestMapping(value = "findFeedback")
	public void findFeedback(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("userId:" + request.getParameter("userId"));
		System.out.println("sessionid:" + request.getParameter("sessionid"));
		System.out.println("ID:" + request.getParameter("ID"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"执行成功\",";
		json += "\"content\":{";
		json += "\"ID\":\"1\",";
		json += "\"time\":\"\"200\"1-1-1 11:11:11\",";
		json += "\"content\":\"详细内容\",";
		json += "\"pics\":[";
		json += "{\"pic\":\"图片1\"},";
		json += "{\"pic\":\"图片2\"}";
		json += "],";
		json += "\"speechSounds\":[";
		json += "{\"speechSound\":\"语音1\"},";
		json += "{\"speechSound\":\"语音2\"}";
		json += "],";
		json += "\"detail\":[";
		json += "{\"type\":\"1\",\"userId\":\"1\",\"avatar\":\"头像\",\"name\":\"张三\",\"commentTime\":\"2011-11-11 19:11:11\",\"content \":\"你好\"},";
		json += "{\"type\":\"2\",\"userId\":\"2\",\"avatar\":\"头像\",\"name\":\"张三\",\"commentTime\":\"2011-11-11 19:11:11\",\"speechSound \":\"语音\"}";
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
	 * 用户发布反馈
	 * 
	 * @param userId
	 *            ,sessionid,content
	 * @return json
	 */
	@RequestMapping(value = "publishFeedback")
	public void publishFeedback(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("userId:" + request.getParameter("userId"));
		System.out.println("sessionid:" + request.getParameter("sessionid"));
		System.out.println("content:" + request.getParameter("content"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"发布成功\"";
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
	 * 用户回复使用反馈
	 * 
	 * @param userId
	 *            ,sessionid,content,type
	 * @return json
	 */
	@RequestMapping(value = "replyFeedback")
	public void replyFeedback(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("userId:" + request.getParameter("userId"));
		System.out.println("sessionid:" + request.getParameter("sessionid"));
		System.out.println("content:" + request.getParameter("content"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"发布成功\"";
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
	 * 用户获取使用过的已发和已收的快递接口
	 * 
	 * @param userId
	 *            ,sessionid
	 * @return json
	 */
	@RequestMapping(value = "findExpressListByUser")
	public void findExpressListByUser(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("userId:" + request.getParameter("userId"));
		System.out.println("sessionid:" + request.getParameter("sessionid"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"执行成功\",";
		json += "\"content\":{";
		json += "\"expressList\":[";
		json += "{\"expressId\":\"1\",\"logo\":\"logo\",\"company\":\"1\",\"type\":\"1\",\"orderCode\":\"111\",\"time\":\"2014-03-23 12:32\"},";
		json += "{\"expressId\":\"2\",\"logo\":\"logo\",\"company\":\"1\",\"type\":\"1\",\"orderCode\":\"111\",\"time\":\"2014-03-23 12:32\"}";
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
	 * 用户查看快递投诉详情
	 * 
	 * @param userId
	 *            ,sessionid,complaintId
	 * @return json
	 */
	@RequestMapping(value = "findExpressComplaint")
	public void findExpressComplaint(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("userId:" + request.getParameter("userId"));
		System.out.println("sessionid:" + request.getParameter("sessionid"));
		System.out
				.println("complaintId:" + request.getParameter("complaintId"));

		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"执行成功\",";
		json += "\"content\":{";
		json += "\"detail\":[";
		json += "{\"userId\":\"1\",\"avatar\":\"头像\",\"content\":\"我要投诉...\",\"time\":\"2014-03-23 12:32\"},";
		json += "{\"userId\":\"2\",\"avatar\":\"头像\",\"content\":\"我要投诉...\",\"time\":\"2014-03-23 12:32\"}";
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
	 * 用户发布快递服务投诉
	 * 
	 * @param userId
	 *            ,sessionid,complaintId,content
	 * @return json
	 */
	@RequestMapping(value = "publishExpressComplaint")
	public void publishExpressComplaint(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("userId:" + request.getParameter("userId"));
		System.out.println("sessionid:" + request.getParameter("sessionid"));
		System.out
				.println("complaintId:" + request.getParameter("complaintId"));
		System.out.println("content:" + request.getParameter("content"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"发布成功\",";
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
	 * 用户查看快递投诉进度接口
	 * 
	 * @param userId
	 *            ,sessionid
	 * @return json
	 */
	@RequestMapping(value = "findExpressSpeedListByUser")
	public void findExpressSpeedListByUser(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("userId:" + request.getParameter("userId"));
		System.out.println("sessionid:" + request.getParameter("sessionid"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"获取成功\",";
		json += "\"content\":{";
		json += "\"solving\":[";
		json += "{\"expressId\":\"1\",\"logo\":\"logo\",\"company\":\"1\",\"type\":\"1\",\"orderCode\":\"111\",\"time\":\"2014-03-23 12:32\",\"replierId\":12,\"lastReply\":\"最新回复\"},";
		json += "{\"expressId\":\"1\",\"logo\":\"logo\",\"company\":\"1\",\"type\":\"1\",\"orderCode\":\"111\",\"time\":\"2014-03-23 12:32\",\"replierId\":12,\"lastReply\":\"最新回复\"}";
		json += "],";
		json += "\"closed\":[";
		json += "{\"expressId\":\"1\",\"logo\":\"logo\",\"company\":\"1\",\"type\":\"1\",\"orderCode\":\"111\",\"time\":\"2014-03-23 12:32\",\"replierId\":12,\"lastReply\":\"最新回复\"},";
		json += "{\"expressId\":\"1\",\"logo\":\"logo\",\"company\":\"1\",\"type\":\"1\",\"orderCode\":\"111\",\"time\":\"2014-03-23 12:32\",\"replierId\":12,\"lastReply\":\"最新回复\"}";
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
	 * 用户评价快递投诉接口
	 * 
	 * @param userId
	 *            ,sessionid,evaluationGrade,ifTheSolution,orderCode
	 * @return json
	 */
	@RequestMapping(value = "publishExpressEvaluation")
	public void publishExpressEvaluation(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("userId:" + request.getParameter("userId"));
		System.out.println("sessionid:" + request.getParameter("sessionid"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"评价成功\",";
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
	 * 用户获取物业服务建议列表
	 * 
	 * @param userId
	 *            ,sessionid
	 * @return json
	 */
	@RequestMapping(value = "findPropertyAdviceListByUser")
	public void findPropertyAdviceListByUser(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("userId:" + request.getParameter("userId"));
		System.out.println("sessionid:" + request.getParameter("sessionid"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"获取成功\",";
		json += "\"content\":{";
		json += "\"adiceList\":[";
		json += "{\"userId\":\"1\",\"userName\":\"张三\",\"content\":\"建议内容\",\"time\":\"2014-03-23 12:32\",\"replierId\":1,\"lastReply\":\"最新回复\"},";
		json += "{\"userId\":\"2\",\"userName\":\"张三\",\"content\":\"建议内容\",\"time\":\"2014-03-23 12:32\",\"replierId\":1,\"lastReply\":\"最新回复\"}";
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
	 * 用户查看物业服务建议详情
	 * 
	 * @param userId
	 *            ,sessionid,adviceId
	 * @return json
	 */
	@RequestMapping(value = "findPropertyAdvice")
	public void findPropertyAdvice(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("userId:" + request.getParameter("userId"));
		System.out.println("sessionid:" + request.getParameter("sessionid"));
		System.out.println("adviceId:" + request.getParameter("adviceId"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"执行成功\",";
		json += "\"content\":{";
		json += "\"detail\":[";
		json += "{\"userId\":\"1\",\"avatar\":\"头像\",\"content\":\"我要建议...\",\"time\":\"2014-03-23 12:32\"},";
		json += "{\"userId\":\"2\",\"avatar\":\"头像\",\"content\":\"我要建议...\",\"time\":\"2014-03-23 12:32\"}";
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
	 * 用户发布物业服务建议
	 * 
	 * @param userId
	 *            ,sessionid,adviceId,content
	 * @return json
	 */
	@RequestMapping(value = "publishPropertyAdvice")
	public void publishPropertyAdvice(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("userId:" + request.getParameter("userId"));
		System.out.println("sessionid:" + request.getParameter("sessionid"));
		System.out.println("adviceId:" + request.getParameter("adviceId"));
		System.out.println("content:" + request.getParameter("content"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"发布成功\",";
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
	 * 用户获取物业投诉列表
	 * 
	 * @param userId
	 *            ,sessionid
	 * @return json
	 */
	@RequestMapping(value = "findPropertyComplaintListByUser")
	public void findPropertyComplaintListByUser(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("userId:" + request.getParameter("userId"));
		System.out.println("sessionid:" + request.getParameter("sessionid"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"获取成功\",";
		json += "\"content\":{";
		json += "\"solving\":[";
		json += "{\"userId\":\"1\",\"userName\":\"张三\",\"content\":\"投诉内容...\",\"time\":\"2014-03-23 12:32\",\"replierId\":1,\"lastReply\":\"最新回复\"},";
		json += "{\"userId\":\"2\",\"userName\":\"张三\",\"content\":\"建议内容...\",\"time\":\"2014-03-23 12:32\",\"replierId\":1,\"lastReply\":\"最新回复\"}";
		json += "],";
		json += "\"closed\":[";
		json += "{\"userId\":\"1\",\"userName\":\"张三\",\"content\":\"建议内容...\",\"time\":\"2014-03-23 12:32\",\"replierId\":1,\"lastReply\":\"最新回复\"},";
		json += "{\"userId\":\"1\",\"userName\":\"张三\",\"content\":\"建议内容...\",\"time\":\"2014-03-23 12:32\",\"replierId\":1,\"lastReply\":\"最新回复\"}";
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
	 * 用户查看物业服务投诉详情
	 * 
	 * @param userId
	 *            ,sessionid,complaintId
	 * @return json
	 */
	@RequestMapping(value = "findPropertyComplaint")
	public void findPropertyComplaint(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("userId:" + request.getParameter("userId"));
		System.out.println("sessionid:" + request.getParameter("sessionid"));
		System.out.println("complaintId:" + request.getParameter("complaintId"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"执行成功\",";
		json += "\"content\":{";
		json += "\"detail\":[";
		json += "{\"userId\":\"1\",\"avatar\":\"头像\",\"content\":\"我要投诉...\",\"time\":\"2014-03-23 12:32\"},";
		json += "{\"userId\":\"1\",\"avatar\":\"头像\",\"content\":\"我要投诉...\",\"time\":\"2014-03-23 12:32\"}";
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
	 * 用户发布物业服务投诉
	 * 
	 * @param userId
	 *            ,sessionid,complaintId,content
	 * @return json
	 */
	@RequestMapping(value = "publishPropertyComplaint")
	public void publishPropertyComplaint(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("userId:" + request.getParameter("userId"));
		System.out.println("sessionid:" + request.getParameter("sessionid"));
		System.out
				.println("complaintId:" + request.getParameter("complaintId"));
		System.out.println("content:" + request.getParameter("content"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"发布成功\",";
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
	 * 用户评价物业服务投诉接口
	 * 
	 * @param userId
	 *            ,sessionid,evaluationGrade,ifTheSolution,complaintId
	 * @return json
	 */
	@RequestMapping(value = "publishPropertyEvaluation")
	public void publishPropertyEvaluation(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("userId:" + request.getParameter("userId"));
		System.out.println("sessionid:" + request.getParameter("sessionid"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"评价成功\",";
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
	 * 用户设置新的回复通知配置
	 * 
	 * @param userId
	 *            ,sessionid,isMessageReply
	 * @return json
	 */
	@RequestMapping(value = "setMessageReply")
	public void setMessageReply(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("userId:" + request.getParameter("userId"));
		System.out.println("sessionid:" + request.getParameter("sessionid"));
		System.out.println("isMessageReply:"
				+ request.getParameter("isMessageReply"));
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"执行成功\",";
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
	 * 用户设置我的邻里求助是否结束推送的配置
	 * 
	 * @param userId
	 *            ,sessionid,type
	 * @return json
	 */
	@RequestMapping(value = "setSeekHelpMessageReply")
	public void setSeekHelpMessageReply(HttpServletRequest request,
			HttpServletResponse response,AppUserConfigQuery query) {
		String json = "";
		try{
			AppUserConfig appUserConfig = new AppUserConfig();
			Timestamp  ts=new Timestamp(new Date().getTime());
			appUserConfig.setEditTime(ts);
			appUserConfig.setHelpSwitch(query.getType());
	        appUserConfig.setUserId(query.getUserId());
	        appUserConfigService.update(appUserConfig);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"执行成功\"";
			json += "}";
		}catch(Exception e){
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"执行失败\"";
			json += "}";
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 用户设置我的二手是否接受推送的配置
	 * 
	 * @param userId
	 *            ,sessionid,type
	 * @return json
	 */
	@RequestMapping(value = "setSecondaryMarketMessageReply")
	public void setSecondaryMarketMessageReply(HttpServletRequest request,
			HttpServletResponse response,AppUserConfigQuery query) {
		String json = "";
		try{
			AppUserConfig appUserConfig = new AppUserConfig();
			Timestamp  ts=new Timestamp(new Date().getTime());
			appUserConfig.setEditTime(ts);
			appUserConfig.setMarketSwitch(query.getType());
	        appUserConfig.setUserId(query.getUserId());
	        appUserConfigService.update(appUserConfig);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"执行成功\"";
			json += "}";
		}catch(Exception e){
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"执行失败\"";
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
	 * 用户设置系统通知是否接受推送的配置
	 * 
	 * @param userId
	 *            ,sessionid,type
	 * @return json
	 */
	@RequestMapping(value = "setServiceSwitch")
	public void setServiceSwitch(HttpServletRequest request,
			HttpServletResponse response,AppUserConfigQuery query) {
		String json = "";
		try{
			AppUserConfig appUserConfig = new AppUserConfig();
			Timestamp  ts=new Timestamp(new Date().getTime());
			appUserConfig.setEditTime(ts);
			appUserConfig.setServiceSwitch(query.getType());
	        appUserConfig.setUserId(query.getUserId());
	        appUserConfigService.update(appUserConfig);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"执行成功\"";
			json += "}";
		}catch(Exception e){
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"执行失败\"";
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
	 * 用户设置快递通知是否接受推送的配置
	 * 
	 * @param userId
	 *            ,sessionid,type
	 * @return json
	 */
	@RequestMapping(value = "setExpressSwitch")
	public void setExpressSwitch(HttpServletRequest request,
			HttpServletResponse response,AppUserConfigQuery query) {
		String json = "";
		try{
			AppUserConfig appUserConfig = new AppUserConfig();
			Timestamp  ts=new Timestamp(new Date().getTime());
			appUserConfig.setEditTime(ts);
			appUserConfig.setExpressSwitch(query.getType());
	        appUserConfig.setUserId(query.getUserId());
	        appUserConfigService.update(appUserConfig);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"执行成功\"";
			json += "}";
		}catch(Exception e){
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"执行失败\"";
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
	 * 用户设置爆料通知是否接受推送的配置
	 * 
	 * @param userId
	 *            ,sessionid,type
	 * @return json
	 */
	@RequestMapping(value = "setBrokeSwitch")
	public void setBrokeSwitch(HttpServletRequest request,
			HttpServletResponse response,AppUserConfigQuery query) {
		String json = "";
		try{
			AppUserConfig appUserConfig = new AppUserConfig();
			Timestamp  ts=new Timestamp(new Date().getTime());
			appUserConfig.setEditTime(ts);
			appUserConfig.setBrokeSwitch(query.getType());
	        appUserConfig.setUserId(query.getUserId());
	        appUserConfigService.update(appUserConfig);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"执行成功\"";
			json += "}";
		}catch(Exception e){
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"执行失败\"";
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
	 * 用户设置爆料通知是否接受推送的配置
	 * 
	 * @param userId
	 *            ,sessionid,type
	 * @return json
	 */
	@RequestMapping(value = "setWeatherSwitch")
	public void setWeatherSwitch(HttpServletRequest request,
			HttpServletResponse response,AppUserConfigQuery query) {
		String json = "";
		try{
			AppUserConfig appUserConfig = new AppUserConfig();
			Timestamp  ts=new Timestamp(new Date().getTime());
			appUserConfig.setEditTime(ts);
			appUserConfig.setWeatherSwitch(query.getType());
	        appUserConfig.setUserId(query.getUserId());
	        appUserConfigService.update(appUserConfig);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"执行成功\"";
			json += "}";
		}catch(Exception e){
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"执行失败\"";
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
	 * 用户设置车辆限行通知是否接受推送的配置
	 * 
	 * @param userId
	 *            ,sessionid,type
	 * @return json
	 */
	@RequestMapping(value = "setLimitSwitch")
	public void setLimitSwitch(HttpServletRequest request,
			HttpServletResponse response,AppUserConfigQuery query) {
		String json = "";
		try{
			AppUserConfig appUserConfig = new AppUserConfig();
			Timestamp  ts=new Timestamp(new Date().getTime());
			appUserConfig.setEditTime(ts);
			appUserConfig.setLimitSwitch(query.getType());
	        appUserConfig.setUserId(query.getUserId());
	        appUserConfigService.update(appUserConfig);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"执行成功\"";
			json += "}";
		}catch(Exception e){
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"执行失败\"";
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
	 * 用户清理缓存
	 * 
	 * @param userId
	 *            ,sessionid
	 * @return json
	 */
	@RequestMapping(value = "clearMem")
	public void clearMem(HttpServletRequest request,
			HttpServletResponse response,AppUserQuery query) {
		String json = "";
		json += "{";
		json += "\"errorCode\":\"200\",";
		json += "\"message\":\"执行成功\"";
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
	 * 用户验证原密码
	 * 
	 * @param userId
	 *            ,sessionid,password
	 * @return json
	 */
	@RequestMapping(value = "verifyPassword")
	public void verifyPassword(HttpServletRequest request,
			HttpServletResponse response,AppUserQuery query) {
		String json = "";
		try{
			int count = appUserService.selectCount(query);
			if (count>0) {
				json += "{";
				json += "\"errorCode\":\"200\",";
				json += "\"message\":\"验证成功\"";
				json += "}";
			}else{
				json = "";
				json += "{";
				json += "\"errorCode\":\"400\",";
				json += "\"message\":\"验证失败\"";
				json += "}";
			}
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
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
	 * 用户修改密码
	 * 
	 * @param userId
	 *            ,sessionid,password
	 * @return json
	 */
	@RequestMapping(value = "changePassword")
	public void changePassword(HttpServletRequest request,
			HttpServletResponse response,AppUserQuery query) {
		String json = "";
		try{
			AppUser appUser = new AppUser();
			Timestamp  ts=new Timestamp(new Date().getTime());
	        appUser.setEditTime(ts);
	        appUser.setPassword(query.getPassword());
	        appUser.setTel(query.getCellphone());
			appUserService.updatePassword(appUser);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"保存成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
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
	 * 用户退出APP
	 * 
	 * @param userId
	 *            ,sessionid
	 * @return json
	 */
	@RequestMapping(value = "logout")
	public void logout(HttpServletRequest request, HttpServletResponse response,AppUserQuery query) {
		String json = "";
		try{
			AppUser appUser = new AppUser();
			Timestamp  ts=new Timestamp(new Date().getTime());
	        appUser.setEditTime(ts);
	        appUser.setBaiduId("");
	        appUser.setChannelId("");
	        appUser.setDeviceType(0);
	        appUser.setUserId(query.getUserId());
			appUserService.update(appUser);
			
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"退出成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
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
	 * APP获取首页信息，包括广告和新闻
	 * 
	 * @param userId
	 *            ,sessionid,estateId,stationId,comId,proId,page,rows
	 * @return json
	 */
	@RequestMapping(value = "getUserEstateIndex")
	public void getUserEstateIndex(HttpServletRequest request,
			HttpServletResponse response,AppHomepageQuery query) {
		Properties p = propertiesUtil.getProperties("config.properties");
		String ip = p.getProperty("imageIp");   
		String json = "";
		try{
			//获取快递信息
			int expState = 1;
			int expId = 0;
			AppLatestNewsQuery appLatestNewsQuery = new AppLatestNewsQuery();
			appLatestNewsQuery.setUserId(query.getUserId());
			appLatestNewsQuery.setTo(0);
			appLatestNewsQuery.setTypeId(26);
			List<AppLatestNews> latestlist = appLatestNewsService.findByExample(appLatestNewsQuery);
			for (AppLatestNews appLatestNews : latestlist) {
				BusinessExp businessExp = businessExpService.findById_app(appLatestNews.getSourceId());
				if (!(businessExp==null)) {
					if(businessExp.getExpState()==3){
						expState = 2;
						expId = businessExp.getExpId();
						break;
					}
				}
				
			}
			
			//获取焦点图
			query.setRows(15);
			query.setOrder("desc");
			query.setSort("publishTime");
			List<BusinessFocus> list = businessFocusService.findById_app(query.getEstateId());
			query.setTop(1);
			//获取最新
			BusinessNewsQuery businessNewsQuery = new BusinessNewsQuery();
			businessNewsQuery.setRows(15);
			businessNewsQuery.setOrder("desc");
			businessNewsQuery.setSort("publishTime");
			businessNewsQuery.setPublishScope(query.getComId());
			businessNewsQuery.setState(0);
			businessNewsQuery.setIsHot(1);
			BaseBean topBaseBean = businessNewsService.findAllPage_app(businessNewsQuery);

			
			BusinessProductQuery BusinessProductQuery = new BusinessProductQuery();
			BusinessProductQuery.setRows(15);
			BusinessProductQuery.setComId(query.getComId());
			BusinessProductQuery.setType(null);
			BusinessProductQuery.setDealState(0);
			BusinessProductQuery.setOrder("desc");
			BusinessProductQuery.setSort("editTime");
			//获取二手
			BaseBean productBaseBean = businessProductService.findAllPage_app(BusinessProductQuery);
			
			BusinessHelpQuery BusinessHelpQuery = new BusinessHelpQuery();
			BusinessHelpQuery.setRows(15);
			BusinessHelpQuery.setEstateId(query.getEstateId());
			BusinessHelpQuery.setOrder("desc");
			BusinessHelpQuery.setSort("editTime");
			BaseBean helpBaseBean = businessHelpService.findAllPage_app(BusinessHelpQuery);

			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"expState\":\""+expState+"\",";
			json += "\"expId\":\""+expId+"\",";
			json += "\"adList\":[";
			for (int i=0;i<list.size();i++) {
				if (i==4) {
					break;
				}
				BusinessFocus BusinessFocus = list.get(i);
				if(BusinessFocus.getSourceType()==0){
					json += "{\"pic\":\""+ip+BusinessFocus.getPicUrl()+"\",\"serviceCode\":\"30002\",\"title\":\""+BusinessFocus.getTitle()+"\",\"ID\":\""+BusinessFocus.getSourceId()+"\",\"focusId\":\""+BusinessFocus.getFocusId()+"\",";
					if(BusinessFocus.getIshtml()==1){
						json +="\"url\":\""+BusinessFocus.getPageUrl()+"\"";
					}else{
						json +="\"url\":\"\"";
					}
					json +="},";
				}else if (BusinessFocus.getSourceType()==1){
					json += "{\"pic\":\""+ip+BusinessFocus.getPicUrl()+"\",\"serviceCode\":\"30005\",\"title\":\""+BusinessFocus.getTitle()+"\",\"ID\":\""+BusinessFocus.getSourceId()+"\",\"focusId\":\""+BusinessFocus.getFocusId()+"\",";
					if(BusinessFocus.getIshtml()==1){
						json +="\"url\":\""+BusinessFocus.getPageUrl()+"\"";
					}else{
						json +="\"url\":\"\"";
					}
					json +="},";
				}else if (BusinessFocus.getSourceType()==2){
					json += "{\"pic\":\""+ip+BusinessFocus.getPicUrl()+"\",\"serviceCode\":\"30003\",\"title\":\""+BusinessFocus.getTitle()+"\",\"ID\":\""+BusinessFocus.getSourceId()+"\",\"focusId\":\""+BusinessFocus.getFocusId()+"\",";
					if(BusinessFocus.getIshtml()==1){
						json +="\"url\":\""+BusinessFocus.getPageUrl()+"\"";
					}else{
						json +="\"url\":\"\"";
					}
					json +="},";
				}else{
					json += "{\"pic\":\""+ip+BusinessFocus.getPicUrl()+"\",\"serviceCode\":\"30004\",\"title\":\""+BusinessFocus.getTitle()+"\",\"ID\":\""+BusinessFocus.getSourceId()+"\",\"focusId\":\""+BusinessFocus.getFocusId()+"\",";
					if(BusinessFocus.getIshtml()==1){
						json +="\"url\":\""+BusinessFocus.getPageUrl()+"\"";
					}else{
						json +="\"url\":\"\"";
					}
					json +="},";	
				}
			}
			if(list.size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "],";
			json += "\"news\":";
			if (topBaseBean.getList().size()==0) {
				json += "{\"ID\":\"\",\"title\":\"\",\"time\":\"\",\"brief\":\"\",";
				json +="\"pic\":\"\",";
				json +="\"comments\":\"\",";
				json +="\"publisherId\":\"\",\"publisherName\":\"\",\"avatar\":\"\",\"type\":\"0\"},";
			}else {
				for(int i=0;i<1;i++) {
					BusinessNews businessNews = (BusinessNews) topBaseBean.getList().get(i);
					json += "{\"ID\":\""+businessNews.getNewsId()+"\",\"title\":\""+businessNews.getTitle()+"\",\"time\":\""
					+DateUtil.getInterval(businessNews.getPublishTime())+"\",\"brief\":\""+businessNews.getBrief()+"\",";
					json +="\"pic\":\""+ip+businessNews.getSubjectPic()+"\",";
					json +="\"comments\":\""+businessNews.getComments()+"\",";
					if(businessNews.getNewsType()==1){
						json +="\"publisherId\":\""+businessNews.getPublisherId()+"\",\"publisherName\":\""+businessNews.getNickname()+"\",\"avatar\":\""+ip+businessNews.getPortrait()+"\",\"type\":\"1\"},";
					}else {
						json +="\"publisherId\":\""+businessNews.getPublisherId()+"\",\"publisherName\":\""+businessNews.getBuNickname()+"\",\"avatar\":\""+ip+businessNews.getAvatar()+"\",\"type\":\"0\"},";
					}
				}
			}
			
			
			json += "\"productList\":[";
			for(int i=0;i<productBaseBean.getList().size();i++) {
				if (i==4) {
					break;
				}
				BusinessProduct businessProduct = (BusinessProduct) productBaseBean.getList().get(i);
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
			if(productBaseBean.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "],";
			
			json += "\"helpList\":[";
			for(int i=0;i<helpBaseBean.getList().size();i++) {
				if (i==2) {
					break;
				}
				BusinessHelp businessHelp = (BusinessHelp) helpBaseBean.getList().get(i);
				json += "{";
				json += "\"ID\":\""+businessHelp.getHelpId()+"\",";
				json += "\"time\":\""+DateUtil.getInterval(businessHelp.getHelpTime())+"\",";
				json += "\"brief\":\""+businessHelp.getHelpContent()+"\",";
				json += "\"publisherId\":\""+businessHelp.getNickname()+"\",";
				if(businessHelp.getIsNickname()==1){
					json += "\"publisherName\":\"小区居民\",";
				}else {
					json += "\"publisherName\":\""+businessHelp.getHelperName()+"\",";
				}
				json += "\"avatar\":\""+ip+businessHelp.getPortrait()+"\",";
				json += "\"supports\":\""+businessHelp.getSupports()+"\",";
				json += "\"comments\":\""+businessHelp.getComments()+"\"";
				json += "},";
			}
			if(helpBaseBean.getList().size() > 0) {
				json = json.substring(0, json.length()-1);
			}
			json += "],";
			
			json += "\"mall\":{";
			json += "\"title\":\"新年大集\",";		
			json += "\"url\":\"http://www.taobao.com/\",";		
			json += "\"list\":[";
			json += "{\"ID\":\"1\",\"price\":\"11\",\"brief\":\"江西赣南脐橙12个（约200g-250g）\",\"pic\":\"http://img03.taobaocdn.com/imgextra/i2/TB1EnURGXXXXXbYaXXXXXXXXXXX_!!0-item_pic.jpg_160x160q90.jpg\",\"url\":\"http://detail.tmall.com/item.htm?spm=a3204.7139825.7139825.4.m0XdpH&id=42260938716&acm=lb-tms-1172644-41436.1003.4.129940&scm=1003.4.lb-tms-1172644-41436.ITEM_42260938716_129940\"},";
			json += "{\"ID\":\"2\",\"price\":\"11\",\"brief\":\"皮薄肉嫩 酸甜畅享\",\"pic\":\"http://img03.taobaocdn.com/imgextra/i1/TB1Abr4GpXXXXbkaXXXXXXXXXXX_!!0-item_pic.jpg_160x160q90.jpg\",\"url\":\"http://detail.tmall.com/item.htm?spm=a3204.7139825.7139825.5.m0XdpH&id=42296726901&acm=lb-tms-1172644-41436.1003.4.129940&scm=1003.4.lb-tms-1172644-41436.ITEM_42296726901_129940\"},";
			json += "{\"ID\":\"3\",\"price\":\"11\",\"brief\":\"新疆阿克苏冰糖心苹果5斤 超大果(果径85-90mm)\",\"pic\":\"http://img03.taobaocdn.com/imgextra/i3/TB1GAk8GVXXXXXmXFXXXXXXXXXX_!!0-item_pic.jpg_160x160q90.jpg\",\"url\":\"http://chaoshi.detail.tmall.com/item.htm?&spm=a3204.7139825.7139825.6.m0XdpH&acm=lb-tms-1172644-41436.1003.4.129940&scm=1003.4.lb-tms-1172644-41436.ITEM_43027834257_129940&userBucket=4&id=43027834257\"}";
			json += "]";
			json += "}";

			
			
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
			appStatisticsClick.setType(0);
			appStatisticsClick.setTypeName("首页列表");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	/**
	 * 用户查看首页信息详情
	 * 
	 * @param userId
	 *            ,sessionid,ID,serviceCode
	 * @return json
	 */
	@RequestMapping(value = "getUserEstateIndexDetail")
	public void getUserEstateIndexDetail(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("userId:" + request.getParameter("userId"));
		System.out.println("sessionid:" + request.getParameter("sessionid"));
		String json = "";

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
	 * 用户点击查看服务信息
	 * 根据serviceCode重定向至不同接口
	 * @param userId
	 *            ,sessionid,serviceCode,page,rows
	 * @return json
	 */
	@RequestMapping(value = "getSriveceByServiceCode")
	public ModelAndView getSriveceByServiceCode(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = null;
		if ("30002".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/commiunity/findByJournalism.json");
		}else if ("30003".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/station/findByStation.json");
		}else if ("30004".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/property/findByProperty.json");
		}else if ("30005".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/activities/findByActivities.json");
		}else if ("30006".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/seekHelp/findBySeekHelp.json");
		}else if ("30007".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/express/findListByEstate.json");
		}else if ("30008".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/secondaryMarket/findBySecondaryMarket.json");
		}else if ("30009".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/commiunity/findByJournalism.json");
		}else if ("30011".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/station/findByStationGril.json");
		}else if ("30012".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service /station/getStationById.json");
		}else if ("30013".equals(request.getParameter("serviceCode"))) {

		}else if ("30017".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/property/findByUserRepair.json");
		}else if ("30018".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/property/getPropertyManual.json");
		}else if ("30019".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/property/getPropertyManual.json");
		}else if ("30020".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/property/getPropertyManual.json");
		}
		mav.addObject("userId", request.getParameter("userId"));
		mav.addObject("sessionid", request.getParameter("sessionid"));
		mav.addObject("serviceCode", request.getParameter("serviceCode"));
		mav.addObject("page", request.getParameter("page"));
		mav.addObject("rows", request.getParameter("rows"));
		mav.addObject("type", request.getParameter("type"));
		mav.addObject("typeId", request.getParameter("typeId"));
		mav.addObject("estateId", request.getParameter("estateId"));
		mav.addObject("comId", request.getParameter("comId"));
		mav.addObject("stationId", request.getParameter("stationId"));
		mav.addObject("dealType", request.getParameter("dealType"));
		mav.addObject("like", request.getParameter("like"));
		return mav;
	}

	/**
	 * 用户点击查看服务列表详情
	 * 
	 * @param userId
	 *            ,sessionid,serviceCode,ID
	 * @return json
	 */
	@RequestMapping(value = "getSriveceDetailsByServiceCode")
	public ModelAndView getSriveceDetailsByServiceCode(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = null;
		if ("30002".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/commiunity/getJournalismDetailsById.json");
		}else if ("30003".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/station/getStation DetailsById.json");
		}else if ("30004".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/property/getPopertyDetailsById.json");
		}else if ("30005".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/activities/getActivitiesDetailsById.json");
		}else if ("30006".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/seekHelp/getSeekHelpDetailsById.json");
		}else if ("30008".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/secondaryMarket/getsecondaryMarketDetailsById.json");
		}
		mav.addObject("userId", request.getParameter("userId"));
		mav.addObject("sessionid", request.getParameter("sessionid"));
		mav.addObject("serviceCode", request.getParameter("serviceCode"));
		mav.addObject("ID", request.getParameter("ID"));
		return mav;
	}

	/**
	 * 用户点击查看服务评论接口
	 * 
	 * @param userId
	 *            ,sessionid,serviceCode,ID,page,rows
	 * @return json
	 */
	@RequestMapping(value = "getSriveceDetailsReviewByServiceCode")
	public ModelAndView getSriveceDetailsReviewByServiceCode(
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		if ("30002".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/commiunity/getJournalismReviewById.json");
		}else if ("30003".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/station/getStationReviewById.json");
		}else if ("30004".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/property/getPopertyReviewById.json");
		}else if ("30005".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/activities/getActivitiesReviewById.json");
		}else if ("30006".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/seekHelp/getSeekHelpReviewById.json");
		}else if ("30008".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/secondaryMarket/getSecondaryMarketReviewById.json");
		}
		mav.addObject("userId", request.getParameter("userId"));
		mav.addObject("sessionid", request.getParameter("sessionid"));
		mav.addObject("serviceCode", request.getParameter("serviceCode"));
		mav.addObject("ID", request.getParameter("ID"));
		mav.addObject("page", request.getParameter("page"));
		mav.addObject("rows", request.getParameter("rows"));
		return mav;
	}

	/**
	 * 用户使用点赞功能
	 * 
	 * @param userId
	 *            ,sessionid,serviceCode,ID
	 * @return json
	 */
	@RequestMapping(value = "support")
	public ModelAndView support(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		if ("30002".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/commiunity/supportJournalism.json");
		}else if ("30003".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/station/supportStation.json");
		}else if ("30004".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/property/supportProperty.json");
		}else if ("30005".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/activities/supportActivities.json");
		}else if ("30006".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/seekHelp/supportSeekHelp.json");
		}else if ("30008".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/secondaryMarket/supportSecondaryMarket.json");
		}
		mav.addObject("userId", request.getParameter("userId"));
		mav.addObject("sessionid", request.getParameter("sessionid"));
		mav.addObject("serviceCode", request.getParameter("serviceCode"));
		mav.addObject("ID", request.getParameter("ID"));
		return mav;
	}

	/**
	 * 用户使用评论功能
	 * 
	 * @param userId
	 *            ,sessionid,serviceCode,ID,content
	 * @return json
	 */
	@RequestMapping(value = "review")
	public ModelAndView review(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = null;
		if ("30002".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/commiunity/saveJournalismReview.json");
		}else if ("30003".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/activities/saveActivitiesReview.json");
		}else if ("30004".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/property/savePopertyReview.json");
		}else if ("30005".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/activities/saveActivitiesReview.json");
		}else if ("30006".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/seekHelp/saveSeekHelpReview.json");
		}else if ("30008".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/secondaryMarket/saveSecondaryMarketReview.json");
		}
		mav.addObject("userId", request.getParameter("userId"));
		mav.addObject("sessionid", request.getParameter("sessionid"));
		mav.addObject("serviceCode", request.getParameter("serviceCode"));
		mav.addObject("ID", request.getParameter("ID"));
		mav.addObject("content", request.getParameter("content"));
		return mav;
	}

	/**
	 * 用户使用回复功能
	 * 
	 * @param userId
	 *            ,sessionid,serviceCode,ID,content,replyId,replyName
	 * @return json
	 */
	@RequestMapping(value = "ReplyReview")
	public ModelAndView ReplyReview(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = null;
		if ("30002".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/commiunity/saveJournalismReply.json");
		}else if ("30003".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/activities/saveActivitiesReply.json");
		}else if ("30004".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/property/savePropertyReply.json");
		}else if ("30005".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/activities/saveActivitiesReply.json");
		}else if ("30006".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/seekHelp/saveSeekHelpReply.json");
		}else if ("30008".equals(request.getParameter("serviceCode"))) {
			mav = new ModelAndView("redirect:/service/secondaryMarket/saveSecondaryMarketReply.json");
		}
		mav.addObject("userId", request.getParameter("userId"));
		mav.addObject("sessionid", request.getParameter("sessionid"));
		mav.addObject("serviceCode", request.getParameter("serviceCode"));
		mav.addObject("ID", request.getParameter("ID"));
		mav.addObject("content", request.getParameter("content"));
		mav.addObject("replyId", request.getParameter("replyId"));
		mav.addObject("replyName", request.getParameter("replyName"));
		return mav;
	}

	/**
	 * 用户查看生活黄页
	 * 
	 * @param userId
	 *            ,sessionid
	 * @return json businessTelGroupService
	 */
	@RequestMapping(value = "findByLifeTel")
	public void findByLifeTel(HttpServletRequest request,
			HttpServletResponse response,BusinessTelGroupQuery query) {
		String json = "";
		try{
			query.setCityId(1);
			List<BusinessTelGroup> groupList = businessTelGroupService.findByExample(query);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"获取成功\",";
			json += "\"content\":{";
			json += "\"list\":[";
			for (BusinessTelGroup businessTelGroup : groupList) {
				BusinessTelQuery businessTelQuery = new BusinessTelQuery();
				businessTelQuery.setGroupId(businessTelGroup.getGroupId());
				List<BusinessTel> telList = businessTelService.findByExample(businessTelQuery);
				json += "{\"title\":\""+businessTelGroup.getGroupName()+"\",\"data\":[";
				for (BusinessTel businessTel : telList) {
					json += "{\"telName\":\""+businessTel.getTelName()+"\",\"tel\":\""+businessTel.getTel()+"\"},";
				}
				if(telList.size() > 0) {
					json = json.substring(0, json.length()-1);
				}
				json += "]";
				json += "},";
			}
			if(groupList.size() > 0) {
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
			appStatisticsClick.setType(44);
			appStatisticsClick.setTypeName("社区黄页");
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 用户点击app焦点图
	 * 
	 * @param userId
	 *            ,sessionid,password
	 * @return json
	 */
	@RequestMapping(value = "updateFocusVisits")
	public void updateFocusVisits(HttpServletRequest request,
			HttpServletResponse response,BusinessFocusQuery query) {
		String json = "";
		try{
			BusinessFocus businessFocus = new BusinessFocus();
			Timestamp  ts=new Timestamp(new Date().getTime());
			businessFocus.setFocusId(query.getFocusId());
	        businessFocusService.updateVisits(businessFocus);
			json += "{";
			json += "\"errorCode\":\"200\",";
			json += "\"message\":\"保存成功\"";
			json += "}";
		}catch(Exception e){
			json = "";
			json += "{";
			json += "\"errorCode\":\"400\",";
			json += "\"message\":\"保存失败\"";
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
	 * 用户点击统计数量
	 * 
	 * @param userId
	 *            ,sessionid
	 * @return json businessTelGroupService
	 */
	@RequestMapping(value = "saveAppStatisticsClick")
	public void saveAppStatisticsClick(HttpServletRequest request,
			HttpServletResponse response,AppStatisticsClickQuery query) {
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
			appStatisticsClick.setType(query.getType());
			appStatisticsClick.setTypeName(query.getTypeName());
			appStatisticsClickService.save(appStatisticsClick);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 进入h5登录页
	 * @return
	 */
	@RequestMapping(value="loginIndex")
	public ModelAndView enter(HttpServletRequest request, HttpServletResponse response) {	
		ModelAndView mav = new ModelAndView("/service/login");
		try{
			String path = request.getContextPath();
			String type = request.getParameter("type");
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
			mav.addObject("ctx", ctx);
			if ("4".equals(type)) {
				mav.addObject("url","service/activities/getActivitiesDetailsById.json");
			}
			mav.addObject("ID", request.getParameter("ID"));
			mav.addObject("type", request.getParameter("type"));
		}catch(Exception e){
			GSLogger.error("进入h5登录野发生错误：/service/login", e);
			e.printStackTrace();
		}
		
		return mav;
	}
	
	/**
	 * 进入手机验证页
	 * @return
	 */
	@RequestMapping(value="cellphone")
	public ModelAndView cellphone(HttpServletRequest request, HttpServletResponse response) {	
		ModelAndView mav = new ModelAndView("/service/cellphone");
		try{
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
			mav.addObject("ctx", ctx);
			mav.addObject("estateId", request.getParameter("estateId"));
			mav.addObject("estateName", request.getParameter("estateName"));
			mav.addObject("comName", request.getParameter("comName"));
			mav.addObject("ID", request.getParameter("ID"));
			mav.addObject("type", request.getParameter("type"));
		}catch(Exception e){
			GSLogger.error("进入手机验证页", e);
			e.printStackTrace();
		}
		
		return mav;
	}
	
	/**
	 * 进入密码填写页面
	 * @return
	 */
	@RequestMapping(value="passwordIndex")
	public ModelAndView passwordIndex(HttpServletRequest request, HttpServletResponse response) {	
		ModelAndView mav = new ModelAndView("/service/passwordIndex");
		try{
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
			mav.addObject("ctx", ctx);
			String type = request.getParameter("type");
			if ("4".equals(type)) {
				mav.addObject("url","service/activities/getActivitiesDetailsById.json");
			}
			mav.addObject("estateId", request.getParameter("estateId"));
			mav.addObject("cellphone", request.getParameter("cellphone"));
			mav.addObject("isRegist", request.getParameter("isRegist"));
			mav.addObject("ID", request.getParameter("ID"));
			mav.addObject("type", request.getParameter("type"));
		}catch(Exception e){
			GSLogger.error("进入密码填写页面发生错误：/service/passwordIndex", e);
			e.printStackTrace();
		}
		
		return mav;
	}
	
	/**
	 * 重置密码验证页
	 * @return
	 */
	@RequestMapping(value="resetIndex")
	public ModelAndView ResetIndex(HttpServletRequest request, HttpServletResponse response) {	
		ModelAndView mav = new ModelAndView("/service/resetIndex");
		try{
			String path = request.getContextPath();
			String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path; 
			mav.addObject("ctx", ctx);
			mav.addObject("ID", request.getParameter("ID"));
			mav.addObject("type", request.getParameter("type"));
		}catch(Exception e){
			GSLogger.error("进入重置密码验证页", e);
			e.printStackTrace();
		}
		
		return mav;
	}
	
	/**
	 * 微信用户第三方登录或注册
	 * 
	 * @param userId
	 *            ,sessionid,password
	 * @return json
	 */
	@RequestMapping(value = "thirdPartyLogin")
	public ModelAndView thirdPartyLogin(HttpServletRequest request,
			HttpServletResponse response,BusinessFocusQuery query) {
		ModelAndView mav = null;
		try{
			String openid = request.getParameter("openid");
			String nickname = request.getParameter("nickname");
			String type = request.getParameter("type");
			String ID = request.getParameter("ID");
			AppUserQuery appUserQuery = new AppUserQuery();
			appUserQuery.setWenxinId(openid);
			List<AppUser> list = appUserService.findByExample(appUserQuery);
			if (list==null || list.size()==0) {
				mav = new ModelAndView("redirect:/service/commiunity/index.json");
				request.getSession().setAttribute("openid", openid);
				request.getSession().setAttribute("nickname", nickname);
				mav.addObject("ID", ID);
				mav.addObject("type", type);
			}else{
				if ("4".equals(type)) {
					mav = new ModelAndView("redirect:/service/activities/getActivitiesDetailsById.json");
					mav.addObject("ID", ID);
					mav.addObject("userId",list.get(0).getUserId());
					mav.addObject("tel",list.get(0).getTel());
					mav.addObject("download","0");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	/**
	 * qq用户第三方登录或注册
	 * 
	 * @param userId
	 *            ,sessionid,password
	 * @return json
	 */
	@RequestMapping(value = "qqThirdPartyLogin")
	public ModelAndView qqThirdPartyLogin(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = null;
		try{
			AccessToken accessTokenObj = (new Oauth()).getAccessTokenByRequest(request);
			String accessToken   = null,
			QQopenid   = null;
			String nickname = "";
			long tokenExpireIn = 0L;
            if (accessTokenObj.getAccessToken().equals("")) {
//              我们的网站被CSRF攻击了或者用户取消了授权
//              做一些数据统计工作
              System.out.print("没有获取到响应参数");
          } else {
              accessToken = accessTokenObj.getAccessToken();
              tokenExpireIn = accessTokenObj.getExpireIn();
              request.getSession().setAttribute("demo_access_token", accessToken);
              request.getSession().setAttribute("demo_token_expirein", String.valueOf(tokenExpireIn));
              // 利用获取到的accessToken 去获取当前用的openid -------- start
              OpenID openIDObj =  new OpenID(accessToken);
              QQopenid = openIDObj.getUserOpenID();
              request.getSession().setAttribute("demo_openid", QQopenid);
             
              // 利用获取到的accessToken,openid 去获取用户在Qzone的昵称等信息 
              UserInfo qzoneUserInfo = new UserInfo(accessToken, QQopenid);
              UserInfoBean userInfoBean = qzoneUserInfo.getUserInfo();

              if (userInfoBean.getRet() == 0) {
            	  nickname = userInfoBean.getNickname();
//                  out.println(userInfoBean.getNickname() + "<br/>");
//                  out.println(userInfoBean.getGender() + "<br/>");
//                  out.println("黄钻等级： " + userInfoBean.getLevel() + "<br/>");
//                  out.println("会员 : " + userInfoBean.isVip() + "<br/>");
              } else {
                  System.out.println("很抱歉，我们没能正确获取到您的信息，原因是： " + userInfoBean.getMsg());
              }              
          }
			
			
			
			String actArgs = request.getParameter("actArgs");
			
			String type = actArgs.split(",")[0];
			String ID = actArgs.split(",")[1];
			
			AppUserQuery appUserQuery = new AppUserQuery();
			appUserQuery.setQqId(QQopenid);
			List<AppUser> list = appUserService.findByExample(appUserQuery);
			if (list==null || list.size()==0) {
				mav = new ModelAndView("redirect:/service/commiunity/index.json");
				request.getSession().setAttribute("QQopenid", QQopenid);
				request.getSession().setAttribute("nickname", nickname);
				mav.addObject("ID", ID);
				mav.addObject("type", type);
			}else{
				if ("4".equals(type)) {
					mav = new ModelAndView("redirect:/service/activities/getActivitiesDetailsById.json");
					mav.addObject("ID", ID);
					mav.addObject("userId",list.get(0).getUserId());
					mav.addObject("tel",list.get(0).getTel());
					mav.addObject("download","0");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
}
