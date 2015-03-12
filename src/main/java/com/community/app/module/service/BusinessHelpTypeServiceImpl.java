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

import com.community.app.module.vo.BusinessHelpTypeQuery;
import com.community.app.module.bean.BusinessHelpType;
import com.community.app.module.dao.BusinessHelpTypeDao;

@Service("BusinessHelpTypeService")
@Transactional
public class BusinessHelpTypeServiceImpl implements BusinessHelpTypeService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessHelpTypeServiceImpl.class);
	@Autowired
	private BusinessHelpTypeDao businessHelpTypeDao;

	/**
	 * 查询单个BusinessHelpType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessHelpType findById(final Integer id) throws ServiceException {
		BusinessHelpType businessHelpType = new BusinessHelpType();
		try {
			businessHelpType = businessHelpTypeDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessHelpTypeServiceImpl findById()：查询单个BusinessHelpType发生错误！", e);
			e.printStackTrace();
		}
		return businessHelpType;
	}
	
	/**
	 * 无条件查询所有BusinessHelpType
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessHelpType> findAll() throws ServiceException {
		List<BusinessHelpType> list = new ArrayList<BusinessHelpType>() ;
		try {
			list=businessHelpTypeDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessHelpTypeServiceImpl findAll()：无条件查询所有BusinessHelpType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpType
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelpType> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessHelpType> list = new ArrayList<BusinessHelpType>() ;
		try {
			list=businessHelpTypeDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessHelpTypeServiceImpl findByMap()：按Map对象条件查询所有BusinessHelpType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpType-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessHelpType> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessHelpType> list = new ArrayList<BusinessHelpType>() ;
		try {
			list=businessHelpTypeDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHelpTypeServiceImpl findByMap()：按Map对象条件查询所有BusinessHelpType-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessHelpType
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelpType> findByExample(final BusinessHelpTypeQuery query) throws ServiceException {
		List<BusinessHelpType> list = new ArrayList<BusinessHelpType>() ;
		try {
			list=businessHelpTypeDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpTypeServiceImpl findByExample()：按VO对象条件查询所有BusinessHelpType发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelpType-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessHelpType> findByExample(final BusinessHelpTypeQuery query, final Integer limit) throws ServiceException {
		List<BusinessHelpType> list = new ArrayList<BusinessHelpType>() ;
		try {
			list=businessHelpTypeDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHelpTypeServiceImpl findByExample()：按VO对象条件查询所有BusinessHelpType-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessHelpTypeQuery query) throws ServiceException {
		List<BusinessHelpType> list = new ArrayList<BusinessHelpType>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessHelpTypeDao.findAllPage(query);
			count=businessHelpTypeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpTypeServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessHelpTypeQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessHelpTypeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpTypeServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessHelpType数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessHelpType entity) throws ServiceException {
		try {
			businessHelpTypeDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHelpTypeServiceImpl save()：保存BusinessHelpType发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessHelpType数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessHelpType entity) throws ServiceException {
		try {
			businessHelpTypeDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHelpTypeServiceImpl update()：修改BusinessHelpType发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessHelpType
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessHelpTypeDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessHelpTypeServiceImpl delete()：删除BusinessHelpType发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
