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

import com.community.app.module.vo.BusinessProductSupportQuery;
import com.community.app.module.bean.BusinessProductSupport;
import com.community.app.module.dao.BusinessProductSupportDao;

@Service("BusinessProductSupportService")
@Transactional
public class BusinessProductSupportServiceImpl implements BusinessProductSupportService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessProductSupportServiceImpl.class);
	@Autowired
	private BusinessProductSupportDao businessProductSupportDao;

	/**
	 * 查询单个BusinessProductSupport
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessProductSupport findById(final Integer id) throws ServiceException {
		BusinessProductSupport businessProductSupport = new BusinessProductSupport();
		try {
			businessProductSupport = businessProductSupportDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessProductSupportServiceImpl findById()：查询单个BusinessProductSupport发生错误！", e);
			e.printStackTrace();
		}
		return businessProductSupport;
	}
	
	/**
	 * 无条件查询所有BusinessProductSupport
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessProductSupport> findAll() throws ServiceException {
		List<BusinessProductSupport> list = new ArrayList<BusinessProductSupport>() ;
		try {
			list=businessProductSupportDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessProductSupportServiceImpl findAll()：无条件查询所有BusinessProductSupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProductSupport
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessProductSupport> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessProductSupport> list = new ArrayList<BusinessProductSupport>() ;
		try {
			list=businessProductSupportDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessProductSupportServiceImpl findByMap()：按Map对象条件查询所有BusinessProductSupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProductSupport-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessProductSupport> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessProductSupport> list = new ArrayList<BusinessProductSupport>() ;
		try {
			list=businessProductSupportDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessProductSupportServiceImpl findByMap()：按Map对象条件查询所有BusinessProductSupport-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessProductSupport
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessProductSupport> findByExample(final BusinessProductSupportQuery query) throws ServiceException {
		List<BusinessProductSupport> list = new ArrayList<BusinessProductSupport>() ;
		try {
			list=businessProductSupportDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessProductSupportServiceImpl findByExample()：按VO对象条件查询所有BusinessProductSupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessProductSupport-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessProductSupport> findByExample(final BusinessProductSupportQuery query, final Integer limit) throws ServiceException {
		List<BusinessProductSupport> list = new ArrayList<BusinessProductSupport>() ;
		try {
			list=businessProductSupportDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessProductSupportServiceImpl findByExample()：按VO对象条件查询所有BusinessProductSupport-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessProductSupportQuery query) throws ServiceException {
		List<BusinessProductSupport> list = new ArrayList<BusinessProductSupport>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessProductSupportDao.findAllPage(query);
			count=businessProductSupportDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessProductSupportServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessProductSupportQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessProductSupportDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessProductSupportServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessProductSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessProductSupport entity) throws ServiceException {
		try {
			businessProductSupportDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessProductSupportServiceImpl save()：保存BusinessProductSupport发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessProductSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessProductSupport entity) throws ServiceException {
		try {
			businessProductSupportDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessProductSupportServiceImpl update()：修改BusinessProductSupport发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessProductSupport
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessProductSupportDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessProductSupportServiceImpl delete()：删除BusinessProductSupport发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
