package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessLifeProp;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessLifePropQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessLifePropService {

	/**
	 * 查询单个BusinessLifeProp
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessLifeProp findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessLifeProp
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessLifeProp> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessLifeProp
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessLifeProp> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessLifeProp-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessLifeProp> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessLifeProp
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessLifeProp> findByExample(final BusinessLifePropQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessLifeProp-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessLifeProp> findByExample(final BusinessLifePropQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessLifePropQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessLifePropQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessLifeProp数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessLifeProp entity) throws ServiceException;
	
	/**
	 * 修改BusinessLifeProp数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessLifeProp entity) throws ServiceException;

	/**
	 * 删除BusinessLifeProp
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

    /**
     * 删除属性
     * @param id
     * @return
     * @throws ServiceException
     */
	public boolean deleteLifeProp(final Integer id) throws ServiceException;

}
