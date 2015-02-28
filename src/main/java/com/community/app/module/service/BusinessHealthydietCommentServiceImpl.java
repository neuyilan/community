package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessHealthydietComment;
import com.community.app.module.dao.BusinessHealthydietCommentDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHealthydietCommentQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessHealthydietCommentService")
@Transactional
public class BusinessHealthydietCommentServiceImpl implements BusinessHealthydietCommentService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessHealthydietCommentServiceImpl.class);
	@Autowired
	private BusinessHealthydietCommentDao businessHealthydietCommentDao;

	/**
	 * 查询单个BusinessHealthydietComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessHealthydietComment findById(final Integer id) throws ServiceException {
		BusinessHealthydietComment businessHealthydietComment = new BusinessHealthydietComment();
		try {
			businessHealthydietComment = businessHealthydietCommentDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietCommentServiceImpl findById()：查询单个BusinessHealthydietComment发生错误！", e);
			e.printStackTrace();
		}
		return businessHealthydietComment;
	}
	
	
	/**
	 * 无条件查询所有BusinessHealthydietComment
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessHealthydietComment> findAll() throws ServiceException {
		List<BusinessHealthydietComment> list = new ArrayList<BusinessHealthydietComment>() ;
		try {
			list=businessHealthydietCommentDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietCommentServiceImpl findAll()：无条件查询所有BusinessHealthydietComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHealthydietComment
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHealthydietComment> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessHealthydietComment> list = new ArrayList<BusinessHealthydietComment>() ;
		try {
			list=businessHealthydietCommentDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessHealthydietComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHealthydietComment-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessHealthydietComment> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessHealthydietComment> list = new ArrayList<BusinessHealthydietComment>() ;
		try {
			list=businessHealthydietCommentDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessHealthydietComment-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessHealthydietComment
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHealthydietComment> findByExample(final BusinessHealthydietCommentQuery query) throws ServiceException {
		List<BusinessHealthydietComment> list = new ArrayList<BusinessHealthydietComment>() ;
		try {
			list=businessHealthydietCommentDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessHealthydietComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHealthydietComment-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessHealthydietComment> findByExample(final BusinessHealthydietCommentQuery query, final Integer limit) throws ServiceException {
		List<BusinessHealthydietComment> list = new ArrayList<BusinessHealthydietComment>() ;
		try {
			list=businessHealthydietCommentDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessHealthydietComment-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessHealthydietCommentQuery query) throws ServiceException {
		List<BusinessHealthydietComment> list = new ArrayList<BusinessHealthydietComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessHealthydietCommentDao.selectCount(query);
			query.setCount(count);
			list=businessHealthydietCommentDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietCommentServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public BaseBean findAllPage_app(final BusinessHealthydietCommentQuery query) throws ServiceException {
		List<BusinessHealthydietComment> list = new ArrayList<BusinessHealthydietComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessHealthydietCommentDao.findAllPage_app(query);
			count=businessHealthydietCommentDao.selectCount_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietCommentServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessHealthydietCommentQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessHealthydietCommentDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietCommentServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessHealthydietComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessHealthydietComment entity) throws ServiceException {
		try {
			businessHealthydietCommentDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietCommentServiceImpl save()：保存BusinessHealthydietComment发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 后台评论回复
	 * 保存BusinessHealthydietComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void replySave(BusinessHealthydietComment entity) throws ServiceException {
		try {
			businessHealthydietCommentDao.replySave(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietCommentServiceImpl replySave()：保存BusinessHealthydietComment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改BusinessHealthydietComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessHealthydietComment entity) throws ServiceException {
		try {
			businessHealthydietCommentDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietCommentServiceImpl update()：修改BusinessHealthydietComment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessHealthydietComment
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessHealthydietCommentDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessHealthydietCommentServiceImpl delete()：删除BusinessHealthydietComment发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
