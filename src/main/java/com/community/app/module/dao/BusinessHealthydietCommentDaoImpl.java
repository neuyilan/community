package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;




import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;
import com.community.app.module.bean.BusinessChinmedichenacareComment;
import com.community.app.module.bean.BusinessHealthydietComment;
import com.community.app.module.vo.BusinessHealthydietCommentQuery;

@Repository("BusinessHealthydietCommentDao")
@Transactional
public class BusinessHealthydietCommentDaoImpl implements BusinessHealthydietCommentDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessHealthydietComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHealthydietComment findById(final Integer id) throws DaoException {
		BusinessHealthydietComment businessHealthydietComment = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHealthydietCommentDao.findById",id);
		return businessHealthydietComment;
	}
	
	/**
	 * 无条件查询所有BusinessHealthydietComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHealthydietComment> findAll() throws DaoException {
		List<BusinessHealthydietComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietCommentDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessHealthydietComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHealthydietComment> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessHealthydietComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietCommentDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHealthydietComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessHealthydietComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessHealthydietComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietCommentDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessHealthydietComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHealthydietComment> findByExample(final BusinessHealthydietCommentQuery query) throws DaoException {
		List<BusinessHealthydietComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietCommentDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHealthydietComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessHealthydietComment> findByExample(final BusinessHealthydietCommentQuery query, final Integer limit) throws DaoException {
		List<BusinessHealthydietComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietCommentDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHealthydietComment> findAllPage(final BusinessHealthydietCommentQuery query) throws DaoException {
		List<BusinessHealthydietComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietCommentDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHealthydietCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHealthydietCommentDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHealthydietComment> findAllPage_app(final BusinessHealthydietCommentQuery query) throws DaoException {
		List<BusinessHealthydietComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHealthydietCommentDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessHealthydietCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHealthydietCommentDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessHealthydietComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHealthydietComment entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessHealthydietCommentDao.save",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHealthydietDao.updateComments",entity);
		}
	}
	
	/**
	 * 后台评论回复
	 * 保存BusinessHealthydietComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void replySave(final BusinessHealthydietComment entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessHealthydietCommentDao.replySave",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHealthydietDao.updateComments",entity);
		}
	}

	/**
	 * 修改BusinessHealthydietComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHealthydietComment entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHealthydietCommentDao.update",entity);
	}

	/**
	 * 删除BusinessHealthydietComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessHealthydietCommentDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
