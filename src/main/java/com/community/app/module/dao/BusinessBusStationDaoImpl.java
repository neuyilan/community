package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessBusStation;
import com.community.app.module.vo.BusinessBusStationQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Repository("BusinessBusStationDao")
@Transactional
public class BusinessBusStationDaoImpl implements BusinessBusStationDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessBusStation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessBusStation findById(final Integer id) throws DaoException {
		BusinessBusStation businessBusStation = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessBusStationDao.findById",id);
		return businessBusStation;
	}
	
	/**
	 * 根据id查询该站点下的线路
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBusStationQuery> findStaBus(final Integer id) throws DaoException {
		List<BusinessBusStationQuery> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBusStationDao.findStaBus",id);
		return list;
	}
	
	/**
	 * 无条件查询所有BusinessBusStation
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBusStation> findAll() throws DaoException {
		List<BusinessBusStation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBusStationDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessBusStation
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBusStation> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessBusStation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBusStationDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBusStation-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBusStation> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessBusStation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBusStationDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBusStation
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBusStation> findByExample(final BusinessBusStationQuery query) throws DaoException {
		List<BusinessBusStation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBusStationDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBusStation-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBusStation> findByExample(final BusinessBusStationQuery query, final Integer limit) throws DaoException {
		List<BusinessBusStation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBusStationDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBusStation> findAllPage(final BusinessBusStationQuery query) throws DaoException {
		List<BusinessBusStation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBusStationDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessBusStationQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessBusStationDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessBusStation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessBusStation entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessBusStationDao.save",entity);
	}

	/**
	 * 修改BusinessBusStation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessBusStation entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessBusStationDao.update",entity);
	}

	/**
	 * 删除BusinessBusStation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessBusStationDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
