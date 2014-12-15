package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessHealthydiet;
import com.community.app.module.vo.BusinessHealthydietQuery;

@Repository("BusinessHealthydietDao")
@Transactional
public class BusinessHealthydietDaoImpl implements BusinessHealthydietDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessHealthydiet
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHealthydiet findById(final Integer id) throws DaoException {
		BusinessHealthydiet businessHealthydiet = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHealthydietDao.findById",id);
		return businessHealthydiet;
	}
	
	/**
	 * 查询单个BusinessHealthydiet
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHealthydiet findById_app(final Integer id) throws DaoException {
		BusinessHealthydiet businessHealthydiet = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHealthydietDao.findById_app",id);
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHealthydietDao.updateVisits",id);
		return businessHealthydiet;
	}
	
	/**
	 * 无条件查询所有BusinessHealthydiet
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHealthydiet> findAll() throws DaoException {
		List<BusinessHealthydiet> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessHealthydiet
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHealthydiet> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessHealthydiet> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHealthydiet-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessHealthydiet> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessHealthydiet> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessHealthydiet
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHealthydiet> findByExample(final BusinessHealthydietQuery query) throws DaoException {
		List<BusinessHealthydiet> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHealthydiet-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessHealthydiet> findByExample(final BusinessHealthydietQuery query, final Integer limit) throws DaoException {
		List<BusinessHealthydiet> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHealthydiet> findAllPage(final BusinessHealthydietQuery query) throws DaoException {
		List<BusinessHealthydiet> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHealthydietQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHealthydietDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHealthydiet> findAllPage_app(final BusinessHealthydietQuery query) throws DaoException {
		List<BusinessHealthydiet> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessHealthydietQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHealthydietDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessHealthydiet数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHealthydiet entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessHealthydietDao.save",entity);
	}

	/**
	 * 修改BusinessHealthydiet数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHealthydiet entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHealthydietDao.update",entity);
	}

	/**
	 * 删除BusinessHealthydiet
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessHealthydietDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
