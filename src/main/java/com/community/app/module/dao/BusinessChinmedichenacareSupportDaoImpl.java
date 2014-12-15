package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessChinmedichenacareSupport;
import com.community.app.module.vo.BusinessChinmedichenacareSupportQuery;

@Repository("BusinessChinmedichenacareSupportDao")
@Transactional
public class BusinessChinmedichenacareSupportDaoImpl implements BusinessChinmedichenacareSupportDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessChinmedichenacareSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessChinmedichenacareSupport findById(final Integer id) throws DaoException {
		BusinessChinmedichenacareSupport businessChinmedichenacareSupport = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessChinmedichenacareSupportDao.findById",id);
		return businessChinmedichenacareSupport;
	}
	
	/**
	 * 无条件查询所有BusinessChinmedichenacareSupport
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChinmedichenacareSupport> findAll() throws DaoException {
		List<BusinessChinmedichenacareSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareSupportDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacareSupport
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessChinmedichenacareSupport> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessChinmedichenacareSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareSupportDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacareSupport-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessChinmedichenacareSupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessChinmedichenacareSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareSupportDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacareSupport
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessChinmedichenacareSupport> findByExample(final BusinessChinmedichenacareSupportQuery query) throws DaoException {
		List<BusinessChinmedichenacareSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareSupportDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacareSupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessChinmedichenacareSupport> findByExample(final BusinessChinmedichenacareSupportQuery query, final Integer limit) throws DaoException {
		List<BusinessChinmedichenacareSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareSupportDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChinmedichenacareSupport> findAllPage(final BusinessChinmedichenacareSupportQuery query) throws DaoException {
		List<BusinessChinmedichenacareSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareSupportDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessChinmedichenacareSupportQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessChinmedichenacareSupportDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessChinmedichenacareSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessChinmedichenacareSupport entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessChinmedichenacareSupportDao.save",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessChinmedichenacareDao.updateSupports",entity);
		}
	}

	/**
	 * 修改BusinessChinmedichenacareSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessChinmedichenacareSupport entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessChinmedichenacareSupportDao.update",entity);
	}

	/**
	 * 删除BusinessChinmedichenacareSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessChinmedichenacareSupportDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
