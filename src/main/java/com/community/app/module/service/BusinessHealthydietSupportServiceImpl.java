package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessHealthydietSupport;
import com.community.app.module.dao.BusinessHealthydietSupportDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHealthydietSupportQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessHealthydietSupportService")
@Transactional
public class BusinessHealthydietSupportServiceImpl implements BusinessHealthydietSupportService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessHealthydietSupportServiceImpl.class);
	@Autowired
	private BusinessHealthydietSupportDao businessHealthydietSupportDao;

	/**
	 * 查询单个BusinessHealthydietSupport
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessHealthydietSupport findById(final Integer id) throws ServiceException {
		BusinessHealthydietSupport businessHealthydietSupport = new BusinessHealthydietSupport();
		try {
			businessHealthydietSupport = businessHealthydietSupportDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietSupportServiceImpl findById()：查询单个BusinessHealthydietSupport发生错误！", e);
			e.printStackTrace();
		}
		return businessHealthydietSupport;
	}
	
	/**
	 * 无条件查询所有BusinessHealthydietSupport
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessHealthydietSupport> findAll() throws ServiceException {
		List<BusinessHealthydietSupport> list = new ArrayList<BusinessHealthydietSupport>() ;
		try {
			list=businessHealthydietSupportDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietSupportServiceImpl findAll()：无条件查询所有BusinessHealthydietSupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHealthydietSupport
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHealthydietSupport> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessHealthydietSupport> list = new ArrayList<BusinessHealthydietSupport>() ;
		try {
			list=businessHealthydietSupportDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietSupportServiceImpl findByMap()：按Map对象条件查询所有BusinessHealthydietSupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHealthydietSupport-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessHealthydietSupport> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessHealthydietSupport> list = new ArrayList<BusinessHealthydietSupport>() ;
		try {
			list=businessHealthydietSupportDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietSupportServiceImpl findByMap()：按Map对象条件查询所有BusinessHealthydietSupport-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessHealthydietSupport
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHealthydietSupport> findByExample(final BusinessHealthydietSupportQuery query) throws ServiceException {
		List<BusinessHealthydietSupport> list = new ArrayList<BusinessHealthydietSupport>() ;
		try {
			list=businessHealthydietSupportDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietSupportServiceImpl findByExample()：按VO对象条件查询所有BusinessHealthydietSupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHealthydietSupport-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessHealthydietSupport> findByExample(final BusinessHealthydietSupportQuery query, final Integer limit) throws ServiceException {
		List<BusinessHealthydietSupport> list = new ArrayList<BusinessHealthydietSupport>() ;
		try {
			list=businessHealthydietSupportDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietSupportServiceImpl findByExample()：按VO对象条件查询所有BusinessHealthydietSupport-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessHealthydietSupportQuery query) throws ServiceException {
		List<BusinessHealthydietSupport> list = new ArrayList<BusinessHealthydietSupport>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessHealthydietSupportDao.findAllPage(query);
			count=businessHealthydietSupportDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietSupportServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessHealthydietSupportQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessHealthydietSupportDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietSupportServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessHealthydietSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessHealthydietSupport entity) throws ServiceException {
		try {
			businessHealthydietSupportDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietSupportServiceImpl save()：保存BusinessHealthydietSupport发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessHealthydietSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessHealthydietSupport entity) throws ServiceException {
		try {
			businessHealthydietSupportDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietSupportServiceImpl update()：修改BusinessHealthydietSupport发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessHealthydietSupport
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessHealthydietSupportDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietSupportServiceImpl delete()：删除BusinessHealthydietSupport发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
