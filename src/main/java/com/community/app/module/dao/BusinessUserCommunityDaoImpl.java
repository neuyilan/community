package com.community.app.module.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessUserCommunity;
import com.community.app.module.vo.BusinessUserCommunityQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessUserCommunityDao")
@Transactional
public class BusinessUserCommunityDaoImpl implements BusinessUserCommunityDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessUserCommunity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessUserCommunity findById(final Integer id) throws DaoException {
		BusinessUserCommunity businessUserCommunity = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessUserCommunityDao.findById",id);
		return businessUserCommunity;
	}
	
	/**
	 * 无条件查询所有BusinessUserCommunity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUserCommunity> findAll() throws DaoException {
		List<BusinessUserCommunity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserCommunityDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessUserCommunity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserCommunity> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessUserCommunity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserCommunityDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessUserCommunity-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessUserCommunity> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessUserCommunity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserCommunityDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessUserCommunity
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserCommunity> findByExample(final BusinessUserCommunityQuery query) throws DaoException {
		List<BusinessUserCommunity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserCommunityDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessUserCommunity-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessUserCommunity> findByExample(final BusinessUserCommunityQuery query, final Integer limit) throws DaoException {
		List<BusinessUserCommunity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserCommunityDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUserCommunity> findAllPage(final BusinessUserCommunityQuery query) throws DaoException {
		List<BusinessUserCommunity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserCommunityDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessUserCommunityQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessUserCommunityDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessUserCommunity数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessUserCommunity entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessUserCommunityDao.save",entity);
	}

	/**
	 * 修改BusinessUserCommunity数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessUserCommunity entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessUserCommunityDao.update",entity);
	}

	/**
	 * 删除BusinessUserCommunity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessUserCommunityDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 根据搜索条件，搜索分页所需的数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessUserCommunity> findAllPageByField(final Map fieldMap, final BusinessUserCommunityQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessUserCommunity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserCommunityDao.findAllPageByField",query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessUserCommunity> findListByField(final Map fieldMap, final BusinessUserCommunityQuery query) throws DaoException {
		query.setFieldMap(fieldMap);
		List<BusinessUserCommunity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessUserCommunityDao.findListByField", query);
		return list;
	}
	
	/**
	 * 根据条件查询所需字段，返回对象
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessUserCommunity findByField(final Map fieldMap, final Integer id) throws DaoException {
		Map paramMap = new HashMap();
		paramMap.put("id", id);
		paramMap.put("fieldMap", fieldMap);
		BusinessUserCommunity businessUserCommunity = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessUserCommunityDao.findByField",paramMap);
		return businessUserCommunity;
	}
	
}
