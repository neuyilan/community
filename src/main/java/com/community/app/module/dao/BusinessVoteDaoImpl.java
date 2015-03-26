package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessVote;
import com.community.app.module.vo.BusinessVoteQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessVoteDao")
@Transactional
public class BusinessVoteDaoImpl implements BusinessVoteDao {

	@Resource(name = "SqlSessionTemplate")
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessVote
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessVote findById(final Integer id) throws DaoException {
		BusinessVote businessVote = this.sqlSessionTemplate.selectOne(
				"com.community.app.module.dao.BusinessVoteDao.findById", id);
		return businessVote;
	}

	/**
	 * 无条件查询所有BusinessVote
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessVote> findAll() throws DaoException {
		List<BusinessVote> list = this.sqlSessionTemplate
				.selectList("com.community.app.module.dao.BusinessVoteDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessVote
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessVote> findByMap(final Map<String, Object> paramMap)
			throws DaoException {
		List<BusinessVote> list = this.sqlSessionTemplate
				.selectList(
						"com.community.app.module.dao.BusinessVoteDao.findByMap",
						paramMap);
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessVote-限制返回条数
	 * 
	 * @return
	 * @throws DaoException
	 */
	/*
	 * public List<BusinessVote> findByMap(final Map<String, Object> paramMap,
	 * final Integer limit) throws DaoException { List<BusinessVote> list =
	 * this.sqlSessionTemplate.selectList(
	 * "com.community.app.module.dao.BusinessVoteDao.findByMap", paramMap, limit);
	 * return list; }
	 */

	/**
	 * 按VO对象条件查询所有BusinessVote
	 * 
	 * @param entity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessVote> findByExample(final BusinessVoteQuery query)
			throws DaoException {
		List<BusinessVote> list = this.sqlSessionTemplate.selectList(
				"com.community.app.module.dao.BusinessVoteDao.findByExample",
				query);
		return list;
	}

	/**
	 * 按VO对象条件查询所有BusinessVote-限制返回条数
	 * 
	 * @param entity
	 * @return
	 * @throws DaoException
	 */
	/*
	 * public List<BusinessVote> findByExample(final BusinessVoteQuery query,
	 * final Integer limit) throws DaoException { List<BusinessVote> list =
	 * this.sqlSessionTemplate.selectList(
	 * "com.community.app.module.dao.BusinessVoteDao.findByExample", query, limit);
	 * return list; }
	 */

	/**
	 * 根据搜索条件，搜索分页数据
	 * 
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessVote> findAllPage(final BusinessVoteQuery query)
			throws DaoException {
		List<BusinessVote> list = this.sqlSessionTemplate.selectList(
				"com.community.app.module.dao.BusinessVoteDao.findAllPage", query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * 
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessVoteQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne(
				"com.community.app.module.dao.BusinessVoteDao.selectCount", query);
		return count;
	}

	/**
	 * 保存BusinessVote数据
	 * 
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessVote entity) throws DaoException {
		this.sqlSessionTemplate.insert(
				"com.community.app.module.dao.BusinessVoteDao.save", entity);
	}

	/**
	 * 修改BusinessVote数据
	 * 
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessVote entity) throws DaoException {
		this.sqlSessionTemplate.update(
				"com.community.app.module.dao.BusinessVoteDao.update", entity);
	}

	/**
	 * 删除BusinessVote
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count = this.sqlSessionTemplate.delete(
				"com.community.app.module.dao.BusinessVoteDao.delete", id);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}
}