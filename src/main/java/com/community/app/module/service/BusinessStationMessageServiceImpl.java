package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessStationMessage;
import com.community.app.module.dao.BusinessStationMessageDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessStationMessageQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessStationMessageService")
@Transactional
public class BusinessStationMessageServiceImpl implements BusinessStationMessageService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessStationMessageServiceImpl.class);
	@Autowired
	private BusinessStationMessageDao businessStationMessageDao;

	/**
	 * 查询单个BusinessStationMessage
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessStationMessage findById(final Integer id) throws ServiceException {
		BusinessStationMessage businessStationMessage = new BusinessStationMessage();
		try {
			businessStationMessage = businessStationMessageDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessStationMessageServiceImpl findById()：查询单个BusinessStationMessage发生错误！", e);
			e.printStackTrace();
		}
		return businessStationMessage;
	}
	
	/**
	 * 无条件查询所有BusinessStationMessage
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessStationMessage> findAll() throws ServiceException {
		List<BusinessStationMessage> list = new ArrayList<BusinessStationMessage>() ;
		try {
			list=businessStationMessageDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessStationMessageServiceImpl findAll()：无条件查询所有BusinessStationMessage发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessStationMessage
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessStationMessage> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessStationMessage> list = new ArrayList<BusinessStationMessage>() ;
		try {
			list=businessStationMessageDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessStationMessageServiceImpl findByMap()：按Map对象条件查询所有BusinessStationMessage发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessStationMessage-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessStationMessage> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessStationMessage> list = new ArrayList<BusinessStationMessage>() ;
		try {
			list=businessStationMessageDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessStationMessageServiceImpl findByMap()：按Map对象条件查询所有BusinessStationMessage-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessStationMessage
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessStationMessage> findByExample(final BusinessStationMessageQuery query) throws ServiceException {
		List<BusinessStationMessage> list = new ArrayList<BusinessStationMessage>() ;
		try {
			list=businessStationMessageDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessStationMessageServiceImpl findByExample()：按VO对象条件查询所有BusinessStationMessage发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessStationMessage-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessStationMessage> findByExample(final BusinessStationMessageQuery query, final Integer limit) throws ServiceException {
		List<BusinessStationMessage> list = new ArrayList<BusinessStationMessage>() ;
		try {
			list=businessStationMessageDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessStationMessageServiceImpl findByExample()：按VO对象条件查询所有BusinessStationMessage-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 查询单个BusinessStationMessage
	 * @param userId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessStationMessage> findByStationId(final Map<String, Object> paramMap) throws ServiceException {
		List<BusinessStationMessage> list = new ArrayList<BusinessStationMessage>() ;
		try {
			list = businessStationMessageDao.findByStationId(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessStationMessageServiceImpl findByStationId()：查询单个BusinessStationMessage发生错误！", e);
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
	public BaseBean findAllPage(final BusinessStationMessageQuery query) throws ServiceException {
		List<BusinessStationMessage> list = new ArrayList<BusinessStationMessage>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessStationMessageDao.selectCount(query);
			query.setCount(count);
			list=businessStationMessageDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessStationMessageServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setRows(query.getRows());
		baseBean.setPage(query.getPage());
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage_app(final BusinessStationMessageQuery query) throws ServiceException {
		List<BusinessStationMessage> list = new ArrayList<BusinessStationMessage>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessStationMessageDao.selectCount_app(query);
			query.setCount(count);
			list=businessStationMessageDao.findAllPage_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessStationMessageServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
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
	public int selectCount(final BusinessStationMessageQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessStationMessageDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessStationMessageServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessStationMessage数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessStationMessage entity) throws ServiceException {
		try {
			businessStationMessageDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessStationMessageServiceImpl save()：保存BusinessStationMessage发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessStationMessage数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessStationMessage entity) throws ServiceException {
		try {
			businessStationMessageDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessStationMessageServiceImpl update()：修改BusinessStationMessage发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessStationMessage
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessStationMessageDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessStationMessageServiceImpl delete()：删除BusinessStationMessage发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
}