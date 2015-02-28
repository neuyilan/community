package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.app.module.bean.ManageUnit;
import com.community.app.module.vo.ManageUnitQuery;
import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;

@Repository("ManageUnitDao")
@Transactional
public class ManageUnitDaoImpl implements ManageUnitDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个ManageUnit
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageUnit findById(final Integer id) throws DaoException {
		ManageUnit manageUnit = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageUnitDao.findById",id);
		return manageUnit;
	}
	
	/**
	 * 无条件查询所有ManageUnit
	 * @return
	 * @throws DaoException
	 */
	public List<ManageUnit> findAll() throws DaoException {
		List<ManageUnit> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageUnitDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageUnit
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageUnit> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<ManageUnit> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageUnitDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageUnit-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageUnit> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<ManageUnit> list = this.sqlSessionTemplate.selectList("com.community.app.app.dao.ManageUnitDao.findByMap", paramMap, limit);
		return list;
	}*/
	
	/**
	 * 按VO对象条件查询所有ManageUnit
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageUnit> findByExample(final ManageUnitQuery query) throws DaoException {
		List<ManageUnit> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageUnitDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageUnit-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	/*public List<ManageUnit> findByExample(final ManageUnitQuery query, final Integer limit) throws DaoException {
		List<ManageUnit> list = this.sqlSessionTemplate.selectList("com.community.app.app.dao.ManageUnitDao.findByExample", query, limit);
		return list;
	}*/
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageUnit> findAllPage(final ManageUnitQuery query) throws DaoException {
		List<ManageUnit> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageUnitDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageUnitQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageUnitDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存ManageUnit数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageUnit entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.ManageUnitDao.save",entity);
	}

	/**
	 * 修改ManageUnit数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageUnit entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.ManageUnitDao.update",entity);
	}

	/**
	 * 删除ManageUnit
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.ManageUnitDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 根据小区id查询小区下的全部单元
	 * @param entity
	 * @return
	 * @throws ServiceException
	 */	
	public List<ManageUnit> getUnitByEstateId(final Integer id) throws DaoException{
		List<ManageUnit> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageUnitDao.getUnitByEstateId",id);
		return list;
	}
	
}
