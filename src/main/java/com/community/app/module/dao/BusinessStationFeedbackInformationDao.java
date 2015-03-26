package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessStationFeedbackInformation;
import com.community.app.module.vo.BusinessStationFeedbackInformationQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessStationFeedbackInformationDao {
		
	/**
	 * 查询单个BusinessStationFeedbackInformation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessStationFeedbackInformation findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessStationFeedbackInformation
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStationFeedbackInformation> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessStationFeedbackInformation
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStationFeedbackInformation> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessStationFeedbackInformation-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessStationFeedbackInformation> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessStationFeedbackInformation
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStationFeedbackInformation> findByExample(final BusinessStationFeedbackInformationQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessStationFeedbackInformation-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessStationFeedbackInformation> findByExample(final BusinessStationFeedbackInformationQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStationFeedbackInformation> findAllPage(final BusinessStationFeedbackInformationQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessStationFeedbackInformationQuery query) throws DaoException;
	
	/**
	 * 保存BusinessStationFeedbackInformation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessStationFeedbackInformation entity) throws DaoException;
	
	/**
	 * 修改BusinessStationFeedbackInformation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessStationFeedbackInformation entity) throws DaoException;

	/**
	 * 删除BusinessStationFeedbackInformation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
}