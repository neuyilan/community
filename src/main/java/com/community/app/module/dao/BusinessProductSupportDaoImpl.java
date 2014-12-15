package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessProductSupport;
import com.community.app.module.vo.BusinessProductSupportQuery;

@Repository("BusinessProductSupportDao")
@Transactional
public class BusinessProductSupportDaoImpl implements BusinessProductSupportDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessProductSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessProductSupport findById(final Integer id) throws DaoException {
		BusinessProductSupport businessProductSupport = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessProductSupportDao.findById",id);
		return businessProductSupport;
	}
	
	/**
	 * 无条件查询所有BusinessProductSupport
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductSupport> findAll() throws DaoException {
		List<BusinessProductSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductSupportDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessProductSupport
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductSupport> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessProductSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductSupportDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProductSupport-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductSupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessProductSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductSupportDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessProductSupport
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductSupport> findByExample(final BusinessProductSupportQuery query) throws DaoException {
		List<BusinessProductSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductSupportDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessProductSupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductSupport> findByExample(final BusinessProductSupportQuery query, final Integer limit) throws DaoException {
		List<BusinessProductSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductSupportDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductSupport> findAllPage(final BusinessProductSupportQuery query) throws DaoException {
		List<BusinessProductSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductSupportDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessProductSupportQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessProductSupportDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessProductSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessProductSupport entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessProductSupportDao.save",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessProductDao.updateSupports",entity);
		}
	}

	/**
	 * 修改BusinessProductSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessProductSupport entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessProductSupportDao.update",entity);
	}

	/**
	 * 删除BusinessProductSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessProductSupportDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
