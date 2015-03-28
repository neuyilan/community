package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessStationFeedback;
import com.community.app.module.vo.BusinessStationFeedbackQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessStationFeedbackDao")
@Transactional
public class BusinessStationFeedbackDaoImpl implements BusinessStationFeedbackDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessStationFeedback
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessStationFeedback findById(final Integer id) throws DaoException {
		BusinessStationFeedback businessStationFeedback = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessStationFeedbackDao.findById",id);
		return businessStationFeedback;
	}
	
	/**
	 * 无条件查询所有BusinessStationFeedback
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStationFeedback> findAll() throws DaoException {
		List<BusinessStationFeedback> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationFeedbackDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessStationFeedback
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStationFeedback> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessStationFeedback> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationFeedbackDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessStationFeedback-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessStationFeedback> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessStationFeedback> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationFeedbackDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessStationFeedback
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStationFeedback> findByExample(final BusinessStationFeedbackQuery query) throws DaoException {
		List<BusinessStationFeedback> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationFeedbackDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessStationFeedback-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessStationFeedback> findByExample(final BusinessStationFeedbackQuery query, final Integer limit) throws DaoException {
		List<BusinessStationFeedback> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationFeedbackDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStationFeedback> findAllPage(final BusinessStationFeedbackQuery query) throws DaoException {
		List<BusinessStationFeedback> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationFeedbackDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessStationFeedbackQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessStationFeedbackDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessStationFeedback数据
	 * @param entity
	 * @throws DaoException
	 */
	public int save(final BusinessStationFeedback entity) throws DaoException {
		int id = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessStationFeedbackDao.save",entity);
		return id;
	}

	/**
	 * 修改BusinessStationFeedback数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessStationFeedback entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessStationFeedbackDao.update",entity);
	}

	/**
	 * 删除BusinessStationFeedback
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessStationFeedbackDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
}