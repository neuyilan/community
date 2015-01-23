package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessShopType;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessShopTypeQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessShopTypeService {

	/**
	 * 查询单个BusinessShopType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessShopType findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessShopType
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessShopType> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessShopType
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessShopType> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessShopType-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessShopType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessShopType
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessShopType> findByExample(final BusinessShopTypeQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessShopType-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessShopType> findByExample(final BusinessShopTypeQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessShopTypeQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessShopTypeQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessShopType数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessShopType entity) throws ServiceException;
	
	/**
	 * 修改BusinessShopType数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessShopType entity) throws ServiceException;

	/**
	 * 删除BusinessShopType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
