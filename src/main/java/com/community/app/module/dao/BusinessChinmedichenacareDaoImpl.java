package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessChinmedichenacare;
import com.community.app.module.vo.BusinessChinmedichenacareQuery;

@Repository("BusinessChinmedichenacareDao")
@Transactional
public class BusinessChinmedichenacareDaoImpl implements BusinessChinmedichenacareDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessChinmedichenacare
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessChinmedichenacare findById(final Integer id) throws DaoException {
		BusinessChinmedichenacare businessChinmedichenacare = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessChinmedichenacareDao.findById",id);
		return businessChinmedichenacare;
	}
	
	/**
	 * 查询单个BusinessChinmedichenacare
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessChinmedichenacare findById_app(final Integer id) throws DaoException {
		BusinessChinmedichenacare businessChinmedichenacare = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessChinmedichenacareDao.findById_app",id);
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessChinmedichenacareDao.updateVisits",id);
		return businessChinmedichenacare;
	}
	
	/**
	 * 无条件查询所有BusinessChinmedichenacare
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChinmedichenacare> findAll() throws DaoException {
		List<BusinessChinmedichenacare> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacare
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessChinmedichenacare> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessChinmedichenacare> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacare-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessChinmedichenacare> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessChinmedichenacare> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacare
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessChinmedichenacare> findByExample(final BusinessChinmedichenacareQuery query) throws DaoException {
		List<BusinessChinmedichenacare> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacare-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessChinmedichenacare> findByExample(final BusinessChinmedichenacareQuery query, final Integer limit) throws DaoException {
		List<BusinessChinmedichenacare> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChinmedichenacare> findAllPage(final BusinessChinmedichenacareQuery query) throws DaoException {
		List<BusinessChinmedichenacare> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessChinmedichenacareQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessChinmedichenacareDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChinmedichenacare> findAllPage_app(final BusinessChinmedichenacareQuery query) throws DaoException {
		List<BusinessChinmedichenacare> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessChinmedichenacareQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessChinmedichenacareDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessChinmedichenacare数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessChinmedichenacare entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessChinmedichenacareDao.save",entity);
	}

	/**
	 * 修改BusinessChinmedichenacare数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessChinmedichenacare entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessChinmedichenacareDao.update",entity);
	}

	/**
	 * 删除BusinessChinmedichenacare
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessChinmedichenacareDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
