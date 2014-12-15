package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessHealthydietSupport;
import com.community.app.module.vo.BusinessHealthydietSupportQuery;


public interface BusinessHealthydietSupportService {

	/**
	 * 查询单个BusinessHealthydietSupport
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessHealthydietSupport findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessHealthydietSupport
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessHealthydietSupport> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessHealthydietSupport
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHealthydietSupport> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessHealthydietSupport-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessHealthydietSupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessHealthydietSupport
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHealthydietSupport> findByExample(final BusinessHealthydietSupportQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessHealthydietSupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessHealthydietSupport> findByExample(final BusinessHealthydietSupportQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessHealthydietSupportQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessHealthydietSupportQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessHealthydietSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessHealthydietSupport entity) throws ServiceException;
	
	/**
	 * 修改BusinessHealthydietSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessHealthydietSupport entity) throws ServiceException;

	/**
	 * 删除BusinessHealthydietSupport
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
