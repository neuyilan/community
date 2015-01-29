package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessCommunity;
import com.community.app.module.common.CommunityBean;
import com.community.app.module.vo.BusinessCommunityQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Repository("BusinessCommunityDao")
@Transactional
public class BusinessCommunityDaoImpl implements BusinessCommunityDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessCommunity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessCommunity findById(final Integer id) throws DaoException {
		BusinessCommunity businessCommunity = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessCommunityDao.findById",id);
		return businessCommunity;
	}
	
	/**
	 * 查询单个BusinessCommunity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessCommunity> findByComId(final Integer id) throws DaoException {
		List<BusinessCommunity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessCommunityDao.findByComId",id);
		return list;
	}
	
	/**
	 * 无条件查询所有BusinessCommunity
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessCommunity> findAll() throws DaoException {
		List<BusinessCommunity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessCommunityDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessCommunity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessCommunity> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessCommunity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessCommunityDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessCommunity (关联BUSINESS_USER_RESOURCE 查询)
	 * @return
	 * @throws DaoException
	 */	
	public List<CommunityBean> findByCon(final Map<String, Object> paramMap) throws DaoException {
		List<CommunityBean> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessCommunityDao.findByCon", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessCommunity-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessCommunity> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessCommunity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessCommunityDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessCommunity
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessCommunity> findByExample(final BusinessCommunityQuery query) throws DaoException {
		List<BusinessCommunity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessCommunityDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessCommunity-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessCommunity> findByExample(final BusinessCommunityQuery query, final Integer limit) throws DaoException {
		List<BusinessCommunity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessCommunityDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessCommunity> findAllPage(final BusinessCommunityQuery query) throws DaoException {
		List<BusinessCommunity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessCommunityDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessCommunityQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessCommunityDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessCommunity数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessCommunity entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessCommunityDao.save",entity);
	}

	/**
	 * 修改BusinessCommunity数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessCommunity entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessCommunityDao.update",entity);
	}

	/**
	 * 删除BusinessCommunity
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessCommunityDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 获取用户负责的社区
	 * @param userId
	 * @return
	 * @throws ServiceException
	 */
	public List<BusinessCommunity> findComsByUser(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessCommunity> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessCommunityDao.findComsByUser",paramMap);
		return list;
	}
	
}
