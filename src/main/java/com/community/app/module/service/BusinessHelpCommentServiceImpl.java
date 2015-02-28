package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessHelpComment;
import com.community.app.module.dao.BusinessHelpCommentDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHelpCommentQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessHelpCommentService")
@Transactional
public class BusinessHelpCommentServiceImpl implements BusinessHelpCommentService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessHelpCommentServiceImpl.class);
	@Autowired
	private BusinessHelpCommentDao businessHelpCommentDao;

	/**
	 * 查询单个BusinessHelpComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessHelpComment findById(final Integer id) throws ServiceException {
		BusinessHelpComment businessHelpComment = new BusinessHelpComment();
		try {
			businessHelpComment = businessHelpCommentDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessHelpCommentServiceImpl findById()：查询单个BusinessHelpComment发生错误！", e);
			e.printStackTrace();
		}
		return businessHelpComment;
	}
	
	/**
	 * 无条件查询所有BusinessHelpComment
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessHelpComment> findAll() throws ServiceException {
		List<BusinessHelpComment> list = new ArrayList<BusinessHelpComment>() ;
		try {
			list=businessHelpCommentDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessHelpCommentServiceImpl findAll()：无条件查询所有BusinessHelpComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpComment
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelpComment> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessHelpComment> list = new ArrayList<BusinessHelpComment>() ;
		try {
			list=businessHelpCommentDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessHelpCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessHelpComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpComment-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelpComment> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessHelpComment> list = new ArrayList<BusinessHelpComment>() ;
		try {
			list=businessHelpCommentDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHelpCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessHelpComment-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelpComment
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelpComment> findByExample(final BusinessHelpCommentQuery query) throws ServiceException {
		List<BusinessHelpComment> list = new ArrayList<BusinessHelpComment>() ;
		try {
			list=businessHelpCommentDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessHelpComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelpComment-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelpComment> findByExample(final BusinessHelpCommentQuery query, final Integer limit) throws ServiceException {
		List<BusinessHelpComment> list = new ArrayList<BusinessHelpComment>() ;
		try {
			list=businessHelpCommentDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHelpCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessHelpComment-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage(final BusinessHelpCommentQuery query) throws ServiceException {
		List<BusinessHelpComment> list = new ArrayList<BusinessHelpComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessHelpCommentDao.findAllPage(query);
			count=businessHelpCommentDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpCommentServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public BaseBean findAllPage_app(final BusinessHelpCommentQuery query) throws ServiceException {
		List<BusinessHelpComment> list = new ArrayList<BusinessHelpComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessHelpCommentDao.findAllPage_app(query);
			count=businessHelpCommentDao.selectCount_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpCommentServiceImpl findAllPage_app()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessHelpCommentQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessHelpCommentDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpCommentServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessHelpComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessHelpComment entity) throws ServiceException {
		try {
			businessHelpCommentDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHelpCommentServiceImpl save()：保存BusinessHelpComment发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 后台评论回复
	 * 保存BusinessHelpComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void replySave(BusinessHelpComment entity) throws ServiceException {
		try {
			businessHelpCommentDao.replySave(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHelpCommentServiceImpl replySave()：保存BusinessHelpComment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改BusinessHelpComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessHelpComment entity) throws ServiceException {
		try {
			businessHelpCommentDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHelpCommentServiceImpl update()：修改BusinessHelpComment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessHelpComment
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessHelpCommentDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessHelpCommentServiceImpl delete()：删除BusinessHelpComment发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
