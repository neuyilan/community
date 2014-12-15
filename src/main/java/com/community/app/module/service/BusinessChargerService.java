package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessCharger;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessChargerQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessChargerService {

	/**
	 * 查询单个BusinessCharger
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessCharger findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessCharger
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessCharger> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessCharger
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessCharger> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessCharger-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessCharger> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessCharger
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessCharger> findByExample(final BusinessChargerQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessCharger-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessCharger> findByExample(final BusinessChargerQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessChargerQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessChargerQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessCharger数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessCharger entity) throws ServiceException;
	
	/**
	 * 修改BusinessCharger数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessCharger entity) throws ServiceException;

	/**
	 * 删除BusinessCharger
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

	public void savelargeData(final List list) throws ServiceException;

}
