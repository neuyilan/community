package com.community.app.module.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.community.app.module.bean.BusinessCommunity;
import com.community.app.module.bean.BusinessMenu;
import com.community.app.module.bean.ManageEstate;
import com.community.app.module.bean.ManageUserFunction;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.common.EstateBean;
import com.community.app.module.common.MenuComparator;
import com.community.app.module.common.UserMenuBean;
import com.community.app.module.service.BusinessAnnoService;
import com.community.app.module.service.BusinessCommunityService;
import com.community.app.module.service.BusinessDepartmentService;
import com.community.app.module.service.BusinessMenuService;
import com.community.app.module.service.BusinessPositionService;
import com.community.app.module.service.BusinessUserService;
import com.community.app.module.service.ManageEstateService;
import com.community.app.module.service.ManageModuleService;
import com.community.app.module.service.ManageModulemenuService;
import com.community.app.module.service.ManageUserFunctionService;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessAnnoQuery;
import com.community.framework.utils.CommonUtils;

@Controller
@RequestMapping(value = "/index")
public class IndexController {
	
	@Autowired
	protected BusinessUserService businessUserService;
	
	@Autowired
	protected BusinessMenuService businessMenuService ;
	
	@Autowired
	protected ManageModuleService manageModuleService;
	
	@Autowired
	protected ManageModulemenuService manageModulemenuService;
	
	@Autowired
	protected BusinessPositionService businessPositionService;
	
	@Autowired
	protected BusinessDepartmentService businessDepartmentService;
	
	@Autowired
	protected ManageUserFunctionService manageUserFunctionService;
	
	@Autowired
	protected BusinessAnnoService businessAnnoService;
	
	@Autowired
	protected ManageEstateService manageEstateService;
	
	@Autowired
	protected BusinessCommunityService businessCommunityService;
	
	@Autowired
	private SessionDAO sessionDAO;
	
	/**
	 * 登入管理首页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/main")
	public ModelAndView main(HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelView = new ModelAndView("/module/main");
		//当前用户标识
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser)currentUser.getPrincipal();
		//验证是否认证用户
		if(shiroUser == null || !currentUser.isAuthenticated()) {//未认证用户跳转到登录
			modelView.addObject("message", "抱歉，您不是我们的有效用户!");
			modelView.setViewName("/login");
			return modelView;
		}
		
		//切换小区搜索条件
		String estateCondition = "";
		if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
			estateCondition = " and res.estateId = " + shiroUser.getCurEstateId();
		}
		//切换社区搜索条件
		String communityCondition = "";
		if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
			communityCondition = " and res.comId = "+shiroUser.getCurComId();
		}
		
		//按角色分别统计数据
		/*String orgType = "";
		if(shiroUser.getCurOrgType() != null && !"".equals(shiroUser.getCurOrgType())) {
			orgType = shiroUser.getCurOrgType();
		}else{
			orgType = shiroUser.getOrgType();
		}*/
		
		//非运营人员可以带ID查看相关数据
		String userCondition = "";
//		if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) {
			userCondition = " and res.userId = " + shiroUser.getUserId();
//		}
		
		//物业
		//if(ModuleConst.PROPERTY_CODE.equals(orgType)) {
			if (currentUser.isPermitted("index_property_verified_resident")) {
				//验证居民
				int verifiedResidents = 0;/*businessUserService.countBySql(
						"select count(distinct(u.userId)) FROM app_user u inner JOIN  app_estate_user b ON  u.userId = b.userId inner join business_user_resource res on res.estateId = b.estateId where u.`type` = 1 " + userCondition + estateCondition);*/
				modelView.addObject("verifiedResidents", verifiedResidents);	
			}
			
			if (currentUser.isPermitted("index_property_today_registed")) {
				//物业当日注册居民
				int propertyRegistedResidentsOnDay = 0;/* businessUserService.countBySql(
						"select count(distinct(u.userId)) FROM app_user u inner JOIN  app_estate_user b ON  u.userId = b.userId inner join business_user_resource res on res.estateId = b.estateId where 0 = DATEDIFF(now(), u.registTime) " + userCondition + estateCondition);*/
				modelView.addObject("propertyRegistedResidentsOnDay", propertyRegistedResidentsOnDay);	
			}
			
			if (currentUser.isPermitted("index_property_today_verified")) {
				//物业当日验证居民
				int propertyVerifiedResidentsOnDay = 0; /*businessUserService.countBySql(
						"select count(distinct(u.userId)) FROM app_user u inner JOIN  app_estate_user b ON  u.userId = b.userId inner join business_user_resource res on res.estateId = b.estateId where u.type = 1 and 0 = DATEDIFF(now(), u.verifyTime) " + userCondition + estateCondition);*/
				modelView.addObject("propertyVerifiedResidentsOnDay", propertyVerifiedResidentsOnDay);	
			}
			
			if (currentUser.isPermitted("index_property_unrepair_handler")) {
				//未报修处理
				int unresolvedRepair = 0;/* businessUserService.countBySql("select count(distinct(re.repairId)) from business_repair re inner join business_user_resource res on res.estateId = re.estateId WHERE re.repairState = 0 " + userCondition + estateCondition);*/
				modelView.addObject("unresolvedRepair", unresolvedRepair);	
			}
			
