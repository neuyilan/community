package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessHelpExpendestates;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHelpExpendestatesQuery;
import com.community.framework.exception.ServiceException;

public interface BusinessHelpExpendestatesService {

	/**
	 * 查询单个BusinessHelpExpendestates
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessHelpExpendestates findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessHelpExpendestates
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessHelpExpendestates> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessHelpExpendestates
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelpExpendestates> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessHelpExpendestates-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessHelpExpendestates> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessHelpExpendestates
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelpExpendestates> findByExample(final BusinessHelpExpendestatesQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessHelpExpendestates-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessHelpExpendestates> findByExample(final BusinessHelpExpendestatesQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessHelpExpendestatesQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessHelpExpendestatesQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessHelpExpendestates数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessHelpExpendestates entity) throws ServiceException;
	
	/**
	 * 修改BusinessHelpExpendestates数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessHelpExpendestates entity) throws ServiceException;

	/**
	 * 删除BusinessHelpExpendestates
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
