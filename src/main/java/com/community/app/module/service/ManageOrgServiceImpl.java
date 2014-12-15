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

import com.community.app.module.vo.ManageOrgQuery;
import com.community.app.module.bean.ManageOrg;
import com.community.app.module.dao.ManageOrgDao;

@Service("ManageOrgService")
@Transactional
public class ManageOrgServiceImpl implements ManageOrgService{
	
	private static Logger logger = LoggerFactory.getLogger(ManageOrgServiceImpl.class);
	@Autowired
	private ManageOrgDao manageOrgDao;

	/**
	 * 查询单个ManageOrg
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public ManageOrg findById(final Integer id) throws ServiceException {
		ManageOrg manageOrg = new ManageOrg();
		try {
			manageOrg = manageOrgDao.findById(id);
		} catch (DaoException e) {
			logger.debug("ManageOrgServiceImpl findById()：查询单个ManageOrg发生错误！", e);
			e.printStackTrace();
		}
		return manageOrg;
	}
	
	/**
	 * 无条件查询所有ManageOrg
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageOrg> findAll() throws ServiceException {
		List<ManageOrg> list = new ArrayList<ManageOrg>() ;
		try {
			list=manageOrgDao.findAll();
		} catch (DaoException e) {
			logger.debug("ManageOrgServiceImpl findAll()：无条件查询所有ManageOrg发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageOrg
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageOrg> findByMap(final Map paramMap) throws ServiceException {
		List<ManageOrg> list = new ArrayList<ManageOrg>() ;
		try {
			list=manageOrgDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("ManageOrgServiceImpl findByMap()：按Map对象条件查询所有ManageOrg发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageOrg-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageOrg> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<ManageOrg> list = new ArrayList<ManageOrg>() ;
		try {
			list=manageOrgDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("ManageOrgServiceImpl findByMap()：按Map对象条件查询所有ManageOrg-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageOrg
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageOrg> findByExample(final ManageOrgQuery query) throws ServiceException {
		List<ManageOrg> list = new ArrayList<ManageOrg>() ;
		try {
			list=manageOrgDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("ManageOrgServiceImpl findByExample()：按VO对象条件查询所有ManageOrg发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageOrg-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageOrg> findByExample(final ManageOrgQuery query, final Integer limit) throws ServiceException {
		List<ManageOrg> list = new ArrayList<ManageOrg>() ;
		try {
			list=manageOrgDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("ManageOrgServiceImpl findByExample()：按VO对象条件查询所有ManageOrg-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final ManageOrgQuery query) throws ServiceException {
		List<ManageOrg> list = new ArrayList<ManageOrg>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=manageOrgDao.findAllPage(query);
			count=manageOrgDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageOrgServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final ManageOrgQuery query) throws ServiceException {
		int count = 0;
		try {
			count = manageOrgDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageOrgServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存ManageOrg数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(ManageOrg entity) throws ServiceException {
		try {
			manageOrgDao.save(entity);
		} catch (DaoException e) {
			logger.debug("ManageOrgServiceImpl save()：保存ManageOrg发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改ManageOrg数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(ManageOrg entity) throws ServiceException {
		try {
			manageOrgDao.update(entity);
		} catch (DaoException e) {
			logger.debug("ManageOrgServiceImpl update()：修改ManageOrg发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除ManageOrg
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return manageOrgDao.delete(id);
		} catch (DaoException e) {
			logger.debug("ManageOrgServiceImpl delete()：删除ManageOrg发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
