package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessToken;
import com.community.app.module.vo.BusinessTokenQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessTokenDao {
		
	/**
	 * 查询单个BusinessToken
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessToken findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessToken
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessToken> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessToken
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessToken> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessToken-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessToken> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessToken
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessToken> findByExample(final BusinessTokenQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessToken-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessToken> findByExample(final BusinessTokenQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessToken> findAllPage(final BusinessTokenQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessTokenQuery query) throws DaoException;
	
	/**
	 * 保存BusinessToken数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessToken entity) throws DaoException;
	
	/**
	 * 修改BusinessToken数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessToken entity) throws DaoException;

	/**
	 * 删除BusinessToken
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
