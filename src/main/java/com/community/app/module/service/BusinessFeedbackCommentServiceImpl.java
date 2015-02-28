package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessFeedbackComment;
import com.community.app.module.dao.BusinessFeedbackCommentDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFeedbackCommentQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessFeedbackCommentService")
@Transactional
public class BusinessFeedbackCommentServiceImpl implements BusinessFeedbackCommentService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessFeedbackCommentServiceImpl.class);
	@Autowired
	private BusinessFeedbackCommentDao businessFeedbackCommentDao;

	/**
	 * 查询单个BusinessFeedbackComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessFeedbackComment findById(final Integer id) throws ServiceException {
		BusinessFeedbackComment businessFeedbackComment = new BusinessFeedbackComment();
		try {
			businessFeedbackComment = businessFeedbackCommentDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackCommentServiceImpl findById()：查询单个BusinessFeedbackComment发生错误！", e);
			e.printStackTrace();
		}
		return businessFeedbackComment;
	}
	
	/**
	 * 无条件查询所有BusinessFeedbackComment
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessFeedbackComment> findAll() throws ServiceException {
		List<BusinessFeedbackComment> list = new ArrayList<BusinessFeedbackComment>() ;
		try {
			list=businessFeedbackCommentDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackCommentServiceImpl findAll()：无条件查询所有BusinessFeedbackComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackComment
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFeedbackComment> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessFeedbackComment> list = new ArrayList<BusinessFeedbackComment>() ;
		try {
			list=businessFeedbackCommentDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessFeedbackComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackComment-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessFeedbackComment> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessFeedbackComment> list = new ArrayList<BusinessFeedbackComment>() ;
		try {
			list=businessFeedbackCommentDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessFeedbackComment-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackComment
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFeedbackComment> findByExample(final BusinessFeedbackCommentQuery query) throws ServiceException {
		List<BusinessFeedbackComment> list = new ArrayList<BusinessFeedbackComment>() ;
		try {
			list=businessFeedbackCommentDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessFeedbackComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackComment-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessFeedbackComment> findByExample(final BusinessFeedbackCommentQuery query, final Integer limit) throws ServiceException {
		List<BusinessFeedbackComment> list = new ArrayList<BusinessFeedbackComment>() ;
		try {
			list=businessFeedbackCommentDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessFeedbackComment-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessFeedbackCommentQuery query) throws ServiceException {
		List<BusinessFeedbackComment> list = new ArrayList<BusinessFeedbackComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessFeedbackCommentDao.findAllPage(query);
			count=businessFeedbackCommentDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackCommentServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage_app(final BusinessFeedbackCommentQuery query) throws ServiceException {
		List<BusinessFeedbackComment> list = new ArrayList<BusinessFeedbackComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessFeedbackCommentDao.findAllPage_app(query);
			count=businessFeedbackCommentDao.selectCount_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackCommentServiceImpl findAllPage_app()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessFeedbackCommentQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessFeedbackCommentDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackCommentServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessFeedbackComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessFeedbackComment entity) throws ServiceException {
		try {
			businessFeedbackCommentDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackCommentServiceImpl save()：保存BusinessFeedbackComment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存BusinessFeedbackComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save_manage(BusinessFeedbackComment entity) throws ServiceException {
		try {
			businessFeedbackCommentDao.save_manage(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackCommentServiceImpl save()：保存BusinessFeedbackComment发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessFeedbackComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessFeedbackComment entity) throws ServiceException {
		try {
			businessFeedbackCommentDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackCommentServiceImpl update()：修改BusinessFeedbackComment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessFeedbackComment
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessFeedbackCommentDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackCommentServiceImpl delete()：删除BusinessFeedbackComment发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
