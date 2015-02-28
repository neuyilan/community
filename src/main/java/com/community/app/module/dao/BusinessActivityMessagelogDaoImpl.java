package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessActivityMessagelog;
import com.community.app.module.vo.BusinessActivityMessagelogQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessActivityMessagelogDao")
@Transactional
public class BusinessActivityMessagelogDaoImpl implements BusinessActivityMessagelogDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessActivityMessagelog
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityMessagelog findById(final Integer id) throws DaoException {
		BusinessActivityMessagelog businessActivityMessagelog = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityMessagelogDao.findById",id);
		return businessActivityMessagelog;
	}
	
	/**
	 * 无条件查询所有BusinessActivityMessagelog
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityMessagelog> findAll() throws DaoException {
		List<BusinessActivityMessagelog> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityMessagelogDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessActivityMessagelog
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityMessagelog> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessActivityMessagelog> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityMessagelogDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityMessagelog-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityMessagelog> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessActivityMessagelog> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityMessagelogDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityMessagelog
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityMessagelog> findByExample(final BusinessActivityMessagelogQuery query) throws DaoException {
		List<BusinessActivityMessagelog> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityMessagelogDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityMessagelog-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityMessagelog> findByExample(final BusinessActivityMessagelogQuery query, final Integer limit) throws DaoException {
		List<BusinessActivityMessagelog> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityMessagelogDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityMessagelog> findAllPage(final BusinessActivityMessagelogQuery query) throws DaoException {
		List<BusinessActivityMessagelog> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityMessagelogDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityMessagelogQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityMessagelogDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessActivityMessagelog数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityMessagelog entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessActivityMessagelogDao.save",entity);
	}

	/**
	 * 修改BusinessActivityMessagelog数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityMessagelog entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityMessagelogDao.update",entity);
	}

	/**
	 * 删除BusinessActivityMessagelog
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessActivityMessagelogDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
