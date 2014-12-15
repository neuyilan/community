package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.ManageFunction;
import com.community.app.module.vo.ManageFunctionQuery;

@Repository("ManageFunctionDao")
@Transactional
public class ManageFunctionDaoImpl implements ManageFunctionDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个ManageFunction
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageFunction findById(final Integer id) throws DaoException {
		ManageFunction manageFunction = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageFunctionDao.findById",id);
		return manageFunction;
	}
	
	/**
	 * 无条件查询所有ManageFunction
	 * @return
	 * @throws DaoException
	 */
	public List<ManageFunction> findAll() throws DaoException {
		List<ManageFunction> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageFunctionDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageFunction
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageFunction> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<ManageFunction> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageFunctionDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageFunction-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageFunction> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<ManageFunction> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageFunctionDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageFunction
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageFunction> findByExample(final ManageFunctionQuery query) throws DaoException {
		List<ManageFunction> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageFunctionDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageFunction-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageFunction> findByExample(final ManageFunctionQuery query, final Integer limit) throws DaoException {
		List<ManageFunction> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageFunctionDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageFunction> findAllPage(final ManageFunctionQuery query) throws DaoException {
		List<ManageFunction> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageFunctionDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageFunctionQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageFunctionDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存ManageFunction数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageFunction entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.ManageFunctionDao.save",entity);
	}

	/**
	 * 修改ManageFunction数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageFunction entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.ManageFunctionDao.update",entity);
	}

	/**
	 * 删除ManageFunction
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.ManageFunctionDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
