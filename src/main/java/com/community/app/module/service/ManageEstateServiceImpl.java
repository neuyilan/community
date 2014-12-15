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
import com.community.app.module.vo.ManageEstateQuery;
import com.community.app.module.bean.ManageEstate;
import com.community.app.module.dao.ManageEstateDao;

@Service("ManageEstateService")
@Transactional
public class ManageEstateServiceImpl implements ManageEstateService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageEstateServiceImpl.class);
	@Autowired
	private ManageEstateDao manageEstateDao;

	/**
	 * 查询单个ManageEstate
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public ManageEstate findById(final Integer id) throws ServiceException {
		ManageEstate manageEstate = new ManageEstate();
		try {
			manageEstate = manageEstateDao.findById(id);
		} catch (DaoException e) {
			logger.debug("ManageEstateServiceImpl findById()：查询单个ManageEstate发生错误！", e);
			e.printStackTrace();
		}
		return manageEstate;
	}
	
	/**
	 * 根据id小区周边
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageEstateQuery> findByEstateAmbitus(ManageEstateQuery query) throws ServiceException {
		List<ManageEstateQuery> list = new ArrayList<ManageEstateQuery>() ;
		try {
			list=manageEstateDao.findByEstateAmbitus(query);
		} catch (DaoException e) {
			logger.debug("ManageEstateServiceImpl findByEstateAmbitus：根据id小区周边发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 根据小区id查询小区周边公交站
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageEstateQuery> findByEstateBus(final Integer id) throws ServiceException {
		List<ManageEstateQuery> list = new ArrayList<ManageEstateQuery>() ;
		try {
			list=manageEstateDao.findByEstateBus(id);
		} catch (DaoException e) {
			logger.debug("ManageEstateServiceImpl findByEstateBus：根据小区id查询小区周边公交站发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 无条件查询所有ManageEstate
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageEstate> findAll() throws ServiceException {
		List<ManageEstate> list = new ArrayList<ManageEstate>() ;
		try {
			list=manageEstateDao.findAll();
		} catch (DaoException e) {
			logger.debug("ManageEstateServiceImpl findAll()：无条件查询所有ManageEstate发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageEstate
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageEstate> findByMap(final Map paramMap) throws ServiceException {
		List<ManageEstate> list = new ArrayList<ManageEstate>() ;
		try {
			list=manageEstateDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("ManageEstateServiceImpl findByMap()：按Map对象条件查询所有ManageEstate发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageEstate-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageEstate> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<ManageEstate> list = new ArrayList<ManageEstate>() ;
		try {
			list=manageEstateDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("ManageEstateServiceImpl findByMap()：按Map对象条件查询所有ManageEstate-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageEstate
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageEstate> findByExample(final ManageEstateQuery query) throws ServiceException {
		List<ManageEstate> list = new ArrayList<ManageEstate>() ;
		try {
			list=manageEstateDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("ManageEstateServiceImpl findByExample()：按VO对象条件查询所有ManageEstate发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageEstate-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageEstate> findByExample(final ManageEstateQuery query, final Integer limit) throws ServiceException {
		List<ManageEstate> list = new ArrayList<ManageEstate>() ;
		try {
			list=manageEstateDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("ManageEstateServiceImpl findByExample()：按VO对象条件查询所有ManageEstate-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage(final ManageEstateQuery query) throws ServiceException {
		List<ManageEstate> list = new ArrayList<ManageEstate>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=manageEstateDao.findAllPage(query);
			count=manageEstateDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageEstateServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final ManageEstateQuery query) throws ServiceException {
		int count = 0;
		try {
			count = manageEstateDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageEstateServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存ManageEstate数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(ManageEstate entity) throws ServiceException {
		try {
			manageEstateDao.save(entity);
		} catch (DaoException e) {
			logger.debug("ManageEstateServiceImpl save()：保存ManageEstate发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改ManageEstate数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(ManageEstate entity) throws ServiceException {
		try {
			manageEstateDao.update(entity);
		} catch (DaoException e) {
			logger.debug("ManageEstateServiceImpl update()：修改ManageEstate发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除ManageEstate
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return manageEstateDao.delete(id);
		} catch (DaoException e) {
			logger.debug("ManageEstateServiceImpl delete()：删除ManageEstate发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	

	/**
	 * 根据名称模糊查询所有ManageEstate
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageEstate> search(final ManageEstateQuery query) throws ServiceException{
		List<ManageEstate> list = new ArrayList<ManageEstate>() ;
		try {
			list=manageEstateDao.search(query);
		} catch (DaoException e) {
			logger.debug("ManageEstateServiceImpl search：根据名称模糊查询所有ManageEstate发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
}
