package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessPropertyMaterial;
import com.community.app.module.vo.BusinessPropertyMaterialQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessPropertyMaterialDao")
@Transactional
public class BusinessPropertyMaterialDaoImpl implements BusinessPropertyMaterialDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessPropertyMaterial
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessPropertyMaterial findById(final Integer id) throws DaoException {
		BusinessPropertyMaterial businessPropertyMaterial = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessPropertyMaterialDao.findById",id);
		return businessPropertyMaterial;
	}
	
	/**
	 * 无条件查询所有BusinessPropertyMaterial
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessPropertyMaterial> findAll() throws DaoException {
		List<BusinessPropertyMaterial> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPropertyMaterialDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessPropertyMaterial
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPropertyMaterial> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessPropertyMaterial> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPropertyMaterialDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessPropertyMaterial-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessPropertyMaterial> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessPropertyMaterial> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPropertyMaterialDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessPropertyMaterial
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessPropertyMaterial> findByExample(final BusinessPropertyMaterialQuery query) throws DaoException {
		List<BusinessPropertyMaterial> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPropertyMaterialDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessPropertyMaterial-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessPropertyMaterial> findByExample(final BusinessPropertyMaterialQuery query, final Integer limit) throws DaoException {
		List<BusinessPropertyMaterial> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPropertyMaterialDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessPropertyMaterial> findAllPage(final BusinessPropertyMaterialQuery query) throws DaoException {
		List<BusinessPropertyMaterial> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessPropertyMaterialDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessPropertyMaterialQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessPropertyMaterialDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessPropertyMaterial数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessPropertyMaterial entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessPropertyMaterialDao.save",entity);
	}

	/**
	 * 修改BusinessPropertyMaterial数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessPropertyMaterial entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessPropertyMaterialDao.update",entity);
	}

	/**
	 * 删除BusinessPropertyMaterial
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessPropertyMaterialDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
