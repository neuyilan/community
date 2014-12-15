package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import com.community.framework.exception.DaoException;
import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessTypeProperty;
import com.community.app.module.vo.BusinessTypePropertyQuery;

@Repository
public interface BusinessTypePropertyDao {
		
	/**
	 * 查询单个BusinessTypeProperty
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessTypeProperty findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessTypeProperty
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessTypeProperty> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessTypeProperty
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessTypeProperty> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessTypeProperty-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessTypeProperty> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessTypeProperty
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessTypeProperty> findByExample(final BusinessTypePropertyQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessTypeProperty-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessTypeProperty> findByExample(final BusinessTypePropertyQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessTypeProperty> findAllPage(final BusinessTypePropertyQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessTypePropertyQuery query) throws DaoException;
	
	/**
	 * 保存BusinessTypeProperty数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessTypeProperty entity) throws DaoException;
	
	/**
	 * 修改BusinessTypeProperty数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessTypeProperty entity) throws DaoException;

	/**
	 * 删除BusinessTypeProperty
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
