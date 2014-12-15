package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import com.community.framework.exception.DaoException;
import org.springframework.stereotype.Repository;


import com.community.app.module.bean.BusinessRepairReply;
import com.community.app.module.vo.BusinessRepairReplyQuery;

@Repository
public interface BusinessRepairReplyDao {
		
	/**
	 * 查询单个BusinessRepairReply
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRepairReply findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessRepairReply
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairReply> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessRepairReply
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairReply> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessRepairReply-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRepairReply> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessRepairReply
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairReply> findByExample(final BusinessRepairReplyQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessRepairReply-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRepairReply> findByExample(final BusinessRepairReplyQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairReply> findAllPage(final BusinessRepairReplyQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRepairReplyQuery query) throws DaoException;
	
	/**
	 * 保存BusinessRepairReply数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRepairReply entity) throws DaoException;
	
	/**
	 * 修改BusinessRepairReply数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRepairReply entity) throws DaoException;

	/**
	 * 删除BusinessRepairReply
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
