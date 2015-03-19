package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessOpertaion;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessOpertaionQuery;
import com.community.framework.exception.ServiceException;

public interface BusinessOpertaionService {

	/**
	 * 查询单个BusinessOpertaion
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessOpertaion findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessOpertaion
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessOpertaion> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessOpertaion
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessOpertaion> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessOpertaion-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessOpertaion> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessOpertaion
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessOpertaion> findByExample(final BusinessOpertaionQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessOpertaion-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessOpertaion> findByExample(final BusinessOpertaionQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessOpertaionQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessOpertaionQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessOpertaion数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessOpertaion entity) throws ServiceException;
	
	/**
	 * 修改BusinessOpertaion数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessOpertaion entity) throws ServiceException;

	/**
	 * 删除BusinessOpertaion
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
}