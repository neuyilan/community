package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppFocusAdScope;
import com.community.app.module.dao.AppFocusAdScopeDao;
import com.community.app.module.vo.AppFocusAdScopeQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("AppFocusAdScopeService")
@Transactional
public class AppFocusAdScopeServiceImpl implements AppFocusAdScopeService {
	
	private static Logger logger = LoggerFactory.getLogger(AppFocusAdScopeServiceImpl.class);
	@Autowired
	private AppFocusAdScopeDao appFocusAdScopeDao;

	/**
	 * 查询单个AppFocusAdScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public AppFocusAdScope findById(final Integer id) throws ServiceException {
		AppFocusAdScope AppFocusAdScope = new AppFocusAdScope();
		try {
			AppFocusAdScope = appFocusAdScopeDao.findById(id);
		} catch (DaoException e) {
			logger.debug("AppFocusAdScopeServiceImpl findById()：查询单个AppFocusAdScope发生错误！", e);
			e.printStackTrace();
		}
		return AppFocusAdScope;
	}
	
	/**
	 * 无条件查询所有AppFocusAdScope
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<AppFocusAdScope> findAll() throws ServiceException {
		List<AppFocusAdScope> list = new ArrayList<AppFocusAdScope>() ;
		try {
			list=appFocusAdScopeDao.findAll();
		} catch (DaoException e) {
			logger.debug("AppFocusAdScopeServiceImpl findAll()：无条件查询所有AppFocusAdScope发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppFocusAdScope
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppFocusAdScope> findByMap(final Map paramMap) throws ServiceException {
		List<AppFocusAdScope> list = new ArrayList<AppFocusAdScope>() ;
		try {
			list=appFocusAdScopeDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("AppFocusAdScopeServiceImpl findByMap()：按Map对象条件查询所有AppFocusAdScope发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppFocusAdScope-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<AppFocusAdScope> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<AppFocusAdScope> list = new ArrayList<AppFocusAdScope>() ;
		try {
			list=appFocusAdScopeDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("AppFocusAdScopeServiceImpl findByMap()：按Map对象条件查询所有AppFocusAdScope-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有AppFocusAdScope
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppFocusAdScope> findByExample(final AppFocusAdScopeQuery query) throws ServiceException {
		List<AppFocusAdScope> list = new ArrayList<AppFocusAdScope>() ;
		try {
			list=appFocusAdScopeDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("AppFocusAdScopeServiceImpl findByExample()：按VO对象条件查询所有AppFocusAdScope发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppFocusAdScope-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<AppFocusAdScope> findByExample(final AppFocusAdScopeQuery query, final Integer limit) throws ServiceException {
		List<AppFocusAdScope> list = new ArrayList<AppFocusAdScope>() ;
		try {
			list=appFocusAdScopeDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("AppFocusAdScopeServiceImpl findByExample()：按VO对象条件查询所有AppFocusAdScope-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final AppFocusAdScopeQuery query) throws ServiceException {
		List<AppFocusAdScope> list = new ArrayList<AppFocusAdScope>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=appFocusAdScopeDao.findAllPage(query);
			count=appFocusAdScopeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppFocusAdScopeServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final AppFocusAdScopeQuery query) throws ServiceException {
		int count = 0;
		try {
			count = appFocusAdScopeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppFocusAdScopeServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存AppFocusAdScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(AppFocusAdScope entity) throws ServiceException {
		try {
			appFocusAdScopeDao.save(entity);
		} catch (DaoException e) {
			logger.debug("AppFocusAdScopeServiceImpl save()：保存AppFocusAdScope发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改AppFocusAdScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(AppFocusAdScope entity) throws ServiceException {
		try {
			appFocusAdScopeDao.update(entity);
		} catch (DaoException e) {
			logger.debug("AppFocusAdScopeServiceImpl update()：修改AppFocusAdScope发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除AppFocusAdScope
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return appFocusAdScopeDao.delete(id);
		} catch (DaoException e) {
			logger.debug("AppFocusAdScopeServiceImpl delete()：删除AppFocusAdScope发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
}