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

import com.community.app.module.vo.BusinessChinmedichenacareSupportQuery;
import com.community.app.module.bean.BusinessChinmedichenacareSupport;
import com.community.app.module.dao.BusinessChinmedichenacareSupportDao;

@Service("BusinessChinmedichenacareSupportService")
@Transactional
public class BusinessChinmedichenacareSupportServiceImpl implements BusinessChinmedichenacareSupportService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessChinmedichenacareSupportServiceImpl.class);
	@Autowired
	private BusinessChinmedichenacareSupportDao businessChinmedichenacareSupportDao;

	/**
	 * 查询单个BusinessChinmedichenacareSupport
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessChinmedichenacareSupport findById(final Integer id) throws ServiceException {
		BusinessChinmedichenacareSupport businessChinmedichenacareSupport = new BusinessChinmedichenacareSupport();
		try {
			businessChinmedichenacareSupport = businessChinmedichenacareSupportDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareSupportServiceImpl findById()：查询单个BusinessChinmedichenacareSupport发生错误！", e);
			e.printStackTrace();
		}
		return businessChinmedichenacareSupport;
	}
	
	/**
	 * 无条件查询所有BusinessChinmedichenacareSupport
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessChinmedichenacareSupport> findAll() throws ServiceException {
		List<BusinessChinmedichenacareSupport> list = new ArrayList<BusinessChinmedichenacareSupport>() ;
		try {
			list=businessChinmedichenacareSupportDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareSupportServiceImpl findAll()：无条件查询所有BusinessChinmedichenacareSupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacareSupport
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessChinmedichenacareSupport> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessChinmedichenacareSupport> list = new ArrayList<BusinessChinmedichenacareSupport>() ;
		try {
			list=businessChinmedichenacareSupportDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareSupportServiceImpl findByMap()：按Map对象条件查询所有BusinessChinmedichenacareSupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacareSupport-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessChinmedichenacareSupport> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessChinmedichenacareSupport> list = new ArrayList<BusinessChinmedichenacareSupport>() ;
		try {
			list=businessChinmedichenacareSupportDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareSupportServiceImpl findByMap()：按Map对象条件查询所有BusinessChinmedichenacareSupport-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacareSupport
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessChinmedichenacareSupport> findByExample(final BusinessChinmedichenacareSupportQuery query) throws ServiceException {
		List<BusinessChinmedichenacareSupport> list = new ArrayList<BusinessChinmedichenacareSupport>() ;
		try {
			list=businessChinmedichenacareSupportDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareSupportServiceImpl findByExample()：按VO对象条件查询所有BusinessChinmedichenacareSupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacareSupport-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessChinmedichenacareSupport> findByExample(final BusinessChinmedichenacareSupportQuery query, final Integer limit) throws ServiceException {
		List<BusinessChinmedichenacareSupport> list = new ArrayList<BusinessChinmedichenacareSupport>() ;
		try {
			list=businessChinmedichenacareSupportDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareSupportServiceImpl findByExample()：按VO对象条件查询所有BusinessChinmedichenacareSupport-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessChinmedichenacareSupportQuery query) throws ServiceException {
		List<BusinessChinmedichenacareSupport> list = new ArrayList<BusinessChinmedichenacareSupport>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessChinmedichenacareSupportDao.findAllPage(query);
			count=businessChinmedichenacareSupportDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareSupportServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessChinmedichenacareSupportQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessChinmedichenacareSupportDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareSupportServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessChinmedichenacareSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessChinmedichenacareSupport entity) throws ServiceException {
		try {
			businessChinmedichenacareSupportDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareSupportServiceImpl save()：保存BusinessChinmedichenacareSupport发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessChinmedichenacareSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessChinmedichenacareSupport entity) throws ServiceException {
		try {
			businessChinmedichenacareSupportDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareSupportServiceImpl update()：修改BusinessChinmedichenacareSupport发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessChinmedichenacareSupport
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessChinmedichenacareSupportDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareSupportServiceImpl delete()：删除BusinessChinmedichenacareSupport发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
