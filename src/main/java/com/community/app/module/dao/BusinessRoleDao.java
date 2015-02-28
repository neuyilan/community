package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessRole;
import com.community.app.module.vo.BusinessRoleQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Repository
public interface BusinessRoleDao {
		
	/**
	 * 查询单个BusinessRole
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRole findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessRole
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRole> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessRole
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRole> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessRole-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRole> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessRole
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRole> findByExample(final BusinessRoleQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessRole-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRole> findByExample(final BusinessRoleQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRole> findAllPage(final BusinessRoleQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRoleQuery query) throws DaoException;
	
	/**
	 * 保存BusinessRole数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRole entity) throws DaoException;
	
	/**
	 * 修改BusinessRole数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRole entity) throws DaoException;

	/**
	 * 删除BusinessRole
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	

	/**
	 * 根据搜索条件，搜索分页所需的数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRole> findAllPageByField(final Map fieldMap, final BusinessRoleQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRole> findListByField(final Map fieldMap, final BusinessRoleQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRole findByField(final Map fieldMap, final Integer id) throws DaoException;

}
