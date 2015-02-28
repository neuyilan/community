package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppUserCellphone;
import com.community.app.module.dao.AppUserCellphoneDao;
import com.community.app.module.vo.AppUserCellphoneQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("AppUserCellphoneService")
@Transactional
public class AppUserCellphoneServiceImpl implements AppUserCellphoneService {
	
	private static Logger logger = LoggerFactory.getLogger(AppUserCellphoneServiceImpl.class);
	@Autowired
	private AppUserCellphoneDao appUserCellphoneDao;

	/**
	 * 查询单个AppUserCellphone
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public AppUserCellphone findById(final Integer id) throws ServiceException {
		AppUserCellphone appUserCellphone = new AppUserCellphone();
		try {
			appUserCellphone = appUserCellphoneDao.findById(id);
		} catch (DaoException e) {
			logger.debug("AppUserCellphoneServiceImpl findById()：查询单个AppUserCellphone发生错误！", e);
			e.printStackTrace();
		}
		return appUserCellphone;
	}
	
	/**
	 * 无条件查询所有AppUserCellphone
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<AppUserCellphone> findAll() throws ServiceException {
		List<AppUserCellphone> list = new ArrayList<AppUserCellphone>() ;
		try {
			list=appUserCellphoneDao.findAll();
		} catch (DaoException e) {
			logger.debug("AppUserCellphoneServiceImpl findAll()：无条件查询所有AppUserCellphone发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppUserCellphone
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppUserCellphone> findByMap(final Map paramMap) throws ServiceException {
		List<AppUserCellphone> list = new ArrayList<AppUserCellphone>() ;
		try {
			list=appUserCellphoneDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("AppUserCellphoneServiceImpl findByMap()：按Map对象条件查询所有AppUserCellphone发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppUserCellphone-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppUserCellphone> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<AppUserCellphone> list = new ArrayList<AppUserCellphone>() ;
		try {
			list=appUserCellphoneDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("AppUserCellphoneServiceImpl findByMap()：按Map对象条件查询所有AppUserCellphone-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * service
	 * 按VO对象条件查询所有AppUserCellphone
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppUserCellphone> findByExample(final AppUserCellphoneQuery query) throws ServiceException {
		List<AppUserCellphone> list = new ArrayList<AppUserCellphone>() ;
		try {
			list=appUserCellphoneDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("AppUserCellphoneServiceImpl findByExample()：按VO对象条件查询所有AppUserCellphone发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppUserCellphone-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppUserCellphone> findByExample(final AppUserCellphoneQuery query, final Integer limit) throws ServiceException {
		List<AppUserCellphone> list = new ArrayList<AppUserCellphone>() ;
		try {
			list=appUserCellphoneDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("AppUserCellphoneServiceImpl findByExample()：按VO对象条件查询所有AppUserCellphone-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final AppUserCellphoneQuery query) throws ServiceException {
		List<AppUserCellphone> list = new ArrayList<AppUserCellphone>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=appUserCellphoneDao.findAllPage(query);
			count=appUserCellphoneDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppUserCellphoneServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final AppUserCellphoneQuery query) throws ServiceException {
		int count = 0;
		try {
			count = appUserCellphoneDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppUserCellphoneServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * service
	 * 保存AppUserCellphone数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(AppUserCellphone entity) throws ServiceException {
		try {
			appUserCellphoneDao.save(entity);
		} catch (DaoException e) {
			logger.debug("AppUserCellphoneServiceImpl save()：保存AppUserCellphone发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * service
	 * 修改AppUserCellphone数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(AppUserCellphone entity) throws ServiceException {
		try {
			appUserCellphoneDao.update(entity);
		} catch (DaoException e) {
			logger.debug("AppUserCellphoneServiceImpl update()：修改AppUserCellphone发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * service
	 * 删除AppUserCellphone
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return appUserCellphoneDao.delete(id);
		} catch (DaoException e) {
			logger.debug("AppUserCellphoneServiceImpl delete()：删除AppUserCellphone发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
