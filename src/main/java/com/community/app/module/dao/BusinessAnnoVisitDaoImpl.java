package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessAnnoVisit;
import com.community.app.module.vo.BusinessAnnoVisitQuery;

@Repository("BusinessAnnoVisitDao")
@Transactional
public class BusinessAnnoVisitDaoImpl implements BusinessAnnoVisitDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessAnnoVisit
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessAnnoVisit findById(final Integer id) throws DaoException {
		BusinessAnnoVisit businessAnnoVisit = this.sqlSessionTemplate.selectOne("com.community.app.app.dao.BusinessAnnoVisitDao.findById",id);
		return businessAnnoVisit;
	}
	
	/**
	 * 无条件查询所有BusinessAnnoVisit
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnnoVisit> findAll() throws DaoException {
		List<BusinessAnnoVisit> list = this.sqlSessionTemplate.selectList("com.community.app.app.dao.BusinessAnnoVisitDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessAnnoVisit
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoVisit> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessAnnoVisit> list = this.sqlSessionTemplate.selectList("com.community.app.app.dao.BusinessAnnoVisitDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoVisit-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessAnnoVisit> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessAnnoVisit> list = this.sqlSessionTemplate.selectList("com.community.app.app.dao.BusinessAnnoVisitDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoVisit
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoVisit> findByExample(final BusinessAnnoVisitQuery query) throws DaoException {
		List<BusinessAnnoVisit> list = this.sqlSessionTemplate.selectList("com.community.app.app.dao.BusinessAnnoVisitDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoVisit-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessAnnoVisit> findByExample(final BusinessAnnoVisitQuery query, final Integer limit) throws DaoException {
		List<BusinessAnnoVisit> list = this.sqlSessionTemplate.selectList("com.community.app.app.dao.BusinessAnnoVisitDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnnoVisit> findAllPage(final BusinessAnnoVisitQuery query) throws DaoException {
		List<BusinessAnnoVisit> list = this.sqlSessionTemplate.selectList("com.community.app.app.dao.BusinessAnnoVisitDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessAnnoVisitQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.app.dao.BusinessAnnoVisitDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessAnnoVisit数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessAnnoVisit entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.app.dao.BusinessAnnoVisitDao.save",entity);
	}

	/**
	 * 修改BusinessAnnoVisit数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessAnnoVisit entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.app.dao.BusinessAnnoVisitDao.update",entity);
	}

	/**
	 * 删除BusinessAnnoVisit
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.app.dao.BusinessAnnoVisitDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
