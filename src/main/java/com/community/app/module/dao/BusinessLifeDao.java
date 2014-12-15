package com.community.app.module.dao;

import java.util.List;
import java.util.Map;


import com.community.framework.exception.DaoException;
import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessLife;
import com.community.app.module.vo.BusinessLifeQuery;

@Repository
public interface BusinessLifeDao {
		
	/**
	 * 查询单个BusinessLife
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessLife findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessLife
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessLife> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessLife
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessLife> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessLife-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessLife> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessLife
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessLife> findByExample(final BusinessLifeQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessLife-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessLife> findByExample(final BusinessLifeQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessLife> findAllPage(final BusinessLifeQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessLifeQuery query) throws DaoException;
	
	/**
	 * 保存BusinessLife数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessLife entity) throws DaoException;
	
	/**
	 * 修改BusinessLife数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessLife entity) throws DaoException;

	/**
	 * 删除BusinessLife
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
