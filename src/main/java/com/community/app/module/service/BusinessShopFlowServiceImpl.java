package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessShopFlow;
import com.community.app.module.dao.BusinessShopFlowDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessShopFlowQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessShopFlowService")
@Transactional
public class BusinessShopFlowServiceImpl implements BusinessShopFlowService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessShopFlowServiceImpl.class);
	@Autowired
	private BusinessShopFlowDao businessShopFlowDao;

	/**
	 * 查询单个BusinessShopFlow
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessShopFlow findById(final Integer id) throws ServiceException {
		BusinessShopFlow businessShopFlow = new BusinessShopFlow();
		try {
			businessShopFlow = businessShopFlowDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessShopFlowServiceImpl findById()：查询单个BusinessShopFlow发生错误！", e);
			e.printStackTrace();
		}
		return businessShopFlow;
	}
	
	/**
	 * 无条件查询所有BusinessShopFlow
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessShopFlow> findAll() throws ServiceException {
		List<BusinessShopFlow> list = new ArrayList<BusinessShopFlow>() ;
		try {
			list=businessShopFlowDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessShopFlowServiceImpl findAll()：无条件查询所有BusinessShopFlow发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessShopFlow
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessShopFlow> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessShopFlow> list = new ArrayList<BusinessShopFlow>() ;
		try {
			list=businessShopFlowDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessShopFlowServiceImpl findByMap()：按Map对象条件查询所有BusinessShopFlow发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessShopFlow-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessShopFlow> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessShopFlow> list = new ArrayList<BusinessShopFlow>() ;
		try {
			list=businessShopFlowDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessShopFlowServiceImpl findByMap()：按Map对象条件查询所有BusinessShopFlow-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessShopFlow
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessShopFlow> findByExample(final BusinessShopFlowQuery query) throws ServiceException {
		List<BusinessShopFlow> list = new ArrayList<BusinessShopFlow>() ;
		try {
			list=businessShopFlowDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessShopFlowServiceImpl findByExample()：按VO对象条件查询所有BusinessShopFlow发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessShopFlow-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessShopFlow> findByExample(final BusinessShopFlowQuery query, final Integer limit) throws ServiceException {
		List<BusinessShopFlow> list = new ArrayList<BusinessShopFlow>() ;
		try {
			list=businessShopFlowDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessShopFlowServiceImpl findByExample()：按VO对象条件查询所有BusinessShopFlow-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessShopFlowQuery query) throws ServiceException {
		List<BusinessShopFlow> list = new ArrayList<BusinessShopFlow>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessShopFlowDao.findAllPage(query);
			count=businessShopFlowDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessShopFlowServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessShopFlowQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessShopFlowDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessShopFlowServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessShopFlow数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessShopFlow entity) throws ServiceException {
		try {
			businessShopFlowDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessShopFlowServiceImpl save()：保存BusinessShopFlow发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessShopFlow数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessShopFlow entity) throws ServiceException {
		try {
			businessShopFlowDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessShopFlowServiceImpl update()：修改BusinessShopFlow发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessShopFlow
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessShopFlowDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessShopFlowServiceImpl delete()：删除BusinessShopFlow发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
