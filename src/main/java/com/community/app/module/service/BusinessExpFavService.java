package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessExpFav;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessExpFavQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessExpFavService {

	/**
	 * 查询单个BusinessExpFav
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessExpFav findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessExpFav
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessExpFav> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessExpFav
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessExpFav> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessExpFav-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessExpFav> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessExpFav
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessExpFav> findByExample(final BusinessExpFavQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessExpFav-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessExpFav> findByExample(final BusinessExpFavQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessExpFavQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessExpFavQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessExpFav数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessExpFav entity) throws ServiceException;
	
	/**
	 * 修改BusinessExpFav数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessExpFav entity) throws ServiceException;

	/**
	 * 删除BusinessExpFav
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
