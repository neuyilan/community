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
import com.community.app.module.vo.BusinessAnnoQuery;
import com.community.app.module.bean.BusinessAnno;
import com.community.app.module.bean.index;
import com.community.app.module.common.ModuleConst;
import com.community.app.module.dao.BusinessAnnoDao;

@Service("BusinessAnnoService")
@Transactional
public class BusinessAnnoServiceImpl implements BusinessAnnoService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessAnnoServiceImpl.class);
	@Autowired
	private BusinessAnnoDao businessAnnoDao;

	/**
	 * 查询单个BusinessAnno
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessAnno findById(final Integer id) throws ServiceException {
		BusinessAnno businessAnno = new BusinessAnno();
		try {
			businessAnno = businessAnnoDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoServiceImpl findById()：查询单个BusinessAnno发生错误！", e);
			e.printStackTrace();
		}
		return businessAnno;
	}
	
	/**
	 * 查询单个BusinessAnno
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = false)
	public BusinessAnno findById_app(final Integer id) throws ServiceException {
		BusinessAnno businessAnno = new BusinessAnno();
		try {
			businessAnno = businessAnnoDao.findById_app(id);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoServiceImpl findById_app()：查询单个BusinessAnno发生错误！", e);
			e.printStackTrace();
		}
		return businessAnno;
	}
	
	/**
	 * 无条件查询所有BusinessAnno
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessAnno> findAll() throws ServiceException {
		List<BusinessAnno> list = new ArrayList<BusinessAnno>() ;
		try {
			list=businessAnnoDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessAnnoServiceImpl findAll()：无条件查询所有BusinessAnno发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessAnno
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessAnno> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessAnno> list = new ArrayList<BusinessAnno>() ;
		try {
			list=businessAnnoDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoServiceImpl findByMap()：按Map对象条件查询所有BusinessAnno发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessAnno-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessAnno> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessAnno> list = new ArrayList<BusinessAnno>() ;
		try {
			list=businessAnnoDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoServiceImpl findByMap()：按Map对象条件查询所有BusinessAnno-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessAnno
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessAnno> findByExample(final BusinessAnnoQuery query) throws ServiceException {
		List<BusinessAnno> list = new ArrayList<BusinessAnno>() ;
		try {
			list=businessAnnoDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoServiceImpl findByExample()：按VO对象条件查询所有BusinessAnno发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessAnno-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessAnno> findByExample(final BusinessAnnoQuery query, final Integer limit) throws ServiceException {
		List<BusinessAnno> list = new ArrayList<BusinessAnno>() ;
		try {
			list=businessAnnoDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoServiceImpl findByExample()：按VO对象条件查询所有BusinessAnno-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessAnnoQuery query) throws ServiceException {
		List<BusinessAnno> list = new ArrayList<BusinessAnno>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			if(query.getOrgType() != null 
					&& !"".equals(query.getOrgType())
					&& query.getOrgType().equals(ModuleConst.PROPERTY_CODE)) {
				count=businessAnnoDao.selectCountByProperty(query);
				query.setCount(list.size());
				list=businessAnnoDao.findAllPageByProperty(query);
			}else{
				count=businessAnnoDao.selectCount(query);	
				query.setCount(list.size());
				list=businessAnnoDao.findAllPage(query);
			}
			
		} catch (DaoException e) {
			logger.debug("BusinessAnnoServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		baseBean.setPage(query.getPage());
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage_app(final BusinessAnnoQuery query) throws ServiceException {
		List<BusinessAnno> list = new ArrayList<BusinessAnno>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessAnnoDao.selectCount_app(query);
			query.setCount(count);
			list=businessAnnoDao.findAllPage_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoServiceImpl findAllPage_app()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BaseBean findAllPage_index_app(final BusinessAnnoQuery query) throws ServiceException {
		List<index> list = new ArrayList<index>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessAnnoDao.selectCount_index_app(query);
			query.setCount(count);
			list=businessAnnoDao.findAllPage_index_app(query);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoServiceImpl findAllPage_index_app()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessAnnoQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessAnnoDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessAnno数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public Integer save(BusinessAnno entity) throws ServiceException {
		Integer id = 0;
		try {
			id = businessAnnoDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoServiceImpl save()：保存BusinessAnno发生错误！", e);
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * 修改BusinessAnno数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessAnno entity) throws ServiceException {
		try {
			businessAnnoDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoServiceImpl update()：修改BusinessAnno发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessAnno
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessAnnoDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoServiceImpl delete()：删除BusinessAnno发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 后台首页公告列表
	 * @param query
	 * @return
	 * @throws ServiceException
	 */
	public BaseBean findAllPageForIndex(final BusinessAnnoQuery query) throws ServiceException {
		List<BusinessAnno> list = new ArrayList<BusinessAnno>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			count=businessAnnoDao.selectCountForIndex(query);
			query.setCount(count);
			list=businessAnnoDao.findAllPageForIndex(query);
		} catch (DaoException e) {
			logger.debug("BusinessAnnoServiceImpl findAllPage_app()：根据搜索条件，搜索分页数据发生错误！", e);
			e.printStackTrace();
		}
		baseBean.setList(list);
		baseBean.setCount(count);
		return baseBean;
	}
	
}
