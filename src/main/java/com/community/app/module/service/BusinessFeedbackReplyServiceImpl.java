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

import com.community.app.module.vo.BusinessFeedbackReplyQuery;
import com.community.app.module.bean.BusinessFeedbackReply;
import com.community.app.module.dao.BusinessFeedbackReplyDao;

@Service("BusinessFeedbackReplyService")
@Transactional
public class BusinessFeedbackReplyServiceImpl implements BusinessFeedbackReplyService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessFeedbackReplyServiceImpl.class);
	@Autowired
	private BusinessFeedbackReplyDao businessFeedbackReplyDao;

	/**
	 * 查询单个BusinessFeedbackReply
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessFeedbackReply findById(final Integer id) throws ServiceException {
		BusinessFeedbackReply businessFeedbackReply = new BusinessFeedbackReply();
		try {
			businessFeedbackReply = businessFeedbackReplyDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackReplyServiceImpl findById()：查询单个BusinessFeedbackReply发生错误！", e);
			e.printStackTrace();
		}
		return businessFeedbackReply;
	}
	
	/**
	 * 无条件查询所有BusinessFeedbackReply
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessFeedbackReply> findAll() throws ServiceException {
		List<BusinessFeedbackReply> list = new ArrayList<BusinessFeedbackReply>() ;
		try {
			list=businessFeedbackReplyDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackReplyServiceImpl findAll()：无条件查询所有BusinessFeedbackReply发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackReply
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFeedbackReply> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessFeedbackReply> list = new ArrayList<BusinessFeedbackReply>() ;
		try {
			list=businessFeedbackReplyDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackReplyServiceImpl findByMap()：按Map对象条件查询所有BusinessFeedbackReply发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackReply-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessFeedbackReply> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessFeedbackReply> list = new ArrayList<BusinessFeedbackReply>() ;
		try {
			list=businessFeedbackReplyDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackReplyServiceImpl findByMap()：按Map对象条件查询所有BusinessFeedbackReply-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackReply
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFeedbackReply> findByExample(final BusinessFeedbackReplyQuery query) throws ServiceException {
		List<BusinessFeedbackReply> list = new ArrayList<BusinessFeedbackReply>() ;
		try {
			list=businessFeedbackReplyDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackReplyServiceImpl findByExample()：按VO对象条件查询所有BusinessFeedbackReply发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackReply-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessFeedbackReply> findByExample(final BusinessFeedbackReplyQuery query, final Integer limit) throws ServiceException {
		List<BusinessFeedbackReply> list = new ArrayList<BusinessFeedbackReply>() ;
		try {
			list=businessFeedbackReplyDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackReplyServiceImpl findByExample()：按VO对象条件查询所有BusinessFeedbackReply-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessFeedbackReplyQuery query) throws ServiceException {
		List<BusinessFeedbackReply> list = new ArrayList<BusinessFeedbackReply>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessFeedbackReplyDao.findAllPage(query);
			count=businessFeedbackReplyDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackReplyServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessFeedbackReplyQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessFeedbackReplyDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackReplyServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessFeedbackReply数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessFeedbackReply entity) throws ServiceException {
		try {
			businessFeedbackReplyDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackReplyServiceImpl save()：保存BusinessFeedbackReply发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessFeedbackReply数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessFeedbackReply entity) throws ServiceException {
		try {
			businessFeedbackReplyDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackReplyServiceImpl update()：修改BusinessFeedbackReply发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessFeedbackReply
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessFeedbackReplyDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackReplyServiceImpl delete()：删除BusinessFeedbackReply发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
