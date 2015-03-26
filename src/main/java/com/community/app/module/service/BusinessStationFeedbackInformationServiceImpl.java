package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessStationFeedbackInformation;
import com.community.app.module.dao.BusinessStationFeedbackInformationDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessStationFeedbackInformationQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessStationFeedbackInformationService")
@Transactional
public class BusinessStationFeedbackInformationServiceImpl implements BusinessStationFeedbackInformationService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessStationFeedbackInformationServiceImpl.class);
	@Autowired
	private BusinessStationFeedbackInformationDao businessStationFeedbackInformationDao;

	/**
	 * 查询单个BusinessStationFeedbackInformation
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessStationFeedbackInformation findById(final Integer id) throws ServiceException {
		BusinessStationFeedbackInformation businessStationFeedbackInformation = new BusinessStationFeedbackInformation();
		try {
			businessStationFeedbackInformation = businessStationFeedbackInformationDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackInformationServiceImpl findById()：查询单个BusinessStationFeedbackInformation发生错误！", e);
			e.printStackTrace();
		}
		return businessStationFeedbackInformation;
	}
	
	/**
	 * 无条件查询所有BusinessStationFeedbackInformation
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessStationFeedbackInformation> findAll() throws ServiceException {
		List<BusinessStationFeedbackInformation> list = new ArrayList<BusinessStationFeedbackInformation>() ;
		try {
			list=businessStationFeedbackInformationDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackInformationServiceImpl findAll()：无条件查询所有BusinessStationFeedbackInformation发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessStationFeedbackInformation
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessStationFeedbackInformation> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessStationFeedbackInformation> list = new ArrayList<BusinessStationFeedbackInformation>() ;
		try {
			list=businessStationFeedbackInformationDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackInformationServiceImpl findByMap()：按Map对象条件查询所有BusinessStationFeedbackInformation发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessStationFeedbackInformation-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessStationFeedbackInformation> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessStationFeedbackInformation> list = new ArrayList<BusinessStationFeedbackInformation>() ;
		try {
			list=businessStationFeedbackInformationDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackInformationServiceImpl findByMap()：按Map对象条件查询所有BusinessStationFeedbackInformation-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessStationFeedbackInformation
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessStationFeedbackInformation> findByExample(final BusinessStationFeedbackInformationQuery query) throws ServiceException {
		List<BusinessStationFeedbackInformation> list = new ArrayList<BusinessStationFeedbackInformation>() ;
		try {
			list=businessStationFeedbackInformationDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackInformationServiceImpl findByExample()：按VO对象条件查询所有BusinessStationFeedbackInformation发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessStationFeedbackInformation-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessStationFeedbackInformation> findByExample(final BusinessStationFeedbackInformationQuery query, final Integer limit) throws ServiceException {
		List<BusinessStationFeedbackInformation> list = new ArrayList<BusinessStationFeedbackInformation>() ;
		try {
			list=businessStationFeedbackInformationDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackInformationServiceImpl findByExample()：按VO对象条件查询所有BusinessStationFeedbackInformation-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessStationFeedbackInformationQuery query) throws ServiceException {
		List<BusinessStationFeedbackInformation> list = new ArrayList<BusinessStationFeedbackInformation>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessStationFeedbackInformationDao.findAllPage(query);
			count=businessStationFeedbackInformationDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackInformationServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessStationFeedbackInformationQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessStationFeedbackInformationDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackInformationServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessStationFeedbackInformation数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessStationFeedbackInformation entity) throws ServiceException {
		try {
			businessStationFeedbackInformationDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackInformationServiceImpl save()：保存BusinessStationFeedbackInformation发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessStationFeedbackInformation数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessStationFeedbackInformation entity) throws ServiceException {
		try {
			businessStationFeedbackInformationDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackInformationServiceImpl update()：修改BusinessStationFeedbackInformation发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessStationFeedbackInformation
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessStationFeedbackInformationDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackInformationServiceImpl delete()：删除BusinessStationFeedbackInformation发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
}