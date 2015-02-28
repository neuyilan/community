package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessFeedbackComment;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFeedbackCommentQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessFeedbackCommentService {

	/**
	 * 查询单个BusinessFeedbackComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessFeedbackComment findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessFeedbackComment
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessFeedbackComment> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessFeedbackComment
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFeedbackComment> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackComment-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessFeedbackComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * service
	 * 按VO对象条件查询所有BusinessFeedbackComment
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFeedbackComment> findByExample(final BusinessFeedbackCommentQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessFeedbackComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessFeedbackComment> findByExample(final BusinessFeedbackCommentQuery query, final Integer limit) throws ServiceException;	

	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessFeedbackCommentQuery query) throws ServiceException;

	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessFeedbackCommentQuery query) throws ServiceException;

	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessFeedbackCommentQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessFeedbackComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessFeedbackComment entity) throws ServiceException;
	
	/**
	 * 保存BusinessFeedbackComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save_manage(final BusinessFeedbackComment entity) throws ServiceException;
	
	/**
	 * 修改BusinessFeedbackComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessFeedbackComment entity) throws ServiceException;

	/**
	 * 删除BusinessFeedbackComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
