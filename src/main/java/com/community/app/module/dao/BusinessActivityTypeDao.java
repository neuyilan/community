package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessActivityType;
import com.community.app.module.vo.BusinessActivityTypeQuery;

@Repository
public interface BusinessActivityTypeDao {
		
	/**
	 * 查询单个BusinessActivityType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityType findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessActivityType
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityType> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessActivityType
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityType> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityType-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessActivityType
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityType> findByExample(final BusinessActivityTypeQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityType-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityType> findByExample(final BusinessActivityTypeQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityType> findAllPage(final BusinessActivityTypeQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityTypeQuery query) throws DaoException;
	
	/**
	 * 保存BusinessActivityType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityType entity) throws DaoException;
	
	/**
	 * 修改BusinessActivityType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityType entity) throws DaoException;

	/**
	 * 删除BusinessActivityType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
