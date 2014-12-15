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

import com.community.app.module.vo.BusinessNewsQuery;
import com.community.app.module.bean.BusinessNews;
import com.community.app.module.bean.index;
import com.community.app.module.dao.BusinessNewsDao;

@Service("BusinessNewsService")
@Transactional
public class BusinessNewsServiceImpl implements BusinessNewsService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessNewsServiceImpl.class);
	@Autowired
	private BusinessNewsDao businessNewsDao;

	/**
	 * 查询单个BusinessNews
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessNews findById(final Integer id) throws ServiceException {
		BusinessNews businessNews = new BusinessNews();
		try {
			businessNews = businessNewsDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessNewsServiceImpl findById()：查询单个BusinessNews发生错误！", e);
			e.printStackTrace();
		}
		return businessNews;
	}
	
	/**
	 * 查询单个BusinessNews
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = false)
	public BusinessNews findById_app(final Integer id) throws ServiceException {
		BusinessNews businessNews = new BusinessNews();
		try {
			businessNews = businessNewsDao.findById_app(id);
		} catch (DaoException e) {
			logger.debug("BusinessNewsServiceImpl findById()：查询单个BusinessNews发生错误！", e);
			e.printStackTrace();
		}
		return businessNews;
	}
	
	/**
	 * 无条件查询所有BusinessNews
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessNews> findAll() throws ServiceException {
		List<BusinessNews> list = new ArrayList<BusinessNews>() ;
		try {
			list=businessNewsDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessNewsServiceImpl findAll()：无条件查询所有BusinessNews发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNews
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNews> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessNews> list = new ArrayList<BusinessNews>() ;
		try {
			list=businessNewsDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessNewsServiceImpl findByMap()：按Map对象条件查询所有BusinessNews发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNews-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessNews> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessNews> list = new ArrayList<BusinessNews>() ;
		try {
			list=businessNewsDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessNewsServiceImpl findByMap()：按Map对象条件查询所有BusinessNews-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessNews
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNews> findByExample(final BusinessNewsQuery query) throws ServiceException {
		List<BusinessNews> list = new ArrayList<BusinessNews>() ;
		try {
			list=businessNewsDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsServiceImpl findByExample()：按VO对象条件查询所有BusinessNews发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNews-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessNews> findByExample(final BusinessNewsQuery query, final Integer limit) throws ServiceException {
		List<BusinessNews> list = new ArrayList<BusinessNews>() ;
		try {
			list=businessNewsDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessNewsServiceImpl findByExample()：按VO对象条件查询所有BusinessNews-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessNewsQuery query) throws ServiceException {
		List<BusinessNews> list = new ArrayList<BusinessNews>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessNewsDao.selectCount(query);
			query.setCount(count);
			list=businessNewsDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setPage(query.getPage());
		return baseBean;
	}
	
	/**
	 * 根据newId查询当前所有置顶的新闻
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessNews> findAllHotById() throws ServiceException {
		List<BusinessNews> list = new ArrayList<BusinessNews>() ;
		try {
			list=businessNewsDao.findAllHotById();
		} catch (DaoException e) {
			logger.debug("BusinessNewsServiceImpl findAllHotById()：根据newId查询当前所有BusinessNews置顶的新闻发生错误！", e);
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
	public BaseBean findAllPage_app(final BusinessNewsQuery query) throws ServiceException {
		List<BusinessNews> list = new ArrayList<BusinessNews>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessNewsDao.selectCount_app(query);
			query.setCount(count);
			list=businessNewsDao.findAllPage_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage_index_app(final BusinessNewsQuery query) throws ServiceException {
		List<index> list = new ArrayList<index>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessNewsDao.selectCount_index_app(query);
			query.setCount(count);
			list=businessNewsDao.findAllPage_index_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsServiceImpl findAllPage_index_app()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessNewsQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessNewsDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessNews数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessNews entity) throws ServiceException {
		try {
			businessNewsDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessNewsServiceImpl save()：保存BusinessNews发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessNews数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public int update(BusinessNews entity) throws ServiceException {
		int count = 0;
		try {
			count = businessNewsDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessNewsServiceImpl update()：修改BusinessNews发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 删除BusinessNews
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessNewsDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessNewsServiceImpl delete()：删除BusinessNews发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
