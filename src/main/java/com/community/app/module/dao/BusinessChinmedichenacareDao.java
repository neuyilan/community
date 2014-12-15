package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessChinmedichenacare;
import com.community.app.module.vo.BusinessChinmedichenacareQuery;

@Repository
public interface BusinessChinmedichenacareDao {
		
	/**
	 * 查询单个BusinessChinmedichenacare
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessChinmedichenacare findById(final Integer id) throws DaoException;
	
	/**
	 * 查询单个BusinessChinmedichenacare
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessChinmedichenacare findById_app(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessChinmedichenacare
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChinmedichenacare> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacare
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessChinmedichenacare> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacare-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessChinmedichenacare> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacare
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessChinmedichenacare> findByExample(final BusinessChinmedichenacareQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacare-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessChinmedichenacare> findByExample(final BusinessChinmedichenacareQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChinmedichenacare> findAllPage(final BusinessChinmedichenacareQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessChinmedichenacareQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChinmedichenacare> findAllPage_app(final BusinessChinmedichenacareQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessChinmedichenacareQuery query) throws DaoException;

	
	/**
	 * 保存BusinessChinmedichenacare数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessChinmedichenacare entity) throws DaoException;
	
	/**
	 * 修改BusinessChinmedichenacare数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessChinmedichenacare entity) throws DaoException;

	/**
	 * 删除BusinessChinmedichenacare
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
