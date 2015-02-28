package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessHelpPic;
import com.community.app.module.vo.BusinessHelpPicQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessHelpPicDao {
		
	/**
	 * 查询单个BusinessHelpPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHelpPic findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessHelpPic
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpPic> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessHelpPic
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpPic> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessHelpPic-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessHelpPic> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessHelpPic
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpPic> findByExample(final BusinessHelpPicQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessHelpPic-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessHelpPic> findByExample(final BusinessHelpPicQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpPic> findAllPage(final BusinessHelpPicQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHelpPicQuery query) throws DaoException;
	
	/**
	 * 保存BusinessHelpPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHelpPic entity) throws DaoException;
	
	/**
	 * 修改BusinessHelpPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHelpPic entity) throws DaoException;

	/**
	 * 删除BusinessHelpPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
