package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessHelpType;
import com.community.app.module.vo.BusinessHelpTypeQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessHelpTypeDao {
		
	/**
	 * 查询单个BusinessHelpType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHelpType findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessHelpType
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpType> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessHelpType
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpType> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessHelpType-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessHelpType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessHelpType
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpType> findByExample(final BusinessHelpTypeQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessHelpType-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessHelpType> findByExample(final BusinessHelpTypeQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpType> findAllPage(final BusinessHelpTypeQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHelpTypeQuery query) throws DaoException;
	
	/**
	 * 保存BusinessHelpType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHelpType entity) throws DaoException;
	
	/**
	 * 修改BusinessHelpType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHelpType entity) throws DaoException;

	/**
	 * 删除BusinessHelpType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
