package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.ManageExpressAll;
import com.community.app.module.vo.ManageExpressAllQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface ManageExpressAllDao {
		
	/**
	 * 查询单个ManageExpressAll
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageExpressAll findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有ManageExpressAll
	 * @return
	 * @throws DaoException
	 */
	public List<ManageExpressAll> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有ManageExpressAll
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageExpressAll> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有ManageExpressAll-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageExpressAll> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有ManageExpressAll
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageExpressAll> findByExample(final ManageExpressAllQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有ManageExpressAll-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageExpressAll> findByExample(final ManageExpressAllQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageExpressAll> findAllPage(final ManageExpressAllQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageExpressAllQuery query) throws DaoException;
	
	/**
	 * 保存ManageExpressAll数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageExpressAll entity) throws DaoException;
	
	/**
	 * 修改ManageExpressAll数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageExpressAll entity) throws DaoException;

	/**
	 * 删除ManageExpressAll
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
}