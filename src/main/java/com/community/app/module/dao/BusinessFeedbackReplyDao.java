package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessFeedbackReply;
import com.community.app.module.vo.BusinessFeedbackReplyQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessFeedbackReplyDao {
		
	/**
	 * 查询单个BusinessFeedbackReply
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFeedbackReply findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessFeedbackReply
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedbackReply> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessFeedbackReply
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedbackReply> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackReply-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessFeedbackReply> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackReply
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedbackReply> findByExample(final BusinessFeedbackReplyQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessFeedbackReply-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessFeedbackReply> findByExample(final BusinessFeedbackReplyQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedbackReply> findAllPage(final BusinessFeedbackReplyQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFeedbackReplyQuery query) throws DaoException;
	
	/**
	 * 保存BusinessFeedbackReply数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessFeedbackReply entity) throws DaoException;
	
	/**
	 * 修改BusinessFeedbackReply数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFeedbackReply entity) throws DaoException;

	/**
	 * 删除BusinessFeedbackReply
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
