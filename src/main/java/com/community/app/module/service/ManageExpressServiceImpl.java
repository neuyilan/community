package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.ManageExpress;
import com.community.app.module.dao.ManageExpressDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.ManageExpressQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("ManageExpressService")
@Transactional
public class ManageExpressServiceImpl implements ManageExpressService {
	
	private static Logger logger = LoggerFactory.getLogger(ManageExpressServiceImpl.class);
	@Autowired
	private ManageExpressDao manageExpressDao;

	/**
	 * 查询单个ManageExpress
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public ManageExpress findById(final Integer id) throws ServiceException {
		ManageExpress manageExpress = new ManageExpress();
		try {
			manageExpress = manageExpressDao.findById(id);
		} catch (DaoException e) {
			logger.debug("ManageExpressServiceImpl findById()：查询单个ManageExpress发生错误！", e);
			e.printStackTrace();
		}
		return manageExpress;
	}
	
	/**
	 * 无条件查询所有ManageExpress
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<ManageExpress> findAll() throws ServiceException {
		List<ManageExpress> list = new ArrayList<ManageExpress>() ;
		try {
			list=manageExpressDao.findAll();
		} catch (DaoException e) {
			logger.debug("ManageExpressServiceImpl findAll()：无条件查询所有ManageExpress发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageExpress
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageExpress> findByMap(final Map paramMap) throws ServiceException {
		List<ManageExpress> list = new ArrayList<ManageExpress>() ;
		try {
			list=manageExpressDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("ManageExpressServiceImpl findByMap()：按Map对象条件查询所有ManageExpress发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageExpress-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageExpress> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<ManageExpress> list = new ArrayList<ManageExpress>() ;
		try {
			list=manageExpressDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("ManageExpressServiceImpl findByMap()：按Map对象条件查询所有ManageExpress-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageExpress
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageExpress> findByExample(final ManageExpressQuery query) throws ServiceException {
		List<ManageExpress> list = new ArrayList<ManageExpress>() ;
		try {
			list=manageExpressDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("ManageExpressServiceImpl findByExample()：按VO对象条件查询所有ManageExpress发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageExpress
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<ManageExpress> findByExample_app(final ManageExpressQuery query) throws ServiceException {
		List<ManageExpress> list = new ArrayList<ManageExpress>() ;
		try {
			list=manageExpressDao.findByExample_app(query);
		} catch (DaoException e) {
			logger.debug("ManageExpressServiceImpl findByExample_app()：按VO对象条件查询所有ManageExpress发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageExpress-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<ManageExpress> findByExample(final ManageExpressQuery query, final Integer limit) throws ServiceException {
		List<ManageExpress> list = new ArrayList<ManageExpress>() ;
		try {
			list=manageExpressDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("ManageExpressServiceImpl findByExample()：按VO对象条件查询所有ManageExpress-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final ManageExpressQuery query) throws ServiceException {
		List<ManageExpress> list = new ArrayList<ManageExpress>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=manageExpressDao.findAllPage(query);
			count=manageExpressDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageExpressServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final ManageExpressQuery query) throws ServiceException {
		int count = 0;
		try {
			count = manageExpressDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("ManageExpressServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存ManageExpress数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(ManageExpress entity) throws ServiceException {
		try {
			manageExpressDao.save(entity);
		} catch (DaoException e) {
			logger.debug("ManageExpressServiceImpl save()：保存ManageExpress发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改ManageExpress数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(ManageExpress entity) throws ServiceException {
		try {
			manageExpressDao.update(entity);
		} catch (DaoException e) {
			logger.debug("ManageExpressServiceImpl update()：修改ManageExpress发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除ManageExpress
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return manageExpressDao.delete(id);
		} catch (DaoException e) {
			logger.debug("ManageExpressServiceImpl delete()：删除ManageExpress发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 按驿站查找快递公司
	 * @param stationId 驿站ID
	 * @return
	 * @throws ServiceException
	 */
	public List findExpressByStation(final Integer stationId) throws ServiceException{
		List<ManageExpress> list = new ArrayList<ManageExpress>() ;
		try {
			list=manageExpressDao.findExpressByStation(stationId);
		} catch (DaoException e) {
			logger.debug("ManageExpressServiceImpl findExpressByStation()：按驿站查找快递公司发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
}
