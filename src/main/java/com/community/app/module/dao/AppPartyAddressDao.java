package com.community.app.module.dao;

import java.util.List;
import java.util.Map;






import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.AppPartyAddress;
import com.community.app.module.vo.AppPartyAddressQuery;

@Repository
public interface AppPartyAddressDao {
		
	/**
	 * 查询单个AppPartyAddress
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppPartyAddress findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有AppPartyAddress
	 * @return
	 * @throws DaoException
	 */
	public List<AppPartyAddress> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有AppPartyAddress
	 * @return
	 * @throws DaoException
	 */	
	public List<AppPartyAddress> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有AppPartyAddress-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<AppPartyAddress> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有AppPartyAddress
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppPartyAddress> findByExample(final AppPartyAddressQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有AppPartyAddress-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppPartyAddress> findByExample(final AppPartyAddressQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppPartyAddress> findAllPage(final AppPartyAddressQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppPartyAddressQuery query) throws DaoException;
	
	/**
	 * service
	 * 保存AppPartyAddress数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppPartyAddressQuery entity) throws DaoException;
	
	/**
	 * 修改AppPartyAddress数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppPartyAddressQuery entity) throws DaoException;

	/**
	 * 删除AppPartyAddress
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * service
	 * 设置默认收货地址
	 * @param entity
	 * @throws ServiceException
	 */
	public void setDefault(final AppPartyAddressQuery entity) throws DaoException;

}
