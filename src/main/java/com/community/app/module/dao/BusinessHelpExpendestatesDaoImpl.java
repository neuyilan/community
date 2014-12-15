package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.BusinessHelpExpendestates;
import com.community.app.module.vo.BusinessHelpExpendestatesQuery;
import com.community.framework.exception.DaoException;

@Repository("BusinessHelpExpendestatesDao")
@Transactional
public class BusinessHelpExpendestatesDaoImpl implements BusinessHelpExpendestatesDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessHelpExpendestates
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessHelpExpendestates findById(final Integer id) throws DaoException {
		BusinessHelpExpendestates businessHelpExpendestates = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpExpendestatesDao.findById",id);
		return businessHelpExpendestates;
	}
	
	/**
	 * 无条件查询所有BusinessHelpExpendestates
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpExpendestates> findAll() throws DaoException {
		List<BusinessHelpExpendestates> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpExpendestatesDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessHelpExpendestates
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpExpendestates> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessHelpExpendestates> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpExpendestatesDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessHelpExpendestates-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessHelpExpendestates> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessHelpExpendestates> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpExpendestatesDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有BusinessHelpExpendestates
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessHelpExpendestates> findByExample(final BusinessHelpExpendestatesQuery query) throws DaoException {
		List<BusinessHelpExpendestates> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpExpendestatesDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessHelpExpendestates-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<BusinessHelpExpendestates> findByExample(final BusinessHelpExpendestatesQuery query, final Integer limit) throws DaoException {
		List<BusinessHelpExpendestates> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpExpendestatesDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessHelpExpendestates> findAllPage(final BusinessHelpExpendestatesQuery query) throws DaoException {
		List<BusinessHelpExpendestates> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessHelpExpendestatesDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessHelpExpendestatesQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessHelpExpendestatesDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessHelpExpendestates数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessHelpExpendestates entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessHelpExpendestatesDao.save",entity);
	}

	/**
	 * 修改BusinessHelpExpendestates数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessHelpExpendestates entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessHelpExpendestatesDao.update",entity);
	}

	/**
	 * 删除BusinessHelpExpendestates
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessHelpExpendestatesDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
}