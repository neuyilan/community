package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessBreakSelect;
import com.community.app.module.vo.BusinessBreakSelectQuery;

public interface BusinessBreakSelectService {

	/**
	 * 查询单个BusinessBreakSelect
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessBreakSelect findById(final Integer id) throws ServiceException;
	
	/**
	 * 根据爆料ID查询所有选用的爆料BusinessBreakSelect
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBreakSelect> findListByBreakId(final Integer id) throws ServiceException;
	/**
	 * 无条件查询所有BusinessBreakSelect
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBreakSelect> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessBreakSelect
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBreakSelect> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessBreakSelect-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessBreakSelect> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessBreakSelect
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBreakSelect> findByExample(final BusinessBreakSelectQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessBreakSelect-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessBreakSelect> findByExample(final BusinessBreakSelectQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessBreakSelectQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessBreakSelectQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessBreakSelect数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessBreakSelect entity) throws ServiceException;
	
	/**
	 * 修改BusinessBreakSelect数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessBreakSelect entity) throws ServiceException;

	/**
	 * 删除BusinessBreakSelect
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
