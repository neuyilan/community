package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessActivity;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessActivityService {

	/**
	 * 查询单个BusinessActivity
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessActivity findById(final Integer id) throws ServiceException;
	
	/**
	 * 查询单个BusinessActivity
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessActivity findById_app(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessActivity
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessActivity> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessActivity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivity> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivity-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivity> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessActivity
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivity> findByExample(final BusinessActivityQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessActivity-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivity> findByExample(final BusinessActivityQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessActivityQuery query) throws ServiceException;
	
	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessActivityQuery query) throws ServiceException;
	
	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app_QNH(final BusinessActivityQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessActivityQuery query) throws ServiceException;
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount_app(final BusinessActivityQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessActivity数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessActivity entity) throws ServiceException;
	
	/**
	 * 修改BusinessActivity数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessActivity entity) throws ServiceException;
	
	/**
	 * 修改BusinessActivity数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void addParticipants(final BusinessActivityQuery entity) throws ServiceException;
	
	/**
	 * 查询未开始和已开始的活动判断活动是否关闭或启动
	 * @param entity
	 * @throws ServiceException
	 */
	public void updateState() throws ServiceException;

	/**
	 * 删除BusinessActivity
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 查询活动是否有定时推送当前时间的定时推送如果有这推送
	 * @param entity
	 * @throws ServiceException
	 */
	public void isTimingPush() throws ServiceException;
	
	/**
	 * 查询当前时间活动是否有定时发布
	 * @param entity
	 * @throws ServiceException
	 */
	public void isTimingPublicTime() throws ServiceException;

}
