package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessActivityVoteInformation;
import com.community.app.module.vo.BusinessActivityVoteInformationQuery;

@Repository
public interface BusinessActivityVoteInformationDao {
		
	/**
	 * 查询单个BusinessActivityVoteInformation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityVoteInformation findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessActivityVoteInformation
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityVoteInformation> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessActivityVoteInformation
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityVoteInformation> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityVoteInformation-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityVoteInformation> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessActivityVoteInformation
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityVoteInformation> findByExample(final BusinessActivityVoteInformationQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityVoteInformation-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityVoteInformation> findByExample(final BusinessActivityVoteInformationQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityVoteInformation> findAllPage(final BusinessActivityVoteInformationQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityVoteInformationQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_userId(final BusinessActivityVoteInformationQuery query) throws DaoException;

	
	/**
	 * 保存BusinessActivityVoteInformation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityVoteInformation entity) throws DaoException;
	
	/**
	 * 修改BusinessActivityVoteInformation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityVoteInformation entity) throws DaoException;

	/**
	 * 删除BusinessActivityVoteInformation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
