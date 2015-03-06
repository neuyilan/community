package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.AppFocusAdScope;
import com.community.app.module.vo.AppFocusAdScopeQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface AppFocusAdScopeDao {
		
	/**
	 * 查询单个AppFocusAdScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppFocusAdScope findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有AppFocusAdScope
	 * @return
	 * @throws DaoException
	 */
	public List<AppFocusAdScope> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有AppFocusAdScope
	 * @return
	 * @throws DaoException
	 */	
	public List<AppFocusAdScope> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有AppFocusAdScope-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<AppFocusAdScope> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有AppFocusAdScope
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppFocusAdScope> findByExample(final AppFocusAdScopeQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有AppFocusAdScope-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<AppFocusAdScope> findByExample(final AppFocusAdScopeQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppFocusAdScope> findAllPage(final AppFocusAdScopeQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppFocusAdScopeQuery query) throws DaoException;
	
	/**
	 * 保存AppFocusAdScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppFocusAdScope entity) throws DaoException;
	
	/**
	 * 修改AppFocusAdScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppFocusAdScope entity) throws DaoException;

	/**
	 * 删除AppFocusAdScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
}