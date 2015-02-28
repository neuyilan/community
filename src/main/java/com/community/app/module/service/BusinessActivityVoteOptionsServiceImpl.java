package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessActivityVoteOptions;
import com.community.app.module.dao.BusinessActivityVoteOptionsDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityVoteOptionsQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessActivityVoteOptionsService")
@Transactional
public class BusinessActivityVoteOptionsServiceImpl implements BusinessActivityVoteOptionsService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessActivityVoteOptionsServiceImpl.class);
	@Autowired
	private BusinessActivityVoteOptionsDao businessActivityVoteOptionsDao;

	/**
	 * 查询单个BusinessActivityVoteOptions
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessActivityVoteOptions findById(final Integer id) throws ServiceException {
		BusinessActivityVoteOptions businessActivityVoteOptions = new BusinessActivityVoteOptions();
		try {
			businessActivityVoteOptions = businessActivityVoteOptionsDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteOptionsServiceImpl findById()：查询单个BusinessActivityVoteOptions发生错误！", e);
			e.printStackTrace();
		}
		return businessActivityVoteOptions;
	}
	
	/**
	 * 无条件查询所有BusinessActivityVoteOptions
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessActivityVoteOptions> findAll() throws ServiceException {
		List<BusinessActivityVoteOptions> list = new ArrayList<BusinessActivityVoteOptions>() ;
		try {
			list=businessActivityVoteOptionsDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteOptionsServiceImpl findAll()：无条件查询所有BusinessActivityVoteOptions发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityVoteOptions
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityVoteOptions> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessActivityVoteOptions> list = new ArrayList<BusinessActivityVoteOptions>() ;
		try {
			list=businessActivityVoteOptionsDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteOptionsServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityVoteOptions发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityVoteOptions-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityVoteOptions> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessActivityVoteOptions> list = new ArrayList<BusinessActivityVoteOptions>() ;
		try {
			list=businessActivityVoteOptionsDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteOptionsServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityVoteOptions-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityVoteOptions
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityVoteOptions> findByExample(final BusinessActivityVoteOptionsQuery query) throws ServiceException {
		List<BusinessActivityVoteOptions> list = new ArrayList<BusinessActivityVoteOptions>() ;
		try {
			list=businessActivityVoteOptionsDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteOptionsServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityVoteOptions发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityVoteOptions-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityVoteOptions> findByExample(final BusinessActivityVoteOptionsQuery query, final Integer limit) throws ServiceException {
		List<BusinessActivityVoteOptions> list = new ArrayList<BusinessActivityVoteOptions>() ;
		try {
			list=businessActivityVoteOptionsDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteOptionsServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityVoteOptions-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessActivityVoteOptionsQuery query) throws ServiceException {
		List<BusinessActivityVoteOptions> list = new ArrayList<BusinessActivityVoteOptions>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessActivityVoteOptionsDao.selectCount(query);
			query.setCount(count);
			list=businessActivityVoteOptionsDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteOptionsServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setRows(query.getRows());
		baseBean.setPage(query.getPage());
		
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public int selectCount(final BusinessActivityVoteOptionsQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessActivityVoteOptionsDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteOptionsServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessActivityVoteOptions数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessActivityVoteOptions entity) throws ServiceException {
		try {
			businessActivityVoteOptionsDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteOptionsServiceImpl save()：保存BusinessActivityVoteOptions发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessActivityVoteOptions数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessActivityVoteOptions entity) throws ServiceException {
		try {
			businessActivityVoteOptionsDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteOptionsServiceImpl update()：修改BusinessActivityVoteOptions发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessActivityVoteOptions
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessActivityVoteOptionsDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityVoteOptionsServiceImpl delete()：删除BusinessActivityVoteOptions发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
