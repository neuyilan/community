package com.community.app.module.dao;

import java.util.List;
import java.util.Map;


import com.community.app.module.bean.MemberVO;
import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessRepair;
import com.community.app.module.vo.BusinessRepairQuery;

@Repository
public interface BusinessRepairDao {
		
	/**
	 * 查询单个BusinessRepair
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRepair findById(final Integer id) throws DaoException;
	
	/**
	 * 查询单个BusinessRepair
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRepair findById_app(final Integer id) throws DaoException;

    /**
     * 获取手机用户信息
     * @param id
     * @return
     * @throws DaoException
     */
	public MemberVO findAppUserById(final Integer id) throws DaoException;

	/**
	 * 无条件查询所有BusinessRepair
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepair> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessRepair
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepair> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessRepair-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRepair> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessRepair
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepair> findByExample(final BusinessRepairQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessRepair-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRepair> findByExample(final BusinessRepairQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepair> findAllPage(final BusinessRepairQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepair> findAllPage_app(final BusinessRepairQuery query) throws DaoException;

	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRepairQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessRepairQuery query) throws DaoException;
	
	/**
	 * 保存BusinessRepair数据
	 * @param entity
	 * @throws DaoException
	 */
	public BusinessRepair save(final BusinessRepair entity) throws DaoException;
	
	/**
	 * 修改BusinessRepair数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRepair entity) throws DaoException;
	
	/**
	 * 修改BusinessRepair数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update_app(final BusinessRepair entity) throws DaoException;


	/**
	 * 删除BusinessRepair
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
