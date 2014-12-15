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

import com.community.app.module.vo.BusinessActivitySupportQuery;
import com.community.app.module.bean.BusinessActivitySupport;
import com.community.app.module.dao.BusinessActivitySupportDao;

@Service("BusinessActivitySupportService")
@Transactional
public class BusinessActivitySupportServiceImpl implements BusinessActivitySupportService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessActivitySupportServiceImpl.class);
	@Autowired
	private BusinessActivitySupportDao businessActivitySupportDao;

	/**
	 * 查询单个BusinessActivitySupport
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessActivitySupport findById(final Integer id) throws ServiceException {
		BusinessActivitySupport businessActivitySupport = new BusinessActivitySupport();
		try {
			businessActivitySupport = businessActivitySupportDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivitySupportServiceImpl findById()：查询单个BusinessActivitySupport发生错误！", e);
			e.printStackTrace();
		}
		return businessActivitySupport;
	}
	
	/**
	 * 无条件查询所有BusinessActivitySupport
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessActivitySupport> findAll() throws ServiceException {
		List<BusinessActivitySupport> list = new ArrayList<BusinessActivitySupport>() ;
		try {
			list=businessActivitySupportDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessActivitySupportServiceImpl findAll()：无条件查询所有BusinessActivitySupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivitySupport
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivitySupport> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessActivitySupport> list = new ArrayList<BusinessActivitySupport>() ;
		try {
			list=businessActivitySupportDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessActivitySupportServiceImpl findByMap()：按Map对象条件查询所有BusinessActivitySupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivitySupport-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivitySupport> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessActivitySupport> list = new ArrayList<BusinessActivitySupport>() ;
		try {
			list=businessActivitySupportDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivitySupportServiceImpl findByMap()：按Map对象条件查询所有BusinessActivitySupport-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivitySupport
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivitySupport> findByExample(final BusinessActivitySupportQuery query) throws ServiceException {
		List<BusinessActivitySupport> list = new ArrayList<BusinessActivitySupport>() ;
		try {
			list=businessActivitySupportDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivitySupportServiceImpl findByExample()：按VO对象条件查询所有BusinessActivitySupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivitySupport-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivitySupport> findByExample(final BusinessActivitySupportQuery query, final Integer limit) throws ServiceException {
		List<BusinessActivitySupport> list = new ArrayList<BusinessActivitySupport>() ;
		try {
			list=businessActivitySupportDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivitySupportServiceImpl findByExample()：按VO对象条件查询所有BusinessActivitySupport-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessActivitySupportQuery query) throws ServiceException {
		List<BusinessActivitySupport> list = new ArrayList<BusinessActivitySupport>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessActivitySupportDao.findAllPage(query);
			count=businessActivitySupportDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivitySupportServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessActivitySupportQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessActivitySupportDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivitySupportServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessActivitySupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessActivitySupport entity) throws ServiceException {
		try {
			businessActivitySupportDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivitySupportServiceImpl save()：保存BusinessActivitySupport发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessActivitySupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessActivitySupport entity) throws ServiceException {
		try {
			businessActivitySupportDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivitySupportServiceImpl update()：修改BusinessActivitySupport发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessActivitySupport
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessActivitySupportDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivitySupportServiceImpl delete()：删除BusinessActivitySupport发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
