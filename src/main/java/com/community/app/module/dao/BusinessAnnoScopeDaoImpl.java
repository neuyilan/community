package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessAnnoScope;
import com.community.app.module.vo.BusinessAnnoScopeQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessAnnoScopeDao")
@Transactional
public class BusinessAnnoScopeDaoImpl implements BusinessAnnoScopeDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessAnnoScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessAnnoScope findById(final Integer id) throws DaoException {
		BusinessAnnoScope businessAnnoScope = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessAnnoScopeDao.findById",id);
		return businessAnnoScope;
	}
	
	/**
	 * 无条件查询所有BusinessAnnoScope
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnnoScope> findAll() throws DaoException {
		List<BusinessAnnoScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoScopeDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessAnnoScope
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoScope> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessAnnoScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoScopeDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoScope-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessAnnoScope> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessAnnoScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoScopeDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoScope
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoScope> findByExample(final BusinessAnnoScopeQuery query) throws DaoException {
		List<BusinessAnnoScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoScopeDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoScope-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessAnnoScope> findByExample(final BusinessAnnoScopeQuery query, final Integer limit) throws DaoException {
		List<BusinessAnnoScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoScopeDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnnoScope> findAllPage(final BusinessAnnoScopeQuery query) throws DaoException {
		List<BusinessAnnoScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoScopeDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessAnnoScopeQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessAnnoScopeDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessAnnoScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessAnnoScope entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessAnnoScopeDao.save",entity);
	}

	/**
	 * 修改BusinessAnnoScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessAnnoScope entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessAnnoScopeDao.update",entity);
	}

	/**
	 * 删除BusinessAnnoScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessAnnoScopeDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
