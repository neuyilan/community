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

import com.community.app.module.vo.BusinessPetTypeQuery;
import com.community.app.module.bean.BusinessPetType;
import com.community.app.module.dao.BusinessPetTypeDao;

@Service("BusinessPetTypeService")
@Transactional
public class BusinessPetTypeServiceImpl implements BusinessPetTypeService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessPetTypeServiceImpl.class);
	@Autowired
	private BusinessPetTypeDao businessPetTypeDao;

	/**
	 * 查询单个BusinessPetType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessPetType findById(final Integer id) throws ServiceException {
		BusinessPetType businessPetType = new BusinessPetType();
		try {
			businessPetType = businessPetTypeDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessPetTypeServiceImpl findById()：查询单个BusinessPetType发生错误！", e);
			e.printStackTrace();
		}
		return businessPetType;
	}
	
	/**
	 * 无条件查询所有BusinessPetType
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessPetType> findAll() throws ServiceException {
		List<BusinessPetType> list = new ArrayList<BusinessPetType>() ;
		try {
			list=businessPetTypeDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessPetTypeServiceImpl findAll()：无条件查询所有BusinessPetType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessPetType
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessPetType> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessPetType> list = new ArrayList<BusinessPetType>() ;
		try {
			list=businessPetTypeDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessPetTypeServiceImpl findByMap()：按Map对象条件查询所有BusinessPetType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessPetType-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessPetType> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessPetType> list = new ArrayList<BusinessPetType>() ;
		try {
			list=businessPetTypeDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessPetTypeServiceImpl findByMap()：按Map对象条件查询所有BusinessPetType-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessPetType
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessPetType> findByExample(final BusinessPetTypeQuery query) throws ServiceException {
		List<BusinessPetType> list = new ArrayList<BusinessPetType>() ;
		try {
			list=businessPetTypeDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessPetTypeServiceImpl findByExample()：按VO对象条件查询所有BusinessPetType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessPetType-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessPetType> findByExample(final BusinessPetTypeQuery query, final Integer limit) throws ServiceException {
		List<BusinessPetType> list = new ArrayList<BusinessPetType>() ;
		try {
			list=businessPetTypeDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessPetTypeServiceImpl findByExample()：按VO对象条件查询所有BusinessPetType-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessPetTypeQuery query) throws ServiceException {
		List<BusinessPetType> list = new ArrayList<BusinessPetType>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessPetTypeDao.findAllPage(query);
			count=businessPetTypeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessPetTypeServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessPetTypeQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessPetTypeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessPetTypeServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessPetType数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessPetType entity) throws ServiceException {
		try {
			businessPetTypeDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessPetTypeServiceImpl save()：保存BusinessPetType发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessPetType数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessPetType entity) throws ServiceException {
		try {
			businessPetTypeDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessPetTypeServiceImpl update()：修改BusinessPetType发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessPetType
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessPetTypeDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessPetTypeServiceImpl delete()：删除BusinessPetType发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
