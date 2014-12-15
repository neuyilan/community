package com.community.app.module.service.shiro;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.community.app.module.bean.BusinessCommunity;
import com.community.app.module.bean.BusinessMenu;
import com.community.app.module.bean.BusinessPosition;
import com.community.app.module.bean.BusinessStation;
import com.community.app.module.bean.BusinessUser;
import com.community.app.module.bean.BusinessUserResource;
import com.community.app.module.bean.ManageEstate;
import com.community.app.module.bean.ManageModule;
import com.community.app.module.bean.ManageModulemenu;
import com.community.app.module.bean.ManageUserFunction;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.common.CommunityBean;
import com.community.app.module.common.EstateBean;
import com.community.app.module.common.MenuComparator;
import com.community.app.module.common.ModuleConst;
import com.community.app.module.common.StationBean;
import com.community.app.module.common.UserMenuBean;
import com.community.app.module.service.BusinessCommunityService;
import com.community.app.module.service.BusinessMenuService;
import com.community.app.module.service.BusinessPositionService;
import com.community.app.module.service.BusinessStationService;
import com.community.app.module.service.BusinessUserResourceService;
import com.community.app.module.service.BusinessUserService;
import com.community.app.module.service.ManageEstateService;
import com.community.app.module.service.ManageModuleService;
import com.community.app.module.service.ManageModulemenuService;
import com.community.app.module.service.ManageUserFunctionService;
import com.community.app.module.vo.ManageModulemenuQuery;
import com.community.framework.utils.CommonUtils;
import com.community.framework.utils.ShiroUtil;

/**
 * 系统用户认证授权管理
 * @author zyp-2_000
 *
 */
public class ShiroDbRealm extends AuthorizingRealm{

	@Autowired
	protected BusinessUserService businessUserService;
	
	@Autowired
	protected ManageModuleService manageModuleService;
	
	@Autowired
	protected BusinessPositionService businessPositionService;
	
	@Autowired
	protected ManageModulemenuService manageModulemenuService;
	
	@Autowired
	protected ManageEstateService manageEstateService;
	
	@Autowired
	protected ManageUserFunctionService manageUserFunctionService;
	
	@Autowired
	protected BusinessMenuService businessMenuService;
	
	@Autowired
	protected BusinessUserResourceService businessUserResourceService;
	
	@Autowired
	protected BusinessStationService businessStationService;
	
