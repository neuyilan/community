package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessHelpSupport;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHelpSupportQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessHelpSupportService {

	/**
	 * 查询单个BusinessHelpSupport
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessHelpSupport findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessHelpSupport
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessHelpSupport> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessHelpSupport
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelpSupport> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessHelpSupport-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelpSupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessHelpSupport
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelpSupport> findByExample(final BusinessHelpSupportQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessHelpSupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelpSupport> findByExample(final BusinessHelpSupportQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessHelpSupportQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessHelpSupportQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessHelpSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessHelpSupport entity) throws ServiceException;
	
	/**
	 * 修改BusinessHelpSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessHelpSupport entity) throws ServiceException;

	/**
	 * 删除BusinessHelpSupport
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
