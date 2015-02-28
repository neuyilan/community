package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessActivityVoteInformation;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityVoteInformationQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessActivityVoteInformationService {

	/**
	 * 查询单个BusinessActivityVoteInformation
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessActivityVoteInformation findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessActivityVoteInformation
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessActivityVoteInformation> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessActivityVoteInformation
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityVoteInformation> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityVoteInformation-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityVoteInformation> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessActivityVoteInformation
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityVoteInformation> findByExample(final BusinessActivityVoteInformationQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityVoteInformation-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityVoteInformation> findByExample(final BusinessActivityVoteInformationQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessActivityVoteInformationQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessActivityVoteInformationQuery query) throws ServiceException;
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount_userId(final BusinessActivityVoteInformationQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessActivityVoteInformation数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessActivityVoteInformation entity) throws ServiceException;
	
	/**
	 * 修改BusinessActivityVoteInformation数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessActivityVoteInformation entity) throws ServiceException;

	/**
	 * 删除BusinessActivityVoteInformation
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
