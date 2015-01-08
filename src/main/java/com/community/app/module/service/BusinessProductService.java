package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import com.community.app.module.bean.BusinessProduct;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessProductQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessProductService {

	/**
	 * 查询单个BusinessProduct
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessProduct findById(final Integer id) throws ServiceException;
	
	/**
	 * 查询单个BusinessProduct
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessProduct findProductById(final Integer id) throws ServiceException;
	
	/**
	 * service
	 * 查询单个BusinessProduct
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessProduct findById_app(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessProduct
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessProduct> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessProduct
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessProduct> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessProduct-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessProduct> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessProduct
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessProduct> findByExample(final BusinessProductQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessProduct-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessProduct> findByExample(final BusinessProductQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessProductQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_manage(final BusinessProductQuery query) throws ServiceException;

	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessProductQuery query) throws ServiceException;

	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessProductQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessProduct数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessProduct entity) throws ServiceException;
	
	/**
	 * 修改BusinessProduct数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessProduct entity) throws ServiceException;
	
	/**
	 * service
	 * 保存BusinessProduct数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save_app(final BusinessProduct entity) throws ServiceException;
	
	/**
	 * service
	 * 修改BusinessProduct数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update_app(final BusinessProduct entity) throws ServiceException;

	/**
	 * 删除BusinessProduct
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 新增商品
	 * 保存BusinessProduct数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void addProduct(final BusinessProductQuery query) throws ServiceException;
	

	/**
	 * 新增商品 for PHP
	 * 保存BusinessProduct数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void addProductPHP(final BusinessProductQuery query) throws ServiceException;
	
	/**
	 * 修改商品
	 * 保存BusinessProduct数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void editProduct(final BusinessProductQuery query) throws ServiceException;

	/**
	 * 修改商品 for PHP
	 * 保存BusinessProduct数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void editProductPHP(BusinessProductQuery query);
	
	

}
