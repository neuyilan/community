package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessHelpReplay;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHelpReplayQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessHelpReplayService {

	/**
	 * 查询单个BusinessHelpReplay
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessHelpReplay findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessHelpReplay
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessHelpReplay> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessHelpReplay
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelpReplay> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessHelpReplay-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessHelpReplay> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessHelpReplay
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelpReplay> findByExample(final BusinessHelpReplayQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessHelpReplay-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessHelpReplay> findByExample(final BusinessHelpReplayQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessHelpReplayQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessHelpReplayQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessHelpReplay数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessHelpReplay entity) throws ServiceException;
	
	/**
	 * 修改BusinessHelpReplay数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessHelpReplay entity) throws ServiceException;

	/**
	 * 删除BusinessHelpReplay
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
