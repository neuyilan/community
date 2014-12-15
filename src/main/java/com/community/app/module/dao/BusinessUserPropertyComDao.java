package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import com.community.framework.exception.DaoException;
import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessUserPropertyCom;
import com.community.app.module.vo.BusinessUserPropertyComQuery;

@Repository
public interface BusinessUserPropertyComDao {
		
	/**
	 * 查询单个BusinessUserPropertyCom
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessUserPropertyCom findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessUserPropertyCom
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUserPropertyCom> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessUserPropertyCom
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserPropertyCom> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessUserPropertyCom-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessUserPropertyCom> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessUserPropertyCom
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserPropertyCom> findByExample(final BusinessUserPropertyComQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessUserPropertyCom-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessUserPropertyCom> findByExample(final BusinessUserPropertyComQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUserPropertyCom> findAllPage(final BusinessUserPropertyComQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessUserPropertyComQuery query) throws DaoException;
	
	/**
	 * 保存BusinessUserPropertyCom数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessUserPropertyCom entity) throws DaoException;
	
	/**
	 * 修改BusinessUserPropertyCom数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessUserPropertyCom entity) throws DaoException;

	/**
	 * 删除BusinessUserPropertyCom
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

    /**
     * 查询互动记录
     * @param query
     * @return
     * @throws DaoException
     */
	public List<BusinessUserPropertyCom> getChatInfo(final BusinessUserPropertyComQuery query) throws DaoException;

}
