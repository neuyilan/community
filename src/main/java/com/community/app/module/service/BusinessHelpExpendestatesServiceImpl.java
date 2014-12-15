package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessHelpExpendestates;
import com.community.app.module.dao.BusinessHelpExpendestatesDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHelpExpendestatesQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessHelpExpendestatesService")
@Transactional
public class BusinessHelpExpendestatesServiceImpl implements BusinessHelpExpendestatesService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessHelpExpendestatesServiceImpl.class);
	@Autowired
	private BusinessHelpExpendestatesDao businessHelpExpendestatesDao;

	/**
	 * 查询单个BusinessHelpExpendestates
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessHelpExpendestates findById(final Integer id) throws ServiceException {
		BusinessHelpExpendestates businessHelpExpendestates = new BusinessHelpExpendestates();
		try {
			businessHelpExpendestates = businessHelpExpendestatesDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessHelpExpendestatesServiceImpl findById()：查询单个BusinessHelpExpendestates发生错误！", e);
			e.printStackTrace();
		}
		return businessHelpExpendestates;
	}
	
	/**
	 * 无条件查询所有BusinessHelpExpendestates
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessHelpExpendestates> findAll() throws ServiceException {
		List<BusinessHelpExpendestates> list = new ArrayList<BusinessHelpExpendestates>() ;
		try {
			list=businessHelpExpendestatesDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessHelpExpendestatesServiceImpl findAll()：无条件查询所有BusinessHelpExpendestates发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpExpendestates
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelpExpendestates> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessHelpExpendestates> list = new ArrayList<BusinessHelpExpendestates>() ;
		try {
			list=businessHelpExpendestatesDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessHelpExpendestatesServiceImpl findByMap()：按Map对象条件查询所有BusinessHelpExpendestates发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpExpendestates-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessHelpExpendestates> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessHelpExpendestates> list = new ArrayList<BusinessHelpExpendestates>() ;
		try {
			list=businessHelpExpendestatesDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHelpExpendestatesServiceImpl findByMap()：按Map对象条件查询所有BusinessHelpExpendestates-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessHelpExpendestates
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelpExpendestates> findByExample(final BusinessHelpExpendestatesQuery query) throws ServiceException {
		List<BusinessHelpExpendestates> list = new ArrayList<BusinessHelpExpendestates>() ;
		try {
			list=businessHelpExpendestatesDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpExpendestatesServiceImpl findByExample()：按VO对象条件查询所有BusinessHelpExpendestates发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelpExpendestates-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessHelpExpendestates> findByExample(final BusinessHelpExpendestatesQuery query, final Integer limit) throws ServiceException {
		List<BusinessHelpExpendestates> list = new ArrayList<BusinessHelpExpendestates>() ;
		try {
			list=businessHelpExpendestatesDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHelpExpendestatesServiceImpl findByExample()：按VO对象条件查询所有BusinessHelpExpendestates-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessHelpExpendestatesQuery query) throws ServiceException {
		List<BusinessHelpExpendestates> list = new ArrayList<BusinessHelpExpendestates>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessHelpExpendestatesDao.findAllPage(query);
			count=businessHelpExpendestatesDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpExpendestatesServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessHelpExpendestatesQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessHelpExpendestatesDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpExpendestatesServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessHelpExpendestates数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessHelpExpendestates entity) throws ServiceException {
		try {
			businessHelpExpendestatesDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHelpExpendestatesServiceImpl save()：保存BusinessHelpExpendestates发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessHelpExpendestates数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessHelpExpendestates entity) throws ServiceException {
		try {
			businessHelpExpendestatesDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHelpExpendestatesServiceImpl update()：修改BusinessHelpExpendestates发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessHelpExpendestates
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessHelpExpendestatesDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessHelpExpendestatesServiceImpl delete()：删除BusinessHelpExpendestates发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
