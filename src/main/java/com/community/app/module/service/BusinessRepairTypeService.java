package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessRepairType;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessRepairTypeQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessRepairTypeService {

	/**
	 * 查询单个BusinessRepairType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRepairType findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessRepairType
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRepairType> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessRepairType
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRepairType> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessRepairType-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRepairType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessRepairType
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRepairType> findByExample(final BusinessRepairTypeQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessRepairType-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRepairType> findByExample(final BusinessRepairTypeQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessRepairTypeQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessRepairTypeQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessRepairType数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessRepairType entity) throws ServiceException;
	
	/**
	 * 修改BusinessRepairType数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessRepairType entity) throws ServiceException;

	/**
	 * 删除BusinessRepairType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
