package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessProductType;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessProductTypeQuery;
import com.community.framework.exception.ServiceException;

public interface BusinessProductTypeService {

	/**
	 * 查询单个BusinessProductType
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessProductType findById(final Integer id)
			throws ServiceException;

	/**
	 * 无条件查询所有BusinessProductType
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessProductType> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessProductType
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessProductType> findByMap(
			final Map<String, Object> paramMap) throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessProductType-限制返回条数
	 * 
	 * @return
	 * @throws ServiceException
	 */
	// public List<BusinessProductType> findByMap(final Map<String, Object>
	// paramMap, final Integer limit) throws ServiceException;

	/**
	 * 按VO对象条件查询所有BusinessProductType
	 * 
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessProductType> findByExample(
			final BusinessProductTypeQuery query) throws ServiceException;

	/**
	 * 按VO对象条件查询所有BusinessProductType-限制返回条数
	 * 
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	// public List<BusinessProductType> findByExample(final
	// BusinessProductTypeQuery query, final Integer limit) throws
	// ServiceException;

	/**
	 * 根据搜索条件，搜索分页数据
	 * 
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessProductTypeQuery query)
			throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * 
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessProductTypeQuery query)
			throws ServiceException;

	/**
	 * 保存BusinessProductType数据
	 * 
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessProductType entity) throws ServiceException;

	/**
	 * 修改BusinessProductType数据
	 * 
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessProductType entity)
			throws ServiceException;

	/**
	 * 删除BusinessProductType
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
}