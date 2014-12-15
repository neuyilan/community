package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.AppStatistics;
import com.community.app.module.vo.AppStatisticsQuery;


public interface AppStatisticsService {

	/**
	 * 查询单个AppStatistics
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public AppStatistics findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有AppStatistics
	 * @return
	 * @throws ServiceException
	 */
	public List<AppStatistics> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有AppStatistics
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppStatistics> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有AppStatistics-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<AppStatistics> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有AppStatistics
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppStatistics> findByExample(final AppStatisticsQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有AppStatistics-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<AppStatistics> findByExample(final AppStatisticsQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final AppStatisticsQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final AppStatisticsQuery query) throws ServiceException;
	
	/**
	 * 保存AppStatistics数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final AppStatistics entity) throws ServiceException;
	
	/**
	 * 修改AppStatistics数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final AppStatistics entity) throws ServiceException;

	/**
	 * 删除AppStatistics
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
