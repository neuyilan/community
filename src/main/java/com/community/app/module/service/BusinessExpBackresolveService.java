package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessExpBackresolve;
import com.community.app.module.vo.BusinessExpBackresolveQuery;


public interface BusinessExpBackresolveService {

	/**
	 * 查询单个BusinessExpBackresolve
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessExpBackresolve findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessExpBackresolve
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessExpBackresolve> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessExpBackresolve
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessExpBackresolve> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessExpBackresolve-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessExpBackresolve> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessExpBackresolve
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessExpBackresolve> findByExample(final BusinessExpBackresolveQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessExpBackresolve-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessExpBackresolve> findByExample(final BusinessExpBackresolveQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessExpBackresolveQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessExpBackresolveQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessExpBackresolve数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessExpBackresolve entity) throws ServiceException;
	
	/**
	 * 修改BusinessExpBackresolve数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessExpBackresolve entity) throws ServiceException;

	/**
	 * 删除BusinessExpBackresolve
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
