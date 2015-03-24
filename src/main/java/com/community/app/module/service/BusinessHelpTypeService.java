package com.community.app.module.service;


import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessHelpType;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHelpTypeQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessHelpTypeService {

	/**
	 * 查询单个BusinessHelpType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessHelpType findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessHelpType
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessHelpType> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessHelpType
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelpType> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessHelpType-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessHelpType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessHelpType
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelpType> findByExample(final BusinessHelpTypeQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessHelpType-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessHelpType> findByExample(final BusinessHelpTypeQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessHelpTypeQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessHelpTypeQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessHelpType数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessHelpType entity) throws ServiceException;
	
	/**
	 * 修改BusinessHelpType数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessHelpType entity) throws ServiceException;

	/**
	 * 删除BusinessHelpType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
