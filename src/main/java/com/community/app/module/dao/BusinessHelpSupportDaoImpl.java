package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessHelpSupport;
import com.community.app.module.vo.BusinessHelpSupportQuery;

@Repository("BusinessHelpSupportDao")
@Transactional
public class BusinessHelpSupportDaoImpl implements BusinessHelpSupportDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessHelpSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHelpSupport findById(final Integer id) throws DaoException {
		BusinessHelpSupport businessHelpSupport = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpSupportDao.findById",id);
		return businessHelpSupport;
	}
	
	/**
	 * 无条件查询所有BusinessHelpSupport
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpSupport> findAll() throws DaoException {
		List<BusinessHelpSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpSupportDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessHelpSupport
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpSupport> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessHelpSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpSupportDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpSupport-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpSupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessHelpSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpSupportDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelpSupport
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpSupport> findByExample(final BusinessHelpSupportQuery query) throws DaoException {
		List<BusinessHelpSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpSupportDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelpSupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpSupport> findByExample(final BusinessHelpSupportQuery query, final Integer limit) throws DaoException {
		List<BusinessHelpSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpSupportDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpSupport> findAllPage(final BusinessHelpSupportQuery query) throws DaoException {
		List<BusinessHelpSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpSupportDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHelpSupportQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpSupportDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessHelpSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHelpSupport entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessHelpSupportDao.save",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHelpDao.updateSupports",entity);
		}
	}

	/**
	 * 修改BusinessHelpSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHelpSupport entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHelpSupportDao.update",entity);
	}

	/**
	 * 删除BusinessHelpSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessHelpSupportDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
