package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessCharger;
import com.community.app.module.vo.BusinessChargerQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessChargerDao {
		
	/**
	 * 查询单个BusinessCharger
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessCharger findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessCharger
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessCharger> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessCharger
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessCharger> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessCharger-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessCharger> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessCharger
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessCharger> findByExample(final BusinessChargerQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessCharger-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessCharger> findByExample(final BusinessChargerQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessCharger> findAllPage(final BusinessChargerQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessChargerQuery query) throws DaoException;
	
	/**
	 * 保存BusinessCharger数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessCharger entity) throws DaoException;
	
	/**
	 * 修改BusinessCharger数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessCharger entity) throws DaoException;

	/**
	 * 删除BusinessCharger
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

	public void savelargeData(final List list) throws DaoException;

}
