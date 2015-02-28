package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessHealthydiet;
import com.community.app.module.vo.BusinessHealthydietQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessHealthydietDao {
		
	/**
	 * 查询单个BusinessHealthydiet
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHealthydiet findById(final Integer id) throws DaoException;
	
	/**
	 * 查询单个BusinessHealthydiet
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHealthydiet findById_app(final Integer id) throws DaoException;

	
	/**
	 * 无条件查询所有BusinessHealthydiet
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHealthydiet> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessHealthydiet
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHealthydiet> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessHealthydiet-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessHealthydiet> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessHealthydiet
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHealthydiet> findByExample(final BusinessHealthydietQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessHealthydiet-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessHealthydiet> findByExample(final BusinessHealthydietQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHealthydiet> findAllPage(final BusinessHealthydietQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHealthydietQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHealthydiet> findAllPage_app(final BusinessHealthydietQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessHealthydietQuery query) throws DaoException;
	
	/**
	 * 保存BusinessHealthydiet数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHealthydiet entity) throws DaoException;
	
	/**
	 * 修改BusinessHealthydiet数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHealthydiet entity) throws DaoException;

	/**
	 * 删除BusinessHealthydiet
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
