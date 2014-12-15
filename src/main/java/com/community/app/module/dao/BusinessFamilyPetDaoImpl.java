package com.community.app.module.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.community.framework.exception.DaoException;

import com.community.app.module.bean.BusinessFamilyPet;
import com.community.app.module.vo.BusinessFamilyPetQuery;

@Repository("BusinessFamilyPetDao")
@Transactional
public class BusinessFamilyPetDaoImpl implements BusinessFamilyPetDao {
	
	@Resource(name="SqlSessionTemplate") 
	SqlSessionTemplate sqlSessionTemplate;

	/**
	 * 查询单个BusinessFamilyPet
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public BusinessFamilyPet findById(final Integer id) throws DaoException {
		BusinessFamilyPet businessFamilyPet = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFamilyPetDao.findById",id);
		return businessFamilyPet;
	}
	
	/**
	 * 无条件查询所有BusinessFamilyPet
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFamilyPet> findAll() throws DaoException {
		List<BusinessFamilyPet> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyPetDao.findAll");
		return list;
	}

	/**
	 * 按Map对象条件查询所有BusinessFamilyPet
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamilyPet> findByMap(final Map<String, Object> paramMap) throws DaoException {
		List<BusinessFamilyPet> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyPetDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按Map对象条件查询所有BusinessFamilyPet-限制返回条数
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamilyPet> findByMap(final Map<String, Object> paramMap, final Integer limit) throws DaoException {
		List<BusinessFamilyPet> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyPetDao.findByMap", paramMap);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFamilyPet
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamilyPet> findByExample(final BusinessFamilyPetQuery query) throws DaoException {
		List<BusinessFamilyPet> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyPetDao.findByExample", query);
		return list;
	}
	
	/**
	 * 按VO对象条件查询所有BusinessFamilyPet-限制返回条数
	 * @param entity
	 * @return
	 * @throws DaoException
	 */	
	public List<BusinessFamilyPet> findByExample(final BusinessFamilyPetQuery query, final Integer limit) throws DaoException {
		List<BusinessFamilyPet> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyPetDao.findByExample", query);
		return list;
	}
	
	/**
	 * 根据搜索条件，搜索分页数据
	 * @param query
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public List<BusinessFamilyPet> findAllPage(final BusinessFamilyPetQuery query) throws DaoException {
		List<BusinessFamilyPet> list = this.sqlSessionTemplate.selectList("com.community.app.module.dao.BusinessFamilyPetDao.findAllPage",query);
		return list;
	}

	/**
	 * 根据搜索条件，搜索分页总数
	 * @param pageData
	 * @return
	 * @throws DaoException
	 */
	public int selectCount(final BusinessFamilyPetQuery query) throws DaoException {
		int count = this.sqlSessionTemplate.selectOne("com.community.app.module.dao.BusinessFamilyPetDao.selectCount",query);
		return count;
	}
	
	/**
	 * 保存BusinessFamilyPet数据
	 * @param entity
	 * @throws DaoException
	 */
	public void save(final BusinessFamilyPet entity) throws DaoException {
		this.sqlSessionTemplate.insert("com.community.app.module.dao.BusinessFamilyPetDao.save",entity);
	}

	/**
	 * 修改BusinessFamilyPet数据
	 * @param entity
	 * @throws DaoException
	 */
	public void update(final BusinessFamilyPet entity) throws DaoException {
		this.sqlSessionTemplate.update("com.community.app.module.dao.BusinessFamilyPetDao.update",entity);
	}

	/**
	 * 删除BusinessFamilyPet
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(final Integer id) throws DaoException {
		int count=this.sqlSessionTemplate.delete("com.community.app.module.dao.BusinessFamilyPetDao.deleteFamilyPet",id);
		if(count>0){
			return true;
		}else{
			return false;
		}
	}
	
}
