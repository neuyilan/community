package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessFamilyMember;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFamilyMemberQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessFamilyMemberService {

	/**
	 * 查询单个BusinessFamilyMember
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessFamilyMember findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessFamilyMember
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessFamilyMember> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessFamilyMember
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFamilyMember> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessFamilyMember-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFamilyMember> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessFamilyMember
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFamilyMember> findByExample(final BusinessFamilyMemberQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessFamilyMember-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFamilyMember> findByExample(final BusinessFamilyMemberQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessFamilyMemberQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessFamilyMemberQuery query) throws ServiceException;
	
	/**
	 * service
	 * 保存BusinessFamilyMember数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessFamilyMember entity) throws ServiceException;
	
	/**
	 * service
	 * 申请加入家庭
	 * @param entity
	 * @throws ServiceException
	 */
	public void ApplySave(final BusinessFamilyMember entity) throws ServiceException;
	
	/**
	 * 修改BusinessFamilyMember数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessFamilyMember entity) throws ServiceException;

	/**
	 * 删除BusinessFamilyMember
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

	/**
	 * 验证用户是否有家庭
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean whetherRepeat(final Integer id) throws ServiceException;
	
	/**
	 * service
	 * 用户是否同意申请加入家庭
	 * @param entity
	 * @throws ServiceException
	 */
	public void informationAgreeAdd(final BusinessFamilyMemberQuery query) throws ServiceException;
}
