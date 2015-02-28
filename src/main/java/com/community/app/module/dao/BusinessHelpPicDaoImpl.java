package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessHelpPic;
import com.community.app.module.vo.BusinessHelpPicQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessHelpPicDao")
@Transactional
public class BusinessHelpPicDaoImpl implements BusinessHelpPicDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessHelpPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHelpPic findById(final Integer id) throws DaoException {
		BusinessHelpPic businessHelpPic = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpPicDao.findById",id);
		return businessHelpPic;
	}
	
	/**
	 * 无条件查询所有BusinessHelpPic
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpPic> findAll() throws DaoException {
		List<BusinessHelpPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpPicDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessHelpPic
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpPic> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessHelpPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpPicDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpPic-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessHelpPic> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessHelpPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpPicDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessHelpPic
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpPic> findByExample(final BusinessHelpPicQuery query) throws DaoException {
		List<BusinessHelpPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpPicDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelpPic-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessHelpPic> findByExample(final BusinessHelpPicQuery query, final Integer limit) throws DaoException {
		List<BusinessHelpPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpPicDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpPic> findAllPage(final BusinessHelpPicQuery query) throws DaoException {
		List<BusinessHelpPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpPicDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHelpPicQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpPicDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessHelpPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHelpPic entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessHelpPicDao.save",entity);
	}

	/**
	 * 修改BusinessHelpPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHelpPic entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHelpPicDao.update",entity);
	}

	/**
	 * 删除BusinessHelpPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessHelpPicDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
