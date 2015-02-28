package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppUserNews;
import com.community.app.module.dao.AppUserNewsDao;
import com.community.app.module.vo.AppUserNewsQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("AppUserNewsService")
@Transactional
public class AppUserNewsServiceImpl implements AppUserNewsService {
	
	private static Logger logger = LoggerFactory.getLogger(AppUserNewsServiceImpl.class);
	@Autowired
	private AppUserNewsDao appUserNewsDao;

	/**
	 * 查询单个AppUserNews
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public AppUserNews findById(final Integer id) throws ServiceException {
		AppUserNews appUserNews = new AppUserNews();
		try {
			appUserNews = appUserNewsDao.findById(id);
		} catch (DaoException e) {
			logger.debug("AppUserNewsServiceImpl findById()：查询单个AppUserNews发生错误！", e);
			e.printStackTrace();
		}
		return appUserNews;
	}
	
	/**
	 * 无条件查询所有AppUserNews
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<AppUserNews> findAll() throws ServiceException {
		List<AppUserNews> list = new ArrayList<AppUserNews>() ;
		try {
			list=appUserNewsDao.findAll();
		} catch (DaoException e) {
			logger.debug("AppUserNewsServiceImpl findAll()：无条件查询所有AppUserNews发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppUserNews
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppUserNews> findByMap(final Map paramMap) throws ServiceException {
		List<AppUserNews> list = new ArrayList<AppUserNews>() ;
		try {
			list=appUserNewsDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("AppUserNewsServiceImpl findByMap()：按Map对象条件查询所有AppUserNews发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppUserNews-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppUserNews> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<AppUserNews> list = new ArrayList<AppUserNews>() ;
		try {
			list=appUserNewsDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("AppUserNewsServiceImpl findByMap()：按Map对象条件查询所有AppUserNews-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppUserNews
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppUserNews> findByExample(final AppUserNewsQuery query) throws ServiceException {
		List<AppUserNews> list = new ArrayList<AppUserNews>() ;
		try {
			list=appUserNewsDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("AppUserNewsServiceImpl findByExample()：按VO对象条件查询所有AppUserNews发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppUserNews-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppUserNews> findByExample(final AppUserNewsQuery query, final Integer limit) throws ServiceException {
		List<AppUserNews> list = new ArrayList<AppUserNews>() ;
		try {
			list=appUserNewsDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("AppUserNewsServiceImpl findByExample()：按VO对象条件查询所有AppUserNews-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final AppUserNewsQuery query) throws ServiceException {
		List<AppUserNews> list = new ArrayList<AppUserNews>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=appUserNewsDao.findAllPage(query);
			count=appUserNewsDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppUserNewsServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final AppUserNewsQuery query) throws ServiceException {
		int count = 0;
		try {
			count = appUserNewsDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppUserNewsServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存AppUserNews数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(AppUserNews entity) throws ServiceException {
		try {
			appUserNewsDao.save(entity);
		} catch (DaoException e) {
			logger.debug("AppUserNewsServiceImpl save()：保存AppUserNews发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改AppUserNews数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(AppUserNews entity) throws ServiceException {
		try {
			appUserNewsDao.update(entity);
		} catch (DaoException e) {
			logger.debug("AppUserNewsServiceImpl update()：修改AppUserNews发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除AppUserNews
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return appUserNewsDao.delete(id);
		} catch (DaoException e) {
			logger.debug("AppUserNewsServiceImpl delete()：删除AppUserNews发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * service
	 * 新增回复我的
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void saveReply(final AppUserNews entity) throws ServiceException {
		try {
			appUserNewsDao.deleteType(entity);
			appUserNewsDao.saveReply(entity);
		} catch (DaoException e) {
			logger.debug("AppUserNewsServiceImpl save()：保存AppUserNews发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * service
	 * 新增回复我的
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void saveReply_manage(final AppUserNews entity) throws ServiceException {
		try {
			appUserNewsDao.deleteType(entity);
			appUserNewsDao.save(entity);
		} catch (DaoException e) {
			logger.debug("AppUserNewsServiceImpl save()：保存AppUserNews发生错误！", e);
			e.printStackTrace();
		}
	}
}
