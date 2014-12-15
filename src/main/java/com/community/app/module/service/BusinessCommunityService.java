package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessCommunity;
import com.community.app.module.vo.BusinessCommunityQuery;


public interface BusinessCommunityService {

	/**
	 * 查询单个BusinessCommunity
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessCommunity findById(final Integer id) throws ServiceException;
	
	/**
	 * service方法
	 * 查询comId社区下的所有小区
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessCommunity> findByComId(final Integer id) throws ServiceException;
	
	/**
	 * service方法
	 * 无条件查询所有BusinessCommunity
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessCommunity> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessCommunity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessCommunity> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessCommunity-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessCommunity> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessCommunity
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessCommunity> findByExample(final BusinessCommunityQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessCommunity-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessCommunity> findByExample(final BusinessCommunityQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessCommunityQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessCommunityQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessCommunity数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessCommunity entity) throws ServiceException;
	
	/**
	 * 修改BusinessCommunity数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessCommunity entity) throws ServiceException;

	/**
	 * 删除BusinessCommunity
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 获取用户负责的社区
	 * @param userId
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessCommunity> findComsByUser(final Integer userId) throws ServiceException;

}
