package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppFocusAdScope;
import com.community.app.module.vo.AppFocusAdScopeQuery;
import com.community.framework.exception.DaoException;

@Repository("AppFocusAdScopeDao")
@Transactional
public class AppFocusAdScopeDaoImpl implements AppFocusAdScopeDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个AppFocusAdScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppFocusAdScope findById(final Integer id) throws DaoException {
		AppFocusAdScope AppFocusAdScope = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppFocusAdScopeDao.findById",id);
		return AppFocusAdScope;
	}
	
	/**
	 * 无条件查询所有AppFocusAdScope
	 * @return
	 * @throws DaoException
	 */
	public List<AppFocusAdScope> findAll() throws DaoException {
		List<AppFocusAdScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppFocusAdScopeDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有AppFocusAdScope
	 * @return
	 * @throws DaoException
	 */	
	public List<AppFocusAdScope> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<AppFocusAdScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppFocusAdScopeDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppFocusAdScope-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<AppFocusAdScope> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<AppFocusAdScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppFocusAdScopeDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有AppFocusAdScope
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppFocusAdScope> findByExample(final AppFocusAdScopeQuery query) throws DaoException {
		List<AppFocusAdScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppFocusAdScopeDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppFocusAdScope-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<AppFocusAdScope> findByExample(final AppFocusAdScopeQuery query, final Integer limit) throws DaoException {
		List<AppFocusAdScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppFocusAdScopeDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppFocusAdScope> findAllPage(final AppFocusAdScopeQuery query) throws DaoException {
		List<AppFocusAdScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppFocusAdScopeDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppFocusAdScopeQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppFocusAdScopeDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存AppFocusAdScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppFocusAdScope entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppFocusAdScopeDao.save",entity);
	}

	/**
	 * 修改AppFocusAdScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppFocusAdScope entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppFocusAdScopeDao.update",entity);
	}

	/**
	 * 删除AppFocusAdScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppFocusAdScopeDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
}