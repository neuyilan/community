package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessActivitySupport;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivitySupportQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessActivitySupportService {

	/**
	 * 查询单个BusinessActivitySupport
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessActivitySupport findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessActivitySupport
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessActivitySupport> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessActivitySupport
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivitySupport> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivitySupport-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivitySupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessActivitySupport
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivitySupport> findByExample(final BusinessActivitySupportQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessActivitySupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivitySupport> findByExample(final BusinessActivitySupportQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessActivitySupportQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessActivitySupportQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessActivitySupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessActivitySupport entity) throws ServiceException;
	
	/**
	 * 修改BusinessActivitySupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessActivitySupport entity) throws ServiceException;

	/**
	 * 删除BusinessActivitySupport
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
