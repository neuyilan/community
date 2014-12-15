package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;




import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.BusinessBus;
import com.community.app.module.vo.BusinessBusQuery;

@Repository("BusinessBusDao")
@Transactional
public class BusinessBusDaoImpl implements BusinessBusDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessBus
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessBus findById(final Integer id) throws DaoException {
		BusinessBus businessBus = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessBusDao.findById",id);
		return businessBus;
	}
	
	/**
	 * 查询线路的所有站点
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessBusQuery> busLineDetails(final Integer id) {
		List<BusinessBusQuery> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBusDao.busLineDetails",id);
		return list;
	}
	
	/**
	 * 无条件查询所有BusinessBus
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBus> findAll() throws DaoException {
		List<BusinessBus> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBusDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessBus
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBus> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessBus> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBusDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBus-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBus> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessBus> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBusDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBus
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBus> findByExample(final BusinessBusQuery query) throws DaoException {
		List<BusinessBus> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBusDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBus-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBus> findByExample(final BusinessBusQuery query, final Integer limit) throws DaoException {
		List<BusinessBus> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBusDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBus> findAllPage(final BusinessBusQuery query) throws DaoException {
		List<BusinessBus> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBusDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessBusQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessBusDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessBus数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessBus entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessBusDao.save",entity);
	}

	/**
	 * 修改BusinessBus数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessBus entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessBusDao.update",entity);
	}

	/**
	 * 删除BusinessBus
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessBusDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
