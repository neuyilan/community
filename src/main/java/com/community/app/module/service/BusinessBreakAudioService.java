package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessBreakAudio;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessBreakAudioQuery;
import com.community.framework.exception.ServiceException;

public interface BusinessBreakAudioService {

	/**
	 * 查询单个BusinessBreakAudio
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessBreakAudio findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessBreakAudio
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBreakAudio> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessBreakAudio
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBreakAudio> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessBreakAudio-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessBreakAudio> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	/**
	 * 根据爆料ID查询所有语音的爆料BusinessBreakAudio
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBreakAudio> findAudioListByBreakId(final Integer id) throws ServiceException;
	
	/**
	 * 按VO对象条件查询所有BusinessBreakAudio
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessBreakAudio> findByExample(final BusinessBreakAudioQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessBreakAudio-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessBreakAudio> findByExample(final BusinessBreakAudioQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessBreakAudioQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessBreakAudioQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessBreakAudio数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessBreakAudio entity) throws ServiceException;
	
	/**
	 * 修改BusinessBreakAudio数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessBreakAudio entity) throws ServiceException;

	/**
	 * 删除BusinessBreakAudio
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
