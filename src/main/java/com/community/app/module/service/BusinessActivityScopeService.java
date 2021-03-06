package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessActivityScope;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityScopeQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessActivityScopeService {

	/**
	 * 查询单个BusinessActivityScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessActivityScope findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessActivityScope
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessActivityScope> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessActivityScope
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityScope> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityScope-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityScope> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessActivityScope
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityScope> findByExample(final BusinessActivityScopeQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityScope-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityScope> findByExample(final BusinessActivityScopeQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessActivityScopeQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessActivityScopeQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessActivityScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessActivityScope entity) throws ServiceException;
	
	/**
	 * 修改BusinessActivityScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessActivityScope entity) throws ServiceException;

	/**
	 * 删除BusinessActivityScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
