package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessRepairReply;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessRepairReplyQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessRepairReplyService {

	/**
	 * 查询单个BusinessRepairReply
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRepairReply findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessRepairReply
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRepairReply> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessRepairReply
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRepairReply> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessRepairReply-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRepairReply> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessRepairReply
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRepairReply> findByExample(final BusinessRepairReplyQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessRepairReply-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRepairReply> findByExample(final BusinessRepairReplyQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessRepairReplyQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessRepairReplyQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessRepairReply数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessRepairReply entity) throws ServiceException;
	
	/**
	 * 修改BusinessRepairReply数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessRepairReply entity) throws ServiceException;

	/**
	 * 删除BusinessRepairReply
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
