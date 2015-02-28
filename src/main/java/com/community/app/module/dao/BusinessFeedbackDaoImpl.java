package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessFeedback;
import com.community.app.module.vo.BusinessFeedbackQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessFeedbackDao")
@Transactional
public class BusinessFeedbackDaoImpl implements BusinessFeedbackDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessFeedback
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFeedback findById(final Integer id) throws DaoException {
		BusinessFeedback businessFeedback = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFeedbackDao.findById",id);
		return businessFeedback;
	}
	
	/**
	 * service
	 * 查询单个BusinessFeedback
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFeedback findById_app(final Integer id) throws DaoException {
		BusinessFeedback businessFeedback = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFeedbackDao.findById_app",id);
		return businessFeedback;
	}
	
	/**
	 * 无条件查询所有BusinessFeedback
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedback> findAll() throws DaoException {
		List<BusinessFeedback> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessFeedback
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedback> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessFeedback> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFeedback-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessFeedback> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessFeedback> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessFeedback
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedback> findByExample(final BusinessFeedbackQuery query) throws DaoException {
		List<BusinessFeedback> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFeedback-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessFeedback> findByExample(final BusinessFeedbackQuery query, final Integer limit) throws DaoException {
		List<BusinessFeedback> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedback> findAllPage(final BusinessFeedbackQuery query) throws DaoException {
		List<BusinessFeedback> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackDao.findAllPage",query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据 - 针对物业
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedback> findAllPageByProperty(final BusinessFeedbackQuery query) throws DaoException {
		List<BusinessFeedback> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackDao.findAllPageByProperty",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFeedbackQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFeedbackDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数 - 针对物业
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCountByProperty(final BusinessFeedbackQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFeedbackDao.selectCountByProperty",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedback> findAllPage_app(final BusinessFeedbackQuery query) throws DaoException {
		List<BusinessFeedback> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessFeedbackQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFeedbackDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessFeedback数据
	 * @param entity
	 * @return 
	 * @throws DaoException
	 */
	public BusinessFeedback save(final BusinessFeedback entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessFeedbackDao.save",entity);
		return entity;
	}

	/**
	 * 修改BusinessFeedback数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFeedback entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessFeedbackDao.update",entity);
	}

	/**
	 * 删除BusinessFeedback
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessFeedbackDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
