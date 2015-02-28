package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppVerify;
import com.community.app.module.vo.AppVerifyQuery;
import com.community.framework.exception.DaoException;

@Repository("AppVerifyDao")
@Transactional
public class AppVerifyDaoImpl implements AppVerifyDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个AppVerify
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppVerify findById(final Integer id) throws DaoException {
		AppVerify appVerify = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppVerifyDao.findById",id);
		return appVerify;
	}
	
	/**
	 * 无条件查询所有AppVerify
	 * @return
	 * @throws DaoException
	 */
	public List<AppVerify> findAll() throws DaoException {
		List<AppVerify> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppVerifyDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有AppVerify
	 * @return
	 * @throws DaoException
	 */	
	public List<AppVerify> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<AppVerify> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppVerifyDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppVerify-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<AppVerify> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<AppVerify> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppVerifyDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppVerify
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppVerify> findByExample(final AppVerifyQuery query) throws DaoException {
		List<AppVerify> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppVerifyDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppVerify-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppVerify> findByExample(final AppVerifyQuery query, final Integer limit) throws DaoException {
		List<AppVerify> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppVerifyDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppVerify> findAllPage(final AppVerifyQuery query) throws DaoException {
		List<AppVerify> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppVerifyDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppVerifyQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppVerifyDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存AppVerify数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppVerify entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppVerifyDao.save",entity);
	}

	/**
	 * 修改AppVerify数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppVerify entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppVerifyDao.update",entity);
	}

	/**
	 * 删除AppVerify
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final AppVerifyQuery query) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppVerifyDao.delete",query);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
