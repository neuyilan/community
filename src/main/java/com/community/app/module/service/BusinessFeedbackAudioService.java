package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessFeedbackAudio;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFeedbackAudioQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessFeedbackAudioService {

	/**
	 * 查询单个BusinessFeedbackAudio
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessFeedbackAudio findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessFeedbackAudio
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessFeedbackAudio> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessFeedbackAudio
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFeedbackAudio> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackAudio-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessFeedbackAudio> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackAudio
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessFeedbackAudio> findByExample(final BusinessFeedbackAudioQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessFeedbackAudio-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessFeedbackAudio> findByExample(final BusinessFeedbackAudioQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessFeedbackAudioQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessFeedbackAudioQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessFeedbackAudio数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessFeedbackAudio entity) throws ServiceException;
	
	/**
	 * 修改BusinessFeedbackAudio数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessFeedbackAudio entity) throws ServiceException;

	/**
	 * 删除BusinessFeedbackAudio
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
