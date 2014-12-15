package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessDepartment;
import com.community.app.module.vo.BusinessDepartmentQuery;

@Repository
public interface BusinessDepartmentDao {
		
	/**
	 * 查询单个BusinessDepartment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessDepartment findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessDepartment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessDepartment> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessDepartment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessDepartment> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessDepartment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessDepartment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessDepartment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessDepartment> findByExample(final BusinessDepartmentQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessDepartment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessDepartment> findByExample(final BusinessDepartmentQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessDepartment> findAllPage(final BusinessDepartmentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessDepartmentQuery query) throws DaoException;
	
	/**
	 * 保存BusinessDepartment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessDepartment entity) throws DaoException;
	
	/**
	 * 修改BusinessDepartment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessDepartment entity) throws DaoException;

	/**
	 * 删除BusinessDepartment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
