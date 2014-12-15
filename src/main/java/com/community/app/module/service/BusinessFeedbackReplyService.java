package com.community.app.module.service;

import java.util.List;
import java.util.Map;


import com.community.app.module.bean.BusinessFeedbackReply;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFeedbackReplyQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessFeedbackReplyService {

	/**
	 * 查询单个BusinessFeedbackReply
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessFeedbackReply findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessFeedbackReply
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessFeedbackReply> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessFeedbackReply
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFeedbackReply> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackReply-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessFeedbackReply> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackReply
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFeedbackReply> findByExample(final BusinessFeedbackReplyQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessFeedbackReply-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessFeedbackReply> findByExample(final BusinessFeedbackReplyQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessFeedbackReplyQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessFeedbackReplyQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessFeedbackReply数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessFeedbackReply entity) throws ServiceException;
	
	/**
	 * 修改BusinessFeedbackReply数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessFeedbackReply entity) throws ServiceException;

	/**
	 * 删除BusinessFeedbackReply
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
