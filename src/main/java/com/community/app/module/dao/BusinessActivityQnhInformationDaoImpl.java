package com.community.app.module.dao;



import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessActivityQnhInformation;
import com.community.app.module.vo.BusinessActivityQnhInformationQuery;

@Repository("BusinessActivityQnhInformationDao")
@Transactional
public class BusinessActivityQnhInformationDaoImpl implements BusinessActivityQnhInformationDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessActivityQnhInformation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessActivityQnhInformation findById(final Integer id) throws DaoException {
		BusinessActivityQnhInformation businessActivityQnhInformation = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityQnhInformationDao.findById",id);
		return businessActivityQnhInformation;
	}
	
	/**
	 * 无条件查询所有BusinessActivityQnhInformation
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityQnhInformation> findAll() throws DaoException {
		List<BusinessActivityQnhInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityQnhInformationDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessActivityQnhInformation
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityQnhInformation> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessActivityQnhInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityQnhInformationDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessActivityQnhInformation-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityQnhInformation> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessActivityQnhInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityQnhInformationDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessActivityQnhInformation
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessActivityQnhInformation> findByExample(final BusinessActivityQnhInformationQuery query) throws DaoException {
		List<BusinessActivityQnhInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityQnhInformationDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessActivityQnhInformation-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessActivityQnhInformation> findByExample(final BusinessActivityQnhInformationQuery query, final Integer limit) throws DaoException {
		List<BusinessActivityQnhInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityQnhInformationDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessActivityQnhInformation> findAllPage(final BusinessActivityQnhInformationQuery query) throws DaoException {
		List<BusinessActivityQnhInformation> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessActivityQnhInformationDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessActivityQnhInformationQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessActivityQnhInformationDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessActivityQnhInformation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessActivityQnhInformation entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessActivityQnhInformationDao.save",entity);
	}

	/**
	 * 修改BusinessActivityQnhInformation数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessActivityQnhInformation entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessActivityQnhInformationDao.update",entity);
	}

	/**
	 * 删除BusinessActivityQnhInformation
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessActivityQnhInformationDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
