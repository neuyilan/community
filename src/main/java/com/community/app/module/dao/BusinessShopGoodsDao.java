package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessShopGoods;
import com.community.app.module.vo.BusinessShopGoodsQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessShopGoodsDao {
		
	/**
	 * 查询单个BusinessShopGoods
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessShopGoods findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessShopGoods
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShopGoods> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessShopGoods
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShopGoods> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessShopGoods-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessShopGoods> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessShopGoods
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShopGoods> findByExample(final BusinessShopGoodsQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessShopGoods-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessShopGoods> findByExample(final BusinessShopGoodsQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShopGoods> findAllPage(final BusinessShopGoodsQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessShopGoodsQuery query) throws DaoException;
	
	/**
	 * 保存BusinessShopGoods数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessShopGoods entity) throws DaoException;
	
	/**
	 * 修改BusinessShopGoods数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessShopGoods entity) throws DaoException;

	/**
	 * 删除BusinessShopGoods
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
