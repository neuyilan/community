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

import com.community.app.module.vo.BusinessRepairCommentQuery;
import com.community.app.module.bean.BusinessRepairComment;
import com.community.app.module.dao.BusinessRepairCommentDao;

@Service("BusinessRepairCommentService")
@Transactional
public class BusinessRepairCommentServiceImpl implements BusinessRepairCommentService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessRepairCommentServiceImpl.class);
	@Autowired
	private BusinessRepairCommentDao businessRepairCommentDao;

	/**
	 * 查询单个BusinessRepairComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessRepairComment findById(final Integer id) throws ServiceException {
		BusinessRepairComment businessRepairComment = new BusinessRepairComment();
		try {
			businessRepairComment = businessRepairCommentDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessRepairCommentServiceImpl findById()：查询单个BusinessRepairComment发生错误！", e);
			e.printStackTrace();
		}
		return businessRepairComment;
	}
	
	/**
	 * 无条件查询所有BusinessRepairComment
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessRepairComment> findAll() throws ServiceException {
		List<BusinessRepairComment> list = new ArrayList<BusinessRepairComment>() ;
		try {
			list=businessRepairCommentDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessRepairCommentServiceImpl findAll()：无条件查询所有BusinessRepairComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRepairComment
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRepairComment> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessRepairComment> list = new ArrayList<BusinessRepairComment>() ;
		try {
			list=businessRepairCommentDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessRepairCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessRepairComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRepairComment-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRepairComment> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessRepairComment> list = new ArrayList<BusinessRepairComment>() ;
		try {
			list=businessRepairCommentDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRepairCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessRepairComment-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRepairComment
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRepairComment> findByExample(final BusinessRepairCommentQuery query) throws ServiceException {
		List<BusinessRepairComment> list = new ArrayList<BusinessRepairComment>() ;
		try {
			list=businessRepairCommentDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessRepairComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRepairComment-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRepairComment> findByExample(final BusinessRepairCommentQuery query, final Integer limit) throws ServiceException {
		List<BusinessRepairComment> list = new ArrayList<BusinessRepairComment>() ;
		try {
			list=businessRepairCommentDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRepairCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessRepairComment-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessRepairCommentQuery query) throws ServiceException {
		List<BusinessRepairComment> list = new ArrayList<BusinessRepairComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessRepairCommentDao.findAllPage(query);
			count=businessRepairCommentDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairCommentServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public BaseBean findAllPage_app(final BusinessRepairCommentQuery query) throws ServiceException {
		List<BusinessRepairComment> list = new ArrayList<BusinessRepairComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessRepairCommentDao.findAllPage_app(query);
			count=businessRepairCommentDao.selectCount_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairCommentServiceImpl findAllPage_app()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessRepairCommentQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessRepairCommentDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairCommentServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessRepairComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessRepairComment entity) throws ServiceException {
		try {
			businessRepairCommentDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRepairCommentServiceImpl save()：保存BusinessRepairComment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 保存BusinessRepairComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save_manage(BusinessRepairComment entity) throws ServiceException {
		try {
			businessRepairCommentDao.save_manage(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRepairCommentServiceImpl save()：保存BusinessRepairComment发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessRepairComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessRepairComment entity) throws ServiceException {
		try {
			businessRepairCommentDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRepairCommentServiceImpl update()：修改BusinessRepairComment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessRepairComment
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessRepairCommentDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessRepairCommentServiceImpl delete()：删除BusinessRepairComment发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
