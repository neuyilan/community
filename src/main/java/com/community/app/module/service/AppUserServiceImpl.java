package com.community.app.module.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppPushLog;
import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.AppUserConfig;
import com.community.app.module.bean.MemberVO;
import com.community.app.module.dao.AppPushLogDao;
import com.community.app.module.dao.AppUserConfigDao;
import com.community.app.module.dao.AppUserDao;
import com.community.app.module.push.AppPushNotificationUtil;
import com.community.app.module.vo.AppUserConfigQuery;
import com.community.app.module.vo.AppUserQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.framework.utils.propertiesUtil;

@Service("AppUserService")
@Transactional
public class AppUserServiceImpl implements AppUserService {
	
	private static Logger logger = LoggerFactory.getLogger(AppUserServiceImpl.class);
	@Autowired
	private AppUserDao appUserDao;
	
	@Autowired
	private AppUserConfigDao appUserConfigDao;
	@Autowired
	private AppPushLogDao appPushLogDao;
	
	
	

	/**
	 * 查询单个AppUser
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public AppUser findById(final Integer id) throws ServiceException {
		AppUser appUser = new AppUser();
		try {
			appUser = appUserDao.findById(id);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl findById()：查询单个AppUser发生错误！", e);
			e.printStackTrace();
		}
		return appUser;
	}
	
	/**
	 * 无条件查询所有AppUser
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<AppUser> findAll() throws ServiceException {
		List<AppUser> list = new ArrayList<AppUser>() ;
		try {
			list=appUserDao.findAll();
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl findAll()：无条件查询所有AppUser发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppUser
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppUser> findByMap(final Map paramMap) throws ServiceException {
		List<AppUser> list = new ArrayList<AppUser>() ;
		try {
			list=appUserDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl findByMap()：按Map对象条件查询所有AppUser发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppUser-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppUser> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<AppUser> list = new ArrayList<AppUser>() ;
		try {
			list=appUserDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl findByMap()：按Map对象条件查询所有AppUser-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * service
	 * 按VO对象条件查询所有AppUser
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppUser> findByExample(final AppUserQuery query) throws ServiceException {
		List<AppUser> list = new ArrayList<AppUser>() ;
		try {
			list=appUserDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl findByExample()：按VO对象条件查询所有AppUser发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppUser-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppUser> findByExample(final AppUserQuery query, final Integer limit) throws ServiceException {
		List<AppUser> list = new ArrayList<AppUser>() ;
		try {
			list=appUserDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl findByExample()：按VO对象条件查询所有AppUser-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage(final AppUserQuery query) throws ServiceException {
		List<AppUser> list = new ArrayList<AppUser>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			/*if(query.getOrgType() != null 
					&& !"".equals(query.getOrgType())
					&& query.getOrgType().equals(ModuleConst.PROPERTY_CODE)) {
				count=appUserDao.selectCountByProperty(query);
				query.setCount(count);
				list=appUserDao.findAllPageByProperty(query);
			}else{
				count=appUserDao.selectCount(query);
				query.setCount(count);
				list=appUserDao.findAllPage(query);
			}*/
			count=appUserDao.selectCountByProperty(query);
			query.setCount(count);
			list=appUserDao.findAllPageByProperty(query);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setPage(query.getPage());
		baseBean.setRows(12);
		
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount(final AppUserQuery query) throws ServiceException {
		int count = 0;
		try {
			count = appUserDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存AppUser数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(AppUser entity) throws ServiceException {
		try {
			appUserDao.save(entity);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl save()：保存AppUser发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存注册AppUser数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void saveRegist(AppUser entity) throws ServiceException {
		try {
			appUserDao.saveRegist(entity);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl saveRegist()：保存注册AppUser发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改AppUser数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(AppUser entity) throws ServiceException {
		try {
			appUserDao.update(entity);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl update()：修改AppUser发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 清除关于该设备的百度id和设备号
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void updateBaiduId(AppUser entity) throws ServiceException {
		try {
			appUserDao.updateBaiduId(entity);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl update()：修改AppUser发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * service
	 * 修改AppUser数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void updatePassword(AppUser entity) throws ServiceException {
		try {
			appUserDao.updatePassword(entity);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl updatePassword()：修改AppUser发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * service
	 * 修改AppUser数据remarks
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void updateRemarks(AppUser entity) throws ServiceException {
		try {
			appUserDao.updateRemarks(entity);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl updateRemarks()：修改AppUser发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除AppUser
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return appUserDao.delete(id);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl delete()：删除AppUser发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 验证tel是否重复
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean whetherRepeat(final String tel) throws ServiceException{
		try {
			return appUserDao.whetherRepeat(tel);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl whetherRepeat()：！验证是否重复！！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 验证用户tel、password是否重复
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean whetherCorrect(final AppUser entity) throws ServiceException{
		try {
			return appUserDao.whetherCorrect(entity);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl whetherCorrect()：！验证用户tel、password是否正确！！", e);
			e.printStackTrace();
		}
		return false;
	}
	
    /**
     * 查询APP用户信息
     * @param id
     * @return
     * @throws ServiceException
     */
    public MemberVO getAppUserInfo(final Integer id) throws ServiceException {
        MemberVO memberVO = new MemberVO();
        try {
            memberVO = appUserDao.getAppUserInfo(id);
        } catch (DaoException e) {
            logger.debug("AppUserServiceImpl getAppUserInfo()：查询APP用户信息错误！", e);
            e.printStackTrace();
        }
        return memberVO;
    }
    
    /**
     * 查询APP用户登录信息
     * @param id
     * @return
     * @throws ServiceException
     */
    public MemberVO getAppUserLoginInfo(final AppUser entity) throws ServiceException {
        MemberVO memberVO = new MemberVO();
        try {
            memberVO = appUserDao.getAppUserLoginInfo(entity);
        } catch (DaoException e) {
            logger.debug("AppUserServiceImpl getAppUserLoginInfo()：查询APP用户登录信息错误！", e);
            e.printStackTrace();
        }
        return memberVO;
    }

    /**
     * 查询APP用户信息
     * @param obj
     * @return
     * @throws ServiceException
     */
    public MemberVO getAppUserInfoByTel(MemberVO obj) throws ServiceException {
        MemberVO VO = new MemberVO();
        try {
            VO= appUserDao.getAppUserInfoByTel(obj);
        } catch (DaoException e) {
            logger.debug("AppUserServiceImpl getAppUserInfoByTel()：查询APP用户信息错误！", e);
            e.printStackTrace();
        }
        return VO;
    }
    
    /**
     * 查询APP用户信息家庭信息
     * @param obj
     * @return
     * @throws ServiceException
     */
    public MemberVO getAppUserInfoById(final Integer id) throws ServiceException {
        MemberVO VO = new MemberVO();
        try {
            VO= appUserDao.getAppUserInfoById(id);
        } catch (DaoException e) {
            logger.debug("AppUserServiceImpl getAppUserInfoById()：查询APP用户信息错误！", e);
            e.printStackTrace();
        }
        return VO;
    }
    
    /**
     * 按照电话查询关联APP用户
     * @param obj
     * @return
     * @throws ServiceException
     */
    public AppUser getAppUserByTel(final String cellPhone) throws ServiceException {
    	AppUser appUser = null;
    	try {
            List list = (List) appUserDao.getAppUserByTel(cellPhone);
            if(list != null && list.size()>0) {
            	appUser = (AppUser) list.get(0);
            }
        } catch (DaoException e) {
            logger.debug("AppUserServiceImpl getAppUserInfoById()：查询APP用户信息错误！", e);
            e.printStackTrace();
        }
        return appUser;
    }
    
    /**
     * 查询该小区下的userId, baiduId, channelId
     * @param obj
     * @return
     * @throws ServiceException
     */
    public List findUserPushIds(final String estateId) throws ServiceException {
    	List list = new ArrayList() ;
		try {
			list=appUserDao.findUserPushIds(estateId);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl findUserPushIds()：查询该小区下的userId, baiduId, channelId返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
    }
    
    /**
     * 查询该社区下的userId, baiduId, channelId
     * @param obj
     * @return
     * @throws ServiceException
     */
    public List findUserPushIdsByCom(final Integer comId) throws ServiceException {
    	List list = new ArrayList() ;
		try {
			list=appUserDao.findUserPushIdsByCom(comId);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl findUserPushIds()：查询该社区下的userId, baiduId, channelId返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
    }
    
    /**
     * 查询该社区下的userId, baiduId, channelId
     * @param obj
     * @return
     * @throws ServiceException
     */
    public List findPushIdsByCom(final AppUserQuery query) throws ServiceException {
    	List list = new ArrayList() ;
		try {
			list=appUserDao.findPushIdsByCom(query);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl findPushIdsByCom()：查询该社区下的userId, baiduId, channelId返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
    }
    
    /**
	 * 推送天气
	 * @param 
	 * @return
	 * @throws 
	 */	
	public   void pushWeather() {
		AppUserConfigQuery appUserConfigQuery = new AppUserConfigQuery();
		Properties p = propertiesUtil.getProperties("weather.properties");
		AppPushLog appPushLog = new AppPushLog();
		appUserConfigQuery.setWeatherSwitch(0);
		List<AppUserConfig> list;
		try {
			list = appUserConfigDao.findByExample_app(appUserConfigQuery);
			String title = "OK家";
			String description = "【每日天气】今天（"+p.getProperty("weath1")+"）"+p.getProperty("temp1")+" 空气质量："+p.getProperty("pm251");	
			Map paramMap = new HashMap();
			paramMap.put("messageType", 16);
			for (AppUserConfig appUserConfig : list) {
				if(appUserConfig.getBaiduId() != null && !"".equals(appUserConfig.getBaiduId()) && appUserConfig.getChannelId() != null && !"".equals(appUserConfig.getChannelId())) {
					Integer success = AppPushNotificationUtil.pushNotification(
							title, 
							description, 
							appUserConfig.getDeviceType(),
							Long.valueOf(appUserConfig.getChannelId()).longValue(), 
							appUserConfig.getBaiduId(),
							paramMap
							);
					//记录推送日志
					appPushLog.setUserId(appUserConfig.getUserId());
				    appPushLog.setUserName("");
				    appPushLog.setBaiduId(appUserConfig.getBaiduId());
				    appPushLog.setChannelId(appUserConfig.getChannelId());
				    appPushLog.setTitle(title);
				    appPushLog.setDescription(description);
				    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
				    appPushLog.setSendState(success);
				    appPushLog.setSenderId(0);
				    appPushLog.setSenderName("定时推送天气");
				    appPushLogDao.save(appPushLog);
				}
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public MemberVO findByCon(Map<String, Object> con) throws ServiceException {
		// TODO Auto-generated method stub
		MemberVO memberVO = new MemberVO();;
		try {
			memberVO=appUserDao.findByCon(con);
		} catch (DaoException e) {
			logger.debug("AppUserServiceImpl findByMap()：查询APP用户信息错误！", e);
			e.printStackTrace();
		}
		return memberVO;
	}
	
	
}
