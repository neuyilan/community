package com.community.app.module.dao;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.ManageOrg;
import com.community.app.module.vo.ManageOrgQuery;
import com.community.framework.exception.DaoException;

@Repository("ManageOrgDao")
@Transactional
public class ManageOrgDaoImpl implements ManageOrgDao{
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个ManageOrg
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageOrg findById(final Integer id) throws DaoException {
		ManageOrg manageOrg = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageOrgDao.findById",id);
		return manageOrg;
	}
	
	/**
	 * 无条件查询所有ManageOrg
	 * @return
	 * @throws DaoException
	 */
	public List<ManageOrg> findAll() throws DaoException {
		List<ManageOrg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageOrgDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageOrg
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageOrg> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<ManageOrg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageOrgDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageOrg-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageOrg> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<ManageOrg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageOrgDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageOrg
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageOrg> findByExample(final ManageOrgQuery query) throws DaoException {
		List<ManageOrg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageOrgDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageOrg-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageOrg> findByExample(final ManageOrgQuery query, final Integer limit) throws DaoException {
		List<ManageOrg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageOrgDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageOrg> findAllPage(final ManageOrgQuery query) throws DaoException {
		List<ManageOrg> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageOrgDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageOrgQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageOrgDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存ManageOrg数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageOrg entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.ManageOrgDao.save",entity);
	}

	/**
	 * 修改ManageOrg数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageOrg entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.ManageOrgDao.update",entity);
	}

	/**
	 * 删除ManageOrg
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.ManageOrgDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
