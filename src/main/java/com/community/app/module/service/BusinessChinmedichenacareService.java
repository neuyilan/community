package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessChinmedichenacare;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessChinmedichenacareQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessChinmedichenacareService {

	/**
	 * 查询单个BusinessChinmedichenacare
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessChinmedichenacare findById(final Integer id) throws ServiceException;
	
	/**
	 * 查询单个BusinessChinmedichenacare
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessChinmedichenacare findById_app(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessChinmedichenacare
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessChinmedichenacare> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacare
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessChinmedichenacare> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacare-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessChinmedichenacare> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacare
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessChinmedichenacare> findByExample(final BusinessChinmedichenacareQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacare-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessChinmedichenacare> findByExample(final BusinessChinmedichenacareQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessChinmedichenacareQuery query) throws ServiceException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessChinmedichenacareQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessChinmedichenacareQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessChinmedichenacare数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessChinmedichenacare entity) throws ServiceException;
	
	/**
	 * 修改BusinessChinmedichenacare数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessChinmedichenacare entity) throws ServiceException;

	/**
	 * 删除BusinessChinmedichenacare
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
