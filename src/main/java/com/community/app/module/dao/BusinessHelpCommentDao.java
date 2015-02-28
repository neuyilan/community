package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessHelpComment;
import com.community.app.module.vo.BusinessHelpCommentQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessHelpCommentDao {
		
	/**
	 * 查询单个BusinessHelpComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHelpComment findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessHelpComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpComment> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessHelpComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpComment> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessHelpComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessHelpComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpComment> findByExample(final BusinessHelpCommentQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessHelpComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpComment> findByExample(final BusinessHelpCommentQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpComment> findAllPage(final BusinessHelpCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHelpCommentQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpComment> findAllPage_app(final BusinessHelpCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessHelpCommentQuery query) throws DaoException;

	
	/**
	 * 保存BusinessHelpComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHelpComment entity) throws DaoException;
	
	/**
	 * 后台评论回复
	 * 保存BusinessHelpComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void replySave(final BusinessHelpComment entity) throws DaoException;
	
	/**
	 * 修改BusinessHelpComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHelpComment entity) throws DaoException;

	/**
	 * 删除BusinessHelpComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
