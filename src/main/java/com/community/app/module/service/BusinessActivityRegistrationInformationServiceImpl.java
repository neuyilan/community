package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessActivityRegistrationInformation;
import com.community.app.module.dao.BusinessActivityRegistrationInformationDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityRegistrationInformationQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessActivityRegistrationInformationService")
@Transactional
public class BusinessActivityRegistrationInformationServiceImpl implements BusinessActivityRegistrationInformationService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessActivityRegistrationInformationServiceImpl.class);
	@Autowired
	private BusinessActivityRegistrationInformationDao businessActivityRegistrationInformationDao;

	/**
	 * 查询单个BusinessActivityRegistrationInformation
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessActivityRegistrationInformation findById(final Integer id) throws ServiceException {
		BusinessActivityRegistrationInformation businessActivityRegistrationInformation = new BusinessActivityRegistrationInformation();
		try {
			businessActivityRegistrationInformation = businessActivityRegistrationInformationDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationInformationServiceImpl findById()：查询单个BusinessActivityRegistrationInformation发生错误！", e);
			e.printStackTrace();
		}
		return businessActivityRegistrationInformation;
	}
	
	/**
	 * 无条件查询所有BusinessActivityRegistrationInformation
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessActivityRegistrationInformation> findAll() throws ServiceException {
		List<BusinessActivityRegistrationInformation> list = new ArrayList<BusinessActivityRegistrationInformation>() ;
		try {
			list=businessActivityRegistrationInformationDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationInformationServiceImpl findAll()：无条件查询所有BusinessActivityRegistrationInformation发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityRegistrationInformation
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityRegistrationInformation> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessActivityRegistrationInformation> list = new ArrayList<BusinessActivityRegistrationInformation>() ;
		try {
			list=businessActivityRegistrationInformationDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationInformationServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityRegistrationInformation发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityRegistrationInformation-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityRegistrationInformation> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessActivityRegistrationInformation> list = new ArrayList<BusinessActivityRegistrationInformation>() ;
		try {
			list=businessActivityRegistrationInformationDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationInformationServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityRegistrationInformation-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityRegistrationInformation
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityRegistrationInformation> findByExample(final BusinessActivityRegistrationInformationQuery query) throws ServiceException {
		List<BusinessActivityRegistrationInformation> list = new ArrayList<BusinessActivityRegistrationInformation>() ;
		try {
			list=businessActivityRegistrationInformationDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationInformationServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityRegistrationInformation发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityRegistrationInformation-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityRegistrationInformation> findByExample(final BusinessActivityRegistrationInformationQuery query, final Integer limit) throws ServiceException {
		List<BusinessActivityRegistrationInformation> list = new ArrayList<BusinessActivityRegistrationInformation>() ;
		try {
			list=businessActivityRegistrationInformationDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationInformationServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityRegistrationInformation-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessActivityRegistrationInformationQuery query) throws ServiceException {
		List<BusinessActivityRegistrationInformation> list = new ArrayList<BusinessActivityRegistrationInformation>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessActivityRegistrationInformationDao.selectCount(query);
			query.setCount(count);
			list=businessActivityRegistrationInformationDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationInformationServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setRows(query.getRows());
		baseBean.setPage(query.getPage());
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount(final BusinessActivityRegistrationInformationQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessActivityRegistrationInformationDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationInformationServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessActivityRegistrationInformation数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessActivityRegistrationInformation entity) throws ServiceException {
		try {
			businessActivityRegistrationInformationDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationInformationServiceImpl save()：保存BusinessActivityRegistrationInformation发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessActivityRegistrationInformation数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessActivityRegistrationInformation entity) throws ServiceException {
		try {
			businessActivityRegistrationInformationDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationInformationServiceImpl update()：修改BusinessActivityRegistrationInformation发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessActivityRegistrationInformation
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessActivityRegistrationInformationDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationInformationServiceImpl delete()：删除BusinessActivityRegistrationInformation发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
