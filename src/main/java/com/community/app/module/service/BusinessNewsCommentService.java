package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessNewsComment;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessNewsCommentQuery;
import com.community.framework.exception.ServiceException;

public interface BusinessNewsCommentService {

	/**
	 * 查询单个BusinessNewsComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessNewsComment findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessNewsComment
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessNewsComment> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessNewsComment
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNewsComment> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessNewsComment-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessNewsComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessNewsComment
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNewsComment> findByExample(final BusinessNewsCommentQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessNewsComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessNewsComment> findByExample(final BusinessNewsCommentQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessNewsCommentQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessNewsCommentQuery query) throws ServiceException;
	
	/**
	 * 后台新闻评论
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_manage(final BusinessNewsCommentQuery query) throws ServiceException;

	/**
	 *  后台新闻评论
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount_manage(final BusinessNewsCommentQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessNewsComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessNewsComment entity) throws ServiceException;
	
	/**
	 * 后台评论回复
	 * 保存BusinessNewsComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void replySave(final BusinessNewsComment entity) throws ServiceException;
	
	/**
	 * 修改BusinessNewsComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessNewsComment entity) throws ServiceException;

	/**
	 * 删除BusinessNewsComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
