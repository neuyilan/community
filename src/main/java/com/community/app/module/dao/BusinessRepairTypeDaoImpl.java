package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessRepairType;
import com.community.app.module.vo.BusinessRepairTypeQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessRepairTypeDao")
@Transactional
public class BusinessRepairTypeDaoImpl implements BusinessRepairTypeDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessRepairType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRepairType findById(final Integer id) throws DaoException {
		BusinessRepairType businessRepairType = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessRepairTypeDao.findById",id);
		return businessRepairType;
	}
	
	/**
	 * 无条件查询所有BusinessRepairType
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairType> findAll() throws DaoException {
		List<BusinessRepairType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairTypeDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessRepairType
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairType> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessRepairType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairTypeDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRepairType-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRepairType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessRepairType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairTypeDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRepairType
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairType> findByExample(final BusinessRepairTypeQuery query) throws DaoException {
		List<BusinessRepairType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairTypeDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRepairType-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRepairType> findByExample(final BusinessRepairTypeQuery query, final Integer limit) throws DaoException {
		List<BusinessRepairType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairTypeDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairType> findAllPage(final BusinessRepairTypeQuery query) throws DaoException {
		List<BusinessRepairType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairTypeDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRepairTypeQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessRepairTypeDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessRepairType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRepairType entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessRepairTypeDao.save",entity);
	}

	/**
	 * 修改BusinessRepairType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRepairType entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessRepairTypeDao.update",entity);
	}

	/**
	 * 删除BusinessRepairType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessRepairTypeDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
