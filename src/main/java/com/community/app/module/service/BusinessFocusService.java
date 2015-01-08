package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessFocus;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFocusQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessFocusService {

	/**
	 * 查询单个BusinessFocus
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessFocus findById(final Integer id) throws ServiceException;
	
	/**
	 * 查询单个BusinessFocus
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessFocus> findById_app(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessFocus
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessFocus> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessFocus
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFocus> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessFocus-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessFocus> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessFocus
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFocus> findByExample(final BusinessFocusQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessFocus-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessFocus> findByExample(final BusinessFocusQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessFocusQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessFocusQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessFocus数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessFocus entity) throws ServiceException;
	
	/**
	 * 修改BusinessFocus数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessFocus entity) throws ServiceException;

	/**
	 * 删除BusinessFocus
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * service
	 * 修改BusinessFocus浏览量
	 * @param entity
	 * @throws ServiceException
	 */
	public void updateVisits(final BusinessFocus entity) throws ServiceException;

}
