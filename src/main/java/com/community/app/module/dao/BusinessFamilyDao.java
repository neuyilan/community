package com.community.app.module.dao;

import java.util.List;
import java.util.Map;







import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessFamily;
import com.community.app.module.vo.BusinessFamilyMemberQuery;
import com.community.app.module.vo.BusinessFamilyQuery;

@Repository
public interface BusinessFamilyDao {
		
	/**
	 * 查询单个BusinessFamily
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFamily findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessFamily
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFamily> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessFamily
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamily> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessFamily-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamily> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessFamily
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamily> findByExample(final BusinessFamilyQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessFamily-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamily> findByExample(final BusinessFamilyQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFamily> findAllPage(final BusinessFamilyQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFamilyQuery query) throws DaoException;
	
	/**
	 * 保存家庭并新增家庭成员并返回家庭信息
	 * @param entity
	 * @throws DaoException
	 */
	public BusinessFamily save(final BusinessFamilyQuery entity) throws DaoException;
	
	/**
	 * 修改BusinessFamily数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFamily entity) throws DaoException;

	/**
	 * 删除BusinessFamily
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 获取家庭信息和成员信息
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessFamilyQuery> getFamilyInfo(final Integer id) throws DaoException;
	

	/**
	 * service
	 * 获取家庭信息
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessFamily getFamilyInfoById(final Integer id) throws DaoException;

}
