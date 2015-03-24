package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessHelpType;
import com.community.app.module.vo.BusinessHelpTypeQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessHelpTypeDao")
@Transactional
public class BusinessHelpTypeDaoImpl implements BusinessHelpTypeDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessHelpType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHelpType findById(final Integer id) throws DaoException {
		BusinessHelpType businessHelpType = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpTypeDao.findById",id);
		return businessHelpType;
	}
	
	/**
	 * 无条件查询所有BusinessHelpType
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpType> findAll() throws DaoException {
		List<BusinessHelpType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpTypeDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessHelpType
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpType> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessHelpType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpTypeDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpType-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessHelpType> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessHelpType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpTypeDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessHelpType
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpType> findByExample(final BusinessHelpTypeQuery query) throws DaoException {
		List<BusinessHelpType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpTypeDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelpType-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessHelpType> findByExample(final BusinessHelpTypeQuery query, final Integer limit) throws DaoException {
		List<BusinessHelpType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpTypeDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpType> findAllPage(final BusinessHelpTypeQuery query) throws DaoException {
		List<BusinessHelpType> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpTypeDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHelpTypeQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpTypeDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessHelpType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHelpType entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessHelpTypeDao.save",entity);
	}

	/**
	 * 修改BusinessHelpType数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHelpType entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHelpTypeDao.update",entity);
	}

	/**
	 * 删除BusinessHelpType
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessHelpTypeDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
