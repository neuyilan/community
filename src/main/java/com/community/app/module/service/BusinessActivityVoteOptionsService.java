package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessActivityVoteOptions;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityVoteOptionsQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessActivityVoteOptionsService {

	/**
	 * 查询单个BusinessActivityVoteOptions
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessActivityVoteOptions findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessActivityVoteOptions
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessActivityVoteOptions> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessActivityVoteOptions
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityVoteOptions> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityVoteOptions-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityVoteOptions> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessActivityVoteOptions
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityVoteOptions> findByExample(final BusinessActivityVoteOptionsQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityVoteOptions-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityVoteOptions> findByExample(final BusinessActivityVoteOptionsQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessActivityVoteOptionsQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessActivityVoteOptionsQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessActivityVoteOptions数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessActivityVoteOptions entity) throws ServiceException;
	
	/**
	 * 修改BusinessActivityVoteOptions数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessActivityVoteOptions entity) throws ServiceException;

	/**
	 * 删除BusinessActivityVoteOptions
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
