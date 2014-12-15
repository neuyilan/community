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

import com.community.app.module.vo.BusinessChargerQuery;
import com.community.app.module.bean.BusinessCharger;
import com.community.app.module.dao.BusinessChargerDao;

@Service("BusinessChargerService")
@Transactional
public class BusinessChargerServiceImpl implements BusinessChargerService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessChargerServiceImpl.class);
	@Autowired
	private BusinessChargerDao businessChargerDao;

	/**
	 * 查询单个BusinessCharger
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessCharger findById(final Integer id) throws ServiceException {
		BusinessCharger businessCharger = new BusinessCharger();
		try {
			businessCharger = businessChargerDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessChargerServiceImpl findById()：查询单个BusinessCharger发生错误！", e);
			e.printStackTrace();
		}
		return businessCharger;
	}
	
	/**
	 * 无条件查询所有BusinessCharger
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessCharger> findAll() throws ServiceException {
		List<BusinessCharger> list = new ArrayList<BusinessCharger>() ;
		try {
			list=businessChargerDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessChargerServiceImpl findAll()：无条件查询所有BusinessCharger发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessCharger
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessCharger> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessCharger> list = new ArrayList<BusinessCharger>() ;
		try {
			list=businessChargerDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessChargerServiceImpl findByMap()：按Map对象条件查询所有BusinessCharger发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessCharger-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessCharger> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessCharger> list = new ArrayList<BusinessCharger>() ;
		try {
			list=businessChargerDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessChargerServiceImpl findByMap()：按Map对象条件查询所有BusinessCharger-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessCharger
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessCharger> findByExample(final BusinessChargerQuery query) throws ServiceException {
		List<BusinessCharger> list = new ArrayList<BusinessCharger>() ;
		try {
			list=businessChargerDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessChargerServiceImpl findByExample()：按VO对象条件查询所有BusinessCharger发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessCharger-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessCharger> findByExample(final BusinessChargerQuery query, final Integer limit) throws ServiceException {
		List<BusinessCharger> list = new ArrayList<BusinessCharger>() ;
		try {
			list=businessChargerDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessChargerServiceImpl findByExample()：按VO对象条件查询所有BusinessCharger-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessChargerQuery query) throws ServiceException {
		List<BusinessCharger> list = new ArrayList<BusinessCharger>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessChargerDao.findAllPage(query);
			count=businessChargerDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessChargerServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessChargerQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessChargerDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessChargerServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessCharger数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessCharger entity) throws ServiceException {
		try {
			businessChargerDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessChargerServiceImpl save()：保存BusinessCharger发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessCharger数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessCharger entity) throws ServiceException {
		try {
			businessChargerDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessChargerServiceImpl update()：修改BusinessCharger发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessCharger
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessChargerDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessChargerServiceImpl delete()：删除BusinessCharger发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
    public void savelargeData(final List list) throws ServiceException {
        try {
            businessChargerDao.savelargeData(list);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
