package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessPetType;
import com.community.app.module.vo.BusinessPetTypeQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessPetTypeDao {
		
	/**
	 * 查询单个BusinessPetType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessPetType findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessPetType
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessPetType> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessPetType
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPetType> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessPetType-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPetType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessPetType
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPetType> findByExample(final BusinessPetTypeQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessPetType-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPetType> findByExample(final BusinessPetTypeQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessPetType> findAllPage(final BusinessPetTypeQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessPetTypeQuery query) throws DaoException;
	
	/**
	 * 保存BusinessPetType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessPetType entity) throws DaoException;
	
	/**
	 * 修改BusinessPetType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessPetType entity) throws DaoException;

	/**
	 * 删除BusinessPetType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
