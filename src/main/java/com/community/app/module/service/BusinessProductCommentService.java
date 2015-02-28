package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessProductComment;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessProductCommentQuery;
import com.community.framework.exception.ServiceException;

public interface BusinessProductCommentService {

	/**
	 * 查询单个BusinessProductComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessProductComment findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessProductComment
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessProductComment> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessProductComment
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessProductComment> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessProductComment-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessProductComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessProductComment
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessProductComment> findByExample(final BusinessProductCommentQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessProductComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessProductComment> findByExample(final BusinessProductCommentQuery query, final Integer limit) throws ServiceException;	

	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessProductCommentQuery query) throws ServiceException;

	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessProductCommentQuery query) throws ServiceException;

	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessProductCommentQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessProductComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessProductComment entity) throws ServiceException;
	
	/**
	 * 后台评论回复
	 * 保存BusinessProductComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void replySave(final BusinessProductComment entity) throws ServiceException;
	
	/**
	 * 修改BusinessProductComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessProductComment entity) throws ServiceException;

	/**
	 * 删除BusinessProductComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}