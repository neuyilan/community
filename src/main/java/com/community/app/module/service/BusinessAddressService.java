package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessAddress;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessAddressQuery;
import com.community.framework.exception.ServiceException;

public interface BusinessAddressService {

	/**
	 * 查询单个BusinessAddress
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessAddress findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessAddress
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessAddress> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessAddress
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessAddress> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessAddress-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessAddress> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessAddress
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessAddress> findByExample(final BusinessAddressQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessAddress-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessAddress> findByExample(final BusinessAddressQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessAddressQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessAddressQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessAddress数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessAddress entity) throws ServiceException;
	
	/**
	 * 修改BusinessAddress数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessAddress entity) throws ServiceException;

	/**
	 * 删除BusinessAddress
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
}