package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessHelpAudio;
import com.community.app.module.vo.BusinessHelpAudioQuery;

@Repository
public interface BusinessHelpAudioDao {
		
	/**
	 * 查询单个BusinessHelpAudio
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHelpAudio findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessHelpAudio
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpAudio> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessHelpAudio
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpAudio> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessHelpAudio-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessHelpAudio> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessHelpAudio
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpAudio> findByExample(final BusinessHelpAudioQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessHelpAudio-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessHelpAudio> findByExample(final BusinessHelpAudioQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpAudio> findAllPage(final BusinessHelpAudioQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHelpAudioQuery query) throws DaoException;
	
	/**
	 * 保存BusinessHelpAudio数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHelpAudio entity) throws DaoException;
	
	/**
	 * 修改BusinessHelpAudio数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHelpAudio entity) throws DaoException;

	/**
	 * 删除BusinessHelpAudio
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
