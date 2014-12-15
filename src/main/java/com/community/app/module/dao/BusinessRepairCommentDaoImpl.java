package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessRepairComment;
import com.community.app.module.vo.BusinessRepairCommentQuery;

@Repository("BusinessRepairCommentDao")
@Transactional
public class BusinessRepairCommentDaoImpl implements BusinessRepairCommentDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessRepairComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRepairComment findById(final Integer id) throws DaoException {
		BusinessRepairComment businessRepairComment = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessRepairCommentDao.findById",id);
		return businessRepairComment;
	}
	
	/**
	 * 无条件查询所有BusinessRepairComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairComment> findAll() throws DaoException {
		List<BusinessRepairComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairCommentDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessRepairComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairComment> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessRepairComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairCommentDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRepairComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRepairComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessRepairComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairCommentDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRepairComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairComment> findByExample(final BusinessRepairCommentQuery query) throws DaoException {
		List<BusinessRepairComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairCommentDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRepairComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRepairComment> findByExample(final BusinessRepairCommentQuery query, final Integer limit) throws DaoException {
		List<BusinessRepairComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairCommentDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairComment> findAllPage(final BusinessRepairCommentQuery query) throws DaoException {
		List<BusinessRepairComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairCommentDao.findAllPage",query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairComment> findAllPage_app(final BusinessRepairCommentQuery query) throws DaoException {
		List<BusinessRepairComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairCommentDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRepairCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessRepairCommentDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessRepairCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessRepairCommentDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessRepairComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRepairComment entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessRepairCommentDao.save",entity);
	}
	
	/**
	 * 保存BusinessRepairComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save_manage(final BusinessRepairComment entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessRepairCommentDao.save_manage",entity);
	}

	/**
	 * 修改BusinessRepairComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRepairComment entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessRepairCommentDao.update",entity);
	}
	
	/**
	 * 修改BusinessRepairComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update_app(final BusinessRepairComment entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessRepairCommentDao.update_app",entity);
	}

	/**
	 * 删除BusinessRepairComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessRepairCommentDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
