package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessActivityVoteInformation;
import com.community.app.module.vo.BusinessActivityVoteInformationQuery;

@Repository("BusinessActivityVoteInformationDao")
@Transactional
public class BusinessActivityVoteInformationDaoImpl implements BusinessActivityVoteInformationDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessActivityVoteInformation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityVoteInformation findById(final Integer id) throws DaoException {
		BusinessActivityVoteInformation businessActivityVoteInformation = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityVoteInformationDao.findById",id);
		return businessActivityVoteInformation;
	}
	
	/**
	 * 无条件查询所有BusinessActivityVoteInformation
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityVoteInformation> findAll() throws DaoException {
		List<BusinessActivityVoteInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityVoteInformationDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessActivityVoteInformation
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityVoteInformation> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessActivityVoteInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityVoteInformationDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityVoteInformation-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityVoteInformation> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessActivityVoteInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityVoteInformationDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityVoteInformation
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityVoteInformation> findByExample(final BusinessActivityVoteInformationQuery query) throws DaoException {
		List<BusinessActivityVoteInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityVoteInformationDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityVoteInformation-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityVoteInformation> findByExample(final BusinessActivityVoteInformationQuery query, final Integer limit) throws DaoException {
		List<BusinessActivityVoteInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityVoteInformationDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityVoteInformation> findAllPage(final BusinessActivityVoteInformationQuery query) throws DaoException {
		List<BusinessActivityVoteInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityVoteInformationDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityVoteInformationQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityVoteInformationDao.selectCount",query);
		return count;
	}
	
	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount_userId(final BusinessActivityVoteInformationQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityVoteInformationDao.selectCount_userId",query);
		return count;
	}
	
	
	/**
	 * 保存BusinessActivityVoteInformation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityVoteInformation entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessActivityVoteInformationDao.save",entity);
	}

	/**
	 * 修改BusinessActivityVoteInformation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityVoteInformation entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityVoteInformationDao.update",entity);
	}

	/**
	 * 删除BusinessActivityVoteInformation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessActivityVoteInformationDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
