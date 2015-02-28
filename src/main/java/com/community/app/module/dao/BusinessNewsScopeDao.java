package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessNewsScope;
import com.community.app.module.vo.BusinessNewsScopeQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Repository
public interface BusinessNewsScopeDao {
		
	/**
	 * 查询单个BusinessNewsScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNewsScope findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessNewsScope
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsScope> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessNewsScope
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsScope> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessNewsScope-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessNewsScope> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessNewsScope
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsScope> findByExample(final BusinessNewsScopeQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessNewsScope-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessNewsScope> findByExample(final BusinessNewsScopeQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsScope> findAllPage(final BusinessNewsScopeQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessNewsScopeQuery query) throws DaoException;
	
	/**
	 * 保存BusinessNewsScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessNewsScope entity) throws DaoException;
	
	/**
	 * 修改BusinessNewsScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessNewsScope entity) throws DaoException;

	/**
	 * 删除BusinessNewsScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	

	/**
	 * 根据搜索条件，搜索分页所需的数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessNewsScope> findAllPageByField(final Map fieldMap, final BusinessNewsScopeQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessNewsScope> findListByField(final Map fieldMap, final BusinessNewsScopeQuery query) throws DaoException;
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessNewsScope findByField(final Map fieldMap, final Integer id) throws DaoException;

	/**
	 * 删除新闻范围
	 * @param newsId
	 * @throws ServiceException
	 */
	public boolean deleteScopeByNews(final Integer newsId) throws DaoException;
	
}
