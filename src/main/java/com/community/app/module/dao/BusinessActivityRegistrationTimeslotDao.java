package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessActivityRegistrationTimeslot;
import com.community.app.module.vo.BusinessActivityRegistrationTimeslotQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessActivityRegistrationTimeslotDao {
		
	/**
	 * 查询单个BusinessActivityRegistrationTimeslot
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityRegistrationTimeslot findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessActivityRegistrationTimeslot
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityRegistrationTimeslot> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessActivityRegistrationTimeslot
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityRegistrationTimeslot> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityRegistrationTimeslot-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityRegistrationTimeslot> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessActivityRegistrationTimeslot
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityRegistrationTimeslot> findByExample(final BusinessActivityRegistrationTimeslotQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityRegistrationTimeslot-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityRegistrationTimeslot> findByExample(final BusinessActivityRegistrationTimeslotQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityRegistrationTimeslot> findAllPage(final BusinessActivityRegistrationTimeslotQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityRegistrationTimeslotQuery query) throws DaoException;
	
	/**
	 * 保存BusinessActivityRegistrationTimeslot数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityRegistrationTimeslot entity) throws DaoException;
	
	/**
	 * 修改BusinessActivityRegistrationTimeslot数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityRegistrationTimeslot entity) throws DaoException;

	/**
	 * 删除BusinessActivityRegistrationTimeslot
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
}