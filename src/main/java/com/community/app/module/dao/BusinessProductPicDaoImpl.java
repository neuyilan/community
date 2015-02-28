package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessProductPic;
import com.community.app.module.vo.BusinessProductPicQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessProductPicDao")
@Transactional
public class BusinessProductPicDaoImpl implements BusinessProductPicDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessProductPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessProductPic findById(final Integer id) throws DaoException {
		BusinessProductPic businessProductPic = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessProductPicDao.findById",id);
		return businessProductPic;
	}
	
	/**
	 * 无条件查询所有BusinessProductPic
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductPic> findAll() throws DaoException {
		List<BusinessProductPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductPicDao.findAll");
		return list;
	}
	
	/**
	 * 根据跳蚤市场ID查询所有BusinessProductPic
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductPic> findAllPicbyId(final Integer id) throws DaoException {
		List<BusinessProductPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductPicDao.findAllPicbyId", id);
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessProductPic
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductPic> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessProductPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductPicDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessProductPic-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessProductPic> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessProductPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductPicDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessProductPic
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessProductPic> findByExample(final BusinessProductPicQuery query) throws DaoException {
		List<BusinessProductPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductPicDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessProductPic-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessProductPic> findByExample(final BusinessProductPicQuery query, final Integer limit) throws DaoException {
		List<BusinessProductPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductPicDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessProductPic> findAllPage(final BusinessProductPicQuery query) throws DaoException {
		List<BusinessProductPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessProductPicDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessProductPicQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessProductPicDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessProductPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessProductPic entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessProductPicDao.save",entity);
	}
	
	/**
	 * 保存BusinessProductPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save_app(final BusinessProductPic entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessProductPicDao.save_app",entity);
	}

	/**
	 * 修改BusinessProductPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessProductPic entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessProductPicDao.update",entity);
	}

	/**
	 * 删除BusinessProductPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessProductPicDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 删除BusinessProductPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete_app(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessProductPicDao.delete_app",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
