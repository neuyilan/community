package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessExpBackresolve;
import com.community.app.module.bean.BusinessExpResolve;
import com.community.app.module.vo.BusinessExpBackresolveQuery;

@Repository("BusinessExpBackresolveDao")
@Transactional
public class BusinessExpBackresolveDaoImpl implements BusinessExpBackresolveDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessExpBackresolve
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessExpBackresolve findById(final Integer id) throws DaoException {
		BusinessExpBackresolve businessExpBackresolve = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessExpBackresolveDao.findById",id);
		return businessExpBackresolve;
	}
	
	/**
	 * 无条件查询所有BusinessExpBackresolve
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExpBackresolve> findAll() throws DaoException {
		List<BusinessExpBackresolve> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpBackresolveDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessExpBackresolve
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExpBackresolve> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessExpBackresolve> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpBackresolveDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessExpBackresolve-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessExpBackresolve> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessExpBackresolve> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpBackresolveDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessExpBackresolve
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessExpBackresolve> findByExample(final BusinessExpBackresolveQuery query) throws DaoException {
		List<BusinessExpBackresolve> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpBackresolveDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessExpBackresolve-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessExpBackresolve> findByExample(final BusinessExpBackresolveQuery query, final Integer limit) throws DaoException {
		List<BusinessExpBackresolve> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpBackresolveDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessExpBackresolve> findAllPage(final BusinessExpBackresolveQuery query) throws DaoException {
		List<BusinessExpBackresolve> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessExpBackresolveDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessExpBackresolveQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessExpBackresolveDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessExpBackresolve数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessExpBackresolve entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessExpBackresolveDao.save",entity);
	}
	
	/**
	 * 保存BusinessExpBackresolve数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save_app(final BusinessExpResolve entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessExpBackresolveDao.save_app",entity);
	}

	/**
	 * 修改BusinessExpBackresolve数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessExpBackresolve entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessExpBackresolveDao.update",entity);
	}

	/**
	 * 删除BusinessExpBackresolve
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessExpBackresolveDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
