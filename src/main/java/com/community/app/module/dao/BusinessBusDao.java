package com.community.app.module.dao;

import java.util.List;
import java.util.Map;






import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessBus;
import com.community.app.module.vo.BusinessBusQuery;

@Repository
public interface BusinessBusDao {
		
	/**
	 * 查询单个BusinessBus
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessBus findById(final Integer id) throws DaoException;
	
	/**
	 * 查询线路的所有站点
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBusQuery> busLineDetails(final Integer id) throws DaoException;

	
	/**
	 * 无条件查询所有BusinessBus
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBus> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessBus
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBus> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessBus-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBus> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessBus
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBus> findByExample(final BusinessBusQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessBus-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBus> findByExample(final BusinessBusQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBus> findAllPage(final BusinessBusQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessBusQuery query) throws DaoException;
	
	/**
	 * 保存BusinessBus数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessBus entity) throws DaoException;
	
	/**
	 * 修改BusinessBus数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessBus entity) throws DaoException;

	/**
	 * 删除BusinessBus
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
