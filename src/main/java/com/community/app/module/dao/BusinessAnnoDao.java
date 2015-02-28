package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessAnno;
import com.community.app.module.bean.index;
import com.community.app.module.vo.BusinessAnnoQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessAnnoDao {
		
	/**
	 * 查询单个BusinessAnno
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessAnno findById(final Integer id) throws DaoException;
	
	/**
	 * 查询单个BusinessAnno
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessAnno findById_app(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessAnno
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnno> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessAnno
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnno> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessAnno-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessAnno> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessAnno
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnno> findByExample(final BusinessAnnoQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessAnno-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessAnno> findByExample(final BusinessAnnoQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnno> findAllPage(final BusinessAnnoQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessAnnoQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnno> findAllPage_app(final BusinessAnnoQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessAnnoQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<index> findAllPage_index_app(final BusinessAnnoQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_index_app(final BusinessAnnoQuery query) throws DaoException;

	
	/**
	 * 保存BusinessAnno数据
	 * @param entity
	 * @throws DaoException
	 */
	public Integer save(final BusinessAnno entity) throws DaoException;
	
	/**
	 * 修改BusinessAnno数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessAnno entity) throws DaoException;

	/**
	 * 删除BusinessAnno
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据 - 只针对物业
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnno> findAllPageByProperty(final BusinessAnnoQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页总数 - 只针对物业
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCountByProperty(final BusinessAnnoQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，为后台首页搜索分页记录
	 * @param query
	 * @return
	 * @throws DaoExceptio
	 */
	public List<BusinessAnno> findAllPageForIndex(final BusinessAnnoQuery query) throws DaoException;

	/**
	 * 根据搜索条件，为后台首页搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCountForIndex(final BusinessAnnoQuery query) throws DaoException;

}
