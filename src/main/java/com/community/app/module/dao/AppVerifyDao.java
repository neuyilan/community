package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.AppVerify;
import com.community.app.module.vo.AppVerifyQuery;

@Repository
public interface AppVerifyDao {
		
	/**
	 * 查询单个AppVerify
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppVerify findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有AppVerify
	 * @return
	 * @throws DaoException
	 */
	public List<AppVerify> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有AppVerify
	 * @return
	 * @throws DaoException
	 */	
	public List<AppVerify> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有AppVerify-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<AppVerify> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有AppVerify
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppVerify> findByExample(final AppVerifyQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有AppVerify-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppVerify> findByExample(final AppVerifyQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppVerify> findAllPage(final AppVerifyQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppVerifyQuery query) throws DaoException;
	
	/**
	 * 保存AppVerify数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppVerify entity) throws DaoException;
	
	/**
	 * 修改AppVerify数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppVerify entity) throws DaoException;

	/**
	 * 删除AppVerify
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final AppVerifyQuery query) throws DaoException;

}
