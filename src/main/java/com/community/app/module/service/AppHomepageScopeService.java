package com.community.app.module.service;

import com.community.app.module.bean.AppHomepageScope;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

public interface AppHomepageScopeService {

	/**
	 * 保存AppHomepageScope数据
	 * @param entity
	 * @throws ServiceException
	 */
	public void save(final AppHomepageScope entity) throws ServiceException;
	
	/**
	 * 删除AppHomepageScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
}