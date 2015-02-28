package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessBreakComment;
import com.community.app.module.vo.BusinessBreakCommentQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessBreakCommentDao")
@Transactional
public class BusinessBreakCommentDaoImpl implements BusinessBreakCommentDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 根据爆料ID查询所有回复的爆料BusinessBreakComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakComment> findCommentListByBreakId(final BusinessBreakCommentQuery query) throws DaoException {
		List<BusinessBreakComment> list  = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakCommentDao.findCommentListByBreakId",query);
		return list;
	}
	
	/**
	 * 查询单个BusinessBreakComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessBreakComment findById(final Integer id) throws DaoException {
		BusinessBreakComment businessBreakComment = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessBreakCommentDao.findById",id);
		return businessBreakComment;
	}
	
	/**
	 * 无条件查询所有BusinessBreakComment
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakComment> findAll() throws DaoException {
		List<BusinessBreakComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakCommentDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessBreakComment
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreakComment> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessBreakComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakCommentDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBreakComment-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessBreakComment> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessBreakComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakCommentDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessBreakComment
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreakComment> findByExample(final BusinessBreakCommentQuery query) throws DaoException {
		List<BusinessBreakComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakCommentDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBreakComment-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessBreakComment> findByExample(final BusinessBreakCommentQuery query, final Integer limit) throws DaoException {
		List<BusinessBreakComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakCommentDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakComment> findAllPage(final BusinessBreakCommentQuery query) throws DaoException {
		List<BusinessBreakComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakCommentDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessBreakCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessBreakCommentDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakComment> findAllPage_app(final BusinessBreakCommentQuery query) throws DaoException {
		List<BusinessBreakComment> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakCommentDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessBreakCommentQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessBreakCommentDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessBreakComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessBreakComment entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessBreakCommentDao.save",entity);
	}
	
	/**
	 * 回复保存BusinessBreakComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public int replySave(final BusinessBreakComment entity) throws DaoException {
		return this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessBreakCommentDao.replySave",entity);
	}

	/**
	 * 修改BusinessBreakComment数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessBreakComment entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessBreakCommentDao.update",entity);
	}

	/**
	 * 删除BusinessBreakComment
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessBreakCommentDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