			if (currentUser.isPermitted("index_property_unreply_feedback")) {
				//未回复反馈
				int unreplied = 0; /*businessUserService.countBySql("select count(distinct(fb.feedbackId)) from business_feedback fb left join app_user u on fb.fberId = u.userId inner join business_user_resource res on res.estateId = fb.estateId WHERE (fb.fbType=0 or fb.fbType=1) and fb.fbState = 0 " + userCondition + estateCondition);*/
				modelView.addObject("unreplied", unreplied);	
			}
			
			if (currentUser.isPermitted("index_property_anno_comment")) {
				//今日公告评论数量
				int propCommentedAnno = 0; /*businessUserService.countBySql("select count(distinct(c.commentId)) as count from business_anno_comment c inner join business_anno a on c.annoId = a.annoId inner join business_anno_scope sc on sc.annoId = a.annoId inner join business_user_resource res on res.estateId = sc.estateId where 0 = DATEDIFF(now(), c.commentTime) and (a.annoType = 0 or a.annoType = 1 ) " + userCondition + estateCondition);*/
				modelView.addObject("propCommentedAnno", propCommentedAnno);	
			}
			
		//}
		//else
		//驿站
		//if(ModuleConst.STATION_CODE.equals(orgType)) {
			if (currentUser.isPermitted("index_station_anno_comment")) {
				//公告评论数量
				int stationCommentedAnno = 0; /*businessUserService.countBySql("select count(distinct(c.commentId)) as count from business_anno_comment c inner join business_anno a on c.annoId = a.annoId inner join business_anno_scope sc on sc.annoId = a.annoId inner join business_user_resource res on res.estateId = sc.estateId where a.annoType = 4 " + userCondition + estateCondition);*/
				modelView.addObject("stationCommentedAnno", stationCommentedAnno);
			}
			
			if (currentUser.isPermitted("index_station_unsolved_express")) {
				//未处理快递服务
				int unresolvedExp = 0; /*businessUserService.countBySql("select count(distinct(e.expId)) from business_exp e inner join business_station s on s.stationId = e.stationId inner join manage_estate es on es.stationId = s.stationId inner join business_user_resource res on res.estateId = es.estateId WHERE (e.expState = 0) " + userCondition + estateCondition);*/
				modelView.addObject("unresolvedExp", unresolvedExp);
			}
			
			if (currentUser.isPermitted("index_station_unreply_help")) {
				//未回复求助信息
				int unrepliedHelp = 0; /*businessUserService.countBySql("select count(distinct(h.helpId)) from business_help h left join app_user u on u.userId=h.helperId inner join business_user_resource res on res.estateId = h.estateId WHERE h.state = 0 " + userCondition + estateCondition);*/
				modelView.addObject("unrepliedHelp", unrepliedHelp);
			}
			
			if (currentUser.isPermitted("index_station_going_activity")) {
				//进行中的活动
				int gointActivity = 0; /*businessUserService.countBySql("select count(distinct(a.actId)) from business_activity a inner join business_activity_scope s on s.actId = a.actId inner join business_user_resource res on res.estateId = s.estateId WHERE (a.state = 0 or a.state = 1) " + userCondition + estateCondition);*/
				modelView.addObject("gointActivity", gointActivity);	
			}
			
			if (currentUser.isPermitted("index_station_unsolved_feedback")) {
				//未处理居民反馈
				int unresolvedFeedback = 0; /* businessUserService.countBySql("select count(distinct(fb.feedbackId)) from business_feedback fb left join app_user u on fb.fberId = u.userId inner join business_user_resource res on res.estateId = fb.estateId WHERE (fb.fbType=3 or fb.fbType=4) and  fb.fbState = 0 " + userCondition + estateCondition);*/
				modelView.addObject("unresolvedFeedback", unresolvedFeedback);
			}
			
			
		//}
		//else
		//社区报
		//if(ModuleConst.COMMUNITY_CODE.equals(orgType)) {
			
			if (currentUser.isPermitted("index_com_news_comment")) {
				//今日新闻评论
				int commentsNews = 0 ; /* businessUserService.countBySql("select count(distinct(c.commentId)) from business_news_comment c inner join business_news n on c.newsId = n.newsId inner join business_news_scope scope on n.newsId = scope.newsId inner join business_user_resource res on res.comId = scope.comId where 0 = DATEDIFF(now(), c.commentTime) " + userCondition + communityCondition);*/
				modelView.addObject("commentsNews", commentsNews);	
			}
			
			if (currentUser.isPermitted("index_com_unsolved_break")) {
				//未处理网友爆料
				int unresolvedBreak = 0; /* businessUserService.countBySql("select count(distinct(b.breakId)) from business_break b inner join business_user_resource res on res.comId = b.comId WHERE b.state = 0 " + userCondition + communityCondition);*/
				modelView.addObject("unresolvedBreak", unresolvedBreak);
			}
			
			if (currentUser.isPermitted("index_com_auding_news")) {
				//待审核新闻
				int auditingNews = 0; /*businessUserService.countBySql("select count(distinct(n.newsId)) from business_news n inner join business_news_scope scope on n.newsId = scope.newsId inner join business_user_resource res on res.comId = scope.comId WHERE n.state = 2 " + userCondition + communityCondition);*/
				modelView.addObject("auditingNews", auditingNews);
			}
			
			/*if (currentUser.isPermitted("index_property_verified_resident")) {
				//待审核位置
				int auditingLife = businessUserService.countBySql("select count(1) as count from business_life l where l.pulishState = 1 ");
				modelView.addObject("auditingLife", auditingLife);
			}*/
			
