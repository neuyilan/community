package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessRepairType;
import com.community.app.module.vo.BusinessRepairTypeQuery;

@Repository
public interface BusinessRepairTypeDao {
		
	/**
	 * 查询单个BusinessRepairType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRepairType findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessRepairType
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairType> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessRepairType
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairType> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessRepairType-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRepairType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessRepairType
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairType> findByExample(final BusinessRepairTypeQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessRepairType-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRepairType> findByExample(final BusinessRepairTypeQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairType> findAllPage(final BusinessRepairTypeQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRepairTypeQuery query) throws DaoException;
	
	/**
	 * 保存BusinessRepairType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRepairType entity) throws DaoException;
	
	/**
	 * 修改BusinessRepairType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRepairType entity) throws DaoException;

	/**
	 * 删除BusinessRepairType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
