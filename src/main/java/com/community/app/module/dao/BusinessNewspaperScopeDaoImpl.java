package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessNewspaperScope;
import com.community.app.module.vo.BusinessNewspaperScopeQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessNewspaperScopeDao")
@Transactional
public class BusinessNewspaperScopeDaoImpl implements BusinessNewspaperScopeDao {

	@Resource(name = "SqlSessionTemplate")
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessNewspaperScope
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNewspaperScope findById(final Integer id)
			throws DaoException {
		BusinessNewspaperScope businessNewspaperScope = this.sqlSessionTemplate
				.selectOne(
						"com.community.app.module.dao.BusinessNewspaperScopeDao.findById",
						id);
		return businessNewspaperScope;
	}

	/**
	 * 无条件查询所有BusinessNewspaperScope
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewspaperScope> findAll() throws DaoException {
		List<BusinessNewspaperScope> list = this.sqlSessionTemplate
				.selectList("com.community.app.module.dao.BusinessNewspaperScopeDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessNewspaperScope
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewspaperScope> findByMap(
			final Map<String, Object> paramMap) throws DaoException {
		List<BusinessNewspaperScope> list = this.sqlSessionTemplate
				.selectList(
						"com.community.app.module.dao.BusinessNewspaperScopeDao.findByMap",
						paramMap);
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessNewspaperScope-限制返回条数
	 * 
	 * @return
	 * @throws DaoException
	 */
	/*
	 * public List<BusinessNewspaperScope> findByMap(final Map<String, Object>
	 * paramMap, final Integer limit) throws DaoException {
	 * List<BusinessNewspaperScope> list = this.sqlSessionTemplate.selectList(
	 * "com.community.app.module.dao.BusinessNewspaperScopeDao.findByMap",
	 * paramMap, limit); return list; }
	 */

	/**
	 * 按VO对象条件查询所有BusinessNewspaperScope
	 * 
	 * @param entity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewspaperScope> findByExample(
			final BusinessNewspaperScopeQuery query) throws DaoException {
		List<BusinessNewspaperScope> list = this.sqlSessionTemplate
				.selectList(
						"com.community.app.module.dao.BusinessNewspaperScopeDao.findByExample",
						query);
		return list;
	}

	/**
	 * 按VO对象条件查询所有BusinessNewspaperScope-限制返回条数
	 * 
	 * @param entity
	 * @return
	 * @throws DaoException
	 */
	/*
	 * public List<BusinessNewspaperScope> findByExample(final
	 * BusinessNewspaperScopeQuery query, final Integer limit) throws
	 * DaoException { List<BusinessNewspaperScope> list =
	 * this.sqlSessionTemplate.selectList(
	 * "com.community.app.module.dao.BusinessNewspaperScopeDao.findByExample",
	 * query, limit); return list; }
	 */

	/**
	 * 根据搜索条件，搜索分页数据
	 * 
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewspaperScope> findAllPage(
			final BusinessNewspaperScopeQuery query) throws DaoException {
		List<BusinessNewspaperScope> list = this.sqlSessionTemplate
				.selectList(
						"com.community.app.module.dao.BusinessNewspaperScopeDao.findAllPage",
						query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * 
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessNewspaperScopeQuery query)
			throws DaoException {
		int count = this.sqlSessionTemplate
				.selectOne(
						"com.community.app.module.dao.BusinessNewspaperScopeDao.selectCount",
						query);
		return count;
	}

	/**
	 * 保存BusinessNewspaperScope数据
	 * 
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessNewspaperScope entity) throws DaoException {
		this.sqlSessionTemplate.insert(
				"com.community.app.module.dao.BusinessNewspaperScopeDao.save",
				entity);
	}

	/**
	 * 修改BusinessNewspaperScope数据
	 * 
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessNewspaperScope entity) throws DaoException {
		this.sqlSessionTemplate
				.update("com.community.app.module.dao.BusinessNewspaperScopeDao.update",
						entity);
	}

	/**
	 * 删除BusinessNewspaperScope
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count = this.sqlSessionTemplate
				.delete("com.community.app.module.dao.BusinessNewspaperScopeDao.delete",
						id);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}
}