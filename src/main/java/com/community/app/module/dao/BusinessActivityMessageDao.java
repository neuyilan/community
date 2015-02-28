package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessActivityMessage;
import com.community.app.module.vo.BusinessActivityMessageQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessActivityMessageDao {
		
	/**
	 * 查询单个BusinessActivityMessage
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityMessage findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessActivityMessage
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityMessage> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessActivityMessage
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityMessage> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityMessage-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityMessage> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessActivityMessage
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityMessage> findByExample(final BusinessActivityMessageQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityMessage-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityMessage> findByExample(final BusinessActivityMessageQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityMessage> findAllPage(final BusinessActivityMessageQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityMessageQuery query) throws DaoException;
	
	/**
	 * 保存BusinessActivityMessage数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityMessage entity) throws DaoException;
	
	/**
	 * 修改BusinessActivityMessage数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityMessage entity) throws DaoException;

	/**
	 * 删除BusinessActivityMessage
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
