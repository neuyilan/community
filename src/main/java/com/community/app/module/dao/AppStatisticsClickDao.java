package com.community.app.module.dao;



import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;


import com.community.app.module.bean.AppStatisticsClick;
import com.community.app.module.vo.AppStatisticsClickQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface AppStatisticsClickDao {
		
	/**
	 * 查询单个AppStatisticsClick
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppStatisticsClick findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有AppStatisticsClick
	 * @return
	 * @throws DaoException
	 */
	public List<AppStatisticsClick> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有AppStatisticsClick
	 * @return
	 * @throws DaoException
	 */	
	public List<AppStatisticsClick> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有AppStatisticsClick-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<AppStatisticsClick> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有AppStatisticsClick
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppStatisticsClick> findByExample(final AppStatisticsClickQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有AppStatisticsClick-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<AppStatisticsClick> findByExample(final AppStatisticsClickQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppStatisticsClick> findAllPage(final AppStatisticsClickQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppStatisticsClickQuery query) throws DaoException;
	
	/**
	 * 保存AppStatisticsClick数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppStatisticsClick entity) throws DaoException;
	
	/**
	 * 修改AppStatisticsClick数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppStatisticsClick entity) throws DaoException;

	/**
	 * 删除AppStatisticsClick
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
