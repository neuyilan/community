package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessActivityRegistrationTimeslot;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityRegistrationTimeslotQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessActivityRegistrationTimeslotService {

	/**
	 * 查询单个BusinessActivityRegistrationTimeslot
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessActivityRegistrationTimeslot findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessActivityRegistrationTimeslot
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessActivityRegistrationTimeslot> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessActivityRegistrationTimeslot
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityRegistrationTimeslot> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityRegistrationTimeslot-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityRegistrationTimeslot> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessActivityRegistrationTimeslot
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityRegistrationTimeslot> findByExample(final BusinessActivityRegistrationTimeslotQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityRegistrationTimeslot-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityRegistrationTimeslot> findByExample(final BusinessActivityRegistrationTimeslotQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessActivityRegistrationTimeslotQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessActivityRegistrationTimeslotQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessActivityRegistrationTimeslot数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessActivityRegistrationTimeslot entity) throws ServiceException;
	
	/**
	 * 修改BusinessActivityRegistrationTimeslot数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessActivityRegistrationTimeslot entity) throws ServiceException;

	/**
	 * 删除BusinessActivityRegistrationTimeslot
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
}