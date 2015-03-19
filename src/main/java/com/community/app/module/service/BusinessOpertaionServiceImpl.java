package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessOpertaion;
import com.community.app.module.dao.BusinessOpertaionDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessOpertaionQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessOpertaionService")
@Transactional
public class BusinessOpertaionServiceImpl implements BusinessOpertaionService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessOpertaionServiceImpl.class);
	@Autowired
	private BusinessOpertaionDao businessOpertaionDao;

	/**
	 * 查询单个BusinessOpertaion
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessOpertaion findById(final Integer id) throws ServiceException {
		BusinessOpertaion businessOpertaion = new BusinessOpertaion();
		try {
			businessOpertaion = businessOpertaionDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessOpertaionServiceImpl findById()：查询单个BusinessOpertaion发生错误！", e);
			e.printStackTrace();
		}
		return businessOpertaion;
	}
	
	/**
	 * 无条件查询所有BusinessOpertaion
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessOpertaion> findAll() throws ServiceException {
		List<BusinessOpertaion> list = new ArrayList<BusinessOpertaion>() ;
		try {
			list=businessOpertaionDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessOpertaionServiceImpl findAll()：无条件查询所有BusinessOpertaion发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessOpertaion
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessOpertaion> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessOpertaion> list = new ArrayList<BusinessOpertaion>() ;
		try {
			list=businessOpertaionDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessOpertaionServiceImpl findByMap()：按Map对象条件查询所有BusinessOpertaion发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessOpertaion-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessOpertaion> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessOpertaion> list = new ArrayList<BusinessOpertaion>() ;
		try {
			list=businessOpertaionDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessOpertaionServiceImpl findByMap()：按Map对象条件查询所有BusinessOpertaion-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessOpertaion
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessOpertaion> findByExample(final BusinessOpertaionQuery query) throws ServiceException {
		List<BusinessOpertaion> list = new ArrayList<BusinessOpertaion>() ;
		try {
			list=businessOpertaionDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessOpertaionServiceImpl findByExample()：按VO对象条件查询所有BusinessOpertaion发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessOpertaion-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessOpertaion> findByExample(final BusinessOpertaionQuery query, final Integer limit) throws ServiceException {
		List<BusinessOpertaion> list = new ArrayList<BusinessOpertaion>() ;
		try {
			list=businessOpertaionDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessOpertaionServiceImpl findByExample()：按VO对象条件查询所有BusinessOpertaion-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessOpertaionQuery query) throws ServiceException {
		List<BusinessOpertaion> list = new ArrayList<BusinessOpertaion>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessOpertaionDao.findAllPage(query);
			count=businessOpertaionDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessOpertaionServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessOpertaionQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessOpertaionDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessOpertaionServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessOpertaion数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessOpertaion entity) throws ServiceException {
		try {
			businessOpertaionDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessOpertaionServiceImpl save()：保存BusinessOpertaion发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessOpertaion数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessOpertaion entity) throws ServiceException {
		try {
			businessOpertaionDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessOpertaionServiceImpl update()：修改BusinessOpertaion发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessOpertaion
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessOpertaionDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessOpertaionServiceImpl delete()：删除BusinessOpertaion发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
}