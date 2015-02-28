package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessExpResolve;
import com.community.app.module.vo.BusinessExpResolveQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessExpResolveDao {
		
	/**
	 * 查询单个BusinessExpResolve
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessExpResolve findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessExpResolve
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExpResolve> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessExpResolve
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExpResolve> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessExpResolve-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExpResolve> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessExpResolve
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExpResolve> findByExample(final BusinessExpResolveQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessExpResolve-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExpResolve> findByExample(final BusinessExpResolveQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExpResolve> findAllPage(final BusinessExpResolveQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessExpResolveQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExpResolve> findAllPage_app(final BusinessExpResolveQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessExpResolveQuery query) throws DaoException;

	
	/**
	 * 保存BusinessExpResolve数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessExpResolve entity) throws DaoException;
	
	/**
	 * 保存BusinessExpResolve数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save_app(final BusinessExpResolve entity) throws DaoException;
	
	/**
	 * 修改BusinessExpResolve数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessExpResolve entity) throws DaoException;

	/**
	 * 删除BusinessExpResolve
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 删除BusinessExpResolve
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete_app(final Integer id) throws DaoException;

}
