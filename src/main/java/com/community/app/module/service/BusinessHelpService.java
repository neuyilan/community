package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessHelp;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHelpQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessHelpService {

	/**
	 * 查询单个BusinessHelp
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessHelp findById(final Integer id) throws ServiceException;
	
	/**
	 * service
	 * 查询单个BusinessHelp
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessHelp findById_app(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessHelp
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessHelp> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessHelp
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelp> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessHelp-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessHelp> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessHelp
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelp> findByExample(final BusinessHelpQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessHelp-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessHelp> findByExample(final BusinessHelpQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessHelpQuery query) throws ServiceException;

	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessHelpQuery query) throws ServiceException;

	
	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage1(final BusinessHelpQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessHelpQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessHelp数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessHelp entity) throws ServiceException;
	
	/**
	 * 修改BusinessHelp数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessHelp entity) throws ServiceException;

	/**
	 * 删除BusinessHelp
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	

	/**
	 * 新增求助
	 * @param entity
	 * @throws ServiceException
	 */
	public void publishSeekHelpRepair(final BusinessHelpQuery query) throws ServiceException;
	
	/**
	 * 新增求助PHP
	 * @param entity
	 * @throws ServiceException
	 */
	public void publishSeekHelpRepairPHP(final BusinessHelpQuery query) throws ServiceException;

}
