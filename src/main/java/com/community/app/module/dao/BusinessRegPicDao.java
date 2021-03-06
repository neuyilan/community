package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessRegPic;
import com.community.app.module.vo.BusinessRegPicQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessRegPicDao {
		
	/**
	 * 查询单个BusinessRegPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRegPic findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessRegPic
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRegPic> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessRegPic
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRegPic> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessRegPic-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRegPic> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessRegPic
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRegPic> findByExample(final BusinessRegPicQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessRegPic-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRegPic> findByExample(final BusinessRegPicQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRegPic> findAllPage(final BusinessRegPicQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRegPicQuery query) throws DaoException;
	
	/**
	 * 保存BusinessRegPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRegPic entity) throws DaoException;
	
	/**
	 * 修改BusinessRegPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRegPic entity) throws DaoException;

	/**
	 * 删除BusinessRegPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
