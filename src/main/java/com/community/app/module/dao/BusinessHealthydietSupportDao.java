package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessHealthydietSupport;
import com.community.app.module.vo.BusinessHealthydietSupportQuery;

@Repository
public interface BusinessHealthydietSupportDao {
		
	/**
	 * 查询单个BusinessHealthydietSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHealthydietSupport findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessHealthydietSupport
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHealthydietSupport> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessHealthydietSupport
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHealthydietSupport> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessHealthydietSupport-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessHealthydietSupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessHealthydietSupport
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHealthydietSupport> findByExample(final BusinessHealthydietSupportQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessHealthydietSupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessHealthydietSupport> findByExample(final BusinessHealthydietSupportQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHealthydietSupport> findAllPage(final BusinessHealthydietSupportQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHealthydietSupportQuery query) throws DaoException;
	
	/**
	 * 保存BusinessHealthydietSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHealthydietSupport entity) throws DaoException;
	
	/**
	 * 修改BusinessHealthydietSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHealthydietSupport entity) throws DaoException;

	/**
	 * 删除BusinessHealthydietSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
