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

import com.community.app.module.vo.BusinessCommunityQuery;
import com.community.app.module.bean.BusinessCommunity;
import com.community.app.module.dao.BusinessCommunityDao;

@Service("BusinessCommunityService")
@Transactional
public class BusinessCommunityServiceImpl implements BusinessCommunityService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessCommunityServiceImpl.class);
	@Autowired
	private BusinessCommunityDao businessCommunityDao;

	/**
	 * 查询单个BusinessCommunity
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessCommunity findById(final Integer id) throws ServiceException {
		BusinessCommunity businessCommunity = new BusinessCommunity();
		try {
			businessCommunity = businessCommunityDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl findById()：查询单个BusinessCommunity发生错误！", e);
			e.printStackTrace();
		}
		return businessCommunity;
	}
	
	/**
	 * 查询comId社区下的所有小区
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessCommunity> findByComId(final Integer id) throws ServiceException {
		List<BusinessCommunity> list = null;
		try {
			list = businessCommunityDao.findByComId(id);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl findById()：查询单个BusinessCommunity发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 无条件查询所有BusinessCommunity
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessCommunity> findAll() throws ServiceException {
		List<BusinessCommunity> list = new ArrayList<BusinessCommunity>() ;
		try {
			list=businessCommunityDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl findAll()：无条件查询所有BusinessCommunity发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessCommunity
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessCommunity> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessCommunity> list = new ArrayList<BusinessCommunity>() ;
		try {
			list=businessCommunityDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl findByMap()：按Map对象条件查询所有BusinessCommunity发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessCommunity-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessCommunity> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessCommunity> list = new ArrayList<BusinessCommunity>() ;
		try {
			list=businessCommunityDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl findByMap()：按Map对象条件查询所有BusinessCommunity-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessCommunity
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessCommunity> findByExample(final BusinessCommunityQuery query) throws ServiceException {
		List<BusinessCommunity> list = new ArrayList<BusinessCommunity>() ;
		try {
			list=businessCommunityDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl findByExample()：按VO对象条件查询所有BusinessCommunity发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessCommunity-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessCommunity> findByExample(final BusinessCommunityQuery query, final Integer limit) throws ServiceException {
		List<BusinessCommunity> list = new ArrayList<BusinessCommunity>() ;
		try {
			list=businessCommunityDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl findByExample()：按VO对象条件查询所有BusinessCommunity-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessCommunityQuery query) throws ServiceException {
		List<BusinessCommunity> list = new ArrayList<BusinessCommunity>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessCommunityDao.findAllPage(query);
			count=businessCommunityDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessCommunityQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessCommunityDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessCommunity数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessCommunity entity) throws ServiceException {
		try {
			businessCommunityDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl save()：保存BusinessCommunity发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessCommunity数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessCommunity entity) throws ServiceException {
		try {
			businessCommunityDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl update()：修改BusinessCommunity发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessCommunity
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessCommunityDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl delete()：删除BusinessCommunity发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 获取用户负责的社区
	 * @param userId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessCommunity> findComsByUser(final Integer userId) throws ServiceException {
		List<BusinessCommunity> list = new ArrayList<BusinessCommunity>() ;
		try {
			list=businessCommunityDao.findComsByUser(userId);
		} catch (DaoException e) {
			logger.debug("BusinessCommunityServiceImpl findComsByUser()：获取用户负责的社区！", e);
			e.printStackTrace();
		}
		return list;
	}
	
}
