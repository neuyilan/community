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

import com.community.app.module.vo.BusinessHelpReplayQuery;
import com.community.app.module.bean.BusinessHelpReplay;
import com.community.app.module.dao.BusinessHelpReplayDao;

@Service("BusinessHelpReplayService")
@Transactional
public class BusinessHelpReplayServiceImpl implements BusinessHelpReplayService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessHelpReplayServiceImpl.class);
	@Autowired
	private BusinessHelpReplayDao businessHelpReplayDao;

	/**
	 * 查询单个BusinessHelpReplay
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessHelpReplay findById(final Integer id) throws ServiceException {
		BusinessHelpReplay businessHelpReplay = new BusinessHelpReplay();
		try {
			businessHelpReplay = businessHelpReplayDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessHelpReplayServiceImpl findById()：查询单个BusinessHelpReplay发生错误！", e);
			e.printStackTrace();
		}
		return businessHelpReplay;
	}
	
	/**
	 * 无条件查询所有BusinessHelpReplay
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessHelpReplay> findAll() throws ServiceException {
		List<BusinessHelpReplay> list = new ArrayList<BusinessHelpReplay>() ;
		try {
			list=businessHelpReplayDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessHelpReplayServiceImpl findAll()：无条件查询所有BusinessHelpReplay发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpReplay
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelpReplay> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessHelpReplay> list = new ArrayList<BusinessHelpReplay>() ;
		try {
			list=businessHelpReplayDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessHelpReplayServiceImpl findByMap()：按Map对象条件查询所有BusinessHelpReplay发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpReplay-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessHelpReplay> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessHelpReplay> list = new ArrayList<BusinessHelpReplay>() ;
		try {
			list=businessHelpReplayDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHelpReplayServiceImpl findByMap()：按Map对象条件查询所有BusinessHelpReplay-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessHelpReplay
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelpReplay> findByExample(final BusinessHelpReplayQuery query) throws ServiceException {
		List<BusinessHelpReplay> list = new ArrayList<BusinessHelpReplay>() ;
		try {
			list=businessHelpReplayDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpReplayServiceImpl findByExample()：按VO对象条件查询所有BusinessHelpReplay发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelpReplay-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessHelpReplay> findByExample(final BusinessHelpReplayQuery query, final Integer limit) throws ServiceException {
		List<BusinessHelpReplay> list = new ArrayList<BusinessHelpReplay>() ;
		try {
			list=businessHelpReplayDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHelpReplayServiceImpl findByExample()：按VO对象条件查询所有BusinessHelpReplay-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessHelpReplayQuery query) throws ServiceException {
		List<BusinessHelpReplay> list = new ArrayList<BusinessHelpReplay>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessHelpReplayDao.findAllPage(query);
			count=businessHelpReplayDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpReplayServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessHelpReplayQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessHelpReplayDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpReplayServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessHelpReplay数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessHelpReplay entity) throws ServiceException {
		try {
			businessHelpReplayDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHelpReplayServiceImpl save()：保存BusinessHelpReplay发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessHelpReplay数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessHelpReplay entity) throws ServiceException {
		try {
			businessHelpReplayDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHelpReplayServiceImpl update()：修改BusinessHelpReplay发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessHelpReplay
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessHelpReplayDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessHelpReplayServiceImpl delete()：删除BusinessHelpReplay发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
