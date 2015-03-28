package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessStationFeedback;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessStationFeedbackQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessStationFeedbackService {

	/**
	 * 查询单个BusinessStationFeedback
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessStationFeedback findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessStationFeedback
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessStationFeedback> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessStationFeedback
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessStationFeedback> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessStationFeedback-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessStationFeedback> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessStationFeedback
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessStationFeedback> findByExample(final BusinessStationFeedbackQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessStationFeedback-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessStationFeedback> findByExample(final BusinessStationFeedbackQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessStationFeedbackQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessStationFeedbackQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessStationFeedback数据
	 * @param entity
	 * @throws ServiceException
	 */
	public int save(final BusinessStationFeedback entity) throws ServiceException;
	
	/**
	 * 修改BusinessStationFeedback数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessStationFeedback entity) throws ServiceException;

	/**
	 * 删除BusinessStationFeedback
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
}