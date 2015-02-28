package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessChargeAnno;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessChargeAnnoQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessChargeAnnoService {

	/**
	 * 查询单个BusinessChargeAnno
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessChargeAnno findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessChargeAnno
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessChargeAnno> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessChargeAnno
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessChargeAnno> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessChargeAnno-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessChargeAnno> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessChargeAnno
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessChargeAnno> findByExample(final BusinessChargeAnnoQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessChargeAnno-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessChargeAnno> findByExample(final BusinessChargeAnnoQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessChargeAnnoQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessChargeAnnoQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessChargeAnno数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessChargeAnno entity) throws ServiceException;
	
	/**
	 * 修改BusinessChargeAnno数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessChargeAnno entity) throws ServiceException;

	/**
	 * 删除BusinessChargeAnno
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
