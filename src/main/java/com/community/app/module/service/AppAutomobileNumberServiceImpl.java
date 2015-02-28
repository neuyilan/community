package com.community.app.module.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppAutomobileNumber;
import com.community.app.module.bean.AppPushLog;
import com.community.app.module.dao.AppAutomobileNumberDao;
import com.community.app.module.dao.AppPushLogDao;
import com.community.app.module.push.AppPushNotificationUtil;
import com.community.app.module.vo.AppAutomobileNumberQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.framework.utils.propertiesUtil;
import com.community.framework.utils.weather;

@Service("AppAutomobileNumberService")
@Transactional
public class AppAutomobileNumberServiceImpl implements AppAutomobileNumberService {
	
	private static Logger logger = LoggerFactory.getLogger(AppAutomobileNumberServiceImpl.class);
	@Autowired
	private AppAutomobileNumberDao appAutomobileNumberDao;
	@Autowired
	private AppPushLogDao appPushLogDao;

	/**
	 * 查询单个AppAutomobileNumber
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public AppAutomobileNumber findById(final Integer id) throws ServiceException {
		AppAutomobileNumber appAutomobileNumber = new AppAutomobileNumber();
		try {
			appAutomobileNumber = appAutomobileNumberDao.findById(id);
		} catch (DaoException e) {
			logger.debug("AppAutomobileNumberServiceImpl findById()：查询单个AppAutomobileNumber发生错误！", e);
			e.printStackTrace();
		}
		return appAutomobileNumber;
	}
	
	/**
	 * 无条件查询所有AppAutomobileNumber
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<AppAutomobileNumber> findAll() throws ServiceException {
		List<AppAutomobileNumber> list = new ArrayList<AppAutomobileNumber>() ;
		try {
			list=appAutomobileNumberDao.findAll();
		} catch (DaoException e) {
			logger.debug("AppAutomobileNumberServiceImpl findAll()：无条件查询所有AppAutomobileNumber发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppAutomobileNumber
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppAutomobileNumber> findByMap(final Map paramMap) throws ServiceException {
		List<AppAutomobileNumber> list = new ArrayList<AppAutomobileNumber>() ;
		try {
			list=appAutomobileNumberDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("AppAutomobileNumberServiceImpl findByMap()：按Map对象条件查询所有AppAutomobileNumber发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppAutomobileNumber-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<AppAutomobileNumber> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<AppAutomobileNumber> list = new ArrayList<AppAutomobileNumber>() ;
		try {
			list=appAutomobileNumberDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("AppAutomobileNumberServiceImpl findByMap()：按Map对象条件查询所有AppAutomobileNumber-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有AppAutomobileNumber
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppAutomobileNumber> findByExample(final AppAutomobileNumberQuery query) throws ServiceException {
		List<AppAutomobileNumber> list = new ArrayList<AppAutomobileNumber>() ;
		try {
			list=appAutomobileNumberDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("AppAutomobileNumberServiceImpl findByExample()：按VO对象条件查询所有AppAutomobileNumber发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppAutomobileNumber
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppAutomobileNumber> findByExample_app(final AppAutomobileNumberQuery query) throws ServiceException {
		List<AppAutomobileNumber> list = new ArrayList<AppAutomobileNumber>() ;
		try {
			list=appAutomobileNumberDao.findByExample_app(query);
		} catch (DaoException e) {
			logger.debug("AppAutomobileNumberServiceImpl findByExample()：按VO对象条件查询所有AppAutomobileNumber发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppAutomobileNumber-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<AppAutomobileNumber> findByExample(final AppAutomobileNumberQuery query, final Integer limit) throws ServiceException {
		List<AppAutomobileNumber> list = new ArrayList<AppAutomobileNumber>() ;
		try {
			list=appAutomobileNumberDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("AppAutomobileNumberServiceImpl findByExample()：按VO对象条件查询所有AppAutomobileNumber-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage(final AppAutomobileNumberQuery query) throws ServiceException {
		List<AppAutomobileNumber> list = new ArrayList<AppAutomobileNumber>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=appAutomobileNumberDao.findAllPage(query);
			count=appAutomobileNumberDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppAutomobileNumberServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount(final AppAutomobileNumberQuery query) throws ServiceException {
		int count = 0;
		try {
			count = appAutomobileNumberDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppAutomobileNumberServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存AppAutomobileNumber数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(AppAutomobileNumber entity) throws ServiceException {
		try {
			appAutomobileNumberDao.save(entity);
		} catch (DaoException e) {
			logger.debug("AppAutomobileNumberServiceImpl save()：保存AppAutomobileNumber发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改AppAutomobileNumber数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(AppAutomobileNumber entity) throws ServiceException {
		try {
			appAutomobileNumberDao.update(entity);
		} catch (DaoException e) {
			logger.debug("AppAutomobileNumberServiceImpl update()：修改AppAutomobileNumber发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除AppAutomobileNumber
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return appAutomobileNumberDao.delete(id);
		} catch (DaoException e) {
			logger.debug("AppAutomobileNumberServiceImpl delete()：删除AppAutomobileNumber发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 删除AppAutomobileNumber
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(AppAutomobileNumber entity) throws ServiceException {
		try {
			return appAutomobileNumberDao.delete(entity);
		} catch (DaoException e) {
			logger.debug("AppAutomobileNumberServiceImpl delete()：删除AppAutomobileNumber发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	 /**
	 * @throws  
	 * 推送限行
	 * @param 
	 * @return
	 * @throws 
	 */	
	public void pushLimit() throws  ServiceException{
		try {
			AppAutomobileNumberQuery appAutomobileNumberQuery = new AppAutomobileNumberQuery();
			AppPushLog appPushLog = new AppPushLog();
			List<AppAutomobileNumber> list = new ArrayList<AppAutomobileNumber>();
			Properties p = propertiesUtil.getProperties("limit.properties");
			String tomorrow = p.getProperty("tomorrow");
			if(tomorrow.contains("和")){
				String[] arr =tomorrow.split("和");
				if(arr[0].equals(0) || arr[1].equals(0)){
					appAutomobileNumberQuery.setNumberName("'"+arr[0]+"','"+arr[1].substring(0, 1)+"','字母'");
				}else {
					appAutomobileNumberQuery.setNumberName("'"+arr[0]+"','"+arr[1].substring(0, 1)+"'");
				}
				
				list = appAutomobileNumberDao.findByExample_app(appAutomobileNumberQuery);
			}else if (tomorrow.contains("单号限行")) {
				appAutomobileNumberQuery.setNumberName("\"1\",\"3\",\"5\",\"7\",\"9\"");
				list = appAutomobileNumberDao.findByExample_app(appAutomobileNumberQuery);
			}else if (tomorrow.contains("双号限行")) {
				appAutomobileNumberQuery.setNumberName("\"0\",\"2\",\"4\",\"6\",\"8\",\"字母\"");
				list = appAutomobileNumberDao.findByExample_app(appAutomobileNumberQuery);
			}
			String title = "OK家";
			
			Map paramMap = new HashMap();
			paramMap.put("messageType", 17);
			
			for (AppAutomobileNumber appAutomobileNumber : list) {
				if(appAutomobileNumber.getBaiduId() != null && !"".equals(appAutomobileNumber.getBaiduId()) && appAutomobileNumber.getChannelId() != null && !"".equals(appAutomobileNumber.getChannelId())) {
					String description = "【限行提醒】明天您尾号为"+appAutomobileNumber.getNumberName().replace(",", "、")+"的爱车将会限行，请您合理选择您的出行方式。";	
					Timestamp  ts=new Timestamp(new Date().getTime()+86400000);
					paramMap.put("week", weather.dayForWeek(ts.toString()));
					paramMap.put("number", appAutomobileNumber.getNumberName());
					Integer success = AppPushNotificationUtil.pushNotification(
							title, 
							description, 
							appAutomobileNumber.getDeviceType(),
							Long.valueOf(appAutomobileNumber.getChannelId()).longValue(), 
							appAutomobileNumber.getBaiduId(),
							paramMap
							);
					//记录推送日志
					appPushLog.setUserId(appAutomobileNumber.getUserId());
				    appPushLog.setUserName("");
				    appPushLog.setBaiduId(appAutomobileNumber.getBaiduId());
				    appPushLog.setChannelId(appAutomobileNumber.getChannelId());
				    appPushLog.setTitle(title);
				    appPushLog.setDescription(description);
				    appPushLog.setSendTime(new Timestamp(System.currentTimeMillis()));
				    appPushLog.setSendState(success);
				    appPushLog.setSenderId(0);
				    appPushLog.setSenderName("定时推送天气");
				    appPushLogDao.save(appPushLog);
				}
			}
		}catch (DaoException e) {
			logger.debug("AppAutomobileNumberServiceImpl delete()：删除AppAutomobileNumber发生错误！", e);
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
