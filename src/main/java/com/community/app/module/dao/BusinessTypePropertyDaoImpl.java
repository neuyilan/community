package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessTypeProperty;
import com.community.app.module.vo.BusinessTypePropertyQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessTypePropertyDao")
@Transactional
public class BusinessTypePropertyDaoImpl implements BusinessTypePropertyDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessTypeProperty
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessTypeProperty findById(final Integer id) throws DaoException {
		BusinessTypeProperty businessTypeProperty = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessTypePropertyDao.findById",id);
		return businessTypeProperty;
	}
	
	/**
	 * 无条件查询所有BusinessTypeProperty
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessTypeProperty> findAll() throws DaoException {
		List<BusinessTypeProperty> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessTypePropertyDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessTypeProperty
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessTypeProperty> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessTypeProperty> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessTypePropertyDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessTypeProperty-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessTypeProperty> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessTypeProperty> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessTypePropertyDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessTypeProperty
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessTypeProperty> findByExample(final BusinessTypePropertyQuery query) throws DaoException {
		List<BusinessTypeProperty> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessTypePropertyDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessTypeProperty-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessTypeProperty> findByExample(final BusinessTypePropertyQuery query, final Integer limit) throws DaoException {
		List<BusinessTypeProperty> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessTypePropertyDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessTypeProperty> findAllPage(final BusinessTypePropertyQuery query) throws DaoException {
		List<BusinessTypeProperty> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessTypePropertyDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessTypePropertyQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessTypePropertyDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessTypeProperty数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessTypeProperty entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessTypePropertyDao.save",entity);
	}

	/**
	 * 修改BusinessTypeProperty数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessTypeProperty entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessTypePropertyDao.update",entity);
	}

	/**
	 * 删除BusinessTypeProperty
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessTypePropertyDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
