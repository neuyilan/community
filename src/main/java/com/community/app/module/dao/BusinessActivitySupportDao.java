package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessActivitySupport;
import com.community.app.module.vo.BusinessActivitySupportQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessActivitySupportDao {
		
	/**
	 * 查询单个BusinessActivitySupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivitySupport findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessActivitySupport
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivitySupport> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessActivitySupport
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivitySupport> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivitySupport-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivitySupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessActivitySupport
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivitySupport> findByExample(final BusinessActivitySupportQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessActivitySupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivitySupport> findByExample(final BusinessActivitySupportQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivitySupport> findAllPage(final BusinessActivitySupportQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivitySupportQuery query) throws DaoException;
	
	/**
	 * 保存BusinessActivitySupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivitySupport entity) throws DaoException;
	
	/**
	 * 修改BusinessActivitySupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivitySupport entity) throws DaoException;

	/**
	 * 删除BusinessActivitySupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
