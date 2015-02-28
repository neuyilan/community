package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessProductComment;
import com.community.app.module.vo.BusinessProductCommentQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessProductCommentDao {
		
	/**
	 * 查询单个BusinessProductComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessProductComment findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessProductComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductComment> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessProductComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductComment> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessProductComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessProductComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessProductComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductComment> findByExample(final BusinessProductCommentQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessProductComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessProductComment> findByExample(final BusinessProductCommentQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductComment> findAllPage(final BusinessProductCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessProductCommentQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductComment> findAllPage_app(final BusinessProductCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessProductCommentQuery query) throws DaoException;

	
	/**
	 * 保存BusinessProductComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessProductComment entity) throws DaoException;
	
	/**
	 * 后台评论回复
	 * 保存BusinessProductComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void replySave(final BusinessProductComment entity) throws DaoException;
	
	/**
	 * 修改BusinessProductComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessProductComment entity) throws DaoException;

	/**
	 * 删除BusinessProductComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}