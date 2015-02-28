package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.AppPushLog;
import com.community.app.module.vo.AppPushLogQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;


public interface AppPushLogService {

	/**
	 * 查询单个AppPushLog
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public AppPushLog findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有AppPushLog
	 * @return
	 * @throws ServiceException
	 */
	public List<AppPushLog> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有AppPushLog
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppPushLog> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有AppPushLog-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<AppPushLog> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有AppPushLog
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppPushLog> findByExample(final AppPushLogQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有AppPushLog-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<AppPushLog> findByExample(final AppPushLogQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final AppPushLogQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final AppPushLogQuery query) throws ServiceException;
	
	/**
	 * 保存AppPushLog数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final AppPushLog entity) throws ServiceException;
	
	/**
	 * 修改AppPushLog数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final AppPushLog entity) throws ServiceException;

	/**
	 * 删除AppPushLog
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
