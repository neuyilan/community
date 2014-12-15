package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessActivitySupport;
import com.community.app.module.vo.BusinessActivitySupportQuery;

@Repository("BusinessActivitySupportDao")
@Transactional
public class BusinessActivitySupportDaoImpl implements BusinessActivitySupportDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessActivitySupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivitySupport findById(final Integer id) throws DaoException {
		BusinessActivitySupport businessActivitySupport = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivitySupportDao.findById",id);
		return businessActivitySupport;
	}
	
	/**
	 * 无条件查询所有BusinessActivitySupport
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivitySupport> findAll() throws DaoException {
		List<BusinessActivitySupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivitySupportDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessActivitySupport
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivitySupport> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessActivitySupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivitySupportDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivitySupport-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivitySupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessActivitySupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivitySupportDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivitySupport
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivitySupport> findByExample(final BusinessActivitySupportQuery query) throws DaoException {
		List<BusinessActivitySupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivitySupportDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivitySupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivitySupport> findByExample(final BusinessActivitySupportQuery query, final Integer limit) throws DaoException {
		List<BusinessActivitySupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivitySupportDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivitySupport> findAllPage(final BusinessActivitySupportQuery query) throws DaoException {
		List<BusinessActivitySupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivitySupportDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivitySupportQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivitySupportDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessActivitySupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivitySupport entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessActivitySupportDao.save",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityDao.updateSupports",entity);
		}
	}

	/**
	 * 修改BusinessActivitySupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivitySupport entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivitySupportDao.update",entity);
	}

	/**
	 * 删除BusinessActivitySupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessActivitySupportDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
