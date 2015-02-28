package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessLifeType;
import com.community.app.module.vo.BusinessLifeTypeQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessLifeTypeDao {
		
	/**
	 * 查询单个BusinessLifeType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessLifeType findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessLifeType
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessLifeType> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessLifeType
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessLifeType> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessLifeType-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessLifeType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessLifeType
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessLifeType> findByExample(final BusinessLifeTypeQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessLifeType-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessLifeType> findByExample(final BusinessLifeTypeQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessLifeType> findAllPage(final BusinessLifeTypeQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessLifeTypeQuery query) throws DaoException;
	
	/**
	 * 保存BusinessLifeType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessLifeType entity) throws DaoException;
	
	/**
	 * 修改BusinessLifeType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessLifeType entity) throws DaoException;

	/**
	 * 删除BusinessLifeType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
