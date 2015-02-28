package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.ManageFunction;
import com.community.app.module.dao.ManageFunctionDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.ManageFunctionQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("ManageFunctionService")
@Transactional
public class ManageFunctionServiceImpl implements ManageFunctionService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageFunctionServiceImpl.class);
	@Autowired
	private ManageFunctionDao manageFunctionDao;

	/**
	 * 查询单个ManageFunction
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public ManageFunction findById(final Integer id) throws ServiceException {
		ManageFunction manageFunction = new ManageFunction();
		try {
			manageFunction = manageFunctionDao.findById(id);
		} catch (DaoException e) {
			logger.debug("ManageFunctionServiceImpl findById()：查询单个ManageFunction发生错误！", e);
			e.printStackTrace();
		}
		return manageFunction;
	}
	
	/**
	 * 无条件查询所有ManageFunction
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageFunction> findAll() throws ServiceException {
		List<ManageFunction> list = new ArrayList<ManageFunction>() ;
		try {
			list=manageFunctionDao.findAll();
		} catch (DaoException e) {
			logger.debug("ManageFunctionServiceImpl findAll()：无条件查询所有ManageFunction发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageFunction
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageFunction> findByMap(final Map paramMap) throws ServiceException {
		List<ManageFunction> list = new ArrayList<ManageFunction>() ;
		try {
			list=manageFunctionDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("ManageFunctionServiceImpl findByMap()：按Map对象条件查询所有ManageFunction发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageFunction-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageFunction> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<ManageFunction> list = new ArrayList<ManageFunction>() ;
		try {
			list=manageFunctionDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("ManageFunctionServiceImpl findByMap()：按Map对象条件查询所有ManageFunction-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageFunction
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageFunction> findByExample(final ManageFunctionQuery query) throws ServiceException {
		List<ManageFunction> list = new ArrayList<ManageFunction>() ;
		try {
			list=manageFunctionDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("ManageFunctionServiceImpl findByExample()：按VO对象条件查询所有ManageFunction发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageFunction-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageFunction> findByExample(final ManageFunctionQuery query, final Integer limit) throws ServiceException {
		List<ManageFunction> list = new ArrayList<ManageFunction>() ;
		try {
			list=manageFunctionDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("ManageFunctionServiceImpl findByExample()：按VO对象条件查询所有ManageFunction-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final ManageFunctionQuery query) throws ServiceException {
		List<ManageFunction> list = new ArrayList<ManageFunction>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=manageFunctionDao.findAllPage(query);
			count=manageFunctionDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageFunctionServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final ManageFunctionQuery query) throws ServiceException {
		int count = 0;
		try {
			count = manageFunctionDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageFunctionServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存ManageFunction数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(ManageFunction entity) throws ServiceException {
		try {
			manageFunctionDao.save(entity);
		} catch (DaoException e) {
			logger.debug("ManageFunctionServiceImpl save()：保存ManageFunction发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改ManageFunction数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(ManageFunction entity) throws ServiceException {
		try {
			manageFunctionDao.update(entity);
		} catch (DaoException e) {
			logger.debug("ManageFunctionServiceImpl update()：修改ManageFunction发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除ManageFunction
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return manageFunctionDao.delete(id);
		} catch (DaoException e) {
			logger.debug("ManageFunctionServiceImpl delete()：删除ManageFunction发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
