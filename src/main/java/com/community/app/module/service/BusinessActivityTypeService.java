package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessActivityType;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityTypeQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessActivityTypeService {

	/**
	 * 查询单个BusinessActivityType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessActivityType findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessActivityType
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessActivityType> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessActivityType
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityType> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityType-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessActivityType
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityType> findByExample(final BusinessActivityTypeQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityType-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityType> findByExample(final BusinessActivityTypeQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessActivityTypeQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessActivityTypeQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessActivityType数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessActivityType entity) throws ServiceException;
	
	/**
	 * 修改BusinessActivityType数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessActivityType entity) throws ServiceException;

	/**
	 * 删除BusinessActivityType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
