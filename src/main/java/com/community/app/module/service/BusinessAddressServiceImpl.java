package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessAddress;
import com.community.app.module.dao.BusinessAddressDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessAddressQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessAddressService")
@Transactional
public class BusinessAddressServiceImpl implements BusinessAddressService {

	private static Logger logger = LoggerFactory
			.getLogger(BusinessAddressServiceImpl.class);
	@Autowired
	private BusinessAddressDao businessAddressDao;

	/**
	 * 查询单个BusinessAddress
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessAddress findById(final Integer id) throws ServiceException {
		BusinessAddress businessAddress = new BusinessAddress();
		try {
			businessAddress = businessAddressDao.findById(id);
		} catch (DaoException e) {
			logger.debug(
					"BusinessAddressServiceImpl findById()：查询单个BusinessAddress发生错误！",
					e);
			e.printStackTrace();
		}
		return businessAddress;
	}

	/**
	 * 无条件查询所有BusinessAddress
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessAddress> findAll() throws ServiceException {
		List<BusinessAddress> list = new ArrayList<BusinessAddress>();
		try {
			list = businessAddressDao.findAll();
		} catch (DaoException e) {
			logger.debug(
					"BusinessAddressServiceImpl findAll()：无条件查询所有BusinessAddress发生错误！",
					e);
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessAddress
	 * 
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessAddress> findByMap(final Map paramMap)
			throws ServiceException {
		List<BusinessAddress> list = new ArrayList<BusinessAddress>();
		try {
			list = businessAddressDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug(
					"BusinessAddressServiceImpl findByMap()：按Map对象条件查询所有BusinessAddress发生错误！",
					e);
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessAddress-限制返回条数
	 * 
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */
	/*
	 * @Transactional(readOnly = true) public List<BusinessAddress>
	 * findByMap(final Map paramMap, final Integer limit) throws
	 * ServiceException { List<BusinessAddress> list = new
	 * ArrayList<BusinessAddress>() ; try {
	 * list=businessAddressDao.findByMap(paramMap, limit); } catch (DaoException
	 * e) { logger.debug(
	 * "BusinessAddressServiceImpl findByMap()：按Map对象条件查询所有BusinessAddress-限制返回条数发生错误！"
	 * , e); e.printStackTrace(); } return list; }
	 */

	/**
	 * 按VO对象条件查询所有BusinessAddress
	 * 
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessAddress> findByExample(final BusinessAddressQuery query)
			throws ServiceException {
		List<BusinessAddress> list = new ArrayList<BusinessAddress>();
		try {
			list = businessAddressDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug(
					"BusinessAddressServiceImpl findByExample()：按VO对象条件查询所有BusinessAddress发生错误！",
					e);
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 按VO对象条件查询所有BusinessAddress-限制返回条数
	 * 
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	/*
	 * @Transactional(readOnly = true) public List<BusinessAddress>
	 * findByExample(final BusinessAddressQuery query, final Integer limit)
	 * throws ServiceException { List<BusinessAddress> list = new
	 * ArrayList<BusinessAddress>() ; try {
	 * list=businessAddressDao.findByExample(query, limit); } catch
	 * (DaoException e) { logger.debug(
	 * "BusinessAddressServiceImpl findByExample()：按VO对象条件查询所有BusinessAddress-限制返回条数发生错误！"
	 * , e); e.printStackTrace(); } return list; }
	 */

	/**
	 * 根据搜索条件，搜索分页数据
	 * 
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage(final BusinessAddressQuery query)
			throws ServiceException {
		List<BusinessAddress> list = new ArrayList<BusinessAddress>();
		int count = 0;
		BaseBean baseBean = new BaseBean();
		try {
			list = businessAddressDao.findAllPage(query);
			count = businessAddressDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug(
					"BusinessAddressServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！",
					e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * 
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount(final BusinessAddressQuery query)
			throws ServiceException {
		int count = 0;
		try {
			count = businessAddressDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug(
					"BusinessAddressServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！",
					e);
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 保存BusinessAddress数据
	 * 
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessAddress entity) throws ServiceException {
		try {
			businessAddressDao.save(entity);
		} catch (DaoException e) {
			logger.debug(
					"BusinessAddressServiceImpl save()：保存BusinessAddress发生错误！",
					e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessAddress数据
	 * 
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessAddress entity) throws ServiceException {
		try {
			businessAddressDao.update(entity);
		} catch (DaoException e) {
			logger.debug(
					"BusinessAddressServiceImpl update()：修改BusinessAddress发生错误！",
					e);
			e.printStackTrace();
		}
	}

	/**
	 * 删除BusinessAddress
	 * 
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessAddressDao.delete(id);
		} catch (DaoException e) {
			logger.debug(
					"BusinessAddressServiceImpl delete()：删除BusinessAddress发生错误！",
					e);
			e.printStackTrace();
		}
		return false;
	}
}