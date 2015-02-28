package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessAnno;
import com.community.app.module.bean.index;
import com.community.app.module.vo.BusinessAnnoQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessAnnoDao")
@Transactional
public class BusinessAnnoDaoImpl implements BusinessAnnoDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessAnno
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessAnno findById(final Integer id) throws DaoException {
		BusinessAnno businessAnno = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessAnnoDao.findById",id);
		return businessAnno;
	}
	
	/**
	 * 查询单个BusinessAnno
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessAnno findById_app(final Integer id) throws DaoException {
		BusinessAnno businessAnno = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessAnnoDao.findById_app",id);
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessAnnoDao.updateVisits",id);
		return businessAnno;
	}
	
	/**
	 * 无条件查询所有BusinessAnno
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnno> findAll() throws DaoException {
		List<BusinessAnno> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessAnno
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnno> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessAnno> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessAnno-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessAnno> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessAnno> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessAnno
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessAnno> findByExample(final BusinessAnnoQuery query) throws DaoException {
		List<BusinessAnno> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessAnno-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessAnno> findByExample(final BusinessAnnoQuery query, final Integer limit) throws DaoException {
		List<BusinessAnno> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnno> findAllPage(final BusinessAnnoQuery query) throws DaoException {
		List<BusinessAnno> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoDao.findAllPage",query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据 - 只针对物业
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnno> findAllPageByProperty(final BusinessAnnoQuery query) throws DaoException {
		List<BusinessAnno> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoDao.findAllPageByProperty",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessAnnoQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessAnnoDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数 - 只针对物业
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCountByProperty(final BusinessAnnoQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessAnnoDao.selectCountByProperty",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessAnno> findAllPage_app(final BusinessAnnoQuery query) throws DaoException {
		List<BusinessAnno> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoDao.findAllPage_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_app(final BusinessAnnoQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessAnnoDao.selectCount_app",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<index> findAllPage_index_app(final BusinessAnnoQuery query) throws DaoException {
		List<index> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoDao.findAllPage_index_app",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_index_app(final BusinessAnnoQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessAnnoDao.selectCount_index_app",query);
		return count;
	}
	
	/**
	 * 保存BusinessAnno数据
	 * @param entity
	 * @throws DaoException
	 */
	public Integer save(final BusinessAnno entity) throws DaoException {
		return this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessAnnoDao.save",entity);
	}

	/**
	 * 修改BusinessAnno数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessAnno entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessAnnoDao.update",entity);
	}

	/**
	 * 删除BusinessAnno
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessAnnoDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 根据搜索条件，为后台首页搜索分页记录
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List findAllPageForIndex(final BusinessAnnoQuery query) throws DaoException {
		List<index> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessAnnoDao.findAllPageForIndex",query);
		return list;
	}

	/**
	 * 根据搜索条件，为后台首页搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCountForIndex(final BusinessAnnoQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessAnnoDao.selectCountForIndex",query);
		return count;
	}
}
