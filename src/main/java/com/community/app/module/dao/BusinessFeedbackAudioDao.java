package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessFeedbackAudio;
import com.community.app.module.vo.BusinessFeedbackAudioQuery;

@Repository
public interface BusinessFeedbackAudioDao {
		
	/**
	 * 查询单个BusinessFeedbackAudio
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFeedbackAudio findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessFeedbackAudio
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedbackAudio> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessFeedbackAudio
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedbackAudio> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackAudio-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessFeedbackAudio> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackAudio
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedbackAudio> findByExample(final BusinessFeedbackAudioQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessFeedbackAudio-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessFeedbackAudio> findByExample(final BusinessFeedbackAudioQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedbackAudio> findAllPage(final BusinessFeedbackAudioQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFeedbackAudioQuery query) throws DaoException;
	
	/**
	 * 保存BusinessFeedbackAudio数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessFeedbackAudio entity) throws DaoException;
	
	/**
	 * 修改BusinessFeedbackAudio数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFeedbackAudio entity) throws DaoException;

	/**
	 * 删除BusinessFeedbackAudio
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
