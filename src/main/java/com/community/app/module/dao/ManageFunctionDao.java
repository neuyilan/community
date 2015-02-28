package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.ManageFunction;
import com.community.app.module.vo.ManageFunctionQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface ManageFunctionDao {
		
	/**
	 * 查询单个ManageFunction
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageFunction findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有ManageFunction
	 * @return
	 * @throws DaoException
	 */
	public List<ManageFunction> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有ManageFunction
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageFunction> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有ManageFunction-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageFunction> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有ManageFunction
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageFunction> findByExample(final ManageFunctionQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有ManageFunction-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageFunction> findByExample(final ManageFunctionQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageFunction> findAllPage(final ManageFunctionQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageFunctionQuery query) throws DaoException;
	
	/**
	 * 保存ManageFunction数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageFunction entity) throws DaoException;
	
	/**
	 * 修改ManageFunction数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageFunction entity) throws DaoException;

	/**
	 * 删除ManageFunction
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
