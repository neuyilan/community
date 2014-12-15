package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.ManageUnit;
import com.community.app.module.vo.ManageUnitQuery;


public interface ManageUnitService {

	/**
	 * 查询单个ManageUnit
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public ManageUnit findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有ManageUnit
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageUnit> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有ManageUnit
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageUnit> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有ManageUnit-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageUnit> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有ManageUnit
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageUnit> findByExample(final ManageUnitQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有ManageUnit-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageUnit> findByExample(final ManageUnitQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final ManageUnitQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final ManageUnitQuery query) throws ServiceException;
	
	/**
	 * 保存ManageUnit数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final ManageUnit entity) throws ServiceException;
	
	/**
	 * 修改ManageUnit数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final ManageUnit entity) throws ServiceException;

	/**
	 * 删除ManageUnit
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 根据小区id查询小区下的全部单元
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageUnit> getUnitByEstateId(final Integer id) throws ServiceException;	


}
