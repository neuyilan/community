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
import com.community.app.module.vo.BusinessNewsCommentQuery;
import com.community.app.module.bean.BusinessNewsComment;
import com.community.app.module.dao.BusinessNewsCommentDao;

@Service("BusinessNewsCommentService")
@Transactional
public class BusinessNewsCommentServiceImpl implements BusinessNewsCommentService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessNewsCommentServiceImpl.class);
	@Autowired
	private BusinessNewsCommentDao businessNewsCommentDao;

	/**
	 * 查询单个BusinessNewsComment
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessNewsComment findById(final Integer id) throws ServiceException {
		BusinessNewsComment businessNewsComment = new BusinessNewsComment();
		try {
			businessNewsComment = businessNewsCommentDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessNewsCommentServiceImpl findById()：查询单个BusinessNewsComment发生错误！", e);
			e.printStackTrace();
		}
		return businessNewsComment;
	}
	
	/**
	 * 无条件查询所有BusinessNewsComment
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessNewsComment> findAll() throws ServiceException {
		List<BusinessNewsComment> list = new ArrayList<BusinessNewsComment>() ;
		try {
			list=businessNewsCommentDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessNewsCommentServiceImpl findAll()：无条件查询所有BusinessNewsComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewsComment
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNewsComment> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessNewsComment> list = new ArrayList<BusinessNewsComment>() ;
		try {
			list=businessNewsCommentDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessNewsCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessNewsComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewsComment-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessNewsComment> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessNewsComment> list = new ArrayList<BusinessNewsComment>() ;
		try {
			list=businessNewsCommentDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessNewsCommentServiceImpl findByMap()：按Map对象条件查询所有BusinessNewsComment-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessNewsComment
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNewsComment> findByExample(final BusinessNewsCommentQuery query) throws ServiceException {
		List<BusinessNewsComment> list = new ArrayList<BusinessNewsComment>() ;
		try {
			list=businessNewsCommentDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessNewsComment发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNewsComment-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessNewsComment> findByExample(final BusinessNewsCommentQuery query, final Integer limit) throws ServiceException {
		List<BusinessNewsComment> list = new ArrayList<BusinessNewsComment>() ;
		try {
			list=businessNewsCommentDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessNewsCommentServiceImpl findByExample()：按VO对象条件查询所有BusinessNewsComment-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessNewsCommentQuery query) throws ServiceException {
		List<BusinessNewsComment> list = new ArrayList<BusinessNewsComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessNewsCommentDao.selectCount(query);
			query.setCount(count);
			list=businessNewsCommentDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsCommentServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessNewsCommentQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessNewsCommentDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsCommentServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage_manage(final BusinessNewsCommentQuery query) throws ServiceException {
		List<BusinessNewsComment> list = new ArrayList<BusinessNewsComment>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessNewsCommentDao.selectCount_manage(query);
			query.setCount(count);
			list=businessNewsCommentDao.findAllPage_manage(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsCommentServiceImpl findAllPage_manage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setRows(query.getRows());
		baseBean.setPage(query.getPage());
		
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount_manage(final BusinessNewsCommentQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessNewsCommentDao.selectCount_manage(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsCommentServiceImpl selectCount_manage()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessNewsComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessNewsComment entity) throws ServiceException {
		try {
			businessNewsCommentDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessNewsCommentServiceImpl save()：保存BusinessNewsComment发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 后台评论回复
	 * 保存BusinessNewsComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void replySave(BusinessNewsComment entity) throws ServiceException {
		try {
			businessNewsCommentDao.replySave(entity);
		} catch (DaoException e) {
			logger.debug("BusinessNewsCommentServiceImpl replySave()：保存BusinessNewsComment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改BusinessNewsComment数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessNewsComment entity) throws ServiceException {
		try {
			businessNewsCommentDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessNewsCommentServiceImpl update()：修改BusinessNewsComment发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessNewsComment
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessNewsCommentDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessNewsCommentServiceImpl delete()：删除BusinessNewsComment发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
