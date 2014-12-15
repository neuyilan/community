package com.community.app.module.dao;

import org.springframework.stereotype.Repository;

import com.community.app.module.bean.AppHomepageScope;
import com.community.framework.exception.DaoException;

@Repository
public interface AppHomepageScopeDao {

	/**
	 * 保存AppHomepageScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppHomepageScope entity) throws DaoException;
	
	/**
	 * 删除AppHomepageScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException;
}