package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessStationFeedbackInformation;
import com.community.app.module.vo.BusinessStationFeedbackInformationQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessStationFeedbackInformationDao")
@Transactional
public class BusinessStationFeedbackInformationDaoImpl implements BusinessStationFeedbackInformationDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessStationFeedbackInformation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessStationFeedbackInformation findById(final Integer id) throws DaoException {
		BusinessStationFeedbackInformation businessStationFeedbackInformation = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessStationFeedbackInformationDao.findById",id);
		return businessStationFeedbackInformation;
	}
	
	/**
	 * 无条件查询所有BusinessStationFeedbackInformation
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStationFeedbackInformation> findAll() throws DaoException {
		List<BusinessStationFeedbackInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationFeedbackInformationDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessStationFeedbackInformation
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStationFeedbackInformation> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessStationFeedbackInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationFeedbackInformationDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessStationFeedbackInformation-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessStationFeedbackInformation> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessStationFeedbackInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationFeedbackInformationDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessStationFeedbackInformation
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessStationFeedbackInformation> findByExample(final BusinessStationFeedbackInformationQuery query) throws DaoException {
		List<BusinessStationFeedbackInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationFeedbackInformationDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessStationFeedbackInformation-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessStationFeedbackInformation> findByExample(final BusinessStationFeedbackInformationQuery query, final Integer limit) throws DaoException {
		List<BusinessStationFeedbackInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationFeedbackInformationDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessStationFeedbackInformation> findAllPage(final BusinessStationFeedbackInformationQuery query) throws DaoException {
		List<BusinessStationFeedbackInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessStationFeedbackInformationDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessStationFeedbackInformationQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessStationFeedbackInformationDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessStationFeedbackInformation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessStationFeedbackInformation entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessStationFeedbackInformationDao.save",entity);
	}

	/**
	 * 修改BusinessStationFeedbackInformation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessStationFeedbackInformation entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessStationFeedbackInformationDao.update",entity);
	}

	/**
	 * 删除BusinessStationFeedbackInformation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessStationFeedbackInformationDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
}