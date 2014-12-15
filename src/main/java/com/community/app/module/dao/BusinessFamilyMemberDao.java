package com.community.app.module.dao;

import java.util.List;
import java.util.Map;






import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessFamilyMember;
import com.community.app.module.vo.BusinessFamilyMemberQuery;

@Repository
public interface BusinessFamilyMemberDao {
		
	/**
	 * 查询单个BusinessFamilyMember
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFamilyMember findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessFamilyMember
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFamilyMember> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessFamilyMember
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamilyMember> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessFamilyMember-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamilyMember> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessFamilyMember
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamilyMember> findByExample(final BusinessFamilyMemberQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessFamilyMember-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamilyMember> findByExample(final BusinessFamilyMemberQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFamilyMember> findAllPage(final BusinessFamilyMemberQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFamilyMemberQuery query) throws DaoException;
	
	/**
	 * 保存BusinessFamilyMember数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessFamilyMember entity) throws DaoException;
	
	/**
	 * service
	 * 申请加入家庭
	 * @param entity
	 * @throws ServiceException
	 */
	public void ApplySave(final BusinessFamilyMember entity) throws DaoException;
	
	/**
	 * 修改BusinessFamilyMember数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFamilyMember entity) throws DaoException;

	/**
	 * 删除BusinessFamilyMember
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 删除BusinessFamilyMember
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete_app(final Integer id) throws DaoException;
	

	/**
	 * 验证用户是否有家庭
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean whetherRepeat(final Integer id) throws DaoException;

}
