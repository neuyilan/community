package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessBreakSelect;
import com.community.app.module.dao.BusinessBreakSelectDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessBreakSelectQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessBreakSelectService")
@Transactional
public class BusinessBreakSelectServiceImpl implements BusinessBreakSelectService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessBreakSelectServiceImpl.class);
	@Autowired
	private BusinessBreakSelectDao businessBreakSelectDao;

	/**
	 * 查询单个BusinessBreakSelect
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessBreakSelect findById(final Integer id) throws ServiceException {
		BusinessBreakSelect businessBreakSelect = new BusinessBreakSelect();
		try {
			businessBreakSelect = businessBreakSelectDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessBreakSelectServiceImpl findById()：查询单个BusinessBreakSelect发生错误！", e);
			e.printStackTrace();
		}
		return businessBreakSelect;
	}
	
	/**
	 * 根据爆料ID查询所有选用的爆料BusinessBreakSelect
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessBreakSelect>  findListByBreakId(final Integer id) throws ServiceException {
		BusinessBreakSelectQuery query = new BusinessBreakSelectQuery();
		List<BusinessBreakSelect> list = new ArrayList<BusinessBreakSelect>() ;
		query.setBreakId(id);
		query.setIsSelected(1);
		query.setOrder("desc");
		query.setSort("selectId");
		try {
			list = businessBreakSelectDao.findListByBreakId(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakSelectServiceImpl findListByBreakId()：根据爆料ID查询所有选用的爆料BusinessBreakSelect发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 无条件查询所有BusinessBreakSelect
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessBreakSelect> findAll() throws ServiceException {
		List<BusinessBreakSelect> list = new ArrayList<BusinessBreakSelect>() ;
		try {
			list=businessBreakSelectDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessBreakSelectServiceImpl findAll()：无条件查询所有BusinessBreakSelect发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBreakSelect
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessBreakSelect> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessBreakSelect> list = new ArrayList<BusinessBreakSelect>() ;
		try {
			list=businessBreakSelectDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessBreakSelectServiceImpl findByMap()：按Map对象条件查询所有BusinessBreakSelect发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBreakSelect-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessBreakSelect> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessBreakSelect> list = new ArrayList<BusinessBreakSelect>() ;
		try {
			list=businessBreakSelectDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessBreakSelectServiceImpl findByMap()：按Map对象条件查询所有BusinessBreakSelect-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessBreakSelect
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessBreakSelect> findByExample(final BusinessBreakSelectQuery query) throws ServiceException {
		List<BusinessBreakSelect> list = new ArrayList<BusinessBreakSelect>() ;
		try {
			list=businessBreakSelectDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakSelectServiceImpl findByExample()：按VO对象条件查询所有BusinessBreakSelect发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBreakSelect-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessBreakSelect> findByExample(final BusinessBreakSelectQuery query, final Integer limit) throws ServiceException {
		List<BusinessBreakSelect> list = new ArrayList<BusinessBreakSelect>() ;
		try {
			list=businessBreakSelectDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessBreakSelectServiceImpl findByExample()：按VO对象条件查询所有BusinessBreakSelect-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessBreakSelectQuery query) throws ServiceException {
		List<BusinessBreakSelect> list = new ArrayList<BusinessBreakSelect>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessBreakSelectDao.findAllPage(query);
			count=businessBreakSelectDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakSelectServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessBreakSelectQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessBreakSelectDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakSelectServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessBreakSelect数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessBreakSelect entity) throws ServiceException {
		try {
			businessBreakSelectDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessBreakSelectServiceImpl save()：保存BusinessBreakSelect发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessBreakSelect数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessBreakSelect entity) throws ServiceException {
		try {
			businessBreakSelectDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessBreakSelectServiceImpl update()：修改BusinessBreakSelect发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessBreakSelect
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessBreakSelectDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessBreakSelectServiceImpl delete()：删除BusinessBreakSelect发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
