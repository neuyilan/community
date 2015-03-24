package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessShopGoods;
import com.community.app.module.dao.BusinessShopGoodsDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessShopGoodsQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessShopGoodsService")
@Transactional
public class BusinessShopGoodsServiceImpl implements BusinessShopGoodsService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessShopGoodsServiceImpl.class);
	@Autowired
	private BusinessShopGoodsDao businessShopGoodsDao;

	/**
	 * 查询单个BusinessShopGoods
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessShopGoods findById(final Integer id) throws ServiceException {
		BusinessShopGoods businessShopGoods = new BusinessShopGoods();
		try {
			businessShopGoods = businessShopGoodsDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessShopGoodsServiceImpl findById()：查询单个BusinessShopGoods发生错误！", e);
			e.printStackTrace();
		}
		return businessShopGoods;
	}
	
	/**
	 * 无条件查询所有BusinessShopGoods
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessShopGoods> findAll() throws ServiceException {
		List<BusinessShopGoods> list = new ArrayList<BusinessShopGoods>() ;
		try {
			list=businessShopGoodsDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessShopGoodsServiceImpl findAll()：无条件查询所有BusinessShopGoods发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessShopGoods
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessShopGoods> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessShopGoods> list = new ArrayList<BusinessShopGoods>() ;
		try {
			list=businessShopGoodsDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessShopGoodsServiceImpl findByMap()：按Map对象条件查询所有BusinessShopGoods发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessShopGoods-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessShopGoods> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessShopGoods> list = new ArrayList<BusinessShopGoods>() ;
		try {
			list=businessShopGoodsDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessShopGoodsServiceImpl findByMap()：按Map对象条件查询所有BusinessShopGoods-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessShopGoods
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessShopGoods> findByExample(final BusinessShopGoodsQuery query) throws ServiceException {
		List<BusinessShopGoods> list = new ArrayList<BusinessShopGoods>() ;
		try {
			list=businessShopGoodsDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessShopGoodsServiceImpl findByExample()：按VO对象条件查询所有BusinessShopGoods发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessShopGoods-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessShopGoods> findByExample(final BusinessShopGoodsQuery query, final Integer limit) throws ServiceException {
		List<BusinessShopGoods> list = new ArrayList<BusinessShopGoods>() ;
		try {
			list=businessShopGoodsDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessShopGoodsServiceImpl findByExample()：按VO对象条件查询所有BusinessShopGoods-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessShopGoodsQuery query) throws ServiceException {
		List<BusinessShopGoods> list = new ArrayList<BusinessShopGoods>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessShopGoodsDao.findAllPage(query);
			count=businessShopGoodsDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessShopGoodsServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessShopGoodsQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessShopGoodsDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessShopGoodsServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessShopGoods数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessShopGoods entity) throws ServiceException {
		try {
			businessShopGoodsDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessShopGoodsServiceImpl save()：保存BusinessShopGoods发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessShopGoods数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessShopGoods entity) throws ServiceException {
		try {
			businessShopGoodsDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessShopGoodsServiceImpl update()：修改BusinessShopGoods发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessShopGoods
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessShopGoodsDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessShopGoodsServiceImpl delete()：删除BusinessShopGoods发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
