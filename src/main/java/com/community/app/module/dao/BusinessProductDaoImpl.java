package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import com.community.framework.exception.DaoException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessProduct;
import com.community.app.module.vo.BusinessProductQuery;

@Repository("BusinessProductDao")
@Transactional
public class BusinessProductDaoImpl implements BusinessProductDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessProduct
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessProduct findById(final Integer id) throws DaoException {
		BusinessProduct businessProduct = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessProductDao.findById",id);
		return businessProduct;
	}
	
	/**
	 * 查询单个BusinessProduct
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessProduct findProductById(final Integer id) throws DaoException {
		BusinessProduct businessProduct = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessProductDao.findProductById",id);
		return businessProduct;
	}
	
	/**
	 * 查询单个BusinessProduct
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessProduct findById_app(final Integer id) throws DaoException {
		BusinessProduct businessProduct = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessProductDao.findById_app",id);
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessProductDao.updateVisits",id);
		return businessProduct;
	}
	
	/**
	 * 无条件查询所有BusinessProduct
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProduct> findAll() throws DaoException {
		List<BusinessProduct> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessProduct
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProduct> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessProduct> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProduct-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessProduct> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessProduct> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessProduct
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProduct> findByExample(final BusinessProductQuery query) throws DaoException {
		List<BusinessProduct> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessProduct-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessProduct> findByExample(final BusinessProductQuery query, final Integer limit) throws DaoException {
		List<BusinessProduct> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProduct> findAllPage(final BusinessProductQuery query) throws DaoException {
		List<BusinessProduct> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductDao.findAllPage",query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProduct> findAllPage_manage(final BusinessProductQuery query) throws DaoException {
		List<BusinessProduct> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductDao.findAllPage_manage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessProductQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessProductDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProduct> findAllPage_app(final BusinessProductQuery query) throws DaoException {
		List<BusinessProduct> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessProductQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessProductDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessProduct数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessProduct entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessProductDao.save",entity);
	}

	/**
	 * 修改BusinessProduct数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessProduct entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessProductDao.update",entity);
	}

	/**
	 * 保存BusinessProduct数据
	 * @param entity
	 * @throws DaoException
	 */
	public BusinessProduct save_app(final BusinessProduct entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessProductDao.save_app",entity);
		return entity;
	}

	/**
	 * 修改BusinessProduct数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update_app(final BusinessProduct entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessProductDao.update_app",entity);
	}
	
	/**
	 * 删除BusinessProduct
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessProductDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
