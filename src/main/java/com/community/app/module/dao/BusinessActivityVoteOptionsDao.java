package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessActivityVoteOptions;
import com.community.app.module.vo.BusinessActivityVoteOptionsQuery;

@Repository
public interface BusinessActivityVoteOptionsDao {
		
	/**
	 * 查询单个BusinessActivityVoteOptions
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityVoteOptions findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessActivityVoteOptions
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityVoteOptions> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessActivityVoteOptions
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityVoteOptions> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityVoteOptions-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityVoteOptions> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessActivityVoteOptions
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityVoteOptions> findByExample(final BusinessActivityVoteOptionsQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityVoteOptions-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityVoteOptions> findByExample(final BusinessActivityVoteOptionsQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityVoteOptions> findAllPage(final BusinessActivityVoteOptionsQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityVoteOptionsQuery query) throws DaoException;
	
	/**
	 * 保存BusinessActivityVoteOptions数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityVoteOptions entity) throws DaoException;
	
	/**
	 * 修改BusinessActivityVoteOptions数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityVoteOptions entity) throws DaoException;

	/**
	 * 删除BusinessActivityVoteOptions
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
