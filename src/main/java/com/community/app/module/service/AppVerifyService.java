package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.AppVerify;
import com.community.app.module.vo.AppVerifyQuery;


public interface AppVerifyService {

	/**
	 * 查询单个AppVerify
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public AppVerify findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有AppVerify
	 * @return
	 * @throws ServiceException
	 */
	public List<AppVerify> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有AppVerify
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppVerify> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有AppVerify-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppVerify> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有AppVerify
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppVerify> findByExample(final AppVerifyQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有AppVerify-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<AppVerify> findByExample(final AppVerifyQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final AppVerifyQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final AppVerifyQuery query) throws ServiceException;
	
	/**
	 * service方法
	 * 保存AppVerify数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final AppVerify entity) throws ServiceException;
	
	/**
	 * 修改AppVerify数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final AppVerify entity) throws ServiceException;

	/**
	 * service方法
	 * 删除AppVerify
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final AppVerifyQuery query ) throws ServiceException;

}
