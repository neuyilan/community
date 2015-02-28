package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessChinmedichenacareSupport;
import com.community.app.module.vo.BusinessChinmedichenacareSupportQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessChinmedichenacareSupportDao {
		
	/**
	 * 查询单个BusinessChinmedichenacareSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessChinmedichenacareSupport findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessChinmedichenacareSupport
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChinmedichenacareSupport> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacareSupport
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessChinmedichenacareSupport> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacareSupport-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessChinmedichenacareSupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacareSupport
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessChinmedichenacareSupport> findByExample(final BusinessChinmedichenacareSupportQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacareSupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessChinmedichenacareSupport> findByExample(final BusinessChinmedichenacareSupportQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChinmedichenacareSupport> findAllPage(final BusinessChinmedichenacareSupportQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessChinmedichenacareSupportQuery query) throws DaoException;
	
	/**
	 * 保存BusinessChinmedichenacareSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessChinmedichenacareSupport entity) throws DaoException;
	
	/**
	 * 修改BusinessChinmedichenacareSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessChinmedichenacareSupport entity) throws DaoException;

	/**
	 * 删除BusinessChinmedichenacareSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
