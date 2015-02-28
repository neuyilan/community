package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.AppUserCellphone;
import com.community.app.module.vo.AppUserCellphoneQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;


public interface AppUserCellphoneService {

	/**
	 * 查询单个AppUserCellphone
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public AppUserCellphone findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有AppUserCellphone
	 * @return
	 * @throws ServiceException
	 */
	public List<AppUserCellphone> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有AppUserCellphone
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppUserCellphone> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有AppUserCellphone-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppUserCellphone> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * service
	 * 按VO对象条件查询所有AppUserCellphone
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppUserCellphone> findByExample(final AppUserCellphoneQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有AppUserCellphone-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppUserCellphone> findByExample(final AppUserCellphoneQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final AppUserCellphoneQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final AppUserCellphoneQuery query) throws ServiceException;
	
	/**
	 * service
	 * 保存AppUserCellphone数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final AppUserCellphone entity) throws ServiceException;
	
	/**
	 * service
	 * 修改AppUserCellphone数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final AppUserCellphone entity) throws ServiceException;

	/**
	 * service
	 * 删除AppUserCellphone
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
