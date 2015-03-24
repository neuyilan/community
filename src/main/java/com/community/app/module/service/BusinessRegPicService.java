package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessRegPic;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessRegPicQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessRegPicService {

	/**
	 * 查询单个BusinessRegPic
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRegPic findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessRegPic
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRegPic> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessRegPic
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRegPic> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessRegPic-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRegPic> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessRegPic
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRegPic> findByExample(final BusinessRegPicQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessRegPic-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRegPic> findByExample(final BusinessRegPicQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessRegPicQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessRegPicQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessRegPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessRegPic entity) throws ServiceException;
	
	/**
	 * 修改BusinessRegPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessRegPic entity) throws ServiceException;

	/**
	 * 删除BusinessRegPic
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
