package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessActivityComment;
import com.community.app.module.vo.BusinessActivityCommentQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessActivityCommentDao {
		
	/**
	 * 查询单个BusinessActivityComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityComment findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessActivityComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityComment> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessActivityComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityComment> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessActivityComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityComment> findByExample(final BusinessActivityCommentQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityComment> findByExample(final BusinessActivityCommentQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityComment> findAllPage(final BusinessActivityCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityCommentQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityComment> findAllPage_app(final BusinessActivityCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessActivityCommentQuery query) throws DaoException;

	
	/**
	 * 保存BusinessActivityComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityComment entity) throws DaoException;
	
	/**
	 * 保存BusinessActivityComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void replySave(final BusinessActivityComment entity) throws DaoException;
	
	/**
	 * 修改BusinessActivityComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityComment entity) throws DaoException;

	/**
	 * 删除BusinessActivityComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
