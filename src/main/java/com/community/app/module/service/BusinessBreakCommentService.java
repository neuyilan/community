package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessBreakComment;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessBreakCommentQuery;
import com.community.framework.exception.ServiceException;

public interface BusinessBreakCommentService {

	/**
	 * 根据爆料ID查询所有回复的爆料BusinessBreakComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBreakComment> findCommentListByBreakId(final Integer id) throws ServiceException;
	
	/**
	 * 查询单个BusinessBreakComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessBreakComment findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessBreakComment
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBreakComment> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessBreakComment
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBreakComment> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessBreakComment-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessBreakComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessBreakComment
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBreakComment> findByExample(final BusinessBreakCommentQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessBreakComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessBreakComment> findByExample(final BusinessBreakCommentQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessBreakCommentQuery query) throws ServiceException;

	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessBreakCommentQuery query) throws ServiceException;
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessBreakCommentQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessBreakComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessBreakComment entity) throws ServiceException;
	
	/**
	 * 回复保存BusinessBreakComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public int replySave(final BusinessBreakComment entity) throws ServiceException;
	
	
	/**
	 * 修改BusinessBreakComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessBreakComment entity) throws ServiceException;

	/**
	 * 删除BusinessBreakComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
