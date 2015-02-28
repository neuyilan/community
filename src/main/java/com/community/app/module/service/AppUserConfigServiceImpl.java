package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppUserConfig;
import com.community.app.module.dao.AppUserConfigDao;
import com.community.app.module.vo.AppUserConfigQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("AppUserConfigService")
@Transactional
public class AppUserConfigServiceImpl implements AppUserConfigService {
	
	private static Logger logger = LoggerFactory.getLogger(AppUserConfigServiceImpl.class);
	@Autowired
	private AppUserConfigDao appUserConfigDao;

	/**
	 * 查询单个AppUserConfig
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public AppUserConfig findById(final Integer id) throws ServiceException {
		AppUserConfig appUserConfig = new AppUserConfig();
		try {
			appUserConfig = appUserConfigDao.findById(id);
		} catch (DaoException e) {
			logger.debug("AppUserConfigServiceImpl findById()：查询单个AppUserConfig发生错误！", e);
			e.printStackTrace();
		}
		return appUserConfig;
	}
	
	/**
	 * 无条件查询所有AppUserConfig
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<AppUserConfig> findAll() throws ServiceException {
		List<AppUserConfig> list = new ArrayList<AppUserConfig>() ;
		try {
			list=appUserConfigDao.findAll();
		} catch (DaoException e) {
			logger.debug("AppUserConfigServiceImpl findAll()：无条件查询所有AppUserConfig发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppUserConfig
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppUserConfig> findByMap(final Map paramMap) throws ServiceException {
		List<AppUserConfig> list = new ArrayList<AppUserConfig>() ;
		try {
			list=appUserConfigDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("AppUserConfigServiceImpl findByMap()：按Map对象条件查询所有AppUserConfig发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppUserConfig-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppUserConfig> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<AppUserConfig> list = new ArrayList<AppUserConfig>() ;
		try {
			list=appUserConfigDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("AppUserConfigServiceImpl findByMap()：按Map对象条件查询所有AppUserConfig-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppUserConfig
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppUserConfig> findByExample(final AppUserConfigQuery query) throws ServiceException {
		List<AppUserConfig> list = new ArrayList<AppUserConfig>() ;
		try {
			list=appUserConfigDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("AppUserConfigServiceImpl findByExample()：按VO对象条件查询所有AppUserConfig发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppUserConfig
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppUserConfig> findByExample_app(final AppUserConfigQuery query) throws ServiceException {
		List<AppUserConfig> list = new ArrayList<AppUserConfig>() ;
		try {
			list=appUserConfigDao.findByExample_app(query);
		} catch (DaoException e) {
			logger.debug("AppUserConfigServiceImpl findByExample()：按VO对象条件查询所有AppUserConfig发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppUserConfig-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppUserConfig> findByExample(final AppUserConfigQuery query, final Integer limit) throws ServiceException {
		List<AppUserConfig> list = new ArrayList<AppUserConfig>() ;
		try {
			list=appUserConfigDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("AppUserConfigServiceImpl findByExample()：按VO对象条件查询所有AppUserConfig-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final AppUserConfigQuery query) throws ServiceException {
		List<AppUserConfig> list = new ArrayList<AppUserConfig>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=appUserConfigDao.findAllPage(query);
			count=appUserConfigDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppUserConfigServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final AppUserConfigQuery query) throws ServiceException {
		int count = 0;
		try {
			count = appUserConfigDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppUserConfigServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存AppUserConfig数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(AppUserConfig entity) throws ServiceException {
		try {
			appUserConfigDao.save(entity);
		} catch (DaoException e) {
			logger.debug("AppUserConfigServiceImpl save()：保存AppUserConfig发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改AppUserConfig数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(AppUserConfig entity) throws ServiceException {
		try {
			appUserConfigDao.update(entity);
		} catch (DaoException e) {
			logger.debug("AppUserConfigServiceImpl update()：修改AppUserConfig发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除AppUserConfig
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return appUserConfigDao.delete(id);
		} catch (DaoException e) {
			logger.debug("AppUserConfigServiceImpl delete()：删除AppUserConfig发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
