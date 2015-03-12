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
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
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
import org.springframework.beans.factory.annotation.Autowired;

import com.community.app.module.bean.BusinessMenu;
import com.community.app.module.bean.BusinessRoleFunction;
import com.community.app.module.bean.BusinessRoleMenu;
import com.community.app.module.bean.BusinessUser;
import com.community.app.module.bean.BusinessUserResource;
import com.community.app.module.bean.ShiroUser;
import com.community.app.module.common.CommunityBean;
import com.community.app.module.common.EstateBean;
import com.community.app.module.common.MenuComparator;
import com.community.app.module.common.UserMenuBean;
import com.community.app.module.service.BusinessCommunityService;
import com.community.app.module.service.BusinessMenuService;
import com.community.app.module.service.BusinessPositionService;
import com.community.app.module.service.BusinessRoleFunctionService;
import com.community.app.module.service.BusinessRoleMenuService;
import com.community.app.module.service.BusinessStationService;
import com.community.app.module.service.BusinessUserCommunityService;
import com.community.app.module.service.BusinessUserResourceService;
import com.community.app.module.service.BusinessUserService;
import com.community.app.module.service.ManageEstateService;
import com.community.app.module.service.ManageModuleService;
import com.community.app.module.service.ManageModulemenuService;
import com.community.app.module.service.ManageUserFunctionService;
import com.community.framework.utils.PickleMake;

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
	
	@Autowired
	protected BusinessRoleMenuService businessRoleMenuService;
	
	@Autowired
	protected BusinessRoleFunctionService businessRoleFunctionService;
	
	@Autowired
	protected BusinessUserCommunityService businessUserCommunityService;
	
	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authToken;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userEmail", token.getUsername());
		//paramMap.put("userPassword", ShiroUtil.encrypt(token.getPassword().toString()));
		paramMap.put("userPassword", String.copyValueOf(token.getPassword()));
		try{
			List<BusinessUser> userList = businessUserService.findByMap(paramMap);
			if(userList != null && userList.size() > 0) {
				BusinessUser businessUser = (BusinessUser) userList.get(0);
//				BusinessPosition businessPosition = businessPositionService.findById(businessUser.getPositionId());
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
				shiroUser.setAvatar(businessUser.getAvatar());
				shiroUser.setOrgType(businessUser.getOrgType());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");				
				shiroUser.setLastLoginTime(sdf.format(businessUser.getLastLoginTime()));
				//保存最近登录时间
				businessUser.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
				businessUserService.update(businessUser);
				//初始化用户菜单到shiro缓存中
				//List menuList = initUserMenu(businessUser.getUserId(), businessUser.getOrgType());
				List<UserMenuBean> menuList = initUserMenu(businessUser.getUserId());
				shiroUser.setMenuList(menuList);
				//按用户类型初始化所需的业务切换关键信息 
				//驿站 - 获取驿站(小区)列表
				//社区 - 获取社区报列表
				//运营 - 切换关键字：模块编码(station,property,community,operation)，用户ID,所有小区列表，所有社区列表
				initBiz(shiroUser);//初始化业务关键信息
				
				//加盐，加密，压缩
				RandomNumberGenerator rng = new SecureRandomNumberGenerator();
				Object salt = rng.nextBytes();
				
				/* 
				 * 深拷贝 shiroUser 对象，并清除 List 属性对象减小 header的 cookie 大小
				 */
				ShiroUser siroUsr = (ShiroUser)PickleMake.deepClone(shiroUser);
				siroUsr.setComList(null);
				siroUsr.setEstateBeanList(null);
				siroUsr.setEstateList(null); 
				siroUsr.setMenuList(null);
				siroUsr.setMemoryEstateBeanList(null);
				
				SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
						siroUsr, 
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
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("userId", shiroUser.getUserId());
		paramMap.put("isRelated", "1");  //是否关联  BUSINESS_USER_RESOURCE  1 关联， 2 无关联
		List<BusinessUserResource> userResourceList = businessUserResourceService.findByMap(paramMap);
//		//测试
//		shiroUser.setOrgType(ModuleConst.COMMUNITY_CODE);
		if(userResourceList != null) {
//			List estateList = new ArrayList();//小区列表
//			List comList = new ArrayList();//社区列表
			
			List<EstateBean> manageEstateList = manageEstateService.findByCon(paramMap);
			shiroUser.setEstateBeanList(manageEstateList);
			
			List<CommunityBean> comList = businessCommunityService.findByCon(paramMap);//社区列表
			shiroUser.setComList(comList);
			
//			for(int i=0;i<userResourceList.size();i++) {
//				BusinessUserResource businessUserResource = (BusinessUserResource) userResourceList.get(i);
//				if(businessUserResource.getEstateId() != null && businessUserResource.getEstateId() != 0) {
//					ManageEstate manageEstate = manageEstateService.findById(businessUserResource.getEstateId());
//					EstateBean estateBean = new EstateBean();
//					estateBean.setEstateId(manageEstate.getEstateId());
//					estateBean.setEstateName(manageEstate.getEstateName());
//					estateBean.setComId(businessUserResource.getComId());
//					shiroUser.getEstateBeanList().add(estateBean);
//				}
//				//组装社区列表
//				boolean hasCom = false;
//				for(int j=0;j<comList.size();j++) {
//					CommunityBean communityBean = (CommunityBean) comList.get(j);
//					if(businessUserResource.getComId() != null 
//							&& (communityBean.getComId() == businessUserResource.getComId())) {
//						hasCom = true;
//					}
//				}
//				if(!hasCom) {
//					CommunityBean communityBean = new CommunityBean();
//					if(businessUserResource.getComId() != null && businessUserResource.getComId() != 0) {
//						BusinessCommunity businessCommunity = businessCommunityService.findById(businessUserResource.getComId());
//						communityBean.setComId(businessCommunity.getComId());
//						communityBean.setComName(businessCommunity.getComName());
//						comList.add(communityBean);
//					}						
//				}
//			}
			shiroUser.setComList(comList);
			shiroUser.setMemoryEstateBeanList(shiroUser.getEstateBeanList()); //备份
			//shiroUser.setEstateBeanList(new ArrayList());  //初始化未空
		}
			
		//社区
		/*List comList = new ArrayList();//社区列表
		List userCommunityList = businessUserCommunityService.findByMap(paramMap);
		CommunityBean communityBean = new CommunityBean();
		for(int i=0;i<userCommunityList.size();i++) {
			BusinessUserCommunity businessUserCommunity = (BusinessUserCommunity) userCommunityList.get(i);
			communityBean.setComId(businessUserCommunity.getComId());
			communityBean.setComName(businessUserCommunity.getComName());
			comList.add(communityBean);		
		}
		shiroUser.setComList(comList);*/
		//}else if(shiroUser.getOrgType().equals(ModuleConst.COMMUNITY_CODE)) {//社区
			/*if(userResourceList != null) {
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
			}*/
		//}else if(shiroUser.getOrgType().equals(ModuleConst.PROPERTY_CODE)) {//物业 组织小区列表
			/*if(userResourceList != null) {
				initPropertyEstate(shiroUser, userResourceList);
			}*/
		//}else{//运营组织所有社区列表，小区列表
			/*List comList = businessCommunityService.findAll();
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
			}*/
		//}
	}
	
	/**
	 * 组织物业小区列表
	 * @param userResourceList
	 */
	private void initPropertyEstate(ShiroUser shiroUser, List<BusinessUserResource> userResourceList) {	
		List<EstateBean> estateList = new ArrayList<EstateBean>();
//		Map<String, Object> paramMap = new HashMap<String, Object>();
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
			
		//info.addRole(businessUser.getOrgType());
		//获取所有有效权限
		List roleFunctionList = businessRoleFunctionService.findRoleFunctionList(businessUser.getUserId());
		for(int j=0;j<roleFunctionList.size();j++){
			BusinessRoleFunction roleFunction = (BusinessRoleFunction) roleFunctionList.get(j);
			info.addStringPermission(roleFunction.getFunctionCode());
		}
			
			/*if(!ModuleConst.OPERATION_CODE.equals(businessUser.getOrgType())) { //运营的人员
				//初始化物业、驿站、社区报负责小区
				Map param = new HashMap();
				if(ModuleConst.PROPERTY_CODE.equals(businessUser.getOrgType())) {//物业人员 获取小区ID 
					param.put("proId", shiroUser.getOrgId());
				}else if(ModuleConst.STATION_CODE.equals(businessUser.getOrgType())) {//驿站人员 获取小区ID 
					param.put("stationId", shiroUser.getOrgId());
				}else if(ModuleConst.COMMUNITY_CODE.equals(businessUser.getOrgType())) {//物业、驿站、社区报授权相应模块的权限
					param.put("comId", shiroUser.getOrgId());
				}
				List estateList = manageEstateService.findByMap(param);
				if(estateList != null) {
					shiroUser.setEstateList(estateList);
				}else{
					shiroUser.setEstateList(new ArrayList());
				}
			}*/
		
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
	private List<UserMenuBean> initUserMenu(Integer userId) {
		List<UserMenuBean> menuList = new ArrayList();
		UserMenuBean userMenuBean = new UserMenuBean();
		Map paramMap = new HashMap();
		paramMap.put("userId", userId);
		List roleMenuList = businessRoleMenuService.initMenuList(paramMap);
		for(int i=0;i<roleMenuList.size();i++) {
			BusinessRoleMenu roleMenu = (BusinessRoleMenu) roleMenuList.get(i);
			userMenuBean = new UserMenuBean();
			userMenuBean.setMenuId(roleMenu.getMenuId());
			BusinessMenu businessMenu = businessMenuService.findById(roleMenu.getMenuId());
			userMenuBean.setMenuName(businessMenu.getName());
			userMenuBean.setNo(businessMenu.getOrd());
			userMenuBean.setIcon(businessMenu.getCode());
			userMenuBean.setMenuPath(businessMenu.getUrl());
			userMenuBean.setIsCom(businessMenu.getIsCom());
			userMenuBean.setIsEstate(businessMenu.getIsEstate());
			
			menuList.add(userMenuBean);
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
