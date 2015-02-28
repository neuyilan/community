package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessCharger;
import com.community.app.module.vo.BusinessChargerQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessChargerDao")
@Transactional
public class BusinessChargerDaoImpl implements BusinessChargerDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessCharger
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessCharger findById(final Integer id) throws DaoException {
		BusinessCharger businessCharger = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessChargerDao.findById",id);
		return businessCharger;
	}
	
	/**
	 * 无条件查询所有BusinessCharger
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessCharger> findAll() throws DaoException {
		List<BusinessCharger> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChargerDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessCharger
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessCharger> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessCharger> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChargerDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessCharger-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessCharger> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessCharger> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChargerDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessCharger
	 * @param
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessCharger> findByExample(final BusinessChargerQuery query) throws DaoException {
		List<BusinessCharger> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChargerDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessCharger-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessCharger> findByExample(final BusinessChargerQuery query, final Integer limit) throws DaoException {
		List<BusinessCharger> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChargerDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessCharger> findAllPage(final BusinessChargerQuery query) throws DaoException {
		List<BusinessCharger> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChargerDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessChargerQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessChargerDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessCharger数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessCharger entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessChargerDao.save",entity);
	}

	/**
	 * 修改BusinessCharger数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessCharger entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessChargerDao.update",entity);
	}

	/**
	 * 删除BusinessCharger
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessChargerDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}

    public void savelargeData(final List list) throws DaoException {
        sqlSessionTemplate.insert("com.community.app.module.dao.BusinessChargerDao.savelargeData", list);
    }
}
