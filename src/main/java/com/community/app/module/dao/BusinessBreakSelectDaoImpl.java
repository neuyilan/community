package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessBreakSelect;
import com.community.app.module.vo.BusinessBreakSelectQuery;

@Repository("BusinessBreakSelectDao")
@Transactional
public class BusinessBreakSelectDaoImpl implements BusinessBreakSelectDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessBreakSelect
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessBreakSelect findById(final Integer id) throws DaoException {
		BusinessBreakSelect businessBreakSelect = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessBreakSelectDao.findById",id);
		return businessBreakSelect;
	}
	
	/**
	 * 无条件查询所有BusinessBreakSelect
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakSelect> findAll() throws DaoException {
		List<BusinessBreakSelect> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakSelectDao.findAll");
		return list;
	}
	
	/**
	 * 根据爆料ID查询所有选用的爆料BusinessBreakSelect
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakSelect> findListByBreakId(final BusinessBreakSelectQuery query) throws DaoException {
		List<BusinessBreakSelect> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakSelectDao.findListByBreakId", query);
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessBreakSelect
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreakSelect> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessBreakSelect> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakSelectDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBreakSelect-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessBreakSelect> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessBreakSelect> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakSelectDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessBreakSelect
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreakSelect> findByExample(final BusinessBreakSelectQuery query) throws DaoException {
		List<BusinessBreakSelect> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakSelectDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBreakSelect-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessBreakSelect> findByExample(final BusinessBreakSelectQuery query, final Integer limit) throws DaoException {
		List<BusinessBreakSelect> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakSelectDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakSelect> findAllPage(final BusinessBreakSelectQuery query) throws DaoException {
		List<BusinessBreakSelect> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakSelectDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessBreakSelectQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessBreakSelectDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessBreakSelect数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessBreakSelect entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessBreakSelectDao.save",entity);
	}

	/**
	 * 修改BusinessBreakSelect数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessBreakSelect entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessBreakSelectDao.update",entity);
	}

	/**
	 * 删除BusinessBreakSelect
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessBreakSelectDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
