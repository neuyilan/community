package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessTel;
import com.community.app.module.vo.BusinessTelQuery;
import com.community.framework.exception.DaoException;

@Repository
public interface BusinessTelDao {
		
	/**
	 * 查询单个BusinessTel
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessTel findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessTel
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessTel> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessTel
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessTel> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessTel-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessTel> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessTel
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessTel> findByExample(final BusinessTelQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessTel-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessTel> findByExample(final BusinessTelQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessTel> findAllPage(final BusinessTelQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessTelQuery query) throws DaoException;
	
	/**
	 * 保存BusinessTel数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessTel entity) throws DaoException;
	
	/**
	 * 修改BusinessTel数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessTel entity) throws DaoException;

	/**
	 * 删除BusinessTel
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
