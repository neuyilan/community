package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessToken;
import com.community.app.module.dao.BusinessTokenDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessTokenQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessTokenService")
@Transactional
public class BusinessTokenServiceImpl implements BusinessTokenService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessTokenServiceImpl.class);
	@Autowired
	private BusinessTokenDao businessTokenDao;

	/**
	 * 查询单个BusinessToken
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessToken findById(final Integer id) throws ServiceException {
		BusinessToken businessToken = new BusinessToken();
		try {
			businessToken = businessTokenDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessTokenServiceImpl findById()：查询单个BusinessToken发生错误！", e);
			e.printStackTrace();
		}
		return businessToken;
	}
	
	/**
	 * 无条件查询所有BusinessToken
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessToken> findAll() throws ServiceException {
		List<BusinessToken> list = new ArrayList<BusinessToken>() ;
		try {
			list=businessTokenDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessTokenServiceImpl findAll()：无条件查询所有BusinessToken发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessToken
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessToken> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessToken> list = new ArrayList<BusinessToken>() ;
		try {
			list=businessTokenDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessTokenServiceImpl findByMap()：按Map对象条件查询所有BusinessToken发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessToken-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessToken> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessToken> list = new ArrayList<BusinessToken>() ;
		try {
			list=businessTokenDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessTokenServiceImpl findByMap()：按Map对象条件查询所有BusinessToken-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessToken
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessToken> findByExample(final BusinessTokenQuery query) throws ServiceException {
		List<BusinessToken> list = new ArrayList<BusinessToken>() ;
		try {
			list=businessTokenDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessTokenServiceImpl findByExample()：按VO对象条件查询所有BusinessToken发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessToken-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessToken> findByExample(final BusinessTokenQuery query, final Integer limit) throws ServiceException {
		List<BusinessToken> list = new ArrayList<BusinessToken>() ;
		try {
			list=businessTokenDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessTokenServiceImpl findByExample()：按VO对象条件查询所有BusinessToken-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessTokenQuery query) throws ServiceException {
		List<BusinessToken> list = new ArrayList<BusinessToken>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessTokenDao.findAllPage(query);
			count=businessTokenDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessTokenServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessTokenQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessTokenDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessTokenServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessToken数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessToken entity) throws ServiceException {
		try {
			businessTokenDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessTokenServiceImpl save()：保存BusinessToken发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessToken数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessToken entity) throws ServiceException {
		try {
			businessTokenDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessTokenServiceImpl update()：修改BusinessToken发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessToken
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessTokenDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessTokenServiceImpl delete()：删除BusinessToken发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
