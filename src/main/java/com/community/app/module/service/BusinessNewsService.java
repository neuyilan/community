package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessNews;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessNewsQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessNewsService {

	/**
	 * 查询单个BusinessNews
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessNews findById(final Integer id) throws ServiceException;
	
	/**
	 * 查询单个BusinessNews
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessNews findById_app(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessNews
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessNews> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessNews
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNews> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 根据newId查询当前所有置顶的新闻
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessNews> findAllHotById() throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessNews-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessNews> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * service
	 * 按VO对象条件查询所有BusinessNews
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNews> findByExample(final BusinessNewsQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessNews-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessNews> findByExample(final BusinessNewsQuery query, final Integer limit) throws ServiceException;	

	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessNewsQuery query) throws ServiceException;

	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessNewsQuery query) throws ServiceException;

	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_index_app(final BusinessNewsQuery query) throws ServiceException;

	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessNewsQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessNews数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessNews entity) throws ServiceException;
	
	/**
	 * 修改BusinessNews数据
	 * @param entity
	 * @throws ServiceException
	 */
	public int update(final BusinessNews entity) throws ServiceException;

	/**
	 * 删除BusinessNews
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * service
	 * 社区报记者使用发布新闻
	 * @param entity
	 * @throws ServiceException
	 */
	public void releaseNews(final BusinessNewsQuery query) throws ServiceException;

}
