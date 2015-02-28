package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessTypeProperty;
import com.community.app.module.dao.BusinessTypePropertyDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessTypePropertyQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessTypePropertyService")
@Transactional
public class BusinessTypePropertyServiceImpl implements BusinessTypePropertyService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessTypePropertyServiceImpl.class);
	@Autowired
	private BusinessTypePropertyDao businessTypePropertyDao;

	/**
	 * 查询单个BusinessTypeProperty
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessTypeProperty findById(final Integer id) throws ServiceException {
		BusinessTypeProperty businessTypeProperty = new BusinessTypeProperty();
		try {
			businessTypeProperty = businessTypePropertyDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessTypePropertyServiceImpl findById()：查询单个BusinessTypeProperty发生错误！", e);
			e.printStackTrace();
		}
		return businessTypeProperty;
	}
	
	/**
	 * 无条件查询所有BusinessTypeProperty
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessTypeProperty> findAll() throws ServiceException {
		List<BusinessTypeProperty> list = new ArrayList<BusinessTypeProperty>() ;
		try {
			list=businessTypePropertyDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessTypePropertyServiceImpl findAll()：无条件查询所有BusinessTypeProperty发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessTypeProperty
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessTypeProperty> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessTypeProperty> list = new ArrayList<BusinessTypeProperty>() ;
		try {
			list=businessTypePropertyDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessTypePropertyServiceImpl findByMap()：按Map对象条件查询所有BusinessTypeProperty发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessTypeProperty-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessTypeProperty> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessTypeProperty> list = new ArrayList<BusinessTypeProperty>() ;
		try {
			list=businessTypePropertyDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessTypePropertyServiceImpl findByMap()：按Map对象条件查询所有BusinessTypeProperty-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessTypeProperty
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessTypeProperty> findByExample(final BusinessTypePropertyQuery query) throws ServiceException {
		List<BusinessTypeProperty> list = new ArrayList<BusinessTypeProperty>() ;
		try {
			list=businessTypePropertyDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessTypePropertyServiceImpl findByExample()：按VO对象条件查询所有BusinessTypeProperty发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessTypeProperty-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessTypeProperty> findByExample(final BusinessTypePropertyQuery query, final Integer limit) throws ServiceException {
		List<BusinessTypeProperty> list = new ArrayList<BusinessTypeProperty>() ;
		try {
			list=businessTypePropertyDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessTypePropertyServiceImpl findByExample()：按VO对象条件查询所有BusinessTypeProperty-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessTypePropertyQuery query) throws ServiceException {
		List<BusinessTypeProperty> list = new ArrayList<BusinessTypeProperty>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessTypePropertyDao.findAllPage(query);
			count=businessTypePropertyDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessTypePropertyServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessTypePropertyQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessTypePropertyDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessTypePropertyServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessTypeProperty数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessTypeProperty entity) throws ServiceException {
		try {
			businessTypePropertyDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessTypePropertyServiceImpl save()：保存BusinessTypeProperty发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessTypeProperty数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessTypeProperty entity) throws ServiceException {
		try {
			businessTypePropertyDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessTypePropertyServiceImpl update()：修改BusinessTypeProperty发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessTypeProperty
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessTypePropertyDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessTypePropertyServiceImpl delete()：删除BusinessTypeProperty发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
