package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessNewspaperScope;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessNewspaperScopeQuery;
import com.community.framework.exception.ServiceException;

public interface BusinessNewspaperScopeService {

	/**
	 * 查询单个BusinessNewspaperScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessNewspaperScope findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessNewspaperScope
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessNewspaperScope> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessNewspaperScope
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNewspaperScope> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessNewspaperScope-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessNewspaperScope> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessNewspaperScope
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNewspaperScope> findByExample(final BusinessNewspaperScopeQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessNewspaperScope-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessNewspaperScope> findByExample(final BusinessNewspaperScopeQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessNewspaperScopeQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessNewspaperScopeQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessNewspaperScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessNewspaperScope entity) throws ServiceException;
	
	/**
	 * 修改BusinessNewspaperScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessNewspaperScope entity) throws ServiceException;

	/**
	 * 删除BusinessNewspaperScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
}