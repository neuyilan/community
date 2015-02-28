package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessActivityMessagelog;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityMessagelogQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessActivityMessagelogService {

	/**
	 * 查询单个BusinessActivityMessagelog
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessActivityMessagelog findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessActivityMessagelog
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessActivityMessagelog> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessActivityMessagelog
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityMessagelog> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityMessagelog-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityMessagelog> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessActivityMessagelog
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityMessagelog> findByExample(final BusinessActivityMessagelogQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityMessagelog-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityMessagelog> findByExample(final BusinessActivityMessagelogQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessActivityMessagelogQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessActivityMessagelogQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessActivityMessagelog数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessActivityMessagelog entity) throws ServiceException;
	
	/**
	 * 修改BusinessActivityMessagelog数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessActivityMessagelog entity) throws ServiceException;

	/**
	 * 删除BusinessActivityMessagelog
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
