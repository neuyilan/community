package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessRepairReply;
import com.community.app.module.vo.BusinessRepairReplyQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessRepairReplyDao")
@Transactional
public class BusinessRepairReplyDaoImpl implements BusinessRepairReplyDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessRepairReply
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRepairReply findById(final Integer id) throws DaoException {
		BusinessRepairReply businessRepairReply = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessRepairReplyDao.findById",id);
		return businessRepairReply;
	}
	
	/**
	 * 无条件查询所有BusinessRepairReply
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairReply> findAll() throws DaoException {
		List<BusinessRepairReply> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairReplyDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessRepairReply
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairReply> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessRepairReply> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairReplyDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRepairReply-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRepairReply> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessRepairReply> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairReplyDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRepairReply
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairReply> findByExample(final BusinessRepairReplyQuery query) throws DaoException {
		List<BusinessRepairReply> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairReplyDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRepairReply-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRepairReply> findByExample(final BusinessRepairReplyQuery query, final Integer limit) throws DaoException {
		List<BusinessRepairReply> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairReplyDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairReply> findAllPage(final BusinessRepairReplyQuery query) throws DaoException {
		List<BusinessRepairReply> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairReplyDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRepairReplyQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessRepairReplyDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessRepairReply数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRepairReply entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessRepairReplyDao.save",entity);
	}

	/**
	 * 修改BusinessRepairReply数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRepairReply entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessRepairReplyDao.update",entity);
	}

	/**
	 * 删除BusinessRepairReply
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessRepairReplyDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
