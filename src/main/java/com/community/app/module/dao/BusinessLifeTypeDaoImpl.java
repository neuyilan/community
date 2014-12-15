package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import com.community.framework.exception.DaoException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.community.app.module.bean.BusinessLifeType;
import com.community.app.module.vo.BusinessLifeTypeQuery;

@Repository("BusinessLifeTypeDao")
@Transactional
public class BusinessLifeTypeDaoImpl implements BusinessLifeTypeDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessLifeType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessLifeType findById(final Integer id) throws DaoException {
		BusinessLifeType businessLifeType = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessLifeTypeDao.findById",id);
		return businessLifeType;
	}
	
	/**
	 * 无条件查询所有BusinessLifeType
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessLifeType> findAll() throws DaoException {
		List<BusinessLifeType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessLifeTypeDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessLifeType
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessLifeType> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessLifeType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessLifeTypeDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessLifeType-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessLifeType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessLifeType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessLifeTypeDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessLifeType
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessLifeType> findByExample(final BusinessLifeTypeQuery query) throws DaoException {
		List<BusinessLifeType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessLifeTypeDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessLifeType-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessLifeType> findByExample(final BusinessLifeTypeQuery query, final Integer limit) throws DaoException {
		List<BusinessLifeType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessLifeTypeDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessLifeType> findAllPage(final BusinessLifeTypeQuery query) throws DaoException {
		List<BusinessLifeType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessLifeTypeDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessLifeTypeQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessLifeTypeDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessLifeType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessLifeType entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessLifeTypeDao.save",entity);
	}

	/**
	 * 修改BusinessLifeType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessLifeType entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessLifeTypeDao.update",entity);
	}

	/**
	 * 删除BusinessLifeType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessLifeTypeDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
