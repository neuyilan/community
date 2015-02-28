package com.community.app.module.dao;


import java.util.List;
import java.util.Map;

import com.community.app.module.bean.ManageOrg;
import com.community.app.module.vo.ManageOrgQuery;
import com.community.framework.exception.DaoException;

public interface ManageOrgDao {
		
	/**
	 * 查询单个ManageOrg
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageOrg findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有ManageOrg
	 * @return
	 * @throws DaoException
	 */
	public List<ManageOrg> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有ManageOrg
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageOrg> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有ManageOrg-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageOrg> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有ManageOrg
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageOrg> findByExample(final ManageOrgQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有ManageOrg-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageOrg> findByExample(final ManageOrgQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageOrg> findAllPage(final ManageOrgQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageOrgQuery query) throws DaoException;
	
	/**
	 * 保存ManageOrg数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageOrg entity) throws DaoException;
	
	/**
	 * 修改ManageOrg数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageOrg entity) throws DaoException;

	/**
	 * 删除ManageOrg
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
