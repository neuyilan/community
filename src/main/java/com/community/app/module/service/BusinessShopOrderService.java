package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessShopOrder;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessShopOrderQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessShopOrderService {

	/**
	 * 查询单个BusinessShopOrder
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessShopOrder findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessShopOrder
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessShopOrder> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessShopOrder
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessShopOrder> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessShopOrder-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessShopOrder> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessShopOrder
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessShopOrder> findByExample(final BusinessShopOrderQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessShopOrder-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessShopOrder> findByExample(final BusinessShopOrderQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessShopOrderQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessShopOrderQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessShopOrder数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessShopOrder entity) throws ServiceException;
	
	/**
	 * 修改BusinessShopOrder数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessShopOrder entity) throws ServiceException;

	/**
	 * 删除BusinessShopOrder
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 保存BusinessShopOrder数据 from WS
	 * @param entity
	 * @throws ServiceException
	 */
	public void saveFromWS(final BusinessShopOrder entity) throws ServiceException;

}
