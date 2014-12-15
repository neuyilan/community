package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.AppHomepage;
import com.community.app.module.vo.AppHomepageQuery;

@Repository
public interface AppHomepageDao {
		
	/**
	 * 查询单个AppHomepage
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppHomepage findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有AppHomepage
	 * @return
	 * @throws DaoException
	 */
	public List<AppHomepage> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有AppHomepage
	 * @return
	 * @throws DaoException
	 */	
	public List<AppHomepage> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有AppHomepage-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<AppHomepage> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有AppHomepage
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppHomepage> findByExample(final AppHomepageQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有AppHomepage-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppHomepage> findByExample(final AppHomepageQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppHomepage> findAllPage(final AppHomepageQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppHomepageQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppHomepage> findAllPage_app(final AppHomepageQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final AppHomepageQuery query) throws DaoException;
	
	/**
	 * 保存AppHomepage数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppHomepage entity) throws DaoException;
	
	/**
	 * 修改AppHomepage数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppHomepage entity) throws DaoException;

	/**
	 * 删除AppHomepage
	 * @param entity
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final AppHomepage entity) throws DaoException;

}
