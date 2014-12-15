package com.community.app.module.dao;

import java.util.List;
import java.util.Map;






import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessBreak;
import com.community.app.module.vo.BusinessBreakQuery;

@Repository
public interface BusinessBreakDao {
		
	/**
	 * 查询单个BusinessBreak
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessBreak findById(final Integer id) throws DaoException;
	
	/**
	 * 查询单个BusinessBreak
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessBreak findById_app(final Integer id) throws DaoException;
	
	/**
	 * 根据爆料ID获取爆料人基本信息及爆料内容
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessBreak checkBreakDetail(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessBreak
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreak> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessBreak
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreak> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessBreak-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessBreak> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessBreak
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreak> findByExample(final BusinessBreakQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessBreak-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessBreak> findByExample(final BusinessBreakQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreak> findAllPage(final BusinessBreakQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessBreakQuery query) throws DaoException;
	
	/**
	 * 保存BusinessBreak数据
	 * @param entity
	 * @throws DaoException
	 */
	public BusinessBreak save(final BusinessBreak entity) throws DaoException;
		
	/**
	 * 修改BusinessBreak数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessBreak entity) throws DaoException;

	/**
	 * 修改BusinessBreak回复数据
	 * @param entity
	 * @throws DaoException
	 */
	public void updateComments(final BusinessBreak entity) throws DaoException;
	
	/**
	 * 删除BusinessBreak
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

	/**
	 * 根据用户id获取用户未被选中爆料的列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBreakQuery> getByUserId(final BusinessBreakQuery query) throws DaoException;	
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int getByUserId_Count(final BusinessBreakQuery query) throws DaoException;
}
