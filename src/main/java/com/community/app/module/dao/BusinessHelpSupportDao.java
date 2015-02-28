package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessHelpSupport;
import com.community.app.module.vo.BusinessHelpSupportQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessHelpSupportDao {
		
	/**
	 * 查询单个BusinessHelpSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHelpSupport findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessHelpSupport
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpSupport> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessHelpSupport
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpSupport> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessHelpSupport-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpSupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessHelpSupport
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpSupport> findByExample(final BusinessHelpSupportQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessHelpSupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpSupport> findByExample(final BusinessHelpSupportQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpSupport> findAllPage(final BusinessHelpSupportQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHelpSupportQuery query) throws DaoException;
	
	/**
	 * 保存BusinessHelpSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHelpSupport entity) throws DaoException;
	
	/**
	 * 修改BusinessHelpSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHelpSupport entity) throws DaoException;

	/**
	 * 删除BusinessHelpSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
