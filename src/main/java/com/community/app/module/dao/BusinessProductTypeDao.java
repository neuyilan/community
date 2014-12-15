package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessProductType;
import com.community.app.module.vo.BusinessProductTypeQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessProductTypeDao {
		
	/**
	 * 查询单个BusinessProductType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessProductType findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessProductType
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductType> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessProductType
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductType> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessProductType-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessProductType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessProductType
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductType> findByExample(final BusinessProductTypeQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessProductType-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessProductType> findByExample(final BusinessProductTypeQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductType> findAllPage(final BusinessProductTypeQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessProductTypeQuery query) throws DaoException;
	
	/**
	 * 保存BusinessProductType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessProductType entity) throws DaoException;
	
	/**
	 * 修改BusinessProductType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessProductType entity) throws DaoException;

	/**
	 * 删除BusinessProductType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
}