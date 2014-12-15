package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;
import com.community.app.module.bean.BusinessChinmedichenacareComment;
import com.community.app.module.vo.BusinessChinmedichenacareCommentQuery;

@Repository
public interface BusinessChinmedichenacareCommentDao {
		
	/**
	 * 查询单个BusinessChinmedichenacareComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessChinmedichenacareComment findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessChinmedichenacareComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChinmedichenacareComment> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacareComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessChinmedichenacareComment> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacareComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessChinmedichenacareComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacareComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessChinmedichenacareComment> findByExample(final BusinessChinmedichenacareCommentQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacareComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessChinmedichenacareComment> findByExample(final BusinessChinmedichenacareCommentQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChinmedichenacareComment> findAllPage(final BusinessChinmedichenacareCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessChinmedichenacareCommentQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChinmedichenacareComment> findAllPage_app(final BusinessChinmedichenacareCommentQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessChinmedichenacareCommentQuery query) throws DaoException;
	
	
	/**
	 * 保存BusinessChinmedichenacareComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessChinmedichenacareComment entity) throws DaoException;
	
	/**
	 * 后台评论回复
	 * 保存BusinessChinmedichenacareComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void replySave(final BusinessChinmedichenacareComment entity) throws DaoException;
	
	/**
	 * 修改BusinessChinmedichenacareComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessChinmedichenacareComment entity) throws DaoException;

	/**
	 * 删除BusinessChinmedichenacareComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
