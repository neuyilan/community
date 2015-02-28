package com.community.app.module.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessNewsScope;
import com.community.app.module.vo.BusinessNewsScopeQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Repository("BusinessNewsScopeDao")
@Transactional
public class BusinessNewsScopeDaoImpl implements BusinessNewsScopeDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessNewsScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNewsScope findById(final Integer id) throws DaoException {
		BusinessNewsScope businessNewsScope = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewsScopeDao.findById",id);
		return businessNewsScope;
	}
	
	/**
	 * 无条件查询所有BusinessNewsScope
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsScope> findAll() throws DaoException {
		List<BusinessNewsScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsScopeDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessNewsScope
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsScope> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessNewsScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsScopeDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewsScope-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessNewsScope> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessNewsScope> list = this.sqlSessionTemplate.selectList("com.community.app.dao.BusinessNewsScopeDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessNewsScope
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsScope> findByExample(final BusinessNewsScopeQuery query) throws DaoException {
		List<BusinessNewsScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsScopeDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNewsScope-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessNewsScope> findByExample(final BusinessNewsScopeQuery query, final Integer limit) throws DaoException {
		List<BusinessNewsScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsScopeDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsScope> findAllPage(final BusinessNewsScopeQuery query) throws DaoException {
		List<BusinessNewsScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsScopeDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessNewsScopeQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewsScopeDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessNewsScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessNewsScope entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessNewsScopeDao.save",entity);
	}

	/**
	 * 修改BusinessNewsScope数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessNewsScope entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessNewsScopeDao.update",entity);
	}

	/**
	 * 删除BusinessNewsScope
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessNewsScopeDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 根据搜索条件，搜索分页所需的数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsScope> findAllPageByField(final Map fieldMap, final BusinessNewsScopeQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessNewsScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsScopeDao.findAllPageByField",query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsScope> findListByField(final Map fieldMap, final BusinessNewsScopeQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessNewsScope> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsScopeDao.findListByField", query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNewsScope findByField(final Map fieldMap, final Integer id) throws DaoException {
		Map paramMap = new HashMap();
		paramMap.put("id", id);
		paramMap.put("fieldMap", fieldMap);
		BusinessNewsScope businessNewsScope = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewsScopeDao.findByField",paramMap);
		return businessNewsScope;
	}
	
	/**
	 * 删除新闻范围
	 * @param newsId
	 * @throws ServiceException
	 */
	public boolean deleteScopeByNews(final Integer newsId) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessNewsScopeDao.deleteScopeByNews",newsId);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
