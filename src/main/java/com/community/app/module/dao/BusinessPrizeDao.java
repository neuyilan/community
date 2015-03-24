package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessPrize;
import com.community.app.module.vo.BusinessPrizeQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessPrizeDao {
		
	/**
	 * 查询单个BusinessPrize
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessPrize findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessPrize
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessPrize> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessPrize
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPrize> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessPrize-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessPrize> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessPrize
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPrize> findByExample(final BusinessPrizeQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessPrize-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessPrize> findByExample(final BusinessPrizeQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessPrize> findAllPage(final BusinessPrizeQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessPrizeQuery query) throws DaoException;
	
	/**
	 * 保存BusinessPrize数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessPrize entity) throws DaoException;
	
	/**
	 * 修改BusinessPrize数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessPrize entity) throws DaoException;

	/**
	 * 删除BusinessPrize
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
