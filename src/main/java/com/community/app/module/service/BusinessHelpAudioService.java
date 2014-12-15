package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessHelpAudio;
import com.community.app.module.vo.BusinessHelpAudioQuery;


public interface BusinessHelpAudioService {

	/**
	 * 查询单个BusinessHelpAudio
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessHelpAudio findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessHelpAudio
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessHelpAudio> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessHelpAudio
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelpAudio> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessHelpAudio-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessHelpAudio> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessHelpAudio
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessHelpAudio> findByExample(final BusinessHelpAudioQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessHelpAudio-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessHelpAudio> findByExample(final BusinessHelpAudioQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessHelpAudioQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessHelpAudioQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessHelpAudio数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessHelpAudio entity) throws ServiceException;
	
	/**
	 * 修改BusinessHelpAudio数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessHelpAudio entity) throws ServiceException;

	/**
	 * 删除BusinessHelpAudio
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
