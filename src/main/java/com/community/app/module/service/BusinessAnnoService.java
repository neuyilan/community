package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessAnno;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessAnnoQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessAnnoService {

	/**
	 * 查询单个BusinessAnno
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessAnno findById(final Integer id) throws ServiceException;
	
	/**
	 * 查询单个BusinessAnno
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessAnno findById_app(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessAnno
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessAnno> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessAnno
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessAnno> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessAnno-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessAnno> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessAnno
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessAnno> findByExample(final BusinessAnnoQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessAnno-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessAnno> findByExample(final BusinessAnnoQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessAnnoQuery query) throws ServiceException;

	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessAnnoQuery query) throws ServiceException;

	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_index_app(final BusinessAnnoQuery query) throws ServiceException;

	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessAnnoQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessAnno数据
	 * @param entity
	 * @throws ServiceException
	 */
	public Integer save(final BusinessAnno entity) throws ServiceException;
	
	/**
	 * 修改BusinessAnno数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessAnno entity) throws ServiceException;

	/**
	 * 删除BusinessAnno
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

	/**
	 * 后台首页公告列表
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPageForIndex(final BusinessAnnoQuery query) throws ServiceException;
	
	
}
