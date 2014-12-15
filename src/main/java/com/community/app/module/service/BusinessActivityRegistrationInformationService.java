package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessActivityRegistrationInformation;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityRegistrationInformationQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessActivityRegistrationInformationService {

	/**
	 * 查询单个BusinessActivityRegistrationInformation
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessActivityRegistrationInformation findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessActivityRegistrationInformation
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessActivityRegistrationInformation> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessActivityRegistrationInformation
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityRegistrationInformation> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityRegistrationInformation-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityRegistrationInformation> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessActivityRegistrationInformation
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityRegistrationInformation> findByExample(final BusinessActivityRegistrationInformationQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityRegistrationInformation-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityRegistrationInformation> findByExample(final BusinessActivityRegistrationInformationQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessActivityRegistrationInformationQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessActivityRegistrationInformationQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessActivityRegistrationInformation数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessActivityRegistrationInformation entity) throws ServiceException;
	
	/**
	 * 修改BusinessActivityRegistrationInformation数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessActivityRegistrationInformation entity) throws ServiceException;

	/**
	 * 删除BusinessActivityRegistrationInformation
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
