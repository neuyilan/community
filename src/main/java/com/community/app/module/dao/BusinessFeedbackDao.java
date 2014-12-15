package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessFeedback;
import com.community.app.module.vo.BusinessFeedbackQuery;

@Repository
public interface BusinessFeedbackDao {
		
	/**
	 * 查询单个BusinessFeedback
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFeedback findById(final Integer id) throws DaoException;
	
	/**
	 * 查询单个BusinessFeedback
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFeedback findById_app(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessFeedback
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedback> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessFeedback
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedback> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessFeedback-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessFeedback> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessFeedback
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedback> findByExample(final BusinessFeedbackQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessFeedback-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessFeedback> findByExample(final BusinessFeedbackQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedback> findAllPage(final BusinessFeedbackQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFeedbackQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedback> findAllPage_app(final BusinessFeedbackQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessFeedbackQuery query) throws DaoException;
	
	/**
	 * 保存BusinessFeedback数据
	 * @param entity
	 * @return 
	 * @throws DaoException
	 */
	public BusinessFeedback save(final BusinessFeedback entity) throws DaoException;
	
	/**
	 * 修改BusinessFeedback数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFeedback entity) throws DaoException;

	/**
	 * 删除BusinessFeedback
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据 - 针对物业
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedback> findAllPageByProperty(final BusinessFeedbackQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页总数 - 针对物业
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCountByProperty(final BusinessFeedbackQuery query) throws DaoException;

}
