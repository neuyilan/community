package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessFamilyPet;
import com.community.app.module.vo.BusinessFamilyPetQuery;

@Repository
public interface BusinessFamilyPetDao {
		
	/**
	 * 查询单个BusinessFamilyPet
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFamilyPet findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessFamilyPet
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFamilyPet> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessFamilyPet
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamilyPet> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessFamilyPet-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamilyPet> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessFamilyPet
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamilyPet> findByExample(final BusinessFamilyPetQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessFamilyPet-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamilyPet> findByExample(final BusinessFamilyPetQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFamilyPet> findAllPage(final BusinessFamilyPetQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFamilyPetQuery query) throws DaoException;
	
	/**
	 * 保存BusinessFamilyPet数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessFamilyPet entity) throws DaoException;
	
	/**
	 * 修改BusinessFamilyPet数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFamilyPet entity) throws DaoException;

	/**
	 * 删除BusinessFamilyPet
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
