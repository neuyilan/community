package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessLifeType;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessLifeTypeQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessLifeTypeService {

	/**
	 * 查询单个BusinessLifeType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessLifeType findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessLifeType
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessLifeType> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessLifeType
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessLifeType> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessLifeType-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessLifeType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessLifeType
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessLifeType> findByExample(final BusinessLifeTypeQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessLifeType-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessLifeType> findByExample(final BusinessLifeTypeQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessLifeTypeQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessLifeTypeQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessLifeType数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessLifeType entity) throws ServiceException;
	
	/**
	 * 修改BusinessLifeType数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessLifeType entity) throws ServiceException;

	/**
	 * 删除BusinessLifeType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
