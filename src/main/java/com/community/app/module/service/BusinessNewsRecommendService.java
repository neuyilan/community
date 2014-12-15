package com.community.app.module.service;

import java.util.List;
import java.util.Map;






import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessNewsRecommend;
import com.community.app.module.vo.BusinessNewsRecommendQuery;


public interface BusinessNewsRecommendService {

	/**
	 * 查询单个BusinessNewsRecommend
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessNewsRecommend findById(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessNewsRecommend
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessNewsRecommend> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessNewsRecommend
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNewsRecommend> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessNewsRecommend-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessNewsRecommend> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessNewsRecommend
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessNewsRecommend> findByExample(final BusinessNewsRecommendQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessNewsRecommend-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessNewsRecommend> findByExample(final BusinessNewsRecommendQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessNewsRecommendQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessNewsRecommendQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessNewsRecommend数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessNewsRecommend entity) throws ServiceException;
	
	/**
	 * 修改BusinessNewsRecommend数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessNewsRecommend entity) throws ServiceException;

	/**
	 * 删除BusinessNewsRecommend
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;

}
