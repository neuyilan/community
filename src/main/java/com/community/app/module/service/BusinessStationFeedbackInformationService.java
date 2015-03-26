package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessStationFeedbackInformation;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessStationFeedbackInformationQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessStationFeedbackInformationService {

	/**
	 * 查询单个BusinessStationFeedbackInformation
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessStationFeedbackInformation findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessStationFeedbackInformation
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessStationFeedbackInformation> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessStationFeedbackInformation
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessStationFeedbackInformation> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessStationFeedbackInformation-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessStationFeedbackInformation> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessStationFeedbackInformation
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessStationFeedbackInformation> findByExample(final BusinessStationFeedbackInformationQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessStationFeedbackInformation-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessStationFeedbackInformation> findByExample(final BusinessStationFeedbackInformationQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessStationFeedbackInformationQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessStationFeedbackInformationQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessStationFeedbackInformation数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessStationFeedbackInformation entity) throws ServiceException;
	
	/**
	 * 修改BusinessStationFeedbackInformation数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessStationFeedbackInformation entity) throws ServiceException;

	/**
	 * 删除BusinessStationFeedbackInformation
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
}