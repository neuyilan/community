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
import com.community.app.module.vo.BusinessProductCommentQuery;
import com.community.app.module.bean.BusinessProductComment;
import com.community.app.module.dao.BusinessProductCommentDao;

@Service("BusinessProductCommentService")
@Transactional
public class BusinessProductCommentServiceImpl implements BusinessProductCommentService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessProductCommentServiceImpl.class);
	@Autowired
	private BusinessProductCommentDao businessProductCommentDao;

	/**
	 * 查询单个BusinessProductComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessProductComment findById(final Integer id) throws ServiceException {
		BusinessProductComment businessProductComment = new BusinessProductComment();
		try {
			businessProductComment = businessProductCommentDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessProductCommentServiceImpl findById()：查询单个BusinessProductComment发生错误！", e);
			e.printStackTrace();
		}
		return businessProductComment;
	}
	
	/**
	 * 无条件查询所有BusinessProductComment
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessProductComment> findAll() throws ServiceException {
		List<BusinessProductComment> list = new ArrayList<BusinessProductComment>() ;
		try {
			list=businessProductCommentDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessProductCommentServiceImpl findAll()：无条件查询所有BusinessProductComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProductComment
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessProductComment> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessProductComment> list = new ArrayList<BusinessProductComment>() ;
		try {
			list=businessProductCommentDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessProductCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessProductComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProductComment-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessProductComment> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessProductComment> list = new ArrayList<BusinessProductComment>() ;
		try {
			list=businessProductCommentDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessProductCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessProductComment-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessProductComment
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessProductComment> findByExample(final BusinessProductCommentQuery query) throws ServiceException {
		List<BusinessProductComment> list = new ArrayList<BusinessProductComment>() ;
		try {
			list=businessProductCommentDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessProductCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessProductComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessProductComment-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessProductComment> findByExample(final BusinessProductCommentQuery query, final Integer limit) throws ServiceException {
		List<BusinessProductComment> list = new ArrayList<BusinessProductComment>() ;
		try {
			list=businessProductCommentDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessProductCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessProductComment-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessProductCommentQuery query) throws ServiceException {
		List<BusinessProductComment> list = new ArrayList<BusinessProductComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessProductCommentDao.findAllPage(query);
			count=businessProductCommentDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessProductCommentServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public BaseBean findAllPage_app(final BusinessProductCommentQuery query) throws ServiceException {
		List<BusinessProductComment> list = new ArrayList<BusinessProductComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessProductCommentDao.findAllPage_app(query);
			count=businessProductCommentDao.selectCount_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessProductCommentServiceImpl findAllPage_app()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessProductCommentQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessProductCommentDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessProductCommentServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessProductComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessProductComment entity) throws ServiceException {
		try {
			businessProductCommentDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessProductCommentServiceImpl save()：保存BusinessProductComment发生错误！", e);
			e.printStackTrace();
		}
	}
	

	/**
	 * 后台评论回复
	 * 保存BusinessProductComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void replySave(BusinessProductComment entity) throws ServiceException {
		try {
			businessProductCommentDao.replySave(entity);
		} catch (DaoException e) {
			logger.debug("BusinessProductCommentServiceImpl replySave()：保存BusinessProductComment发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessProductComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessProductComment entity) throws ServiceException {
		try {
			businessProductCommentDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessProductCommentServiceImpl update()：修改BusinessProductComment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessProductComment
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessProductCommentDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessProductCommentServiceImpl delete()：删除BusinessProductComment发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
}