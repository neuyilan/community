package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessDepartment;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessDepartmentQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessDepartmentService {

	/**
	 * 查询单个BusinessDepartment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessDepartment findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessDepartment
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessDepartment> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessDepartment
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessDepartment> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessDepartment-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessDepartment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessDepartment
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessDepartment> findByExample(final BusinessDepartmentQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessDepartment-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessDepartment> findByExample(final BusinessDepartmentQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessDepartmentQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessDepartmentQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessDepartment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessDepartment entity) throws ServiceException;
	
	/**
	 * 修改BusinessDepartment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessDepartment entity) throws ServiceException;

	/**
	 * 删除BusinessDepartment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
