package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessOpertaion;
import com.community.app.module.vo.BusinessOpertaionQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessOpertaionDao")
@Transactional
public class BusinessOpertaionDaoImpl implements BusinessOpertaionDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessOpertaion
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessOpertaion findById(final Integer id) throws DaoException {
		BusinessOpertaion businessOpertaion = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessOpertaionDao.findById",id);
		return businessOpertaion;
	}
	
	/**
	 * 无条件查询所有BusinessOpertaion
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessOpertaion> findAll() throws DaoException {
		List<BusinessOpertaion> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessOpertaionDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessOpertaion
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessOpertaion> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessOpertaion> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessOpertaionDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessOpertaion-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessOpertaion> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessOpertaion> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessOpertaionDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessOpertaion
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessOpertaion> findByExample(final BusinessOpertaionQuery query) throws DaoException {
		List<BusinessOpertaion> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessOpertaionDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessOpertaion-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessOpertaion> findByExample(final BusinessOpertaionQuery query, final Integer limit) throws DaoException {
		List<BusinessOpertaion> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessOpertaionDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessOpertaion> findAllPage(final BusinessOpertaionQuery query) throws DaoException {
		List<BusinessOpertaion> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessOpertaionDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessOpertaionQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessOpertaionDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessOpertaion数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessOpertaion entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessOpertaionDao.save",entity);
	}

	/**
	 * 修改BusinessOpertaion数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessOpertaion entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessOpertaionDao.update",entity);
	}

	/**
	 * 删除BusinessOpertaion
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessOpertaionDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
}