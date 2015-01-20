package com.community.app.module.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessActivityCoupon;
import com.community.app.module.dao.BusinessActivityCouponDao;
import com.community.app.module.vo.BaseBean;
import com.community.app.module.vo.BusinessActivityCouponQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("BusinessActivityCouponService")
@Transactional
public class BusinessActivityCouponServiceImpl implements BusinessActivityCouponService {
	
	private static Logger logger = LoggerFactory.getLogger(BusinessActivityCouponServiceImpl.class);
	@Autowired
	private BusinessActivityCouponDao businessActivityCouponDao;

	/**
	 * 查询单个BusinessActivityCoupon
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public BusinessActivityCoupon findById(final Integer id) throws ServiceException {
		BusinessActivityCoupon businessActivityCoupon = new BusinessActivityCoupon();
		try {
			businessActivityCoupon = businessActivityCouponDao.findById(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCouponServiceImpl findById()：查询单个BusinessActivityCoupon发生错误！", e);
			e.printStackTrace();
		}
		return businessActivityCoupon;
	}
	
	/**
	 * 无条件查询所有BusinessActivityCoupon
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = true)
	public List<BusinessActivityCoupon> findAll() throws ServiceException {
		List<BusinessActivityCoupon> list = new ArrayList<BusinessActivityCoupon>() ;
		try {
			list=businessActivityCouponDao.findAll();
		} catch (DaoException e) {
			logger.debug("BusinessActivityCouponServiceImpl findAll()：无条件查询所有BusinessActivityCoupon发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityCoupon
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityCoupon> findByMap(final Map paramMap) throws ServiceException {
		List<BusinessActivityCoupon> list = new ArrayList<BusinessActivityCoupon>() ;
		try {
			list=businessActivityCouponDao.findByMap(paramMap);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCouponServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityCoupon发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityCoupon-限制返回条数
	 * @param paramMap
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityCoupon> findByMap(final Map paramMap, final Integer limit) throws ServiceException {
		List<BusinessActivityCoupon> list = new ArrayList<BusinessActivityCoupon>() ;
		try {
			list=businessActivityCouponDao.findByMap(paramMap, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCouponServiceImpl findByMap()：按Map对象条件查询所有BusinessActivityCoupon-限制返回条数发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityCoupon
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	@Transactional(readOnly = true)
	public List<BusinessActivityCoupon> findByExample(final BusinessActivityCouponQuery query) throws ServiceException {
		List<BusinessActivityCoupon> list = new ArrayList<BusinessActivityCoupon>() ;
		try {
			list=businessActivityCouponDao.findByExample(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCouponServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityCoupon发生错误！", e);
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityCoupon-限制返回条数
	 * @param query
	 * @return
	 * @throws ServiceException
	 */	
	/*@Transactional(readOnly = true)
	public List<BusinessActivityCoupon> findByExample(final BusinessActivityCouponQuery query, final Integer limit) throws ServiceException {
		List<BusinessActivityCoupon> list = new ArrayList<BusinessActivityCoupon>() ;
		try {
			list=businessActivityCouponDao.findByExample(query, limit);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCouponServiceImpl findByExample()：按VO对象条件查询所有BusinessActivityCoupon-限制返回条数发生错误！", e);
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
	public BaseBean findAllPage(final BusinessActivityCouponQuery query) throws ServiceException {
		List<BusinessActivityCoupon> list = new ArrayList<BusinessActivityCoupon>() ;
		int count=0;
		BaseBean baseBean = new BaseBean();
		try {
			list=businessActivityCouponDao.findAllPage(query);
			count=businessActivityCouponDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCouponServiceImpl findAllPage()：根据搜索条件，搜索分页数据发生错误！", e);
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
	public int selectCount(final BusinessActivityCouponQuery query) throws ServiceException {
		int count = 0;
		try {
			count = businessActivityCouponDao.selectCount(query);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCouponServiceImpl selectCount()：根据搜索条件，搜索分页总数发生错误！", e);
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * 保存BusinessActivityCoupon数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(BusinessActivityCoupon entity) throws ServiceException {
		try {
			businessActivityCouponDao.save(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCouponServiceImpl save()：保存BusinessActivityCoupon发生错误！", e);
			e.printStackTrace();
		}
	}

	/**
	 * 修改BusinessActivityCoupon数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void update(BusinessActivityCoupon entity) throws ServiceException {
		try {
			businessActivityCouponDao.update(entity);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCouponServiceImpl update()：修改BusinessActivityCoupon发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除BusinessActivityCoupon
	 * @param entityId
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return businessActivityCouponDao.delete(id);
		} catch (DaoException e) {
			logger.debug("BusinessActivityCouponServiceImpl delete()：删除BusinessActivityCoupon发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
}