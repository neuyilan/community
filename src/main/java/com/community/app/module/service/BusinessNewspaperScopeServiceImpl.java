package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessNewspaperScope;
import com.community.app.module.dao.BusinessNewspaperScopeDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessNewspaperScopeQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessNewspaperScopeService")
@Transactional
public class BusinessNewspaperScopeServiceImpl implements BusinessNewspaperScopeService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessNewspaperScopeServiceImpl.class);
	@Autowired
	private BusinessNewspaperScopeDao businessNewspaperScopeDao;

	/**
	 * 查询单个BusinessNewspaperScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessNewspaperScope findById(final Integer id) throws ServiceException {
		BusinessNewspaperScope businessNewspaperScope = new BusinessNewspaperScope();
		try {
			businessNewspaperScope = businessNewspaperScopeDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperScopeServiceImpl findById()：查询单个BusinessNewspaperScope发生错误！", e);
			e.printStackTrace();
		}
		return businessNewspaperScope;
	}
	
	/**
	 * 无条件查询所有BusinessNewspaperScope
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessNewspaperScope> findAll() throws ServiceException {
		List<BusinessNewspaperScope> list = new ArrayList<BusinessNewspaperScope>() ;
		try {
			list=businessNewspaperScopeDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperScopeServiceImpl findAll()：无条件查询所有BusinessNewspaperScope发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewspaperScope
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNewspaperScope> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessNewspaperScope> list = new ArrayList<BusinessNewspaperScope>() ;
		try {
			list=businessNewspaperScopeDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperScopeServiceImpl findByMap()：按Map对象条件查询所有BusinessNewspaperScope发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewspaperScope-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessNewspaperScope> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessNewspaperScope> list = new ArrayList<BusinessNewspaperScope>() ;
		try {
			list=businessNewspaperScopeDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperScopeServiceImpl findByMap()：按Map对象条件查询所有BusinessNewspaperScope-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessNewspaperScope
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNewspaperScope> findByExample(final BusinessNewspaperScopeQuery query) throws ServiceException {
		List<BusinessNewspaperScope> list = new ArrayList<BusinessNewspaperScope>() ;
		try {
			list=businessNewspaperScopeDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperScopeServiceImpl findByExample()：按VO对象条件查询所有BusinessNewspaperScope发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNewspaperScope-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessNewspaperScope> findByExample(final BusinessNewspaperScopeQuery query, final Integer limit) throws ServiceException {
		List<BusinessNewspaperScope> list = new ArrayList<BusinessNewspaperScope>() ;
		try {
			list=businessNewspaperScopeDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperScopeServiceImpl findByExample()：按VO对象条件查询所有BusinessNewspaperScope-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessNewspaperScopeQuery query) throws ServiceException {
		List<BusinessNewspaperScope> list = new ArrayList<BusinessNewspaperScope>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessNewspaperScopeDao.findAllPage(query);
			count=businessNewspaperScopeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperScopeServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessNewspaperScopeQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessNewspaperScopeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperScopeServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessNewspaperScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessNewspaperScope entity) throws ServiceException {
		try {
			businessNewspaperScopeDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperScopeServiceImpl save()：保存BusinessNewspaperScope发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessNewspaperScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessNewspaperScope entity) throws ServiceException {
		try {
			businessNewspaperScopeDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperScopeServiceImpl update()：修改BusinessNewspaperScope发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessNewspaperScope
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessNewspaperScopeDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperScopeServiceImpl delete()：删除BusinessNewspaperScope发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
}