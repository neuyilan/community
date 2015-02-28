package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessActivityScope;
import com.community.app.module.vo.BusinessActivityScopeQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessActivityScopeDao")
@Transactional
public class BusinessActivityScopeDaoImpl implements BusinessActivityScopeDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessActivityScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityScope findById(final Integer id) throws DaoException {
		BusinessActivityScope businessActivityScope = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityScopeDao.findById",id);
		return businessActivityScope;
	}
	
	/**
	 * 无条件查询所有BusinessActivityScope
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityScope> findAll() throws DaoException {
		List<BusinessActivityScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityScopeDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessActivityScope
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityScope> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessActivityScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityScopeDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityScope-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityScope> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessActivityScope> list = this.sqlSessionTemplate.selectList("com.community.app.app.dao.BusinessActivityScopeDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityScope
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityScope> findByExample(final BusinessActivityScopeQuery query) throws DaoException {
		List<BusinessActivityScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityScopeDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityScope-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityScope> findByExample(final BusinessActivityScopeQuery query, final Integer limit) throws DaoException {
		List<BusinessActivityScope> list = this.sqlSessionTemplate.selectList("com.community.app.app.dao.BusinessActivityScopeDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityScope> findAllPage(final BusinessActivityScopeQuery query) throws DaoException {
		List<BusinessActivityScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityScopeDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityScopeQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityScopeDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessActivityScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityScope entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessActivityScopeDao.save",entity);
	}

	/**
	 * 修改BusinessActivityScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityScope entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityScopeDao.update",entity);
	}

	/**
	 * 删除BusinessActivityScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessActivityScopeDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
