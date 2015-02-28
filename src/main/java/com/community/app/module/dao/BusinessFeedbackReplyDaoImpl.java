package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessFeedbackReply;
import com.community.app.module.vo.BusinessFeedbackReplyQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessFeedbackReplyDao")
@Transactional
public class BusinessFeedbackReplyDaoImpl implements BusinessFeedbackReplyDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessFeedbackReply
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFeedbackReply findById(final Integer id) throws DaoException {
		BusinessFeedbackReply businessFeedbackReply = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFeedbackReplyDao.findById",id);
		return businessFeedbackReply;
	}
	
	/**
	 * 无条件查询所有BusinessFeedbackReply
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedbackReply> findAll() throws DaoException {
		List<BusinessFeedbackReply> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackReplyDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessFeedbackReply
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedbackReply> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessFeedbackReply> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackReplyDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackReply-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessFeedbackReply> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessFeedbackReply> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackReplyDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackReply
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedbackReply> findByExample(final BusinessFeedbackReplyQuery query) throws DaoException {
		List<BusinessFeedbackReply> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackReplyDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackReply-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessFeedbackReply> findByExample(final BusinessFeedbackReplyQuery query, final Integer limit) throws DaoException {
		List<BusinessFeedbackReply> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackReplyDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedbackReply> findAllPage(final BusinessFeedbackReplyQuery query) throws DaoException {
		List<BusinessFeedbackReply> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackReplyDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFeedbackReplyQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFeedbackReplyDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessFeedbackReply数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessFeedbackReply entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessFeedbackReplyDao.save",entity);
	}

	/**
	 * 修改BusinessFeedbackReply数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFeedbackReply entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessFeedbackReplyDao.update",entity);
	}

	/**
	 * 删除BusinessFeedbackReply
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessFeedbackReplyDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
