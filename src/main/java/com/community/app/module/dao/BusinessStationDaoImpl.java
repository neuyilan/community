package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import com.community.framework.exception.DaoException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessStation;
import com.community.app.module.vo.BusinessStationQuery;

@Repository("BusinessStationDao")
@Transactional
public class BusinessStationDaoImpl implements BusinessStationDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessStation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessStation findById(final Integer id) throws DaoException {
		BusinessStation businessStation = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessStationDao.findById",id);
		return businessStation;
	}
	
	/**
	 * 无条件查询所有BusinessStation
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStation> findAll() throws DaoException {
		List<BusinessStation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessStation
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStation> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessStation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessStation-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessStation> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessStation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessStation
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStation> findByExample(final BusinessStationQuery query) throws DaoException {
		List<BusinessStation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessStation-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessStation> findByExample(final BusinessStationQuery query, final Integer limit) throws DaoException {
		List<BusinessStation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStation> findAllPage(final BusinessStationQuery query) throws DaoException {
		List<BusinessStation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessStationQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessStationDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessStation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessStation entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessStationDao.save",entity);
	}

	/**
	 * 修改BusinessStation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessStation entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessStationDao.update",entity);
	}

	/**
	 * 删除BusinessStation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessStationDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
