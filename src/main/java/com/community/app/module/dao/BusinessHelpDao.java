package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import com.community.framework.exception.DaoException;
import org.springframework.stereotype.Repository;


import com.community.app.module.bean.BusinessHelp;
import com.community.app.module.vo.BusinessHelpQuery;

@Repository
public interface BusinessHelpDao {
		
	/**
	 * 查询单个BusinessHelp
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHelp findById(final Integer id) throws DaoException;
	
	/**
	 * 查询单个BusinessHelp
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHelp findById_app(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessHelp
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelp> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessHelp
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelp> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessHelp-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessHelp> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessHelp
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelp> findByExample(final BusinessHelpQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessHelp-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessHelp> findByExample(final BusinessHelpQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelp> findAllPage(final BusinessHelpQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelp> findAllPage_app(final BusinessHelpQuery query) throws DaoException;

	
	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelp> findAllPage1(final BusinessHelpQuery query) throws DaoException;

	/**
	 * service
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount1(final BusinessHelpQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHelpQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessHelpQuery query) throws DaoException;
	
	
	/**
	 * 保存BusinessHelp数据
	 * @param entity
	 * @throws DaoException
	 */
	public BusinessHelp save(final BusinessHelp entity) throws DaoException;
	
	/**
	 * 修改BusinessHelp数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHelp entity) throws DaoException;

	/**
	 * 删除BusinessHelp
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
