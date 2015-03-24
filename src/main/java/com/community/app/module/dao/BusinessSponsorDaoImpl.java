package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessSponsor;
import com.community.app.module.vo.BusinessSponsorQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessSponsorDao")
@Transactional
public class BusinessSponsorDaoImpl implements BusinessSponsorDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessSponsor
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessSponsor findById(final Integer id) throws DaoException {
		BusinessSponsor businessSponsor = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessSponsorDao.findById",id);
		return businessSponsor;
	}
	
	/**
	 * 无条件查询所有BusinessSponsor
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessSponsor> findAll() throws DaoException {
		List<BusinessSponsor> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessSponsorDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessSponsor
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessSponsor> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessSponsor> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessSponsorDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessSponsor-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessSponsor> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessSponsor> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessSponsorDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessSponsor
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessSponsor> findByExample(final BusinessSponsorQuery query) throws DaoException {
		List<BusinessSponsor> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessSponsorDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessSponsor-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessSponsor> findByExample(final BusinessSponsorQuery query, final Integer limit) throws DaoException {
		List<BusinessSponsor> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessSponsorDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessSponsor> findAllPage(final BusinessSponsorQuery query) throws DaoException {
		List<BusinessSponsor> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessSponsorDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessSponsorQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessSponsorDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessSponsor数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessSponsor entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessSponsorDao.save",entity);
	}

	/**
	 * 修改BusinessSponsor数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessSponsor entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessSponsorDao.update",entity);
	}

	/**
	 * 删除BusinessSponsor
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessSponsorDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
