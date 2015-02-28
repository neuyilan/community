package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessSpecialMenu;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessSpecialMenuQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessSpecialMenuService {

	/**
	 * 查询单个BusinessSpecialMenu
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessSpecialMenu findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessSpecialMenu
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessSpecialMenu> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessSpecialMenu
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessSpecialMenu> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessSpecialMenu-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessSpecialMenu> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessSpecialMenu
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessSpecialMenu> findByExample(final BusinessSpecialMenuQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessSpecialMenu-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessSpecialMenu> findByExample(final BusinessSpecialMenuQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页所有数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessSpecialMenuQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessSpecialMenuQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessSpecialMenu数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessSpecialMenu entity) throws ServiceException;
	
	/**
	 * 修改BusinessSpecialMenu数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessSpecialMenu entity) throws ServiceException;

	/**
	 * 删除BusinessSpecialMenu
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 根据搜索条件，搜索分页所需的数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessSpecialMenuQuery query) throws ServiceException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List findListByField(final Map fieldMap, final BusinessSpecialMenuQuery query) throws ServiceException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessSpecialMenu findByField(final Map fieldMap, final Integer id) throws ServiceException;

}
