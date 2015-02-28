package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessProductComment;
import com.community.app.module.vo.BusinessProductCommentQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessProductCommentDao")
@Transactional
public class BusinessProductCommentDaoImpl implements BusinessProductCommentDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessProductComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessProductComment findById(final Integer id) throws DaoException {
		BusinessProductComment businessProductComment = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessProductCommentDao.findById",id);
		return businessProductComment;
	}
	
	/**
	 * 无条件查询所有BusinessProductComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductComment> findAll() throws DaoException {
		List<BusinessProductComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductCommentDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessProductComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductComment> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessProductComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductCommentDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProductComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessProductComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessProductComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductCommentDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessProductComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductComment> findByExample(final BusinessProductCommentQuery query) throws DaoException {
		List<BusinessProductComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductCommentDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessProductComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessProductComment> findByExample(final BusinessProductCommentQuery query, final Integer limit) throws DaoException {
		List<BusinessProductComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductCommentDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductComment> findAllPage(final BusinessProductCommentQuery query) throws DaoException {
		List<BusinessProductComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductCommentDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessProductCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessProductCommentDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductComment> findAllPage_app(final BusinessProductCommentQuery query) throws DaoException {
		List<BusinessProductComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductCommentDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessProductCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessProductCommentDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessProductComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessProductComment entity) throws DaoException {
		int count=this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessProductCommentDao.save",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessProductDao.updateComments",entity);
		}
	}
	
	/**
	 * 后台评论回复
	 * 保存BusinessProductComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void replySave(final BusinessProductComment entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessProductCommentDao.replySave",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessProductDao.updateComments",entity);
		}
	}

	/**
	 * 修改BusinessProductComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessProductComment entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessProductCommentDao.update",entity);
	}

	/**
	 * 删除BusinessProductComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessProductCommentDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
