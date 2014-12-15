package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.AppFocusScope;
import com.community.app.module.vo.AppFocusScopeQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface AppFocusScopeDao {
		
	/**
	 * 查询单个AppFocusScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppFocusScope findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有AppFocusScope
	 * @return
	 * @throws DaoException
	 */
	public List<AppFocusScope> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有AppFocusScope
	 * @return
	 * @throws DaoException
	 */	
	public List<AppFocusScope> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有AppFocusScope-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<AppFocusScope> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有AppFocusScope
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppFocusScope> findByExample(final AppFocusScopeQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有AppFocusScope-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<AppFocusScope> findByExample(final AppFocusScopeQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppFocusScope> findAllPage(final AppFocusScopeQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppFocusScopeQuery query) throws DaoException;
	
	/**
	 * 保存AppFocusScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppFocusScope entity) throws DaoException;
	
	/**
	 * 修改AppFocusScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppFocusScope entity) throws DaoException;

	/**
	 * 删除AppFocusScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
}