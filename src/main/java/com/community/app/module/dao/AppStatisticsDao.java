package com.community.app.module.dao;



import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.AppStatistics;
import com.community.app.module.vo.AppStatisticsQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface AppStatisticsDao {
		
	/**
	 * 查询单个AppStatistics
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppStatistics findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有AppStatistics
	 * @return
	 * @throws DaoException
	 */
	public List<AppStatistics> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有AppStatistics
	 * @return
	 * @throws DaoException
	 */	
	public List<AppStatistics> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有AppStatistics-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<AppStatistics> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有AppStatistics
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppStatistics> findByExample(final AppStatisticsQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有AppStatistics-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<AppStatistics> findByExample(final AppStatisticsQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppStatistics> findAllPage(final AppStatisticsQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppStatisticsQuery query) throws DaoException;
	
	/**
	 * 保存AppStatistics数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppStatistics entity) throws DaoException;
	
	/**
	 * 修改AppStatistics数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppStatistics entity) throws DaoException;

	/**
	 * 删除AppStatistics
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
