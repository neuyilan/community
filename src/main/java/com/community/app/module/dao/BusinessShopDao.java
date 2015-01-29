package com.community.app.module.dao;

import java.util.List;
import java.util.Map;






import org.springframework.stereotype.Repository;

import com.community.framework.exception.DaoException;
import com.community.app.module.bean.BusinessShop;
import com.community.app.module.vo.BusinessShopQuery;

@Repository
public interface BusinessShopDao {
		
	/**
	 * 查询单个BusinessShop
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessShop findById(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessShop
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShop> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessShop
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShop> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessShop-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessShop> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessShop
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessShop> findByExample(final BusinessShopQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessShop-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessShop> findByExample(final BusinessShopQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessShop> findAllPage(final BusinessShopQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessShopQuery query) throws DaoException;
	
	/**
	 * 保存BusinessShop数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessShop entity) throws DaoException;
	
	/**
	 * 修改BusinessShop数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessShop entity) throws DaoException;

	/**
	 * 删除BusinessShop
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;

	/**
	 * 根据userid、estateId查询 用户 信息
	 */
	public Map<String, Object> findUserInfo(Map<String, Object> map) throws DaoException;

}
