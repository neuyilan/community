package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessShopOrder;
import com.community.app.module.vo.BusinessShopOrderQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessShopOrderDao {
		
	/**
	 * 查询单个BusinessShopOrder
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessShopOrder findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessShopOrder
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShopOrder> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessShopOrder
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShopOrder> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessShopOrder-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessShopOrder> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessShopOrder
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShopOrder> findByExample(final BusinessShopOrderQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessShopOrder-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessShopOrder> findByExample(final BusinessShopOrderQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShopOrder> findAllPage(final BusinessShopOrderQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessShopOrderQuery query) throws DaoException;
	
	/**
	 * 保存BusinessShopOrder数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessShopOrder entity) throws DaoException;
	
	/**
	 * 修改BusinessShopOrder数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessShopOrder entity) throws DaoException;

	/**
	 * 删除BusinessShopOrder
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
