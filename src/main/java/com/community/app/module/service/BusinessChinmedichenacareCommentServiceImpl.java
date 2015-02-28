package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessChinmedichenacareComment;
import com.community.app.module.dao.BusinessChinmedichenacareCommentDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessChinmedichenacareCommentQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessChinmedichenacareCommentService")
@Transactional
public class BusinessChinmedichenacareCommentServiceImpl implements BusinessChinmedichenacareCommentService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessChinmedichenacareCommentServiceImpl.class);
	@Autowired
	private BusinessChinmedichenacareCommentDao businessChinmedichenacareCommentDao;

	/**
	 * 查询单个BusinessChinmedichenacareComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessChinmedichenacareComment findById(final Integer id) throws ServiceException {
		BusinessChinmedichenacareComment businessChinmedichenacareComment = new BusinessChinmedichenacareComment();
		try {
			businessChinmedichenacareComment = businessChinmedichenacareCommentDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareCommentServiceImpl findById()：查询单个BusinessChinmedichenacareComment发生错误！", e);
			e.printStackTrace();
		}
		return businessChinmedichenacareComment;
	}
	
	/**
	 * 无条件查询所有BusinessChinmedichenacareComment
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessChinmedichenacareComment> findAll() throws ServiceException {
		List<BusinessChinmedichenacareComment> list = new ArrayList<BusinessChinmedichenacareComment>() ;
		try {
			list=businessChinmedichenacareCommentDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareCommentServiceImpl findAll()：无条件查询所有BusinessChinmedichenacareComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacareComment
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessChinmedichenacareComment> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessChinmedichenacareComment> list = new ArrayList<BusinessChinmedichenacareComment>() ;
		try {
			list=businessChinmedichenacareCommentDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessChinmedichenacareComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacareComment-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessChinmedichenacareComment> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessChinmedichenacareComment> list = new ArrayList<BusinessChinmedichenacareComment>() ;
		try {
			list=businessChinmedichenacareCommentDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessChinmedichenacareComment-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacareComment
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessChinmedichenacareComment> findByExample(final BusinessChinmedichenacareCommentQuery query) throws ServiceException {
		List<BusinessChinmedichenacareComment> list = new ArrayList<BusinessChinmedichenacareComment>() ;
		try {
			list=businessChinmedichenacareCommentDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessChinmedichenacareComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacareComment-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessChinmedichenacareComment> findByExample(final BusinessChinmedichenacareCommentQuery query, final Integer limit) throws ServiceException {
		List<BusinessChinmedichenacareComment> list = new ArrayList<BusinessChinmedichenacareComment>() ;
		try {
			list=businessChinmedichenacareCommentDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessChinmedichenacareComment-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessChinmedichenacareCommentQuery query) throws ServiceException {
		List<BusinessChinmedichenacareComment> list = new ArrayList<BusinessChinmedichenacareComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessChinmedichenacareCommentDao.selectCount(query);
			query.setCount(count);
			list=businessChinmedichenacareCommentDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareCommentServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public BaseBean findAllPage_app(final BusinessChinmedichenacareCommentQuery query) throws ServiceException {
		List<BusinessChinmedichenacareComment> list = new ArrayList<BusinessChinmedichenacareComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessChinmedichenacareCommentDao.findAllPage_app(query);
			count=businessChinmedichenacareCommentDao.selectCount_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareCommentServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessChinmedichenacareCommentQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessChinmedichenacareCommentDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareCommentServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessChinmedichenacareComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessChinmedichenacareComment entity) throws ServiceException {
		try {
			businessChinmedichenacareCommentDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareCommentServiceImpl save()：保存BusinessChinmedichenacareComment发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 后台评论回复
	 * 保存BusinessChinmedichenacareComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void replySave(BusinessChinmedichenacareComment entity) throws ServiceException {
		try {
			businessChinmedichenacareCommentDao.replySave(entity);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareCommentServiceImpl replySave()：保存BusinessChinmedichenacareComment发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessChinmedichenacareComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessChinmedichenacareComment entity) throws ServiceException {
		try {
			businessChinmedichenacareCommentDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareCommentServiceImpl update()：修改BusinessChinmedichenacareComment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessChinmedichenacareComment
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessChinmedichenacareCommentDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareCommentServiceImpl delete()：删除BusinessChinmedichenacareComment发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
}