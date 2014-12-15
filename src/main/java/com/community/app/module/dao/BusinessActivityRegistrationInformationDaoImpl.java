package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessActivityRegistrationInformation;
import com.community.app.module.vo.BusinessActivityRegistrationInformationQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessActivityRegistrationInformationDao")
@Transactional
public class BusinessActivityRegistrationInformationDaoImpl implements BusinessActivityRegistrationInformationDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessActivityRegistrationInformation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityRegistrationInformation findById(final Integer id) throws DaoException {
		BusinessActivityRegistrationInformation businessActivityRegistrationInformation = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityRegistrationInformationDao.findById",id);
		return businessActivityRegistrationInformation;
	}
	
	/**
	 * 无条件查询所有BusinessActivityRegistrationInformation
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityRegistrationInformation> findAll() throws DaoException {
		List<BusinessActivityRegistrationInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityRegistrationInformationDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessActivityRegistrationInformation
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityRegistrationInformation> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessActivityRegistrationInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityRegistrationInformationDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityRegistrationInformation-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityRegistrationInformation> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessActivityRegistrationInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityRegistrationInformationDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityRegistrationInformation
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityRegistrationInformation> findByExample(final BusinessActivityRegistrationInformationQuery query) throws DaoException {
		List<BusinessActivityRegistrationInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityRegistrationInformationDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityRegistrationInformation-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityRegistrationInformation> findByExample(final BusinessActivityRegistrationInformationQuery query, final Integer limit) throws DaoException {
		List<BusinessActivityRegistrationInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityRegistrationInformationDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityRegistrationInformation> findAllPage(final BusinessActivityRegistrationInformationQuery query) throws DaoException {
		List<BusinessActivityRegistrationInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityRegistrationInformationDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityRegistrationInformationQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityRegistrationInformationDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessActivityRegistrationInformation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityRegistrationInformation entity) throws DaoException {
		int count = this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessActivityRegistrationInformationDao.save",entity);
		if(count>0){
			this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityDao.updateParticpates2",entity);
		}
	}

	/**
	 * 修改BusinessActivityRegistrationInformation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityRegistrationInformation entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityRegistrationInformationDao.update",entity);
	}

	/**
	 * 删除BusinessActivityRegistrationInformation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessActivityRegistrationInformationDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
