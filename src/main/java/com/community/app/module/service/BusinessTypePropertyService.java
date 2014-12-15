package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessTypeProperty;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessTypePropertyQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessTypePropertyService {

	/**
	 * 查询单个BusinessTypeProperty
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessTypeProperty findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessTypeProperty
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessTypeProperty> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessTypeProperty
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessTypeProperty> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessTypeProperty-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessTypeProperty> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessTypeProperty
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessTypeProperty> findByExample(final BusinessTypePropertyQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessTypeProperty-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessTypeProperty> findByExample(final BusinessTypePropertyQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessTypePropertyQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessTypePropertyQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessTypeProperty数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessTypeProperty entity) throws ServiceException;
	
	/**
	 * 修改BusinessTypeProperty数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessTypeProperty entity) throws ServiceException;

	/**
	 * 删除BusinessTypeProperty
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
