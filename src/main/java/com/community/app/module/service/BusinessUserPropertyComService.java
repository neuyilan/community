package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessUserPropertyCom;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessUserPropertyComQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessUserPropertyComService {

	/**
	 * 查询单个BusinessUserPropertyCom
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessUserPropertyCom findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessUserPropertyCom
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessUserPropertyCom> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessUserPropertyCom
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessUserPropertyCom> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessUserPropertyCom-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessUserPropertyCom> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessUserPropertyCom
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessUserPropertyCom> findByExample(final BusinessUserPropertyComQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessUserPropertyCom-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessUserPropertyCom> findByExample(final BusinessUserPropertyComQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessUserPropertyComQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessUserPropertyComQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessUserPropertyCom数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessUserPropertyCom entity) throws ServiceException;
	
	/**
	 * 修改BusinessUserPropertyCom数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessUserPropertyCom entity) throws ServiceException;

	/**
	 * 删除BusinessUserPropertyCom
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

    /**
     * 查询互动记录
     * @param query
     * @return
     * @throws ServiceException
     */
	public List<BusinessUserPropertyCom> getChatInfo(final BusinessUserPropertyComQuery query) throws ServiceException;

}
