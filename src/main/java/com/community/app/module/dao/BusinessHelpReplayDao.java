package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessHelpReplay;
import com.community.app.module.vo.BusinessHelpReplayQuery;

@Repository
public interface BusinessHelpReplayDao {
		
	/**
	 * 查询单个BusinessHelpReplay
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHelpReplay findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessHelpReplay
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpReplay> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessHelpReplay
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpReplay> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessHelpReplay-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessHelpReplay> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessHelpReplay
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpReplay> findByExample(final BusinessHelpReplayQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessHelpReplay-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessHelpReplay> findByExample(final BusinessHelpReplayQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpReplay> findAllPage(final BusinessHelpReplayQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHelpReplayQuery query) throws DaoException;
	
	/**
	 * 保存BusinessHelpReplay数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHelpReplay entity) throws DaoException;
	
	/**
	 * 修改BusinessHelpReplay数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHelpReplay entity) throws DaoException;

	/**
	 * 删除BusinessHelpReplay
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
