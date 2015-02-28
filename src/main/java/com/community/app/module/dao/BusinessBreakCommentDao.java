package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessBreakComment;
import com.community.app.module.vo.BusinessBreakCommentQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessBreakCommentDao {
	
	/**
	 * 根据爆料ID查询所有回复的爆料BusinessBreakComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakComment> findCommentListByBreakId(final BusinessBreakCommentQuery query) throws DaoException;
	
	/**
	 * 查询单个BusinessBreakComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessBreakComment findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessBreakComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakComment> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessBreakComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreakComment> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessBreakComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessBreakComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessBreakComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreakComment> findByExample(final BusinessBreakCommentQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessBreakComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessBreakComment> findByExample(final BusinessBreakCommentQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakComment> findAllPage(final BusinessBreakCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessBreakCommentQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakComment> findAllPage_app(final BusinessBreakCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessBreakCommentQuery query) throws DaoException;
	
	/**
	 * 保存BusinessBreakComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessBreakComment entity) throws DaoException;
	
	/**
	 * 回复保存BusinessBreakComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public int replySave(final BusinessBreakComment entity) throws DaoException;
	
	/**
	 * 修改BusinessBreakComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessBreakComment entity) throws DaoException;

	/**
	 * 删除BusinessBreakComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
