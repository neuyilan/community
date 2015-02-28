package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.AppEstateUser;
import com.community.app.module.vo.AppEstateUserQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;


public interface AppEstateUserService {

	/**
	 * 查询单个AppEstateUser
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public AppEstateUser findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有AppEstateUser
	 * @return
	 * @throws ServiceException
	 */
	public List<AppEstateUser> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有AppEstateUser
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppEstateUser> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有AppEstateUser-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppEstateUser> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有AppEstateUser
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppEstateUser> findByExample(final AppEstateUserQuery query) throws ServiceException;	
	
	/**
	 * 按VO对象条件查询所有AppEstateUser
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppEstateUser> findByExample_app(final AppEstateUserQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有AppEstateUser-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppEstateUser> findByExample(final AppEstateUserQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final AppEstateUserQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final AppEstateUserQuery query) throws ServiceException;
	
	/**
	 * 保存AppEstateUser数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final AppEstateUser entity) throws ServiceException;
	
	/**
	 * service
	 * 修改AppEstateUser数据
	 * @param entity
	 * @throws ServiceException
	 */
	public AppEstateUser update(final AppEstateUser entity) throws ServiceException;
	
	/**
	 * service
	 * 用户变更小区
	 * @param entity
	 * @throws ServiceException
	 */
	public String update_app(final AppEstateUserQuery query) throws ServiceException;

	/**
	 * 删除AppEstateUser
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 根据userId获取小区列表
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppEstateUser> findByUserId(final AppEstateUserQuery query) throws ServiceException;	


}
