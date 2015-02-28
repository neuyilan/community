package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessNewsView;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessNewsViewQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessNewsViewService {

	/**
	 * 查询单个BusinessNewsView
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessNewsView findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessNewsView
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessNewsView> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessNewsView
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNewsView> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessNewsView-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessNewsView> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessNewsView
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNewsView> findByExample(final BusinessNewsViewQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessNewsView-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessNewsView> findByExample(final BusinessNewsViewQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessNewsViewQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessNewsViewQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessNewsView数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessNewsView entity) throws ServiceException;
	
	/**
	 * 修改BusinessNewsView数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessNewsView entity) throws ServiceException;

	/**
	 * 删除BusinessNewsView
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
