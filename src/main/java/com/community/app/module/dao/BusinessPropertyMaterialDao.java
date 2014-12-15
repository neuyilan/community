package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessPropertyMaterial;
import com.community.app.module.vo.BusinessPropertyMaterialQuery;

@Repository
public interface BusinessPropertyMaterialDao {
		
	/**
	 * 查询单个BusinessPropertyMaterial
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessPropertyMaterial findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessPropertyMaterial
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessPropertyMaterial> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessPropertyMaterial
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPropertyMaterial> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessPropertyMaterial-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessPropertyMaterial> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessPropertyMaterial
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPropertyMaterial> findByExample(final BusinessPropertyMaterialQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessPropertyMaterial-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessPropertyMaterial> findByExample(final BusinessPropertyMaterialQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessPropertyMaterial> findAllPage(final BusinessPropertyMaterialQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessPropertyMaterialQuery query) throws DaoException;
	
	/**
	 * 保存BusinessPropertyMaterial数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessPropertyMaterial entity) throws DaoException;
	
	/**
	 * 修改BusinessPropertyMaterial数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessPropertyMaterial entity) throws DaoException;

	/**
	 * 删除BusinessPropertyMaterial
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
