package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessFeedbackComment;
import com.community.app.module.vo.BusinessFeedbackCommentQuery;

@Repository
public interface BusinessFeedbackCommentDao {
		
	/**
	 * 查询单个BusinessFeedbackComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFeedbackComment findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessFeedbackComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedbackComment> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessFeedbackComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedbackComment> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessFeedbackComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedbackComment> findByExample(final BusinessFeedbackCommentQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessFeedbackComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessFeedbackComment> findByExample(final BusinessFeedbackCommentQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedbackComment> findAllPage(final BusinessFeedbackCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFeedbackCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedbackComment> findAllPage_app(final BusinessFeedbackCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessFeedbackCommentQuery query) throws DaoException;

	
	/**
	 * 保存BusinessFeedbackComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessFeedbackComment entity) throws DaoException;
	
	/**
	 * 保存BusinessFeedbackComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save_manage(final BusinessFeedbackComment entity) throws DaoException;
	
	/**
	 * 修改BusinessFeedbackComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFeedbackComment entity) throws DaoException;
	
	/**
	 * 修改BusinessFeedbackComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update_app(final BusinessFeedbackComment entity) throws DaoException;

	/**
	 * 删除BusinessFeedbackComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
