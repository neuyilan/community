package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppFocusScope;
import com.community.app.module.dao.AppFocusScopeDao;
import com.community.app.module.vo.AppFocusScopeQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("AppFocusScopeService")
@Transactional
public class AppFocusScopeServiceImpl implements AppFocusScopeService {
	
	private static Logger logger = LoggerFactory.getLogger(AppFocusScopeServiceImpl.class);
	@Autowired
	private AppFocusScopeDao appFocusScopeDao;

	/**
	 * 查询单个AppFocusScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public AppFocusScope findById(final Integer id) throws ServiceException {
		AppFocusScope appFocusScope = new AppFocusScope();
		try {
			appFocusScope = appFocusScopeDao.findById(id);
		} catch (DaoException e) {
			logger.debug("AppFocusScopeServiceImpl findById()：查询单个AppFocusScope发生错误！", e);
			e.printStackTrace();
		}
		return appFocusScope;
	}
	
	/**
	 * 无条件查询所有AppFocusScope
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<AppFocusScope> findAll() throws ServiceException {
		List<AppFocusScope> list = new ArrayList<AppFocusScope>() ;
		try {
			list=appFocusScopeDao.findAll();
		} catch (DaoException e) {
			logger.debug("AppFocusScopeServiceImpl findAll()：无条件查询所有AppFocusScope发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppFocusScope
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppFocusScope> findByMap(final Map paramMap) throws ServiceException {
		List<AppFocusScope> list = new ArrayList<AppFocusScope>() ;
		try {
			list=appFocusScopeDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("AppFocusScopeServiceImpl findByMap()：按Map对象条件查询所有AppFocusScope发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppFocusScope-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<AppFocusScope> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<AppFocusScope> list = new ArrayList<AppFocusScope>() ;
		try {
			list=appFocusScopeDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("AppFocusScopeServiceImpl findByMap()：按Map对象条件查询所有AppFocusScope-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有AppFocusScope
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppFocusScope> findByExample(final AppFocusScopeQuery query) throws ServiceException {
		List<AppFocusScope> list = new ArrayList<AppFocusScope>() ;
		try {
			list=appFocusScopeDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("AppFocusScopeServiceImpl findByExample()：按VO对象条件查询所有AppFocusScope发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppFocusScope-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<AppFocusScope> findByExample(final AppFocusScopeQuery query, final Integer limit) throws ServiceException {
		List<AppFocusScope> list = new ArrayList<AppFocusScope>() ;
		try {
			list=appFocusScopeDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("AppFocusScopeServiceImpl findByExample()：按VO对象条件查询所有AppFocusScope-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final AppFocusScopeQuery query) throws ServiceException {
		List<AppFocusScope> list = new ArrayList<AppFocusScope>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=appFocusScopeDao.findAllPage(query);
			count=appFocusScopeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppFocusScopeServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final AppFocusScopeQuery query) throws ServiceException {
		int count = 0;
		try {
			count = appFocusScopeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppFocusScopeServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存AppFocusScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(AppFocusScope entity) throws ServiceException {
		try {
			appFocusScopeDao.save(entity);
		} catch (DaoException e) {
			logger.debug("AppFocusScopeServiceImpl save()：保存AppFocusScope发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改AppFocusScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(AppFocusScope entity) throws ServiceException {
		try {
			appFocusScopeDao.update(entity);
		} catch (DaoException e) {
			logger.debug("AppFocusScopeServiceImpl update()：修改AppFocusScope发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除AppFocusScope
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return appFocusScopeDao.delete(id);
		} catch (DaoException e) {
			logger.debug("AppFocusScopeServiceImpl delete()：删除AppFocusScope发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
}