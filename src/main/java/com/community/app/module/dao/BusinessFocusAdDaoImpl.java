package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessFocusAd;
import com.community.app.module.vo.BusinessFocusAdQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessFocusAdDao")
@Transactional
public class BusinessFocusAdDaoImpl implements BusinessFocusAdDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessFocusAd
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFocusAd findById(final Integer id) throws DaoException {
		BusinessFocusAd businessFocusAd = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFocusAdDao.findById",id);
		return businessFocusAd;
	}
	
	/**
	 * 查询单个BusinessFocus
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFocusAd> findById_app(final Integer id) throws DaoException {
		List<BusinessFocusAd> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFocusAdDao.findById_app",id);
		return list;
	}
	
	/**
	 * 无条件查询所有BusinessFocusAd
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFocusAd> findAll() throws DaoException {
		List<BusinessFocusAd> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFocusAdDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessFocusAd
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFocusAd> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessFocusAd> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFocusAdDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFocusAd-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessFocusAd> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessFocusAd> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFocusAdDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessFocusAd
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFocusAd> findByExample(final BusinessFocusAdQuery query) throws DaoException {
		List<BusinessFocusAd> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFocusAdDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFocusAd-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessFocusAd> findByExample(final BusinessFocusAdQuery query, final Integer limit) throws DaoException {
		List<BusinessFocusAd> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFocusAdDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFocusAd> findAllPage(final BusinessFocusAdQuery query) throws DaoException {
		List<BusinessFocusAd> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFocusAdDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFocusAdQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFocusAdDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessFocusAd数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessFocusAd entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessFocusAdDao.save",entity);
	}

	/**
	 * 修改BusinessFocusAd数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFocusAd entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessFocusAdDao.update",entity);
	}

	/**
	 * 删除BusinessFocusAd
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessFocusAdDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * service
	 * 修改BusinessFocusAd浏览量
	 * @param entity
	 * @throws DaoException
	 */
	public void updateVisits(final BusinessFocusAd entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessFocusAdDao.updateVisits",entity.getFocusAdId());
	}
}