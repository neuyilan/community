package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessFocusAd;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFocusAdQuery;
import com.community.framework.exception.ServiceException;

public interface BusinessFocusAdService {

	/**
	 * 查询单个BusinessFocusAd
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessFocusAd findById(final Integer id) throws ServiceException;
	
	/**
	 * 查询单个BusinessFocusAd
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessFocusAd> findById_app(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessFocusAd
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessFocusAd> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessFocusAd
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFocusAd> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessFocusAd-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessFocusAd> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessFocusAd
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFocusAd> findByExample(final BusinessFocusAdQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessFocusAd-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessFocusAd> findByExample(final BusinessFocusAdQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessFocusAdQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessFocusAdQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessFocusAd数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessFocusAd entity) throws ServiceException;
	
	/**
	 * 修改BusinessFocusAd数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessFocusAd entity) throws ServiceException;

	/**
	 * 删除BusinessFocusAd
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * service
	 * 修改BusinessFocusAd浏览量
	 * @param entity
	 * @throws ServiceException
	 */
	public void updateVisits(final BusinessFocusAd entity) throws ServiceException;
}