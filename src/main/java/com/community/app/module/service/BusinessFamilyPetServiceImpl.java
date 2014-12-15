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

import com.community.app.module.vo.BusinessFamilyPetQuery;
import com.community.app.module.bean.BusinessFamilyPet;
import com.community.app.module.dao.BusinessFamilyPetDao;

@Service("BusinessFamilyPetService")
@Transactional
public class BusinessFamilyPetServiceImpl implements BusinessFamilyPetService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessFamilyPetServiceImpl.class);
	@Autowired
	private BusinessFamilyPetDao businessFamilyPetDao;

	/**
	 * 查询单个BusinessFamilyPet
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessFamilyPet findById(final Integer id) throws ServiceException {
		BusinessFamilyPet businessFamilyPet = new BusinessFamilyPet();
		try {
			businessFamilyPet = businessFamilyPetDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyPetServiceImpl findById()：查询单个BusinessFamilyPet发生错误！", e);
			e.printStackTrace();
		}
		return businessFamilyPet;
	}
	
	/**
	 * 无条件查询所有BusinessFamilyPet
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessFamilyPet> findAll() throws ServiceException {
		List<BusinessFamilyPet> list = new ArrayList<BusinessFamilyPet>() ;
		try {
			list=businessFamilyPetDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessFamilyPetServiceImpl findAll()：无条件查询所有BusinessFamilyPet发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFamilyPet
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFamilyPet> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessFamilyPet> list = new ArrayList<BusinessFamilyPet>() ;
		try {
			list=businessFamilyPetDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyPetServiceImpl findByMap()：按Map对象条件查询所有BusinessFamilyPet发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFamilyPet-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFamilyPet> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessFamilyPet> list = new ArrayList<BusinessFamilyPet>() ;
		try {
			list=businessFamilyPetDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyPetServiceImpl findByMap()：按Map对象条件查询所有BusinessFamilyPet-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFamilyPet
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFamilyPet> findByExample(final BusinessFamilyPetQuery query) throws ServiceException {
		List<BusinessFamilyPet> list = new ArrayList<BusinessFamilyPet>() ;
		try {
			list=businessFamilyPetDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyPetServiceImpl findByExample()：按VO对象条件查询所有BusinessFamilyPet发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFamilyPet-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessFamilyPet> findByExample(final BusinessFamilyPetQuery query, final Integer limit) throws ServiceException {
		List<BusinessFamilyPet> list = new ArrayList<BusinessFamilyPet>() ;
		try {
			list=businessFamilyPetDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyPetServiceImpl findByExample()：按VO对象条件查询所有BusinessFamilyPet-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessFamilyPetQuery query) throws ServiceException {
		List<BusinessFamilyPet> list = new ArrayList<BusinessFamilyPet>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessFamilyPetDao.findAllPage(query);
			count=businessFamilyPetDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyPetServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessFamilyPetQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessFamilyPetDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyPetServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessFamilyPet数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessFamilyPet entity) throws ServiceException {
		try {
			businessFamilyPetDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyPetServiceImpl save()：保存BusinessFamilyPet发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessFamilyPet数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessFamilyPet entity) throws ServiceException {
		try {
			businessFamilyPetDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyPetServiceImpl update()：修改BusinessFamilyPet发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessFamilyPet
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessFamilyPetDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessFamilyPetServiceImpl delete()：删除BusinessFamilyPet发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
