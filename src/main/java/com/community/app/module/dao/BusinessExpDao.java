package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.BusinessExp;
import com.community.app.module.vo.BusinessExpQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Repository
public interface BusinessExpDao {
		
	/**
	 * 查询单个BusinessExp
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessExp findById(final Integer id) throws DaoException;
	
	/**
	 * 查询单个BusinessExp
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessExp findById_app(final Integer id) throws DaoException;
	
	/**
	 * 无条件查询所有BusinessExp
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExp> findAll() throws DaoException;

	/**
	 * 按Map对象条件查询所有BusinessExp
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExp> findByMap(final Map<String, Object> paramMap) throws DaoException;
	
	/**
	 * 按Map对象条件查询所有BusinessExp-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessExp> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException;
	
	/**
	 * 按VO对象条件查询所有BusinessExp
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExp> findByExample(final BusinessExpQuery query) throws DaoException;	

	/**
	 * 按VO对象条件查询所有BusinessExp-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	//public List<BusinessExp> findByExample(final BusinessExpQuery query, final Integer limit) throws DaoException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExp> findAllPage(final BusinessExpQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索结果导出excel数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExp> findExcelAllExp(final BusinessExpQuery query) throws DaoException;
	
	/**
	 * 查询有快递单的快递公司
	 * 查询条件 和 查询快递单条件一致
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<Map> findHasExpCom(final BusinessExpQuery query) throws DaoException ;

	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessExpQuery query) throws DaoException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExp> findAllPage_app(final BusinessExpQuery query) throws DaoException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessExpQuery query) throws DaoException;

	
	/**
	 * 保存BusinessExp数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessExp entity) throws DaoException;
	
	/**
	 * 修改BusinessExp数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessExp entity) throws DaoException;
	
	/**
	 * 修改BusinessExp数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update_app(final BusinessExp entity) throws DaoException;
	
	/**
	 * 取消预约
	 * @param entity
	 * @throws DaoException
	 */
	public void update_Schedule(final BusinessExp entity) throws DaoException;

	/**
	 * 删除BusinessExp
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
	

	/**
	 * 用户使用发件功能
	 * service
	 * @param entity
	 * @throws ServiceException
	 */
	public void sendExpress(final BusinessExp entity) throws DaoException;
	
	/**
	 * 用户使用语言发件功能
	 * service
	 * @param entity
	 * @throws ServiceException
	 */
	public void sendExpressSound(final BusinessExpQuery query) throws DaoException;


}
