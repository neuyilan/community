package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessAnnoVisit;
import com.community.app.module.dao.BusinessAnnoVisitDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessAnnoVisitQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessAnnoVisitService")
@Transactional
public class BusinessAnnoVisitServiceImpl implements BusinessAnnoVisitService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessAnnoVisitServiceImpl.class);
	@Autowired
	private BusinessAnnoVisitDao businessAnnoVisitDao;

	/**
	 * 查询单个BusinessAnnoVisit
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessAnnoVisit findById(final Integer id) throws ServiceException {
		BusinessAnnoVisit businessAnnoVisit = new BusinessAnnoVisit();
		try {
			businessAnnoVisit = businessAnnoVisitDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoVisitServiceImpl findById()：查询单个BusinessAnnoVisit发生错误！", e);
			e.printStackTrace();
		}
		return businessAnnoVisit;
	}
	
	/**
	 * 无条件查询所有BusinessAnnoVisit
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessAnnoVisit> findAll() throws ServiceException {
		List<BusinessAnnoVisit> list = new ArrayList<BusinessAnnoVisit>() ;
		try {
			list=businessAnnoVisitDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessAnnoVisitServiceImpl findAll()：无条件查询所有BusinessAnnoVisit发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoVisit
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessAnnoVisit> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessAnnoVisit> list = new ArrayList<BusinessAnnoVisit>() ;
		try {
			list=businessAnnoVisitDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoVisitServiceImpl findByMap()：按Map对象条件查询所有BusinessAnnoVisit发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoVisit-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessAnnoVisit> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessAnnoVisit> list = new ArrayList<BusinessAnnoVisit>() ;
		try {
			list=businessAnnoVisitDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoVisitServiceImpl findByMap()：按Map对象条件查询所有BusinessAnnoVisit-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoVisit
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessAnnoVisit> findByExample(final BusinessAnnoVisitQuery query) throws ServiceException {
		List<BusinessAnnoVisit> list = new ArrayList<BusinessAnnoVisit>() ;
		try {
			list=businessAnnoVisitDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoVisitServiceImpl findByExample()：按VO对象条件查询所有BusinessAnnoVisit发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoVisit-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessAnnoVisit> findByExample(final BusinessAnnoVisitQuery query, final Integer limit) throws ServiceException {
		List<BusinessAnnoVisit> list = new ArrayList<BusinessAnnoVisit>() ;
		try {
			list=businessAnnoVisitDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoVisitServiceImpl findByExample()：按VO对象条件查询所有BusinessAnnoVisit-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessAnnoVisitQuery query) throws ServiceException {
		List<BusinessAnnoVisit> list = new ArrayList<BusinessAnnoVisit>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessAnnoVisitDao.findAllPage(query);
			count=businessAnnoVisitDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoVisitServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessAnnoVisitQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessAnnoVisitDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoVisitServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessAnnoVisit数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessAnnoVisit entity) throws ServiceException {
		try {
			businessAnnoVisitDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoVisitServiceImpl save()：保存BusinessAnnoVisit发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessAnnoVisit数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessAnnoVisit entity) throws ServiceException {
		try {
			businessAnnoVisitDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoVisitServiceImpl update()：修改BusinessAnnoVisit发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessAnnoVisit
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessAnnoVisitDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoVisitServiceImpl delete()：删除BusinessAnnoVisit发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
