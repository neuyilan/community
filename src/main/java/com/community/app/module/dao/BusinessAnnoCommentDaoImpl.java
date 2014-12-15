package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import com.community.app.module.bean.BusinessAnnoComment;
import com.community.app.module.vo.BusinessAnnoCommentQuery;
import com.community.framework.exception.DaoException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("BusinessAnnoCommentDao")
@Transactional
public class BusinessAnnoCommentDaoImpl implements BusinessAnnoCommentDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessAnnoComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessAnnoComment findById(final Integer id) throws DaoException {
		BusinessAnnoComment businessAnnoComment = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessAnnoCommentDao.findById",id);
		return businessAnnoComment;
	}
	
	/**
	 * 无条件查询所有BusinessAnnoComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnnoComment> findAll() throws DaoException {
		List<BusinessAnnoComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoCommentDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessAnnoComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoComment> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessAnnoComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoCommentDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessAnnoComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessAnnoComment> list = this.sqlSessionTemplate.selectList("com.community.app.app.dao.BusinessAnnoCommentDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoComment> findByExample(final BusinessAnnoCommentQuery query) throws DaoException {
		List<BusinessAnnoComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoCommentDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessAnnoComment> findByExample(final BusinessAnnoCommentQuery query, final Integer limit) throws DaoException {
		List<BusinessAnnoComment> list = this.sqlSessionTemplate.selectList("com.community.app.app.dao.BusinessAnnoCommentDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnnoComment> findAllPage(final BusinessAnnoCommentQuery query) throws DaoException {
		List<BusinessAnnoComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoCommentDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessAnnoCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessAnnoCommentDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnnoComment> findAllPage_app(final BusinessAnnoCommentQuery query) throws DaoException {
		List<BusinessAnnoComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoCommentDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessAnnoCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessAnnoCommentDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessAnnoComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessAnnoComment entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessAnnoCommentDao.save",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessAnnoDao.updateComments",entity);
		}
	}
	
	/**
	 * 后台回复保存BusinessAnnoComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void replySave(final BusinessAnnoComment entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessAnnoCommentDao.replySave",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessAnnoDao.updateComments",entity);
		}
	}

	/**
	 * 修改BusinessAnnoComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessAnnoComment entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessAnnoCommentDao.update",entity);
	}

	/**
	 * 删除BusinessAnnoComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessAnnoCommentDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
