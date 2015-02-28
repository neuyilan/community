package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessActivityScope;
import com.community.app.module.dao.BusinessActivityScopeDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityScopeQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessActivityScopeService")
@Transactional
public class BusinessActivityScopeServiceImpl implements BusinessActivityScopeService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessActivityScopeServiceImpl.class);
	@Autowired
	private BusinessActivityScopeDao businessActivityScopeDao;

	/**
	 * 查询单个BusinessActivityScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessActivityScope findById(final Integer id) throws ServiceException {
		BusinessActivityScope businessActivityScope = new BusinessActivityScope();
		try {
			businessActivityScope = businessActivityScopeDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityScopeServiceImpl findById()：查询单个BusinessActivityScope发生错误！", e);
			e.printStackTrace();
		}
		return businessActivityScope;
	}
	
	/**
	 * 无条件查询所有BusinessActivityScope
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessActivityScope> findAll() throws ServiceException {
		List<BusinessActivityScope> list = new ArrayList<BusinessActivityScope>() ;
		try {
			list=businessActivityScopeDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessActivityScopeServiceImpl findAll()：无条件查询所有BusinessActivityScope发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityScope
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityScope> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessActivityScope> list = new ArrayList<BusinessActivityScope>() ;
		try {
			list=businessActivityScopeDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessActivityScopeServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityScope发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityScope-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityScope> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessActivityScope> list = new ArrayList<BusinessActivityScope>() ;
		try {
			list=businessActivityScopeDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityScopeServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityScope-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityScope
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityScope> findByExample(final BusinessActivityScopeQuery query) throws ServiceException {
		List<BusinessActivityScope> list = new ArrayList<BusinessActivityScope>() ;
		try {
			list=businessActivityScopeDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityScopeServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityScope发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityScope-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityScope> findByExample(final BusinessActivityScopeQuery query, final Integer limit) throws ServiceException {
		List<BusinessActivityScope> list = new ArrayList<BusinessActivityScope>() ;
		try {
			list=businessActivityScopeDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityScopeServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityScope-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessActivityScopeQuery query) throws ServiceException {
		List<BusinessActivityScope> list = new ArrayList<BusinessActivityScope>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessActivityScopeDao.findAllPage(query);
			count=businessActivityScopeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityScopeServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessActivityScopeQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessActivityScopeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityScopeServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessActivityScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessActivityScope entity) throws ServiceException {
		try {
			businessActivityScopeDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityScopeServiceImpl save()：保存BusinessActivityScope发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessActivityScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessActivityScope entity) throws ServiceException {
		try {
			businessActivityScopeDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityScopeServiceImpl update()：修改BusinessActivityScope发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessActivityScope
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessActivityScopeDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityScopeServiceImpl delete()：删除BusinessActivityScope发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
