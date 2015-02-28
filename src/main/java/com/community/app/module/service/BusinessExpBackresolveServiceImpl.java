package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessExpBackresolve;
import com.community.app.module.dao.BusinessExpBackresolveDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessExpBackresolveQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessExpBackresolveService")
@Transactional
public class BusinessExpBackresolveServiceImpl implements BusinessExpBackresolveService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessExpBackresolveServiceImpl.class);
	@Autowired
	private BusinessExpBackresolveDao businessExpBackresolveDao;

	/**
	 * 查询单个BusinessExpBackresolve
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessExpBackresolve findById(final Integer id) throws ServiceException {
		BusinessExpBackresolve businessExpBackresolve = new BusinessExpBackresolve();
		try {
			businessExpBackresolve = businessExpBackresolveDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessExpBackresolveServiceImpl findById()：查询单个BusinessExpBackresolve发生错误！", e);
			e.printStackTrace();
		}
		return businessExpBackresolve;
	}
	
	/**
	 * 无条件查询所有BusinessExpBackresolve
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessExpBackresolve> findAll() throws ServiceException {
		List<BusinessExpBackresolve> list = new ArrayList<BusinessExpBackresolve>() ;
		try {
			list=businessExpBackresolveDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessExpBackresolveServiceImpl findAll()：无条件查询所有BusinessExpBackresolve发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessExpBackresolve
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessExpBackresolve> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessExpBackresolve> list = new ArrayList<BusinessExpBackresolve>() ;
		try {
			list=businessExpBackresolveDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessExpBackresolveServiceImpl findByMap()：按Map对象条件查询所有BusinessExpBackresolve发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessExpBackresolve-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessExpBackresolve> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessExpBackresolve> list = new ArrayList<BusinessExpBackresolve>() ;
		try {
			list=businessExpBackresolveDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessExpBackresolveServiceImpl findByMap()：按Map对象条件查询所有BusinessExpBackresolve-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessExpBackresolve
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessExpBackresolve> findByExample(final BusinessExpBackresolveQuery query) throws ServiceException {
		List<BusinessExpBackresolve> list = new ArrayList<BusinessExpBackresolve>() ;
		try {
			list=businessExpBackresolveDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessExpBackresolveServiceImpl findByExample()：按VO对象条件查询所有BusinessExpBackresolve发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessExpBackresolve-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessExpBackresolve> findByExample(final BusinessExpBackresolveQuery query, final Integer limit) throws ServiceException {
		List<BusinessExpBackresolve> list = new ArrayList<BusinessExpBackresolve>() ;
		try {
			list=businessExpBackresolveDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessExpBackresolveServiceImpl findByExample()：按VO对象条件查询所有BusinessExpBackresolve-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessExpBackresolveQuery query) throws ServiceException {
		List<BusinessExpBackresolve> list = new ArrayList<BusinessExpBackresolve>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessExpBackresolveDao.findAllPage(query);
			count=businessExpBackresolveDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessExpBackresolveServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessExpBackresolveQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessExpBackresolveDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessExpBackresolveServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessExpBackresolve数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessExpBackresolve entity) throws ServiceException {
		try {
			businessExpBackresolveDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessExpBackresolveServiceImpl save()：保存BusinessExpBackresolve发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessExpBackresolve数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessExpBackresolve entity) throws ServiceException {
		try {
			businessExpBackresolveDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessExpBackresolveServiceImpl update()：修改BusinessExpBackresolve发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessExpBackresolve
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessExpBackresolveDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessExpBackresolveServiceImpl delete()：删除BusinessExpBackresolve发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
