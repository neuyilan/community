package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessFeedbackComment;
import com.community.app.module.vo.BusinessFeedbackCommentQuery;

@Repository("BusinessFeedbackCommentDao")
@Transactional
public class BusinessFeedbackCommentDaoImpl implements BusinessFeedbackCommentDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessFeedbackComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFeedbackComment findById(final Integer id) throws DaoException {
		BusinessFeedbackComment businessFeedbackComment = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFeedbackCommentDao.findById",id);
		return businessFeedbackComment;
	}
	
	/**
	 * 无条件查询所有BusinessFeedbackComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedbackComment> findAll() throws DaoException {
		List<BusinessFeedbackComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackCommentDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessFeedbackComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedbackComment> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessFeedbackComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackCommentDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessFeedbackComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessFeedbackComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackCommentDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedbackComment> findByExample(final BusinessFeedbackCommentQuery query) throws DaoException {
		List<BusinessFeedbackComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackCommentDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessFeedbackComment> findByExample(final BusinessFeedbackCommentQuery query, final Integer limit) throws DaoException {
		List<BusinessFeedbackComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackCommentDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedbackComment> findAllPage(final BusinessFeedbackCommentQuery query) throws DaoException {
		List<BusinessFeedbackComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackCommentDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFeedbackCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFeedbackCommentDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedbackComment> findAllPage_app(final BusinessFeedbackCommentQuery query) throws DaoException {
		List<BusinessFeedbackComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackCommentDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessFeedbackCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFeedbackCommentDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessFeedbackComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessFeedbackComment entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessFeedbackCommentDao.save",entity);
	}
	
	/**
	 * 保存BusinessFeedbackComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save_manage(final BusinessFeedbackComment entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessFeedbackCommentDao.save_manage",entity);
	}

	/**
	 * 修改BusinessFeedbackComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFeedbackComment entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessFeedbackCommentDao.update",entity);
	}
	
	/**
	 * 修改BusinessFeedbackComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update_app(final BusinessFeedbackComment entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessFeedbackCommentDao.update_app",entity);
	}

	/**
	 * 删除BusinessFeedbackComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessFeedbackCommentDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
