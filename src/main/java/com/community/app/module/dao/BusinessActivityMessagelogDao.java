package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessActivityMessagelog;
import com.community.app.module.vo.BusinessActivityMessagelogQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessActivityMessagelogDao {
		
	/**
	 * 查询单个BusinessActivityMessagelog
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityMessagelog findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessActivityMessagelog
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityMessagelog> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessActivityMessagelog
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityMessagelog> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityMessagelog-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityMessagelog> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessActivityMessagelog
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityMessagelog> findByExample(final BusinessActivityMessagelogQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityMessagelog-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityMessagelog> findByExample(final BusinessActivityMessagelogQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityMessagelog> findAllPage(final BusinessActivityMessagelogQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityMessagelogQuery query) throws DaoException;
	
	/**
	 * 保存BusinessActivityMessagelog数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityMessagelog entity) throws DaoException;
	
	/**
	 * 修改BusinessActivityMessagelog数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityMessagelog entity) throws DaoException;

	/**
	 * 删除BusinessActivityMessagelog
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
