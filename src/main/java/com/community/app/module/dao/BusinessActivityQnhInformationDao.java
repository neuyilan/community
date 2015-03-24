package com.community.app.module.dao;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessActivityQnhInformation;
import com.community.app.module.vo.BusinessActivityQnhInformationQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessActivityQnhInformationDao {
		
	/**
	 * 查询单个BusinessActivityQnhInformation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityQnhInformation findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessActivityQnhInformation
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityQnhInformation> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessActivityQnhInformation
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityQnhInformation> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityQnhInformation-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityQnhInformation> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessActivityQnhInformation
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityQnhInformation> findByExample(final BusinessActivityQnhInformationQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityQnhInformation-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityQnhInformation> findByExample(final BusinessActivityQnhInformationQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityQnhInformation> findAllPage(final BusinessActivityQnhInformationQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityQnhInformationQuery query) throws DaoException;
	
	/**
	 * 保存BusinessActivityQnhInformation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityQnhInformation entity) throws DaoException;
	
	/**
	 * 修改BusinessActivityQnhInformation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityQnhInformation entity) throws DaoException;

	/**
	 * 删除BusinessActivityQnhInformation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
