package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

import org.springframework.stereotype.Repository;


import com.community.app.module.bean.ManageExpress;
import com.community.app.module.vo.ManageExpressQuery;

@Repository
public interface ManageExpressDao {
		
	/**
	 * 查询单个ManageExpress
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageExpress findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有ManageExpress
	 * @return
	 * @throws DaoException
	 */
	public List<ManageExpress> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有ManageExpress
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageExpress> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有ManageExpress-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageExpress> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有ManageExpress
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageExpress> findByExample(final ManageExpressQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有ManageExpress
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageExpress> findByExample_app(final ManageExpressQuery query) throws DaoException;	

	
	/**
	 * 按VO对象条件查询所有ManageExpress-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageExpress> findByExample(final ManageExpressQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageExpress> findAllPage(final ManageExpressQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageExpressQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageExpress> findAllPage_app(final ManageExpressQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final ManageExpressQuery query) throws DaoException;

	
	/**
	 * 保存ManageExpress数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageExpress entity) throws DaoException;
	
	/**
	 * 修改ManageExpress数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageExpress entity) throws DaoException;

	/**
	 * 删除ManageExpress
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 按驿站查找快递公司
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List findExpressByStation(final Integer stationId) throws DaoException;

}
