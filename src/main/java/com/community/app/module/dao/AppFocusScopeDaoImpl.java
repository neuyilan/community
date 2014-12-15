package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppFocusScope;
import com.community.app.module.vo.AppFocusScopeQuery;
import com.community.framework.exception.DaoException;

@Repository("AppFocusScopeDao")
@Transactional
public class AppFocusScopeDaoImpl implements AppFocusScopeDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个AppFocusScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppFocusScope findById(final Integer id) throws DaoException {
		AppFocusScope appFocusScope = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppFocusScopeDao.findById",id);
		return appFocusScope;
	}
	
	/**
	 * 无条件查询所有AppFocusScope
	 * @return
	 * @throws DaoException
	 */
	public List<AppFocusScope> findAll() throws DaoException {
		List<AppFocusScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppFocusScopeDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有AppFocusScope
	 * @return
	 * @throws DaoException
	 */	
	public List<AppFocusScope> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<AppFocusScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppFocusScopeDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppFocusScope-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<AppFocusScope> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<AppFocusScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppFocusScopeDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有AppFocusScope
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppFocusScope> findByExample(final AppFocusScopeQuery query) throws DaoException {
		List<AppFocusScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppFocusScopeDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppFocusScope-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<AppFocusScope> findByExample(final AppFocusScopeQuery query, final Integer limit) throws DaoException {
		List<AppFocusScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppFocusScopeDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppFocusScope> findAllPage(final AppFocusScopeQuery query) throws DaoException {
		List<AppFocusScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppFocusScopeDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppFocusScopeQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppFocusScopeDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存AppFocusScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppFocusScope entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppFocusScopeDao.save",entity);
	}

	/**
	 * 修改AppFocusScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppFocusScope entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppFocusScopeDao.update",entity);
	}

	/**
	 * 删除AppFocusScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppFocusScopeDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
}