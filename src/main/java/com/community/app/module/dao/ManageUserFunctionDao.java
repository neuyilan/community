package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.ManageUserFunction;
import com.community.app.module.vo.ManageUserFunctionQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface ManageUserFunctionDao {
		
	/**
	 * 查询单个ManageUserFunction
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageUserFunction findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有ManageUserFunction
	 * @return
	 * @throws DaoException
	 */
	public List<ManageUserFunction> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有ManageUserFunction
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageUserFunction> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有ManageUserFunction-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageUserFunction> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有ManageUserFunction
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageUserFunction> findByExample(final ManageUserFunctionQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有ManageUserFunction-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageUserFunction> findByExample(final ManageUserFunctionQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageUserFunction> findAllPage(final ManageUserFunctionQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageUserFunctionQuery query) throws DaoException;
	
	/**
	 * 保存ManageUserFunction数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageUserFunction entity) throws DaoException;
	
	/**
	 * 修改ManageUserFunction数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageUserFunction entity) throws DaoException;

	/**
	 * 删除ManageUserFunction
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

    /**
     * 删除ManageUserFunction
     * @param id
     * @return
     * @throws DaoException
     */
	public boolean deleteByUserId(final Integer id) throws DaoException;

}
