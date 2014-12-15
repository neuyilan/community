package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.AppAutomobileNumber;
import com.community.app.module.vo.AppAutomobileNumberQuery;


public interface AppAutomobileNumberService {

	/**
	 * 查询单个AppAutomobileNumber
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public AppAutomobileNumber findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有AppAutomobileNumber
	 * @return
	 * @throws ServiceException
	 */
	public List<AppAutomobileNumber> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有AppAutomobileNumber
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppAutomobileNumber> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有AppAutomobileNumber-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<AppAutomobileNumber> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有AppAutomobileNumber
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppAutomobileNumber> findByExample(final AppAutomobileNumberQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有AppAutomobileNumber
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppAutomobileNumber> findByExample_app(final AppAutomobileNumberQuery query) throws ServiceException;	
	
	/**
	 * 按VO对象条件查询所有AppAutomobileNumber-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<AppAutomobileNumber> findByExample(final AppAutomobileNumberQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final AppAutomobileNumberQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final AppAutomobileNumberQuery query) throws ServiceException;
	
	/**
	 * 保存AppAutomobileNumber数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final AppAutomobileNumber entity) throws ServiceException;
	
	/**
	 * 修改AppAutomobileNumber数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final AppAutomobileNumber entity) throws ServiceException;

	/**
	 * 删除AppAutomobileNumber
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 删除AppAutomobileNumber
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(AppAutomobileNumber entity) throws ServiceException;
	
	 /**
		 * @throws  
		 * 推送限行
		 * @param 
		 * @return
		 * @throws 
		 */	
		public void pushLimit() throws  ServiceException;

}
