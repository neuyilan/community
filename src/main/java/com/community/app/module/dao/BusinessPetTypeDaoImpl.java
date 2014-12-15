package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessPetType;
import com.community.app.module.vo.BusinessPetTypeQuery;

@Repository("BusinessPetTypeDao")
@Transactional
public class BusinessPetTypeDaoImpl implements BusinessPetTypeDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessPetType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessPetType findById(final Integer id) throws DaoException {
		BusinessPetType businessPetType = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessPetTypeDao.findById",id);
		return businessPetType;
	}
	
	/**
	 * 无条件查询所有BusinessPetType
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessPetType> findAll() throws DaoException {
		List<BusinessPetType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPetTypeDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessPetType
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPetType> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessPetType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPetTypeDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessPetType-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPetType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessPetType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPetTypeDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessPetType
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPetType> findByExample(final BusinessPetTypeQuery query) throws DaoException {
		List<BusinessPetType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPetTypeDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessPetType-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPetType> findByExample(final BusinessPetTypeQuery query, final Integer limit) throws DaoException {
		List<BusinessPetType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPetTypeDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessPetType> findAllPage(final BusinessPetTypeQuery query) throws DaoException {
		List<BusinessPetType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPetTypeDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessPetTypeQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessPetTypeDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessPetType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessPetType entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessPetTypeDao.save",entity);
	}

	/**
	 * 修改BusinessPetType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessPetType entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessPetTypeDao.update",entity);
	}

	/**
	 * 删除BusinessPetType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessPetTypeDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
