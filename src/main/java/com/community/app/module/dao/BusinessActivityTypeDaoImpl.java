package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessActivityType;
import com.community.app.module.vo.BusinessActivityTypeQuery;

@Repository("BusinessActivityTypeDao")
@Transactional
public class BusinessActivityTypeDaoImpl implements BusinessActivityTypeDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessActivityType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityType findById(final Integer id) throws DaoException {
		BusinessActivityType businessActivityType = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityTypeDao.findById",id);
		return businessActivityType;
	}
	
	/**
	 * 无条件查询所有BusinessActivityType
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityType> findAll() throws DaoException {
		List<BusinessActivityType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityTypeDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessActivityType
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityType> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessActivityType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityTypeDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityType-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessActivityType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityTypeDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityType
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityType> findByExample(final BusinessActivityTypeQuery query) throws DaoException {
		List<BusinessActivityType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityTypeDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityType-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityType> findByExample(final BusinessActivityTypeQuery query, final Integer limit) throws DaoException {
		List<BusinessActivityType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityTypeDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityType> findAllPage(final BusinessActivityTypeQuery query) throws DaoException {
		List<BusinessActivityType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityTypeDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityTypeQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityTypeDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessActivityType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityType entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessActivityTypeDao.save",entity);
	}

	/**
	 * 修改BusinessActivityType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityType entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityTypeDao.update",entity);
	}

	/**
	 * 删除BusinessActivityType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessActivityTypeDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
