package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessAddress;
import com.community.app.module.vo.BusinessAddressQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessAddressDao")
@Transactional
public class BusinessAddressDaoImpl implements BusinessAddressDao {

	@Resource(name = "SqlSessionTemplate")
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessAddress
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessAddress findById(final Integer id) throws DaoException {
		BusinessAddress businessAddress = this.sqlSessionTemplate.selectOne(
				"com.community.app.module.dao.BusinessAddressDao.findById", id);
		return businessAddress;
	}

	/**
	 * 无条件查询所有BusinessAddress
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAddress> findAll() throws DaoException {
		List<BusinessAddress> list = this.sqlSessionTemplate
				.selectList("com.community.app.module.dao.BusinessAddressDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessAddress
	 * 
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAddress> findByMap(final Map<String, Object> paramMap)
			throws DaoException {
		List<BusinessAddress> list = this.sqlSessionTemplate.selectList(
				"com.community.app.module.dao.BusinessAddressDao.findByMap",
				paramMap);
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessAddress-限制返回条数
	 * 
	 * @return
	 * @throws DaoException
	 */
	/*
	 * public List<BusinessAddress> findByMap(final Map<String, Object>
	 * paramMap, final Integer limit) throws DaoException {
	 * List<BusinessAddress> list = this.sqlSessionTemplate.selectList(
	 * "com.community.app.module.dao.BusinessAddressDao.findByMap", paramMap,
	 * limit); return list; }
	 */

	/**
	 * 按VO对象条件查询所有BusinessAddress
	 * 
	 * @param entity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAddress> findByExample(final BusinessAddressQuery query)
			throws DaoException {
		List<BusinessAddress> list = this.sqlSessionTemplate.selectList(
				"com.community.app.module.dao.BusinessAddressDao.findByExample",
				query);
		return list;
	}

	/**
	 * 按VO对象条件查询所有BusinessAddress-限制返回条数
	 * 
	 * @param entity
	 * @return
	 * @throws DaoException
	 */
	/*
	 * public List<BusinessAddress> findByExample(final BusinessAddressQuery
	 * query, final Integer limit) throws DaoException { List<BusinessAddress>
	 * list = this.sqlSessionTemplate.selectList(
	 * "com.community.app.module.dao.BusinessAddressDao.findByExample", query,
	 * limit); return list; }
	 */

	/**
	 * 根据搜索条件，搜索分页数据
	 * 
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAddress> findAllPage(final BusinessAddressQuery query)
			throws DaoException {
		List<BusinessAddress> list = this.sqlSessionTemplate.selectList(
				"com.community.app.module.dao.BusinessAddressDao.findAllPage",
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
	public int selectCount(final BusinessAddressQuery query)
			throws DaoException {
		int count = this.sqlSessionTemplate.selectOne(
				"com.community.app.module.dao.BusinessAddressDao.selectCount",
				query);
		return count;
	}

	/**
	 * 保存BusinessAddress数据
	 * 
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessAddress entity) throws DaoException {
		this.sqlSessionTemplate.insert(
				"com.community.app.module.dao.BusinessAddressDao.save", entity);
	}

	/**
	 * 修改BusinessAddress数据
	 * 
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessAddress entity) throws DaoException {
		this.sqlSessionTemplate.update(
				"com.community.app.module.dao.BusinessAddressDao.update", entity);
	}

	/**
	 * 删除BusinessAddress
	 * 
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count = this.sqlSessionTemplate.delete(
				"com.community.app.module.dao.BusinessAddressDao.delete", id);
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}
}