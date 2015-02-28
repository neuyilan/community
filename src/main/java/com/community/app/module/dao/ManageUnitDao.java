package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.ManageUnit;
import com.community.app.module.vo.ManageUnitQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Repository
public interface ManageUnitDao {
		
	/**
	 * 查询单个ManageUnit
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageUnit findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有ManageUnit
	 * @return
	 * @throws DaoException
	 */
	public List<ManageUnit> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有ManageUnit
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageUnit> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有ManageUnit-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageUnit> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有ManageUnit
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageUnit> findByExample(final ManageUnitQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有ManageUnit-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageUnit> findByExample(final ManageUnitQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageUnit> findAllPage(final ManageUnitQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageUnitQuery query) throws DaoException;
	
	/**
	 * 保存ManageUnit数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageUnit entity) throws DaoException;
	
	/**
	 * 修改ManageUnit数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageUnit entity) throws DaoException;

	/**
	 * 删除ManageUnit
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	

	/**
	 * 根据小区id查询小区下的全部单元
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageUnit> getUnitByEstateId(final Integer id) throws DaoException;	


}
