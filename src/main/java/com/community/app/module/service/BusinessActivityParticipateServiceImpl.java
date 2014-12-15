package com.community.app.module.service;

import java.util.ArrayList;
import java.util.HashMap;
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

import com.community.app.module.vo.BusinessActivityParticipateQuery;
import com.community.app.module.bean.BusinessActivityParticipate;
import com.community.app.module.dao.BusinessActivityParticipateDao;

@Service("BusinessActivityParticipateService")
@Transactional
public class BusinessActivityParticipateServiceImpl implements BusinessActivityParticipateService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessActivityParticipateServiceImpl.class);
	@Autowired
	private BusinessActivityParticipateDao businessActivityParticipateDao;

	/**
	 * 查询单个BusinessActivityParticipate
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessActivityParticipate findById(final Integer id) throws ServiceException {
		BusinessActivityParticipate businessActivityParticipate = new BusinessActivityParticipate();
		try {
			businessActivityParticipate = businessActivityParticipateDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityParticipateServiceImpl findById()：查询单个BusinessActivityParticipate发生错误！", e);
			e.printStackTrace();
		}
		return businessActivityParticipate;
	}
	
	/**
	 * 无条件查询所有BusinessActivityParticipate
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessActivityParticipate> findAll() throws ServiceException {
		List<BusinessActivityParticipate> list = new ArrayList<BusinessActivityParticipate>() ;
		try {
			list=businessActivityParticipateDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessActivityParticipateServiceImpl findAll()：无条件查询所有BusinessActivityParticipate发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityParticipate
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityParticipate> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessActivityParticipate> list = new ArrayList<BusinessActivityParticipate>() ;
		try {
			list=businessActivityParticipateDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessActivityParticipateServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityParticipate发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityParticipate-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityParticipate> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessActivityParticipate> list = new ArrayList<BusinessActivityParticipate>() ;
		try {
			list=businessActivityParticipateDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityParticipateServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityParticipate-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityParticipate
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityParticipate> findByExample(final BusinessActivityParticipateQuery query) throws ServiceException {
		List<BusinessActivityParticipate> list = new ArrayList<BusinessActivityParticipate>() ;
		try {
			list=businessActivityParticipateDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityParticipateServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityParticipate发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * service
	 * 获取排名
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public Map<String,Object> ranking(final BusinessActivityParticipateQuery query) throws ServiceException {
		Map<String,Object> Map = new HashMap<String,Object>();
		try {
			Map=businessActivityParticipateDao.ranking(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityParticipateServiceImpl ranking()：获取排名发生错误！", e);
			e.printStackTrace();
		}
		return Map;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityParticipate-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityParticipate> findByExample(final BusinessActivityParticipateQuery query, final Integer limit) throws ServiceException {
		List<BusinessActivityParticipate> list = new ArrayList<BusinessActivityParticipate>() ;
		try {
			list=businessActivityParticipateDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityParticipateServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityParticipate-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessActivityParticipateQuery query) throws ServiceException {
		List<BusinessActivityParticipate> list = new ArrayList<BusinessActivityParticipate>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessActivityParticipateDao.selectCount(query);
			query.setCount(count);
			list=businessActivityParticipateDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityParticipateServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setRows(query.getRows());
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
	public int selectCount(final BusinessActivityParticipateQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessActivityParticipateDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityParticipateServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessActivityParticipate数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessActivityParticipate entity) throws ServiceException {
		try {
			businessActivityParticipateDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityParticipateServiceImpl save()：保存BusinessActivityParticipate发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessActivityParticipate数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessActivityParticipate entity) throws ServiceException {
		try {
			businessActivityParticipateDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityParticipateServiceImpl update()：修改BusinessActivityParticipate发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessActivityParticipate
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessActivityParticipateDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityParticipateServiceImpl delete()：删除BusinessActivityParticipate发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
