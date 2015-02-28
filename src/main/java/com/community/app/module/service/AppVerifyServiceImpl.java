package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppVerify;
import com.community.app.module.dao.AppVerifyDao;
import com.community.app.module.vo.AppVerifyQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("AppVerifyService")
@Transactional
public class AppVerifyServiceImpl implements AppVerifyService {
	
	private static Logger logger = LoggerFactory.getLogger(AppVerifyServiceImpl.class);
	@Autowired
	private AppVerifyDao appVerifyDao;

	/**
	 * 查询单个AppVerify
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public AppVerify findById(final Integer id) throws ServiceException {
		AppVerify appVerify = new AppVerify();
		try {
			appVerify = appVerifyDao.findById(id);
		} catch (DaoException e) {
			logger.debug("AppVerifyServiceImpl findById()：查询单个AppVerify发生错误！", e);
			e.printStackTrace();
		}
		return appVerify;
	}
	
	/**
	 * 无条件查询所有AppVerify
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<AppVerify> findAll() throws ServiceException {
		List<AppVerify> list = new ArrayList<AppVerify>() ;
		try {
			list=appVerifyDao.findAll();
		} catch (DaoException e) {
			logger.debug("AppVerifyServiceImpl findAll()：无条件查询所有AppVerify发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppVerify
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppVerify> findByMap(final Map paramMap) throws ServiceException {
		List<AppVerify> list = new ArrayList<AppVerify>() ;
		try {
			list=appVerifyDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("AppVerifyServiceImpl findByMap()：按Map对象条件查询所有AppVerify发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppVerify-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppVerify> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<AppVerify> list = new ArrayList<AppVerify>() ;
		try {
			list=appVerifyDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("AppVerifyServiceImpl findByMap()：按Map对象条件查询所有AppVerify-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppVerify
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppVerify> findByExample(final AppVerifyQuery query) throws ServiceException {
		List<AppVerify> list = new ArrayList<AppVerify>() ;
		try {
			list=appVerifyDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("AppVerifyServiceImpl findByExample()：按VO对象条件查询所有AppVerify发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppVerify-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppVerify> findByExample(final AppVerifyQuery query, final Integer limit) throws ServiceException {
		List<AppVerify> list = new ArrayList<AppVerify>() ;
		try {
			list=appVerifyDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("AppVerifyServiceImpl findByExample()：按VO对象条件查询所有AppVerify-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final AppVerifyQuery query) throws ServiceException {
		List<AppVerify> list = new ArrayList<AppVerify>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=appVerifyDao.findAllPage(query);
			count=appVerifyDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppVerifyServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final AppVerifyQuery query) throws ServiceException {
		int count = 0;
		try {
			count = appVerifyDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppVerifyServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存AppVerify数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(AppVerify entity) throws ServiceException {
		try {
			appVerifyDao.save(entity);
		} catch (DaoException e) {
			logger.debug("AppVerifyServiceImpl save()：保存AppVerify发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改AppVerify数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(AppVerify entity) throws ServiceException {
		try {
			appVerifyDao.update(entity);
		} catch (DaoException e) {
			logger.debug("AppVerifyServiceImpl update()：修改AppVerify发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除AppVerify
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(final AppVerifyQuery query) throws ServiceException {
		try {
			return appVerifyDao.delete(query);
		} catch (DaoException e) {
			logger.debug("AppVerifyServiceImpl delete()：删除AppVerify发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
