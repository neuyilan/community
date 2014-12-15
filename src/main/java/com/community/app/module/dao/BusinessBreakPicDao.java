package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import com.community.framework.exception.DaoException;
import com.community.app.module.bean.BusinessBreakPic;
import com.community.app.module.vo.BusinessBreakPicQuery;

@Repository
public interface BusinessBreakPicDao {
		
	/**
	 * 查询单个BusinessBreakPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessBreakPic findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessBreakPic
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakPic> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessBreakPic
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreakPic> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessBreakPic-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessBreakPic> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 根据爆料ID查询所有爆料的图片BusinessBreakPic
	 * @param entity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakPic> findPicListByBreakId(final BusinessBreakPicQuery query) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessBreakPic
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreakPic> findByExample(final BusinessBreakPicQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessBreakPic-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessBreakPic> findByExample(final BusinessBreakPicQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakPic> findAllPage(final BusinessBreakPicQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessBreakPicQuery query) throws DaoException;
	
	/**
	 * 保存BusinessBreakPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessBreakPic entity) throws DaoException;
	
	/**
	 * 修改BusinessBreakPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessBreakPic entity) throws DaoException;

	/**
	 * 删除BusinessBreakPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
