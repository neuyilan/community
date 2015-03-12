package com.community.app.module.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppEstateUser;
import com.community.app.module.bean.AppUser;
import com.community.app.module.dao.AppEstateUserDao;
import com.community.app.module.dao.AppUserDao;
import com.community.app.module.vo.AppEstateUserQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("AppEstateUserService")
@Transactional
public class AppEstateUserServiceImpl implements AppEstateUserService {
	
	private static Logger logger = LoggerFactory.getLogger(AppEstateUserServiceImpl.class);
	@Autowired
	private AppEstateUserDao appEstateUserDao;
	@Autowired
	private AppUserDao appUserDao;
	
	

	/**
	 * 查询单个AppEstateUser
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public AppEstateUser findById(final Integer id) throws ServiceException {
		AppEstateUser appEstateUser = new AppEstateUser();
		try {
			appEstateUser = appEstateUserDao.findById(id);
		} catch (DaoException e) {
			logger.debug("AppEstateUserServiceImpl findById()：查询单个AppEstateUser发生错误！", e);
			e.printStackTrace();
		}
		return appEstateUser;
	}
	
	/**
	 * 无条件查询所有AppEstateUser
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<AppEstateUser> findAll() throws ServiceException {
		List<AppEstateUser> list = new ArrayList<AppEstateUser>() ;
		try {
			list=appEstateUserDao.findAll();
		} catch (DaoException e) {
			logger.debug("AppEstateUserServiceImpl findAll()：无条件查询所有AppEstateUser发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppEstateUser
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppEstateUser> findByMap(final Map paramMap) throws ServiceException {
		List<AppEstateUser> list = new ArrayList<AppEstateUser>() ;
		try {
			list=appEstateUserDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("AppEstateUserServiceImpl findByMap()：按Map对象条件查询所有AppEstateUser发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppEstateUser-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppEstateUser> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<AppEstateUser> list = new ArrayList<AppEstateUser>() ;
		try {
			list=appEstateUserDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("AppEstateUserServiceImpl findByMap()：按Map对象条件查询所有AppEstateUser-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppEstateUser
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppEstateUser> findByExample(final AppEstateUserQuery query) throws ServiceException {
		List<AppEstateUser> list = new ArrayList<AppEstateUser>() ;
		try {
			list=appEstateUserDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("AppEstateUserServiceImpl findByExample()：按VO对象条件查询所有AppEstateUser发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppEstateUser
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppEstateUser> findByExample_app(final AppEstateUserQuery query) throws ServiceException {
		List<AppEstateUser> list = new ArrayList<AppEstateUser>() ;
		try {
			list=appEstateUserDao.findByExample_app(query);
		} catch (DaoException e) {
			logger.debug("AppEstateUserServiceImpl findByExample()：按VO对象条件查询所有AppEstateUser发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppEstateUser-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppEstateUser> findByExample(final AppEstateUserQuery query, final Integer limit) throws ServiceException {
		List<AppEstateUser> list = new ArrayList<AppEstateUser>() ;
		try {
			list=appEstateUserDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("AppEstateUserServiceImpl findByExample()：按VO对象条件查询所有AppEstateUser-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final AppEstateUserQuery query) throws ServiceException {
		List<AppEstateUser> list = new ArrayList<AppEstateUser>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=appEstateUserDao.findAllPage(query);
			count=appEstateUserDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppEstateUserServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final AppEstateUserQuery query) throws ServiceException {
		int count = 0;
		try {
			count = appEstateUserDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppEstateUserServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存AppEstateUser数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(AppEstateUser entity) throws ServiceException {
		try {
			appEstateUserDao.save(entity);
		} catch (DaoException e) {
			logger.debug("AppEstateUserServiceImpl save()：保存AppEstateUser发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改AppEstateUser数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public AppEstateUser update(AppEstateUser entity) throws ServiceException {
		AppEstateUser AppEstateUser = new AppEstateUser();
		try {
			AppEstateUser=appEstateUserDao.update(entity);
		} catch (DaoException e) {
			logger.debug("AppEstateUserServiceImpl update()：修改AppEstateUser发生错误！", e);
			e.printStackTrace();
		}
		return AppEstateUser;
	}
	
	/**
	 * 删除AppEstateUser
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return appEstateUserDao.delete(id);
		} catch (DaoException e) {
			logger.debug("AppEstateUserServiceImpl delete()：删除AppEstateUser发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 根据userId获取小区列表
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppEstateUser> findByUserId(final AppEstateUserQuery query) throws ServiceException {
		List<AppEstateUser> list = new ArrayList<AppEstateUser>() ;
		try {
			list=appEstateUserDao.findByUserId(query);
		} catch (DaoException e) {
			logger.debug("AppEstateUserServiceImpl findByExample()：按VO对象条件查询所有AppEstateUser发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * service
	 * 用户变更小区
	 * @param entity
	 * @throws ServiceException
	 */
	public String update_app(final AppEstateUserQuery query) throws ServiceException {
		String json = "";
		try{
			query.setEstateId(query.getOrdestateId());
			List<AppEstateUser> ordeList = appEstateUserDao.findByUserId(query);//之前小区
			query.setEstateId(query.getCurrestateId());
			List<AppEstateUser> currList = appEstateUserDao.findByUserId(query);//选择小区
			if (ordeList == null || ordeList.size()==0) {
				json += "{";
				json += "\"errorCode\":400,";
				json += "\"message\":\"变更小区不存在\"";
				json += "}";
			}else if (currList !=null && currList.size()!=0) {
				json += "{";
				json += "\"errorCode\":400,";
				json += "\"message\":\"变更小区重复\"";
				json += "}";
			}else {
				if(!ordeList.get(0).getEstateId().equals(ordeList.get(0).getDefaultEstateId())){
					appEstateUserDao.delete(ordeList.get(0).getEstMemId());
					Timestamp  ts=new Timestamp(new Date().getTime());
					AppEstateUser appEstateUser = new AppEstateUser();
					appEstateUser.setEstateId(query.getCurrestateId());
					appEstateUser.setUserId(query.getUserId());
					appEstateUser.setCreateTime(ts);
					appEstateUser.setEditTime(ts);
					appEstateUserDao.save(appEstateUser);
					query.setEstateId(query.getCurrestateId());
					List<AppEstateUser> list1 = appEstateUserDao.findByUserId(query);
					AppUser appUser = new AppUser();
					appUser.setUserId(query.getUserId());
					appUser.setEstateId(list1.get(0).getEstateId());
					appUser.setEstateName(list1.get(0).getEstateName());
					appUser.setEditTime(ts);
					appUserDao.update(appUser);
					json += "{";
					json += "\"errorCode\":\"200\",";
					json += "\"message\":\"变更成功\"";
					json += "}";
				}else {
					appEstateUserDao.delete(ordeList.get(0).getEstMemId());
					Timestamp  ts=new Timestamp(new Date().getTime());
					AppEstateUser appEstateUser = new AppEstateUser();
					appEstateUser.setEstateId(query.getCurrestateId());
					appEstateUser.setUserId(query.getUserId());
					appEstateUser.setCreateTime(ts);
					appEstateUser.setEditTime(ts);
					appEstateUserDao.save(appEstateUser);
					query.setEstateId(query.getCurrestateId());
					List<AppEstateUser> list1 = appEstateUserDao.findByUserId(query);
					AppUser appUser = new AppUser();
					appUser.setUserId(query.getUserId());
					appUser.setEstateId(list1.get(0).getEstateId());
					appUser.setEstateName(list1.get(0).getEstateName());
					appUser.setEditTime(ts);
					appUserDao.update(appUser);
					json += "{";
					json += "\"errorCode\":\"200\",";
					json += "\"message\":\"变更成功\"";
					json += "}";
				}
			}
		}catch(Exception e){
			json += "{";
			json += "\"errorCode\":400,";
			json += "\"message\":\"变更失败\"";
			json += "}";
			e.printStackTrace();
		}	
		return json;
	}
	
}
