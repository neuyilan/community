package com.community.app.module.service;

import java.util.List;
import java.util.Map;








import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFamilyMemberQuery;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessFamily;
import com.community.app.module.vo.BusinessFamilyQuery;


public interface BusinessFamilyService {

	/**
	 * 查询单个BusinessFamily
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessFamily findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessFamily
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessFamily> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessFamily
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFamily> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessFamily-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFamily> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessFamily
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFamily> findByExample(final BusinessFamilyQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessFamily-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFamily> findByExample(final BusinessFamilyQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessFamilyQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessFamilyQuery query) throws ServiceException;
	
	/**
	 * service
	 * 保存BusinessFamily数据并新增家庭成员并返回家庭信息
	 * @param entity
	 * @throws ServiceException
	 */
	public BusinessFamily save(final BusinessFamilyQuery entity) throws ServiceException;
	
	/**
	 * 修改BusinessFamily数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessFamily entity) throws ServiceException;

	/**
	 * 删除BusinessFamily
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * service
	 * 获取家庭信息和成员信息
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessFamilyQuery> getFamilyInfo(final Integer id) throws ServiceException;

	/**
	 * service
	 * 获取家庭信息
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessFamily getFamilyInfoById(final Integer id) throws ServiceException;


}
