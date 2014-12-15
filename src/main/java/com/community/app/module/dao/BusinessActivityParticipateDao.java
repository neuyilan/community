package com.community.app.module.dao;

import java.util.List;
import java.util.Map;






import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessActivityParticipate;
import com.community.app.module.vo.BusinessActivityParticipateQuery;

@Repository
public interface BusinessActivityParticipateDao {
		
	/**
	 * 查询单个BusinessActivityParticipate
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityParticipate findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessActivityParticipate
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityParticipate> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessActivityParticipate
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityParticipate> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityParticipate-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityParticipate> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessActivityParticipate
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityParticipate> findByExample(final BusinessActivityParticipateQuery query) throws DaoException;	

	/**
	 * service
	 * 获取排名
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public Map<String,Object> ranking(final BusinessActivityParticipateQuery query) throws DaoException;	

	
	/**
	 * 按VO对象条件查询所有BusinessActivityParticipate-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActivityParticipate> findByExample(final BusinessActivityParticipateQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityParticipate> findAllPage(final BusinessActivityParticipateQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityParticipateQuery query) throws DaoException;
	
	/**
	 * 保存BusinessActivityParticipate数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityParticipate entity) throws DaoException;
	
	/**
	 * 修改BusinessActivityParticipate数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityParticipate entity) throws DaoException;

	/**
	 * 删除BusinessActivityParticipate
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
