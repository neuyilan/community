package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessNewspaper;
import com.community.app.module.vo.BusinessNewspaperQuery;

@Repository
public interface BusinessNewspaperDao {
		
	/**
	 * 查询单个BusinessNewspaper
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNewspaper findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessNewspaper
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewspaper> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessNewspaper
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewspaper> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessNewspaper-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewspaper> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessNewspaper
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewspaper> findByExample(final BusinessNewspaperQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessNewspaper-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewspaper> findByExample(final BusinessNewspaperQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewspaper> findAllPage(final BusinessNewspaperQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessNewspaperQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewspaper> findAllPage_app(final BusinessNewspaperQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessNewspaperQuery query) throws DaoException;
	
	/**
	 * 保存BusinessNewspaper数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessNewspaper entity) throws DaoException;
	
	/**
	 * 修改BusinessNewspaper数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessNewspaper entity) throws DaoException;

	/**
	 * 删除BusinessNewspaper
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
