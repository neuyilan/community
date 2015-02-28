package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessBreakComment;
import com.community.app.module.dao.BusinessBreakCommentDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessBreakCommentQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessBreakCommentService")
@Transactional
public class BusinessBreakCommentServiceImpl implements BusinessBreakCommentService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessBreakCommentServiceImpl.class);
	@Autowired
	private BusinessBreakCommentDao businessBreakCommentDao;

	/**
	 * 根据爆料ID查询所有回复的爆料BusinessBreakComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessBreakComment> findCommentListByBreakId(final Integer id) throws ServiceException {
		BusinessBreakCommentQuery query = new BusinessBreakCommentQuery();
		List<BusinessBreakComment> list = new ArrayList<BusinessBreakComment>() ;
		query.setBreakId(id);
		query.setOrder("desc");
		query.setSort("commentId");
		try {
			list = businessBreakCommentDao.findCommentListByBreakId(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakCommentServiceImpl findCommentListByBreakId()：根据爆料ID查询所有回复的爆料BusinessBreakComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 查询单个BusinessBreakComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessBreakComment findById(final Integer id) throws ServiceException {
		BusinessBreakComment businessBreakComment = new BusinessBreakComment();
		try {
			businessBreakComment = businessBreakCommentDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessBreakCommentServiceImpl findById()：查询单个BusinessBreakComment发生错误！", e);
			e.printStackTrace();
		}
		return businessBreakComment;
	}
	
	/**
	 * 无条件查询所有BusinessBreakComment
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessBreakComment> findAll() throws ServiceException {
		List<BusinessBreakComment> list = new ArrayList<BusinessBreakComment>() ;
		try {
			list=businessBreakCommentDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessBreakCommentServiceImpl findAll()：无条件查询所有BusinessBreakComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBreakComment
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessBreakComment> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessBreakComment> list = new ArrayList<BusinessBreakComment>() ;
		try {
			list=businessBreakCommentDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessBreakCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessBreakComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBreakComment-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessBreakComment> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessBreakComment> list = new ArrayList<BusinessBreakComment>() ;
		try {
			list=businessBreakCommentDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessBreakCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessBreakComment-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessBreakComment
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessBreakComment> findByExample(final BusinessBreakCommentQuery query) throws ServiceException {
		List<BusinessBreakComment> list = new ArrayList<BusinessBreakComment>() ;
		try {
			list=businessBreakCommentDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessBreakComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBreakComment-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessBreakComment> findByExample(final BusinessBreakCommentQuery query, final Integer limit) throws ServiceException {
		List<BusinessBreakComment> list = new ArrayList<BusinessBreakComment>() ;
		try {
			list=businessBreakCommentDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessBreakCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessBreakComment-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessBreakCommentQuery query) throws ServiceException {
		List<BusinessBreakComment> list = new ArrayList<BusinessBreakComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessBreakCommentDao.findAllPage(query);
			count=businessBreakCommentDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakCommentServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}
	
	/**
	 * service
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage_app(final BusinessBreakCommentQuery query) throws ServiceException {
		List<BusinessBreakComment> list = new ArrayList<BusinessBreakComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessBreakCommentDao.findAllPage_app(query);
			count=businessBreakCommentDao.selectCount_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakCommentServiceImpl findAllPage_app()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessBreakCommentQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessBreakCommentDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakCommentServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessBreakComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessBreakComment entity) throws ServiceException {
		try {
			businessBreakCommentDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessBreakCommentServiceImpl save()：保存BusinessBreakComment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 回复保存BusinessBreakComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public int replySave(BusinessBreakComment entity) throws ServiceException {
		try {
			return businessBreakCommentDao.replySave(entity);
		} catch (DaoException e) {
			logger.debug("BusinessBreakCommentServiceImpl save()：保存BusinessBreakComment发生错误！", e);
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 修改BusinessBreakComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessBreakComment entity) throws ServiceException {
		try {
			businessBreakCommentDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessBreakCommentServiceImpl update()：修改BusinessBreakComment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessBreakComment
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessBreakCommentDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessBreakCommentServiceImpl delete()：删除BusinessBreakComment发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
