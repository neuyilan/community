package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessActivityVoteInformation;
import com.community.app.module.dao.BusinessActivityVoteInformationDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityVoteInformationQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessActivityVoteInformationService")
@Transactional
public class BusinessActivityVoteInformationServiceImpl implements BusinessActivityVoteInformationService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessActivityVoteInformationServiceImpl.class);
	@Autowired
	private BusinessActivityVoteInformationDao businessActivityVoteInformationDao;

	/**
	 * 查询单个BusinessActivityVoteInformation
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessActivityVoteInformation findById(final Integer id) throws ServiceException {
		BusinessActivityVoteInformation businessActivityVoteInformation = new BusinessActivityVoteInformation();
		try {
			businessActivityVoteInformation = businessActivityVoteInformationDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteInformationServiceImpl findById()：查询单个BusinessActivityVoteInformation发生错误！", e);
			e.printStackTrace();
		}
		return businessActivityVoteInformation;
	}
	
	/**
	 * 无条件查询所有BusinessActivityVoteInformation
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessActivityVoteInformation> findAll() throws ServiceException {
		List<BusinessActivityVoteInformation> list = new ArrayList<BusinessActivityVoteInformation>() ;
		try {
			list=businessActivityVoteInformationDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteInformationServiceImpl findAll()：无条件查询所有BusinessActivityVoteInformation发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityVoteInformation
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityVoteInformation> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessActivityVoteInformation> list = new ArrayList<BusinessActivityVoteInformation>() ;
		try {
			list=businessActivityVoteInformationDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteInformationServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityVoteInformation发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityVoteInformation-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityVoteInformation> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessActivityVoteInformation> list = new ArrayList<BusinessActivityVoteInformation>() ;
		try {
			list=businessActivityVoteInformationDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteInformationServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityVoteInformation-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityVoteInformation
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityVoteInformation> findByExample(final BusinessActivityVoteInformationQuery query) throws ServiceException {
		List<BusinessActivityVoteInformation> list = new ArrayList<BusinessActivityVoteInformation>() ;
		try {
			list=businessActivityVoteInformationDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteInformationServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityVoteInformation发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityVoteInformation-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityVoteInformation> findByExample(final BusinessActivityVoteInformationQuery query, final Integer limit) throws ServiceException {
		List<BusinessActivityVoteInformation> list = new ArrayList<BusinessActivityVoteInformation>() ;
		try {
			list=businessActivityVoteInformationDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteInformationServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityVoteInformation-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessActivityVoteInformationQuery query) throws ServiceException {
		List<BusinessActivityVoteInformation> list = new ArrayList<BusinessActivityVoteInformation>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessActivityVoteInformationDao.selectCount(query);
			query.setCount(count);
			list=businessActivityVoteInformationDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteInformationServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessActivityVoteInformationQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessActivityVoteInformationDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteInformationServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount_userId(final BusinessActivityVoteInformationQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessActivityVoteInformationDao.selectCount_userId(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteInformationServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessActivityVoteInformation数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessActivityVoteInformation entity) throws ServiceException {
		try {
			businessActivityVoteInformationDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteInformationServiceImpl save()：保存BusinessActivityVoteInformation发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessActivityVoteInformation数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessActivityVoteInformation entity) throws ServiceException {
		try {
			businessActivityVoteInformationDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteInformationServiceImpl update()：修改BusinessActivityVoteInformation发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessActivityVoteInformation
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessActivityVoteInformationDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteInformationServiceImpl delete()：删除BusinessActivityVoteInformation发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
