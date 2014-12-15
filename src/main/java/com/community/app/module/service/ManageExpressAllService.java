package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.ManageExpressAll;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.ManageExpressAllQuery;
import com.community.framework.exception.ServiceException;

public interface ManageExpressAllService {

	/**
	 * 查询单个ManageExpressAll
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public ManageExpressAll findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有ManageExpressAll
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageExpressAll> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有ManageExpressAll
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageExpressAll> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有ManageExpressAll-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageExpressAll> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有ManageExpressAll
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageExpressAll> findByExample(final ManageExpressAllQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有ManageExpressAll-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageExpressAll> findByExample(final ManageExpressAllQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final ManageExpressAllQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final ManageExpressAllQuery query) throws ServiceException;
	
	/**
	 * 保存ManageExpressAll数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final ManageExpressAll entity) throws ServiceException;
	
	/**
	 * 修改ManageExpressAll数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final ManageExpressAll entity) throws ServiceException;

	/**
	 * 删除ManageExpressAll
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
}