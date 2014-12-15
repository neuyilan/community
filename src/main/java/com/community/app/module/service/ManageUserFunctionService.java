package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.ManageUserFunction;
import com.community.app.module.vo.ManageUserFunctionQuery;


public interface ManageUserFunctionService {

	/**
	 * 查询单个ManageUserFunction
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public ManageUserFunction findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有ManageUserFunction
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageUserFunction> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有ManageUserFunction
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageUserFunction> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有ManageUserFunction-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageUserFunction> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有ManageUserFunction
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageUserFunction> findByExample(final ManageUserFunctionQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有ManageUserFunction-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageUserFunction> findByExample(final ManageUserFunctionQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final ManageUserFunctionQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final ManageUserFunctionQuery query) throws ServiceException;
	
	/**
	 * 保存ManageUserFunction数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final ManageUserFunction entity) throws ServiceException;
	
	/**
	 * 修改ManageUserFunction数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final ManageUserFunction entity) throws ServiceException;

	/**
	 * 删除ManageUserFunction
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

    /**
     * 删除ManageUserFunction
     * @param id
     * @return
     * @throws ServiceException
     */
	public boolean deleteByUserId(final Integer id) throws ServiceException;

}
