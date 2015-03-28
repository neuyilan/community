package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessVote;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessVoteQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessVoteService {

	/**
	 * 查询单个BusinessVote
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessVote findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessVote
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessVote> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessVote
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessVote> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessVote-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessVote> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessVote
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessVote> findByExample(final BusinessVoteQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessVote-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessVote> findByExample(final BusinessVoteQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessVoteQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessVoteQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessVote数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessVote entity) throws ServiceException;
	
	/**
	 * 修改BusinessVote数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessVote entity) throws ServiceException;

	/**
	 * 删除BusinessVote
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

	public List<BusinessVote> findTodayVotesByMap(Map<String, Object> map) throws ServiceException;

}
