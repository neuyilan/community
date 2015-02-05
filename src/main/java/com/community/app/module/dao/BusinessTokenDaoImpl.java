package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessToken;
import com.community.app.module.vo.BusinessTokenQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessTokenDao")
@Transactional
public class BusinessTokenDaoImpl implements BusinessTokenDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessToken
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessToken findById(final Integer id) throws DaoException {
		BusinessToken businessToken = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessTokenDao.findById",id);
		return businessToken;
	}
	
	/**
	 * 无条件查询所有BusinessToken
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessToken> findAll() throws DaoException {
		List<BusinessToken> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessTokenDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessToken
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessToken> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessToken> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessTokenDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessToken-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessToken> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessToken> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessTokenDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessToken
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessToken> findByExample(final BusinessTokenQuery query) throws DaoException {
		List<BusinessToken> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessTokenDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessToken-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessToken> findByExample(final BusinessTokenQuery query, final Integer limit) throws DaoException {
		List<BusinessToken> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessTokenDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessToken> findAllPage(final BusinessTokenQuery query) throws DaoException {
		List<BusinessToken> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessTokenDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessTokenQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessTokenDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessToken数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessToken entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessTokenDao.save",entity);
	}

	/**
	 * 修改BusinessToken数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessToken entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessTokenDao.update",entity);
	}

	/**
	 * 删除BusinessToken
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessTokenDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
