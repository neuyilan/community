package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessProperty;
import com.community.app.module.dao.BusinessPropertyDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessPropertyQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessPropertyService")
@Transactional
public class BusinessPropertyServiceImpl implements BusinessPropertyService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessPropertyServiceImpl.class);
	@Autowired
	private BusinessPropertyDao businessPropertyDao;

	/**
	 * 查询单个BusinessProperty
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessProperty findById(final Integer id) throws ServiceException {
		BusinessProperty businessProperty = new BusinessProperty();
		try {
			businessProperty = businessPropertyDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyServiceImpl findById()：查询单个BusinessProperty发生错误！", e);
			e.printStackTrace();
		}
		return businessProperty;
	}
	
	/**
	 * 无条件查询所有BusinessProperty
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessProperty> findAll() throws ServiceException {
		List<BusinessProperty> list = new ArrayList<BusinessProperty>() ;
		try {
			list=businessPropertyDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessPropertyServiceImpl findAll()：无条件查询所有BusinessProperty发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProperty
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessProperty> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessProperty> list = new ArrayList<BusinessProperty>() ;
		try {
			list=businessPropertyDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyServiceImpl findByMap()：按Map对象条件查询所有BusinessProperty发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProperty-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessProperty> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessProperty> list = new ArrayList<BusinessProperty>() ;
		try {
			list=businessPropertyDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyServiceImpl findByMap()：按Map对象条件查询所有BusinessProperty-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessProperty
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessProperty> findByExample(final BusinessPropertyQuery query) throws ServiceException {
		List<BusinessProperty> list = new ArrayList<BusinessProperty>() ;
		try {
			list=businessPropertyDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyServiceImpl findByExample()：按VO对象条件查询所有BusinessProperty发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessProperty-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessProperty> findByExample(final BusinessPropertyQuery query, final Integer limit) throws ServiceException {
		List<BusinessProperty> list = new ArrayList<BusinessProperty>() ;
		try {
			list=businessPropertyDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyServiceImpl findByExample()：按VO对象条件查询所有BusinessProperty-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessPropertyQuery query) throws ServiceException {
		List<BusinessProperty> list = new ArrayList<BusinessProperty>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessPropertyDao.findAllPage(query);
			count=businessPropertyDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessPropertyQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessPropertyDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessProperty数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessProperty entity) throws ServiceException {
		try {
			businessPropertyDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyServiceImpl save()：保存BusinessProperty发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessProperty数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessProperty entity) throws ServiceException {
		try {
			businessPropertyDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyServiceImpl update()：修改BusinessProperty发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessProperty
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessPropertyDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyServiceImpl delete()：删除BusinessProperty发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
