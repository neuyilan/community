package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.vo.AppLatestNewsQuery;

@Repository
public interface AppLatestNewsDao {
		
	/**
	 * 查询单个AppLatestNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppLatestNews findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有AppLatestNews
	 * @return
	 * @throws DaoException
	 */
	public List<AppLatestNews> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有AppLatestNews
	 * @return
	 * @throws DaoException
	 */	
	public List<AppLatestNews> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有AppLatestNews-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<AppLatestNews> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有AppLatestNews
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppLatestNews> findByExample(final AppLatestNewsQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有AppLatestNews-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppLatestNews> findByExample(final AppLatestNewsQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppLatestNews> findAllPage(final AppLatestNewsQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppLatestNewsQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppLatestNews> findAllPage_app(final AppLatestNewsQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final AppLatestNewsQuery query) throws DaoException;

	
	/**
	 * 保存AppLatestNews数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppLatestNews entity) throws DaoException;
	

	/**
	 * 保存AppLatestNews数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save_app(final AppLatestNews entity) throws DaoException;
	
	/**
	 * 修改AppLatestNews数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppLatestNews entity) throws DaoException;

	/**
	 * 删除AppLatestNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 按条件删除AppLatestNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean deleteByCondition(final AppLatestNewsQuery query) throws DaoException;

	/**
	 * 删除AppLatestNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete_app(final AppLatestNews entity) throws DaoException;
	
	/**
	 * 删除AppLatestNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete_app_id(final AppLatestNews entity) throws DaoException;

}
