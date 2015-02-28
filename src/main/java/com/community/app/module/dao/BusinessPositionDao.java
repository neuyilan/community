package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessPosition;
import com.community.app.module.vo.BusinessPositionQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessPositionDao {
		
	/**
	 * 查询单个BusinessPosition
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessPosition findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessPosition
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessPosition> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessPosition
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPosition> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessPosition-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessPosition> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessPosition
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPosition> findByExample(final BusinessPositionQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessPosition-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessPosition> findByExample(final BusinessPositionQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessPosition> findAllPage(final BusinessPositionQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessPositionQuery query) throws DaoException;
	
	/**
	 * 保存BusinessPosition数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessPosition entity) throws DaoException;
	
	/**
	 * 修改BusinessPosition数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessPosition entity) throws DaoException;

	/**
	 * 删除BusinessPosition
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
