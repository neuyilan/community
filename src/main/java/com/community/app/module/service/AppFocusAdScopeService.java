package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.AppFocusAdScope;
import com.community.app.module.vo.AppFocusAdScopeQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;

public interface AppFocusAdScopeService {

	/**
	 * 查询单个AppFocusAdScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public AppFocusAdScope findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有AppFocusAdScope
	 * @return
	 * @throws ServiceException
	 */
	public List<AppFocusAdScope> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有AppFocusAdScope
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppFocusAdScope> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有AppFocusAdScope-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<AppFocusAdScope> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有AppFocusAdScope
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppFocusAdScope> findByExample(final AppFocusAdScopeQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有AppFocusAdScope-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<AppFocusAdScope> findByExample(final AppFocusAdScopeQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final AppFocusAdScopeQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final AppFocusAdScopeQuery query) throws ServiceException;
	
	/**
	 * 保存AppFocusAdScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final AppFocusAdScope entity) throws ServiceException;
	
	/**
	 * 修改AppFocusAdScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final AppFocusAdScope entity) throws ServiceException;

	/**
	 * 删除AppFocusAdScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
}