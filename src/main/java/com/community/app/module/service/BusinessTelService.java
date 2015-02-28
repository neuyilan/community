package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessTel;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessTelQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessTelService {

	/**
	 * 查询单个BusinessTel
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessTel findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessTel
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessTel> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessTel
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessTel> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessTel-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessTel> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessTel
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessTel> findByExample(final BusinessTelQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessTel-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessTel> findByExample(final BusinessTelQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessTelQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessTelQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessTel数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessTel entity) throws ServiceException;
	
	/**
	 * 修改BusinessTel数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessTel entity) throws ServiceException;

	/**
	 * 删除BusinessTel
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
