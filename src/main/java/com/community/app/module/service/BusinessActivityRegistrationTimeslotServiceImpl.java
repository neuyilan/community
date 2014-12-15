package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessActivityRegistrationTimeslot;
import com.community.app.module.dao.BusinessActivityRegistrationTimeslotDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityRegistrationTimeslotQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessActivityRegistrationTimeslotService")
@Transactional
public class BusinessActivityRegistrationTimeslotServiceImpl implements BusinessActivityRegistrationTimeslotService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessActivityRegistrationTimeslotServiceImpl.class);
	@Autowired
	private BusinessActivityRegistrationTimeslotDao businessActivityRegistrationTimeslotDao;

	/**
	 * 查询单个BusinessActivityRegistrationTimeslot
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessActivityRegistrationTimeslot findById(final Integer id) throws ServiceException {
		BusinessActivityRegistrationTimeslot businessActivityRegistrationTimeslot = new BusinessActivityRegistrationTimeslot();
		try {
			businessActivityRegistrationTimeslot = businessActivityRegistrationTimeslotDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationTimeslotServiceImpl findById()：查询单个BusinessActivityRegistrationTimeslot发生错误！", e);
			e.printStackTrace();
		}
		return businessActivityRegistrationTimeslot;
	}
	
	/**
	 * 无条件查询所有BusinessActivityRegistrationTimeslot
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessActivityRegistrationTimeslot> findAll() throws ServiceException {
		List<BusinessActivityRegistrationTimeslot> list = new ArrayList<BusinessActivityRegistrationTimeslot>() ;
		try {
			list=businessActivityRegistrationTimeslotDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationTimeslotServiceImpl findAll()：无条件查询所有BusinessActivityRegistrationTimeslot发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityRegistrationTimeslot
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityRegistrationTimeslot> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessActivityRegistrationTimeslot> list = new ArrayList<BusinessActivityRegistrationTimeslot>() ;
		try {
			list=businessActivityRegistrationTimeslotDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationTimeslotServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityRegistrationTimeslot发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityRegistrationTimeslot-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityRegistrationTimeslot> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessActivityRegistrationTimeslot> list = new ArrayList<BusinessActivityRegistrationTimeslot>() ;
		try {
			list=businessActivityRegistrationTimeslotDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationTimeslotServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityRegistrationTimeslot-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityRegistrationTimeslot
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityRegistrationTimeslot> findByExample(final BusinessActivityRegistrationTimeslotQuery query) throws ServiceException {
		List<BusinessActivityRegistrationTimeslot> list = new ArrayList<BusinessActivityRegistrationTimeslot>() ;
		try {
			list=businessActivityRegistrationTimeslotDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationTimeslotServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityRegistrationTimeslot发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityRegistrationTimeslot-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityRegistrationTimeslot> findByExample(final BusinessActivityRegistrationTimeslotQuery query, final Integer limit) throws ServiceException {
		List<BusinessActivityRegistrationTimeslot> list = new ArrayList<BusinessActivityRegistrationTimeslot>() ;
		try {
			list=businessActivityRegistrationTimeslotDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationTimeslotServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityRegistrationTimeslot-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessActivityRegistrationTimeslotQuery query) throws ServiceException {
		List<BusinessActivityRegistrationTimeslot> list = new ArrayList<BusinessActivityRegistrationTimeslot>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessActivityRegistrationTimeslotDao.selectCount(query);
			query.setCount(count);
			list=businessActivityRegistrationTimeslotDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationTimeslotServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessActivityRegistrationTimeslotQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessActivityRegistrationTimeslotDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationTimeslotServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessActivityRegistrationTimeslot数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessActivityRegistrationTimeslot entity) throws ServiceException {
		try {
			businessActivityRegistrationTimeslotDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationTimeslotServiceImpl save()：保存BusinessActivityRegistrationTimeslot发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessActivityRegistrationTimeslot数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessActivityRegistrationTimeslot entity) throws ServiceException {
		try {
			businessActivityRegistrationTimeslotDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationTimeslotServiceImpl update()：修改BusinessActivityRegistrationTimeslot发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessActivityRegistrationTimeslot
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessActivityRegistrationTimeslotDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityRegistrationTimeslotServiceImpl delete()：删除BusinessActivityRegistrationTimeslot发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
}