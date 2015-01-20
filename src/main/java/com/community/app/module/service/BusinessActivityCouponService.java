package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessActivityCoupon;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityCouponQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessActivityCouponService {

	/**
	 * 查询单个BusinessActivityCoupon
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessActivityCoupon findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessActivityCoupon
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessActivityCoupon> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessActivityCoupon
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityCoupon> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityCoupon-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityCoupon> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessActivityCoupon
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityCoupon> findByExample(final BusinessActivityCouponQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityCoupon-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityCoupon> findByExample(final BusinessActivityCouponQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessActivityCouponQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessActivityCouponQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessActivityCoupon数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessActivityCoupon entity) throws ServiceException;
	
	/**
	 * 修改BusinessActivityCoupon数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessActivityCoupon entity) throws ServiceException;

	/**
	 * 删除BusinessActivityCoupon
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
