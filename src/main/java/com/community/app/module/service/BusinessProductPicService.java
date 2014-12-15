package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessProductPic;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessProductPicQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessProductPicService {

	/**
	 * 查询单个BusinessProductPic
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessProductPic findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessProductPic
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessProductPic> findAll() throws ServiceException;
	
	/**
	 * 根据跳蚤市场ID查询所有BusinessProductPic
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessProductPic> findAllPicbyId(final Integer id) throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessProductPic
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessProductPic> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessProductPic-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessProductPic> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessProductPic
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessProductPic> findByExample(final BusinessProductPicQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessProductPic-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessProductPic> findByExample(final BusinessProductPicQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessProductPicQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessProductPicQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessProductPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessProductPic entity) throws ServiceException;
	
	/**
	 * 修改BusinessProductPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessProductPic entity) throws ServiceException;

	/**
	 * 删除BusinessProductPic
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
