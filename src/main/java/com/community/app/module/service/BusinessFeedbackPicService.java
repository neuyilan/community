package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessFeedbackPic;
import com.community.app.module.vo.BusinessFeedbackPicQuery;


public interface BusinessFeedbackPicService {

	/**
	 * 查询单个BusinessFeedbackPic
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessFeedbackPic findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessFeedbackPic
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessFeedbackPic> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessFeedbackPic
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFeedbackPic> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackPic-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessFeedbackPic> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackPic
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFeedbackPic> findByExample(final BusinessFeedbackPicQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessFeedbackPic-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessFeedbackPic> findByExample(final BusinessFeedbackPicQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessFeedbackPicQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessFeedbackPicQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessFeedbackPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessFeedbackPic entity) throws ServiceException;
	
	/**
	 * 修改BusinessFeedbackPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessFeedbackPic entity) throws ServiceException;

	/**
	 * 删除BusinessFeedbackPic
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
