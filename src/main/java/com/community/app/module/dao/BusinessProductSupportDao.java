package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessProductSupport;
import com.community.app.module.vo.BusinessProductSupportQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessProductSupportDao {
		
	/**
	 * 查询单个BusinessProductSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessProductSupport findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessProductSupport
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductSupport> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessProductSupport
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductSupport> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessProductSupport-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductSupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessProductSupport
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductSupport> findByExample(final BusinessProductSupportQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessProductSupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductSupport> findByExample(final BusinessProductSupportQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductSupport> findAllPage(final BusinessProductSupportQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessProductSupportQuery query) throws DaoException;
	
	/**
	 * 保存BusinessProductSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessProductSupport entity) throws DaoException;
	
	/**
	 * 修改BusinessProductSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessProductSupport entity) throws DaoException;

	/**
	 * 删除BusinessProductSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
