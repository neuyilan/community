package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.AppPartyAddress;
import com.community.app.module.vo.AppPartyAddressQuery;


public interface AppPartyAddressService {

	/**
	 * 查询单个AppPartyAddress
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public AppPartyAddress findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有AppPartyAddress
	 * @return
	 * @throws ServiceException
	 */
	public List<AppPartyAddress> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有AppPartyAddress
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppPartyAddress> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有AppPartyAddress-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppPartyAddress> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有AppPartyAddress
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppPartyAddress> findByExample(final AppPartyAddressQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有AppPartyAddress-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppPartyAddress> findByExample(final AppPartyAddressQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final AppPartyAddressQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final AppPartyAddressQuery query) throws ServiceException;
	
	/**
	 * service
	 * 保存AppPartyAddress数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final AppPartyAddressQuery entity) throws ServiceException;
	
	/**
	 * service
	 * 修改AppPartyAddress数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final AppPartyAddressQuery entity) throws ServiceException;

	/**
	 * 删除AppPartyAddress
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * service
	 * 设置默认收货地址
	 * @param entity
	 * @throws ServiceException
	 */
	public void setDefault(final AppPartyAddressQuery entity) throws ServiceException;

}
