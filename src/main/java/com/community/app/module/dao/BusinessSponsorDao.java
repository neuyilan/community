package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessSponsor;
import com.community.app.module.vo.BusinessSponsorQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessSponsorDao {
		
	/**
	 * 查询单个BusinessSponsor
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessSponsor findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessSponsor
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessSponsor> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessSponsor
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessSponsor> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessSponsor-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessSponsor> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessSponsor
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessSponsor> findByExample(final BusinessSponsorQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessSponsor-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessSponsor> findByExample(final BusinessSponsorQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessSponsor> findAllPage(final BusinessSponsorQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessSponsorQuery query) throws DaoException;
	
	/**
	 * 保存BusinessSponsor数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessSponsor entity) throws DaoException;
	
	/**
	 * 修改BusinessSponsor数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessSponsor entity) throws DaoException;

	/**
	 * 删除BusinessSponsor
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
