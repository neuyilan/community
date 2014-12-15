package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.vo.AppLatestNewsQuery;


public interface AppLatestNewsService {

	/**
	 * 查询单个AppLatestNews
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public AppLatestNews findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有AppLatestNews
	 * @return
	 * @throws ServiceException
	 */
	public List<AppLatestNews> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有AppLatestNews
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppLatestNews> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有AppLatestNews-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppLatestNews> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有AppLatestNews
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppLatestNews> findByExample(final AppLatestNewsQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有AppLatestNews-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppLatestNews> findByExample(final AppLatestNewsQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final AppLatestNewsQuery query) throws ServiceException;

	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final AppLatestNewsQuery query) throws ServiceException;

	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final AppLatestNewsQuery query) throws ServiceException;
	
	/**
	 * 保存AppLatestNews数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final AppLatestNews entity) throws ServiceException;
	
	/**
	 * service
	 * 保存AppLatestNews数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save_app(final AppLatestNews entity) throws ServiceException;
	
	/**
	 * 修改AppLatestNews数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final AppLatestNews entity) throws ServiceException;

	/**
	 * 删除AppLatestNews
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 按条件删除AppLatestNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean deleteByCondition(final AppLatestNewsQuery query) throws ServiceException;
	
	/**
	 * service
	 * 删除AppLatestNews
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete_app(final AppLatestNews entity) throws ServiceException;
	
	/**
	 * service
	 * 删除AppLatestNews
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete_app_id(final AppLatestNews entity) throws ServiceException;

}
