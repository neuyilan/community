package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessLifeProp;
import com.community.app.module.vo.BusinessLifePropQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessLifePropDao")
@Transactional
public class BusinessLifePropDaoImpl implements BusinessLifePropDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessLifeProp
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessLifeProp findById(final Integer id) throws DaoException {
		BusinessLifeProp businessLifeProp = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessLifePropDao.findById",id);
		return businessLifeProp;
	}
	
	/**
	 * 无条件查询所有BusinessLifeProp
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessLifeProp> findAll() throws DaoException {
		List<BusinessLifeProp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessLifePropDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessLifeProp
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessLifeProp> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessLifeProp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessLifePropDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessLifeProp-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessLifeProp> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessLifeProp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessLifePropDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessLifeProp
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessLifeProp> findByExample(final BusinessLifePropQuery query) throws DaoException {
		List<BusinessLifeProp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessLifePropDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessLifeProp-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessLifeProp> findByExample(final BusinessLifePropQuery query, final Integer limit) throws DaoException {
		List<BusinessLifeProp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessLifePropDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessLifeProp> findAllPage(final BusinessLifePropQuery query) throws DaoException {
		List<BusinessLifeProp> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessLifePropDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessLifePropQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessLifePropDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessLifeProp数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessLifeProp entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessLifePropDao.save",entity);
	}

	/**
	 * 修改BusinessLifeProp数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessLifeProp entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessLifePropDao.update",entity);
	}

	/**
	 * 删除BusinessLifeProp
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessLifePropDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 删除BusinessLifeProp
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean deleteLifeProp(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessLifePropDao.deleteLifeProp",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}


	
}
