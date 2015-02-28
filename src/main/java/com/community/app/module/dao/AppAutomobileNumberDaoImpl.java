package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.AppAutomobileNumber;
import com.community.app.module.vo.AppAutomobileNumberQuery;
import com.community.framework.exception.DaoException;

@Repository("AppAutomobileNumberDao")
@Transactional
public class AppAutomobileNumberDaoImpl implements AppAutomobileNumberDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个AppAutomobileNumber
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public AppAutomobileNumber findById(final Integer id) throws DaoException {
		AppAutomobileNumber appAutomobileNumber = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppAutomobileNumberDao.findById",id);
		return appAutomobileNumber;
	}
	
	/**
	 * 无条件查询所有AppAutomobileNumber
	 * @return
	 * @throws DaoException
	 */
	public List<AppAutomobileNumber> findAll() throws DaoException {
		List<AppAutomobileNumber> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppAutomobileNumberDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有AppAutomobileNumber
	 * @return
	 * @throws DaoException
	 */	
	public List<AppAutomobileNumber> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<AppAutomobileNumber> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppAutomobileNumberDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有AppAutomobileNumber-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<AppAutomobileNumber> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<AppAutomobileNumber> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppAutomobileNumberDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有AppAutomobileNumber
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppAutomobileNumber> findByExample(final AppAutomobileNumberQuery query) throws DaoException {
		List<AppAutomobileNumber> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppAutomobileNumberDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppAutomobileNumber
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<AppAutomobileNumber> findByExample_app(final AppAutomobileNumberQuery query) throws DaoException {
		List<AppAutomobileNumber> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppAutomobileNumberDao.findByExample_app", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有AppAutomobileNumber-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<AppAutomobileNumber> findByExample(final AppAutomobileNumberQuery query, final Integer limit) throws DaoException {
		List<AppAutomobileNumber> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppAutomobileNumberDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<AppAutomobileNumber> findAllPage(final AppAutomobileNumberQuery query) throws DaoException {
		List<AppAutomobileNumber> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.AppAutomobileNumberDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final AppAutomobileNumberQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.AppAutomobileNumberDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存AppAutomobileNumber数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final AppAutomobileNumber entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.AppAutomobileNumberDao.save",entity);
	}

	/**
	 * 修改AppAutomobileNumber数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final AppAutomobileNumber entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.AppAutomobileNumberDao.update",entity);
	}

	/**
	 * 删除AppAutomobileNumber
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppAutomobileNumberDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 删除AppAutomobileNumber
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final AppAutomobileNumber entity) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.AppAutomobileNumberDao.deleteAppAutomobileNumber",entity);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
