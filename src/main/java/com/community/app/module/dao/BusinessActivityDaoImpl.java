package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessActivity;
import com.community.app.module.vo.BusinessActivityQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessActivityDao")
@Transactional
public class BusinessActivityDaoImpl implements BusinessActivityDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessActivity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivity findById(final Integer id) throws DaoException {
		BusinessActivity businessActivity = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityDao.findById",id);
		return businessActivity;
	}
	
	/**
	 * 查询单个BusinessActivity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivity findById_app(final Integer id) throws DaoException {
		BusinessActivity businessActivity = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityDao.findById_app",id);
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityDao.updateVisits",id);
		return businessActivity;
	}
	
	/**
	 * 无条件查询所有BusinessActivity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivity> findAll() throws DaoException {
		List<BusinessActivity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessActivity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivity> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessActivity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivity-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivity> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessActivity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivity
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivity> findByExample(final BusinessActivityQuery query) throws DaoException {
		List<BusinessActivity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivity-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivity> findByExample(final BusinessActivityQuery query, final Integer limit) throws DaoException {
		List<BusinessActivity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivity> findAllPage(final BusinessActivityQuery query) throws DaoException {
		List<BusinessActivity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivity> findAllPage_app(final BusinessActivityQuery query) throws DaoException {
		List<BusinessActivity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app_QNH(final BusinessActivityQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityDao.selectCount_app_QNH",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivity> findAllPage_app_QNH(final BusinessActivityQuery query) throws DaoException {
		List<BusinessActivity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityDao.findAllPage_app_QNH",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessActivityQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessActivity数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivity entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessActivityDao.save",entity);
	}

	/**
	 * 修改BusinessActivity数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivity entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityDao.update",entity);
	}

	/**
	 * 删除BusinessActivity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessActivityDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
