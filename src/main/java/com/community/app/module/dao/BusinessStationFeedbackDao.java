package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessStationFeedback;
import com.community.app.module.vo.BusinessStationFeedbackQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessStationFeedbackDao {
		
	/**
	 * 查询单个BusinessStationFeedback
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessStationFeedback findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessStationFeedback
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStationFeedback> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessStationFeedback
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStationFeedback> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessStationFeedback-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessStationFeedback> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessStationFeedback
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStationFeedback> findByExample(final BusinessStationFeedbackQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessStationFeedback-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessStationFeedback> findByExample(final BusinessStationFeedbackQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStationFeedback> findAllPage(final BusinessStationFeedbackQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessStationFeedbackQuery query) throws DaoException;
	
	/**
	 * 保存BusinessStationFeedback数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessStationFeedback entity) throws DaoException;
	
	/**
	 * 修改BusinessStationFeedback数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessStationFeedback entity) throws DaoException;

	/**
	 * 删除BusinessStationFeedback
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
}