package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.AppUserNews;
import com.community.app.module.vo.AppUserNewsQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;


public interface AppUserNewsService {

	/**
	 * 查询单个AppUserNews
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public AppUserNews findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有AppUserNews
	 * @return
	 * @throws ServiceException
	 */
	public List<AppUserNews> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有AppUserNews
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppUserNews> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有AppUserNews-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppUserNews> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有AppUserNews
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppUserNews> findByExample(final AppUserNewsQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有AppUserNews-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppUserNews> findByExample(final AppUserNewsQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final AppUserNewsQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final AppUserNewsQuery query) throws ServiceException;
	
	/**
	 * 保存AppUserNews数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final AppUserNews entity) throws ServiceException;
	
	/**
	 * 修改AppUserNews数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final AppUserNews entity) throws ServiceException;

	/**
	 * 删除AppUserNews
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * service
	 * 新增回复我的
	 * @param entity
	 * @throws ServiceException
	 */
	public void saveReply(final AppUserNews entity) throws ServiceException;
	
	/**
	 * service
	 * 新增回复我的
	 * @param entity
	 * @throws ServiceException
	 */
	public void saveReply_manage(final AppUserNews entity) throws ServiceException;

}
