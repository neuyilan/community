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

import com.community.app.module.vo.BusinessFeedbackPicQuery;
import com.community.app.module.bean.BusinessFeedbackPic;
import com.community.app.module.dao.BusinessFeedbackPicDao;

@Service("BusinessFeedbackPicService")
@Transactional
public class BusinessFeedbackPicServiceImpl implements BusinessFeedbackPicService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessFeedbackPicServiceImpl.class);
	@Autowired
	private BusinessFeedbackPicDao businessFeedbackPicDao;

	/**
	 * 查询单个BusinessFeedbackPic
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessFeedbackPic findById(final Integer id) throws ServiceException {
		BusinessFeedbackPic businessFeedbackPic = new BusinessFeedbackPic();
		try {
			businessFeedbackPic = businessFeedbackPicDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackPicServiceImpl findById()：查询单个BusinessFeedbackPic发生错误！", e);
			e.printStackTrace();
		}
		return businessFeedbackPic;
	}
	
	/**
	 * 无条件查询所有BusinessFeedbackPic
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessFeedbackPic> findAll() throws ServiceException {
		List<BusinessFeedbackPic> list = new ArrayList<BusinessFeedbackPic>() ;
		try {
			list=businessFeedbackPicDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackPicServiceImpl findAll()：无条件查询所有BusinessFeedbackPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackPic
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFeedbackPic> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessFeedbackPic> list = new ArrayList<BusinessFeedbackPic>() ;
		try {
			list=businessFeedbackPicDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackPicServiceImpl findByMap()：按Map对象条件查询所有BusinessFeedbackPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackPic-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessFeedbackPic> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessFeedbackPic> list = new ArrayList<BusinessFeedbackPic>() ;
		try {
			list=businessFeedbackPicDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackPicServiceImpl findByMap()：按Map对象条件查询所有BusinessFeedbackPic-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackPic
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFeedbackPic> findByExample(final BusinessFeedbackPicQuery query) throws ServiceException {
		List<BusinessFeedbackPic> list = new ArrayList<BusinessFeedbackPic>() ;
		try {
			list=businessFeedbackPicDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackPicServiceImpl findByExample()：按VO对象条件查询所有BusinessFeedbackPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackPic-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessFeedbackPic> findByExample(final BusinessFeedbackPicQuery query, final Integer limit) throws ServiceException {
		List<BusinessFeedbackPic> list = new ArrayList<BusinessFeedbackPic>() ;
		try {
			list=businessFeedbackPicDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackPicServiceImpl findByExample()：按VO对象条件查询所有BusinessFeedbackPic-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessFeedbackPicQuery query) throws ServiceException {
		List<BusinessFeedbackPic> list = new ArrayList<BusinessFeedbackPic>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessFeedbackPicDao.findAllPage(query);
			count=businessFeedbackPicDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackPicServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessFeedbackPicQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessFeedbackPicDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackPicServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessFeedbackPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessFeedbackPic entity) throws ServiceException {
		try {
			businessFeedbackPicDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackPicServiceImpl save()：保存BusinessFeedbackPic发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessFeedbackPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessFeedbackPic entity) throws ServiceException {
		try {
			businessFeedbackPicDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackPicServiceImpl update()：修改BusinessFeedbackPic发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessFeedbackPic
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessFeedbackPicDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessFeedbackPicServiceImpl delete()：删除BusinessFeedbackPic发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
