package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessNewsRecommend;
import com.community.app.module.dao.BusinessNewsRecommendDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessNewsRecommendQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessNewsRecommendService")
@Transactional
public class BusinessNewsRecommendServiceImpl implements BusinessNewsRecommendService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessNewsRecommendServiceImpl.class);
	@Autowired
	private BusinessNewsRecommendDao businessNewsRecommendDao;

	/**
	 * 查询单个BusinessNewsRecommend
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessNewsRecommend findById(final Integer id) throws ServiceException {
		BusinessNewsRecommend businessNewsRecommend = new BusinessNewsRecommend();
		try {
			businessNewsRecommend = businessNewsRecommendDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessNewsRecommendServiceImpl findById()：查询单个BusinessNewsRecommend发生错误！", e);
			e.printStackTrace();
		}
		return businessNewsRecommend;
	}
	
	/**
	 * 无条件查询所有BusinessNewsRecommend
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessNewsRecommend> findAll() throws ServiceException {
		List<BusinessNewsRecommend> list = new ArrayList<BusinessNewsRecommend>() ;
		try {
			list=businessNewsRecommendDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessNewsRecommendServiceImpl findAll()：无条件查询所有BusinessNewsRecommend发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewsRecommend
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNewsRecommend> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessNewsRecommend> list = new ArrayList<BusinessNewsRecommend>() ;
		try {
			list=businessNewsRecommendDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessNewsRecommendServiceImpl findByMap()：按Map对象条件查询所有BusinessNewsRecommend发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewsRecommend-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessNewsRecommend> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessNewsRecommend> list = new ArrayList<BusinessNewsRecommend>() ;
		try {
			list=businessNewsRecommendDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessNewsRecommendServiceImpl findByMap()：按Map对象条件查询所有BusinessNewsRecommend-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessNewsRecommend
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNewsRecommend> findByExample(final BusinessNewsRecommendQuery query) throws ServiceException {
		List<BusinessNewsRecommend> list = new ArrayList<BusinessNewsRecommend>() ;
		try {
			list=businessNewsRecommendDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsRecommendServiceImpl findByExample()：按VO对象条件查询所有BusinessNewsRecommend发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNewsRecommend-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessNewsRecommend> findByExample(final BusinessNewsRecommendQuery query, final Integer limit) throws ServiceException {
		List<BusinessNewsRecommend> list = new ArrayList<BusinessNewsRecommend>() ;
		try {
			list=businessNewsRecommendDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessNewsRecommendServiceImpl findByExample()：按VO对象条件查询所有BusinessNewsRecommend-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessNewsRecommendQuery query) throws ServiceException {
		List<BusinessNewsRecommend> list = new ArrayList<BusinessNewsRecommend>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessNewsRecommendDao.findAllPage(query);
			count=businessNewsRecommendDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsRecommendServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessNewsRecommendQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessNewsRecommendDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsRecommendServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessNewsRecommend数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessNewsRecommend entity) throws ServiceException {
		try {
			businessNewsRecommendDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessNewsRecommendServiceImpl save()：保存BusinessNewsRecommend发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessNewsRecommend数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessNewsRecommend entity) throws ServiceException {
		try {
			businessNewsRecommendDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessNewsRecommendServiceImpl update()：修改BusinessNewsRecommend发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessNewsRecommend
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessNewsRecommendDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessNewsRecommendServiceImpl delete()：删除BusinessNewsRecommend发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
