package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessHelpExpendestates;
import com.community.app.module.vo.BusinessHelpExpendestatesQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessHelpExpendestatesDao {
		
	/**
	 * 查询单个BusinessHelpExpendestates
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHelpExpendestates findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessHelpExpendestates
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpExpendestates> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessHelpExpendestates
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpExpendestates> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessHelpExpendestates-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessHelpExpendestates> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessHelpExpendestates
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpExpendestates> findByExample(final BusinessHelpExpendestatesQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessHelpExpendestates-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessHelpExpendestates> findByExample(final BusinessHelpExpendestatesQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpExpendestates> findAllPage(final BusinessHelpExpendestatesQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHelpExpendestatesQuery query) throws DaoException;
	
	/**
	 * 保存BusinessHelpExpendestates数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHelpExpendestates entity) throws DaoException;
	
	/**
	 * 修改BusinessHelpExpendestates数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHelpExpendestates entity) throws DaoException;

	/**
	 * 删除BusinessHelpExpendestates
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
}