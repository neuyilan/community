package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessActivityScope;
import com.community.app.module.vo.BusinessActivityScopeQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessActivityScopeDao {
		
	/**
	 * 查询单个BusinessActivityScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityScope findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessActivityScope
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityScope> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessActivityScope
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityScope> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityScope-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityScope> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessActivityScope
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityScope> findByExample(final BusinessActivityScopeQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityScope-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityScope> findByExample(final BusinessActivityScopeQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityScope> findAllPage(final BusinessActivityScopeQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityScopeQuery query) throws DaoException;
	
	/**
	 * 保存BusinessActivityScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityScope entity) throws DaoException;
	
	/**
	 * 修改BusinessActivityScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityScope entity) throws DaoException;

	/**
	 * 删除BusinessActivityScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
