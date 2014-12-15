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

import com.community.app.module.vo.BusinessDepartmentQuery;
import com.community.app.module.bean.BusinessDepartment;
import com.community.app.module.dao.BusinessDepartmentDao;

@Service("BusinessDepartmentService")
@Transactional
public class BusinessDepartmentServiceImpl implements BusinessDepartmentService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessDepartmentServiceImpl.class);
	@Autowired
	private BusinessDepartmentDao businessDepartmentDao;

	/**
	 * 查询单个BusinessDepartment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessDepartment findById(final Integer id) throws ServiceException {
		BusinessDepartment businessDepartment = new BusinessDepartment();
		try {
			businessDepartment = businessDepartmentDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessDepartmentServiceImpl findById()：查询单个BusinessDepartment发生错误！", e);
			e.printStackTrace();
		}
		return businessDepartment;
	}
	
	/**
	 * 无条件查询所有BusinessDepartment
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessDepartment> findAll() throws ServiceException {
		List<BusinessDepartment> list = new ArrayList<BusinessDepartment>() ;
		try {
			list=businessDepartmentDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessDepartmentServiceImpl findAll()：无条件查询所有BusinessDepartment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessDepartment
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessDepartment> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessDepartment> list = new ArrayList<BusinessDepartment>() ;
		try {
			list=businessDepartmentDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessDepartmentServiceImpl findByMap()：按Map对象条件查询所有BusinessDepartment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessDepartment-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessDepartment> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessDepartment> list = new ArrayList<BusinessDepartment>() ;
		try {
			list=businessDepartmentDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessDepartmentServiceImpl findByMap()：按Map对象条件查询所有BusinessDepartment-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessDepartment
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessDepartment> findByExample(final BusinessDepartmentQuery query) throws ServiceException {
		List<BusinessDepartment> list = new ArrayList<BusinessDepartment>() ;
		try {
			list=businessDepartmentDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessDepartmentServiceImpl findByExample()：按VO对象条件查询所有BusinessDepartment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessDepartment-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessDepartment> findByExample(final BusinessDepartmentQuery query, final Integer limit) throws ServiceException {
		List<BusinessDepartment> list = new ArrayList<BusinessDepartment>() ;
		try {
			list=businessDepartmentDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessDepartmentServiceImpl findByExample()：按VO对象条件查询所有BusinessDepartment-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessDepartmentQuery query) throws ServiceException {
		List<BusinessDepartment> list = new ArrayList<BusinessDepartment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessDepartmentDao.findAllPage(query);
			count=businessDepartmentDao.selectCount(query);
			query.setCount(count);
		} catch (DaoException e) {
			logger.debug("BusinessDepartmentServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessDepartmentQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessDepartmentDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessDepartmentServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessDepartment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessDepartment entity) throws ServiceException {
		try {
			businessDepartmentDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessDepartmentServiceImpl save()：保存BusinessDepartment发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessDepartment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessDepartment entity) throws ServiceException {
		try {
			businessDepartmentDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessDepartmentServiceImpl update()：修改BusinessDepartment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessDepartment
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessDepartmentDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessDepartmentServiceImpl delete()：删除BusinessDepartment发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
