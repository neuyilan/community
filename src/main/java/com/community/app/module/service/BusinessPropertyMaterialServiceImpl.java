package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessPropertyMaterial;
import com.community.app.module.dao.BusinessPropertyMaterialDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessPropertyMaterialQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessPropertyMaterialService")
@Transactional
public class BusinessPropertyMaterialServiceImpl implements BusinessPropertyMaterialService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessPropertyMaterialServiceImpl.class);
	@Autowired
	private BusinessPropertyMaterialDao businessPropertyMaterialDao;

	/**
	 * 查询单个BusinessPropertyMaterial
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessPropertyMaterial findById(final Integer id) throws ServiceException {
		BusinessPropertyMaterial businessPropertyMaterial = new BusinessPropertyMaterial();
		try {
			businessPropertyMaterial = businessPropertyMaterialDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyMaterialServiceImpl findById()：查询单个BusinessPropertyMaterial发生错误！", e);
			e.printStackTrace();
		}
		return businessPropertyMaterial;
	}
	
	/**
	 * 无条件查询所有BusinessPropertyMaterial
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessPropertyMaterial> findAll() throws ServiceException {
		List<BusinessPropertyMaterial> list = new ArrayList<BusinessPropertyMaterial>() ;
		try {
			list=businessPropertyMaterialDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessPropertyMaterialServiceImpl findAll()：无条件查询所有BusinessPropertyMaterial发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessPropertyMaterial
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessPropertyMaterial> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessPropertyMaterial> list = new ArrayList<BusinessPropertyMaterial>() ;
		try {
			list=businessPropertyMaterialDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyMaterialServiceImpl findByMap()：按Map对象条件查询所有BusinessPropertyMaterial发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessPropertyMaterial-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessPropertyMaterial> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessPropertyMaterial> list = new ArrayList<BusinessPropertyMaterial>() ;
		try {
			list=businessPropertyMaterialDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyMaterialServiceImpl findByMap()：按Map对象条件查询所有BusinessPropertyMaterial-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessPropertyMaterial
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessPropertyMaterial> findByExample(final BusinessPropertyMaterialQuery query) throws ServiceException {
		List<BusinessPropertyMaterial> list = new ArrayList<BusinessPropertyMaterial>() ;
		try {
			list=businessPropertyMaterialDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyMaterialServiceImpl findByExample()：按VO对象条件查询所有BusinessPropertyMaterial发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessPropertyMaterial-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessPropertyMaterial> findByExample(final BusinessPropertyMaterialQuery query, final Integer limit) throws ServiceException {
		List<BusinessPropertyMaterial> list = new ArrayList<BusinessPropertyMaterial>() ;
		try {
			list=businessPropertyMaterialDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyMaterialServiceImpl findByExample()：按VO对象条件查询所有BusinessPropertyMaterial-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessPropertyMaterialQuery query) throws ServiceException {
		List<BusinessPropertyMaterial> list = new ArrayList<BusinessPropertyMaterial>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessPropertyMaterialDao.findAllPage(query);
			count=businessPropertyMaterialDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyMaterialServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessPropertyMaterialQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessPropertyMaterialDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyMaterialServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessPropertyMaterial数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessPropertyMaterial entity) throws ServiceException {
		try {
			businessPropertyMaterialDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyMaterialServiceImpl save()：保存BusinessPropertyMaterial发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessPropertyMaterial数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessPropertyMaterial entity) throws ServiceException {
		try {
			businessPropertyMaterialDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyMaterialServiceImpl update()：修改BusinessPropertyMaterial发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessPropertyMaterial
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessPropertyMaterialDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessPropertyMaterialServiceImpl delete()：删除BusinessPropertyMaterial发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
}
