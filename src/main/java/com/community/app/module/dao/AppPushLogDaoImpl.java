package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppPushLog;
import com.community.app.module.vo.AppPushLogQuery;
import com.community.framework.exception.DaoException;

@Repository("AppPushLogDao")
@Transactional
public class AppPushLogDaoImpl implements AppPushLogDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个AppPushLog
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppPushLog findById(final Integer id) throws DaoException {
		AppPushLog appPushLog = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppPushLogDao.findById",id);
		return appPushLog;
	}
	
	/**
	 * 无条件查询所有AppPushLog
	 * @return
	 * @throws DaoException
	 */
	public List<AppPushLog> findAll() throws DaoException {
		List<AppPushLog> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppPushLogDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有AppPushLog
	 * @return
	 * @throws DaoException
	 */	
	public List<AppPushLog> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<AppPushLog> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppPushLogDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppPushLog-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<AppPushLog> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<AppPushLog> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppPushLogDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有AppPushLog
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppPushLog> findByExample(final AppPushLogQuery query) throws DaoException {
		List<AppPushLog> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppPushLogDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppPushLog-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<AppPushLog> findByExample(final AppPushLogQuery query, final Integer limit) throws DaoException {
		List<AppPushLog> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppPushLogDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppPushLog> findAllPage(final AppPushLogQuery query) throws DaoException {
		List<AppPushLog> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppPushLogDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppPushLogQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppPushLogDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存AppPushLog数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppPushLog entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppPushLogDao.save",entity);
	}

	/**
	 * 修改AppPushLog数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppPushLog entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppPushLogDao.update",entity);
	}

	/**
	 * 删除AppPushLog
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppPushLogDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
