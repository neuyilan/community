package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessAnnoScope;
import com.community.app.module.vo.BusinessAnnoScopeQuery;


public interface BusinessAnnoScopeService {

	/**
	 * 查询单个BusinessAnnoScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessAnnoScope findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessAnnoScope
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessAnnoScope> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessAnnoScope
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessAnnoScope> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoScope-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessAnnoScope> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoScope
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessAnnoScope> findByExample(final BusinessAnnoScopeQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessAnnoScope-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessAnnoScope> findByExample(final BusinessAnnoScopeQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessAnnoScopeQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessAnnoScopeQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessAnnoScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessAnnoScope entity) throws ServiceException;
	
	/**
	 * 修改BusinessAnnoScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessAnnoScope entity) throws ServiceException;

	/**
	 * 删除BusinessAnnoScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
