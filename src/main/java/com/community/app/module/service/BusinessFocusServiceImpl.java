package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.framework.utils.CommonUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.vo.BusinessFocusQuery;
import com.community.app.module.bean.BusinessFocus;
import com.community.app.module.common.ModuleConst;
import com.community.app.module.dao.BusinessFocusDao;

@Service("BusinessFocusService")
@Transactional
public class BusinessFocusServiceImpl implements BusinessFocusService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessFocusServiceImpl.class);
	@Autowired
	private BusinessFocusDao businessFocusDao;

	/**
	 * 查询单个BusinessFocus
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessFocus findById(final Integer id) throws ServiceException {
		BusinessFocus businessFocus = new BusinessFocus();
		try {
			businessFocus = businessFocusDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessFocusServiceImpl findById()：查询单个BusinessFocus发生错误！", e);
			e.printStackTrace();
		}
		return businessFocus;
	}
	
	/**
	 * 查询单个BusinessFocus
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessFocus findById_app(final Integer id) throws ServiceException {
		BusinessFocus businessFocus = new BusinessFocus();
		try {
			businessFocus = businessFocusDao.findById_app(id);
		} catch (DaoException e) {
			logger.debug("BusinessFocusServiceImpl findById_app()：查询单个BusinessFocus发生错误！", e);
			e.printStackTrace();
		}
		return businessFocus;
	}
	
	/**
	 * 无条件查询所有BusinessFocus
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessFocus> findAll() throws ServiceException {
		List<BusinessFocus> list = new ArrayList<BusinessFocus>() ;
		try {
			list=businessFocusDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessFocusServiceImpl findAll()：无条件查询所有BusinessFocus发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFocus
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFocus> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessFocus> list = new ArrayList<BusinessFocus>() ;
		try {
			list=businessFocusDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessFocusServiceImpl findByMap()：按Map对象条件查询所有BusinessFocus发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFocus-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessFocus> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessFocus> list = new ArrayList<BusinessFocus>() ;
		try {
			list=businessFocusDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFocusServiceImpl findByMap()：按Map对象条件查询所有BusinessFocus-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessFocus
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFocus> findByExample(final BusinessFocusQuery query) throws ServiceException {
		List<BusinessFocus> list = new ArrayList<BusinessFocus>() ;
		try {
			list=businessFocusDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessFocusServiceImpl findByExample()：按VO对象条件查询所有BusinessFocus发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFocus-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessFocus> findByExample(final BusinessFocusQuery query, final Integer limit) throws ServiceException {
		List<BusinessFocus> list = new ArrayList<BusinessFocus>() ;
		try {
			list=businessFocusDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFocusServiceImpl findByExample()：按VO对象条件查询所有BusinessFocus-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessFocusQuery query) throws ServiceException {
		List<BusinessFocus> list = new ArrayList<BusinessFocus>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessFocusDao.selectCount(query);
			query.setCount(count);
			list=businessFocusDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessFocusServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setPage(query.getPage());
		if(CommonUtils.hasRole(ModuleConst.OPERATION_CODE)) {
			 baseBean.setRows(11);
		 } else {
			 baseBean.setRows(12);
		 }
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount(final BusinessFocusQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessFocusDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessFocusServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessFocus数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessFocus entity) throws ServiceException {
		try {
			businessFocusDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFocusServiceImpl save()：保存BusinessFocus发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessFocus数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessFocus entity) throws ServiceException {
		try {
			businessFocusDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFocusServiceImpl update()：修改BusinessFocus发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessFocus
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessFocusDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessFocusServiceImpl delete()：删除BusinessFocus发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * service
	 * 修改BusinessFocus浏览量
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void updateVisits(BusinessFocus entity) throws ServiceException {
		try {
			businessFocusDao.updateVisits(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFocusServiceImpl updateVisits()：修改BusinessFocus浏览量发生错误！", e);
			e.printStackTrace();
		}
	}
	
}
