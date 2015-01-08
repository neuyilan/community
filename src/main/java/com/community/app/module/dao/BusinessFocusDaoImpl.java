package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import com.community.framework.exception.DaoException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessFocus;
import com.community.app.module.vo.BusinessFocusQuery;

@Repository("BusinessFocusDao")
@Transactional
public class BusinessFocusDaoImpl implements BusinessFocusDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessFocus
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFocus findById(final Integer id) throws DaoException {
		BusinessFocus businessFocus = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFocusDao.findById",id);
		return businessFocus;
	}
	
	/**
	 * 查询单个BusinessFocus
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFocus> findById_app(final Integer id) throws DaoException {
		List<BusinessFocus> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFocusDao.findById_app",id);
		return list;
	}
	
	/**
	 * 无条件查询所有BusinessFocus
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFocus> findAll() throws DaoException {
		List<BusinessFocus> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFocusDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessFocus
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFocus> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessFocus> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFocusDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFocus-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessFocus> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessFocus> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFocusDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessFocus
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFocus> findByExample(final BusinessFocusQuery query) throws DaoException {
		List<BusinessFocus> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFocusDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFocus-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessFocus> findByExample(final BusinessFocusQuery query, final Integer limit) throws DaoException {
		List<BusinessFocus> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFocusDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFocus> findAllPage(final BusinessFocusQuery query) throws DaoException {
		List<BusinessFocus> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFocusDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFocusQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFocusDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessFocus数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessFocus entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessFocusDao.save",entity);
	}

	/**
	 * 修改BusinessFocus数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFocus entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessFocusDao.update",entity);
	}

	/**
	 * 删除BusinessFocus
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessFocusDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * service
	 * 修改BusinessFocus浏览量
	 * @param entity
	 * @throws DaoException
	 */
	public void updateVisits(final BusinessFocus entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessFocusDao.updateVisits",entity.getFocusId());
	}
	
}
