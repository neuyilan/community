package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessNewsSupport;
import com.community.app.module.vo.BusinessNewsSupportQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessNewsSupportDao {
		
	/**
	 * 查询单个BusinessNewsSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNewsSupport findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessNewsSupport
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsSupport> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessNewsSupport
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsSupport> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessNewsSupport-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsSupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessNewsSupport
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsSupport> findByExample(final BusinessNewsSupportQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessNewsSupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsSupport> findByExample(final BusinessNewsSupportQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsSupport> findAllPage(final BusinessNewsSupportQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessNewsSupportQuery query) throws DaoException;
	
	/**
	 * 保存BusinessNewsSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessNewsSupport entity) throws DaoException;
	
	/**
	 * 修改BusinessNewsSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessNewsSupport entity) throws DaoException;

	/**
	 * 删除BusinessNewsSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
