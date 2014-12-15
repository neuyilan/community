package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessProductKeyword;
import com.community.app.module.vo.BusinessProductKeywordQuery;

@Repository("BusinessProductKeywordDao")
@Transactional
public class BusinessProductKeywordDaoImpl implements BusinessProductKeywordDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessProductKeyword
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessProductKeyword findById(final Integer id) throws DaoException {
		BusinessProductKeyword businessProductKeyword = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessProductKeywordDao.findById",id);
		return businessProductKeyword;
	}
	
	/**
	 * 无条件查询所有BusinessProductKeyword
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductKeyword> findAll() throws DaoException {
		List<BusinessProductKeyword> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductKeywordDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessProductKeyword
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductKeyword> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessProductKeyword> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductKeywordDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProductKeyword-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessProductKeyword> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessProductKeyword> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductKeywordDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessProductKeyword
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductKeyword> findByExample(final BusinessProductKeywordQuery query) throws DaoException {
		List<BusinessProductKeyword> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductKeywordDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessProductKeyword-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessProductKeyword> findByExample(final BusinessProductKeywordQuery query, final Integer limit) throws DaoException {
		List<BusinessProductKeyword> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductKeywordDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductKeyword> findAllPage(final BusinessProductKeywordQuery query) throws DaoException {
		List<BusinessProductKeyword> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductKeywordDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessProductKeywordQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessProductKeywordDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessProductKeyword数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessProductKeyword entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessProductKeywordDao.save",entity);
	}

	/**
	 * 修改BusinessProductKeyword数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessProductKeyword entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessProductKeywordDao.update",entity);
	}

	/**
	 * 删除BusinessProductKeyword
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessProductKeywordDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
