package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessProductType;
import com.community.app.module.vo.BusinessProductTypeQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessProductTypeDao")
@Transactional
public class BusinessProductTypeDaoImpl implements BusinessProductTypeDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessProductType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessProductType findById(final Integer id) throws DaoException {
		BusinessProductType businessProductType = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessProductTypeDao.findById",id);
		return businessProductType;
	}
	
	/**
	 * 无条件查询所有BusinessProductType
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductType> findAll() throws DaoException {
		List<BusinessProductType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductTypeDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessProductType
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductType> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessProductType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductTypeDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProductType-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessProductType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessProductType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductTypeDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessProductType
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductType> findByExample(final BusinessProductTypeQuery query) throws DaoException {
		List<BusinessProductType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductTypeDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessProductType-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessProductType> findByExample(final BusinessProductTypeQuery query, final Integer limit) throws DaoException {
		List<BusinessProductType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductTypeDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductType> findAllPage(final BusinessProductTypeQuery query) throws DaoException {
		List<BusinessProductType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductTypeDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessProductTypeQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessProductTypeDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessProductType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessProductType entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessProductTypeDao.save",entity);
	}

	/**
	 * 修改BusinessProductType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessProductType entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessProductTypeDao.update",entity);
	}

	/**
	 * 删除BusinessProductType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessProductTypeDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
