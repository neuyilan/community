package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.ManageUserFunction;
import com.community.app.module.vo.ManageUserFunctionQuery;
import com.community.framework.exception.DaoException;

@Repository("ManageUserFunctionDao")
@Transactional
public class ManageUserFunctionDaoImpl implements ManageUserFunctionDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个ManageUserFunction
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageUserFunction findById(final Integer id) throws DaoException {
		ManageUserFunction manageUserFunction = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageUserFunctionDao.findById",id);
		return manageUserFunction;
	}
	
	/**
	 * 无条件查询所有ManageUserFunction
	 * @return
	 * @throws DaoException
	 */
	public List<ManageUserFunction> findAll() throws DaoException {
		List<ManageUserFunction> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageUserFunctionDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageUserFunction
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageUserFunction> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<ManageUserFunction> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageUserFunctionDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageUserFunction-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageUserFunction> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<ManageUserFunction> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageUserFunctionDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageUserFunction
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageUserFunction> findByExample(final ManageUserFunctionQuery query) throws DaoException {
		List<ManageUserFunction> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageUserFunctionDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageUserFunction-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageUserFunction> findByExample(final ManageUserFunctionQuery query, final Integer limit) throws DaoException {
		List<ManageUserFunction> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageUserFunctionDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageUserFunction> findAllPage(final ManageUserFunctionQuery query) throws DaoException {
		List<ManageUserFunction> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageUserFunctionDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageUserFunctionQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageUserFunctionDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存ManageUserFunction数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageUserFunction entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.ManageUserFunctionDao.save",entity);
	}

	/**
	 * 修改ManageUserFunction数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageUserFunction entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.ManageUserFunctionDao.update",entity);
	}

	/**
	 * 删除ManageUserFunction
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.ManageUserFunctionDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 删除ManageUserFunction
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean deleteByUserId(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.ManageUserFunctionDao.deleteByUserId",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
