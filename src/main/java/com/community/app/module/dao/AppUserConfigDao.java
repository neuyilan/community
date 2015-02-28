package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.AppUserConfig;
import com.community.app.module.vo.AppUserConfigQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface AppUserConfigDao {
		
	/**
	 * 查询单个AppUserConfig
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppUserConfig findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有AppUserConfig
	 * @return
	 * @throws DaoException
	 */
	public List<AppUserConfig> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有AppUserConfig
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserConfig> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有AppUserConfig-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserConfig> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有AppUserConfig
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserConfig> findByExample(final AppUserConfigQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有AppUserConfig
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserConfig> findByExample_app(final AppUserConfigQuery query) throws DaoException;	

	
	/**
	 * 按VO对象条件查询所有AppUserConfig-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserConfig> findByExample(final AppUserConfigQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppUserConfig> findAllPage(final AppUserConfigQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppUserConfigQuery query) throws DaoException;
	
	/**
	 * 保存AppUserConfig数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppUserConfig entity) throws DaoException;
	
	/**
	 * 修改AppUserConfig数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppUserConfig entity) throws DaoException;

	/**
	 * 删除AppUserConfig
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
