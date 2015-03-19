package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessOpertaion;
import com.community.app.module.vo.BusinessOpertaionQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessOpertaionDao {
		
	/**
	 * 查询单个BusinessOpertaion
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessOpertaion findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessOpertaion
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessOpertaion> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessOpertaion
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessOpertaion> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessOpertaion-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessOpertaion> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessOpertaion
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessOpertaion> findByExample(final BusinessOpertaionQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessOpertaion-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessOpertaion> findByExample(final BusinessOpertaionQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessOpertaion> findAllPage(final BusinessOpertaionQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessOpertaionQuery query) throws DaoException;
	
	/**
	 * 保存BusinessOpertaion数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessOpertaion entity) throws DaoException;
	
	/**
	 * 修改BusinessOpertaion数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessOpertaion entity) throws DaoException;

	/**
	 * 删除BusinessOpertaion
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
}