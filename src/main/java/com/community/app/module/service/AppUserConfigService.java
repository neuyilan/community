package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.AppUserConfig;
import com.community.app.module.vo.AppUserConfigQuery;
import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;


public interface AppUserConfigService {

	/**
	 * 查询单个AppUserConfig
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public AppUserConfig findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有AppUserConfig
	 * @return
	 * @throws ServiceException
	 */
	public List<AppUserConfig> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有AppUserConfig
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppUserConfig> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有AppUserConfig-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppUserConfig> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有AppUserConfig
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppUserConfig> findByExample(final AppUserConfigQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有AppUserConfig
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppUserConfig> findByExample_app(final AppUserConfigQuery query) throws ServiceException;	

	
	/**
	 * 按VO对象条件查询所有AppUserConfig-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppUserConfig> findByExample(final AppUserConfigQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final AppUserConfigQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final AppUserConfigQuery query) throws ServiceException;
	
	/**
	 * 保存AppUserConfig数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final AppUserConfig entity) throws ServiceException;
	
	/**
	 * 修改AppUserConfig数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final AppUserConfig entity) throws ServiceException;

	/**
	 * 删除AppUserConfig
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
