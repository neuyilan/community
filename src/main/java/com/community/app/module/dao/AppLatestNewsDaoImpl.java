package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.AppLatestNews;
import com.community.app.module.vo.AppLatestNewsQuery;

@Repository("AppLatestNewsDao")
@Transactional
public class AppLatestNewsDaoImpl implements AppLatestNewsDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个AppLatestNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppLatestNews findById(final Integer id) throws DaoException {
		AppLatestNews appLatestNews = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppLatestNewsDao.findById",id);
		return appLatestNews;
	}
	
	/**
	 * 无条件查询所有AppLatestNews
	 * @return
	 * @throws DaoException
	 */
	public List<AppLatestNews> findAll() throws DaoException {
		List<AppLatestNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppLatestNewsDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有AppLatestNews
	 * @return
	 * @throws DaoException
	 */	
	public List<AppLatestNews> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<AppLatestNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppLatestNewsDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppLatestNews-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<AppLatestNews> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<AppLatestNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppLatestNewsDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppLatestNews
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppLatestNews> findByExample(final AppLatestNewsQuery query) throws DaoException {
		List<AppLatestNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppLatestNewsDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppLatestNews-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppLatestNews> findByExample(final AppLatestNewsQuery query, final Integer limit) throws DaoException {
		List<AppLatestNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppLatestNewsDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppLatestNews> findAllPage(final AppLatestNewsQuery query) throws DaoException {
		List<AppLatestNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppLatestNewsDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppLatestNewsQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppLatestNewsDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppLatestNews> findAllPage_app(final AppLatestNewsQuery query) throws DaoException {
		List<AppLatestNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppLatestNewsDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final AppLatestNewsQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppLatestNewsDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存AppLatestNews数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppLatestNews entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppLatestNewsDao.save",entity);
	}
	
	/**
	 * 保存AppLatestNews数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save_app(final AppLatestNews entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppLatestNewsDao.save_app",entity);
	}

	/**
	 * 修改AppLatestNews数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppLatestNews entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppLatestNewsDao.update",entity);
	}

	/**
	 * 删除AppLatestNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppLatestNewsDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 按条件删除AppLatestNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean deleteByCondition(final AppLatestNewsQuery query) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppLatestNewsDao.deleteByCondition",query);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	

	/**
	 * 删除AppLatestNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete_app(final AppLatestNews entity) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppLatestNewsDao.delete_app",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 删除AppLatestNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete_app_id(final AppLatestNews entity) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppLatestNewsDao.delete_app_id",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
