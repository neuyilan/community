package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessImages;
import com.community.app.module.dao.BusinessImagesDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessImagesQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessImagesService")
@Transactional
public class BusinessImagesServiceImpl implements BusinessImagesService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessImagesServiceImpl.class);
	@Autowired
	private BusinessImagesDao businessImagesDao;

	/**
	 * 查询单个BusinessImages
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessImages findById(final Integer id) throws ServiceException {
		BusinessImages businessImages = new BusinessImages();
		try {
			businessImages = businessImagesDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessImagesServiceImpl findById()：查询单个BusinessImages发生错误！", e);
			e.printStackTrace();
		}
		return businessImages;
	}
	
	/**
	 * 无条件查询所有BusinessImages
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessImages> findAll() throws ServiceException {
		List<BusinessImages> list = new ArrayList<BusinessImages>() ;
		try {
			list=businessImagesDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessImagesServiceImpl findAll()：无条件查询所有BusinessImages发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessImages
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessImages> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessImages> list = new ArrayList<BusinessImages>() ;
		try {
			list=businessImagesDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessImagesServiceImpl findByMap()：按Map对象条件查询所有BusinessImages发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessImages-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessImages> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessImages> list = new ArrayList<BusinessImages>() ;
		try {
			list=businessImagesDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessImagesServiceImpl findByMap()：按Map对象条件查询所有BusinessImages-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessImages
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessImages> findByExample(final BusinessImagesQuery query) throws ServiceException {
		List<BusinessImages> list = new ArrayList<BusinessImages>() ;
		try {
			list=businessImagesDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessImagesServiceImpl findByExample()：按VO对象条件查询所有BusinessImages发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessImages-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessImages> findByExample(final BusinessImagesQuery query, final Integer limit) throws ServiceException {
		List<BusinessImages> list = new ArrayList<BusinessImages>() ;
		try {
			list=businessImagesDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessImagesServiceImpl findByExample()：按VO对象条件查询所有BusinessImages-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessImagesQuery query) throws ServiceException {
		List<BusinessImages> list = new ArrayList<BusinessImages>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessImagesDao.findAllPage(query);
			count=businessImagesDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessImagesServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessImagesQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessImagesDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessImagesServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessImages数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessImages entity) throws ServiceException {
		try {
			businessImagesDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessImagesServiceImpl save()：保存BusinessImages发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessImages数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessImages entity) throws ServiceException {
		try {
			businessImagesDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessImagesServiceImpl update()：修改BusinessImages发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessImages
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessImagesDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessImagesServiceImpl delete()：删除BusinessImages发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
}