package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessTel;
import com.community.app.module.vo.BusinessTelQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessTelDao")
@Transactional
public class BusinessTelDaoImpl implements BusinessTelDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessTel
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessTel findById(final Integer id) throws DaoException {
		BusinessTel businessTel = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessTelDao.findById",id);
		return businessTel;
	}
	
	/**
	 * 无条件查询所有BusinessTel
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessTel> findAll() throws DaoException {
		List<BusinessTel> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessTelDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessTel
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessTel> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessTel> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessTelDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessTel-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessTel> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessTel> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessTelDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessTel
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessTel> findByExample(final BusinessTelQuery query) throws DaoException {
		List<BusinessTel> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessTelDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessTel-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessTel> findByExample(final BusinessTelQuery query, final Integer limit) throws DaoException {
		List<BusinessTel> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessTelDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessTel> findAllPage(final BusinessTelQuery query) throws DaoException {
		List<BusinessTel> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessTelDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessTelQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessTelDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessTel数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessTel entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessTelDao.save",entity);
	}

	/**
	 * 修改BusinessTel数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessTel entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessTelDao.update",entity);
	}

	/**
	 * 删除BusinessTel
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessTelDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
