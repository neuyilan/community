package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessRepairPic;
import com.community.app.module.dao.BusinessRepairPicDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessRepairPicQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessRepairPicService")
@Transactional
public class BusinessRepairPicServiceImpl implements BusinessRepairPicService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessRepairPicServiceImpl.class);
	@Autowired
	private BusinessRepairPicDao businessRepairPicDao;

	/**
	 * 查询单个BusinessRepairPic
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessRepairPic findById(final Integer id) throws ServiceException {
		BusinessRepairPic businessRepairPic = new BusinessRepairPic();
		try {
			businessRepairPic = businessRepairPicDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessRepairPicServiceImpl findById()：查询单个BusinessRepairPic发生错误！", e);
			e.printStackTrace();
		}
		return businessRepairPic;
	}
	
	/**
	 * 无条件查询所有BusinessRepairPic
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessRepairPic> findAll() throws ServiceException {
		List<BusinessRepairPic> list = new ArrayList<BusinessRepairPic>() ;
		try {
			list=businessRepairPicDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessRepairPicServiceImpl findAll()：无条件查询所有BusinessRepairPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRepairPic
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRepairPic> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessRepairPic> list = new ArrayList<BusinessRepairPic>() ;
		try {
			list=businessRepairPicDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessRepairPicServiceImpl findByMap()：按Map对象条件查询所有BusinessRepairPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRepairPic-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRepairPic> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessRepairPic> list = new ArrayList<BusinessRepairPic>() ;
		try {
			list=businessRepairPicDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRepairPicServiceImpl findByMap()：按Map对象条件查询所有BusinessRepairPic-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRepairPic
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessRepairPic> findByExample(final BusinessRepairPicQuery query) throws ServiceException {
		List<BusinessRepairPic> list = new ArrayList<BusinessRepairPic>() ;
		try {
			list=businessRepairPicDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairPicServiceImpl findByExample()：按VO对象条件查询所有BusinessRepairPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRepairPic-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessRepairPic> findByExample(final BusinessRepairPicQuery query, final Integer limit) throws ServiceException {
		List<BusinessRepairPic> list = new ArrayList<BusinessRepairPic>() ;
		try {
			list=businessRepairPicDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessRepairPicServiceImpl findByExample()：按VO对象条件查询所有BusinessRepairPic-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessRepairPicQuery query) throws ServiceException {
		List<BusinessRepairPic> list = new ArrayList<BusinessRepairPic>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessRepairPicDao.findAllPage(query);
			count=businessRepairPicDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairPicServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessRepairPicQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessRepairPicDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessRepairPicServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessRepairPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessRepairPic entity) throws ServiceException {
		try {
			businessRepairPicDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRepairPicServiceImpl save()：保存BusinessRepairPic发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessRepairPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessRepairPic entity) throws ServiceException {
		try {
			businessRepairPicDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessRepairPicServiceImpl update()：修改BusinessRepairPic发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessRepairPic
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessRepairPicDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessRepairPicServiceImpl delete()：删除BusinessRepairPic发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
