package com.community.app.module.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;


import com.community.app.module.bean.BusinessFeedback;
import com.community.app.module.bean.BusinessFeedbackComment;
import com.community.app.module.bean.MemberVO;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFeedbackQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessRepair;
import com.community.app.module.vo.BusinessRepairQuery;


public interface BusinessRepairService {

	/**
	 * 查询单个BusinessRepair
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRepair findById(final Integer id) throws ServiceException;
	
	/**
	 * 查询单个BusinessRepair
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessRepair findById_app(final Integer id) throws ServiceException;

    /**
     * 获取手机用户信息
     * @param id
     * @return
     * @throws ServiceException
     */
	public MemberVO findAppUserById(final Integer id) throws ServiceException;

	/**
	 * 无条件查询所有BusinessRepair
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessRepair> findAll() throws ServiceException;

	/**
	 * 按Map对象条件查询所有BusinessRepair
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRepair> findByMap(final Map<String, Object> paramMap) throws ServiceException;
	
	/**
	 * 按Map对象条件查询所有BusinessRepair-限制返回条数
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRepair> findByMap(final Map<String, Object> paramMap, final Integer limit) throws ServiceException;
	
	
	/**
	 * 按VO对象条件查询所有BusinessRepair
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessRepair> findByExample(final BusinessRepairQuery query) throws ServiceException;	

	/**
	 * 按VO对象条件查询所有BusinessRepair-限制返回条数
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	//public List<BusinessRepair> findByExample(final BusinessRepairQuery query, final Integer limit) throws ServiceException;	

	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage(final BusinessRepairQuery query) throws ServiceException;
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPage_app(final BusinessRepairQuery query) throws ServiceException;

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	public int selectCount(final BusinessRepairQuery query) throws ServiceException;
	
	/**
	 * 保存BusinessRepair数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final BusinessRepair entity) throws ServiceException;
	
	/**
	 * 修改BusinessRepair数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void update(final BusinessRepair entity) throws ServiceException;

	/**
	 * 删除BusinessRepair
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public boolean delete(final Integer id) throws ServiceException;
	
	/**
	 * 用户发布物业报修
	 * @param entity
	 * @throws ServiceException
	 */
	public void publishPropertyRepair(final BusinessRepairQuery query) throws ServiceException;
	
	/**
	 * service
	 * 评价
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void evaluation(BusinessRepair entity,final BusinessRepairQuery query) throws ServiceException;

}
