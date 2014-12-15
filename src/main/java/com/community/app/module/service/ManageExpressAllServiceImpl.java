package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.ManageExpressAll;
import com.community.app.module.dao.ManageExpressAllDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.ManageExpressAllQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("ManageExpressAllService")
@Transactional
public class ManageExpressAllServiceImpl implements ManageExpressAllService {

	private static Logger logger = LoggerFactory
			.getLogger(ManageExpressAllServiceImpl.class);
	@Autowired
	private ManageExpressAllDao manageExpressAllDao;

	/**
	 * 查询单个ManageExpressAll
	 * 
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public ManageExpressAll findById(final Integer id) throws ServiceException {
		ManageExpressAll manageExpressAll = new ManageExpressAll();
		try {
			manageExpressAll = manageExpressAllDao.findById(id);
		} catch (DaoException e) {
			logger.debug(
					"ManageExpressAllServiceImpl findById()：查询单个ManageExpressAll发生错误！",
					e);
			e.printStackTrace();
		}
		return manageExpressAll;
	}

	/**
	 * 无条件查询所有ManageExpressAll
	 * 
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageExpressAll> findAll() throws ServiceException {
		List<ManageExpressAll> list = new ArrayList<ManageExpressAll>();
		try {
			list = manageExpressAllDao.findAll();
		} catch (DaoException e) {
			logger.debug(
					"ManageExpressAllServiceImpl findAll()：无条件查询所有ManageExpressAll发生错误！",
					e);
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageExpressAll
	 * 
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageExpressAll> findByMap(final Map paramMap)
			throws ServiceException {
		List<ManageExpressAll> list = new ArrayList<ManageExpressAll>();
		try {
			list = manageExpressAllDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug(
					"ManageExpressAllServiceImpl findByMap()：按Map对象条件查询所有ManageExpressAll发生错误！",
					e);
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageExpressAll-限制返回条数
	 * 
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */
	/*
	 * @Transactional(readOnly = true) public List<ManageExpressAll>
	 * findByMap(final Map paramMap, final Integer limit) throws
	 * ServiceException { List<ManageExpressAll> list = new
	 * ArrayList<ManageExpressAll>() ; try {
	 * list=manageExpressAllDao.findByMap(paramMap, limit); } catch
	 * (DaoException e) { logger.debug(
	 * "ManageExpressAllServiceImpl findByMap()：按Map对象条件查询所有ManageExpressAll-限制返回条数发生错误！"
	 * , e); e.printStackTrace(); } return list; }
	 */

	/**
	 * 按VO对象条件查询所有ManageExpressAll
	 * 
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageExpressAll> findByExample(
			final ManageExpressAllQuery query) throws ServiceException {
		List<ManageExpressAll> list = new ArrayList<ManageExpressAll>();
		try {
			list = manageExpressAllDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug(
					"ManageExpressAllServiceImpl findByExample()：按VO对象条件查询所有ManageExpressAll发生错误！",
					e);
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 按VO对象条件查询所有ManageExpressAll-限制返回条数
	 * 
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	/*
	 * @Transactional(readOnly = true) public List<ManageExpressAll>
	 * findByExample(final ManageExpressAllQuery query, final Integer limit)
	 * throws ServiceException { List<ManageExpressAll> list = new
	 * ArrayList<ManageExpressAll>() ; try {
	 * list=manageExpressAllDao.findByExample(query, limit); } catch
	 * (DaoException e) { logger.debug(
	 * "ManageExpressAllServiceImpl findByExample()：按VO对象条件查询所有ManageExpressAll-限制返回条数发生错误！"
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
	public BaseBean findAllPage(final ManageExpressAllQuery query)
			throws ServiceException {
		List<ManageExpressAll> list = new ArrayList<ManageExpressAll>();
		int count = 0;
		BaseBean baseBean = new BaseBean();
		try {
			list = manageExpressAllDao.findAllPage(query);
			count = manageExpressAllDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug(
					"ManageExpressAllServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！",
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
	public int selectCount(final ManageExpressAllQuery query)
			throws ServiceException {
		int count = 0;
		try {
			count = manageExpressAllDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug(
					"ManageExpressAllServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！",
					e);
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 保存ManageExpressAll数据
	 * 
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(ManageExpressAll entity) throws ServiceException {
		try {
			manageExpressAllDao.save(entity);
		} catch (DaoException e) {
			logger.debug(
					"ManageExpressAllServiceImpl save()：保存ManageExpressAll发生错误！",
					e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改ManageExpressAll数据
	 * 
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(ManageExpressAll entity) throws ServiceException {
		try {
			manageExpressAllDao.update(entity);
		} catch (DaoException e) {
			logger.debug(
					"ManageExpressAllServiceImpl update()：修改ManageExpressAll发生错误！",
					e);
			e.printStackTrace();
		}
	}

	/**
	 * 删除ManageExpressAll
	 * 
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return manageExpressAllDao.delete(id);
		} catch (DaoException e) {
			logger.debug(
					"ManageExpressAllServiceImpl delete()：删除ManageExpressAll发生错误！",
					e);
			e.printStackTrace();
		}
		return false;
	}
}