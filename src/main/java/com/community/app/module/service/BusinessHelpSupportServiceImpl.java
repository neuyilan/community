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

import com.community.app.module.vo.BusinessHelpSupportQuery;
import com.community.app.module.bean.BusinessHelpSupport;
import com.community.app.module.dao.BusinessHelpSupportDao;

@Service("BusinessHelpSupportService")
@Transactional
public class BusinessHelpSupportServiceImpl implements BusinessHelpSupportService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessHelpSupportServiceImpl.class);
	@Autowired
	private BusinessHelpSupportDao businessHelpSupportDao;

	/**
	 * 查询单个BusinessHelpSupport
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessHelpSupport findById(final Integer id) throws ServiceException {
		BusinessHelpSupport businessHelpSupport = new BusinessHelpSupport();
		try {
			businessHelpSupport = businessHelpSupportDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessHelpSupportServiceImpl findById()：查询单个BusinessHelpSupport发生错误！", e);
			e.printStackTrace();
		}
		return businessHelpSupport;
	}
	
	/**
	 * 无条件查询所有BusinessHelpSupport
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessHelpSupport> findAll() throws ServiceException {
		List<BusinessHelpSupport> list = new ArrayList<BusinessHelpSupport>() ;
		try {
			list=businessHelpSupportDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessHelpSupportServiceImpl findAll()：无条件查询所有BusinessHelpSupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpSupport
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelpSupport> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessHelpSupport> list = new ArrayList<BusinessHelpSupport>() ;
		try {
			list=businessHelpSupportDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessHelpSupportServiceImpl findByMap()：按Map对象条件查询所有BusinessHelpSupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpSupport-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelpSupport> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessHelpSupport> list = new ArrayList<BusinessHelpSupport>() ;
		try {
			list=businessHelpSupportDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHelpSupportServiceImpl findByMap()：按Map对象条件查询所有BusinessHelpSupport-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelpSupport
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelpSupport> findByExample(final BusinessHelpSupportQuery query) throws ServiceException {
		List<BusinessHelpSupport> list = new ArrayList<BusinessHelpSupport>() ;
		try {
			list=businessHelpSupportDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpSupportServiceImpl findByExample()：按VO对象条件查询所有BusinessHelpSupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelpSupport-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelpSupport> findByExample(final BusinessHelpSupportQuery query, final Integer limit) throws ServiceException {
		List<BusinessHelpSupport> list = new ArrayList<BusinessHelpSupport>() ;
		try {
			list=businessHelpSupportDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHelpSupportServiceImpl findByExample()：按VO对象条件查询所有BusinessHelpSupport-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessHelpSupportQuery query) throws ServiceException {
		List<BusinessHelpSupport> list = new ArrayList<BusinessHelpSupport>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessHelpSupportDao.findAllPage(query);
			count=businessHelpSupportDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpSupportServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessHelpSupportQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessHelpSupportDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpSupportServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessHelpSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessHelpSupport entity) throws ServiceException {
		try {
			businessHelpSupportDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHelpSupportServiceImpl save()：保存BusinessHelpSupport发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessHelpSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessHelpSupport entity) throws ServiceException {
		try {
			businessHelpSupportDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHelpSupportServiceImpl update()：修改BusinessHelpSupport发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessHelpSupport
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessHelpSupportDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessHelpSupportServiceImpl delete()：删除BusinessHelpSupport发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
