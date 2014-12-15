package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.AppUserConfig;
import com.community.app.module.vo.AppUserConfigQuery;

@Repository("AppUserConfigDao")
@Transactional
public class AppUserConfigDaoImpl implements AppUserConfigDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个AppUserConfig
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppUserConfig findById(final Integer id) throws DaoException {
		AppUserConfig appUserConfig = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppUserConfigDao.findById",id);
		return appUserConfig;
	}
	
	/**
	 * 无条件查询所有AppUserConfig
	 * @return
	 * @throws DaoException
	 */
	public List<AppUserConfig> findAll() throws DaoException {
		List<AppUserConfig> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserConfigDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有AppUserConfig
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserConfig> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<AppUserConfig> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserConfigDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppUserConfig-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserConfig> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<AppUserConfig> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserConfigDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppUserConfig
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserConfig> findByExample(final AppUserConfigQuery query) throws DaoException {
		List<AppUserConfig> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserConfigDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppUserConfig
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserConfig> findByExample_app(final AppUserConfigQuery query) throws DaoException {
		List<AppUserConfig> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserConfigDao.findByExample_app", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppUserConfig-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppUserConfig> findByExample(final AppUserConfigQuery query, final Integer limit) throws DaoException {
		List<AppUserConfig> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserConfigDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppUserConfig> findAllPage(final AppUserConfigQuery query) throws DaoException {
		List<AppUserConfig> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppUserConfigDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppUserConfigQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppUserConfigDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存AppUserConfig数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppUserConfig entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppUserConfigDao.save",entity);
	}

	/**
	 * 修改AppUserConfig数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppUserConfig entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppUserConfigDao.update",entity);
	}

	/**
	 * 删除AppUserConfig
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppUserConfigDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
