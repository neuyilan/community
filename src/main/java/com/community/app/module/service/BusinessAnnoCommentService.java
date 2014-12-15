package com.community.app.module.service;

import com.community.app.module.bean.BusinessAnnoComment;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessAnnoCommentQuery;
import com.community.framework.exception.ServiceException;

import java.util.List;
import java.util.Map;


public interface BusinessAnnoCommentService {

	/**
	 * 查询单个BusinessAnnoComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessAnnoComment findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessAnnoComment
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessAnnoComment> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessAnnoComment
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessAnnoComment> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoComment-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessAnnoComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoComment
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessAnnoComment> findByExample(final BusinessAnnoCommentQuery query) throws ServiceException;

	/**
	 * 按VO对象条件查询所有BusinessAnnoComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessAnnoComment> findByExample(final BusinessAnnoCommentQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessAnnoCommentQuery query) throws ServiceException;

	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessAnnoCommentQuery query) throws ServiceException;

	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessAnnoCommentQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessAnnoComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessAnnoComment entity) throws ServiceException;
	
	/**
	 * 后台回复保存BusinessAnnoComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void replySave(final BusinessAnnoComment entity) throws ServiceException;
	
	/**
	 * 修改BusinessAnnoComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessAnnoComment entity) throws ServiceException;

	/**
	 * 删除BusinessAnnoComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
