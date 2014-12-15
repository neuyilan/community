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
import com.community.app.module.vo.BusinessBreakPicQuery;
import com.community.app.module.bean.BusinessBreakPic;
import com.community.app.module.dao.BusinessBreakPicDao;

@Service("BusinessBreakPicService")
@Transactional
public class BusinessBreakPicServiceImpl implements BusinessBreakPicService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessBreakPicServiceImpl.class);
	@Autowired
	private BusinessBreakPicDao businessBreakPicDao;

	/**
	 * 查询单个BusinessBreakPic
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessBreakPic findById(final Integer id) throws ServiceException {
		BusinessBreakPic businessBreakPic = new BusinessBreakPic();
		try {
			businessBreakPic = businessBreakPicDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessBreakPicServiceImpl findById()：查询单个BusinessBreakPic发生错误！", e);
			e.printStackTrace();
		}
		return businessBreakPic;
	}
	
	/**
	 * 无条件查询所有BusinessBreakPic
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessBreakPic> findAll() throws ServiceException {
		List<BusinessBreakPic> list = new ArrayList<BusinessBreakPic>() ;
		try {
			list=businessBreakPicDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessBreakPicServiceImpl findAll()：无条件查询所有BusinessBreakPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBreakPic
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessBreakPic> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessBreakPic> list = new ArrayList<BusinessBreakPic>() ;
		try {
			list=businessBreakPicDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessBreakPicServiceImpl findByMap()：按Map对象条件查询所有BusinessBreakPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBreakPic-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessBreakPic> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessBreakPic> list = new ArrayList<BusinessBreakPic>() ;
		try {
			list=businessBreakPicDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessBreakPicServiceImpl findByMap()：按Map对象条件查询所有BusinessBreakPic-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessBreakPic
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessBreakPic> findByExample(final BusinessBreakPicQuery query) throws ServiceException {
		List<BusinessBreakPic> list = new ArrayList<BusinessBreakPic>() ;
		try {
			list=businessBreakPicDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakPicServiceImpl findByExample()：按VO对象条件查询所有BusinessBreakPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBreakPic-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessBreakPic> findByExample(final BusinessBreakPicQuery query, final Integer limit) throws ServiceException {
		List<BusinessBreakPic> list = new ArrayList<BusinessBreakPic>() ;
		try {
			list=businessBreakPicDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessBreakPicServiceImpl findByExample()：按VO对象条件查询所有BusinessBreakPic-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 根据爆料ID查询所有爆料的图片BusinessBreakPic
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessBreakPic> findPicListByBreakId(final Integer id) throws ServiceException {
		BusinessBreakPicQuery query = new BusinessBreakPicQuery();
		List<BusinessBreakPic> list = new ArrayList<BusinessBreakPic>() ;
		query.setBreakId(id);
		try {
			list = businessBreakPicDao.findPicListByBreakId(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakPicServiceImpl findPicListByBreakId()：根据爆料ID查询所有爆料的图片BusinessBreakPic发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage(final BusinessBreakPicQuery query) throws ServiceException {
		List<BusinessBreakPic> list = new ArrayList<BusinessBreakPic>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessBreakPicDao.findAllPage(query);
			count=businessBreakPicDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakPicServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessBreakPicQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessBreakPicDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessBreakPicServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessBreakPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessBreakPic entity) throws ServiceException {
		try {
			businessBreakPicDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessBreakPicServiceImpl save()：保存BusinessBreakPic发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessBreakPic数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessBreakPic entity) throws ServiceException {
		try {
			businessBreakPicDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessBreakPicServiceImpl update()：修改BusinessBreakPic发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessBreakPic
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessBreakPicDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessBreakPicServiceImpl delete()：删除BusinessBreakPic发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
