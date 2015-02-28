package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessNewsView;
import com.community.app.module.vo.BusinessNewsViewQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessNewsViewDao {
		
	/**
	 * 查询单个BusinessNewsView
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNewsView findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessNewsView
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsView> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessNewsView
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsView> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessNewsView-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessNewsView> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessNewsView
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsView> findByExample(final BusinessNewsViewQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessNewsView-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessNewsView> findByExample(final BusinessNewsViewQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsView> findAllPage(final BusinessNewsViewQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessNewsViewQuery query) throws DaoException;
	
	/**
	 * 保存BusinessNewsView数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessNewsView entity) throws DaoException;
	
	/**
	 * 修改BusinessNewsView数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessNewsView entity) throws DaoException;

	/**
	 * 删除BusinessNewsView
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
