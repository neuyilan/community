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

import com.community.app.module.vo.BusinessHealthydietQuery;
import com.community.app.module.bean.BusinessHealthydiet;
import com.community.app.module.dao.BusinessHealthydietDao;

@Service("BusinessHealthydietService")
@Transactional
public class BusinessHealthydietServiceImpl implements BusinessHealthydietService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessHealthydietServiceImpl.class);
	@Autowired
	private BusinessHealthydietDao businessHealthydietDao;

	/**
	 * 查询单个BusinessHealthydiet
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessHealthydiet findById(final Integer id) throws ServiceException {
		BusinessHealthydiet businessHealthydiet = new BusinessHealthydiet();
		try {
			businessHealthydiet = businessHealthydietDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietServiceImpl findById()：查询单个BusinessHealthydiet发生错误！", e);
			e.printStackTrace();
		}
		return businessHealthydiet;
	}
	
	/**
	 * 查询单个BusinessHealthydiet
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public BusinessHealthydiet findById_app(final Integer id) throws ServiceException {
		BusinessHealthydiet businessHealthydiet = new BusinessHealthydiet();
		try {
			businessHealthydiet = businessHealthydietDao.findById_app(id);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietServiceImpl findById()：查询单个BusinessHealthydiet发生错误！", e);
			e.printStackTrace();
		}
		return businessHealthydiet;
	}
	
	/**
	 * 无条件查询所有BusinessHealthydiet
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessHealthydiet> findAll() throws ServiceException {
		List<BusinessHealthydiet> list = new ArrayList<BusinessHealthydiet>() ;
		try {
			list=businessHealthydietDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietServiceImpl findAll()：无条件查询所有BusinessHealthydiet发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHealthydiet
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHealthydiet> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessHealthydiet> list = new ArrayList<BusinessHealthydiet>() ;
		try {
			list=businessHealthydietDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietServiceImpl findByMap()：按Map对象条件查询所有BusinessHealthydiet发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHealthydiet-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessHealthydiet> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessHealthydiet> list = new ArrayList<BusinessHealthydiet>() ;
		try {
			list=businessHealthydietDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietServiceImpl findByMap()：按Map对象条件查询所有BusinessHealthydiet-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessHealthydiet
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHealthydiet> findByExample(final BusinessHealthydietQuery query) throws ServiceException {
		List<BusinessHealthydiet> list = new ArrayList<BusinessHealthydiet>() ;
		try {
			list=businessHealthydietDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietServiceImpl findByExample()：按VO对象条件查询所有BusinessHealthydiet发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHealthydiet-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessHealthydiet> findByExample(final BusinessHealthydietQuery query, final Integer limit) throws ServiceException {
		List<BusinessHealthydiet> list = new ArrayList<BusinessHealthydiet>() ;
		try {
			list=businessHealthydietDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietServiceImpl findByExample()：按VO对象条件查询所有BusinessHealthydiet-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessHealthydietQuery query) throws ServiceException {
		List<BusinessHealthydiet> list = new ArrayList<BusinessHealthydiet>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessHealthydietDao.selectCount(query);
			query.setCount(count);
			list=businessHealthydietDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setPage(query.getPage());
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
	public BaseBean findAllPage_app(final BusinessHealthydietQuery query) throws ServiceException {
		List<BusinessHealthydiet> list = new ArrayList<BusinessHealthydiet>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessHealthydietDao.selectCount_app(query);
			query.setCount(count);
			list=businessHealthydietDao.findAllPage_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessHealthydietQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessHealthydietDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessHealthydiet数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessHealthydiet entity) throws ServiceException {
		try {
			businessHealthydietDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietServiceImpl save()：保存BusinessHealthydiet发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessHealthydiet数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessHealthydiet entity) throws ServiceException {
		try {
			businessHealthydietDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietServiceImpl update()：修改BusinessHealthydiet发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessHealthydiet
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessHealthydietDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietServiceImpl delete()：删除BusinessHealthydiet发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
