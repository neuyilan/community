package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessActivityRegistrationInformation;
import com.community.app.module.vo.BusinessActivityRegistrationInformationQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessActivityRegistrationInformationDao {
		
	/**
	 * 查询单个BusinessActivityRegistrationInformation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityRegistrationInformation findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessActivityRegistrationInformation
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityRegistrationInformation> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessActivityRegistrationInformation
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityRegistrationInformation> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityRegistrationInformation-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityRegistrationInformation> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessActivityRegistrationInformation
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityRegistrationInformation> findByExample(final BusinessActivityRegistrationInformationQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityRegistrationInformation-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityRegistrationInformation> findByExample(final BusinessActivityRegistrationInformationQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityRegistrationInformation> findAllPage(final BusinessActivityRegistrationInformationQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityRegistrationInformationQuery query) throws DaoException;
	
	/**
	 * 保存BusinessActivityRegistrationInformation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityRegistrationInformation entity) throws DaoException;
	
	/**
	 * 修改BusinessActivityRegistrationInformation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityRegistrationInformation entity) throws DaoException;

	/**
	 * 删除BusinessActivityRegistrationInformation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
