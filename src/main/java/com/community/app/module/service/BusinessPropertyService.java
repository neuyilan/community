package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessProperty;
import com.community.app.module.vo.BusinessPropertyQuery;


public interface BusinessPropertyService {

	/**
	 * 查询单个BusinessProperty
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessProperty findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessProperty
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessProperty> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessProperty
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessProperty> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessProperty-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessProperty> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessProperty
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessProperty> findByExample(final BusinessPropertyQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessProperty-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessProperty> findByExample(final BusinessPropertyQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessPropertyQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessPropertyQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessProperty数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessProperty entity) throws ServiceException;
	
	/**
	 * 修改BusinessProperty数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessProperty entity) throws ServiceException;

	/**
	 * 删除BusinessProperty
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
