package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessShopFlow;
import com.community.app.module.vo.BusinessShopFlowQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessShopFlowDao {
		
	/**
	 * 查询单个BusinessShopFlow
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessShopFlow findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessShopFlow
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShopFlow> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessShopFlow
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShopFlow> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessShopFlow-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessShopFlow> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessShopFlow
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShopFlow> findByExample(final BusinessShopFlowQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessShopFlow-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessShopFlow> findByExample(final BusinessShopFlowQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShopFlow> findAllPage(final BusinessShopFlowQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessShopFlowQuery query) throws DaoException;
	
	/**
	 * 保存BusinessShopFlow数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessShopFlow entity) throws DaoException;
	
	/**
	 * 修改BusinessShopFlow数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessShopFlow entity) throws DaoException;

	/**
	 * 删除BusinessShopFlow
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
