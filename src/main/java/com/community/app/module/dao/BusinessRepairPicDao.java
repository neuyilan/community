package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessRepairPic;
import com.community.app.module.vo.BusinessRepairPicQuery;

@Repository
public interface BusinessRepairPicDao {
		
	/**
	 * 查询单个BusinessRepairPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRepairPic findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessRepairPic
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairPic> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessRepairPic
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairPic> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessRepairPic-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRepairPic> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessRepairPic
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairPic> findByExample(final BusinessRepairPicQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessRepairPic-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRepairPic> findByExample(final BusinessRepairPicQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairPic> findAllPage(final BusinessRepairPicQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRepairPicQuery query) throws DaoException;
	
	/**
	 * 保存BusinessRepairPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRepairPic entity) throws DaoException;
	
	/**
	 * 修改BusinessRepairPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRepairPic entity) throws DaoException;

	/**
	 * 删除BusinessRepairPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
