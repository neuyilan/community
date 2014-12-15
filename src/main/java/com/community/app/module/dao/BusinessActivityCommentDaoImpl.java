package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessActivityComment;
import com.community.app.module.vo.BusinessActivityCommentQuery;

@Repository("BusinessActivityCommentDao")
@Transactional
public class BusinessActivityCommentDaoImpl implements BusinessActivityCommentDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessActivityComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityComment findById(final Integer id) throws DaoException {
		BusinessActivityComment businessActivityComment = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityCommentDao.findById",id);
		return businessActivityComment;
	}
	
	/**
	 * 无条件查询所有BusinessActivityComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityComment> findAll() throws DaoException {
		List<BusinessActivityComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityCommentDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessActivityComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityComment> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessActivityComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityCommentDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessActivityComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityCommentDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityComment> findByExample(final BusinessActivityCommentQuery query) throws DaoException {
		List<BusinessActivityComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityCommentDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityComment> findByExample(final BusinessActivityCommentQuery query, final Integer limit) throws DaoException {
		List<BusinessActivityComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityCommentDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityComment> findAllPage(final BusinessActivityCommentQuery query) throws DaoException {
		List<BusinessActivityComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityCommentDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityCommentDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityComment> findAllPage_app(final BusinessActivityCommentQuery query) throws DaoException {
		List<BusinessActivityComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityCommentDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessActivityCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityCommentDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessActivityComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityComment entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessActivityCommentDao.save",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityDao.updateComments",entity);
		}
	}
	
	/**
	 * 保存BusinessActivityComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void replySave(final BusinessActivityComment entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessActivityCommentDao.replySave",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityDao.updateComments",entity);
		}
	}

	/**
	 * 修改BusinessActivityComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityComment entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityCommentDao.update",entity);
	}

	/**
	 * 删除BusinessActivityComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessActivityCommentDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
