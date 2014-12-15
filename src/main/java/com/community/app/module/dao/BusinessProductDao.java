package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import com.community.framework.exception.DaoException;
import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessProduct;
import com.community.app.module.vo.BusinessProductQuery;

@Repository
public interface BusinessProductDao {
		
	/**
	 * 查询单个BusinessProduct
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessProduct findById(final Integer id) throws DaoException;
	
	/**
	 * 查询单个BusinessProduct
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessProduct findProductById(final Integer id) throws DaoException;
	
	/**
	 * 查询单个BusinessProduct
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessProduct findById_app(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessProduct
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProduct> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessProduct
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProduct> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessProduct-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessProduct> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessProduct
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProduct> findByExample(final BusinessProductQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessProduct-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessProduct> findByExample(final BusinessProductQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProduct> findAllPage(final BusinessProductQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProduct> findAllPage_manage(final BusinessProductQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessProductQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProduct> findAllPage_app(final BusinessProductQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessProductQuery query) throws DaoException;

	
	/**
	 * 保存BusinessProduct数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessProduct entity) throws DaoException;
	
	/**
	 * 修改BusinessProduct数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessProduct entity) throws DaoException;
	
	/**
	 * 保存BusinessProduct数据
	 * @param entity
	 * @throws DaoException
	 */
	public BusinessProduct save_app(final BusinessProduct entity) throws DaoException;
	
	/**
	 * 修改BusinessProduct数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update_app(final BusinessProduct entity) throws DaoException;

	/**
	 * 删除BusinessProduct
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
