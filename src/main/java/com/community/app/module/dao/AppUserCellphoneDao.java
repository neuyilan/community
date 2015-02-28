package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.AppUserCellphone;
import com.community.app.module.vo.AppUserCellphoneQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface AppUserCellphoneDao {
		
	/**
	 * 查询单个AppUserCellphone
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppUserCellphone findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有AppUserCellphone
	 * @return
	 * @throws DaoException
	 */
	public List<AppUserCellphone> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有AppUserCellphone
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserCellphone> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有AppUserCellphone-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserCellphone> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有AppUserCellphone
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserCellphone> findByExample(final AppUserCellphoneQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有AppUserCellphone-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserCellphone> findByExample(final AppUserCellphoneQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppUserCellphone> findAllPage(final AppUserCellphoneQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppUserCellphoneQuery query) throws DaoException;
	
	/**
	 * 保存AppUserCellphone数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppUserCellphone entity) throws DaoException;
	
	/**
	 * 修改AppUserCellphone数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppUserCellphone entity) throws DaoException;

	/**
	 * 删除AppUserCellphone
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
