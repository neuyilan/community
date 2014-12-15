package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.AppUserNews;
import com.community.app.module.vo.AppUserNewsQuery;

@Repository("AppUserNewsDao")
@Transactional
public class AppUserNewsDaoImpl implements AppUserNewsDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个AppUserNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppUserNews findById(final Integer id) throws DaoException {
		AppUserNews appUserNews = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppUserNewsDao.findById",id);
		return appUserNews;
	}
	
	/**
	 * 获取家庭申请id
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppUserNews findById_family_id(final Integer id) throws DaoException {
		AppUserNews appUserNews = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppUserNewsDao.findById_family_id",id);
		return appUserNews;
	}
	
	/**
	 * 无条件查询所有AppUserNews
	 * @return
	 * @throws DaoException
	 */
	public List<AppUserNews> findAll() throws DaoException {
		List<AppUserNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserNewsDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有AppUserNews
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserNews> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<AppUserNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserNewsDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppUserNews-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserNews> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<AppUserNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserNewsDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppUserNews
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserNews> findByExample(final AppUserNewsQuery query) throws DaoException {
		List<AppUserNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserNewsDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppUserNews-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserNews> findByExample(final AppUserNewsQuery query, final Integer limit) throws DaoException {
		List<AppUserNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserNewsDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppUserNews> findAllPage(final AppUserNewsQuery query) throws DaoException {
		List<AppUserNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserNewsDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppUserNewsQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppUserNewsDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存AppUserNews数据
	 * @param entity
	 * @return 
	 * @throws DaoException
	 */
	public AppUserNews save(final AppUserNews entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppUserNewsDao.save",entity);
		return entity;
	}
	
	/**
	 * 保存AppUserNews数据
	 * @param entity
	 * @throws DaoException
	 */
	public void saveReply(final AppUserNews entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppUserNewsDao.saveReply",entity);
	}

	/**
	 * 修改AppUserNews数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppUserNews entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppUserNewsDao.update",entity);
	}

	/**
	 * 删除AppUserNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppUserNewsDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 删除AppUserNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean deleteType(final AppUserNews entity) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppUserNewsDao.deleteType",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
