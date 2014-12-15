package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessChargeAnno;
import com.community.app.module.vo.BusinessChargeAnnoQuery;

@Repository("BusinessChargeAnnoDao")
@Transactional
public class BusinessChargeAnnoDaoImpl implements BusinessChargeAnnoDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessChargeAnno
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessChargeAnno findById(final Integer id) throws DaoException {
		BusinessChargeAnno businessChargeAnno = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessChargeAnnoDao.findById",id);
		return businessChargeAnno;
	}
	
	/**
	 * 无条件查询所有BusinessChargeAnno
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChargeAnno> findAll() throws DaoException {
		List<BusinessChargeAnno> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChargeAnnoDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessChargeAnno
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessChargeAnno> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessChargeAnno> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChargeAnnoDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessChargeAnno-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessChargeAnno> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessChargeAnno> list = this.sqlSessionTemplate.selectList("com.community.app.app.dao.BusinessChargeAnnoDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessChargeAnno
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessChargeAnno> findByExample(final BusinessChargeAnnoQuery query) throws DaoException {
		List<BusinessChargeAnno> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChargeAnnoDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessChargeAnno-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessChargeAnno> findByExample(final BusinessChargeAnnoQuery query, final Integer limit) throws DaoException {
		List<BusinessChargeAnno> list = this.sqlSessionTemplate.selectList("com.community.app.app.dao.BusinessChargeAnnoDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessChargeAnno> findAllPage(final BusinessChargeAnnoQuery query) throws DaoException {
		List<BusinessChargeAnno> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessChargeAnnoDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessChargeAnnoQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessChargeAnnoDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessChargeAnno数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessChargeAnno entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessChargeAnnoDao.save",entity);
	}

	/**
	 * 修改BusinessChargeAnno数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessChargeAnno entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessChargeAnnoDao.update",entity);
	}

	/**
	 * 删除BusinessChargeAnno
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessChargeAnnoDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
