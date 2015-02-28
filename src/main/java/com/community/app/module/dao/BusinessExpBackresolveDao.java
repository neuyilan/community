package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessExpBackresolve;
import com.community.app.module.bean.BusinessExpResolve;
import com.community.app.module.vo.BusinessExpBackresolveQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessExpBackresolveDao {
		
	/**
	 * 查询单个BusinessExpBackresolve
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessExpBackresolve findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessExpBackresolve
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExpBackresolve> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessExpBackresolve
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExpBackresolve> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessExpBackresolve-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessExpBackresolve> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessExpBackresolve
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExpBackresolve> findByExample(final BusinessExpBackresolveQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessExpBackresolve-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessExpBackresolve> findByExample(final BusinessExpBackresolveQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExpBackresolve> findAllPage(final BusinessExpBackresolveQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessExpBackresolveQuery query) throws DaoException;
	
	/**
	 * 保存BusinessExpBackresolve数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessExpBackresolve entity) throws DaoException;
	
	/**
	 * 保存BusinessExpBackresolve数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save_app(final BusinessExpResolve entity) throws DaoException;
	
	/**
	 * 修改BusinessExpBackresolve数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessExpBackresolve entity) throws DaoException;

	/**
	 * 删除BusinessExpBackresolve
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
