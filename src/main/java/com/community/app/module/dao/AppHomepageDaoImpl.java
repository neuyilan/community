package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppHomepage;
import com.community.app.module.vo.AppHomepageQuery;
import com.community.framework.exception.DaoException;

@Repository("AppHomepageDao")
@Transactional
public class AppHomepageDaoImpl implements AppHomepageDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个AppHomepage
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppHomepage findById(final Integer id) throws DaoException {
		AppHomepage appHomepage = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppHomepageDao.findById",id);
		return appHomepage;
	}
	
	/**
	 * 无条件查询所有AppHomepage
	 * @return
	 * @throws DaoException
	 */
	public List<AppHomepage> findAll() throws DaoException {
		List<AppHomepage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppHomepageDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有AppHomepage
	 * @return
	 * @throws DaoException
	 */	
	public List<AppHomepage> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<AppHomepage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppHomepageDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppHomepage-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<AppHomepage> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<AppHomepage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppHomepageDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppHomepage
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppHomepage> findByExample(final AppHomepageQuery query) throws DaoException {
		List<AppHomepage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppHomepageDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppHomepage-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppHomepage> findByExample(final AppHomepageQuery query, final Integer limit) throws DaoException {
		List<AppHomepage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppHomepageDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppHomepage> findAllPage(final AppHomepageQuery query) throws DaoException {
		List<AppHomepage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppHomepageDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppHomepageQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppHomepageDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppHomepage> findAllPage_app(final AppHomepageQuery query) throws DaoException {
		List<AppHomepage> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppHomepageDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final AppHomepageQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppHomepageDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存AppHomepage数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppHomepage entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppHomepageDao.save",entity);
	}

	/**
	 * 修改AppHomepage数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppHomepage entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppHomepageDao.update",entity);
	}

	/**
	 * 删除AppHomepage
	 * @param entity
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final AppHomepage entity) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppHomepageDao.delete",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
}