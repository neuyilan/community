package com.community.app.module.service;



import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessActivityQnhInformation;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityQnhInformationQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessActivityQnhInformationService {

	/**
	 * 查询单个BusinessActivityQnhInformation
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessActivityQnhInformation findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessActivityQnhInformation
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessActivityQnhInformation> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessActivityQnhInformation
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityQnhInformation> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityQnhInformation-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityQnhInformation> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessActivityQnhInformation
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityQnhInformation> findByExample(final BusinessActivityQnhInformationQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityQnhInformation-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityQnhInformation> findByExample(final BusinessActivityQnhInformationQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessActivityQnhInformationQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessActivityQnhInformationQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessActivityQnhInformation数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessActivityQnhInformation entity) throws ServiceException;
	
	/**
	 * 修改BusinessActivityQnhInformation数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessActivityQnhInformation entity) throws ServiceException;

	/**
	 * 删除BusinessActivityQnhInformation
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
