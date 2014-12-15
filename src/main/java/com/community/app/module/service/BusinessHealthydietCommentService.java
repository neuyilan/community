package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessHealthydietComment;
import com.community.app.module.vo.BusinessHealthydietCommentQuery;

public interface BusinessHealthydietCommentService {

	/**
	 * 查询单个BusinessHealthydietComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessHealthydietComment findById(final Integer id) throws ServiceException;
	
	
	/**
	 * 无条件查询所有BusinessHealthydietComment
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessHealthydietComment> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessHealthydietComment
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHealthydietComment> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessHealthydietComment-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessHealthydietComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessHealthydietComment
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHealthydietComment> findByExample(final BusinessHealthydietCommentQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessHealthydietComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessHealthydietComment> findByExample(final BusinessHealthydietCommentQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessHealthydietCommentQuery query) throws ServiceException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessHealthydietCommentQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessHealthydietCommentQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessHealthydietComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessHealthydietComment entity) throws ServiceException;
	
	/**
	 * 后台评论回复
	 * 保存BusinessHealthydietComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void replySave(final BusinessHealthydietComment entity) throws ServiceException;
	
	
	/**
	 * 修改BusinessHealthydietComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessHealthydietComment entity) throws ServiceException;

	/**
	 * 删除BusinessHealthydietComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
