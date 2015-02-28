package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessChargeAnno;
import com.community.app.module.dao.BusinessChargeAnnoDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessChargeAnnoQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessChargeAnnoService")
@Transactional
public class BusinessChargeAnnoServiceImpl implements BusinessChargeAnnoService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessChargeAnnoServiceImpl.class);
	@Autowired
	private BusinessChargeAnnoDao businessChargeAnnoDao;

	/**
	 * 查询单个BusinessChargeAnno
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessChargeAnno findById(final Integer id) throws ServiceException {
		BusinessChargeAnno businessChargeAnno = new BusinessChargeAnno();
		try {
			businessChargeAnno = businessChargeAnnoDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessChargeAnnoServiceImpl findById()：查询单个BusinessChargeAnno发生错误！", e);
			e.printStackTrace();
		}
		return businessChargeAnno;
	}
	
	/**
	 * 无条件查询所有BusinessChargeAnno
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessChargeAnno> findAll() throws ServiceException {
		List<BusinessChargeAnno> list = new ArrayList<BusinessChargeAnno>() ;
		try {
			list=businessChargeAnnoDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessChargeAnnoServiceImpl findAll()：无条件查询所有BusinessChargeAnno发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessChargeAnno
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessChargeAnno> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessChargeAnno> list = new ArrayList<BusinessChargeAnno>() ;
		try {
			list=businessChargeAnnoDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessChargeAnnoServiceImpl findByMap()：按Map对象条件查询所有BusinessChargeAnno发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessChargeAnno-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessChargeAnno> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessChargeAnno> list = new ArrayList<BusinessChargeAnno>() ;
		try {
			list=businessChargeAnnoDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessChargeAnnoServiceImpl findByMap()：按Map对象条件查询所有BusinessChargeAnno-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessChargeAnno
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessChargeAnno> findByExample(final BusinessChargeAnnoQuery query) throws ServiceException {
		List<BusinessChargeAnno> list = new ArrayList<BusinessChargeAnno>() ;
		try {
			list=businessChargeAnnoDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessChargeAnnoServiceImpl findByExample()：按VO对象条件查询所有BusinessChargeAnno发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessChargeAnno-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessChargeAnno> findByExample(final BusinessChargeAnnoQuery query, final Integer limit) throws ServiceException {
		List<BusinessChargeAnno> list = new ArrayList<BusinessChargeAnno>() ;
		try {
			list=businessChargeAnnoDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessChargeAnnoServiceImpl findByExample()：按VO对象条件查询所有BusinessChargeAnno-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessChargeAnnoQuery query) throws ServiceException {
		List<BusinessChargeAnno> list = new ArrayList<BusinessChargeAnno>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessChargeAnnoDao.selectCount(query);
			query.setCount(count);
			list=businessChargeAnnoDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessChargeAnnoServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessChargeAnnoQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessChargeAnnoDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessChargeAnnoServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessChargeAnno数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessChargeAnno entity) throws ServiceException {
		try {
			businessChargeAnnoDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessChargeAnnoServiceImpl save()：保存BusinessChargeAnno发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessChargeAnno数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessChargeAnno entity) throws ServiceException {
		try {
			businessChargeAnnoDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessChargeAnnoServiceImpl update()：修改BusinessChargeAnno发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessChargeAnno
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessChargeAnnoDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessChargeAnnoServiceImpl delete()：删除BusinessChargeAnno发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
