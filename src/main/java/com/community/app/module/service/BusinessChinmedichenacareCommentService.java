package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessChinmedichenacareComment;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessChinmedichenacareCommentQuery;
import com.community.framework.exception.ServiceException;

public interface BusinessChinmedichenacareCommentService {

	/**
	 * 查询单个BusinessChinmedichenacareComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessChinmedichenacareComment findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessChinmedichenacareComment
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessChinmedichenacareComment> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacareComment
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessChinmedichenacareComment> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacareComment-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessChinmedichenacareComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacareComment
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessChinmedichenacareComment> findByExample(final BusinessChinmedichenacareCommentQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacareComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessChinmedichenacareComment> findByExample(final BusinessChinmedichenacareCommentQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessChinmedichenacareCommentQuery query) throws ServiceException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessChinmedichenacareCommentQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessChinmedichenacareCommentQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessChinmedichenacareComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessChinmedichenacareComment entity) throws ServiceException;
		
	/**
	 * 后台评论回复
	 * 保存BusinessChinmedichenacareComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void replySave(final BusinessChinmedichenacareComment entity) throws ServiceException;
	
	/**
	 * 修改BusinessChinmedichenacareComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessChinmedichenacareComment entity) throws ServiceException;

	/**
	 * 删除BusinessChinmedichenacareComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
