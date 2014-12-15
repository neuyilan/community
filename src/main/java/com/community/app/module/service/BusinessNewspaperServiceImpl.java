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

import com.community.app.module.vo.BusinessNewspaperQuery;
import com.community.app.module.bean.BusinessNewspaper;
import com.community.app.module.dao.BusinessNewspaperDao;

@Service("BusinessNewspaperService")
@Transactional
public class BusinessNewspaperServiceImpl implements BusinessNewspaperService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessNewspaperServiceImpl.class);
	@Autowired
	private BusinessNewspaperDao businessNewspaperDao;

	/**
	 * 查询单个BusinessNewspaper
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessNewspaper findById(final Integer id) throws ServiceException {
		BusinessNewspaper businessNewspaper = new BusinessNewspaper();
		try {
			businessNewspaper = businessNewspaperDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperServiceImpl findById()：查询单个BusinessNewspaper发生错误！", e);
			e.printStackTrace();
		}
		return businessNewspaper;
	}
	
	/**
	 * 无条件查询所有BusinessNewspaper
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessNewspaper> findAll() throws ServiceException {
		List<BusinessNewspaper> list = new ArrayList<BusinessNewspaper>() ;
		try {
			list=businessNewspaperDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperServiceImpl findAll()：无条件查询所有BusinessNewspaper发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewspaper
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNewspaper> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessNewspaper> list = new ArrayList<BusinessNewspaper>() ;
		try {
			list=businessNewspaperDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperServiceImpl findByMap()：按Map对象条件查询所有BusinessNewspaper发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewspaper-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNewspaper> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessNewspaper> list = new ArrayList<BusinessNewspaper>() ;
		try {
			list=businessNewspaperDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperServiceImpl findByMap()：按Map对象条件查询所有BusinessNewspaper-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNewspaper
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNewspaper> findByExample(final BusinessNewspaperQuery query) throws ServiceException {
		List<BusinessNewspaper> list = new ArrayList<BusinessNewspaper>() ;
		try {
			list=businessNewspaperDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperServiceImpl findByExample()：按VO对象条件查询所有BusinessNewspaper发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNewspaper-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNewspaper> findByExample(final BusinessNewspaperQuery query, final Integer limit) throws ServiceException {
		List<BusinessNewspaper> list = new ArrayList<BusinessNewspaper>() ;
		try {
			list=businessNewspaperDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperServiceImpl findByExample()：按VO对象条件查询所有BusinessNewspaper-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessNewspaperQuery query) throws ServiceException {
		List<BusinessNewspaper> list = new ArrayList<BusinessNewspaper>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessNewspaperDao.selectCount(query);
			query.setCount(count);
			list=businessNewspaperDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public BaseBean findAllPage_app(final BusinessNewspaperQuery query) throws ServiceException {
		List<BusinessNewspaper> list = new ArrayList<BusinessNewspaper>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessNewspaperDao.selectCount_app(query);
			query.setCount(count);
			list=businessNewspaperDao.findAllPage_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setPage(query.getPage());
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount(final BusinessNewspaperQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessNewspaperDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessNewspaper数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessNewspaper entity) throws ServiceException {
		try {
			businessNewspaperDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperServiceImpl save()：保存BusinessNewspaper发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessNewspaper数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessNewspaper entity) throws ServiceException {
		try {
			businessNewspaperDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperServiceImpl update()：修改BusinessNewspaper发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessNewspaper
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessNewspaperDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessNewspaperServiceImpl delete()：删除BusinessNewspaper发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
