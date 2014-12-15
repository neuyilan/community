package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import com.community.framework.exception.DaoException;
import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessProductPic;
import com.community.app.module.vo.BusinessProductPicQuery;

@Repository
public interface BusinessProductPicDao {
		
	/**
	 * 查询单个BusinessProductPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessProductPic findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessProductPic
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductPic> findAll() throws DaoException;

	/**
	 * 根据跳蚤市场ID查询所有BusinessProductPic
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductPic> findAllPicbyId(final Integer id) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessProductPic
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductPic> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessProductPic-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessProductPic> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessProductPic
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductPic> findByExample(final BusinessProductPicQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessProductPic-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessProductPic> findByExample(final BusinessProductPicQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductPic> findAllPage(final BusinessProductPicQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessProductPicQuery query) throws DaoException;
	
	/**
	 * 保存BusinessProductPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessProductPic entity) throws DaoException;
	
	/**
	 * 保存BusinessProductPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save_app(final BusinessProductPic entity) throws DaoException;

	
	/**
	 * 修改BusinessProductPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessProductPic entity) throws DaoException;

	/**
	 * 删除BusinessProductPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 删除BusinessProductPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete_app(final Integer id) throws DaoException;

}
