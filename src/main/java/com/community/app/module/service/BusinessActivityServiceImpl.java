package com.community.app.module.service;

import static com.community.framework.utils.CommonUtils.getUser;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.community.app.module.push.AppPushNotificationUtil;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityScopeQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.vo.BusinessActivityQuery;
import com.community.app.module.bean.AppHomepage;
import com.community.app.module.bean.AppHomepageScope;
import com.community.app.module.bean.AppPushLog;
import com.community.app.module.bean.AppUser;
import com.community.app.module.bean.BusinessActivity;
import com.community.app.module.bean.BusinessActivityScope;
import com.community.app.module.dao.AppPushLogDao;
import com.community.app.module.dao.AppUserDao;
import com.community.app.module.dao.BusinessActivityDao;
import com.community.app.module.dao.BusinessActivityScopeDao;

@Service("BusinessActivityService")
@Transactional
public class BusinessActivityServiceImpl implements BusinessActivityService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessActivityServiceImpl.class);
	@Autowired
	private BusinessActivityDao businessActivityDao;
	@Autowired
	private BusinessActivityScopeDao businessActivityScopeDao;
	@Autowired
	private AppUserDao appUserDao;
	@Autowired
	private AppPushLogDao appPushLogDao;
	@Autowired
	private AppHomepageService appHomepageService;
	@Autowired
	private AppHomepageScopeService appHomepageScopeService;
	
	

	/**
	 * 查询单个BusinessActivity
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessActivity findById(final Integer id) throws ServiceException {
		BusinessActivity businessActivity = new BusinessActivity();
		try {
			businessActivity = businessActivityDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityServiceImpl findById()：查询单个BusinessActivity发生错误！", e);
			e.printStackTrace();
		}
		return businessActivity;
	}
	
	/**
	 * 查询单个BusinessActivity
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = false)
	public BusinessActivity findById_app(final Integer id) throws ServiceException {
		BusinessActivity businessActivity = new BusinessActivity();
		try {
			businessActivity = businessActivityDao.findById_app(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityServiceImpl findById()_app：查询单个BusinessActivity发生错误！", e);
			e.printStackTrace();
		}
		return businessActivity;
	}
	
	/**
	 * 无条件查询所有BusinessActivity
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessActivity> findAll() throws ServiceException {
		List<BusinessActivity> list = new ArrayList<BusinessActivity>() ;
		try {
			list=businessActivityDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessActivityServiceImpl findAll()：无条件查询所有BusinessActivity发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivity
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivity> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessActivity> list = new ArrayList<BusinessActivity>() ;
		try {
			list=businessActivityDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessActivityServiceImpl findByMap()：按Map对象条件查询所有BusinessActivity发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivity-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivity> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessActivity> list = new ArrayList<BusinessActivity>() ;
		try {
			list=businessActivityDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityServiceImpl findByMap()：按Map对象条件查询所有BusinessActivity-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivity
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivity> findByExample(final BusinessActivityQuery query) throws ServiceException {
		List<BusinessActivity> list = new ArrayList<BusinessActivity>() ;
		try {
			list=businessActivityDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityServiceImpl findByExample()：按VO对象条件查询所有BusinessActivity发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivity-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivity> findByExample(final BusinessActivityQuery query, final Integer limit) throws ServiceException {
		List<BusinessActivity> list = new ArrayList<BusinessActivity>() ;
		try {
			list=businessActivityDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityServiceImpl findByExample()：按VO对象条件查询所有BusinessActivity-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessActivityQuery query) throws ServiceException {
		List<BusinessActivity> list = new ArrayList<BusinessActivity>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessActivityDao.selectCount(query);
			query.setCount(count);
			list=businessActivityDao.findAllPage(query);			
		} catch (DaoException e) {
			logger.debug("BusinessActivityServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setPage(query.getPage());
		Subject currentUser = SecurityUtils.getSubject();  
		if (currentUser.isPermitted("activity_publish")) {  //新增活动功能展示会影响分页
			baseBean.setRows(11);
		} else {  
			baseBean.setRows(12);
		}
		return baseBean;
	}
	
	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage_app(final BusinessActivityQuery query) throws ServiceException {
		List<BusinessActivity> list = new ArrayList<BusinessActivity>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessActivityDao.selectCount_app(query);
			query.setCount(count);
			list=businessActivityDao.findAllPage_app(query);			
		} catch (DaoException e) {
			logger.debug("BusinessActivityServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessActivityQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessActivityDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessActivity数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessActivity entity) throws ServiceException {
		try {
			businessActivityDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityServiceImpl save()：保存BusinessActivity发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessActivity数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessActivity entity) throws ServiceException {
		try {
			businessActivityDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityServiceImpl update()：修改BusinessActivity发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询未开始和已开始的活动判断活动是否关闭或启动
	 * @param entity
	 * @throws ServiceException
	 */
	public void updateState() throws ServiceException {
		List<BusinessActivity> list = new ArrayList<BusinessActivity>() ;
		try {
			BusinessActivityQuery businessActivityQuery = new BusinessActivityQuery();
			businessActivityQuery.setType(1);
			list=businessActivityDao.findByExample(businessActivityQuery);
			for (BusinessActivity businessActivity : list) {
				String startTime = businessActivity.getPublishDate() + " " + businessActivity.getPublishTime() + ":00";
				//开始结束时间计算
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date ts = (Date) sdf.parse(startTime);
				long time = ts.getTime() + 30*60*1000;
				Date date = new Date();
				if(businessActivity.getState()==0 && date.getTime()>=time) {
					BusinessActivity businessActiv = new BusinessActivity();
					businessActiv.setActId(businessActivity.getActId());
					businessActiv.setState(2);
					businessActivityDao.update(businessActiv);
				}
				if(businessActivity.getState()==1 && date.getTime()>=ts.getTime()) {
					BusinessActivity businessActiv = new BusinessActivity();
					businessActiv.setActId(businessActivity.getActId());
					businessActiv.setState(0);
					businessActivityDao.update(businessActiv);
				}
			}
			
		} catch (DaoException e) {
			logger.debug("BusinessActivityServiceImpl update()：修改BusinessActivity发生错误！", e);
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessActivity
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessActivityDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityServiceImpl delete()：删除BusinessActivity发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * 查询活动是否有定时推送当前时间的定时推送如果有这推送
	 * @param entity
	 * @throws ServiceException
	 */
	public void isTimingPush() throws ServiceException{
		List<BusinessActivity> list = new ArrayList<BusinessActivity>();
		try {
			Timestamp  ts=new Timestamp(new Date().getTime());
			BusinessActivityQuery businessActivityQuery = new BusinessActivityQuery();
			businessActivityQuery.setTimingPushTime(ts);
			businessActivityQuery.setIsTimingPush(1);
			businessActivityQuery.setIsTimingPushType(1);
			list=businessActivityDao.findByExample(businessActivityQuery);
			for (BusinessActivity businessActivity : list) {
				Map paramMap1 = new HashMap();
    			paramMap1.put("actId", businessActivity.getActId());
    			List<BusinessActivityScope> scopeList = businessActivityScopeDao.findByMap(paramMap1);
    			for (BusinessActivityScope businessActivityScope : scopeList) {
					//查询该小区下的userId, baiduId, channelId
					List appUserList = appUserDao.findUserPushIds(businessActivityScope.getEstateId()+"");
					AppPushLog appPushLog = new AppPushLog();
					String title = "OK家";
					String description = businessActivity.getTimingPushconTent();	
					
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
						    appPushLog.setSenderId(0);
						    appPushLog.setSenderName("");
						    appPushLogDao.save(appPushLog);
						}
					}
				}
			}
			
		} catch (DaoException e) {
			logger.debug("BusinessActivityServiceImpl update()：修改BusinessActivity发生错误！", e);
			e.printStackTrace();
		} 
	}
	
	/**
	 * 查询当前时间活动是否有定时发布
	 * @param entity
	 * @throws ServiceException
	 */
	public void isTimingPublicTime() throws ServiceException{
		List<BusinessActivity> list = new ArrayList<BusinessActivity>();
		try {
			Timestamp  ts=new Timestamp(new Date().getTime());
			BusinessActivityQuery businessActivityQuery = new BusinessActivityQuery();
			businessActivityQuery.setTimingPublicTime(ts);
			businessActivityQuery.setState(6);
			list=businessActivityDao.findByExample(businessActivityQuery);
			for (BusinessActivity businessActivity : list) {
				BusinessActivity obj = new BusinessActivity();
				if (businessActivity.getTypeId()==2) {
					obj.setState(0);
				}else {
					obj.setState(1);
				}
				obj.setActId(businessActivity.getActId());
				businessActivityDao.update(obj);
				AppHomepage appHomepage = new AppHomepage();
        		appHomepage.setId(businessActivity.getActId());
    		    appHomepage.setTitle(businessActivity.getActName());
    		    appHomepage.setBrief(businessActivity.getBrief());
    		    appHomepage.setPic(businessActivity.getAppPic());
    		    appHomepage.setType(4);//活动
    		    appHomepage.setPublishTime(new Timestamp(System.currentTimeMillis()));
				if (businessActivity.getRecommend()==1) {
					
	    		    appHomepage.setTop(1);
				}else {
					appHomepage.setTop(0);
				}
				appHomepageService.save(appHomepage);
				BusinessActivityScopeQuery businessActivityScopeQuery = new BusinessActivityScopeQuery();
				businessActivityScopeQuery.setActId(businessActivity.getActId());
				List<BusinessActivityScope> list2 = businessActivityScopeDao.findByExample(businessActivityScopeQuery);
				
				for(int i=0;i<list2.size();i++) {
                	AppHomepageScope appHomepageScope = new AppHomepageScope();
    				appHomepageScope.setHomePageId(appHomepage.getHomePageId());
    				appHomepageScope.setId(list2.get(i).getEstateId()); //小区id
    				appHomepageScope.setCreateTime(new Timestamp(System.currentTimeMillis()));
    				appHomepageScopeService.save(appHomepageScope);
                }
				if(businessActivity.getIsPush()==1){
					Map paramMap1 = new HashMap();
	    			paramMap1.put("actId", businessActivity.getActId());
	    			List<BusinessActivityScope> scopeList = businessActivityScopeDao.findByMap(paramMap1);
	    			for (BusinessActivityScope businessActivityScope : scopeList) {
						//查询该小区下的userId, baiduId, channelId
						List appUserList = appUserDao.findUserPushIds(businessActivityScope.getEstateId()+"");
						AppPushLog appPushLog = new AppPushLog();
						String title = "OK家";
						String description = businessActivity.getActName();	
						
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
							    appPushLog.setSenderId(0);
							    appPushLog.setSenderName("");
							    appPushLogDao.save(appPushLog);
							}
						}
					}
				}
			}
			
		} catch (DaoException e) {
			logger.debug("BusinessActivityServiceImpl update()：修改BusinessActivity发生错误！", e);
			e.printStackTrace();
		} 
	}
}
