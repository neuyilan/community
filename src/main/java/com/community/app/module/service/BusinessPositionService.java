package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessPosition;
import com.community.app.module.vo.BusinessPositionQuery;


public interface BusinessPositionService {

	/**
	 * 查询单个BusinessPosition
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessPosition findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessPosition
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessPosition> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessPosition
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessPosition> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessPosition-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessPosition> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessPosition
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessPosition> findByExample(final BusinessPositionQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessPosition-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessPosition> findByExample(final BusinessPositionQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessPositionQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessPositionQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessPosition数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessPosition entity) throws ServiceException;
	
	/**
	 * 修改BusinessPosition数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessPosition entity) throws ServiceException;

	/**
	 * 删除BusinessPosition
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
