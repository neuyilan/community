package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessActivityCoupon;
import com.community.app.module.vo.BusinessActivityCouponQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessActivityCouponDao {
		
	/**
	 * 查询单个BusinessActivityCoupon
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityCoupon findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessActivityCoupon
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityCoupon> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessActivityCoupon
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityCoupon> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityCoupon-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityCoupon> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessActivityCoupon
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityCoupon> findByExample(final BusinessActivityCouponQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityCoupon-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityCoupon> findByExample(final BusinessActivityCouponQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityCoupon> findAllPage(final BusinessActivityCouponQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityCouponQuery query) throws DaoException;
	
	/**
	 * 保存BusinessActivityCoupon数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityCoupon entity) throws DaoException;
	
	/**
	 * 修改BusinessActivityCoupon数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityCoupon entity) throws DaoException;

	/**
	 * 删除BusinessActivityCoupon
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
}