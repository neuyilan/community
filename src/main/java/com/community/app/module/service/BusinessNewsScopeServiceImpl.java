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

import com.community.app.module.vo.BusinessNewsScopeQuery;
import com.community.app.module.bean.BusinessNewsScope;
import com.community.app.module.dao.BusinessNewsScopeDao;

@Service("BusinessNewsScopeService")
@Transactional
public class BusinessNewsScopeServiceImpl implements BusinessNewsScopeService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessNewsScopeServiceImpl.class);
	@Autowired
	private BusinessNewsScopeDao businessNewsScopeDao;

	/**
	 * 查询单个BusinessNewsScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessNewsScope findById(final Integer id) throws ServiceException {
		BusinessNewsScope businessNewsScope = new BusinessNewsScope();
		try {
			businessNewsScope = businessNewsScopeDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessNewsScopeServiceImpl findById()：查询单个BusinessNewsScope发生错误！", e);
			e.printStackTrace();
		}
		return businessNewsScope;
	}
	
	/**
	 * 无条件查询所有BusinessNewsScope
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessNewsScope> findAll() throws ServiceException {
		List<BusinessNewsScope> list = new ArrayList<BusinessNewsScope>() ;
		try {
			list=businessNewsScopeDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessNewsScopeServiceImpl findAll()：无条件查询所有BusinessNewsScope发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewsScope
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNewsScope> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessNewsScope> list = new ArrayList<BusinessNewsScope>() ;
		try {
			list=businessNewsScopeDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessNewsScopeServiceImpl findByMap()：按Map对象条件查询所有BusinessNewsScope发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewsScope-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessNewsScope> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessNewsScope> list = new ArrayList<BusinessNewsScope>() ;
		try {
			list=businessNewsScopeDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessNewsScopeServiceImpl findByMap()：按Map对象条件查询所有BusinessNewsScope-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessNewsScope
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessNewsScope> findByExample(final BusinessNewsScopeQuery query) throws ServiceException {
		List<BusinessNewsScope> list = new ArrayList<BusinessNewsScope>() ;
		try {
			list=businessNewsScopeDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsScopeServiceImpl findByExample()：按VO对象条件查询所有BusinessNewsScope发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNewsScope-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessNewsScope> findByExample(final BusinessNewsScopeQuery query, final Integer limit) throws ServiceException {
		List<BusinessNewsScope> list = new ArrayList<BusinessNewsScope>() ;
		try {
			list=businessNewsScopeDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessNewsScopeServiceImpl findByExample()：按VO对象条件查询所有BusinessNewsScope-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessNewsScopeQuery query) throws ServiceException {
		List<BusinessNewsScope> list = new ArrayList<BusinessNewsScope>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessNewsScopeDao.selectCount(query);
			query.setCount(count);
			list=businessNewsScopeDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsScopeServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessNewsScopeQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessNewsScopeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsScopeServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessNewsScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessNewsScope entity) throws ServiceException {
		try {
			businessNewsScopeDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessNewsScopeServiceImpl save()：保存BusinessNewsScope发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessNewsScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessNewsScope entity) throws ServiceException {
		try {
			businessNewsScopeDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessNewsScopeServiceImpl update()：修改BusinessNewsScope发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessNewsScope
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessNewsScopeDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessNewsScopeServiceImpl delete()：删除BusinessNewsScope发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 根据搜索条件，搜索分页所需的数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPageByField(final Map fieldMap, final BusinessNewsScopeQuery query) throws ServiceException {
		List<BusinessNewsScope> list = new ArrayList<BusinessNewsScope>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessNewsScopeDao.selectCount(query);
			query.setCount(count);
			list=businessNewsScopeDao.findAllPageByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsScopeServiceImpl findAllPageByField()：根据搜索条件，根据搜索条件，搜索分页所需的数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}
	
	/**
	 * 根据条件查询所需字段，返回列表
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List findListByField(final Map fieldMap, final BusinessNewsScopeQuery query) throws ServiceException {
		List<BusinessNewsScope> list = new ArrayList<BusinessNewsScope>() ;
		try {
			list=businessNewsScopeDao.findListByField(fieldMap, query);
		} catch (DaoException e) {
			logger.debug("BusinessNewsScopeServiceImpl findListByField()：根据条件查询所需字段，返回列表发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessNewsScope findByField(final Map fieldMap, final Integer id) throws ServiceException {
		BusinessNewsScope businessNewsScope = new BusinessNewsScope();
		try {
			businessNewsScope = businessNewsScopeDao.findByField(fieldMap, id);
		} catch (DaoException e) {
			logger.debug("BusinessNewsScopeServiceImpl findByField()：根据条件查询所需字段，返回对象发生错误！", e);
			e.printStackTrace();
		}
		return businessNewsScope;
	}
	
	/**
	 * 删除新闻范围
	 * @param newsId
	 * @throws ServiceException
	 */
	public boolean deleteScopeByNews(final Integer newsId) throws ServiceException {
		Boolean bool = false;
		try {
			bool = businessNewsScopeDao.deleteScopeByNews(newsId);
		} catch (DaoException e) {
			logger.debug("BusinessNewsScopeServiceImpl deleteScopeByNews()：删除新闻范围！", e);
			e.printStackTrace();
		}
		return bool;
	}
	
}
