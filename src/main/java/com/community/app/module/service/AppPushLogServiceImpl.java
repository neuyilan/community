package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.framework.exception.DaoException;

import com.community.app.module.vo.AppPushLogQuery;
import com.community.app.module.bean.AppPushLog;
import com.community.app.module.dao.AppPushLogDao;

@Service("AppPushLogService")
@Transactional
public class AppPushLogServiceImpl implements AppPushLogService {
	
	private static Logger logger = LoggerFactory.getLogger(AppPushLogServiceImpl.class);
	@Autowired
	private AppPushLogDao appPushLogDao;

	/**
	 * 查询单个AppPushLog
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public AppPushLog findById(final Integer id) throws ServiceException {
		AppPushLog appPushLog = new AppPushLog();
		try {
			appPushLog = appPushLogDao.findById(id);
		} catch (DaoException e) {
			logger.debug("AppPushLogServiceImpl findById()：查询单个AppPushLog发生错误！", e);
			e.printStackTrace();
		}
		return appPushLog;
	}
	
	/**
	 * 无条件查询所有AppPushLog
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<AppPushLog> findAll() throws ServiceException {
		List<AppPushLog> list = new ArrayList<AppPushLog>() ;
		try {
			list=appPushLogDao.findAll();
		} catch (DaoException e) {
			logger.debug("AppPushLogServiceImpl findAll()：无条件查询所有AppPushLog发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppPushLog
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppPushLog> findByMap(final Map paramMap) throws ServiceException {
		List<AppPushLog> list = new ArrayList<AppPushLog>() ;
		try {
			list=appPushLogDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("AppPushLogServiceImpl findByMap()：按Map对象条件查询所有AppPushLog发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppPushLog-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<AppPushLog> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<AppPushLog> list = new ArrayList<AppPushLog>() ;
		try {
			list=appPushLogDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("AppPushLogServiceImpl findByMap()：按Map对象条件查询所有AppPushLog-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有AppPushLog
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppPushLog> findByExample(final AppPushLogQuery query) throws ServiceException {
		List<AppPushLog> list = new ArrayList<AppPushLog>() ;
		try {
			list=appPushLogDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("AppPushLogServiceImpl findByExample()：按VO对象条件查询所有AppPushLog发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppPushLog-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<AppPushLog> findByExample(final AppPushLogQuery query, final Integer limit) throws ServiceException {
		List<AppPushLog> list = new ArrayList<AppPushLog>() ;
		try {
			list=appPushLogDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("AppPushLogServiceImpl findByExample()：按VO对象条件查询所有AppPushLog-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final AppPushLogQuery query) throws ServiceException {
		List<AppPushLog> list = new ArrayList<AppPushLog>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=appPushLogDao.findAllPage(query);
			count=appPushLogDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppPushLogServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final AppPushLogQuery query) throws ServiceException {
		int count = 0;
		try {
			count = appPushLogDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppPushLogServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存AppPushLog数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(AppPushLog entity) throws ServiceException {
		try {
			appPushLogDao.save(entity);
		} catch (DaoException e) {
			logger.debug("AppPushLogServiceImpl save()：保存AppPushLog发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改AppPushLog数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(AppPushLog entity) throws ServiceException {
		try {
			appPushLogDao.update(entity);
		} catch (DaoException e) {
			logger.debug("AppPushLogServiceImpl update()：修改AppPushLog发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除AppPushLog
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return appPushLogDao.delete(id);
		} catch (DaoException e) {
			logger.debug("AppPushLogServiceImpl delete()：删除AppPushLog发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
