package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessAnnoVisit;
import com.community.app.module.vo.BusinessAnnoVisitQuery;


public interface BusinessAnnoVisitService {

	/**
	 * 查询单个BusinessAnnoVisit
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessAnnoVisit findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessAnnoVisit
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessAnnoVisit> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessAnnoVisit
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessAnnoVisit> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoVisit-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessAnnoVisit> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoVisit
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessAnnoVisit> findByExample(final BusinessAnnoVisitQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessAnnoVisit-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessAnnoVisit> findByExample(final BusinessAnnoVisitQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessAnnoVisitQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessAnnoVisitQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessAnnoVisit数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessAnnoVisit entity) throws ServiceException;
	
	/**
	 * 修改BusinessAnnoVisit数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessAnnoVisit entity) throws ServiceException;

	/**
	 * 删除BusinessAnnoVisit
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
