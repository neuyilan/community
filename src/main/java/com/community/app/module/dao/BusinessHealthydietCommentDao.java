package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;
import com.community.app.module.bean.BusinessHealthydietComment;
import com.community.app.module.vo.BusinessHealthydietCommentQuery;

@Repository
public interface BusinessHealthydietCommentDao {
		
	/**
	 * 查询单个BusinessHealthydietComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHealthydietComment findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessHealthydietComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHealthydietComment> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessHealthydietComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHealthydietComment> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessHealthydietComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessHealthydietComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessHealthydietComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHealthydietComment> findByExample(final BusinessHealthydietCommentQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessHealthydietComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessHealthydietComment> findByExample(final BusinessHealthydietCommentQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHealthydietComment> findAllPage(final BusinessHealthydietCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHealthydietCommentQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHealthydietComment> findAllPage_app(final BusinessHealthydietCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessHealthydietCommentQuery query) throws DaoException;
	
	/**
	 * 保存BusinessHealthydietComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHealthydietComment entity) throws DaoException;
	
	/**
	 * 后台评论回复
	 * 保存BusinessHealthydietComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void replySave(final BusinessHealthydietComment entity) throws DaoException;
	
	/**
	 * 修改BusinessHealthydietComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHealthydietComment entity) throws DaoException;

	/**
	 * 删除BusinessHealthydietComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
