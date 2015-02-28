package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessHealthydietSupport;
import com.community.app.module.vo.BusinessHealthydietSupportQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessHealthydietSupportDao")
@Transactional
public class BusinessHealthydietSupportDaoImpl implements BusinessHealthydietSupportDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessHealthydietSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHealthydietSupport findById(final Integer id) throws DaoException {
		BusinessHealthydietSupport businessHealthydietSupport = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHealthydietSupportDao.findById",id);
		return businessHealthydietSupport;
	}
	
	/**
	 * 无条件查询所有BusinessHealthydietSupport
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHealthydietSupport> findAll() throws DaoException {
		List<BusinessHealthydietSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietSupportDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessHealthydietSupport
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHealthydietSupport> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessHealthydietSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietSupportDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHealthydietSupport-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessHealthydietSupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessHealthydietSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietSupportDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessHealthydietSupport
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHealthydietSupport> findByExample(final BusinessHealthydietSupportQuery query) throws DaoException {
		List<BusinessHealthydietSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietSupportDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHealthydietSupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessHealthydietSupport> findByExample(final BusinessHealthydietSupportQuery query, final Integer limit) throws DaoException {
		List<BusinessHealthydietSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietSupportDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHealthydietSupport> findAllPage(final BusinessHealthydietSupportQuery query) throws DaoException {
		List<BusinessHealthydietSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietSupportDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHealthydietSupportQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHealthydietSupportDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessHealthydietSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHealthydietSupport entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessHealthydietSupportDao.save",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHealthydietDao.updateSupports",entity);
		}
	}

	/**
	 * 修改BusinessHealthydietSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHealthydietSupport entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHealthydietSupportDao.update",entity);
	}

	/**
	 * 删除BusinessHealthydietSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessHealthydietSupportDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
