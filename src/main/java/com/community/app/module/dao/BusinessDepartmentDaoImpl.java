package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessDepartment;
import com.community.app.module.vo.BusinessDepartmentQuery;

@Repository("BusinessDepartmentDao")
@Transactional
public class BusinessDepartmentDaoImpl implements BusinessDepartmentDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessDepartment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessDepartment findById(final Integer id) throws DaoException {
		BusinessDepartment businessDepartment = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessDepartmentDao.findById",id);
		return businessDepartment;
	}
	
	/**
	 * 无条件查询所有BusinessDepartment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessDepartment> findAll() throws DaoException {
		List<BusinessDepartment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessDepartmentDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessDepartment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessDepartment> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessDepartment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessDepartmentDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessDepartment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessDepartment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessDepartment> list = this.sqlSessionTemplate.selectList("com.community.app.app.dao.BusinessDepartmentDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessDepartment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessDepartment> findByExample(final BusinessDepartmentQuery query) throws DaoException {
		List<BusinessDepartment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessDepartmentDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessDepartment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessDepartment> findByExample(final BusinessDepartmentQuery query, final Integer limit) throws DaoException {
		List<BusinessDepartment> list = this.sqlSessionTemplate.selectList("com.community.app.app.dao.BusinessDepartmentDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessDepartment> findAllPage(final BusinessDepartmentQuery query) throws DaoException {
		List<BusinessDepartment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessDepartmentDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessDepartmentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessDepartmentDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessDepartment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessDepartment entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessDepartmentDao.save",entity);
	}

	/**
	 * 修改BusinessDepartment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessDepartment entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessDepartmentDao.update",entity);
	}

	/**
	 * 删除BusinessDepartment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessDepartmentDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
