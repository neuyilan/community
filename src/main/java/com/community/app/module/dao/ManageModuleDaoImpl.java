package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.ManageModule;
import com.community.app.module.vo.ManageModuleQuery;
import com.community.framework.exception.DaoException;

@Repository("ManageModuleDao")
@Transactional
public class ManageModuleDaoImpl implements ManageModuleDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个ManageModule
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageModule findById(final Integer id) throws DaoException {
		ManageModule manageModule = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageModuleDao.findById",id);
		return manageModule;
	}
	
	/**
	 * 无条件查询所有ManageModule
	 * @return
	 * @throws DaoException
	 */
	public List<ManageModule> findAll() throws DaoException {
		List<ManageModule> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageModuleDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageModule
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageModule> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<ManageModule> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageModuleDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageModule-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageModule> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<ManageModule> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageModuleDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageModule
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageModule> findByExample(final ManageModuleQuery query) throws DaoException {
		List<ManageModule> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageModuleDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageModule-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageModule> findByExample(final ManageModuleQuery query, final Integer limit) throws DaoException {
		List<ManageModule> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageModuleDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageModule> findAllPage(final ManageModuleQuery query) throws DaoException {
		List<ManageModule> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageModuleDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageModuleQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageModuleDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存ManageModule数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageModule entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.ManageModuleDao.save",entity);
	}

	/**
	 * 修改ManageModule数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageModule entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.ManageModuleDao.update",entity);
	}

	/**
	 * 删除ManageModule
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.ManageModuleDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
