package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessRegPic;
import com.community.app.module.vo.BusinessRegPicQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessRegPicDao")
@Transactional
public class BusinessRegPicDaoImpl implements BusinessRegPicDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessRegPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRegPic findById(final Integer id) throws DaoException {
		BusinessRegPic businessRegPic = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessRegPicDao.findById",id);
		return businessRegPic;
	}
	
	/**
	 * 无条件查询所有BusinessRegPic
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRegPic> findAll() throws DaoException {
		List<BusinessRegPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRegPicDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessRegPic
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRegPic> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessRegPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRegPicDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRegPic-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRegPic> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessRegPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRegPicDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRegPic
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRegPic> findByExample(final BusinessRegPicQuery query) throws DaoException {
		List<BusinessRegPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRegPicDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRegPic-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRegPic> findByExample(final BusinessRegPicQuery query, final Integer limit) throws DaoException {
		List<BusinessRegPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRegPicDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRegPic> findAllPage(final BusinessRegPicQuery query) throws DaoException {
		List<BusinessRegPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRegPicDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRegPicQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessRegPicDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessRegPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRegPic entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessRegPicDao.save",entity);
	}

	/**
	 * 修改BusinessRegPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRegPic entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessRegPicDao.update",entity);
	}

	/**
	 * 删除BusinessRegPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessRegPicDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
