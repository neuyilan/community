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

import com.community.app.module.vo.BusinessTelGroupQuery;
import com.community.app.module.bean.BusinessTelGroup;
import com.community.app.module.dao.BusinessTelGroupDao;

@Service("BusinessTelGroupService")
@Transactional
public class BusinessTelGroupServiceImpl implements BusinessTelGroupService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessTelGroupServiceImpl.class);
	@Autowired
	private BusinessTelGroupDao businessTelGroupDao;

	/**
	 * 查询单个BusinessTelGroup
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessTelGroup findById(final Integer id) throws ServiceException {
		BusinessTelGroup businessTelGroup = new BusinessTelGroup();
		try {
			businessTelGroup = businessTelGroupDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessTelGroupServiceImpl findById()：查询单个BusinessTelGroup发生错误！", e);
			e.printStackTrace();
		}
		return businessTelGroup;
	}
	
	/**
	 * 无条件查询所有BusinessTelGroup
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessTelGroup> findAll() throws ServiceException {
		List<BusinessTelGroup> list = new ArrayList<BusinessTelGroup>() ;
		try {
			list=businessTelGroupDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessTelGroupServiceImpl findAll()：无条件查询所有BusinessTelGroup发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessTelGroup
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessTelGroup> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessTelGroup> list = new ArrayList<BusinessTelGroup>() ;
		try {
			list=businessTelGroupDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessTelGroupServiceImpl findByMap()：按Map对象条件查询所有BusinessTelGroup发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessTelGroup-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessTelGroup> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessTelGroup> list = new ArrayList<BusinessTelGroup>() ;
		try {
			list=businessTelGroupDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessTelGroupServiceImpl findByMap()：按Map对象条件查询所有BusinessTelGroup-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessTelGroup
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessTelGroup> findByExample(final BusinessTelGroupQuery query) throws ServiceException {
		List<BusinessTelGroup> list = new ArrayList<BusinessTelGroup>() ;
		try {
			list=businessTelGroupDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessTelGroupServiceImpl findByExample()：按VO对象条件查询所有BusinessTelGroup发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessTelGroup-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessTelGroup> findByExample(final BusinessTelGroupQuery query, final Integer limit) throws ServiceException {
		List<BusinessTelGroup> list = new ArrayList<BusinessTelGroup>() ;
		try {
			list=businessTelGroupDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessTelGroupServiceImpl findByExample()：按VO对象条件查询所有BusinessTelGroup-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessTelGroupQuery query) throws ServiceException {
		List<BusinessTelGroup> list = new ArrayList<BusinessTelGroup>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessTelGroupDao.findAllPage(query);
			count=businessTelGroupDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessTelGroupServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessTelGroupQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessTelGroupDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessTelGroupServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessTelGroup数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessTelGroup entity) throws ServiceException {
		try {
			businessTelGroupDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessTelGroupServiceImpl save()：保存BusinessTelGroup发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessTelGroup数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessTelGroup entity) throws ServiceException {
		try {
			businessTelGroupDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessTelGroupServiceImpl update()：修改BusinessTelGroup发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessTelGroup
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessTelGroupDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessTelGroupServiceImpl delete()：删除BusinessTelGroup发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
