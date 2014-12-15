package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessBus;
import com.community.app.module.vo.BusinessBusQuery;


public interface BusinessBusService {

	/**
	 * 查询单个BusinessBus
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessBus findById(final Integer id) throws ServiceException;
	
	/**
	 * 查询线路的所有站点
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBusQuery> busLineDetails(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessBus
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBus> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessBus
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBus> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessBus-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBus> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessBus
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBus> findByExample(final BusinessBusQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessBus-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBus> findByExample(final BusinessBusQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessBusQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessBusQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessBus数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessBus entity) throws ServiceException;
	
	/**
	 * 修改BusinessBus数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessBus entity) throws ServiceException;

	/**
	 * 删除BusinessBus
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
