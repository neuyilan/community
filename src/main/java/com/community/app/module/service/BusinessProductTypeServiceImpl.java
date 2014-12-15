package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessProductType;
import com.community.app.module.dao.BusinessProductTypeDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessProductTypeQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessProductTypeService")
@Transactional
public class BusinessProductTypeServiceImpl implements
		BusinessProductTypeService {

	private static Logger logger = LoggerFactory
			.getLogger(BusinessProductTypeServiceImpl.class);
	@Autowired
	private BusinessProductTypeDao businessProductTypeDao;

	/**
	 * 查询单个BusinessProductType
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessProductType findById(final Integer id)
			throws ServiceException {
		BusinessProductType businessProductType = new BusinessProductType();
		try {
			businessProductType = businessProductTypeDao.findById(id);
		} catch (DaoException e) {
			logger.debug(
					"BusinessProductTypeServiceImpl findById()：查询单个BusinessProductType发生错误！",
					e);
			e.printStackTrace();
		}
		return businessProductType;
	}

	/**
	 * 无条件查询所有BusinessProductType
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessProductType> findAll() throws ServiceException {
		List<BusinessProductType> list = new ArrayList<BusinessProductType>();
		try {
			list = businessProductTypeDao.findAll();
		} catch (DaoException e) {
			logger.debug(
					"BusinessProductTypeServiceImpl findAll()：无条件查询所有BusinessProductType发生错误！",
					e);
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessProductType
	 * 
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessProductType> findByMap(final Map paramMap)
			throws ServiceException {
		List<BusinessProductType> list = new ArrayList<BusinessProductType>();
		try {
			list = businessProductTypeDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug(
					"BusinessProductTypeServiceImpl findByMap()：按Map对象条件查询所有BusinessProductType发生错误！",
					e);
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessProductType-限制返回条数
	 * 
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */
	/*
	 * @Transactional(readOnly = true) public List<BusinessProductType>
	 * findByMap(final Map paramMap, final Integer limit) throws
	 * ServiceException { List<BusinessProductType> list = new
	 * ArrayList<BusinessProductType>() ; try {
	 * list=businessProductTypeDao.findByMap(paramMap, limit); } catch
	 * (DaoException e) { logger.debug(
	 * "BusinessProductTypeServiceImpl findByMap()：按Map对象条件查询所有BusinessProductType-限制返回条数发生错误！"
	 * , e); e.printStackTrace(); } return list; }
	 */

	/**
	 * 按VO对象条件查询所有BusinessProductType
	 * 
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessProductType> findByExample(
			final BusinessProductTypeQuery query) throws ServiceException {
		List<BusinessProductType> list = new ArrayList<BusinessProductType>();
		try {
			list = businessProductTypeDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug(
					"BusinessProductTypeServiceImpl findByExample()：按VO对象条件查询所有BusinessProductType发生错误！",
					e);
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 按VO对象条件查询所有BusinessProductType-限制返回条数
	 * 
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	/*
	 * @Transactional(readOnly = true) public List<BusinessProductType>
	 * findByExample(final BusinessProductTypeQuery query, final Integer limit)
	 * throws ServiceException { List<BusinessProductType> list = new
	 * ArrayList<BusinessProductType>() ; try {
	 * list=businessProductTypeDao.findByExample(query, limit); } catch
	 * (DaoException e) { logger.debug(
	 * "BusinessProductTypeServiceImpl findByExample()：按VO对象条件查询所有BusinessProductType-限制返回条数发生错误！"
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
	public BaseBean findAllPage(final BusinessProductTypeQuery query)
			throws ServiceException {
		List<BusinessProductType> list = new ArrayList<BusinessProductType>();
		int count = 0;
		BaseBean baseBean = new BaseBean();
		try {
			list = businessProductTypeDao.findAllPage(query);
			count = businessProductTypeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug(
					"BusinessProductTypeServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！",
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
	public int selectCount(final BusinessProductTypeQuery query)
			throws ServiceException {
		int count = 0;
		try {
			count = businessProductTypeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug(
					"BusinessProductTypeServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！",
					e);
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 保存BusinessProductType数据
	 * 
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessProductType entity) throws ServiceException {
		try {
			businessProductTypeDao.save(entity);
		} catch (DaoException e) {
			logger.debug(
					"BusinessProductTypeServiceImpl save()：保存BusinessProductType发生错误！",
					e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessProductType数据
	 * 
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessProductType entity) throws ServiceException {
		try {
			businessProductTypeDao.update(entity);
		} catch (DaoException e) {
			logger.debug(
					"BusinessProductTypeServiceImpl update()：修改BusinessProductType发生错误！",
					e);
			e.printStackTrace();
		}
	}

	/**
	 * 删除BusinessProductType
	 * 
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessProductTypeDao.delete(id);
		} catch (DaoException e) {
			logger.debug(
					"BusinessProductTypeServiceImpl delete()：删除BusinessProductType发生错误！",
					e);
			e.printStackTrace();
		}
		return false;
	}
}