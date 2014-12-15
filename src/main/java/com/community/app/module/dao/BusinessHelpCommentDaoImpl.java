package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;
import com.community.app.module.bean.BusinessHelpComment;
import com.community.app.module.vo.BusinessHelpCommentQuery;

@Repository("BusinessHelpCommentDao")
@Transactional
public class BusinessHelpCommentDaoImpl implements BusinessHelpCommentDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessHelpComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHelpComment findById(final Integer id) throws DaoException {
		BusinessHelpComment businessHelpComment = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpCommentDao.findById",id);
		return businessHelpComment;
	}
	
	/**
	 * 无条件查询所有BusinessHelpComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpComment> findAll() throws DaoException {
		List<BusinessHelpComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpCommentDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessHelpComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpComment> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessHelpComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpCommentDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessHelpComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpCommentDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelpComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpComment> findByExample(final BusinessHelpCommentQuery query) throws DaoException {
		List<BusinessHelpComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpCommentDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelpComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpComment> findByExample(final BusinessHelpCommentQuery query, final Integer limit) throws DaoException {
		List<BusinessHelpComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpCommentDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpComment> findAllPage(final BusinessHelpCommentQuery query) throws DaoException {
		List<BusinessHelpComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpCommentDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHelpCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpCommentDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpComment> findAllPage_app(final BusinessHelpCommentQuery query) throws DaoException {
		List<BusinessHelpComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpCommentDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessHelpCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpCommentDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessHelpComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHelpComment entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessHelpCommentDao.save",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHelpDao.updateComments",entity);
		}
	}
	
	/**
	 * 后台评论回复
	 * 保存BusinessHelpComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void replySave(final BusinessHelpComment entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessHelpCommentDao.replySave",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHelpDao.updateCommentsTime",entity);
		}
	}
	
	/**
	 * 修改BusinessHelpComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHelpComment entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHelpCommentDao.update",entity);
	}

	/**
	 * 删除BusinessHelpComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessHelpCommentDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
