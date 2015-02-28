package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessFeedback;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFeedbackQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessFeedbackService {

	/**
	 * 查询单个BusinessFeedback
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessFeedback findById(final Integer id) throws ServiceException;
	
	/**
	 * service
	 * 查询单个BusinessFeedback
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessFeedback findById_app(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessFeedback
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessFeedback> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessFeedback
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFeedback> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessFeedback-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessFeedback> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessFeedback
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFeedback> findByExample(final BusinessFeedbackQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessFeedback-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessFeedback> findByExample(final BusinessFeedbackQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessFeedbackQuery query) throws ServiceException;

	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessFeedbackQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessFeedbackQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessFeedback数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessFeedback entity) throws ServiceException;
	
	/**
	 * 修改BusinessFeedback数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessFeedback entity) throws ServiceException;
	
	/**
	 * 评价
	 * @param entity
	 * @throws ServiceException
	 */
	public void evaluation(final BusinessFeedback entity,final BusinessFeedbackQuery query) throws ServiceException;
	
	/**
	 * 删除BusinessFeedback
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 用户发布反馈
	 * @param entity
	 * @throws ServiceException
	 */
	public void publishPropertyComplaint(final BusinessFeedbackQuery query) throws ServiceException;

}
