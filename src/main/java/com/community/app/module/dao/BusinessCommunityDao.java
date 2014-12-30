package com.community.app.module.dao;

import java.util.List;
import java.util.Map;







import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessCommunity;
import com.community.app.module.vo.BusinessCommunityQuery;

@Repository
public interface BusinessCommunityDao {
		
	/**
	 * 查询单个BusinessCommunity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessCommunity findById(final Integer id) throws DaoException;
	
	/**
	 * 查询comId社区下的所有小区
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessCommunity> findByComId(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessCommunity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessCommunity> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessCommunity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessCommunity> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessCommunity-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessCommunity> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessCommunity
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessCommunity> findByExample(final BusinessCommunityQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessCommunity-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessCommunity> findByExample(final BusinessCommunityQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessCommunity> findAllPage(final BusinessCommunityQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessCommunityQuery query) throws DaoException;
	
	/**
	 * 保存BusinessCommunity数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessCommunity entity) throws DaoException;
	
	/**
	 * 修改BusinessCommunity数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessCommunity entity) throws DaoException;

	/**
	 * 删除BusinessCommunity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	
	/**
	 * 获取用户负责的社区
	 * @param userId
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessCommunity> findComsByUser(final Map<String, Object> paramMap) throws DaoException;

}
