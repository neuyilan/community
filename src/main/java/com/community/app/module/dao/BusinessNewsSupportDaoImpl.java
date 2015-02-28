package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessNewsSupport;
import com.community.app.module.vo.BusinessNewsSupportQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessNewsSupportDao")
@Transactional
public class BusinessNewsSupportDaoImpl implements BusinessNewsSupportDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessNewsSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessNewsSupport findById(final Integer id) throws DaoException {
		BusinessNewsSupport businessNewsSupport = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewsSupportDao.findById",id);
		return businessNewsSupport;
	}
	
	/**
	 * 无条件查询所有BusinessNewsSupport
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsSupport> findAll() throws DaoException {
		List<BusinessNewsSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsSupportDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessNewsSupport
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsSupport> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessNewsSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsSupportDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessNewsSupport-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsSupport> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessNewsSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsSupportDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNewsSupport
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsSupport> findByExample(final BusinessNewsSupportQuery query) throws DaoException {
		List<BusinessNewsSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsSupportDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessNewsSupport-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessNewsSupport> findByExample(final BusinessNewsSupportQuery query, final Integer limit) throws DaoException {
		List<BusinessNewsSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsSupportDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessNewsSupport> findAllPage(final BusinessNewsSupportQuery query) throws DaoException {
		List<BusinessNewsSupport> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessNewsSupportDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessNewsSupportQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessNewsSupportDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessNewsSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessNewsSupport entity) throws DaoException {
		int  count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessNewsSupportDao.save",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessNewsDao.updateSupports",entity);
		}
	}

	/**
	 * 修改BusinessNewsSupport数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessNewsSupport entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessNewsSupportDao.update",entity);
	}

	/**
	 * 删除BusinessNewsSupport
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessNewsSupportDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
