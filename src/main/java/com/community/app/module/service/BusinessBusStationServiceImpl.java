package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessBusStation;
import com.community.app.module.dao.BusinessBusStationDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessBusStationQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessBusStationService")
@Transactional
public class BusinessBusStationServiceImpl implements BusinessBusStationService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessBusStationServiceImpl.class);
	@Autowired
	private BusinessBusStationDao businessBusStationDao;

	/**
	 * 查询单个BusinessBusStation
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessBusStation findById(final Integer id) throws ServiceException {
		BusinessBusStation businessBusStation = new BusinessBusStation();
		try {
			businessBusStation = businessBusStationDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessBusStationServiceImpl findById()：查询单个BusinessBusStation发生错误！", e);
			e.printStackTrace();
		}
		return businessBusStation;
	}
	
	/**
	 * 根据id查询该站点下的线路
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBusStationQuery> findStaBus(final Integer id) throws ServiceException {
		List<BusinessBusStationQuery> list = new ArrayList<BusinessBusStationQuery>() ;
		try {
			list=businessBusStationDao.findStaBus(id);
		} catch (DaoException e) {
			logger.debug("BusinessBusStationServiceImpl findStaBus()：根据id查询该站点下的线路发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 无条件查询所有BusinessBusStation
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessBusStation> findAll() throws ServiceException {
		List<BusinessBusStation> list = new ArrayList<BusinessBusStation>() ;
		try {
			list=businessBusStationDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessBusStationServiceImpl findAll()：无条件查询所有BusinessBusStation发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBusStation
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessBusStation> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessBusStation> list = new ArrayList<BusinessBusStation>() ;
		try {
			list=businessBusStationDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessBusStationServiceImpl findByMap()：按Map对象条件查询所有BusinessBusStation发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBusStation-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessBusStation> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessBusStation> list = new ArrayList<BusinessBusStation>() ;
		try {
			list=businessBusStationDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessBusStationServiceImpl findByMap()：按Map对象条件查询所有BusinessBusStation-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBusStation
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessBusStation> findByExample(final BusinessBusStationQuery query) throws ServiceException {
		List<BusinessBusStation> list = new ArrayList<BusinessBusStation>() ;
		try {
			list=businessBusStationDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessBusStationServiceImpl findByExample()：按VO对象条件查询所有BusinessBusStation发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBusStation-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessBusStation> findByExample(final BusinessBusStationQuery query, final Integer limit) throws ServiceException {
		List<BusinessBusStation> list = new ArrayList<BusinessBusStation>() ;
		try {
			list=businessBusStationDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessBusStationServiceImpl findByExample()：按VO对象条件查询所有BusinessBusStation-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessBusStationQuery query) throws ServiceException {
		List<BusinessBusStation> list = new ArrayList<BusinessBusStation>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessBusStationDao.findAllPage(query);
			count=businessBusStationDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessBusStationServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessBusStationQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessBusStationDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessBusStationServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessBusStation数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessBusStation entity) throws ServiceException {
		try {
			businessBusStationDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessBusStationServiceImpl save()：保存BusinessBusStation发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessBusStation数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessBusStation entity) throws ServiceException {
		try {
			businessBusStationDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessBusStationServiceImpl update()：修改BusinessBusStation发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessBusStation
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessBusStationDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessBusStationServiceImpl delete()：删除BusinessBusStation发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
