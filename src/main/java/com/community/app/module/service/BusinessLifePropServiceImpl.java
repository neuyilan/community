package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.vo.BusinessLifePropQuery;
import com.community.app.module.bean.BusinessLifeProp;
import com.community.app.module.dao.BusinessLifePropDao;

@Service("BusinessLifePropService")
@Transactional
public class BusinessLifePropServiceImpl implements BusinessLifePropService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessLifePropServiceImpl.class);
	@Autowired
	private BusinessLifePropDao businessLifePropDao;

	/**
	 * 查询单个BusinessLifeProp
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessLifeProp findById(final Integer id) throws ServiceException {
		BusinessLifeProp businessLifeProp = new BusinessLifeProp();
		try {
			businessLifeProp = businessLifePropDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessLifePropServiceImpl findById()：查询单个BusinessLifeProp发生错误！", e);
			e.printStackTrace();
		}
		return businessLifeProp;
	}
	
	/**
	 * 无条件查询所有BusinessLifeProp
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessLifeProp> findAll() throws ServiceException {
		List<BusinessLifeProp> list = new ArrayList<BusinessLifeProp>() ;
		try {
			list=businessLifePropDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessLifePropServiceImpl findAll()：无条件查询所有BusinessLifeProp发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessLifeProp
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessLifeProp> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessLifeProp> list = new ArrayList<BusinessLifeProp>() ;
		try {
			list=businessLifePropDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessLifePropServiceImpl findByMap()：按Map对象条件查询所有BusinessLifeProp发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessLifeProp-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessLifeProp> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessLifeProp> list = new ArrayList<BusinessLifeProp>() ;
		try {
			list=businessLifePropDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessLifePropServiceImpl findByMap()：按Map对象条件查询所有BusinessLifeProp-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessLifeProp
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessLifeProp> findByExample(final BusinessLifePropQuery query) throws ServiceException {
		List<BusinessLifeProp> list = new ArrayList<BusinessLifeProp>() ;
		try {
			list=businessLifePropDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessLifePropServiceImpl findByExample()：按VO对象条件查询所有BusinessLifeProp发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessLifeProp-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessLifeProp> findByExample(final BusinessLifePropQuery query, final Integer limit) throws ServiceException {
		List<BusinessLifeProp> list = new ArrayList<BusinessLifeProp>() ;
		try {
			list=businessLifePropDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessLifePropServiceImpl findByExample()：按VO对象条件查询所有BusinessLifeProp-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessLifePropQuery query) throws ServiceException {
		List<BusinessLifeProp> list = new ArrayList<BusinessLifeProp>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessLifePropDao.findAllPage(query);
			count=businessLifePropDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessLifePropServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessLifePropQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessLifePropDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessLifePropServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessLifeProp数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessLifeProp entity) throws ServiceException {
		try {
			businessLifePropDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessLifePropServiceImpl save()：保存BusinessLifeProp发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessLifeProp数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessLifeProp entity) throws ServiceException {
		try {
			businessLifePropDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessLifePropServiceImpl update()：修改BusinessLifeProp发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessLifeProp
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessLifePropDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessLifePropServiceImpl delete()：删除BusinessLifeProp发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 删除BusinessLifeProp
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean deleteLifeProp(Integer id) throws ServiceException {
		try {
			return businessLifePropDao.deleteLifeProp(id);
		} catch (DaoException e) {
			logger.debug("BusinessLifePropServiceImpl delete()：删除BusinessLifeProp发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
