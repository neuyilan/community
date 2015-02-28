package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessNewsView;
import com.community.app.module.vo.BusinessNewsViewQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessNewsViewDao")
@Transactional
public class BusinessNewsViewDaoImpl implements BusinessNewsViewDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessNewsView
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNewsView findById(final Integer id) throws DaoException {
		BusinessNewsView businessNewsView = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewsViewDao.findById",id);
		return businessNewsView;
	}
	
	/**
	 * 无条件查询所有BusinessNewsView
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsView> findAll() throws DaoException {
		List<BusinessNewsView> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsViewDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessNewsView
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsView> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessNewsView> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsViewDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewsView-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessNewsView> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessNewsView> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsViewDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessNewsView
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsView> findByExample(final BusinessNewsViewQuery query) throws DaoException {
		List<BusinessNewsView> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsViewDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNewsView-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessNewsView> findByExample(final BusinessNewsViewQuery query, final Integer limit) throws DaoException {
		List<BusinessNewsView> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsViewDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsView> findAllPage(final BusinessNewsViewQuery query) throws DaoException {
		List<BusinessNewsView> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsViewDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessNewsViewQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewsViewDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessNewsView数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessNewsView entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessNewsViewDao.save",entity);
	}

	/**
	 * 修改BusinessNewsView数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessNewsView entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessNewsViewDao.update",entity);
	}

	/**
	 * 删除BusinessNewsView
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessNewsViewDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
