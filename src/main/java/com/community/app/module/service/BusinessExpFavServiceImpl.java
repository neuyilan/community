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

import com.community.app.module.vo.BusinessExpFavQuery;
import com.community.app.module.bean.BusinessExpFav;
import com.community.app.module.dao.BusinessExpFavDao;

@Service("BusinessExpFavService")
@Transactional
public class BusinessExpFavServiceImpl implements BusinessExpFavService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessExpFavServiceImpl.class);
	@Autowired
	private BusinessExpFavDao businessExpFavDao;

	/**
	 * 查询单个BusinessExpFav
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessExpFav findById(final Integer id) throws ServiceException {
		BusinessExpFav businessExpFav = new BusinessExpFav();
		try {
			businessExpFav = businessExpFavDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessExpFavServiceImpl findById()：查询单个BusinessExpFav发生错误！", e);
			e.printStackTrace();
		}
		return businessExpFav;
	}
	
	/**
	 * 无条件查询所有BusinessExpFav
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessExpFav> findAll() throws ServiceException {
		List<BusinessExpFav> list = new ArrayList<BusinessExpFav>() ;
		try {
			list=businessExpFavDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessExpFavServiceImpl findAll()：无条件查询所有BusinessExpFav发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessExpFav
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessExpFav> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessExpFav> list = new ArrayList<BusinessExpFav>() ;
		try {
			list=businessExpFavDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessExpFavServiceImpl findByMap()：按Map对象条件查询所有BusinessExpFav发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessExpFav-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessExpFav> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessExpFav> list = new ArrayList<BusinessExpFav>() ;
		try {
			list=businessExpFavDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessExpFavServiceImpl findByMap()：按Map对象条件查询所有BusinessExpFav-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessExpFav
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessExpFav> findByExample(final BusinessExpFavQuery query) throws ServiceException {
		List<BusinessExpFav> list = new ArrayList<BusinessExpFav>() ;
		try {
			list=businessExpFavDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessExpFavServiceImpl findByExample()：按VO对象条件查询所有BusinessExpFav发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessExpFav-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessExpFav> findByExample(final BusinessExpFavQuery query, final Integer limit) throws ServiceException {
		List<BusinessExpFav> list = new ArrayList<BusinessExpFav>() ;
		try {
			list=businessExpFavDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessExpFavServiceImpl findByExample()：按VO对象条件查询所有BusinessExpFav-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessExpFavQuery query) throws ServiceException {
		List<BusinessExpFav> list = new ArrayList<BusinessExpFav>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessExpFavDao.findAllPage(query);
			count=businessExpFavDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessExpFavServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessExpFavQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessExpFavDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessExpFavServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessExpFav数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessExpFav entity) throws ServiceException {
		try {
			businessExpFavDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessExpFavServiceImpl save()：保存BusinessExpFav发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessExpFav数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessExpFav entity) throws ServiceException {
		try {
			businessExpFavDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessExpFavServiceImpl update()：修改BusinessExpFav发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessExpFav
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessExpFavDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessExpFavServiceImpl delete()：删除BusinessExpFav发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
