package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;


import com.community.app.module.bean.AppAutomobileNumber;
import com.community.app.module.vo.AppAutomobileNumberQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface AppAutomobileNumberDao {
		
	/**
	 * 查询单个AppAutomobileNumber
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppAutomobileNumber findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有AppAutomobileNumber
	 * @return
	 * @throws DaoException
	 */
	public List<AppAutomobileNumber> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有AppAutomobileNumber
	 * @return
	 * @throws DaoException
	 */	
	public List<AppAutomobileNumber> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有AppAutomobileNumber-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<AppAutomobileNumber> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有AppAutomobileNumber
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppAutomobileNumber> findByExample(final AppAutomobileNumberQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有AppAutomobileNumber
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppAutomobileNumber> findByExample_app(final AppAutomobileNumberQuery query) throws DaoException;	

	
	/**
	 * 按VO对象条件查询所有AppAutomobileNumber-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<AppAutomobileNumber> findByExample(final AppAutomobileNumberQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppAutomobileNumber> findAllPage(final AppAutomobileNumberQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppAutomobileNumberQuery query) throws DaoException;
	
	/**
	 * 保存AppAutomobileNumber数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppAutomobileNumber entity) throws DaoException;
	
	/**
	 * 修改AppAutomobileNumber数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppAutomobileNumber entity) throws DaoException;

	/**
	 * 删除AppAutomobileNumber
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 删除AppAutomobileNumber
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final AppAutomobileNumber entity) throws DaoException;

}
