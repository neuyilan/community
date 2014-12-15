package com.community.app.module.dao;

import java.util.List;
import java.util.Map;






import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;
import com.community.app.module.bean.BusinessBreakSelect;
import com.community.app.module.vo.BusinessBreakSelectQuery;

@Repository
public interface BusinessBreakSelectDao {
		
	/**
	 * 查询单个BusinessBreakSelect
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessBreakSelect findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessBreakSelect
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakSelect> findAll() throws DaoException;

	/**
	 * 根据爆料ID查询所有选用的爆料BusinessBreakSelect
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakSelect> findListByBreakId(final BusinessBreakSelectQuery query) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessBreakSelect
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreakSelect> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessBreakSelect-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessBreakSelect> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessBreakSelect
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreakSelect> findByExample(final BusinessBreakSelectQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessBreakSelect-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessBreakSelect> findByExample(final BusinessBreakSelectQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakSelect> findAllPage(final BusinessBreakSelectQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessBreakSelectQuery query) throws DaoException;
	
	/**
	 * 保存BusinessBreakSelect数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessBreakSelect entity) throws DaoException;
	
	/**
	 * 修改BusinessBreakSelect数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessBreakSelect entity) throws DaoException;

	/**
	 * 删除BusinessBreakSelect
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
