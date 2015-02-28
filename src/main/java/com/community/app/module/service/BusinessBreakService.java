package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessBreak;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessBreakQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessBreakService {

	/**
	 * 查询单个BusinessBreak
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessBreak findById(final Integer id) throws ServiceException;
	
	/**
	 * service
	 * 查询单个BusinessBreak
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessBreak findById_app(final Integer id) throws ServiceException;
	
	/**
	 * 根据爆料ID获取爆料人基本信息及爆料内容
	 * 查询单个BusinessBreak
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessBreak checkBreakDetail(final Integer id) throws ServiceException;
	/**
	 * 无条件查询所有BusinessBreak
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBreak> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessBreak
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBreak> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessBreak-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessBreak> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessBreak
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBreak> findByExample(final BusinessBreakQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessBreak-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessBreak> findByExample(final BusinessBreakQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessBreakQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessBreakQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessBreak数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessBreak entity) throws ServiceException;
		
	/**
	 * 修改BusinessBreak数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessBreak entity) throws ServiceException;

	/**
	 * 修改BusinessBreak回复数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void updateComments(final BusinessBreak entity) throws ServiceException;
	
	/**
	 * 删除BusinessBreak
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * service
	 * 根据用户id获取用户未被选中爆料的列表带分页
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public BaseBean getByUserId(final BusinessBreakQuery query) throws ServiceException;	
	
	/**
	 * service
	 * 发布爆料
	 * @param entity
	 * @throws ServiceException
	 */
	public void publishBroke(final BusinessBreak entity,Map imageMap,Map audioMap) throws ServiceException;
	
	/**
	 * service
	 * 发布爆料
	 * @param entity
	 * @throws ServiceException
	 */
	public void publishBrokePHP(final BusinessBreak entity,String[] images) throws ServiceException;

}
