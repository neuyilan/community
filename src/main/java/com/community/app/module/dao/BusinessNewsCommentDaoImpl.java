package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessNewsComment;
import com.community.app.module.vo.BusinessNewsCommentQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessNewsCommentDao")
@Transactional
public class BusinessNewsCommentDaoImpl implements BusinessNewsCommentDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessNewsComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNewsComment findById(final Integer id) throws DaoException {
		BusinessNewsComment businessNewsComment = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewsCommentDao.findById",id);
		return businessNewsComment;
	}
	
	/**
	 * 无条件查询所有BusinessNewsComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsComment> findAll() throws DaoException {
		List<BusinessNewsComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsCommentDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessNewsComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsComment> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessNewsComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsCommentDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewsComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessNewsComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessNewsComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsCommentDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessNewsComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsComment> findByExample(final BusinessNewsCommentQuery query) throws DaoException {
		List<BusinessNewsComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsCommentDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNewsComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessNewsComment> findByExample(final BusinessNewsCommentQuery query, final Integer limit) throws DaoException {
		List<BusinessNewsComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsCommentDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsComment> findAllPage(final BusinessNewsCommentQuery query) throws DaoException {
		List<BusinessNewsComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsCommentDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessNewsCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewsCommentDao.selectCount",query);
		return count;
	}
	
	/**
	 * 后台新闻评论
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsComment> findAllPage_manage(final BusinessNewsCommentQuery query) throws DaoException {
		List<BusinessNewsComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsCommentDao.findAllPage_manage",query);
		return list;
	}

	/**
	 * 后台新闻评论
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_manage(final BusinessNewsCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewsCommentDao.selectCount_manage",query);
		return count;
	}
	
	/**
	 * 保存BusinessNewsComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessNewsComment entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessNewsCommentDao.save",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessNewsDao.updateComments",entity);
		}
	}

	/**
	 * 后台评论回复
	 * 保存BusinessNewsComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void replySave(final BusinessNewsComment entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessNewsCommentDao.replySave",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessNewsDao.updateComments",entity);
		}
	}
	
	/**
	 * 修改BusinessNewsComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessNewsComment entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessNewsCommentDao.update",entity);
	}

	/**
	 * 删除BusinessNewsComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessNewsCommentDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
