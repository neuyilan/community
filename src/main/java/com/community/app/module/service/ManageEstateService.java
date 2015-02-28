package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.ManageEstate;
import com.community.app.module.common.EstateBean;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.ManageEstateQuery;
import com.community.framework.exception.ServiceException;


public interface ManageEstateService {

	/**
	 * 查询单个ManageEstate
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public ManageEstate findById(final Integer id) throws ServiceException;
	
	/**
	 * 根据id小区周边
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageEstateQuery> findByEstateAmbitus(ManageEstateQuery query) throws ServiceException;

	
	/**
	 * 根据小区id查询小区周边公交站
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageEstateQuery> findByEstateBus(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有ManageEstate
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageEstate> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有ManageEstate
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageEstate> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	
	/**
	 * 按Map对象条件查询所有ManageEstate (关联BUSINESS_USER_RESOURCE 查询)
	 * @return
	 * @throws ServiceException
	 */	
	public List<EstateBean> findByCon(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有ManageEstate-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageEstate> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有ManageEstate
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageEstate> findByExample(final ManageEstateQuery query) throws ServiceException;	

	/**
	 * service方法
	 * 按VO对象条件查询所有ManageEstate-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageEstate> findByExample(final ManageEstateQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final ManageEstateQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final ManageEstateQuery query) throws ServiceException;
	
	/**
	 * 保存ManageEstate数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final ManageEstate entity) throws ServiceException;
	
	/**
	 * 修改ManageEstate数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final ManageEstate entity) throws ServiceException;

	/**
	 * 删除ManageEstate
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * service方法
	 * 根据名称模糊查询所有ManageEstate
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageEstate> search(final ManageEstateQuery query) throws ServiceException;

}
