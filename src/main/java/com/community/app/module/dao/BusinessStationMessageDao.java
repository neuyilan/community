package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessStationMessage;
import com.community.app.module.vo.BusinessStationMessageQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessStationMessageDao {
		
	/**
	 * 查询单个BusinessStationMessage
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessStationMessage findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessStationMessage
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStationMessage> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessStationMessage
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStationMessage> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessStationMessage-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessStationMessage> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessStationMessage
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStationMessage> findByExample(final BusinessStationMessageQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessStationMessage-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessStationMessage> findByExample(final BusinessStationMessageQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据用户查询所管理的小区所对应的驿站
	 * @param paramMap
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStationMessage> findByStationId(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStationMessage> findAllPage(final BusinessStationMessageQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStationMessage> findAllPage_app(final BusinessStationMessageQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessStationMessageQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessStationMessageQuery query) throws DaoException;
	
	/**
	 * 保存BusinessStationMessage数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessStationMessage entity) throws DaoException;
	
	/**
	 * 修改BusinessStationMessage数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessStationMessage entity) throws DaoException;

	/**
	 * 删除BusinessStationMessage
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
}