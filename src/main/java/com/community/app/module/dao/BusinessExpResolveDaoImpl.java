package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessExpResolve;
import com.community.app.module.vo.BusinessExpResolveQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessExpResolveDao")
@Transactional
public class BusinessExpResolveDaoImpl implements BusinessExpResolveDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessExpResolve
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessExpResolve findById(final Integer id) throws DaoException {
		BusinessExpResolve businessExpResolve = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessExpResolveDao.findById",id);
		return businessExpResolve;
	}
	
	/**
	 * 无条件查询所有BusinessExpResolve
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExpResolve> findAll() throws DaoException {
		List<BusinessExpResolve> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpResolveDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessExpResolve
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExpResolve> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessExpResolve> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpResolveDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessExpResolve-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExpResolve> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessExpResolve> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpResolveDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessExpResolve
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExpResolve> findByExample(final BusinessExpResolveQuery query) throws DaoException {
		List<BusinessExpResolve> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpResolveDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessExpResolve-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExpResolve> findByExample(final BusinessExpResolveQuery query, final Integer limit) throws DaoException {
		List<BusinessExpResolve> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpResolveDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExpResolve> findAllPage(final BusinessExpResolveQuery query) throws DaoException {
		List<BusinessExpResolve> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpResolveDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessExpResolveQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessExpResolveDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExpResolve> findAllPage_app(final BusinessExpResolveQuery query) throws DaoException {
		List<BusinessExpResolve> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpResolveDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessExpResolveQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessExpResolveDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessExpResolve数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessExpResolve entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessExpResolveDao.save",entity);
	}
	
	/**
	 * 保存BusinessExpResolve数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save_app(final BusinessExpResolve entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessExpResolveDao.save_app",entity);
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessExpBackresolveDao.save_app",entity);
	}

	/**
	 * 修改BusinessExpResolve数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessExpResolve entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessExpResolveDao.update",entity);
	}

	/**
	 * 删除BusinessExpResolve
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessExpResolveDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 删除BusinessExpResolve
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete_app(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessExpResolveDao.delete_app",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
