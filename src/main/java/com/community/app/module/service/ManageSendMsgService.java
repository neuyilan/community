package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.ManageSendMsg;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.ManageSendMsgQuery;
import com.community.framework.exception.ServiceException;


public interface ManageSendMsgService {

	/**
	 * 查询单个ManageSendMsg
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public ManageSendMsg findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有ManageSendMsg
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageSendMsg> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有ManageSendMsg
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageSendMsg> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有ManageSendMsg-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageSendMsg> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有ManageSendMsg
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageSendMsg> findByExample(final ManageSendMsgQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有ManageSendMsg-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<ManageSendMsg> findByExample(final ManageSendMsgQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final ManageSendMsgQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final ManageSendMsgQuery query) throws ServiceException;
	
	/**
	 * 保存ManageSendMsg数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final ManageSendMsg entity) throws ServiceException;
	
	/**
	 * 修改ManageSendMsg数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final ManageSendMsg entity) throws ServiceException;

	/**
	 * 删除ManageSendMsg
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

	public void save(String cellphone, String result_mt, String content, int flag);

}
