package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessAnnoScope;
import com.community.app.module.vo.BusinessAnnoScopeQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessAnnoScopeDao {
		
	/**
	 * 查询单个BusinessAnnoScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessAnnoScope findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessAnnoScope
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnnoScope> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessAnnoScope
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoScope> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoScope-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessAnnoScope> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoScope
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoScope> findByExample(final BusinessAnnoScopeQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessAnnoScope-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessAnnoScope> findByExample(final BusinessAnnoScopeQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnnoScope> findAllPage(final BusinessAnnoScopeQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessAnnoScopeQuery query) throws DaoException;
	
	/**
	 * 保存BusinessAnnoScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessAnnoScope entity) throws DaoException;
	
	/**
	 * 修改BusinessAnnoScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessAnnoScope entity) throws DaoException;

	/**
	 * 删除BusinessAnnoScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
