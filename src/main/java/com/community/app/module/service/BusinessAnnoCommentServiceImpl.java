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



import com.community.app.module.vo.BusinessAnnoCommentQuery;
import com.community.app.module.bean.BusinessAnnoComment;
import com.community.app.module.dao.BusinessAnnoCommentDao;

@Service("BusinessAnnoCommentService")
@Transactional
public class BusinessAnnoCommentServiceImpl implements BusinessAnnoCommentService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessAnnoCommentServiceImpl.class);
	@Autowired
	private BusinessAnnoCommentDao businessAnnoCommentDao;

	/**
	 * 查询单个BusinessAnnoComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessAnnoComment findById(final Integer id) throws ServiceException {
		BusinessAnnoComment businessAnnoComment = new BusinessAnnoComment();
		try {
			businessAnnoComment = businessAnnoCommentDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoCommentServiceImpl findById()：查询单个BusinessAnnoComment发生错误！", e);
			e.printStackTrace();
		}
		return businessAnnoComment;
	}
	
	/**
	 * 无条件查询所有BusinessAnnoComment
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessAnnoComment> findAll() throws ServiceException {
		List<BusinessAnnoComment> list = new ArrayList<BusinessAnnoComment>() ;
		try {
			list=businessAnnoCommentDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessAnnoCommentServiceImpl findAll()：无条件查询所有BusinessAnnoComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoComment
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessAnnoComment> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessAnnoComment> list = new ArrayList<BusinessAnnoComment>() ;
		try {
			list=businessAnnoCommentDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessAnnoComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoComment-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessAnnoComment> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessAnnoComment> list = new ArrayList<BusinessAnnoComment>() ;
		try {
			list=businessAnnoCommentDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessAnnoComment-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoComment
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessAnnoComment> findByExample(final BusinessAnnoCommentQuery query) throws ServiceException {
		List<BusinessAnnoComment> list = new ArrayList<BusinessAnnoComment>() ;
		try {
			list=businessAnnoCommentDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessAnnoComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoComment-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessAnnoComment> findByExample(final BusinessAnnoCommentQuery query, final Integer limit) throws ServiceException {
		List<BusinessAnnoComment> list = new ArrayList<BusinessAnnoComment>() ;
		try {
			list=businessAnnoCommentDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessAnnoComment-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessAnnoCommentQuery query) throws ServiceException {
		List<BusinessAnnoComment> list = new ArrayList<BusinessAnnoComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessAnnoCommentDao.selectCount(query);
			query.setCount(count);
			list=businessAnnoCommentDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoCommentServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public BaseBean findAllPage_app(final BusinessAnnoCommentQuery query) throws ServiceException {
		List<BusinessAnnoComment> list = new ArrayList<BusinessAnnoComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessAnnoCommentDao.findAllPage_app(query);
			count=businessAnnoCommentDao.selectCount_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoCommentServiceImpl findAllPage_app()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessAnnoCommentQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessAnnoCommentDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoCommentServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessAnnoComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessAnnoComment entity) throws ServiceException {
		try {
			businessAnnoCommentDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoCommentServiceImpl save()：保存BusinessAnnoComment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 后台回复保存BusinessAnnoComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void replySave(BusinessAnnoComment entity) throws ServiceException {
		try {
			businessAnnoCommentDao.replySave(entity);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoCommentServiceImpl replySave()：保存BusinessAnnoComment发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessAnnoComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessAnnoComment entity) throws ServiceException {
		try {
			businessAnnoCommentDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoCommentServiceImpl update()：修改BusinessAnnoComment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessAnnoComment
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessAnnoCommentDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoCommentServiceImpl delete()：删除BusinessAnnoComment发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
