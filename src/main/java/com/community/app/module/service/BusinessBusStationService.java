package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessBusStation;
import com.community.app.module.vo.BusinessBusStationQuery;


public interface BusinessBusStationService {

	/**
	 * 查询单个BusinessBusStation
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessBusStation findById(final Integer id) throws ServiceException;
	
	/**
	 * 根据id查询该站点下的线路
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBusStationQuery> findStaBus(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessBusStation
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBusStation> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessBusStation
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBusStation> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessBusStation-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBusStation> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessBusStation
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBusStation> findByExample(final BusinessBusStationQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessBusStation-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBusStation> findByExample(final BusinessBusStationQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessBusStationQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessBusStationQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessBusStation数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessBusStation entity) throws ServiceException;
	
	/**
	 * 修改BusinessBusStation数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessBusStation entity) throws ServiceException;

	/**
	 * 删除BusinessBusStation
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
