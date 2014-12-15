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

import com.community.app.module.vo.BusinessLifeQuery;
import com.community.app.module.bean.BusinessLife;
import com.community.app.module.dao.BusinessLifeDao;

@Service("BusinessLifeService")
@Transactional
public class BusinessLifeServiceImpl implements BusinessLifeService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessLifeServiceImpl.class);
	@Autowired
	private BusinessLifeDao businessLifeDao;

	/**
	 * 查询单个BusinessLife
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessLife findById(final Integer id) throws ServiceException {
		BusinessLife businessLife = new BusinessLife();
		try {
			businessLife = businessLifeDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessLifeServiceImpl findById()：查询单个BusinessLife发生错误！", e);
			e.printStackTrace();
		}
		return businessLife;
	}
	
	/**
	 * 无条件查询所有BusinessLife
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessLife> findAll() throws ServiceException {
		List<BusinessLife> list = new ArrayList<BusinessLife>() ;
		try {
			list=businessLifeDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessLifeServiceImpl findAll()：无条件查询所有BusinessLife发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessLife
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessLife> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessLife> list = new ArrayList<BusinessLife>() ;
		try {
			list=businessLifeDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessLifeServiceImpl findByMap()：按Map对象条件查询所有BusinessLife发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessLife-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessLife> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessLife> list = new ArrayList<BusinessLife>() ;
		try {
			list=businessLifeDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessLifeServiceImpl findByMap()：按Map对象条件查询所有BusinessLife-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessLife
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessLife> findByExample(final BusinessLifeQuery query) throws ServiceException {
		List<BusinessLife> list = new ArrayList<BusinessLife>() ;
		try {
			list=businessLifeDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessLifeServiceImpl findByExample()：按VO对象条件查询所有BusinessLife发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessLife-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessLife> findByExample(final BusinessLifeQuery query, final Integer limit) throws ServiceException {
		List<BusinessLife> list = new ArrayList<BusinessLife>() ;
		try {
			list=businessLifeDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessLifeServiceImpl findByExample()：按VO对象条件查询所有BusinessLife-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessLifeQuery query) throws ServiceException {
		List<BusinessLife> list = new ArrayList<BusinessLife>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessLifeDao.findAllPage(query);
			count=businessLifeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessLifeServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessLifeQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessLifeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessLifeServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessLife数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessLife entity) throws ServiceException {
		try {
			businessLifeDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessLifeServiceImpl save()：保存BusinessLife发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessLife数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessLife entity) throws ServiceException {
		try {
			businessLifeDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessLifeServiceImpl update()：修改BusinessLife发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessLife
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessLifeDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessLifeServiceImpl delete()：删除BusinessLife发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
