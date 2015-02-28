package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessNewsSupport;
import com.community.app.module.dao.BusinessNewsSupportDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessNewsSupportQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessNewsSupportService")
@Transactional
public class BusinessNewsSupportServiceImpl implements BusinessNewsSupportService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessNewsSupportServiceImpl.class);
	@Autowired
	private BusinessNewsSupportDao businessNewsSupportDao;

	/**
	 * 查询单个BusinessNewsSupport
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessNewsSupport findById(final Integer id) throws ServiceException {
		BusinessNewsSupport businessNewsSupport = new BusinessNewsSupport();
		try {
			businessNewsSupport = businessNewsSupportDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessNewsSupportServiceImpl findById()：查询单个BusinessNewsSupport发生错误！", e);
			e.printStackTrace();
		}
		return businessNewsSupport;
	}
	
	/**
	 * 无条件查询所有BusinessNewsSupport
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessNewsSupport> findAll() throws ServiceException {
		List<BusinessNewsSupport> list = new ArrayList<BusinessNewsSupport>() ;
		try {
			list=businessNewsSupportDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessNewsSupportServiceImpl findAll()：无条件查询所有BusinessNewsSupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewsSupport
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNewsSupport> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessNewsSupport> list = new ArrayList<BusinessNewsSupport>() ;
		try {
			list=businessNewsSupportDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessNewsSupportServiceImpl findByMap()：按Map对象条件查询所有BusinessNewsSupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewsSupport-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNewsSupport> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessNewsSupport> list = new ArrayList<BusinessNewsSupport>() ;
		try {
			list=businessNewsSupportDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessNewsSupportServiceImpl findByMap()：按Map对象条件查询所有BusinessNewsSupport-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNewsSupport
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNewsSupport> findByExample(final BusinessNewsSupportQuery query) throws ServiceException {
		List<BusinessNewsSupport> list = new ArrayList<BusinessNewsSupport>() ;
		try {
			list=businessNewsSupportDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsSupportServiceImpl findByExample()：按VO对象条件查询所有BusinessNewsSupport发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNewsSupport-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNewsSupport> findByExample(final BusinessNewsSupportQuery query, final Integer limit) throws ServiceException {
		List<BusinessNewsSupport> list = new ArrayList<BusinessNewsSupport>() ;
		try {
			list=businessNewsSupportDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessNewsSupportServiceImpl findByExample()：按VO对象条件查询所有BusinessNewsSupport-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessNewsSupportQuery query) throws ServiceException {
		List<BusinessNewsSupport> list = new ArrayList<BusinessNewsSupport>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessNewsSupportDao.findAllPage(query);
			count=businessNewsSupportDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsSupportServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessNewsSupportQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessNewsSupportDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsSupportServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessNewsSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessNewsSupport entity) throws ServiceException {
		try {
			businessNewsSupportDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessNewsSupportServiceImpl save()：保存BusinessNewsSupport发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessNewsSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessNewsSupport entity) throws ServiceException {
		try {
			businessNewsSupportDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessNewsSupportServiceImpl update()：修改BusinessNewsSupport发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessNewsSupport
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessNewsSupportDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessNewsSupportServiceImpl delete()：删除BusinessNewsSupport发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
