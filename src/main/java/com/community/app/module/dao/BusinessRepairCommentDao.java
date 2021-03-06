package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessRepairComment;
import com.community.app.module.vo.BusinessRepairCommentQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessRepairCommentDao {
		
	/**
	 * 查询单个BusinessRepairComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRepairComment findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessRepairComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairComment> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessRepairComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairComment> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessRepairComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRepairComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessRepairComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairComment> findByExample(final BusinessRepairCommentQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessRepairComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRepairComment> findByExample(final BusinessRepairCommentQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairComment> findAllPage(final BusinessRepairCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairComment> findAllPage_app(final BusinessRepairCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRepairCommentQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessRepairCommentQuery query) throws DaoException;

	
	/**
	 * 保存BusinessRepairComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRepairComment entity) throws DaoException;
	
	/**
	 * 保存BusinessRepairComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save_manage(final BusinessRepairComment entity) throws DaoException;
	
	/**
	 * 修改BusinessRepairComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRepairComment entity) throws DaoException;
	
	/**
	 * 修改BusinessRepairComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update_app(final BusinessRepairComment entity) throws DaoException;

	/**
	 * 删除BusinessRepairComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
