package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessRepairAudio;
import com.community.app.module.vo.BusinessRepairAudioQuery;

@Repository
public interface BusinessRepairAudioDao {
		
	/**
	 * 查询单个BusinessRepairAudio
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRepairAudio findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessRepairAudio
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairAudio> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessRepairAudio
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairAudio> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessRepairAudio-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRepairAudio> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessRepairAudio
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairAudio> findByExample(final BusinessRepairAudioQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessRepairAudio-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessRepairAudio> findByExample(final BusinessRepairAudioQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairAudio> findAllPage(final BusinessRepairAudioQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRepairAudioQuery query) throws DaoException;
	
	/**
	 * 保存BusinessRepairAudio数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRepairAudio entity) throws DaoException;
	
	/**
	 * 修改BusinessRepairAudio数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRepairAudio entity) throws DaoException;

	/**
	 * 删除BusinessRepairAudio
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
