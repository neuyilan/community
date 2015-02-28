package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessAnnoSupport;
import com.community.app.module.vo.BusinessAnnoSupportQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessAnnoSupportDao")
@Transactional
public class BusinessAnnoSupportDaoImpl implements BusinessAnnoSupportDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessAnnoSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessAnnoSupport findById(final Integer id) throws DaoException {
		BusinessAnnoSupport businessAnnoSupport = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessAnnoSupportDao.findById",id);
		return businessAnnoSupport;
	}
	
	/**
	 * 无条件查询所有BusinessAnnoSupport
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnnoSupport> findAll() throws DaoException {
		List<BusinessAnnoSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoSupportDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessAnnoSupport
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoSupport> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessAnnoSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoSupportDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessAnnoSupport-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoSupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessAnnoSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoSupportDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoSupport
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoSupport> findByExample(final BusinessAnnoSupportQuery query) throws DaoException {
		List<BusinessAnnoSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoSupportDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessAnnoSupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnnoSupport> findByExample(final BusinessAnnoSupportQuery query, final Integer limit) throws DaoException {
		List<BusinessAnnoSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoSupportDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnnoSupport> findAllPage(final BusinessAnnoSupportQuery query) throws DaoException {
		List<BusinessAnnoSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoSupportDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessAnnoSupportQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessAnnoSupportDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessAnnoSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessAnnoSupport entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessAnnoSupportDao.save",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessAnnoDao.updateSupports",entity);
		}
	}

	/**
	 * 修改BusinessAnnoSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessAnnoSupport entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessAnnoSupportDao.update",entity);
	}

	/**
	 * 删除BusinessAnnoSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessAnnoSupportDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
