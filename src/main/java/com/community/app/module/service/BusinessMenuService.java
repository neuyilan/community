package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessMenu;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessMenuQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessMenuService {

	/**
	 * 查询单个BusinessMenu
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessMenu findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessMenu
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessMenu> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessMenu
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessMenu> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessMenu-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessMenu> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessMenu
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessMenu> findByExample(final BusinessMenuQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessMenu-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessMenu> findByExample(final BusinessMenuQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessMenuQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessMenuQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessMenu entity) throws ServiceException;
	
	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessMenu entity) throws ServiceException;

	/**
	 * 删除BusinessMenu
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

	/**
	 * 查找模块下的所有菜单
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessMenu> findMenuByModuleId(final Integer moduleId) throws ServiceException;	

}
