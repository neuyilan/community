package com.community.app.module.dao;

import java.util.List;
import java.util.Map;





import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessNewsRecommend;
import com.community.app.module.vo.BusinessNewsRecommendQuery;

@Repository
public interface BusinessNewsRecommendDao {
		
	/**
	 * 查询单个BusinessNewsRecommend
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNewsRecommend findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessNewsRecommend
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsRecommend> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessNewsRecommend
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsRecommend> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessNewsRecommend-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessNewsRecommend> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessNewsRecommend
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsRecommend> findByExample(final BusinessNewsRecommendQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessNewsRecommend-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessNewsRecommend> findByExample(final BusinessNewsRecommendQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsRecommend> findAllPage(final BusinessNewsRecommendQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessNewsRecommendQuery query) throws DaoException;
	
	/**
	 * 保存BusinessNewsRecommend数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessNewsRecommend entity) throws DaoException;
	
	/**
	 * 修改BusinessNewsRecommend数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessNewsRecommend entity) throws DaoException;

	/**
	 * 删除BusinessNewsRecommend
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

}
