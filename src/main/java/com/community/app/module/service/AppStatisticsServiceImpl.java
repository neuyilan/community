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

import com.community.app.module.vo.AppStatisticsQuery;
import com.community.app.module.bean.AppStatistics;
import com.community.app.module.dao.AppStatisticsDao;

@Service("AppStatisticsService")
@Transactional
public class AppStatisticsServiceImpl implements AppStatisticsService {
	
	private static Logger logger = LoggerFactory.getLogger(AppStatisticsServiceImpl.class);
	@Autowired
	private AppStatisticsDao appStatisticsDao;

	/**
	 * 查询单个AppStatistics
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public AppStatistics findById(final Integer id) throws ServiceException {
		AppStatistics appStatistics = new AppStatistics();
		try {
			appStatistics = appStatisticsDao.findById(id);
		} catch (DaoException e) {
			logger.debug("AppStatisticsServiceImpl findById()：查询单个AppStatistics发生错误！", e);
			e.printStackTrace();
		}
		return appStatistics;
	}
	
	/**
	 * 无条件查询所有AppStatistics
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<AppStatistics> findAll() throws ServiceException {
		List<AppStatistics> list = new ArrayList<AppStatistics>() ;
		try {
			list=appStatisticsDao.findAll();
		} catch (DaoException e) {
			logger.debug("AppStatisticsServiceImpl findAll()：无条件查询所有AppStatistics发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppStatistics
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppStatistics> findByMap(final Map paramMap) throws ServiceException {
		List<AppStatistics> list = new ArrayList<AppStatistics>() ;
		try {
			list=appStatisticsDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("AppStatisticsServiceImpl findByMap()：按Map对象条件查询所有AppStatistics发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppStatistics-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<AppStatistics> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<AppStatistics> list = new ArrayList<AppStatistics>() ;
		try {
			list=appStatisticsDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("AppStatisticsServiceImpl findByMap()：按Map对象条件查询所有AppStatistics-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有AppStatistics
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppStatistics> findByExample(final AppStatisticsQuery query) throws ServiceException {
		List<AppStatistics> list = new ArrayList<AppStatistics>() ;
		try {
			list=appStatisticsDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("AppStatisticsServiceImpl findByExample()：按VO对象条件查询所有AppStatistics发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppStatistics-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<AppStatistics> findByExample(final AppStatisticsQuery query, final Integer limit) throws ServiceException {
		List<AppStatistics> list = new ArrayList<AppStatistics>() ;
		try {
			list=appStatisticsDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("AppStatisticsServiceImpl findByExample()：按VO对象条件查询所有AppStatistics-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final AppStatisticsQuery query) throws ServiceException {
		List<AppStatistics> list = new ArrayList<AppStatistics>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=appStatisticsDao.findAllPage(query);
			count=appStatisticsDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppStatisticsServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final AppStatisticsQuery query) throws ServiceException {
		int count = 0;
		try {
			count = appStatisticsDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppStatisticsServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存AppStatistics数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(AppStatistics entity) throws ServiceException {
		try {
			appStatisticsDao.save(entity);
		} catch (DaoException e) {
			logger.debug("AppStatisticsServiceImpl save()：保存AppStatistics发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改AppStatistics数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(AppStatistics entity) throws ServiceException {
		try {
			appStatisticsDao.update(entity);
		} catch (DaoException e) {
			logger.debug("AppStatisticsServiceImpl update()：修改AppStatistics发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除AppStatistics
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return appStatisticsDao.delete(id);
		} catch (DaoException e) {
			logger.debug("AppStatisticsServiceImpl delete()：删除AppStatistics发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
