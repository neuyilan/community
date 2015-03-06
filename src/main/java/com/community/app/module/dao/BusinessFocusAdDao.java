package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessFocus;
import com.community.app.module.bean.BusinessFocusAd;
import com.community.app.module.vo.BusinessFocusAdQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessFocusAdDao {
		
	/**
	 * 查询单个BusinessFocusAd
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFocusAd findById(final Integer id) throws DaoException;
	
	/**
	 * 查询单个BusinessFocusAd
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFocusAd> findById_app(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessFocusAd
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFocusAd> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessFocusAd
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFocusAd> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessFocusAd-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessFocusAd> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessFocusAd
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFocusAd> findByExample(final BusinessFocusAdQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessFocusAd-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessFocusAd> findByExample(final BusinessFocusAdQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFocusAd> findAllPage(final BusinessFocusAdQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFocusAdQuery query) throws DaoException;
	
	/**
	 * 保存BusinessFocusAd数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessFocusAd entity) throws DaoException;
	
	/**
	 * 修改BusinessFocusAd数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFocusAd entity) throws DaoException;

	/**
	 * 删除BusinessFocusAd
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * service
	 * 修改BusinessFocusAd浏览量
	 * @param entity
	 * @throws DaoException
	 */
	public void updateVisits(final BusinessFocusAd entity) throws DaoException;
}