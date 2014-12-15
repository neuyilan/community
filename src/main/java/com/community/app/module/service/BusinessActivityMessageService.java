package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessActivityMessage;
import com.community.app.module.vo.BusinessActivityMessageQuery;


public interface BusinessActivityMessageService {

	/**
	 * 查询单个BusinessActivityMessage
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessActivityMessage findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessActivityMessage
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessActivityMessage> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessActivityMessage
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityMessage> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessActivityMessage-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityMessage> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessActivityMessage
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessActivityMessage> findByExample(final BusinessActivityMessageQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessActivityMessage-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessActivityMessage> findByExample(final BusinessActivityMessageQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessActivityMessageQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessActivityMessageQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessActivityMessage数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessActivityMessage entity) throws ServiceException;
	
	/**
	 * 修改BusinessActivityMessage数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessActivityMessage entity) throws ServiceException;

	/**
	 * 删除BusinessActivityMessage
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
