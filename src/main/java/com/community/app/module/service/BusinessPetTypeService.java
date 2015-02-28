package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessPetType;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessPetTypeQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessPetTypeService {

	/**
	 * 查询单个BusinessPetType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessPetType findById(final Integer id) throws ServiceException;
	
	/**
	 * service
	 * 无条件查询所有BusinessPetType
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessPetType> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessPetType
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessPetType> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessPetType-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessPetType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * service
	 * 按VO对象条件查询所有BusinessPetType
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessPetType> findByExample(final BusinessPetTypeQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessPetType-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessPetType> findByExample(final BusinessPetTypeQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessPetTypeQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessPetTypeQuery query) throws ServiceException;
	
	/**
	 * service
	 * 保存BusinessPetType数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessPetType entity) throws ServiceException;
	
	/**
	 * 修改BusinessPetType数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessPetType entity) throws ServiceException;

	/**
	 * service
	 * 删除BusinessPetType
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
