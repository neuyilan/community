package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessPrize;
import com.community.app.module.dao.BusinessPrizeDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessPrizeQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessPrizeService")
@Transactional
public class BusinessPrizeServiceImpl implements BusinessPrizeService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessPrizeServiceImpl.class);
	@Autowired
	private BusinessPrizeDao businessPrizeDao;

	/**
	 * 查询单个BusinessPrize
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessPrize findById(final Integer id) throws ServiceException {
		BusinessPrize businessPrize = new BusinessPrize();
		try {
			businessPrize = businessPrizeDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessPrizeServiceImpl findById()：查询单个BusinessPrize发生错误！", e);
			e.printStackTrace();
		}
		return businessPrize;
	}
	
	/**
	 * 无条件查询所有BusinessPrize
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessPrize> findAll() throws ServiceException {
		List<BusinessPrize> list = new ArrayList<BusinessPrize>() ;
		try {
			list=businessPrizeDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessPrizeServiceImpl findAll()：无条件查询所有BusinessPrize发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessPrize
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessPrize> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessPrize> list = new ArrayList<BusinessPrize>() ;
		try {
			list=businessPrizeDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessPrizeServiceImpl findByMap()：按Map对象条件查询所有BusinessPrize发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessPrize-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessPrize> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessPrize> list = new ArrayList<BusinessPrize>() ;
		try {
			list=businessPrizeDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessPrizeServiceImpl findByMap()：按Map对象条件查询所有BusinessPrize-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessPrize
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessPrize> findByExample(final BusinessPrizeQuery query) throws ServiceException {
		List<BusinessPrize> list = new ArrayList<BusinessPrize>() ;
		try {
			list=businessPrizeDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessPrizeServiceImpl findByExample()：按VO对象条件查询所有BusinessPrize发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessPrize-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessPrize> findByExample(final BusinessPrizeQuery query, final Integer limit) throws ServiceException {
		List<BusinessPrize> list = new ArrayList<BusinessPrize>() ;
		try {
			list=businessPrizeDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessPrizeServiceImpl findByExample()：按VO对象条件查询所有BusinessPrize-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessPrizeQuery query) throws ServiceException {
		List<BusinessPrize> list = new ArrayList<BusinessPrize>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessPrizeDao.findAllPage(query);
			count=businessPrizeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessPrizeServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessPrizeQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessPrizeDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessPrizeServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessPrize数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessPrize entity) throws ServiceException {
		try {
			businessPrizeDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessPrizeServiceImpl save()：保存BusinessPrize发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessPrize数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessPrize entity) throws ServiceException {
		try {
			businessPrizeDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessPrizeServiceImpl update()：修改BusinessPrize发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessPrize
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessPrizeDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessPrizeServiceImpl delete()：删除BusinessPrize发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
