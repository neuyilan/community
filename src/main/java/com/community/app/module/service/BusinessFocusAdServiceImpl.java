package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessFocusAd;
import com.community.app.module.common.ModuleConst;
import com.community.app.module.dao.BusinessFocusAdDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFocusAdQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.framework.utils.CommonUtils;

@Service("BusinessFocusAdService")
@Transactional
public class BusinessFocusAdServiceImpl implements BusinessFocusAdService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessFocusAdServiceImpl.class);
	@Autowired
	private BusinessFocusAdDao businessFocusAdDao;

	/**
	 * 查询单个BusinessFocusAd
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessFocusAd findById(final Integer id) throws ServiceException {
		BusinessFocusAd businessFocusAd = new BusinessFocusAd();
		try {
			businessFocusAd = businessFocusAdDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessFocusAdServiceImpl findById()：查询单个BusinessFocusAd发生错误！", e);
			e.printStackTrace();
		}
		return businessFocusAd;
	}
	
	/**
	 * 查询单个BusinessFocus
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessFocusAd> findById_app(final Integer id) throws ServiceException {
		List<BusinessFocusAd> list = new ArrayList<BusinessFocusAd>();
		try {
			list = businessFocusAdDao.findById_app(id);
		} catch (DaoException e) {
			logger.debug("BusinessFocusAdServiceImpl findById_app()：查询单个BusinessFocusAd发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 无条件查询所有BusinessFocusAd
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessFocusAd> findAll() throws ServiceException {
		List<BusinessFocusAd> list = new ArrayList<BusinessFocusAd>() ;
		try {
			list=businessFocusAdDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessFocusAdServiceImpl findAll()：无条件查询所有BusinessFocusAd发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFocusAd
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFocusAd> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessFocusAd> list = new ArrayList<BusinessFocusAd>() ;
		try {
			list=businessFocusAdDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessFocusAdServiceImpl findByMap()：按Map对象条件查询所有BusinessFocusAd发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFocusAd-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessFocusAd> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessFocusAd> list = new ArrayList<BusinessFocusAd>() ;
		try {
			list=businessFocusAdDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFocusAdServiceImpl findByMap()：按Map对象条件查询所有BusinessFocusAd-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessFocusAd
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFocusAd> findByExample(final BusinessFocusAdQuery query) throws ServiceException {
		List<BusinessFocusAd> list = new ArrayList<BusinessFocusAd>() ;
		try {
			list=businessFocusAdDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessFocusAdServiceImpl findByExample()：按VO对象条件查询所有BusinessFocusAd发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFocusAd-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessFocusAd> findByExample(final BusinessFocusAdQuery query, final Integer limit) throws ServiceException {
		List<BusinessFocusAd> list = new ArrayList<BusinessFocusAd>() ;
		try {
			list=businessFocusAdDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFocusAdServiceImpl findByExample()：按VO对象条件查询所有BusinessFocusAd-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessFocusAdQuery query) throws ServiceException {
		List<BusinessFocusAd> list = new ArrayList<BusinessFocusAd>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessFocusAdDao.selectCount(query);
			query.setCount(count);
			list=businessFocusAdDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessFocusAdServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessFocusAdQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessFocusAdDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessFocusAdServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessFocusAd数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessFocusAd entity) throws ServiceException {
		try {
			businessFocusAdDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFocusAdServiceImpl save()：保存BusinessFocusAd发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessFocusAd数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessFocusAd entity) throws ServiceException {
		try {
			businessFocusAdDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFocusAdServiceImpl update()：修改BusinessFocusAd发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessFocusAd
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessFocusAdDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessFocusAdServiceImpl delete()：删除BusinessFocusAd发生错误！", e);
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
	public void updateVisits(BusinessFocusAd entity) throws ServiceException {
		try {
			businessFocusAdDao.updateVisits(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFocusServiceImpl updateVisits()：修改BusinessFocusAd浏览量发生错误！", e);
			e.printStackTrace();
		}
	}
}