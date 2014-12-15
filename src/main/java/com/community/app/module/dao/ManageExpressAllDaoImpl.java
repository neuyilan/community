package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.ManageExpressAll;
import com.community.app.module.vo.ManageExpressAllQuery;
import com.community.framework.exception.DaoException;

@Repository("ManageExpressAllDao")
@Transactional
public class ManageExpressAllDaoImpl implements ManageExpressAllDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个ManageExpressAll
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageExpressAll findById(final Integer id) throws DaoException {
		ManageExpressAll manageExpressAll = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageExpressAllDao.findById",id);
		return manageExpressAll;
	}
	
	/**
	 * 无条件查询所有ManageExpressAll
	 * @return
	 * @throws DaoException
	 */
	public List<ManageExpressAll> findAll() throws DaoException {
		List<ManageExpressAll> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressAllDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageExpressAll
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageExpressAll> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<ManageExpressAll> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressAllDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageExpressAll-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageExpressAll> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<ManageExpressAll> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressAllDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageExpressAll
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageExpressAll> findByExample(final ManageExpressAllQuery query) throws DaoException {
		List<ManageExpressAll> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressAllDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageExpressAll-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageExpressAll> findByExample(final ManageExpressAllQuery query, final Integer limit) throws DaoException {
		List<ManageExpressAll> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressAllDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageExpressAll> findAllPage(final ManageExpressAllQuery query) throws DaoException {
		List<ManageExpressAll> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageExpressAllDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageExpressAllQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageExpressAllDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存ManageExpressAll数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageExpressAll entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.ManageExpressAllDao.save",entity);
	}

	/**
	 * 修改ManageExpressAll数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageExpressAll entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.ManageExpressAllDao.update",entity);
	}

	/**
	 * 删除ManageExpressAll
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.ManageExpressAllDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
}