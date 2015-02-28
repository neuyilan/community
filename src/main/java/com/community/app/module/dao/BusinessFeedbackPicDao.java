package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessFeedbackPic;
import com.community.app.module.vo.BusinessFeedbackPicQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessFeedbackPicDao {
		
	/**
	 * 查询单个BusinessFeedbackPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFeedbackPic findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessFeedbackPic
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedbackPic> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessFeedbackPic
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedbackPic> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackPic-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessFeedbackPic> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackPic
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedbackPic> findByExample(final BusinessFeedbackPicQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessFeedbackPic-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessFeedbackPic> findByExample(final BusinessFeedbackPicQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedbackPic> findAllPage(final BusinessFeedbackPicQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFeedbackPicQuery query) throws DaoException;
	
	/**
	 * 保存BusinessFeedbackPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessFeedbackPic entity) throws DaoException;
	
	/**
	 * 修改BusinessFeedbackPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFeedbackPic entity) throws DaoException;

	/**
	 * 删除BusinessFeedbackPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
