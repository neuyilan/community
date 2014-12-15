package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessImages;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessImagesQuery;
import com.community.framework.exception.ServiceException;

public interface BusinessImagesService {

	/**
	 * 查询单个BusinessImages
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessImages findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessImages
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessImages> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessImages
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessImages> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessImages-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessImages> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessImages
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessImages> findByExample(final BusinessImagesQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessImages-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessImages> findByExample(final BusinessImagesQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessImagesQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessImagesQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessImages数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessImages entity) throws ServiceException;
	
	/**
	 * 修改BusinessImages数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessImages entity) throws ServiceException;

	/**
	 * 删除BusinessImages
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
