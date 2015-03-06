package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessStationMessage;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessStationMessageQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessStationMessageService {

	/**
	 * 查询单个BusinessStationMessage
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessStationMessage findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessStationMessage
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessStationMessage> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessStationMessage
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessStationMessage> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessStationMessage-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessStationMessage> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessStationMessage
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessStationMessage> findByExample(final BusinessStationMessageQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessStationMessage-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessStationMessage> findByExample(final BusinessStationMessageQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据用户查询所管理的小区所对应的驿站
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessStationMessage> findByStationId(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessStationMessageQuery query) throws ServiceException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessStationMessageQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessStationMessageQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessStationMessage数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessStationMessage entity) throws ServiceException;
	
	/**
	 * 修改BusinessStationMessage数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessStationMessage entity) throws ServiceException;

	/**
	 * 删除BusinessStationMessage
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
}