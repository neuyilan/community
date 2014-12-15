package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.AppFocusScope;
import com.community.app.module.vo.AppFocusScopeQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;

public interface AppFocusScopeService {

	/**
	 * 查询单个AppFocusScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public AppFocusScope findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有AppFocusScope
	 * @return
	 * @throws ServiceException
	 */
	public List<AppFocusScope> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有AppFocusScope
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppFocusScope> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有AppFocusScope-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<AppFocusScope> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有AppFocusScope
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppFocusScope> findByExample(final AppFocusScopeQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有AppFocusScope-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<AppFocusScope> findByExample(final AppFocusScopeQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final AppFocusScopeQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final AppFocusScopeQuery query) throws ServiceException;
	
	/**
	 * 保存AppFocusScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final AppFocusScope entity) throws ServiceException;
	
	/**
	 * 修改AppFocusScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final AppFocusScope entity) throws ServiceException;

	/**
	 * 删除AppFocusScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
}