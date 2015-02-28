package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessLifeType;
import com.community.app.module.dao.BusinessLifeTypeDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessLifeTypeQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessLifeTypeService")
@Transactional
public class BusinessLifeTypeServiceImpl implements BusinessLifeTypeService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessLifeTypeServiceImpl.class);
	@Autowired
	private BusinessLifeTypeDao businessLifeTypeDao;

	/**
	 * 查询单个BusinessLifeType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessLifeType findById(final Integer id) throws ServiceException {
		BusinessLifeType businessLifeType = new BusinessLifeType();
		try {
			businessLifeType = businessLifeTypeDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessLifeTypeServiceImpl findById()：查询单个BusinessLifeType发生错误！", e);
			e.printStackTrace();
		}
		return businessLifeType;
	}
	
	/**
	 * 无条件查询所有BusinessLifeType
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessLifeType> findAll() throws ServiceException {
		List<BusinessLifeType> list = new ArrayList<BusinessLifeType>() ;
		try {
			list=businessLifeTypeDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessLifeTypeServiceImpl findAll()：无条件查询所有BusinessLifeType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessLifeType
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessLifeType> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessLifeType> list = new ArrayList<BusinessLifeType>() ;
		try {
			list=businessLifeTypeDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessLifeTypeServiceImpl findByMap()：按Map对象条件查询所有BusinessLifeType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessLifeType-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessLifeType> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessLifeType> list = new ArrayList<BusinessLifeType>() ;
		try {
			list=businessLifeTypeDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessLifeTypeServiceImpl findByMap()：按Map对象条件查询所有BusinessLifeType-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessLifeType
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessLifeType> findByExample(final BusinessLifeTypeQuery query) throws ServiceException {
		List<BusinessLifeType> list = new ArrayList<BusinessLifeType>() ;
		try {
			list=businessLifeTypeDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessLifeTypeServiceImpl findByExample()：按VO对象条件查询所有BusinessLifeType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessLifeType-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessLifeType> findByExample(final BusinessLifeTypeQuery query, final Integer limit) throws ServiceException {
		List<BusinessLifeType> list = new ArrayList<BusinessLifeType>() ;
		try {
			list=businessLifeTypeDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessLifeTypeServiceImpl findByExample()：按VO对象条件查询所有BusinessLifeType-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessLifeTypeQuery query) throws ServiceException {
		List<BusinessLifeType> list = new ArrayList<BusinessLifeType>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessLifeTypeDao.findAllPage(query);
			count=businessLifeTypeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessLifeTypeServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessLifeTypeQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessLifeTypeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessLifeTypeServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessLifeType数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessLifeType entity) throws ServiceException {
		try {
			businessLifeTypeDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessLifeTypeServiceImpl save()：保存BusinessLifeType发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessLifeType数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessLifeType entity) throws ServiceException {
		try {
			businessLifeTypeDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessLifeTypeServiceImpl update()：修改BusinessLifeType发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessLifeType
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessLifeTypeDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessLifeTypeServiceImpl delete()：删除BusinessLifeType发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
