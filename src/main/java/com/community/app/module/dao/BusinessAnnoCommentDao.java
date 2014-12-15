package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessAnnoComment;
import com.community.app.module.vo.BusinessAnnoCommentQuery;
import com.community.framework.exception.DaoException;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessAnnoCommentDao {
		
	/**
	 * 查询单个BusinessAnnoComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessAnnoComment findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessAnnoComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnnoComment> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessAnnoComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoComment> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessAnnoComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoComment> findByExample(final BusinessAnnoCommentQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessAnnoComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessAnnoComment> findByExample(final BusinessAnnoCommentQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnnoComment> findAllPage(final BusinessAnnoCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessAnnoCommentQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnnoComment> findAllPage_app(final BusinessAnnoCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessAnnoCommentQuery query) throws DaoException;

	
	/**
	 * 保存BusinessAnnoComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessAnnoComment entity) throws DaoException;
	
	/**
	 * 后台回复保存BusinessAnnoComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void replySave(final BusinessAnnoComment entity) throws DaoException;
	
	/**
	 * 修改BusinessAnnoComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessAnnoComment entity) throws DaoException;

	/**
	 * 删除BusinessAnnoComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
