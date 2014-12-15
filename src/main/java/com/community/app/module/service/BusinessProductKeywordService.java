package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessProductKeyword;
import com.community.app.module.vo.BusinessProductKeywordQuery;


public interface BusinessProductKeywordService {

	/**
	 * 查询单个BusinessProductKeyword
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessProductKeyword findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessProductKeyword
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessProductKeyword> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessProductKeyword
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessProductKeyword> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessProductKeyword-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessProductKeyword> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessProductKeyword
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessProductKeyword> findByExample(final BusinessProductKeywordQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessProductKeyword-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessProductKeyword> findByExample(final BusinessProductKeywordQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessProductKeywordQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessProductKeywordQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessProductKeyword数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessProductKeyword entity) throws ServiceException;
	
	/**
	 * 修改BusinessProductKeyword数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessProductKeyword entity) throws ServiceException;

	/**
	 * 删除BusinessProductKeyword
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
