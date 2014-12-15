package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessHelpComment;
import com.community.app.module.vo.BusinessHelpCommentQuery;

public interface BusinessHelpCommentService {

	/**
	 * 查询单个BusinessHelpComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessHelpComment findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessHelpComment
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessHelpComment> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessHelpComment
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelpComment> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessHelpComment-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelpComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessHelpComment
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelpComment> findByExample(final BusinessHelpCommentQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessHelpComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelpComment> findByExample(final BusinessHelpCommentQuery query, final Integer limit) throws ServiceException;	

	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessHelpCommentQuery query) throws ServiceException;

	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessHelpCommentQuery query) throws ServiceException;

	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessHelpCommentQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessHelpComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessHelpComment entity) throws ServiceException;
	
	/**
	 * 后台评论回复
	 * 保存BusinessHelpComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void replySave(final BusinessHelpComment entity) throws ServiceException;
	
	/**
	 * 修改BusinessHelpComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessHelpComment entity) throws ServiceException;

	/**
	 * 删除BusinessHelpComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
