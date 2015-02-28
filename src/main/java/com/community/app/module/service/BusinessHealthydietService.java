package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessHealthydiet;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHealthydietQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessHealthydietService {

	/**
	 * 查询单个BusinessHealthydiet
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessHealthydiet findById(final Integer id) throws ServiceException;
	
	/**
	 * 查询单个BusinessHealthydiet
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessHealthydiet findById_app(final Integer id) throws ServiceException;
	
	
	/**
	 * 无条件查询所有BusinessHealthydiet
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessHealthydiet> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessHealthydiet
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHealthydiet> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessHealthydiet-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessHealthydiet> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessHealthydiet
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHealthydiet> findByExample(final BusinessHealthydietQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessHealthydiet-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessHealthydiet> findByExample(final BusinessHealthydietQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessHealthydietQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessHealthydietQuery query) throws ServiceException;

	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessHealthydietQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessHealthydiet数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessHealthydiet entity) throws ServiceException;
	
	/**
	 * 修改BusinessHealthydiet数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessHealthydiet entity) throws ServiceException;

	/**
	 * 删除BusinessHealthydiet
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
