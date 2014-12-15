package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessNewspaper;
import com.community.app.module.vo.BusinessNewspaperQuery;

@Repository("BusinessNewspaperDao")
@Transactional
public class BusinessNewspaperDaoImpl implements BusinessNewspaperDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessNewspaper
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNewspaper findById(final Integer id) throws DaoException {
		BusinessNewspaper businessNewspaper = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewspaperDao.findById",id);
		return businessNewspaper;
	}
	
	/**
	 * 无条件查询所有BusinessNewspaper
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewspaper> findAll() throws DaoException {
		List<BusinessNewspaper> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewspaperDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessNewspaper
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewspaper> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessNewspaper> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewspaperDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewspaper-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewspaper> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessNewspaper> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewspaperDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNewspaper
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewspaper> findByExample(final BusinessNewspaperQuery query) throws DaoException {
		List<BusinessNewspaper> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewspaperDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNewspaper-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewspaper> findByExample(final BusinessNewspaperQuery query, final Integer limit) throws DaoException {
		List<BusinessNewspaper> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewspaperDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewspaper> findAllPage(final BusinessNewspaperQuery query) throws DaoException {
		List<BusinessNewspaper> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewspaperDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessNewspaperQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewspaperDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewspaper> findAllPage_app(final BusinessNewspaperQuery query) throws DaoException {
		List<BusinessNewspaper> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewspaperDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessNewspaperQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewspaperDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessNewspaper数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessNewspaper entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessNewspaperDao.save",entity);
	}

	/**
	 * 修改BusinessNewspaper数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessNewspaper entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessNewspaperDao.update",entity);
	}

	/**
	 * 删除BusinessNewspaper
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessNewspaperDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
}