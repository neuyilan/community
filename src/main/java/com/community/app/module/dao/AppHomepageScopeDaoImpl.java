package com.community.app.module.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppHomepageScope;
import com.community.framework.exception.DaoException;

@Repository("AppHomepageScope")
@Transactional
public class AppHomepageScopeDaoImpl implements AppHomepageScopeDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * 保存AppHomepageScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppHomepageScope entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppHomepageScopeDao.save",entity);
	}
	
	/**
	 * 删除AppHomepageScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppHomepageScopeDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
}