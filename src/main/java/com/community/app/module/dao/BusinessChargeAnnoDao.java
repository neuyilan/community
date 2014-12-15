package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessChargeAnno;
import com.community.app.module.vo.BusinessChargeAnnoQuery;

@Repository
public interface BusinessChargeAnnoDao {
		
	/**
	 * 查询单个BusinessChargeAnno
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessChargeAnno findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessChargeAnno
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChargeAnno> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessChargeAnno
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessChargeAnno> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessChargeAnno-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessChargeAnno> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessChargeAnno
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessChargeAnno> findByExample(final BusinessChargeAnnoQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessChargeAnno-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessChargeAnno> findByExample(final BusinessChargeAnnoQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChargeAnno> findAllPage(final BusinessChargeAnnoQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessChargeAnnoQuery query) throws DaoException;
	
	/**
	 * 保存BusinessChargeAnno数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessChargeAnno entity) throws DaoException;
	
	/**
	 * 修改BusinessChargeAnno数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessChargeAnno entity) throws DaoException;

	/**
	 * 删除BusinessChargeAnno
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
