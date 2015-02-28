package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessNewsScope;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessNewsScopeQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessNewsScopeService {

	/**
	 * 查询单个BusinessNewsScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessNewsScope findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessNewsScope
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessNewsScope> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessNewsScope
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNewsScope> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessNewsScope-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessNewsScope> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessNewsScope
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNewsScope> findByExample(final BusinessNewsScopeQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessNewsScope-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessNewsScope> findByExample(final BusinessNewsScopeQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页所有数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessNewsScopeQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessNewsScopeQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessNewsScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessNewsScope entity) throws ServiceException;
	
	/**
	 * 修改BusinessNewsScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessNewsScope entity) throws ServiceException;

	/**
	 * 删除BusinessNewsScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 根据搜索条件，搜索分页所需的数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessNewsScopeQuery query) throws ServiceException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List findListByField(final Map fieldMap, final BusinessNewsScopeQuery query) throws ServiceException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessNewsScope findByField(final Map fieldMap, final Integer id) throws ServiceException;

	/**
	 * 删除新闻范围
	 * @param newsId
	 * @throws ServiceException
	 */
	public boolean deleteScopeByNews(final Integer newsId) throws ServiceException;
	
}
