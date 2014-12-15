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

import com.community.app.module.vo.BusinessNewsViewQuery;
import com.community.app.module.bean.BusinessNewsView;
import com.community.app.module.dao.BusinessNewsViewDao;

@Service("BusinessNewsViewService")
@Transactional
public class BusinessNewsViewServiceImpl implements BusinessNewsViewService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessNewsViewServiceImpl.class);
	@Autowired
	private BusinessNewsViewDao businessNewsViewDao;

	/**
	 * 查询单个BusinessNewsView
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessNewsView findById(final Integer id) throws ServiceException {
		BusinessNewsView businessNewsView = new BusinessNewsView();
		try {
			businessNewsView = businessNewsViewDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessNewsViewServiceImpl findById()：查询单个BusinessNewsView发生错误！", e);
			e.printStackTrace();
		}
		return businessNewsView;
	}
	
	/**
	 * 无条件查询所有BusinessNewsView
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessNewsView> findAll() throws ServiceException {
		List<BusinessNewsView> list = new ArrayList<BusinessNewsView>() ;
		try {
			list=businessNewsViewDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessNewsViewServiceImpl findAll()：无条件查询所有BusinessNewsView发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewsView
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNewsView> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessNewsView> list = new ArrayList<BusinessNewsView>() ;
		try {
			list=businessNewsViewDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessNewsViewServiceImpl findByMap()：按Map对象条件查询所有BusinessNewsView发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewsView-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessNewsView> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessNewsView> list = new ArrayList<BusinessNewsView>() ;
		try {
			list=businessNewsViewDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessNewsViewServiceImpl findByMap()：按Map对象条件查询所有BusinessNewsView-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessNewsView
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNewsView> findByExample(final BusinessNewsViewQuery query) throws ServiceException {
		List<BusinessNewsView> list = new ArrayList<BusinessNewsView>() ;
		try {
			list=businessNewsViewDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsViewServiceImpl findByExample()：按VO对象条件查询所有BusinessNewsView发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNewsView-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessNewsView> findByExample(final BusinessNewsViewQuery query, final Integer limit) throws ServiceException {
		List<BusinessNewsView> list = new ArrayList<BusinessNewsView>() ;
		try {
			list=businessNewsViewDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessNewsViewServiceImpl findByExample()：按VO对象条件查询所有BusinessNewsView-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessNewsViewQuery query) throws ServiceException {
		List<BusinessNewsView> list = new ArrayList<BusinessNewsView>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessNewsViewDao.findAllPage(query);
			count=businessNewsViewDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsViewServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessNewsViewQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessNewsViewDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsViewServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessNewsView数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessNewsView entity) throws ServiceException {
		try {
			businessNewsViewDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessNewsViewServiceImpl save()：保存BusinessNewsView发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessNewsView数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessNewsView entity) throws ServiceException {
		try {
			businessNewsViewDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessNewsViewServiceImpl update()：修改BusinessNewsView发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessNewsView
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessNewsViewDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessNewsViewServiceImpl delete()：删除BusinessNewsView发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
