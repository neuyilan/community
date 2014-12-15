package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.community.app.module.vo.BaseBean;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.vo.BusinessProductPicQuery;
import com.community.app.module.bean.BusinessProductPic;
import com.community.app.module.dao.BusinessProductPicDao;

@Service("BusinessProductPicService")
@Transactional
public class BusinessProductPicServiceImpl implements BusinessProductPicService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessProductPicServiceImpl.class);
	@Autowired
	private BusinessProductPicDao businessProductPicDao;

	/**
	 * 查询单个BusinessProductPic
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessProductPic findById(final Integer id) throws ServiceException {
		BusinessProductPic businessProductPic = new BusinessProductPic();
		try {
			businessProductPic = businessProductPicDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessProductPicServiceImpl findById()：查询单个BusinessProductPic发生错误！", e);
			e.printStackTrace();
		}
		return businessProductPic;
	}
	
	/**
	 * 无条件查询所有BusinessProductPic
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessProductPic> findAll() throws ServiceException {
		List<BusinessProductPic> list = new ArrayList<BusinessProductPic>() ;
		try {
			list=businessProductPicDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessProductPicServiceImpl findAll()：无条件查询所有BusinessProductPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据跳蚤市场ID查询所有BusinessProductPic
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessProductPic> findAllPicbyId(final Integer id) throws ServiceException {
		List<BusinessProductPic> list = new ArrayList<BusinessProductPic>() ;
		try {
			list=businessProductPicDao.findAllPicbyId(id);
		} catch (DaoException e) {
			logger.debug("BusinessProductPicServiceImpl findAllPicbyId()：根据跳蚤市场ID查询所有BusinessProductPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProductPic
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessProductPic> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessProductPic> list = new ArrayList<BusinessProductPic>() ;
		try {
			list=businessProductPicDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessProductPicServiceImpl findByMap()：按Map对象条件查询所有BusinessProductPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProductPic-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessProductPic> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessProductPic> list = new ArrayList<BusinessProductPic>() ;
		try {
			list=businessProductPicDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessProductPicServiceImpl findByMap()：按Map对象条件查询所有BusinessProductPic-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessProductPic
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessProductPic> findByExample(final BusinessProductPicQuery query) throws ServiceException {
		List<BusinessProductPic> list = new ArrayList<BusinessProductPic>() ;
		try {
			list=businessProductPicDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessProductPicServiceImpl findByExample()：按VO对象条件查询所有BusinessProductPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessProductPic-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessProductPic> findByExample(final BusinessProductPicQuery query, final Integer limit) throws ServiceException {
		List<BusinessProductPic> list = new ArrayList<BusinessProductPic>() ;
		try {
			list=businessProductPicDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessProductPicServiceImpl findByExample()：按VO对象条件查询所有BusinessProductPic-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessProductPicQuery query) throws ServiceException {
		List<BusinessProductPic> list = new ArrayList<BusinessProductPic>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessProductPicDao.findAllPage(query);
			count=businessProductPicDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessProductPicServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessProductPicQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessProductPicDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessProductPicServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessProductPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessProductPic entity) throws ServiceException {
		try {
			businessProductPicDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessProductPicServiceImpl save()：保存BusinessProductPic发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessProductPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessProductPic entity) throws ServiceException {
		try {
			businessProductPicDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessProductPicServiceImpl update()：修改BusinessProductPic发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessProductPic
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessProductPicDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessProductPicServiceImpl delete()：删除BusinessProductPic发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
