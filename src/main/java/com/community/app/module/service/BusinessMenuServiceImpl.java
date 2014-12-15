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

import com.community.app.module.vo.BusinessMenuQuery;
import com.community.app.module.bean.BusinessMenu;
import com.community.app.module.dao.BusinessMenuDao;

@Service("BusinessMenuService")
@Transactional
public class BusinessMenuServiceImpl implements BusinessMenuService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessMenuServiceImpl.class);
	@Autowired
	private BusinessMenuDao businessMenuDao;

	/**
	 * 查询单个BusinessMenu
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessMenu findById(final Integer id) throws ServiceException {
		BusinessMenu businessMenu = new BusinessMenu();
		try {
			businessMenu = businessMenuDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessMenuServiceImpl findById()：查询单个BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
		return businessMenu;
	}
	
	/**
	 * 无条件查询所有BusinessMenu
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessMenu> findAll() throws ServiceException {
		List<BusinessMenu> list = new ArrayList<BusinessMenu>() ;
		try {
			list=businessMenuDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessMenuServiceImpl findAll()：无条件查询所有BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessMenu
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessMenu> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessMenu> list = new ArrayList<BusinessMenu>() ;
		try {
			list=businessMenuDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessMenuServiceImpl findByMap()：按Map对象条件查询所有BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessMenu-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessMenu> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessMenu> list = new ArrayList<BusinessMenu>() ;
		try {
			list=businessMenuDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessMenuServiceImpl findByMap()：按Map对象条件查询所有BusinessMenu-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessMenu
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessMenu> findByExample(final BusinessMenuQuery query) throws ServiceException {
		List<BusinessMenu> list = new ArrayList<BusinessMenu>() ;
		try {
			list=businessMenuDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessMenuServiceImpl findByExample()：按VO对象条件查询所有BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessMenu-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessMenu> findByExample(final BusinessMenuQuery query, final Integer limit) throws ServiceException {
		List<BusinessMenu> list = new ArrayList<BusinessMenu>() ;
		try {
			list=businessMenuDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessMenuServiceImpl findByExample()：按VO对象条件查询所有BusinessMenu-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessMenuQuery query) throws ServiceException {
		List<BusinessMenu> list = new ArrayList<BusinessMenu>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessMenuDao.findAllPage(query);
			count=businessMenuDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessMenuServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessMenuQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessMenuDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessMenuServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessMenu数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessMenu entity) throws ServiceException {
		try {
			businessMenuDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessMenuServiceImpl save()：保存BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessMenu数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessMenu entity) throws ServiceException {
		try {
			businessMenuDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessMenuServiceImpl update()：修改BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessMenu
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessMenuDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessMenuServiceImpl delete()：删除BusinessMenu发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 查找模块下的所有菜单
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<BusinessMenu> findMenuByModuleId(final Integer moduleId) throws ServiceException {
		List<BusinessMenu> list = new ArrayList<BusinessMenu>() ;
		try {
			list =  businessMenuDao.findMenuByModuleId(moduleId);
		} catch (DaoException e) {
			logger.debug("BusinessMenuServiceImpl findMenuByModuleId()：查找模块下的所有菜单发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	
}
