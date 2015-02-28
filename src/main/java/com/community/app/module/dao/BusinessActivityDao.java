package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessActivity;
import com.community.app.module.vo.BusinessActivityQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessActivityDao {
		
	/**
	 * 查询单个BusinessActivity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivity findById(final Integer id) throws DaoException;
	
	/**
	 * 查询单个BusinessActivity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivity findById_app(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessActivity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivity> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessActivity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivity> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivity-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivity> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessActivity
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivity> findByExample(final BusinessActivityQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessActivity-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivity> findByExample(final BusinessActivityQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivity> findAllPage(final BusinessActivityQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivity> findAllPage_app(final BusinessActivityQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessActivityQuery query) throws DaoException;
	
	
	/**
	 * 保存BusinessActivity数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivity entity) throws DaoException;
	
	/**
	 * 修改BusinessActivity数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivity entity) throws DaoException;

	/**
	 * 删除BusinessActivity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
