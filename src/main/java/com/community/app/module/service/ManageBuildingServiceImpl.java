package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.ManageBuilding;
import com.community.app.module.dao.ManageBuildingDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.ManageBuildingQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("ManageBuildingService")
@Transactional
public class ManageBuildingServiceImpl implements ManageBuildingService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageBuildingServiceImpl.class);
	@Autowired
	private ManageBuildingDao manageBuildingDao;

	/**
	 * 查询单个ManageBuilding
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public ManageBuilding findById(final Integer id) throws ServiceException {
		ManageBuilding manageBuilding = new ManageBuilding();
		try {
			manageBuilding = manageBuildingDao.findById(id);
		} catch (DaoException e) {
			logger.debug("ManageBuildingServiceImpl findById()：查询单个ManageBuilding发生错误！", e);
			e.printStackTrace();
		}
		return manageBuilding;
	}
	
	/**
	 * 无条件查询所有ManageBuilding
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageBuilding> findAll() throws ServiceException {
		List<ManageBuilding> list = new ArrayList<ManageBuilding>() ;
		try {
			list=manageBuildingDao.findAll();
		} catch (DaoException e) {
			logger.debug("ManageBuildingServiceImpl findAll()：无条件查询所有ManageBuilding发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageBuilding
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageBuilding> findByMap(final Map paramMap) throws ServiceException {
		List<ManageBuilding> list = new ArrayList<ManageBuilding>() ;
		try {
			list=manageBuildingDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("ManageBuildingServiceImpl findByMap()：按Map对象条件查询所有ManageBuilding发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageBuilding-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageBuilding> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<ManageBuilding> list = new ArrayList<ManageBuilding>() ;
		try {
			list=manageBuildingDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("ManageBuildingServiceImpl findByMap()：按Map对象条件查询所有ManageBuilding-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageBuilding
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageBuilding> findByExample(final ManageBuildingQuery query) throws ServiceException {
		List<ManageBuilding> list = new ArrayList<ManageBuilding>() ;
		try {
			list=manageBuildingDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("ManageBuildingServiceImpl findByExample()：按VO对象条件查询所有ManageBuilding发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageBuilding-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageBuilding> findByExample(final ManageBuildingQuery query, final Integer limit) throws ServiceException {
		List<ManageBuilding> list = new ArrayList<ManageBuilding>() ;
		try {
			list=manageBuildingDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("ManageBuildingServiceImpl findByExample()：按VO对象条件查询所有ManageBuilding-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final ManageBuildingQuery query) throws ServiceException {
		List<ManageBuilding> list = new ArrayList<ManageBuilding>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=manageBuildingDao.findAllPage(query);
			count=manageBuildingDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageBuildingServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final ManageBuildingQuery query) throws ServiceException {
		int count = 0;
		try {
			count = manageBuildingDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageBuildingServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存ManageBuilding数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(ManageBuilding entity) throws ServiceException {
		try {
			manageBuildingDao.save(entity);
		} catch (DaoException e) {
			logger.debug("ManageBuildingServiceImpl save()：保存ManageBuilding发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改ManageBuilding数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(ManageBuilding entity) throws ServiceException {
		try {
			manageBuildingDao.update(entity);
		} catch (DaoException e) {
			logger.debug("ManageBuildingServiceImpl update()：修改ManageBuilding发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除ManageBuilding
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return manageBuildingDao.delete(id);
		} catch (DaoException e) {
			logger.debug("ManageBuildingServiceImpl delete()：删除ManageBuilding发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
