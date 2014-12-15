package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.ServiceException;
import com.community.framework.exception.DaoException;

import com.community.app.module.vo.BusinessActivityCommentQuery;
import com.community.app.module.bean.BusinessActivityComment;
import com.community.app.module.dao.BusinessActivityCommentDao;

@Service("BusinessActivityCommentService")
@Transactional
public class BusinessActivityCommentServiceImpl implements BusinessActivityCommentService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessActivityCommentServiceImpl.class);
	@Autowired
	private BusinessActivityCommentDao businessActivityCommentDao;

	/**
	 * 查询单个BusinessActivityComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessActivityComment findById(final Integer id) throws ServiceException {
		BusinessActivityComment businessActivityComment = new BusinessActivityComment();
		try {
			businessActivityComment = businessActivityCommentDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCommentServiceImpl findById()：查询单个BusinessActivityComment发生错误！", e);
			e.printStackTrace();
		}
		return businessActivityComment;
	}
	
	/**
	 * 无条件查询所有BusinessActivityComment
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessActivityComment> findAll() throws ServiceException {
		List<BusinessActivityComment> list = new ArrayList<BusinessActivityComment>() ;
		try {
			list=businessActivityCommentDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessActivityCommentServiceImpl findAll()：无条件查询所有BusinessActivityComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityComment
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityComment> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessActivityComment> list = new ArrayList<BusinessActivityComment>() ;
		try {
			list=businessActivityCommentDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityComment-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityComment> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessActivityComment> list = new ArrayList<BusinessActivityComment>() ;
		try {
			list=businessActivityCommentDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityComment-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityComment
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityComment> findByExample(final BusinessActivityCommentQuery query) throws ServiceException {
		List<BusinessActivityComment> list = new ArrayList<BusinessActivityComment>() ;
		try {
			list=businessActivityCommentDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityComment-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityComment> findByExample(final BusinessActivityCommentQuery query, final Integer limit) throws ServiceException {
		List<BusinessActivityComment> list = new ArrayList<BusinessActivityComment>() ;
		try {
			list=businessActivityCommentDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityComment-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessActivityCommentQuery query) throws ServiceException {
		List<BusinessActivityComment> list = new ArrayList<BusinessActivityComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessActivityCommentDao.selectCount(query);
			query.setCount(count);
			list=businessActivityCommentDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCommentServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setRows(query.getRows());
		baseBean.setPage(query.getPage());
		
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
	public BaseBean findAllPage_app(final BusinessActivityCommentQuery query) throws ServiceException {
		List<BusinessActivityComment> list = new ArrayList<BusinessActivityComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessActivityCommentDao.selectCount_app(query);
			query.setCount(count);
			list=businessActivityCommentDao.findAllPage_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCommentServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessActivityCommentQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessActivityCommentDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCommentServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessActivityComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessActivityComment entity) throws ServiceException {
		try {
			businessActivityCommentDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCommentServiceImpl save()：保存BusinessActivityComment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存BusinessActivityComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void replySave(BusinessActivityComment entity) throws ServiceException {
		try {
			businessActivityCommentDao.replySave(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCommentServiceImpl save()：保存BusinessActivityComment发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessActivityComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessActivityComment entity) throws ServiceException {
		try {
			businessActivityCommentDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCommentServiceImpl update()：修改BusinessActivityComment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessActivityComment
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessActivityCommentDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCommentServiceImpl delete()：删除BusinessActivityComment发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
