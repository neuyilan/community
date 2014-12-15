package com.community.app.module.dao;

import java.util.List;
import java.util.Map;






import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessBusStation;
import com.community.app.module.vo.BusinessBusStationQuery;

@Repository
public interface BusinessBusStationDao {
		
	/**
	 * 查询单个BusinessBusStation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessBusStation findById(final Integer id) throws DaoException;
	
	/**
	 * 根据id查询该站点下的线路
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBusStationQuery> findStaBus(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessBusStation
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBusStation> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessBusStation
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBusStation> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessBusStation-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBusStation> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessBusStation
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBusStation> findByExample(final BusinessBusStationQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessBusStation-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBusStation> findByExample(final BusinessBusStationQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBusStation> findAllPage(final BusinessBusStationQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessBusStationQuery query) throws DaoException;
	
	/**
	 * 保存BusinessBusStation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessBusStation entity) throws DaoException;
	
	/**
	 * 修改BusinessBusStation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessBusStation entity) throws DaoException;

	/**
	 * 删除BusinessBusStation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
