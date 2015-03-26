package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessActReg;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActRegQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessActRegService {

	/**
	 * 查询单个BusinessActReg
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessActReg findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessActReg
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessActReg> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessActReg
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActReg> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessActReg-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActReg> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessActReg
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActReg> findById_app(final BusinessActRegQuery query) throws ServiceException;	
	
	/**
	 * 按VO对象条件查询所有BusinessActReg
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActReg> findByExample(final BusinessActRegQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessActReg-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActReg> findByExample(final BusinessActRegQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessActRegQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessActRegQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessActReg数据
	 * @param entity
	 * @throws ServiceException
	 */
	public int save(final BusinessActReg entity) throws ServiceException;
	
	/**
	 * 修改BusinessActReg数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessActReg entity) throws ServiceException;

	/**
	 * 删除BusinessActReg
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

	/**
	 * 计算当前选手前面有多少名 总数
	 * @param map
	 * @return
	 */
	public int cntFront(Map<String, Object> map)  throws ServiceException;
	
	/**
	 * 修改当前的选手的code
	 * @param map
	 * @return
	 */
	public void updateCode(Map<String, Object> map) throws ServiceException;

	/**
	 * 查询报名排名
	 * @param map
	 * @return
	 */
	public BaseBean findRankPage(BusinessActRegQuery query) throws ServiceException;
	
	/**
	 * 获取最新报名
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findLatestRegPage(BusinessActRegQuery query)  throws ServiceException;
	
}
