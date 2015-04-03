package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessStationFeedback;
import com.community.app.module.dao.BusinessStationFeedbackDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessStationFeedbackQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessStationFeedbackService")
@Transactional
public class BusinessStationFeedbackServiceImpl implements BusinessStationFeedbackService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessStationFeedbackServiceImpl.class);
	@Autowired
	private BusinessStationFeedbackDao businessStationFeedbackDao;

	/**
	 * 查询单个BusinessStationFeedback
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessStationFeedback findById(final Integer id) throws ServiceException {
		BusinessStationFeedback businessStationFeedback = new BusinessStationFeedback();
		try {
			businessStationFeedback = businessStationFeedbackDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackServiceImpl findById()：查询单个BusinessStationFeedback发生错误！", e);
			e.printStackTrace();
		}
		return businessStationFeedback;
	}
	
	/**
	 * 无条件查询所有BusinessStationFeedback
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessStationFeedback> findAll() throws ServiceException {
		List<BusinessStationFeedback> list = new ArrayList<BusinessStationFeedback>() ;
		try {
			list=businessStationFeedbackDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackServiceImpl findAll()：无条件查询所有BusinessStationFeedback发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessStationFeedback
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessStationFeedback> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessStationFeedback> list = new ArrayList<BusinessStationFeedback>() ;
		try {
			list=businessStationFeedbackDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackServiceImpl findByMap()：按Map对象条件查询所有BusinessStationFeedback发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessStationFeedback-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessStationFeedback> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessStationFeedback> list = new ArrayList<BusinessStationFeedback>() ;
		try {
			list=businessStationFeedbackDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackServiceImpl findByMap()：按Map对象条件查询所有BusinessStationFeedback-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessStationFeedback
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessStationFeedback> findByExample(final BusinessStationFeedbackQuery query) throws ServiceException {
		List<BusinessStationFeedback> list = new ArrayList<BusinessStationFeedback>() ;
		try {
			list=businessStationFeedbackDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackServiceImpl findByExample()：按VO对象条件查询所有BusinessStationFeedback发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessStationFeedback-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessStationFeedback> findByExample(final BusinessStationFeedbackQuery query, final Integer limit) throws ServiceException {
		List<BusinessStationFeedback> list = new ArrayList<BusinessStationFeedback>() ;
		try {
			list=businessStationFeedbackDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackServiceImpl findByExample()：按VO对象条件查询所有BusinessStationFeedback-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessStationFeedbackQuery query) throws ServiceException {
		List<BusinessStationFeedback> list = new ArrayList<BusinessStationFeedback>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessStationFeedbackDao.selectCount(query);
			query.setCount(count);
			list=businessStationFeedbackDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setPage(query.getPage());
		baseBean.setRows(20);
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount(final BusinessStationFeedbackQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessStationFeedbackDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessStationFeedback数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public int save(BusinessStationFeedback entity) throws ServiceException {
		try {
			return businessStationFeedbackDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackServiceImpl save()：保存BusinessStationFeedback发生错误！", e);
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 修改BusinessStationFeedback数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessStationFeedback entity) throws ServiceException {
		try {
			businessStationFeedbackDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackServiceImpl update()：修改BusinessStationFeedback发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessStationFeedback
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessStationFeedbackDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessStationFeedbackServiceImpl delete()：删除BusinessStationFeedback发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
}