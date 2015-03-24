package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessRegPic;
import com.community.app.module.dao.BusinessRegPicDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessRegPicQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessRegPicService")
@Transactional
public class BusinessRegPicServiceImpl implements BusinessRegPicService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessRegPicServiceImpl.class);
	@Autowired
	private BusinessRegPicDao businessRegPicDao;

	/**
	 * 查询单个BusinessRegPic
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessRegPic findById(final Integer id) throws ServiceException {
		BusinessRegPic businessRegPic = new BusinessRegPic();
		try {
			businessRegPic = businessRegPicDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessRegPicServiceImpl findById()：查询单个BusinessRegPic发生错误！", e);
			e.printStackTrace();
		}
		return businessRegPic;
	}
	
	/**
	 * 无条件查询所有BusinessRegPic
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessRegPic> findAll() throws ServiceException {
		List<BusinessRegPic> list = new ArrayList<BusinessRegPic>() ;
		try {
			list=businessRegPicDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessRegPicServiceImpl findAll()：无条件查询所有BusinessRegPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRegPic
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRegPic> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessRegPic> list = new ArrayList<BusinessRegPic>() ;
		try {
			list=businessRegPicDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessRegPicServiceImpl findByMap()：按Map对象条件查询所有BusinessRegPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRegPic-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRegPic> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessRegPic> list = new ArrayList<BusinessRegPic>() ;
		try {
			list=businessRegPicDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRegPicServiceImpl findByMap()：按Map对象条件查询所有BusinessRegPic-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRegPic
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRegPic> findByExample(final BusinessRegPicQuery query) throws ServiceException {
		List<BusinessRegPic> list = new ArrayList<BusinessRegPic>() ;
		try {
			list=businessRegPicDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessRegPicServiceImpl findByExample()：按VO对象条件查询所有BusinessRegPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRegPic-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRegPic> findByExample(final BusinessRegPicQuery query, final Integer limit) throws ServiceException {
		List<BusinessRegPic> list = new ArrayList<BusinessRegPic>() ;
		try {
			list=businessRegPicDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRegPicServiceImpl findByExample()：按VO对象条件查询所有BusinessRegPic-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessRegPicQuery query) throws ServiceException {
		List<BusinessRegPic> list = new ArrayList<BusinessRegPic>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessRegPicDao.findAllPage(query);
			count=businessRegPicDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRegPicServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessRegPicQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessRegPicDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRegPicServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessRegPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessRegPic entity) throws ServiceException {
		try {
			businessRegPicDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRegPicServiceImpl save()：保存BusinessRegPic发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessRegPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessRegPic entity) throws ServiceException {
		try {
			businessRegPicDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRegPicServiceImpl update()：修改BusinessRegPic发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessRegPic
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessRegPicDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessRegPicServiceImpl delete()：删除BusinessRegPic发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
