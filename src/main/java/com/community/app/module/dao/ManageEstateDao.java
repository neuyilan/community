package com.community.app.module.dao;

import java.util.List;
import java.util.Map;








import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.ManageEstate;
import com.community.app.module.vo.ManageEstateQuery;

@Repository
public interface ManageEstateDao {
		
	/**
	 * 查询单个ManageEstate
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageEstate findById(final Integer id) throws DaoException;
	
	/**
	 * 根据id小区周边
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageEstateQuery> findByEstateAmbitus(ManageEstateQuery query) throws DaoException;
	
	/**
	 * 根据小区id查询小区周边公交站
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageEstateQuery> findByEstateBus(final Integer id) throws DaoException;

	
	/**
	 * 无条件查询所有ManageEstate
	 * @return
	 * @throws DaoException
	 */
	public List<ManageEstate> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有ManageEstate
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageEstate> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有ManageEstate-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageEstate> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有ManageEstate
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageEstate> findByExample(final ManageEstateQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有ManageEstate-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageEstate> findByExample(final ManageEstateQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageEstate> findAllPage(final ManageEstateQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageEstateQuery query) throws DaoException;
	
	/**
	 * 保存ManageEstate数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageEstate entity) throws DaoException;
	
	/**
	 * 修改ManageEstate数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageEstate entity) throws DaoException;

	/**
	 * 删除ManageEstate
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	

	/**
	 * 根据名称模糊查询所有ManageEstate
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageEstate> search(final ManageEstateQuery query) throws DaoException;

}
