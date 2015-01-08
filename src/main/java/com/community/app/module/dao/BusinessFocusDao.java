package com.community.app.module.dao;

import java.util.List;
import java.util.Map;


import com.community.framework.exception.DaoException;
import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessFocus;
import com.community.app.module.vo.BusinessFocusQuery;

@Repository
public interface BusinessFocusDao {
		
	/**
	 * 查询单个BusinessFocus
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFocus findById(final Integer id) throws DaoException;
	
	/**
	 * 查询单个BusinessFocus
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFocus> findById_app(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessFocus
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFocus> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessFocus
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFocus> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessFocus-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessFocus> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessFocus
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFocus> findByExample(final BusinessFocusQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessFocus-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessFocus> findByExample(final BusinessFocusQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFocus> findAllPage(final BusinessFocusQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFocusQuery query) throws DaoException;
	
	/**
	 * 保存BusinessFocus数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessFocus entity) throws DaoException;
	
	/**
	 * 修改BusinessFocus数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFocus entity) throws DaoException;

	/**
	 * 删除BusinessFocus
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

	
	/**
	 * service
	 * 修改BusinessFocus浏览量
	 * @param entity
	 * @throws DaoException
	 */
	public void updateVisits(final BusinessFocus entity) throws DaoException;

}
