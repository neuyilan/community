package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessHelpPic;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHelpPicQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessHelpPicService {

	/**
	 * 查询单个BusinessHelpPic
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessHelpPic findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessHelpPic
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessHelpPic> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessHelpPic
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelpPic> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessHelpPic-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessHelpPic> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessHelpPic
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelpPic> findByExample(final BusinessHelpPicQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessHelpPic-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessHelpPic> findByExample(final BusinessHelpPicQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessHelpPicQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessHelpPicQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessHelpPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessHelpPic entity) throws ServiceException;
	
	/**
	 * 修改BusinessHelpPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessHelpPic entity) throws ServiceException;

	/**
	 * 删除BusinessHelpPic
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
