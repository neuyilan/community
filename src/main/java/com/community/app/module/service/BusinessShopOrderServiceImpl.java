package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.framework.exception.DaoException;
import com.community.app.module.vo.BusinessShopOrderQuery;
import com.community.app.module.bean.BusinessShopOrder;
import com.community.app.module.dao.BusinessShopGoodsDao;
import com.community.app.module.dao.BusinessShopOrderDao;

@Service("BusinessShopOrderService")
@Transactional
public class BusinessShopOrderServiceImpl implements BusinessShopOrderService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessShopOrderServiceImpl.class);
	@Autowired
	private BusinessShopOrderDao businessShopOrderDao;
	@Autowired
	private BusinessShopGoodsDao businessShopGoodsDao;
	/**
	 * 查询单个BusinessShopOrder
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessShopOrder findById(final Integer id) throws ServiceException {
		BusinessShopOrder businessShopOrder = new BusinessShopOrder();
		try {
			businessShopOrder = businessShopOrderDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessShopOrderServiceImpl findById()：查询单个BusinessShopOrder发生错误！", e);
			e.printStackTrace();
		}
		return businessShopOrder;
	}
	
	/**
	 * 无条件查询所有BusinessShopOrder
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessShopOrder> findAll() throws ServiceException {
		List<BusinessShopOrder> list = new ArrayList<BusinessShopOrder>() ;
		try {
			list=businessShopOrderDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessShopOrderServiceImpl findAll()：无条件查询所有BusinessShopOrder发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessShopOrder
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessShopOrder> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessShopOrder> list = new ArrayList<BusinessShopOrder>() ;
		try {
			list=businessShopOrderDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessShopOrderServiceImpl findByMap()：按Map对象条件查询所有BusinessShopOrder发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessShopOrder-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessShopOrder> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessShopOrder> list = new ArrayList<BusinessShopOrder>() ;
		try {
			list=businessShopOrderDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessShopOrderServiceImpl findByMap()：按Map对象条件查询所有BusinessShopOrder-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessShopOrder
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessShopOrder> findByExample(final BusinessShopOrderQuery query) throws ServiceException {
		List<BusinessShopOrder> list = new ArrayList<BusinessShopOrder>() ;
		try {
			list=businessShopOrderDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessShopOrderServiceImpl findByExample()：按VO对象条件查询所有BusinessShopOrder发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessShopOrder-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessShopOrder> findByExample(final BusinessShopOrderQuery query, final Integer limit) throws ServiceException {
		List<BusinessShopOrder> list = new ArrayList<BusinessShopOrder>() ;
		try {
			list=businessShopOrderDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessShopOrderServiceImpl findByExample()：按VO对象条件查询所有BusinessShopOrder-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessShopOrderQuery query) throws ServiceException {
		List<BusinessShopOrder> list = new ArrayList<BusinessShopOrder>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessShopOrderDao.findAllPage(query);
			count=businessShopOrderDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessShopOrderServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessShopOrderQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessShopOrderDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessShopOrderServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessShopOrder数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessShopOrder entity) throws ServiceException {
		try {
			businessShopOrderDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessShopOrderServiceImpl save()：保存BusinessShopOrder发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessShopOrder数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessShopOrder entity) throws ServiceException {
		try {
			businessShopOrderDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessShopOrderServiceImpl update()：修改BusinessShopOrder发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessShopOrder
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessShopOrderDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessShopOrderServiceImpl delete()：删除BusinessShopOrder发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}



	public void saveFromWS(BusinessShopOrder entity) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			businessShopOrderDao.save(entity);
//			businessShopGoodsDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessShopOrderServiceImpl save()：保存BusinessShopOrder from WS发生错误！", e);
			e.printStackTrace();
		}
	}
	
}