			if (currentUser.isPermitted("index_com_goting_activity")) {
				//进行中的活动
				int comGoingActivity = 0; /* businessUserService.countBySql("select count(distinct(a.actId)) from business_activity a inner join business_activity_scope s on s.actId = a.actId inner join business_user_resource res on res.estateId = s.estateId WHERE (a.state = 0 or a.state = 1)  " + userCondition + communityCondition);*/
				modelView.addObject("comGoingActivity", comGoingActivity);	
			}
			
			if (currentUser.isPermitted("index_station_audting_market")) {
				//待审核二手信息
				int auditingMarket = 0; /*businessUserService.countBySql("select count(distinct(p.productId)) from business_product p inner join business_user_resource res on res.estateId = p.estateId WHERE p.dealState = 1 " + userCondition + estateCondition);*/
				modelView.addObject("auditingMarket", auditingMarket);	
			}
			
		//}
		//else
		//运营
		//if(ModuleConst.OPERATION_CODE.equals(orgType)) {
			
			if (currentUser.isPermitted("index_operation_regist_resident")) {
				//已有注册居民
				int regisitedResident = 0; /* businessUserService.countBySql("select count(1) as count from app_user u where u.type = 1 ");*/
				modelView.addObject("regisitedResident", regisitedResident);	
			}
			
			if (currentUser.isPermitted("index_operation_today_registed")) {
				//当日注册居民
				int operationRegistedResidentsOnDay = 0;/* businessUserService.countBySql(
						"select count(1) as count from app_user u where 0 = DATEDIFF(now(), u.registTime) ");*/
				modelView.addObject("operationRegistedResidentsOnDay", operationRegistedResidentsOnDay);	
			}

			if (currentUser.isPermitted("index_operation_today_verified")) {
				//当日验证居民
				int operationVerifiedResidentsOnDay = 0; /* businessUserService.countBySql(
						"select count(1) as count from app_user u where u.type = 1 and 0 = DATEDIFF(now(), u.verifyTime) ");*/
				modelView.addObject("operationVerifiedResidentsOnDay", operationVerifiedResidentsOnDay);	
			}
			
			if (currentUser.isPermitted("index_operation_unreply_feedback")) {
				//未回复居民反馈
				int unrepliedFeedback = 0;/* businessUserService.countBySql("select count(1) as count from business_feedback f where f.fbType=2 and  f.fbState = 0");*/
				modelView.addObject("unrepliedFeedback", unrepliedFeedback);	
			}
			
			if (currentUser.isPermitted("index_operation_auditing_anno")) {
				//待审核公告信息
				int audtingAnno = 0; /*businessUserService.countBySql("select count(distinct(anno.annoId)) as annoCount from business_anno anno inner join business_anno_scope scope on anno.annoId = scope.annoId inner join business_user_resource res on res.estateId = scope.estateId WHERE anno.publishState = 2 and ( anno.annoType = 2 OR anno.annoType = 3 )");*/
				modelView.addObject("audtingAnno", audtingAnno);
			}
			
			//推送未成功
			//int unsuccessedPush = businessUserService.countBySql("");
			
			if (currentUser.isPermitted("index_operation_publishing_focus")) {
				//待发布焦点图
				int auditFocus = 0 ; // businessUserService.countBySql("select count(distinct(f.focusId)) as annoCount from business_focus f inner join app_focus_scope scope on scope.focusId = f.focusId inner join business_user_resource res on res.estateId = scope.estateId where f.state = 1");
				modelView.addObject("auditFocus", auditFocus);	
			}
			
		//}
		
