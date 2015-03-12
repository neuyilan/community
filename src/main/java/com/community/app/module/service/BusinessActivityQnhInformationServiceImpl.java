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

import com.community.app.module.vo.BusinessActivityQnhInformationQuery;
import com.community.app.module.bean.BusinessActivityQnhInformation;
import com.community.app.module.dao.BusinessActivityQnhInformationDao;

@Service("BusinessActivityQnhInformationService")
@Transactional
public class BusinessActivityQnhInformationServiceImpl implements BusinessActivityQnhInformationService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessActivityQnhInformationServiceImpl.class);
	@Autowired
	private BusinessActivityQnhInformationDao businessActivityQnhInformationDao;

	/**
	 * 查询单个BusinessActivityQnhInformation
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessActivityQnhInformation findById(final Integer id) throws ServiceException {
		BusinessActivityQnhInformation businessActivityQnhInformation = new BusinessActivityQnhInformation();
		try {
			businessActivityQnhInformation = businessActivityQnhInformationDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityQnhInformationServiceImpl findById()：查询单个BusinessActivityQnhInformation发生错误！", e);
			e.printStackTrace();
		}
		return businessActivityQnhInformation;
	}
	
	/**
	 * 无条件查询所有BusinessActivityQnhInformation
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessActivityQnhInformation> findAll() throws ServiceException {
		List<BusinessActivityQnhInformation> list = new ArrayList<BusinessActivityQnhInformation>() ;
		try {
			list=businessActivityQnhInformationDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessActivityQnhInformationServiceImpl findAll()：无条件查询所有BusinessActivityQnhInformation发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityQnhInformation
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityQnhInformation> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessActivityQnhInformation> list = new ArrayList<BusinessActivityQnhInformation>() ;
		try {
			list=businessActivityQnhInformationDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessActivityQnhInformationServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityQnhInformation发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityQnhInformation-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityQnhInformation> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessActivityQnhInformation> list = new ArrayList<BusinessActivityQnhInformation>() ;
		try {
			list=businessActivityQnhInformationDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityQnhInformationServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityQnhInformation-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityQnhInformation
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityQnhInformation> findByExample(final BusinessActivityQnhInformationQuery query) throws ServiceException {
		List<BusinessActivityQnhInformation> list = new ArrayList<BusinessActivityQnhInformation>() ;
		try {
			list=businessActivityQnhInformationDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityQnhInformationServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityQnhInformation发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityQnhInformation-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityQnhInformation> findByExample(final BusinessActivityQnhInformationQuery query, final Integer limit) throws ServiceException {
		List<BusinessActivityQnhInformation> list = new ArrayList<BusinessActivityQnhInformation>() ;
		try {
			list=businessActivityQnhInformationDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityQnhInformationServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityQnhInformation-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessActivityQnhInformationQuery query) throws ServiceException {
		List<BusinessActivityQnhInformation> list = new ArrayList<BusinessActivityQnhInformation>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessActivityQnhInformationDao.findAllPage(query);
			count=businessActivityQnhInformationDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityQnhInformationServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessActivityQnhInformationQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessActivityQnhInformationDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityQnhInformationServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessActivityQnhInformation数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessActivityQnhInformation entity) throws ServiceException {
		try {
			businessActivityQnhInformationDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityQnhInformationServiceImpl save()：保存BusinessActivityQnhInformation发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessActivityQnhInformation数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessActivityQnhInformation entity) throws ServiceException {
		try {
			businessActivityQnhInformationDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityQnhInformationServiceImpl update()：修改BusinessActivityQnhInformation发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessActivityQnhInformation
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessActivityQnhInformationDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityQnhInformationServiceImpl delete()：删除BusinessActivityQnhInformation发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
