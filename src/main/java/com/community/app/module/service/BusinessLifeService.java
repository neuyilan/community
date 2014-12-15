package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessLife;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessLifeQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessLifeService {

	/**
	 * 查询单个BusinessLife
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessLife findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessLife
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessLife> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessLife
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessLife> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessLife-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessLife> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * service
	 * 按VO对象条件查询所有BusinessLife
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessLife> findByExample(final BusinessLifeQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessLife-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessLife> findByExample(final BusinessLifeQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessLifeQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessLifeQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessLife数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessLife entity) throws ServiceException;
	
	/**
	 * 修改BusinessLife数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessLife entity) throws ServiceException;

	/**
	 * 删除BusinessLife
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
