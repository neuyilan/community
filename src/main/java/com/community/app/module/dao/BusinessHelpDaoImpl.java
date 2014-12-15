package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import com.community.framework.exception.DaoException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessHelp;
import com.community.app.module.vo.BusinessHelpQuery;

@Repository("BusinessHelpDao")
@Transactional
public class BusinessHelpDaoImpl implements BusinessHelpDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessHelp
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHelp findById(final Integer id) throws DaoException {
		BusinessHelp businessHelp = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpDao.findById",id);
		return businessHelp;
	}
	
	/**
	 * 查询单个BusinessHelp
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHelp findById_app(final Integer id) throws DaoException {
		BusinessHelp businessHelp = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpDao.findById_app",id);
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHelpDao.updateVisits",id);
		return businessHelp;
	}
	
	/**
	 * 无条件查询所有BusinessHelp
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelp> findAll() throws DaoException {
		List<BusinessHelp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessHelp
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelp> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessHelp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelp-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessHelp> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessHelp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessHelp
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelp> findByExample(final BusinessHelpQuery query) throws DaoException {
		List<BusinessHelp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelp-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessHelp> findByExample(final BusinessHelpQuery query, final Integer limit) throws DaoException {
		List<BusinessHelp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelp> findAllPage(final BusinessHelpQuery query) throws DaoException {
		List<BusinessHelp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpDao.findAllPage",query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelp> findAllPage_app(final BusinessHelpQuery query) throws DaoException {
		List<BusinessHelp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpDao.findAllPage_app",query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelp> findAllPage1(final BusinessHelpQuery query) throws DaoException {
		List<BusinessHelp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpDao.findAllPage1",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHelpQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessHelpQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount1(final BusinessHelpQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpDao.selectCount1",query);
		return count;
	}
	
	/**
	 * 保存BusinessHelp数据
	 * @param entity
	 * @return 
	 * @throws DaoException
	 */
	public BusinessHelp save(final BusinessHelp entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessHelpDao.save",entity);
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessHelpDao.saveBusinessHelpExpendestates",entity);
		return entity;
	}

	/**
	 * 修改BusinessHelp数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHelp entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHelpDao.update",entity);
	}

	/**
	 * 删除BusinessHelp
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessHelpDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
