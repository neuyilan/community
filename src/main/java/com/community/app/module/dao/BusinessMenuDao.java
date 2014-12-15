package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

import com.community.app.module.bean.BusinessMenu;
import com.community.app.module.vo.BusinessMenuQuery;

@Repository
public interface BusinessMenuDao {
		
	/**
	 * 查询单个BusinessMenu
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessMenu findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessMenu
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessMenu> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessMenu
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessMenu> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessMenu-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessMenu> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessMenu
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessMenu> findByExample(final BusinessMenuQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessMenu-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessMenu> findByExample(final BusinessMenuQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessMenu> findAllPage(final BusinessMenuQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessMenuQuery query) throws DaoException;
	
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessMenu entity) throws DaoException;
	
	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessMenu entity) throws DaoException;

	/**
	 * 删除BusinessMenu
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 查找模块下的所有菜单
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessMenu> findMenuByModuleId(final Integer moduleId) throws DaoException;

}
