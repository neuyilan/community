package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessNewspaperScope;
import com.community.app.module.vo.BusinessNewspaperScopeQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessNewspaperScopeDao {
		
	/**
	 * 查询单个BusinessNewspaperScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNewspaperScope findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessNewspaperScope
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewspaperScope> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessNewspaperScope
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewspaperScope> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessNewspaperScope-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessNewspaperScope> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessNewspaperScope
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewspaperScope> findByExample(final BusinessNewspaperScopeQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessNewspaperScope-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessNewspaperScope> findByExample(final BusinessNewspaperScopeQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewspaperScope> findAllPage(final BusinessNewspaperScopeQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessNewspaperScopeQuery query) throws DaoException;
	
	/**
	 * 保存BusinessNewspaperScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessNewspaperScope entity) throws DaoException;
	
	/**
	 * 修改BusinessNewspaperScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessNewspaperScope entity) throws DaoException;

	/**
	 * 删除BusinessNewspaperScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
}