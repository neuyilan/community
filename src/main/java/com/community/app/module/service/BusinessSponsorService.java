package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessSponsor;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessSponsorQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessSponsorService {

	/**
	 * 查询单个BusinessSponsor
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessSponsor findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessSponsor
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessSponsor> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessSponsor
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessSponsor> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessSponsor-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessSponsor> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessSponsor
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessSponsor> findByExample(final BusinessSponsorQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessSponsor-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessSponsor> findByExample(final BusinessSponsorQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessSponsorQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessSponsorQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessSponsor数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessSponsor entity) throws ServiceException;
	
	/**
	 * 修改BusinessSponsor数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessSponsor entity) throws ServiceException;

	/**
	 * 删除BusinessSponsor
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
