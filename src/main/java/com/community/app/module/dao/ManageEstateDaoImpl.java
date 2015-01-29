package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;







import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;
import com.community.framework.exception.ServiceException;
import com.community.app.module.bean.ManageEstate;
import com.community.app.module.common.EstateBean;
import com.community.app.module.vo.ManageEstateQuery;

@Repository("ManageEstateDao")
@Transactional
public class ManageEstateDaoImpl implements ManageEstateDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个ManageEstate
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public ManageEstate findById(final Integer id) throws DaoException {
		ManageEstate manageEstate = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageEstateDao.findById",id);
		return manageEstate;
	}
	
	/**
	 * 根据id小区周边
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageEstateQuery> findByEstateAmbitus(ManageEstateQuery query) throws DaoException {
		List<ManageEstateQuery> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageEstateDao.findByEstateAmbitus",query);
		return list;
	}
	
	/**
	 * 根据小区id查询小区周边公交站
	 * @param id
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageEstateQuery> findByEstateBus(final Integer id) throws DaoException {
		List<ManageEstateQuery> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageEstateDao.findByEstateBus",id);
		return list;
	}
	
	/**
	 * 无条件查询所有ManageEstate
	 * @return
	 * @throws DaoException
	 */
	public List<ManageEstate> findAll() throws DaoException {
		List<ManageEstate> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageEstateDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有ManageEstate
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageEstate> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<ManageEstate> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageEstateDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageEstate (关联BUSINESS_USER_RESOURCE 查询)
	 * @return
	 * @throws DaoException
	 */	
	public List<EstateBean> findByCon(final Map<String, Object> paramMap) throws DaoException {
		List<EstateBean> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageEstateDao.findByCon", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有ManageEstate-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageEstate> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<ManageEstate> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageEstateDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageEstate
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageEstate> findByExample(final ManageEstateQuery query) throws DaoException {
		List<ManageEstate> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageEstateDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有ManageEstate-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<ManageEstate> findByExample(final ManageEstateQuery query, final Integer limit) throws DaoException {
		List<ManageEstate> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageEstateDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<ManageEstate> findAllPage(final ManageEstateQuery query) throws DaoException {
		List<ManageEstate> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageEstateDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final ManageEstateQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.ManageEstateDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存ManageEstate数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final ManageEstate entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.ManageEstateDao.save",entity);
	}

	/**
	 * 修改ManageEstate数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final ManageEstate entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.ManageEstateDao.update",entity);
	}

	/**
	 * 删除ManageEstate
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.ManageEstateDao.delete",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 根据名称模糊查询所有ManageEstate
	 * @return
	 * @throws ServiceException
	 */
	public List<ManageEstate> search(final ManageEstateQuery query) throws DaoException{
		List<ManageEstate> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.ManageEstateDao.search",query);
		return list;
	}
}
