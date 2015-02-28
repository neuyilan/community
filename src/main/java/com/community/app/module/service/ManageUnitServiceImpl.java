package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.ManageUnit;
import com.community.app.module.dao.ManageUnitDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.ManageUnitQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("ManageUnitService")
@Transactional
public class ManageUnitServiceImpl implements ManageUnitService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageUnitServiceImpl.class);
	@Autowired
	private ManageUnitDao manageUnitDao;

	/**
	 * 查询单个ManageUnit
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public ManageUnit findById(final Integer id) throws ServiceException {
		ManageUnit manageUnit = new ManageUnit();
		try {
			manageUnit = manageUnitDao.findById(id);
		} catch (DaoException e) {
			logger.debug("ManageUnitServiceImpl findById()：查询单个ManageUnit发生错误！", e);
			e.printStackTrace();
		}
		return manageUnit;
	}
	
	/**
	 * 无条件查询所有ManageUnit
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageUnit> findAll() throws ServiceException {
		List<ManageUnit> list = new ArrayList<ManageUnit>() ;
		try {
			list=manageUnitDao.findAll();
		} catch (DaoException e) {
			logger.debug("ManageUnitServiceImpl findAll()：无条件查询所有ManageUnit发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageUnit
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageUnit> findByMap(final Map paramMap) throws ServiceException {
		List<ManageUnit> list = new ArrayList<ManageUnit>() ;
		try {
			list=manageUnitDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("ManageUnitServiceImpl findByMap()：按Map对象条件查询所有ManageUnit发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageUnit-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageUnit> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<ManageUnit> list = new ArrayList<ManageUnit>() ;
		try {
			list=manageUnitDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("ManageUnitServiceImpl findByMap()：按Map对象条件查询所有ManageUnit-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageUnit
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageUnit> findByExample(final ManageUnitQuery query) throws ServiceException {
		List<ManageUnit> list = new ArrayList<ManageUnit>() ;
		try {
			list=manageUnitDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("ManageUnitServiceImpl findByExample()：按VO对象条件查询所有ManageUnit发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageUnit-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageUnit> findByExample(final ManageUnitQuery query, final Integer limit) throws ServiceException {
		List<ManageUnit> list = new ArrayList<ManageUnit>() ;
		try {
			list=manageUnitDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("ManageUnitServiceImpl findByExample()：按VO对象条件查询所有ManageUnit-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final ManageUnitQuery query) throws ServiceException {
		List<ManageUnit> list = new ArrayList<ManageUnit>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=manageUnitDao.findAllPage(query);
			count=manageUnitDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageUnitServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final ManageUnitQuery query) throws ServiceException {
		int count = 0;
		try {
			count = manageUnitDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageUnitServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存ManageUnit数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(ManageUnit entity) throws ServiceException {
		try {
			manageUnitDao.save(entity);
		} catch (DaoException e) {
			logger.debug("ManageUnitServiceImpl save()：保存ManageUnit发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改ManageUnit数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(ManageUnit entity) throws ServiceException {
		try {
			manageUnitDao.update(entity);
		} catch (DaoException e) {
			logger.debug("ManageUnitServiceImpl update()：修改ManageUnit发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除ManageUnit
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return manageUnitDao.delete(id);
		} catch (DaoException e) {
			logger.debug("ManageUnitServiceImpl delete()：删除ManageUnit发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	

	/**
	 * 根据小区id查询小区下的全部单元
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageUnit> getUnitByEstateId(final Integer id) throws ServiceException{
		List<ManageUnit> list = new ArrayList<ManageUnit>() ;
		try {
			list=manageUnitDao.getUnitByEstateId(id);
		} catch (DaoException e) {
			logger.debug("ManageUnitServiceImpl findByExample()：按VO对象条件查询所有ManageUnit发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
}
