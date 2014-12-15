package com.community.app.module.service;

import java.util.List;
import java.util.Map;







import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFamilyQuery;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessFamilyPet;
import com.community.app.module.vo.BusinessFamilyPetQuery;


public interface BusinessFamilyPetService {

	/**
	 * 查询单个BusinessFamilyPet
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessFamilyPet findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessFamilyPet
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessFamilyPet> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessFamilyPet
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFamilyPet> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessFamilyPet-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFamilyPet> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessFamilyPet
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFamilyPet> findByExample(final BusinessFamilyPetQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessFamilyPet-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFamilyPet> findByExample(final BusinessFamilyPetQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessFamilyPetQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessFamilyPetQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessFamilyPet数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessFamilyPet entity) throws ServiceException;
	
	/**
	 * 修改BusinessFamilyPet数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessFamilyPet entity) throws ServiceException;

	/**
	 * 删除BusinessFamilyPet
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	
}
