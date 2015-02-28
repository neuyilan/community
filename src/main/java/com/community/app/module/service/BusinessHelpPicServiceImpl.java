package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessHelpPic;
import com.community.app.module.dao.BusinessHelpPicDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessHelpPicQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessHelpPicService")
@Transactional
public class BusinessHelpPicServiceImpl implements BusinessHelpPicService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessHelpPicServiceImpl.class);
	@Autowired
	private BusinessHelpPicDao businessHelpPicDao;

	/**
	 * 查询单个BusinessHelpPic
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessHelpPic findById(final Integer id) throws ServiceException {
		BusinessHelpPic businessHelpPic = new BusinessHelpPic();
		try {
			businessHelpPic = businessHelpPicDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessHelpPicServiceImpl findById()：查询单个BusinessHelpPic发生错误！", e);
			e.printStackTrace();
		}
		return businessHelpPic;
	}
	
	/**
	 * 无条件查询所有BusinessHelpPic
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessHelpPic> findAll() throws ServiceException {
		List<BusinessHelpPic> list = new ArrayList<BusinessHelpPic>() ;
		try {
			list=businessHelpPicDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessHelpPicServiceImpl findAll()：无条件查询所有BusinessHelpPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpPic
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelpPic> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessHelpPic> list = new ArrayList<BusinessHelpPic>() ;
		try {
			list=businessHelpPicDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessHelpPicServiceImpl findByMap()：按Map对象条件查询所有BusinessHelpPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpPic-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessHelpPic> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessHelpPic> list = new ArrayList<BusinessHelpPic>() ;
		try {
			list=businessHelpPicDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHelpPicServiceImpl findByMap()：按Map对象条件查询所有BusinessHelpPic-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessHelpPic
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessHelpPic> findByExample(final BusinessHelpPicQuery query) throws ServiceException {
		List<BusinessHelpPic> list = new ArrayList<BusinessHelpPic>() ;
		try {
			list=businessHelpPicDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpPicServiceImpl findByExample()：按VO对象条件查询所有BusinessHelpPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelpPic-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessHelpPic> findByExample(final BusinessHelpPicQuery query, final Integer limit) throws ServiceException {
		List<BusinessHelpPic> list = new ArrayList<BusinessHelpPic>() ;
		try {
			list=businessHelpPicDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessHelpPicServiceImpl findByExample()：按VO对象条件查询所有BusinessHelpPic-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessHelpPicQuery query) throws ServiceException {
		List<BusinessHelpPic> list = new ArrayList<BusinessHelpPic>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessHelpPicDao.findAllPage(query);
			count=businessHelpPicDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpPicServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessHelpPicQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessHelpPicDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessHelpPicServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessHelpPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessHelpPic entity) throws ServiceException {
		try {
			businessHelpPicDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHelpPicServiceImpl save()：保存BusinessHelpPic发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessHelpPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessHelpPic entity) throws ServiceException {
		try {
			businessHelpPicDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessHelpPicServiceImpl update()：修改BusinessHelpPic发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessHelpPic
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessHelpPicDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessHelpPicServiceImpl delete()：删除BusinessHelpPic发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
