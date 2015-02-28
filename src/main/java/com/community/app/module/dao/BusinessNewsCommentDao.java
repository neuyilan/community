package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessNewsComment;
import com.community.app.module.vo.BusinessNewsCommentQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessNewsCommentDao {
		
	/**
	 * 查询单个BusinessNewsComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNewsComment findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessNewsComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsComment> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessNewsComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsComment> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessNewsComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessNewsComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessNewsComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsComment> findByExample(final BusinessNewsCommentQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessNewsComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessNewsComment> findByExample(final BusinessNewsCommentQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsComment> findAllPage(final BusinessNewsCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessNewsCommentQuery query) throws DaoException;
	
	/**
	 * 后台新闻评论
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsComment> findAllPage_manage(final BusinessNewsCommentQuery query) throws DaoException;

	/**
	 *  后台新闻评论
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_manage(final BusinessNewsCommentQuery query) throws DaoException;
	
	/**
	 * 保存BusinessNewsComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessNewsComment entity) throws DaoException;
	
	/**
	 * 后台评论回复
	 * 保存BusinessNewsComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void replySave(final BusinessNewsComment entity) throws DaoException;
	
	/**
	 * 修改BusinessNewsComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessNewsComment entity) throws DaoException;

	/**
	 * 删除BusinessNewsComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
