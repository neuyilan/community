package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessActivityMessagelog;
import com.community.app.module.dao.BusinessActivityMessagelogDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityMessagelogQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessActivityMessagelogService")
@Transactional
public class BusinessActivityMessagelogServiceImpl implements BusinessActivityMessagelogService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessActivityMessagelogServiceImpl.class);
	@Autowired
	private BusinessActivityMessagelogDao businessActivityMessagelogDao;

	/**
	 * 查询单个BusinessActivityMessagelog
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessActivityMessagelog findById(final Integer id) throws ServiceException {
		BusinessActivityMessagelog businessActivityMessagelog = new BusinessActivityMessagelog();
		try {
			businessActivityMessagelog = businessActivityMessagelogDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessagelogServiceImpl findById()：查询单个BusinessActivityMessagelog发生错误！", e);
			e.printStackTrace();
		}
		return businessActivityMessagelog;
	}
	
	/**
	 * 无条件查询所有BusinessActivityMessagelog
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessActivityMessagelog> findAll() throws ServiceException {
		List<BusinessActivityMessagelog> list = new ArrayList<BusinessActivityMessagelog>() ;
		try {
			list=businessActivityMessagelogDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessagelogServiceImpl findAll()：无条件查询所有BusinessActivityMessagelog发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityMessagelog
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityMessagelog> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessActivityMessagelog> list = new ArrayList<BusinessActivityMessagelog>() ;
		try {
			list=businessActivityMessagelogDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessagelogServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityMessagelog发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityMessagelog-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityMessagelog> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessActivityMessagelog> list = new ArrayList<BusinessActivityMessagelog>() ;
		try {
			list=businessActivityMessagelogDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessagelogServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityMessagelog-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityMessagelog
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityMessagelog> findByExample(final BusinessActivityMessagelogQuery query) throws ServiceException {
		List<BusinessActivityMessagelog> list = new ArrayList<BusinessActivityMessagelog>() ;
		try {
			list=businessActivityMessagelogDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessagelogServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityMessagelog发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityMessagelog-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityMessagelog> findByExample(final BusinessActivityMessagelogQuery query, final Integer limit) throws ServiceException {
		List<BusinessActivityMessagelog> list = new ArrayList<BusinessActivityMessagelog>() ;
		try {
			list=businessActivityMessagelogDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessagelogServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityMessagelog-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessActivityMessagelogQuery query) throws ServiceException {
		List<BusinessActivityMessagelog> list = new ArrayList<BusinessActivityMessagelog>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessActivityMessagelogDao.findAllPage(query);
			count=businessActivityMessagelogDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessagelogServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessActivityMessagelogQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessActivityMessagelogDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessagelogServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessActivityMessagelog数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessActivityMessagelog entity) throws ServiceException {
		try {
			businessActivityMessagelogDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessagelogServiceImpl save()：保存BusinessActivityMessagelog发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessActivityMessagelog数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessActivityMessagelog entity) throws ServiceException {
		try {
			businessActivityMessagelogDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessagelogServiceImpl update()：修改BusinessActivityMessagelog发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessActivityMessagelog
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessActivityMessagelogDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessagelogServiceImpl delete()：删除BusinessActivityMessagelog发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
