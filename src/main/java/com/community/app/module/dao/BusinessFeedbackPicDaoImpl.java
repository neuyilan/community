package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessFeedbackPic;
import com.community.app.module.vo.BusinessFeedbackPicQuery;

@Repository("BusinessFeedbackPicDao")
@Transactional
public class BusinessFeedbackPicDaoImpl implements BusinessFeedbackPicDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessFeedbackPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFeedbackPic findById(final Integer id) throws DaoException {
		BusinessFeedbackPic businessFeedbackPic = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFeedbackPicDao.findById",id);
		return businessFeedbackPic;
	}
	
	/**
	 * 无条件查询所有BusinessFeedbackPic
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedbackPic> findAll() throws DaoException {
		List<BusinessFeedbackPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackPicDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessFeedbackPic
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedbackPic> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessFeedbackPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackPicDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFeedbackPic-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessFeedbackPic> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessFeedbackPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackPicDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackPic
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFeedbackPic> findByExample(final BusinessFeedbackPicQuery query) throws DaoException {
		List<BusinessFeedbackPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackPicDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFeedbackPic-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessFeedbackPic> findByExample(final BusinessFeedbackPicQuery query, final Integer limit) throws DaoException {
		List<BusinessFeedbackPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackPicDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFeedbackPic> findAllPage(final BusinessFeedbackPicQuery query) throws DaoException {
		List<BusinessFeedbackPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFeedbackPicDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFeedbackPicQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFeedbackPicDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessFeedbackPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessFeedbackPic entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessFeedbackPicDao.save",entity);
	}

	/**
	 * 修改BusinessFeedbackPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFeedbackPic entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessFeedbackPicDao.update",entity);
	}

	/**
	 * 删除BusinessFeedbackPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessFeedbackPicDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
