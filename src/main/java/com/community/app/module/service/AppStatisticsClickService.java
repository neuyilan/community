package com.community.app.module.service;



import java.util.List;
import java.util.Map;

import com.community.app.module.bean.AppStatisticsClick;
import com.community.app.module.vo.AppStatisticsClickQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;



public interface AppStatisticsClickService {

	/**
	 * 查询单个AppStatisticsClick
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public AppStatisticsClick findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有AppStatisticsClick
	 * @return
	 * @throws ServiceException
	 */
	public List<AppStatisticsClick> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有AppStatisticsClick
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppStatisticsClick> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有AppStatisticsClick-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<AppStatisticsClick> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有AppStatisticsClick
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppStatisticsClick> findByExample(final AppStatisticsClickQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有AppStatisticsClick-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<AppStatisticsClick> findByExample(final AppStatisticsClickQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final AppStatisticsClickQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final AppStatisticsClickQuery query) throws ServiceException;
	
	/**
	 * 保存AppStatisticsClick数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final AppStatisticsClick entity) throws ServiceException;
	
	/**
	 * 修改AppStatisticsClick数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final AppStatisticsClick entity) throws ServiceException;

	/**
	 * 删除AppStatisticsClick
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
