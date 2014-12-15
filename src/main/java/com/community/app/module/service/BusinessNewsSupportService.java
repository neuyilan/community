package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessNewsSupport;
import com.community.app.module.vo.BusinessNewsSupportQuery;


public interface BusinessNewsSupportService {

	/**
	 * 查询单个BusinessNewsSupport
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessNewsSupport findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessNewsSupport
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessNewsSupport> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessNewsSupport
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNewsSupport> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessNewsSupport-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNewsSupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessNewsSupport
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNewsSupport> findByExample(final BusinessNewsSupportQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessNewsSupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNewsSupport> findByExample(final BusinessNewsSupportQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessNewsSupportQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessNewsSupportQuery query) throws ServiceException;
	
	/**
	 * service
	 * 保存BusinessNewsSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessNewsSupport entity) throws ServiceException;
	
	/**
	 * 修改BusinessNewsSupport数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessNewsSupport entity) throws ServiceException;

	/**
	 * 删除BusinessNewsSupport
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
