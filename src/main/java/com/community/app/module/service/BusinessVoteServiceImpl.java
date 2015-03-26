package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessVote;
import com.community.app.module.dao.BusinessVoteDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessVoteQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessVoteService")
@Transactional
public class BusinessVoteServiceImpl implements BusinessVoteService {

	private static Logger logger = LoggerFactory
			.getLogger(BusinessVoteServiceImpl.class);
	@Autowired
	private BusinessVoteDao businessVoteDao;

	/**
	 * 查询单个BusinessVote
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessVote findById(final Integer id) throws ServiceException {
		BusinessVote businessVote = new BusinessVote();
		try {
			businessVote = businessVoteDao.findById(id);
		} catch (DaoException e) {
			logger.debug(
					"BusinessVoteServiceImpl findById()：查询单个BusinessVote发生错误！",
					e);
			e.printStackTrace();
		}
		return businessVote;
	}

	/**
	 * 无条件查询所有BusinessVote
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessVote> findAll() throws ServiceException {
		List<BusinessVote> list = new ArrayList<BusinessVote>();
		try {
			list = businessVoteDao.findAll();
		} catch (DaoException e) {
			logger.debug(
					"BusinessVoteServiceImpl findAll()：无条件查询所有BusinessVote发生错误！",
					e);
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessVote
	 * 
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessVote> findByMap(final Map paramMap)
			throws ServiceException {
		List<BusinessVote> list = new ArrayList<BusinessVote>();
		try {
			list = businessVoteDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug(
					"BusinessVoteServiceImpl findByMap()：按Map对象条件查询所有BusinessVote发生错误！",
					e);
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessVote-限制返回条数
	 * 
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */
	/*
	 * @Transactional(readOnly = true) public List<BusinessVote> findByMap(final
	 * Map paramMap, final Integer limit) throws ServiceException {
	 * List<BusinessVote> list = new ArrayList<BusinessVote>() ; try {
	 * list=businessVoteDao.findByMap(paramMap, limit); } catch (DaoException e)
	 * { logger.debug(
	 * "BusinessVoteServiceImpl findByMap()：按Map对象条件查询所有BusinessVote-限制返回条数发生错误！"
	 * , e); e.printStackTrace(); } return list; }
	 */

	/**
	 * 按VO对象条件查询所有BusinessVote
	 * 
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessVote> findByExample(final BusinessVoteQuery query)
			throws ServiceException {
		List<BusinessVote> list = new ArrayList<BusinessVote>();
		try {
			list = businessVoteDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug(
					"BusinessVoteServiceImpl findByExample()：按VO对象条件查询所有BusinessVote发生错误！",
					e);
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 按VO对象条件查询所有BusinessVote-限制返回条数
	 * 
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	/*
	 * @Transactional(readOnly = true) public List<BusinessVote>
	 * findByExample(final BusinessVoteQuery query, final Integer limit) throws
	 * ServiceException { List<BusinessVote> list = new
	 * ArrayList<BusinessVote>() ; try {
	 * list=businessVoteDao.findByExample(query, limit); } catch (DaoException
	 * e) { logger.debug(
	 * "BusinessVoteServiceImpl findByExample()：按VO对象条件查询所有BusinessVote-限制返回条数发生错误！"
	 * , e); e.printStackTrace(); } return list; }
	 */

	/**
	 * 根据搜索条件，搜索分页数据
	 * 
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage(final BusinessVoteQuery query)
			throws ServiceException {
		List<BusinessVote> list = new ArrayList<BusinessVote>();
		int count = 0;
		BaseBean baseBean = new BaseBean();
		try {
			list = businessVoteDao.findAllPage(query);
			count = businessVoteDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug(
					"BusinessVoteServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！",
					e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * 
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount(final BusinessVoteQuery query)
			throws ServiceException {
		int count = 0;
		try {
			count = businessVoteDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug(
					"BusinessVoteServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！",
					e);
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 保存BusinessVote数据
	 * 
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessVote entity) throws ServiceException {
		try {
			businessVoteDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessVoteServiceImpl save()：保存BusinessVote发生错误！",
					e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessVote数据
	 * 
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessVote entity) throws ServiceException {
		try {
			businessVoteDao.update(entity);
		} catch (DaoException e) {
			logger.debug(
					"BusinessVoteServiceImpl update()：修改BusinessVote发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 删除BusinessVote
	 * 
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessVoteDao.delete(id);
		} catch (DaoException e) {
			logger.debug(
					"BusinessVoteServiceImpl delete()：删除BusinessVote发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}

}
