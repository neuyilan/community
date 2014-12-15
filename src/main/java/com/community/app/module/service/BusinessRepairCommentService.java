package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessRepairComment;
import com.community.app.module.vo.BusinessRepairCommentQuery;


public interface BusinessRepairCommentService {

	/**
	 * 查询单个BusinessRepairComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRepairComment findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessRepairComment
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRepairComment> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessRepairComment
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRepairComment> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessRepairComment-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRepairComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessRepairComment
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRepairComment> findByExample(final BusinessRepairCommentQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessRepairComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRepairComment> findByExample(final BusinessRepairCommentQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessRepairCommentQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessRepairCommentQuery query) throws ServiceException;

	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessRepairCommentQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessRepairComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessRepairComment entity) throws ServiceException;
	
	/**
	 * 保存BusinessRepairComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save_manage(final BusinessRepairComment entity) throws ServiceException;
	
	
	/**
	 * 修改BusinessRepairComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessRepairComment entity) throws ServiceException;

	/**
	 * 删除BusinessRepairComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
