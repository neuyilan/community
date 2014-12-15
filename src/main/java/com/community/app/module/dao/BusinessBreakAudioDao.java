package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;
import com.community.app.module.bean.BusinessBreakAudio;
import com.community.app.module.vo.BusinessBreakAudioQuery;

@Repository
public interface BusinessBreakAudioDao {
		
	/**
	 * 查询单个BusinessBreakAudio
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessBreakAudio findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessBreakAudio
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakAudio> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessBreakAudio
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreakAudio> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessBreakAudio-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessBreakAudio> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 根据爆料ID查询所有爆料的语音BusinessBreakAudio
	 * @param entity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakAudio> findAudioListByBreakId(final BusinessBreakAudioQuery query) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessBreakAudio
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreakAudio> findByExample(final BusinessBreakAudioQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessBreakAudio-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessBreakAudio> findByExample(final BusinessBreakAudioQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakAudio> findAllPage(final BusinessBreakAudioQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessBreakAudioQuery query) throws DaoException;
	
	/**
	 * 保存BusinessBreakAudio数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessBreakAudio entity) throws DaoException;
	
	/**
	 * 修改BusinessBreakAudio数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessBreakAudio entity) throws DaoException;

	/**
	 * 删除BusinessBreakAudio
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
