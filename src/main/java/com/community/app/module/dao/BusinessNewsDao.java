package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessNews;
import com.community.app.module.bean.index;
import com.community.app.module.vo.BusinessNewsQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessNewsDao {
		
	/**
	 * 查询单个BusinessNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNews findById(final Integer id) throws DaoException;
	
	/**
	 * 查询单个BusinessNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNews findById_app(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessNews
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNews> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessNews
	 * @return
	 * @throws DaoException
	 */	
	
	/**
	 * 查询当前所有置顶的新闻
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNews> findAllHotById() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessNews
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNews> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessNews-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessNews> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessNews
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNews> findByExample(final BusinessNewsQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessNews-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessNews> findByExample(final BusinessNewsQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNews> findAllPage(final BusinessNewsQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessNewsQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNews> findAllPage_app(final BusinessNewsQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessNewsQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<index> findAllPage_index_app(final BusinessNewsQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_index_app(final BusinessNewsQuery query) throws DaoException;

	
	/**
	 * 保存BusinessNews数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessNews entity) throws DaoException;
	
	/**
	 * 修改BusinessNews数据
	 * @param entity
	 * @throws DaoException
	 */
	public int update(final BusinessNews entity) throws DaoException;

	/**
	 * 删除BusinessNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
