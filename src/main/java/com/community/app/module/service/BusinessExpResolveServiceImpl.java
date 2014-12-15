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

import com.community.app.module.vo.BusinessExpResolveQuery;
import com.community.app.module.bean.BusinessExpResolve;
import com.community.app.module.dao.BusinessExpResolveDao;

@Service("BusinessExpResolveService")
@Transactional
public class BusinessExpResolveServiceImpl implements BusinessExpResolveService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessExpResolveServiceImpl.class);
	@Autowired
	private BusinessExpResolveDao businessExpResolveDao;

	/**
	 * 查询单个BusinessExpResolve
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessExpResolve findById(final Integer id) throws ServiceException {
		BusinessExpResolve businessExpResolve = new BusinessExpResolve();
		try {
			businessExpResolve = businessExpResolveDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessExpResolveServiceImpl findById()：查询单个BusinessExpResolve发生错误！", e);
			e.printStackTrace();
		}
		return businessExpResolve;
	}
	
	/**
	 * 无条件查询所有BusinessExpResolve
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessExpResolve> findAll() throws ServiceException {
		List<BusinessExpResolve> list = new ArrayList<BusinessExpResolve>() ;
		try {
			list=businessExpResolveDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessExpResolveServiceImpl findAll()：无条件查询所有BusinessExpResolve发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessExpResolve
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessExpResolve> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessExpResolve> list = new ArrayList<BusinessExpResolve>() ;
		try {
			list=businessExpResolveDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessExpResolveServiceImpl findByMap()：按Map对象条件查询所有BusinessExpResolve发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessExpResolve-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessExpResolve> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessExpResolve> list = new ArrayList<BusinessExpResolve>() ;
		try {
			list=businessExpResolveDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessExpResolveServiceImpl findByMap()：按Map对象条件查询所有BusinessExpResolve-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessExpResolve
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessExpResolve> findByExample(final BusinessExpResolveQuery query) throws ServiceException {
		List<BusinessExpResolve> list = new ArrayList<BusinessExpResolve>() ;
		try {
			list=businessExpResolveDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessExpResolveServiceImpl findByExample()：按VO对象条件查询所有BusinessExpResolve发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessExpResolve-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessExpResolve> findByExample(final BusinessExpResolveQuery query, final Integer limit) throws ServiceException {
		List<BusinessExpResolve> list = new ArrayList<BusinessExpResolve>() ;
		try {
			list=businessExpResolveDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessExpResolveServiceImpl findByExample()：按VO对象条件查询所有BusinessExpResolve-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessExpResolveQuery query) throws ServiceException {
		List<BusinessExpResolve> list = new ArrayList<BusinessExpResolve>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessExpResolveDao.findAllPage(query);
			count=businessExpResolveDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessExpResolveServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage_app(final BusinessExpResolveQuery query) throws ServiceException {
		List<BusinessExpResolve> list = new ArrayList<BusinessExpResolve>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessExpResolveDao.findAllPage_app(query);
			count=businessExpResolveDao.selectCount_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessExpResolveServiceImpl findAllPage_app()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessExpResolveQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessExpResolveDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessExpResolveServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessExpResolve数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessExpResolve entity) throws ServiceException {
		try {
			businessExpResolveDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessExpResolveServiceImpl save()：保存BusinessExpResolve发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存BusinessExpResolve数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save_app(BusinessExpResolve entity) throws ServiceException {
		try {
			businessExpResolveDao.save_app(entity);
		} catch (DaoException e) {
			logger.debug("BusinessExpResolveServiceImpl save_app()：保存BusinessExpResolve发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessExpResolve数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessExpResolve entity) throws ServiceException {
		try {
			businessExpResolveDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessExpResolveServiceImpl update()：修改BusinessExpResolve发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessExpResolve
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessExpResolveDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessExpResolveServiceImpl delete()：删除BusinessExpResolve发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 删除BusinessExpResolve
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete_app(Integer id) throws ServiceException {
		try {
			return businessExpResolveDao.delete_app(id);
		} catch (DaoException e) {
			logger.debug("BusinessExpResolveServiceImpl delete_app()：删除BusinessExpResolve发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
