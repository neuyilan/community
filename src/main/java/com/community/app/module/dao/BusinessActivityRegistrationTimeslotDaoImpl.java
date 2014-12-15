package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessActivityRegistrationTimeslot;
import com.community.app.module.vo.BusinessActivityRegistrationTimeslotQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessActivityRegistrationTimeslotDao")
@Transactional
public class BusinessActivityRegistrationTimeslotDaoImpl implements BusinessActivityRegistrationTimeslotDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessActivityRegistrationTimeslot
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityRegistrationTimeslot findById(final Integer id) throws DaoException {
		BusinessActivityRegistrationTimeslot businessActivityRegistrationTimeslot = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityRegistrationTimeslotDao.findById",id);
		return businessActivityRegistrationTimeslot;
	}
	
	/**
	 * 无条件查询所有BusinessActivityRegistrationTimeslot
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityRegistrationTimeslot> findAll() throws DaoException {
		List<BusinessActivityRegistrationTimeslot> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityRegistrationTimeslotDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessActivityRegistrationTimeslot
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityRegistrationTimeslot> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessActivityRegistrationTimeslot> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityRegistrationTimeslotDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityRegistrationTimeslot-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityRegistrationTimeslot> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessActivityRegistrationTimeslot> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityRegistrationTimeslotDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityRegistrationTimeslot
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityRegistrationTimeslot> findByExample(final BusinessActivityRegistrationTimeslotQuery query) throws DaoException {
		List<BusinessActivityRegistrationTimeslot> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityRegistrationTimeslotDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityRegistrationTimeslot-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityRegistrationTimeslot> findByExample(final BusinessActivityRegistrationTimeslotQuery query, final Integer limit) throws DaoException {
		List<BusinessActivityRegistrationTimeslot> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityRegistrationTimeslotDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityRegistrationTimeslot> findAllPage(final BusinessActivityRegistrationTimeslotQuery query) throws DaoException {
		List<BusinessActivityRegistrationTimeslot> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityRegistrationTimeslotDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityRegistrationTimeslotQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityRegistrationTimeslotDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessActivityRegistrationTimeslot数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityRegistrationTimeslot entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessActivityRegistrationTimeslotDao.save",entity);
	}

	/**
	 * 修改BusinessActivityRegistrationTimeslot数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityRegistrationTimeslot entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityRegistrationTimeslotDao.update",entity);
	}

	/**
	 * 删除BusinessActivityRegistrationTimeslot
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessActivityRegistrationTimeslotDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
}