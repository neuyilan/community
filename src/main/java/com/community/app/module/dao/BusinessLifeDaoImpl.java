package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import com.community.framework.exception.DaoException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessLife;
import com.community.app.module.vo.BusinessLifeQuery;

@Repository("BusinessLifeDao")
@Transactional
public class BusinessLifeDaoImpl implements BusinessLifeDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessLife
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessLife findById(final Integer id) throws DaoException {
		BusinessLife businessLife = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessLifeDao.findById",id);
		return businessLife;
	}
	
	/**
	 * 无条件查询所有BusinessLife
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessLife> findAll() throws DaoException {
		List<BusinessLife> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessLifeDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessLife
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessLife> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessLife> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessLifeDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessLife-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessLife> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessLife> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessLifeDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessLife
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessLife> findByExample(final BusinessLifeQuery query) throws DaoException {
		List<BusinessLife> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessLifeDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessLife-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessLife> findByExample(final BusinessLifeQuery query, final Integer limit) throws DaoException {
		List<BusinessLife> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessLifeDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessLife> findAllPage(final BusinessLifeQuery query) throws DaoException {
		List<BusinessLife> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessLifeDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessLifeQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessLifeDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessLife数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessLife entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessLifeDao.save",entity);
	}

	/**
	 * 修改BusinessLife数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessLife entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessLifeDao.update",entity);
	}

	/**
	 * 删除BusinessLife
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessLifeDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
