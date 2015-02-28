package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessNews;
import com.community.app.module.bean.index;
import com.community.app.module.vo.BusinessNewsQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessNewsDao")
@Transactional
public class BusinessNewsDaoImpl implements BusinessNewsDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNews findById(final Integer id) throws DaoException {
		BusinessNews businessNews = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewsDao.findById",id);
		return businessNews;
	}
	
	/**
	 * 查询单个BusinessNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNews findById_app(final Integer id) throws DaoException {
		BusinessNews businessNews = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewsDao.findById_app",id);
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessNewsDao.updateVisits",id);
		return businessNews;
	}
	
	/**
	 * 无条件查询所有BusinessNews
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNews> findAll() throws DaoException {
		List<BusinessNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsDao.findAll");
		return list;
	}

	/**
	 * 查询当前所有置顶的新闻
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNews> findAllHotById() throws DaoException {
		List<BusinessNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsDao.findAllHotById");
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNews
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNews> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNews-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessNews> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessNews
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNews> findByExample(final BusinessNewsQuery query) throws DaoException {
		List<BusinessNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNews-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessNews> findByExample(final BusinessNewsQuery query, final Integer limit) throws DaoException {
		List<BusinessNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNews> findAllPage(final BusinessNewsQuery query) throws DaoException {
		List<BusinessNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessNewsQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewsDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNews> findAllPage_app(final BusinessNewsQuery query) throws DaoException {
		List<BusinessNews> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessNewsQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewsDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<index> findAllPage_index_app(final BusinessNewsQuery query) throws DaoException {
		List<index> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsDao.findAllPage_index_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_index_app(final BusinessNewsQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewsDao.selectCount_index_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessNews数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessNews entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessNewsDao.save",entity);
	}

	/**
	 * 修改BusinessNews数据
	 * @param entity
	 * @throws DaoException
	 */
	public int update(final BusinessNews entity) throws DaoException {
		return  this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessNewsDao.update",entity);
	}

	/**
	 * 删除BusinessNews
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessNewsDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
