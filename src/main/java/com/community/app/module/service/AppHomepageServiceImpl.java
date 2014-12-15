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

import com.community.app.module.vo.AppHomepageQuery;
import com.community.app.module.bean.AppHomepage;
import com.community.app.module.dao.AppHomepageDao;

@Service("AppHomepageService")
@Transactional
public class AppHomepageServiceImpl implements AppHomepageService {
	
	private static Logger logger = LoggerFactory.getLogger(AppHomepageServiceImpl.class);
	@Autowired
	private AppHomepageDao appHomepageDao;

	/**
	 * 查询单个AppHomepage
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public AppHomepage findById(final Integer id) throws ServiceException {
		AppHomepage appHomepage = new AppHomepage();
		try {
			appHomepage = appHomepageDao.findById(id);
		} catch (DaoException e) {
			logger.debug("AppHomepageServiceImpl findById()：查询单个AppHomepage发生错误！", e);
			e.printStackTrace();
		}
		return appHomepage;
	}
	
	/**
	 * 无条件查询所有AppHomepage
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<AppHomepage> findAll() throws ServiceException {
		List<AppHomepage> list = new ArrayList<AppHomepage>() ;
		try {
			list=appHomepageDao.findAll();
		} catch (DaoException e) {
			logger.debug("AppHomepageServiceImpl findAll()：无条件查询所有AppHomepage发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppHomepage
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppHomepage> findByMap(final Map paramMap) throws ServiceException {
		List<AppHomepage> list = new ArrayList<AppHomepage>() ;
		try {
			list=appHomepageDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("AppHomepageServiceImpl findByMap()：按Map对象条件查询所有AppHomepage发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppHomepage-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppHomepage> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<AppHomepage> list = new ArrayList<AppHomepage>() ;
		try {
			list=appHomepageDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("AppHomepageServiceImpl findByMap()：按Map对象条件查询所有AppHomepage-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppHomepage
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppHomepage> findByExample(final AppHomepageQuery query) throws ServiceException {
		List<AppHomepage> list = new ArrayList<AppHomepage>() ;
		try {
			list=appHomepageDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("AppHomepageServiceImpl findByExample()：按VO对象条件查询所有AppHomepage发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppHomepage-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppHomepage> findByExample(final AppHomepageQuery query, final Integer limit) throws ServiceException {
		List<AppHomepage> list = new ArrayList<AppHomepage>() ;
		try {
			list=appHomepageDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("AppHomepageServiceImpl findByExample()：按VO对象条件查询所有AppHomepage-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final AppHomepageQuery query) throws ServiceException {
		List<AppHomepage> list = new ArrayList<AppHomepage>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=appHomepageDao.findAllPage(query);
			count=appHomepageDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppHomepageServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage_app(final AppHomepageQuery query) throws ServiceException {
		List<AppHomepage> list = new ArrayList<AppHomepage>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=appHomepageDao.findAllPage_app(query);
			count=appHomepageDao.selectCount_app(query);
		} catch (DaoException e) {
			logger.debug("AppHomepageServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final AppHomepageQuery query) throws ServiceException {
		int count = 0;
		try {
			count = appHomepageDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppHomepageServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存AppHomepage数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(AppHomepage entity) throws ServiceException {
		try {
			appHomepageDao.save(entity);
		} catch (DaoException e) {
			logger.debug("AppHomepageServiceImpl save()：保存AppHomepage发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改AppHomepage数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(AppHomepage entity) throws ServiceException {
		try {
			appHomepageDao.update(entity);
		} catch (DaoException e) {
			logger.debug("AppHomepageServiceImpl update()：修改AppHomepage发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除AppHomepage
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(AppHomepage entity) throws ServiceException {
		try {
			return appHomepageDao.delete(entity);
		} catch (DaoException e) {
			logger.debug("AppHomepageServiceImpl delete()：删除AppHomepage发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
}