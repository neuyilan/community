package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessImages;
import com.community.app.module.vo.BusinessImagesQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessImagesDao")
@Transactional
public class BusinessImagesDaoImpl implements BusinessImagesDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessImages
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessImages findById(final Integer id) throws DaoException {
		BusinessImages businessImages = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessImagesDao.findById",id);
		return businessImages;
	}
	
	/**
	 * 无条件查询所有BusinessImages
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessImages> findAll() throws DaoException {
		List<BusinessImages> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessImagesDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessImages
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessImages> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessImages> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessImagesDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessImages-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessImages> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessImages> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessImagesDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessImages
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessImages> findByExample(final BusinessImagesQuery query) throws DaoException {
		List<BusinessImages> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessImagesDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessImages-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessImages> findByExample(final BusinessImagesQuery query, final Integer limit) throws DaoException {
		List<BusinessImages> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessImagesDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessImages> findAllPage(final BusinessImagesQuery query) throws DaoException {
		List<BusinessImages> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessImagesDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessImagesQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessImagesDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessImages数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessImages entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessImagesDao.save",entity);
	}

	/**
	 * 修改BusinessImages数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessImages entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessImagesDao.update",entity);
	}

	/**
	 * 删除BusinessImages
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessImagesDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
}