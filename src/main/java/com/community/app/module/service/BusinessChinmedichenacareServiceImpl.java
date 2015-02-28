package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessChinmedichenacare;
import com.community.app.module.dao.BusinessChinmedichenacareDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessChinmedichenacareQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessChinmedichenacareService")
@Transactional
public class BusinessChinmedichenacareServiceImpl implements BusinessChinmedichenacareService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessChinmedichenacareServiceImpl.class);
	@Autowired
	private BusinessChinmedichenacareDao businessChinmedichenacareDao;

	/**
	 * 查询单个BusinessChinmedichenacare
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessChinmedichenacare findById(final Integer id) throws ServiceException {
		BusinessChinmedichenacare businessChinmedichenacare = new BusinessChinmedichenacare();
		try {
			businessChinmedichenacare = businessChinmedichenacareDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareServiceImpl findById()：查询单个BusinessChinmedichenacare发生错误！", e);
			e.printStackTrace();
		}
		return businessChinmedichenacare;
	}
	
	/**
	 * 查询单个BusinessChinmedichenacare
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public BusinessChinmedichenacare findById_app(final Integer id) throws ServiceException {
		BusinessChinmedichenacare businessChinmedichenacare = new BusinessChinmedichenacare();
		try {
			businessChinmedichenacare = businessChinmedichenacareDao.findById_app(id);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareServiceImpl findById()：查询单个BusinessChinmedichenacare发生错误！", e);
			e.printStackTrace();
		}
		return businessChinmedichenacare;
	}
	
	/**
	 * 无条件查询所有BusinessChinmedichenacare
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessChinmedichenacare> findAll() throws ServiceException {
		List<BusinessChinmedichenacare> list = new ArrayList<BusinessChinmedichenacare>() ;
		try {
			list=businessChinmedichenacareDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareServiceImpl findAll()：无条件查询所有BusinessChinmedichenacare发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacare
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessChinmedichenacare> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessChinmedichenacare> list = new ArrayList<BusinessChinmedichenacare>() ;
		try {
			list=businessChinmedichenacareDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareServiceImpl findByMap()：按Map对象条件查询所有BusinessChinmedichenacare发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacare-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessChinmedichenacare> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessChinmedichenacare> list = new ArrayList<BusinessChinmedichenacare>() ;
		try {
			list=businessChinmedichenacareDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareServiceImpl findByMap()：按Map对象条件查询所有BusinessChinmedichenacare-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacare
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessChinmedichenacare> findByExample(final BusinessChinmedichenacareQuery query) throws ServiceException {
		List<BusinessChinmedichenacare> list = new ArrayList<BusinessChinmedichenacare>() ;
		try {
			list=businessChinmedichenacareDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareServiceImpl findByExample()：按VO对象条件查询所有BusinessChinmedichenacare发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacare-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessChinmedichenacare> findByExample(final BusinessChinmedichenacareQuery query, final Integer limit) throws ServiceException {
		List<BusinessChinmedichenacare> list = new ArrayList<BusinessChinmedichenacare>() ;
		try {
			list=businessChinmedichenacareDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareServiceImpl findByExample()：按VO对象条件查询所有BusinessChinmedichenacare-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessChinmedichenacareQuery query) throws ServiceException {
		List<BusinessChinmedichenacare> list = new ArrayList<BusinessChinmedichenacare>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessChinmedichenacareDao.selectCount(query);
			query.setCount(count);
			list=businessChinmedichenacareDao.findAllPage(query);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setPage(query.getPage());
		
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
	public BaseBean findAllPage_app(final BusinessChinmedichenacareQuery query) throws ServiceException {
		List<BusinessChinmedichenacare> list = new ArrayList<BusinessChinmedichenacare>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessChinmedichenacareDao.findAllPage_app(query);
			count=businessChinmedichenacareDao.selectCount_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessChinmedichenacareQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessChinmedichenacareDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessChinmedichenacare数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessChinmedichenacare entity) throws ServiceException {
		try {
			businessChinmedichenacareDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareServiceImpl save()：保存BusinessChinmedichenacare发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessChinmedichenacare数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessChinmedichenacare entity) throws ServiceException {
		try {
			businessChinmedichenacareDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareServiceImpl update()：修改BusinessChinmedichenacare发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessChinmedichenacare
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessChinmedichenacareDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessChinmedichenacareServiceImpl delete()：删除BusinessChinmedichenacare发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
