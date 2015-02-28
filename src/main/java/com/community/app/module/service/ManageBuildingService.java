package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.ManageBuilding;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.ManageBuildingQuery;
import com.community.framework.exception.ServiceException;


public interface ManageBuildingService {

	/**
	 * 查询单个ManageBuilding
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public ManageBuilding findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有ManageBuilding
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageBuilding> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有ManageBuilding
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageBuilding> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有ManageBuilding-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageBuilding> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * service
	 * 按VO对象条件查询所有ManageBuilding
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageBuilding> findByExample(final ManageBuildingQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有ManageBuilding-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageBuilding> findByExample(final ManageBuildingQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final ManageBuildingQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final ManageBuildingQuery query) throws ServiceException;
	
	/**
	 * 保存ManageBuilding数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final ManageBuilding entity) throws ServiceException;
	
	/**
	 * 修改ManageBuilding数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final ManageBuilding entity) throws ServiceException;

	/**
	 * 删除ManageBuilding
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
