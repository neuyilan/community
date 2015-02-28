package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessRepairPic;
import com.community.app.module.vo.BusinessRepairPicQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessRepairPicDao")
@Transactional
public class BusinessRepairPicDaoImpl implements BusinessRepairPicDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessRepairPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessRepairPic findById(final Integer id) throws DaoException {
		BusinessRepairPic businessRepairPic = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessRepairPicDao.findById",id);
		return businessRepairPic;
	}
	
	/**
	 * 无条件查询所有BusinessRepairPic
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairPic> findAll() throws DaoException {
		List<BusinessRepairPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairPicDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessRepairPic
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairPic> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessRepairPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairPicDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessRepairPic-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRepairPic> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessRepairPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairPicDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessRepairPic
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessRepairPic> findByExample(final BusinessRepairPicQuery query) throws DaoException {
		List<BusinessRepairPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairPicDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessRepairPic-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessRepairPic> findByExample(final BusinessRepairPicQuery query, final Integer limit) throws DaoException {
		List<BusinessRepairPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairPicDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessRepairPic> findAllPage(final BusinessRepairPicQuery query) throws DaoException {
		List<BusinessRepairPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessRepairPicDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessRepairPicQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessRepairPicDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessRepairPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessRepairPic entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessRepairPicDao.save",entity);
	}

	/**
	 * 修改BusinessRepairPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessRepairPic entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessRepairPicDao.update",entity);
	}

	/**
	 * 删除BusinessRepairPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessRepairPicDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
