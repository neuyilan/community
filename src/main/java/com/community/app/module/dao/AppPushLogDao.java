package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.AppPushLog;
import com.community.app.module.vo.AppPushLogQuery;

@Repository
public interface AppPushLogDao {
		
	/**
	 * 查询单个AppPushLog
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppPushLog findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有AppPushLog
	 * @return
	 * @throws DaoException
	 */
	public List<AppPushLog> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有AppPushLog
	 * @return
	 * @throws DaoException
	 */	
	public List<AppPushLog> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有AppPushLog-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<AppPushLog> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有AppPushLog
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppPushLog> findByExample(final AppPushLogQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有AppPushLog-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<AppPushLog> findByExample(final AppPushLogQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppPushLog> findAllPage(final AppPushLogQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppPushLogQuery query) throws DaoException;
	
	/**
	 * 保存AppPushLog数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppPushLog entity) throws DaoException;
	
	/**
	 * 修改AppPushLog数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppPushLog entity) throws DaoException;

	/**
	 * 删除AppPushLog
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
