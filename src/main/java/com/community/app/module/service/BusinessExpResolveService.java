package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessExpResolve;
import com.community.app.module.vo.BusinessExpResolveQuery;


public interface BusinessExpResolveService {

	/**
	 * 查询单个BusinessExpResolve
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessExpResolve findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessExpResolve
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessExpResolve> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessExpResolve
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessExpResolve> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessExpResolve-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessExpResolve> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessExpResolve
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessExpResolve> findByExample(final BusinessExpResolveQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessExpResolve-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessExpResolve> findByExample(final BusinessExpResolveQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessExpResolveQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessExpResolveQuery query) throws ServiceException;

	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessExpResolveQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessExpResolve数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessExpResolve entity) throws ServiceException;
	
	/**
	 * 保存BusinessExpResolve数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save_app(final BusinessExpResolve entity) throws ServiceException;
	
	/**
	 * 修改BusinessExpResolve数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessExpResolve entity) throws ServiceException;

	/**
	 * 删除BusinessExpResolve
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 删除BusinessExpResolve
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete_app(final Integer id) throws ServiceException;

}
