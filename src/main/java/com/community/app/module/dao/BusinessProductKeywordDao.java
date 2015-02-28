package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessProductKeyword;
import com.community.app.module.vo.BusinessProductKeywordQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessProductKeywordDao {
		
	/**
	 * 查询单个BusinessProductKeyword
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessProductKeyword findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessProductKeyword
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductKeyword> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessProductKeyword
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductKeyword> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessProductKeyword-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessProductKeyword> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessProductKeyword
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductKeyword> findByExample(final BusinessProductKeywordQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessProductKeyword-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessProductKeyword> findByExample(final BusinessProductKeywordQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductKeyword> findAllPage(final BusinessProductKeywordQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessProductKeywordQuery query) throws DaoException;
	
	/**
	 * 保存BusinessProductKeyword数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessProductKeyword entity) throws DaoException;
	
	/**
	 * 修改BusinessProductKeyword数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessProductKeyword entity) throws DaoException;

	/**
	 * 删除BusinessProductKeyword
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
