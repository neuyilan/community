package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.AppEstateUser;
import com.community.app.module.vo.AppEstateUserQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Repository
public interface AppEstateUserDao {
		
	/**
	 * 查询单个AppEstateUser
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppEstateUser findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有AppEstateUser
	 * @return
	 * @throws DaoException
	 */
	public List<AppEstateUser> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有AppEstateUser
	 * @return
	 * @throws DaoException
	 */	
	public List<AppEstateUser> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有AppEstateUser-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<AppEstateUser> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有AppEstateUser
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppEstateUser> findByExample(final AppEstateUserQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有AppEstateUser
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppEstateUser> findByExample_app(final AppEstateUserQuery query) throws DaoException;	

	
	/**
	 * 按VO对象条件查询所有AppEstateUser-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppEstateUser> findByExample(final AppEstateUserQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppEstateUser> findAllPage(final AppEstateUserQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppEstateUserQuery query) throws DaoException;
	
	/**
	 * 保存AppEstateUser数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppEstateUser entity) throws DaoException;
	
	/**
	 * service
	 * 修改AppEstateUser数据
	 * @param entity
	 * @throws DaoException
	 */
	public AppEstateUser update(final AppEstateUser entity) throws DaoException;

	/**
	 * 删除AppEstateUser
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 根据userId获取小区列表
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppEstateUser> findByUserId(final AppEstateUserQuery query)  throws DaoException;	


}
