package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.ManageBuilding;
import com.community.app.module.vo.ManageBuildingQuery;
import com.community.framework.exception.DaoException;

@Repository("ManageBuildingDao")
@Transactional
public class ManageBuildingDaoImpl implements ManageBuildingDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个ManageBuilding
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageBuilding findById(final Integer id) throws DaoException {
		ManageBuilding manageBuilding = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageBuildingDao.findById",id);
		return manageBuilding;
	}
	
	/**
	 * 无条件查询所有ManageBuilding
	 * @return
	 * @throws DaoException
	 */
	public List<ManageBuilding> findAll() throws DaoException {
		List<ManageBuilding> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageBuildingDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageBuilding
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageBuilding> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<ManageBuilding> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageBuildingDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageBuilding-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageBuilding> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<ManageBuilding> list = this.sqlSessionTemplate.selectList("com.community.app.app.dao.ManageBuildingDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageBuilding
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageBuilding> findByExample(final ManageBuildingQuery query) throws DaoException {
		List<ManageBuilding> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageBuildingDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageBuilding-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageBuilding> findByExample(final ManageBuildingQuery query, final Integer limit) throws DaoException {
		List<ManageBuilding> list = this.sqlSessionTemplate.selectList("com.community.app.app.dao.ManageBuildingDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageBuilding> findAllPage(final ManageBuildingQuery query) throws DaoException {
		List<ManageBuilding> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageBuildingDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageBuildingQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageBuildingDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存ManageBuilding数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageBuilding entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.ManageBuildingDao.save",entity);
	}

	/**
	 * 修改ManageBuilding数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageBuilding entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.ManageBuildingDao.update",entity);
	}

	/**
	 * 删除ManageBuilding
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.ManageBuildingDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
