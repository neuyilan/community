package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessExpFav;
import com.community.app.module.vo.BusinessExpFavQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessExpFavDao {
		
	/**
	 * 查询单个BusinessExpFav
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessExpFav findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessExpFav
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExpFav> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessExpFav
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExpFav> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessExpFav-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessExpFav> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessExpFav
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExpFav> findByExample(final BusinessExpFavQuery query) throws DaoException;

	/**
	 * 按VO对象条件查询所有BusinessExpFav-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessExpFav> findByExample(final BusinessExpFavQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExpFav> findAllPage(final BusinessExpFavQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessExpFavQuery query) throws DaoException;
	
	/**
	 * 保存BusinessExpFav数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessExpFav entity) throws DaoException;
	
	/**
	 * 修改BusinessExpFav数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessExpFav entity) throws DaoException;

	/**
	 * 删除BusinessExpFav
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
