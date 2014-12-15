package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessNewspaper;
import com.community.app.module.vo.BusinessNewspaperQuery;


public interface BusinessNewspaperService {

	/**
	 * 查询单个BusinessNewspaper
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessNewspaper findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessNewspaper
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessNewspaper> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessNewspaper
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNewspaper> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessNewspaper-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNewspaper> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessNewspaper
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNewspaper> findByExample(final BusinessNewspaperQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessNewspaper-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNewspaper> findByExample(final BusinessNewspaperQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessNewspaperQuery query) throws ServiceException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessNewspaperQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessNewspaperQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessNewspaper数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessNewspaper entity) throws ServiceException;
	
	/**
	 * 修改BusinessNewspaper数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessNewspaper entity) throws ServiceException;

	/**
	 * 删除BusinessNewspaper
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
