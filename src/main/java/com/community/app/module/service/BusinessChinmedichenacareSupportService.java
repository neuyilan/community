package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessChinmedichenacareSupport;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessChinmedichenacareSupportQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessChinmedichenacareSupportService {

	/**
	 * 查询单个BusinessChinmedichenacareSupport
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessChinmedichenacareSupport findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessChinmedichenacareSupport
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessChinmedichenacareSupport> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacareSupport
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessChinmedichenacareSupport> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacareSupport-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessChinmedichenacareSupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacareSupport
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessChinmedichenacareSupport> findByExample(final BusinessChinmedichenacareSupportQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacareSupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessChinmedichenacareSupport> findByExample(final BusinessChinmedichenacareSupportQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessChinmedichenacareSupportQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessChinmedichenacareSupportQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessChinmedichenacareSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessChinmedichenacareSupport entity) throws ServiceException;
	
	/**
	 * 修改BusinessChinmedichenacareSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessChinmedichenacareSupport entity) throws ServiceException;

	/**
	 * 删除BusinessChinmedichenacareSupport
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
