package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessPosition;
import com.community.app.module.dao.BusinessPositionDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessPositionQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessPositionService")
@Transactional
public class BusinessPositionServiceImpl implements BusinessPositionService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessPositionServiceImpl.class);
	@Autowired
	private BusinessPositionDao businessPositionDao;

	/**
	 * 查询单个BusinessPosition
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessPosition findById(final Integer id) throws ServiceException {
		BusinessPosition businessPosition = new BusinessPosition();
		try {
			businessPosition = businessPositionDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessPositionServiceImpl findById()：查询单个BusinessPosition发生错误！", e);
			e.printStackTrace();
		}
		return businessPosition;
	}
	
	/**
	 * 无条件查询所有BusinessPosition
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessPosition> findAll() throws ServiceException {
		List<BusinessPosition> list = new ArrayList<BusinessPosition>() ;
		try {
			list=businessPositionDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessPositionServiceImpl findAll()：无条件查询所有BusinessPosition发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessPosition
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessPosition> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessPosition> list = new ArrayList<BusinessPosition>() ;
		try {
			list=businessPositionDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessPositionServiceImpl findByMap()：按Map对象条件查询所有BusinessPosition发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessPosition-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessPosition> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessPosition> list = new ArrayList<BusinessPosition>() ;
		try {
			list=businessPositionDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessPositionServiceImpl findByMap()：按Map对象条件查询所有BusinessPosition-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessPosition
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessPosition> findByExample(final BusinessPositionQuery query) throws ServiceException {
		List<BusinessPosition> list = new ArrayList<BusinessPosition>() ;
		try {
			list=businessPositionDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessPositionServiceImpl findByExample()：按VO对象条件查询所有BusinessPosition发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessPosition-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessPosition> findByExample(final BusinessPositionQuery query, final Integer limit) throws ServiceException {
		List<BusinessPosition> list = new ArrayList<BusinessPosition>() ;
		try {
			list=businessPositionDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessPositionServiceImpl findByExample()：按VO对象条件查询所有BusinessPosition-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessPositionQuery query) throws ServiceException {
		List<BusinessPosition> list = new ArrayList<BusinessPosition>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessPositionDao.selectCount(query);
			query.setCount(count);
			list=businessPositionDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessPositionServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessPositionQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessPositionDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessPositionServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessPosition数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessPosition entity) throws ServiceException {
		try {
			businessPositionDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessPositionServiceImpl save()：保存BusinessPosition发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessPosition数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessPosition entity) throws ServiceException {
		try {
			businessPositionDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessPositionServiceImpl update()：修改BusinessPosition发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessPosition
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessPositionDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessPositionServiceImpl delete()：删除BusinessPosition发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
