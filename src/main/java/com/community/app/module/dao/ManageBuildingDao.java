package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.ManageBuilding;
import com.community.app.module.vo.ManageBuildingQuery;

@Repository
public interface ManageBuildingDao {
		
	/**
	 * 查询单个ManageBuilding
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageBuilding findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有ManageBuilding
	 * @return
	 * @throws DaoException
	 */
	public List<ManageBuilding> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有ManageBuilding
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageBuilding> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有ManageBuilding-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageBuilding> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有ManageBuilding
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageBuilding> findByExample(final ManageBuildingQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有ManageBuilding-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<ManageBuilding> findByExample(final ManageBuildingQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageBuilding> findAllPage(final ManageBuildingQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageBuildingQuery query) throws DaoException;
	
	/**
	 * 保存ManageBuilding数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageBuilding entity) throws DaoException;
	
	/**
	 * 修改ManageBuilding数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageBuilding entity) throws DaoException;

	/**
	 * 删除ManageBuilding
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
