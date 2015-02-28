package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessAnnoScope;
import com.community.app.module.dao.BusinessAnnoScopeDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessAnnoScopeQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessAnnoScopeService")
@Transactional
public class BusinessAnnoScopeServiceImpl implements BusinessAnnoScopeService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessAnnoScopeServiceImpl.class);
	@Autowired
	private BusinessAnnoScopeDao businessAnnoScopeDao;

	/**
	 * 查询单个BusinessAnnoScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessAnnoScope findById(final Integer id) throws ServiceException {
		BusinessAnnoScope businessAnnoScope = new BusinessAnnoScope();
		try {
			businessAnnoScope = businessAnnoScopeDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoScopeServiceImpl findById()：查询单个BusinessAnnoScope发生错误！", e);
			e.printStackTrace();
		}
		return businessAnnoScope;
	}
	
	/**
	 * 无条件查询所有BusinessAnnoScope
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessAnnoScope> findAll() throws ServiceException {
		List<BusinessAnnoScope> list = new ArrayList<BusinessAnnoScope>() ;
		try {
			list=businessAnnoScopeDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessAnnoScopeServiceImpl findAll()：无条件查询所有BusinessAnnoScope发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoScope
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessAnnoScope> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessAnnoScope> list = new ArrayList<BusinessAnnoScope>() ;
		try {
			list=businessAnnoScopeDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoScopeServiceImpl findByMap()：按Map对象条件查询所有BusinessAnnoScope发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoScope-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessAnnoScope> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessAnnoScope> list = new ArrayList<BusinessAnnoScope>() ;
		try {
			list=businessAnnoScopeDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoScopeServiceImpl findByMap()：按Map对象条件查询所有BusinessAnnoScope-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoScope
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessAnnoScope> findByExample(final BusinessAnnoScopeQuery query) throws ServiceException {
		List<BusinessAnnoScope> list = new ArrayList<BusinessAnnoScope>() ;
		try {
			list=businessAnnoScopeDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoScopeServiceImpl findByExample()：按VO对象条件查询所有BusinessAnnoScope发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoScope-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessAnnoScope> findByExample(final BusinessAnnoScopeQuery query, final Integer limit) throws ServiceException {
		List<BusinessAnnoScope> list = new ArrayList<BusinessAnnoScope>() ;
		try {
			list=businessAnnoScopeDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoScopeServiceImpl findByExample()：按VO对象条件查询所有BusinessAnnoScope-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessAnnoScopeQuery query) throws ServiceException {
		List<BusinessAnnoScope> list = new ArrayList<BusinessAnnoScope>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessAnnoScopeDao.findAllPage(query);
			count=businessAnnoScopeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoScopeServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessAnnoScopeQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessAnnoScopeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoScopeServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessAnnoScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessAnnoScope entity) throws ServiceException {
		try {
			businessAnnoScopeDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoScopeServiceImpl save()：保存BusinessAnnoScope发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessAnnoScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessAnnoScope entity) throws ServiceException {
		try {
			businessAnnoScopeDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoScopeServiceImpl update()：修改BusinessAnnoScope发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessAnnoScope
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessAnnoScopeDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoScopeServiceImpl delete()：删除BusinessAnnoScope发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
