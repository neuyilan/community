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

import com.community.app.module.vo.BusinessProductKeywordQuery;
import com.community.app.module.bean.BusinessProductKeyword;
import com.community.app.module.dao.BusinessProductKeywordDao;

@Service("BusinessProductKeywordService")
@Transactional
public class BusinessProductKeywordServiceImpl implements BusinessProductKeywordService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessProductKeywordServiceImpl.class);
	@Autowired
	private BusinessProductKeywordDao businessProductKeywordDao;

	/**
	 * 查询单个BusinessProductKeyword
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessProductKeyword findById(final Integer id) throws ServiceException {
		BusinessProductKeyword businessProductKeyword = new BusinessProductKeyword();
		try {
			businessProductKeyword = businessProductKeywordDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessProductKeywordServiceImpl findById()：查询单个BusinessProductKeyword发生错误！", e);
			e.printStackTrace();
		}
		return businessProductKeyword;
	}
	
	/**
	 * 无条件查询所有BusinessProductKeyword
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessProductKeyword> findAll() throws ServiceException {
		List<BusinessProductKeyword> list = new ArrayList<BusinessProductKeyword>() ;
		try {
			list=businessProductKeywordDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessProductKeywordServiceImpl findAll()：无条件查询所有BusinessProductKeyword发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProductKeyword
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessProductKeyword> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessProductKeyword> list = new ArrayList<BusinessProductKeyword>() ;
		try {
			list=businessProductKeywordDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessProductKeywordServiceImpl findByMap()：按Map对象条件查询所有BusinessProductKeyword发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProductKeyword-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessProductKeyword> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessProductKeyword> list = new ArrayList<BusinessProductKeyword>() ;
		try {
			list=businessProductKeywordDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessProductKeywordServiceImpl findByMap()：按Map对象条件查询所有BusinessProductKeyword-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessProductKeyword
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessProductKeyword> findByExample(final BusinessProductKeywordQuery query) throws ServiceException {
		List<BusinessProductKeyword> list = new ArrayList<BusinessProductKeyword>() ;
		try {
			list=businessProductKeywordDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessProductKeywordServiceImpl findByExample()：按VO对象条件查询所有BusinessProductKeyword发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessProductKeyword-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessProductKeyword> findByExample(final BusinessProductKeywordQuery query, final Integer limit) throws ServiceException {
		List<BusinessProductKeyword> list = new ArrayList<BusinessProductKeyword>() ;
		try {
			list=businessProductKeywordDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessProductKeywordServiceImpl findByExample()：按VO对象条件查询所有BusinessProductKeyword-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessProductKeywordQuery query) throws ServiceException {
		List<BusinessProductKeyword> list = new ArrayList<BusinessProductKeyword>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessProductKeywordDao.findAllPage(query);
			count=businessProductKeywordDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessProductKeywordServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessProductKeywordQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessProductKeywordDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessProductKeywordServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessProductKeyword数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessProductKeyword entity) throws ServiceException {
		try {
			businessProductKeywordDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessProductKeywordServiceImpl save()：保存BusinessProductKeyword发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessProductKeyword数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessProductKeyword entity) throws ServiceException {
		try {
			businessProductKeywordDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessProductKeywordServiceImpl update()：修改BusinessProductKeyword发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessProductKeyword
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessProductKeywordDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessProductKeywordServiceImpl delete()：删除BusinessProductKeyword发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
