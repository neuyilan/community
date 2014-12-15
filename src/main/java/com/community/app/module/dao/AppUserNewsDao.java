package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.AppUserNews;
import com.community.app.module.vo.AppUserNewsQuery;

@Repository
public interface AppUserNewsDao {
		
	/**
	 * 查询单个AppUserNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppUserNews findById(final Integer id) throws DaoException;
	
	/**
	 * 获取家庭申请id
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppUserNews findById_family_id(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有AppUserNews
	 * @return
	 * @throws DaoException
	 */
	public List<AppUserNews> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有AppUserNews
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserNews> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有AppUserNews-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserNews> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有AppUserNews
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserNews> findByExample(final AppUserNewsQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有AppUserNews-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserNews> findByExample(final AppUserNewsQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppUserNews> findAllPage(final AppUserNewsQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppUserNewsQuery query) throws DaoException;
	
	/**
	 * 保存AppUserNews数据
	 * @param entity
	 * @throws DaoException
	 */
	public AppUserNews save(final AppUserNews entity) throws DaoException;
	
	/**
	 * 保存AppUserNews数据
	 * @param entity
	 * @throws DaoException
	 */
	public void saveReply(final AppUserNews entity) throws DaoException;
	
	/**
	 * 修改AppUserNews数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppUserNews entity) throws DaoException;

	/**
	 * 删除AppUserNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 根据类型和来源id删除回复我的
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean deleteType(final AppUserNews entity) throws DaoException;

}
