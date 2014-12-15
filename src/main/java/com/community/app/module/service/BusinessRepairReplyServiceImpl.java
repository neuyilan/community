package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.vo.BusinessRepairReplyQuery;
import com.community.app.module.bean.BusinessRepairReply;
import com.community.app.module.dao.BusinessRepairReplyDao;

@Service("BusinessRepairReplyService")
@Transactional
public class BusinessRepairReplyServiceImpl implements BusinessRepairReplyService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessRepairReplyServiceImpl.class);
	@Autowired
	private BusinessRepairReplyDao businessRepairReplyDao;

	/**
	 * 查询单个BusinessRepairReply
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessRepairReply findById(final Integer id) throws ServiceException {
		BusinessRepairReply businessRepairReply = new BusinessRepairReply();
		try {
			businessRepairReply = businessRepairReplyDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessRepairReplyServiceImpl findById()：查询单个BusinessRepairReply发生错误！", e);
			e.printStackTrace();
		}
		return businessRepairReply;
	}
	
	/**
	 * 无条件查询所有BusinessRepairReply
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessRepairReply> findAll() throws ServiceException {
		List<BusinessRepairReply> list = new ArrayList<BusinessRepairReply>() ;
		try {
			list=businessRepairReplyDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessRepairReplyServiceImpl findAll()：无条件查询所有BusinessRepairReply发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRepairReply
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRepairReply> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessRepairReply> list = new ArrayList<BusinessRepairReply>() ;
		try {
			list=businessRepairReplyDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessRepairReplyServiceImpl findByMap()：按Map对象条件查询所有BusinessRepairReply发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRepairReply-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRepairReply> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessRepairReply> list = new ArrayList<BusinessRepairReply>() ;
		try {
			list=businessRepairReplyDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRepairReplyServiceImpl findByMap()：按Map对象条件查询所有BusinessRepairReply-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRepairReply
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRepairReply> findByExample(final BusinessRepairReplyQuery query) throws ServiceException {
		List<BusinessRepairReply> list = new ArrayList<BusinessRepairReply>() ;
		try {
			list=businessRepairReplyDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairReplyServiceImpl findByExample()：按VO对象条件查询所有BusinessRepairReply发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRepairReply-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRepairReply> findByExample(final BusinessRepairReplyQuery query, final Integer limit) throws ServiceException {
		List<BusinessRepairReply> list = new ArrayList<BusinessRepairReply>() ;
		try {
			list=businessRepairReplyDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRepairReplyServiceImpl findByExample()：按VO对象条件查询所有BusinessRepairReply-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage(final BusinessRepairReplyQuery query) throws ServiceException {
		List<BusinessRepairReply> list = new ArrayList<BusinessRepairReply>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessRepairReplyDao.findAllPage(query);
			count=businessRepairReplyDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairReplyServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount(final BusinessRepairReplyQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessRepairReplyDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairReplyServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessRepairReply数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessRepairReply entity) throws ServiceException {
		try {
			businessRepairReplyDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRepairReplyServiceImpl save()：保存BusinessRepairReply发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessRepairReply数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessRepairReply entity) throws ServiceException {
		try {
			businessRepairReplyDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRepairReplyServiceImpl update()：修改BusinessRepairReply发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessRepairReply
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessRepairReplyDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessRepairReplyServiceImpl delete()：删除BusinessRepairReply发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
