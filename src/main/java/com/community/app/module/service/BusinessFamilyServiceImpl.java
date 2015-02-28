package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessFamily;
import com.community.app.module.dao.BusinessFamilyDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessFamilyQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessFamilyService")
@Transactional
public class BusinessFamilyServiceImpl implements BusinessFamilyService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessFamilyServiceImpl.class);
	@Autowired
	private BusinessFamilyDao businessFamilyDao;

	/**
	 * 查询单个BusinessFamily
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessFamily findById(final Integer id) throws ServiceException {
		BusinessFamily businessFamily = new BusinessFamily();
		try {
			businessFamily = businessFamilyDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyServiceImpl findById()：查询单个BusinessFamily发生错误！", e);
			e.printStackTrace();
		}
		return businessFamily;
	}
	
	/**
	 * 无条件查询所有BusinessFamily
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessFamily> findAll() throws ServiceException {
		List<BusinessFamily> list = new ArrayList<BusinessFamily>() ;
		try {
			list=businessFamilyDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessFamilyServiceImpl findAll()：无条件查询所有BusinessFamily发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFamily
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFamily> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessFamily> list = new ArrayList<BusinessFamily>() ;
		try {
			list=businessFamilyDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyServiceImpl findByMap()：按Map对象条件查询所有BusinessFamily发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFamily-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFamily> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessFamily> list = new ArrayList<BusinessFamily>() ;
		try {
			list=businessFamilyDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyServiceImpl findByMap()：按Map对象条件查询所有BusinessFamily-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFamily
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFamily> findByExample(final BusinessFamilyQuery query) throws ServiceException {
		List<BusinessFamily> list = new ArrayList<BusinessFamily>() ;
		try {
			list=businessFamilyDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyServiceImpl findByExample()：按VO对象条件查询所有BusinessFamily发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFamily-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFamily> findByExample(final BusinessFamilyQuery query, final Integer limit) throws ServiceException {
		List<BusinessFamily> list = new ArrayList<BusinessFamily>() ;
		try {
			list=businessFamilyDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyServiceImpl findByExample()：按VO对象条件查询所有BusinessFamily-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessFamilyQuery query) throws ServiceException {
		List<BusinessFamily> list = new ArrayList<BusinessFamily>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessFamilyDao.findAllPage(query);
			count=businessFamilyDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessFamilyQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessFamilyDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * service
	 * 保存家庭并新增家庭成员并返回家庭信息
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public BusinessFamily save(BusinessFamilyQuery entity) throws ServiceException {
		BusinessFamily businessFamily = null;
		try {
			businessFamily=businessFamilyDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyServiceImpl save()：保存BusinessFamily发生错误！", e);
			e.printStackTrace();
		}
		return businessFamily;
	}

	/**
	 * 修改BusinessFamily数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessFamily entity) throws ServiceException {
		try {
			businessFamilyDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyServiceImpl update()：修改BusinessFamily发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessFamily
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessFamilyDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyServiceImpl delete()：删除BusinessFamily发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 获取家庭信息和成员信息
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessFamilyQuery> getFamilyInfo(final Integer id) throws ServiceException{
		List<BusinessFamilyQuery> list = new ArrayList<BusinessFamilyQuery>() ;
		try {
			list=businessFamilyDao.getFamilyInfo(id);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyServiceImpl findByExample()：按VO对象条件查询所有BusinessFamily-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	

	/**
	 * service
	 * 获取家庭信息
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public BusinessFamily getFamilyInfoById(final Integer id) throws ServiceException{
		BusinessFamily BusinessFamily = new BusinessFamily() ;
		try {
			BusinessFamily=businessFamilyDao.getFamilyInfoById(id);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyServiceImpl findByExample()：按VO对象条件查询所有BusinessFamily-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return BusinessFamily;
	}

	
}
