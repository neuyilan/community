package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessAnnoVisit;
import com.community.app.module.vo.BusinessAnnoVisitQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessAnnoVisitDao {
		
	/**
	 * 查询单个BusinessAnnoVisit
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessAnnoVisit findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessAnnoVisit
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnnoVisit> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessAnnoVisit
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoVisit> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoVisit-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessAnnoVisit> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoVisit
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoVisit> findByExample(final BusinessAnnoVisitQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessAnnoVisit-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessAnnoVisit> findByExample(final BusinessAnnoVisitQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnnoVisit> findAllPage(final BusinessAnnoVisitQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessAnnoVisitQuery query) throws DaoException;
	
	/**
	 * 保存BusinessAnnoVisit数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessAnnoVisit entity) throws DaoException;
	
	/**
	 * 修改BusinessAnnoVisit数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessAnnoVisit entity) throws DaoException;

	/**
	 * 删除BusinessAnnoVisit
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
