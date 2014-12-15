package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.ManageFunction;
import com.community.app.module.vo.ManageFunctionQuery;


public interface ManageFunctionService {

	/**
	 * 查询单个ManageFunction
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public ManageFunction findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有ManageFunction
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageFunction> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有ManageFunction
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageFunction> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有ManageFunction-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageFunction> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有ManageFunction
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageFunction> findByExample(final ManageFunctionQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有ManageFunction-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageFunction> findByExample(final ManageFunctionQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final ManageFunctionQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final ManageFunctionQuery query) throws ServiceException;
	
	/**
	 * 保存ManageFunction数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final ManageFunction entity) throws ServiceException;
	
	/**
	 * 修改ManageFunction数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final ManageFunction entity) throws ServiceException;

	/**
	 * 删除ManageFunction
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
