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

import com.community.app.module.vo.BusinessTelQuery;
import com.community.app.module.bean.BusinessTel;
import com.community.app.module.dao.BusinessTelDao;

@Service("BusinessTelService")
@Transactional
public class BusinessTelServiceImpl implements BusinessTelService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessTelServiceImpl.class);
	@Autowired
	private BusinessTelDao businessTelDao;

	/**
	 * 查询单个BusinessTel
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessTel findById(final Integer id) throws ServiceException {
		BusinessTel businessTel = new BusinessTel();
		try {
			businessTel = businessTelDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessTelServiceImpl findById()：查询单个BusinessTel发生错误！", e);
			e.printStackTrace();
		}
		return businessTel;
	}
	
	/**
	 * 无条件查询所有BusinessTel
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessTel> findAll() throws ServiceException {
		List<BusinessTel> list = new ArrayList<BusinessTel>() ;
		try {
			list=businessTelDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessTelServiceImpl findAll()：无条件查询所有BusinessTel发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessTel
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessTel> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessTel> list = new ArrayList<BusinessTel>() ;
		try {
			list=businessTelDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessTelServiceImpl findByMap()：按Map对象条件查询所有BusinessTel发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessTel-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessTel> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessTel> list = new ArrayList<BusinessTel>() ;
		try {
			list=businessTelDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessTelServiceImpl findByMap()：按Map对象条件查询所有BusinessTel-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessTel
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessTel> findByExample(final BusinessTelQuery query) throws ServiceException {
		List<BusinessTel> list = new ArrayList<BusinessTel>() ;
		try {
			list=businessTelDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessTelServiceImpl findByExample()：按VO对象条件查询所有BusinessTel发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessTel-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessTel> findByExample(final BusinessTelQuery query, final Integer limit) throws ServiceException {
		List<BusinessTel> list = new ArrayList<BusinessTel>() ;
		try {
			list=businessTelDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessTelServiceImpl findByExample()：按VO对象条件查询所有BusinessTel-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessTelQuery query) throws ServiceException {
		List<BusinessTel> list = new ArrayList<BusinessTel>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessTelDao.findAllPage(query);
			count=businessTelDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessTelServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessTelQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessTelDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessTelServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessTel数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessTel entity) throws ServiceException {
		try {
			businessTelDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessTelServiceImpl save()：保存BusinessTel发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessTel数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessTel entity) throws ServiceException {
		try {
			businessTelDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessTelServiceImpl update()：修改BusinessTel发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessTel
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessTelDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessTelServiceImpl delete()：删除BusinessTel发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
