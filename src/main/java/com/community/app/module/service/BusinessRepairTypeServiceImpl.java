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

import com.community.app.module.vo.BusinessRepairTypeQuery;
import com.community.app.module.bean.BusinessRepairType;
import com.community.app.module.dao.BusinessRepairTypeDao;

@Service("BusinessRepairTypeService")
@Transactional
public class BusinessRepairTypeServiceImpl implements BusinessRepairTypeService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessRepairTypeServiceImpl.class);
	@Autowired
	private BusinessRepairTypeDao businessRepairTypeDao;

	/**
	 * 查询单个BusinessRepairType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessRepairType findById(final Integer id) throws ServiceException {
		BusinessRepairType businessRepairType = new BusinessRepairType();
		try {
			businessRepairType = businessRepairTypeDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessRepairTypeServiceImpl findById()：查询单个BusinessRepairType发生错误！", e);
			e.printStackTrace();
		}
		return businessRepairType;
	}
	
	/**
	 * 无条件查询所有BusinessRepairType
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessRepairType> findAll() throws ServiceException {
		List<BusinessRepairType> list = new ArrayList<BusinessRepairType>() ;
		try {
			list=businessRepairTypeDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessRepairTypeServiceImpl findAll()：无条件查询所有BusinessRepairType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRepairType
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRepairType> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessRepairType> list = new ArrayList<BusinessRepairType>() ;
		try {
			list=businessRepairTypeDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessRepairTypeServiceImpl findByMap()：按Map对象条件查询所有BusinessRepairType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRepairType-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRepairType> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessRepairType> list = new ArrayList<BusinessRepairType>() ;
		try {
			list=businessRepairTypeDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRepairTypeServiceImpl findByMap()：按Map对象条件查询所有BusinessRepairType-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRepairType
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRepairType> findByExample(final BusinessRepairTypeQuery query) throws ServiceException {
		List<BusinessRepairType> list = new ArrayList<BusinessRepairType>() ;
		try {
			list=businessRepairTypeDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairTypeServiceImpl findByExample()：按VO对象条件查询所有BusinessRepairType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRepairType-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRepairType> findByExample(final BusinessRepairTypeQuery query, final Integer limit) throws ServiceException {
		List<BusinessRepairType> list = new ArrayList<BusinessRepairType>() ;
		try {
			list=businessRepairTypeDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRepairTypeServiceImpl findByExample()：按VO对象条件查询所有BusinessRepairType-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessRepairTypeQuery query) throws ServiceException {
		List<BusinessRepairType> list = new ArrayList<BusinessRepairType>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessRepairTypeDao.findAllPage(query);
			count=businessRepairTypeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairTypeServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessRepairTypeQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessRepairTypeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairTypeServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessRepairType数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessRepairType entity) throws ServiceException {
		try {
			businessRepairTypeDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRepairTypeServiceImpl save()：保存BusinessRepairType发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessRepairType数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessRepairType entity) throws ServiceException {
		try {
			businessRepairTypeDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRepairTypeServiceImpl update()：修改BusinessRepairType发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessRepairType
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessRepairTypeDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessRepairTypeServiceImpl delete()：删除BusinessRepairType发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
