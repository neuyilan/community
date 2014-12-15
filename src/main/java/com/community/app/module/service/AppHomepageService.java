package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.AppHomepage;
import com.community.app.module.vo.AppHomepageQuery;


public interface AppHomepageService {

	/**
	 * 查询单个AppHomepage
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public AppHomepage findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有AppHomepage
	 * @return
	 * @throws ServiceException
	 */
	public List<AppHomepage> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有AppHomepage
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppHomepage> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有AppHomepage-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppHomepage> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有AppHomepage
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppHomepage> findByExample(final AppHomepageQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有AppHomepage-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppHomepage> findByExample(final AppHomepageQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final AppHomepageQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final AppHomepageQuery query) throws ServiceException;

	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final AppHomepageQuery query) throws ServiceException;
	
	/**
	 * 保存AppHomepage数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final AppHomepage entity) throws ServiceException;
	
	/**
	 * 修改AppHomepage数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final AppHomepage entity) throws ServiceException;

	/**
	 * 删除AppHomepage
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final AppHomepage entity) throws ServiceException;

}
