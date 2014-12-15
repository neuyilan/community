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

import com.community.app.module.vo.BusinessActivityTypeQuery;
import com.community.app.module.bean.BusinessActivityType;
import com.community.app.module.dao.BusinessActivityTypeDao;

@Service("BusinessActivityTypeService")
@Transactional
public class BusinessActivityTypeServiceImpl implements BusinessActivityTypeService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessActivityTypeServiceImpl.class);
	@Autowired
	private BusinessActivityTypeDao businessActivityTypeDao;

	/**
	 * 查询单个BusinessActivityType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessActivityType findById(final Integer id) throws ServiceException {
		BusinessActivityType businessActivityType = new BusinessActivityType();
		try {
			businessActivityType = businessActivityTypeDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityTypeServiceImpl findById()：查询单个BusinessActivityType发生错误！", e);
			e.printStackTrace();
		}
		return businessActivityType;
	}
	
	/**
	 * 无条件查询所有BusinessActivityType
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessActivityType> findAll() throws ServiceException {
		List<BusinessActivityType> list = new ArrayList<BusinessActivityType>() ;
		try {
			list=businessActivityTypeDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessActivityTypeServiceImpl findAll()：无条件查询所有BusinessActivityType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityType
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityType> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessActivityType> list = new ArrayList<BusinessActivityType>() ;
		try {
			list=businessActivityTypeDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessActivityTypeServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityType-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityType> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessActivityType> list = new ArrayList<BusinessActivityType>() ;
		try {
			list=businessActivityTypeDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityTypeServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityType-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityType
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityType> findByExample(final BusinessActivityTypeQuery query) throws ServiceException {
		List<BusinessActivityType> list = new ArrayList<BusinessActivityType>() ;
		try {
			list=businessActivityTypeDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityTypeServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityType-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityType> findByExample(final BusinessActivityTypeQuery query, final Integer limit) throws ServiceException {
		List<BusinessActivityType> list = new ArrayList<BusinessActivityType>() ;
		try {
			list=businessActivityTypeDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityTypeServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityType-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessActivityTypeQuery query) throws ServiceException {
		List<BusinessActivityType> list = new ArrayList<BusinessActivityType>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessActivityTypeDao.findAllPage(query);
			count=businessActivityTypeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityTypeServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessActivityTypeQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessActivityTypeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityTypeServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessActivityType数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessActivityType entity) throws ServiceException {
		try {
			businessActivityTypeDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityTypeServiceImpl save()：保存BusinessActivityType发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessActivityType数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessActivityType entity) throws ServiceException {
		try {
			businessActivityTypeDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityTypeServiceImpl update()：修改BusinessActivityType发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessActivityType
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessActivityTypeDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityTypeServiceImpl delete()：删除BusinessActivityType发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
