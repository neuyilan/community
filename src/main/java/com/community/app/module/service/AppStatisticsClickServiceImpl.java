package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppStatisticsClick;
import com.community.app.module.dao.AppStatisticsClickDao;
import com.community.app.module.vo.AppStatisticsClickQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("AppStatisticsClickService")
@Transactional
public class AppStatisticsClickServiceImpl implements AppStatisticsClickService {
	
	private static Logger logger = LoggerFactory.getLogger(AppStatisticsClickServiceImpl.class);
	@Autowired
	private AppStatisticsClickDao appStatisticsClickDao;

	/**
	 * 查询单个AppStatisticsClick
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public AppStatisticsClick findById(final Integer id) throws ServiceException {
		AppStatisticsClick appStatisticsClick = new AppStatisticsClick();
		try {
			appStatisticsClick = appStatisticsClickDao.findById(id);
		} catch (DaoException e) {
			logger.debug("AppStatisticsClickServiceImpl findById()：查询单个AppStatisticsClick发生错误！", e);
			e.printStackTrace();
		}
		return appStatisticsClick;
	}
	
	/**
	 * 无条件查询所有AppStatisticsClick
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<AppStatisticsClick> findAll() throws ServiceException {
		List<AppStatisticsClick> list = new ArrayList<AppStatisticsClick>() ;
		try {
			list=appStatisticsClickDao.findAll();
		} catch (DaoException e) {
			logger.debug("AppStatisticsClickServiceImpl findAll()：无条件查询所有AppStatisticsClick发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppStatisticsClick
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppStatisticsClick> findByMap(final Map paramMap) throws ServiceException {
		List<AppStatisticsClick> list = new ArrayList<AppStatisticsClick>() ;
		try {
			list=appStatisticsClickDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("AppStatisticsClickServiceImpl findByMap()：按Map对象条件查询所有AppStatisticsClick发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppStatisticsClick-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<AppStatisticsClick> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<AppStatisticsClick> list = new ArrayList<AppStatisticsClick>() ;
		try {
			list=appStatisticsClickDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("AppStatisticsClickServiceImpl findByMap()：按Map对象条件查询所有AppStatisticsClick-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有AppStatisticsClick
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppStatisticsClick> findByExample(final AppStatisticsClickQuery query) throws ServiceException {
		List<AppStatisticsClick> list = new ArrayList<AppStatisticsClick>() ;
		try {
			list=appStatisticsClickDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("AppStatisticsClickServiceImpl findByExample()：按VO对象条件查询所有AppStatisticsClick发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppStatisticsClick-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<AppStatisticsClick> findByExample(final AppStatisticsClickQuery query, final Integer limit) throws ServiceException {
		List<AppStatisticsClick> list = new ArrayList<AppStatisticsClick>() ;
		try {
			list=appStatisticsClickDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("AppStatisticsClickServiceImpl findByExample()：按VO对象条件查询所有AppStatisticsClick-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final AppStatisticsClickQuery query) throws ServiceException {
		List<AppStatisticsClick> list = new ArrayList<AppStatisticsClick>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=appStatisticsClickDao.findAllPage(query);
			count=appStatisticsClickDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppStatisticsClickServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final AppStatisticsClickQuery query) throws ServiceException {
		int count = 0;
		try {
			count = appStatisticsClickDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppStatisticsClickServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存AppStatisticsClick数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(AppStatisticsClick entity) throws ServiceException {
		try {
			appStatisticsClickDao.save(entity);
		} catch (DaoException e) {
			logger.debug("AppStatisticsClickServiceImpl save()：保存AppStatisticsClick发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改AppStatisticsClick数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(AppStatisticsClick entity) throws ServiceException {
		try {
			appStatisticsClickDao.update(entity);
		} catch (DaoException e) {
			logger.debug("AppStatisticsClickServiceImpl update()：修改AppStatisticsClick发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除AppStatisticsClick
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return appStatisticsClickDao.delete(id);
		} catch (DaoException e) {
			logger.debug("AppStatisticsClickServiceImpl delete()：删除AppStatisticsClick发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