		//获取公告
		BusinessAnnoQuery annoQuery = new BusinessAnnoQuery();
		annoQuery.setAnnoType(2);//内部公告
		//if(ModuleConst.COMMUNITY_CODE.equals(shiroUser.getOrgType())) {//社区类型
		//	annoQuery.setScopeType(1);
		//}else if(ModuleConst.STATION_CODE.equals(shiroUser.getOrgType())) {//驿站类型
		//	annoQuery.setScopeType(2);
		//}else if(ModuleConst.PROPERTY_CODE.equals(shiroUser.getOrgType())) {//物业类型
		//	annoQuery.setScopeType(3);
		//}//运营不分类型
		annoQuery.setSort("annoId");
		annoQuery.setOrder("desc");
		annoQuery.setRows(1);
		BaseBean baseBean = businessAnnoService.findAllPageForIndex(annoQuery);//获取首页公告列表
		modelView.addObject("annoList", baseBean.getList());
		modelView.addObject("isCom", shiroUser.getIsCom());
		modelView.addObject("isEstate", shiroUser.getIsEstate());
		//modelView.addObject("orgType", orgType);
		return modelView;
	}
	
	/**
	 * 登录操作，提交shiro进行认证和授权，认证失败到认证失败信息页，认证成功则进行授权操作并跳转到相应模块主页，
	 * 模块主页根据用户所拥有的模块编码匹配，并且操作功能授权也根据模块来赋予，每个模块的功能授权不同，
	 * 且在模块跳转时进行不同的授权切换 ，运营类人员跳转到模块选择页
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		ModelAndView modelView = new ModelAndView();
		//获取当前用户标识
		Subject currentUser = SecurityUtils.getSubject();
		//放入身份token中准备验证
		UsernamePasswordToken token = new UsernamePasswordToken(userEmail, userPassword);
		token.setRememberMe(true);
		try {
			if(isDuplicateLogin(userEmail)) {//已经登录的进行提示并踢掉该账号并重新登录
				//踢掉该用户
				kickOutUser(userEmail);
				//重新登录
				currentUser.login(token);
			}else{//未登录的进行登录
				currentUser.login(token);
			}			
		} catch (UnknownAccountException uae) {  
			modelView.addObject("message", "抱歉，登录信息有误，请您重新输入!");
			modelView.setViewName("/login");
			uae.printStackTrace();
        } catch (IncorrectCredentialsException ice) {  
        	modelView.addObject("message", "抱歉，登录信息有误，请您重新输入!");
			modelView.setViewName("/login");
			ice.printStackTrace();
        } catch (LockedAccountException lae) {  
        	modelView.addObject("message", "抱歉，登录信息有误，请您重新输入!");
			modelView.setViewName("/login");
			lae.printStackTrace();
        } catch (AuthenticationException ae) {
			token.clear();
			modelView.addObject("message", "抱歉，登录信息有误，请您重新输入!");
			modelView.setViewName("/login");
			ae.printStackTrace();
		}
		
		if(currentUser.isAuthenticated()){
			/*HttpSession session = request.getSession();
			session.setMaxInactiveInterval(30*60*1000);
			session.setAttribute("shiroUser", CommonUtils.getUser());*/
			
			//判断用户拥有哪个模块，如果是多个自动展示运营模块
			/*ShiroUser shiroUser = (ShiroUser)currentUser.getPrincipal();
			BusinessUser businessUser = businessUserService.findById(shiroUser.getUserId());
			//判断用户拥有哪个模块，如果是多个自动展示运营模块
			//String modules = businessUser.getModules();
			List<BusinessMenu> menuList = new ArrayList<BusinessMenu>();
			//if(modules.indexOf(',') > -1) { //有多个模块，必定是运营的人员
				//获取运营模块ID
				//ManageModule manageModule = manageModuleService.findById(ModuleConst.OPERATION);
				//获取运营模块下的菜单	
				//menuList = businessMenuService.findMenuByModuleId(manageModule.getModuleId());		
			//}else{//只有一个，就授权相应模块的权限
				//获取对应模块下的所有菜单
				//menuList = businessMenuService.findMenuByModuleId(ModuleConst.getModuleId(modules));				
			//}
			
			//modelView.addObject("menuList", menuList); //绑定菜单数据集合
			modelView.addObject("userName", businessUser.getUserName());//姓名
			//职位
			if(businessUser.getPositionId() != null && businessUser.getPositionId() != 0) {
				BusinessPosition businessPosition = businessPositionService.findById(businessUser.getPositionId());
				modelView.addObject("depName", businessPosition.getDepName());
				modelView.addObject("positionName", businessPosition.getPositionName());
			}else{
				modelView.addObject("depName", "");
				modelView.addObject("positionName", "");
			}			
			modelView.addObject("lastLoginTime", businessUser.getLastLoginTime());
			
			//切换小区搜索条件
			String estateCondition = "";
			if(shiroUser.getCurEstateId() != null && shiroUser.getCurEstateId() != 0) {
				estateCondition = " and res.estateId = " + shiroUser.getCurEstateId();
			}
			//切换社区搜索条件
			String communityCondition = "";
			if(shiroUser.getCurComId() != null && shiroUser.getCurComId() != 0) {
				communityCondition = " and res.comId = "+shiroUser.getCurComId();
			}
			
			//按角色分别统计数据
			//String orgType = "";
			//if(shiroUser.getCurOrgType() != null && !"".equals(shiroUser.getCurOrgType())) {
				//orgType = shiroUser.getCurOrgType();
			//}else{
				//orgType = shiroUser.getOrgType();
			//}
			
			//非运营人员可以带ID查看相关数据
			String userCondition = "";
			//if(!ModuleConst.OPERATION_CODE.equals(shiroUser.getOrgType())) {
				userCondition = " and res.userId = " + shiroUser.getUserId();
			//}
			
			//物业
			//if(ModuleConst.PROPERTY_CODE.equals(orgType)) {
				if (currentUser.isPermitted("index_property_verified_resident")) {
					//验证居民
					int verifiedResidents = businessUserService.countBySql(
							"select count(distinct(u.userId)) FROM app_user u inner JOIN  app_estate_user b ON  u.userId = b.userId inner join business_user_resource res on res.estateId = b.estateId where u.`type` = 1 " + userCondition + estateCondition);
					modelView.addObject("verifiedResidents", verifiedResidents);	
				}
				
				if (currentUser.isPermitted("index_property_today_registed")) {
					//物业当日注册居民
					int propertyRegistedResidentsOnDay = businessUserService.countBySql(
							"select count(distinct(u.userId)) FROM app_user u inner JOIN  app_estate_user b ON  u.userId = b.userId inner join business_user_resource res on res.estateId = b.estateId where 0 = DATEDIFF(now(), u.registTime) " + userCondition + estateCondition);
					modelView.addObject("propertyRegistedResidentsOnDay", propertyRegistedResidentsOnDay);	
				}
				
				if (currentUser.isPermitted("index_property_today_verified")) {
					//物业当日验证居民
					int propertyVerifiedResidentsOnDay = businessUserService.countBySql(
							"select count(distinct(u.userId)) FROM app_user u inner JOIN  app_estate_user b ON  u.userId = b.userId inner join business_user_resource res on res.estateId = b.estateId where u.type = 1 and 0 = DATEDIFF(now(), u.verifyTime) " + userCondition + estateCondition);
					modelView.addObject("propertyVerifiedResidentsOnDay", propertyVerifiedResidentsOnDay);	
				}
				
				if (currentUser.isPermitted("index_property_unrepair_handler")) {
					//未报修处理
					int unresolvedRepair = businessUserService.countBySql("select count(distinct(re.repairId)) from business_repair re inner join business_user_resource res on res.estateId = re.estateId WHERE re.repairState = 0 " + userCondition + estateCondition);
					modelView.addObject("unresolvedRepair", unresolvedRepair);	
				}
				
				if (currentUser.isPermitted("index_property_unreply_feedback")) {
					//未回复反馈
					int unreplied = businessUserService.countBySql("select count(distinct(fb.feedbackId)) from business_feedback fb left join app_user u on fb.fberId = u.userId inner join business_user_resource res on res.estateId = fb.estateId WHERE (fb.fbType=0 or fb.fbType=1) and fb.fbState = 0 " + userCondition + estateCondition);
					modelView.addObject("unreplied", unreplied);	
				}
				
				if (currentUser.isPermitted("index_property_anno_comment")) {
					//今日公告评论数量
					int propCommentedAnno = businessUserService.countBySql("select count(distinct(c.commentId)) as count from business_anno_comment c inner join business_anno a on c.annoId = a.annoId inner join business_anno_scope sc on sc.annoId = a.annoId inner join business_user_resource res on res.estateId = sc.estateId where 0 = DATEDIFF(now(), c.commentTime) and (a.annoType = 0 or a.annoType = 1 ) " + userCondition + estateCondition);
					modelView.addObject("propCommentedAnno", propCommentedAnno);	
				}
				
			//}
			//else
			//驿站
			//if(ModuleConst.STATION_CODE.equals(orgType)) {
				if (currentUser.isPermitted("index_station_anno_comment")) {
					//公告评论数量
					int stationCommentedAnno = businessUserService.countBySql("select count(distinct(c.commentId)) as count from business_anno_comment c inner join business_anno a on c.annoId = a.annoId inner join business_anno_scope sc on sc.annoId = a.annoId inner join business_user_resource res on res.estateId = sc.estateId where a.annoType = 4 " + userCondition + estateCondition);
					modelView.addObject("stationCommentedAnno", stationCommentedAnno);
				}
				
				if (currentUser.isPermitted("index_station_unsolved_express")) {
					//未处理快递服务
					int unresolvedExp = businessUserService.countBySql("select count(distinct(e.expId)) from business_exp e inner join business_station s on s.stationId = e.stationId inner join manage_estate es on es.stationId = s.stationId inner join business_user_resource res on res.estateId = es.estateId WHERE (e.expState = 0) " + userCondition + estateCondition);
					modelView.addObject("unresolvedExp", unresolvedExp);
				}
				
				if (currentUser.isPermitted("index_station_unreply_help")) {
					//未回复求助信息
					int unrepliedHelp = businessUserService.countBySql("select count(distinct(h.helpId)) from business_help h left join app_user u on u.userId=h.helperId inner join business_user_resource res on res.estateId = h.estateId WHERE h.state = 0 " + userCondition + estateCondition);
					modelView.addObject("unrepliedHelp", unrepliedHelp);
				}
				
				if (currentUser.isPermitted("index_station_going_activity")) {
					//进行中的活动
					int gointActivity = businessUserService.countBySql("select count(distinct(a.actId)) from business_activity a inner join business_activity_scope s on s.actId = a.actId inner join business_user_resource res on res.estateId = s.estateId WHERE (a.state = 0 or a.state = 1) " + userCondition + estateCondition);
					modelView.addObject("gointActivity", gointActivity);	
				}
				
				if (currentUser.isPermitted("index_station_unsolved_feedback")) {
					//未处理居民反馈
					int unresolvedFeedback = businessUserService.countBySql("select count(distinct(fb.feedbackId)) from business_feedback fb left join app_user u on fb.fberId = u.userId inner join business_user_resource res on res.estateId = fb.estateId WHERE (fb.fbType=3 or fb.fbType=4) and  fb.fbState = 0 " + userCondition + estateCondition);
					modelView.addObject("unresolvedFeedback", unresolvedFeedback);
				}
				
				
			//}
			//else
			//社区报
			//if(ModuleConst.COMMUNITY_CODE.equals(orgType)) {
				
				if (currentUser.isPermitted("index_com_news_comment")) {
					//今日已有新闻评论
					int commentsNews = businessUserService.countBySql("select count(distinct(c.commentId)) from business_news_comment c inner join business_news n on c.newsId = n.newsId inner join business_news_scope scope on n.newsId = scope.newsId inner join business_user_resource res on res.comId = scope.comId where 0 = DATEDIFF(now(), c.commentTime) " + userCondition + communityCondition);
					modelView.addObject("commentsNews", commentsNews);	
				}
				
				if (currentUser.isPermitted("index_com_unsolved_break")) {
					//未处理网友爆料
					int unresolvedBreak = businessUserService.countBySql("select count(distinct(b.breakId)) from business_break b inner join business_user_resource res on res.comId = b.comId WHERE b.state = 0 " + userCondition + communityCondition);
					modelView.addObject("unresolvedBreak", unresolvedBreak);
				}
				
				if (currentUser.isPermitted("index_com_auding_news")) {
					//待审核新闻
					int auditingNews = businessUserService.countBySql("select count(distinct(n.newsId)) from business_news n inner join business_news_scope scope on n.newsId = scope.newsId inner join business_user_resource res on res.comId = scope.comId WHERE n.state = 2 " + userCondition + communityCondition);
					modelView.addObject("auditingNews", auditingNews);
				}
				
				if (currentUser.isPermitted("index_property_verified_resident")) {
					//待审核位置
					int auditingLife = businessUserService.countBySql("select count(1) as count from business_life l where l.pulishState = 1 ");
					modelView.addObject("auditingLife", auditingLife);
				}
				
				if (currentUser.isPermitted("index_com_goting_activity")) {
					//进行中的活动
					int comGoingActivity = businessUserService.countBySql("select count(distinct(a.actId)) from business_activity a inner join business_activity_scope s on s.actId = a.actId inner join business_user_resource res on res.estateId = s.estateId WHERE (a.state = 0 or a.state = 1)  " + userCondition + communityCondition);
					modelView.addObject("comGoingActivity", comGoingActivity);	
				}

				if (currentUser.isPermitted("index_station_audting_market")) {
					//待审核二手信息
					int auditingMarket = businessUserService.countBySql("select count(distinct(p.productId)) from business_product p inner join business_user_resource res on res.estateId = p.estateId WHERE p.dealState = 1 " + userCondition + estateCondition);
					modelView.addObject("auditingMarket", auditingMarket);	
				}
				
			//}
			//else
			//运营
			//if(ModuleConst.OPERATION_CODE.equals(orgType)) {
				
				if (currentUser.isPermitted("index_operation_regist_resident")) {
					//已有注册居民
					int regisitedResident = businessUserService.countBySql("select count(1) as count from app_user u where u.type = 1 ");
					modelView.addObject("regisitedResident", regisitedResident);	
				}
				
				if (currentUser.isPermitted("index_operation_today_registed")) {
					//当日注册居民
					int operationRegistedResidentsOnDay = businessUserService.countBySql(
							"select count(1) as count from app_user u where 0 = DATEDIFF(now(), u.registTime) ");
					modelView.addObject("operationRegistedResidentsOnDay", operationRegistedResidentsOnDay);	
				}

				if (currentUser.isPermitted("index_operation_today_verified")) {
					//当日验证居民
					int operationVerifiedResidentsOnDay = businessUserService.countBySql(
							"select count(1) as count from app_user u where u.type = 1 and 0 = DATEDIFF(now(), u.verifyTime) ");
					modelView.addObject("operationVerifiedResidentsOnDay", operationVerifiedResidentsOnDay);	
				}
				
				if (currentUser.isPermitted("index_operation_unreply_feedback")) {
					//未回复居民反馈
					int unrepliedFeedback = businessUserService.countBySql("select count(1) as count from business_feedback f where f.fbType=2 and  f.fbState = 0");
					modelView.addObject("unrepliedFeedback", unrepliedFeedback);	
				}
				
				if (currentUser.isPermitted("index_operation_auditing_anno")) {
					//待审核公告信息
					int audtingAnno = businessUserService.countBySql("select count(distinct(anno.annoId)) as annoCount from business_anno anno inner join business_anno_scope scope on anno.annoId = scope.annoId inner join business_user_resource res on res.estateId = scope.estateId WHERE anno.publishState = 2 and ( anno.annoType = 2 OR anno.annoType = 3 )");
					modelView.addObject("audtingAnno", audtingAnno);
				}
				
				//推送未成功
				//int unsuccessedPush = businessUserService.countBySql("");
				
				if (currentUser.isPermitted("index_operation_publishing_focus")) {
					//待发布焦点图
					int auditFocus = businessUserService.countBySql("select count(distinct(f.focusId)) as annoCount from business_focus f inner join app_focus_scope scope on scope.focusId = f.focusId inner join business_user_resource res on res.estateId = scope.estateId where f.state = 1");
					modelView.addObject("auditFocus", auditFocus);	
				}
				
			//}
			
			//获取公告
			BusinessAnnoQuery annoQuery = new BusinessAnnoQuery();
			annoQuery.setAnnoType(2);//内部公告
			//if(ModuleConst.COMMUNITY_CODE.equals(shiroUser.getOrgType())) {//社区类型
				//annoQuery.setScopeType(1);
			//}else if(ModuleConst.STATION_CODE.equals(shiroUser.getOrgType())) {//驿站类型
				//annoQuery.setScopeType(2);
			//}else if(ModuleConst.PROPERTY_CODE.equals(shiroUser.getOrgType())) {//物业类型
				//annoQuery.setScopeType(3);
			//}//运营不分类型
			annoQuery.setSort("annoId");
			annoQuery.setOrder("desc");
			annoQuery.setRows(1);
			BaseBean baseBean = businessAnnoService.findAllPageForIndex(annoQuery);//获取首页公告列表
			modelView.addObject("annoList", baseBean.getList());
			//modelView.addObject("orgType", orgType);
			*/
			modelView.setViewName("redirect:/index/main.do");
			
			//modelView.addObject("isCom", shiroUser.getIsCom());
			//modelView.addObject("isEstate", shiroUser.getIsEstate());
						
		}else{
			modelView.addObject("message", "抱歉，您不是我们的有效用户!");
			modelView.setViewName("/login");
		}
		return modelView;
	}
	
	/**
	 * 从缓存集合中比较判断该邮箱账号是否已经登录,如果已登录则提示已登录
	 * @param userEmail
	 * @return
	 */
	private boolean isDuplicateLogin(String userEmail) {
		boolean loginned =  false;
		Collection<Session> sessions = sessionDAO.getActiveSessions();
		Iterator it = sessions.iterator();
		Set<String> loginNames = new HashSet<String>();
		while(it.hasNext()){
			Session session = (Session) it.next();
			if(session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY") != null) {
				String str = session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY").toString();
				loginNames.add(str);
				if(str.equalsIgnoreCase(userEmail)) {
					loginned = true;
					break;
				}
			}			
		}
		return loginned;
	}
	
	/**
	 * 踢掉该用户
	 * @param userEmail
	 */
	private void kickOutUser(String userEmail) {
		Collection<Session> sessions = sessionDAO.getActiveSessions();
		Iterator it = sessions.iterator();
		Set<String> loginNames = new HashSet<String>();
		while(it.hasNext()){
			Session session = (Session) it.next();
			if(session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY") != null) {
				String str = session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY").toString();
				if(str.equalsIgnoreCase(userEmail)) {
					session.stop();
				}
			} 			
		}
	}
	
	/**
	 * 运营业务切换
	 * @return
	 */
	@RequestMapping("/businessChange")
	public ModelAndView businessChange(HttpServletRequest request) {
		try {
			ShiroUser shiroUser = CommonUtils.getUser();
			ShiroUser siroUsrP = (ShiroUser)SecurityUtils.getSubject().getPrincipal();
			//切换用户菜单到shiro缓存中
			shiroUser.setCurEstateId(0);
			shiroUser.setCurComId(0);
			
			siroUsrP.setCurEstateId(0);
			siroUsrP.setCurComId(0);
			List menuList = initUserMenu(shiroUser.getUserId());
			if(menuList.size() > 0) {
				MenuComparator comparator=new MenuComparator();
				Collections.sort(menuList, comparator);
			}
			//shiroUser.setCurOrgType(orgType);
			//shiroUser.setMenuList(menuList);
			/*if(ModuleConst.PROPERTY_CODE.equals(orgType)) {
				shiroUser.setCurOrgTypeName(ModuleConst.PROPERTY_NAME);
			}else if(ModuleConst.COMMUNITY_CODE.equals(orgType)) {
				shiroUser.setCurOrgTypeName(ModuleConst.COMMUNITY_NAME);
			}else if(ModuleConst.STATION_CODE.equals(orgType)) {
				shiroUser.setCurOrgTypeName(ModuleConst.STATION_NAME);
			}else{
				shiroUser.setCurOrgTypeName(ModuleConst.OPERATION_NAME);
			}*/
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("redirect:/index/main.do");
		return modelView;
	}
	
	/**
	 * 小区切换
	 * @return
	 */
	@RequestMapping("/estateChange")
	public ModelAndView estateChange(HttpServletRequest request) {
		Integer estateId = Integer.valueOf(request.getParameter("estateId"));
		String jump = request.getParameter("jump");
		try {
			ShiroUser shiroUser = CommonUtils.getUser();
			ShiroUser siroUsrP = (ShiroUser)SecurityUtils.getSubject().getPrincipal();
			//切换小区ID到shiro缓存中
			shiroUser.setCurEstateId(estateId);
			shiroUser.setCurComId(0);
			
			siroUsrP.setCurEstateId(estateId);
			siroUsrP.setCurComId(0);
			if(estateId != null && estateId != 0) {
				ManageEstate manageEstate = manageEstateService.findById(estateId);
				BusinessCommunity com = businessCommunityService.findById(manageEstate.getComId());
				String curComName = "";
				if (com != null)
					curComName = com.getComName();
				
				shiroUser.setCurEstateName(manageEstate.getEstateName());
				shiroUser.setCurStateId(manageEstate.getStationId());
				shiroUser.setCurComId(manageEstate.getComId());
				shiroUser.setCurComName(curComName);
				
				
				siroUsrP.setCurEstateName(manageEstate.getEstateName());
				siroUsrP.setCurStateId(manageEstate.getStationId());
				siroUsrP.setCurComId(manageEstate.getComId());
				siroUsrP.setCurComName(curComName);
				
			}else{
				shiroUser.setCurEstateName("全部小区");
				shiroUser.setCurStateId(0);
				
				siroUsrP.setCurEstateName("全部小区");
				siroUsrP.setCurStateId(0);
			}
			
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("redirect:"+jump);
		return modelView;
	}
	
	/**
	 * 社区业务切换
	 * @return
	 */
	@RequestMapping("/communityChange")
	public ModelAndView communityChange(HttpServletRequest request) {
		Integer comId = Integer.valueOf(request.getParameter("comId"));
		String jump = request.getParameter("jump");
		try {
			ShiroUser shiroUser = CommonUtils.getUser();
			ShiroUser siroUsrP = (ShiroUser)SecurityUtils.getSubject().getPrincipal();
			//切换社区ID到shiro缓存中
			shiroUser.setCurEstateId(0);
			shiroUser.setCurEstateName("全部小区");
			shiroUser.setCurComId(comId);
			
			siroUsrP.setCurEstateId(0);
			siroUsrP.setCurEstateName("全部小区");
			siroUsrP.setCurComId(comId);
			if(comId != null && comId != 0) {
				BusinessCommunity businessCommunity = businessCommunityService.findById(comId);
				shiroUser.setCurComName(businessCommunity.getComName());
				
				siroUsrP.setCurComName(businessCommunity.getComName());
				//切换社区关联的小区
				List<EstateBean> tempList = shiroUser.getMemoryEstateBeanList();
				List estateBeanListByCom = new ArrayList();
				for(EstateBean esteteBean : tempList) {
					if(esteteBean.getComId() == comId) {
						estateBeanListByCom.add(esteteBean);
					}
				}
				shiroUser.setEstateBeanList(estateBeanListByCom);
			}else{
				shiroUser.setCurComName("全部社区");
				
				siroUsrP.setCurComName("全部社区");
				//切换小区为全部小区
				shiroUser.setEstateBeanList(shiroUser.getMemoryEstateBeanList());
			}
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("redirect:"+jump);
		return modelView;
	}
	
	//按组织类型初始化用户菜单列表
	private List<UserMenuBean> initUserMenu(Integer userId) {
		List<UserMenuBean> menuList = new ArrayList();
		//获取用户所有功能权限并组织出菜单
		Map paramMap = new HashMap();
		paramMap.put("userId", userId);
		UserMenuBean userMenuBean = new UserMenuBean();
		List userFunctionList = manageUserFunctionService.findByMap(paramMap);
		if(userFunctionList != null && userFunctionList.size() > 0) {
			for(int i=0;i<userFunctionList.size();i++){
				ManageUserFunction userFunction = (ManageUserFunction) userFunctionList.get(i);
				if(menuList.size() > 0) {//已有菜单
					boolean hasMenu = false;
					for(int j=0;j<menuList.size();j++) {
						userMenuBean = menuList.get(j);
						if(userMenuBean.getMenuId() == userFunction.getMenuId()) {
							hasMenu = true;
						}
					}
					if(!hasMenu) {//还没有菜单
						userMenuBean = new UserMenuBean();
						userMenuBean.setMenuId(userFunction.getMenuId());
						BusinessMenu businessMenu = businessMenuService.findById(userFunction.getMenuId());
						userMenuBean.setMenuName(businessMenu.getName());
						userMenuBean.setNo(businessMenu.getOrd());
						userMenuBean.setIcon(businessMenu.getCode());
						userMenuBean.setMenuPath(businessMenu.getUrl());
						userMenuBean.setIsCom(businessMenu.getIsCom());
						userMenuBean.setIsEstate(businessMenu.getIsEstate());
						
						menuList.add(userMenuBean);
					}
				}else{//没有菜单
					userMenuBean = new UserMenuBean();
					userMenuBean.setMenuId(userFunction.getMenuId());
					BusinessMenu businessMenu = businessMenuService.findById(userFunction.getMenuId());
					userMenuBean.setMenuName(businessMenu.getName());
					userMenuBean.setNo(businessMenu.getOrd());
					userMenuBean.setIcon(businessMenu.getCode());
					userMenuBean.setMenuPath(businessMenu.getUrl());
					userMenuBean.setIsCom(businessMenu.getIsCom());
					menuList.add(userMenuBean);
				}
			}
		}
		return menuList;
	}
	
	/**
	 * 登出
	 * @return
	 */
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		Subject currentUser = SecurityUtils.getSubject();
		try {
			if(currentUser != null && currentUser.getSession() != null) {
				currentUser.logout();
			}
			HttpSession session = request.getSession();
			//ShiroUser shiroUser = (ShiroUser) session.getAttribute("shiroUser");
			//if(shiroUser != null) {
			//	session.setAttribute("shiroUser", null);
			//}
			//session.invalidate();
		} catch (AuthenticationException e) {
			e.printStackTrace();

		}
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("/login");
		return modelView;
	}
	
	/**
	 * 登出
	 * @return
	 */
	@RequestMapping("/loginPage")
	public ModelAndView loginPage(HttpServletRequest request) {
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("/login");
		return modelView;
	}
	
	/**
	 * 验证是否有效用户
	 * @return
	 */
	@RequestMapping("/chklogin")  
    @ResponseBody  
    public String chkLogin() {  
        Subject currentUser = SecurityUtils.getSubject();  
        if (!currentUser.isAuthenticated()) {  
            return "false";  
        }  
        return "true";  
    }
	
	@RequestMapping("/getBusinessUserInfo")
	public ModelAndView getBusinessUserInfo(HttpServletRequest request,HttpServletResponse response){
		ShiroUser shiroUser = CommonUtils.getUser();
		ModelAndView mav = new ModelAndView("/module/updatePassword");
		mav.addObject("userId", shiroUser.getUserId());
		return mav;
	}
	
	@RequestMapping("/unauthorized")
	public ModelAndView unauthorized(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mav = new ModelAndView("/common/unauthorized");
		return mav;
	}
	
	/**
	 * 菜单切换时获取这个菜单是否要显示社区后者小区，初始化在内存
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/menuChange")
	public ModelAndView menuChange(HttpServletRequest request,HttpServletResponse response){
		
		ShiroUser shiroUser = CommonUtils.getUser();
		ShiroUser siroUsrP = (ShiroUser)SecurityUtils.getSubject().getPrincipal();
		
		String isCom = request.getParameter("isCom");
		String isEstate = request.getParameter("isEstate");
		//初始化到缓存
		shiroUser.setIsCom(new Integer(isCom));
		shiroUser.setIsEstate(new Integer(isEstate));
		
		siroUsrP.setIsCom(new Integer(isCom));
		siroUsrP.setIsEstate(new Integer(isEstate));
		
		String menuPath = request.getParameter("menuPath");
		ModelAndView mav = new ModelAndView(new RedirectView(menuPath));
		return mav;
		
	}
}