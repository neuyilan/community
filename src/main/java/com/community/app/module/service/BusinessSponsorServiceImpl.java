package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessSponsor;
import com.community.app.module.dao.BusinessSponsorDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessSponsorQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessSponsorService")
@Transactional
public class BusinessSponsorServiceImpl implements BusinessSponsorService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessSponsorServiceImpl.class);
	@Autowired
	private BusinessSponsorDao businessSponsorDao;

	/**
	 * 查询单个BusinessSponsor
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessSponsor findById(final Integer id) throws ServiceException {
		BusinessSponsor businessSponsor = new BusinessSponsor();
		try {
			businessSponsor = businessSponsorDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessSponsorServiceImpl findById()：查询单个BusinessSponsor发生错误！", e);
			e.printStackTrace();
		}
		return businessSponsor;
	}
	
	/**
	 * 无条件查询所有BusinessSponsor
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessSponsor> findAll() throws ServiceException {
		List<BusinessSponsor> list = new ArrayList<BusinessSponsor>() ;
		try {
			list=businessSponsorDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessSponsorServiceImpl findAll()：无条件查询所有BusinessSponsor发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessSponsor
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessSponsor> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessSponsor> list = new ArrayList<BusinessSponsor>() ;
		try {
			list=businessSponsorDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessSponsorServiceImpl findByMap()：按Map对象条件查询所有BusinessSponsor发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessSponsor-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessSponsor> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessSponsor> list = new ArrayList<BusinessSponsor>() ;
		try {
			list=businessSponsorDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessSponsorServiceImpl findByMap()：按Map对象条件查询所有BusinessSponsor-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessSponsor
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessSponsor> findByExample(final BusinessSponsorQuery query) throws ServiceException {
		List<BusinessSponsor> list = new ArrayList<BusinessSponsor>() ;
		try {
			list=businessSponsorDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessSponsorServiceImpl findByExample()：按VO对象条件查询所有BusinessSponsor发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessSponsor-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessSponsor> findByExample(final BusinessSponsorQuery query, final Integer limit) throws ServiceException {
		List<BusinessSponsor> list = new ArrayList<BusinessSponsor>() ;
		try {
			list=businessSponsorDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessSponsorServiceImpl findByExample()：按VO对象条件查询所有BusinessSponsor-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessSponsorQuery query) throws ServiceException {
		List<BusinessSponsor> list = new ArrayList<BusinessSponsor>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessSponsorDao.findAllPage(query);
			count=businessSponsorDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessSponsorServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessSponsorQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessSponsorDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessSponsorServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessSponsor数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessSponsor entity) throws ServiceException {
		try {
			businessSponsorDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessSponsorServiceImpl save()：保存BusinessSponsor发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessSponsor数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessSponsor entity) throws ServiceException {
		try {
			businessSponsorDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessSponsorServiceImpl update()：修改BusinessSponsor发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessSponsor
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessSponsorDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessSponsorServiceImpl delete()：删除BusinessSponsor发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
