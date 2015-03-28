package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessActReg;
import com.community.app.module.dao.BusinessActRegDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActRegQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessActRegService")
@Transactional
public class BusinessActRegServiceImpl implements BusinessActRegService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessActRegServiceImpl.class);
	@Autowired
	private BusinessActRegDao businessActRegDao;

	/**
	 * 查询单个BusinessActReg
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessActReg findById(final Integer id) throws ServiceException {
		BusinessActReg businessActReg = new BusinessActReg();
		try {
			businessActReg = businessActRegDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessActRegServiceImpl findById()：查询单个BusinessActReg发生错误！", e);
			e.printStackTrace();
		}
		return businessActReg;
	}
	
	/**
	 * 无条件查询所有BusinessActReg
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessActReg> findAll() throws ServiceException {
		List<BusinessActReg> list = new ArrayList<BusinessActReg>() ;
		try {
			list=businessActRegDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessActRegServiceImpl findAll()：无条件查询所有BusinessActReg发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActReg
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActReg> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessActReg> list = new ArrayList<BusinessActReg>() ;
		try {
			list=businessActRegDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessActRegServiceImpl findByMap()：按Map对象条件查询所有BusinessActReg发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActReg-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActReg> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessActReg> list = new ArrayList<BusinessActReg>() ;
		try {
			list=businessActRegDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActRegServiceImpl findByMap()：按Map对象条件查询所有BusinessActReg-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActReg
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActReg> findByExample(final BusinessActRegQuery query) throws ServiceException {
		List<BusinessActReg> list = new ArrayList<BusinessActReg>() ;
		try {
			list=businessActRegDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessActRegServiceImpl findByExample()：按VO对象条件查询所有BusinessActReg发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActReg
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActReg> findById_app(final BusinessActRegQuery query) throws ServiceException {
		List<BusinessActReg> list = new ArrayList<BusinessActReg>() ;
		try {
			list=businessActRegDao.findById_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessActRegServiceImpl findByExample()：按VO对象条件查询所有BusinessActReg发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActReg-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActReg> findByExample(final BusinessActRegQuery query, final Integer limit) throws ServiceException {
		List<BusinessActReg> list = new ArrayList<BusinessActReg>() ;
		try {
			list=businessActRegDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActRegServiceImpl findByExample()：按VO对象条件查询所有BusinessActReg-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessActRegQuery query) throws ServiceException {
		List<BusinessActReg> list = new ArrayList<BusinessActReg>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessActRegDao.findAllPage(query);
			count=businessActRegDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActRegServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessActRegQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessActRegDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActRegServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessActReg数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public int save(BusinessActReg entity) throws ServiceException {
		try {
			return businessActRegDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActRegServiceImpl save()：保存BusinessActReg发生错误！", e);
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 修改BusinessActReg数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessActReg entity) throws ServiceException {
		try {
			businessActRegDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActRegServiceImpl update()：修改BusinessActReg发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessActReg
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessActRegDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessActRegServiceImpl delete()：删除BusinessActReg发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	

	/**
	 * 计算当前选手前面有多少名 总数
	 * @param map
	 * @return
	 */
	public int cntFront(Map<String, Object> map) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return businessActRegDao.cntFront(map);
		} catch (DaoException e) {
			logger.debug("BusinessActRegServiceImpl cntFront()：计算当前选手前面有多少名 发生错误！", e);
			e.printStackTrace();
		}
		return 0;
	}


	/**
	 * 修改当前的选手的code
	 * @param map
	 * @return
	 */
	public void updateCode(Map<String, Object> map) throws ServiceException {
		try {
		    businessActRegDao.updateCode(map);
		} catch (DaoException e) {
			logger.debug("BusinessActRegServiceImpl cntFront()：修改当前的选手的code 发生错误！", e);
			e.printStackTrace();
		}
	}


	/**
	 * 查询报名排名
	 * @param map
	 * @return
	 */
	public BaseBean findRankPage(BusinessActRegQuery query) 
			throws ServiceException {
		List<BusinessActReg> list = new ArrayList<BusinessActReg>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessActRegDao.findRankPage(query);
			count=businessActRegDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActRegServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}

	/**
	 * 获取最新报名
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findLatestRegPage(BusinessActRegQuery query) throws ServiceException {
		List<BusinessActReg> list = new ArrayList<BusinessActReg>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessActRegDao.findLatestRegPage(query);
			count=businessActRegDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActRegServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}



	public void updateVotes(Map<String, Object> map) throws ServiceException {
		try {
		    businessActRegDao.updateVotes(map);
		} catch (DaoException e) {
			logger.debug("BusinessActRegServiceImpl cntFront()：修改当前的选手的code 发生错误！", e);
			e.printStackTrace();
		}		
	}
	
}
