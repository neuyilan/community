package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessVote;
import com.community.app.module.vo.BusinessVoteQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessVoteDao {

	/**
	 * 查询单个BusinessVote
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessVote findById(final Integer id) throws DaoException;

	/**
	 * 无条件查询所有BusinessVote
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessVote> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessVote
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessVote> findByMap(final Map<String, Object> paramMap)
			throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessVote-限制返回条数
	 * 
	 * @return
	 * @throws DaoException
	 */
	// public List<BusinessVote> findByMap(final Map<String, Object> paramMap,
	// final Integer limit) throws DaoException;

	/**
	 * 按VO对象条件查询所有BusinessVote
	 * 
	 * @param entity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessVote> findByExample(final BusinessVoteQuery query)
			throws DaoException;

	/**
	 * 按VO对象条件查询所有BusinessVote-限制返回条数
	 * 
	 * @param entity
	 * @return
	 * @throws DaoException
	 */
	// public List<BusinessVote> findByExample(final BusinessVoteQuery query,
	// final Integer limit) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页数据
	 * 
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessVote> findAllPage(final BusinessVoteQuery query)
			throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * 
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessVoteQuery query) throws DaoException;

	/**
	 * 保存BusinessVote数据
	 * 
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessVote entity) throws DaoException;

	/**
	 * 修改BusinessVote数据
	 * 
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessVote entity) throws DaoException;

	/**
	 * 删除BusinessVote
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
