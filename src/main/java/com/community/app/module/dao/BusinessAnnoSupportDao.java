package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessAnnoSupport;
import com.community.app.module.vo.BusinessAnnoSupportQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessAnnoSupportDao {
		
	/**
	 * 查询单个BusinessAnnoSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessAnnoSupport findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessAnnoSupport
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnnoSupport> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessAnnoSupport
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoSupport> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoSupport-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoSupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoSupport
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoSupport> findByExample(final BusinessAnnoSupportQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessAnnoSupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoSupport> findByExample(final BusinessAnnoSupportQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnnoSupport> findAllPage(final BusinessAnnoSupportQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessAnnoSupportQuery query) throws DaoException;
	
	/**
	 * 保存BusinessAnnoSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessAnnoSupport entity) throws DaoException;
	
	/**
	 * 修改BusinessAnnoSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessAnnoSupport entity) throws DaoException;

	/**
	 * 删除BusinessAnnoSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
