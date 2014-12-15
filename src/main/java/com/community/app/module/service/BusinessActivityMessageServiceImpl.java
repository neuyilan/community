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

import com.community.app.module.vo.BusinessActivityMessageQuery;
import com.community.app.module.bean.BusinessActivityMessage;
import com.community.app.module.dao.BusinessActivityMessageDao;

@Service("BusinessActivityMessageService")
@Transactional
public class BusinessActivityMessageServiceImpl implements BusinessActivityMessageService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessActivityMessageServiceImpl.class);
	@Autowired
	private BusinessActivityMessageDao businessActivityMessageDao;

	/**
	 * 查询单个BusinessActivityMessage
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessActivityMessage findById(final Integer id) throws ServiceException {
		BusinessActivityMessage businessActivityMessage = new BusinessActivityMessage();
		try {
			businessActivityMessage = businessActivityMessageDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessageServiceImpl findById()：查询单个BusinessActivityMessage发生错误！", e);
			e.printStackTrace();
		}
		return businessActivityMessage;
	}
	
	/**
	 * 无条件查询所有BusinessActivityMessage
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessActivityMessage> findAll() throws ServiceException {
		List<BusinessActivityMessage> list = new ArrayList<BusinessActivityMessage>() ;
		try {
			list=businessActivityMessageDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessageServiceImpl findAll()：无条件查询所有BusinessActivityMessage发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityMessage
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityMessage> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessActivityMessage> list = new ArrayList<BusinessActivityMessage>() ;
		try {
			list=businessActivityMessageDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessageServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityMessage发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityMessage-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityMessage> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessActivityMessage> list = new ArrayList<BusinessActivityMessage>() ;
		try {
			list=businessActivityMessageDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessageServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityMessage-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityMessage
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityMessage> findByExample(final BusinessActivityMessageQuery query) throws ServiceException {
		List<BusinessActivityMessage> list = new ArrayList<BusinessActivityMessage>() ;
		try {
			list=businessActivityMessageDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessageServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityMessage发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityMessage-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityMessage> findByExample(final BusinessActivityMessageQuery query, final Integer limit) throws ServiceException {
		List<BusinessActivityMessage> list = new ArrayList<BusinessActivityMessage>() ;
		try {
			list=businessActivityMessageDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessageServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityMessage-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessActivityMessageQuery query) throws ServiceException {
		List<BusinessActivityMessage> list = new ArrayList<BusinessActivityMessage>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessActivityMessageDao.findAllPage(query);
			count=businessActivityMessageDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessageServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessActivityMessageQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessActivityMessageDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessageServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessActivityMessage数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessActivityMessage entity) throws ServiceException {
		try {
			businessActivityMessageDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessageServiceImpl save()：保存BusinessActivityMessage发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessActivityMessage数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessActivityMessage entity) throws ServiceException {
		try {
			businessActivityMessageDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessageServiceImpl update()：修改BusinessActivityMessage发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessActivityMessage
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessActivityMessageDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityMessageServiceImpl delete()：删除BusinessActivityMessage发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
