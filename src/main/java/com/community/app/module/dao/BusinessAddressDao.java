package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessAddress;
import com.community.app.module.vo.BusinessAddressQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessAddressDao {

	/**
	 * 查询单个BusinessAddress
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessAddress findById(final Integer id) throws DaoException;

	/**
	 * 无条件查询所有BusinessAddress
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAddress> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessAddress
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAddress> findByMap(final Map<String, Object> paramMap)
			throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessAddress-限制返回条数
	 * 
	 * @return
	 * @throws DaoException
	 */
	// public List<BusinessAddress> findByMap(final Map<String, Object>
	// paramMap, final Integer limit) throws DaoException;

	/**
	 * 按VO对象条件查询所有BusinessAddress
	 * 
	 * @param entity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAddress> findByExample(final BusinessAddressQuery query)
			throws DaoException;

	/**
	 * 按VO对象条件查询所有BusinessAddress-限制返回条数
	 * 
	 * @param entity
	 * @return
	 * @throws DaoException
	 */
	// public List<BusinessAddress> findByExample(final BusinessAddressQuery
	// query, final Integer limit) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页数据
	 * 
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAddress> findAllPage(final BusinessAddressQuery query)
			throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * 
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessAddressQuery query)
			throws DaoException;

	/**
	 * 保存BusinessAddress数据
	 * 
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessAddress entity) throws DaoException;

	/**
	 * 修改BusinessAddress数据
	 * 
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessAddress entity) throws DaoException;

	/**
	 * 删除BusinessAddress
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
}