package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessLifeProp;
import com.community.app.module.vo.BusinessLifePropQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessLifePropDao {
		
	/**
	 * 查询单个BusinessLifeProp
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessLifeProp findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessLifeProp
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessLifeProp> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessLifeProp
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessLifeProp> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessLifeProp-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessLifeProp> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * service
	 * 按VO对象条件查询所有BusinessLifeProp
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessLifeProp> findByExample(final BusinessLifePropQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessLifeProp-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessLifeProp> findByExample(final BusinessLifePropQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessLifeProp> findAllPage(final BusinessLifePropQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessLifePropQuery query) throws DaoException;
	
	/**
	 * 保存BusinessLifeProp数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessLifeProp entity) throws DaoException;
	
	/**
	 * 修改BusinessLifeProp数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessLifeProp entity) throws DaoException;

	/**
	 * 删除BusinessLifeProp
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

    /**
     * 删除属性
     * @param id
     * @return
     * @throws DaoException
     */
	public boolean deleteLifeProp(final Integer id) throws DaoException;

}
