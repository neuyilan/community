package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessToken;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessTokenQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessTokenService {

	/**
	 * 查询单个BusinessToken
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessToken findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessToken
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessToken> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessToken
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessToken> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessToken-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessToken> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessToken
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessToken> findByExample(final BusinessTokenQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessToken-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessToken> findByExample(final BusinessTokenQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessTokenQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessTokenQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessToken数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessToken entity) throws ServiceException;
	
	/**
	 * 修改BusinessToken数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessToken entity) throws ServiceException;

	/**
	 * 删除BusinessToken
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
