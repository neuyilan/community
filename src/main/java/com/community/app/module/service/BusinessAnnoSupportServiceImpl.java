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

import com.community.app.module.vo.BusinessAnnoSupportQuery;
import com.community.app.module.bean.BusinessAnnoSupport;
import com.community.app.module.dao.BusinessAnnoSupportDao;

@Service("BusinessAnnoSupportService")
@Transactional
public class BusinessAnnoSupportServiceImpl implements BusinessAnnoSupportService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessAnnoSupportServiceImpl.class);
	@Autowired
	private BusinessAnnoSupportDao businessAnnoSupportDao;

	/**
	 * 查询单个BusinessAnnoSupport
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessAnnoSupport findById(final Integer id) throws ServiceException {
		BusinessAnnoSupport businessAnnoSupport = new BusinessAnnoSupport();
		try {
			businessAnnoSupport = businessAnnoSupportDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoSupportServiceImpl findById()：查询单个BusinessAnnoSupport发生错误！", e);
			e.printStackTrace();
		}
		return businessAnnoSupport;
	}
	
	/**
	 * 无条件查询所有BusinessAnnoSupport
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessAnnoSupport> findAll() throws ServiceException {
		List<BusinessAnnoSupport> list = new ArrayList<BusinessAnnoSupport>() ;
		try {
			list=businessAnnoSupportDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessAnnoSupportServiceImpl findAll()：无条件查询所有BusinessAnnoSupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoSupport
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessAnnoSupport> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessAnnoSupport> list = new ArrayList<BusinessAnnoSupport>() ;
		try {
			list=businessAnnoSupportDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoSupportServiceImpl findByMap()：按Map对象条件查询所有BusinessAnnoSupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoSupport-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessAnnoSupport> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessAnnoSupport> list = new ArrayList<BusinessAnnoSupport>() ;
		try {
			list=businessAnnoSupportDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoSupportServiceImpl findByMap()：按Map对象条件查询所有BusinessAnnoSupport-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoSupport
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessAnnoSupport> findByExample(final BusinessAnnoSupportQuery query) throws ServiceException {
		List<BusinessAnnoSupport> list = new ArrayList<BusinessAnnoSupport>() ;
		try {
			list=businessAnnoSupportDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoSupportServiceImpl findByExample()：按VO对象条件查询所有BusinessAnnoSupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoSupport-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessAnnoSupport> findByExample(final BusinessAnnoSupportQuery query, final Integer limit) throws ServiceException {
		List<BusinessAnnoSupport> list = new ArrayList<BusinessAnnoSupport>() ;
		try {
			list=businessAnnoSupportDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoSupportServiceImpl findByExample()：按VO对象条件查询所有BusinessAnnoSupport-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessAnnoSupportQuery query) throws ServiceException {
		List<BusinessAnnoSupport> list = new ArrayList<BusinessAnnoSupport>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessAnnoSupportDao.findAllPage(query);
			count=businessAnnoSupportDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoSupportServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessAnnoSupportQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessAnnoSupportDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoSupportServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessAnnoSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessAnnoSupport entity) throws ServiceException {
		try {
			businessAnnoSupportDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoSupportServiceImpl save()：保存BusinessAnnoSupport发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessAnnoSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessAnnoSupport entity) throws ServiceException {
		try {
			businessAnnoSupportDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoSupportServiceImpl update()：修改BusinessAnnoSupport发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessAnnoSupport
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessAnnoSupportDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoSupportServiceImpl delete()：删除BusinessAnnoSupport发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
