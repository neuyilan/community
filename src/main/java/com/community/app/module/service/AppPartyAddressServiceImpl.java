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

import com.community.app.module.vo.AppPartyAddressQuery;
import com.community.app.module.bean.AppPartyAddress;
import com.community.app.module.dao.AppPartyAddressDao;

@Service("AppPartyAddressService")
@Transactional
public class AppPartyAddressServiceImpl implements AppPartyAddressService {
	
	private static Logger logger = LoggerFactory.getLogger(AppPartyAddressServiceImpl.class);
	@Autowired
	private AppPartyAddressDao appPartyAddressDao;

	/**
	 * 查询单个AppPartyAddress
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public AppPartyAddress findById(final Integer id) throws ServiceException {
		AppPartyAddress appPartyAddress = new AppPartyAddress();
		try {
			appPartyAddress = appPartyAddressDao.findById(id);
		} catch (DaoException e) {
			logger.debug("AppPartyAddressServiceImpl findById()：查询单个AppPartyAddress发生错误！", e);
			e.printStackTrace();
		}
		return appPartyAddress;
	}
	
	/**
	 * 无条件查询所有AppPartyAddress
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<AppPartyAddress> findAll() throws ServiceException {
		List<AppPartyAddress> list = new ArrayList<AppPartyAddress>() ;
		try {
			list=appPartyAddressDao.findAll();
		} catch (DaoException e) {
			logger.debug("AppPartyAddressServiceImpl findAll()：无条件查询所有AppPartyAddress发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppPartyAddress
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppPartyAddress> findByMap(final Map paramMap) throws ServiceException {
		List<AppPartyAddress> list = new ArrayList<AppPartyAddress>() ;
		try {
			list=appPartyAddressDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("AppPartyAddressServiceImpl findByMap()：按Map对象条件查询所有AppPartyAddress发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppPartyAddress-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppPartyAddress> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<AppPartyAddress> list = new ArrayList<AppPartyAddress>() ;
		try {
			list=appPartyAddressDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("AppPartyAddressServiceImpl findByMap()：按Map对象条件查询所有AppPartyAddress-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppPartyAddress
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppPartyAddress> findByExample(final AppPartyAddressQuery query) throws ServiceException {
		List<AppPartyAddress> list = new ArrayList<AppPartyAddress>() ;
		try {
			list=appPartyAddressDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("AppPartyAddressServiceImpl findByExample()：按VO对象条件查询所有AppPartyAddress发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppPartyAddress-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<AppPartyAddress> findByExample(final AppPartyAddressQuery query, final Integer limit) throws ServiceException {
		List<AppPartyAddress> list = new ArrayList<AppPartyAddress>() ;
		try {
			list=appPartyAddressDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("AppPartyAddressServiceImpl findByExample()：按VO对象条件查询所有AppPartyAddress-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final AppPartyAddressQuery query) throws ServiceException {
		List<AppPartyAddress> list = new ArrayList<AppPartyAddress>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=appPartyAddressDao.findAllPage(query);
			count=appPartyAddressDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppPartyAddressServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final AppPartyAddressQuery query) throws ServiceException {
		int count = 0;
		try {
			count = appPartyAddressDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("AppPartyAddressServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * service
	 * 保存AppPartyAddress数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(AppPartyAddressQuery entity) throws ServiceException {
		try {
			appPartyAddressDao.save(entity);
		} catch (DaoException e) {
			logger.debug("AppPartyAddressServiceImpl save()：保存AppPartyAddress发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * service
	 * 修改AppPartyAddress数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(AppPartyAddressQuery entity) throws ServiceException {
		try {
			appPartyAddressDao.update(entity);
		} catch (DaoException e) {
			logger.debug("AppPartyAddressServiceImpl update()：修改AppPartyAddress发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除AppPartyAddress
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return appPartyAddressDao.delete(id);
		} catch (DaoException e) {
			logger.debug("AppPartyAddressServiceImpl delete()：删除AppPartyAddress发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * service
	 * 设置默认收货地址
	 * @param entity
	 * @throws ServiceException
	 */
	public void setDefault(final AppPartyAddressQuery entity) throws ServiceException{
		try {
			appPartyAddressDao.setDefault(entity);
		} catch (DaoException e) {
			logger.debug("AppPartyAddressServiceImpl setDefault()：设置默认收货地址发生错误！", e);
			e.printStackTrace();
		}
	}
	
}
