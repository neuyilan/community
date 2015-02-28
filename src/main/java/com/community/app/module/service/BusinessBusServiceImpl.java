package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessBus;
import com.community.app.module.dao.BusinessBusDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessBusQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessBusService")
@Transactional
public class BusinessBusServiceImpl implements BusinessBusService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessBusServiceImpl.class);
	@Autowired
	private BusinessBusDao businessBusDao;
	

	/**
	 * 查询单个BusinessBus
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessBus findById(final Integer id) throws ServiceException {
		BusinessBus businessBus = new BusinessBus();
		try {
			businessBus = businessBusDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessBusServiceImpl findById()：查询单个BusinessBus发生错误！", e);
			e.printStackTrace();
		}
		return businessBus;
	}
	/**
	 * 查询线路的所有站点
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBusQuery> busLineDetails(final Integer id) throws ServiceException {
		List<BusinessBusQuery> list = new ArrayList<BusinessBusQuery>() ;
		try {
			list=businessBusDao.busLineDetails(id);
		} catch (DaoException e) {
			logger.debug("BusinessBusServiceImpl busLineDetails()：查询线路的所有站点发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 无条件查询所有BusinessBus
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessBus> findAll() throws ServiceException {
		List<BusinessBus> list = new ArrayList<BusinessBus>() ;
		try {
			list=businessBusDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessBusServiceImpl findAll()：无条件查询所有BusinessBus发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBus
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessBus> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessBus> list = new ArrayList<BusinessBus>() ;
		try {
			list=businessBusDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessBusServiceImpl findByMap()：按Map对象条件查询所有BusinessBus发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBus-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessBus> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessBus> list = new ArrayList<BusinessBus>() ;
		try {
			list=businessBusDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessBusServiceImpl findByMap()：按Map对象条件查询所有BusinessBus-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBus
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessBus> findByExample(final BusinessBusQuery query) throws ServiceException {
		List<BusinessBus> list = new ArrayList<BusinessBus>() ;
		try {
			list=businessBusDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessBusServiceImpl findByExample()：按VO对象条件查询所有BusinessBus发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBus-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessBus> findByExample(final BusinessBusQuery query, final Integer limit) throws ServiceException {
		List<BusinessBus> list = new ArrayList<BusinessBus>() ;
		try {
			list=businessBusDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessBusServiceImpl findByExample()：按VO对象条件查询所有BusinessBus-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessBusQuery query) throws ServiceException {
		List<BusinessBus> list = new ArrayList<BusinessBus>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessBusDao.findAllPage(query);
			count=businessBusDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessBusServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessBusQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessBusDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessBusServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessBus数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessBus entity) throws ServiceException {
		try {
			businessBusDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessBusServiceImpl save()：保存BusinessBus发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessBus数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessBus entity) throws ServiceException {
		try {
			businessBusDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessBusServiceImpl update()：修改BusinessBus发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessBus
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessBusDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessBusServiceImpl delete()：删除BusinessBus发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
