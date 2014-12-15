package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;
import com.community.app.module.bean.BusinessChinmedichenacareComment;
import com.community.app.module.vo.BusinessChinmedichenacareCommentQuery;

@Repository("BusinessChinmedichenacareCommentDao")
@Transactional
public class BusinessChinmedichenacareCommentDaoImpl implements BusinessChinmedichenacareCommentDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessChinmedichenacareComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessChinmedichenacareComment findById(final Integer id) throws DaoException {
		BusinessChinmedichenacareComment businessChinmedichenacareComment = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessChinmedichenacareCommentDao.findById",id);
		return businessChinmedichenacareComment;
	}
	
	/**
	 * 无条件查询所有BusinessChinmedichenacareComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChinmedichenacareComment> findAll() throws DaoException {
		List<BusinessChinmedichenacareComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareCommentDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacareComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessChinmedichenacareComment> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessChinmedichenacareComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareCommentDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessChinmedichenacareComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessChinmedichenacareComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessChinmedichenacareComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareCommentDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacareComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessChinmedichenacareComment> findByExample(final BusinessChinmedichenacareCommentQuery query) throws DaoException {
		List<BusinessChinmedichenacareComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareCommentDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessChinmedichenacareComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessChinmedichenacareComment> findByExample(final BusinessChinmedichenacareCommentQuery query, final Integer limit) throws DaoException {
		List<BusinessChinmedichenacareComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareCommentDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChinmedichenacareComment> findAllPage(final BusinessChinmedichenacareCommentQuery query) throws DaoException {
		List<BusinessChinmedichenacareComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareCommentDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessChinmedichenacareCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessChinmedichenacareCommentDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChinmedichenacareComment> findAllPage_app(final BusinessChinmedichenacareCommentQuery query) throws DaoException {
		List<BusinessChinmedichenacareComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChinmedichenacareCommentDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessChinmedichenacareCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessChinmedichenacareCommentDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessChinmedichenacareComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessChinmedichenacareComment entity) throws DaoException {
		int count =  this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessChinmedichenacareCommentDao.save",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessChinmedichenacareDao.updateComments",entity);
		}
	}
	
	/**
	 * 后台评论回复
	 * 保存BusinessChinmedichenacareComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void replySave(final BusinessChinmedichenacareComment entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessChinmedichenacareCommentDao.replySave",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessChinmedichenacareDao.updateComments",entity);
		}
	}

	/**
	 * 修改BusinessChinmedichenacareComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessChinmedichenacareComment entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessChinmedichenacareCommentDao.update",entity);
	}

	/**
	 * 删除BusinessChinmedichenacareComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessChinmedichenacareCommentDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
