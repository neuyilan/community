package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessImages;
import com.community.app.module.vo.BusinessImagesQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessImagesDao {
		
	/**
	 * 查询单个BusinessImages
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessImages findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessImages
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessImages> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessImages
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessImages> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessImages-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessImages> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessImages
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessImages> findByExample(final BusinessImagesQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessImages-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessImages> findByExample(final BusinessImagesQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessImages> findAllPage(final BusinessImagesQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessImagesQuery query) throws DaoException;
	
	/**
	 * 保存BusinessImages数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessImages entity) throws DaoException;
	
	/**
	 * 修改BusinessImages数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessImages entity) throws DaoException;

	/**
	 * 删除BusinessImages
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
}