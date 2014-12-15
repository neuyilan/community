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

import com.community.app.module.vo.ManageModulemenuQuery;
import com.community.app.module.bean.ManageModulemenu;
import com.community.app.module.dao.ManageModulemenuDao;

@Service("ManageModulemenuService")
@Transactional
public class ManageModulemenuServiceImpl implements ManageModulemenuService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageModulemenuServiceImpl.class);
	@Autowired
	private ManageModulemenuDao manageModulemenuDao;

	/**
	 * 查询单个ManageModulemenu
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public ManageModulemenu findById(final Integer id) throws ServiceException {
		ManageModulemenu manageModulemenu = new ManageModulemenu();
		try {
			manageModulemenu = manageModulemenuDao.findById(id);
		} catch (DaoException e) {
			logger.debug("ManageModulemenuServiceImpl findById()：查询单个ManageModulemenu发生错误！", e);
			e.printStackTrace();
		}
		return manageModulemenu;
	}
	
	/**
	 * 无条件查询所有ManageModulemenu
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageModulemenu> findAll() throws ServiceException {
		List<ManageModulemenu> list = new ArrayList<ManageModulemenu>() ;
		try {
			list=manageModulemenuDao.findAll();
		} catch (DaoException e) {
			logger.debug("ManageModulemenuServiceImpl findAll()：无条件查询所有ManageModulemenu发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageModulemenu
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageModulemenu> findByMap(final Map paramMap) throws ServiceException {
		List<ManageModulemenu> list = new ArrayList<ManageModulemenu>() ;
		try {
			list=manageModulemenuDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("ManageModulemenuServiceImpl findByMap()：按Map对象条件查询所有ManageModulemenu发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageModulemenu-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageModulemenu> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<ManageModulemenu> list = new ArrayList<ManageModulemenu>() ;
		try {
			list=manageModulemenuDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("ManageModulemenuServiceImpl findByMap()：按Map对象条件查询所有ManageModulemenu-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageModulemenu
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageModulemenu> findByExample(final ManageModulemenuQuery query) throws ServiceException {
		List<ManageModulemenu> list = new ArrayList<ManageModulemenu>() ;
		try {
			list=manageModulemenuDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("ManageModulemenuServiceImpl findByExample()：按VO对象条件查询所有ManageModulemenu发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageModulemenu-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageModulemenu> findByExample(final ManageModulemenuQuery query, final Integer limit) throws ServiceException {
		List<ManageModulemenu> list = new ArrayList<ManageModulemenu>() ;
		try {
			list=manageModulemenuDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("ManageModulemenuServiceImpl findByExample()：按VO对象条件查询所有ManageModulemenu-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final ManageModulemenuQuery query) throws ServiceException {
		List<ManageModulemenu> list = new ArrayList<ManageModulemenu>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=manageModulemenuDao.findAllPage(query);
			count=manageModulemenuDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageModulemenuServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final ManageModulemenuQuery query) throws ServiceException {
		int count = 0;
		try {
			count = manageModulemenuDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageModulemenuServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存ManageModulemenu数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(ManageModulemenu entity) throws ServiceException {
		try {
			manageModulemenuDao.save(entity);
		} catch (DaoException e) {
			logger.debug("ManageModulemenuServiceImpl save()：保存ManageModulemenu发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改ManageModulemenu数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(ManageModulemenu entity) throws ServiceException {
		try {
			manageModulemenuDao.update(entity);
		} catch (DaoException e) {
			logger.debug("ManageModulemenuServiceImpl update()：修改ManageModulemenu发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除ManageModulemenu
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return manageModulemenuDao.delete(id);
		} catch (DaoException e) {
			logger.debug("ManageModulemenuServiceImpl delete()：删除ManageModulemenu发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
