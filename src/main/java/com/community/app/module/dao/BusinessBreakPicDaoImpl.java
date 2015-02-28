package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessBreakPic;
import com.community.app.module.vo.BusinessBreakPicQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessBreakPicDao")
@Transactional
public class BusinessBreakPicDaoImpl implements BusinessBreakPicDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessBreakPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessBreakPic findById(final Integer id) throws DaoException {
		BusinessBreakPic businessBreakPic = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessBreakPicDao.findById",id);
		return businessBreakPic;
	}
	
	/**
	 * 无条件查询所有BusinessBreakPic
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakPic> findAll() throws DaoException {
		List<BusinessBreakPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakPicDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessBreakPic
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreakPic> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessBreakPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakPicDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessBreakPic-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessBreakPic> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessBreakPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakPicDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 根据爆料ID查询所有爆料的图片BusinessBreakPic
	 * @param entity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakPic> findPicListByBreakId(final BusinessBreakPicQuery query) throws DaoException {
		List<BusinessBreakPic> list  = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakPicDao.findPicListByBreakId",query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBreakPic
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessBreakPic> findByExample(final BusinessBreakPicQuery query) throws DaoException {
		List<BusinessBreakPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakPicDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessBreakPic-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessBreakPic> findByExample(final BusinessBreakPicQuery query, final Integer limit) throws DaoException {
		List<BusinessBreakPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakPicDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessBreakPic> findAllPage(final BusinessBreakPicQuery query) throws DaoException {
		List<BusinessBreakPic> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessBreakPicDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessBreakPicQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessBreakPicDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessBreakPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessBreakPic entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessBreakPicDao.save",entity);
	}

	/**
	 * 修改BusinessBreakPic数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessBreakPic entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessBreakPicDao.update",entity);
	}

	/**
	 * 删除BusinessBreakPic
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessBreakPicDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
