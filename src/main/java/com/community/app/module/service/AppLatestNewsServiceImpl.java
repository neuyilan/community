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

import com.community.app.module.vo.AppLatestNewsQuery;
import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.dao.AppLatestNewsDao;

@Service("AppLatestNewsService")
@Transactional
public class AppLatestNewsServiceImpl implements AppLatestNewsService {
	
	private static Logger logger = LoggerFactory.getLogger(AppLatestNewsServiceImpl.class);
	@Autowired
	private AppLatestNewsDao appLatestNewsDao;

	/**
	 * 查询单个AppLatestNews
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public AppLatestNews findById(final Integer id) throws ServiceException {
		AppLatestNews appLatestNews = new AppLatestNews();
		try {
			appLatestNews = appLatestNewsDao.findById(id);
		} catch (DaoException e) {
			logger.debug("AppLatestNewsServiceImpl findById()：查询单个AppLatestNews发生错误！", e);
			e.printStackTrace();
		}
		return appLatestNews;
	}
	
	/**
	 * 无条件查询所有AppLatestNews
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<AppLatestNews> findAll() throws ServiceException {
		List<AppLatestNews> list = new ArrayList<AppLatestNews>() ;
		try {
			list=appLatestNewsDao.findAll();
		} catch (DaoException e) {
			logger.debug("AppLatestNewsServiceImpl findAll()：无条件查询所有AppLatestNews发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppLatestNews
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppLatestNews> findByMap(final Map paramMap) throws ServiceException {
		List<AppLatestNews> list = new ArrayList<AppLatestNews>() ;
		try {
			list=appLatestNewsDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("AppLatestNewsServiceImpl findByMap()：按Map对象条件查询所有AppLatestNews发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppLatestNews-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppLatestNews> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<AppLatestNews> list = new ArrayList<AppLatestNews>() ;
		try {
			list=appLatestNewsDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("AppLatestNewsServiceImpl findByMap()：按Map对象条件查询所有AppLatestNews-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppLatestNews
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppLatestNews> findByExample(final AppLatestNewsQuery query) throws ServiceException {
		List<AppLatestNews> list = new ArrayList<AppLatestNews>() ;
		try {
			list=appLatestNewsDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("AppLatestNewsServiceImpl findByExample()：按VO对象条件查询所有AppLatestNews发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppLatestNews-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppLatestNews> findByExample(final AppLatestNewsQuery query, final Integer limit) throws ServiceException {
		List<AppLatestNews> list = new ArrayList<AppLatestNews>() ;
		try {
			list=appLatestNewsDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("AppLatestNewsServiceImpl findByExample()：按VO对象条件查询所有AppLatestNews-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final AppLatestNewsQuery query) throws ServiceException {
		List<AppLatestNews> list = new ArrayList<AppLatestNews>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=appLatestNewsDao.findAllPage(query);
			count=appLatestNewsDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppLatestNewsServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
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
	public BaseBean findAllPage_app(final AppLatestNewsQuery query) throws ServiceException {
		List<AppLatestNews> list = new ArrayList<AppLatestNews>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=appLatestNewsDao.findAllPage_app(query);
			count=appLatestNewsDao.selectCount_app(query);
		} catch (DaoException e) {
			logger.debug("AppLatestNewsServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final AppLatestNewsQuery query) throws ServiceException {
		int count = 0;
		try {
			count = appLatestNewsDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppLatestNewsServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存AppLatestNews数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(AppLatestNews entity) throws ServiceException {
		try {
			appLatestNewsDao.save(entity);
		} catch (DaoException e) {
			logger.debug("AppLatestNewsServiceImpl save()：保存AppLatestNews发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * service
	 * 保存AppLatestNews数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save_app(AppLatestNews entity) throws ServiceException {
		try {
			appLatestNewsDao.save_app(entity);
		} catch (DaoException e) {
			logger.debug("AppLatestNewsServiceImpl save_app()：保存AppLatestNews发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改AppLatestNews数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(AppLatestNews entity) throws ServiceException {
		try {
			appLatestNewsDao.update(entity);
		} catch (DaoException e) {
			logger.debug("AppLatestNewsServiceImpl update()：修改AppLatestNews发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除AppLatestNews
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return appLatestNewsDao.delete(id);
		} catch (DaoException e) {
			logger.debug("AppLatestNewsServiceImpl delete()：删除AppLatestNews发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 按条件删除AppLatestNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean deleteByCondition(final AppLatestNewsQuery query) throws ServiceException {
		try {
			return appLatestNewsDao.deleteByCondition(query);
		} catch (DaoException e) {
			logger.debug("AppLatestNewsServiceImpl deleteByCondition()：按条件删除AppLatestNews发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * service
	 * 删除AppLatestNews
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete_app(final AppLatestNews entity) throws ServiceException {
		try {
			return appLatestNewsDao.delete_app(entity);
		} catch (DaoException e) {
			logger.debug("AppLatestNewsServiceImpl delete_app()：删除AppLatestNews发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * service
	 * 删除AppLatestNews
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete_app_id(final AppLatestNews entity) throws ServiceException {
		try {
			return appLatestNewsDao.delete_app_id(entity);
		} catch (DaoException e) {
			logger.debug("AppLatestNewsServiceImpl delete_app_id()：删除AppLatestNews发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
