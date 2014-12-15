package com.community.app.module.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppHomepageScope;
import com.community.app.module.dao.AppHomepageScopeDao;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Service("AppHomepageScopeService")
@Transactional
public class AppHomepageScopeServiceImpl implements AppHomepageScopeService {
	
	private static Logger logger = LoggerFactory.getLogger(AppHomepageScopeServiceImpl.class);
	@Autowired
	private AppHomepageScopeDao appHomepageScopeDao;
	
	/**
	 * 保存AppHomepageScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public void save(AppHomepageScope entity) throws ServiceException {
		try {
			appHomepageScopeDao.save(entity);
		} catch (DaoException e) {
			logger.debug("AppHomepageScopeServiceImpl save()：保存AppHomepageScope发生错误！", e);
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除AppHomepageScope
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	@Transactional("transactionManager")
	public boolean delete(Integer id) throws ServiceException {
		try {
			return appHomepageScopeDao.delete(id);
		} catch (DaoException e) {
			logger.debug("AppHomepageServiceImpl delete()：删除AppHomepageScope发生错误！", e);
			e.printStackTrace();
		}
		return false;
	}
}