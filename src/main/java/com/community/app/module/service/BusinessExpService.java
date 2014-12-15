package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import com.community.app.module.bean.BusinessExp;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessExpQuery;
import com.community.framework.exception.ServiceException;


public interface BusinessExpService {

	/**
	 * 查询单个BusinessExp
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessExp findById(final Integer id) throws ServiceException;
	
	/**
	 * service
	 * 查询单个BusinessExp
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessExp findById_app(final Integer id) throws ServiceException;
	
	/**
	 * 无条件查询所有BusinessExp
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessExp> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessExp
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessExp> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessExp-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessExp> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessExp
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessExp> findByExample(final BusinessExpQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessExp-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessExp> findByExample(final BusinessExpQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessExpQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，导出excel数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessExp> findExcelAllExp(final BusinessExpQuery query) throws ServiceException;
	
	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessExpQuery query) throws ServiceException;

	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessExpQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessExp数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessExp entity) throws ServiceException;
	
	
	/**
	 * 修改BusinessExp数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessExp entity) throws ServiceException;
	
	/**
	 * service
	 * 修改BusinessExp数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update_app(final BusinessExp entity) throws ServiceException;
	
	/**
	 * service
	 * 取消预定
	 * @param entity
	 * @throws ServiceException
	 */
	public void update_Schedule(final BusinessExp entity) throws ServiceException;
	
	/**
	 * service
	 * 修改提取快件方式
	 * @param entity
	 * @throws ServiceException
	 */
	public void update_state(final BusinessExp entity) throws ServiceException;
	
	/**
	 * service
	 * 修改提取语言快件方式
	 * @param entity
	 * @throws ServiceException
	 */
	public void update_SpeechSound(final BusinessExpQuery query) throws ServiceException;

	/**
	 * 删除BusinessExp
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 用户使用发件功能
	 * service
	 * @param entity
	 * @throws ServiceException
	 */
	public void sendExpress(final BusinessExp entity) throws ServiceException;
	
	/**
	 * 用户使用语言发件功能
	 * service
	 * @param entity
	 * @throws ServiceException
	 */
	public void sendExpressSound(final BusinessExpQuery query) throws ServiceException;
	
	/**
	 * 定时修改状态
	 * @param entity
	 * @throws ServiceException
	 */
	public void taskUpdateState() throws ServiceException;
	
	/**
	 * 定时修改状态
	 * @param entity
	 * @throws ServiceException
	 */
	public void taskUpdateState1() throws ServiceException;
	

	/**
	 * 导出Excel表格
	 * @param query 
	 * @param outputStream
	 */
	public void exportExcel(BusinessExpQuery query, ServletOutputStream outputStream) ;

}
