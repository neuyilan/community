package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessBreakPic;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessBreakPicQuery;
import com.community.framework.exception.ServiceException;

public interface BusinessBreakPicService {

	/**
	 * 查询单个BusinessBreakPic
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessBreakPic findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessBreakPic
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBreakPic> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessBreakPic
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBreakPic> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessBreakPic-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessBreakPic> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessBreakPic
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBreakPic> findByExample(final BusinessBreakPicQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessBreakPic-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessBreakPic> findByExample(final BusinessBreakPicQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据爆料ID查询所有爆料的图片BusinessBreakPic
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBreakPic> findPicListByBreakId(final Integer id) throws ServiceException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessBreakPicQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessBreakPicQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessBreakPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessBreakPic entity) throws ServiceException;
	
	/**
	 * 修改BusinessBreakPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessBreakPic entity) throws ServiceException;

	/**
	 * 删除BusinessBreakPic
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
