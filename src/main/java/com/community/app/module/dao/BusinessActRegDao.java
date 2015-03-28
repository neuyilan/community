package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessActReg;
import com.community.app.module.vo.BusinessActRegQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Repository
public interface BusinessActRegDao {
		
	/**
	 * 查询单个BusinessActReg
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActReg findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessActReg
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActReg> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessActReg
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActReg> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessActReg-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActReg> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessActReg
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActReg> findByExample(final BusinessActRegQuery query) throws DaoException;	
	
	/**
	 * 按VO对象条件查询所有BusinessActReg
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActReg> findById_app(final BusinessActRegQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessActReg-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessActReg> findByExample(final BusinessActRegQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActReg> findAllPage(final BusinessActRegQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActRegQuery query) throws DaoException;
	
	/**
	 * 保存BusinessActReg数据
	 * @param entity
	 * @return 
	 * @throws DaoException
	 */
	public int save(final BusinessActReg entity) throws DaoException;
	
	/**
	 * 修改BusinessActReg数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActReg entity) throws DaoException;

	/**
	 * 删除BusinessActReg
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

	/**
	 * 计算当前选手前面有多少名 总数
	 * @param map
	 * @return
	 */
	public int cntFront(Map<String, Object> map)throws DaoException;

	/**
	 * 修改当前的选手的code
	 * @param map
	 * @return
	 */
	public void updateCode(Map<String, Object> map) throws DaoException;

	/**
	 * 查询报名排名
	 * @param map
	 * @return
	 */
	public List<BusinessActReg> findRankPage(BusinessActRegQuery query) throws DaoException;

	/**
	 * 获取最新报名
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessActReg> findLatestRegPage(BusinessActRegQuery query) throws DaoException;

	public void updateVotes(Map<String, Object> map) throws DaoException;
	
}