	@Autowired
	protected BusinessCommunityService businessCommunityService;
	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authToken;
		Map<String, Object> paramMap = new HashMap();
		paramMap.put("userEmail", token.getUsername());
		//paramMap.put("userPassword", ShiroUtil.encrypt(token.getPassword().toString()));
		paramMap.put("userPassword", String.copyValueOf(token.getPassword()));
		try{
			List userList = businessUserService.findByMap(paramMap);
			if(userList != null && userList.size() > 0) {
				BusinessUser businessUser = (BusinessUser) userList.get(0);
				BusinessPosition businessPosition = businessPositionService.findById(businessUser.getPositionId());
				//返回shiro缓存的用户对象
				//byte[] salt = Encodes.decodeHex(user.getSalt());
				ShiroUser shiroUser = new ShiroUser();
				shiroUser.setUserId(businessUser.getUserId());
				shiroUser.setUserEmail(businessUser.getUserEmail());
				shiroUser.setUserName(businessUser.getUserName());				
				shiroUser.setUserTel(businessUser.getUserTel());
				shiroUser.setPositionId(businessUser.getPositionId());
				shiroUser.setPosName(businessUser.getPosName());
				shiroUser.setNickName(businessUser.getNickname());
				shiroUser.setOrgId(businessUser.getOrgId());
				shiroUser.setOrgType(businessUser.getOrgType());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");				
				shiroUser.setLastLoginTime(sdf.format(businessUser.getLastLoginTime()));
				//保存最近登录时间
				businessUser.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
				businessUserService.update(businessUser);
				//初始化用户菜单到shiro缓存中
				List menuList = initUserMenu(businessUser.getUserId(), businessUser.getOrgType());
				shiroUser.setMenuList(menuList);
				//按用户类型初始化所需的业务切换关键信息 
				//驿站 - 获取驿站(小区)列表
				//社区 - 获取社区报列表
				//运营 - 切换关键字：模块编码(station,property,community,operation)，用户ID,所有小区列表，所有社区列表
				initBiz(shiroUser);//初始化业务关键信息
				
				//加盐，加密，压缩
				RandomNumberGenerator rng = new SecureRandomNumberGenerator();
				Object salt = rng.nextBytes();
				SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
						shiroUser, 
						//ShiroUtil.encrypt(businessUser.getUserPassword()), 
						businessUser.getUserPassword(),
						ByteSource.Util.bytes(salt), 
						getName());	
				//设置SESSION控制时间
				//SecurityUtils.getSubject().getSession().setTimeout(30*60*1000);//超时设置为1个小时
				Subject currentUser = SecurityUtils.getSubject();
				if(null != currentUser) {
					Session session = currentUser.getSession();
					//session.getTimeout();
					session.setTimeout(3600000);
					if(null != session) {
						session.setAttribute("shiroUser", shiroUser);
					}
				}
				return info;
			}else{
				 throw new UnknownAccountException();
			}
		}catch(Exception e) {
			throw new AuthenticationException();
		}
		
	}
	
	//初始化业务关键信息
	private void initBiz(ShiroUser shiroUser) {
		Map paramMap = new HashMap();
		paramMap.put("userId", shiroUser.getUserId());
		List userResourceList = businessUserResourceService.findByMap(paramMap);
		if(shiroUser.getOrgType().equals(ModuleConst.STATION_CODE)) {//驿站
			if(userResourceList != null) {
				for(int i=0;i<userResourceList.size();i++) {
					BusinessUserResource businessUserResource = (BusinessUserResource) userResourceList.get(i);
					ManageEstate manageEstate = manageEstateService.findById(businessUserResource.getEstateId());
					EstateBean estateBean = new EstateBean();
					estateBean.setEstateId(manageEstate.getEstateId());
					estateBean.setEstateName(manageEstate.getEstateName());
					shiroUser.getEstateBeanList().add(estateBean);
				}
			}
		}else if(shiroUser.getOrgType().equals(ModuleConst.COMMUNITY_CODE)) {//社区
			if(userResourceList != null) {
				List estateList = new ArrayList();//小区列表
				List comList = new ArrayList();//社区列表
				for(int i=0;i<userResourceList.size();i++) {
					BusinessUserResource businessUserResource = (BusinessUserResource) userResourceList.get(i);
					if(businessUserResource.getEstateId() != null && businessUserResource.getEstateId() != 0) {
						ManageEstate manageEstate = manageEstateService.findById(businessUserResource.getEstateId());
						EstateBean estateBean = new EstateBean();
						estateBean.setEstateId(manageEstate.getEstateId());
						estateBean.setEstateName(manageEstate.getEstateName());
						shiroUser.getEstateBeanList().add(estateBean);
					}
					//组装社区列表
					boolean hasCom = false;
					for(int j=0;j<comList.size();j++) {
						CommunityBean communityBean = (CommunityBean) comList.get(j);
						if(communityBean.getComId() == businessUserResource.getComId()) {
							hasCom = true;
						}
					}
					if(!hasCom) {
						CommunityBean communityBean = new CommunityBean();
						if(businessUserResource.getComId() != null && businessUserResource.getComId() != 0) {
							BusinessCommunity businessCommunity = businessCommunityService.findById(businessUserResource.getComId());
							communityBean.setComId(businessCommunity.getComId());
							communityBean.setComName(businessCommunity.getComName());
							comList.add(communityBean);
						}						
					}
				}
				shiroUser.setComList(comList);
			}
		}else if(shiroUser.getOrgType().equals(ModuleConst.PROPERTY_CODE)) {//物业 组织小区列表
			if(userResourceList != null) {
				initPropertyEstate(shiroUser, userResourceList);
			}
		}else{//运营组织所有社区列表，小区列表
			List comList = businessCommunityService.findAll();
			for(int i=0;i<comList.size();i++) {
				BusinessCommunity businessCommunity = (BusinessCommunity) comList.get(i);
				CommunityBean communityBean = new CommunityBean();
				communityBean.setComId(businessCommunity.getComId());
				communityBean.setComName(businessCommunity.getComName());
				shiroUser.getComList().add(communityBean);
			}
			
			List estateList = manageEstateService.findAll();
			for(int i=0;i<estateList.size();i++) {
				ManageEstate manageEstate = (ManageEstate) estateList.get(i);
				EstateBean estateBean = new EstateBean();
				estateBean.setEstateId(manageEstate.getEstateId());
				estateBean.setEstateName(manageEstate.getEstateName());
				shiroUser.getEstateBeanList().add(estateBean);
			}
		}
	}
	
	/**
	 * 组织物业小区列表
	 * @param userResourceList
	 */
	private void initPropertyEstate(ShiroUser shiroUser, List userResourceList) {	
		List estateList = new ArrayList();
		Map paramMap = new HashMap();
		EstateBean estateBean = new EstateBean();
		if(userResourceList != null && userResourceList.size() > 0) {
			for(int i=0;i<userResourceList.size();i++){
				BusinessUserResource userResource = (BusinessUserResource) userResourceList.get(i);
				if(estateList.size() > 0) {
					boolean hasEstate = false;
					for(int j=0;j<estateList.size();j++) {
						estateBean = (EstateBean) estateList.get(j);
						if(estateBean.getEstateId() == userResource.getEstateId()) {
							hasEstate = true;
						}
					}
					if(!hasEstate) {
						estateBean = new EstateBean();
						estateBean.setEstateId(userResource.getEstateId());
						estateBean.setEstateName(userResource.getEstateName());
						//shiroUser.getEstateBeanList().add(estateBean);
						estateList.add(estateBean);
					}
				}else{
					estateBean = new EstateBean();
					estateBean.setEstateId(userResource.getEstateId());
					estateBean.setEstateName(userResource.getEstateName());
					//shiroUser.getEstateBeanList().add(estateBean);
					estateList.add(estateBean);
				}
			}
			shiroUser.setEstateBeanList(estateList);
		}
		
	}
	
	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//判断身份
		if (principals == null) {
            throw new AuthorizationException("Principal对象不能为空");
        }
		//获取用户信息
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		//初始化授权集合
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			BusinessUser businessUser = businessUserService.findById(shiroUser.getUserId());
			//初始化授权即模块-菜单-功能权限
			//判断用户拥有哪个模块
			if(ModuleConst.OPERATION_CODE.equals(businessUser.getOrgType())) { //运营的人员
				//运营模块角色
				info.addRole(businessUser.getOrgType());
				//获取运营模块ID
				ManageModule manageModule = manageModuleService.findById(ModuleConst.OPERATION);
				//获取运营模块下的菜单
				Map paramMap = new HashMap();
				//paramMap.put("moduleId", manageModule.getModuleId());
				//List modulemenuList = manageModulemenuService.findByMap(paramMap);
				//获取运营模块下用户所拥有的功能权限
				/*for(int i=0;i<modulemenuList.size();i++) {
					ManageModulemenu modulemenu = (ManageModulemenu) modulemenuList.get(i);
					//获取用户的功能权限
					paramMap.put("moduleCode", manageModule.getModuleCode());
					paramMap.put("menuId", modulemenu.getMenuId());
					paramMap.put("userId", businessUser.getUserId());
					List userFunctionList = manageUserFunctionService.findByMap(paramMap);
					for(int j=0;j<userFunctionList.size();j++){
						ManageUserFunction userFunction = (ManageUserFunction) userFunctionList.get(j);
						info.addStringPermission(userFunction.getFunctionCode());
					}
					
				}*/
				paramMap.put("userId", businessUser.getUserId());
				List userFunctionList = manageUserFunctionService.findByMap(paramMap);
				for(int j=0;j<userFunctionList.size();j++){
					ManageUserFunction userFunction = (ManageUserFunction) userFunctionList.get(j);
					info.addStringPermission(userFunction.getFunctionCode());
				}
			}else{//物业、驿站、社区报授权相应模块的权限
				info.addRole(businessUser.getOrgType());
				//获取对应模块下的所有菜单
				Map paramMap = new HashMap();
				paramMap.put("moduleId", ModuleConst.getModuleId(businessUser.getOrgType()));
				List modulemenuList = manageModulemenuService.findByMap(paramMap);
				//获取对应模块下用户所拥有的功能权限
				for(int i=0;i<modulemenuList.size();i++) {
			 		ManageModulemenu modulemenu = (ManageModulemenu) modulemenuList.get(i);
					//获取用户的功能权限
					paramMap.put("moduleCode", businessUser.getOrgType());
					paramMap.put("menuId", modulemenu.getMenuId());
					paramMap.put("userId", businessUser.getUserId());
					List userFunctionList = manageUserFunctionService.findByMap(paramMap);
					for(int j=0;j<userFunctionList.size();j++){
						ManageUserFunction userFunction = (ManageUserFunction) userFunctionList.get(j);
						info.addStringPermission(userFunction.getFunctionCode());
					}
				}
				
				//初始化物业、驿站、社区报负责小区
				Map param = new HashMap();
				if(ModuleConst.PROPERTY_CODE.equals(businessUser.getOrgType())) {//物业人员 获取小区ID 
					param.put("proId", shiroUser.getOrgId());
				}else if(ModuleConst.STATION_CODE.equals(businessUser.getOrgType())) {//驿站人员 获取小区ID 
					param.put("stationId", shiroUser.getOrgId());
				}else if(ModuleConst.COMMUNITY_CODE.equals(businessUser.getOrgType())) {//社区报人员 获取小区ID
					param.put("comId", shiroUser.getOrgId());
				}
				List estateList = manageEstateService.findByMap(param);
				if(estateList != null) {
					shiroUser.setEstateList(estateList);
				}else{
					shiroUser.setEstateList(new ArrayList());
				}
				
			}
		
		return info;
	}
	
	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	//@PostConstruct
	/*public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
		matcher.setHashIterations(1024);
		setCredentialsMatcher(matcher);
	}*/
	
	//按组织类型初始化用户菜单列表
	private List<UserMenuBean> initUserMenu(Integer userId, String orgType) {
		List<UserMenuBean> menuList = new ArrayList();
		//获取用户所有功能权限并组织出菜单
		Map paramMap = new HashMap();
		paramMap.put("moduleCode", orgType);
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
					menuList.add(userMenuBean);
				}
			}
		}
		if(menuList.size() > 0) {
			MenuComparator comparator=new MenuComparator();
			  Collections.sort(menuList, comparator);
		}
		return menuList;
	}
	
	/** 
     * 更新用户授权信息缓存. 
     */  
    public void clearCachedAuthorizationInfo(String principal) {  
        SimplePrincipalCollection principals = new SimplePrincipalCollection(  
                principal, getName());  
        clearCachedAuthorizationInfo(principals);  
    }  
  
    /** 
     * 清除所有用户授权信息缓存. 
     */  
    public void clearAllCachedAuthorizationInfo() {  
        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();  
        if (cache != null) {  
            for (Object key : cache.keys()) {  
                cache.remove(key);  
            }  
        }  
    }  
  
    public String encrypt(String plainText) {  
        String result = "";  
        /*byte[] hashPassword = null;  
        try {  
            hashPassword = Digests.md5(new ByteArrayInputStream(plainText  
                    .getBytes()));  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        result = Encodes.encodeHex(hashPassword);  */
        return result;  
  
    }  
  
    //@PostConstruct  
    //public void initCredentialsMatcher() {//MD5加密   
        /*HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(  
                ALGORITHM);  
        setCredentialsMatcher(matcher);  */
    //}  
	
	
}
