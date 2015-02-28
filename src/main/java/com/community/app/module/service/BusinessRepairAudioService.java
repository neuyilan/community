package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessRepairAudio;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessRepairAudioQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessRepairAudioService {

	/**
	 * 查询单个BusinessRepairAudio
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRepairAudio findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessRepairAudio
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRepairAudio> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessRepairAudio
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRepairAudio> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessRepairAudio-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRepairAudio> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessRepairAudio
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRepairAudio> findByExample(final BusinessRepairAudioQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessRepairAudio-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRepairAudio> findByExample(final BusinessRepairAudioQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessRepairAudioQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessRepairAudioQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessRepairAudio数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessRepairAudio entity) throws ServiceException;
	
	/**
	 * 修改BusinessRepairAudio数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessRepairAudio entity) throws ServiceException;

	/**
	 * 删除BusinessRepairAudio
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
